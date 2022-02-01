package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AppletsSettingFragment$1
  implements View.OnClickListener
{
  AppletsSettingFragment$1(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if (AppletsSettingFragment.a(this.a))
    {
      this.a.a();
    }
    else
    {
      AppletsSettingFragment localAppletsSettingFragment = this.a;
      AppletsSettingFragment.a(localAppletsSettingFragment, AppletsSettingFragment.a(localAppletsSettingFragment) ^ true);
      localAppletsSettingFragment = this.a;
      AppletsSettingFragment.a(localAppletsSettingFragment, AppletsSettingFragment.a(localAppletsSettingFragment));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */