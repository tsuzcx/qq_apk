package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import android.os.Handler;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientHolder;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class PageWebview
  extends BasePageWebview
{
  private static final String TAG = "PageWebview";
  private static final boolean enableEmbeddedElementConfig;
  private static final boolean enableEmbeddedLiveConfig;
  private static final boolean enableEmbeddedVideoConfiog;
  private AppBrandPageContainer mAppBrandPageContainer;
  private BrandPageWebview mBrandPageWebview;
  private IMiniAppContext mContext;
  private EmbeddedState mEmbeddedState;
  protected EmbeddedWidgetClientFactory mEmbeddedWidgetClientFactory;
  private boolean mPageJsLoadSucc = false;
  private ShareState mShareState;
  public int scrollY;
  public ArrayList<PageWebview.OnWebviewScrollListener> webviewScrollListenerList;
  
  static
  {
    boolean bool2 = true;
    boolean bool1;
    if (WnsConfig.getConfig("qqminiapp", "enable_embedded_video", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    enableEmbeddedVideoConfiog = bool1;
    if (WnsConfig.getConfig("qqminiapp", "enable_embedded_live", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    enableEmbeddedLiveConfig = bool1;
    if (WnsConfig.getConfig("qqminiapp", "enable_embedded_element", 1) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    enableEmbeddedElementConfig = bool1;
  }
  
  public PageWebview(IMiniAppContext paramIMiniAppContext, AppBrandPageContainer paramAppBrandPageContainer, BrandPageWebview paramBrandPageWebview)
  {
    super(paramIMiniAppContext.getContext(), paramAppBrandPageContainer);
    this.mContext = paramIMiniAppContext;
    this.mAppBrandPageContainer = paramAppBrandPageContainer;
    this.mBrandPageWebview = paramBrandPageWebview;
    this.mShareState = new ShareState();
    this.mEmbeddedState = new EmbeddedState();
    init();
  }
  
  public static Bitmap createBitmap(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      QMLog.e("PageWebview", "createBitmap failed", localOutOfMemoryError1);
      System.gc();
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QMLog.e("PageWebview", "createBitmap failed again", localOutOfMemoryError2);
      }
    }
    return null;
  }
  
  private void reportEmbeddedSupportResult(int paramInt, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new PageWebview.1(this, paramInt, paramString));
  }
  
  public static Bitmap screenShot(WebView paramWebView, int paramInt1, int paramInt2)
  {
    if ((paramWebView != null) && (paramInt1 > 0))
    {
      if (paramInt2 <= 0) {
        return null;
      }
      Bitmap localBitmap = createBitmap(paramInt1, paramInt2);
      if (localBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      if (paramWebView.getX5WebViewExtension() != null)
      {
        PaintFlagsDrawFilter localPaintFlagsDrawFilter = new PaintFlagsDrawFilter(134, 64);
        paramInt2 = QbSdk.getTbsVersion(paramWebView.getContext());
        if ((paramInt2 >= 43000) && (paramInt2 < 43105))
        {
          f = paramInt1 / paramWebView.getMeasuredWidth();
          localCanvas.scale(f, f);
          localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
          paramWebView.getX5WebViewExtension().snapshotVisible(localCanvas, false, false, false, false);
          QMLog.d("PageWebview", "snapshot with snapshotVisible()");
        }
        else
        {
          f = paramInt1 / paramWebView.getContentWidth();
          localCanvas.scale(f, f);
          localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
          paramWebView.getX5WebViewExtension().snapshotWholePage(localCanvas, false, false);
          QMLog.d("PageWebview", "snapshot with snapshotWholePage()");
        }
        localCanvas.setDrawFilter(null);
        return localBitmap;
      }
      float f = paramInt1 / paramWebView.getMeasuredWidth();
      localCanvas.scale(f, f);
      paramWebView = paramWebView.capturePicture();
      if (paramWebView != null) {
        paramWebView.draw(localCanvas);
      }
      return localBitmap;
    }
    return null;
  }
  
  public void destroy()
  {
    super.destroy();
    Object localObject = this.mAppBrandPageContainer;
    if (localObject != null) {
      ((AppBrandPageContainer)localObject).notifyOnPageWebViewDestory();
    }
    localObject = this.mEmbeddedWidgetClientFactory;
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap() != null))
    {
      localObject = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.webViewDestroy();
        }
        ((Iterator)localObject).remove();
      }
    }
  }
  
  public EmbeddedState getEmbeddedState()
  {
    return this.mEmbeddedState;
  }
  
  public EmbeddedWidgetClientFactory getEmbeddedWidgetClientFactory()
  {
    return this.mEmbeddedWidgetClientFactory;
  }
  
  public ShareState getShareState()
  {
    return this.mShareState;
  }
  
  public boolean handleBackPressed()
  {
    BrandPageWebview localBrandPageWebview = this.mBrandPageWebview;
    if (localBrandPageWebview != null) {
      return localBrandPageWebview.handleBackPressed();
    }
    return false;
  }
  
  public void init()
  {
    boolean bool3 = false;
    setScrollBarStyle(0);
    if (getX5WebViewExtension() != null) {
      getX5WebViewExtension().setVerticalTrackDrawable(null);
    }
    for (;;)
    {
      boolean bool5;
      try
      {
        if (getX5WebViewExtension() != null)
        {
          long l = System.currentTimeMillis();
          this.mEmbeddedWidgetClientFactory = new EmbeddedWidgetClientFactory();
          Object localObject1 = getX5WebViewExtension();
          Object localObject2 = this.mEmbeddedWidgetClientFactory;
          bool4 = ((IX5WebViewExtension)localObject1).registerEmbeddedWidget(new String[] { "video" }, localObject2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("registerEmbeddedWidget : ");
          ((StringBuilder)localObject1).append(bool4);
          ((StringBuilder)localObject1).append("; ");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
          QMLog.d("miniapp-embedded", ((StringBuilder)localObject1).toString());
          if (!bool4) {
            reportEmbeddedSupportResult(780, "registerEmbeddedWidget false");
          }
          localObject1 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
          if (((MiniAppProxy)localObject1).isDebugVersion())
          {
            localObject1 = ((MiniAppProxy)localObject1).getAccount();
            localObject2 = AppLoaderFactory.g().getContext();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("_user_embedded_video_");
            bool1 = ((Context)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("_user_embedded_video_", true);
            localObject2 = AppLoaderFactory.g().getContext();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("_user_embedded_live_");
            bool5 = ((Context)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("_user_embedded_live_", true);
            if ((bool4) && (bool1))
            {
              bool1 = true;
              break label410;
            }
          }
          else
          {
            if ((!bool4) || (!enableEmbeddedVideoConfiog)) {
              break label434;
            }
            bool1 = true;
            if ((!bool4) || (!enableEmbeddedLiveConfig)) {
              break label439;
            }
            bool2 = true;
            if ((!bool4) || (!enableEmbeddedElementConfig)) {
              break label444;
            }
            bool4 = true;
            bool3 = bool1;
            bool1 = bool4;
            this.mEmbeddedState.setEnableEmbeddedVideo(bool3);
            this.mEmbeddedState.setEnableEmbeddedLive(bool2);
            this.mEmbeddedState.setEnableEmbeddedElement(bool1);
          }
        }
        else
        {
          reportEmbeddedSupportResult(780, "getX5WebViewExtension null");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "registerEmbeddedWidget error,", localThrowable);
        return;
      }
      boolean bool1 = false;
      label410:
      boolean bool2 = bool3;
      if (bool4)
      {
        bool2 = bool3;
        if (bool5) {
          bool2 = true;
        }
      }
      bool3 = bool1;
      bool1 = bool4;
      continue;
      label434:
      bool1 = false;
      continue;
      label439:
      bool2 = false;
      continue;
      label444:
      boolean bool4 = false;
      bool3 = bool1;
      bool1 = bool4;
    }
  }
  
  public void onHide()
  {
    if (this.mAppBrandPageContainer.getShowingPage() != null)
    {
      String str = this.mAppBrandPageContainer.getShowingPage().getCurShowingUrl();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHide :");
      localStringBuilder.append(str);
      localStringBuilder.append("  id:");
      localStringBuilder.append(this.mPageWebviewId);
      QMLog.d("PageWebview", localStringBuilder.toString());
      ThreadManager.getSubThreadHandler().post(new PageWebview.2(this, str));
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pagewebview onPause, id is  ");
    ((StringBuilder)localObject).append(this.mPageWebviewId);
    QMLog.d("PageWebview", ((StringBuilder)localObject).toString());
    localObject = this.mAppBrandPageContainer;
    if (localObject != null) {
      ((AppBrandPageContainer)localObject).notifyOnPageWebViewPause(this.mPageWebviewId);
    }
    localObject = this.mBrandPageWebview;
    if (localObject != null) {
      ((BrandPageWebview)localObject).evaluateJs("document.title=\"\"", null);
    }
    localObject = this.mEmbeddedWidgetClientFactory;
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap() != null))
    {
      localObject = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.webViewPause();
        }
      }
    }
    onHide();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("pagewebview onResume, id is ");
    ((StringBuilder)localObject1).append(this.mPageWebviewId);
    QMLog.d("PageWebview", ((StringBuilder)localObject1).toString());
    localObject1 = this.mAppBrandPageContainer;
    if (localObject1 != null) {
      ((AppBrandPageContainer)localObject1).notifyOnPageWebViewResume();
    }
    Object localObject2;
    if ((this.mBrandPageWebview != null) && (this.mAppBrandPageContainer != null))
    {
      localObject1 = this.mContext;
      if (localObject1 != null)
      {
        if (((IMiniAppContext)localObject1).getMiniAppInfo() != null) {
          localObject1 = this.mContext.getMiniAppInfo().appId;
        } else {
          localObject1 = null;
        }
        if (this.mAppBrandPageContainer.getShowingPage() != null) {
          localObject2 = this.mAppBrandPageContainer.getShowingPage().getCurShowingUrl();
        } else {
          localObject2 = null;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\"");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(":");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(":VISIBLE\"");
        localObject1 = localStringBuilder.toString();
        localObject2 = this.mBrandPageWebview;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("document.title=");
        localStringBuilder.append((String)localObject1);
        ((BrandPageWebview)localObject2).evaluateJs(localStringBuilder.toString(), null);
      }
    }
    localObject1 = this.mEmbeddedWidgetClientFactory;
    if ((localObject1 != null) && (((EmbeddedWidgetClientFactory)localObject1).getEmbeddedWidgetClientHolderMap() != null))
    {
      localObject1 = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EmbeddedWidgetClientHolder)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject2 != null) {
          ((EmbeddedWidgetClientHolder)localObject2).webViewResume();
        }
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.webviewScrollListenerList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.webviewScrollListenerList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PageWebview.OnWebviewScrollListener)((Iterator)localObject).next()).onVerticalScroll(paramInt2);
      }
    }
    this.scrollY = paramInt2;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject2.put("windowWidth", (int)(paramInt1 / DisplayUtil.getDensity(getContext())));
      localJSONObject2.put("windowHeight", (int)(paramInt2 / DisplayUtil.getDensity(getContext())));
      localJSONObject1.put("size", localJSONObject2);
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PageWebview", "onSizeChanged, JSONException!", localJSONException);
    }
    this.mContext.performAction(ServiceSubscribeEvent.obtain("onViewDidResize", localJSONObject1.toString(), getPageWebViewId()));
    if (this.mPageJsLoadSucc)
    {
      this.mBrandPageWebview.evaluateSubscribeJS("onViewDidResize", localJSONObject1.toString(), getPageWebViewId());
      return;
    }
    QMLog.d("PageWebview", "page not ready, do nothing.");
  }
  
  public void removeWebviewScrollListener(PageWebview.OnWebviewScrollListener paramOnWebviewScrollListener)
  {
    ArrayList localArrayList = this.webviewScrollListenerList;
    if ((localArrayList != null) && (localArrayList.contains(paramOnWebviewScrollListener))) {
      this.webviewScrollListenerList.remove(paramOnWebviewScrollListener);
    }
  }
  
  public void setOnWebviewScrollListener(PageWebview.OnWebviewScrollListener paramOnWebviewScrollListener)
  {
    if (this.webviewScrollListenerList == null) {
      this.webviewScrollListenerList = new ArrayList();
    }
    this.webviewScrollListenerList.add(paramOnWebviewScrollListener);
  }
  
  public void setPageJsLoadSucc(boolean paramBoolean)
  {
    this.mPageJsLoadSucc = paramBoolean;
  }
  
  public void shotWebview(PageWebview.WebviewShotCallback paramWebviewShotCallback)
  {
    ThreadManager.getSubThreadHandler().post(new PageWebview.3(this, paramWebviewShotCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebview
 * JD-Core Version:    0.7.0.1
 */