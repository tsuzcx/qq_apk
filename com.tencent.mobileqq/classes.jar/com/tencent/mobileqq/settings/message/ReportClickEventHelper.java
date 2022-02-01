package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class ReportClickEventHelper
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
      return;
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ReportClickEventHelper
 * JD-Core Version:    0.7.0.1
 */