package com.tencent.qqmini.sdk.task;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;", "", "(Ljava/lang/String;I)V", "WAIT", "RUNNING", "SUCCESS", "FAIL", "CACHED", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
public enum TaskExecutionStatics$Status
{
  static
  {
    Status localStatus1 = new Status("WAIT", 0);
    WAIT = localStatus1;
    Status localStatus2 = new Status("RUNNING", 1);
    RUNNING = localStatus2;
    Status localStatus3 = new Status("SUCCESS", 2);
    SUCCESS = localStatus3;
    Status localStatus4 = new Status("FAIL", 3);
    FAIL = localStatus4;
    Status localStatus5 = new Status("CACHED", 4);
    CACHED = localStatus5;
    $VALUES = new Status[] { localStatus1, localStatus2, localStatus3, localStatus4, localStatus5 };
  }
  
  private TaskExecutionStatics$Status() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskExecutionStatics.Status
 * JD-Core Version:    0.7.0.1
 */