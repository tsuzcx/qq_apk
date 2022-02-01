package com.tencent.mobileqq.kandian.biz.comment;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;

final class CommentProteusUtil$1
  implements ViewFactory.FoundClickableViewListener
{
  CommentProteusUtil$1(Container paramContainer, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (paramViewBase.getNativeView() != null)
    {
      if (paramViewBase.getClickEvnet() == null) {
        return;
      }
      SparseArray localSparseArray = new SparseArray();
      int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      CommentProteusListenerUtil.a.a(i, localSparseArray).b(i, localSparseArray).a(i, this.a, this.b, this.c, paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusUtil.1
 * JD-Core Version:    0.7.0.1
 */