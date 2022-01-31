import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;

public class rmy
  implements DialogInterface.OnClickListener
{
  public rmy(BaseChatPie paramBaseChatPie, AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.i("Q.aio.BaseChatPie", 2, "qbShowShareResultDialog back");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
          {
            Util.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "choose", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, "back");
            ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid), "1000", "51", "0", false);
          }
          Util.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(1);
        } while (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true));
        try
        {
          paramDialogInterface = (PendingIntent)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
          if ((paramDialogInterface != null) && ((paramDialogInterface instanceof PendingIntent)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getBooleanExtra("share_from_aio", false)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "-->finish--send callback using PendingIntent");
            }
            paramDialogInterface.send();
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().moveTaskToBack(true);
          return;
        }
        catch (Throwable paramDialogInterface) {}
      } while (!QLog.isColorLevel());
      QLog.e("Q.aio.BaseChatPie", 2, "qbShowShareResultDialog ", paramDialogInterface);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "-->qbShowShareResultDialog--stay");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null);
    Util.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "choose", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, "stay");
    ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid), "1000", "52", "0", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmy
 * JD-Core Version:    0.7.0.1
 */