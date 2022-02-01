package com.tencent.mobileqq.mini.entry;

import android.content.Context;

final class MiniAppUtils$2
  implements Runnable
{
  MiniAppUtils$2(Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 16	com/tencent/mobileqq/mini/entry/MiniAppUtils$2:val$context	Landroid/content/Context;
    //   8: invokestatic 35	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   11: invokevirtual 39	com/tencent/open/adapter/CommonDataAdapter:c	()J
    //   14: invokestatic 45	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   17: aload_0
    //   18: getfield 18	com/tencent/mobileqq/mini/entry/MiniAppUtils$2:val$appId	Ljava/lang/String;
    //   21: invokestatic 51	com/tencent/mobileqq/mini/cache/Storage:open	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/mini/cache/Storage;
    //   24: astore_3
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: astore_1
    //   29: aload_3
    //   30: aload_0
    //   31: getfield 20	com/tencent/mobileqq/mini/entry/MiniAppUtils$2:val$key	Ljava/lang/String;
    //   34: ldc 53
    //   36: aload_0
    //   37: getfield 22	com/tencent/mobileqq/mini/entry/MiniAppUtils$2:val$data	Ljava/lang/String;
    //   40: invokevirtual 57	com/tencent/mobileqq/mini/cache/Storage:writeSync	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_3
    //   45: ifnull +32 -> 77
    //   48: aload_3
    //   49: astore_1
    //   50: goto +23 -> 73
    //   53: astore_1
    //   54: goto +24 -> 78
    //   57: astore_3
    //   58: aload_1
    //   59: astore_2
    //   60: ldc 59
    //   62: iconst_1
    //   63: ldc 61
    //   65: aload_3
    //   66: invokestatic 67	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 70	com/tencent/mobileqq/mini/cache/Storage:close	()V
    //   77: return
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 70	com/tencent/mobileqq/mini/cache/Storage:close	()V
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	2
    //   1	49	1	localObject1	Object
    //   53	34	1	localObject2	Object
    //   3	80	2	localObject3	Object
    //   24	25	3	localStorage	com.tencent.mobileqq.mini.cache.Storage
    //   57	9	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   4	25	53	finally
    //   29	44	53	finally
    //   60	69	53	finally
    //   4	25	57	java/lang/Exception
    //   29	44	57	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.2
 * JD-Core Version:    0.7.0.1
 */