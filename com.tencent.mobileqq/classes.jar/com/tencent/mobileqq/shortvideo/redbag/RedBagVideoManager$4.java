package com.tencent.mobileqq.shortvideo.redbag;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RedBagVideoManager$4
  implements View.OnClickListener
{
  RedBagVideoManager$4(RedBagVideoManager paramRedBagVideoManager) {}
  
  public void onClick(View paramView)
  {
    RedBagVideoManager.a(this.a, RedBagVideoManager.a(this.a));
    RedBagVideoManager.b(this.a, System.currentTimeMillis());
    if (RedBagVideoManager.a(this.a) - RedBagVideoManager.b(this.a) < 300L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      RedBagVideoManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.4
 * JD-Core Version:    0.7.0.1
 */