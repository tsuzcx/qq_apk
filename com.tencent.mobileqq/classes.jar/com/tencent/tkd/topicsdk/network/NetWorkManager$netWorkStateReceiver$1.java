package com.tencent.tkd.topicsdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/network/NetWorkManager$netWorkStateReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class NetWorkManager$netWorkStateReceiver$1
  extends BroadcastReceiver
{
  public void onReceive(@NotNull Context paramContext, @Nullable Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    NetWorkManager.a(NetWorkManager.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.network.NetWorkManager.netWorkStateReceiver.1
 * JD-Core Version:    0.7.0.1
 */