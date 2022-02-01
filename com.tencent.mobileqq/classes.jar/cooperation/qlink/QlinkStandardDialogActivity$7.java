package cooperation.qlink;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QlinkStandardDialogActivity$7
  implements DialogInterface.OnClickListener
{
  QlinkStandardDialogActivity$7(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.getQQProxyForQlink().a("0X8004750", 1);
    this.a.app.getQQProxyForQlink().a(new QlAndQQInterface.DailogClickInfo(9));
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("topAct:");
      if (QlinkStandardDialogActivity.a(this.a) != null) {
        paramDialogInterface = QlinkStandardDialogActivity.a(this.a).getLocalClassName();
      } else {
        paramDialogInterface = "null";
      }
      localStringBuilder.append(paramDialogInterface);
      QLog.d("QlinkStandardDialogActivity", 2, localStringBuilder.toString());
    }
    if (((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).isNeedFinish(QlinkStandardDialogActivity.a(this.a))) {
      return;
    }
    FileManagerUtil.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity.7
 * JD-Core Version:    0.7.0.1
 */