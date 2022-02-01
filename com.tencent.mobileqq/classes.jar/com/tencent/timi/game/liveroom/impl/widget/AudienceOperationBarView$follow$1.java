package com.tencent.timi.game.liveroom.impl.widget;

import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/AudienceOperationBarView$follow$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AudienceOperationBarView$follow$1
  implements IQQLiveFollowCallback
{
  AudienceOperationBarView$follow$1(BaseAnchorInfo paramBaseAnchorInfo, ILiveRoom paramILiveRoom) {}
  
  public void a()
  {
    if (this.b.getAnchorUid() == AudienceOperationBarView.c(this.a))
    {
      BaseRoomInfo localBaseRoomInfo = this.c.getRoomInfo();
      Intrinsics.checkExpressionValueIsNotNull(localBaseRoomInfo, "liveRoom.roomInfo");
      if (localBaseRoomInfo.getRoomId() != AudienceOperationBarView.b(this.a)) {
        return;
      }
      ((ImageView)this.a.a(2131433508)).setImageResource(2130853024);
      ((FrameLayout)this.a.a(2131433509)).setOnClickListener((View.OnClickListener)new AudienceOperationBarView.follow.1.onSuccess.1(this));
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    QQToast.makeText(this.a.getContext(), (CharSequence)"关注失败，请稍后重试", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.follow.1
 * JD-Core Version:    0.7.0.1
 */