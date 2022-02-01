package com.tencent.timi.game.liveroom.impl.profile.operate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/timi/game/liveroom/impl/profile/operate/ProfileOperateDialog$initViews$1$1"}, k=3, mv={1, 1, 16})
final class ProfileOperateDialog$initViews$$inlined$forEach$lambda$1
  implements View.OnClickListener
{
  ProfileOperateDialog$initViews$$inlined$forEach$lambda$1(AdminReason paramAdminReason, ProfileOperateDialog paramProfileOperateDialog, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      ProfileOperateDialog.ItemClickListener localItemClickListener = this.b.a();
      if (localItemClickListener != null) {
        localItemClickListener.a(ProfileOperateDialog.a(this.b), this.a);
      }
      this.b.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.operate.ProfileOperateDialog.initViews..inlined.forEach.lambda.1
 * JD-Core Version:    0.7.0.1
 */