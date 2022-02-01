package cooperation.qzone;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class QzonePluginProxyActivity$1
  implements DialogInterface.OnClickListener
{
  QzonePluginProxyActivity$1(Context paramContext, int paramInt, String paramString, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!QZoneHelper.forwardQZoneApp(this.val$activity, this.val$qzSupVer, Long.valueOf(this.val$uin).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
      QZoneHelper.forwardH5QZone(this.val$intent.getStringExtra("sid"), this.val$activity);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.1
 * JD-Core Version:    0.7.0.1
 */