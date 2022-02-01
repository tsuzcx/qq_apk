package com.tencent.mobileqq.flashshow.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.widgets.feed.FSLayerFeedItemView;
import com.tencent.qphone.base.util.QLog;

class FSLayerPageAdapter$LayerPagerHolder
  extends RecyclerView.ViewHolder
{
  public FSLayerPageAdapter$LayerPagerHolder(@NonNull View paramView)
  {
    super(paramView);
  }
  
  public void a(FSFeedData paramFSFeedData, int paramInt)
  {
    if (!(this.itemView instanceof FSLayerFeedItemView))
    {
      QLog.e("FSLayerPageAdapter", 1, "setData  itemView != FSLayerFeedItemView");
      return;
    }
    ((FSLayerFeedItemView)this.itemView).setData(paramFSFeedData, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter.LayerPagerHolder
 * JD-Core Version:    0.7.0.1
 */