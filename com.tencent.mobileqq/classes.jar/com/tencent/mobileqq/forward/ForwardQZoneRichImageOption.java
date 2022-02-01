package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ForwardQZoneRichImageOption
  extends ForwardSdkBaseOption
{
  private boolean o;
  
  public ForwardQZoneRichImageOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    if (this.d)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.d = false;
    }
    super.a();
  }
  
  public boolean a()
  {
    super.a();
    this.b = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    this.o = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_ec_live_share", false);
    if ((this.b > 0L) && (!this.o)) {
      Share.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.b, 0L, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
    I();
    Object localObject = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    ((Bundle)localObject).putInt("req_type", 1);
    localObject = StructMsgFactory.a((Bundle)localObject);
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    }
    J();
    return true;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if (this.o)
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_share_key_source_name");
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceIcon = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_share_key_source_icon");
    }
    if ((paramQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption$PreStructViewHolder = new ForwardSdkBaseOption.PreStructViewHolder(this, this.jdField_a_of_type_AndroidAppActivity);
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption$PreStructViewHolder.a());
      paramQQCustomDialog.adjustMessageTopBottomMargin(0.0F, 10.0F);
      a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, paramQQCustomDialog);
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
  }
  
  protected boolean c()
  {
    K();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQZoneRichImageOption
 * JD-Core Version:    0.7.0.1
 */