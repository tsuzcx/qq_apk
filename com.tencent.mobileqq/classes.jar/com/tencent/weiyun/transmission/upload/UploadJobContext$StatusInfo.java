package com.tencent.weiyun.transmission.upload;

public final class UploadJobContext$StatusInfo
  implements Cloneable
{
  public static final int STATE_COMPRESSING = 2;
  public static final int STATE_FAILED = 6;
  public static final int STATE_INIT = 0;
  public static final int STATE_RUNNING = 3;
  public static final int STATE_SUCCESS = 5;
  public static final int STATE_SUSPEND = 4;
  public static final int STATE_WAIT = 1;
  public long adSpeed = 0L;
  public boolean autoBackupFlag = false;
  public long currSize = 0L;
  public int errorCode = 0;
  public String errorMsg = "";
  public long exSpeed = 0L;
  public String fileId = "";
  public String filePath = "";
  public String fileVersion = "";
  public UploadJobContext jobContext;
  public long speed = 0L;
  public volatile int state = 0;
  public long totalSize = 0L;
  
  public boolean canRestart()
  {
    int i = this.state;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (this.state != 6)
      {
        bool1 = bool2;
        if (this.state != 4)
        {
          if (this.state == 1)
          {
            i = this.errorCode;
            bool1 = bool2;
            if (i == 1810003) {
              return bool1;
            }
            if (i == 1810004) {
              return true;
            }
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public boolean canRunning()
  {
    if (this.state == 1)
    {
      int i = this.errorCode;
      if ((i != 1810003) && (i != 1810004)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean canSuspend()
  {
    int i = this.state;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (this.state != 1)
      {
        bool1 = bool2;
        if (this.state != 2)
        {
          if (this.state == 3) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public StatusInfo clone()
  {
    try
    {
      StatusInfo localStatusInfo = (StatusInfo)super.clone();
      return localStatusInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public boolean isCompressing()
  {
    return this.state == 2;
  }
  
  public boolean waitingNet()
  {
    int i = this.state;
    boolean bool = true;
    if (i == 1)
    {
      i = this.errorCode;
      if (i == 1810003) {
        return bool;
      }
      if (i == 1810004) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public boolean waitingNetError(int paramInt)
  {
    return (paramInt == 1810003) || (paramInt == 1810004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo
 * JD-Core Version:    0.7.0.1
 */