package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import java.io.Serializable;

public class TVKLiveVideoInfo
  extends TVKNetVideoInfo
  implements Serializable
{
  public static final int ERR_CGI = 10001;
  public static final int ERR_NETWORK = 10000;
  private static final long serialVersionUID = -1L;
  private int aCode;
  private int live360;
  private String[] mBackPlayUrl;
  private int mBufferLoadingTime;
  private int mCdnId;
  private int mErrModule;
  private boolean mGetDlnaUrl = false;
  private boolean mGetPreviewInfo = false;
  private TVKLiveVideoInfo.SHOT_DIRECTION mLensDirection;
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
  private String mXml;
  private int vCode;
  
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
  
  public TVKLiveVideoInfo.SHOT_DIRECTION getLens_direction()
  {
    return this.mLensDirection;
  }
  
  public int getLive360()
  {
    return this.live360;
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
  
  public String getXml()
  {
    return this.mXml;
  }
  
  public int getaCode()
  {
    return this.aCode;
  }
  
  public int getvCode()
  {
    return this.vCode;
  }
  
  public boolean isGetDlnaUrl()
  {
    return this.mGetDlnaUrl;
  }
  
  public boolean isGetPreviewInfo()
  {
    return this.mGetPreviewInfo;
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
  
  public void setLens_direction(TVKLiveVideoInfo.SHOT_DIRECTION paramSHOT_DIRECTION)
  {
    this.mLensDirection = paramSHOT_DIRECTION;
  }
  
  public void setLive360(int paramInt)
  {
    this.live360 = paramInt;
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
  
  public void setXml(String paramString)
  {
    this.mXml = paramString;
  }
  
  public void setaCode(int paramInt)
  {
    this.aCode = paramInt;
  }
  
  public void setvCode(int paramInt)
  {
    this.vCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo
 * JD-Core Version:    0.7.0.1
 */