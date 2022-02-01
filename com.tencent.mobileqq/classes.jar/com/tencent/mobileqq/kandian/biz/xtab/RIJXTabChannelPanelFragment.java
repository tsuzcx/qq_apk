package com.tencent.mobileqq.kandian.biz.xtab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyStaticGridView;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.RIJStaticChannelGridViewAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.RIJBaseChannelPanelFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class RIJXTabChannelPanelFragment
  extends RIJBaseChannelPanelFragment
{
  private ReadInJoyStaticGridView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyStaticGridView;
  private RIJStaticChannelGridViewAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJStaticChannelGridViewAdapter;
  private ReadInJoyLogicEngine jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, TabChannelCoverInfo> jdField_a_of_type_JavaUtilMap;
  
  private boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, List<TabChannelCoverInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.next();
      if ((localTabChannelCoverInfo.mChannelCoverId == paramTabChannelCoverInfo.mChannelCoverId) || ((paramTabChannelCoverInfo.mChannelCoverName != null) && (paramTabChannelCoverInfo.mChannelCoverName.equals(localTabChannelCoverInfo.mChannelCoverName)))) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.a());
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void c()
  {
    ThreadManager.executeOnSubThread(new RIJXTabChannelPanelFragment.1(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyStaticGridView = ((ReadInJoyStaticGridView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376219));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJStaticChannelGridViewAdapter = new RIJStaticChannelGridViewAdapter(getBaseActivity(), 4, this.jdField_a_of_type_Int, new RIJXTabChannelPanelFragment.RecommendChannelAdapterCallback(this, null));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJStaticChannelGridViewAdapter.c(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyStaticGridView.setExpendable(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyStaticGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJStaticChannelGridViewAdapter);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyStaticGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJStaticChannelGridViewAdapter);
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (RIJChannelHelper.a(localTabChannelCoverInfo) == 1)
      {
        localTabChannelCoverInfo.redPoint.a = false;
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.a(localTabChannelCoverInfo);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.c(false);
  }
  
  public int a()
  {
    return 2131562717;
  }
  
  public String a()
  {
    return getString(2131718003);
  }
  
  @VisibleForTesting
  public List<TabChannelCoverInfo> a(List<ChannelSection> paramList)
  {
    Object localObject = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        ((List)localObject).addAll(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.b(i));
        i += 1;
      }
    }
    paramList = RIJXTabFrameUtils.getChannelCoverList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (!a(localTabChannelCoverInfo, paramList)) {
        localArrayList.add(localTabChannelCoverInfo);
      }
    }
    return localArrayList;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e();
    c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    d();
    f();
    return this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */