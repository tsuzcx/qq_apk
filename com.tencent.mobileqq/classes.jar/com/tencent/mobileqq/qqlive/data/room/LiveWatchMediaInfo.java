package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qqlive.data.room.stream.ServiceFrameInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceStreamInfo;

public class LiveWatchMediaInfo
{
  public static final int CODEC_TYPE_AV1 = 4;
  public static final int CODEC_TYPE_H264 = 1;
  public static final int CODEC_TYPE_H265 = 2;
  public static final int CODEC_TYPE_H266 = 3;
  public static final int CODEC_TYPE_VP9 = 5;
  public static final int PROTO_TYPE_FILE = 3;
  public static final int PROTO_TYPE_HTTP = 1;
  public static final int PROTO_TYPE_RTMP = 2;
  public boolean forceSwitch = false;
  public boolean isOriginStream;
  public boolean isPreload = false;
  public String mFlvUrl;
  public String mFlvUrlHigh;
  public String mFlvUrlLow;
  public String mFlvUrlLowest;
  public String mHLSUrl;
  public int mLevel;
  public String mRtmpUrl;
  public String mRtmpUrlHigh;
  public String mRtmpUrlLow;
  public String mRtmpUrlLowest;
  public int mSdkType = 0;
  public String mUrl;
  public String mUrlHigh;
  public String mUrlLow;
  public String mUrlLowest;
  public LiveVideoStatus mVideoStatus = LiveVideoStatus.Start;
  public ServiceStreamInfo serviceStreamInfo;
  public byte[] sig;
  public long sigTimeOut;
  public int sugLevel;
  public ServiceFrameInfo sugServiceFrameInfo;
  
  public String getMediaUrl()
  {
    return this.mRtmpUrl;
  }
  
  public int getProtoType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo
 * JD-Core Version:    0.7.0.1
 */