package com.tencent.timi.game.liveroom.impl.profile;

import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.liveroom.api.ProfileOperateType;
import com.tencent.timi.game.liveroom.impl.profile.operate.ProfileOperateDialog.ItemClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/profile/LivingOperateHelper$openAnchorProfileDialog$operateListener$1", "Lcom/tencent/timi/game/liveroom/impl/profile/operate/ProfileOperateDialog$ItemClickListener;", "onItemClick", "", "type", "", "data", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingOperateHelper$openAnchorProfileDialog$operateListener$1
  implements ProfileOperateDialog.ItemClickListener
{
  LivingOperateHelper$openAnchorProfileDialog$operateListener$1(long paramLong, LiveUserInfo paramLiveUserInfo) {}
  
  public void a(int paramInt, @Nullable AdminReason paramAdminReason)
  {
    if (paramInt == ProfileOperateType.a.c())
    {
      LivingOperateHelper localLivingOperateHelper = LivingOperateHelper.a;
      long l1 = this.a;
      long l2 = LivingOperateHelper.a.a();
      long l3 = this.b.uid;
      if (paramAdminReason != null)
      {
        paramAdminReason = paramAdminReason.desc;
        if (paramAdminReason != null) {}
      }
      else
      {
        paramAdminReason = "";
      }
      String str = this.b.nick;
      Intrinsics.checkExpressionValueIsNotNull(str, "liveUserInfo.nick");
      LivingOperateHelper.a(localLivingOperateHelper, l1, l2, l3, paramAdminReason, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper.openAnchorProfileDialog.operateListener.1
 * JD-Core Version:    0.7.0.1
 */