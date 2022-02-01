package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.text.format.DateUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.utils.SharedPreUtils;

class ReadInJoyTabTopSearchHeaderController$5
  implements Runnable
{
  ReadInJoyTabTopSearchHeaderController$5(ReadInJoyTabTopSearchHeaderController paramReadInJoyTabTopSearchHeaderController, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!DateUtils.isToday(SharedPreUtils.b("search_word_prefix_last_change_hotword_time")))
    {
      SharedPreUtils.a("search_word_prefix_last_change_hotword_time", System.currentTimeMillis());
      SharedPreUtils.a(this.this$0.a, 0);
      SharedPreUtils.a(this.this$0.b, 0);
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(204);
    int j = 100;
    int i;
    int m;
    int k;
    if (localAladdinConfig != null)
    {
      j = localAladdinConfig.getIntegerFromString("search_max_num", 100);
      i = localAladdinConfig.getIntegerFromString("refresh_num_n", 100);
      m = localAladdinConfig.getIntegerFromString("wording_times_m", 1);
      k = localAladdinConfig.getIntegerFromString("later_wording_times_y", 1);
    }
    else
    {
      i = 100;
      k = 1;
      m = 1;
    }
    if (SharedPreUtils.a(this.this$0.a) < j) {
      if (this.a == 6)
      {
        SharedPreUtils.a(this.this$0.a, SharedPreUtils.a(this.this$0.a) + 1);
        this.this$0.b(true, this.a, this.b);
      }
      else if (SharedPreUtils.a(this.this$0.b) < i)
      {
        if ((m > 0) && ((SharedPreUtils.a(this.this$0.b) + 1) % m == 0))
        {
          SharedPreUtils.a(this.this$0.a, SharedPreUtils.a(this.this$0.a) + 1);
          this.this$0.b(true, this.a, this.b);
        }
      }
      else if ((k > 0) && ((SharedPreUtils.a(this.this$0.b) + 1 - i) % k == 0))
      {
        SharedPreUtils.a(this.this$0.a, SharedPreUtils.a(this.this$0.a) + 1);
        this.this$0.b(true, this.a, this.b);
      }
    }
    SharedPreUtils.a(this.this$0.b, SharedPreUtils.a(this.this$0.b) + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyTabTopSearchHeaderController.5
 * JD-Core Version:    0.7.0.1
 */