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
    return (this.state == 0) || (this.state == 6) || (this.state == 4) || ((this.state == 1) && ((this.errorCode == 1810003) || (this.errorCode == 1810004)));
  }
  
  public boolean canRunning()
  {
    return (this.state == 1) && (this.errorCode != 1810003) && (this.errorCode != 1810004);
  }
  
  public boolean canSuspend()
  {
    return (this.state == 0) || (this.state == 1) || (this.state == 2) || (this.state == 3);
  }
  
  public StatusInfo clone()
  {
    try
    {
      StatusInfo localStatusInfo = (StatusInfo)super.clone();
      return localStatusInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public boolean isCompressing()
  {
    return this.state == 2;
  }
  
  public boolean waitingNet()
  {
    return (this.state == 1) && ((this.errorCode == 1810003) || (this.errorCode == 1810004));
  }
  
  public boolean waitingNetError(int paramInt)
  {
    return (paramInt == 1810003) || (paramInt == 1810004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo
 * JD-Core Version:    0.7.0.1
 */