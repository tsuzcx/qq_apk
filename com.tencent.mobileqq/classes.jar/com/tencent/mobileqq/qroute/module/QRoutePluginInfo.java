package com.tencent.mobileqq.qroute.module;

public class QRoutePluginInfo
{
  private long mCostApk;
  private long mCostDex2Oat;
  private long mCostLib;
  private long mDownloadDuration;
  private String mID = "";
  private int mInstallCode;
  private long mLength = 0L;
  private String mMD5 = "";
  private String mName = "";
  private String[] mProcesses = new String[0];
  private int mStartDownloadNetType;
  private int mState;
  private int mSubType;
  private String mURL = "";
  private String mVersion = "";
  
  public long getCostApk()
  {
    return this.mCostApk;
  }
  
  public long getCostDex2Oat()
  {
    return this.mCostDex2Oat;
  }
  
  public long getCostLib()
  {
    return this.mCostLib;
  }
  
  public long getDownloadDuration()
  {
    return this.mDownloadDuration;
  }
  
  public String getID()
  {
    return this.mID;
  }
  
  public int getInstallCode()
  {
    return this.mInstallCode;
  }
  
  public long getLength()
  {
    return this.mLength;
  }
  
  public String getMD5()
  {
    return this.mMD5;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String[] getProcesses()
  {
    return this.mProcesses;
  }
  
  public int getStartDownloadNetType()
  {
    return this.mStartDownloadNetType;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getSubType()
  {
    return this.mSubType;
  }
  
  public String getURL()
  {
    return this.mURL;
  }
  
  public String getVersion()
  {
    return this.mVersion;
  }
  
  public void setCostApk(long paramLong)
  {
    this.mCostApk = paramLong;
  }
  
  public void setCostDex2Oat(long paramLong)
  {
    this.mCostDex2Oat = paramLong;
  }
  
  public void setCostLib(long paramLong)
  {
    this.mCostLib = paramLong;
  }
  
  public void setDownloadDuration(long paramLong)
  {
    this.mDownloadDuration = paramLong;
  }
  
  public void setID(String paramString)
  {
    this.mID = paramString;
  }
  
  public void setInstallCode(int paramInt)
  {
    this.mInstallCode = paramInt;
  }
  
  public void setLength(long paramLong)
  {
    this.mLength = paramLong;
  }
  
  public void setMD5(String paramString)
  {
    this.mMD5 = paramString;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setProcesses(String[] paramArrayOfString)
  {
    this.mProcesses = paramArrayOfString;
  }
  
  public void setStartDownloadNetType(int paramInt)
  {
    this.mStartDownloadNetType = paramInt;
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public void setSubType(int paramInt)
  {
    this.mSubType = paramInt;
  }
  
  public void setURL(String paramString)
  {
    this.mURL = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.mVersion = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.QRoutePluginInfo
 * JD-Core Version:    0.7.0.1
 */