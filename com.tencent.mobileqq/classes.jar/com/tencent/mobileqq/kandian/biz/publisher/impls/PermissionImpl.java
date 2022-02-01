package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.interfaces.IPermission;
import com.tencent.tkd.topicsdk.interfaces.IPermission.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PermissionImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission;", "()V", "checkPermission", "", "activity", "Landroid/app/Activity;", "permission", "", "requestPermission", "", "permissions", "", "requestCode", "callback", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission$Callback;", "(Landroid/app/Activity;[Ljava/lang/String;ILcom/tencent/tkd/topicsdk/interfaces/IPermission$Callback;)V", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PermissionImpl
  implements IPermission
{
  public static final PermissionImpl.Companion a = new PermissionImpl.Companion(null);
  
  @RequiresApi(23)
  public int a(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "permission");
    paramActivity = QQPermissionFactory.a((Fragment)((QPublicFragmentActivity)paramActivity).getFragment());
    if (paramActivity != null) {
      return paramActivity.a(paramString);
    }
    return -1;
  }
  
  @RequiresApi(23)
  public void a(@NotNull Activity paramActivity, @NotNull String[] paramArrayOfString, int paramInt, @NotNull IPermission.Callback paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "permissions");
    Intrinsics.checkParameterIsNotNull(paramCallback, "callback");
    paramCallback = new PermissionImpl.requestPermission.dialogCallback.1(paramArrayOfString, paramCallback, paramInt);
    paramActivity = QQPermissionFactory.a((Fragment)((QPublicFragmentActivity)paramActivity).getFragment());
    if (paramActivity != null)
    {
      paramActivity.a(paramArrayOfString, 2, (QQPermission.BasePermissionsListener)paramCallback);
      return;
    }
    QLog.e("PermissionImpl", 1, "The Fragment has no access to request permission");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PermissionImpl
 * JD-Core Version:    0.7.0.1
 */