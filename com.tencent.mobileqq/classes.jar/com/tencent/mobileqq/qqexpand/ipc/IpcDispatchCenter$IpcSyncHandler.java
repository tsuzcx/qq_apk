package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/ipc/IpcDispatchCenter$IpcSyncHandler;", "", "handleMessage", "Landroid/os/Bundle;", "message", "", "params", "callbackId", "", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IpcDispatchCenter$IpcSyncHandler
{
  @NotNull
  public abstract Bundle a(@NotNull String paramString, @Nullable Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.IpcDispatchCenter.IpcSyncHandler
 * JD-Core Version:    0.7.0.1
 */