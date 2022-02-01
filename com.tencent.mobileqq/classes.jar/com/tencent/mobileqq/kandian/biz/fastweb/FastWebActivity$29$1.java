package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class FastWebActivity$29$1
  implements Runnable
{
  final AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$29.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  final FastWebArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo = FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$29.a);
  
  FastWebActivity$29$1(FastWebActivity.29 param29, long paramLong, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
        return;
      }
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$29.a;
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a()) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      Object localObject = RIJTransMergeKanDianReport.a(localFastWebActivity, localAbsBaseArticleInfo, 0, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("open_speed", this.jdField_a_of_type_Long);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X8008997", ((JSONObject)localObject).toString());
      FastWebActivity.k(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$29.a);
      FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$29.a, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo);
      ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_JavaUtilList);
      FastWebRequestUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.29.1
 * JD-Core Version:    0.7.0.1
 */