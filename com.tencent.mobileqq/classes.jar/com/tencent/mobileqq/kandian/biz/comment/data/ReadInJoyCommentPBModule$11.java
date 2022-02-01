package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyCommentPBModule$11
  implements Runnable
{
  ReadInJoyCommentPBModule$11(ReadInJoyCommentPBModule paramReadInJoyCommentPBModule, int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, String paramString, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleSubCommentList | retCode ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" | hasNextPage ");
    ((StringBuilder)localObject).append(this.b.d);
    ((StringBuilder)localObject).append(" | pageCookie ");
    ((StringBuilder)localObject).append(this.b.e);
    ((StringBuilder)localObject).append("| subCommentListSize ");
    ((StringBuilder)localObject).append(this.b.b);
    if (((StringBuilder)localObject).toString() != null)
    {
      localObject = Integer.valueOf(this.b.b.size());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0 | hashCode ");
      ((StringBuilder)localObject).append(hashCode());
      localObject = ((StringBuilder)localObject).toString();
    }
    QLog.d("ReadInJoyCommentPBModule", 1, new Object[] { localObject });
    if (ReadInJoyCommentPBModule.a(this.this$0) != null) {
      ReadInJoyCommentPBModule.a(this.this$0).a(this.a, this.c, this.b, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule.11
 * JD-Core Version:    0.7.0.1
 */