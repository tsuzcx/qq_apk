package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$20
  extends PublicAccountObserver
{
  LebaQzoneAndPluginPart$20(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  public void onPublicAccountNotification(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("LebaBusinessPartImpl", 1, "PublicAccountObserver onPublicAccountNotification, isSuccess=" + paramBoolean1 + ",isFresh=" + paramBoolean2);
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.20
 * JD-Core Version:    0.7.0.1
 */