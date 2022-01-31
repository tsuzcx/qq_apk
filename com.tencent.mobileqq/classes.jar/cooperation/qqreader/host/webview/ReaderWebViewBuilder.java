package cooperation.qqreader.host.webview;

import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import cooperation.qqreader.host.ActivityWrapper;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReaderWebViewBuilder
{
  private ReaderWebViewBuilder.InnerAbsWebView a;
  protected Handler mJsHandler;
  protected ReaderWebView mReaderWebView;
  
  public ReaderWebViewBuilder(ActivityWrapper paramActivityWrapper)
  {
    this(paramActivityWrapper, null);
  }
  
  public ReaderWebViewBuilder(ActivityWrapper paramActivityWrapper, ReaderWebView paramReaderWebView)
  {
    paramActivityWrapper = (Activity)paramActivityWrapper.getContext();
    this.a = new ReaderWebViewBuilder.InnerAbsWebView(this, paramActivityWrapper, paramActivityWrapper, (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    this.mReaderWebView = paramReaderWebView;
  }
  
  protected void addJavaScript(List<ReaderBaseWebViewPlugin> paramList) {}
  
  public ReaderWebView getWebView()
  {
    return this.mReaderWebView;
  }
  
  public void initWebView()
  {
    this.a.a(this.mReaderWebView);
    onWebViewReady();
  }
  
  public void onCreate()
  {
    this.a.onCreate();
  }
  
  public void onDestroy()
  {
    this.a.onDestroy();
  }
  
  protected void onPageFinished(ReaderWebView paramReaderWebView, String paramString) {}
  
  protected void onPageStarted(ReaderWebView paramReaderWebView, String paramString) {}
  
  public void onPause()
  {
    this.a.onPause();
  }
  
  protected void onReceivedError(ReaderWebView paramReaderWebView, String paramString1, int paramInt, String paramString2) {}
  
  public void onResume()
  {
    this.a.onResume();
  }
  
  protected void onWebViewReady() {}
  
  public void setHandler(Handler paramHandler)
  {
    this.mJsHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.webview.ReaderWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */