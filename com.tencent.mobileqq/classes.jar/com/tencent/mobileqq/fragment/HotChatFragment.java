package com.tencent.mobileqq.fragment;

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
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.IHotChatFragment;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class HotChatFragment
  extends NearbyBaseFragment
  implements Handler.Callback, IHotChatFragment
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new HotChatFragment.1(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public View a;
  public RefreshView a;
  public NearbyActivity a;
  public HotChatFragment.HotChatWebView a;
  ArrayList<Rect> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  BroadcastReceiver b;
  
  public HotChatFragment()
  {
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new HotChatFragment.2(this);
    this.e = 2;
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatFragment", new Object[] { "HotChatFragment" });
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(getString(2131699035)).a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a("").a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
  }
  
  void a(Activity paramActivity, INearbyAppInterface paramINearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("HotChatFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView, paramActivity, paramINearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView == null) && (paramActivity != null) && (paramINearbyAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView = new HotChatFragment.HotChatWebView(this, paramActivity.getBaseContext(), paramActivity, (AppInterface)paramINearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("url", SharedPreUtils.e(paramActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin()));
          WebAccelerateHelper.getInstance().preGetKey(localIntent, (AppRuntime)paramINearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if ((this.m) && (this.o)) {
      c();
    }
  }
  
  void b()
  {
    if (!this.c)
    {
      if (this.f == null) {
        return;
      }
      long l = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
        l = System.currentTimeMillis();
      }
      this.c = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.a();
      }
      Object localObject = this.jdField_a_of_type_ComTencentBizUiRefreshView;
      if (localObject != null)
      {
        ((RefreshView)localObject).setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.mWebview.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.jdField_b_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      try
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mobileqq.refresh_hot_chat_list");
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mobileqq.get_banner_rect");
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      NearbyActivity localNearbyActivity = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
      if (localNearbyActivity != null)
      {
        localNearbyActivity.mInitTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime) });
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      b();
    }
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    NearbyActivity localNearbyActivity = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
    if ((localNearbyActivity != null) && (localNearbyActivity.mOnCreateMilliTimeStamp == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp) });
      }
    }
    super.onCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView;
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent());
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
    if ((paramBundle != null) && (paramBundle.onCreateTime == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime) });
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
      l = System.currentTimeMillis();
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatFragment", new Object[] { "onCreateView", Long.valueOf(l) });
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.f == null)
    {
      this.f = paramLayoutInflater.inflate(2131559479, null);
      this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.f.findViewById(2131381056));
      this.jdField_a_of_type_AndroidViewView = this.f.findViewById(2131368285);
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(getString(2131694387)).a(false);
    c();
    if ((this.jdField_b_of_type_Boolean) && (!this.c)) {
      b();
    }
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.mViewInflateTime == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mViewInflateTime = (System.currentTimeMillis() - l);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mViewInflateTime) });
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
    if (!this.c) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.c) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.c) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.b();
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
      QQToast.a(getBaseActivity(), 1, HardCodeUtil.a(2131705635), 0).b(getBaseActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.HotChatFragment
 * JD-Core Version:    0.7.0.1
 */