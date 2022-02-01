package com.tencent.timi.game.liveroom.impl.blacklist;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AnchorBlackListAdapter$1
  implements View.OnClickListener
{
  AnchorBlackListAdapter$1(AnchorBlackListAdapter paramAnchorBlackListAdapter, int paramInt, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (AnchorBlackListAdapter.a(this.c) != null) {
      AnchorBlackListAdapter.a(this.c).a(paramView, this.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.blacklist.AnchorBlackListAdapter.1
 * JD-Core Version:    0.7.0.1
 */