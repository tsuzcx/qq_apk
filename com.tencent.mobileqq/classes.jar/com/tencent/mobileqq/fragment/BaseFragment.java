package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import apqf;
import bbmv;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;

public class BaseFragment
  extends Fragment
{
  protected int a;
  protected View a;
  public apqf a;
  protected bbmv a;
  public IphoneTitleBarActivity a;
  protected boolean a;
  protected boolean b;
  protected boolean c;
  
  public BaseFragment()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Fragment", 2, "new BaseFragment:" + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void a() {}
  
  public boolean a()
  {
    return false;
  }
  
  public void aW_()
  {
    c();
    onHiddenChanged(false);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onPageSelected() " + getClass().getSimpleName());
    }
  }
  
  public void c()
  {
    if ((getActivity() instanceof NearbyActivity)) {
      ((NearbyActivity)getActivity()).a(this.jdField_a_of_type_Apqf);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onActivityCreated() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("NBase", 2, "onActivityResult() BaseFragment");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onAttach() " + getClass().getSimpleName() + " " + hashCode());
    }
    if (this.jdField_a_of_type_Apqf == null) {
      this.jdField_a_of_type_Apqf = new apqf(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = ((IphoneTitleBarActivity)getActivity());
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onCreate() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onCreateView() " + getClass().getSimpleName() + " " + hashCode());
    }
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onDestroy() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onDestroyView() " + getClass().getSimpleName() + " " + hashCode());
    }
    if (this.jdField_a_of_type_Bbmv != null) {
      this.jdField_a_of_type_Bbmv.b();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onDetach() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onHiddenChanged() " + getClass().getSimpleName() + " " + hashCode() + " hidden=" + paramBoolean);
    }
    if (paramBoolean)
    {
      onPause();
      return;
    }
    onResume();
  }
  
  public void onPause()
  {
    super.onPause();
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onPause() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.c = true;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onResume() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onStart() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onStop() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BaseFragment
 * JD-Core Version:    0.7.0.1
 */