package com.tencent.mobileqq.tritonaudio;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import com.tencent.mobileqq.tritonaudio.internal.ApiUtil;
import com.tencent.mobileqq.tritonaudio.webaudio.NativeBuffer;
import com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/tritonaudio/WebAudioPlugin;", "Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "()V", "context", "Landroid/content/Context;", "hasSoLoaded", "", "isActivityPaused", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "sId", "Ljava/util/concurrent/atomic/AtomicInteger;", "supportedEvents", "", "", "getSupportedEvents", "()Ljava/util/Set;", "webAudioManager", "Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;", "closeWebAudioContext", "", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "connectWebAudioNode", "copyFormChannel", "copyToChannel", "createBuffer", "createGainNode", "createWebAudioBufferSource", "createWebAudioContext", "createWebAudioScriptProcessor", "decodeWebAudioData", "getBufferChannelData", "getCurrentGain", "getWebAudioCurrentTime", "getWebAudioDestination", "getWebAudioSampleRate", "onCall", "eventName", "onCreate", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onDestroy", "onStart", "onStop", "oprateWebAudioContext", "resumeWebAudioContext", "setBufferSourceLoop", "setCurrentGain", "setQueueBuffer", "setSourceBuffer", "setWebAudioSoPath", "soPath", "sourceStart", "sourceStop", "support", "suspendWebAudioContext", "Companion", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class WebAudioPlugin
  implements ComposableScriptPlugin
{
  @NotNull
  public static final String API_CLOSE_WEB_AUDIO_CONTEXT = "closeWebAudioContext";
  @NotNull
  public static final String API_COPY_FROM_CHANNEL = "audioBufferCopyFromChannel";
  @NotNull
  public static final String API_COPY_TO_CHANNEL = "audioBufferCopyToChannel";
  @NotNull
  public static final String API_CREATE_AUDIO_CONTEXT = "createWebAudioContext";
  @NotNull
  public static final String API_CREATE_BUFFER = "createWebAudioContextBuffer";
  @NotNull
  public static final String API_CREATE_BUFFER_SOURCE = "createWebAudioBufferSource";
  @NotNull
  public static final String API_CREATE_GAIN = "createWebAudioGain";
  @NotNull
  public static final String API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR = "createWebAudioScriptProcessor";
  @NotNull
  public static final String API_DECODE_AUDIO_DATA = "decodeWebAudioData";
  @NotNull
  public static final String API_GET_BUFFTER_CHANNEL_DATA = "getWebAudioBufferChannelData";
  @NotNull
  public static final String API_GET_CURRENT_GAIN = "getWebAudioCurrentGain";
  @NotNull
  public static final String API_GET_WEBAUDIO_SAMPLE_RATE = "getWebAudioSampleRate";
  @NotNull
  public static final String API_GET_WEB_AUDIO_CURRENT_TIME = "getWebAudioCurrentTime";
  @NotNull
  public static final String API_GET_WEB_AUDIO_DESTINATION = "getWebAudioDestination";
  @NotNull
  public static final String API_ON_DECODE_AUDIO_DATA_DONE = "onDecodeWebAudioDataDone";
  @NotNull
  public static final String API_ON_SOURCE_ENDED = "onWebAudioSourceEnded";
  @NotNull
  public static final String API_ON_WEB_AUDIO_SCRIPT_PROCESSOR = "onWebAudioScriptProcessorAudioProcess";
  @NotNull
  public static final String API_OPERATE_WEB_AUDIO_CONTEXT = "operateWebAudioContext";
  @NotNull
  public static final String API_SET_BUFFER_SOURCE_LOOP = "setWebAudioBufferSourceLoop";
  @NotNull
  public static final String API_SET_CURRENT_GAIN = "setWebAudioCurrentGain";
  @NotNull
  public static final String API_SET_QUEUE_BUFFER = "audioProcessingEventSetQueueBuffer";
  @NotNull
  public static final String API_SET_SOURCE_BUFFER = "setWebAudioSourceBuffer";
  @NotNull
  public static final String API_SOURCE_START = "sourceStart";
  @NotNull
  public static final String API_SOURCE_STOP = "sourceStop";
  @NotNull
  public static final String API_WEB_AUDIO_CONNECT_AUDIO_NODE = "webAudioConnectAudioNode";
  @NotNull
  public static final String AUDIO_ID = "audioId";
  public static final WebAudioPlugin.Companion Companion = new WebAudioPlugin.Companion(null);
  private static final String TAG = "[audio]WebAudioPlugin";
  private static final Set<String> supportedEvents = SetsKt.setOf(new String[] { "createWebAudioContext", "decodeWebAudioData", "closeWebAudioContext", "getWebAudioSampleRate", "getWebAudioDestination", "getWebAudioCurrentTime", "operateWebAudioContext", "createWebAudioContextBuffer", "getWebAudioBufferChannelData", "audioBufferCopyFromChannel", "audioBufferCopyToChannel", "createWebAudioBufferSource", "setWebAudioSourceBuffer", "sourceStart", "sourceStop", "setWebAudioBufferSourceLoop", "webAudioConnectAudioNode", "createWebAudioGain", "getWebAudioCurrentGain", "setWebAudioCurrentGain", "createWebAudioScriptProcessor", "audioProcessingEventSetQueueBuffer" });
  private Context context;
  private boolean hasSoLoaded;
  private boolean isActivityPaused;
  private LogDelegate logger;
  private final AtomicInteger sId = new AtomicInteger();
  private WebAudioManager webAudioManager;
  
  private final String closeWebAudioContext(Argument paramArgument)
  {
    int i = paramArgument.getParams().getInt("audioId");
    paramArgument = this.webAudioManager;
    if (paramArgument != null) {
      paramArgument.closeAudioContext(i);
    }
    paramArgument = ApiUtil.wrapCallbackOk("closeWebAudioContext", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…CONTEXT, null).toString()");
    return paramArgument;
  }
  
  private final void closeWebAudioContext()
  {
    if (!this.hasSoLoaded)
    {
      localObject = this.logger;
      if (localObject != null) {
        ((LogDelegate)localObject).printLog(LogDelegate.Level.INFO, "[audio]WebAudioPlugin", "closeWebAudioContext fail so has not loaded", null);
      }
      return;
    }
    Object localObject = this.webAudioManager;
    if (localObject != null) {
      ((WebAudioManager)localObject).closeAudioContext();
    }
  }
  
  private final String connectWebAudioNode(Argument paramArgument)
  {
    int i = paramArgument.getParams().optInt("oriAudioNodeType", -1);
    paramArgument.getParams().optInt("channelId", -2);
    paramArgument.getParams().optInt("audioNodeType");
    int j = paramArgument.getParams().getInt("audioId");
    if (i == WebAudioManager.SCRIPT_PROCESSOR_AUDIO_NODE_TYPE)
    {
      WebAudioManager localWebAudioManager = this.webAudioManager;
      if (localWebAudioManager != null) {
        localWebAudioManager.startAudioProcess(paramArgument, j);
      }
    }
    paramArgument = ApiUtil.wrapCallbackOk("webAudioConnectAudioNode", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…IO_NODE, null).toString()");
    return paramArgument;
  }
  
  private final String copyFormChannel(Argument paramArgument)
  {
    paramArgument = ApiUtil.wrapCallbackOk("audioBufferCopyFromChannel", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…CHANNEL, null).toString()");
    return paramArgument;
  }
  
  private final String copyToChannel(Argument paramArgument)
  {
    int j = paramArgument.getParams().getInt("bufferId");
    Object localObject = paramArgument.getParams();
    int i = -1;
    int k = ((JSONObject)localObject).optInt("sourceId", -1);
    int m = paramArgument.getParams().getInt("channelId");
    int n = paramArgument.getParams().optInt("startInChannel", 0);
    paramArgument = NativeBuffer.unpackNativeBuffer(paramArgument, paramArgument.getParams(), "data");
    if (paramArgument != null)
    {
      paramArgument = paramArgument.buf;
      if ((paramArgument != null) && (paramArgument.length != 0))
      {
        localObject = this.webAudioManager;
        if (localObject != null) {
          i = ((WebAudioManager)localObject).copyToChannel(paramArgument, j, k, m, n);
        }
        paramArgument = new JSONObject();
        paramArgument.put("bufferId", i);
        paramArgument = ApiUtil.wrapCallbackOk("audioBufferCopyToChannel", paramArgument).toString();
        Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…_CHANNEL, res).toString()");
        return paramArgument;
      }
    }
    paramArgument = ApiUtil.wrapCallbackFail("audioBufferCopyToChannel", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackFail…CHANNEL, null).toString()");
    return paramArgument;
  }
  
  private final String createBuffer(Argument paramArgument)
  {
    int i = paramArgument.getParams().optInt("numOfChannels", 1);
    int j = paramArgument.getParams().optInt("length");
    int k = paramArgument.getParams().optInt("sampleRate");
    int m = paramArgument.getParams().getInt("audioId");
    paramArgument = this.webAudioManager;
    if (paramArgument != null) {
      paramArgument = paramArgument.createBuffer(m, i, j, k);
    } else {
      paramArgument = null;
    }
    paramArgument = ApiUtil.wrapCallbackOk("createWebAudioContextBuffer", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…, sampleRate)).toString()");
    return paramArgument;
  }
  
  private final String createGainNode(Argument paramArgument)
  {
    paramArgument = new JSONObject();
    paramArgument.put("audioNodeType", 5);
    paramArgument.put("channelId", -1);
    paramArgument = ApiUtil.wrapCallbackOk("createWebAudioGain", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…ATE_GAIN, res).toString()");
    return paramArgument;
  }
  
  private final String createWebAudioBufferSource(Argument paramArgument)
  {
    int i = paramArgument.getParams().getInt("audioId");
    paramArgument = this.webAudioManager;
    if (paramArgument != null) {
      paramArgument = paramArgument.createBufferSource(i);
    } else {
      paramArgument = null;
    }
    paramArgument = ApiUtil.wrapCallbackOk("createWebAudioBufferSource", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…urce(audioId)).toString()");
    return paramArgument;
  }
  
  private final String createWebAudioContext(Argument paramArgument)
  {
    paramArgument = this.webAudioManager;
    if (paramArgument != null) {
      paramArgument = paramArgument.createAudioContext();
    } else {
      paramArgument = null;
    }
    paramArgument = ApiUtil.wrapCallbackOk("createWebAudioContext", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…udioContext()).toString()");
    return paramArgument;
  }
  
  private final String createWebAudioScriptProcessor(Argument paramArgument)
  {
    int i = paramArgument.getParams().optInt("bufferSize");
    int j = paramArgument.getParams().optInt("inputChannelNum");
    int k = paramArgument.getParams().optInt("outputChannelNum");
    int m = paramArgument.getParams().getInt("audioId");
    paramArgument = this.webAudioManager;
    if (paramArgument != null) {
      paramArgument.createScriptProcessor(m, i, j, k);
    }
    paramArgument = ApiUtil.wrapCallbackOk("createWebAudioScriptProcessor", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…OCESSOR, null).toString()");
    return paramArgument;
  }
  
  private final String decodeWebAudioData(Argument paramArgument)
  {
    int i = this.sId.incrementAndGet();
    Object localObject = NativeBuffer.unpackNativeBuffer(paramArgument, paramArgument.getParams(), "data");
    if (localObject != null)
    {
      localObject = ((NativeBuffer)localObject).buf;
      if (Build.VERSION.SDK_INT >= 16)
      {
        WebAudioManager localWebAudioManager = this.webAudioManager;
        if (localWebAudioManager != null) {
          localWebAudioManager.decodeAudioDataAndReturnBufferIdAsync(i, (byte[])localObject, paramArgument);
        }
      }
    }
    paramArgument = new JSONObject();
    paramArgument.put("decodeId", i);
    paramArgument = ApiUtil.wrapCallbackOk("decodeWebAudioData", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…DIO_DATA, res).toString()");
    return paramArgument;
  }
  
  private final String getBufferChannelData(Argument paramArgument)
  {
    int i = paramArgument.getParams().getInt("bufferId");
    int j = paramArgument.getParams().getInt("channelId");
    Object localObject = this.webAudioManager;
    if (localObject != null)
    {
      localObject = ((WebAudioManager)localObject).getBufferChannelData(i, j);
      if (localObject != null) {}
    }
    else
    {
      localObject = new byte[0];
    }
    JSONObject localJSONObject = new JSONObject();
    NativeBuffer.packNativeBuffer(paramArgument, (byte[])localObject, NativeBuffer.TYPE_BUFFER_NATIVE, "data", localJSONObject);
    paramArgument = ApiUtil.wrapCallbackOk("getWebAudioBufferChannelData", localJSONObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…_DATA, resObj).toString()");
    return paramArgument;
  }
  
  private final String getCurrentGain(Argument paramArgument)
  {
    int i = paramArgument.getParams().getInt("channelId");
    int j = paramArgument.getParams().getInt("audioId");
    paramArgument = this.webAudioManager;
    float f;
    if (paramArgument != null) {
      f = paramArgument.getCurrentGain(j, i);
    } else {
      f = 1.0F;
    }
    return String.valueOf(f);
  }
  
  private final String getWebAudioCurrentTime(Argument paramArgument)
  {
    int i = paramArgument.getParams().getInt("audioId");
    paramArgument = this.webAudioManager;
    double d;
    if (paramArgument != null) {
      d = paramArgument.getAudioContextCurrentTime(i);
    } else {
      d = -1.0D;
    }
    return String.valueOf(d);
  }
  
  private final String getWebAudioDestination(Argument paramArgument)
  {
    paramArgument = new JSONObject();
    paramArgument.put("audioNodeType", 4);
    paramArgument = ApiUtil.wrapCallbackOk("getWebAudioDestination", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…TINATION, res).toString()");
    return paramArgument;
  }
  
  private final String getWebAudioSampleRate(Argument paramArgument)
  {
    paramArgument = ApiUtil.wrapCallbackOk("getWebAudioSampleRate", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…LE_RATE, null).toString()");
    return paramArgument;
  }
  
  private final String oprateWebAudioContext(Argument paramArgument)
  {
    paramArgument = paramArgument.getParams().getString("operationType");
    if (Intrinsics.areEqual(paramArgument, "suspend"))
    {
      paramArgument = this.webAudioManager;
      if (paramArgument != null) {
        paramArgument.suspendAudioContext();
      }
    }
    else if (Intrinsics.areEqual(paramArgument, "resume"))
    {
      paramArgument = this.webAudioManager;
      if (paramArgument != null) {
        paramArgument.resumeAudioContext();
      }
    }
    paramArgument = ApiUtil.wrapCallbackOk("operateWebAudioContext", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…CONTEXT, null).toString()");
    return paramArgument;
  }
  
  private final void resumeWebAudioContext()
  {
    if (!this.hasSoLoaded)
    {
      localObject = this.logger;
      if (localObject != null) {
        ((LogDelegate)localObject).printLog(LogDelegate.Level.INFO, "[audio]WebAudioPlugin", "resumeWebAudioContext fail so has not loaded", null);
      }
      return;
    }
    Object localObject = this.webAudioManager;
    if (localObject != null) {
      ((WebAudioManager)localObject).resumeAudioContext();
    }
  }
  
  private final String setBufferSourceLoop(Argument paramArgument)
  {
    boolean bool = paramArgument.getParams().getBoolean("loop");
    int i = paramArgument.getParams().getInt("channelId");
    int j = paramArgument.getParams().getInt("audioId");
    if (bool)
    {
      paramArgument = this.webAudioManager;
      if (paramArgument != null) {
        paramArgument.setBufferSourceLoop(j, i, bool);
      }
    }
    paramArgument = ApiUtil.wrapCallbackOk("setWebAudioBufferSourceLoop", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…CE_LOOP, null).toString()");
    return paramArgument;
  }
  
  private final String setCurrentGain(Argument paramArgument)
  {
    int i = paramArgument.getParams().getInt("channelId");
    double d = paramArgument.getParams().getDouble("data");
    int j = paramArgument.getParams().getInt("audioId");
    paramArgument = this.webAudioManager;
    if (paramArgument != null) {
      paramArgument.setCurrentGain(j, i, d);
    }
    paramArgument = ApiUtil.wrapCallbackOk("setWebAudioCurrentGain", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…NT_GAIN, null).toString()");
    return paramArgument;
  }
  
  private final String setQueueBuffer(Argument paramArgument)
  {
    int i = paramArgument.getParams().optInt("channelId", -2);
    int j = paramArgument.getParams().optInt("bufferId");
    paramArgument = this.webAudioManager;
    if (paramArgument != null) {
      paramArgument.setQueueBuffer(i, j);
    }
    paramArgument = ApiUtil.wrapCallbackOk("audioProcessingEventSetQueueBuffer", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…_BUFFER, null).toString()");
    return paramArgument;
  }
  
  private final String setSourceBuffer(Argument paramArgument)
  {
    int i = paramArgument.getParams().getInt("channelId");
    int j = paramArgument.getParams().optInt("bufferId", -1);
    int k = paramArgument.getParams().optInt("decodeId", -1);
    WebAudioManager localWebAudioManager1 = null;
    paramArgument = null;
    if (j != -1)
    {
      localWebAudioManager1 = this.webAudioManager;
      if (localWebAudioManager1 != null) {
        paramArgument = localWebAudioManager1.setSourceBuffer(i, j);
      }
      paramArgument = ApiUtil.wrapCallbackOk("setWebAudioSourceBuffer", paramArgument).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…Id, bufferId)).toString()");
      return paramArgument;
    }
    if (k != -1)
    {
      WebAudioManager localWebAudioManager2 = this.webAudioManager;
      paramArgument = localWebAudioManager1;
      if (localWebAudioManager2 != null) {
        paramArgument = localWebAudioManager2.setDecodingQueueBuffer(i, k);
      }
      paramArgument = ApiUtil.wrapCallbackOk("setWebAudioSourceBuffer", paramArgument).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…Id, decodeId)).toString()");
      return paramArgument;
    }
    paramArgument = ApiUtil.wrapCallbackFail("setWebAudioSourceBuffer", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackFail…_BUFFER, null).toString()");
    return paramArgument;
  }
  
  private final String sourceStart(Argument paramArgument)
  {
    int i = paramArgument.getParams().getInt("audioId");
    int j = paramArgument.getParams().getInt("channelId");
    int k = paramArgument.getParams().optInt("when", 0);
    int m = paramArgument.getParams().optInt("offset", 0);
    int n = paramArgument.getParams().optInt("duration", -1);
    WebAudioManager localWebAudioManager = this.webAudioManager;
    if (localWebAudioManager != null) {
      paramArgument = localWebAudioManager.sourceStart(paramArgument, i, j, k, m, n);
    } else {
      paramArgument = null;
    }
    paramArgument = ApiUtil.wrapCallbackOk("sourceStart", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…et, duration)).toString()");
    return paramArgument;
  }
  
  private final String sourceStop(Argument paramArgument)
  {
    int i = paramArgument.getParams().getInt("audioId");
    int j = paramArgument.getParams().getInt("channelId");
    int k = paramArgument.getParams().optInt("when", 0);
    paramArgument = this.webAudioManager;
    if (paramArgument != null) {
      paramArgument = paramArgument.sourceStop(i, j, k);
    } else {
      paramArgument = null;
    }
    paramArgument = ApiUtil.wrapCallbackOk("sourceStop", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…ceId, `when`)).toString()");
    return paramArgument;
  }
  
  private final void suspendWebAudioContext()
  {
    if (!this.hasSoLoaded)
    {
      localObject = this.logger;
      if (localObject != null) {
        ((LogDelegate)localObject).printLog(LogDelegate.Level.INFO, "[audio]WebAudioPlugin", "suspendWebAudioContext fail so has not loaded", null);
      }
      return;
    }
    Object localObject = this.webAudioManager;
    if (localObject != null) {
      ((WebAudioManager)localObject).suspendAudioContext();
    }
  }
  
  @NotNull
  public Set<String> getSupportedEvents()
  {
    return supportedEvents;
  }
  
  @Nullable
  public String onCall(@NotNull String paramString, @NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramArgument, "arguments");
    Object localObject = this.logger;
    if (localObject != null)
    {
      LogDelegate.Level localLevel = LogDelegate.Level.INFO;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall eventName=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" hasSoLoaded=");
      localStringBuilder.append(this.hasSoLoaded);
      LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject, localLevel, "[audio]WebAudioPlugin", localStringBuilder.toString(), null, 8, null);
    }
    boolean bool = this.hasSoLoaded;
    localObject = null;
    if (!bool) {
      return null;
    }
    switch (paramString.hashCode())
    {
    default: 
      return null;
    case 1943975281: 
      if (paramString.equals("createWebAudioContextBuffer")) {
        return createBuffer(paramArgument);
      }
      break;
    case 1902976409: 
      if (paramString.equals("createWebAudioBufferSource")) {
        return createWebAudioBufferSource(paramArgument);
      }
      break;
    case 1451060777: 
      if (paramString.equals("createWebAudioScriptProcessor")) {
        return createWebAudioScriptProcessor(paramArgument);
      }
      break;
    case 1360624096: 
      if (paramString.equals("audioProcessingEventSetQueueBuffer")) {
        return setQueueBuffer(paramArgument);
      }
      break;
    case 1135871536: 
      if (paramString.equals("webAudioConnectAudioNode")) {
        return connectWebAudioNode(paramArgument);
      }
      break;
    case 799668671: 
      if (paramString.equals("setWebAudioSourceBuffer")) {
        return setSourceBuffer(paramArgument);
      }
      break;
    case 719352470: 
      if (paramString.equals("getWebAudioDestination")) {
        return getWebAudioDestination(paramArgument);
      }
      break;
    case 294903293: 
      if (paramString.equals("audioBufferCopyToChannel")) {
        return copyToChannel(paramArgument);
      }
      break;
    case 212415010: 
      if (paramString.equals("getWebAudioSampleRate")) {
        return getWebAudioSampleRate(paramArgument);
      }
      break;
    case 141268433: 
      if (paramString.equals("createWebAudioContext")) {
        return createWebAudioContext(paramArgument);
      }
      break;
    case -95730425: 
      if (paramString.equals("sourceStart")) {
        return sourceStart(paramArgument);
      }
      break;
    case -106116946: 
      if (paramString.equals("audioBufferCopyFromChannel")) {
        return copyFormChannel(paramArgument);
      }
      break;
    case -231799148: 
      if (paramString.equals("setWebAudioCurrentGain")) {
        return setCurrentGain(paramArgument);
      }
      break;
    case -817189219: 
      if (paramString.equals("createWebAudioGain")) {
        return createGainNode(paramArgument);
      }
      break;
    case -1111466307: 
      if (paramString.equals("sourceStop")) {
        return sourceStop(paramArgument);
      }
      break;
    case -1131299979: 
      if (paramString.equals("getWebAudioBufferChannelData")) {
        return getBufferChannelData(paramArgument);
      }
      break;
    case -1365570487: 
      if (paramString.equals("operateWebAudioContext")) {
        return oprateWebAudioContext(paramArgument);
      }
      break;
    case -1513995947: 
      if (paramString.equals("closeWebAudioContext")) {
        return closeWebAudioContext(paramArgument);
      }
      break;
    case -1544532370: 
      if (paramString.equals("getWebAudioCurrentTime")) {
        return getWebAudioCurrentTime(paramArgument);
      }
      break;
    case -1544927456: 
      if (paramString.equals("getWebAudioCurrentGain")) {
        return getCurrentGain(paramArgument);
      }
      break;
    case -1809797821: 
      if (paramString.equals("setWebAudioBufferSourceLoop")) {
        return setBufferSourceLoop(paramArgument);
      }
      break;
    case -2076546886: 
      if (paramString.equals("decodeWebAudioData")) {
        localObject = decodeWebAudioData(paramArgument);
      }
      break;
    }
    return localObject;
  }
  
  public void onCreate(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    this.context = paramTritonEngine.getData().getContext();
    this.logger = paramTritonEngine.getData().getLogDelegate();
    this.webAudioManager = new WebAudioManager(this.logger);
  }
  
  public void onDestroy()
  {
    closeWebAudioContext();
  }
  
  public void onFirstFrame()
  {
    ComposableScriptPlugin.DefaultImpls.onFirstFrame(this);
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ComposableScriptPlugin.DefaultImpls.onGameLaunched(this, paramTritonEngine);
  }
  
  public void onStart()
  {
    this.isActivityPaused = false;
    resumeWebAudioContext();
  }
  
  public void onStop()
  {
    this.isActivityPaused = true;
    suspendWebAudioContext();
  }
  
  public final void setWebAudioSoPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "soPath");
    Object localObject = this.webAudioManager;
    boolean bool;
    if (localObject != null) {
      bool = ((WebAudioManager)localObject).loadWebAudioSo(paramString);
    } else {
      bool = false;
    }
    this.hasSoLoaded = bool;
    paramString = this.logger;
    if (paramString != null)
    {
      localObject = LogDelegate.Level.INFO;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWebAudioSoPath hasSoLoaded=");
      localStringBuilder.append(this.hasSoLoaded);
      LogDelegate.DefaultImpls.printLog$default(paramString, (LogDelegate.Level)localObject, "[audio]WebAudioPlugin", localStringBuilder.toString(), null, 8, null);
    }
  }
  
  public final boolean support(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    return getSupportedEvents().contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.WebAudioPlugin
 * JD-Core Version:    0.7.0.1
 */