package com.tencent.mobileqq.qqlive.trtc.video.videoprocess;

import com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;

public class QQLiveProcessFrame
  extends QQLiveVideoBaseFrame
{
  private TRTCCloudDef.TRTCVideoFrame a;
  
  public QQLiveProcessFrame(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    this.a = paramTRTCVideoFrame;
  }
  
  public TRTCCloudDef.TRTCVideoFrame a()
  {
    return this.a;
  }
  
  public int getVideoFrameType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.videoprocess.QQLiveProcessFrame
 * JD-Core Version:    0.7.0.1
 */