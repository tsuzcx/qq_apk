package com.tencent.mobileqq.businessCard.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BusinessCardEditActivity$14
  implements View.OnClickListener
{
  BusinessCardEditActivity$14(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.r != null) && (this.a.r.isShowing()))
    {
      this.a.r.dismiss();
      this.a.r = null;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.14
 * JD-Core Version:    0.7.0.1
 */