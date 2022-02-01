package com.tencent.mobileqq.emoticon;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class SogouEmojiTaskController$1
  implements DialogInterface.OnDismissListener
{
  SogouEmojiTaskController$1(SogouEmojiTaskController paramSogouEmojiTaskController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDismiss begins, mCurTaskId:" + this.a.a);
    }
    this.a.a(this.a.a);
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDismiss ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmojiTaskController.1
 * JD-Core Version:    0.7.0.1
 */