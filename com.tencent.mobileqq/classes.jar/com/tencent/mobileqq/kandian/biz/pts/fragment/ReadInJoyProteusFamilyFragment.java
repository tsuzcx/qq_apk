package com.tencent.mobileqq.kandian.biz.pts.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyProteusFamilyViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil;
import com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil.OnProteusFamilyDataLoaded;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ReadInJoyProteusFamilyFragment
  extends IphoneTitleBarFragment
  implements ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener, ReadInJoyProteusFamilyUtil.OnProteusFamilyDataLoaded
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyProteusFamilyViewController jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController;
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController = new ReadInJoyProteusFamilyViewController((Activity)localObject);
      localObject = (ViewGroup)this.mContentView.findViewById(2131373168);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController.a((ViewGroup)localObject);
      b();
    }
  }
  
  private void a(int paramInt)
  {
    if (this.leftView != null)
    {
      this.leftView.setTextColor(paramInt);
      this.leftView.setBackgroundResource(2130849814);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(paramInt);
    }
  }
  
  private void b()
  {
    setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131717989));
    RIJAppSetting.a(getTitleBarView());
    a(-16777216);
    Object localObject = this.rightViewImg;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageResource(2130842958);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(0);
      ((ImageView)localObject).setOnClickListener(new ReadInJoyProteusFamilyFragment.2(this, (ImageView)localObject));
    }
    localObject = getTitleBarView();
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new ReadInJoyProteusFamilyFragment.3(this));
    }
  }
  
  public void a(BaseActivity paramBaseActivity, View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[3];
    int[] tmp16_14 = arrayOfInt;
    tmp16_14[0] = 0;
    int[] tmp20_16 = tmp16_14;
    tmp20_16[1] = 1;
    int[] tmp24_20 = tmp20_16;
    tmp24_20[2] = 2;
    tmp24_20;
    String str1 = BaseApplicationImpl.getApplication().getString(2131717989);
    String str2 = BaseApplicationImpl.getApplication().getString(2131717989);
    String str3 = BaseApplicationImpl.getApplication().getString(2131717989);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = arrayOfInt[i];
      localMenuItem.title = new String[] { str1, str2, str3 }[i];
      localMenuItem.iconId = new int[] { 2130842951, 2130842952, 2130842951 }[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    i = ViewUtils.a(125.0F);
    PopupMenuDialog.build(paramBaseActivity, localArrayList, new ReadInJoyProteusFamilyFragment.4(this), new ReadInJoyProteusFamilyFragment.5(this), i, false, -1, 2131755036).showAsDropDown(paramView, -(i - paramView.getWidth()), 0);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean, List<AbsBaseArticleInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ReadInJoyProteusFamilyFragment.1(this, paramList));
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController.aw_();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131366758));
    ReadInJoyDropFrameHelper.a().a(8888, this);
  }
  
  protected int getContentLayoutId()
  {
    return 2131560260;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getBaseActivity();
    ReadInJoyProteusFamilyUtil.a().a(this);
    ReadInJoyProteusFamilyUtil.a().c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyProteusFamilyUtil.a().d();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.e();
    }
    ReadInJoyDropFrameHelper.a().b(8888, this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.i();
    }
    RIJAppSetting.a(getBaseActivity(), true, RIJAppSetting.a(getBaseActivity()));
  }
  
  public void onStart()
  {
    super.onStart();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.f();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyProteusFamilyViewController;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.fragment.ReadInJoyProteusFamilyFragment
 * JD-Core Version:    0.7.0.1
 */