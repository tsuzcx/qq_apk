package com.tencent.superplayer.api;

import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo.Section;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.ArrayList;
import java.util.Arrays;

public class SuperPlayerVideoInfo
  implements Cloneable
{
  public static final int AUDIO_VOD_FORMAT_MP3 = 107;
  public static final int VIDEO_FORMAT_UNKNOWN = 204;
  public static final int VIDEO_LIVE_FORMAT_FLV = 202;
  public static final int VIDEO_LIVE_FORMAT_HLS = 201;
  public static final int VIDEO_LIVE_FORMAT_UNKNOWN = 203;
  public static final int VIDEO_SOURCE_DIRECT_URL = 3;
  public static final int VIDEO_SOURCE_TVIDEO = 1;
  public static final int VIDEO_VOD_FORMAT_HLS = 102;
  public static final int VIDEO_VOD_FORMAT_MP4 = 101;
  public static final int VIDEO_VOD_FORMAT_RTMP = 103;
  public static final int VIDEO_VOD_FORMAT_UNKNOWN = 104;
  private int mBusiPlatform;
  private ArrayList<String> mCookies = null;
  private String mFileId;
  private int mFormat;
  private boolean mIsDisableTVideoCache;
  private String mLocalSavePath;
  private String mPid;
  private String[] mPlayUrls;
  private String mRequestDefinition;
  private TPDownloadParamData mTPDownloadParamData = null;
  private ITPMediaAsset mTPMediaAssert;
  private String mTVideoLoginCookie;
  private TVideoNetInfo mTVideoNetInfo;
  private ArrayList<TVKVideoInfo.Section> mTVideoSectionList;
  private ArrayList<String> mUrlHostList = null;
  private String mVid;
  private long mVideoDurationMs;
  private int mVideoSource;
  private int mVideoType;
  
  protected SuperPlayerVideoInfo(int paramInt)
  {
    this.mVideoSource = paramInt;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = paramInt3;
    this.mVid = paramString;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = paramInt3;
    this.mVid = paramString1;
    this.mPid = paramString2;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = SuperPlayerSDKMgr.getPlatform();
    this.mVid = paramString;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = SuperPlayerSDKMgr.getPlatform();
    this.mVid = paramString1;
    this.mPid = paramString2;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (SuperPlayerVideoInfo)paramObject;
      if (this.mVideoSource != paramObject.mVideoSource) {
        return false;
      }
      if (this.mVideoType != paramObject.mVideoType) {
        return false;
      }
      if (this.mBusiPlatform != paramObject.mBusiPlatform) {
        return false;
      }
      Object localObject = this.mVid;
      if (localObject != null)
      {
        if (!((String)localObject).equals(paramObject.mVid)) {
          return false;
        }
      }
      else if (paramObject.mVid != null) {
        return false;
      }
      localObject = this.mPid;
      if (localObject != null)
      {
        if (!((String)localObject).equals(paramObject.mPid)) {
          return false;
        }
      }
      else if (paramObject.mPid != null) {
        return false;
      }
      localObject = this.mRequestDefinition;
      if (localObject != null)
      {
        if (!((String)localObject).equals(paramObject.mRequestDefinition)) {
          return false;
        }
      }
      else if (paramObject.mRequestDefinition != null) {
        return false;
      }
      localObject = this.mLocalSavePath;
      if (localObject != null)
      {
        if (!((String)localObject).equals(paramObject.mLocalSavePath)) {
          return false;
        }
      }
      else if (paramObject.mLocalSavePath != null) {
        return false;
      }
      localObject = this.mFileId;
      if (localObject != null)
      {
        if (!((String)localObject).equals(paramObject.mFileId)) {
          return false;
        }
      }
      else if (paramObject.mFileId != null) {
        return false;
      }
      localObject = this.mCookies;
      if (localObject != null) {
        return ((ArrayList)localObject).equals(paramObject.mCookies);
      }
      return paramObject.mCookies == null;
    }
    return false;
  }
  
  public int getBusiPlatform()
  {
    return this.mBusiPlatform;
  }
  
  public ArrayList<String> getCookie()
  {
    return this.mCookies;
  }
  
  public String getFileId()
  {
    return this.mFileId;
  }
  
  public int getFormat()
  {
    return this.mFormat;
  }
  
  public boolean getIsDisableTVideoCache()
  {
    return this.mIsDisableTVideoCache;
  }
  
  public String getLocalSavePath()
  {
    return this.mLocalSavePath;
  }
  
  public ITPMediaAsset getMediaAssert()
  {
    return this.mTPMediaAssert;
  }
  
  public String getPid()
  {
    return this.mPid;
  }
  
  public String getPlayUrl()
  {
    String[] arrayOfString = this.mPlayUrls;
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      return arrayOfString[0];
    }
    return null;
  }
  
  public String[] getPlayUrls()
  {
    return this.mPlayUrls;
  }
  
  public String getRequestDefinition()
  {
    String str2 = this.mRequestDefinition;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public TPDownloadParamData getTPDownloadParamData()
  {
    return this.mTPDownloadParamData;
  }
  
  public String getTVideoLoginCookie()
  {
    return this.mTVideoLoginCookie;
  }
  
  public TVideoNetInfo getTVideoNetInfo()
  {
    return this.mTVideoNetInfo;
  }
  
  public ArrayList<TVKVideoInfo.Section> getTVideoSectionList()
  {
    return this.mTVideoSectionList;
  }
  
  public ArrayList<String> getUrlHostList()
  {
    return this.mUrlHostList;
  }
  
  public String getVid()
  {
    return this.mVid;
  }
  
  public long getVideoDurationMs()
  {
    return this.mVideoDurationMs;
  }
  
  public int getVideoSource()
  {
    return this.mVideoSource;
  }
  
  public int getVideoType()
  {
    return this.mVideoType;
  }
  
  public int hashCode()
  {
    int i2 = this.mVideoSource;
    int i3 = this.mVideoType;
    int i4 = this.mBusiPlatform;
    Object localObject = this.mVid;
    int i1 = 0;
    int i;
    if (localObject != null) {
      i = ((String)localObject).hashCode();
    } else {
      i = 0;
    }
    localObject = this.mPid;
    int j;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = this.mRequestDefinition;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = this.mLocalSavePath;
    int m;
    if (localObject != null) {
      m = ((String)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = this.mFileId;
    int n;
    if (localObject != null) {
      n = ((String)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = this.mCookies;
    if (localObject != null) {
      i1 = ((ArrayList)localObject).hashCode();
    }
    return (((((((i2 * 31 + i3) * 31 + i4) * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public void setBusiPlatform(int paramInt)
  {
    this.mBusiPlatform = paramInt;
  }
  
  public void setCookies(ArrayList<String> paramArrayList)
  {
    this.mCookies = paramArrayList;
  }
  
  public void setFileId(String paramString)
  {
    this.mFileId = paramString;
  }
  
  public void setFormat(int paramInt)
  {
    this.mFormat = paramInt;
  }
  
  public void setIsDisableTVideoCache(boolean paramBoolean)
  {
    this.mIsDisableTVideoCache = paramBoolean;
  }
  
  public void setLocalSavePath(String paramString)
  {
    this.mLocalSavePath = paramString;
  }
  
  public void setMediaAssert(ITPMediaAsset paramITPMediaAsset)
  {
    this.mTPMediaAssert = paramITPMediaAsset;
  }
  
  public void setPlayUrl(String paramString)
  {
    this.mPlayUrls = new String[] { paramString };
  }
  
  void setPlayUrl(String[] paramArrayOfString)
  {
    this.mPlayUrls = paramArrayOfString;
  }
  
  public void setRequestDefinition(String paramString)
  {
    this.mRequestDefinition = paramString;
  }
  
  public void setTPDownloadParamData(TPDownloadParamData paramTPDownloadParamData)
  {
    this.mTPDownloadParamData = paramTPDownloadParamData;
  }
  
  public void setTVideoLoginCookie(String paramString)
  {
    this.mTVideoLoginCookie = paramString;
  }
  
  public void setTVideoNetInfo(TVideoNetInfo paramTVideoNetInfo)
  {
    this.mTVideoNetInfo = paramTVideoNetInfo;
  }
  
  public void setTVideoSectionList(ArrayList<TVKVideoInfo.Section> paramArrayList)
  {
    this.mTVideoSectionList = paramArrayList;
  }
  
  public void setUrlHostList(ArrayList<String> paramArrayList)
  {
    this.mUrlHostList = paramArrayList;
  }
  
  public void setVideoDurationMs(long paramLong)
  {
    this.mVideoDurationMs = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperPlayerVideoInfo[ mVideoSource:");
    String str;
    if (this.mVideoSource == 1) {
      str = "tvideo";
    } else {
      str = "directUrl";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", ");
    localStringBuilder.append("mVideoType:");
    localStringBuilder.append(this.mVideoType);
    localStringBuilder.append(", ");
    localStringBuilder.append("mBusiPlatform:");
    localStringBuilder.append(this.mBusiPlatform);
    localStringBuilder.append(", ");
    localStringBuilder.append("mVid:");
    localStringBuilder.append(this.mVid);
    localStringBuilder.append(", ");
    localStringBuilder.append("mPid:");
    localStringBuilder.append(this.mPid);
    localStringBuilder.append(", ");
    localStringBuilder.append("mPlayUrls:");
    localStringBuilder.append(Arrays.toString(this.mPlayUrls));
    localStringBuilder.append(", ");
    localStringBuilder.append("mRequestDefn:");
    localStringBuilder.append(this.mRequestDefinition);
    localStringBuilder.append(" ");
    localStringBuilder.append("mFormat:");
    localStringBuilder.append(this.mFormat);
    localStringBuilder.append(" ");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerVideoInfo
 * JD-Core Version:    0.7.0.1
 */