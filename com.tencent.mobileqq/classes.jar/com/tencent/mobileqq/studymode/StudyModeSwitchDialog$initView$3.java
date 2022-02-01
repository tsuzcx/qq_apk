package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class StudyModeSwitchDialog$initView$3
  implements DialogInterface.OnDismissListener
{
  StudyModeSwitchDialog$initView$3(StudyModeSwitchDialog paramStudyModeSwitchDialog) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    StudyModeSwitchDialog.c(this.a).b((ModeSwitchManager.OnModeChangeResultCallback)this.a);
    StudyModeSwitchDialog.c(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeSwitchDialog.initView.3
 * JD-Core Version:    0.7.0.1
 */