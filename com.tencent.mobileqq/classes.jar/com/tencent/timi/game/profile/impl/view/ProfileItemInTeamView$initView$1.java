package com.tencent.timi.game.profile.impl.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.profile.impl.dialog.ProfileJumpHelper;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ProfileItemInTeamView$initView$1
  implements View.OnClickListener
{
  ProfileItemInTeamView$initView$1(ProfileItemInTeamView paramProfileItemInTeamView) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      Object localObject2;
      if ((ProfileItemInTeamView.a(this.a) != null) && (ProfileItemInTeamView.b(this.a) != null) && (ProfileItemInTeamView.c(this.a) != null))
      {
        localObject1 = ProfileJumpHelper.a;
        localObject2 = ProfileItemInTeamView.a(this.a);
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        Object localObject3 = ProfileItemInTeamView.b(this.a);
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        long l = ((PremadesTeamServerOuterClass.SmobaPremadesTeamInfo)localObject3).id.get();
        localObject3 = ProfileItemInTeamView.c(this.a);
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((ProfileJumpHelper)localObject1).a((CommonOuterClass.QQUserId)localObject2, l, (Context)localObject3);
      }
      else
      {
        localObject1 = ProfileItemInTeamView.d(this.a);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("joinYoloRoomFromTeamView - onError -");
        ((StringBuilder)localObject2).append(ProfileItemInTeamView.b(this.a));
        Logger.c((String)localObject1, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = this.a.getClickListener();
      if (localObject1 != null) {
        ((View.OnClickListener)localObject1).onClick((View)this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.view.ProfileItemInTeamView.initView.1
 * JD-Core Version:    0.7.0.1
 */