package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyCommentPBModule$4
  implements Runnable
{
  ReadInJoyCommentPBModule$4(ReadInJoyCommentPBModule paramReadInJoyCommentPBModule, int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleFamilyCommentList | retCode ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" | hasFamilyNextPage ");
    localStringBuilder.append(this.b.d);
    localStringBuilder.append(" | familyPageCookie ");
    localStringBuilder.append(this.b.e);
    localStringBuilder.append("| familyCommentCnt ");
    localStringBuilder.append(this.c.a);
    localStringBuilder.append(" | familyCommentListSize ");
    int i;
    if (this.b.a != null) {
      i = this.b.a.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    QLog.d("ReadInJoyCommentPBModule", 1, localStringBuilder.toString());
    if (ReadInJoyCommentPBModule.a(this.this$0) != null) {
      ReadInJoyCommentPBModule.a(this.this$0).c(this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule.4
 * JD-Core Version:    0.7.0.1
 */