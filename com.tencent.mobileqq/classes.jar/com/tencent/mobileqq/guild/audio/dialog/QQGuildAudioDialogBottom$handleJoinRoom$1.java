package com.tencent.mobileqq.guild.audio.dialog;

import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogBottom$handleJoinRoom$1", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "onAllGranted", "", "onDenied", "permissions", "", "", "results", "", "onDialogShow", "dialog", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "deniedPermissions", "onUncertain", "uncertainPermission", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildAudioDialogBottom$handleJoinRoom$1
  extends QQPermission.BasePermissionsListener
{
  public void a()
  {
    super.a();
    QQGuildAudioDialogBottom.c(this.a);
  }
  
  public void a(@NotNull PermissionRequestDialog paramPermissionRequestDialog, @NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramPermissionRequestDialog, "dialog");
    Intrinsics.checkParameterIsNotNull(paramList, "deniedPermissions");
    super.a(paramPermissionRequestDialog, paramList);
    QQGuildAudioDialogBottom.d(this.a);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uncertainPermission");
    super.a(paramString);
    QQGuildAudioDialogBottom.c(this.a);
    QQGuildAudioDialogBottom.d(this.a);
  }
  
  public void a(@NotNull List<String> paramList, @NotNull List<Integer> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "permissions");
    Intrinsics.checkParameterIsNotNull(paramList1, "results");
    super.a(paramList, paramList1);
    QQGuildAudioDialogBottom.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogBottom.handleJoinRoom.1
 * JD-Core Version:    0.7.0.1
 */