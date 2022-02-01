package com.tencent.mqp.app.sec;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;

final class MQPSensitiveMsgUtil$1
  implements DialogInterface.OnClickListener
{
  MQPSensitiveMsgUtil$1(String paramString1, int paramInt1, int paramInt2, QQMessageFacade paramQQMessageFacade, String paramString2, int paramInt3, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "P_CliOper", "Safe_SensMsg", this.jdField_a_of_type_JavaLangString, "Alert_Dialog", "Other", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
    ThreadManager.executeOnSubThread(new MQPSensitiveMsgUtil.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */