package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.PlusPanelAdapter.ViewHolder;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopBarReplyActivity$16
  implements View.OnClickListener
{
  TroopBarReplyActivity$16(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onClick(View paramView)
  {
    switch (((PlusPanelAdapter.ViewHolder)paramView.getTag()).a)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopBarReplyActivity.b(this.a);
      continue;
      TroopBarReplyActivity.c(this.a);
      continue;
      TroopBarReplyActivity.d(this.a);
      continue;
      if (this.a.k)
      {
        TroopBarUtils.a(this.a.m, this.a.n, "Clk_music", this.a.o, "", "", "");
        TroopBarUtils.b("reply_page_new", "Clk_music", this.a.o, "", "", "");
      }
      if (!this.a.a(4)) {
        if ((this.a.a.a() != 0) && (this.a.a.a() != 3))
        {
          this.a.a(3);
        }
        else
        {
          this.a.b(4);
          continue;
          if (this.a.k)
          {
            TroopBarUtils.a(this.a.m, this.a.n, "Clk_video", this.a.o, "", "", "");
            TroopBarUtils.b("reply_page_new", "Clk_video", this.a.o, "", "", "");
          }
          if (!this.a.a(8)) {
            if ((this.a.a.a() != 0) && (this.a.a.a() != 4)) {
              this.a.a(7);
            } else {
              this.a.b(3);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.16
 * JD-Core Version:    0.7.0.1
 */