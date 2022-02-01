package com.tencent.mobileqq.transfile.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class BaseInnerDns$3
  extends BroadcastReceiver
{
  BaseInnerDns$3(BaseInnerDns paramBaseInnerDns) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.innerdns.domainAddressDataUpdateAction".equals(paramIntent.getAction())) {
      BaseInnerDns.access$200(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.BaseInnerDns.3
 * JD-Core Version:    0.7.0.1
 */