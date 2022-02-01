package com.tencent.mobileqq.hotpic;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.image.AbstractGifImage;

class HotPicRecyclerView$1
  extends RecyclerView.OnScrollListener
{
  HotPicRecyclerView$1(HotPicRecyclerView paramHotPicRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      HotVideoBlurTaskManager.c();
      this.a.b();
    }
    else
    {
      this.a.c();
      AbstractGifImage.pauseAll();
      HotVideoBlurTaskManager.b();
    }
    if (paramInt == 2) {
      this.a.g.a(true);
    } else {
      this.a.g.a(false);
    }
    if ((paramInt == 0) && (this.a.b == 2))
    {
      ((StaggeredGridLayoutManager)this.a.getLayoutManager()).findFirstCompletelyVisibleItemPositions(this.a.c);
      if ((this.a.c[0] == 0) && (this.a.f != null)) {
        this.a.f.d();
      }
    }
    this.a.b = paramInt;
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.a.g.a(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */