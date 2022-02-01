package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

final class ReadInJoyCommentComponentFragment$FuncReportRunnable
  implements Runnable
{
  private final String a;
  
  private ReadInJoyCommentComponentFragment$FuncReportRunnable(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str1 = ReadInJoyCommentUtils.a(ReadInJoyCommentComponentFragment.a(this.this$0));
    String str2 = this.a;
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, str2, str2, 0, 0, "", "", "", ReadInJoyCommentComponentFragment.a(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.FuncReportRunnable
 * JD-Core Version:    0.7.0.1
 */