package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardTextOption$1
  implements View.OnClickListener
{
  ForwardTextOption$1(ForwardTextOption paramForwardTextOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.A != null)
    {
      this.a.A.hideSoftInputFromWindow();
      ForwardPreviewTextController localForwardPreviewTextController = new ForwardPreviewTextController(this.a.A);
      localForwardPreviewTextController.a(this.a.s.getString(2131889672), this.a.u);
      this.a.A.addPreviewView(localForwardPreviewTextController.f());
      this.a.aq();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTextOption.1
 * JD-Core Version:    0.7.0.1
 */