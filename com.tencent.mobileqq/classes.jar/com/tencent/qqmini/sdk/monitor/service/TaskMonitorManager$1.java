package com.tencent.qqmini.sdk.monitor.service;

import bdrs;
import bdrx;

public class TaskMonitorManager$1
  implements Runnable
{
  public TaskMonitorManager$1(bdrx parambdrx) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Long = this.this$0.c;
    this.this$0.c = bdrs.a("-1");
    long l2 = this.this$0.c;
    long l3 = this.this$0.jdField_a_of_type_Long;
    if (this.this$0.jdField_b_of_type_Boolean)
    {
      this.this$0.jdField_b_of_type_Long = this.this$0.d;
      this.this$0.d = bdrs.a("-2");
    }
    for (long l1 = this.this$0.d - this.this$0.jdField_b_of_type_Long;; l1 = 0L)
    {
      bdrx localbdrx = this.this$0;
      if ((this.this$0.d > 0L) && (l1 > 0L)) {}
      for (boolean bool = true;; bool = false)
      {
        localbdrx.jdField_b_of_type_Boolean = bool;
        if (!this.this$0.jdField_b_of_type_Boolean) {
          break;
        }
        this.this$0.jdField_a_of_type_Int = ((int)(100L * (l2 - l3) / l1));
        return;
      }
      this.this$0.jdField_a_of_type_Int = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager.1
 * JD-Core Version:    0.7.0.1
 */