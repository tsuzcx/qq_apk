package com.tencent.mobileqq.kandian.glue.report.task;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.ClipboardUtil;
import com.tencent.common.app.BaseApplicationImpl;

class TaskManager$13$1$1
  implements DialogInterface.OnClickListener
{
  TaskManager$13$1$1(TaskManager.13.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ClipboardUtil.a(BaseApplicationImpl.getContext(), this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager.13.1.1
 * JD-Core Version:    0.7.0.1
 */