package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyStaticGridView;
import com.tencent.mobileqq.kandian.biz.feeds.RIJBaseChannelGridViewAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.RIJBaseChannelGridViewAdapter.AdapterCallback;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.db.struct.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.net.URLDecoder;
import java.util.Map;
import org.json.JSONException;

class ReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback
  implements RIJBaseChannelGridViewAdapter.AdapterCallback
{
  private final long b;
  private final int[] c = new int[2];
  
  public ReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, long paramLong)
  {
    this.b = paramLong;
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, ReadInJoyDynamicGridView.BaseDynamicGridAdapter paramBaseDynamicGridAdapter)
  {
    if (RIJChannelHelper.a(paramTabChannelCoverInfo) == 0)
    {
      ReadInJoyChannelPanelFragment.c(this.a, true);
      paramTabChannelCoverInfo.redPoint.a = false;
      if (paramBaseDynamicGridAdapter != null) {
        paramBaseDynamicGridAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, AdapterView<?> paramAdapterView, int paramInt, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", tab = ");
    localStringBuilder.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "moveChannelToMine, position = ", Integer.valueOf(paramInt), localStringBuilder.toString() });
    ReadInJoyChannelPanelFragment.a(this.a, paramTabChannelCoverInfo);
    ((ReadInJoyStaticGridView)paramAdapterView).a(paramInt, paramAdapterView.getCount() - 1);
    ReadInJoyChannelPanelFragment.a(this.a).a(paramTabChannelCoverInfo);
    try
    {
      RIJChannelReporter.a("0X800949D", new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addContentType(RIJChannelHelper.a(paramTabChannelCoverInfo)).addRedDotStatus(RIJChannelHelper.a(paramTabChannelCoverInfo)).addType((int)paramTabChannelCoverInfo.sectionId).build());
    }
    catch (JSONException paramTabChannelCoverInfo)
    {
      paramTabChannelCoverInfo.printStackTrace();
    }
    if (ReadInJoyChannelPanelFragment.j(this.a) == null) {
      ReadInJoyChannelPanelFragment.a(this.a, new ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback.2(this, paramArrayOfInt));
    }
    ReadInJoyChannelPanelFragment.a(this.a).getViewTreeObserver().addOnPreDrawListener(ReadInJoyChannelPanelFragment.j(this.a));
    ReadInJoyChannelPanelFragment.c(this.a);
  }
  
  private void a(AdapterView<?> paramAdapterView, int paramInt, int[] paramArrayOfInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    try
    {
      RIJChannelReporter.a("0X8009499", new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addContentType(RIJChannelHelper.a(paramTabChannelCoverInfo)).addRedDotStatus(RIJChannelHelper.a(paramTabChannelCoverInfo)).addType((int)paramTabChannelCoverInfo.sectionId).addStringNotThrow("style", 1).build());
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportData error ->");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.e("ReadInJoyChannelPanelFragment", 1, localStringBuilder.toString());
    }
    if (ChannelCoverInfoModule.e(paramTabChannelCoverInfo.mChannelCoverId))
    {
      a(paramTabChannelCoverInfo, paramAdapterView, paramInt, paramArrayOfInt);
      this.a.getBaseActivity().finish();
      ReadInJoyLogicEngine.a().c(paramTabChannelCoverInfo.mChannelCoverId, 3);
      RIJThreadHandler.b().post(new ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback.1(this, paramTabChannelCoverInfo));
      return;
    }
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelJumpUrl)) {
      try
      {
        paramAdapterView = URLDecoder.decode(paramTabChannelCoverInfo.mChannelJumpUrl, "utf-8");
        ViolaAccessHelper.a(this.a.getBaseActivity(), paramTabChannelCoverInfo.mChannelCoverName, paramAdapterView, null);
        return;
      }
      catch (Exception paramAdapterView)
      {
        paramAdapterView.printStackTrace();
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("gotoReadInJoyViolaChannel, v_url error->");
        paramArrayOfInt.append(paramAdapterView.getMessage());
        QLog.w("ReadInJoyChannelPanelFragment", 1, paramArrayOfInt.toString());
        return;
      }
    }
    if (paramTabChannelCoverInfo.mChannelType == 3)
    {
      ReadInJoyActivityHelper.INSTANCE.launchVideoSubChannelActivity(this.a.getBaseActivity(), paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelType, -1);
      return;
    }
    ReadInJoyActivityHelper.INSTANCE.launchChannelActivity(this.a.getBaseActivity(), paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelType, -1);
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
    RIJChannelReporter.a(localReportData, (int)this.b);
  }
  
  public void a(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", tab = ");
    localStringBuilder.append(paramTabChannelCoverInfo);
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onRecommendChannelClick, position = ", Integer.valueOf(paramInt), localStringBuilder.toString() });
    paramAdapterView.getChildAt(paramInt).getLocationOnScreen(this.c);
    a(paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
    if (!ReadInJoyChannelPanelFragment.b(this.a))
    {
      a(paramAdapterView, paramInt, this.c, paramTabChannelCoverInfo);
      return;
    }
    a(paramTabChannelCoverInfo, paramAdapterView, paramInt, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback
 * JD-Core Version:    0.7.0.1
 */