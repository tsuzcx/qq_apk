package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

final class ReportUtil$4
  implements Runnable
{
  ReportUtil$4(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo) {}
  
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
      ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X800A731", ((JSONObject)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil.4
 * JD-Core Version:    0.7.0.1
 */