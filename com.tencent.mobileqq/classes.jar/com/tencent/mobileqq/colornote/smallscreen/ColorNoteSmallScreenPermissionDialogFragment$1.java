package com.tencent.mobileqq.colornote.smallscreen;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.MobileQQ;

class ColorNoteSmallScreenPermissionDialogFragment$1
  implements DialogInterface.OnClickListener
{
  ColorNoteSmallScreenPermissionDialogFragment$1(ColorNoteSmallScreenPermissionDialogFragment paramColorNoteSmallScreenPermissionDialogFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ColorNoteSmallScreenPermissionUtil.d(MobileQQ.getContext());
    if (this.a.getQBaseActivity() != null)
    {
      this.a.getQBaseActivity().finish();
      this.a.getQBaseActivity().overridePendingTransition(0, 0);
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB3C", "0X800AB3C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment.1
 * JD-Core Version:    0.7.0.1
 */