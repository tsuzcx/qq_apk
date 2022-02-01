package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyPrivacyListFragment
  extends IphoneTitleBarFragment
  implements ReadInJoyPrivacyListView.LoadMoreCallback
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private ReadInJoyPrivacyListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListAdapter = null;
  private ReadInJoyPrivacyListView jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListView = null;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyPrivacyListFragment.1(this);
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 0;
  
  public void a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    if ((localBaseActivity.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      localBaseActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(localBaseActivity.getWindow(), localBaseActivity.isClearCoverLayer);
      if (localBaseActivity.mSystemBarComp == null) {
        localBaseActivity.mSystemBarComp = new SystemBarCompact(localBaseActivity, true, -1);
      }
      localBaseActivity.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(localBaseActivity.app))
      {
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
        {
          localBaseActivity.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          localBaseActivity.mSystemBarComp.setStatusBarColor(-7829368);
          localBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        localBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localBaseActivity.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.d())
      {
        localBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        localBaseActivity.mSystemBarComp.setStatusBarColor(-1);
        localBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849814);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    this.vg.setBackgroundColor(-1);
  }
  
  public void b()
  {
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Long, this.b, 30);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListView = ((ReadInJoyPrivacyListView)this.mContentView.findViewById(2131370164));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListAdapter = new ReadInJoyPrivacyListAdapter(getBaseActivity(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListView.setLoadMoreCallback(this);
    setTitle(HardCodeUtil.a(2131712773));
    if (this.leftView != null) {
      this.leftView.setText(HardCodeUtil.a(2131712854));
    }
    a();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  protected int getContentLayoutId()
  {
    return 2131560257;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = getBaseActivity().getIntent().getLongExtra("feeds_id", 0L);
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Long, this.b, 30);
    RIJDtReportHelper.a.a(getBaseActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListFragment
 * JD-Core Version:    0.7.0.1
 */