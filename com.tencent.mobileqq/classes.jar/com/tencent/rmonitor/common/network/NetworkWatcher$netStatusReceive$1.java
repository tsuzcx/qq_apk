package com.tencent.rmonitor.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/rmonitor/common/network/NetworkWatcher$netStatusReceive$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class NetworkWatcher$netStatusReceive$1
  extends BroadcastReceiver
{
  public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    paramContext = NetworkWatcher.a(NetworkWatcher.a);
    if (paramContext != null) {
      paramContext = (Context)paramContext.get();
    } else {
      paramContext = null;
    }
    if (paramContext != null)
    {
      paramContext = NetworkWatcher.b(NetworkWatcher.a);
      if (paramContext != null) {
        paramContext.post((Runnable)NetworkWatcher.netStatusReceive.1.onReceive.1.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.network.NetworkWatcher.netStatusReceive.1
 * JD-Core Version:    0.7.0.1
 */