package cooperation.qzone.webviewplugin;

import bioy;
import bnmr;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;

public class QZoneSharePictureJsPlugin$11
  implements Runnable
{
  public QZoneSharePictureJsPlugin$11(bnmr parambnmr, int paramInt, String paramString) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */