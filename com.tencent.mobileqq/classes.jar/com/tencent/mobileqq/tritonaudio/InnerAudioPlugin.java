package com.tencent.mobileqq.tritonaudio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager;
import com.tencent.mobileqq.tritonaudio.internal.ApiUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/tritonaudio/InnerAudioPlugin;", "Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "()V", "audioPlayerManager", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;", "context", "Landroid/content/Context;", "interruptionMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/triton/script/Argument;", "isActivityPaused", "", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "mixWithOther", "onAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "sId", "Ljava/util/concurrent/atomic/AtomicInteger;", "supportedEvents", "", "getSupportedEvents", "()Ljava/util/Set;", "createAudioInstance", "arguments", "destroyAudioInstance", "execAudioFocus", "", "requestFocus", "getAudioState", "getAvailableAudioSources", "handleAbandonFocus", "handleFocusGain", "handleFocusLoss", "onCall", "eventName", "onCreate", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onDestroy", "onStart", "onStop", "operateAudio", "saveAudioInterruptionCaller", "event", "setAudioState", "setInnerAudioOption", "setMixWithOther", "support", "Companion", "GameAudioStateChangeListener", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class InnerAudioPlugin
  implements ComposableScriptPlugin
{
  @NotNull
  public static final String API_CREATE_AUDIO_INSTANCE = "createAudioInstance";
  @NotNull
  public static final String API_DESTROY_AUDIO_INSTANCE = "destroyAudioInstance";
  @NotNull
  public static final String API_GET_AUDIO_STATE = "getAudioState";
  @NotNull
  public static final String API_GET_AVAILABLE_AUDIO_SOURCES = "getAvailableAudioSources";
  @NotNull
  public static final String API_OPERATE_AUDIO = "operateAudio";
  @NotNull
  public static final String API_SET_AUDIO_STATE = "setAudioState";
  @NotNull
  public static final String API_SET_INNER_AUDIO_OPTION = "setInnerAudioOptionQGame";
  @NotNull
  public static final String AUDIO_OPERATE_PAUSE = "pause";
  @NotNull
  public static final String AUDIO_OPERATE_PLAY = "play";
  @NotNull
  public static final String AUDIO_OPERATE_SEEK = "seek";
  @NotNull
  public static final String AUDIO_OPERATE_STOP = "stop";
  @NotNull
  public static final String AUDIO_PROPERTY_AUTOPLAY = "autoplay";
  @NotNull
  public static final String AUDIO_PROPERTY_BUFFERED = "buffered";
  @NotNull
  public static final String AUDIO_PROPERTY_CURRENTTIME = "currentTime";
  @NotNull
  public static final String AUDIO_PROPERTY_DURATIOIN = "duration";
  @NotNull
  public static final String AUDIO_PROPERTY_LOOP = "loop";
  @NotNull
  public static final String AUDIO_PROPERTY_PAUSED = "paused";
  @NotNull
  public static final String AUDIO_PROPERTY_SRC = "src";
  @NotNull
  public static final String AUDIO_PROPERTY_STARTTIME = "startTime";
  @NotNull
  public static final String AUDIO_PROPERTY_VOLUME = "volume";
  @NotNull
  public static final String AUDIO_STATE_CANPLAY = "canplay";
  @NotNull
  public static final String AUDIO_STATE_ENDED = "ended";
  @NotNull
  public static final String AUDIO_STATE_ERROR = "error";
  @NotNull
  public static final String AUDIO_STATE_PAUSE = "pause";
  @NotNull
  public static final String AUDIO_STATE_PLAY = "play";
  @NotNull
  public static final String AUDIO_STATE_SEEKED = "seeked";
  @NotNull
  public static final String AUDIO_STATE_SEEKING = "seeking";
  @NotNull
  public static final String AUDIO_STATE_STOP = "stop";
  @NotNull
  public static final String AUDIO_STATE_TIMEUPDATE = "timeUpdate";
  @NotNull
  public static final String AUDIO_STATE_WAITING = "waiting";
  public static final InnerAudioPlugin.Companion Companion = new InnerAudioPlugin.Companion(null);
  public static final int ERROR_FILE = 10003;
  public static final int ERROR_FORMAT = 10004;
  public static final int ERROR_NETWORK = 10002;
  public static final int ERROR_SYSTEM = 10001;
  public static final int ERROR_UNKNOWN = -1;
  @NotNull
  public static final String EVENT_INTERRUPTION_BEGIN = "onAudioInterruptionBegin";
  @NotNull
  public static final String EVENT_INTERRUPTION_END = "onAudioInterruptionEnd";
  @NotNull
  public static final String EVENT_ON_AUDIO_STATE_CHANGE = "onAudioStateChange";
  private static final String TAG = "[audio]InnerAudioPlugin";
  private static final Set<String> supportedEvents = SetsKt.setOf(new String[] { "createAudioInstance", "destroyAudioInstance", "operateAudio", "setAudioState", "getAudioState", "setInnerAudioOptionQGame", "getAvailableAudioSources", "onAudioInterruptionBegin", "onAudioInterruptionEnd" });
  private AudioPlayerManager audioPlayerManager;
  private Context context;
  private final HashMap<String, Argument> interruptionMap = new HashMap();
  private boolean isActivityPaused;
  private LogDelegate logger;
  private volatile boolean mixWithOther = true;
  private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = (AudioManager.OnAudioFocusChangeListener)new InnerAudioPlugin.onAudioFocusChangeListener.1(this);
  private final AtomicInteger sId = new AtomicInteger();
  
  private final String createAudioInstance(Argument paramArgument)
  {
    int i = this.sId.incrementAndGet();
    TritonAudioThreadPool.getAudioExecutorService().execute((Runnable)new InnerAudioPlugin.createAudioInstance.1(this, i, paramArgument));
    paramArgument = new JSONObject();
    paramArgument.put("audioId", i);
    paramArgument = ApiUtil.wrapCallbackOk("createAudioInstance", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A… audioContext).toString()");
    return paramArgument;
  }
  
  private final String destroyAudioInstance(Argument paramArgument)
  {
    int i = paramArgument.getParams().optInt("audioId", -1);
    TritonAudioThreadPool.getAudioExecutorService().execute((Runnable)new InnerAudioPlugin.destroyAudioInstance.1(this, i));
    paramArgument = ApiUtil.wrapCallbackOk("destroyAudioInstance", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…NSTANCE, null).toString()");
    return paramArgument;
  }
  
  private final void execAudioFocus(boolean paramBoolean)
  {
    Object localObject = this.logger;
    if (localObject != null) {
      LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject, LogDelegate.Level.INFO, "[audio]InnerAudioPlugin", "execAudioFocus focus=" + paramBoolean, null, 8, null);
    }
    localObject = this.context;
    if (localObject != null) {}
    for (localObject = ((Context)localObject).getSystemService("audio");; localObject = null)
    {
      if ((localObject instanceof AudioManager))
      {
        if (!paramBoolean) {
          break;
        }
        if (((AudioManager)localObject).requestAudioFocus(this.onAudioFocusChangeListener, 3, 1) == 1)
        {
          localObject = this.audioPlayerManager;
          if ((localObject != null) && (((AudioPlayerManager)localObject).execAudioFocus() == true))
          {
            localObject = (Argument)this.interruptionMap.get("onAudioInterruptionEnd");
            if (localObject != null) {
              ((Argument)localObject).subscribe("onAudioInterruptionEnd", null);
            }
          }
        }
      }
      return;
    }
    ((AudioManager)localObject).abandonAudioFocus(this.onAudioFocusChangeListener);
  }
  
  private final String getAudioState(Argument paramArgument)
  {
    Object localObject = null;
    int i = paramArgument.getParams().optInt("audioId", -1);
    if (i == -1)
    {
      paramArgument = ApiUtil.wrapCallbackFail("getAudioState", null, "param error").toString();
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackFail…              .toString()");
      return paramArgument;
    }
    JSONObject localJSONObject = new JSONObject();
    paramArgument = this.audioPlayerManager;
    if (paramArgument != null)
    {
      paramArgument = Double.valueOf(paramArgument.getDuration(i));
      localJSONObject.put("duration", paramArgument);
      paramArgument = this.audioPlayerManager;
      if (paramArgument == null) {
        break label271;
      }
      paramArgument = Double.valueOf(paramArgument.getCurPosition(i));
      label97:
      localJSONObject.put("currentTime", paramArgument);
      paramArgument = this.audioPlayerManager;
      if (paramArgument == null) {
        break label276;
      }
      paramArgument = Double.valueOf(paramArgument.getBuffered(i));
      label124:
      localJSONObject.put("buffered", paramArgument);
      paramArgument = this.audioPlayerManager;
      if (paramArgument == null) {
        break label281;
      }
      paramArgument = Boolean.valueOf(paramArgument.getPaused(i));
      label151:
      localJSONObject.put("paused", paramArgument);
      paramArgument = this.audioPlayerManager;
      if (paramArgument == null) {
        break label286;
      }
      paramArgument = Float.valueOf(paramArgument.getStartTime(i));
      label178:
      localJSONObject.put("startTime", paramArgument);
      paramArgument = this.audioPlayerManager;
      if (paramArgument == null) {
        break label291;
      }
    }
    label271:
    label276:
    label281:
    label286:
    label291:
    for (paramArgument = Boolean.valueOf(paramArgument.getAutoplay(i));; paramArgument = null)
    {
      localJSONObject.put("autoplay", paramArgument);
      AudioPlayerManager localAudioPlayerManager = this.audioPlayerManager;
      paramArgument = localObject;
      if (localAudioPlayerManager != null) {
        paramArgument = Boolean.valueOf(localAudioPlayerManager.getLoop(i));
      }
      localJSONObject.put("loop", paramArgument);
      paramArgument = ApiUtil.wrapCallbackOk("getAudioState", localJSONObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…E, audioState).toString()");
      return paramArgument;
      paramArgument = null;
      break;
      paramArgument = null;
      break label97;
      paramArgument = null;
      break label124;
      paramArgument = null;
      break label151;
      paramArgument = null;
      break label178;
    }
  }
  
  private final String getAvailableAudioSources(Argument paramArgument)
  {
    Object localObject = new JSONObject();
    String str = Arrays.toString(new String[] { "auto" });
    Intrinsics.checkExpressionValueIsNotNull(str, "java.util.Arrays.toString(this)");
    ((JSONObject)localObject).put("audioSources", str);
    localObject = ApiUtil.wrapCallbackOk("getAvailableAudioSources", (JSONObject)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ApiUtil.wrapCallbackOk(A…URCES, resObj).toString()");
    paramArgument.callback((String)localObject);
    return localObject;
  }
  
  private final void handleAbandonFocus()
  {
    Object localObject = this.context;
    if (localObject != null) {}
    for (localObject = ((Context)localObject).getSystemService("audio");; localObject = null)
    {
      if ((localObject instanceof AudioManager)) {
        ((AudioManager)localObject).abandonAudioFocus(this.onAudioFocusChangeListener);
      }
      return;
    }
  }
  
  private final String operateAudio(Argument paramArgument)
  {
    TritonAudioThreadPool.getAudioExecutorService().execute((Runnable)new InnerAudioPlugin.operateAudio.1(this, paramArgument));
    paramArgument = ApiUtil.wrapCallbackOk("operateAudio", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…E_AUDIO, null).toString()");
    return paramArgument;
  }
  
  private final String saveAudioInterruptionCaller(String paramString, Argument paramArgument)
  {
    if (!this.interruptionMap.containsKey(paramString)) {
      ((Map)this.interruptionMap).put(paramString, paramArgument);
    }
    paramString = ApiUtil.wrapCallbackOk(paramString, null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "ApiUtil.wrapCallbackOk(event, null).toString()");
    return paramString;
  }
  
  private final String setAudioState(Argument paramArgument)
  {
    TritonAudioThreadPool.getAudioExecutorService().execute((Runnable)new InnerAudioPlugin.setAudioState.1(this, paramArgument));
    paramArgument = ApiUtil.wrapCallbackOk("setAudioState", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…O_STATE, null).toString()");
    return paramArgument;
  }
  
  private final String setInnerAudioOption(Argument paramArgument)
  {
    boolean bool1 = paramArgument.getParams().optBoolean("mixWithOther", true);
    boolean bool2 = paramArgument.getParams().optBoolean("obeyMuteSwitch", true);
    setMixWithOther(bool1);
    Object localObject = this.audioPlayerManager;
    if (localObject != null) {
      ((AudioPlayerManager)localObject).setMusicSwitch(bool2);
    }
    localObject = ApiUtil.wrapCallbackOk("setInnerAudioOptionQGame", null).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ApiUtil.wrapCallbackOk(A…_OPTION, null).toString()");
    paramArgument.callback((String)localObject);
    return localObject;
  }
  
  private final void setMixWithOther(boolean paramBoolean)
  {
    this.mixWithOther = paramBoolean;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      execAudioFocus(paramBoolean);
      return;
    }
  }
  
  @NotNull
  public Set<String> getSupportedEvents()
  {
    return supportedEvents;
  }
  
  public final void handleFocusGain()
  {
    Object localObject = this.audioPlayerManager;
    if (localObject != null) {
      ((AudioPlayerManager)localObject).handleFocusGain();
    }
    localObject = (Argument)this.interruptionMap.get("onAudioInterruptionEnd");
    if (localObject != null) {
      ((Argument)localObject).subscribe("onAudioInterruptionEnd", null);
    }
  }
  
  public final void handleFocusLoss()
  {
    Object localObject = this.audioPlayerManager;
    if (localObject != null) {
      ((AudioPlayerManager)localObject).handleFocusLoss();
    }
    localObject = (Argument)this.interruptionMap.get("onAudioInterruptionBegin");
    if (localObject != null) {
      ((Argument)localObject).subscribe("onAudioInterruptionBegin", null);
    }
  }
  
  @Nullable
  public String onCall(@NotNull String paramString, @NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramArgument, "arguments");
    switch (paramString.hashCode())
    {
    default: 
    case 1240524369: 
    case -430902094: 
    case -2107296591: 
    case 1868086796: 
    case 17532319: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return null;
              } while (!paramString.equals("getAudioState"));
              return getAudioState(paramArgument);
            } while (!paramString.equals("operateAudio"));
            return operateAudio(paramArgument);
          } while (!paramString.equals("destroyAudioInstance"));
          return destroyAudioInstance(paramArgument);
        } while (!paramString.equals("setInnerAudioOptionQGame"));
        return setInnerAudioOption(paramArgument);
      } while (!paramString.equals("onAudioInterruptionEnd"));
    }
    for (;;)
    {
      return saveAudioInterruptionCaller(paramString, paramArgument);
      if (!paramString.equals("createAudioInstance")) {
        break;
      }
      return createAudioInstance(paramArgument);
      if (!paramString.equals("setAudioState")) {
        break;
      }
      return setAudioState(paramArgument);
      if (!paramString.equals("getAvailableAudioSources")) {
        break;
      }
      return getAvailableAudioSources(paramArgument);
      if (!paramString.equals("onAudioInterruptionBegin")) {
        break;
      }
    }
  }
  
  public void onCreate(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    this.context = paramTritonEngine.getData().getContext();
    this.logger = paramTritonEngine.getData().getLogDelegate();
    this.audioPlayerManager = new AudioPlayerManager(paramTritonEngine.getData().getContext(), paramTritonEngine.getData().getDataFileSystem(), paramTritonEngine.getData().getDownloader(), paramTritonEngine.getData().getLogDelegate());
  }
  
  public void onDestroy()
  {
    execAudioFocus(false);
    TritonAudioThreadPool.getAudioExecutorService().execute((Runnable)new InnerAudioPlugin.onDestroy.1(this));
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
    if (!this.mixWithOther) {
      execAudioFocus(true);
    }
    TritonAudioThreadPool.getAudioExecutorService().execute((Runnable)new InnerAudioPlugin.onStart.1(this));
    this.isActivityPaused = false;
  }
  
  public void onStop()
  {
    execAudioFocus(false);
    TritonAudioThreadPool.getAudioExecutorService().execute((Runnable)new InnerAudioPlugin.onStop.1(this));
    this.isActivityPaused = true;
  }
  
  public final boolean support(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    return getSupportedEvents().contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.InnerAudioPlugin
 * JD-Core Version:    0.7.0.1
 */