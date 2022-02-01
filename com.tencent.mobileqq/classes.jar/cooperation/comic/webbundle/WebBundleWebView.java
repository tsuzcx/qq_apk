package cooperation.comic.webbundle;

import android.content.Context;
import android.util.AttributeSet;
import apub;
import aqbj;
import bkhi;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import com.tencent.webbundle.sdk.IWebBundleWebView.OnPageFinishedListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class WebBundleWebView
  extends TouchWebView
  implements IWebBundleWebView
{
  public WebBundleWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebBundleWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean canGoBack()
  {
    Object localObject = copyBackForwardList();
    if ((localObject != null) && (((WebBackForwardList)localObject).getSize() > 0))
    {
      localObject = ((WebBackForwardList)localObject).getItemAtIndex(0);
      if (localObject != null)
      {
        localObject = ((WebHistoryItem)localObject).getUrl();
        QQComicConfBean localQQComicConfBean = (QQComicConfBean)apub.a().a(534);
        if ((localQQComicConfBean != null) && (localQQComicConfBean.a.a.equals(localObject))) {
          return super.canGoBackOrForward(-2);
        }
      }
    }
    return super.canGoBack();
  }
  
  public void dispatchJsEvent(@NotNull String paramString, @NotNull JSONObject paramJSONObject1, @Nullable JSONObject paramJSONObject2)
  {
    callJs(WebViewPlugin.toJsScript(paramString, paramJSONObject1, paramJSONObject2));
  }
  
  public void enableJavaScript(boolean paramBoolean)
  {
    getSettings().setJavaScriptEnabled(paramBoolean);
  }
  
  public void setOnPageFinishedListener(@NotNull IWebBundleWebView.OnPageFinishedListener paramOnPageFinishedListener)
  {
    setWebViewClient(new bkhi(this, paramOnPageFinishedListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.comic.webbundle.WebBundleWebView
 * JD-Core Version:    0.7.0.1
 */