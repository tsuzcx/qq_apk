package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.qwallet.hb.aio.ScrollPlayer;

class TroopUnclaimedHbList$3
  extends RecyclerView.OnScrollListener
{
  TroopUnclaimedHbList$3(TroopUnclaimedHbList paramTroopUnclaimedHbList) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ScrollPlayer.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.3
 * JD-Core Version:    0.7.0.1
 */