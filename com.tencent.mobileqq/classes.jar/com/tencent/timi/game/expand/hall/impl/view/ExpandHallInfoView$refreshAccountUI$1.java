package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.DefaultImpls;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.SwitchSmobaAccountCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandHallInfoView$refreshAccountUI$1
  implements View.OnClickListener
{
  ExpandHallInfoView$refreshAccountUI$1(ExpandHallInfoView paramExpandHallInfoView, QBaseActivity paramQBaseActivity, GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp) {}
  
  public final void onClick(View paramView)
  {
    Object localObject3 = (GameDataServerOuterClass.GetSmobaAuthInfoRsp)((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).c().getValue();
    if (localObject3 == null)
    {
      QQToast.makeText(this.a.getContext(), 2131917229, 0).show();
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d(null);
    }
    else
    {
      Object localObject1;
      Object localObject2;
      if (!((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject3).is_auth.get())
      {
        localObject1 = (IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class);
        localObject2 = this.b;
        localObject3 = ((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject3).auth_desc.get();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "authInfo.auth_desc.get()");
        IUserSmobaInfoService.DefaultImpls.a((IUserSmobaInfoService)localObject1, (QBaseActivity)localObject2, (List)localObject3, true, null, null, 24, null);
      }
      else if ((((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject3).is_auth.get()) && (this.c == null))
      {
        localObject1 = LoadingUtils.a;
        localObject2 = this.a.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
        ((LoadingUtils)localObject1).a((Context)localObject2);
        localObject1 = new ExpandHallInfoView.refreshAccountUI.1.bindAccountCb.1(this);
        ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a(this.b, (IUserSmobaInfoService.BindSmobaAccountCallback)localObject1);
      }
      else if ((((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject3).is_auth.get()) && (this.c != null))
      {
        localObject1 = new ExpandHallInfoView.refreshAccountUI.1.cb.1();
        ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a(this.b, (IUserSmobaInfoService.SwitchSmobaAccountCallback)localObject1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView.refreshAccountUI.1
 * JD-Core Version:    0.7.0.1
 */