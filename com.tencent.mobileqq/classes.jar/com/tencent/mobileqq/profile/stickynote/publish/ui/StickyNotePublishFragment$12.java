package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.statistics.ReportController;

class StickyNotePublishFragment$12
  implements DialogInterface.OnClickListener
{
  StickyNotePublishFragment$12(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.b.obtainMessage(3, "").sendToTarget();
    ReportController.b(null, "dc00898", "", "", "0X800AB31", "0X800AB31", 2, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.12
 * JD-Core Version:    0.7.0.1
 */