package com.tencent.mobileqq.profilecard.bussiness.miniapp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniAppProfileCardGuestView$1
  implements View.OnClickListener
{
  MiniAppProfileCardGuestView$1(MiniAppProfileCardGuestView paramMiniAppProfileCardGuestView, String paramString) {}
  
  public void onClick(View paramView)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.this$0.getContext(), this.val$moreJumpLink, 2062, new MiniAppProfileCardGuestView.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.miniapp.MiniAppProfileCardGuestView.1
 * JD-Core Version:    0.7.0.1
 */