package com.tencent.mobileqq.vas.adv.base.servlet;

import android.content.Context;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/servlet/VasAdvServlet$Companion;", "", "()V", "CALLBACK_MAP", "", "", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvCallback;", "DEFAULT_VALUE_TIMEOUT", "", "RSP_HEADER_LENGTH", "", "SEND_EXTRA_KEY_CMD", "SEND_EXTRA_KEY_DATA", "SEND_EXTRA_KEY_REQ_UUID", "SEND_EXTRA_KEY_TIMEOUT", "TAG", "send", "", "cmd", "uuid", "data", "", "callback", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvServlet$Companion
{
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull byte[] paramArrayOfByte, @NotNull VasAdvCallback paramVasAdvCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    Intrinsics.checkParameterIsNotNull(paramString2, "uuid");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Intrinsics.checkParameterIsNotNull(paramVasAdvCallback, "callback");
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "appRuntime");
      NewIntent localNewIntent = new NewIntent((Context)localAppRuntime.getApplication(), VasAdvServlet.class);
      localNewIntent.putExtra("cmd", paramString1);
      localNewIntent.putExtra("req_uuid", paramString2);
      localNewIntent.putExtra("data", WupUtil.a(paramArrayOfByte));
      localAppRuntime.startServlet(localNewIntent);
      VasAdvServlet.a().put(paramString2, paramVasAdvCallback);
      return;
    }
    catch (Exception paramString1)
    {
      VasAdvServlet.a().remove(paramString2);
      paramVasAdvCallback.a("send cmd failed", (Throwable)paramString1);
      paramString2 = new StringBuilder();
      paramString2.append("requestAdv error: ");
      paramString2.append(paramString1);
      QLog.e("VasAdvServlet", 1, paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.servlet.VasAdvServlet.Companion
 * JD-Core Version:    0.7.0.1
 */