package com.tencent.mobileqq.fragment;

import alud;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import asfg;
import asfh;
import asfi;
import ashu;
import auwz;
import bdin;
import bdne;
import beej;
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
  View.OnClickListener a;
  public asfi a;
  public RefreshView a;
  public NearbyActivity a;
  public String a;
  public View b;
  
  public CommonTabFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_Ashu.a(getString(2131699536)).a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ashu.a();
      return;
      this.jdField_a_of_type_Ashu.a("").a(null);
    }
  }
  
  public beej a()
  {
    return this.jdField_a_of_type_Asfi;
  }
  
  void a(Activity paramActivity, NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        auwz.a("CommonTabFragment", "createWebView", new Object[] { this.jdField_a_of_type_Asfi, paramActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
      }
      if ((this.jdField_a_of_type_Asfi == null) && (paramActivity != null) && (paramNearbyAppInterface != null))
      {
        this.jdField_a_of_type_Asfi = new asfi(this, paramActivity.getBaseContext(), paramActivity, paramNearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("url", bdne.e(paramActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()));
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
      if (TextUtils.isEmpty(paramSosoLbsInfo.a.f)) {
        break label126;
      }
    }
    label126:
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_JavaLangString = ("latitude=" + paramSosoLbsInfo.a.a + "&longitude=" + paramSosoLbsInfo.a.b + "&areaStat=" + i + "&code=" + paramSosoLbsInfo.a.f);
      if (QLog.isDevelopLevel()) {
        QLog.i("CommonTabFragment", 4, " nearbyTabLocParams = " + this.jdField_a_of_type_JavaLangString);
      }
      e();
      return;
    }
  }
  
  public boolean a(long paramLong, Map<String, Object> paramMap, int paramInt1, int paramInt2, Intent paramIntent)
  {
    CustomWebView localCustomWebView;
    if (this.jdField_a_of_type_Asfi != null) {
      localCustomWebView = this.jdField_a_of_type_Asfi.getWebView();
    }
    while (localCustomWebView != null)
    {
      this.jdField_a_of_type_Asfi.b();
      WebViewPluginEngine localWebViewPluginEngine = localCustomWebView.getPluginEngine();
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
  
  public void aR_()
  {
    super.aR_();
  }
  
  public void d()
  {
    if (getActivity() == null) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
      QLog.e("CommonTabFragment", 1, "ACCESS_FINE_LOCATION permission not granted!");
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        SosoInterface.a(new asfg(this, 3, true, false, 30000L, true, false, "NearbyNowliveTab"));
        return;
      }
      e();
      return;
    }
  }
  
  public void e()
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
      if (!this.jdField_a_of_type_Asfi.a)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_Asfi.a();
      }
      if (this.jdField_a_of_type_ComTencentBizUiRefreshView != null)
      {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_Asfi.mWebview.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_Asfi.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if ((this.jdField_a_of_type_Asfi.b) && (this.b != null)) {
        this.b.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          auwz.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l) });
        }
      }
    } while ((!(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity instanceof NearbyActivity)) || (this.jdField_a_of_type_Asfi == null));
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.centerView.setClickable(true);
    ((NearbyActivity)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity).a(new asfh(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.needLoc == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CommonTabFragment", 2, "startLocation start" + System.currentTimeMillis());
        }
        d();
      }
      else
      {
        e();
      }
    }
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
        auwz.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g) });
      }
    }
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_Asfi != null) {
      this.jdField_a_of_type_Asfi.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g);
      if (QLog.isDevelopLevel()) {
        auwz.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i) });
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      if (QLog.isColorLevel()) {
        auwz.a("CommonTabFragment", new Object[] { "onCreateView", Long.valueOf(l) });
      }
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559374, null);
        this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380159));
        this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131367765);
      }
      this.jdField_a_of_type_Ashu.b(getString(2131694687)).a(false);
      f();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.needLoc == 1)) {
        if ((this.e) && (!this.f)) {
          d();
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j == 0L))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j = (System.currentTimeMillis() - l);
          if (QLog.isDevelopLevel()) {
            auwz.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j) });
          }
        }
        return this.jdField_a_of_type_AndroidViewView;
        e();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.f) {
      return;
    }
    this.jdField_a_of_type_Asfi.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.f) {
      return;
    }
    this.jdField_a_of_type_Asfi.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.f) {}
    do
    {
      return;
      this.jdField_a_of_type_Asfi.b();
    } while (bdin.g(getActivity()));
    QQToast.a(getActivity(), 1, alud.a(2131702633), 0).b(getActivity().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CommonTabFragment
 * JD-Core Version:    0.7.0.1
 */