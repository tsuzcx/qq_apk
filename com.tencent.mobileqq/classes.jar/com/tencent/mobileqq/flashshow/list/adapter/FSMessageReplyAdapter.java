package com.tencent.mobileqq.flashshow.list.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.mobileqq.flashshow.view.message.FSMessageReplyItemView;
import com.tencent.mobileqq.flashshow.view.message.FSMessageReplyItemView.FSMessageReplyItemListener;
import java.util.List;

public class FSMessageReplyAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<FSFeedCommentInfo> a;
  private FSMessageReplyItemView.FSMessageReplyItemListener b;
  
  public void a(FSMessageReplyItemView.FSMessageReplyItemListener paramFSMessageReplyItemListener)
  {
    this.b = paramFSMessageReplyItemListener;
  }
  
  public void a(List<FSFeedCommentInfo> paramList)
  {
    this.a = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    List localList = this.a;
    if (localList != null) {
      ((FSMessageReplyAdapter.FeedCommentVH)paramViewHolder).a(localList.get(paramInt), paramInt);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new FSMessageReplyItemView(paramViewGroup.getContext());
    paramViewGroup.setReplyItemListener(this.b);
    return new FSMessageReplyAdapter.FeedCommentVH(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.adapter.FSMessageReplyAdapter
 * JD-Core Version:    0.7.0.1
 */