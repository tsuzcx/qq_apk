package com.tencent.mtt.hippy.modules.nativemodules.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter;
import java.util.concurrent.Executor;

class NetInfoModule$a
  extends BroadcastReceiver
{
  private final String b = "networkStatusDidChange";
  private boolean c = false;
  private String d;
  
  private NetInfoModule$a(NetInfoModule paramNetInfoModule) {}
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
      NetInfoModule.c(this.a).getGlobalConfigs().getExecutorSupplierAdapter().getBackgroundTaskExecutor().execute(new NetInfoModule.a.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.netinfo.NetInfoModule.a
 * JD-Core Version:    0.7.0.1
 */