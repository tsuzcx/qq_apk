package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$17
  extends ReadInJoyObserver
{
  LebaQzoneAndPluginPart$17(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyObserver onReadInJoyNotifyRedTouchUpdate, isSuccess=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(",isUpdate=");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(", type=");
    localStringBuilder.append(paramInt);
    QLog.i("LebaBusinessPartImpl", 1, localStringBuilder.toString());
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt & 0x1) != 0)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.17
 * JD-Core Version:    0.7.0.1
 */