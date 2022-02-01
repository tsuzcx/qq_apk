package com.tencent.mobileqq.kandian.biz.comment.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment;

public class ReadInJoyCommentBridgeFragment
  extends PublicBaseFragment
{
  private ReadInJoyCommentComponentFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment;
  private ReadInJoyCommentEntrance jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  
  private void a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance = new ReadInJoyCommentEntrance(localBaseActivity, localBaseActivity.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance.a();
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaLangBoolean == null)
    {
      if ((Build.VERSION.SDK_INT != 21) && (Build.VERSION.SDK_INT != 22)) {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(ReadInJoyHelper.h());
      } else {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(ReadInJoyHelper.i());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUseCommentModule: useCommentModule=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangBoolean);
      QLog.d("ReadInJoyCommentBridgeFragment", 1, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  private boolean a(FragmentManager paramFragmentManager)
  {
    BaseFragment localBaseFragment = (BaseFragment)paramFragmentManager.findFragmentByTag("ReadInJoyCommentComponentFragment");
    if (localBaseFragment != null)
    {
      if ((localBaseFragment instanceof ReadInJoyCommentComponentFragment))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment = ((ReadInJoyCommentComponentFragment)localBaseFragment);
        return true;
      }
      paramFragmentManager.beginTransaction().remove(localBaseFragment).commitAllowingStateLoss();
    }
    return false;
  }
  
  private void b()
  {
    if (a()) {
      return;
    }
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment.isAdded()) {
      return;
    }
    Object localObject = getBaseActivity();
    if (localObject != null)
    {
      localObject = ((BaseActivity)localObject).getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131367211, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment, "ReadInJoyCommentComponentFragment");
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment != null) {
      return;
    }
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (a(localBaseActivity.getSupportFragmentManager()))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment = new ReadInJoyCommentComponentFragment();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment.setArguments(getArguments());
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    b();
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment;
    if (localReadInJoyCommentComponentFragment != null) {
      localReadInJoyCommentComponentFragment.initWindowStyleAndAnimation(paramActivity);
    }
  }
  
  public boolean isWrapContent()
  {
    b();
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment;
    if (localReadInJoyCommentComponentFragment != null) {
      return localReadInJoyCommentComponentFragment.isWrapContent();
    }
    return false;
  }
  
  public boolean needImmersive()
  {
    b();
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment;
    if (localReadInJoyCommentComponentFragment != null) {
      return localReadInJoyCommentComponentFragment.needImmersive();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @androidx.annotation.Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment;
    if (localObject != null) {
      ((ReadInJoyCommentComponentFragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseReadInJoyCommentEntrance;
    if (localObject != null) {
      ((ReadInJoyCommentEntrance)localObject).a().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment;
    if (localReadInJoyCommentComponentFragment != null) {
      return localReadInJoyCommentComponentFragment.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  @org.jetbrains.annotations.Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (a()) {
      a();
    } else {
      b();
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyCommentEntrance.e();
  }
  
  public void onFinish()
  {
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentComponentFragment;
    if (localReadInJoyCommentComponentFragment != null) {
      localReadInJoyCommentComponentFragment.onFinish();
    }
  }
  
  public void onPause()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (localFragmentActivity.isFinishing())) {
      ReadInJoyCommentEntrance.d();
    }
    super.onPause();
    ReadInJoyCommentEntrance.c();
  }
  
  public void onResume()
  {
    super.onResume();
    ReadInJoyCommentEntrance.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentBridgeFragment
 * JD-Core Version:    0.7.0.1
 */