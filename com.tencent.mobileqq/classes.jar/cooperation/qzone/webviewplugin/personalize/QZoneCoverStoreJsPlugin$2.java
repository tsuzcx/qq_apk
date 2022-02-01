package cooperation.qzone.webviewplugin.personalize;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import mqq.app.QQPermissionCallback;

class QZoneCoverStoreJsPlugin$2
  implements QQPermissionCallback
{
  QZoneCoverStoreJsPlugin$2(QZoneCoverStoreJsPlugin paramQZoneCoverStoreJsPlugin, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.this$0.mRuntime.d());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QZoneCoverStoreJsPlugin.access$000(this.this$0, this.val$offset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */