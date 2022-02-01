package dov.com.qq.im.ae.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.qq.im.ae.util.AEQLog;

final class AEResUtil$3
  implements DialogInterface.OnClickListener
{
  AEResUtil$3(String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEQLog.a("PreCheckAERes", "【showLightBundleDownloadDialog】dialog: choose sure, prefix = " + this.a);
    AEResUtil.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResUtil.3
 * JD-Core Version:    0.7.0.1
 */