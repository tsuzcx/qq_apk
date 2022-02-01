package com.tencent.timi.game.liveroom.impl;

import android.app.Activity;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.gift.impl.timi.TimiGiftPanelFragment;
import com.tencent.timi.game.gift.impl.timi.TimiGiftPanelFragment.Companion;
import com.tencent.timi.game.liveroom.impl.share.TgLiveShareUtil;
import com.tencent.timi.game.liveroom.impl.widget.AudienceInputBoxView;
import com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.IAudienceOperationViewListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$6
  implements AudienceOperationBarView.IAudienceOperationViewListener
{
  TimiAudienceView$6(TimiAudienceView paramTimiAudienceView) {}
  
  public void a()
  {
    TimiAudienceView.g(this.a).requestFocus();
    TimiAudienceView.g(this.a).h();
  }
  
  public void b()
  {
    TgLiveShareUtil.a(CommonExKt.a(this.a), TimiAudienceView.b(this.a), TimiAudienceView.h(this.a));
  }
  
  public void c()
  {
    Object localObject2 = TimiAudienceView.i(this.a).i(TimiAudienceView.b(this.a));
    if (localObject2 == null)
    {
      Logger.c("TimiAudienceView", "onGiftEntranceClick userInfo == null");
      return;
    }
    Object localObject1 = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).f();
    if (localObject1 == null) {
      return;
    }
    Activity localActivity = TimiAudienceView.j(this.a);
    Object localObject3 = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).h(TimiAudienceView.b(this.a));
    if (localObject3 == null) {
      return;
    }
    if (localActivity != null)
    {
      TimiGiftPanelFragment.Companion localCompanion = TimiGiftPanelFragment.a;
      long l1 = TimiAudienceView.b(this.a);
      long l2 = ((LiveUserInfo)localObject1).uid;
      String str1 = ((LiveUserInfo)localObject1).nick;
      localObject1 = ((LiveUserInfo)localObject1).headUrl;
      long l3 = ((TgLiveAnchorUserInfo)localObject2).a;
      String str2 = ((TgLiveAnchorUserInfo)localObject2).b;
      localObject2 = ((TgLiveAnchorUserInfo)localObject2).c;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(TimiAudienceView.h(this.a).d);
      localObject4 = ((StringBuilder)localObject4).toString();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("");
      ((StringBuilder)localObject5).append(TimiAudienceView.h(this.a).b);
      localObject5 = ((StringBuilder)localObject5).toString();
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("");
      ((StringBuilder)localObject6).append(((BaseRoomInfo)localObject3).getProgramId());
      localObject3 = ((StringBuilder)localObject6).toString();
      localObject6 = TimiAudienceView.h(this.a).f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TimiAudienceView.h(this.a).b);
      localCompanion.a(localActivity, 10001, l1, l2, str1, (String)localObject1, l3, str2, (String)localObject2, (String)localObject4, (String)localObject5, (String)localObject3, "1037", (String)localObject6, localStringBuilder.toString());
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.6
 * JD-Core Version:    0.7.0.1
 */