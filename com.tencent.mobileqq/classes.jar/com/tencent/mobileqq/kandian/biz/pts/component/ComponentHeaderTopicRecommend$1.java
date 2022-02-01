package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.kandian.base.image.imageloader.CloseableBitmap;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class ComponentHeaderTopicRecommend$1
  implements IPublicAccountImageDownListener
{
  ComponentHeaderTopicRecommend$1(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderTopicRecommend", 2, "topic image view download success");
    }
    if ((paramObject instanceof CloseableBitmap))
    {
      paramURL = (CloseableBitmap)paramObject;
      ComponentHeaderTopicRecommend.a(this.a, paramURL.a());
    }
  }
  
  public void a(URL paramURL, Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderTopicRecommend.1
 * JD-Core Version:    0.7.0.1
 */