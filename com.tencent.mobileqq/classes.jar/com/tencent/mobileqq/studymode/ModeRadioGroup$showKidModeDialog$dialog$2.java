package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class ModeRadioGroup$showKidModeDialog$dialog$2
  implements DialogInterface.OnClickListener
{
  ModeRadioGroup$showKidModeDialog$dialog$2(ModeRadioGroup paramModeRadioGroup, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.getContext(), 1, 2131694475, 1).a();
      return;
    }
    if (ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup)) {
      ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup, this.jdField_a_of_type_Int, true, false, 4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeRadioGroup.showKidModeDialog.dialog.2
 * JD-Core Version:    0.7.0.1
 */