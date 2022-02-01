package com.tencent.mobileqq.vas.ipc.remote;

import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.Base64Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ipc/remote/RedTouchIPC;", "Lcom/tencent/mobileqq/vas/ipc/remote/IRedTouchIPC;", "()V", "getAppInfo", "", "path", "getRedTouchManager", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "onRedTouchItemClick", "", "reportLevelOne", "reportType", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RedTouchIPC
  implements IRedTouchIPC
{
  @Nullable
  public String getAppInfo(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    paramString = getRedTouchManager().getAppInfoByPath(paramString);
    if (paramString != null) {
      paramString = paramString.toByteArray();
    } else {
      paramString = null;
    }
    return Base64Util.encodeToString(paramString, 0);
  }
  
  @NotNull
  public final IRedTouchManager getRedTouchManager()
  {
    IRuntimeService localIRuntimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IRedTouchManager.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "appRuntime.getRuntimeSer…va, ProcessConstant.MAIN)");
    return (IRedTouchManager)localIRuntimeService;
  }
  
  public void onRedTouchItemClick(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    getRedTouchManager().onRedTouchItemClick(paramString);
  }
  
  public void reportLevelOne(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    getRedTouchManager().reportLevelOneRedInfo(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.RedTouchIPC
 * JD-Core Version:    0.7.0.1
 */