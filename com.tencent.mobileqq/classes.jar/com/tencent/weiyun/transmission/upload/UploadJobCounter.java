package com.tencent.weiyun.transmission.upload;

public class UploadJobCounter
  implements Cloneable
{
  int autoBackup = 0;
  public int compressing = 0;
  public int failed = 0;
  public int running = 0;
  public int suspend = 0;
  public int wait = 0;
  
  /* Error */
  public UploadJobCounter clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 37	java/lang/Object:clone	()Ljava/lang/Object;
    //   8: checkcast 2	com/tencent/weiyun/transmission/upload/UploadJobCounter
    //   11: astore_2
    //   12: aload_2
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    //   23: astore_2
    //   24: goto -10 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	UploadJobCounter
    //   3	14	1	localObject1	Object
    //   18	4	1	localObject2	Object
    //   11	2	2	localUploadJobCounter	UploadJobCounter
    //   23	1	2	localCloneNotSupportedException	java.lang.CloneNotSupportedException
    // Exception table:
    //   from	to	target	type
    //   4	12	18	finally
    //   4	12	23	java/lang/CloneNotSupportedException
  }
  
  public void reset()
  {
    try
    {
      this.autoBackup = 0;
      this.failed = 0;
      this.suspend = 0;
      this.running = 0;
      this.compressing = 0;
      this.wait = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public UploadJobCounter update(UploadJobContext paramUploadJobContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {}
    for (;;)
    {
      try
      {
        if (paramUploadJobContext.file().autoBackupFlag)
        {
          if (paramInt2 == 1)
          {
            this.autoBackup += 1;
            paramUploadJobContext = clone();
            return paramUploadJobContext;
          }
          if ((paramInt2 != 6) && (paramInt2 != 5)) {
            continue;
          }
          this.autoBackup -= 1;
          continue;
        }
        switch (paramInt1)
        {
        }
      }
      finally {}
      for (;;)
      {
        switch (paramInt2)
        {
        case 5: 
        default: 
          break;
        case 1: 
          this.wait += 1;
          break;
          this.wait -= 1;
          continue;
          this.compressing -= 1;
          continue;
          this.running -= 1;
          continue;
          this.suspend -= 1;
          continue;
          this.failed -= 1;
        }
      }
      this.compressing += 1;
      continue;
      this.running += 1;
      continue;
      this.suspend += 1;
      continue;
      this.failed += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobCounter
 * JD-Core Version:    0.7.0.1
 */