package com.tencent.qqlive.tvkplayer.vinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKMediaSource;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

public class TVKPlaybackParam
{
  private float mAudioGainRatio;
  private Context mContext;
  private String mDefinition;
  private String mFlowId;
  private boolean mIsLoopback;
  private long mLiveBackPlayTimeSec;
  private TVKMediaSource mMediaSource;
  private boolean mOutputMute;
  private long mSkipEndPosition;
  private float mSpeedRatio;
  private long mStartPosition;
  private TVKUserInfo mUserInfo;
  private TVKPlayerVideoInfo mVideoInfo;
  
  public TVKPlaybackParam()
  {
    initDefaults();
  }
  
  private void initDefaults()
  {
    this.mUserInfo = null;
    this.mVideoInfo = null;
    this.mStartPosition = 0L;
    this.mSkipEndPosition = 0L;
    this.mSpeedRatio = 1.0F;
    this.mDefinition = "";
    this.mIsLoopback = false;
    this.mAudioGainRatio = 1.0F;
    this.mOutputMute = false;
    this.mLiveBackPlayTimeSec = 0L;
  }
  
  public float audioGainRatio()
  {
    return this.mAudioGainRatio;
  }
  
  public void audioGainRatio(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.mAudioGainRatio = f;
  }
  
  public void clear()
  {
    initDefaults();
  }
  
  public Context context()
  {
    return this.mContext;
  }
  
  public void context(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public String definition()
  {
    return this.mDefinition;
  }
  
  public void definition(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mDefinition = str;
  }
  
  void dumpParams(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append("[");
    localStringBuilder.append("vid =");
    paramString = this.mVideoInfo;
    if (paramString != null) {
      paramString = paramString.getVid();
    } else {
      paramString = "";
    }
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    localStringBuilder.append("[");
    localStringBuilder.append("definition =");
    localStringBuilder.append(this.mDefinition);
    localStringBuilder.append("]");
    localStringBuilder.append("[");
    localStringBuilder.append("startTime =");
    localStringBuilder.append(this.mStartPosition);
    localStringBuilder.append("]");
    localStringBuilder.append("[");
    localStringBuilder.append("skipTime =");
    localStringBuilder.append(this.mSkipEndPosition);
    localStringBuilder.append("]");
    localStringBuilder.append(")");
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", localStringBuilder.toString());
  }
  
  public String flowId()
  {
    return this.mFlowId;
  }
  
  public void flowId(String paramString)
  {
    this.mFlowId = paramString;
  }
  
  public boolean isLoopback()
  {
    return this.mIsLoopback;
  }
  
  public boolean isOutputMute()
  {
    return this.mOutputMute;
  }
  
  public long livePlayBackTimeSec()
  {
    return this.mLiveBackPlayTimeSec;
  }
  
  public void livePlayBackTimeSec(long paramLong)
  {
    this.mLiveBackPlayTimeSec = paramLong;
  }
  
  public void loopback(boolean paramBoolean)
  {
    this.mIsLoopback = paramBoolean;
  }
  
  public void mediaSource(@NonNull TVKMediaSource paramTVKMediaSource)
  {
    this.mMediaSource = paramTVKMediaSource;
    paramTVKMediaSource = this.mUserInfo;
    if (paramTVKMediaSource != null) {
      this.mMediaSource.setHttpHeaders(paramTVKMediaSource.getCdnHttpHeader());
    }
  }
  
  public void outputMute(boolean paramBoolean)
  {
    this.mOutputMute = paramBoolean;
  }
  
  public long skipEndPosition()
  {
    return this.mSkipEndPosition;
  }
  
  public void skipEndPosition(long paramLong)
  {
    long l = 0L;
    if (paramLong < 0L) {
      paramLong = l;
    } else {
      paramLong = this.mSkipEndPosition;
    }
    this.mSkipEndPosition = paramLong;
  }
  
  public void speedRatio(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat <= 0.0F) {
      f = 0.1F;
    }
    this.mSpeedRatio = f;
  }
  
  public float speedRato()
  {
    return this.mSpeedRatio;
  }
  
  public long startPosition()
  {
    return this.mStartPosition;
  }
  
  public void startPosition(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.mStartPosition = l;
  }
  
  public TVKUserInfo userInfo()
  {
    return this.mUserInfo;
  }
  
  public void userInfo(TVKUserInfo paramTVKUserInfo)
  {
    TVKUserInfo localTVKUserInfo = paramTVKUserInfo;
    if (paramTVKUserInfo == null) {
      localTVKUserInfo = new TVKUserInfo();
    }
    this.mUserInfo = localTVKUserInfo;
    paramTVKUserInfo = this.mMediaSource;
    if (paramTVKUserInfo != null) {
      paramTVKUserInfo.setHttpHeaders(this.mUserInfo.getCdnHttpHeader());
    }
  }
  
  public TVKPlayerVideoInfo videoInfo()
  {
    return this.mVideoInfo;
  }
  
  public void videoInfo(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    TVKPlayerVideoInfo localTVKPlayerVideoInfo = paramTVKPlayerVideoInfo;
    if (paramTVKPlayerVideoInfo == null) {
      localTVKPlayerVideoInfo = new TVKPlayerVideoInfo();
    }
    this.mVideoInfo = localTVKPlayerVideoInfo;
    if (TextUtils.isEmpty(this.mVideoInfo.getCid()))
    {
      paramTVKPlayerVideoInfo = this.mVideoInfo;
      paramTVKPlayerVideoInfo.setCid(paramTVKPlayerVideoInfo.getVid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackParam
 * JD-Core Version:    0.7.0.1
 */