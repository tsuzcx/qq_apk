package com.tencent.mobileqq.qqgift.business.qqlive;

import com.tencent.mobileqq.qqgift.business.dt.QQGiftDtReportHelper;
import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class QQGiftPanelViewModelForLive$2
  implements IQQGiftRechargeCallback
{
  QQGiftPanelViewModelForLive$2(QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive) {}
  
  public Map<String, String> a()
  {
    if (QQGiftPanelViewModelForLive.a(this.a) != null) {
      return QQGiftPanelViewModelForLive.a(this.a).a();
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onRechargeBack] success:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", errCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errMsg:");
      localStringBuilder.append(paramString);
      QLog.i("QQGiftPanelViewModel", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      QQGiftPanelViewModelForLive.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewModelForLive.2
 * JD-Core Version:    0.7.0.1
 */