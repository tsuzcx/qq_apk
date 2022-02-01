package com.tencent.mobileqq.flashshow.list.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.widget.BaseWidgetView;

class FSMessageReplyAdapter$FeedCommentVH
  extends RecyclerView.ViewHolder
{
  public FSMessageReplyAdapter$FeedCommentVH(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      this.itemView.setTag(this);
      ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.adapter.FSMessageReplyAdapter.FeedCommentVH
 * JD-Core Version:    0.7.0.1
 */