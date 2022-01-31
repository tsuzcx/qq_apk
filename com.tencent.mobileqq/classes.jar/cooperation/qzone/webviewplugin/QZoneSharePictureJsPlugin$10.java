package cooperation.qzone.webviewplugin;

import becq;
import bjsx;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;

public class QZoneSharePictureJsPlugin$10
  implements Runnable
{
  public QZoneSharePictureJsPlugin$10(bjsx parambjsx, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.a != null) && (this.this$0.a.mRuntime != null)) {
        QQToast.a(this.this$0.a.mRuntime.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0).a();
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.w("QZoneSharePictureJsPlugin", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */