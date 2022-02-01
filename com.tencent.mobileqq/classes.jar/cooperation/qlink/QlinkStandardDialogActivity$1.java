package cooperation.qlink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class QlinkStandardDialogActivity$1
  extends BroadcastReceiver
{
  QlinkStandardDialogActivity$1(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qlink.finishdlg".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity.1
 * JD-Core Version:    0.7.0.1
 */