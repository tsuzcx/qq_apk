package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class FileManagerReporter
{
  public static void a(String paramString)
  {
    Object localObject = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = paramString;
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_JavaLangString = paramString;
    boolean bool = ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Boolean;
    ReportController.b(null, "CliOper", "", "", ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_JavaLangString, ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString, ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int, ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_Int, bool ^ true, String.valueOf(((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_Long), ((FileManagerReporter.FileAssistantReportData)localObject).d, FileManagerReporter.FileAssistantReportData.a((FileManagerReporter.FileAssistantReportData)localObject), ((FileManagerReporter.FileAssistantReportData)localObject).c);
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
    boolean bool = paramFileAssistantReportData.jdField_a_of_type_Boolean;
    ReportController.b(null, "CliOper", "", "", paramFileAssistantReportData.jdField_a_of_type_JavaLangString, paramFileAssistantReportData.jdField_b_of_type_JavaLangString, paramFileAssistantReportData.jdField_a_of_type_Int, paramFileAssistantReportData.jdField_b_of_type_Int, bool ^ true, String.valueOf(paramFileAssistantReportData.jdField_b_of_type_Long), paramFileAssistantReportData.d, FileManagerReporter.FileAssistantReportData.a(paramFileAssistantReportData), paramFileAssistantReportData.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerReporter
 * JD-Core Version:    0.7.0.1
 */