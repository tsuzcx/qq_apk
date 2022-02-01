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
  private int b = -1;
  private int c = 0;
  
  private ReadInJoyChannelPanelFragment$MyChannelAdapterCallback(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment) {}
  
  private void a(RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter)
  {
    int i = b();
    if (i != -1)
    {
      ReadInJoyChannelPanelFragment.b(this.a, i);
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramRIJBaseChannelGridViewAdapter.getItem(ReadInJoyChannelPanelFragment.i(this.a));
      if (localTabChannelCoverInfo != null)
      {
        localTabChannelCoverInfo.isCurrent = true;
        paramRIJBaseChannelGridViewAdapter.notifyDataSetChanged();
      }
      paramRIJBaseChannelGridViewAdapter = new StringBuilder();
      paramRIJBaseChannelGridViewAdapter.append("getRecommendChannelIndex: ");
      paramRIJBaseChannelGridViewAdapter.append(ReadInJoyChannelPanelFragment.i(this.a));
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
      ReadInJoyChannelPanelFragment.c(this.a, true);
      paramTabChannelCoverInfo.redPoint.a = false;
      if (paramBaseDynamicGridAdapter != null) {
        paramBaseDynamicGridAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private int b()
  {
    if (ReadInJoyChannelPanelFragment.e(this.a) == null) {
      return -1;
    }
    List localList = ReadInJoyChannelPanelFragment.e(this.a).d();
    if (localList == null) {
      return -1;
    }
    int i = 0;
    while (i < localList.size())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localList.get(i);
      int k = ChannelCoverInfoModule.g();
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
  
  private void b(int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", tabChannelCoverInfo = ");
    localStringBuilder.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem, position = ", Integer.valueOf(paramInt), localStringBuilder.toString() });
    int[] arrayOfInt = new int[2];
    if (paramInt < this.c)
    {
      QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "can not delete item, position = ", Integer.valueOf(paramInt), ", lockCount = ", Integer.valueOf(this.c) });
      return;
    }
    ReadInJoyChannelPanelFragment.a(this.a, paramTabChannelCoverInfo);
    try
    {
      RIJChannelReporter.a("0X800949C", new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addContentType(RIJChannelHelper.a(paramTabChannelCoverInfo)).build());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (ReadInJoyChannelPanelFragment.a(this.a).getChildAt(paramInt) == null)
    {
      paramRIJBaseChannelGridViewAdapter = new StringBuilder();
      paramRIJBaseChannelGridViewAdapter.append(", tabChannelCoverInfo = ");
      paramRIJBaseChannelGridViewAdapter.append(paramTabChannelCoverInfo);
      QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem NPE, position = ", Integer.valueOf(paramInt), paramRIJBaseChannelGridViewAdapter.toString() });
      return;
    }
    ReadInJoyChannelPanelFragment.a(this.a).getChildAt(paramInt).getLocationOnScreen(arrayOfInt);
    if (ReadInJoyChannelPanelFragment.a(this.a).a(paramInt, ReadInJoyChannelPanelFragment.e(this.a).getCount() - 1))
    {
      ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.f(this.a).findViewWithTag(Long.valueOf(paramTabChannelCoverInfo.sectionId));
      if (localReadInJoyStaticGridView == null)
      {
        localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.g(this.a).get(0);
        paramTabChannelCoverInfo.channelConfigType = ((ChannelSection)ReadInJoyChannelPanelFragment.h(this.a).get(1)).a;
      }
      else
      {
        paramTabChannelCoverInfo.channelConfigType = paramTabChannelCoverInfo.sectionId;
      }
      localReadInJoyStaticGridView.a(localReadInJoyStaticGridView.getAdapter().getCount() - 1, 0, paramTabChannelCoverInfo);
      paramTabChannelCoverInfo = new ReadInJoyChannelPanelFragment.MyChannelAdapterCallback.2(this, localReadInJoyStaticGridView, arrayOfInt);
      localReadInJoyStaticGridView.setTag(2131444244, paramTabChannelCoverInfo);
      localReadInJoyStaticGridView.getViewTreeObserver().addOnPreDrawListener(paramTabChannelCoverInfo);
      if (paramInt == ReadInJoyChannelPanelFragment.i(this.a)) {
        a(paramRIJBaseChannelGridViewAdapter);
      }
    }
  }
  
  public void a()
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, "onActionDrop");
    ReadInJoyChannelPanelFragment.b(this.a, false);
    ReadInJoyChannelPanelFragment.a(this.a, -1);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    ReadInJoyChannelPanelFragment.a(this.a).setLockCount(paramInt);
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
    localStringBuilder.append(this.b);
    QLog.d("ReadInJoyChannelPanelFragment", 1, localStringBuilder.toString());
    paramInt1 = this.b;
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
    this.b = -1;
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    ReadInJoyChannelPanelFragment.d(this.a).put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), paramTabChannelCoverInfo);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    ReportData localReportData = new ReportData();
    localReportData.C = paramTabChannelCoverInfo;
    localReportData.D = paramInt;
    RIJChannelReporter.a(localReportData, TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG);
  }
  
  public void a(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onMyChannelClick, position = ", Integer.valueOf(paramInt), ", tab = ", paramTabChannelCoverInfo, ", isEditMode: ", Boolean.valueOf(ReadInJoyChannelPanelFragment.b(this.a)) });
    if (!ReadInJoyChannelPanelFragment.b(this.a))
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
      this.a.getBaseActivity().finish();
      if (ReadInJoyHelper.S()) {
        ReadInJoyLogicEngine.a().a(paramTabChannelCoverInfo.mChannelCoverId, 3, false, true);
      } else {
        ReadInJoyLogicEngine.a().b(paramTabChannelCoverInfo.mChannelCoverId, 3);
      }
      RIJThreadHandler.b().post(new ReadInJoyChannelPanelFragment.MyChannelAdapterCallback.1(this, paramTabChannelCoverInfo));
      return;
    }
    b(paramInt, paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
    ReadInJoyChannelPanelFragment.c(this.a);
  }
  
  public void b(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    paramAdapterView = new StringBuilder();
    paramAdapterView.append(", tabInfo = ");
    paramAdapterView.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onChannelLongClick, position = ", Integer.valueOf(paramInt), paramAdapterView.toString() });
    ReadInJoyChannelPanelFragment.a(this.a, true);
    if (paramInt >= this.c)
    {
      this.b = paramInt;
      ReadInJoyChannelPanelFragment.b(this.a, true);
      ReadInJoyChannelPanelFragment.a(this.a, paramTabChannelCoverInfo);
    }
    ReadInJoyChannelPanelFragment.a(this.a, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment.MyChannelAdapterCallback
 * JD-Core Version:    0.7.0.1
 */