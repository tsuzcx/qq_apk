package com.tencent.mobileqq.intervideo.groupvideo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GroupVideoLoadingFragment$VideoButtonListener
  implements View.OnClickListener
{
  private GroupVideoLoadingFragment$VideoButtonListener(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void onClick(View paramView)
  {
    GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705422), HardCodeUtil.a(2131705426));
    GroupVideoLoadingFragment.a(this.a).c();
    GroupVideoLoadingFragment.a(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment.VideoButtonListener
 * JD-Core Version:    0.7.0.1
 */