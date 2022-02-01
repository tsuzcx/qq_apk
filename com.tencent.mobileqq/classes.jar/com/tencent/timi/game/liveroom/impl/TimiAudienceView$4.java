package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.timi.game.component.chat.input.KeyboardUtils;
import com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$4
  implements LiveRoomStatusListener
{
  TimiAudienceView$4(TimiAudienceView paramTimiAudienceView) {}
  
  public void onRoomClose(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRoomClose, closeType: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("closeReason: ");
    localStringBuilder.append(paramString);
    Logger.a("TimiAudienceView", localStringBuilder.toString());
    KeyboardUtils.b(this.a);
    TimiAudienceView.c(this.a);
  }
  
  public void onRoomOpen() {}
  
  public void onRoomPause()
  {
    TimiAudienceView.d(this.a).d();
  }
  
  public void onRoomResume()
  {
    TimiAudienceView.d(this.a).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.4
 * JD-Core Version:    0.7.0.1
 */