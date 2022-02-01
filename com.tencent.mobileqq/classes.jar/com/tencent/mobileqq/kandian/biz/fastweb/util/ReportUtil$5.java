package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

final class ReportUtil$5
  implements Runnable
{
  ReportUtil$5(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, long paramLong) {}
  
  public void run()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    int i = (int)localAbsBaseArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a()) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    Object localObject = RIJTransMergeKanDianReport.a(localContext, localAbsBaseArticleInfo, i, (String)localObject);
    try
    {
      ((JSONObject)localObject).put("sojourn_time", this.jdField_a_of_type_Long);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X800A854", ((JSONObject)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil.5
 * JD-Core Version:    0.7.0.1
 */