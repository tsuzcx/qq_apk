package cooperation.qzone.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class QzoneVideoTabJsPlugin$1
  implements QQPermissionCallback
{
  QzoneVideoTabJsPlugin$1(QzoneVideoTabJsPlugin paramQzoneVideoTabJsPlugin, String[] paramArrayOfString, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(QzoneVideoTabJsPlugin.access$100(this.val$activity));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QzoneVideoTabJsPlugin.access$000(this.this$0, this.val$args[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */