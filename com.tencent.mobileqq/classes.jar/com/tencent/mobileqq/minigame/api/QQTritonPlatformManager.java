package com.tencent.mobileqq.minigame.api;

import android.os.Build;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.TritonPlatform;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/api/QQTritonPlatformManager;", "", "()V", "OPENGL_ES3_BLACK_LIST", "", "", "[Ljava/lang/String;", "TAG", "platform", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "enableOpengles3", "", "getTritonPlatform", "context", "Landroid/content/Context;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQTritonPlatformManager
{
  public static final QQTritonPlatformManager INSTANCE = new QQTritonPlatformManager();
  private static final String[] OPENGL_ES3_BLACK_LIST = { "vivo Xplay5A", "vivo X7", "vivo X7Plus", "OPPO R9 Plusm A" };
  private static final String TAG = "QQTritonPlatformManager";
  private static TritonPlatform platform;
  
  private final boolean enableOpengles3()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = OPENGL_ES3_BLACK_LIST;
    int k = arrayOfString.length;
    int i = 0;
    int j = 1;
    while (i < k)
    {
      if (StringsKt.equals(str, arrayOfString[i], true)) {
        j = 0;
      }
      i += 1;
    }
    boolean bool1 = bool2;
    if (GameWnsUtils.enableOpengles3())
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  @kotlin.jvm.JvmStatic
  @org.jetbrains.annotations.NotNull
  public static final TritonPlatform getTritonPlatform(@org.jetbrains.annotations.NotNull android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 87
    //   6: invokestatic 91	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: getstatic 56	com/tencent/mobileqq/minigame/api/QQTritonPlatformManager:platform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +131 -> 145
    //   17: new 93	com/tencent/mobileqq/triton/TritonPlatform$Builder
    //   20: dup
    //   21: invokespecial 94	com/tencent/mobileqq/triton/TritonPlatform$Builder:<init>	()V
    //   24: aload_0
    //   25: invokevirtual 97	com/tencent/mobileqq/triton/TritonPlatform$Builder:context	(Landroid/content/Context;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   28: new 99	com/tencent/mobileqq/triton/model/DebugConfig
    //   31: dup
    //   32: iconst_0
    //   33: invokestatic 103	com/tencent/mobileqq/minigame/utils/GameWnsUtils:getGamePresentDetectInterval	()I
    //   36: i2l
    //   37: invokestatic 106	com/tencent/mobileqq/minigame/utils/GameWnsUtils:getNoPresentDurationLimit	()I
    //   40: i2l
    //   41: invokestatic 109	com/tencent/mobileqq/minigame/utils/GameWnsUtils:getFrameNoChangeLimit	()I
    //   44: invokestatic 112	com/tencent/mobileqq/minigame/utils/GameWnsUtils:getNoPresentTouchLimit	()I
    //   47: invokespecial 115	com/tencent/mobileqq/triton/model/DebugConfig:<init>	(ZJJII)V
    //   50: invokevirtual 119	com/tencent/mobileqq/triton/TritonPlatform$Builder:debugConfig	(Lcom/tencent/mobileqq/triton/model/DebugConfig;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   53: invokestatic 122	com/tencent/mobileqq/minigame/utils/GameWnsUtils:isCodeCacheEnable	()Z
    //   56: invokevirtual 126	com/tencent/mobileqq/triton/TritonPlatform$Builder:enableCodeCache	(Z)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   59: getstatic 38	com/tencent/mobileqq/minigame/api/QQTritonPlatformManager:INSTANCE	Lcom/tencent/mobileqq/minigame/api/QQTritonPlatformManager;
    //   62: invokespecial 127	com/tencent/mobileqq/minigame/api/QQTritonPlatformManager:enableOpengles3	()Z
    //   65: invokevirtual 130	com/tencent/mobileqq/triton/TritonPlatform$Builder:enableOpenGlEs3	(Z)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   68: astore_0
    //   69: invokestatic 136	com/tencent/mobileqq/minigame/manager/GameEnvManager:getEnginePackage	()Lcom/tencent/mobileqq/minigame/api/QQMiniEnginePackage;
    //   72: astore_1
    //   73: aload_1
    //   74: ldc 138
    //   76: invokestatic 141	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   79: aload_0
    //   80: aload_1
    //   81: checkcast 143	com/tencent/mobileqq/triton/filesystem/EnginePackage
    //   84: invokevirtual 147	com/tencent/mobileqq/triton/TritonPlatform$Builder:enginePackage	(Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   87: astore_0
    //   88: invokestatic 153	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   91: astore_1
    //   92: aload_1
    //   93: ldc 155
    //   95: invokestatic 141	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   98: aload_0
    //   99: aload_1
    //   100: checkcast 157	com/tencent/mobileqq/triton/utils/LogDelegate
    //   103: invokevirtual 161	com/tencent/mobileqq/triton/TritonPlatform$Builder:logger	(Lcom/tencent/mobileqq/triton/utils/LogDelegate;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   106: getstatic 166	com/tencent/mobileqq/minigame/api/QQMiniScriptPluginFactory:INSTANCE	Lcom/tencent/mobileqq/minigame/api/QQMiniScriptPluginFactory;
    //   109: checkcast 168	com/tencent/mobileqq/triton/script/ScriptPluginFactory
    //   112: invokevirtual 172	com/tencent/mobileqq/triton/TritonPlatform$Builder:scriptPluginFactory	(Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   115: invokestatic 178	com/tencent/mobileqq/mini/appbrand/utils/ThreadPools:getMainThreadExecutor	()Ljava/util/concurrent/Executor;
    //   118: invokevirtual 182	com/tencent/mobileqq/triton/TritonPlatform$Builder:mainThreadExecutor	(Ljava/util/concurrent/Executor;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   121: invokestatic 186	com/tencent/mobileqq/mini/appbrand/utils/ThreadPools:getComputationThreadPool	()Ljava/util/concurrent/ExecutorService;
    //   124: checkcast 188	java/util/concurrent/Executor
    //   127: invokevirtual 191	com/tencent/mobileqq/triton/TritonPlatform$Builder:workerExecutor	(Ljava/util/concurrent/Executor;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   130: getstatic 196	com/tencent/mobileqq/minigame/api/QQMiniDownloader:INSTANCE	Lcom/tencent/mobileqq/minigame/api/QQMiniDownloader;
    //   133: checkcast 198	com/tencent/mobileqq/triton/utils/Downloader
    //   136: invokevirtual 202	com/tencent/mobileqq/triton/TritonPlatform$Builder:downloader	(Lcom/tencent/mobileqq/triton/utils/Downloader;)Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;
    //   139: invokevirtual 206	com/tencent/mobileqq/triton/TritonPlatform$Builder:build	()Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   142: putstatic 56	com/tencent/mobileqq/minigame/api/QQTritonPlatformManager:platform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   145: getstatic 56	com/tencent/mobileqq/minigame/api/QQTritonPlatformManager:platform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   148: astore_0
    //   149: aload_0
    //   150: ifnonnull +8 -> 158
    //   153: ldc 57
    //   155: invokestatic 63	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   158: ldc 2
    //   160: monitorexit
    //   161: aload_0
    //   162: areturn
    //   163: astore_0
    //   164: ldc 32
    //   166: iconst_1
    //   167: ldc 208
    //   169: aload_0
    //   170: checkcast 210	java/lang/Throwable
    //   173: invokestatic 216	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_0
    //   177: invokevirtual 219	com/tencent/mobileqq/triton/exception/TritonPlatformInitTwiceException:getPreviouslyBuiltPlatform	()Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   180: putstatic 56	com/tencent/mobileqq/minigame/api/QQTritonPlatformManager:platform	Lcom/tencent/mobileqq/triton/TritonPlatform;
    //   183: goto -38 -> 145
    //   186: astore_0
    //   187: ldc 2
    //   189: monitorexit
    //   190: aload_0
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	android.content.Context
    //   12	88	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	145	163	com/tencent/mobileqq/triton/exception/TritonPlatformInitTwiceException
    //   3	13	186	finally
    //   17	145	186	finally
    //   145	149	186	finally
    //   153	158	186	finally
    //   164	183	186	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQTritonPlatformManager
 * JD-Core Version:    0.7.0.1
 */