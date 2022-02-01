package com.tencent.mobileqq.winkpublish.part;

import com.tencent.mobileqq.winkpublish.viewmodel.PublishPoiViewModel;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class PublishLbsPart$8
  implements QQPermissionCallback
{
  PublishLbsPart$8(PublishLbsPart paramPublishLbsPart) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(PublishLbsPart.a, 1, "jumpToPoiFragment... deny");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PublishLbsPart.b(this.a).a(this.a.j());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart.8
 * JD-Core Version:    0.7.0.1
 */