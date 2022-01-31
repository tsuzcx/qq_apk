package com.tencent.smtt.sdk;

import android.util.Log;
import com.tencent.smtt.utils.TbsLog;

public class TbsLogReport$TbsLogInfo
  implements Cloneable
{
  private String mApn;
  private String mCheckErrorDetail;
  private long mDownConsumeTime;
  private int mDownFinalFlag;
  private String mDownUrl;
  private int mDownloadCancel;
  private long mDownloadSize;
  int mErrorCode;
  private long mEventTime;
  private String mFailDetail;
  private int mHttpCode;
  private int mNetworkChange;
  private int mNetworkType;
  private int mPatchUpdateFlag;
  private long mPkgSize;
  private String mResolveIp;
  private int mUnpkgFlag;
  
  private TbsLogReport$TbsLogInfo()
  {
    resetArgs();
  }
  
  protected Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
  
  public int getDownFinalFlag()
  {
    return this.mDownFinalFlag;
  }
  
  public void resetArgs()
  {
    this.mEventTime = 0L;
    this.mDownUrl = null;
    this.mResolveIp = null;
    this.mHttpCode = 0;
    this.mPatchUpdateFlag = 0;
    this.mDownloadCancel = 0;
    this.mUnpkgFlag = 2;
    this.mApn = "unknown";
    this.mNetworkType = 0;
    this.mDownFinalFlag = 2;
    this.mPkgSize = 0L;
    this.mDownConsumeTime = 0L;
    this.mNetworkChange = 1;
    this.mErrorCode = 0;
    this.mCheckErrorDetail = null;
    this.mFailDetail = null;
    this.mDownloadSize = 0L;
  }
  
  public void setApn(String paramString)
  {
    this.mApn = paramString;
  }
  
  public void setCheckErrorDetail(String paramString)
  {
    setErrorCode(108);
    this.mCheckErrorDetail = paramString;
  }
  
  public void setDownConsumeTime(long paramLong)
  {
    this.mDownConsumeTime += paramLong;
  }
  
  public void setDownFinalFlag(int paramInt)
  {
    this.mDownFinalFlag = paramInt;
  }
  
  public void setDownloadCancel(int paramInt)
  {
    this.mDownloadCancel = paramInt;
  }
  
  public void setDownloadSize(long paramLong)
  {
    this.mDownloadSize += paramLong;
  }
  
  public void setDownloadUrl(String paramString)
  {
    if (this.mDownUrl == null)
    {
      this.mDownUrl = paramString;
      return;
    }
    this.mDownUrl = (this.mDownUrl + ";" + paramString);
  }
  
  public void setErrorCode(int paramInt)
  {
    if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400)) {
      TbsLog.i("TbsDownload", "error occured, errorCode:" + paramInt, true);
    }
    if (paramInt == 111) {
      TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
    }
    this.mErrorCode = paramInt;
  }
  
  public void setEventTime(long paramLong)
  {
    this.mEventTime = paramLong;
  }
  
  public void setFailDetail(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = paramString;
    if (paramString.length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    this.mFailDetail = str;
  }
  
  public void setFailDetail(Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      this.mFailDetail = "";
      return;
    }
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    this.mFailDetail = paramThrowable;
  }
  
  public void setHttpCode(int paramInt)
  {
    this.mHttpCode = paramInt;
  }
  
  public void setNetworkChange(int paramInt)
  {
    this.mNetworkChange = paramInt;
  }
  
  public void setNetworkType(int paramInt)
  {
    this.mNetworkType = paramInt;
  }
  
  public void setPatchUpdateFlag(int paramInt)
  {
    this.mPatchUpdateFlag = paramInt;
  }
  
  public void setPkgSize(long paramLong)
  {
    this.mPkgSize = paramLong;
  }
  
  public void setResolveIp(String paramString)
  {
    this.mResolveIp = paramString;
  }
  
  public void setUnpkgFlag(int paramInt)
  {
    this.mUnpkgFlag = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo
 * JD-Core Version:    0.7.0.1
 */