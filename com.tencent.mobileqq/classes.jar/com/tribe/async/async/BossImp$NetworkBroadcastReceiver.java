package com.tribe.async.async;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class BossImp$NetworkBroadcastReceiver
  extends BroadcastReceiver
{
  private BossImp$NetworkBroadcastReceiver(BossImp paramBossImp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    BossImp.access$300(this.this$0).setCorePoolSize(BossImp.access$200(this.this$0).getCore());
    BossImp.access$300(this.this$0).setMaximumPoolSize(BossImp.access$200(this.this$0).getMaximum());
    BossImp.access$300(this.this$0).setKeepAliveTime(BossImp.access$200(this.this$0).getAliveTime(), BossImp.access$200(this.this$0).getTimeUnit());
  }
  
  public void register(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.AIRPLANE_MODE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter);
  }
  
  void unregister(Context paramContext)
  {
    paramContext.unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.async.BossImp.NetworkBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */