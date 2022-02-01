package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.stickynote.publish.bean.StickyDraftBean;
import com.tencent.mobileqq.statistics.ReportController;

class StickyNotePublishFragment$11
  implements DialogInterface.OnClickListener
{
  StickyNotePublishFragment$11(StickyNotePublishFragment paramStickyNotePublishFragment, StickyDraftBean paramStickyDraftBean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.b.b.obtainMessage(3, this.a).sendToTarget();
    ReportController.b(null, "dc00898", "", "", "0X800AB31", "0X800AB31", 1, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.11
 * JD-Core Version:    0.7.0.1
 */