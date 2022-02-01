package com.tencent.mobileqq.winkpublish.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.winkpublish.adapter.base.PublishBaseMultiViewBlock;
import com.tencent.mobileqq.winkpublish.widget.PublishAssociateTagWidget;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class PublishAssociateLabelAdapter
  extends PublishBaseMultiViewBlock<FeedCloudMeta.StTagInfo>
{
  private RecyclerView a;
  
  public PublishAssociateLabelAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    RecyclerView localRecyclerView = this.a;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.a.post(new PublishAssociateLabelAdapter.1(this));
        return;
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.a = paramRecyclerView;
  }
  
  public void a(List<FeedCloudMeta.StTagInfo> paramList)
  {
    if (paramList != null)
    {
      this.mDataList.clear();
      a();
      this.mDataList.addAll(paramList);
      a();
    }
  }
  
  public void b(List<FeedCloudMeta.StTagInfo> paramList)
  {
    this.mDataList.addAll(this.mDataList.size(), paramList);
    a();
  }
  
  public void clearData()
  {
    this.mDataList.clear();
    a();
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList.size() > paramInt) && ((paramViewHolder instanceof PublishAssociateLabelAdapter.QCircleAssociateTagVH))) {
      ((PublishAssociateLabelAdapter.QCircleAssociateTagVH)paramViewHolder).a(this.mDataList.get(paramInt), paramInt);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new PublishAssociateLabelAdapter.QCircleAssociateTagVH(this, new PublishAssociateTagWidget(getContext()));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.adapter.PublishAssociateLabelAdapter
 * JD-Core Version:    0.7.0.1
 */