package com.tencent.mobileqq.kandian.biz.ugc;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ReadInJoyDraftboxFragment
  extends IphoneTitleBarFragment
{
  private ReadInJoyDraftboxAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter;
  private ReadInJoyDraftboxModule jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxModule = ReadInJoyLogicEngine.a().a();
  private List<ReadInJoyDraftboxItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDraftboxFragment.1(this));
  }
  
  private static boolean b(ReadInJoyDraftboxItem paramReadInJoyDraftboxItem)
  {
    return (paramReadInJoyDraftboxItem.type != 1) && (paramReadInJoyDraftboxItem.type != 3) && (paramReadInJoyDraftboxItem.type != 2);
  }
  
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
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter = new ReadInJoyDraftboxAdapter(getBaseActivity(), this.jdField_a_of_type_JavaUtilList);
    if (this.mContentView != null)
    {
      paramLayoutInflater = (SwipListView)this.mContentView.findViewById(2131365875);
      paramLayoutInflater.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter);
      paramLayoutInflater.setDragEnable(true);
      paramLayoutInflater.setDivider(new ColorDrawable(Color.parseColor("#FFF2F2F2")));
      paramLayoutInflater.setDividerHeight(ViewUtils.a(0.5F));
      paramLayoutInflater.setEmptyView(this.mContentView.findViewById(2131365874));
    }
    setTitle(HardCodeUtil.a(2131712932));
    if (this.leftView != null) {
      this.leftView.setText(HardCodeUtil.a(2131712933));
    }
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131560179;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    RIJDtReportHelper.a.a(getBaseActivity(), "109");
  }
  
  public void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxFragment
 * JD-Core Version:    0.7.0.1
 */