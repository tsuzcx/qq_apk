package cooperation.qzone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class QzonePluginProxyActivity$4$1$1
  implements DialogInterface.OnDismissListener
{
  QzonePluginProxyActivity$4$1$1(QzonePluginProxyActivity.4.1 param1) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.this$1.this$0.val$dismissListener != null) {
      this.this$1.this$0.val$dismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.4.1.1
 * JD-Core Version:    0.7.0.1
 */