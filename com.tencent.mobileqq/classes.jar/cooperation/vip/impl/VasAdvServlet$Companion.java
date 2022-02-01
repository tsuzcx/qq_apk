package cooperation.vip.impl;

import android.content.Context;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.WupUtil;
import cooperation.vip.VasAdvCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/impl/VasAdvServlet$Companion;", "", "()V", "CALLBACK_MAP", "", "", "Lcooperation/vip/VasAdvCallback;", "DEFAULT_VALUE_TIMEOUT", "", "RSP_HEADER_LENGTH", "", "SEND_EXTRA_KEY_CMD", "SEND_EXTRA_KEY_DATA", "SEND_EXTRA_KEY_REQ_UUID", "SEND_EXTRA_KEY_TIMEOUT", "TAG", "send", "", "cmd", "uuid", "data", "", "callback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
      Object localObject = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "appRuntime");
      NewIntent localNewIntent = new NewIntent((Context)((AppRuntime)localObject).getApplication(), VasAdvServlet.class);
      localNewIntent.putExtra("cmd", paramString1);
      localNewIntent.putExtra("req_uuid", paramString2);
      localNewIntent.putExtra("data", WupUtil.a(paramArrayOfByte));
      ((AppRuntime)localObject).startServlet(localNewIntent);
      VasAdvServlet.a().put(paramString2, paramVasAdvCallback);
      return;
    }
    catch (Exception paramString1)
    {
      VasAdvServlet.a().remove(paramString2);
      paramVasAdvCallback.a("send cmd failed", (Throwable)paramString1);
      QLog.e("VasAdvServlet", 1, "requestAdv error: " + paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.impl.VasAdvServlet.Companion
 * JD-Core Version:    0.7.0.1
 */