package dov.com.qq.im.ae;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.setting.IQIMCameraContainer;

class AEPituCameraUnit$34$1
  implements DialogInterface.OnClickListener
{
  AEPituCameraUnit$34$1(AEPituCameraUnit.34 param34) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEQLog.b(this.a.this$0.b, "PermissionDialog--onClick which=" + paramInt);
    Activity localActivity = this.a.this$0.a.a();
    if (paramInt == 1)
    {
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", localActivity.getPackageName(), null));
      localActivity.startActivity(localIntent);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.34.1
 * JD-Core Version:    0.7.0.1
 */