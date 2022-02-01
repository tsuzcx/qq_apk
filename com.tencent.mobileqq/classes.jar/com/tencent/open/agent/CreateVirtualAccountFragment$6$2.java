package com.tencent.open.agent;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import anvx;
import bjcm;
import com.tencent.open.model.CreateVirtualResult;
import com.tencent.qphone.base.util.QLog;

public class CreateVirtualAccountFragment$6$2
  implements Runnable
{
  public CreateVirtualAccountFragment$6$2(bjcm parambjcm, boolean paramBoolean, CreateVirtualResult paramCreateVirtualResult, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bjcm.a.b();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onCreateVirtual isSuccess = " + this.jdField_a_of_type_Boolean);
    Intent localIntent;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult != null)
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> onCreateVirtual isSuccess = " + this.jdField_a_of_type_Boolean + " vi == virtualId ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long + " headUrl ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_JavaLangString);
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a, anvx.a(2131702109), true);
        localIntent = new Intent();
        localIntent.putExtra("createVirtualAccount", 1);
        localIntent.putExtra("createVirtualVid", this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_Bjcm.a.getActivity() != null)
        {
          this.jdField_a_of_type_Bjcm.a.getActivity().setResult(101, localIntent);
          this.jdField_a_of_type_Bjcm.a.getActivity().finish();
        }
      }
      return;
    }
    if (this.jdField_a_of_type_Int == 151)
    {
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a, anvx.a(2131707305), false);
      localIntent = new Intent();
      localIntent.putExtra("createVirtualAccount", 2);
      if (this.jdField_a_of_type_Bjcm.a.getActivity() != null)
      {
        this.jdField_a_of_type_Bjcm.a.getActivity().setResult(101, localIntent);
        this.jdField_a_of_type_Bjcm.a.getActivity().finish();
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
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a, anvx.a(2131707310), false);
      } else {
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bjcm.a, anvx.a(2131702111) + this.jdField_a_of_type_Int, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6.2
 * JD-Core Version:    0.7.0.1
 */