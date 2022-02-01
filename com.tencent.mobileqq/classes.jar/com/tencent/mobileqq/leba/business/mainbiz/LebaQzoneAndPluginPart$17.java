package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.app.readinjoy.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$17
  extends ReadInJoyObserver
{
  LebaQzoneAndPluginPart$17(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    QLog.i("LebaBusinessPartImpl", 1, "ReadInJoyObserver onReadInJoyNotifyRedTouchUpdate, isSuccess=" + paramBoolean1 + ",isUpdate=" + paramBoolean2 + ", type=" + paramInt);
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt & 0x1) != 0)) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.17
 * JD-Core Version:    0.7.0.1
 */