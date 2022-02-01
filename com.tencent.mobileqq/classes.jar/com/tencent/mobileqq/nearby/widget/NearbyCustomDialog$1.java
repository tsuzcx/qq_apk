package com.tencent.mobileqq.nearby.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyCustomDialog$1
  implements View.OnClickListener
{
  NearbyCustomDialog$1(NearbyCustomDialog paramNearbyCustomDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyCustomDialog.1
 * JD-Core Version:    0.7.0.1
 */