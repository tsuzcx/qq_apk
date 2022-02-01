package com.tencent.mobileqq.wxapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.openapi.IWXAPI;

class WXShareHelper$2
  extends BroadcastReceiver
{
  WXShareHelper$2(WXShareHelper paramWXShareHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (WXShareHelper.access$100(this.this$0) != null) {
      WXShareHelper.access$100(this.this$0).handleIntent(paramIntent, this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXShareHelper.2
 * JD-Core Version:    0.7.0.1
 */