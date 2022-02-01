package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarTextViewImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class SmobaCapInfoSubItemView$refresh$1
  implements View.OnClickListener
{
  SmobaCapInfoSubItemView$refresh$1(SmobaCapInfoSubItemView paramSmobaCapInfoSubItemView, CommonOuterClass.QQUserId paramQQUserId1, CommonOuterClass.QQUserId paramQQUserId2) {}
  
  public final void onClick(View paramView)
  {
    if (this.b != null)
    {
      ITGRelationshipService localITGRelationshipService = (ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class);
      QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "TimiGameActivityManager.getTopQActivity()");
      CommonOuterClass.QQUserId localQQUserId = this.b;
      long l = this.c.uid.get();
      String str = ((TimiAvatarTextViewImpl)this.a.a(2131446514)).f();
      Intrinsics.checkExpressionValueIsNotNull(str, "subNickView.acquireShowName()");
      localITGRelationshipService.a(localQBaseActivity, localQQUserId, String.valueOf(l), str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SmobaCapInfoSubItemView.refresh.1
 * JD-Core Version:    0.7.0.1
 */