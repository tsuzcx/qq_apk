package com.tencent.mobileqq.vas.ipc.remote;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.Base64Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ipc/remote/RedTouchIPC;", "Lcom/tencent/mobileqq/vas/ipc/remote/IRedTouchIPC;", "()V", "redTouchManager", "Lcom/tencent/mobileqq/redtouch/RedTouchManager;", "getRedTouchManager", "()Lcom/tencent/mobileqq/redtouch/RedTouchManager;", "setRedTouchManager", "(Lcom/tencent/mobileqq/redtouch/RedTouchManager;)V", "getAppInfo", "", "path", "onRedTouchItemClick", "", "reportLevelOne", "reportType", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RedTouchIPC
  implements IRedTouchIPC
{
  @Nullable
  private RedTouchManager redTouchManager;
  
  public RedTouchIPC()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    Manager localManager = ((BaseApplicationImpl)localObject).getRuntime().getManager(QQManagerFactory.MGR_RED_TOUCH);
    localObject = localManager;
    if (!(localManager instanceof RedTouchManager)) {
      localObject = null;
    }
    this.redTouchManager = ((RedTouchManager)localObject);
  }
  
  @Nullable
  public String getAppInfo(@NotNull String paramString)
  {
    byte[] arrayOfByte = null;
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    RedTouchManager localRedTouchManager = this.redTouchManager;
    if (localRedTouchManager != null) {}
    for (paramString = localRedTouchManager.a(paramString);; paramString = null)
    {
      if (paramString != null) {
        arrayOfByte = paramString.toByteArray();
      }
      return Base64Util.encodeToString(arrayOfByte, 0);
    }
  }
  
  @Nullable
  public final RedTouchManager getRedTouchManager()
  {
    return this.redTouchManager;
  }
  
  public void onRedTouchItemClick(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    RedTouchManager localRedTouchManager = this.redTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.b(paramString);
    }
  }
  
  public void reportLevelOne(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    RedTouchManager localRedTouchManager = this.redTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.a(paramString, paramInt);
    }
  }
  
  public final void setRedTouchManager(@Nullable RedTouchManager paramRedTouchManager)
  {
    this.redTouchManager = paramRedTouchManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.RedTouchIPC
 * JD-Core Version:    0.7.0.1
 */