package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.qphone.base.util.QLog;

public class NearbyMsgFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public NearbyActivity a;
  
  public void aR_()
  {
    super.aR_();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onPageSelected， startMsgBoxListActivity");
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onActivityCreated");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
    }
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onAttach");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onCreate");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreateView: lastIdx=");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getmLastTabIndex());
      QLog.i("nearby.NearbyMsgFragment", 2, paramBundle.toString());
    }
    if (this.f == null)
    {
      this.f = paramLayoutInflater.inflate(2131561192, paramViewGroup, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getmLastTabIndex() == this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo.getTabIndex()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.startMsgBoxListActivity(false);
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyMsgFragment", 2, "onCreateView, startMsgBoxListActivity");
        }
      }
    }
    return this.f;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onDestroy");
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onDestroyView");
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHiddenChanged, hidden=");
      localStringBuilder.append(paramBoolean);
      QLog.i("nearby.NearbyMsgFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onPause");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onResume");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyMsgFragment
 * JD-Core Version:    0.7.0.1
 */