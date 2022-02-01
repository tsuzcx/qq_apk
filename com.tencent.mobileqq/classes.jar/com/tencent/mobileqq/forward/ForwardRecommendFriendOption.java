package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ForwardRecommendFriendOption
  extends ForwardBaseOption
{
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  
  public ForwardRecommendFriendOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("structmsg_service_id", -1);
    if (i == 63) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B34", "0X8005B34", 0, 0, "", "", "", "");
    } else if (i == 84) {
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("pa_type", -1) == 53) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007018", "0X8007018", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007169", "0X8007169", 0, 0, "", "", "", "");
      }
    }
    super.a();
  }
  
  public boolean a()
  {
    super.a();
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("struct_msg_show_in_dialog"));
    if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localAbsStructMsg);
    }
    return true;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
    if (localObject != null)
    {
      paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardRecommendFriendOption", 2, "updateImageView addStructView");
      }
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), (LinearLayout.LayoutParams)localObject);
    }
    return true;
  }
  
  protected void b()
  {
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  protected void t()
  {
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("structmsg_service_id", -1);
    if (i == 63) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B35", "0X8005B35", 0, 0, "", "", "", "");
    } else if (i == 84) {
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("pa_type", -1) == 53) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007017", "0X8007017", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800716A", "0X800716A", 0, 0, "", "", "", "");
      }
    }
    super.t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardRecommendFriendOption
 * JD-Core Version:    0.7.0.1
 */