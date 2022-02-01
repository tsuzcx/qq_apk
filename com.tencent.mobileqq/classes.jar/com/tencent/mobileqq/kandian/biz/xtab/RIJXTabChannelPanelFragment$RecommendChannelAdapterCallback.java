package com.tencent.mobileqq.kandian.biz.xtab;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.RIJBaseChannelGridViewAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.RIJBaseChannelGridViewAdapter.AdapterCallback;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.net.URLDecoder;
import java.util.Map;

class RIJXTabChannelPanelFragment$RecommendChannelAdapterCallback
  implements RIJBaseChannelGridViewAdapter.AdapterCallback
{
  private RIJXTabChannelPanelFragment$RecommendChannelAdapterCallback(RIJXTabChannelPanelFragment paramRIJXTabChannelPanelFragment) {}
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, ReadInJoyDynamicGridView.BaseDynamicGridAdapter paramBaseDynamicGridAdapter)
  {
    if (RIJChannelHelper.a(paramTabChannelCoverInfo) == 0)
    {
      paramTabChannelCoverInfo.redPoint.a = false;
      if (paramBaseDynamicGridAdapter != null) {
        paramBaseDynamicGridAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    RIJChannelReporter.a("0X800949D", new RIJTransMergeKanDianReport.ReportR5Builder().addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addKandianModeNew().build());
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelJumpUrl)) {
      try
      {
        localObject = URLDecoder.decode(paramTabChannelCoverInfo.mChannelJumpUrl, "utf-8");
        ViolaAccessHelper.a(this.a.getBaseActivity(), paramTabChannelCoverInfo.mChannelCoverName, (String)localObject, null);
        return;
      }
      catch (Exception paramTabChannelCoverInfo)
      {
        paramTabChannelCoverInfo.printStackTrace();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("gotoReadInJoyViolaChannel, v_url error->");
        ((StringBuilder)localObject).append(paramTabChannelCoverInfo.getMessage());
        QLog.w("RIJXTabChannelPanelFragment", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (paramTabChannelCoverInfo.mChannelType == 3)
    {
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchVideoSubChannelActivity(this.a.getBaseActivity(), paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelType, -1);
      return;
    }
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(this.a.getBaseActivity(), paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelType, -1);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    RIJXTabChannelPanelFragment.a(this.a).put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), paramTabChannelCoverInfo);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt) {}
  
  public void a(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    paramAdapterView = new StringBuilder();
    paramAdapterView.append(", tab = ");
    paramAdapterView.append(paramTabChannelCoverInfo);
    QLog.d("RIJXTabChannelPanelFragment", 1, new Object[] { "onRecommendChannelClick, position = ", Integer.valueOf(paramInt), paramAdapterView.toString() });
    a(paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
    b(paramTabChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabChannelPanelFragment.RecommendChannelAdapterCallback
 * JD-Core Version:    0.7.0.1
 */