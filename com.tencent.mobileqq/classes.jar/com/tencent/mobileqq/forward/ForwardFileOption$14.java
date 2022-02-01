package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardFileOption$14
  implements View.OnClickListener
{
  ForwardFileOption$14(ForwardFileOption paramForwardFileOption, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(View paramView)
  {
    ForwardFileOption localForwardFileOption = this.d;
    localForwardFileOption.am = true;
    ForwardFileOption.a(localForwardFileOption, this.a, this.b, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.14
 * JD-Core Version:    0.7.0.1
 */