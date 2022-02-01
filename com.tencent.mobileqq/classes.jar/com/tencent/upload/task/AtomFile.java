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
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 49	com/tencent/upload/task/AtomFile:mSending	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: getfield 51	com/tencent/upload/task/AtomFile:mSessionId	Ljava/lang/String;
    //   20: areturn
    //   21: aload_0
    //   22: invokevirtual 54	java/lang/Object:wait	()V
    //   25: goto -11 -> 14
    //   28: astore_1
    //   29: goto -15 -> 14
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	AtomFile
    //   28	1	1	localException	java.lang.Exception
    //   32	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	25	28	java/lang/Exception
    //   2	14	32	finally
    //   14	16	32	finally
    //   21	25	32	finally
    //   33	35	32	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.task.AtomFile
 * JD-Core Version:    0.7.0.1
 */