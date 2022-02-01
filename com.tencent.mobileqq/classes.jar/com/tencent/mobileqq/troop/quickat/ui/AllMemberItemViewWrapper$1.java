package com.tencent.mobileqq.troop.quickat.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AllMemberItemViewWrapper$1
  implements View.OnClickListener
{
  AllMemberItemViewWrapper$1(AllMemberItemViewWrapper paramAllMemberItemViewWrapper) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(AllMemberItemViewWrapper.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
    AllMemberItemViewWrapper.a(this.a).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.1
 * JD-Core Version:    0.7.0.1
 */