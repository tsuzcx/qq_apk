package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.leba.ILebaHelperService;

class KidModeAdvanceSettingFragment$5$1
  implements Runnable
{
  KidModeAdvanceSettingFragment$5$1(KidModeAdvanceSettingFragment.5 param5) {}
  
  public void run()
  {
    ILebaHelperService localILebaHelperService = KidModeAdvanceSettingFragment.a(this.a.a);
    if (localILebaHelperService != null) {
      localILebaHelperService.reloadLebaItems(KidModeAdvanceSettingFragment.a(this.a.a));
    }
    KidModeAdvanceSettingFragment.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.5.1
 * JD-Core Version:    0.7.0.1
 */