package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.mobileqq.minigame.manager.FileDownloadManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.utils.LogFilterUtil;
import com.tencent.mobileqq.minigame.utils.PluginLogger;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPlugin.DefaultImpls;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.WebAudioDownloadListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/api/QQMiniScriptPlugin;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "()V", "innerAudio", "Lcom/tencent/mobileqq/tritonaudio/InnerAudioPlugin;", "jsPluginEngine", "Lcom/tencent/mobileqq/minigame/jsapi/GameJsPluginEngine;", "logger", "Lcom/tencent/mobileqq/minigame/utils/PluginLogger;", "webAudio", "Lcom/tencent/mobileqq/tritonaudio/WebAudioPlugin;", "onCall", "", "eventName", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "onCreate", "", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onDestroy", "onStart", "onStop", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQMiniScriptPlugin
  implements ScriptPlugin
{
  private final InnerAudioPlugin innerAudio = new InnerAudioPlugin();
  private GameJsPluginEngine jsPluginEngine;
  private final PluginLogger logger = new PluginLogger();
  private final WebAudioPlugin webAudio = new WebAudioPlugin();
  
  public QQMiniScriptPlugin()
  {
    PluginLogger localPluginLogger = this.logger;
    Map localMap1 = LogFilterUtil.getLogWhiteList();
    Intrinsics.checkExpressionValueIsNotNull(localMap1, "LogFilterUtil.getLogWhiteList()");
    Map localMap2 = LogFilterUtil.getLogBlackList();
    Intrinsics.checkExpressionValueIsNotNull(localMap2, "LogFilterUtil.getLogBlackList()");
    localPluginLogger.setConfig(localMap1, localMap2);
  }
  
  @Nullable
  public String onCall(@NotNull String paramString, @NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramArgument, "arguments");
    Object localObject = this.jsPluginEngine;
    if (localObject != null) {
      ((GameJsPluginEngine)localObject).cacheCommonJsService(paramArgument, this.logger);
    }
    PluginLogger localPluginLogger;
    ScriptContextType localScriptContextType;
    String str;
    int i;
    if (this.innerAudio.support(paramString))
    {
      localObject = this.innerAudio.onCall(paramString, paramArgument);
      localPluginLogger = this.logger;
      localScriptContextType = paramArgument.getContextType();
      str = paramArgument.getRawParams();
      i = paramArgument.getCallbackId();
      if (localObject == null) {
        break label187;
      }
    }
    label187:
    for (paramArgument = (Argument)localObject;; paramArgument = "{}")
    {
      localPluginLogger.printStartLog(localScriptContextType, paramString, str, i, paramArgument);
      return localObject;
      if (this.webAudio.support(paramString))
      {
        localObject = this.webAudio.onCall(paramString, paramArgument);
        break;
      }
      localObject = this.jsPluginEngine;
      if (localObject != null)
      {
        localObject = ((GameJsPluginEngine)localObject).handleNativeRequest(paramString, paramArgument.getRawParams(), (JsRuntime)new GameJsRuntime(paramArgument, this.logger), paramArgument.getCallbackId());
        break;
      }
      localObject = null;
      break;
    }
  }
  
  public void onCreate(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ScriptPlugin.DefaultImpls.onCreate(this, paramTritonEngine);
    this.innerAudio.onCreate(paramTritonEngine);
    this.webAudio.onCreate(paramTritonEngine);
    FileDownloadManager.getWebAudioDownloadPath((DownloaderProxy.WebAudioDownloadListener)new QQMiniScriptPlugin.onCreate.listener.1(this));
    this.jsPluginEngine = ((GameRuntimeLoader)paramTritonEngine.getData().get(GameRuntimeLoader.class)).getJsPluginEngine();
    paramTritonEngine = this.jsPluginEngine;
    if (paramTritonEngine != null) {
      paramTritonEngine.setAudioPlugin(this.innerAudio);
    }
  }
  
  public void onDestroy()
  {
    ScriptPlugin.DefaultImpls.onDestroy(this);
    this.innerAudio.onDestroy();
    this.webAudio.onDestroy();
    GameJsPluginEngine localGameJsPluginEngine = this.jsPluginEngine;
    if (localGameJsPluginEngine != null) {
      localGameJsPluginEngine.onDestroy();
    }
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
    this.innerAudio.onStart();
    this.webAudio.onStart();
    GameJsPluginEngine localGameJsPluginEngine = this.jsPluginEngine;
    if (localGameJsPluginEngine != null) {
      localGameJsPluginEngine.onResume();
    }
  }
  
  public void onStop()
  {
    ScriptPlugin.DefaultImpls.onStop(this);
    this.innerAudio.onStop();
    this.webAudio.onStop();
    GameJsPluginEngine localGameJsPluginEngine = this.jsPluginEngine;
    if (localGameJsPluginEngine != null) {
      localGameJsPluginEngine.onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniScriptPlugin
 * JD-Core Version:    0.7.0.1
 */