package com.tencent.mobileqq.colornotebiz.settings;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNoteHandler;
import com.tencent.mobileqq.colornote.settings.IColorNoteSettingCallback;
import com.tencent.mobileqq.statistics.ReportController;

public class ColorNoteSettingCallback
  implements IColorNoteSettingCallback
{
  public void a(boolean paramBoolean)
  {
    ((ColorNoteHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).a(paramBoolean);
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A8B0", "0X800A8B0", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornotebiz.settings.ColorNoteSettingCallback
 * JD-Core Version:    0.7.0.1
 */