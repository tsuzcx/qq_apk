package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.RefreshData;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONException;

class ReadInJoyFooterPresenter$3
  implements View.OnClickListener
{
  ReadInJoyFooterPresenter$3(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter) {}
  
  public void onClick(View paramView)
  {
    paramView = ReadInJoyFooterPresenter.a(this.a);
    int j = 0;
    RefreshData localRefreshData = ReadInJoyRefreshManager.b(paramView, 0);
    ReadinjoyReportUtils.a(false);
    paramView = new RIJTransMergeKanDianReport.ReportR5Builder();
    paramView.addSessionId().addFolderStatus().addKandianMode().addChannelId(ReadInJoyFooterPresenter.b(this.a).m()).addKandianModeNew().addTabSource().addRedStyle();
    if (ReadInJoyFooterPresenter.b(this.a).m() == 0)
    {
      int i = j;
      if (localRefreshData != null) {
        i = j;
      }
      try
      {
        if (localRefreshData.isAD) {
          i = 1;
        }
        paramView.addInt("ad_page", i);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", paramView.build(), false);
    if (ReadInJoyFooterPresenter.c(this.a) != null) {
      ReadInJoyFooterPresenter.c(this.a).m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter.3
 * JD-Core Version:    0.7.0.1
 */