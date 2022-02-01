package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import java.util.HashMap;
import java.util.Map;

abstract class BaseVideoEventParamsBuilder<T>
  extends BaseEventParamsBuilder<T>
{
  private Boolean mIsVertical;
  private PlayParamConst.PlayLoopType mPlayLoopType;
  private String mPlaySessionId;
  private PlayParamConst.PlayType mPlayType;
  private String mVideoContentId;
  private Integer mVideoHeight;
  private long mVideoStaticDuration;
  private Integer mVideoWidth;
  
  public BaseVideoEventParamsBuilder(String paramString1, long paramLong, String paramString2)
  {
    this.mVideoContentId = paramString1;
    this.mVideoStaticDuration = paramLong;
    this.mPlaySessionId = paramString2;
  }
  
  public final Map<String, String> build()
  {
    HashMap localHashMap = new HashMap(this.mEventParams);
    putSingleParam(localHashMap, "video_contentid", this.mVideoContentId);
    putSingleParam(localHashMap, "video_static_duration", Long.valueOf(this.mVideoStaticDuration));
    putSingleParam(localHashMap, "video_width", this.mVideoWidth);
    putSingleParam(localHashMap, "video_height", this.mVideoHeight);
    Object localObject = this.mIsVertical;
    if (localObject == null) {
      localObject = null;
    } else if (((Boolean)localObject).booleanValue()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    putSingleParam(localHashMap, "is_vertical", localObject);
    putSingleParam(localHashMap, "play_sessionid", this.mPlaySessionId);
    putSingleParam(localHashMap, "play_type", this.mPlayType);
    putSingleParam(localHashMap, "play_loop_type", this.mPlayLoopType);
    onBuild(localHashMap);
    return localHashMap;
  }
  
  final BaseEventParamsBuilder.CheckResult checkValidity()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = new String[2];
    int i = 0;
    arrayOfString[0] = "PlaySessionId";
    boolean bool = true;
    arrayOfString[1] = "VideoContentId";
    String str1 = this.mPlaySessionId;
    String str2 = this.mVideoContentId;
    while (i < arrayOfString.length)
    {
      bool &= checkSingleParam(localStringBuilder, arrayOfString[i], new Object[] { str1, str2 }[i]);
      i += 1;
    }
    return new BaseEventParamsBuilder.CheckResult(bool, localStringBuilder.toString());
  }
  
  abstract void onBuild(Map<String, String> paramMap);
  
  public T setPlayLoopType(PlayParamConst.PlayLoopType paramPlayLoopType)
  {
    this.mPlayLoopType = paramPlayLoopType;
    return self();
  }
  
  public T setPlayType(PlayParamConst.PlayType paramPlayType)
  {
    this.mPlayType = paramPlayType;
    return self();
  }
  
  public T setVertical(boolean paramBoolean)
  {
    this.mIsVertical = Boolean.valueOf(paramBoolean);
    return self();
  }
  
  public T setVideoHeight(int paramInt)
  {
    this.mVideoHeight = Integer.valueOf(paramInt);
    return self();
  }
  
  public T setVideoWidth(int paramInt)
  {
    this.mVideoWidth = Integer.valueOf(paramInt);
    return self();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
 * JD-Core Version:    0.7.0.1
 */