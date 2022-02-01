package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ProfileMessageItemView$1
  implements View.OnClickListener
{
  ProfileMessageItemView$1(ProfileMessageItemView paramProfileMessageItemView) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      Object localObject1 = this.a.getContext();
      if (((localObject1 instanceof QBaseActivity)) && (ProfileMessageItemView.b(this.a) != null) && (ProfileMessageItemView.c(this.a) != null))
      {
        ITGRelationshipService localITGRelationshipService;
        Object localObject2;
        long l;
        if (ProfileMessageItemView.d(this.a))
        {
          if (this.a.getSelfQQUserId() != null)
          {
            localITGRelationshipService = (ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class);
            localObject1 = (QBaseActivity)localObject1;
            localObject2 = this.a.getSelfQQUserId();
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            Object localObject3 = ProfileMessageItemView.b(this.a);
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            localObject3 = ((IUserInfo)localObject3).a();
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            l = ((Long)localObject3).longValue();
            localObject3 = ProfileMessageItemView.b(this.a);
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            localObject3 = ((IUserInfo)localObject3).c(ProfileMessageItemView.c(this.a));
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "alluerInfo!!.nick(qqUserId)");
            localITGRelationshipService.a((QBaseActivity)localObject1, (CommonOuterClass.QQUserId)localObject2, String.valueOf(l), (String)localObject3);
          }
          else
          {
            Logger.c("ProfileMessageItemView", "addQQFriendView selfQQUserId==null");
          }
        }
        else if (ProfileMessageItemView.e(this.a) == ProfileMessageItemView.f(this.a))
        {
          localITGRelationshipService = (ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class);
          localObject1 = (QBaseActivity)localObject1;
          localObject2 = ProfileMessageItemView.b(this.a);
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          l = ((IUserInfo)localObject2).a().longValue();
          localObject2 = ProfileMessageItemView.b(this.a);
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          localObject2 = ((IUserInfo)localObject2).c(ProfileMessageItemView.c(this.a));
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "alluerInfo!!.nick(qqUserId)");
          localITGRelationshipService.b((QBaseActivity)localObject1, String.valueOf(l), (String)localObject2);
        }
        else
        {
          localITGRelationshipService = (ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class);
          localObject1 = (QBaseActivity)localObject1;
          localObject2 = ProfileMessageItemView.b(this.a);
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          l = ((IUserInfo)localObject2).a().longValue();
          localObject2 = ProfileMessageItemView.b(this.a);
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          localObject2 = ((IUserInfo)localObject2).c(ProfileMessageItemView.c(this.a));
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "alluerInfo!!.nick(qqUserId)");
          localITGRelationshipService.a((QBaseActivity)localObject1, String.valueOf(l), (String)localObject2);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.ProfileMessageItemView.1
 * JD-Core Version:    0.7.0.1
 */