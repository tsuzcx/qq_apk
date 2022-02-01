package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.TritonPlatform;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/api/TritonPlatformManager;", "", "()V", "TAG", "", "platform", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "getTritonPlatform", "context", "Landroid/content/Context;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class TritonPlatformManager
{
  public static final TritonPlatformManager INSTANCE = new TritonPlatformManager();
  private static final String TAG = "TritonPlatformManager";
  private static TritonPlatform platform;
  
  /* Error */
  @kotlin.jvm.JvmStatic
  @org.jetbrains.annotations.NotNull
  public static final TritonPlatform getTritonPlatform(@org.jetbrains.annotations.NotNull android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 56
    //   6: invokestatic 60	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: getstatic 41	com/tencent/qqmini/minigame/api/TritonPlatformManager:platform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +148 -> 162
    //   17: new 62	com/tencent/mobileqq/triton/TritonPlatform$Builder
    //   20: dup
    //   21: invokespecial 63	com/tencent/mobileqq/triton/TritonPlatform$Builder:<init>	()V
    //   24: aload_0
    //   25: invokevirtual 66	com/tencent/mobileqq/triton/TritonPlatform$Builder:context	(Landroid/content/Context;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   28: astore_0
    //   29: ldc 68
    //   31: invokestatic 74	com/tencent/qqmini/sdk/core/proxy/ProxyManager:get	(Ljava/lang/Class;)Ljava/lang/Object;
    //   34: astore_1
    //   35: aload_1
    //   36: ldc 76
    //   38: invokestatic 79	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   41: aload_0
    //   42: new 81	com/tencent/mobileqq/triton/model/DebugConfig
    //   45: dup
    //   46: aload_1
    //   47: checkcast 68	com/tencent/qqmini/sdk/launcher/core/proxy/MiniAppProxy
    //   50: invokevirtual 85	com/tencent/qqmini/sdk/launcher/core/proxy/MiniAppProxy:isDebugVersion	()Z
    //   53: invokestatic 91	com/tencent/qqmini/sdk/utils/GameWnsUtils:getGamePresentDetectInterval	()I
    //   56: i2l
    //   57: invokestatic 94	com/tencent/qqmini/sdk/utils/GameWnsUtils:getNoPresentDurationLimit	()I
    //   60: i2l
    //   61: invokestatic 97	com/tencent/qqmini/sdk/utils/GameWnsUtils:getFrameNoChangeLimit	()I
    //   64: invokestatic 100	com/tencent/qqmini/sdk/utils/GameWnsUtils:getNoPresentTouchLimit	()I
    //   67: invokespecial 103	com/tencent/mobileqq/triton/model/DebugConfig:<init>	(ZJJII)V
    //   70: invokevirtual 107	com/tencent/mobileqq/triton/TritonPlatform$Builder:debugConfig	(Lcom/tencent/mobileqq/triton/model/DebugConfig;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   73: invokestatic 110	com/tencent/qqmini/sdk/utils/GameWnsUtils:getGameEnableCodeCache	()Z
    //   76: invokevirtual 114	com/tencent/mobileqq/triton/TritonPlatform$Builder:enableCodeCache	(Z)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   79: invokestatic 117	com/tencent/qqmini/sdk/utils/GameWnsUtils:enableOpengles3	()Z
    //   82: invokevirtual 120	com/tencent/mobileqq/triton/TritonPlatform$Builder:enableOpenGlEs3	(Z)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   85: astore_0
    //   86: invokestatic 126	com/tencent/qqmini/minigame/manager/EnginePackageManager:getEnginePackage	()Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;
    //   89: astore_1
    //   90: aload_1
    //   91: ldc 128
    //   93: invokestatic 79	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload_0
    //   97: aload_1
    //   98: checkcast 130	com/tencent/mobileqq/triton/filesystem/EnginePackage
    //   101: invokevirtual 134	com/tencent/mobileqq/triton/TritonPlatform$Builder:enginePackage	(Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   104: astore_0
    //   105: invokestatic 140	com/tencent/qqmini/minigame/utils/GameLog:getInstance	()Lcom/tencent/qqmini/minigame/utils/GameLog;
    //   108: astore_1
    //   109: aload_1
    //   110: ldc 142
    //   112: invokestatic 79	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   115: aload_0
    //   116: aload_1
    //   117: checkcast 144	com/tencent/mobileqq/triton/utils/LogDelegate
    //   120: invokevirtual 148	com/tencent/mobileqq/triton/TritonPlatform$Builder:logger	(Lcom/tencent/mobileqq/triton/utils/LogDelegate;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   123: getstatic 153	com/tencent/qqmini/minigame/api/MiniScriptPluginFactory:INSTANCE	Lcom/tencent/qqmini/minigame/api/MiniScriptPluginFactory;
    //   126: checkcast 155	com/tencent/mobileqq/triton/script/ScriptPluginFactory
    //   129: invokevirtual 159	com/tencent/mobileqq/triton/TritonPlatform$Builder:scriptPluginFactory	(Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   132: invokestatic 165	com/tencent/qqmini/sdk/core/utils/thread/ThreadPools:getMainThreadExecutor	()Ljava/util/concurrent/Executor;
    //   135: invokevirtual 169	com/tencent/mobileqq/triton/TritonPlatform$Builder:mainThreadExecutor	(Ljava/util/concurrent/Executor;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   138: invokestatic 173	com/tencent/qqmini/sdk/core/utils/thread/ThreadPools:getComputationThreadPool	()Ljava/util/concurrent/ExecutorService;
    //   141: checkcast 175	java/util/concurrent/Executor
    //   144: invokevirtual 178	com/tencent/mobileqq/triton/TritonPlatform$Builder:workerExecutor	(Ljava/util/concurrent/Executor;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   147: getstatic 183	com/tencent/qqmini/minigame/api/MiniDownloader:INSTANCE	Lcom/tencent/qqmini/minigame/api/MiniDownloader;
    //   150: checkcast 185	com/tencent/mobileqq/triton/utils/Downloader
    //   153: invokevirtual 189	com/tencent/mobileqq/triton/TritonPlatform$Builder:downloader	(Lcom/tencent/mobileqq/triton/utils/Downloader;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   156: invokevirtual 193	com/tencent/mobileqq/triton/TritonPlatform$Builder:build	()Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   159: putstatic 41	com/tencent/qqmini/minigame/api/TritonPlatformManager:platform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   162: getstatic 41	com/tencent/qqmini/minigame/api/TritonPlatformManager:platform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   165: astore_0
    //   166: aload_0
    //   167: ifnonnull +8 -> 175
    //   170: ldc 42
    //   172: invokestatic 48	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: areturn
    //   180: astore_0
    //   181: invokestatic 140	com/tencent/qqmini/minigame/utils/GameLog:getInstance	()Lcom/tencent/qqmini/minigame/utils/GameLog;
    //   184: ldc 29
    //   186: ldc 195
    //   188: aload_0
    //   189: checkcast 197	java/lang/Throwable
    //   192: invokevirtual 201	com/tencent/qqmini/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   195: pop
    //   196: aload_0
    //   197: invokevirtual 204	com/tencent/mobileqq/triton/exception/TritonPlatformInitTwiceException:getPreviouslyBuiltPlatform	()Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   200: putstatic 41	com/tencent/qqmini/minigame/api/TritonPlatformManager:platform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   203: goto -41 -> 162
    //   206: astore_0
    //   207: ldc 2
    //   209: monitorexit
    //   210: aload_0
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramContext	android.content.Context
    //   12	105	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	162	180	com/tencent/mobileqq/triton/exception/TritonPlatformInitTwiceException
    //   3	13	206	finally
    //   17	162	206	finally
    //   162	166	206	finally
    //   170	175	206	finally
    //   181	203	206	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.TritonPlatformManager
 * JD-Core Version:    0.7.0.1
 */