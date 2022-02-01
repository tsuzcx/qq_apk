package com.tencent.timi.game.liveroom.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.timi.game.liveroom.impl.live.AnchorLivePrivacyStateHolder;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class TimiAnchorView$11
  implements IResultListener<LiveRealTimeInfo>
{
  TimiAnchorView$11(TimiAnchorView paramTimiAnchorView, QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    Logger.a("TimiAnchorView", "stopLive failed");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "下播失败";
    }
    CustomToastView.a(str);
  }
  
  public void a(LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    Logger.a("TimiAnchorView", "stopLive success");
    TimiAnchorView.a(this.b, this.a, paramLiveRealTimeInfo);
    AnchorLivePrivacyStateHolder.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAnchorView.11
 * JD-Core Version:    0.7.0.1
 */