package com.tencent.mobileqq.qqgift.business.qqlive;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.countdown.CountDownController;
import com.tencent.mobileqq.qqgift.countdown.CountDownInfo;
import com.tencent.mobileqq.qqgift.countdown.TimerInfo;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData.FreeInfo;
import com.tencent.mobileqq.qqgift.manager.QQGiftCountDownManager;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.utils.QQGiftTimeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class QQGiftPanelItemViewForLive$1
  implements Observer<TimerInfo>
{
  QQGiftPanelItemViewForLive$1(QQGiftPanelItemViewForLive paramQQGiftPanelItemViewForLive) {}
  
  public void a(TimerInfo paramTimerInfo)
  {
    if (QLog.isColorLevel())
    {
      paramTimerInfo = new StringBuilder();
      paramTimerInfo.append("[onChanged] timerInfo");
      paramTimerInfo.append(hashCode());
      QLog.i("QQGiftPanelItemViewForLive", 2, paramTimerInfo.toString());
    }
    if (QQGiftCountDownManager.a(QQGiftPanelItemViewForLive.a(this.a))) {
      try
      {
        paramTimerInfo = QQGiftCountDownManager.a();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(QQGiftPanelItemViewForLive.b(this.a).i().c().a);
        ((StringBuilder)localObject).append("");
        paramTimerInfo = paramTimerInfo.a(((StringBuilder)localObject).toString()).d();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(QQGiftPanelItemViewForLive.a(this.a).a);
        ((StringBuilder)localObject).append("");
        paramTimerInfo = (CountDownInfo)paramTimerInfo.get(((StringBuilder)localObject).toString());
        if (paramTimerInfo != null)
        {
          localObject = QQGiftTimeUtil.a(paramTimerInfo.b * 1000L);
          String str = QQGiftPanelItemViewForLive.a(this.a).l.b;
          QQGiftPanelItemViewForLive.a(this.a, paramTimerInfo, (String)localObject);
          if (QQGiftPanelItemViewForLive.c(this.a)) {
            QQGiftPanelItemViewForLive.a(this.a, (String)localObject, str);
          }
        }
        else
        {
          QQGiftPanelItemViewForLive.a(this.a, false);
          if (QQGiftPanelItemViewForLive.c(this.a))
          {
            QQGiftPanelItemViewForLive.d(this.a);
            return;
          }
        }
      }
      catch (Exception paramTimerInfo)
      {
        QLog.e("QQGiftPanelItemViewForLive", 1, paramTimerInfo, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelItemViewForLive.1
 * JD-Core Version:    0.7.0.1
 */