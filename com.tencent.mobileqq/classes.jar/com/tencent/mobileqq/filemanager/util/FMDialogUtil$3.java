package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableString;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class FMDialogUtil$3
  implements Runnable
{
  FMDialogUtil$3(Context paramContext, CharSequence paramCharSequence, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (((localObject instanceof Activity)) && (((Activity)localObject).isFinishing())) {
      return;
    }
    localObject = this.jdField_a_of_type_JavaLangCharSequence;
    if ((localObject instanceof String))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_JavaLangString, (String)localObject, 2131692263, 2131692267, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.b).show();
      return;
    }
    if ((localObject instanceof SpannableString)) {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_JavaLangString, (CharSequence)localObject, 2131692263, 2131692267, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.b).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMDialogUtil.3
 * JD-Core Version:    0.7.0.1
 */