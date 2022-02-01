package cooperation.ilive.host.lite;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

class PluginWebViewWrapper$2
  implements cooperation.qzone.webviewwrapper.IWebviewListener
{
  PluginWebViewWrapper$2(PluginWebViewWrapper paramPluginWebViewWrapper, cooperation.ilive.host.lite.white.IWebviewListener paramIWebviewListener) {}
  
  public void onPageFinished()
  {
    cooperation.ilive.host.lite.white.IWebviewListener localIWebviewListener = this.val$listener;
    if (localIWebviewListener != null) {
      try
      {
        localIWebviewListener.getClass().getMethod("onPageFinished", new Class[0]).invoke(this.val$listener, new Object[0]);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.e("PluginWebViewWrapper", 1, "onPageFinished exception ", localThrowable);
      }
    }
  }
  
  public void onReceiveError(int paramInt, String paramString1, String paramString2)
  {
    if (this.val$listener != null) {
      try
      {
        Class localClass = Integer.TYPE;
        this.val$listener.getClass().getMethod("onReceiveError", new Class[] { localClass, String.class, String.class }).invoke(this.val$listener, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
        return;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        QLog.e("PluginWebViewWrapper", 1, "onReceiveError exception ", paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.lite.PluginWebViewWrapper.2
 * JD-Core Version:    0.7.0.1
 */