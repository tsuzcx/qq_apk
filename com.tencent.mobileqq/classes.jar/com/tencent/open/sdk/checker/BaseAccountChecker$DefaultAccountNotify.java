package com.tencent.open.sdk.checker;

import android.content.Context;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class BaseAccountChecker$DefaultAccountNotify
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  
  public BaseAccountChecker$DefaultAccountNotify(Context paramContext, String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = 2131694663;
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1) {
      this.c = 2131694665;
    } else {
      this.c = 2131694664;
    }
    this.d = 2131690728;
  }
  
  public void a(BaseAccountChecker.DefaultAccountNotify.DialogBtnClickListener paramDialogBtnClickListener)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230);
    localQQCustomDialog.setTitle(this.b);
    localQQCustomDialog.setMessage(this.jdField_a_of_type_JavaLangString);
    BaseAccountChecker.DefaultAccountNotify.1 local1 = new BaseAccountChecker.DefaultAccountNotify.1(this, paramDialogBtnClickListener);
    localQQCustomDialog.setPositiveButton(this.c, local1);
    if (this.jdField_a_of_type_Int == 2) {
      localQQCustomDialog.setNegativeButton(this.d, local1);
    }
    localQQCustomDialog.setOnCancelListener(new BaseAccountChecker.DefaultAccountNotify.2(this, paramDialogBtnClickListener));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.sdk.checker.BaseAccountChecker.DefaultAccountNotify
 * JD-Core Version:    0.7.0.1
 */