package com.tencent.mobileqq.wink.pick.circle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter;

class WinkCircleSinglePhotoListFragment$1
  extends RecyclerView.OnScrollListener
{
  WinkCircleSinglePhotoListFragment$1(WinkCircleSinglePhotoListFragment paramWinkCircleSinglePhotoListFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.a;
    WinkCircleSinglePhotoListFragment.a(paramRecyclerView, WinkCircleSinglePhotoListFragment.a(paramRecyclerView) + paramInt2);
    if ((WinkCircleSinglePhotoListFragment.a(this.a) >= this.a.b.f) && (!WinkCircleSinglePhotoListFragment.b(this.a)))
    {
      WinkCircleSinglePhotoListFragment.a(this.a, true);
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCircleSinglePhotoListFragment.1
 * JD-Core Version:    0.7.0.1
 */