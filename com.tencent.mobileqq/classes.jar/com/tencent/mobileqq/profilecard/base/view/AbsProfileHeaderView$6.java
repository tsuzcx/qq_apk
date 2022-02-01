package com.tencent.mobileqq.profilecard.base.view;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbsProfileHeaderView$6
  implements View.OnClickListener
{
  AbsProfileHeaderView$6(AbsProfileHeaderView paramAbsProfileHeaderView, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mApp.getApp().getSharedPreferences(this.this$0.mApp.getCurrentAccountUin(), 0).edit().putBoolean("common_topic_friend_list_should_show", false).apply();
    this.val$topicView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.6
 * JD-Core Version:    0.7.0.1
 */