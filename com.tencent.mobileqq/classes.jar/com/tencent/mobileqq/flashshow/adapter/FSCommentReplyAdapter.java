package com.tencent.mobileqq.flashshow.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.flashshow.bean.FSReplyItemInfo;
import com.tencent.mobileqq.flashshow.widgets.comment.FSMoreReplyItemView;
import com.tencent.mobileqq.flashshow.widgets.comment.FSReplyItemView;
import com.tencent.mobileqq.flashshow.widgets.comment.OnCommentElementClickListener;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class FSCommentReplyAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private FeedCloudMeta.StFeed a;
  private FeedCloudMeta.StComment b;
  private List<FSReplyItemInfo> c;
  private OnCommentElementClickListener d;
  private int e;
  
  public void a(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.d = paramOnCommentElementClickListener;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, List<FSReplyItemInfo> paramList, int paramInt)
  {
    this.a = paramStFeed;
    this.b = paramStComment;
    this.c = paramList;
    this.e = paramInt;
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (localList.size() > paramInt)) {
      return ((FSReplyItemInfo)this.c.get(paramInt)).a;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (localList.size() > paramInt)) {
      ((FSCommentReplyAdapter.ReplyItemViewHolder)paramViewHolder).a((FSReplyItemInfo)this.c.get(paramInt), this.a, this.b, this.e, paramInt, this.d);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new FSCommentReplyAdapter.ReplyItemViewHolder(new FSReplyItemView(paramViewGroup.getContext()), null);
    }
    return new FSCommentReplyAdapter.ReplyItemViewHolder(new FSMoreReplyItemView(paramViewGroup.getContext()), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.adapter.FSCommentReplyAdapter
 * JD-Core Version:    0.7.0.1
 */