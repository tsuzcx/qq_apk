package cooperation.qzone.webviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class QZoneWebViewJsHandleLogic$5
  implements DialogInterface.OnClickListener
{
  QZoneWebViewJsHandleLogic$5(QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$mDialog.isShowing()) {
      this.val$mDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.5
 * JD-Core Version:    0.7.0.1
 */