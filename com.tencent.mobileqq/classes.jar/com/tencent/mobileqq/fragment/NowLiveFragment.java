package com.tencent.mobileqq.fragment;

import adnu;
import adnv;
import adnz;
import adoa;
import adob;
import adoc;
import adod;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.TicketManager;

public class NowLiveFragment
  extends NearbyBaseFragment
  implements View.OnClickListener
{
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new adod();
  public static String b;
  private static boolean g;
  public RefreshView a;
  public NearbyActivity a;
  public NowLiveFragment.NowLiveWebView a;
  public CookieManager a;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  public String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  int[] jdField_a_of_type_ArrayOfInt = { 2130839482, 2130839483, 2130839481 };
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "发起直播", "个人中心", "帮助" };
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
  
  void a(Activity paramActivity, NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("NowLiveFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView, paramActivity, paramNearbyAppInterface });
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
    if (paramSosoLbsInfo != null) {
      this.jdField_a_of_type_JavaLangString = ("&latitude=" + paramSosoLbsInfo.a.a + "&longitude=" + paramSosoLbsInfo.a.b);
    }
    if (i != -1)
    {
      paramSosoLbsInfo = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&gender=");
      if (i != 2) {
        break label194;
      }
    }
    label194:
    for (i = 2;; i = 1)
    {
      this.jdField_a_of_type_JavaLangString = i;
      if ((jdField_b_of_type_JavaLangString == null) || (jdField_b_of_type_JavaLangString.length() <= 0)) {
        break;
      }
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("NowLiveFragment", 2, "now.qq.com pskey : " + jdField_b_of_type_JavaLangString);
      }
      CookieSyncManager.getInstance().sync();
      e();
      return;
    }
    if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com") != null)
    {
      paramSosoLbsInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com");
      if (QLog.isColorLevel()) {
        QLog.i("NowLiveFragment", 2, "now.qq.com cookie : " + paramSosoLbsInfo);
      }
      if (paramSosoLbsInfo.contains("p_skey"))
      {
        e();
        return;
      }
    }
    jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
    long l = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
    if ((jdField_b_of_type_JavaLangString != null) && (jdField_b_of_type_JavaLangString.length() > 0) && (System.currentTimeMillis() - l < 21600000L))
    {
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + jdField_b_of_type_JavaLangString);
      CookieSyncManager.getInstance().sync();
      e();
      return;
    }
    paramSosoLbsInfo = new adnu(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramSosoLbsInfo, 2000L);
    paramSosoLbsInfo = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(2);
    String str = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin();
    adnv localadnv = new adnv(this);
    paramSosoLbsInfo.GetPskey(str, 16L, new String[] { "now.qq.com" }, localadnv);
  }
  
  public void ar_()
  {
    super.ar_();
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.a();
    if (localCustomWebView != null)
    {
      str = WebViewPlugin.toJsScript("onPageSelected", null, null);
      localCustomWebView.c(str);
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
    int i = 0;
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a("开播").a(false).a(this).a();
    ArrayList localArrayList = new ArrayList();
    while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = i;
      localMenuItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i];
      localMenuItem.c = this.jdField_a_of_type_ArrayOfJavaLangString[i];
      localMenuItem.b = this.jdField_a_of_type_ArrayOfInt[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, localArrayList, new adoc(this));
  }
  
  public void e()
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
        if (!this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.a();
        }
        if (this.jdField_a_of_type_ComTencentBizUiRefreshView != null)
        {
          this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
          this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
          this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.jdField_a_of_type_ComTencentBizUiTouchWebView, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.b) && (this.jdField_b_of_type_AndroidViewView != null)) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.e = (System.currentTimeMillis() - l);
    } while (!QLog.isDevelopLevel());
    NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.e) });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveFragment", 2, "startLocation start" + System.currentTimeMillis());
    }
    SosoInterface.a(new adnz(this, 0, true, false, 300000L, true, false, "NearbyNowliveTab"));
    return true;
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
    } while (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null);
    if (!this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAtLocation(this.jdField_a_of_type_AndroidViewView, 53, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131558953), this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131558451) + this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131559259));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
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
      NearbyUtils.a("NowLiveFragment", new Object[] { "mNowOnCreateMilliTimeStamp", Long.valueOf(l) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.c == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.c = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.b);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.c) });
      }
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130969111, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365230);
      this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365229));
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
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(getString(2131435075)).a(false);
    this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new adoa(this));
    if ((this.jdField_e_of_type_Boolean) && (!this.f)) {
      SosoInterface.a(new adob(this, 0, true, false, 30000L, true, false, "NearbyNowliveTab"));
    }
    d();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.d == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.d = (System.currentTimeMillis() - l);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.d) });
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
    } while (NetworkUtil.g(getActivity()));
    QQToast.a(getActivity(), 1, "当前网络不可用，请检查网络设置", 0).b(getActivity().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment
 * JD-Core Version:    0.7.0.1
 */