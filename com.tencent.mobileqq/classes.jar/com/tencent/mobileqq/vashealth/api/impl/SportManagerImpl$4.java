package com.tencent.mobileqq.vashealth.api.impl;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.config.HealthTimerConfigBean;
import com.tencent.mobileqq.vashealth.config.HealthTimerConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class SportManagerImpl$4
  implements Handler.Callback
{
  SportManagerImpl$4(SportManagerImpl paramSportManagerImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = HealthTimerConfigProcessor.a();
      int i = paramMessage.l();
      int m = paramMessage.m();
      int j = paramMessage.j();
      int k = paramMessage.k();
      if ((SSOHttpUtils.c != 0L) && (NetConnInfoCenter.getServerTimeMillis() - SSOHttpUtils.c >= i))
      {
        if (this.a.mTimer2ReportTimes >= m)
        {
          QLog.i("SportManager", 2, "retry time enough cancel task.");
          this.a.mHandler.removeCallbacksAndMessages(null);
          return true;
        }
        paramMessage = Calendar.getInstance();
        paramMessage.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        m = paramMessage.get(11);
        if (m >= j)
        {
          paramMessage = this.a;
          paramMessage.mTimer2ReportTimes += 1;
          this.a.refreshCurrentStep("timer2 callback report1");
        }
        else
        {
          if (m >= k) {
            break label256;
          }
          paramMessage.set(11, 0);
          paramMessage.set(12, 0);
          paramMessage.set(13, 0);
          paramMessage.set(14, 0);
          if (SSOHttpUtils.c - paramMessage.getTimeInMillis() > 0L)
          {
            QLog.i("SportManager", 2, "already report cancel task.");
            this.a.mHandler.removeCallbacksAndMessages(null);
            return true;
          }
          paramMessage = this.a;
          paramMessage.mTimer2ReportTimes += 1;
          this.a.refreshCurrentStep("timer2 callback report2");
        }
        this.a.mHandler.sendEmptyMessageDelayed(1, i + 2000);
        return true;
        label256:
        QLog.i("SportManager", 2, "over time cancel task.");
        this.a.mHandler.removeCallbacksAndMessages(null);
        return true;
      }
      this.a.mHandler.sendEmptyMessageDelayed(1, i);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.SportManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */