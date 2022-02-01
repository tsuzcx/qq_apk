package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyStaticGridView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.feeds.RIJBaseChannelGridViewAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.RIJDynamicChannelGridViewAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.db.struct.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

class ReadInJoyChannelPanelFragment$MyChannelAdapterCallback
  implements RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback
{
  private int jdField_a_of_type_Int = -1;
  private int b = 0;
  
  private ReadInJoyChannelPanelFragment$MyChannelAdapterCallback(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment) {}
  
  private int a()
  {
    if (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment) == null) {
      return -1;
    }
    List localList = ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).a();
    if (localList == null) {
      return -1;
    }
    int i = 0;
    while (i < localList.size())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localList.get(i);
      int k = ChannelCoverInfoModule.a();
      int j = k;
      if (k == -1) {
        j = 0;
      }
      if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == j)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void a(RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter)
  {
    int i = a();
    if (i != -1)
    {
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment, i);
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramRIJBaseChannelGridViewAdapter.getItem(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment));
      if (localTabChannelCoverInfo != null)
      {
        localTabChannelCoverInfo.isCurrent = true;
        paramRIJBaseChannelGridViewAdapter.notifyDataSetChanged();
      }
      paramRIJBaseChannelGridViewAdapter = new StringBuilder();
      paramRIJBaseChannelGridViewAdapter.append("getRecommendChannelIndex: ");
      paramRIJBaseChannelGridViewAdapter.append(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment));
      QLog.d("ReadInJoyChannelPanelFragment", 1, paramRIJBaseChannelGridViewAdapter.toString());
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, ReadInJoyDynamicGridView.BaseDynamicGridAdapter paramBaseDynamicGridAdapter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearChannelInfoRedDot, tabChannelCoverInfo = ");
    localStringBuilder.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, localStringBuilder.toString());
    if (RIJChannelHelper.a(paramTabChannelCoverInfo) >= 0)
    {
      ReadInJoyChannelPanelFragment.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment, true);
      paramTabChannelCoverInfo.redPoint.a = false;
      if (paramBaseDynamicGridAdapter != null) {
        paramBaseDynamicGridAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void b(int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", tabChannelCoverInfo = ");
    localStringBuilder.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem, position = ", Integer.valueOf(paramInt), localStringBuilder.toString() });
    int[] arrayOfInt = new int[2];
    if (paramInt < this.b)
    {
      QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "can not delete item, position = ", Integer.valueOf(paramInt), ", lockCount = ", Integer.valueOf(this.b) });
      return;
    }
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment, paramTabChannelCoverInfo);
    try
    {
      RIJChannelReporter.a("0X800949C", new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addContentType(RIJChannelHelper.a(paramTabChannelCoverInfo)).build());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).getChildAt(paramInt) == null)
    {
      paramRIJBaseChannelGridViewAdapter = new StringBuilder();
      paramRIJBaseChannelGridViewAdapter.append(", tabChannelCoverInfo = ");
      paramRIJBaseChannelGridViewAdapter.append(paramTabChannelCoverInfo);
      QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem NPE, position = ", Integer.valueOf(paramInt), paramRIJBaseChannelGridViewAdapter.toString() });
      return;
    }
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).getChildAt(paramInt).getLocationOnScreen(arrayOfInt);
    if (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).a(paramInt, ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).getCount() - 1))
    {
      ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).findViewWithTag(Long.valueOf(paramTabChannelCoverInfo.sectionId));
      if (localReadInJoyStaticGridView == null)
      {
        localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).get(0);
        paramTabChannelCoverInfo.channelConfigType = ((ChannelSection)ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).get(1)).a;
      }
      else
      {
        paramTabChannelCoverInfo.channelConfigType = paramTabChannelCoverInfo.sectionId;
      }
      localReadInJoyStaticGridView.a(localReadInJoyStaticGridView.getAdapter().getCount() - 1, 0, paramTabChannelCoverInfo);
      paramTabChannelCoverInfo = new ReadInJoyChannelPanelFragment.MyChannelAdapterCallback.2(this, localReadInJoyStaticGridView, arrayOfInt);
      localReadInJoyStaticGridView.setTag(2131376044, paramTabChannelCoverInfo);
      localReadInJoyStaticGridView.getViewTreeObserver().addOnPreDrawListener(paramTabChannelCoverInfo);
      if (paramInt == ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment)) {
        a(paramRIJBaseChannelGridViewAdapter);
      }
    }
  }
  
  public void a()
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, "onActionDrop");
    ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment, false);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment, -1);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).setLockCount(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLockCountChanged:");
    localStringBuilder.append(paramInt);
    QLog.d("ReadInJoyChannelPanelFragment", 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onClick, delete button position = ", Integer.valueOf(paramInt) });
    b(paramInt, paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
  }
  
  public void a(RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDragPositionsChanged, onDragPosition: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("ReadInJoyChannelPanelFragment", 1, localStringBuilder.toString());
    paramInt1 = this.jdField_a_of_type_Int;
    if (paramInt1 >= 0) {
      paramRIJBaseChannelGridViewAdapter = (TabChannelCoverInfo)paramRIJBaseChannelGridViewAdapter.getItem(paramInt1);
    } else {
      paramRIJBaseChannelGridViewAdapter = null;
    }
    if (paramRIJBaseChannelGridViewAdapter != null) {
      try
      {
        RIJChannelReporter.a("0X800949B", new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addChannelId(paramRIJBaseChannelGridViewAdapter.mChannelCoverId).addContentType(RIJChannelHelper.a(paramRIJBaseChannelGridViewAdapter)).build());
      }
      catch (JSONException paramRIJBaseChannelGridViewAdapter)
      {
        paramRIJBaseChannelGridViewAdapter.printStackTrace();
      }
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment).put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), paramTabChannelCoverInfo);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    ReportData localReportData = new ReportData();
    localReportData.a = paramTabChannelCoverInfo;
    localReportData.l = paramInt;
    RIJChannelReporter.a(localReportData, TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG);
  }
  
  public void a(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onMyChannelClick, position = ", Integer.valueOf(paramInt), ", tab = ", paramTabChannelCoverInfo, ", isEditMode: ", Boolean.valueOf(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment)) });
    if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment))
    {
      try
      {
        RIJChannelReporter.a("0X8009499", new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addContentType(RIJChannelHelper.a(paramTabChannelCoverInfo)).addRedDotStatus(RIJChannelHelper.a(paramTabChannelCoverInfo)).addType((int)paramTabChannelCoverInfo.sectionId).addStringNotThrow("style", 1).build());
      }
      catch (JSONException paramAdapterView)
      {
        paramAdapterView.printStackTrace();
      }
      a(paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment.getBaseActivity().finish();
      if (ReadInJoyHelper.y()) {
        ReadInJoyLogicEngine.a().a(paramTabChannelCoverInfo.mChannelCoverId, 3, false, true);
      } else {
        ReadInJoyLogicEngine.a().b(paramTabChannelCoverInfo.mChannelCoverId, 3);
      }
      RIJThreadHandler.b().post(new ReadInJoyChannelPanelFragment.MyChannelAdapterCallback.1(this, paramTabChannelCoverInfo));
      return;
    }
    b(paramInt, paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment);
  }
  
  public void b(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    paramAdapterView = new StringBuilder();
    paramAdapterView.append(", tabInfo = ");
    paramAdapterView.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onChannelLongClick, position = ", Integer.valueOf(paramInt), paramAdapterView.toString() });
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment, true);
    if (paramInt >= this.b)
    {
      this.jdField_a_of_type_Int = paramInt;
      ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment, true);
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment, paramTabChannelCoverInfo);
    }
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment, paramInt);
    try
    {
      RIJChannelReporter.a("0X800949A", new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addContentType(RIJChannelHelper.a(paramTabChannelCoverInfo)).build());
      return;
    }
    catch (JSONException paramAdapterView)
    {
      paramAdapterView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment.MyChannelAdapterCallback
 * JD-Core Version:    0.7.0.1
 */