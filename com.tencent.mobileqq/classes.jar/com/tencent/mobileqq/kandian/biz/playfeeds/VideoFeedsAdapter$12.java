package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsAdapter$12
  implements INetInfoHandler
{
  VideoFeedsAdapter$12(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, "INetInfoHandler onNetMobile2None()");
    }
    VideoFeedsAdapter.g(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INetInfoHandler onNetMobile2Wifi() ssid=");
      localStringBuilder.append(paramString);
      QLog.i("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, localStringBuilder.toString());
    }
    VideoFeedsAdapter.a(this.a, true);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INetInfoHandler onNetNone2Mobile() apn=");
      localStringBuilder.append(paramString);
      QLog.i("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, localStringBuilder.toString());
    }
    VideoFeedsAdapter.a(this.a, false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INetInfoHandler onNetNone2Wifi() ssid=");
      localStringBuilder.append(paramString);
      QLog.i("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, localStringBuilder.toString());
    }
    VideoFeedsAdapter.a(this.a, true);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INetInfoHandler onNetWifi2Mobile() apn=");
      localStringBuilder.append(paramString);
      QLog.i("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, localStringBuilder.toString());
    }
    VideoFeedsAdapter.a(this.a, false);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, "INetInfoHandler onNetWifi2None()");
    }
    VideoFeedsAdapter.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.12
 * JD-Core Version:    0.7.0.1
 */