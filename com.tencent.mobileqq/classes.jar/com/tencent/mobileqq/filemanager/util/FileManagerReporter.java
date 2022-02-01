package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class FileManagerReporter
{
  public static void a(String paramString)
  {
    Object localObject = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject).b = paramString;
    ((FileManagerReporter.FileAssistantReportData)localObject).a = paramString;
    boolean bool = ((FileManagerReporter.FileAssistantReportData)localObject).i;
    ReportController.b(null, "CliOper", "", "", ((FileManagerReporter.FileAssistantReportData)localObject).a, ((FileManagerReporter.FileAssistantReportData)localObject).b, ((FileManagerReporter.FileAssistantReportData)localObject).c, ((FileManagerReporter.FileAssistantReportData)localObject).g, bool ^ true, String.valueOf(((FileManagerReporter.FileAssistantReportData)localObject).h), ((FileManagerReporter.FileAssistantReportData)localObject).f, FileManagerReporter.FileAssistantReportData.a((FileManagerReporter.FileAssistantReportData)localObject), ((FileManagerReporter.FileAssistantReportData)localObject).d);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report key:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("FileManagerReporter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(String paramString, FileManagerReporter.FileAssistantReportData paramFileAssistantReportData)
  {
    boolean bool = paramFileAssistantReportData.i;
    ReportController.b(null, "CliOper", "", "", paramFileAssistantReportData.a, paramFileAssistantReportData.b, paramFileAssistantReportData.c, paramFileAssistantReportData.g, bool ^ true, String.valueOf(paramFileAssistantReportData.h), paramFileAssistantReportData.f, FileManagerReporter.FileAssistantReportData.a(paramFileAssistantReportData), paramFileAssistantReportData.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerReporter
 * JD-Core Version:    0.7.0.1
 */