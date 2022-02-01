package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.util.SparseIntArray;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.ViewHolderWrapper;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.RecycledViewPool;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewHolder;
import java.util.ArrayList;

public class HippyWaterfallView$RNWFRecyclerPool
  extends RecyclerViewBase.RecycledViewPool
{
  public void putRecycledView(RecyclerViewBase.ViewHolder paramViewHolder, RecyclerViewBase.Adapter paramAdapter)
  {
    int i = paramViewHolder.getItemViewType();
    ArrayList localArrayList = getScrapHeapForType(i);
    if (this.mMaxScrap.get(i) <= localArrayList.size())
    {
      RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)localArrayList.get(0);
      localArrayList.remove(0);
      if ((paramAdapter != null) && ((localViewHolder instanceof RecyclerView.ViewHolderWrapper))) {
        ((HippyWaterfallAdapter)paramAdapter).a((RecyclerView.ViewHolderWrapper)localViewHolder);
      }
    }
    paramViewHolder.mPosition = -2147483648;
    paramViewHolder.mOldPosition = -2147483648;
    paramViewHolder.mItemId = -1L;
    paramViewHolder.clearFlagsForSharedPool();
    localArrayList.add(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallView.RNWFRecyclerPool
 * JD-Core Version:    0.7.0.1
 */