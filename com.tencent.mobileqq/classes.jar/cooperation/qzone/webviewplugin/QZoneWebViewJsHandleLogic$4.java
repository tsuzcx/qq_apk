package cooperation.qzone.webviewplugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;

final class QZoneWebViewJsHandleLogic$4
  implements DialogInterface.OnClickListener
{
  QZoneWebViewJsHandleLogic$4(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (QUA.getQUA3().indexOf("GM") < 0) {
        QZoneWebViewJsHandleLogic.handleUrl(QzoneConfig.getInstance().getConfig("H5Url", "DownloadQzoneClient", "https://m.qzone.com/client/fwd?bid=update&_wv=7"), this.val$context);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("showQzoneAppDownloadDialog", 2, "simpleBrowserJump exception", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.4
 * JD-Core Version:    0.7.0.1
 */