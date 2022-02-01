package com.tencent.timi.game.liveroom.impl.blacklist;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.timi.game.utils.Logger;
import java.util.List;

class AnchorRoomBlackListFragment$1
  extends RecyclerView.OnScrollListener
{
  AnchorRoomBlackListFragment$1(AnchorRoomBlackListFragment paramAnchorRoomBlackListFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      paramInt = ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      if (paramInt >= AnchorRoomBlackListFragment.a(this.a).size() - 3)
      {
        paramRecyclerView = new StringBuilder();
        paramRecyclerView.append("loadNextPage, lastVisiablePosition = ");
        paramRecyclerView.append(paramInt);
        Logger.a("AnchorRoomBlackListFragment", paramRecyclerView.toString());
        AnchorRoomBlackListFragment.b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.blacklist.AnchorRoomBlackListFragment.1
 * JD-Core Version:    0.7.0.1
 */