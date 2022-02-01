package com.tencent.mobileqq.weiyun.sdk.download;

import com.tencent.mobileqq.weiyun.model.DownloadJobContext;

public class DownloadJobCounter
  implements Cloneable
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  
  /* Error */
  public DownloadJobCounter a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 31	java/lang/Object:clone	()Ljava/lang/Object;
    //   8: checkcast 2	com/tencent/mobileqq/weiyun/sdk/download/DownloadJobCounter
    //   11: astore_2
    //   12: aload_2
    //   13: astore_1
    //   14: goto +8 -> 22
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: astore_2
    //   27: goto -5 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	DownloadJobCounter
    //   3	11	1	localObject	Object
    //   17	8	1	localDownloadJobCounter1	DownloadJobCounter
    //   11	2	2	localDownloadJobCounter2	DownloadJobCounter
    //   26	1	2	localCloneNotSupportedException	java.lang.CloneNotSupportedException
    // Exception table:
    //   from	to	target	type
    //   4	12	17	finally
    //   4	12	26	java/lang/CloneNotSupportedException
  }
  
  public DownloadJobCounter a(DownloadJobContext paramDownloadJobContext, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == paramInt2) || ((paramInt1 == 1) || ((paramInt1 == 2) || ((paramInt1 == 3) || (paramInt1 == 5)))))
    {
      label95:
      label108:
      label121:
      try
      {
        this.d -= 1;
      }
      finally {}
      this.c -= 1;
      break label145;
      this.b -= 1;
      break label145;
      this.a -= 1;
      break label145;
      this.d += 1;
      break label131;
      this.c += 1;
      break label131;
      this.b += 1;
      break label131;
      this.a += 1;
    }
    for (;;)
    {
      label131:
      paramDownloadJobContext = a();
      return paramDownloadJobContext;
      label145:
      if (paramInt2 == 1) {
        break label121;
      }
      if (paramInt2 == 2) {
        break label108;
      }
      if (paramInt2 == 3) {
        break label95;
      }
      if (paramInt2 == 5) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.DownloadJobCounter
 * JD-Core Version:    0.7.0.1
 */