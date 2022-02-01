package com.tencent.mobileqq.troop.troopnotification.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousAdapter;

class TroopNotificationFragment$28
  extends RecyclerView.OnScrollListener
{
  TroopNotificationFragment$28(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a.i = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition() + 1 == TroopNotificationFragment.k(this.a).getItemCount())) {
        TroopNotificationFragment.y(this.a);
      }
    }
    if (this.a.j != null)
    {
      if (paramInt != 0)
      {
        this.a.j.cancelPendingRequests();
        this.a.j.pause();
        return;
      }
      if (this.a.j.isPausing()) {
        this.a.j.resume();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.28
 * JD-Core Version:    0.7.0.1
 */