package com.tencent.mobileqq.debug;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.EditText;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class DatongVerifyManager$showVerifyToggleDialog$dialog$1
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    DatongVerifyManager.a.a(str);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("ACTION_TOGGLE_DATONG_VERIFY", str).apply();
    paramDialogInterface.dismiss();
    DatongVerifyManager.a(DatongVerifyManager.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.DatongVerifyManager.showVerifyToggleDialog.dialog.1
 * JD-Core Version:    0.7.0.1
 */