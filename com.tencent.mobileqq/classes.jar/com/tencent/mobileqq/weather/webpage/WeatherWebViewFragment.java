package com.tencent.mobileqq.weather.webpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.adv.preload.api.IVasAdvPreloadApi;
import com.tencent.mobileqq.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.weather.config.WeatherConfigBean;
import com.tencent.mobileqq.weather.config.WeatherConfigProcessor;
import com.tencent.mobileqq.weather.config.WeatherConfigProcessor.Companion;
import com.tencent.mobileqq.weather.mvvm.MVVMExtKt;
import com.tencent.mobileqq.weather.mvvm.ViewExtKt;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponent;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QQPermissionConfig(id="biz_src_weather", scene="weather_h5")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WeatherWebViewFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "activity", "Lmqq/app/AppActivity;", "adCode", "", "appMeta", "appName", "appVersion", "appView", "arkLoadState", "", "arkViewWrapper", "Lcom/tencent/mobileqq/weather/webpage/WeatherArkViewWrapper;", "curWebPageData", "Lcom/tencent/mobileqq/weather/webpage/WebPageData;", "isFromDrawer", "", "isFromShare", "isPageLoadFinish", "isStartTimeAdded", "isWebLoaded", "lifeCycleVMStoreOwner", "Lcom/tencent/mobileqq/mvvm/LifeCycleAndViewModelStoreOwner;", "qqPermission", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "startClickTime", "", "startLoadTime", "viewModel", "Lcom/tencent/mobileqq/weather/webpage/WeatherWebArkViewModel;", "webViewWrapper", "Lcom/tencent/biz/ui/RefreshView;", "kotlin.jvm.PlatformType", "getWebViewWrapper", "()Lcom/tencent/biz/ui/RefreshView;", "webViewWrapper$delegate", "Lkotlin/Lazy;", "changeWhiteTitleStyle", "", "createBgImageIfNeed", "Landroid/widget/ImageView;", "getWebTitleBarInterface", "Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;", "getWebViewKernelCallBack", "Lcom/tencent/mobileqq/webview/swift/utils/WebViewKernelCallBack;", "initData", "intent", "Landroid/content/Intent;", "initTitle", "initView", "initViewModel", "onArkLoadState", "state", "onArkViewTouchEvent", "eventAny", "", "onAttach", "Landroid/app/Activity;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onJsCall", "data", "onPageDataCall", "any", "onPause", "onRefreshViewOverScroll", "overScrollDistance", "onResume", "onTipLocationFail", "onWebBgChange", "bgUrl", "requestLocationPermission", "setBackButtonWhite", "setHiddenMenuItem", "hiddenList", "", "setShareButtonWhite", "showActionSheet", "toWeatherOptionActivity", "tryRequestCurrAdCode", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebViewFragment
  extends WebViewFragment
{
  public static final WeatherWebViewFragment.Companion a = new WeatherWebViewFragment.Companion(null);
  private static final List<String> v = CollectionsKt.listOf(new String[] { "5061201803333178", "7091208803630139" });
  private static final String[] w = { "android.permission.ACCESS_FINE_LOCATION" };
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private boolean g;
  private boolean h;
  private long i;
  private WebPageData j;
  private boolean k;
  private boolean l;
  private AppActivity m;
  private LifeCycleAndViewModelStoreOwner n;
  private WeatherArkViewWrapper o;
  private WeatherWebArkViewModel p;
  private long q;
  private boolean r;
  private final Lazy s = LazyKt.lazy((Function0)new WeatherWebViewFragment.webViewWrapper.2(this));
  private int t;
  private QQPermission u;
  
  private final void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onArkLoadState state: ");
    localStringBuilder.append(paramInt);
    QLog.i("WeatherWebViewFragment", 1, localStringBuilder.toString());
    this.t = paramInt;
    if (this.t == -1) {
      j();
    }
    i();
  }
  
  private final void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("appName");
    Intrinsics.checkExpressionValueIsNotNull(str, "intent.getStringExtra(KEY_APP_NAME)");
    this.b = str;
    str = paramIntent.getStringExtra("appVersion");
    Intrinsics.checkExpressionValueIsNotNull(str, "intent.getStringExtra(KEY_APP_VERSION)");
    this.c = str;
    str = paramIntent.getStringExtra("appMeta");
    Intrinsics.checkExpressionValueIsNotNull(str, "intent.getStringExtra(KEY_APP_META)");
    this.d = str;
    str = paramIntent.getStringExtra("appView");
    Intrinsics.checkExpressionValueIsNotNull(str, "intent.getStringExtra(KEY_APP_VIEW)");
    this.e = str;
    str = paramIntent.getStringExtra("adCode");
    Intrinsics.checkExpressionValueIsNotNull(str, "intent.getStringExtra(KEY_AD_CODE)");
    this.f = str;
    boolean bool = paramIntent.getBooleanExtra("webProcessExist", false);
    this.k = paramIntent.getBooleanExtra("is_from_share", false);
    this.l = paramIntent.getBooleanExtra("is_from_drawer", false);
    if (this.q > 0L)
    {
      long l1 = System.currentTimeMillis() - this.q;
      if (bool) {
        paramIntent = "new_folder_prestart_open_times";
      } else {
        paramIntent = "new_folder_noprestart_open_times";
      }
      WeatherDCReportHelper.a().a(null, paramIntent, Long.valueOf(l1));
      paramIntent = new StringBuilder();
      paramIntent.append("startTime = ");
      paramIntent.append(l1);
      WeatherPreloadHelper.a(3, paramIntent.toString());
    }
  }
  
  private final void a(WebPageData paramWebPageData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onJsCall data: ");
      ((StringBuilder)localObject).append(paramWebPageData);
      QLog.d("WeatherWebViewFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramWebPageData.b();
    String str = paramWebPageData.c();
    int i1 = paramWebPageData.f();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty((CharSequence)str)))
    {
      if (this.h)
      {
        if (QLog.isColorLevel())
        {
          paramWebPageData = new StringBuilder();
          paramWebPageData.append("onJsCall jsFunction: ");
          paramWebPageData.append((String)localObject);
          paramWebPageData.append(", jsParam: ");
          paramWebPageData.append(str);
          QLog.d("WeatherWebViewFragment", 2, paramWebPageData.toString());
        }
        this.webView.callJs((String)localObject, new String[] { str });
        paramWebPageData = null;
      }
      this.j = paramWebPageData;
    }
    if (i1 > 0)
    {
      paramWebPageData = this.o;
      if (paramWebPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      float f1 = i1;
      localObject = this.m;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("activity");
      }
      paramWebPageData.setArkHeight(Utils.a(f1, ((AppActivity)localObject).getResources()));
    }
  }
  
  private final void a(Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (MotionEvent)paramObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onArkViewTouchEvent  event: ");
        localStringBuilder.append(paramObject);
        QLog.d("WeatherWebViewFragment", 2, localStringBuilder.toString());
      }
      c().dispatchTouchEvent(paramObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.MotionEvent");
  }
  
  private final void a(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onWebBgChange bgUrl: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("WeatherWebViewFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      localObject1 = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "resources");
      Object localObject2 = ViewExtKt.a((Resources)localObject1, 2130839668);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      localObject2 = (ImageView)c().findViewById(2131450064);
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1));
      }
    }
  }
  
  private final void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (!paramList.contains("menuItem:setFont")) {
      paramList.add("menuItem:setFont");
    }
    if (!paramList.contains("menuItem:screenLongShotShare")) {
      paramList.add("menuItem:screenLongShotShare");
    }
    if (!paramList.contains("menuItem:exposeArticle")) {
      paramList.add("menuItem:exposeArticle");
    }
  }
  
  private final void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRefreshViewOverScroll  overScrollDistance: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("WeatherWebViewFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.o;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localObject = ((WeatherArkViewWrapper)localObject).getLayoutParams();
    if ((localObject instanceof FrameLayout.LayoutParams))
    {
      ((FrameLayout.LayoutParams)localObject).topMargin = (-paramInt);
      WeatherArkViewWrapper localWeatherArkViewWrapper = this.o;
      if (localWeatherArkViewWrapper == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      localWeatherArkViewWrapper.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private final void b(Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (WebPageData)paramObject;
      int i1 = paramObject.a();
      String str = paramObject.d();
      int i2 = paramObject.e();
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 4) {
                return;
              }
              l();
              return;
            }
            e();
            return;
          }
          a(i2);
          return;
        }
        a(str);
        return;
      }
      a(paramObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.weather.webpage.WebPageData");
  }
  
  private final RefreshView c()
  {
    return (RefreshView)this.s.getValue();
  }
  
  private final void d()
  {
    this.p = new WeatherWebArkViewModel();
    IArkAPIService localIArkAPIService = (IArkAPIService)QRoute.api(IArkAPIService.class);
    WeatherWebArkViewModel localWeatherWebArkViewModel = this.p;
    if (localWeatherWebArkViewModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    localIArkAPIService.registerAppNotification("com.tencent.weather_v2", (IAppNotifyCallback)new WeatherArkNotify(localWeatherWebArkViewModel));
  }
  
  private final void e()
  {
    QLog.i("WeatherWebViewFragment", 1, "onTipLocationFail");
    QQToast.makeText((Context)getQBaseActivity(), (CharSequence)getString(2131917994), 0).show();
  }
  
  private final void f()
  {
    Object localObject1 = getSwiftTitleUI().o;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "swiftTitleUI.titleContainer");
    localObject1 = ((ViewGroup)localObject1).getParent();
    if ((localObject1 instanceof ViewGroup))
    {
      ((ViewGroup)localObject1).removeView((View)getSwiftTitleUI().o);
      localObject1 = getView();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView((View)getSwiftTitleUI().o);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
    localObject1 = (ImageView)getSwiftTitleUI().o.findViewById(2131436199);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "secondImage");
    ViewExtKt.a((View)localObject1, null);
    ((ImageView)localObject1).setVisibility(0);
    ((ImageView)localObject1).setImageResource(2130852615);
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new WeatherWebViewFragment.initTitle.1(this));
    ((ImageView)localObject1).setContentDescription((CharSequence)getString(2131888090));
    b();
    Object localObject2 = ((ImageView)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = Utils.a(11.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = Utils.a(12.0F, getResources());
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = getSwiftTitleUI().d;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "swiftTitleUI.leftView");
      ((TextView)localObject1).setContentDescription((CharSequence)getString(2131887625));
      localObject1 = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "qBaseActivity");
      ImmersiveUtils.clearCoverForStatus(((QBaseActivity)localObject1).getWindow(), true);
      localObject1 = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "qBaseActivity");
      ((QBaseActivity)localObject1).getIntent().removeExtra("isTransparentTitle");
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  private final void g()
  {
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather(null, "new_topbar_account_click");
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest((Context)getQBaseActivity(), "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", "2658655094");
    localActivityURIRequest.extra().putString("uinname", "QQ天气");
    localActivityURIRequest.extra().putInt("uintype", 1008);
    localActivityURIRequest.setFlags(67108864);
    QRoute.startUri((URIRequest)localActivityURIRequest, null);
    ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(null, "2658655094", "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  private final void h()
  {
    this.webView.addScrollChangedListener((TouchWebView.OnScrollChangedListener)new WeatherWebViewFragment.initView.1(this));
    this.webView.setBackgroundColor(0);
    int i2 = (int)getResources().getDimension(2131299920);
    int i1 = i2;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i1 = i2 + ImmersiveUtils.getStatusBarHeight((Context)getQBaseActivity());
    }
    Object localObject1 = this.webView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "webView");
    localObject1 = ((TouchWebView)localObject1).getLayoutParams();
    if (localObject1 != null)
    {
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).topMargin = i1;
      Object localObject2 = this.webView;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "webView");
      ((TouchWebView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = k();
      localObject2 = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
      ((ImageView)localObject1).setImageDrawable(ViewExtKt.a((Resources)localObject2, 2130839668));
      localObject1 = this.n;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleVMStoreOwner");
      }
      localObject2 = (LifecycleOwner)localObject1;
      localObject1 = this.p;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      Object localObject3 = (LiveData)((WeatherWebArkViewModel)localObject1).a();
      localObject1 = (WeatherWebViewFragment)this;
      MVVMExtKt.a((LifecycleOwner)localObject2, (LiveData)localObject3, (Function1)new WeatherWebViewFragment.initView.2((WeatherWebViewFragment)localObject1));
      localObject2 = this.n;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleVMStoreOwner");
      }
      localObject2 = (LifecycleOwner)localObject2;
      localObject3 = c().b;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "webViewWrapper.onOverScrolledLiveData");
      MVVMExtKt.a((LifecycleOwner)localObject2, (LiveData)localObject3, (Function1)new WeatherWebViewFragment.initView.3((WeatherWebViewFragment)localObject1));
      localObject2 = this.n;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleVMStoreOwner");
      }
      localObject2 = (LifecycleOwner)localObject2;
      localObject3 = this.o;
      if (localObject3 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      MVVMExtKt.a((LifecycleOwner)localObject2, (LiveData)((WeatherArkViewWrapper)localObject3).getTouchEventData(), (Function1)new WeatherWebViewFragment.initView.4((WeatherWebViewFragment)localObject1));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  private final void i()
  {
    if ((!this.k) && (!this.l) && (this.g))
    {
      localObject1 = this.o;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      if (((WeatherArkViewWrapper)localObject1).a())
      {
        localObject1 = this.p;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        localObject2 = this.m;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        String str = this.f;
        if (str == null) {
          Intrinsics.throwUninitializedPropertyAccessException("adCode");
        }
        ((WeatherWebArkViewModel)localObject1).a((AppActivity)localObject2, str);
        return;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("requestCurrAdCode fail isFromShare: ");
    ((StringBuilder)localObject1).append(this.k);
    ((StringBuilder)localObject1).append(" isFromDrawer: ");
    ((StringBuilder)localObject1).append(this.l);
    ((StringBuilder)localObject1).append(" isWebLoaded: ");
    ((StringBuilder)localObject1).append(this.g);
    ((StringBuilder)localObject1).append(" isArkLoaded: ");
    Object localObject2 = this.o;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    ((StringBuilder)localObject1).append(((WeatherArkViewWrapper)localObject2).a());
    ((StringBuilder)localObject1).append(')');
    QLog.i("WeatherWebViewFragment", 1, ((StringBuilder)localObject1).toString());
  }
  
  private final void j()
  {
    Object localObject1 = getSwiftTitleUI();
    Object localObject3 = null;
    if (localObject1 != null)
    {
      localObject1 = ((SwiftIphoneTitleBarUI)localObject1).o;
      if (localObject1 != null)
      {
        localObject1 = (ImageView)((ViewGroup)localObject1).findViewById(2131436199);
        break label36;
      }
    }
    localObject1 = null;
    label36:
    if (localObject1 != null) {
      localObject2 = ((ImageView)localObject1).getDrawable();
    } else {
      localObject2 = null;
    }
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageResource(0);
    }
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageDrawable(BaseImageUtil.a((Drawable)localObject2, -16777216));
    }
    Object localObject2 = getSwiftTitleUI();
    localObject1 = localObject3;
    if (localObject2 != null)
    {
      localObject2 = ((SwiftIphoneTitleBarUI)localObject2).h;
      localObject1 = localObject3;
      if (localObject2 != null) {
        localObject1 = ((ImageView)localObject2).getDrawable();
      }
    }
    localObject2 = getSwiftTitleUI();
    if (localObject2 != null)
    {
      localObject2 = ((SwiftIphoneTitleBarUI)localObject2).h;
      if (localObject2 != null) {
        ((ImageView)localObject2).setColorFilter(-16777216);
      }
    }
    localObject2 = getSwiftTitleUI();
    if (localObject2 != null)
    {
      localObject2 = ((SwiftIphoneTitleBarUI)localObject2).h;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageResource(0);
      }
    }
    localObject2 = getSwiftTitleUI();
    if (localObject2 != null)
    {
      localObject2 = ((SwiftIphoneTitleBarUI)localObject2).h;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      }
    }
    localObject1 = getSwiftTitleUI().d;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "swiftTitleUI.leftView");
    localObject1 = BaseImageUtil.a(((TextView)localObject1).getBackground(), -16777216);
    localObject2 = getSwiftTitleUI();
    if (localObject2 != null)
    {
      localObject2 = ((SwiftIphoneTitleBarUI)localObject2).d;
      if (localObject2 != null) {
        ViewExtKt.a((View)localObject2, (Drawable)localObject1);
      }
    }
    localObject1 = getSwiftTitleUI();
    if (localObject1 != null)
    {
      localObject1 = ((SwiftIphoneTitleBarUI)localObject1).e;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(-16777216);
      }
    }
    localObject1 = getSwiftTitleUI();
    if (localObject1 != null)
    {
      localObject1 = ((SwiftIphoneTitleBarUI)localObject1).o;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setBackgroundColor(-1);
      }
    }
    localObject1 = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "qBaseActivity");
    ImmersiveUtils.setStatusTextColor(true, ((QBaseActivity)localObject1).getWindow());
  }
  
  private final ImageView k()
  {
    ImageView localImageView = (ImageView)c().findViewById(2131450064);
    Object localObject;
    if (localImageView != null)
    {
      localObject = localImageView;
      if ((localImageView.getParent() instanceof ViewGroup))
      {
        localObject = localImageView.getParent();
        if (localObject != null)
        {
          ((ViewGroup)localObject).removeView((View)localImageView);
          localObject = localImageView;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
    }
    else
    {
      localObject = new ImageView((Context)getQBaseActivity());
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setId(2131450064);
      ((ImageView)localObject).setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }
    c().addView((View)localObject, 0);
    return localObject;
  }
  
  private final void l()
  {
    if (this.u == null) {
      this.u = QQPermissionFactory.a((Fragment)this);
    }
    QQPermission localQQPermission = this.u;
    if (localQQPermission != null) {
      localQQPermission.a(w, 2, (QQPermission.BasePermissionsListener)new WeatherWebViewFragment.requestLocationPermission.1(this));
    }
  }
  
  public final void a()
  {
    Object localObject1 = getSwiftTitleUI();
    if (localObject1 != null)
    {
      localObject1 = ((SwiftIphoneTitleBarUI)localObject1).h;
      if (localObject1 != null)
      {
        localObject1 = ((ImageView)localObject1).getDrawable();
        break label28;
      }
    }
    localObject1 = null;
    label28:
    localObject1 = BaseImageUtil.a((Drawable)localObject1, -1);
    if (localObject1 != null)
    {
      Object localObject2 = getSwiftTitleUI();
      if (localObject2 != null)
      {
        localObject2 = ((SwiftIphoneTitleBarUI)localObject2).h;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
        }
      }
      localObject1 = getSwiftTitleUI();
      if (localObject1 != null)
      {
        localObject1 = ((SwiftIphoneTitleBarUI)localObject1).h;
        if (localObject1 != null) {
          ((ImageView)localObject1).setColorFilter(-1);
        }
      }
    }
  }
  
  public final void b()
  {
    Object localObject1 = getSwiftTitleUI();
    if (localObject1 != null)
    {
      localObject1 = ((SwiftIphoneTitleBarUI)localObject1).d;
      if (localObject1 != null)
      {
        localObject1 = ((TextView)localObject1).getBackground();
        break label28;
      }
    }
    localObject1 = null;
    label28:
    localObject1 = BaseImageUtil.a((Drawable)localObject1, -1);
    if (localObject1 != null)
    {
      Object localObject2 = getSwiftTitleUI();
      if (localObject2 != null)
      {
        localObject2 = ((SwiftIphoneTitleBarUI)localObject2).d;
        if (localObject2 != null) {
          ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        }
      }
    }
  }
  
  @NotNull
  public WebUiUtils.WebTitleBarInterface getWebTitleBarInterface()
  {
    return (WebUiUtils.WebTitleBarInterface)new WeatherWebViewFragment.getWebTitleBarInterface.1(this, (WebUiUtils.WebTitleBarInterface)this.webViewSurface);
  }
  
  @NotNull
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return (WebViewKernelCallBack)new WeatherWebViewFragment.getWebViewKernelCallBack.1(this, (WebViewKernelCallBack)this.webViewSurface);
  }
  
  public void onAttach(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    super.onAttach(paramActivity);
    this.m = ((AppActivity)paramActivity);
    WeatherWebPageHelper.a();
    if (WeatherConfigProcessor.a.a().a())
    {
      ((IVasAdvPreloadApi)QRoute.api(IVasAdvPreloadApi.class)).addPreloadAd("weather", v);
      ((IVasAdvPreloadApi)QRoute.api(IVasAdvPreloadApi.class)).loadAd("weather");
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class);
    AppActivity localAppActivity = this.m;
    if (localAppActivity == null) {
      Intrinsics.throwUninitializedPropertyAccessException("activity");
    }
    paramBundle = paramBundle.checkAndAddLifeCycleFragment((Activity)localAppActivity);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "QRoute.api(ILifeCycleFra…feCycleFragment(activity)");
    this.n = paramBundle;
    this.q = getIntent().getLongExtra("start_click_time", 0L);
    d();
    paramBundle = this.intent;
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "intent");
    a(paramBundle);
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = new FrameLayout((Context)getQBaseActivity());
    paramLayoutInflater.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    if ((WebAccelerateHelper.preloadBrowserView instanceof WebBrowserViewContainer))
    {
      paramViewGroup = WebAccelerateHelper.preloadBrowserView;
      if (paramViewGroup != null)
      {
        this.contentView = ((WebBrowserViewContainer)paramViewGroup);
        WebAccelerateHelper.preloadBrowserView = (View)null;
        getStatistics().aG = true;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.webview.swift.WebBrowserViewContainer");
      }
    }
    else
    {
      this.contentView = new WebBrowserViewContainer((Context)super.getQBaseActivity());
    }
    paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
    paramBundle = this.contentView;
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "contentView");
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    paramLayoutInflater.addView((View)this.contentView);
    int i2 = (int)getResources().getDimension(2131299920);
    int i1 = i2;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i1 = i2 + ImmersiveUtils.getStatusBarHeight((Context)getQBaseActivity());
    }
    paramViewGroup = this.m;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("activity");
    }
    this.o = new WeatherArkViewWrapper((Context)paramViewGroup);
    paramViewGroup = new FrameLayout.LayoutParams(-1, Utils.a(720, getResources()) + i1);
    paramBundle = this.o;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    paramLayoutInflater.addView((View)paramBundle, (ViewGroup.LayoutParams)paramViewGroup);
    paramViewGroup = this.o;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    paramBundle = this.p;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    paramViewGroup.a(paramBundle);
    paramViewGroup = this.o;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("appName");
    }
    String str1 = this.e;
    if (str1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("appView");
    }
    String str2 = this.c;
    if (str2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("appVersion");
    }
    String str3 = this.d;
    if (str3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("appMeta");
    }
    paramViewGroup.a(paramBundle, str1, str2, str3);
    paramLayoutInflater = (View)paramLayoutInflater;
    listenKeyboardShowHide(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.weather_v2", null);
    WeatherArkViewWrapper localWeatherArkViewWrapper = this.o;
    if (localWeatherArkViewWrapper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localWeatherArkViewWrapper.getArkView().onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
    ((IVasAdvPreloadApi)QRoute.api(IVasAdvPreloadApi.class)).removeAd("weather");
  }
  
  public void onPause()
  {
    super.onPause();
    WeatherArkViewWrapper localWeatherArkViewWrapper = this.o;
    if (localWeatherArkViewWrapper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localWeatherArkViewWrapper.getArkView().onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    WeatherArkViewWrapper localWeatherArkViewWrapper = this.o;
    if (localWeatherArkViewWrapper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localWeatherArkViewWrapper.getArkView().onResume();
  }
  
  public void showActionSheet()
  {
    QLog.i("WeatherWebViewFragment", 1, "showActionSheet");
    SwiftBrowserComponentsProvider.SwiftBrowserComponent localSwiftBrowserComponent = (SwiftBrowserComponentsProvider.SwiftBrowserComponent)this.mComponentsProvider.a(4);
    a(((IWebviewApi)QRoute.api(IWebviewApi.class)).getMenuHideNameList(localSwiftBrowserComponent));
    super.showActionSheet();
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather(null, "new_topbar_share_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebViewFragment
 * JD-Core Version:    0.7.0.1
 */