package com.tencent.upload.task;

import com.tencent.upload.utils.FileUtils;
import java.io.File;

public class AtomFile
{
  private File mFile;
  private long mFileSize;
  private long mOffset;
  private boolean mSending;
  private String mSessionId;
  private int mSliceSize;
  private long mStartTime;
  
  public AtomFile(String paramString)
  {
    this.mFile = new File(paramString);
    this.mFileSize = FileUtils.getFileLength(paramString);
  }
  
  public File getFile()
  {
    try
    {
      File localFile = this.mFile;
      return localFile;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getOffset()
  {
    try
    {
      long l = this.mOffset;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getRemainSize()
  {
    try
    {
      long l1 = this.mFileSize;
      long l2 = this.mOffset;
      return l1 - l2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String getSessionId()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/tencent/upload/task/AtomFile:mSending	Z
    //   6: ifne +11 -> 17
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 49	com/tencent/upload/task/AtomFile:mSending	Z
    //   14: goto +7 -> 21
    //   17: aload_0
    //   18: invokevirtual 52	java/lang/Object:wait	()V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_0
    //   24: getfield 54	com/tencent/upload/task/AtomFile:mSessionId	Ljava/lang/String;
    //   27: areturn
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: astore_1
    //   34: goto -13 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	AtomFile
    //   28	4	1	localObject	Object
    //   33	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	14	28	finally
    //   17	21	28	finally
    //   21	23	28	finally
    //   29	31	28	finally
    //   17	21	33	java/lang/Exception
  }
  
  public int getSliceSize()
  {
    try
    {
      int i = this.mSliceSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getStartTime()
  {
    try
    {
      long l = this.mStartTime;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long reduce(long paramLong)
  {
    try
    {
      long l = this.mOffset;
      this.mOffset += paramLong;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public AtomFile setOffset(long paramLong)
  {
    try
    {
      this.mOffset = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public AtomFile setSessionId(String paramString)
  {
    try
    {
      this.mSessionId = paramString;
      notifyAll();
      return this;
    }
    finally {}
  }
  
  public AtomFile setSliceSize(int paramInt)
  {
    try
    {
      this.mSliceSize = paramInt;
      return this;
    }
    finally {}
  }
  
  public AtomFile setStartTime(long paramLong)
  {
    try
    {
      this.mStartTime = paramLong;
      return this;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.task.AtomFile
 * JD-Core Version:    0.7.0.1
 */