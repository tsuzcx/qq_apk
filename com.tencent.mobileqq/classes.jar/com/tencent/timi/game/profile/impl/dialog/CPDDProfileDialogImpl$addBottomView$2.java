package com.tencent.timi.game.profile.impl.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CPDDProfileDialogImpl$addBottomView$2
  implements View.OnClickListener
{
  CPDDProfileDialogImpl$addBottomView$2(CPDDProfileDialogImpl paramCPDDProfileDialogImpl) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      if (CPDDProfileDialogImpl.b(this.a)) {
        ((ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class)).a(this.a.m(), String.valueOf(this.a.n().uid.get()), this.a.f());
      } else {
        ((ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class)).b(this.a.m(), String.valueOf(this.a.n().uid.get()), this.a.f());
      }
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.CPDDProfileDialogImpl.addBottomView.2
 * JD-Core Version:    0.7.0.1
 */