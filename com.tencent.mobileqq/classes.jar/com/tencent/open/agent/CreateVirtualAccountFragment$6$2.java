package com.tencent.open.agent;

import ajyc;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import bdac;
import com.tencent.open.model.CreateVirtualResult;
import com.tencent.qphone.base.util.QLog;

public class CreateVirtualAccountFragment$6$2
  implements Runnable
{
  public CreateVirtualAccountFragment$6$2(bdac parambdac, boolean paramBoolean, CreateVirtualResult paramCreateVirtualResult, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bdac.a.b();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onCreatVirtual isSuccess = " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult != null)
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> onCreatVirtual isSuccess = " + this.jdField_a_of_type_Boolean + " vi == virtualId ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long + " headUrl ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_JavaLangString);
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdac.a, ajyc.a(2131702614), true);
        Intent localIntent = new Intent();
        localIntent.putExtra("createVirtualAccount", 1);
        localIntent.putExtra("createVirtualVid", this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_Bdac.a.getActivity() != null)
        {
          this.jdField_a_of_type_Bdac.a.getActivity().setResult(101, localIntent);
          this.jdField_a_of_type_Bdac.a.getActivity().finish();
        }
      }
      return;
    }
    CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bdac.a, ajyc.a(2131702616) + this.jdField_a_of_type_Int, false);
    if (this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult != null) {
      QLog.d("CreateVirtualAccountFragment", 2, "========> onCreatVirtual isSuccess = " + this.jdField_a_of_type_Boolean + " vi == virtualId ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long + " headUrl ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_JavaLangString);
    }
    QLog.d("CreateVirtualAccountFragment", 1, "========> onCreatVirtual Failed code = " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6.2
 * JD-Core Version:    0.7.0.1
 */