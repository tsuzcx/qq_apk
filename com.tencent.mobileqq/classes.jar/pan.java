import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class pan
  extends pav
{
  public pan(AbsBaseWebViewActivity paramAbsBaseWebViewActivity)
  {
    super(paramAbsBaseWebViewActivity, null);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pan
 * JD-Core Version:    0.7.0.1
 */