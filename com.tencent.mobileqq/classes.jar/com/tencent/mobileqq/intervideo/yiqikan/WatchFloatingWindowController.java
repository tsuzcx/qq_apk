package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mediafocus.MediaFocusManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewModule;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nonnull;
import mqq.util.WeakReference;

public class WatchFloatingWindowController
{
  private static volatile WatchFloatingWindowController a;
  private volatile WatchTogetherFloatingData b;
  private volatile boolean c = false;
  private WeakReference<WatchFloatingWindowController.FloatingWindowListener> d;
  private WebViewModule e;
  private WatchTogetherFloatingView f;
  private WatchFloatingWindowController.WatchFloatingWindowMediaFocusChangeListener g;
  private WeakReference<IVideoOuterStatusListener> h;
  private WatchTogetherFloatingData i;
  private long j = 0L;
  
  private int a(Context paramContext, float paramFloat)
  {
    Object localObject = new FloatingScreenParams.FloatingBuilder();
    if (paramFloat < 1.0F) {
      k = 1;
    } else {
      k = 2;
    }
    localObject = ((FloatingScreenParams.FloatingBuilder)localObject).setShapeType(k).setCanMove(true).setCanZoom(false).setRatio(paramFloat).setFloatingCenter(300, -680).build();
    int k = ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).enterWatchTogetherFloatingScreen(BaseApplicationImpl.context, this.f, (FloatingScreenParams)localObject, FloatingWatchTogetherWrapper.CLASS_NAME);
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(k) });
    }
    if (k == 1)
    {
      TogetherWatchFloatingUtil.a(paramContext, 4, this.b.getCurUin());
      return k;
    }
    this.h = new WeakReference(((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new WatchFloatingWindowController.1(this), FloatingWatchTogetherWrapper.CLASS_NAME));
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(FloatingWatchTogetherWrapper.CLASS_NAME, new WatchFloatingWindowController.2(this, paramContext));
    return 0;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.b != null))
    {
      if ((paramString.equals(this.b.getCurUin())) && (paramInt == this.b.getCurType())) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("closeFloatingWindow uin or type not match:");
        localStringBuilder.append("mCurType=");
        localStringBuilder.append(this.b.getCurType());
        localStringBuilder.append(" sessionType=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" mCurUin=");
        localStringBuilder.append(this.b.getCurUin());
        localStringBuilder.append(" uin=");
        localStringBuilder.append(paramString);
        QLog.d("WatchFloatingWindowController", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow uin is empty or data==null");
    }
    return false;
  }
  
  public static WatchFloatingWindowController c()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WatchFloatingWindowController();
        }
      }
      finally {}
    }
    return a;
  }
  
  public int a(Context paramContext, @Nonnull WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2131892104, 0).show();
      this.i = null;
      return 4;
    }
    if ((this.b != null) && (this.b.getCurUin().equals(paramWatchTogetherFloatingData.getCurUin())) && (this.b.getCurType() == this.b.getCurType()) && (this.b.getLoadingStatus() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "showFloatingWindow:  duplicate show");
      }
      this.i = null;
      return 5;
    }
    Object localObject = this.f;
    if (localObject == null)
    {
      this.f = new WatchTogetherFloatingView(BaseApplicationImpl.getContext());
      this.f.a(true);
    }
    else
    {
      ((WatchTogetherFloatingView)localObject).a(paramWatchTogetherFloatingData.getSmallUrl());
    }
    this.b = paramWatchTogetherFloatingData;
    float f1;
    if ((this.b.getVideoHeight() > 0.0D) && (this.b.getVideoWidth() > 0.0D)) {
      f1 = (float)(this.b.getVideoHeight() / this.b.getVideoWidth());
    } else {
      f1 = 0.5625F;
    }
    int k = a(paramContext, f1);
    if (k != 0)
    {
      this.b = null;
      this.i = null;
      return k;
    }
    this.c = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("web_view_module_from", 1);
    ((Intent)localObject).putExtra("url", paramWatchTogetherFloatingData.getSmallUrl());
    this.e = new WebViewModule((Intent)localObject, paramContext);
    this.e.onCreate();
    TogetherWatchFloatingUtil.a(true, paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 0);
    this.i = null;
    return 0;
  }
  
  public void a()
  {
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, oooo");
      }
      return;
    }
    a(this.b.getCurUin(), this.b.getCurType(), true);
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    boolean bool = QLog.isColorLevel();
    int k = 2;
    Object localObject;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateWindowSize videoWidth =");
      ((StringBuilder)localObject).append(paramDouble1);
      ((StringBuilder)localObject).append(" videoHeight=");
      ((StringBuilder)localObject).append(paramDouble2);
      QLog.d("WatchFloatingWindowController", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramDouble1 > 0.0D) && (paramDouble2 > 0.0D))
    {
      if (this.b == null) {
        return;
      }
      if ((paramDouble1 == this.b.getVideoWidth()) && (paramDouble2 == this.b.getVideoHeight()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is equal");
        }
        return;
      }
      this.b.setVideoWidth(paramDouble1);
      this.b.setVideoHeight(paramDouble2);
      float f1 = (float)(paramDouble2 / paramDouble1);
      ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).updateFloatingWindowRatio(f1, FloatingWatchTogetherWrapper.CLASS_NAME);
      localObject = (IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class);
      if (f1 < 1.0F) {
        k = 1;
      }
      ((IQQFloatingWindow)localObject).updateFloatingWindowShape(k, FloatingWatchTogetherWrapper.CLASS_NAME);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is invalid");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b == null) {
      return;
    }
    if (!this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
      }
      return;
    }
    a(this.b.getCurUin(), this.b.getCurType(), paramInt);
  }
  
  public void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "showFloatingWindowByPendingData");
    }
    if (paramContext == null) {
      return;
    }
    WatchTogetherFloatingData localWatchTogetherFloatingData = this.i;
    if (localWatchTogetherFloatingData == null) {
      return;
    }
    a(paramContext, localWatchTogetherFloatingData);
  }
  
  public void a(WatchFloatingWindowController.FloatingWindowListener paramFloatingWindowListener)
  {
    this.d = new WeakReference(paramFloatingWindowListener);
  }
  
  public void a(WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    this.i = paramWatchTogetherFloatingData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.b != null)
    {
      if (this.f == null) {
        return;
      }
      WeakReference localWeakReference = this.d;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((WatchFloatingWindowController.FloatingWindowListener)this.d.get()).a(paramInt2);
      }
      if (this.f.getLoadingState() != 1) {
        a(paramString, paramInt1, true);
      }
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!a(paramString, paramInt)) {
      return;
    }
    if (!this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, but isSuccessCreateFloatingView is false");
      }
      return;
    }
    this.b = null;
    this.i = null;
    WebViewModule localWebViewModule = this.e;
    if (localWebViewModule != null)
    {
      localWebViewModule.onPause();
      this.e.onDestroy();
      this.e = null;
    }
    this.j = 0L;
    this.f = null;
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(FloatingWatchTogetherWrapper.CLASS_NAME);
    TogetherWatchFloatingUtil.a(false, paramString, paramInt, paramBoolean);
    if (this.g != null)
    {
      MediaFocusManager.b().a(this.g);
      this.g = null;
    }
    this.h = null;
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(null, FloatingWatchTogetherWrapper.CLASS_NAME);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (WatchFloatingWindowController.FloatingWindowListener)this.d.get();
      int k;
      if (paramBoolean) {
        k = 1;
      } else {
        k = 2;
      }
      ((WatchFloatingWindowController.FloatingWindowListener)localObject).b(k);
    }
  }
  
  public void b()
  {
    if (this.b == null) {
      return;
    }
    boolean bool = this.c;
    int k = 2;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
      }
      return;
    }
    String str = this.b.getCurUin();
    int m = this.b.getCurType();
    if (this.b.isIsAdm()) {
      k = 1;
    }
    a(str, m, k);
  }
  
  public void b(int paramInt)
  {
    if (this.f == null) {
      return;
    }
    if (this.b == null) {
      return;
    }
    if (this.b.getLoadingStatus() == paramInt)
    {
      if (paramInt == 2) {
        ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.b.getCurUin(), "", "", "");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLoadingStatus mLoadingStatus=");
      ((StringBuilder)localObject).append(this.b.getLoadingStatus());
      ((StringBuilder)localObject).append(" status=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("WatchFloatingWindowController", 2, ((StringBuilder)localObject).toString());
    }
    this.b.setLoadingStatus(paramInt);
    if (paramInt == 1)
    {
      this.f.a(false);
      localObject = this.g;
      if (localObject == null)
      {
        this.g = new WatchFloatingWindowController.WatchFloatingWindowMediaFocusChangeListener(this.h);
        MediaFocusManager.b().a(1, this.g);
        return;
      }
      ((WatchFloatingWindowController.WatchFloatingWindowMediaFocusChangeListener)localObject).a(this.h);
      return;
    }
    if (paramInt == 2)
    {
      ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.b.getCurUin(), "", "", "");
      this.f.a();
    }
  }
  
  public void b(WatchFloatingWindowController.FloatingWindowListener paramFloatingWindowListener)
  {
    WeakReference localWeakReference = this.d;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (this.d.get() == paramFloatingWindowListener)) {
      this.d = null;
    }
  }
  
  public void d()
  {
    if (this.f != null)
    {
      Object localObject = this.e;
      if (localObject == null) {
        return;
      }
      localObject = ((WebViewModule)localObject).webView;
      if (localObject == null) {
        return;
      }
      this.f.a((TouchWebView)localObject);
      this.e.onResume();
    }
  }
  
  public boolean e()
  {
    if (this.f != null)
    {
      Object localObject = this.e;
      if (localObject == null) {
        return false;
      }
      localObject = ((WebViewModule)localObject).webView;
      if (localObject == null) {
        return false;
      }
      return ((TouchWebView)localObject).isShown();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchFloatingWindowController
 * JD-Core Version:    0.7.0.1
 */