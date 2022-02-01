package com.tencent.open.agent;

import android.text.TextUtils;
import android.widget.EditText;
import anvx;
import bjcm;
import bjqa;
import com.tencent.qphone.base.util.QLog;

public class CreateVirtualAccountFragment$6$1
  implements Runnable
{
  public CreateVirtualAccountFragment$6$1(bjcm parambjcm, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bjcm.a.b();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onUploadAvatar isSuccess = " + this.jdField_a_of_type_Boolean + " filePath ==" + this.jdField_a_of_type_JavaLangString + " headid==" + this.b);
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a).getText()))
      {
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a, anvx.a(2131702112), false);
        return;
      }
      String str = CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a).getText().toString();
      QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + str + " headId==" + this.b);
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a);
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a).a(CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a), str, this.b, CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a));
      return;
    }
    CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a, anvx.a(2131702114) + this.jdField_a_of_type_Int, false);
    QLog.d("CreateVirtualAccountFragment", 1, "upload avatar failed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6.1
 * JD-Core Version:    0.7.0.1
 */