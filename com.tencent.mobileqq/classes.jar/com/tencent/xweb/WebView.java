package com.tencent.xweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.internal.f;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWebCoreInfo;

public class WebView
  extends FrameLayout
  implements IWebView
{
  static WebView.c b = WebView.c.a;
  static String c = "";
  static boolean d = false;
  static com.tencent.luggage.wxa.st.b i;
  private int a = -1;
  IWebView e;
  WebView.c f = WebView.c.a;
  com.tencent.xweb.internal.d g;
  View.OnLongClickListener h;
  protected boolean j = false;
  
  static {}
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, 0, WebView.c.a);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.c paramc)
  {
    super(a(paramContext), paramAttributeSet, paramInt);
    a(paramc);
  }
  
  public static boolean _initWebviewCore(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback, boolean paramBoolean)
  {
    try
    {
      paramBoolean = a(paramContext, paramc, paramPreInitCallback, true, false);
      return paramBoolean;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static Context a(Context paramContext)
  {
    Object localObject = paramContext;
    if ((paramContext instanceof MutableContextWrapper)) {
      localObject = new WebView.e(((MutableContextWrapper)paramContext).getBaseContext());
    }
    return localObject;
  }
  
  private List<TextureView> a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof TextureView))
    {
      localArrayList.add((TextureView)paramView);
      return localArrayList;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int k = 0;
      while (k < paramView.getChildCount())
      {
        localArrayList.addAll(a(paramView.getChildAt(k)));
        k += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(WebView.c paramc)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start to init, prefer type = ");
    ((StringBuilder)localObject).append(getCurWebType());
    ((StringBuilder)localObject).append(" , forcetype = ");
    ((StringBuilder)localObject).append(paramc);
    org.xwalk.core.Log.i("xweb.WebView", ((StringBuilder)localObject).toString());
    if (XWalkEnvironment.getApplicationContext() == null) {
      XWalkEnvironment.init(getContext());
    }
    if (this.f != WebView.c.a) {
      return;
    }
    if (getCurWebType() == WebView.c.a)
    {
      _initWebviewCore(getContext(), WebView.c.d, null, true);
      org.xwalk.core.Log.e("xweb.Webview", "use xweb without init, force to use sys web");
    }
    if (com.tencent.xweb.internal.h.a().e())
    {
      this.f = WebView.c.d;
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "isTestingSys, force to use sys web");
    }
    else if (paramc == WebView.c.d)
    {
      this.f = paramc;
      paramc = l.a(WebView.c.d);
      if (paramc != null) {
        paramc.initWebviewCore(getContext(), null);
      }
    }
    else
    {
      this.f = getCurWebType();
    }
    this.e = l.a(this.f, this);
    if (this.e == null)
    {
      paramc = new WebView.c[3];
      paramc[0] = WebView.c.b;
      paramc[1] = WebView.c.d;
      paramc[2] = WebView.c.c;
      int k = 0;
      while (k < paramc.length)
      {
        if ((paramc[k] != this.f) && (_initWebviewCore(getContext(), paramc[k], null, false)))
        {
          this.e = l.a(paramc[k], this);
          if (this.e != null)
          {
            this.f = getCurWebType();
            break;
          }
        }
        k += 1;
      }
    }
    if (this.e == null)
    {
      a(getContext(), WebView.c.d, null, false, true);
      this.e = l.a(WebView.c.d, this);
      this.f = getCurWebType();
    }
    paramc = this.e;
    if (paramc == null)
    {
      paramc = new StringBuilder();
      paramc.append("init finally failed type = ");
      paramc.append(this.f);
      org.xwalk.core.Log.e("xweb.WebView", paramc.toString());
      com.tencent.xweb.util.h.E();
      return;
    }
    addView(paramc.getWebViewUI());
    if (this.f == WebView.c.c)
    {
      if (this.e.getX5WebViewExtension() != null)
      {
        this.j = true;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-x5kernal");
      }
      else
      {
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-syskernal ");
      }
    }
    else
    {
      paramc = new StringBuilder();
      paramc.append("this webview instance is using :");
      paramc.append(this.f);
      org.xwalk.core.Log.i("xweb.WebView", paramc.toString());
    }
    if (this.e.getCurWebviewClient() != null) {
      this.e.getCurWebviewClient().a(this.e.getDefalutOpProvider());
    }
    if (this.e.getCurWebChromeClient() != null) {
      this.e.getCurWebChromeClient().a(this.e.getDefalutOpProvider());
    }
    this.e.getView().setOnLongClickListener(new WebView.1(this));
    try
    {
      this.g = ((com.tencent.xweb.internal.d)l.a(WebView.c.b).excute("STR_CMD_GET_DEBUG_VIEW", new Object[] { this }));
      this.g.a();
    }
    catch (Exception paramc)
    {
      label590:
      StringBuilder localStringBuilder;
      break label590;
    }
    org.xwalk.core.Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
    this.g = new WebView.2(this);
    if (getWebCoreType() == WebView.c.b)
    {
      paramc = getContext();
      if ((paramc instanceof WebView.e)) {
        ((WebView.e)paramc).a(this.e);
      }
      com.tencent.xweb.internal.k.a(WebView.c.b).b();
    }
    paramc = getSettings().a();
    localObject = getSettings();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramc);
    localStringBuilder.append(" MMWEBID/");
    localStringBuilder.append(XWalkEnvironment.getGrayValue());
    ((w)localObject).b(localStringBuilder.toString());
  }
  
  static boolean a(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    WebView.c localc = paramc;
    try
    {
      if (a(paramc, paramContext, paramPreInitCallback, paramBoolean2)) {
        break label106;
      }
      localc = paramc;
      if (!paramBoolean1) {
        break label106;
      }
      paramc = WebView.c.a;
      arrayOfc = new WebView.c[3];
      arrayOfc[0] = WebView.c.b;
      arrayOfc[1] = WebView.c.d;
      arrayOfc[2] = WebView.c.c;
      k = 0;
    }
    finally
    {
      for (;;)
      {
        WebView.c[] arrayOfc;
        int k;
        for (;;)
        {
          throw paramContext;
        }
        k += 1;
      }
    }
    localc = paramc;
    if (k < arrayOfc.length)
    {
      if ((arrayOfc[k] == paramc) || (!a(arrayOfc[k], paramContext, paramPreInitCallback, paramBoolean2))) {
        break label238;
      }
      localc = arrayOfc[k];
    }
    label106:
    b = localc;
    if (WebView.c.a == localc)
    {
      com.tencent.xweb.util.h.D();
      paramContext = new StringBuilder();
      paramContext.append("_initWebviewCore finally failed type = ");
      paramContext.append(localc);
      org.xwalk.core.Log.e("xweb.WebView", paramContext.toString());
      return false;
    }
    paramContext = new StringBuilder();
    paramContext.append("init webview core type = ");
    paramContext.append(localc);
    paramContext.append(", sdk:");
    paramContext.append(201201);
    paramContext.append(",xweb apk ver:");
    paramContext.append(XWalkEnvironment.getAvailableVersion());
    XWalkEnvironment.addXWalkInitializeLog(paramContext.toString());
    return true;
  }
  
  static boolean a(WebView.c paramc, Context paramContext, WebView.PreInitCallback paramPreInitCallback, boolean paramBoolean)
  {
    Object localObject = WebView.c.c;
    boolean bool = false;
    if ((paramc == localObject) && (!com.tencent.luggage.wxa.st.c.a()))
    {
      org.xwalk.core.Log.e("xweb.WebView", "no tbs sdk compiled");
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("try to init webview core = ");
    ((StringBuilder)localObject).append(paramc);
    org.xwalk.core.Log.i("xweb.WebView", ((StringBuilder)localObject).toString());
    if ((!paramBoolean) && (com.tencent.xweb.internal.b.a(paramc)))
    {
      com.tencent.xweb.util.h.c(paramc);
      return false;
    }
    localObject = com.tencent.xweb.internal.b.a("LOAD_CORE", paramc);
    ((com.tencent.xweb.internal.b)localObject).a();
    paramBoolean = bool;
    try
    {
      l.a locala = l.a(paramc);
      paramBoolean = bool;
      bool = locala.initWebviewCore(paramContext, paramPreInitCallback);
      if (bool)
      {
        paramBoolean = bool;
        c.a().a(locala.getCookieManager());
        paramBoolean = bool;
        d.a(locala.getCookieSyncManager());
        paramBoolean = bool;
        com.tencent.xweb.util.h.b(paramc);
        paramBoolean = bool;
        ((com.tencent.xweb.internal.b)localObject).b();
        return bool;
      }
      paramBoolean = bool;
      paramContext = new StringBuilder();
      paramBoolean = bool;
      paramContext.append("init webview failed type = ");
      paramBoolean = bool;
      paramContext.append(paramc);
      paramBoolean = bool;
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", paramContext.toString());
      return bool;
    }
    catch (Exception paramContext)
    {
      paramPreInitCallback = new StringBuilder();
      paramPreInitCallback.append("init webview got exception  type = ");
      paramPreInitCallback.append(paramc);
      paramPreInitCallback.append(", err = ");
      paramPreInitCallback.append(paramContext.getMessage());
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", paramPreInitCallback.toString());
    }
    try
    {
      paramPreInitCallback = new StringBuilder();
      paramPreInitCallback.append("crash stack : ");
      paramPreInitCallback.append(android.util.Log.getStackTraceString(paramContext));
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", paramPreInitCallback.toString());
      label300:
      com.tencent.xweb.util.h.d(paramc);
      return paramBoolean;
    }
    catch (Exception paramContext)
    {
      break label300;
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (getCurWebType() == WebView.c.d) {
      com.tencent.xweb.util.g.a("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (getCurWebType() == WebView.c.d) {
      com.tencent.xweb.util.g.a("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  public static void forceEnableFrameCostProfile()
  {
    f localf = com.tencent.xweb.internal.k.a(getCurWebType());
    if (localf != null) {
      localf.a().a();
    }
  }
  
  public static boolean getCanReboot()
  {
    if ((d) && (XWebCoreInfo.getCurAbiInstalledNewestVersion(XWalkEnvironment.getApplicationContext()) > 0))
    {
      org.xwalk.core.Log.i("xweb.WebView", "need rebot because of has installed xweb core ");
      return true;
    }
    if ((getCurWebType() == WebView.c.b) && (XWalkEnvironment.getAvailableVersion() > 0) && (XWalkEnvironment.getInstalledNewstVersionForCurAbi() > XWalkEnvironment.getAvailableVersion()))
    {
      org.xwalk.core.Log.i("xweb.WebView", "need rebot because of has newer xweb version ");
      return true;
    }
    if (getCurWebType() == WebView.c.c)
    {
      com.tencent.luggage.wxa.st.b localb = i;
      if (localb != null) {
        return localb.a();
      }
      org.xwalk.core.Log.e("xweb.WebView", "getCanReboot: sImp is null");
    }
    return com.tencent.xweb.internal.h.a().f();
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    com.tencent.luggage.wxa.st.b localb = i;
    if (localb != null) {
      return localb.c(paramContext);
    }
    org.xwalk.core.Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
    return "";
  }
  
  public static String getCurStrModule()
  {
    return c;
  }
  
  public static WebView.c getCurWebType()
  {
    return b;
  }
  
  public static int getInstalledTbsCoreVersion(Context paramContext)
  {
    com.tencent.luggage.wxa.st.b localb = i;
    if (localb != null) {
      return localb.a(paramContext);
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    return 0;
  }
  
  public static WebView.c getPreferedWebviewType(Context paramContext, WebView.c paramc, String paramString)
  {
    if (b != WebView.c.a) {
      return b;
    }
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isIaDevice())
    {
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "x86 device use WV_KIND_SYS");
      com.tencent.xweb.util.h.a(69L, 1);
      return WebView.c.d;
    }
    if (v.a().b(paramString) != WebView.c.a)
    {
      paramContext = v.a().b(paramString);
      paramc = new StringBuilder();
      paramc.append("use hard code web type = ");
      paramc.append(paramContext);
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", paramc.toString());
    }
    else
    {
      paramContext = WebView.c.b;
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use compile setting force to xweb ");
    }
    com.tencent.xweb.util.h.a(paramContext);
    paramc = paramContext;
    if (paramContext == WebView.c.b)
    {
      paramc = paramContext;
      if (!XWalkEnvironment.hasAvailableVersion())
      {
        paramc = WebView.c.d;
        d = true;
        XWalkEnvironment.addXWalkInitializeLog("xwalk is not available , use sys");
      }
    }
    com.tencent.xweb.internal.h.a(paramc, paramString);
    if (com.tencent.xweb.internal.h.a().g())
    {
      XWalkEnvironment.addXWalkInitializeLog("kind is match loadurlwatchdog switch to syskernal");
      paramc = WebView.c.d;
    }
    paramContext = paramc;
    if (paramc == WebView.c.c)
    {
      paramContext = paramc;
      if (!com.tencent.luggage.wxa.st.c.a())
      {
        XWalkEnvironment.addXWalkInitializeLog("x5 sdk is not compiled switch to xweb");
        paramContext = WebView.c.b;
      }
    }
    return paramContext;
  }
  
  public static WebView.c getPreferedWebviewType(Context paramContext, String paramString)
  {
    return getPreferedWebviewType(paramContext, WebView.c.c, paramString);
  }
  
  @Deprecated
  public static int getTbsCoreVersion(Context paramContext)
  {
    com.tencent.luggage.wxa.st.b localb = i;
    if (localb != null) {
      return localb.a(paramContext);
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    return 0;
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    com.tencent.luggage.wxa.st.b localb = i;
    if (localb != null) {
      return localb.b(paramContext);
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsSDKVersion: sImp is null");
    return 0;
  }
  
  public static int getUsingTbsCoreVersion(Context paramContext)
  {
    if (b == WebView.c.c)
    {
      com.tencent.luggage.wxa.st.b localb = i;
      if (localb != null) {
        return localb.a(paramContext);
      }
      org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    }
    return 0;
  }
  
  public static boolean hasInited()
  {
    if (getCurWebType() == WebView.c.a) {
      return false;
    }
    if (l.a(getCurWebType()) == null) {
      return false;
    }
    return l.a(getCurWebType()).hasInited();
  }
  
  public static void initWebviewCore(Context paramContext, WebView.c paramc, String paramString, WebView.PreInitCallback paramPreInitCallback)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      str = "tools";
    }
    if (b != WebView.c.a)
    {
      if (b != paramc) {
        org.xwalk.core.Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
      }
      return;
    }
    c = str;
    com.tencent.xweb.util.h.a(str);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    XWalkEnvironment.init(paramContext);
    p.a();
    v.a(paramContext);
    if (XWalkEnvironment.getAvailableVersion() <= 0)
    {
      XWalkEnvironment.addXWalkInitializeLog("initWebviewCore with no xweb, tryEmbedInstall");
      t.a();
    }
    _initWebviewCore(paramContext, getPreferedWebviewType(paramContext, paramc, paramString), paramPreInitCallback, true);
  }
  
  public static boolean isSys()
  {
    return getCurWebType() == WebView.c.d;
  }
  
  public static boolean isX5()
  {
    return getCurWebType() == WebView.c.c;
  }
  
  public static boolean isXWalk()
  {
    return getCurWebType() == WebView.c.b;
  }
  
  public static void reinitToXWeb()
  {
    XWalkEnvironment.addXWalkInitializeLog("reinitToXWeb");
    b = WebView.c.a;
    XWalkEnvironment.refreshVerInfo();
    initWebviewCore(XWalkEnvironment.getApplicationContext(), WebView.c.b, c, null);
  }
  
  public static boolean setProfileResultCallback(String paramString, @Nullable i parami)
  {
    f localf = com.tencent.xweb.internal.k.a(getCurWebType());
    if (localf != null) {
      return localf.a().a(paramString, parami);
    }
    return false;
  }
  
  public static void setX5Interface(com.tencent.luggage.wxa.st.b paramb)
  {
    i = paramb;
  }
  
  public void _disablePlatformNotifications() {}
  
  public void _enablePlatformNotifications() {}
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.e.addJavascriptInterface(paramObject, paramString);
  }
  
  public boolean canGoBack()
  {
    return this.e.canGoBack();
  }
  
  public boolean canGoForward()
  {
    return this.e.canGoForward();
  }
  
  public Bitmap captureBitmap()
  {
    return this.e.captureBitmap();
  }
  
  public void captureBitmap(IWebView.a parama)
  {
    org.xwalk.core.Log.d("xweb.WebView", "captureBitmap");
    this.e.captureBitmap(parama);
  }
  
  public void clearHistory()
  {
    this.e.clearHistory();
  }
  
  public void clearMatches()
  {
    this.e.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    this.e.clearSslPreferences();
  }
  
  public void clearView()
  {
    this.e.clearView();
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    return this.e.copyBackForwardList();
  }
  
  public void destroy()
  {
    this.e.destroy();
  }
  
  public void disableVideoJsCallback(boolean paramBoolean)
  {
    this.e.disableVideoJsCallback(paramBoolean);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public void drawCanvas(Canvas paramCanvas)
  {
    if (isXWalkKernel())
    {
      paramCanvas.drawBitmap(getBitmap(), 0.0F, 0.0F, null);
      return;
    }
    draw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    this.e.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public void findAllAsync(String paramString)
  {
    this.e.findAllAsync(paramString);
  }
  
  public void findNext(boolean paramBoolean)
  {
    this.e.findNext(paramBoolean);
  }
  
  public String getAbstractInfo()
  {
    return this.e.getAbstractInfo();
  }
  
  public Bitmap getBitmap()
  {
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas;
    if (localBitmap != null)
    {
      localBitmap.eraseColor(-1);
      localCanvas = new Canvas(localBitmap);
      if (!isXWalkKernel()) {}
    }
    try
    {
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      Object localObject1 = a(this).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((TextureView)((Iterator)localObject1).next()).getBitmap();
        if (localObject2 != null) {
          localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, localPaint);
        } else {
          org.xwalk.core.Log.e("xweb.WebView", "getBitmap textureViewBitmap = null");
        }
      }
      localObject1 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      Object localObject2 = new Canvas((Bitmap)localObject1);
      getTopView().draw((Canvas)localObject2);
      localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, localPaint);
      return localBitmap;
    }
    catch (Exception localException) {}
    draw(localCanvas);
    return localBitmap;
    return localBitmap;
  }
  
  public int getContentHeight()
  {
    return this.e.getContentHeight();
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    return null;
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    return null;
  }
  
  public u getCurWebChromeClient()
  {
    return this.e.getCurWebChromeClient();
  }
  
  public y getCurWebviewClient()
  {
    return this.e.getCurWebviewClient();
  }
  
  public e getDefalutOpProvider()
  {
    return null;
  }
  
  public WebView.a getFullscreenVideoKind()
  {
    return this.e.getFullscreenVideoKind();
  }
  
  public WebView.b getHitTestResult()
  {
    return this.e.getHitTestResult();
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    return this.e.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, g paramg)
  {
    return this.e.getImageBitmapToFile(paramString1, paramString2, paramString3, paramg);
  }
  
  public float getScale()
  {
    return this.e.getScale();
  }
  
  public int getScrollHeight()
  {
    return this.e.getScrollHeight();
  }
  
  public w getSettings()
  {
    return this.e.getSettings();
  }
  
  public String getTitle()
  {
    return this.e.getTitle();
  }
  
  public ViewGroup getTopView()
  {
    return this.e.getTopView();
  }
  
  public String getUrl()
  {
    return this.e.getUrl();
  }
  
  public String getVersionInfo()
  {
    return this.e.getVersionInfo();
  }
  
  public View getView()
  {
    return this.e.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    return this.e.getVisibleTitleHeight();
  }
  
  public WebView.c getWebCoreType()
  {
    return this.f;
  }
  
  public int getWebScrollX()
  {
    return this.e.getWebScrollX();
  }
  
  public int getWebScrollY()
  {
    return this.e.getWebScrollY();
  }
  
  public View getWebViewUI()
  {
    return this.e.getWebViewUI();
  }
  
  public Object getX5WebViewExtension()
  {
    return this.e.getX5WebViewExtension();
  }
  
  public void goBack()
  {
    this.e.goBack();
  }
  
  public void goForward()
  {
    this.e.goForward();
  }
  
  public boolean hasEnteredFullscreen()
  {
    return this.e.hasEnteredFullscreen();
  }
  
  public Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    return this.e.invokeMiscMethod(paramString, paramBundle);
  }
  
  public boolean isOverScrollStart()
  {
    return this.e.isOverScrollStart();
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    if (isXWalkKernel()) {
      return this.e.isSupportExtendPluginForAppbrand();
    }
    return false;
  }
  
  public boolean isSysKernel()
  {
    return this.f == WebView.c.d;
  }
  
  public boolean isX5WrappedSysKernel()
  {
    return (getCurWebType() == WebView.c.c) && (!this.j);
  }
  
  public boolean isXWalkKernel()
  {
    return this.f == WebView.c.b;
  }
  
  public void leaveFullscreen()
  {
    this.e.leaveFullscreen();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.e.loadData(paramString1, paramString2, paramString3);
    com.tencent.xweb.util.h.a(paramString1, this);
    reportLoadByReason();
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.e.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    com.tencent.xweb.util.h.a(paramString1, this);
  }
  
  public void loadUrl(String paramString)
  {
    if (this.g.a(paramString))
    {
      this.e.loadUrl("http://weixin.qq.com/");
      return;
    }
    this.e.loadUrl(paramString);
    com.tencent.xweb.util.h.a(paramString, this);
    reportLoadByReason();
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if (this.g.a(paramString))
    {
      this.e.loadUrl("http://weixin.qq.com/");
      return;
    }
    this.e.loadUrl(paramString, paramMap);
    com.tencent.xweb.util.h.a(paramString, this);
    reportLoadByReason();
  }
  
  @Deprecated
  public void manualStartFrameCostProfiler()
  {
    f localf = com.tencent.xweb.internal.k.a(getCurWebType());
    if (localf != null) {
      localf.a().a("xprofile.frameCost", 10000);
    }
  }
  
  @Deprecated
  public void manualStopFrameCostProfiler(j paramj)
  {
    f localf = com.tencent.xweb.internal.k.a(getCurWebType());
    if (localf != null) {
      localf.a().a(paramj);
    }
  }
  
  public void onHide()
  {
    this.e.onHide();
  }
  
  public void onPause()
  {
    this.e.onPause();
  }
  
  public void onResume()
  {
    this.e.onResume();
  }
  
  public void onShow()
  {
    this.e.onShow();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    paramView = this.e;
    if (paramView != null) {
      paramView.getView().setVisibility(paramInt);
    }
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean overlayHorizontalScrollbar()
  {
    return this.e.overlayHorizontalScrollbar();
  }
  
  public void reload()
  {
    this.e.reload();
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    this.e.removeJavascriptInterface(paramString);
  }
  
  public void reportLoadByReason()
  {
    com.tencent.xweb.util.h.b(this.a);
    this.a = -1;
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    return this.e.savePage(paramString1, paramString2, paramInt);
  }
  
  public void setA8keyReason(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setBackgroundColor color:");
    ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
    org.xwalk.core.Log.i("xweb.WebView", ((StringBuilder)localObject).toString());
    super.setBackgroundColor(paramInt);
    localObject = this.e;
    if (localObject != null) {
      ((IWebView)localObject).getWebViewUI().setBackgroundColor(paramInt);
    }
  }
  
  public void setBottomHeight(int paramInt)
  {
    this.e.setBottomHeight(paramInt);
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    this.e.setDownloadListener(paramDownloadListener);
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    this.e.setFindListener(paramFindListener);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusable(false);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusable(false);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusableInTouchMode(false);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusableInTouchMode(false);
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    this.e.setHorizontalScrollBarEnabled(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.e.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setJSExceptionListener(aa paramaa)
  {
    this.e.setJSExceptionListener(paramaa);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.h = paramOnLongClickListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.e.getWebViewUI().setOnTouchListener(paramOnTouchListener);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    this.e.setVerticalScrollBarEnabled(paramBoolean);
  }
  
  public r setVideoJsCallback(s params)
  {
    return this.e.setVideoJsCallback(params);
  }
  
  public void setWebChromeClient(u paramu)
  {
    if (paramu != null) {
      paramu.a(this.e.getDefalutOpProvider());
    }
    this.e.setWebChromeClient(paramu);
  }
  
  public void setWebViewCallbackClient(x paramx)
  {
    this.e.setWebViewCallbackClient(paramx);
  }
  
  public void setWebViewClient(y paramy)
  {
    if (paramy != null) {
      paramy.a(this.e.getDefalutOpProvider());
    }
    this.e.setWebViewClient(paramy);
  }
  
  public void setWebViewClientExtension(a parama)
  {
    this.e.setWebViewClientExtension(parama);
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    this.e.smoothScroll(paramInt1, paramInt2, paramLong);
  }
  
  public void startLongScreenshot(n paramn, boolean paramBoolean)
  {
    if (((this.e instanceof com.tencent.xweb.internal.g)) && (this.f == WebView.c.b)) {
      ((com.tencent.xweb.internal.g)this.e).a(((ViewGroup)getWebViewUI()).getChildAt(0), paramBoolean, paramn);
    }
  }
  
  public void stopLoading()
  {
    this.e.stopLoading();
  }
  
  public void super_computeScroll()
  {
    this.e.super_computeScroll();
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.e.super_dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.e.super_onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.e.super_onTouchEvent(paramMotionEvent);
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return this.e.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public boolean supportFeature(int paramInt)
  {
    return this.e.supportFeature(paramInt);
  }
  
  public boolean zoomIn()
  {
    return this.e.zoomIn();
  }
  
  public boolean zoomOut()
  {
    return this.e.zoomOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.WebView
 * JD-Core Version:    0.7.0.1
 */