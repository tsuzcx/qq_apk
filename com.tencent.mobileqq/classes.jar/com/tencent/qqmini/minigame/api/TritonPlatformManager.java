package com.tencent.qqmini.minigame.api;

import android.content.Context;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.TritonPlatform.Builder;
import com.tencent.mobileqq.triton.exception.TritonPlatformInitTwiceException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.qqmini.minigame.manager.EnginePackageManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/api/TritonPlatformManager;", "", "()V", "TAG", "", "platform", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "getTritonPlatform", "context", "Landroid/content/Context;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class TritonPlatformManager
{
  public static final TritonPlatformManager INSTANCE = new TritonPlatformManager();
  private static final String TAG = "TritonPlatformManager";
  private static TritonPlatform platform;
  
  @JvmStatic
  @NotNull
  public static final TritonPlatform getTritonPlatform(@NotNull Context paramContext)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramContext, "context");
      Object localObject = platform;
      if (localObject == null) {
        try
        {
          paramContext = new TritonPlatform.Builder().context(paramContext);
          localObject = ProxyManager.get(MiniAppProxy.class);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "ProxyManager.get(MiniAppProxy::class.java)");
          paramContext = paramContext.debugConfig(new DebugConfig(((MiniAppProxy)localObject).isDebugVersion(), GameWnsUtils.getGamePresentDetectInterval(), GameWnsUtils.getNoPresentDurationLimit(), GameWnsUtils.getFrameNoChangeLimit(), GameWnsUtils.getNoPresentTouchLimit())).enableCodeCache(GameWnsUtils.getGameEnableCodeCache()).enableOpenGlEs3(GameWnsUtils.enableOpengles3());
          localObject = EnginePackageManager.getEnginePackage();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "EnginePackageManager.getEnginePackage()");
          paramContext = paramContext.enginePackage((EnginePackage)localObject);
          localObject = GameLog.getInstance();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "GameLog.getInstance()");
          platform = paramContext.logger((LogDelegate)localObject).scriptPluginFactory((ScriptPluginFactory)MiniScriptPluginFactory.INSTANCE).mainThreadExecutor(ThreadPools.getMainThreadExecutor()).workerExecutor((Executor)ThreadPools.getComputationThreadPool()).downloader((Downloader)MiniDownloader.INSTANCE).build();
        }
        catch (TritonPlatformInitTwiceException paramContext)
        {
          GameLog.getInstance().e("TritonPlatformManager", "exception in init TritonPlatform", (Throwable)paramContext);
          platform = paramContext.getPreviouslyBuiltPlatform();
        }
      }
      paramContext = platform;
      if (paramContext == null) {
        Intrinsics.throwUninitializedPropertyAccessException("platform");
      }
      return paramContext;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.TritonPlatformManager
 * JD-Core Version:    0.7.0.1
 */