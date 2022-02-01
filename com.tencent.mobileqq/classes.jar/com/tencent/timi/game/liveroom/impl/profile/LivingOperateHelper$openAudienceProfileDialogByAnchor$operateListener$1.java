package com.tencent.timi.game.liveroom.impl.profile;

import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.liveroom.api.ProfileOperateType;
import com.tencent.timi.game.liveroom.impl.profile.operate.ProfileOperateDialog.ItemClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/profile/LivingOperateHelper$openAudienceProfileDialogByAnchor$operateListener$1", "Lcom/tencent/timi/game/liveroom/impl/profile/operate/ProfileOperateDialog$ItemClickListener;", "onItemClick", "", "type", "", "data", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingOperateHelper$openAudienceProfileDialogByAnchor$operateListener$1
  implements ProfileOperateDialog.ItemClickListener
{
  LivingOperateHelper$openAudienceProfileDialogByAnchor$operateListener$1(long paramLong1, long paramLong2, LiveUserInfo paramLiveUserInfo) {}
  
  public void a(int paramInt, @Nullable AdminReason paramAdminReason)
  {
    LivingOperateHelper localLivingOperateHelper;
    long l1;
    long l2;
    long l3;
    if (paramInt == ProfileOperateType.a.c())
    {
      localLivingOperateHelper = LivingOperateHelper.a;
      l1 = this.a;
      l2 = this.b;
      l3 = this.c.uid;
      if (paramAdminReason != null)
      {
        paramAdminReason = paramAdminReason.desc;
        if (paramAdminReason != null) {}
      }
      else
      {
        paramAdminReason = "";
      }
      String str = this.c.nick;
      Intrinsics.checkExpressionValueIsNotNull(str, "liveUserInfo.nick");
      LivingOperateHelper.a(localLivingOperateHelper, l1, l2, l3, paramAdminReason, str);
      return;
    }
    if (paramInt == ProfileOperateType.a.a())
    {
      localLivingOperateHelper = LivingOperateHelper.a;
      l1 = this.b;
      l2 = this.a;
      l3 = this.c.uid;
      if (paramAdminReason != null) {
        paramInt = paramAdminReason.id;
      } else {
        paramInt = 0;
      }
      paramAdminReason = this.c.nick;
      Intrinsics.checkExpressionValueIsNotNull(paramAdminReason, "liveUserInfo.nick");
      LivingOperateHelper.a(localLivingOperateHelper, l1, l2, l3, paramInt, paramAdminReason);
      return;
    }
    if (paramInt == ProfileOperateType.a.b())
    {
      localLivingOperateHelper = LivingOperateHelper.a;
      l1 = this.b;
      l2 = this.a;
      l3 = this.c.uid;
      if (paramAdminReason != null) {
        paramInt = paramAdminReason.id;
      } else {
        paramInt = 0;
      }
      paramAdminReason = this.c.nick;
      Intrinsics.checkExpressionValueIsNotNull(paramAdminReason, "liveUserInfo.nick");
      LivingOperateHelper.b(localLivingOperateHelper, l1, l2, l3, paramInt, paramAdminReason);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper.openAudienceProfileDialogByAnchor.operateListener.1
 * JD-Core Version:    0.7.0.1
 */