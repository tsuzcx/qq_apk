package com.tencent.qqlive.tvkplayer.playerwrapper.player;

import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

public class TVKMediaSource
{
  public static final int TYPE_FD = 2;
  public static final int TYPE_MEDIA_ASSET = 3;
  public static final int TYPE_URL = 1;
  public static final int TYPE_VID = 0;
  private String[] mBackupUrls;
  private String mCaptureUrl;
  private ParcelFileDescriptor mFileDescriptor;
  private Map<String, String> mHeaders;
  private int mType;
  private String mUrl;
  private TVKPlayerVideoInfo mVideoInfo;
  
  public TVKMediaSource()
  {
    this.mHeaders = new HashMap();
  }
  
  public TVKMediaSource(@NonNull ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mType = 2;
    this.mFileDescriptor = paramParcelFileDescriptor;
  }
  
  public TVKMediaSource(@NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    this.mVideoInfo = paramTVKPlayerVideoInfo;
    this.mType = 0;
    this.mHeaders = new HashMap(1);
  }
  
  public TVKMediaSource(@NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo, @Nullable Map<String, String> paramMap)
  {
    this.mVideoInfo = paramTVKPlayerVideoInfo;
    this.mType = 0;
    paramTVKPlayerVideoInfo = paramMap;
    if (paramMap == null) {
      paramTVKPlayerVideoInfo = new HashMap(1);
    }
    this.mHeaders = paramTVKPlayerVideoInfo;
  }
  
  public TVKMediaSource(@NonNull String paramString, @Nullable Map<String, String> paramMap)
  {
    this.mUrl = paramString;
    this.mType = 1;
    paramString = paramMap;
    if (paramMap == null) {
      paramString = new HashMap(1);
    }
    this.mHeaders = paramString;
  }
  
  public String[] backupUrls()
  {
    return this.mBackupUrls;
  }
  
  public String captureUrl()
  {
    return this.mCaptureUrl;
  }
  
  public ParcelFileDescriptor fileDescriptor()
  {
    return this.mFileDescriptor;
  }
  
  public Map<String, String> httpHeaders()
  {
    return this.mHeaders;
  }
  
  public boolean isValid()
  {
    int i = this.mType;
    boolean bool2 = false;
    if ((i == 0) && (this.mVideoInfo != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && ((this.mType != 1) || (TextUtils.isEmpty(this.mUrl)))) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool1;
    if (i == 0)
    {
      bool1 = bool2;
      if (this.mType == 2)
      {
        bool1 = bool2;
        if (this.mFileDescriptor == null) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void setBackupUrls(String[] paramArrayOfString)
  {
    this.mBackupUrls = paramArrayOfString;
  }
  
  public void setCaptureUrl(String paramString)
  {
    this.mCaptureUrl = paramString;
  }
  
  public void setFileDescriptor(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mUrl = null;
    this.mType = 2;
    this.mHeaders.clear();
    this.mFileDescriptor = paramParcelFileDescriptor;
  }
  
  public void setHttpHeaders(Map<String, String> paramMap)
  {
    this.mHeaders.clear();
    if (paramMap != null) {
      this.mHeaders.putAll(paramMap);
    }
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
    this.mType = 1;
    this.mFileDescriptor = null;
  }
  
  public void setVideoInfo(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    this.mUrl = null;
    this.mType = 0;
    this.mHeaders.clear();
    this.mFileDescriptor = null;
    this.mVideoInfo = paramTVKPlayerVideoInfo;
  }
  
  public int type()
  {
    return this.mType;
  }
  
  public String url()
  {
    return this.mUrl;
  }
  
  public TVKPlayerVideoInfo videoInfo()
  {
    return this.mVideoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKMediaSource
 * JD-Core Version:    0.7.0.1
 */