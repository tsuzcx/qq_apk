package com.tencent.mobileqq.kandian.biz.framework.click;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.plugin.PluginBaseActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class RIJFrameworkHandleClick$3
  implements ClickHandler
{
  RIJFrameworkHandleClick$3(RIJFrameworkHandleClick paramRIJFrameworkHandleClick) {}
  
  public void onClick(View paramView)
  {
    RIJFrameworkHandleClick.a(this.a).a().e().a(RIJFrameworkHandleClick.a(this.a).a().A());
    RIJFrameworkHandleClick.a(this.a).a().e().b(RIJFrameworkHandleClick.a(this.a).a().A());
    ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
    if (localViewHolder == null) {
      return;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)RIJFrameworkHandleClick.a(this.a).b().get(localViewHolder.P);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", RIJFrameworkHandleClick.a(this.a).a().B());
      boolean bool = RIJFrameworkHandleClick.a(this.a).a().A() instanceof BaseActivity;
      if (bool)
      {
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        localJSONObject.put("kandian_mode", RIJAppSetting.b());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJFeedsType.g(localAbsBaseArticleInfo));
        localJSONObject.put("feeds_type", localStringBuilder.toString());
        localJSONObject.put("rowkey", ReadinjoyReportUtils.c(localAbsBaseArticleInfo));
        PublicAccountReportUtils.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
      }
      else if ((RIJFrameworkHandleClick.a(this.a).a().A() instanceof PluginBaseActivity))
      {
        localJSONObject.put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", localJSONObject.toString());
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    RIJFrameworkHandleClick.a(this.a).a().e().a(paramView, localViewHolder, localAbsBaseArticleInfo, RIJFrameworkHandleClick.a(this.a));
    if ((RIJFrameworkHandleClick.a(this.a).a().z() != null) && (RIJFrameworkHandleClick.a(this.a).a().z().g()))
    {
      RIJFrameworkHandleClick.a(this.a).a().z().c();
      RIJFrameworkHandleClick.a(this.a).a().f(true);
    }
    VideoHandler.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJFrameworkHandleClick.3
 * JD-Core Version:    0.7.0.1
 */