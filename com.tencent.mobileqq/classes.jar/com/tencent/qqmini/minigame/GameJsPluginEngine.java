package com.tencent.qqmini.minigame;

import android.content.Context;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPlugin.DefaultImpls;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.minigame.utils.LogFilterUtil;
import com.tencent.qqmini.minigame.utils.PluginLogger;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/GameJsPluginEngine;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commonJsServiceMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "Lkotlin/collections/HashMap;", "gameRuntime", "Lcom/tencent/qqmini/minigame/GameRuntime;", "innerAudio", "Lcom/tencent/mobileqq/tritonaudio/InnerAudioPlugin;", "jsPluginEngine", "Lcom/tencent/qqmini/sdk/plugins/engine/MiniGameJsPluginEngine;", "logger", "Lcom/tencent/qqmini/minigame/utils/PluginLogger;", "mFirstFrameFinished", "", "mLaunchJsEventRecord", "", "", "realPluginEngine", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/engine/IJsPluginEngine;", "getRealPluginEngine", "()Lcom/tencent/qqmini/sdk/launcher/core/plugins/engine/IJsPluginEngine;", "runtime", "Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "getRuntime", "()Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "webAudio", "Lcom/tencent/mobileqq/tritonaudio/WebAudioPlugin;", "cacheCommonJsService", "", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "getCommonJsService", "contextType", "handleFocusGain", "handleFocusLoss", "loadAudioSoAsync", "onCall", "eventName", "onCreate", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onDestroy", "onFirstFrame", "onStart", "onStop", "recordJsEventCost", "startTime", "reportJsEventCostDurLaunch", "Companion", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameJsPluginEngine
  implements ScriptPlugin
{
  public static final GameJsPluginEngine.Companion Companion = new GameJsPluginEngine.Companion(null);
  private static final String TAG = "GameJsPluginEngine";
  private HashMap<ScriptContextType, IJsService> commonJsServiceMap;
  private GameRuntime gameRuntime;
  private final InnerAudioPlugin innerAudio;
  private MiniGameJsPluginEngine jsPluginEngine;
  private final PluginLogger logger;
  private boolean mFirstFrameFinished;
  private final HashMap<String, Long> mLaunchJsEventRecord;
  private final WebAudioPlugin webAudio;
  
  public GameJsPluginEngine(@NotNull Context paramContext)
  {
    this.jsPluginEngine = new MiniGameJsPluginEngine(paramContext);
    this.commonJsServiceMap = new HashMap();
    this.logger = new PluginLogger();
    this.innerAudio = new InnerAudioPlugin();
    this.webAudio = new WebAudioPlugin();
    this.mLaunchJsEventRecord = new HashMap();
    paramContext = this.logger;
    Map localMap1 = LogFilterUtil.getLogWhiteList();
    Intrinsics.checkExpressionValueIsNotNull(localMap1, "LogFilterUtil.getLogWhiteList()");
    Map localMap2 = LogFilterUtil.getLogBlackList();
    Intrinsics.checkExpressionValueIsNotNull(localMap2, "LogFilterUtil.getLogBlackList()");
    paramContext.setConfig(localMap1, localMap2);
  }
  
  private final void cacheCommonJsService(Argument paramArgument)
  {
    if (this.commonJsServiceMap.get(paramArgument.getContextType()) == null)
    {
      GameJsPluginEngine.cacheCommonJsService.jsService.1 local1 = new GameJsPluginEngine.cacheCommonJsService.jsService.1(this, paramArgument);
      ((Map)this.commonJsServiceMap).put(paramArgument.getContextType(), local1);
    }
  }
  
  private final void loadAudioSoAsync()
  {
    ThreadManager.executeOnComputationThreadPool((Runnable)new GameJsPluginEngine.loadAudioSoAsync.1(this));
  }
  
  private final void recordJsEventCost(String paramString, long paramLong)
  {
    if (!this.mFirstFrameFinished)
    {
      paramLong = System.currentTimeMillis() - paramLong;
      Long localLong = (Long)this.mLaunchJsEventRecord.get(paramString);
      if ((localLong == null) || (paramLong > localLong.longValue())) {
        ((Map)this.mLaunchJsEventRecord).put(paramString, Long.valueOf(paramLong));
      }
    }
  }
  
  private final void reportJsEventCostDurLaunch()
  {
    if ((((Map)this.mLaunchJsEventRecord).isEmpty() ^ true))
    {
      Object localObject = getRuntime();
      if (localObject != null)
      {
        localObject = ((BaseRuntime)localObject).getMiniAppInfo();
        if (localObject != null)
        {
          localObject = ((MiniAppInfo)localObject).appId;
          if (localObject != null)
          {
            MiniGameBeaconReport.INSTANCE.reportGameLaunchJsEventCost((String)localObject, MapsKt.toMap((Map)this.mLaunchJsEventRecord));
            this.mLaunchJsEventRecord.clear();
          }
        }
      }
    }
  }
  
  @Nullable
  public final IJsService getCommonJsService(@NotNull ScriptContextType paramScriptContextType)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContextType, "contextType");
    return (IJsService)this.commonJsServiceMap.get(paramScriptContextType);
  }
  
  @Nullable
  public final IJsPluginEngine getRealPluginEngine()
  {
    return (IJsPluginEngine)this.jsPluginEngine;
  }
  
  @Nullable
  public final BaseRuntime getRuntime()
  {
    return (BaseRuntime)this.gameRuntime;
  }
  
  public final void handleFocusGain()
  {
    this.innerAudio.handleFocusGain();
  }
  
  public final void handleFocusLoss()
  {
    this.innerAudio.handleFocusLoss();
  }
  
  @Nullable
  public String onCall(@NotNull String paramString, @NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramArgument, "arguments");
    cacheCommonJsService(paramArgument);
    long l = System.currentTimeMillis();
    String str1;
    if (this.innerAudio.support(paramString)) {
      str1 = this.innerAudio.onCall(paramString, paramArgument);
    } else if (this.webAudio.support(paramString)) {
      str1 = this.webAudio.onCall(paramString, paramArgument);
    } else {
      str1 = this.jsPluginEngine.handleNativeRequest(paramString, paramArgument.getRawParams(), (IJsService)new GameJsService(paramArgument, this.logger), paramArgument.getCallbackId());
    }
    recordJsEventCost(paramString, l);
    PluginLogger localPluginLogger = this.logger;
    ScriptContextType localScriptContextType = paramArgument.getContextType();
    String str2 = paramArgument.getRawParams();
    int i = paramArgument.getCallbackId();
    if (str1 != null) {
      paramArgument = str1;
    } else {
      paramArgument = "{}";
    }
    localPluginLogger.printStartLog(localScriptContextType, paramString, str2, i, paramArgument);
    return str1;
  }
  
  public void onCreate(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    Object localObject = paramTritonEngine.getData();
    Class localClass = Class.forName("com.tencent.qqmini.minigame.GameRuntime");
    Intrinsics.checkExpressionValueIsNotNull(localClass, "Class.forName(\"com.tence…ni.minigame.GameRuntime\")");
    localObject = ((EngineData)localObject).get(localClass);
    if (localObject != null)
    {
      this.gameRuntime = ((GameRuntime)localObject);
      this.jsPluginEngine.onCreate((IMiniAppContext)this.gameRuntime);
      localObject = this.gameRuntime;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((GameRuntime)localObject).setJsPluginEngine(this);
      this.innerAudio.onCreate(paramTritonEngine);
      this.webAudio.onCreate(paramTritonEngine);
      loadAudioSoAsync();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.qqmini.minigame.GameRuntime");
  }
  
  public void onDestroy()
  {
    ScriptPlugin.DefaultImpls.onDestroy(this);
    this.jsPluginEngine.onDestroy();
    this.innerAudio.onDestroy();
    this.webAudio.onDestroy();
    this.commonJsServiceMap.clear();
  }
  
  public void onFirstFrame()
  {
    ScriptPlugin.DefaultImpls.onFirstFrame(this);
    this.mFirstFrameFinished = true;
    reportJsEventCostDurLaunch();
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ScriptPlugin.DefaultImpls.onGameLaunched(this, paramTritonEngine);
  }
  
  public void onStart()
  {
    ScriptPlugin.DefaultImpls.onStart(this);
    this.jsPluginEngine.onResume();
    this.innerAudio.onStart();
    this.webAudio.onStart();
  }
  
  public void onStop()
  {
    ScriptPlugin.DefaultImpls.onStop(this);
    this.jsPluginEngine.onPause();
    this.innerAudio.onStop();
    this.webAudio.onStop();
    this.logger.printFailedApi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */