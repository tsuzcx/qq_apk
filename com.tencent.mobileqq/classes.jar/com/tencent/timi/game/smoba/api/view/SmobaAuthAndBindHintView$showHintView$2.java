package com.tencent.timi.game.smoba.api.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.DefaultImpls;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class SmobaAuthAndBindHintView$showHintView$2
  implements View.OnClickListener
{
  SmobaAuthAndBindHintView$showHintView$2(SmobaAuthAndBindHintView paramSmobaAuthAndBindHintView, GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp, GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = this.b;
    QBaseActivity localQBaseActivity;
    if (localObject == null)
    {
      localObject = (IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class);
      localQBaseActivity = SmobaAuthAndBindHintView.a(this.a);
      if (localQBaseActivity == null) {
        Intrinsics.throwNpe();
      }
      IUserSmobaInfoService.DefaultImpls.a((IUserSmobaInfoService)localObject, localQBaseActivity, false, null, null, 14, null);
    }
    else if (!((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject).is_auth.get())
    {
      localObject = (IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class);
      localQBaseActivity = SmobaAuthAndBindHintView.a(this.a);
      if (localQBaseActivity == null) {
        Intrinsics.throwNpe();
      }
      List localList = this.b.auth_desc.get();
      Intrinsics.checkExpressionValueIsNotNull(localList, "authInfo.auth_desc.get()");
      IUserSmobaInfoService.DefaultImpls.a((IUserSmobaInfoService)localObject, localQBaseActivity, localList, false, null, null, 28, null);
    }
    else if (this.c != null)
    {
      localObject = (IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class);
      localQBaseActivity = SmobaAuthAndBindHintView.a(this.a);
      if (localQBaseActivity == null) {
        Intrinsics.throwNpe();
      }
      IUserSmobaInfoService.DefaultImpls.a((IUserSmobaInfoService)localObject, localQBaseActivity, this.c, null, 4, null);
    }
    else
    {
      localObject = (IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class);
      localQBaseActivity = SmobaAuthAndBindHintView.a(this.a);
      if (localQBaseActivity == null) {
        Intrinsics.throwNpe();
      }
      IUserSmobaInfoService.DefaultImpls.a((IUserSmobaInfoService)localObject, localQBaseActivity, null, 2, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.view.SmobaAuthAndBindHintView.showHintView.2
 * JD-Core Version:    0.7.0.1
 */