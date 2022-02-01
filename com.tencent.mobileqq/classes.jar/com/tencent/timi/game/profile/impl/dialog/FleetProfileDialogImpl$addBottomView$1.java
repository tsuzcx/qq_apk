package com.tencent.timi.game.profile.impl.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class FleetProfileDialogImpl$addBottomView$1
  implements View.OnClickListener
{
  FleetProfileDialogImpl$addBottomView$1(FleetProfileDialogImpl paramFleetProfileDialogImpl) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      if (this.a.c() != null)
      {
        ITGRelationshipService localITGRelationshipService = (ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class);
        QBaseActivity localQBaseActivity = this.a.m();
        CommonOuterClass.QQUserId localQQUserId = this.a.c();
        if (localQQUserId == null) {
          Intrinsics.throwNpe();
        }
        localITGRelationshipService.a(localQBaseActivity, localQQUserId, String.valueOf(this.a.n().uid.get()), this.a.f());
      }
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.FleetProfileDialogImpl.addBottomView.1
 * JD-Core Version:    0.7.0.1
 */