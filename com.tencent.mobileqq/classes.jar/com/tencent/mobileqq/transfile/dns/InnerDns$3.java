package com.tencent.mobileqq.transfile.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class InnerDns$3
  extends BroadcastReceiver
{
  InnerDns$3(InnerDns paramInnerDns) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.innerdns.domainAddressDataUpdateAction".equals(paramIntent.getAction())) {
      InnerDns.access$200(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.InnerDns.3
 * JD-Core Version:    0.7.0.1
 */