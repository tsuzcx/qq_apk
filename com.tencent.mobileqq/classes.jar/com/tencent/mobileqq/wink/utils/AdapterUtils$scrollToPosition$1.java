package com.tencent.mobileqq.wink.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdapterUtils$scrollToPosition$1
  implements Runnable
{
  AdapterUtils$scrollToPosition$1(LinearSmoothScroller paramLinearSmoothScroller, int paramInt, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager) {}
  
  public final void run()
  {
    this.a.setTargetPosition(this.b);
    AdapterUtils.a(AdapterUtils.a, this.c, this.d, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.AdapterUtils.scrollToPosition.1
 * JD-Core Version:    0.7.0.1
 */