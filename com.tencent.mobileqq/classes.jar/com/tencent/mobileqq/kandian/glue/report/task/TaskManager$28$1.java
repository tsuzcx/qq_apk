package com.tencent.mobileqq.kandian.glue.report.task;

import java.util.TimerTask;

class TaskManager$28$1
  extends TimerTask
{
  public void run()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    JSContext localJSContext = this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext;
    if (localJSContext != null)
    {
      localJSContext.a(this.jdField_a_of_type_JavaLangString, localStringBuffer);
      TaskManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskTaskManager$28.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskTaskManager, localStringBuffer, this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskTaskManager$28.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskTask, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager.28.1
 * JD-Core Version:    0.7.0.1
 */