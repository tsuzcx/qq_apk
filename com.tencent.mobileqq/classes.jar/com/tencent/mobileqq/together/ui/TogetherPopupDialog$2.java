package com.tencent.mobileqq.together.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.together.TogetherEntryData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TogetherPopupDialog$2
  implements View.OnClickListener
{
  TogetherPopupDialog$2(TogetherPopupDialog paramTogetherPopupDialog) {}
  
  public void onClick(View paramView)
  {
    switch (((TogetherEntryData)paramView.getTag()).b)
    {
    default: 
      break;
    case 1005: 
      this.a.i();
      break;
    case 1004: 
      this.a.h();
      break;
    case 1003: 
      this.a.g();
      break;
    case 1002: 
      this.a.f();
      break;
    case 1001: 
      this.a.e();
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog.2
 * JD-Core Version:    0.7.0.1
 */