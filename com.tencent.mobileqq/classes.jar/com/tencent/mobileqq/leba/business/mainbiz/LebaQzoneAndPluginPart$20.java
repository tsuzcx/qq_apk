package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$20
  extends IPublicAccountObserver.OnCallback
{
  LebaQzoneAndPluginPart$20(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  public void onPublicAccountNotification(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublicAccountObserver onPublicAccountNotification, isSuccess=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(",isFresh=");
    localStringBuilder.append(paramBoolean2);
    QLog.i("LebaBusinessPartImpl", 1, localStringBuilder.toString());
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.20
 * JD-Core Version:    0.7.0.1
 */