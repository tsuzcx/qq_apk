package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendTabView$2
  implements View.OnClickListener
{
  FriendTabView$2(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    this.a.g.a(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTabView.2
 * JD-Core Version:    0.7.0.1
 */