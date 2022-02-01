package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ProfileMessageItemView$chatListener$1
  implements View.OnClickListener
{
  ProfileMessageItemView$chatListener$1(ProfileMessageItemView paramProfileMessageItemView) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      Object localObject1 = this.a.getContext();
      if (((localObject1 instanceof QBaseActivity)) && (ProfileMessageItemView.b(this.a) != null))
      {
        ITGRelationshipService localITGRelationshipService = (ITGRelationshipService)ServiceCenter.a(ITGRelationshipService.class);
        localObject1 = (QBaseActivity)localObject1;
        Object localObject2 = ProfileMessageItemView.b(this.a);
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((IUserInfo)localObject2).a();
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        long l = ((Long)localObject2).longValue();
        int i;
        if (ProfileMessageItemView.g(this.a)) {
          i = 303;
        } else {
          i = 302;
        }
        localITGRelationshipService.a((QBaseActivity)localObject1, String.valueOf(l), i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.ProfileMessageItemView.chatListener.1
 * JD-Core Version:    0.7.0.1
 */