package com.tencent.mobileqq.fragment;

import aduw;
import adux;
import aduy;
import aduz;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class CommonTabFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public aduz a;
  View.OnClickListener a;
  public RefreshView a;
  public NearbyActivity a;
  public String a;
  public View b;
  
  public CommonTabFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(getString(2131438317)).a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a("").a(null);
    }
  }
  
  void a(Activity paramActivity, NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("CommonTabFragment", "createWebView", new Object[] { this.jdField_a_of_type_Aduz, paramActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
      }
      if ((this.jdField_a_of_type_Aduz == null) && (paramActivity != null) && (paramNearbyAppInterface != null))
      {
        this.jdField_a_of_type_Aduz = new aduz(this, paramActivity.getBaseContext(), paramActivity, paramNearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("url", SharedPreUtils.d(paramActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()));
          WebAccelerateHelper.getInstance().preGetKey(localIntent, paramNearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo != null) {
      this.jdField_a_of_type_JavaLangString = ("latitude=" + paramSosoLbsInfo.a.a + "&longitude=" + paramSosoLbsInfo.a.b);
    }
    d();
  }
  
  public boolean a(long paramLong, Map paramMap, int paramInt1, int paramInt2, Intent paramIntent)
  {
    CustomWebView localCustomWebView;
    if (this.jdField_a_of_type_Aduz != null) {
      localCustomWebView = this.jdField_a_of_type_Aduz.a();
    }
    while (localCustomWebView != null)
    {
      this.jdField_a_of_type_Aduz.b();
      WebViewPluginEngine localWebViewPluginEngine = localCustomWebView.a();
      if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(localCustomWebView.getUrl(), paramLong, paramMap)))
      {
        return true;
        localCustomWebView = null;
      }
      else
      {
        int i = paramInt2 >> 8 & 0xFF;
        if (i > 0)
        {
          if ((localCustomWebView != null) && (localWebViewPluginEngine != null))
          {
            if ((paramIntent != null) && (paramIntent.hasExtra("entryId")) && (localWebViewPluginEngine.a("card") == null)) {
              localWebViewPluginEngine.a(new String[] { "card" });
            }
            paramMap = localWebViewPluginEngine.a(i, true);
            if (paramMap != null)
            {
              paramMap.onActivityResult(paramIntent, (byte)(paramInt2 & 0xFF), paramInt1);
              return true;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.w("CommonTabFragment", 2, "Caution! activity result not handled!");
          }
        }
      }
    }
    return false;
  }
  
  public void at_()
  {
    super.at_();
  }
  
  public void d()
  {
    if ((this.f) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    do
    {
      return;
      long l = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
        l = System.currentTimeMillis();
      }
      this.f = true;
      if (!this.jdField_a_of_type_Aduz.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_Aduz.a();
      }
      if (this.jdField_a_of_type_ComTencentBizUiRefreshView != null)
      {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_Aduz.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_Aduz.jdField_a_of_type_ComTencentBizUiTouchWebView, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if ((this.jdField_a_of_type_Aduz.b) && (this.b != null)) {
        this.b.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l) });
        }
      }
    } while ((!(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity instanceof NearbyActivity)) || (this.jdField_a_of_type_Aduz == null));
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.centerView.setClickable(true);
    ((NearbyActivity)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity).a(new adux(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.d == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonTabFragment", 2, "startLocation start" + System.currentTimeMillis());
      }
      SosoInterface.a(new aduy(this, 0, true, false, 300000L, true, false, "NearbyNowliveTab"));
      return false;
    }
    d();
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g) });
      }
    }
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_Aduz != null) {
      this.jdField_a_of_type_Aduz.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i) });
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("CommonTabFragment", new Object[] { "onCreateView", Long.valueOf(l) });
      }
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130969114, null);
        this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365256));
        this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131365257);
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(getString(2131435091)).a(false);
      e();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.d == 1)) {
        if ((this.e) && (!this.f)) {
          SosoInterface.a(new aduw(this, 0, true, false, 30000L, true, false, "NearbyNowliveTab"));
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j == 0L))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j = (System.currentTimeMillis() - l);
          if (QLog.isDevelopLevel()) {
            NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j) });
          }
        }
        return this.jdField_a_of_type_AndroidViewView;
        d();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.f) {
      return;
    }
    this.jdField_a_of_type_Aduz.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.f) {
      return;
    }
    this.jdField_a_of_type_Aduz.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.f) {}
    do
    {
      return;
      this.jdField_a_of_type_Aduz.b();
    } while (NetworkUtil.g(getActivity()));
    QQToast.a(getActivity(), 1, "当前网络不可用，请检查网络设置", 0).b(getActivity().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CommonTabFragment
 * JD-Core Version:    0.7.0.1
 */