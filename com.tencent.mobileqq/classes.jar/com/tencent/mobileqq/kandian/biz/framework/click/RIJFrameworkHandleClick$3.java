package com.tencent.mobileqq.kandian.biz.framework.click;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
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
    RIJFrameworkHandleClick.a(this.a).a().a().a(RIJFrameworkHandleClick.a(this.a).a().a());
    RIJFrameworkHandleClick.a(this.a).a().a().a(RIJFrameworkHandleClick.a(this.a).a().a());
    ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
    if (localViewHolder == null) {
      return;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)RIJFrameworkHandleClick.a(this.a).a().get(localViewHolder.a);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
      ((JSONObject)localObject).put("channel_id", RIJFrameworkHandleClick.a(this.a).a().b());
      boolean bool = RIJFrameworkHandleClick.a(this.a).a().a() instanceof BaseActivity;
      if (bool)
      {
        ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.a());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJFeedsType.a(localAbsBaseArticleInfo));
        ((JSONObject)localObject).put("feeds_type", localStringBuilder.toString());
        ((JSONObject)localObject).put("rowkey", ReadinjoyReportUtils.a(localAbsBaseArticleInfo));
        localObject = ((JSONObject)localObject).toString();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", (String)localObject, false);
      }
      else if ((RIJFrameworkHandleClick.a(this.a).a().a() instanceof PluginBaseActivity))
      {
        ((JSONObject)localObject).put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", ((JSONObject)localObject).toString());
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    RIJFrameworkHandleClick.a(this.a).a().a().a(paramView, localViewHolder, localAbsBaseArticleInfo, RIJFrameworkHandleClick.a(this.a));
    if ((RIJFrameworkHandleClick.a(this.a).a().a() != null) && (RIJFrameworkHandleClick.a(this.a).a().a().a()))
    {
      RIJFrameworkHandleClick.a(this.a).a().a().a();
      RIJFrameworkHandleClick.a(this.a).a().f(true);
    }
    VideoHandler.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJFrameworkHandleClick.3
 * JD-Core Version:    0.7.0.1
 */