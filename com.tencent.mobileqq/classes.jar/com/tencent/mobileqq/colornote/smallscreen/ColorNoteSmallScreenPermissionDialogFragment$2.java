package com.tencent.mobileqq.colornote.smallscreen;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;

class ColorNoteSmallScreenPermissionDialogFragment$2
  implements DialogInterface.OnCancelListener
{
  ColorNoteSmallScreenPermissionDialogFragment$2(ColorNoteSmallScreenPermissionDialogFragment paramColorNoteSmallScreenPermissionDialogFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB3B", "0X800AB3B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */