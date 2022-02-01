package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TaskOfflineUtils$TaskAsyncBack
  implements AsyncBack
{
  private final int jdField_a_of_type_Int;
  private final TaskOfflineUtils.OfflineCallBack jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskTaskOfflineUtils$OfflineCallBack;
  private final String jdField_a_of_type_JavaLangString;
  
  public TaskOfflineUtils$TaskAsyncBack(String paramString, int paramInt, TaskOfflineUtils.OfflineCallBack paramOfflineCallBack)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskTaskOfflineUtils$OfflineCallBack = paramOfflineCallBack;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void loaded(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new TaskOfflineUtils.TaskAsyncBack.1(this, paramString, paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils.TaskAsyncBack
 * JD-Core Version:    0.7.0.1
 */