package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ReadInJoyCommentReportManager$1
  implements Runnable
{
  ReadInJoyCommentReportManager$1(ReadInJoyCommentReportManager paramReadInJoyCommentReportManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = ReadInJoyCommentReportManager.a(this.this$0);
    String str1 = ReadInJoyCommentUtils.a(ReadInJoyCommentReportManager.b(this.this$0));
    String str2 = this.a;
    PublicAccountReportUtils.a(localQQAppInterface, str1, str2, str2, 0, 0, String.valueOf(ReadInJoyCommentReportManager.b(this.this$0).innerUniqueID), String.valueOf(ReadInJoyCommentReportManager.b(this.this$0).mStrategyId), ReadInJoyCommentReportManager.b(this.this$0).innerUniqueID, this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager.1
 * JD-Core Version:    0.7.0.1
 */