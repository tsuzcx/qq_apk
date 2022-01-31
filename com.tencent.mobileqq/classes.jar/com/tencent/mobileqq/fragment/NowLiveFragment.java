package com.tencent.mobileqq.fragment;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import appc;
import appd;
import appe;
import appf;
import apqf;
import asfl;
import asjt;
import badq;
import baxr;
import bbmy;
import bemi;
import beml;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.TicketManager;

public class NowLiveFragment
  extends NearbyBaseFragment
  implements View.OnClickListener
{
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new NowLiveFragment.6();
  public static String b;
  private static boolean g;
  bemi jdField_a_of_type_Bemi;
  public RefreshView a;
  public NearbyActivity a;
  public NowLiveFragment.NowLiveWebView a;
  public CookieManager a;
  public String a;
  ArrayList<Rect> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  int[] jdField_a_of_type_ArrayOfInt = { 2130840888, 2130840889, 2130840887 };
  String[] jdField_a_of_type_ArrayOfJavaLangString = { ajjy.a(2131641882), ajjy.a(2131641881), ajjy.a(2131641880) };
  public View b;
  public String c = "https://now.qq.com/qq/nearby/live.html?_wv=16777219&_bid=2452&from=50036";
  public String d;
  boolean d;
  public String e;
  
  static
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  public NowLiveFragment()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "https://now.qq.com/qq/nearby/user.html?_wv=3&_bid=2452&from=50036";
    this.jdField_e_of_type_JavaLangString = "https://now.qq.com/qq/nearby/help.html?_wv=3&_bid=2452&from=50036";
  }
  
  public baxr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView;
  }
  
  void a(Activity paramActivity, NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        asfl.a("NowLiveFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView, paramActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView == null) && (paramActivity != null) && (paramNearbyAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView = new NowLiveFragment.NowLiveWebView(this, paramActivity.getBaseContext(), paramActivity, paramNearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          paramActivity = new Intent();
          paramActivity.putExtra("url", NearbyActivity.jdField_a_of_type_JavaLangString);
          WebAccelerateHelper.getInstance().preGetKey(paramActivity, paramNearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a() + 1;
    if (paramSosoLbsInfo != null)
    {
      this.jdField_a_of_type_JavaLangString = ("&latitude=" + paramSosoLbsInfo.a.a + "&longitude=" + paramSosoLbsInfo.a.b);
      str = paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString;
      paramSosoLbsInfo = paramSosoLbsInfo.a.jdField_d_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramSosoLbsInfo))) {
        this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "&city=" + str + "&province=" + paramSosoLbsInfo);
      }
    }
    else if (i != -1)
    {
      paramSosoLbsInfo = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&gender=");
      if (i != 2) {
        break label283;
      }
    }
    label283:
    for (i = 2;; i = 1)
    {
      this.jdField_a_of_type_JavaLangString = i;
      if ((jdField_b_of_type_JavaLangString == null) || (jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label288;
      }
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("NowLiveFragment", 2, "now.qq.com pskey : " + jdField_b_of_type_JavaLangString);
      }
      CookieSyncManager.getInstance().sync();
      f();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("NowLiveFragment", 2, "onLocFinish, city or province is empty");
      break;
    }
    label288:
    if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com") != null)
    {
      paramSosoLbsInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com");
      if (QLog.isColorLevel()) {
        QLog.i("NowLiveFragment", 2, "now.qq.com cookie : " + paramSosoLbsInfo);
      }
      if (paramSosoLbsInfo.contains("p_skey"))
      {
        f();
        return;
      }
    }
    jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
    long l = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
    if ((jdField_b_of_type_JavaLangString != null) && (jdField_b_of_type_JavaLangString.length() > 0) && (System.currentTimeMillis() - l < 21600000L))
    {
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + jdField_b_of_type_JavaLangString);
      CookieSyncManager.getInstance().sync();
      f();
      return;
    }
    paramSosoLbsInfo = new NowLiveFragment.2(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramSosoLbsInfo, 2000L);
    paramSosoLbsInfo = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(2);
    String str = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin();
    appd localappd = new appd(this);
    paramSosoLbsInfo.GetPskey(str, 16L, new String[] { "now.qq.com" }, localappd);
  }
  
  public void aW_()
  {
    super.aW_();
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.getWebView();
    if (localCustomWebView != null)
    {
      str = WebViewPlugin.toJsScript("onPageSelected", null, null);
      localCustomWebView.callJs(str);
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveFragment", 2, "onPageSelected:" + str);
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("NowLiveFragment", 2, "onPageSelected, webView==null");
  }
  
  public void d()
  {
    if (getActivity() == null) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
      QLog.e("NowLiveFragment", 1, "ACCESS_FINE_LOCATION permission not granted!");
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        SosoInterface.a(new appc(this, 3, true, false, 300000L, true, false, "NearbyNowliveTab"));
        return;
      }
      f();
      return;
    }
  }
  
  public void e()
  {
    int i = 0;
    this.jdField_a_of_type_Apqf.a(ajjy.a(2131641884)).a(false).a(this).a();
    ArrayList localArrayList = new ArrayList();
    while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      beml localbeml = new beml();
      localbeml.jdField_a_of_type_Int = i;
      localbeml.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i];
      localbeml.c = this.jdField_a_of_type_ArrayOfJavaLangString[i];
      localbeml.b = this.jdField_a_of_type_ArrayOfInt[i];
      localArrayList.add(localbeml);
      i += 1;
    }
    this.jdField_a_of_type_Bemi = bemi.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, localArrayList, new appf(this));
  }
  
  public void f()
  {
    if ((this.f) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    do
    {
      long l;
      do
      {
        return;
        l = 0L;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
          l = System.currentTimeMillis();
        }
        this.f = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.a) {
          this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.a();
        }
        if (this.jdField_a_of_type_ComTencentBizUiRefreshView != null)
        {
          this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
          this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.mWebview.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
          this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.b) && (this.jdField_b_of_type_AndroidViewView != null)) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.e = (System.currentTimeMillis() - l);
    } while (!QLog.isDevelopLevel());
    asfl.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.e) });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveFragment", 2, "startLocation start" + System.currentTimeMillis());
      }
      d();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Bemi == null);
    if (!this.jdField_a_of_type_Bemi.isShowing())
    {
      this.jdField_a_of_type_Bemi.showAtLocation(this.jdField_a_of_type_AndroidViewView, 53, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131167522), this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131167767) + this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131167024));
      return;
    }
    this.jdField_a_of_type_Bemi.dismiss();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
    this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
    CookieSyncManager.createInstance(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null)
    {
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.b = l;
    }
    if (QLog.isColorLevel()) {
      asfl.a("NowLiveFragment", new Object[] { "mNowOnCreateMilliTimeStamp", Long.valueOf(l) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.c == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.c = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.b);
      if (QLog.isDevelopLevel()) {
        asfl.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.c) });
      }
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131493752, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131302008);
      this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313546));
    }
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("nearByTabUrl", "");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyActivity.nearByTabUrl frg", 4, paramLayoutInflater);
    }
    if (!paramLayoutInflater.equals(""))
    {
      NearbyActivity.jdField_a_of_type_JavaLangString = paramLayoutInflater;
      this.c = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_startLive", "");
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_personalCenter", "");
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_help", "");
    }
    this.jdField_a_of_type_Apqf.b(getString(2131628867)).a(false);
    this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new appe(this));
    if ((this.jdField_e_of_type_Boolean) && (!this.f)) {
      d();
    }
    e();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.d == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.d = (System.currentTimeMillis() - l);
      if (QLog.isDevelopLevel()) {
        asfl.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.d) });
      }
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      paramLayoutInflater = new Rect();
      paramLayoutInflater.top = 0;
      paramLayoutInflater.bottom = ((int)(315.0F * this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramLayoutInflater);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.f) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.f) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.f) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.b();
    } while (badq.g(getActivity()));
    bbmy.a(getActivity(), 1, ajjy.a(2131641886), 0).b(getActivity().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment
 * JD-Core Version:    0.7.0.1
 */