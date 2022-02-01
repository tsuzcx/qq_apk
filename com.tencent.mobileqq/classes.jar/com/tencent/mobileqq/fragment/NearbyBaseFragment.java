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
import bimg;
import blhq;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class NearbyBaseFragment
  extends BaseFragment
  implements Handler.Callback
{
  public static int b;
  public Handler a;
  public NearbyAppInterface a;
  public NearbyTabInfo a;
  int c = 5000;
  private boolean d;
  boolean e;
  boolean f;
  public boolean g;
  
  public NearbyBaseFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo = null;
    this.jdField_a_of_type_AndroidOsHandler = new blhq(Looper.getMainLooper(), this);
  }
  
  public bimg a()
  {
    return null;
  }
  
  protected NearbyAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  }
  
  public void a()
  {
    bimg localbimg = a();
    if ((localbimg == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    try
    {
      int i = localbimg.mWebview.getWebScrollY();
      int j = localbimg.mWebview.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyBaseFragment", 2, "gotoFragmentHead, scrollY=" + i + ", webH=" + j + ", maxV=" + this.c);
      }
      if (i > j)
      {
        localbimg.mWebview.getView().scrollTo(0, j);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyBaseFragment.1(this, localbimg), 60L);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    localException.mWebview.flingScroll(0, -this.c);
  }
  
  public void a(NearbyTabInfo paramNearbyTabInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo = paramNearbyTabInfo;
    this.jdField_a_of_type_Int = paramNearbyTabInfo.tabIndex;
  }
  
  public void aP_()
  {
    super.aP_();
    if (!this.e)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.f) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      this.e = true;
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppInterface localAppInterface = null;
    super.onAttach(paramActivity);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramActivity);
    int i = localViewConfiguration.getScaledMaximumFlingVelocity();
    int j = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.c = (i / 4);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyBaseFragment", 2, "onAttach: maxVelocity=" + i + ", minVelocity=" + j);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramActivity instanceof BaseActivity)) {
        localAppInterface = ((BaseActivity)paramActivity).getAppInterface();
      }
      if ((localAppInterface instanceof NearbyAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)localAppInterface);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool2 = false;
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo == null))
    {
      paramViewGroup = paramBundle.getString("info");
      if (!TextUtils.isEmpty(paramViewGroup)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo = NearbyTabInfo.fromJson(paramViewGroup);
      }
    }
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder().append("onCreateView: inState==null?");
      if (paramBundle != null) {
        break label159;
      }
    }
    label159:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramViewGroup = paramViewGroup.append(bool1).append(", mTabInfo==null?");
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo == null) {
        bool1 = true;
      }
      QLog.d("NearbyBaseFragment", 2, bool1 + ", this=" + this);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo != null) && (b == this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo.tabIndex) && (!this.e)) {
        this.e = true;
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onSaveInstanceState(paramBundle);
    if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo != null)) {
      paramBundle.putString("info", this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo.toJson());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSaveInstanceState: outState==null?");
      if (paramBundle != null) {
        break label102;
      }
      bool1 = true;
      paramBundle = localStringBuilder.append(bool1).append(", mTabInfo==null?");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo != null) {
        break label107;
      }
    }
    label102:
    label107:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("NearbyBaseFragment", 2, bool1 + ", this=" + this);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyBaseFragment", 2, "setUserVisibleHint: isVisibleToUser=" + paramBoolean);
    }
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyBaseFragment
 * JD-Core Version:    0.7.0.1
 */