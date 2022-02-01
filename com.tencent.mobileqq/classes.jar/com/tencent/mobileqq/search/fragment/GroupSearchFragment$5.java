package com.tencent.mobileqq.search.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GroupSearchFragment$5
  implements View.OnClickListener
{
  GroupSearchFragment$5(GroupSearchFragment paramGroupSearchFragment) {}
  
  public void onClick(View paramView)
  {
    GroupSearchFragment localGroupSearchFragment = this.a;
    localGroupSearchFragment.c = 1;
    if (UniteSearchActivity.a(GroupSearchFragment.b(localGroupSearchFragment), GroupSearchFragment.a(this.a))) {
      this.a.c = 1;
    }
    this.a.j();
    GroupSearchFragment.a(this.a).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment.5
 * JD-Core Version:    0.7.0.1
 */