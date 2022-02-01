package cooperation.qlink;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class QlinkStandardDialogActivity$7
  implements DialogInterface.OnClickListener
{
  QlinkStandardDialogActivity$7(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.getQQProxyForQlink().a("0X8004750", 1);
    this.a.app.getQQProxyForQlink().a(new QlAndQQInterface.DailogClickInfo(9));
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("topAct:");
      if (QlinkStandardDialogActivity.a(this.a) == null) {
        break label150;
      }
    }
    label150:
    for (paramDialogInterface = QlinkStandardDialogActivity.a(this.a).getLocalClassName();; paramDialogInterface = "null")
    {
      QLog.d("QlinkStandardDialogActivity", 2, paramDialogInterface);
      if ((QlinkStandardDialogActivity.a(this.a) == null) || (!(QlinkStandardDialogActivity.a(this.a) instanceof FMActivity))) {
        break;
      }
      paramDialogInterface = (FMActivity)QlinkStandardDialogActivity.a(this.a);
      if ((paramDialogInterface.e() != 0) && (7 != paramDialogInterface.e())) {
        break;
      }
      this.a.finish();
      return;
    }
    FileManagerUtil.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity.7
 * JD-Core Version:    0.7.0.1
 */