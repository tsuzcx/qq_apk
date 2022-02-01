package com.tencent.mobileqq.qqgift.business.qqlive;

import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class QQGiftPanelViewModelForLive$1
  implements IQQGiftListCallback
{
  QQGiftPanelViewModelForLive$1(QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    paramString = new ArrayList();
    this.b.a(paramString);
  }
  
  public void a(List<GiftServiceData> paramList)
  {
    this.b.a(paramList);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[refreshGiftList] onReceive:");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      localStringBuilder.append(i);
      localStringBuilder.append(",cost:");
      localStringBuilder.append(System.currentTimeMillis() - this.a);
      QLog.i("QQGiftPanelViewModel", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewModelForLive.1
 * JD-Core Version:    0.7.0.1
 */