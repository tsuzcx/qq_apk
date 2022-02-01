package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/onlinestatus/view/WeatherView$showCard$1", "", "denied", "", "grant", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherView$showCard$1
{
  @QQPermissionDenied(1)
  public final void denied()
  {
    DialogUtil.a((Activity)this.a.a(), 2131698482, 2131698483).setOnDismissListener((DialogInterface.OnDismissListener)new WeatherView.showCard.1.denied.1(this));
  }
  
  @QQPermissionGrant(1)
  public final void grant()
  {
    Object localObject = WeatherView.a(this.a).getRuntimeService(IOnlineStatusManagerService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
    localObject = ((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusDataManager.class);
    if (localObject != null)
    {
      ((OnlineStatusDataManager)localObject).a(9);
      this.a.show();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.WeatherView.showCard.1
 * JD-Core Version:    0.7.0.1
 */