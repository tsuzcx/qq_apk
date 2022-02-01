package com.tencent.mobileqq.uniformdownload.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class UniformDownloadMgr$1$1
  extends BroadcastReceiver
{
  UniformDownloadMgr$1$1(UniformDownloadMgr.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getBundleExtra("param");
    paramIntent = paramIntent.getStringExtra("param");
    UniformDownloadMgr.a().b(paramIntent, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.1.1
 * JD-Core Version:    0.7.0.1
 */