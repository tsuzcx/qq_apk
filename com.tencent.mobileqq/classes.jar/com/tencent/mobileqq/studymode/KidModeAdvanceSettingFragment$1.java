package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

class KidModeAdvanceSettingFragment$1
  extends KidModeObserver
{
  KidModeAdvanceSettingFragment$1(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    int i = 0;
    KidModeAdvanceSettingFragment localKidModeAdvanceSettingFragment;
    switch (paramInt)
    {
    default: 
    case 8: 
    case 16: 
    case 32: 
      do
      {
        return;
        bool = StudyModeManager.b(paramInt);
        KidModeAdvanceSettingFragment.a(this.a, paramInt, bool);
      } while (paramBoolean);
      localKidModeAdvanceSettingFragment = this.a;
      if (!bool) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        KidModeAdvanceSettingFragment.a(localKidModeAdvanceSettingFragment, paramInt, paramBoolean);
        QQToast.a(this.a.getActivity(), 1, 2131719697, 0).a();
        return;
      }
    }
    if (paramBoolean)
    {
      paramInt = i;
      if (KidModeAdvanceSettingFragment.a(this.a).a()) {
        paramInt = 1;
      }
      StudyModeManager.a(paramInt);
    }
    for (;;)
    {
      KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
      return;
      localKidModeAdvanceSettingFragment = this.a;
      FormMultiLineSwitchItem localFormMultiLineSwitchItem = KidModeAdvanceSettingFragment.a(this.a);
      paramBoolean = bool;
      if (!KidModeAdvanceSettingFragment.a(this.a).a()) {
        paramBoolean = true;
      }
      KidModeAdvanceSettingFragment.a(localKidModeAdvanceSettingFragment, localFormMultiLineSwitchItem, paramBoolean, KidModeAdvanceSettingFragment.a(this.a));
      KidModeUtils.a(this.a.getActivity(), HardCodeUtil.a(2131719697), 1);
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    KidModeAdvanceSettingFragment.a(this.a);
  }
  
  public void c(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("phone");
    paramBundle = paramBundle.getString("mibao_set_url");
    if (StringUtil.a(str)) {}
    for (int i = 1;; i = 0)
    {
      StudyModeManager.a(i, str, paramBundle);
      KidModeAdvanceSettingFragment.a(this.a, StringUtil.a(str));
      KidModeAdvanceSettingFragment.a(this.a, 4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */