package com.tencent.mobileqq.studymode;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class KidModeAdvanceSettingFragment$6
  implements View.OnClickListener
{
  KidModeAdvanceSettingFragment$6(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onClick(View paramView)
  {
    ILebaHelperService localILebaHelperService = KidModeAdvanceSettingFragment.a(this.a);
    if (localILebaHelperService != null) {
      localILebaHelperService.goToLebaMgrActivity(this.a.getBaseActivity(), KidModeAdvanceSettingFragment.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */