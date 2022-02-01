package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.qphone.base.util.QLog;

class CommentViewItem$5
  implements Ox978RespCallBack
{
  CommentViewItem$5(CommentViewItem paramCommentViewItem) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("add to follow isSuccess: ");
      paramString.append(paramBoolean);
      QLog.d("CommentViewItem", 2, new Object[] { "", paramString.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem.5
 * JD-Core Version:    0.7.0.1
 */