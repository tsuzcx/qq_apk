package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import java.util.List;

class ReadInJoySecondCommentListFragment$3
  implements ReadInJoyCommentDataManager.OnCommentListLoadListener
{
  ReadInJoySecondCommentListFragment$3(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void onCommentStateError(int paramInt)
  {
    if (paramInt == 1002) {
      ReadInJoySecondCommentListFragment.a(this.a, true);
    }
    if (paramInt == 1003) {
      QRUtils.a(1, 2131915284);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment.3
 * JD-Core Version:    0.7.0.1
 */