package com.tencent.mobileqq.olympic.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PromotionRes$4
  implements View.OnClickListener
{
  PromotionRes$4(PromotionRes paramPromotionRes) {}
  
  public void onClick(View paramView)
  {
    PopupMenu localPopupMenu = new PopupMenu(PromotionRes.a(this.a), paramView);
    PromotionRes localPromotionRes = this.a;
    localPromotionRes.a(PromotionRes.a(localPromotionRes).a, localPopupMenu);
    localPopupMenu.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionRes.4
 * JD-Core Version:    0.7.0.1
 */