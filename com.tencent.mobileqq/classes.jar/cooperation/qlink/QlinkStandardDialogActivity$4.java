package cooperation.qlink;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class QlinkStandardDialogActivity$4
  implements DialogInterface.OnClickListener
{
  QlinkStandardDialogActivity$4(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.getQQProxyForQlink().a(new QlAndQQInterface.DailogClickInfo(4));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity.4
 * JD-Core Version:    0.7.0.1
 */