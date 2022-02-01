package com.tencent.open.agent;

import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.qphone.base.util.QLog;

class CreateVirtualAccountFragment$6$1
  implements Runnable
{
  CreateVirtualAccountFragment$6$1(CreateVirtualAccountFragment.6 param6, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a.b();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onUploadAvatar isSuccess = " + this.jdField_a_of_type_Boolean + " filePath ==" + this.jdField_a_of_type_JavaLangString + " headid==" + this.b);
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a).getText()))
      {
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a, HardCodeUtil.a(2131702660), false);
        return;
      }
      String str = CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a).getText().toString();
      QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + str + " headId==" + this.b);
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a);
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a).a(CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a), str, this.b, CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a));
      return;
    }
    CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a, HardCodeUtil.a(2131702662) + this.jdField_a_of_type_Int, false);
    QLog.d("CreateVirtualAccountFragment", 1, "upload avatar failed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6.1
 * JD-Core Version:    0.7.0.1
 */