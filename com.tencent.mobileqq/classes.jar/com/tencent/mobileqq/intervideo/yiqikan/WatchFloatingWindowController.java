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
  private static volatile WatchFloatingWindowController jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController;
  private long jdField_a_of_type_Long = 0L;
  private WatchFloatingWindowController.WatchFloatingWindowMediaFocusChangeListener jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController$WatchFloatingWindowMediaFocusChangeListener;
  private volatile WatchTogetherFloatingData jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData;
  private WatchTogetherFloatingView jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView;
  private WebViewModule jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule;
  private WeakReference<WatchFloatingWindowController.FloatingWindowListener> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private WatchTogetherFloatingData jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData;
  private WeakReference<IVideoOuterStatusListener> jdField_b_of_type_MqqUtilWeakReference;
  
  private int a(Context paramContext, float paramFloat)
  {
    Object localObject = new FloatingScreenParams.FloatingBuilder();
    if (paramFloat < 1.0F) {}
    for (int i = 1;; i = 2)
    {
      localObject = ((FloatingScreenParams.FloatingBuilder)localObject).setShapeType(i).setCanMove(true).setCanZoom(false).setRatio(paramFloat).setFloatingCenter(300, -680).build();
      i = ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).enterWatchTogetherFloatingScreen(BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView, (FloatingScreenParams)localObject, FloatingWatchTogetherWrapper.CLASS_NAME);
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(i) });
      }
      if (i != 1) {
        break;
      }
      TogetherWatchFloatingUtil.a(paramContext, 4, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin());
      return i;
    }
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new WatchFloatingWindowController.1(this), FloatingWatchTogetherWrapper.CLASS_NAME));
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(FloatingWatchTogetherWrapper.CLASS_NAME, new WatchFloatingWindowController.2(this, paramContext));
    return 0;
  }
  
  public static WatchFloatingWindowController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController == null) {
        jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController = new WatchFloatingWindowController();
      }
      return jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController;
    }
    finally {}
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow uin is empty or data==null");
      }
    }
    do
    {
      return false;
      if ((paramString.equals(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin())) && (paramInt == this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType())) {
        break;
      }
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder("closeFloatingWindow uin or type not match:");
    localStringBuilder.append("mCurType=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType()).append(" sessionType=").append(paramInt).append(" mCurUin=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin()).append(" uin=").append(paramString);
    QLog.d("WatchFloatingWindowController", 2, localStringBuilder.toString());
    return false;
    return true;
  }
  
  public int a(Context paramContext, @Nonnull WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131694459, 0).a();
      this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
      return 4;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData != null) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin().equals(paramWatchTogetherFloatingData.getCurUin())) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType() == this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType()) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getLoadingStatus() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "showFloatingWindow:  duplicate show");
      }
      this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
      return 5;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView = new WatchTogetherFloatingView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a(true);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = paramWatchTogetherFloatingData;
      if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoHeight() > 0.0D) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoWidth() > 0.0D)) {
        break label200;
      }
    }
    label200:
    for (float f = 0.5625F;; f = (float)(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoHeight() / this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoWidth()))
    {
      int i = a(paramContext, f);
      if (i == 0) {
        break label220;
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
      this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
      return i;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a(paramWatchTogetherFloatingData.getSmallUrl());
      break;
    }
    label220:
    this.jdField_a_of_type_Boolean = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("web_view_module_from", 1);
    localIntent.putExtra("url", paramWatchTogetherFloatingData.getSmallUrl());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule = new WebViewModule(localIntent, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule.onCreate();
    TogetherWatchFloatingUtil.a(true, paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 0);
    this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, oooo");
      }
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType(), true);
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "updateWindowSize videoWidth =" + paramDouble1 + " videoHeight=" + paramDouble2);
    }
    if ((paramDouble1 <= 0.0D) || (paramDouble2 <= 0.0D)) {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is invalid");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null);
      if ((paramDouble1 != this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoWidth()) || (paramDouble2 != this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoHeight())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is equal");
    return;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.setVideoWidth(paramDouble1);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.setVideoHeight(paramDouble2);
    float f = (float)(paramDouble2 / paramDouble1);
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).updateFloatingWindowRatio(f, FloatingWatchTogetherWrapper.CLASS_NAME);
    IQQFloatingWindow localIQQFloatingWindow = (IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class);
    if (f < 1.0F) {
      i = 1;
    }
    localIQQFloatingWindow.updateFloatingWindowShape(i, FloatingWatchTogetherWrapper.CLASS_NAME);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
    return;
    a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType(), paramInt);
  }
  
  public void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "showFloatingWindowByPendingData");
    }
    if (paramContext == null) {}
    while (this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) {
      return;
    }
    a(paramContext, this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData);
  }
  
  public void a(WatchFloatingWindowController.FloatingWindowListener paramFloatingWindowListener)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramFloatingWindowListener);
  }
  
  public void a(WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = paramWatchTogetherFloatingData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) || (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        ((WatchFloatingWindowController.FloatingWindowListener)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt2);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a() == 1);
    a(paramString, paramInt1, true);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!a(paramString, paramInt)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, but isSuccessCreateFloatingView is false");
    return;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
    this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule.onPause();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule = null;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView = null;
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(FloatingWatchTogetherWrapper.CLASS_NAME);
    TogetherWatchFloatingUtil.a(false, paramString, paramInt, paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController$WatchFloatingWindowMediaFocusChangeListener != null)
    {
      MediaFocusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController$WatchFloatingWindowMediaFocusChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController$WatchFloatingWindowMediaFocusChangeListener = null;
    }
    this.jdField_b_of_type_MqqUtilWeakReference = null;
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(null, FloatingWatchTogetherWrapper.CLASS_NAME);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      return;
    }
    WatchFloatingWindowController.FloatingWindowListener localFloatingWindowListener = (WatchFloatingWindowController.FloatingWindowListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localFloatingWindowListener.b(i);
      return;
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule == null)) {}
    TouchWebView localTouchWebView;
    do
    {
      return false;
      localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule.webView;
    } while (localTouchWebView == null);
    return localTouchWebView.isShown();
  }
  
  public void b()
  {
    int i = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
    return;
    String str = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin();
    int j = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType();
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.isIsAdm()) {
      i = 1;
    }
    a(str, j, i);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null);
        if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getLoadingStatus() != paramInt) {
          break;
        }
      } while (paramInt != 2);
      ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "updateLoadingStatus mLoadingStatus=" + this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getLoadingStatus() + " status=" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.setLoadingStatus(paramInt);
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a(false);
        if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController$WatchFloatingWindowMediaFocusChangeListener == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController$WatchFloatingWindowMediaFocusChangeListener = new WatchFloatingWindowController.WatchFloatingWindowMediaFocusChangeListener(this.jdField_b_of_type_MqqUtilWeakReference);
          MediaFocusManager.a().a(1, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController$WatchFloatingWindowMediaFocusChangeListener);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController$WatchFloatingWindowMediaFocusChangeListener.a(this.jdField_b_of_type_MqqUtilWeakReference);
        return;
      }
    } while (paramInt != 2);
    ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a();
  }
  
  public void b(WatchFloatingWindowController.FloatingWindowListener paramFloatingWindowListener)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() == paramFloatingWindowListener)) {
      this.jdField_a_of_type_MqqUtilWeakReference = null;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule == null)) {}
    TouchWebView localTouchWebView;
    do
    {
      return;
      localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule.webView;
    } while (localTouchWebView == null);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a(localTouchWebView);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewModule.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchFloatingWindowController
 * JD-Core Version:    0.7.0.1
 */