package com.tencent.mobileqq.kandian.biz.dislike;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().remove(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().e(true);
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().notifyDataSetChanged();
    int i;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
      i = 2131699886;
    } else {
      i = 2131699885;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a() instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), -1, this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a()).getTitleBarHeight());
    } else if ((this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a() instanceof PluginBaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), -1, this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a()).g());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      long l = 0L;
      if ((this.a.jdField_a_of_type_JavaLangObject instanceof DislikeInfo)) {
        l = ((DislikeInfo)this.a.jdField_a_of_type_JavaLangObject).a;
      }
      ReadInJoyLogicEngine.a().a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), (AdvertisementInfo)this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, l, this.a.jdField_a_of_type_JavaUtilArrayList, false);
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
      ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b());
      ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
      boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a() instanceof BaseActivity;
      if (bool)
      {
        ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.a());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJFeedsType.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
        ((JSONObject)localObject).put("feeds_type", localStringBuilder.toString());
        ((JSONObject)localObject).put("rowkey", ReadinjoyReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
        localObject = ((JSONObject)localObject).toString();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007059", "0X8007059", 0, 0, "", "", RIJDislikeManager.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a() instanceof PluginBaseActivity))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */