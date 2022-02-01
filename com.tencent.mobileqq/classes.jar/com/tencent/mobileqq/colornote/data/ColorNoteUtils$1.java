package com.tencent.mobileqq.colornote.data;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class ColorNoteUtils$1
  implements DialogInterface.OnClickListener
{
  ColorNoteUtils$1(QQCustomDialog paramQQCustomDialog, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    ColorNoteSmallScreenUtil.a(this.jdField_a_of_type_AndroidContentContext, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteUtils.1
 * JD-Core Version:    0.7.0.1
 */