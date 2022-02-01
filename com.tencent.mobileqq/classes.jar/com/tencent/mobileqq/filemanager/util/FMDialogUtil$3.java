package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableString;
import bglp;
import bgpa;

public final class FMDialogUtil$3
  implements Runnable
{
  public FMDialogUtil$3(Context paramContext, CharSequence paramCharSequence, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void run()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaLangCharSequence instanceof String))
      {
        bglp.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaLangCharSequence, 2131692060, 2131692064, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.b).show();
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangCharSequence instanceof SpannableString));
    bglp.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangCharSequence, 2131692060, 2131692064, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.b).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMDialogUtil.3
 * JD-Core Version:    0.7.0.1
 */