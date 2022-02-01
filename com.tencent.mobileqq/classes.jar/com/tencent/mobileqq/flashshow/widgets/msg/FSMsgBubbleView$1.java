package com.tencent.mobileqq.flashshow.widgets.msg;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.api.bean.FSPageListBean;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSMsgBubbleView$1
  implements View.OnClickListener
{
  FSMsgBubbleView$1(FSMsgBubbleView paramFSMsgBubbleView, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    FSMsgBubbleView.a(this.b);
    if (!TextUtils.isEmpty(FSMsgBubbleView.b(this.b).c())) {
      ((IJumpApi)QRoute.api(IJumpApi.class)).doJumpAction(this.a, FSMsgBubbleView.b(this.b).c());
    } else {
      FSNativeLauncher.a(this.b.getContext(), new FSPageListBean(this.b.getReportBean()));
    }
    FSMsgBubbleView.c(this.b);
    FSMsgBubbleView.a(this.b, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.msg.FSMsgBubbleView.1
 * JD-Core Version:    0.7.0.1
 */