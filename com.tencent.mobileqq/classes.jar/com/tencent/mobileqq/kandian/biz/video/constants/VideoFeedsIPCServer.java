package com.tencent.mobileqq.kandian.biz.video.constants;

import com.tencent.mobileqq.qipc.QIPCModule;

public class VideoFeedsIPCServer
{
  private static VideoFeedsIPCServer a;
  
  public static VideoFeedsIPCServer a()
  {
    if (a == null) {
      try
      {
        a = new VideoFeedsIPCServer();
      }
      finally {}
    }
    return a;
  }
  
  public QIPCModule b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.constants.VideoFeedsIPCServer
 * JD-Core Version:    0.7.0.1
 */