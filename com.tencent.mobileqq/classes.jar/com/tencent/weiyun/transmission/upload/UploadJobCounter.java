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
    //   0	30	0	this	UploadJobCounter
    //   3	11	1	localObject	Object
    //   17	8	1	localUploadJobCounter1	UploadJobCounter
    //   11	2	2	localUploadJobCounter2	UploadJobCounter
    //   26	1	2	localCloneNotSupportedException	java.lang.CloneNotSupportedException
    // Exception table:
    //   from	to	target	type
    //   4	12	17	finally
    //   4	12	26	java/lang/CloneNotSupportedException
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
        if (!paramUploadJobContext.file().autoBackupFlag) {
          break label203;
        }
        if (paramInt2 == 1)
        {
          this.autoBackup += 1;
          continue;
          this.autoBackup -= 1;
          continue;
          this.failed -= 1;
          break label229;
          this.suspend -= 1;
          break label229;
          this.running -= 1;
          break label229;
          this.compressing -= 1;
          break label229;
          this.wait -= 1;
          break label229;
          this.failed += 1;
          continue;
          this.suspend += 1;
          continue;
          this.running += 1;
          continue;
          this.compressing += 1;
          continue;
          this.wait += 1;
          paramUploadJobContext = clone();
          return paramUploadJobContext;
        }
      }
      finally {}
      if (paramInt2 != 6) {
        if (paramInt2 == 5)
        {
          continue;
          label203:
          if (paramInt1 != 1) {
            if (paramInt1 != 2) {
              if (paramInt1 != 3) {
                if (paramInt1 != 4) {
                  if (paramInt1 != 6) {
                    label229:
                    if (paramInt2 != 1) {
                      if (paramInt2 != 2) {
                        if (paramInt2 != 3) {
                          if (paramInt2 != 4) {
                            if (paramInt2 == 6) {}
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobCounter
 * JD-Core Version:    0.7.0.1
 */