package com.tencent.mobileqq.flashshow.adapter;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.flashshow.bean.FSReplyItemInfo;
import com.tencent.mobileqq.flashshow.widgets.comment.FSMoreReplyItemView;
import com.tencent.mobileqq.flashshow.widgets.comment.FSReplyItemView;
import com.tencent.mobileqq.flashshow.widgets.comment.OnCommentElementClickListener;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;

class FSCommentReplyAdapter$ReplyItemViewHolder
  extends RecyclerView.ViewHolder
{
  private FSCommentReplyAdapter$ReplyItemViewHolder(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public void a(FSReplyItemInfo paramFSReplyItemInfo, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt1, int paramInt2, OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    if ((this.itemView instanceof FSReplyItemView))
    {
      ((FSReplyItemView)this.itemView).setPreData(paramStFeed, paramStComment, paramInt1);
      ((FSReplyItemView)this.itemView).setOnCommentElementClickListener(paramOnCommentElementClickListener);
      ((FSReplyItemView)this.itemView).a(paramFSReplyItemInfo, paramInt2);
      return;
    }
    if ((this.itemView instanceof FSMoreReplyItemView))
    {
      ((FSMoreReplyItemView)this.itemView).setPreData(paramStFeed, paramStComment, paramInt1);
      ((FSMoreReplyItemView)this.itemView).setOnCommentElementClickListener(paramOnCommentElementClickListener);
      ((FSMoreReplyItemView)this.itemView).a(paramFSReplyItemInfo, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.adapter.FSCommentReplyAdapter.ReplyItemViewHolder
 * JD-Core Version:    0.7.0.1
 */