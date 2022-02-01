package com.tencent.timi.game.liveroom.impl;

import android.app.Activity;
import com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView.Listener;
import com.tencent.timi.game.utils.FloatingPermission;

class TimiAnchorView$6
  implements AnchorTopAreaView.Listener
{
  TimiAnchorView$6(TimiAnchorView paramTimiAnchorView) {}
  
  public void a(long paramLong)
  {
    if (FloatingPermission.a(this.a.getContext()))
    {
      Activity localActivity = TimiAnchorView.d(this.a);
      if (localActivity != null) {
        localActivity.finish();
      }
    }
    else
    {
      TimiAnchorView.l(this.a);
    }
  }
  
  public void b(long paramLong)
  {
    TimiAnchorView.m(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAnchorView.6
 * JD-Core Version:    0.7.0.1
 */