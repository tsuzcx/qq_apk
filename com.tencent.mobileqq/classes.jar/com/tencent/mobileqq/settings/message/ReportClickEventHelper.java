package com.tencent.mobileqq.settings.message;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class ReportClickEventHelper
{
  public static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ReportController.b(paramAppInterface, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
      return;
    }
    ReportController.b(paramAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ReportClickEventHelper
 * JD-Core Version:    0.7.0.1
 */