package com.tencent.mobileqq.forward;

import abgu;
import android.content.Intent;
import android.os.Bundle;
import avbr;
import bdll;
import bdow;
import bhpc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;

public class ForwardQZoneRichImageOption
  extends ForwardSdkBaseOption
{
  private boolean n;
  
  public ForwardQZoneRichImageOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public boolean a()
  {
    super.a();
    this.b = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    this.n = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_ec_live_share", false);
    if ((this.b > 0L) && (!this.n)) {
      abgu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.b, 0L, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
    I();
    Object localObject = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    ((Bundle)localObject).putInt("req_type", 1);
    localObject = bdow.a((Bundle)localObject);
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    }
    J();
    return true;
  }
  
  public boolean a(bhpc parambhpc)
  {
    if (this.n)
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_share_key_source_name");
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceIcon = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_share_key_source_icon");
    }
    if ((parambhpc != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null))
    {
      this.jdField_a_of_type_Avbr = new avbr(this, this.jdField_a_of_type_AndroidAppActivity);
      parambhpc.addView(this.jdField_a_of_type_Avbr.a());
      parambhpc.adjustMessageTopBottomMargin(0.0F, 10.0F);
      a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, parambhpc);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bhpc.setMessage("");
  }
  
  public boolean c()
  {
    K();
    return true;
  }
  
  public void d()
  {
    if (this.d)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.d = false;
    }
    super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQZoneRichImageOption
 * JD-Core Version:    0.7.0.1
 */