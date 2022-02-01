package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.WeakReferenceHandler;

public class NearbyBaseFragment
  extends TitlebarBaseFragment
  implements Handler.Callback
{
  public static int j;
  private boolean a = false;
  INearbyAppInterface k;
  Handler l = new WeakReferenceHandler(Looper.getMainLooper(), this);
  boolean m;
  boolean n;
  int o = 5000;
  protected boolean p = false;
  INearbyTabInfo q = null;
  
  public void a(INearbyTabInfo paramINearbyTabInfo)
  {
    this.q = paramINearbyTabInfo;
    this.ah = paramINearbyTabInfo.getTabIndex();
  }
  
  public AbsWebView b()
  {
    return null;
  }
  
  public void dw_()
  {
    super.dw_();
    if (!this.m)
    {
      if ((this.am != null) && (!this.n) && (!this.l.hasMessages(1))) {
        this.l.sendEmptyMessage(1);
      }
      this.m = true;
    }
  }
  
  public void e()
  {
    AbsWebView localAbsWebView = b();
    if (localAbsWebView != null)
    {
      if (this.l == null) {
        return;
      }
      try
      {
        int i = localAbsWebView.mWebview.getWebScrollY();
        int i1 = localAbsWebView.mWebview.getHeight();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("gotoFragmentHead, scrollY=");
          localStringBuilder.append(i);
          localStringBuilder.append(", webH=");
          localStringBuilder.append(i1);
          localStringBuilder.append(", maxV=");
          localStringBuilder.append(this.o);
          QLog.d("NearbyBaseFragment", 2, localStringBuilder.toString());
        }
        if (i > i1)
        {
          localAbsWebView.mWebview.getView().scrollTo(0, i1);
          this.l.postDelayed(new NearbyBaseFragment.1(this, localAbsWebView), 60L);
          return;
        }
        localAbsWebView.mWebview.flingScroll(0, -this.o);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected INearbyAppInterface f()
  {
    return this.k;
  }
  
  public boolean g()
  {
    return this.a;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    Object localObject = ViewConfiguration.get(paramActivity);
    int i = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
    int i1 = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
    this.o = (i / 4);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAttach: maxVelocity=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", minVelocity=");
      ((StringBuilder)localObject).append(i1);
      QLog.d("NearbyBaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = this.ai;
    localObject = null;
    if (bool)
    {
      if ((paramActivity instanceof BaseActivity)) {
        localObject = ((BaseActivity)paramActivity).getAppInterface();
      }
      if ((localObject instanceof INearbyAppInterface)) {
        this.k = ((INearbyAppInterface)localObject);
      }
    }
    else
    {
      this.k = null;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((paramBundle != null) && (this.q == null))
    {
      paramViewGroup = paramBundle.getString("info");
      if (!TextUtils.isEmpty(paramViewGroup)) {
        this.q = ((IFactoryApi)QRoute.api(IFactoryApi.class)).parserFormJson(paramViewGroup);
      }
    }
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("onCreateView: inState==null?");
      boolean bool2 = false;
      if (paramBundle == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramViewGroup.append(bool1);
      paramViewGroup.append(", mTabInfo==null?");
      boolean bool1 = bool2;
      if (this.q == null) {
        bool1 = true;
      }
      paramViewGroup.append(bool1);
      paramViewGroup.append(", this=");
      paramViewGroup.append(this);
      QLog.d("NearbyBaseFragment", 2, paramViewGroup.toString());
    }
    paramViewGroup = this.q;
    if ((paramViewGroup != null) && (j == paramViewGroup.getTabIndex()) && (!this.m)) {
      this.m = true;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Object localObject;
    if (paramBundle != null)
    {
      localObject = this.q;
      if (localObject != null) {
        paramBundle.putString("info", ((INearbyTabInfo)localObject).toJson());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSaveInstanceState: outState==null?");
      boolean bool2 = true;
      boolean bool1;
      if (paramBundle == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", mTabInfo==null?");
      if (this.q == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", this=");
      ((StringBuilder)localObject).append(this);
      QLog.d("NearbyBaseFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUserVisibleHint: isVisibleToUser=");
      localStringBuilder.append(paramBoolean);
      QLog.d("NearbyBaseFragment", 2, localStringBuilder.toString());
    }
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyBaseFragment
 * JD-Core Version:    0.7.0.1
 */