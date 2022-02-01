package com.tencent.mobileqq.filemanager.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class FileManagerReporter
{
  public static void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
      localFileAssistantReportData.jdField_b_of_type_JavaLangString = paramString;
      localFileAssistantReportData.jdField_a_of_type_JavaLangString = paramString;
      if (localFileAssistantReportData.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", localFileAssistantReportData.jdField_a_of_type_JavaLangString, localFileAssistantReportData.jdField_b_of_type_JavaLangString, localFileAssistantReportData.jdField_a_of_type_Int, localFileAssistantReportData.jdField_b_of_type_Int, i, String.valueOf(localFileAssistantReportData.jdField_b_of_type_Long), localFileAssistantReportData.d, FileManagerReporter.FileAssistantReportData.a(localFileAssistantReportData), localFileAssistantReportData.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, FileManagerReporter.FileAssistantReportData paramFileAssistantReportData)
  {
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramFileAssistantReportData.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        ReportController.b(paramString, "CliOper", "", "", paramFileAssistantReportData.jdField_a_of_type_JavaLangString, paramFileAssistantReportData.jdField_b_of_type_JavaLangString, paramFileAssistantReportData.jdField_a_of_type_Int, paramFileAssistantReportData.jdField_b_of_type_Int, i, String.valueOf(paramFileAssistantReportData.jdField_b_of_type_Long), paramFileAssistantReportData.d, FileManagerReporter.FileAssistantReportData.a(paramFileAssistantReportData), paramFileAssistantReportData.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerReporter
 * JD-Core Version:    0.7.0.1
 */