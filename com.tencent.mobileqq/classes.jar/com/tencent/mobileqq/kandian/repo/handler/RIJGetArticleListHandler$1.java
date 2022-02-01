package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.kandian.repo.pts.network.WeakNetManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

class RIJGetArticleListHandler$1
  implements Runnable
{
  RIJGetArticleListHandler$1(RIJGetArticleListHandler paramRIJGetArticleListHandler, ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = RIJGetArticleListHandler.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.jdField_a_of_type_Long));
      localToServiceMsg.getAttributes().put("feedsRequestVersion", Long.valueOf(this.b));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.jdField_a_of_type_AndroidOsBundle != null) {
        localToServiceMsg.getAttributes().put("request_extra_data_key", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.jdField_a_of_type_AndroidOsBundle);
      }
      localToServiceMsg.getAttributes().put("auto_refresh_src", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.h));
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.i & 0x40) != 0) {
        localToServiceMsg.getAttributes().put("recommendFlag", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.i));
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.jdField_b_of_type_JavaUtilList.size() < 1)) {
          break label298;
        }
        l = ((Long)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.jdField_b_of_type_JavaUtilList.get(0)).longValue();
        localJSONObject.put("preload_red_pnt_push_articleID", l);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009482", "0X8009482", 0, 0, localJSONObject.toString(), "", "", "", false);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0x68bParams.jdField_a_of_type_Long == -1L)) {
        this.this$0.a.a("-1", 1, 0);
      }
      this.this$0.a.sendPbReq(localToServiceMsg);
      WeakNetManager.a().a(localToServiceMsg);
      return;
      label298:
      long l = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJGetArticleListHandler.1
 * JD-Core Version:    0.7.0.1
 */