package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TextHeaderView$2
  implements View.OnClickListener
{
  TextHeaderView$2(TextHeaderView paramTextHeaderView, Activity paramActivity, int paramInt, QQVipMsgInfo paramQQVipMsgInfo) {}
  
  public void onClick(View paramView)
  {
    TextHeaderView.a(this.d, this.a, this.b, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.TextHeaderView.2
 * JD-Core Version:    0.7.0.1
 */