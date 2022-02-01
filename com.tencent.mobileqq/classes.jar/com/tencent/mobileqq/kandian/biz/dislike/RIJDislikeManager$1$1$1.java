package com.tencent.mobileqq.kandian.biz.dislike;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class RIJDislikeManager$1$1$1
  implements Runnable
{
  RIJDislikeManager$1$1$1(RIJDislikeManager.1.1 param1) {}
  
  public void run()
  {
    this.a.c.b.b().remove(this.a.c.d);
    this.a.c.b.a().e(true);
    this.a.c.b.a().v().notifyDataSetChanged();
    int i;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(this.a.c.d)) {
      i = 2131897939;
    } else {
      i = 2131897938;
    }
    if ((this.a.c.b.a().A() instanceof BaseActivity)) {
      QQToast.makeText(this.a.c.b.a().A(), -1, this.a.c.b.a().A().getString(i), 0).show(((BaseActivity)this.a.c.b.a().A()).getTitleBarHeight());
    } else if ((this.a.c.b.a().A() instanceof PluginBaseActivity)) {
      QQToast.makeText(this.a.c.b.a().A(), -1, this.a.c.b.a().A().getString(i), 0).show(((PluginBaseActivity)this.a.c.b.a().A()).L());
    }
    this.a.c.b.a().v().a(this.a.c.a, this.a.c.d, this.a.a);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(this.a.c.d))
    {
      long l = 0L;
      if ((this.a.b instanceof DislikeInfo)) {
        l = ((DislikeInfo)this.a.b).e;
      }
      ReadInJoyLogicEngine.a().a(this.a.c.b.a().A(), (AdvertisementInfo)this.a.c.d, l, this.a.a, false);
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
      ((JSONObject)localObject).put("channel_id", this.a.c.b.a().B());
      ((JSONObject)localObject).put("tag_num", this.a.a.size());
      boolean bool = this.a.c.b.a().A() instanceof BaseActivity;
      if (bool)
      {
        ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.b());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJFeedsType.g(this.a.c.d));
        ((JSONObject)localObject).put("feeds_type", localStringBuilder.toString());
        ((JSONObject)localObject).put("rowkey", ReadinjoyReportUtils.c(this.a.c.d));
        localObject = ((JSONObject)localObject).toString();
        PublicAccountReportUtils.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", RIJDislikeManager.a(this.a.a), (String)localObject, false);
        return;
      }
      if ((this.a.c.b.a().A() instanceof PluginBaseActivity))
      {
        ((JSONObject)localObject).put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showDislikeDialog JSONException:");
        localStringBuilder.append(localJSONException.getMessage());
        QLog.d("RIJDislikeManager", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */