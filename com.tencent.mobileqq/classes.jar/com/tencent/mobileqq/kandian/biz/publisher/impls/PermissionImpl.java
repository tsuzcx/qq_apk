package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.tencent.tkd.topicsdk.interfaces.IPermission;
import com.tencent.tkd.topicsdk.interfaces.IPermission.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PermissionImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission;", "()V", "checkPermission", "", "activity", "Landroid/app/Activity;", "permission", "", "requestPermission", "", "permissions", "", "requestCode", "callback", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission$Callback;", "(Landroid/app/Activity;[Ljava/lang/String;ILcom/tencent/tkd/topicsdk/interfaces/IPermission$Callback;)V", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PermissionImpl
  implements IPermission
{
  @RequiresApi(23)
  public int a(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "permission");
    return ContextCompat.checkSelfPermission((Context)paramActivity, paramString);
  }
  
  @RequiresApi(23)
  public void a(@NotNull Activity paramActivity, @NotNull String[] paramArrayOfString, int paramInt, @NotNull IPermission.Callback paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "permissions");
    Intrinsics.checkParameterIsNotNull(paramCallback, "callback");
    ActivityCompat.requestPermissions(paramActivity, paramArrayOfString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PermissionImpl
 * JD-Core Version:    0.7.0.1
 */