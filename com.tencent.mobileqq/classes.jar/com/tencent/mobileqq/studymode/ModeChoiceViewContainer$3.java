package com.tencent.mobileqq.studymode;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class ModeChoiceViewContainer$3
  implements CompoundButton.OnCheckedChangeListener
{
  ModeChoiceViewContainer$3(ModeChoiceViewContainer paramModeChoiceViewContainer) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = ModeChoiceViewContainer.b(this.a).getSwitch().isChecked();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(ModeChoiceViewContainer.c(this.a), false, null);
    int j = SimpleUIUtil.i();
    int i;
    if ((bool1) && (bool2))
    {
      i = SimpleUIUtil.d;
    }
    else
    {
      i = j;
      if (bool1)
      {
        i = j;
        if (ThemeUtil.isNowThemeIsNight(ModeChoiceViewContainer.c(this.a), false, SimpleUIUtil.a(j))) {
          i = SimpleUIUtil.j();
        }
      }
    }
    if (paramBoolean)
    {
      String str = SimpleUIUtil.a(i);
      if (!DarkModeManager.b(ModeChoiceViewContainer.a(this.a), str, new ModeChoiceViewContainer.3.1(this, paramCompoundButton, bool1, i))) {
        ModeChoiceViewContainer.a(this.a, paramCompoundButton, true, bool1, i);
      }
    }
    else
    {
      ModeChoiceViewContainer.a(this.a, paramCompoundButton, false, bool1, i);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.3
 * JD-Core Version:    0.7.0.1
 */