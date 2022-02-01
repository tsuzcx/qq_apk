package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;

class VideoColumnSubscribeHandler$2
  implements Runnable
{
  VideoColumnSubscribeHandler$2(VideoColumnSubscribeHandler paramVideoColumnSubscribeHandler, int paramInt1, boolean paramBoolean, String paramString, int paramInt2) {}
  
  public void run()
  {
    if ((this.a != 0) && (this.b))
    {
      RIJPushNotifyManager.getInstance().showPushNotifyDialog(this.a, this.c, String.valueOf(this.d), 1);
      return;
    }
    if (!this.b) {
      RIJPushNotifyManager.getInstance().dismiss(true, "MATCH_ALL_UIN");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoColumnSubscribeHandler.2
 * JD-Core Version:    0.7.0.1
 */