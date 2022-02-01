package com.tencent.mobileqq.colornote.settings;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class ColorNoteSettingFragment$4
  implements CompoundButton.OnCheckedChangeListener
{
  ColorNoteSettingFragment$4(ColorNoteSettingFragment paramColorNoteSettingFragment, AppRuntime paramAppRuntime) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((IColorNoteController)QRoute.api(IColorNoteController.class)).setRecentlyViewedSwitch(this.jdField_a_of_type_MqqAppAppRuntime, paramBoolean);
    if (!paramBoolean) {
      new ColorNoteCurd().c(null);
    }
    ColorNoteSettingUtil.a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */