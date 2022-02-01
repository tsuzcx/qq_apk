package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

final class ReadInJoyCommentReportManager$2
  implements Runnable
{
  ReadInJoyCommentReportManager$2(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.a), "0X800B06F", "0X800B06F", 0, 0, String.valueOf(this.a.innerUniqueID), String.valueOf(this.a.mStrategyId), this.a.innerUniqueID, this.b.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager.2
 * JD-Core Version:    0.7.0.1
 */