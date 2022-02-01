package com.tencent.mobileqq.intervideo.now.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.Global;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.NowPluginObserver;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.qphone.base.util.QLog;

public class LoadingFragment
  extends IphoneTitleBarFragment
{
  static View jdField_a_of_type_AndroidViewView;
  NowPluginObserver jdField_a_of_type_ComTencentIntervideoNowproxyNowPluginObserver = new LoadingFragment.1(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IDynamicNowManager jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicIDynamicNowManager;
  
  public static void a(Context paramContext, Bundle paramBundle, View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    jdField_a_of_type_AndroidViewView = paramView;
    PublicFragmentActivity.a(paramContext, localIntent, LoadingFragment.class);
  }
  
  protected void a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.overridePendingTransition(0, 0);
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getArguments().putBoolean("loadingShow", true);
    hideTitleBar();
    if (jdField_a_of_type_AndroidViewView != null)
    {
      paramLayoutInflater = (FrameLayout)this.mContentView;
      if (paramLayoutInflater != null)
      {
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        if (jdField_a_of_type_AndroidViewView.getParent() != null) {
          ((ViewGroup)jdField_a_of_type_AndroidViewView.getParent()).removeView(jdField_a_of_type_AndroidViewView);
        }
        paramLayoutInflater.addView(jdField_a_of_type_AndroidViewView, paramViewGroup);
      }
    }
    ((NowDataReporter)this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicIDynamicNowManager.a()).a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561204;
  }
  
  protected void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    paramBundle = getBaseActivity();
    if (paramBundle == null) {
      paramBundle = null;
    } else {
      paramBundle = paramBundle.getAppInterface();
    }
    if ((paramBundle instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicIDynamicNowManager = ((IDynamicNowManager)paramBundle.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER));
      Global.addNowPluginObserver(this.jdField_a_of_type_ComTencentIntervideoNowproxyNowPluginObserver);
      return;
    }
    QLog.e("IphoneTitleBarFragment", 1, "app is null");
    a();
  }
  
  public boolean onBackEvent()
  {
    NowLive.cancelRun();
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicIDynamicNowManager != null) {
      Global.removeNowPluginObserver(this.jdField_a_of_type_ComTencentIntervideoNowproxyNowPluginObserver);
    }
    Object localObject = jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (ViewGroup)((View)localObject).getParent();
      if (localObject != null)
      {
        QLog.i("LoadingFragment", 4, "removeView ");
        ((ViewGroup)localObject).removeView(jdField_a_of_type_AndroidViewView);
      }
    }
    jdField_a_of_type_AndroidViewView = null;
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.LoadingFragment
 * JD-Core Version:    0.7.0.1
 */