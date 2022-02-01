package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CONSTELLATION_CARD_HEIGHT_DEFAULT", "", "TAG", "", "applyActivityResult", "Lkotlin/Pair;", "", "app", "Lmqq/app/AppRuntime;", "intent", "Landroid/content/Intent;", "currentConstellation", "sendBirthDayChangedRequest", "", "birthday", "age", "constellation", "qqonlinestatus-impl_release"}, k=2, mv={1, 1, 16})
public final class ConstellationViewKt
{
  @NotNull
  public static final Pair<Integer, String> a(@NotNull AppRuntime paramAppRuntime, @Nullable Intent paramIntent, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    Object localObject = new Pair(Integer.valueOf(0), "");
    if (paramIntent != null)
    {
      int k = paramIntent.getShortExtra("param_year", (short)1990);
      byte b = (byte)1;
      int m = paramIntent.getByteExtra("param_month", b);
      int n = paramIntent.getByteExtra("param_day", b);
      int i = paramIntent.getIntExtra("param_age", 0);
      int j = paramIntent.getIntExtra("param_constellation_id", ConstellationLauncher.b);
      k = k << 16 | m << 8 | n;
      paramIntent = OnlineStatusUtil.b(j);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("constellationStr: ");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.d("ConstellationView", 2, new Object[] { "applyActivityResult: called. ", ((StringBuilder)localObject).toString() });
      }
      if ((Intrinsics.areEqual(paramIntent, paramString) ^ true))
      {
        a(k, i, j);
        OnlineStatusExtInfoServlet.a(paramAppRuntime, paramIntent);
        if (QLog.isColorLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("constellation: ");
          paramAppRuntime.append(paramIntent);
          QLog.d("ConstellationView", 2, new Object[] { "applyActivityResult: called. ", paramAppRuntime.toString() });
        }
      }
      else if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("not changed, birthdayValue: ");
        paramAppRuntime.append(paramString);
        QLog.d("ConstellationView", 2, new Object[] { "applyActivityResult: called. ", paramAppRuntime.toString() });
      }
      return new Pair(Integer.valueOf(k), paramIntent);
    }
    return localObject;
  }
  
  public static final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("birthday", paramInt1);
    ((Bundle)localObject1).putInt("age", paramInt2);
    ((Bundle)localObject1).putInt("key_constellation", paramInt3);
    Object localObject2 = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IProfileProtocolService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.getRuntimeService(\n …va, ProcessConstant.MAIN)");
    localObject2 = (IProfileProtocolService)localObject2;
    if (localObject2 != null) {
      ((IProfileProtocolService)localObject2).setProfileDetail((Bundle)localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("constellation: ");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.d("ConstellationView", 2, new Object[] { "sendBirthDayChangedRequest: called. ", ((StringBuilder)localObject1).toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationViewKt
 * JD-Core Version:    0.7.0.1
 */