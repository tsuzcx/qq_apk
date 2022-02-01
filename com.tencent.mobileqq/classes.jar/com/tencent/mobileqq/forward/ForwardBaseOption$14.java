package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;

class ForwardBaseOption$14
  implements DialogInterface.OnClickListener
{
  ForwardBaseOption$14(ForwardBaseOption paramForwardBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1) {
        return;
      }
      if (this.a.c) {
        ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.a.jdField_a_of_type_Long), "1000", "52", "0", false, this.a.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--onClick--send call");
      }
      paramDialogInterface = new Intent();
      paramDialogInterface.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.a.jdField_a_of_type_Long), "shareToQQ" })));
      paramDialogInterface.setPackage(this.a.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("pkg_name"));
      paramDialogInterface = PendingIntent.getActivity(this.a.jdField_a_of_type_AndroidAppActivity, 0, paramDialogInterface, 268435456);
      Intent localIntent = new Intent();
      localIntent.putExtra("is_share_flag", true);
      if (this.a.jdField_a_of_type_Long > 0L) {
        localIntent.putExtra("activity_finish_run_pendingIntent", paramDialogInterface);
      }
      QfavHelper.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, -1, true);
      QfavReport.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5, 0);
      this.a.jdField_a_of_type_AndroidAppActivity.setResult(1);
      return;
    }
    if (this.a.c) {
      ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.a.jdField_a_of_type_Long), "1000", "51", "0", false, this.a.c);
    }
    this.a.a(true);
    this.a.jdField_a_of_type_AndroidAppActivity.setResult(1);
    this.a.jdField_a_of_type_AndroidAppActivity.finish();
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--onClick--back call");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.14
 * JD-Core Version:    0.7.0.1
 */