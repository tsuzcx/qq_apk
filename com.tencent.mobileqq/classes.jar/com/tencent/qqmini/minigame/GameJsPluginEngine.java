package com.tencent.qqmini.minigame;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPlugin.DefaultImpls;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.qqmini.minigame.utils.LogFilterUtil;
import com.tencent.qqmini.minigame.utils.PluginLogger;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.LameMp3SoDownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.WebAudioDownloadListener;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/GameJsPluginEngine;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "()V", "commonJsServiceMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "Lkotlin/collections/HashMap;", "gameRuntime", "Lcom/tencent/qqmini/minigame/GameRuntime;", "innerAudio", "Lcom/tencent/mobileqq/tritonaudio/InnerAudioPlugin;", "jsPluginEngine", "Lcom/tencent/qqmini/sdk/plugins/engine/JsPluginEngine;", "logger", "Lcom/tencent/qqmini/minigame/utils/PluginLogger;", "realPluginEngine", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/engine/IJsPluginEngine;", "getRealPluginEngine", "()Lcom/tencent/qqmini/sdk/launcher/core/plugins/engine/IJsPluginEngine;", "runtime", "Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "getRuntime", "()Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "webAudio", "Lcom/tencent/mobileqq/tritonaudio/WebAudioPlugin;", "cacheCommonJsService", "", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "getCommonJsService", "contextType", "handleFocusGain", "handleFocusLoss", "onCall", "", "eventName", "onCreate", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onDestroy", "onStart", "onStop", "Companion", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameJsPluginEngine
  implements ScriptPlugin
{
  public static final GameJsPluginEngine.Companion Companion = new GameJsPluginEngine.Companion(null);
  private static final String TAG = "GameJsPluginEngine";
  private HashMap<ScriptContextType, IJsService> commonJsServiceMap = new HashMap();
  private GameRuntime gameRuntime;
  private final InnerAudioPlugin innerAudio = new InnerAudioPlugin();
  private JsPluginEngine jsPluginEngine;
  private final PluginLogger logger = new PluginLogger();
  private final WebAudioPlugin webAudio = new WebAudioPlugin();
  
  public GameJsPluginEngine()
  {
    PluginLogger localPluginLogger = this.logger;
    Map localMap1 = LogFilterUtil.getLogWhiteList();
    Intrinsics.checkExpressionValueIsNotNull(localMap1, "LogFilterUtil.getLogWhiteList()");
    Map localMap2 = LogFilterUtil.getLogBlackList();
    Intrinsics.checkExpressionValueIsNotNull(localMap2, "LogFilterUtil.getLogBlackList()");
    localPluginLogger.setConfig(localMap1, localMap2);
  }
  
  private final void cacheCommonJsService(Argument paramArgument)
  {
    if (this.commonJsServiceMap.get(paramArgument.getContextType()) == null)
    {
      GameJsPluginEngine.cacheCommonJsService.jsService.1 local1 = new GameJsPluginEngine.cacheCommonJsService.jsService.1(this, paramArgument);
      ((Map)this.commonJsServiceMap).put(paramArgument.getContextType(), local1);
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
    Object localObject;
    if (this.innerAudio.support(paramString))
    {
      localObject = this.innerAudio.onCall(paramString, paramArgument);
    }
    else if (this.webAudio.support(paramString))
    {
      localObject = this.webAudio.onCall(paramString, paramArgument);
    }
    else
    {
      localObject = this.jsPluginEngine;
      if (localObject != null) {
        localObject = ((JsPluginEngine)localObject).handleNativeRequest(paramString, paramArgument.getRawParams(), (IJsService)new GameJsService(paramArgument, this.logger), paramArgument.getCallbackId());
      } else {
        localObject = null;
      }
    }
    PluginLogger localPluginLogger = this.logger;
    ScriptContextType localScriptContextType = paramArgument.getContextType();
    String str = paramArgument.getRawParams();
    int i = paramArgument.getCallbackId();
    if (localObject != null) {
      paramArgument = (Argument)localObject;
    } else {
      paramArgument = "{}";
    }
    localPluginLogger.printStartLog(localScriptContextType, paramString, str, i, paramArgument);
    return localObject;
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
      this.jsPluginEngine = new JsPluginEngine(paramTritonEngine.getData().getContext());
      localObject = this.jsPluginEngine;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((JsPluginEngine)localObject).onCreate((IMiniAppContext)this.gameRuntime);
      localObject = this.gameRuntime;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((GameRuntime)localObject).setJsPluginEngine(this);
      this.innerAudio.onCreate(paramTritonEngine);
      this.webAudio.onCreate(paramTritonEngine);
      paramTritonEngine = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
      paramTritonEngine.getWebAudioDownloadPath((DownloaderProxy.WebAudioDownloadListener)new GameJsPluginEngine.onCreate.webAudioDownloadListener.1(this));
      paramTritonEngine.getLameMp3SoDownloadPath((DownloaderProxy.LameMp3SoDownloadListener)new GameJsPluginEngine.onCreate.lameMp3SoDownloadListener.1(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.qqmini.minigame.GameRuntime");
  }
  
  public void onDestroy()
  {
    ScriptPlugin.DefaultImpls.onDestroy(this);
    JsPluginEngine localJsPluginEngine = this.jsPluginEngine;
    if (localJsPluginEngine != null) {
      localJsPluginEngine.onDestroy();
    }
    this.innerAudio.onDestroy();
    this.webAudio.onDestroy();
    this.commonJsServiceMap.clear();
  }
  
  public void onFirstFrame()
  {
    ScriptPlugin.DefaultImpls.onFirstFrame(this);
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ScriptPlugin.DefaultImpls.onGameLaunched(this, paramTritonEngine);
  }
  
  public void onStart()
  {
    ScriptPlugin.DefaultImpls.onStart(this);
    JsPluginEngine localJsPluginEngine = this.jsPluginEngine;
    if (localJsPluginEngine != null) {
      localJsPluginEngine.onResume();
    }
    this.innerAudio.onStart();
    this.webAudio.onStart();
  }
  
  public void onStop()
  {
    ScriptPlugin.DefaultImpls.onStop(this);
    JsPluginEngine localJsPluginEngine = this.jsPluginEngine;
    if (localJsPluginEngine != null) {
      localJsPluginEngine.onPause();
    }
    this.innerAudio.onStop();
    this.webAudio.onStop();
    this.logger.printFailedApi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */