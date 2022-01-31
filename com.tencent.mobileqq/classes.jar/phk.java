import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;

public class phk
  extends Handler
{
  public phk(QzoneWebViewOfflinePlugin paramQzoneWebViewOfflinePlugin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof WebSoCgiService.WebSoCgiState)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((WebSoCgiService.WebSoCgiState)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phk
 * JD-Core Version:    0.7.0.1
 */