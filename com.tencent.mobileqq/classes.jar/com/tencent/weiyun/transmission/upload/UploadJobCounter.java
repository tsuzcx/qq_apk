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
    //   2: aload_0
    //   3: invokespecial 37	java/lang/Object:clone	()Ljava/lang/Object;
    //   6: checkcast 2	com/tencent/weiyun/transmission/upload/UploadJobCounter
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aconst_null
    //   16: astore_1
    //   17: goto -7 -> 10
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	UploadJobCounter
    //   9	4	1	localUploadJobCounter	UploadJobCounter
    //   14	1	1	localCloneNotSupportedException	java.lang.CloneNotSupportedException
    //   16	1	1	localObject1	Object
    //   20	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	14	java/lang/CloneNotSupportedException
    //   2	10	20	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobCounter
 * JD-Core Version:    0.7.0.1
 */