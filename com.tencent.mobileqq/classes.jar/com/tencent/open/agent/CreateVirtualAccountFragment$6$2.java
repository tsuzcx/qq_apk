package com.tencent.open.agent;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.model.CreateVirtualResult;
import com.tencent.qphone.base.util.QLog;

class CreateVirtualAccountFragment$6$2
  implements Runnable
{
  CreateVirtualAccountFragment$6$2(CreateVirtualAccountFragment.6 param6, boolean paramBoolean, CreateVirtualResult paramCreateVirtualResult, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a.b();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onCreateVirtual isSuccess = " + this.jdField_a_of_type_Boolean);
    Intent localIntent;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult != null)
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> onCreateVirtual isSuccess = " + this.jdField_a_of_type_Boolean + " vi == virtualId ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long + " headUrl ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_JavaLangString);
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a, HardCodeUtil.a(2131702657), true);
        localIntent = new Intent();
        localIntent.putExtra("createVirtualAccount", 1);
        localIntent.putExtra("createVirtualVid", this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a.getActivity() != null)
        {
          this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a.getActivity().setResult(101, localIntent);
          this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a.getActivity().finish();
        }
      }
      return;
    }
    if (this.jdField_a_of_type_Int == 151)
    {
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a, HardCodeUtil.a(2131707830), false);
      localIntent = new Intent();
      localIntent.putExtra("createVirtualAccount", 2);
      if (this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a.getActivity() != null)
      {
        this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a.getActivity().setResult(101, localIntent);
        this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a.getActivity().finish();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult != null) {
        QLog.d("CreateVirtualAccountFragment", 2, "========> onCreateVirtual isSuccess = " + this.jdField_a_of_type_Boolean + " vi == virtualId ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long + " headUrl ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_JavaLangString);
      }
      QLog.d("CreateVirtualAccountFragment", 1, "========> onCreateVirtual Failed code = " + this.jdField_a_of_type_Int);
      return;
      if (this.jdField_a_of_type_Int == 10670) {
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a, HardCodeUtil.a(2131707835), false);
      } else {
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment$6.a, HardCodeUtil.a(2131702659) + this.jdField_a_of_type_Int, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6.2
 * JD-Core Version:    0.7.0.1
 */