package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.interfaces.IPermission.Callback;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/PermissionImpl$requestPermission$dialogCallback$1", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "onAllGranted", "", "onDenied", "permissions", "", "", "results", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PermissionImpl$requestPermission$dialogCallback$1
  extends QQPermission.BasePermissionsListener
{
  PermissionImpl$requestPermission$dialogCallback$1(String[] paramArrayOfString, IPermission.Callback paramCallback, int paramInt) {}
  
  public void a()
  {
    int j = this.a.length;
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    this.b.a(this.c, this.a, arrayOfInt);
    QLog.i("PermissionImpl", 1, "request permissions and all was granted");
  }
  
  public void a(@NotNull List<String> paramList, @NotNull List<Integer> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "permissions");
    Intrinsics.checkParameterIsNotNull(paramList1, "results");
    super.a(paramList, paramList1);
    QLog.i("PermissionImpl", 1, "request permissions and some was denied");
    IPermission.Callback localCallback = this.b;
    int i = this.c;
    paramList = ((Collection)paramList).toArray(new String[0]);
    if (paramList != null)
    {
      localCallback.a(i, (String[])paramList, CollectionsKt.toIntArray((Collection)paramList1));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PermissionImpl.requestPermission.dialogCallback.1
 * JD-Core Version:    0.7.0.1
 */