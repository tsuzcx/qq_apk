package cooperation.qzone.webviewplugin;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;

class QzoneWebViewOfflinePlugin$3
  extends Handler
{
  QzoneWebViewOfflinePlugin$3(QzoneWebViewOfflinePlugin paramQzoneWebViewOfflinePlugin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof WebSoCgiService.WebSoCgiState)) {
      return;
    }
    if (paramMessage.what == 204) {
      this.this$0.onCgiRsp((WebSoCgiService.WebSoCgiState)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin.3
 * JD-Core Version:    0.7.0.1
 */