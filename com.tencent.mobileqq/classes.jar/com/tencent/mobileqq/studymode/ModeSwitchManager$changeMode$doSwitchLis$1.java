package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class ModeSwitchManager$changeMode$doSwitchLis$1
  implements DialogInterface.OnClickListener
{
  ModeSwitchManager$changeMode$doSwitchLis$1(ModeSwitchManager paramModeSwitchManager, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof QQCustomDialog)) {
      ((QQCustomDialog)paramDialogInterface).setOnDismissListener(null);
    }
    ModeSwitchManager.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeSwitchManager, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeSwitchManager.changeMode.doSwitchLis.1
 * JD-Core Version:    0.7.0.1
 */