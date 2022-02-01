package com.tencent.webbundle.sdk;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;

public class WebBundle$WebBundleInterface
{
  private WeakReference<IStateHolder<WebBundle.WebBundlePreloadState>> holderRef;
  private String json = "";
  
  public WebBundle$WebBundleInterface(IStateHolder<WebBundle.WebBundlePreloadState> paramIStateHolder)
  {
    Object localObject;
    this.holderRef = new WeakReference(localObject);
  }
  
  @JavascriptInterface
  public String getData()
  {
    IStateHolder localIStateHolder = (IStateHolder)this.holderRef.get();
    if (localIStateHolder != null) {
      WebBundleManager.getInstance(WebBundle.access$000(this.this$0)).log(3, "WebBundle.WebBundle", new String[] { "[use][step 2][#", String.valueOf(localIStateHolder.hashCode()), "] h5 get real data: ", this.json });
    }
    return this.json;
  }
  
  public String getJson()
  {
    return this.json;
  }
  
  @JavascriptInterface
  public void preloadViewSuccess()
  {
    IStateHolder localIStateHolder = (IStateHolder)this.holderRef.get();
    if (localIStateHolder != null)
    {
      WebBundleManager.getInstance(WebBundle.access$000(this.this$0)).log(3, "WebBundle.WebBundle", new String[] { "[preload][step 3][#", String.valueOf(localIStateHolder.hashCode()), "] receive preload success callback from h5." });
      localIStateHolder.setPreloadState(WebBundle.WebBundlePreloadState.SUCCESS);
    }
  }
  
  public void setJson(@NotNull String paramString)
  {
    this.json = paramString;
  }
  
  @JavascriptInterface
  public void setWebBundleOption(int paramInt)
  {
    Object localObject = (IStateHolder)this.holderRef.get();
    if (localObject != null) {
      WebBundleManager.getInstance(WebBundle.access$000(this.this$0)).log(3, "WebBundle.WebBundle", new String[] { "[@", String.valueOf(localObject.hashCode()), "][setWebBundleOption] useWebBundle = ", String.valueOf(paramInt) });
    }
    localObject = WebBundleManager.getInstance(WebBundle.access$000(this.this$0)).getConfig();
    if ((localObject != null) && (((WebBundleConfig)localObject).getOptionListener() != null))
    {
      localObject = ((WebBundleConfig)localObject).getOptionListener();
      if (paramInt == 0) {
        break label106;
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      ((WebBundleH5OptionListner)localObject).enableWebBundle(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.webbundle.sdk.WebBundle.WebBundleInterface
 * JD-Core Version:    0.7.0.1
 */