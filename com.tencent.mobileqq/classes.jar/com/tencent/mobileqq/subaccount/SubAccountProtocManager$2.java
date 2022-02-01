package com.tencent.mobileqq.subaccount;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

class SubAccountProtocManager$2
  implements Runnable
{
  SubAccountProtocManager$2(SubAccountProtocManager paramSubAccountProtocManager) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = SubAccountProtocManager.a(this.this$0).getApp().getSharedPreferences("mobileQQ", 0);
    long l2 = localSharedPreferences.getLong("subaccount_last_report_time_" + SubAccountProtocManager.a(this.this$0).getCurrentAccountUin(), 0L);
    long l3 = System.currentTimeMillis() - 10L;
    Object localObject = Calendar.getInstance();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(l2);
    localCalendar1.add(5, 1);
    localCalendar1.clear(10);
    localCalendar1.clear(12);
    localCalendar1.clear(13);
    localCalendar1.clear(14);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.add(5, 1);
    localCalendar2.clear(10);
    localCalendar2.clear(12);
    localCalendar2.clear(13);
    localCalendar2.clear(14);
    long l1 = localCalendar2.getTimeInMillis() - l3 - 100L;
    if (l1 < 0L) {
      l1 = 86400000L;
    }
    for (;;)
    {
      if ((l2 > 0L) && (((Calendar)localObject).after(localCalendar1)) && (SubAccountControll.a(SubAccountProtocManager.a(this.this$0))))
      {
        boolean bool = SubAccountControll.b(SubAccountProtocManager.a(this.this$0));
        localObject = new HashMap();
        if (!bool) {
          break label437;
        }
      }
      label437:
      for (int i = 1;; i = 0)
      {
        ((Map)localObject).put("Top_bind_account", Integer.valueOf(i));
        StatisticCollector.getInstance(SubAccountProtocManager.a(this.this$0).getApp()).reportOnOff(SubAccountProtocManager.a(this.this$0), SubAccountProtocManager.a(this.this$0).getCurrentAccountUin(), (Map)localObject);
        localSharedPreferences.edit().putLong("subaccount_last_report_time_" + SubAccountProtocManager.a(this.this$0).getCurrentAccountUin(), l3).commit();
        if (l2 == 0L) {
          localSharedPreferences.edit().putLong("subaccount_last_report_time_" + SubAccountProtocManager.a(this.this$0).getCurrentAccountUin(), l3).commit();
        }
        l2 = (Math.random() * 30.0D * 60.0D * 1000.0D);
        if (ThreadManager.getSubThreadHandler() != null) {
          ThreadManager.getSubThreadHandler().postDelayed(SubAccountProtocManager.a(this.this$0), l2 + l1 + 60000L);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountProtocManager.2
 * JD-Core Version:    0.7.0.1
 */