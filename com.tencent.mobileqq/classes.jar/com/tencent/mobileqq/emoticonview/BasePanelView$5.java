package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class BasePanelView$5
  implements Runnable
{
  BasePanelView$5(BasePanelView paramBasePanelView, int paramInt, long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    if (BasePanelView.access$200(this.this$0) != null)
    {
      String str = BasePanelView.access$200(this.this$0).getCurrentAccountUin();
      if ((BasePanelView.access$300(this.this$0) != null) && (str != null))
      {
        Object localObject1 = BasePanelView.access$300(this.this$0);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("emoticon_panel_");
        ((StringBuilder)localObject2).append(str);
        SharedPreferences localSharedPreferences = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
        long l = localSharedPreferences.getLong("sp_key_emoticon_panel_last_report_time", 0L);
        int i = localSharedPreferences.getInt("sp_key_emoticon_panel_report_count", 0);
        if (System.currentTimeMillis() - l > 86400000L)
        {
          localObject1 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putLong("sp_key_emoticon_panel_last_report_time", System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject1).putInt("sp_key_emoticon_panel_report_count", 0);
          ((SharedPreferences.Editor)localObject1).apply();
          i = 0;
        }
        if (i < 10)
        {
          int j = this.val$tempCondition;
          localObject2 = "report_AIOEmoticonPanel_OpenFirstTimeInProcess";
          localObject1 = localObject2;
          if (j != 1) {
            if (j != 2)
            {
              if (j != 3) {
                localObject1 = localObject2;
              } else {
                localObject1 = "report_AIOEmoticonPanel_ReopenInAIO";
              }
            }
            else {
              localObject1 = "report_AIOEmoticonPanel_OpenFirstTimeInAIO";
            }
          }
          StatisticCollector.getInstance(BasePanelView.access$300(this.this$0)).collectPerformance(str, (String)localObject1, true, this.val$duration, 0L, this.val$params, "", false);
          localObject1 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putInt("sp_key_emoticon_panel_report_count", i + 1);
          ((SharedPreferences.Editor)localObject1).apply();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BasePanelView.5
 * JD-Core Version:    0.7.0.1
 */