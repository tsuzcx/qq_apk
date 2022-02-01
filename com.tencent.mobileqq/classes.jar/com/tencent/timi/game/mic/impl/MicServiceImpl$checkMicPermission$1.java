package com.tencent.timi.game.mic.impl;

import com.tencent.timi.game.mic.api.CheckMicPermissionCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.QQPermissionCallback;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/mic/impl/MicServiceImpl$checkMicPermission$1", "Lmqq/app/QQPermissionCallback;", "deny", "", "i", "", "strings", "", "", "ints", "", "(I[Ljava/lang/String;[I)V", "grant", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MicServiceImpl$checkMicPermission$1
  implements QQPermissionCallback
{
  MicServiceImpl$checkMicPermission$1(CheckMicPermissionCallback paramCheckMicPermissionCallback) {}
  
  public void deny(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    paramArrayOfString = this.a;
    if (paramArrayOfString != null) {
      paramArrayOfString.a(false);
    }
  }
  
  public void grant(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    paramArrayOfString = this.a;
    if (paramArrayOfString != null) {
      paramArrayOfString.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.mic.impl.MicServiceImpl.checkMicPermission.1
 * JD-Core Version:    0.7.0.1
 */