package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardStructingMsgOption$3
  implements View.OnClickListener
{
  ForwardStructingMsgOption$3(ForwardStructingMsgOption paramForwardStructingMsgOption, boolean paramBoolean, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (this.d.A != null)
    {
      this.d.A.hideSoftInputFromWindow();
      ForwardStructingMsgOption.a(this.d, this.a, this.b, this.c);
      this.d.aq();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardStructingMsgOption.3
 * JD-Core Version:    0.7.0.1
 */