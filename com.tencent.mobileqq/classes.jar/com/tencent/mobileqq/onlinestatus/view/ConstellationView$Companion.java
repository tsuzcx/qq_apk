package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/view/ConstellationView$Companion;", "", "()V", "reqCardDisplaySettingIfNotPrepared", "", "app", "Lmqq/app/AppRuntime;", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class ConstellationView$Companion
{
  public final boolean a(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    Object localObject = paramAppRuntime.getRuntimeService(IProfileDataService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IP…ava, ProcessConstant.ALL)");
    localObject = ((IProfileDataService)localObject).getProfileCard(paramAppRuntime.getCurrentUin(), true);
    boolean bool;
    if (((IProfileSettingApi)QRoute.api(IProfileSettingApi.class)).getProfileSettingStateFromCard(41609, (Card)localObject) == -1) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("displaySettingNotPrepared: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ConstellationView", 2, new Object[] { "onSelectStatusCallback: called. ", ((StringBuilder)localObject).toString() });
    }
    if (bool) {
      ((IProfileSettingApi)QRoute.api(IProfileSettingApi.class)).requestProfileSettingState((AppInterface)paramAppRuntime, CollectionsKt.arrayListOf(new Integer[] { Integer.valueOf(41609) }));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationView.Companion
 * JD-Core Version:    0.7.0.1
 */