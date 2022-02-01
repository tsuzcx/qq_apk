package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyCommentComponentFragment$2
  implements Runnable
{
  ReadInJoyCommentComponentFragment$2(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void run()
  {
    String str;
    if (ReadInJoyCommentComponentFragment.a(this.this$0) == 1) {
      str = "0X80094C4";
    } else {
      str = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "", str, 0, 0, String.valueOf(this.this$0.d), "", "", ReadInJoyCommentComponentFragment.a(this.this$0, true), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.2
 * JD-Core Version:    0.7.0.1
 */