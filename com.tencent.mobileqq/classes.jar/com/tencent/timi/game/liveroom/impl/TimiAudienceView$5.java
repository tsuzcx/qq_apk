package com.tencent.timi.game.liveroom.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveHideLotteryCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationContainer;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$5
  implements IQQLiveHideLotteryCallback
{
  TimiAudienceView$5(TimiAudienceView paramTimiAudienceView) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IQQLiveHideLotteryCallback : lotteryId == ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",roomId == ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",programId == ");
    localStringBuilder.append(paramString3);
    Logger.a("TimiAudienceView", localStringBuilder.toString());
    if (TimiAudienceView.e(this.a) == null) {
      return;
    }
    if (TimiAudienceView.e(this.a).getRoomInfo() == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (String.valueOf(TimiAudienceView.e(this.a).getRoomInfo().getRoomId()).equals(paramString2)) {
      TimiAudienceView.f(this.a).a(9999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.5
 * JD-Core Version:    0.7.0.1
 */