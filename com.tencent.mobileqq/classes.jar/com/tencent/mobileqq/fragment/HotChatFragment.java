package com.tencent.mobileqq.fragment;

import ajyc;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import aqhm;
import aqhn;
import aqju;
import atbp;
import bbev;
import bbjn;
import bcpw;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class HotChatFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aqhm(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public RefreshView a;
  public NearbyActivity a;
  public HotChatFragment.HotChatWebView a;
  public ArrayList<Rect> a;
  BroadcastReceiver b;
  public View b;
  public boolean d = false;
  
  public HotChatFragment()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new aqhn(this);
    this.jdField_a_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      atbp.a("HotChatFragment", new Object[] { "HotChatFragment" });
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_Aqju.a(getString(2131699168)).a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqju.a();
      return;
      this.jdField_a_of_type_Aqju.a("").a(null);
    }
  }
  
  void a(Activity paramActivity, NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        atbp.a("HotChatFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView, paramActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView == null) && (paramActivity != null) && (paramNearbyAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView = new HotChatFragment.HotChatWebView(this, paramActivity.getBaseContext(), paramActivity, paramNearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("url", bbjn.e(paramActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()));
          WebAccelerateHelper.getInstance().preGetKey(localIntent, paramNearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if ((this.jdField_a_of_type_Boolean) && (this.c)) {
      e();
    }
  }
  
  void d()
  {
    if ((this.f) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    for (;;)
    {
      return;
      long l = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
        l = System.currentTimeMillis();
      }
      this.f = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.a();
      }
      if (this.jdField_a_of_type_ComTencentBizUiRefreshView != null)
      {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.mWebview.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.b) && (this.jdField_b_of_type_AndroidViewView != null)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      try
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.refresh_hot_chat_list");
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.get_banner_rect");
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l = (System.currentTimeMillis() - l);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        atbp.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l) });
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d();
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
        atbp.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g) });
      }
    }
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g);
      if (QLog.isDevelopLevel()) {
        atbp.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i) });
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      if (QLog.isColorLevel()) {
        atbp.a("HotChatFragment", new Object[] { "onCreateView", Long.valueOf(l) });
      }
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559324, null);
        this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379381));
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367626);
      }
      this.jdField_a_of_type_Aqju.b(getString(2131694528)).a(false);
      e();
      if ((this.e) && (!this.f)) {
        d();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j == 0L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          atbp.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j) });
        }
      }
      if (!this.d)
      {
        paramLayoutInflater = new Rect();
        paramLayoutInflater.top = 0;
        paramLayoutInflater.bottom = ((int)(315.0F * this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDisplayMetrics().density));
        this.jdField_a_of_type_JavaUtilArrayList.add(paramLayoutInflater);
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.f) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.d();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.f) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.f) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.b();
    } while (bbev.g(getActivity()));
    bcpw.a(getActivity(), 1, ajyc.a(2131705542), 0).b(getActivity().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.HotChatFragment
 * JD-Core Version:    0.7.0.1
 */