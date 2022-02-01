package com.tencent.mobileqq.leba;

import android.os.SystemClock;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.List;
import mqq.app.AppRuntime;

class Leba$4
  implements Runnable
{
  Leba$4(Leba paramLeba) {}
  
  public void run()
  {
    List localList = LebaShowListManager.a().b(this.this$0.jdField_a_of_type_MqqAppAppRuntime);
    this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.post(new Leba.4.1(this, localList));
    if (Leba.a(this.this$0))
    {
      Leba.a(this.this$0, false);
      long l1 = SystemClock.uptimeMillis();
      long l2 = Leba.a(this.this$0);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.this$0.jdField_a_of_type_MqqAppAppRuntime.getAccount(), "actLebaShowTime", true, l1 - l2, 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.4
 * JD-Core Version:    0.7.0.1
 */