package com.tencent.open.downloadnew;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.business.base.StaticAnalyz;

public class MyAppApi$ClickListenerProxy
  implements DialogInterface.OnClickListener
{
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public MyAppApi$ClickListenerProxy(MyAppApi paramMyAppApi, DialogInterface.OnClickListener paramOnClickListener, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_JavaLangString = StaticAnalyz.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
    paramDialogInterface.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    paramDialogInterface.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = null;
    StaticAnalyz.a("710", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.ClickListenerProxy
 * JD-Core Version:    0.7.0.1
 */