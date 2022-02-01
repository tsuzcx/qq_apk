package com.tencent.timi.game.liveroom.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.data.QQLiveEndRecommendInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView.LiveViewListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$13
  implements EndLiveClickCallback
{
  TimiAudienceView$13(TimiAudienceView paramTimiAudienceView, LiveAnchorInfo paramLiveAnchorInfo) {}
  
  public void a(int paramInt, QQLiveEndRecommendInfo paramQQLiveEndRecommendInfo, View paramView)
  {
    Logger.a("TimiAudienceView", "onFollowClick");
    if ((TimiAudienceView.p(this.b) != null) && (paramQQLiveEndRecommendInfo != null))
    {
      Logger.a("TimiAudienceView", "call listener");
      paramQQLiveEndRecommendInfo = new QQLiveSwitchRoom(paramQQLiveEndRecommendInfo.roomId, paramQQLiveEndRecommendInfo.videoUrl, paramQQLiveEndRecommendInfo.videoId, paramQQLiveEndRecommendInfo.roomType, paramQQLiveEndRecommendInfo.gameId, paramQQLiveEndRecommendInfo.gameTagId, paramQQLiveEndRecommendInfo.videoSource, paramQQLiveEndRecommendInfo.roomBg, paramQQLiveEndRecommendInfo.roomTitle, Long.valueOf(paramQQLiveEndRecommendInfo.popularity), paramQQLiveEndRecommendInfo.nick);
      TimiAudienceView.q(this.b).a(paramQQLiveEndRecommendInfo);
    }
  }
  
  public void a(View paramView)
  {
    paramView = TimiAudienceView.j(this.b);
    if (paramView != null) {
      paramView.finish();
    }
  }
  
  public void b(View paramView)
  {
    Logger.a("TimiAudienceView", "onFollowClick");
    paramView = TimiAudienceView.i(this.b).d();
    if (paramView != null)
    {
      paramView = paramView.getFollowMsgService();
      if (paramView != null) {
        paramView.followAnchor(this.a.uid, TimiAudienceView.b(this.b), new TimiAudienceView.13.1(this));
      }
    }
  }
  
  public void c(View paramView) {}
  
  public void d(View paramView) {}
  
  public void e(View paramView) {}
  
  public void f(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.13
 * JD-Core Version:    0.7.0.1
 */