package com.tencent.open.agent;

import ajya;
import android.text.TextUtils;
import android.widget.EditText;
import bdar;
import bdod;
import com.tencent.qphone.base.util.QLog;

public class CreateVirtualAccountFragment$6$1
  implements Runnable
{
  public CreateVirtualAccountFragment$6$1(bdar parambdar, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bdar.a.b();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onUploadAvatar isSuccess = " + this.jdField_a_of_type_Boolean + " filePath ==" + this.jdField_a_of_type_JavaLangString + " headid==" + this.b);
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdar.a).getText()))
      {
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdar.a, ajya.a(2131702628), false);
        return;
      }
      String str = CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdar.a).getText().toString();
      QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + str + " headId==" + this.b);
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdar.a);
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdar.a).a(CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdar.a), str, this.b, CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdar.a));
      return;
    }
    CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdar.a, ajya.a(2131702630) + this.jdField_a_of_type_Int, false);
    QLog.d("CreateVirtualAccountFragment", 1, "upload avatar failed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6.1
 * JD-Core Version:    0.7.0.1
 */