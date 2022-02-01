package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

final class ReadInJoyCommentReportManager$3
  implements Runnable
{
  ReadInJoyCommentReportManager$3(BaseCommentData paramBaseCommentData, AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, ((SubCommentData)this.a).repliedUserUin, "0X800BAC3", "0X800BAC3", 0, 0, String.valueOf(this.b.innerUniqueID), String.valueOf(this.b.mStrategyId), this.b.innerUniqueID, this.c.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager.3
 * JD-Core Version:    0.7.0.1
 */