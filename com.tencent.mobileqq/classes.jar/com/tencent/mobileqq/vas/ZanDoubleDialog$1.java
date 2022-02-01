package com.tencent.mobileqq.vas;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ZanDoubleDialog$1
  implements View.OnClickListener
{
  ZanDoubleDialog$1(ZanDoubleDialog paramZanDoubleDialog) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131374947: 
      this.a.dismiss();
      break;
    case 2131374946: 
      if (this.a.a != null) {
        this.a.a.onRightClick();
      }
      this.a.dismiss();
      break;
    case 2131374945: 
      if (this.a.a != null) {
        this.a.a.onLeftClick();
      }
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanDoubleDialog.1
 * JD-Core Version:    0.7.0.1
 */