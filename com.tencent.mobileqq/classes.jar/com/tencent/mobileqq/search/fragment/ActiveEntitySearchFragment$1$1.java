package com.tencent.mobileqq.search.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActiveEntitySearchFragment$1$1
  implements View.OnClickListener
{
  ActiveEntitySearchFragment$1$1(ActiveEntitySearchFragment.1 param1, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.b.a.getBaseActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.a);
    this.b.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment.1.1
 * JD-Core Version:    0.7.0.1
 */