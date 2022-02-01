package com.tencent.mobileqq.onlinestatus.constellation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAgeSelectionApi;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/constellation/ConstellationLauncher;", "", "()V", "DEFAULT_CONSTELLATION", "", "REQUEST_CODE_BIRTHDAY", "launchMiniProgram", "", "activity", "Landroid/app/Activity;", "url", "", "launchScene", "launchSelectAge", "launchFrom", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class ConstellationLauncher
{
  @JvmField
  public static final int a = 1040;
  @JvmField
  public static final int b = 0;
  public static final ConstellationLauncher c = new ConstellationLauncher();
  
  public final void a(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "launchFrom");
    Intent localIntent = new Intent();
    if (MobileQQ.sProcessId == 1)
    {
      Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      IProfileCardUtil localIProfileCardUtil = (IProfileCardUtil)QRoute.api(IProfileCardUtil.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "app");
      int i = (int)localIProfileCardUtil.initCard((AppRuntime)localObject, ((AppRuntime)localObject).getCurrentAccountUin()).lBirthday;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{card.lBirthday}: ");
        ((StringBuilder)localObject).append(i);
        QLog.d("ConstellationLauncher", 2, new Object[] { "launchSelectAge: called. ", ((StringBuilder)localObject).toString() });
      }
      localIntent.putExtra("param_birthday", i);
      localIntent.putExtra("param_launch_from", paramString);
      ((IAgeSelectionApi)QRoute.api(IAgeSelectionApi.class)).startAgeSelectionActivity(paramActivity, localIntent, a);
    }
  }
  
  public final void a(@NotNull Activity paramActivity, @Nullable String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("  launchScene: ");
      localStringBuilder.append(paramInt);
      QLog.d("ConstellationLauncher", 2, new Object[] { "launchMiniProgram: called. ", localStringBuilder.toString() });
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)paramActivity, paramString, paramInt, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher
 * JD-Core Version:    0.7.0.1
 */