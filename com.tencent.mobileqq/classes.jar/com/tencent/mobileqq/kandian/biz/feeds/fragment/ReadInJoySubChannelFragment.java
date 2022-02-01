package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;

public class ReadInJoySubChannelFragment
  extends ReadInJoyBaseFragment
{
  private static long a = 0L;
  public static final String a = "com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment";
  protected int a;
  protected View a;
  protected ReadInJoyChannelViewController a;
  protected String b;
  protected int c;
  
  public ReadInJoySubChannelFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public static ReadInJoySubChannelFragment a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoySubChannelFragment localReadInJoySubChannelFragment = new ReadInJoySubChannelFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt1);
    localBundle.putInt("channel_type", paramInt2);
    localBundle.putString("channel_name", paramString);
    localReadInJoySubChannelFragment.setArguments(localBundle);
    return localReadInJoySubChannelFragment;
  }
  
  private void a()
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d((String)localObject, 2, new Object[] { "initUI, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376123);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = new ReadInJoyChannelViewController(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.b(this.c);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a((ViewGroup)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.aw_();
    localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a();
    int i = a();
    if ((!this.d) && (i > 0)) {
      ((ViewGroup)localObject).setPadding(0, i, 0, 0);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null)
    {
      localReadInJoyChannelViewController.a(true);
      return;
    }
    ReadInJoyChannelViewPagerController.d(b());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (paramActivity != null)
    {
      paramActivity.i();
      if (a() != null)
      {
        paramActivity = a().getKandianLockScreenRedPntInfo();
        if ((a().hasKandianOrSubscribePush()) && (paramActivity != null)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.a(true);
        }
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void e()
  {
    super.e();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.h();
    }
  }
  
  public void f()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public void g()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("channel_id");
      this.c = ((Bundle)localObject).getInt("channel_type");
      this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("channel_name");
    }
    localObject = jdField_a_of_type_JavaLangString;
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onCreate, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewLayoutInflater;
    boolean bool = false;
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560199, paramViewGroup, false);
    a();
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new RIJDtParamBuilder().a(Integer.valueOf(this.jdField_a_of_type_Int)).a());
    paramLayoutInflater = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
      bool = true;
    }
    QLog.d(paramLayoutInflater, 2, new Object[] { "onCreateView, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onDestroy, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onDestroy();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).e();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController = null;
  }
  
  public void onDestroyView()
  {
    String str = jdField_a_of_type_JavaLangString;
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onDestroyView, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onDestroyView();
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void onPause()
  {
    String str = jdField_a_of_type_JavaLangString;
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onPause, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int), ", mIsShowingSelf = ", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    super.onPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.h();
    }
  }
  
  public void onResume()
  {
    String str = jdField_a_of_type_JavaLangString;
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onResume, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int), ", mIsShowingSelf = ", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController.i();
    }
  }
  
  public void onStart()
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onStart, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onStart();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).f();
    }
  }
  
  public void onStop()
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onStop, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onStop();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyChannelViewController;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment
 * JD-Core Version:    0.7.0.1
 */