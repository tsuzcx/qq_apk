package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;

class QZoneSharePictureJsPlugin$11
  implements Runnable
{
  QZoneSharePictureJsPlugin$11(QZoneSharePictureJsPlugin paramQZoneSharePictureJsPlugin, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.parentPlugin != null) && (this.this$0.parentPlugin.mRuntime != null))
      {
        QQToast.makeText(this.this$0.parentPlugin.mRuntime.d(), this.val$icon, this.val$msg, 0).show();
        return;
      }
    }
    catch (Exception localException)
    {
      QZLog.w("QZoneSharePictureJsPlugin", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */