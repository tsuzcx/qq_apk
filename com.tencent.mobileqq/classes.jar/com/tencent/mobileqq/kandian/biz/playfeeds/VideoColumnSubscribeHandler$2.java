package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.push.api.IRIJPushNotifyManager;
import com.tencent.mobileqq.qroute.QRoute;

class VideoColumnSubscribeHandler$2
  implements Runnable
{
  VideoColumnSubscribeHandler$2(VideoColumnSubscribeHandler paramVideoColumnSubscribeHandler, int paramInt1, boolean paramBoolean, String paramString, int paramInt2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Boolean))
    {
      ((IRIJPushNotifyManager)QRoute.api(IRIJPushNotifyManager.class)).showPushNotifyDialog(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, String.valueOf(this.b), 1);
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      ((IRIJPushNotifyManager)QRoute.api(IRIJPushNotifyManager.class)).dismiss(true, "MATCH_ALL_UIN");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoColumnSubscribeHandler.2
 * JD-Core Version:    0.7.0.1
 */