package com.tencent.mobileqq.intervideo.now.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import arhz;
import arii;
import arjb;
import arjc;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.Global;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.NowPluginObserver;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qphone.base.util.QLog;

public class LoadingFragment
  extends IphoneTitleBarFragment
{
  static View jdField_a_of_type_AndroidViewView;
  arii jdField_a_of_type_Arii;
  NowPluginObserver jdField_a_of_type_ComTencentIntervideoNowproxyNowPluginObserver = new arjb(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
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
  
  public void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    } while (localFragmentActivity == null);
    localFragmentActivity.overridePendingTransition(0, 0);
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getArguments().putBoolean("loadingShow", true);
    hideTitleBar();
    if (jdField_a_of_type_AndroidViewView != null)
    {
      paramLayoutInflater = (FrameLayout)this.mContentView;
      if (paramLayoutInflater != null)
      {
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        paramLayoutInflater.addView(jdField_a_of_type_AndroidViewView, paramViewGroup);
      }
    }
    this.jdField_a_of_type_Arii.a.a.a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560875;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null) {}
    for (paramBundle = null; (paramBundle instanceof QQAppInterface); paramBundle = paramBundle.getAppInterface())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
      this.jdField_a_of_type_Arii = ((arii)paramBundle.getManager(306));
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
    if (this.jdField_a_of_type_Arii != null) {
      Global.removeNowPluginObserver(this.jdField_a_of_type_ComTencentIntervideoNowproxyNowPluginObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.LoadingFragment
 * JD-Core Version:    0.7.0.1
 */