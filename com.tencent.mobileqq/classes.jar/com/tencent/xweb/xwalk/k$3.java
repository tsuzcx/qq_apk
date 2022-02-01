package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.widget.AbsoluteLayout;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.aa;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.sys.c.c;
import com.tencent.xweb.u;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import com.tencent.xweb.y;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkUIClient.InitiateBy;
import org.xwalk.core.XWalkUIClient.JavascriptMessageType;
import org.xwalk.core.XWalkUIClient.LoadStatus;
import org.xwalk.core.XWalkView;

class k$3
  extends m
{
  String a = null;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  
  k$3(k paramk, XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public boolean OnGetSampleString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    paramXWalkView = new Bundle();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("translate: OnGetSampleString orghashmap size = ");
    localStringBuilder.append(paramMap.size());
    localStringBuilder.append(" resultHashMap size = ");
    localStringBuilder.append(localHashMap.size());
    Log.d("XWWebView", localStringBuilder.toString());
    paramXWalkView.putSerializable("sample_hashmap", localHashMap);
    paramXWalkView = k.a(this.b).onMiscCallBack("onGetSampleString", paramXWalkView);
    if ((paramXWalkView instanceof Boolean)) {
      return ((Boolean)paramXWalkView).booleanValue();
    }
    return false;
  }
  
  public View getVideoLoadingProgressView()
  {
    Log.i("XWWebView", "getVideoLoadingProgressView");
    return LayoutInflater.from(this.b.a.getContext()).inflate(2131629634, null);
  }
  
  public boolean isSearchable()
  {
    Object localObject = k.a(this.b).onMiscCallBack("supportSmartPickWord", new Bundle());
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public void onClearCurrentPage()
  {
    if (k.a(this.b) != null) {
      k.a(this.b).hasDiscardCurrentPage(true);
    }
  }
  
  public boolean onConsoleMessage(XWalkView paramXWalkView, String paramString1, int paramInt, String paramString2, XWalkUIClient.ConsoleMessageType paramConsoleMessageType)
  {
    if ((XWalkUIClient.ConsoleMessageType.ERROR == paramConsoleMessageType) && (k.g(this.b) != null))
    {
      paramXWalkView = paramString1.split(":");
      if (paramXWalkView.length == 2)
      {
        k.g(this.b).a(paramString2, paramXWalkView[0], paramXWalkView[1]);
        com.tencent.xweb.util.h.s();
      }
    }
    return this.b.f.a(g.a(paramString1, paramInt, paramString2, paramConsoleMessageType));
  }
  
  public boolean onCreateWindowRequested(XWalkView paramXWalkView, XWalkUIClient.InitiateBy paramInitiateBy, ValueCallback<XWalkView> paramValueCallback)
  {
    paramXWalkView = k.h(this.b);
    paramValueCallback = this.b.a;
    paramValueCallback.getClass();
    paramXWalkView = paramXWalkView.obtainMessage(100, new WebView.d(paramValueCallback));
    paramValueCallback = this.b.f;
    boolean bool = false;
    if (paramValueCallback != null)
    {
      paramValueCallback = this.b.f;
      WebView localWebView = this.b.a;
      if (paramInitiateBy == XWalkUIClient.InitiateBy.BY_USER_GESTURE) {
        bool = true;
      } else {
        bool = false;
      }
      bool = paramValueCallback.a(localWebView, false, bool, paramXWalkView);
    }
    return bool;
  }
  
  public void onDidChangeThemeColor(XWalkView paramXWalkView, int paramInt)
  {
    this.b.f.a(this.b.a, paramInt);
  }
  
  public void onExitFullscreenVideo(Bitmap paramBitmap)
  {
    Log.i("XWWebView", "onExitFullscreenVideo");
    this.b.f.a(paramBitmap);
  }
  
  public void onFullscreenToggled(XWalkView paramXWalkView, boolean paramBoolean)
  {
    super.onFullscreenToggled(paramXWalkView, paramBoolean);
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    this.b.f.a();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
  {
    this.b.f.a(paramString, new g.b(paramXWalkGeolocationPermissionsCallback));
  }
  
  public boolean onGetTranslateString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    paramXWalkView = new Bundle();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("translate: onGetTranslateString orghashmap size = ");
    localStringBuilder.append(paramMap.size());
    localStringBuilder.append(" resultHashMap size = ");
    localStringBuilder.append(localHashMap.size());
    Log.d("XWWebView", localStringBuilder.toString());
    if ((localHashMap.size() == 0) && (k.e(this.b)))
    {
      Log.d("XWWebView", "translate: onTranslateFinish ");
      k.i(this.b);
    }
    paramXWalkView.putSerializable("translate_hashmap", localHashMap);
    paramXWalkView = k.a(this.b).onMiscCallBack("onGetTranslateString", paramXWalkView);
    if ((paramXWalkView instanceof Boolean)) {
      return ((Boolean)paramXWalkView).booleanValue();
    }
    return false;
  }
  
  public void onHideCustomView()
  {
    Log.i("XWWebView", "onHideCustomView");
    if (this.e)
    {
      this.e = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHideCustomView: mIsMediaPlaybackRequiresUserGesture");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", mIsVideoPlaybackRequiresUserGesture:");
      localStringBuilder.append(this.d);
      Log.i("XWWebView", localStringBuilder.toString());
      this.b.c.getSettings().setMediaPlaybackRequiresUserGesture(this.c);
      this.b.c.getSettings().setVideoPlaybackRequiresUserGesture(this.d);
    }
    if (this.b.f.o_())
    {
      Log.i("XWWebView", "onHideCustomView isHandled:true");
      return;
    }
    this.b.d.setVisibility(0);
    if (k.d(this.b) != null) {
      k.d(this.b).a();
    }
  }
  
  public void onIconAvailable(XWalkView paramXWalkView, String paramString, Message paramMessage)
  {
    super.onIconAvailable(paramXWalkView, paramString, paramMessage);
  }
  
  public void onJavascriptCloseWindow(XWalkView paramXWalkView)
  {
    this.b.f.a(this.b.a);
  }
  
  public boolean onJavascriptModalDialog(XWalkView paramXWalkView, XWalkUIClient.JavascriptMessageType paramJavascriptMessageType, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    return super.onJavascriptModalDialog(paramXWalkView, paramJavascriptMessageType, paramString1, paramString2, paramString3, paramXWalkJavascriptResult);
  }
  
  public boolean onJsAlert(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    Log.i("XWWebView", "onJsAlert");
    return this.b.f.c(this.b.a, paramString1, paramString2, new g.c(paramXWalkJavascriptResult));
  }
  
  public boolean onJsConfirm(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    Log.i("XWWebView", "onJsConfirm");
    return this.b.f.d(this.b.a, paramString1, paramString2, new g.c(paramXWalkJavascriptResult));
  }
  
  public boolean onJsPrompt(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    Log.i("XWWebView", "onJsPrompt");
    return this.b.f.a(this.b.a, paramString1, paramString2, paramString3, new g.e(paramXWalkJavascriptResult));
  }
  
  public void onPageCommitVisible(XWalkView paramXWalkView, String paramString)
  {
    this.b.e.d(this.b.a, paramString);
  }
  
  public void onPageLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    paramXWalkView = new StringBuilder();
    paramXWalkView.append("onPageLoadStarted: url = ");
    paramXWalkView.append(paramString);
    Log.i("XWWebView", paramXWalkView.toString());
    this.b.e.a(this.b.a, paramString, this.b.c.getFavicon());
    com.tencent.xweb.internal.h.a().b();
    this.a = null;
    if ((k.b(this.b) != null) && (paramString != null) && (!paramString.equals(k.b(this.b))) && (com.tencent.xweb.util.h.c(paramString) != com.tencent.xweb.util.h.c(k.b(this.b)))) {
      if ((com.tencent.xweb.util.h.c(k.b(this.b)) == 1) && (com.tencent.xweb.util.h.c(paramString) == 2)) {
        k.a(this.b, 1);
      } else if ((com.tencent.xweb.util.h.c(k.b(this.b)) == 2) && (com.tencent.xweb.util.h.c(paramString) == 1)) {
        k.a(this.b, 2);
      }
    }
    k.a(this.b, paramString);
    this.b.i = System.currentTimeMillis();
    paramXWalkView = paramString;
    if (paramString == null) {
      paramXWalkView = "";
    }
    com.tencent.xweb.util.h.a(paramXWalkView, k.c(this.b));
    d.a(this.b.a);
    if (k.d(this.b) != null)
    {
      paramXWalkView = k.d(this.b);
      boolean bool;
      if (this.b.a.getFullscreenVideoKind() == WebView.a.c) {
        bool = true;
      } else {
        bool = false;
      }
      paramXWalkView.a(true, bool);
    }
    if (k.e(this.b))
    {
      Log.d("XWWebView", "onTranslateStart setTranslateMode true ");
      k.f(this.b);
      this.b.c.setTranslateMode(true);
    }
  }
  
  public void onPageLoadStopped(XWalkView paramXWalkView, String paramString, XWalkUIClient.LoadStatus paramLoadStatus)
  {
    paramXWalkView = this.a;
    if ((paramXWalkView != null) && (paramXWalkView.equals(paramString)))
    {
      paramXWalkView = new StringBuilder();
      paramXWalkView.append("abandoned onPageFinished: url = ");
      paramXWalkView.append(paramString);
      paramXWalkView.append(" status = ");
      paramXWalkView.append(paramLoadStatus);
      Log.i("XWWebView", paramXWalkView.toString());
      return;
    }
    if (k.d(this.b) != null)
    {
      paramXWalkView = k.d(this.b);
      boolean bool;
      if (this.b.a.getFullscreenVideoKind() == WebView.a.c) {
        bool = true;
      } else {
        bool = false;
      }
      paramXWalkView.a(false, bool);
    }
    this.a = paramString;
    paramXWalkView = new StringBuilder();
    paramXWalkView.append("onPageFinished: url = ");
    paramXWalkView.append(paramString);
    paramXWalkView.append(" status = ");
    paramXWalkView.append(paramLoadStatus);
    Log.i("XWWebView", paramXWalkView.toString());
    this.b.e.c(this.b.a, paramString);
    if (paramLoadStatus != XWalkUIClient.LoadStatus.FAILED) {
      com.tencent.xweb.internal.h.a().h();
    }
    com.tencent.xweb.util.h.a(paramString, System.currentTimeMillis() - this.b.i, k.c(this.b));
    this.b.i = System.currentTimeMillis();
  }
  
  public void onReceivedIcon(XWalkView paramXWalkView, String paramString, Bitmap paramBitmap)
  {
    super.onReceivedIcon(paramXWalkView, paramString, paramBitmap);
  }
  
  public void onReceivedTitle(XWalkView paramXWalkView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedTitle: ");
    localStringBuilder.append(paramString);
    Log.i("XWWebView", localStringBuilder.toString());
    super.onReceivedTitle(paramXWalkView, paramString);
    this.b.f.a(null, paramString);
    if (k.d(this.b) != null)
    {
      paramXWalkView = k.d(this.b);
      boolean bool;
      if (this.b.a.getFullscreenVideoKind() == WebView.a.c) {
        bool = true;
      } else {
        bool = false;
      }
      paramXWalkView.a(true, bool);
    }
  }
  
  public void onRequestFocus(XWalkView paramXWalkView)
  {
    super.onRequestFocus(paramXWalkView);
  }
  
  public void onScaleChanged(XWalkView paramXWalkView, float paramFloat1, float paramFloat2)
  {
    this.b.e.a(this.b.a, paramFloat1, paramFloat2);
  }
  
  public boolean onSearchWord(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3)
  {
    if (isSearchable())
    {
      paramXWalkView = new Bundle();
      paramXWalkView.putString("query", paramString1);
      k.a(this.b).onMiscCallBack("jumpToSos", paramXWalkView);
      return this.b.f.a(paramString1, paramString2, paramString3, this.b.c.getUrl(), this.b.c.getRefererUrl(), this.b.c.getTitle());
    }
    return false;
  }
  
  public boolean onSelectInfoChanged(XWalkView paramXWalkView, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (!isSearchable()) {
      return false;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("PickedWord", paramString1);
    ((Bundle)localObject).putString("PrefixText", paramString2);
    ((Bundle)localObject).putString("SuffixText", paramString3);
    localObject = k.a(this.b).onMiscCallBack("smartPickWord", (Bundle)localObject);
    if ((localObject instanceof Bundle))
    {
      localObject = (Bundle)localObject;
      if ((localObject != null) && (((Bundle)localObject).getString("PickedWord") != null))
      {
        int i = ((Bundle)localObject).getInt("PrefixOffset");
        int j = ((Bundle)localObject).getInt("SuffixOffset");
        k.b localb = k.b.a(paramString1, ((Bundle)localObject).getString("PickedWord"), i, j, paramString2, paramString3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSelectInfoChanged ");
        localStringBuilder.append(localb.toString());
        Log.d("XWWebView", localStringBuilder.toString());
        paramXWalkView.adjustSelectPosition(paramLong, ((Bundle)localObject).getString("PickedWord"), -localb.e, localb.g);
      }
      return this.b.f.a(paramLong, paramString1, paramString2, paramString3);
    }
    return false;
  }
  
  public void onShowCustomView(View paramView, int paramInt, CustomViewCallback paramCustomViewCallback)
  {
    super.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
  }
  
  public void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShowCustomView:");
    localStringBuilder.append(paramView);
    Log.i("XWWebView", localStringBuilder.toString());
    if (!this.e)
    {
      this.e = true;
      this.c = this.b.c.getSettings().getMediaPlaybackRequiresUserGesture();
      this.d = this.b.c.getSettings().getVideoPlaybackRequiresUserGesture();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowCustomView: mIsMediaPlaybackRequiresUserGesture");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", mIsVideoPlaybackRequiresUserGesture:");
      localStringBuilder.append(this.d);
      Log.i("XWWebView", localStringBuilder.toString());
      this.b.c.getSettings().setMediaPlaybackRequiresUserGesture(false);
      this.b.c.getSettings().setVideoPlaybackRequiresUserGesture(false);
    }
    boolean bool = this.b.f.a(paramView, new g.a(paramCustomViewCallback));
    com.tencent.xweb.util.h.k();
    if (bool)
    {
      Log.i("XWWebView", "onShowCustomView isHandled:true");
      return;
    }
    this.b.d.setVisibility(4);
    if (k.d(this.b) != null) {
      k.d(this.b).a(paramView, new g.a(paramCustomViewCallback));
    }
  }
  
  public boolean onShowFileChooser(XWalkView paramXWalkView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return this.b.f.a(this.b.a, paramValueCallback, new c.c(paramFileChooserParams));
  }
  
  public void onShowSos()
  {
    k.a(this.b).onMiscCallBack("onShowSos", new Bundle());
  }
  
  public void onUnhandledKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    super.onUnhandledKeyEvent(paramXWalkView, paramKeyEvent);
  }
  
  public void openFileChooser(XWalkView paramXWalkView, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    Log.i("XWWebView", "openFileChooser with three param");
    this.b.f.a(paramValueCallback, paramString1, paramString2);
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    if (k.a(this.b) != null) {
      return k.a(this.b).shouldDiscardCurrentPage();
    }
    return super.shouldDiscardCurrentPage();
  }
  
  public boolean shouldOverrideKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    return super.shouldOverrideKeyEvent(paramXWalkView, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.3
 * JD-Core Version:    0.7.0.1
 */