package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.font.FontInterface.TrueTypeResult;

class QzonePersonalizeJsPlugin$1
  implements FontInterface.TrueTypeResult
{
  QzonePersonalizeJsPlugin$1(QzonePersonalizeJsPlugin paramQzonePersonalizeJsPlugin) {}
  
  public void result(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzonePersonalizeJsPlugin", 4, "FontInterface.TrueTypeResult font:" + paramInt + ", fontPath:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      QzonePersonalizeJsPlugin.access$000(this.this$0, paramString2, -2, "font download failed.");
      return;
    }
    QzonePersonalizeJsPlugin.access$000(this.this$0, paramString2, 0, "success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzonePersonalizeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */