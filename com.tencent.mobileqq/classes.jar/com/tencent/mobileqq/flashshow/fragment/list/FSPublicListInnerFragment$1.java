package com.tencent.mobileqq.flashshow.fragment.list;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.flashshow.list.blocks.FSBaseListBlock;

class FSPublicListInnerFragment$1
  extends RecyclerView.OnScrollListener
{
  FSPublicListInnerFragment$1(FSPublicListInnerFragment paramFSPublicListInnerFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (this.a.c != null) {
      this.a.c.getDropFrameMonitorTag();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.list.FSPublicListInnerFragment.1
 * JD-Core Version:    0.7.0.1
 */