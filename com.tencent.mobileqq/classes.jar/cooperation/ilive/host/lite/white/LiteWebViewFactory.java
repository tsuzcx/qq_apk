package cooperation.ilive.host.lite.white;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import cooperation.ilive.host.lite.PluginWebViewWrapper;

public class LiteWebViewFactory
{
  public static void doWebSoRequest(String paramString)
  {
    if (WebSoUtils.b(paramString)) {
      ThreadManager.postImmediately(new LiteWebViewFactory.1(paramString), null, false);
    }
  }
  
  public static IWebviewWrapper getWebViewWrapper(IJsAdapter paramIJsAdapter, View paramView)
  {
    return new PluginWebViewWrapper(paramIJsAdapter, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.lite.white.LiteWebViewFactory
 * JD-Core Version:    0.7.0.1
 */