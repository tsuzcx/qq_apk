package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.n;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.u;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import com.tencent.xweb.y;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkHitTestResult.type;
import org.xwalk.core.XWalkLibraryLoader;
import org.xwalk.core.XWalkNavigationHistory;
import org.xwalk.core.XWalkNavigationHistory.Direction;
import org.xwalk.core.XWalkNavigationItem;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkProxyWebViewClientExtension;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;
import org.xwalk.core.resource.XWalkContextWrapper;

public class k
  implements IWebView, com.tencent.xweb.internal.g
{
  static int l;
  private boolean A = false;
  WebView a;
  l b;
  XWalkView c;
  AbsoluteLayout d;
  y e = new y();
  u f = new u();
  h g;
  int h = XWalkEnvironment.getAvailableVersion();
  long i = 0L;
  x j;
  boolean k = false;
  m m;
  o n;
  private int o = 0;
  private String p = null;
  private XWalkProxyWebViewClientExtension q = new k.1(this);
  private com.tencent.xweb.x5.export.external.extension.proxy.a r = new com.tencent.xweb.x5.export.external.extension.proxy.a();
  private b s;
  private aa t = null;
  private final int u = 0;
  private final int v = 1;
  private final int w = 2;
  private boolean x = false;
  private boolean y = false;
  private Handler z;
  
  public k(WebView paramWebView)
  {
    XWalkContextWrapper localXWalkContextWrapper = new XWalkContextWrapper(paramWebView.getContext(), this.h);
    XWalkLibraryLoader.prepareToInit(localXWalkContextWrapper);
    try
    {
      XWalkPreferences.setValue("xweb-version", String.valueOf(this.h));
      XWalkPreferences.setValue("xwebsdk-version", String.valueOf(201201));
    }
    catch (Exception localException)
    {
      Log.e("XWWebView", localException.getMessage());
    }
    this.c = new k.a(this, localXWalkContextWrapper);
    this.d = new AbsoluteLayout(localXWalkContextWrapper);
    this.c.getXWalkContentView().addView(this.d);
    this.c.setCustomOnScrollChangedListener(new k.5(this));
    this.c.setCustomOnOverScrolledListener(new k.6(this));
    this.g = new h(this.c);
    this.a = paramWebView;
    d();
    b(this.c.getContext());
    this.z = new k.7(this);
  }
  
  static void a(WebView paramWebView1, WebView paramWebView2)
  {
    paramWebView1 = (XWalkView)paramWebView1.getWebViewUI();
    paramWebView2 = (XWalkView)paramWebView2.getWebViewUI();
    paramWebView1 = paramWebView1.getBridge();
    paramWebView2 = paramWebView2.getBridge();
    try
    {
      Class localClass = XWalkCoreWrapper.getInstance().getClass("org.xwalk.core.internal.XWalkViewInternal");
      if (localClass == null) {
        return;
      }
      new ReflectMethod(localClass, "completesWindowCreation", new Class[] { localClass, localClass }).invoke(new Object[] { paramWebView1, paramWebView2 });
      return;
    }
    catch (Exception paramWebView1)
    {
      paramWebView2 = new StringBuilder();
      paramWebView2.append("completeWindowCreation reflect failed, e:");
      paramWebView2.append(paramWebView1.toString());
      Log.e("XWWebView", paramWebView2.toString());
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (!this.x) {
      return;
    }
    if (this.y) {
      return;
    }
    this.y = true;
    Log.i("XWWebView", "getTranslateTipsView");
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, 144);
    localLayoutParams.gravity = 51;
    TextView localTextView = new TextView(this.a.getContext());
    localTextView.setGravity(17);
    localTextView.setText(paramString);
    localTextView.setTextColor(Color.argb(127, 0, 0, 0));
    localTextView.setTextSize(0, 42.0F);
    if (paramBoolean) {
      localTextView.setBackgroundColor(-328966);
    } else {
      localTextView.setBackgroundColor(-855310);
    }
    ((ViewGroup)this.a.getParent()).addView(localTextView, localLayoutParams);
    ((FrameLayout.LayoutParams)this.a.getLayoutParams()).topMargin = 144;
    this.a.requestLayout();
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      com.tencent.xweb.xwalk.updater.f.a(paramContext);
      boolean bool = com.tencent.xweb.xwalk.updater.f.c();
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initFullscreenVideo:");
    localStringBuilder.append(getFullscreenVideoKind());
    Log.i("XWWebView", localStringBuilder.toString());
    this.s = com.tencent.xweb.extension.video.f.a(paramContext, this.a, this.c, com.tencent.xweb.extension.video.e.b());
    if (getFullscreenVideoKind() == WebView.a.c) {
      this.s.a(this.c);
    }
  }
  
  private void e()
  {
    this.r.onMiscCallBack("onTranslateStart", new Bundle());
  }
  
  private void f()
  {
    this.r.onMiscCallBack("onTranslateFinish", new Bundle());
  }
  
  void a()
  {
    if (this.m != null) {
      return;
    }
    this.m = new k.3(this, this.c);
    this.g.a(this.m);
    this.c.setUIClient(this.m);
    this.n = new k.4(this, this.c);
    this.g.a(this.n);
    this.c.setResourceClient(this.n);
  }
  
  public void a(View paramView, boolean paramBoolean, n paramn)
  {
    if (XWalkCoreWrapper.getInstance().hasFeature(2)) {}
    try
    {
      Class localClass = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.screenshot.LongScreenShotManager");
      if (localClass == null) {
        return;
      }
      new ReflectMethod(localClass, "startLongScreenShot", new Class[] { View.class, Boolean.TYPE, Object.class }).invoke(new Object[] { paramView, Boolean.valueOf(paramBoolean), XWalkCoreWrapper.getInstance().getBridgeObject(new g.d(paramn)) });
      return;
    }
    catch (Exception paramView)
    {
      label97:
      break label97;
    }
    Log.e("XWWebView", "startLongScreenShot reflect failed");
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.c.addJavascriptInterface(paramObject, paramString);
  }
  
  public boolean b()
  {
    return this.A;
  }
  
  public Object c()
  {
    XWalkView localXWalkView = this.c;
    if (localXWalkView == null)
    {
      Log.e("XWWebView", "getXWalkBridge mwebview == null");
      return null;
    }
    return localXWalkView.getBridge();
  }
  
  public boolean canGoBack()
  {
    if (this.k) {
      return false;
    }
    XWalkNavigationHistory localXWalkNavigationHistory = this.c.getNavigationHistory();
    if (localXWalkNavigationHistory == null) {
      return false;
    }
    return localXWalkNavigationHistory.canGoBack();
  }
  
  public boolean canGoForward()
  {
    if (this.c.getNavigationHistory() != null) {
      return this.c.getNavigationHistory().canGoForward();
    }
    return false;
  }
  
  public Bitmap captureBitmap()
  {
    Object localObject = ((ViewGroup)((ViewGroup)this.c.getChildAt(0)).getChildAt(0)).getChildAt(0);
    if ((localObject instanceof TextureView))
    {
      localObject = ((TextureView)localObject).getBitmap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("captureBitmap with ");
      localStringBuilder.append(localObject);
      Log.d("XWWebView", localStringBuilder.toString());
      return localObject;
    }
    return null;
  }
  
  public void captureBitmap(IWebView.a parama)
  {
    View localView = ((ViewGroup)((ViewGroup)this.c.getChildAt(0)).getChildAt(0)).getChildAt(0);
    if ((localView instanceof TextureView)) {
      new Thread(new k.10(this, localView, parama)).start();
    }
  }
  
  public void clearHistory()
  {
    if (this.c.getNavigationHistory() != null) {
      this.c.getNavigationHistory().clear();
    }
  }
  
  public void clearMatches()
  {
    this.c.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    this.c.clearSslPreferences();
  }
  
  public void clearView() {}
  
  public WebBackForwardList copyBackForwardList()
  {
    return new q(this.c.getNavigationHistory());
  }
  
  void d()
  {
    this.b = new l(this.c);
    this.c.getSettings().SetLogCallBack(new k.9(this));
  }
  
  public void destroy()
  {
    this.c.onDestroy();
  }
  
  public void disableVideoJsCallback(boolean paramBoolean)
  {
    b localb = this.s;
    if (localb != null) {
      localb.a(paramBoolean);
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    this.c.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public void findAllAsync(String paramString)
  {
    this.c.findAllAsync(paramString);
  }
  
  public void findNext(boolean paramBoolean)
  {
    this.c.findNext(paramBoolean);
  }
  
  public String getAbstractInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webviewtype = xwalk, sdkver = 201201\n apkver = ");
    localStringBuilder.append(XWalkEnvironment.getAvailableVersion());
    return localStringBuilder.toString();
  }
  
  public int getContentHeight()
  {
    return this.c.getContentHeight();
  }
  
  public u getCurWebChromeClient()
  {
    return this.f;
  }
  
  public y getCurWebviewClient()
  {
    return this.e;
  }
  
  public com.tencent.xweb.internal.e getDefalutOpProvider()
  {
    return this.g;
  }
  
  public WebView.a getFullscreenVideoKind()
  {
    return com.tencent.xweb.a.d(WebView.getCurStrModule());
  }
  
  public WebView.b getHitTestResult()
  {
    WebView.b localb = new WebView.b();
    XWalkHitTestResult localXWalkHitTestResult = this.c.getHitTestResult();
    localb.a(localXWalkHitTestResult.getType().ordinal());
    localb.a(localXWalkHitTestResult.getExtra());
    return localb;
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    return z.a().a(paramString1, paramString2);
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, com.tencent.xweb.g paramg)
  {
    return this.c.getImageBitmapToFile(paramString1, paramString2, paramString3, new k.2(this, paramg));
  }
  
  public float getScale()
  {
    return this.c.getScale();
  }
  
  public int getScrollHeight()
  {
    return this.c.computeVerticalScrollRange();
  }
  
  public w getSettings()
  {
    return this.b;
  }
  
  public String getTitle()
  {
    return this.c.getTitle();
  }
  
  public ViewGroup getTopView()
  {
    return this.d;
  }
  
  public String getUrl()
  {
    return this.c.getUrl();
  }
  
  public String getVersionInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webviewType = WV_KIND_CW,V8 type=");
    localStringBuilder.append(JsRuntime.b());
    localStringBuilder.append(" ,apkversion = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" , ");
    localStringBuilder.append(XWalkEnvironment.getAvailableVersionDetail());
    localStringBuilder.append(" sdk = ");
    localStringBuilder.append(201201);
    return localStringBuilder.toString();
  }
  
  public View getView()
  {
    return this.c;
  }
  
  public int getVisibleTitleHeight()
  {
    return 0;
  }
  
  public int getWebScrollX()
  {
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView)) {
      return ((XWalkView)localView).computeHorizontalScrollOffset();
    }
    return localView.getScrollX();
  }
  
  public int getWebScrollY()
  {
    return this.c.computeVerticalScrollOffset();
  }
  
  public View getWebViewUI()
  {
    return this.c;
  }
  
  public Object getX5WebViewExtension()
  {
    return null;
  }
  
  public void goBack()
  {
    if (this.c.getNavigationHistory() == null) {
      return;
    }
    if (this.c.getNavigationHistory().canGoBack())
    {
      this.c.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.BACKWARD, 1);
      if ((this.c.getNavigationHistory() != null) && (this.c.getNavigationHistory().getCurrentItem() != null)) {
        this.f.a(this.a, this.c.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
  }
  
  public void goForward()
  {
    if (this.c.getNavigationHistory().canGoForward())
    {
      this.c.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.FORWARD, 1);
      if ((this.c.getNavigationHistory() != null) && (this.c.getNavigationHistory().getCurrentItem() != null)) {
        this.f.a(this.a, this.c.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
  }
  
  public boolean hasEnteredFullscreen()
  {
    return this.c.hasEnteredFullscreen();
  }
  
  public Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" method string is ");
      ((StringBuilder)localObject1).append(paramString);
      Log.d("XWWebView", ((StringBuilder)localObject1).toString());
      boolean bool;
      if (paramString.equals("supportTranslateWebSite"))
      {
        bool = XWalkCoreWrapper.getInstance().isSupportTranslateWebSite();
        paramString = new Bundle();
        paramString.putBoolean("result", bool);
        paramBundle = new StringBuilder();
        paramBundle.append("translate: xweb is supportTranslateWebSite = ");
        paramBundle.append(bool);
        Log.i("XWWebView", paramBundle.toString());
        return paramString;
      }
      if (paramString.equals("getTranslateSampleString"))
      {
        Log.i("XWWebView", "translate: xweb is detectTranslateWebSiteIsNeeded ,getTranslateSampleString");
        this.c.getTranslateSampleString(0);
        return null;
      }
      if (paramString.equals("translateWebSite"))
      {
        Log.i("XWWebView", "translate: do translateWebSite");
        paramBundle.getString("url");
        this.x = true;
        return null;
      }
      if (paramString.equals("replaceTranslatedString"))
      {
        paramString = new StringBuilder();
        paramString.append("translate: replaceTranslatedString mIsTranslateMode =");
        paramString.append(this.x);
        Log.i("XWWebView", paramString.toString());
        if (!this.x) {
          return null;
        }
        paramString = (HashMap)paramBundle.getSerializable("translate_hashmap");
        bool = paramBundle.getBoolean("is_mp_url");
        paramBundle = paramBundle.getString("translate_tips");
        localObject1 = new HashMap();
        Object localObject2 = paramString.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (String)((Iterator)localObject2).next();
          String str = (String)paramString.get(localObject3);
          if ((localObject3 != null) && (!((String)localObject3).isEmpty()) && (str != null) && (!str.isEmpty()))
          {
            if ((str.trim().length() != 0) && (!str.trim().equals("\n")) && (!str.trim().equals("\r")))
            {
              ((HashMap)localObject1).put(localObject3, str);
            }
            else
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("translate: string is space  or change line  value = ");
              ((StringBuilder)localObject3).append(str);
              Log.d("XWWebView", ((StringBuilder)localObject3).toString());
            }
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("translate: string is err !!!  key = ");
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append(" value = ");
            localStringBuilder.append(str);
            Log.d("XWWebView", localStringBuilder.toString());
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("translate: replaceTranslatedString orghashmap size = ");
        ((StringBuilder)localObject2).append(paramString.size());
        ((StringBuilder)localObject2).append(" resultHashMap size = ");
        ((StringBuilder)localObject2).append(((HashMap)localObject1).size());
        Log.d("XWWebView", ((StringBuilder)localObject2).toString());
        this.c.replaceTranslatedString((Map)localObject1);
        a(Boolean.valueOf(bool).booleanValue(), paramBundle);
        Log.d("XWWebView", "translate: onTranslateFinish ");
        f();
      }
      return null;
    }
    Log.d("XWWebView", " method string is null or empty");
    return null;
  }
  
  public boolean isOverScrollStart()
  {
    boolean bool = b();
    View localView = getWebViewUI();
    int i1;
    if ((localView instanceof XWalkView)) {
      i1 = ((XWalkView)localView).computeVerticalScrollOffset();
    } else {
      i1 = localView.getScrollY();
    }
    return (i1 == 0) && (bool);
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    return this.c.isSupportExtendPluginForAppbrand();
  }
  
  public void leaveFullscreen()
  {
    this.c.leaveFullscreen();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.c.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.c.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if ((paramString != null) && (paramString.trim().startsWith("javascript:")))
    {
      this.c.evaluateJavascript(paramString, null);
      return;
    }
    this.k = false;
    this.c.loadUrl(paramString);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    this.c.loadUrl(paramString, paramMap);
  }
  
  public void onHide()
  {
    this.c.onHide();
  }
  
  public void onPause()
  {
    this.c.onPause();
  }
  
  public void onResume()
  {
    this.c.onResume();
  }
  
  public void onShow()
  {
    this.c.onShow();
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    int i1 = this.c.getScrollBarStyle();
    return (i1 == 0) || (i1 == 33554432);
  }
  
  public void reload()
  {
    this.c.reload(0);
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    this.c.removeJavascriptInterface(paramString);
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView)) {
      return ((XWalkView)localView).savePage(paramString1, paramString2, paramInt);
    }
    return false;
  }
  
  public void setBottomHeight(int paramInt)
  {
    Log.e("XWWebView", "setBottomHeight not implement");
    this.c.setBottomHeight(paramInt);
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    this.c.setDownloadListener(new g.f(this.a.getContext(), paramDownloadListener));
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    this.c.setFindListener(new g.g(paramFindListener));
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    this.c.setHorizontalScrollBarEnable(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    z.a().a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setJSExceptionListener(aa paramaa)
  {
    this.t = paramaa;
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    this.c.setVerticalScrollBarEnable(paramBoolean);
  }
  
  public r setVideoJsCallback(s params)
  {
    b localb = this.s;
    if ((localb != null) && (localb.b(params))) {
      return new k.8(this);
    }
    Log.i("XWWebView", "setVideoJsCallback not support");
    return null;
  }
  
  public void setWebChromeClient(u paramu)
  {
    if (paramu == null)
    {
      this.f = new u();
      return;
    }
    a();
    this.f = paramu;
  }
  
  public void setWebViewCallbackClient(x paramx)
  {
    this.j = paramx;
  }
  
  public void setWebViewClient(y paramy)
  {
    if (paramy == null)
    {
      this.e = new y();
      this.e.a(this.g);
      return;
    }
    a();
    this.e = paramy;
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    this.r = parama;
    this.c.setProxyWebViewClientExtension(this.q);
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    this.c.smoothScroll(paramInt1, paramInt2, paramLong);
  }
  
  public void stopLoading()
  {
    this.c.stopLoading();
  }
  
  public void super_computeScroll() {}
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean supportFeature(int paramInt)
  {
    return XWalkCoreWrapper.getInstance().hasFeature(paramInt);
  }
  
  public boolean zoomIn()
  {
    return this.c.zoomIn();
  }
  
  public boolean zoomOut()
  {
    return this.c.zoomOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k
 * JD-Core Version:    0.7.0.1
 */