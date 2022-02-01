package com.tencent.mobileqq.troop.homework.entry.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;

class SubmitHomeWorkFragment$4
  implements DialogInterface.OnClickListener
{
  SubmitHomeWorkFragment$4(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, HomeworkInfo paramHomeworkInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (this.b.G > 0L)
    {
      this.b.a(this.a);
      return;
    }
    this.b.a(3, null, null, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.4
 * JD-Core Version:    0.7.0.1
 */