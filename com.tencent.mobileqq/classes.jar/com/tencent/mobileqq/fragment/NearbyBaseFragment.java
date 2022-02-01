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
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  INearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface;
  INearbyTabInfo jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo = null;
  private boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 5000;
  boolean jdField_b_of_type_Boolean;
  boolean c;
  protected boolean d = false;
  
  protected INearbyAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface;
  }
  
  public AbsWebView a()
  {
    return null;
  }
  
  public void a(INearbyTabInfo paramINearbyTabInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo = paramINearbyTabInfo;
    this.e = paramINearbyTabInfo.getTabIndex();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void aR_()
  {
    super.aR_();
    if (!this.jdField_b_of_type_Boolean)
    {
      if ((this.f != null) && (!this.c) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void d()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        return;
      }
      try
      {
        int i = localAbsWebView.mWebview.getWebScrollY();
        int j = localAbsWebView.mWebview.getHeight();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("gotoFragmentHead, scrollY=");
          localStringBuilder.append(i);
          localStringBuilder.append(", webH=");
          localStringBuilder.append(j);
          localStringBuilder.append(", maxV=");
          localStringBuilder.append(this.jdField_b_of_type_Int);
          QLog.d("NearbyBaseFragment", 2, localStringBuilder.toString());
        }
        if (i > j)
        {
          localAbsWebView.mWebview.getView().scrollTo(0, j);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyBaseFragment.1(this, localAbsWebView), 60L);
          return;
        }
        localAbsWebView.mWebview.flingScroll(0, -this.jdField_b_of_type_Int);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
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
    int j = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
    this.jdField_b_of_type_Int = (i / 4);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAttach: maxVelocity=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", minVelocity=");
      ((StringBuilder)localObject).append(j);
      QLog.d("NearbyBaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = this.m;
    localObject = null;
    if (bool)
    {
      if ((paramActivity instanceof BaseActivity)) {
        localObject = ((BaseActivity)paramActivity).getAppInterface();
      }
      if ((localObject instanceof INearbyAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface = ((INearbyAppInterface)localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface = null;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo == null))
    {
      paramViewGroup = paramBundle.getString("info");
      if (!TextUtils.isEmpty(paramViewGroup)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo = ((IFactoryApi)QRoute.api(IFactoryApi.class)).parserFormJson(paramViewGroup);
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
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo == null) {
        bool1 = true;
      }
      paramViewGroup.append(bool1);
      paramViewGroup.append(", this=");
      paramViewGroup.append(this);
      QLog.d("NearbyBaseFragment", 2, paramViewGroup.toString());
    }
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo;
    if ((paramViewGroup != null) && (jdField_a_of_type_Int == paramViewGroup.getTabIndex()) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_b_of_type_Boolean = true;
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo;
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
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo == null) {
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
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyBaseFragment
 * JD-Core Version:    0.7.0.1
 */