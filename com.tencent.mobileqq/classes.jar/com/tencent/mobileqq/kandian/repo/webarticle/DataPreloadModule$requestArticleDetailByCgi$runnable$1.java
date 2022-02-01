package com.tencent.mobileqq.kandian.repo.webarticle;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class DataPreloadModule$requestArticleDetailByCgi$runnable$1
  implements Runnable
{
  DataPreloadModule$requestArticleDetailByCgi$runnable$1(String paramString) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule$requestArticleDetailByCgi$runnable$1:a	Ljava/lang/String;
    //   4: checkcast 36	java/lang/CharSequence
    //   7: invokeinterface 40 1 0
    //   12: ifne +8 -> 20
    //   15: iconst_1
    //   16: istore_1
    //   17: goto +5 -> 22
    //   20: iconst_0
    //   21: istore_1
    //   22: iload_1
    //   23: ifeq +12 -> 35
    //   26: ldc 42
    //   28: iconst_1
    //   29: ldc 44
    //   31: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: return
    //   35: new 52	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: ldc 55
    //   46: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: aload_0
    //   52: getfield 26	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule$requestArticleDetailByCgi$runnable$1:a	Ljava/lang/String;
    //   55: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 42
    //   61: iconst_1
    //   62: aload_2
    //   63: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: new 65	android/os/Bundle
    //   72: dup
    //   73: invokespecial 66	android/os/Bundle:<init>	()V
    //   76: astore_2
    //   77: aload_2
    //   78: ldc 68
    //   80: aload_0
    //   81: getfield 26	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule$requestArticleDetailByCgi$runnable$1:a	Ljava/lang/String;
    //   84: invokevirtual 72	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_2
    //   88: ldc 74
    //   90: iconst_1
    //   91: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   94: new 65	android/os/Bundle
    //   97: dup
    //   98: invokespecial 66	android/os/Bundle:<init>	()V
    //   101: astore_3
    //   102: aload_3
    //   103: invokestatic 84	com/tencent/biz/common/util/HttpUtil:addCookie	(Landroid/os/Bundle;)V
    //   106: getstatic 90	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:INSTANCE	Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;
    //   109: invokestatic 94	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:access$getRequestList$p	(Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;)Ljava/util/Set;
    //   112: aload_0
    //   113: getfield 26	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule$requestArticleDetailByCgi$runnable$1:a	Ljava/lang/String;
    //   116: invokeinterface 100 2 0
    //   121: pop
    //   122: invokestatic 106	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   125: checkcast 108	android/content/Context
    //   128: getstatic 90	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:INSTANCE	Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;
    //   131: ldc 110
    //   133: invokestatic 114	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:access$getUrlWithToken	(Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;Ljava/lang/String;)Ljava/lang/String;
    //   136: ldc 116
    //   138: aload_2
    //   139: aload_3
    //   140: invokestatic 120	com/tencent/biz/common/util/HttpUtil:openUrl	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   143: astore_2
    //   144: getstatic 90	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:INSTANCE	Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;
    //   147: aload_2
    //   148: invokestatic 124	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:access$handleArticleDetailCgiResponse	(Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;Ljava/lang/String;)V
    //   151: goto +74 -> 225
    //   154: astore_2
    //   155: goto +87 -> 242
    //   158: astore_2
    //   159: new 52	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   166: astore_3
    //   167: aload_3
    //   168: ldc 126
    //   170: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_3
    //   175: aload_2
    //   176: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 42
    //   182: iconst_1
    //   183: aload_3
    //   184: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: goto +35 -> 225
    //   193: astore_2
    //   194: new 52	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   201: astore_3
    //   202: aload_3
    //   203: ldc 126
    //   205: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_3
    //   210: aload_2
    //   211: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: ldc 42
    //   217: iconst_1
    //   218: aload_3
    //   219: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: getstatic 90	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:INSTANCE	Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;
    //   228: invokestatic 94	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:access$getRequestList$p	(Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;)Ljava/util/Set;
    //   231: aload_0
    //   232: getfield 26	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule$requestArticleDetailByCgi$runnable$1:a	Ljava/lang/String;
    //   235: invokeinterface 135 2 0
    //   240: pop
    //   241: return
    //   242: getstatic 90	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:INSTANCE	Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;
    //   245: invokestatic 94	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule:access$getRequestList$p	(Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;)Ljava/util/Set;
    //   248: aload_0
    //   249: getfield 26	com/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule$requestArticleDetailByCgi$runnable$1:a	Ljava/lang/String;
    //   252: invokeinterface 135 2 0
    //   257: pop
    //   258: aload_2
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	1
    //   16	7	1	i	int
    //   42	106	2	localObject1	Object
    //   154	1	2	localObject2	Object
    //   158	18	2	localError	java.lang.Error
    //   193	66	2	localException	java.lang.Exception
    //   101	118	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   106	151	154	finally
    //   159	190	154	finally
    //   194	225	154	finally
    //   106	151	158	java/lang/Error
    //   106	151	193	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.DataPreloadModule.requestArticleDetailByCgi.runnable.1
 * JD-Core Version:    0.7.0.1
 */