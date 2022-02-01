package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ModeChoiceViewContainer$5
  implements DialogInterface.OnClickListener
{
  ModeChoiceViewContainer$5(ModeChoiceViewContainer paramModeChoiceViewContainer, Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof QQCustomDialog)) {
      ((QQCustomDialog)paramDialogInterface).setOnDismissListener(null);
    }
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.5
 * JD-Core Version:    0.7.0.1
 */