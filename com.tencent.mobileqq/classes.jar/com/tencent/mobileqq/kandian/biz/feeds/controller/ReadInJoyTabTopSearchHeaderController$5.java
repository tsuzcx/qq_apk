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
    if (!DateUtils.isToday(SharedPreUtils.k("search_word_prefix_last_change_hotword_time")))
    {
      SharedPreUtils.a("search_word_prefix_last_change_hotword_time", System.currentTimeMillis());
      SharedPreUtils.c(this.this$0.f, 0);
      SharedPreUtils.c(this.this$0.g, 0);
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
    if (SharedPreUtils.l(this.this$0.f) < j) {
      if (this.a == 6)
      {
        SharedPreUtils.c(this.this$0.f, SharedPreUtils.l(this.this$0.f) + 1);
        this.this$0.b(true, this.a, this.b);
      }
      else if (SharedPreUtils.l(this.this$0.g) < i)
      {
        if ((m > 0) && ((SharedPreUtils.l(this.this$0.g) + 1) % m == 0))
        {
          SharedPreUtils.c(this.this$0.f, SharedPreUtils.l(this.this$0.f) + 1);
          this.this$0.b(true, this.a, this.b);
        }
      }
      else if ((k > 0) && ((SharedPreUtils.l(this.this$0.g) + 1 - i) % k == 0))
      {
        SharedPreUtils.c(this.this$0.f, SharedPreUtils.l(this.this$0.f) + 1);
        this.this$0.b(true, this.a, this.b);
      }
    }
    SharedPreUtils.c(this.this$0.g, SharedPreUtils.l(this.this$0.g) + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyTabTopSearchHeaderController.5
 * JD-Core Version:    0.7.0.1
 */