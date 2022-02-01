package com.tencent.mobileqq.leba;

import android.os.SystemClock;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.List;
import mqq.app.AppRuntime;

class Leba$5
  implements Runnable
{
  Leba$5(Leba paramLeba) {}
  
  public void run()
  {
    List localList = LebaShowListManager.a().b(this.this$0.aF);
    this.this$0.k.post(new Leba.5.1(this, localList));
    if (Leba.b(this.this$0))
    {
      Leba.b(this.this$0, false);
      long l1 = SystemClock.uptimeMillis();
      long l2 = Leba.c(this.this$0);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.this$0.aF.getAccount(), "actLebaShowTime", true, l1 - l2, 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.5
 * JD-Core Version:    0.7.0.1
 */