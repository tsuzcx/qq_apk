package com.tencent.mobileqq.magicface.drawable;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PngFrameManager$1$1
  implements View.OnClickListener
{
  PngFrameManager$1$1(PngFrameManager.1 param1) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a.c.v.getVisibility() != 0) && (this.a.a.c.c.getVisibility() == 0))
    {
      this.a.a.f = true;
      this.a.a.c.v.setVisibility(0);
      this.a.this$0.e(this.a.a);
      if (this.a.a.g != null) {
        this.a.a.g.a(this.a.a.c);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.1.1
 * JD-Core Version:    0.7.0.1
 */