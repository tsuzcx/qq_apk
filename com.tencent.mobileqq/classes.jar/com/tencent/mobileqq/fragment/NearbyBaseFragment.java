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
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class NearbyBaseFragment
  extends BaseFragment
  implements Handler.Callback
{
  public static int b;
  public Handler a;
  public NearbyActivity.TabInfo a;
  public NearbyAppInterface a;
  boolean e;
  boolean f;
  
  public NearbyBaseFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo = null;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a(NearbyActivity.TabInfo paramTabInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo = paramTabInfo;
    this.jdField_a_of_type_Int = paramTabInfo.jdField_a_of_type_Int;
  }
  
  public void at_()
  {
    super.at_();
    if (!this.e)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.f) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      this.e = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppInterface localAppInterface = null;
    super.onAttach(paramActivity);
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
    if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo == null))
    {
      paramViewGroup = paramBundle.getString("info");
      if (!TextUtils.isEmpty(paramViewGroup))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo = new NearbyActivity.TabInfo();
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.a(paramViewGroup);
      }
    }
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder().append("onCreateView: inState==null?");
      if (paramBundle != null) {
        break label165;
      }
    }
    label165:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramViewGroup = paramViewGroup.append(bool1).append(", mTabInfo==null?");
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo == null) {
        bool1 = true;
      }
      QLog.d("NearbyBaseFragment", 2, bool1 + ", this=" + this);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) && (b == this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.jdField_a_of_type_Int) && (!this.e)) {
        this.e = true;
      }
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
    if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null)) {
      paramBundle.putString("info", this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.b());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSaveInstanceState: outState==null?");
      if (paramBundle != null) {
        break label102;
      }
      bool1 = true;
      paramBundle = localStringBuilder.append(bool1).append(", mTabInfo==null?");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyBaseFragment
 * JD-Core Version:    0.7.0.1
 */