package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtTicketPromise;

public class NowLiveFragment
  extends NearbyBaseFragment
  implements View.OnClickListener
{
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new NowLiveFragment.6();
  static String b = "";
  private static boolean jdField_e_of_type_Boolean = false;
  public View a;
  public RefreshView a;
  public NearbyActivity a;
  public NowLiveFragment.NowLiveWebView a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  public String a;
  ArrayList<Rect> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = { 2130841394, 2130841395, 2130841393 };
  String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131707672), HardCodeUtil.a(2131707671), HardCodeUtil.a(2131707670) };
  String c;
  String d = "https://now.qq.com/qq/nearby/user.html?_wv=3&_bid=2452&from=50036";
  String jdField_e_of_type_JavaLangString = "https://now.qq.com/qq/nearby/help.html?_wv=3&_bid=2452&from=50036";
  
  public NowLiveFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "https://now.qq.com/qq/nearby/live.html?_wv=16777219&_bid=2452&from=50036";
  }
  
  public AbsWebView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView;
  }
  
  void a(Activity paramActivity, INearbyAppInterface paramINearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("NowLiveFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView, paramActivity, paramINearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView == null) && (paramActivity != null) && (paramINearbyAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView = new NowLiveFragment.NowLiveWebView(this, paramActivity.getBaseContext(), paramActivity, (AppInterface)paramINearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          paramActivity = new Intent();
          paramActivity.putExtra("url", NearbyActivity.nearByTabUrl);
          WebAccelerateHelper.getInstance().preGetKey(paramActivity, (AppRuntime)paramINearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  void a(SosoLbsInfo paramSosoLbsInfo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getNearbyProcManager().a() + 1;
    if (paramSosoLbsInfo != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&latitude=");
      ((StringBuilder)localObject1).append(paramSosoLbsInfo.mLocation.mLat02);
      ((StringBuilder)localObject1).append("&longitude=");
      ((StringBuilder)localObject1).append(paramSosoLbsInfo.mLocation.mLon02);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      localObject1 = paramSosoLbsInfo.mLocation.city;
      paramSosoLbsInfo = paramSosoLbsInfo.mLocation.province;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramSosoLbsInfo)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("&city=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&province=");
        ((StringBuilder)localObject2).append(paramSosoLbsInfo);
        this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("NowLiveFragment", 2, "onLocFinish, city or province is empty");
      }
    }
    if (i != -1)
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append(this.jdField_a_of_type_JavaLangString);
      paramSosoLbsInfo.append("&gender=");
      if (i == 2) {
        i = 2;
      } else {
        i = 1;
      }
      paramSosoLbsInfo.append(i);
      this.jdField_a_of_type_JavaLangString = paramSosoLbsInfo.toString();
    }
    paramSosoLbsInfo = jdField_b_of_type_JavaLangString;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.length() > 0))
    {
      paramSosoLbsInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("p_skey=");
      ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
      paramSosoLbsInfo.setCookie("now.qq.com", ((StringBuilder)localObject1).toString());
      if (QLog.isColorLevel())
      {
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("now.qq.com pskey : ");
        paramSosoLbsInfo.append(jdField_b_of_type_JavaLangString);
        QLog.i("NowLiveFragment", 2, paramSosoLbsInfo.toString());
      }
      CookieSyncManager.getInstance().sync();
      e();
      return;
    }
    if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com") != null)
    {
      paramSosoLbsInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("now.qq.com cookie : ");
        ((StringBuilder)localObject1).append(paramSosoLbsInfo);
        QLog.i("NowLiveFragment", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramSosoLbsInfo.contains("p_skey"))
      {
        e();
        return;
      }
    }
    jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
    long l = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
    paramSosoLbsInfo = jdField_b_of_type_JavaLangString;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.length() > 0) && (System.currentTimeMillis() - l < 21600000L))
    {
      paramSosoLbsInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("p_skey=");
      ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
      paramSosoLbsInfo.setCookie("now.qq.com", ((StringBuilder)localObject1).toString());
      CookieSyncManager.getInstance().sync();
      e();
      return;
    }
    paramSosoLbsInfo = new NowLiveFragment.2(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramSosoLbsInfo, 2000L);
    paramSosoLbsInfo = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getManager(2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin();
    Object localObject2 = new NowLiveFragment.3(this);
    paramSosoLbsInfo.getPskey((String)localObject1, 16L, new String[] { "now.qq.com" }, (WtTicketPromise)localObject2);
  }
  
  public void aR_()
  {
    super.aR_();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.getWebView();
    if (localObject != null)
    {
      String str = WebViewPlugin.toJsScript("onPageSelected", null, null);
      ((CustomWebView)localObject).callJs(str);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPageSelected:");
        ((StringBuilder)localObject).append(str);
        QLog.d("NowLiveFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("NowLiveFragment", 2, "onPageSelected, webView==null");
    }
  }
  
  public void b()
  {
    if (getBaseActivity() == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = j;
      if (getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        QLog.e("NowLiveFragment", 1, "ACCESS_FINE_LOCATION permission not granted!");
        i = 1;
      }
    }
    if (i == 0)
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new NowLiveFragment.1(this, 3, true, false, 300000L, true, false, "NearbyNowliveTab"));
      return;
    }
    e();
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(HardCodeUtil.a(2131707674));
    int i = 0;
    ((TitlebarStatus)localObject).a(false).a(this).a();
    localObject = new ArrayList();
    while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = i;
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localMenuItem.title = arrayOfString[i];
      localMenuItem.contentDescription = arrayOfString[i];
      localMenuItem.iconId = this.jdField_a_of_type_ArrayOfInt[i];
      ((List)localObject).add(localMenuItem);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.build(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (List)localObject, new NowLiveFragment.5(this));
  }
  
  void e()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if (this.f == null) {
        return;
      }
      long l = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
        l = System.currentTimeMillis();
      }
      this.jdField_c_of_type_Boolean = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.a();
      }
      Object localObject = this.jdField_a_of_type_ComTencentBizUiRefreshView;
      if (localObject != null)
      {
        ((RefreshView)localObject).setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.mWebview.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.jdField_b_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
      if (localObject != null)
      {
        ((NearbyActivity)localObject).mNowInitTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mNowInitTime) });
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
      return false;
    }
    if (paramMessage.what != 1) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("startLocation start");
      paramMessage.append(System.currentTimeMillis());
      QLog.d("NowLiveFragment", 2, paramMessage.toString());
    }
    b();
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131369216) && (i != 2131369233)) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
    if (paramView != null)
    {
      if (!paramView.isShowing())
      {
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAtLocation(this.f, 53, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131298898), this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131299169) + this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131298383));
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
    this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
    CookieSyncManager.createInstance(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView;
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null)
    {
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mNowOnCreateMilliTimeStamp = l;
    }
    else
    {
      l = 0L;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("NowLiveFragment", new Object[] { "mNowOnCreateMilliTimeStamp", Long.valueOf(l) });
    }
    NearbyActivity localNearbyActivity = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
    if ((localNearbyActivity != null) && (localNearbyActivity.mNowOnCreateTime == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mNowOnCreateTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mNowOnCreateMilliTimeStamp);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mNowOnCreateTime) });
      }
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.f == null)
    {
      this.f = paramLayoutInflater.inflate(2131559479, null);
      this.jdField_a_of_type_AndroidViewView = this.f.findViewById(2131368285);
      this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.f.findViewById(2131381056));
    }
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("nearByTabUrl", "");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyActivity.nearByTabUrl frg", 4, paramLayoutInflater);
    }
    if (!paramLayoutInflater.equals(""))
    {
      NearbyActivity.nearByTabUrl = paramLayoutInflater;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_startLive", "");
      this.d = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_personalCenter", "");
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_help", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(getString(2131694387)).a(false);
    this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new NowLiveFragment.4(this));
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      b();
    }
    c();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.mNowViewInflateTime == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mNowViewInflateTime = (System.currentTimeMillis() - l);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mNowViewInflateTime) });
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramLayoutInflater = new Rect();
      paramLayoutInflater.top = 0;
      paramLayoutInflater.bottom = ((int)(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDisplayMetrics().density * 315.0F));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramLayoutInflater);
    }
    return this.f;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.b();
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
      QQToast.a(getBaseActivity(), 1, HardCodeUtil.a(2131707676), 0).b(getBaseActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment
 * JD-Core Version:    0.7.0.1
 */