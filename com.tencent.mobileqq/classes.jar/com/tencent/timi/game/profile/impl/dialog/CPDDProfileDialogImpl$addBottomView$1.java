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
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CPDDProfileDialogImpl$addBottomView$1
  implements View.OnClickListener
{
  CPDDProfileDialogImpl$addBottomView$1(CPDDProfileDialogImpl paramCPDDProfileDialogImpl) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      ITGRelationshipService localITGRelationshipService = (ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class);
      QBaseActivity localQBaseActivity = this.a.m();
      long l = this.a.n().uid.get();
      int i;
      if (CPDDProfileDialogImpl.b(this.a)) {
        i = 303;
      } else {
        i = 302;
      }
      localITGRelationshipService.a(localQBaseActivity, String.valueOf(l), i);
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.CPDDProfileDialogImpl.addBottomView.1
 * JD-Core Version:    0.7.0.1
 */