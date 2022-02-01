package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.TKDHippy2NativeEventSimpleReceiver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.jetbrains.annotations.NotNull;

class ReadInJoyCommentListFragment$11
  extends TKDHippy2NativeEventSimpleReceiver
{
  ReadInJoyCommentListFragment$11(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, String paramString7)
  {
    if (ReadInJoyCommentListFragment.k(this.a) != null) {
      ReadInJoyCommentUtils.a(ReadInJoyCommentListFragment.k(this.a).mRecommendSeq, true);
    }
  }
  
  public void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    if (ReadInJoyCommentListFragment.k(this.a) != null) {
      ReadInJoyCommentUtils.a(ReadInJoyCommentListFragment.k(this.a).mRecommendSeq, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.11
 * JD-Core Version:    0.7.0.1
 */