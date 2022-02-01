package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class IdolAdapter$1
  implements View.OnClickListener
{
  IdolAdapter$1(IdolAdapter paramIdolAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.this$0.clickItem(this.val$i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.IdolAdapter.1
 * JD-Core Version:    0.7.0.1
 */