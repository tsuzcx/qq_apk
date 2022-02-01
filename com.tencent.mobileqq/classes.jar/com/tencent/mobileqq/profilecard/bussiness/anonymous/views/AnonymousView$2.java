package com.tencent.mobileqq.profilecard.bussiness.anonymous.views;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;

class AnonymousView$2
  extends RecyclerView.OnScrollListener
{
  AnonymousView$2(AnonymousView paramAnonymousView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      AnonymousView.access$000(this.this$0).cancelPendingRequests();
      AnonymousView.access$000(this.this$0).pause();
      return;
    }
    if (AnonymousView.access$000(this.this$0).isPausing()) {
      AnonymousView.access$000(this.this$0).resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.2
 * JD-Core Version:    0.7.0.1
 */