package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import java.io.Serializable;

public class TVKLiveVideoInfo
  extends TVKNetVideoInfo
  implements Serializable
{
  public static final int ERR_CGI = 10001;
  public static final int ERR_NETWORK = 10000;
  public static final int SHOT_DIRECTION_DOWN = 2;
  public static final int SHOT_DIRECTION_UP = 1;
  private static final long serialVersionUID = -1L;
  private int mAcode;
  private String[] mBackPlayUrl;
  private int mBufferLoadingTime;
  private int mCdnId;
  private int mErrModule;
  private boolean mGetDlnaUrl = false;
  private boolean mGetPreviewInfo = false;
  @TVKLiveVideoInfo.ShotDirection
  private int mLensDirection;
  private int mLive360;
  private String mOriginalPlayUrl = "";
  private String mPlayUrl = null;
  private String mProgramId;
  private int mProxyRequestId = 0;
  private String mRand = "";
  private int mRestPrePlayCount;
  private int mSecondBufferTime;
  private int mSecondMaxBufferTime;
  private int mSecondMinBufferTime;
  private long mServerTime;
  private int mStream;
  private String mTargetId;
  private int mVcode;
  private String mXml;
  
  public int getAcode()
  {
    return this.mAcode;
  }
  
  public String[] getBackPlayUrl()
  {
    return this.mBackPlayUrl;
  }
  
  public int getBufferLoadingTime()
  {
    return this.mBufferLoadingTime;
  }
  
  public int getCdnId()
  {
    return this.mCdnId;
  }
  
  public int getErrModule()
  {
    return this.mErrModule;
  }
  
  public int getLensDirection()
  {
    return this.mLensDirection;
  }
  
  public int getLive360()
  {
    return this.mLive360;
  }
  
  public String getOriginalPlayUrl()
  {
    return this.mOriginalPlayUrl;
  }
  
  public String getPlayUrl()
  {
    if (TextUtils.isEmpty(this.mPlayUrl)) {
      return "";
    }
    return this.mPlayUrl;
  }
  
  public String getProgId()
  {
    return this.mProgramId;
  }
  
  public int getProxyRequestId()
  {
    return this.mProxyRequestId;
  }
  
  public String getRand()
  {
    return this.mRand;
  }
  
  public int getSecondBufferTime()
  {
    return this.mSecondBufferTime;
  }
  
  public int getSecondMaxBufferTime()
  {
    return this.mSecondMaxBufferTime;
  }
  
  public int getSecondMinBufferTime()
  {
    return this.mSecondMinBufferTime;
  }
  
  public long getServerTime()
  {
    return this.mServerTime;
  }
  
  public int getStream()
  {
    return this.mStream;
  }
  
  public String getTargetId()
  {
    return this.mTargetId;
  }
  
  public int getVcode()
  {
    return this.mVcode;
  }
  
  public String getXml()
  {
    return this.mXml;
  }
  
  public boolean isGetDlnaUrl()
  {
    return this.mGetDlnaUrl;
  }
  
  public boolean isGetPreviewInfo()
  {
    return this.mGetPreviewInfo;
  }
  
  public void setAcode(int paramInt)
  {
    this.mAcode = paramInt;
  }
  
  public void setBackPlayUrl(String[] paramArrayOfString)
  {
    this.mBackPlayUrl = paramArrayOfString;
  }
  
  public void setBufferLoadingTime(int paramInt)
  {
    this.mBufferLoadingTime = paramInt;
  }
  
  public void setCdnId(int paramInt)
  {
    this.mCdnId = paramInt;
  }
  
  public void setErrModule(int paramInt)
  {
    this.mErrModule = paramInt;
  }
  
  public void setGetDlnaUrl(boolean paramBoolean)
  {
    this.mGetDlnaUrl = paramBoolean;
  }
  
  public void setGetPreviewInfo(boolean paramBoolean)
  {
    this.mGetPreviewInfo = paramBoolean;
  }
  
  public void setLensDirection(@TVKLiveVideoInfo.ShotDirection int paramInt)
  {
    this.mLensDirection = paramInt;
  }
  
  public void setLive360(int paramInt)
  {
    this.mLive360 = paramInt;
  }
  
  public void setOriginalPlayUrl(String paramString)
  {
    this.mOriginalPlayUrl = paramString;
  }
  
  public void setPlayUrl(String paramString)
  {
    this.mPlayUrl = paramString;
  }
  
  public void setProgId(String paramString)
  {
    this.mProgramId = paramString;
  }
  
  public void setProxyRequestId(int paramInt)
  {
    this.mProxyRequestId = paramInt;
  }
  
  public void setRand(String paramString)
  {
    this.mRand = paramString;
  }
  
  public void setSecondBufferTime(int paramInt)
  {
    this.mSecondBufferTime = paramInt;
  }
  
  public void setSecondMaxBufferTime(int paramInt)
  {
    this.mSecondMaxBufferTime = paramInt;
  }
  
  public void setSecondMinBufferTime(int paramInt)
  {
    this.mSecondMinBufferTime = paramInt;
  }
  
  public void setServerTime(long paramLong)
  {
    this.mServerTime = paramLong;
  }
  
  public void setStream(int paramInt)
  {
    this.mStream = paramInt;
  }
  
  public void setTargetId(String paramString)
  {
    this.mTargetId = paramString;
  }
  
  public void setVcode(int paramInt)
  {
    this.mVcode = paramInt;
  }
  
  public void setXml(String paramString)
  {
    this.mXml = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo
 * JD-Core Version:    0.7.0.1
 */