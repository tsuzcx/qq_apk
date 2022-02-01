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
  static View c;
  QQAppInterface a;
  IDynamicNowManager b;
  NowPluginObserver d = new LoadingFragment.1(this);
  
  public static void a(Context paramContext, Bundle paramBundle, View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    c = paramView;
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
    if (this.a == null) {
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
    if (c != null)
    {
      paramLayoutInflater = (FrameLayout)this.mContentView;
      if (paramLayoutInflater != null)
      {
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        if (c.getParent() != null) {
          ((ViewGroup)c.getParent()).removeView(c);
        }
        paramLayoutInflater.addView(c, paramViewGroup);
      }
    }
    ((NowDataReporter)this.b.j()).a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131627556;
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
      this.a = ((QQAppInterface)paramBundle);
      this.b = ((IDynamicNowManager)paramBundle.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER));
      Global.addNowPluginObserver(this.d);
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
    if (this.b != null) {
      Global.removeNowPluginObserver(this.d);
    }
    Object localObject = c;
    if (localObject != null)
    {
      localObject = (ViewGroup)((View)localObject).getParent();
      if (localObject != null)
      {
        QLog.i("LoadingFragment", 4, "removeView ");
        ((ViewGroup)localObject).removeView(c);
      }
    }
    c = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.LoadingFragment
 * JD-Core Version:    0.7.0.1
 */