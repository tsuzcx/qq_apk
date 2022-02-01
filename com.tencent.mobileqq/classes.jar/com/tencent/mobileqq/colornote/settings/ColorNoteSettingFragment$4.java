package com.tencent.mobileqq.colornote.settings;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.data.ColorNoteHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ColorNoteSettingFragment$4
  implements CompoundButton.OnCheckedChangeListener
{
  ColorNoteSettingFragment$4(ColorNoteSettingFragment paramColorNoteSettingFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ColorNoteController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    if (!paramBoolean) {
      new ColorNoteCurd().c(null);
    }
    ((ColorNoteHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).a(paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A8B0", "0X800A8B0", i, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */