import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.smtt.sdk.WebView;

public class pca
  implements LoadedBack2
{
  public pca(OfflinePlugin paramOfflinePlugin) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      WebUiBaseInterface localWebUiBaseInterface = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface)) && (((WebUiUtils.QQBrowserBaseActivityInterface)localWebUiBaseInterface).b() != localObject))
      {
        localObject = this.a.mRuntime.a();
        if (localObject != null) {
          try
          {
            localWebUiBaseInterface = this.a.mRuntime.a(this.a.mRuntime.a());
            if ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))
            {
              ((WebView)localObject).loadUrl(((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).b());
              return;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    Message localMessage = this.a.a.obtainMessage();
    localMessage.arg1 = 4;
    localMessage.arg2 = paramInt;
    this.a.a.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = this.a.a.obtainMessage();
    paramString.arg1 = 5;
    paramString.arg2 = paramInt;
    this.a.a.sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pca
 * JD-Core Version:    0.7.0.1
 */