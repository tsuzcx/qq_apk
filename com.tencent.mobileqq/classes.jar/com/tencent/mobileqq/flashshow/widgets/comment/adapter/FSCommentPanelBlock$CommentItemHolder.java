package com.tencent.mobileqq.flashshow.widgets.comment.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.flashshow.bean.FSCommentItemInfo;
import com.tencent.mobileqq.flashshow.widgets.comment.FSCommentItemView;
import com.tencent.mobileqq.flashshow.widgets.comment.OnCommentElementClickListener;
import feedcloud.FeedCloudMeta.StFeed;

class FSCommentPanelBlock$CommentItemHolder
  extends RecyclerView.ViewHolder
{
  private FSCommentPanelBlock$CommentItemHolder(FSCommentPanelBlock paramFSCommentPanelBlock, View paramView)
  {
    super(paramView);
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, FSCommentItemInfo paramFSCommentItemInfo, OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    if ((this.itemView instanceof FSCommentItemView))
    {
      ((FSCommentItemView)this.itemView).setFeed(paramStFeed);
      ((FSCommentItemView)this.itemView).setOnCommentElementClickListener(paramOnCommentElementClickListener);
      ((FSCommentItemView)this.itemView).a(paramFSCommentItemInfo, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.adapter.FSCommentPanelBlock.CommentItemHolder
 * JD-Core Version:    0.7.0.1
 */