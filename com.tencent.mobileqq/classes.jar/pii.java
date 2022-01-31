import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class pii
  implements Runnable
{
  pii(pih parampih) {}
  
  public void run()
  {
    if ((this.a.a.mRuntime != null) && (this.a.a.mRuntime.a() != null)) {}
    try
    {
      this.a.a.a(this.a.a.mRuntime.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebSoPlugin", 1, "asynJudgmentDynamicCover, useSoftwareMode err, ExceptionMsg = " + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pii
 * JD-Core Version:    0.7.0.1
 */