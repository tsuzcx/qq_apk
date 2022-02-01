package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyCommentPBModule$6
  implements Runnable
{
  ReadInJoyCommentPBModule$6(ReadInJoyCommentPBModule paramReadInJoyCommentPBModule, int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleNewCommentList | retCode ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" | hasNewNextPage ");
    localStringBuilder.append(this.b.d);
    localStringBuilder.append(" | newPageCookie ");
    localStringBuilder.append(this.b.e);
    localStringBuilder.append("| newCommentCnt ");
    localStringBuilder.append(this.c.a);
    localStringBuilder.append(" | newCommentListSize ");
    int i;
    if (this.b.a != null) {
      i = this.b.a.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    QLog.d("ReadInJoyCommentPBModule", 1, localStringBuilder.toString());
    if (ReadInJoyCommentPBModule.a(this.this$0) != null) {
      ReadInJoyCommentPBModule.a(this.this$0).a(this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule.6
 * JD-Core Version:    0.7.0.1
 */