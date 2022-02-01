package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.QQPermissionCallback;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/ChooseCoverController$openCamera$1", "Lmqq/app/QQPermissionCallback;", "deny", "", "i", "", "strings", "", "", "ints", "", "(I[Ljava/lang/String;[I)V", "grant", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class ChooseCoverController$openCamera$1
  implements QQPermissionCallback
{
  public void deny(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    DialogUtil.a((Activity)ChooseCoverController.c(this.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    ChooseCoverController.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.ChooseCoverController.openCamera.1
 * JD-Core Version:    0.7.0.1
 */