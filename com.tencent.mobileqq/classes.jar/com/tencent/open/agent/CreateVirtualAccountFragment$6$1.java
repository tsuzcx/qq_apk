package com.tencent.open.agent;

import alud;
import android.text.TextUtils;
import android.widget.EditText;
import bfdy;
import bfrj;
import com.tencent.qphone.base.util.QLog;

public class CreateVirtualAccountFragment$6$1
  implements Runnable
{
  public CreateVirtualAccountFragment$6$1(bfdy parambfdy, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bfdy.a.b();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onUploadAvatar isSuccess = " + this.jdField_a_of_type_Boolean + " filePath ==" + this.jdField_a_of_type_JavaLangString + " headid==" + this.b);
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a).getText()))
      {
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a, alud.a(2131703012), false);
        return;
      }
      String str = CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a).getText().toString();
      QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + str + " headId==" + this.b);
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a);
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a).a(CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a), str, this.b, CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a));
      return;
    }
    CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a, alud.a(2131703014) + this.jdField_a_of_type_Int, false);
    QLog.d("CreateVirtualAccountFragment", 1, "upload avatar failed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6.1
 * JD-Core Version:    0.7.0.1
 */