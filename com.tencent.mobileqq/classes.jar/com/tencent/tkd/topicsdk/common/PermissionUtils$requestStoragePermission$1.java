package com.tencent.tkd.topicsdk.common;

import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.events.StoragePermissionEvent;
import com.tencent.tkd.topicsdk.interfaces.IPermission.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "requestCode", "", "permissions", "", "", "kotlin.jvm.PlatformType", "results", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"}, k=3, mv={1, 1, 16})
final class PermissionUtils$requestStoragePermission$1
  implements IPermission.Callback
{
  PermissionUtils$requestStoragePermission$1(Function1 paramFunction1) {}
  
  public final void a(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "permissions");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "results");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 3)
    {
      if (paramArrayOfString.length == 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      bool1 = bool2;
      if ((paramInt ^ 0x1) != 0)
      {
        bool1 = bool2;
        if (Intrinsics.areEqual(paramArrayOfString[0], "android.permission.READ_EXTERNAL_STORAGE"))
        {
          if (paramArrayOfInt.length == 0) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          bool1 = bool2;
          if ((paramInt ^ 0x1) != 0)
          {
            bool1 = bool2;
            if (paramArrayOfInt[0] == 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    paramArrayOfString = this.a;
    if (paramArrayOfString != null) {
      paramArrayOfString = (Unit)paramArrayOfString.invoke(Boolean.valueOf(true));
    }
    DispatchManager.a.a((IEvent)new StoragePermissionEvent(bool1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.PermissionUtils.requestStoragePermission.1
 * JD-Core Version:    0.7.0.1
 */