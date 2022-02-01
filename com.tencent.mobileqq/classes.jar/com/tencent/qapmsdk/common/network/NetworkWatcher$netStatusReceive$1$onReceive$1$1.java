package com.tencent.qapmsdk.common.network;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
final class NetworkWatcher$netStatusReceive$1$onReceive$1$1
  implements Runnable
{
  public static final 1 INSTANCE = new 1();
  
  public final void run()
  {
    NetworkWatcher.access$checkConnInfo(NetworkWatcher.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.network.NetworkWatcher.netStatusReceive.1.onReceive.1.1
 * JD-Core Version:    0.7.0.1
 */