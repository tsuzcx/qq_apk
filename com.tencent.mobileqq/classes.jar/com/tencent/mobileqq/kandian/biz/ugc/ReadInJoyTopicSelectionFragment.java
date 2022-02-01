package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Intent;
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
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadInJoyTopicSelectionFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private ReadInJoyTopicListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingReadInJoyTopicListAdapter;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyTopicSelectionFragment.1(this);
  List<Map<String, CharSequence>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<TopicInfo> b;
  private View c;
  
  public ReadInJoyTopicSelectionFragment()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    this.c.setVisibility(0);
  }
  
  private void a(TopicInfo paramTopicInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRA_SELECTED_TOPIC", paramTopicInfo);
    getQBaseActivity().setResult(-1, localIntent);
    onBackEvent();
  }
  
  private static List<Map<String, CharSequence>> b(List<TopicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TopicInfo localTopicInfo = (TopicInfo)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("key_cover_url", localTopicInfo.c());
      localHashMap.put("key_title", localTopicInfo.a());
      localHashMap.put("key_summary", localTopicInfo.b());
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }
  
  private void b(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131378304);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingReadInJoyTopicListAdapter = new ReadInJoyTopicListAdapter(getQBaseActivity(), this.jdField_a_of_type_JavaUtilList);
    paramViewGroup = (ListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370164);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.addFooterView(paramLayoutInflater.inflate(2131560298, paramViewGroup, false));
    paramViewGroup.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingReadInJoyTopicListAdapter);
    ReadInJoyLogicEngine.a().g(null);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.changeBg(true);
    a(getString(2131717944));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690529);
    Utils.a(this);
  }
  
  private void d()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", this.jdField_a_of_type_Int);
    localIntent.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a(getQBaseActivity(), localIntent, QPublicTransFragmentActivity.class, ReadInJoyUgcSearchTopicFragment.class, 1000);
  }
  
  protected int a()
  {
    return 2131560297;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    b(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null) {
      this.jdField_a_of_type_Int = paramLayoutInflater.getInt("searchTopicFrom");
    }
    RIJDtReportHelper.a.a(getQBaseActivity());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = (TopicInfo)paramIntent.getParcelableExtra("EXTRA_SELECTED_TOPIC");
      if (paramIntent != null) {
        a(paramIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131378304) {
      return;
    }
    this.c.setVisibility(8);
    d();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
    {
      a((TopicInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt));
      paramAdapterView = (TopicInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      paramLong = -1L;
      if (paramAdapterView != null) {
        paramLong = paramAdapterView.a();
      }
      ReadInJoyUtils.a("0X800980A", this.jdField_a_of_type_Int, paramLong, "0");
      RIJDeliverUGCReportUtil.a(String.valueOf(paramLong), "0");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void onResume()
  {
    super.onResume();
    c();
    a();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyTopicSelectionFragment
 * JD-Core Version:    0.7.0.1
 */