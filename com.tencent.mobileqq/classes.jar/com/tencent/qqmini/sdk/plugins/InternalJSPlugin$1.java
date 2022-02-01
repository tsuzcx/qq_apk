package com.tencent.qqmini.sdk.plugins;

import android.content.Context;

final class InternalJSPlugin$1
  implements Runnable
{
  InternalJSPlugin$1(Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 16	com/tencent/qqmini/sdk/plugins/InternalJSPlugin$1:val$context	Landroid/content/Context;
    //   8: invokestatic 35	com/tencent/qqmini/sdk/manager/LoginManager:getInstance	()Lcom/tencent/qqmini/sdk/manager/LoginManager;
    //   11: invokevirtual 39	com/tencent/qqmini/sdk/manager/LoginManager:getAccount	()Ljava/lang/String;
    //   14: invokestatic 45	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: aload_0
    //   18: getfield 18	com/tencent/qqmini/sdk/plugins/InternalJSPlugin$1:val$appId	Ljava/lang/String;
    //   21: invokestatic 51	com/tencent/qqmini/sdk/cache/Storage:open	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qqmini/sdk/cache/Storage;
    //   24: astore_3
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: astore_1
    //   29: aload_3
    //   30: aload_0
    //   31: getfield 20	com/tencent/qqmini/sdk/plugins/InternalJSPlugin$1:val$key	Ljava/lang/String;
    //   34: ldc 53
    //   36: aload_0
    //   37: getfield 22	com/tencent/qqmini/sdk/plugins/InternalJSPlugin$1:val$data	Ljava/lang/String;
    //   40: invokevirtual 57	com/tencent/qqmini/sdk/cache/Storage:writeSync	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_3
    //   45: ifnull +31 -> 76
    //   48: aload_3
    //   49: astore_1
    //   50: goto +22 -> 72
    //   53: astore_1
    //   54: goto +23 -> 77
    //   57: astore_3
    //   58: aload_1
    //   59: astore_2
    //   60: ldc 59
    //   62: ldc 61
    //   64: aload_3
    //   65: invokestatic 67	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 70	com/tencent/qqmini/sdk/cache/Storage:close	()V
    //   76: return
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 70	com/tencent/qqmini/sdk/cache/Storage:close	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	1
    //   1	49	1	localObject1	Object
    //   53	33	1	localObject2	Object
    //   3	79	2	localObject3	Object
    //   24	25	3	localStorage	com.tencent.qqmini.sdk.cache.Storage
    //   57	8	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   4	25	53	finally
    //   29	44	53	finally
    //   60	68	53	finally
    //   4	25	57	java/lang/Exception
    //   29	44	57	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.1
 * JD-Core Version:    0.7.0.1
 */