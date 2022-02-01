package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.RefreshData;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONException;

class ComponentLastRead$1
  implements View.OnClickListener
{
  ComponentLastRead$1(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    ReadinjoyReportUtils.a(false);
    paramView = new RIJTransMergeKanDianReport.ReportR5Builder();
    paramView.addSessionId().addFolderStatus().addKandianMode().addChannelId(this.a.a.a.m()).addKandianModeNew().addTabSource().addRedStyle();
    if (this.a.a.a.m() == 0) {
      try
      {
        RefreshData localRefreshData = ReadInJoyRefreshManager.b(this.a.getContext(), 0);
        int i = j;
        if (localRefreshData != null)
        {
          i = j;
          if (localRefreshData.isAD) {
            i = 1;
          }
        }
        paramView.addInt("ad_page", i);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", paramView.build(), false);
    if (this.a.a.b != null) {
      this.a.a.b.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentLastRead.1
 * JD-Core Version:    0.7.0.1
 */