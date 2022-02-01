package com.tencent.tkd.topicsdk.common;

import android.app.Activity;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.events.PosPermissionEvent;
import com.tencent.tkd.topicsdk.framework.events.StoragePermissionEvent;
import com.tencent.tkd.topicsdk.interfaces.IPermission;
import com.tencent.tkd.topicsdk.interfaces.IPermission.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/PermissionUtils;", "", "()V", "checkPermission", "", "activity", "Landroid/app/Activity;", "permission", "", "checkPosPermission", "", "checkStoragePermission", "checkStoragePermission$topicsdk_release", "requestPermission", "", "permissions", "", "requestCode", "callback", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission$Callback;", "(Landroid/app/Activity;[Ljava/lang/String;ILcom/tencent/tkd/topicsdk/interfaces/IPermission$Callback;)V", "requestPosPermission", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "requestStoragePermission", "requestStoragePermission$topicsdk_release", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PermissionUtils
{
  public static final PermissionUtils a = new PermissionUtils();
  
  private final int a(Activity paramActivity, String paramString)
  {
    return TopicSDK.a.a().a().a().a(paramActivity, paramString);
  }
  
  private final void a(Activity paramActivity, String[] paramArrayOfString, int paramInt, IPermission.Callback paramCallback)
  {
    TopicSDK.a.a().a().a().a(paramActivity, paramArrayOfString, paramInt, paramCallback);
  }
  
  private final boolean b(Activity paramActivity)
  {
    return a(paramActivity, "android.permission.ACCESS_FINE_LOCATION") == 0;
  }
  
  public final void a(@NotNull Activity paramActivity, @Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (a(paramActivity))
    {
      if (paramFunction1 != null) {
        paramActivity = (Unit)paramFunction1.invoke(Boolean.valueOf(true));
      }
      DispatchManager.a.a((IEvent)new StoragePermissionEvent(true));
      return;
    }
    paramFunction1 = (IPermission.Callback)new PermissionUtils.requestStoragePermission.1(paramFunction1);
    a(paramActivity, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" }, 3, paramFunction1);
  }
  
  public final boolean a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    return (a(paramActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0) && (a(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
  
  public final void b(@NotNull Activity paramActivity, @Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (b(paramActivity))
    {
      if (paramFunction1 != null) {
        paramActivity = (Unit)paramFunction1.invoke(Boolean.valueOf(true));
      }
      DispatchManager.a.a((IEvent)new PosPermissionEvent(true));
      return;
    }
    paramFunction1 = (IPermission.Callback)new PermissionUtils.requestPosPermission.1(paramFunction1);
    a(paramActivity, new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 4, paramFunction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.PermissionUtils
 * JD-Core Version:    0.7.0.1
 */