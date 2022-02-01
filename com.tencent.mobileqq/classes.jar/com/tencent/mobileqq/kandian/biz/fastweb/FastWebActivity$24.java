package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;

class FastWebActivity$24
  extends ReadInJoyObserver
{
  FastWebActivity$24(FastWebActivity paramFastWebActivity) {}
  
  public void a(String paramString)
  {
    super.a(paramString);
    CommentViewItem localCommentViewItem = FastWebActivity.o(this.a).a(paramString, FastWebActivity.E(this.a));
    if (localCommentViewItem != null)
    {
      paramString = ReadinjoyCommentListBaseAdapter.b(ReadinjoyCommentListBaseAdapter.a(paramString));
      this.a.a(true, localCommentViewItem.c.commentId, paramString);
    }
    FastWebActivity.l(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.24
 * JD-Core Version:    0.7.0.1
 */