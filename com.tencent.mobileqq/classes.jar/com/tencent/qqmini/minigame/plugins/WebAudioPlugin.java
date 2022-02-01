package com.tencent.qqmini.minigame.plugins;

import android.os.Build.VERSION;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.minigame.webaudio.WebAudioManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class WebAudioPlugin
  extends BaseJsPlugin
{
  public static final String API_CLOSE_WEB_AUDIO_CONTEXT = "closeWebAudioContext";
  public static final String API_COPY_FROM_CHANNEL = "audioBufferCopyFromChannel";
  public static final String API_COPY_TO_CHANNEL = "audioBufferCopyToChannel";
  public static final String API_CREATE_AUDIO_CONTEXT = "createWebAudioContext";
  public static final String API_CREATE_BUFFER = "createWebAudioContextBuffer";
  public static final String API_CREATE_BUFFER_SOURCE = "createWebAudioBufferSource";
  public static final String API_CREATE_GAIN = "createWebAudioGain";
  public static final String API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR = "createWebAudioScriptProcessor";
  public static final String API_DECODE_AUDIO_DATA = "decodeWebAudioData";
  public static final String API_GET_BUFFTER_CHANNEL_DATA = "getWebAudioBufferChannelData";
  public static final String API_GET_CURRENT_GAIN = "getWebAudioCurrentGain";
  public static final String API_GET_WEBAUDIO_SAMPLE_RATE = "getWebAudioSampleRate";
  public static final String API_GET_WEB_AUDIO_CURRENT_TIME = "getWebAudioCurrentTime";
  public static final String API_GET_WEB_AUDIO_DESTINATION = "getWebAudioDestination";
  public static final String API_ON_DECODE_AUDIO_DATA_DONE = "onDecodeWebAudioDataDone";
  public static final String API_ON_SOURCE_ENDED = "onWebAudioSourceEnded";
  public static final String API_ON_WEB_AUDIO_SCRIPT_PROCESSOR = "onWebAudioScriptProcessorAudioProcess";
  public static final String API_OPERATE_WEB_AUDIO_CONTEXT = "operateWebAudioContext";
  public static final String API_SET_BUFFER_SOURCE_LOOP = "setWebAudioBufferSourceLoop";
  public static final String API_SET_CURRENT_GAIN = "setWebAudioCurrentGain";
  public static final String API_SET_QUEUE_BUFFER = "audioProcessingEventSetQueueBuffer";
  public static final String API_SET_SOURCE_BUFFER = "setWebAudioSourceBuffer";
  public static final String API_SOURCE_START = "sourceStart";
  public static final String API_SOURCE_STOP = "sourceStop";
  public static final String API_WEB_AUDIO_CONNECT_AUDIO_NODE = "webAudioConnectAudioNode";
  private static final String TAG = "WebAudioPlugin";
  private ITTEngine mTTEngine;
  private WebAudioManager mWebAudioManager;
  private AtomicInteger sId = new AtomicInteger();
  
  @JsEvent({"audioBufferCopyFromChannel"})
  public String audioBufferCopyFromChannel(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    return "{}";
  }
  
  @JsEvent({"audioBufferCopyToChannel"})
  public String audioBufferCopyToChannel(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).optInt("sourceId", -1);
      int k = ((JSONObject)localObject).getInt("channelId");
      int m = ((JSONObject)localObject).optInt("startInChannel", 0);
      localObject = NativeBuffer.unpackNativeBuffer(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((NativeBuffer)localObject).buf;
        if ((localObject != null) && (localObject.length != 0))
        {
          GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL data.length " + localObject.length);
          i = WebAudioManager.getInstance().copyToChannel((byte[])localObject, i, j, k, m);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("bufferId", i);
          GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL newBufferId: " + i);
          paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject).toString();
          return paramRequestEvent;
        }
      }
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "{}";
  }
  
  @JsEvent({"audioProcessingEventSetQueueBuffer"})
  public String audioProcessingEventSetQueueBuffer(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
      int i = paramRequestEvent.optInt("channelId", -2);
      int j = paramRequestEvent.optInt("bufferId");
      WebAudioManager.getInstance().setQueueBuffer(i, j);
      return "{}";
    }
    catch (JSONException paramRequestEvent)
    {
      for (;;)
      {
        paramRequestEvent.printStackTrace();
      }
    }
  }
  
  @JsEvent({"closeWebAudioContext"})
  public String closeWebAudioContext(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      int i = new JSONObject(paramRequestEvent.jsonParams).getInt("audioId");
      WebAudioManager.getInstance().closeAudioContext(i);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_CLOSE_WEB_AUDIO_CONTEXT error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"createWebAudioBufferSource"})
  public String createWebAudioBufferSource(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      int i = new JSONObject(paramRequestEvent.jsonParams).getInt("audioId");
      JSONObject localJSONObject = WebAudioManager.getInstance().createBufferSource(i);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"createWebAudioContext"})
  public String createWebAudioContext(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    JSONObject localJSONObject = WebAudioManager.getInstance().createAudioContext(paramRequestEvent.jsonParams);
    return ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
  }
  
  @JsEvent({"createWebAudioContextBuffer"})
  public String createWebAudioContextBuffer(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.optInt("numOfChannels", 1);
      int j = localJSONObject.optInt("length");
      int k = localJSONObject.optInt("sampleRate");
      int m = localJSONObject.getInt("audioId");
      localJSONObject = WebAudioManager.getInstance().createBuffer(m, i, j, k);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"createWebAudioGain"})
  public String createWebAudioGain(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 5);
      localJSONObject.put("channelId", -1);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_CREATE_GAIN error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"createWebAudioScriptProcessor"})
  public String createWebAudioScriptProcessor(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.optInt("bufferSize");
      int j = localJSONObject.optInt("inputChannelNum");
      int k = localJSONObject.optInt("outputChannelNum");
      int m = localJSONObject.getInt("audioId");
      WebAudioManager.getInstance().createScriptProcessor(paramRequestEvent, m, i, j, k);
      return "{}";
    }
    catch (JSONException paramRequestEvent)
    {
      for (;;)
      {
        paramRequestEvent.printStackTrace();
      }
    }
  }
  
  @JsEvent({"decodeWebAudioData"})
  public String decodeWebAudioData(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = this.sId.incrementAndGet();
      localObject = NativeBuffer.unpackNativeBuffer(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((NativeBuffer)localObject).buf;
        if (Build.VERSION.SDK_INT >= 16) {
          WebAudioManager.getInstance().decodeAudioDataAndReturnBufferIdAsync(i, (byte[])localObject, paramRequestEvent);
        }
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("decodeId", i);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"getWebAudioBufferChannelData"})
  public String getWebAudioBufferChannelData(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).getInt("channelId");
      localObject = WebAudioManager.getInstance().getBufferChannelData(i, j);
      JSONObject localJSONObject = new JSONObject();
      NativeBuffer.packNativeBuffer(this.mMiniAppContext, (byte[])localObject, NativeBuffer.TYPE_BUFFER_NATIVE, "data", localJSONObject);
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA data.length " + localObject.length);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"getWebAudioCurrentGain"})
  public String getWebAudioCurrentGain(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
      int i = paramRequestEvent.getInt("channelId");
      int j = paramRequestEvent.getInt("audioId");
      paramRequestEvent = WebAudioManager.getInstance().getCurrentGain(j, i) + "";
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"getWebAudioCurrentTime"})
  public String getWebAudioCurrentTime(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      int i = new JSONObject(paramRequestEvent.jsonParams).getInt("audioId");
      paramRequestEvent = WebAudioManager.getInstance().getAudioContextCurrentTime(i) + "";
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"getWebAudioDestination"})
  public String getWebAudioDestination(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 4);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    if ((this.mMiniAppContext instanceof GameRuntime)) {
      this.mTTEngine = ((GameRuntime)this.mMiniAppContext).getGameEngine();
    }
    WebAudioManager.getInstance().setAudioNativeManager(this.mTTEngine);
  }
  
  @JsEvent({"operateWebAudioContext"})
  public String operateWebAudioContext(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams).getString("operationType");
      if (paramRequestEvent.equals("suspend")) {
        WebAudioManager.getInstance().suspendAudioContext(this.mTTEngine);
      }
      for (;;)
      {
        return "{}";
        if (paramRequestEvent.equals("resume")) {
          WebAudioManager.getInstance().resumeAudioContext(this.mTTEngine);
        }
      }
    }
    catch (Throwable paramRequestEvent)
    {
      for (;;)
      {
        GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_OPERATE_WEB_AUDIO_CONTEXT error " + paramRequestEvent.getMessage());
      }
    }
  }
  
  @JsEvent({"setWebAudioBufferSourceLoop"})
  public String setWebAudioBufferSourceLoop(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      boolean bool = localJSONObject.getBoolean("loop");
      int i = localJSONObject.getInt("channelId");
      int j = localJSONObject.getInt("audioId");
      WebAudioManager.getInstance().setBufferSourceLoop(j, i, bool);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"setWebAudioCurrentGain"})
  public String setWebAudioCurrentGain(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.getInt("channelId");
      double d = localJSONObject.getDouble("data");
      int j = localJSONObject.getInt("audioId");
      WebAudioManager.getInstance().setCurrentGain(j, i, d);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"setWebAudioSourceBuffer"})
  public String setWebAudioSourceBuffer(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.getInt("channelId");
      int j = localJSONObject.optInt("bufferId", -1);
      int k = localJSONObject.optInt("decodeId", -1);
      if (j != -1)
      {
        localJSONObject = WebAudioManager.getInstance().setSourceBuffer(i, j);
        return ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
      }
      if (k != -1)
      {
        localJSONObject = WebAudioManager.getInstance().setDecodingQueueBuffer(i, k);
        paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
        return paramRequestEvent;
      }
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"sourceStart"})
  public String sourceStart(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      int m = localJSONObject.optInt("offset", 0);
      int n = localJSONObject.optInt("duration", -1);
      localJSONObject = WebAudioManager.getInstance().sourceStart(paramRequestEvent, i, j, k, m, n);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_START error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"sourceStop"})
  public String sourceStop(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      localJSONObject = WebAudioManager.getInstance().sourceStop(i, j, k);
      paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
      return paramRequestEvent;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_STOP error " + paramRequestEvent.getMessage());
    }
    return "{}";
  }
  
  @JsEvent({"webAudioConnectAudioNode"})
  public String webAudioConnectAudioNode(RequestEvent paramRequestEvent)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.optInt("oriAudioNodeType", -1);
      localJSONObject.optInt("channelId", -2);
      localJSONObject.optInt("audioNodeType");
      int j = localJSONObject.getInt("audioId");
      if (i == WebAudioManager.SCRIPT_PROCESSOR_AUDIO_NODE_TYPE) {
        WebAudioManager.getInstance().startAudioProcess(paramRequestEvent, j);
      }
      return "{}";
    }
    catch (JSONException paramRequestEvent)
    {
      for (;;)
      {
        paramRequestEvent.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.WebAudioPlugin
 * JD-Core Version:    0.7.0.1
 */