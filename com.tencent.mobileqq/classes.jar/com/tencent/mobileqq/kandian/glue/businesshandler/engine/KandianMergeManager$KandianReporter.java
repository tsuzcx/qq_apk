package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.base.report.ReadInJoyDataProviderObserver.Reporter;
import com.tencent.mobileqq.kandian.glue.report.task.TaskManager;

public class KandianMergeManager$KandianReporter
  extends ReadInJoyDataProviderObserver.Reporter
{
  protected void report(String paramString)
  {
    TaskManager.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.KandianReporter
 * JD-Core Version:    0.7.0.1
 */