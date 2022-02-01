package com.tencent.mobileqq.troop.homework.recite.ui;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;

final class ReciteFragment$11
  implements DialogInterface.OnClickListener
{
  @SuppressLint({"NewApi"})
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      ((android.content.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Feed Debug Info", this.jdField_a_of_type_JavaLangString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment.11
 * JD-Core Version:    0.7.0.1
 */