package com.tencent.open.agent;

import alud;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import bfdy;
import com.tencent.open.model.CreateVirtualResult;
import com.tencent.qphone.base.util.QLog;

public class CreateVirtualAccountFragment$6$2
  implements Runnable
{
  public CreateVirtualAccountFragment$6$2(bfdy parambfdy, boolean paramBoolean, CreateVirtualResult paramCreateVirtualResult, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bfdy.a.b();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onCreatVirtual isSuccess = " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult != null)
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> onCreatVirtual isSuccess = " + this.jdField_a_of_type_Boolean + " vi == virtualId ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long + " headUrl ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_JavaLangString);
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a, alud.a(2131703009), true);
        Intent localIntent = new Intent();
        localIntent.putExtra("createVirtualAccount", 1);
        localIntent.putExtra("createVirtualVid", this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_Bfdy.a.getActivity() != null)
        {
          this.jdField_a_of_type_Bfdy.a.getActivity().setResult(101, localIntent);
          this.jdField_a_of_type_Bfdy.a.getActivity().finish();
        }
      }
      return;
    }
    CreateVirtualAccountFragment.a(this.jdField_a_of_type_Bfdy.a, alud.a(2131703011) + this.jdField_a_of_type_Int, false);
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