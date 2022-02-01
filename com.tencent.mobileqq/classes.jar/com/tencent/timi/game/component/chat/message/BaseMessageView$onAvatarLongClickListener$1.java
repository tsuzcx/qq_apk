package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.chat.at.FamilyAtFunction;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarTextViewImpl;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k=3, mv={1, 1, 16})
final class BaseMessageView$onAvatarLongClickListener$1
  implements View.OnLongClickListener
{
  BaseMessageView$onAvatarLongClickListener$1(BaseMessageView paramBaseMessageView) {}
  
  public final boolean onLongClick(View paramView)
  {
    Object localObject2 = TimiGameActivityManager.a();
    paramView = new StringBuilder();
    paramView.append("userLongClick ");
    paramView.append(localObject2);
    Logger.a("BaseMsgView ", paramView.toString());
    paramView = (TimiAvatarTextViewImpl)this.a.a(2131429329);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "baseNickView");
    CommonOuterClass.QQUserId localQQUserId = paramView.getQQUserId();
    Object localObject1 = (FamilyAtFunction)null;
    if (!(localObject2 instanceof FamilyAtFunction))
    {
      paramView = (View)localObject1;
      if ((localObject2 instanceof QPublicFragmentActivity))
      {
        localObject2 = (QPublicFragmentActivity)localObject2;
        paramView = (View)localObject1;
        if ((((QPublicFragmentActivity)localObject2).getFragment() instanceof FamilyAtFunction))
        {
          localObject1 = ((QPublicFragmentActivity)localObject2).getFragment();
          paramView = (View)localObject1;
          if (!(localObject1 instanceof FamilyAtFunction)) {
            paramView = null;
          }
          paramView = (FamilyAtFunction)paramView;
        }
      }
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject2 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
        localObject1 = paramView;
        if (localObject2 != null)
        {
          localObject1 = paramView;
          if ((localObject2 instanceof FamilyAtFunction)) {
            localObject1 = (FamilyAtFunction)localObject2;
          }
        }
      }
      paramView = (View)localObject1;
    }
    else
    {
      paramView = (FamilyAtFunction)localObject2;
    }
    if (paramView != null)
    {
      localObject1 = ((TimiAvatarTextViewImpl)this.a.a(2131429329)).g();
      localObject2 = (CharSequence)localObject1;
      int i;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject2 = SpecialMsgUtil.a;
        Intrinsics.checkExpressionValueIsNotNull(localQQUserId, "uid");
        SpecialMsgUtil.a((SpecialMsgUtil)localObject2, localQQUserId, (String)localObject1, paramView, null, null, 24, null);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.BaseMessageView.onAvatarLongClickListener.1
 * JD-Core Version:    0.7.0.1
 */