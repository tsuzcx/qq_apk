package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqlive.listener.supervision.OnKickedOutOfRoomListener;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$9
  implements OnKickedOutOfRoomListener
{
  TimiAudienceView$9(TimiAudienceView paramTimiAudienceView) {}
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnKickedOutOfRoomListener onKickedOut ");
    localStringBuilder.append(paramString);
    Logger.a("TimiAudienceView", localStringBuilder.toString());
    CustomToastView.a("已被踢出直播房间");
    TimiAudienceView.n(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.9
 * JD-Core Version:    0.7.0.1
 */