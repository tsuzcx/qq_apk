package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyFlowLayout;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ReadInJoyVideoTagSelectionFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new ReadInJoyVideoTagSelectionFragment.1(this);
  private ReadInJoyVideoTagSelectionFragment.SelectedTagsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter;
  private ReadInJoyVideoTagSelectionFragment.TagsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$TagsAdapter;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyVideoTagSelectionFragment.3(this);
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private DataSetObserver jdField_b_of_type_AndroidDatabaseDataSetObserver = new ReadInJoyVideoTagSelectionFragment.2(this);
  private QQToast jdField_b_of_type_ComTencentMobileqqWidgetQQToast;
  private View c;
  private View d;
  private View e;
  private TextView g;
  
  private void a()
  {
    this.e.setVisibility(0);
  }
  
  private void c()
  {
    this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131378304);
    this.e.setOnClickListener(this);
    this.g = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378640));
    this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131365198);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365193);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131367030);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter = new ReadInJoyVideoTagSelectionFragment.SelectedTagsAdapter(getQBaseActivity(), 2131560309);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter);
    localReadInJoyFlowLayout.setOnItemClickListener(new ReadInJoyVideoTagSelectionFragment.4(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131367031);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$TagsAdapter = new ReadInJoyVideoTagSelectionFragment.TagsAdapter(getQBaseActivity(), 2131560309);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$TagsAdapter.registerDataSetObserver(this.jdField_b_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$TagsAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$TagsAdapter.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new ReadInJoyVideoTagSelectionFragment.5(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getQBaseActivity(), 2131718056, 0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getQBaseActivity(), 2131718055, 0);
    d();
  }
  
  private void d()
  {
    Object localObject2 = getQBaseActivity().getIntent();
    if (localObject2 != null)
    {
      localObject1 = ((Intent)localObject2).getStringExtra("EXTRA_TOPIC_ID");
      if (localObject1 == null) {}
    }
    try
    {
      localObject1 = Long.valueOf((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label31:
      ArrayList localArrayList;
      break label31;
    }
    QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
    Object localObject1 = null;
    localArrayList = ((Intent)localObject2).getParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST");
    localObject2 = localObject1;
    if (localArrayList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.addAll(localArrayList);
      localObject2 = localObject1;
      break label69;
      localObject2 = null;
    }
    label69:
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.notifyDataSetChanged();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    if (localObject2 != null)
    {
      ReadInJoyLogicEngine.a().b(((Long)localObject2).longValue());
      return;
    }
    ReadInJoyLogicEngine.a().f(null);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.changeBg(true);
    c(2131691064, this);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16265040);
    this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    a(getString(2131718031));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690529);
    Utils.a(this);
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.a());
    QPublicFragmentActivity.Launcher.a(getQBaseActivity(), localIntent, QPublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void g()
  {
    Object localObject = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.getItem(i));
      i += 1;
    }
    ((Intent)localObject).putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getQBaseActivity().setResult(-1, (Intent)localObject);
    getQBaseActivity().finish();
    localObject = Integer.valueOf(localArrayList.size()).toString();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F2", "0X80092F2", 0, 0, (String)localObject, "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  protected int a()
  {
    return 2131560308;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    RIJDtReportHelper.a.a(getQBaseActivity());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = (TagInfo)paramIntent.getParcelableExtra("SEARCH_TAG_RESULT");
      if ((paramIntent != null) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.a(paramIntent)) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    g();
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369233)
    {
      if (i != 2131378304) {
        return;
      }
      this.e.setVisibility(8);
      f();
      return;
    }
    g();
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void onResume()
  {
    super.onResume();
    e();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoTagSelectionFragment
 * JD-Core Version:    0.7.0.1
 */