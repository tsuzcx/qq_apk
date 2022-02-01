package com.tencent.mobileqq.mini.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniAppProfileCardGuestView$1
  implements View.OnClickListener
{
  MiniAppProfileCardGuestView$1(MiniAppProfileCardGuestView paramMiniAppProfileCardGuestView, String paramString) {}
  
  public void onClick(View paramView)
  {
    MiniAppLauncher.startMiniApp(this.this$0.getContext(), this.val$moreJumpLink, 2062, new MiniAppProfileCardGuestView.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardGuestView.1
 * JD-Core Version:    0.7.0.1
 */