package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.msf.sdk.b.e.c;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class t
  extends BroadcastReceiver
{
  t(MsfServiceSdk paramMsfServiceSdk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.msf.ACTION_MSF_IPC_EXCEPTION".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("process");
      if ((paramContext != null) && (paramContext.equals(BaseApplication.processName))) {}
    }
    else
    {
      return;
    }
    String str1 = paramIntent.getStringExtra("uin");
    String str2 = paramIntent.getStringExtra("type");
    String str3 = paramIntent.getStringExtra("exception");
    String str4 = paramIntent.getStringExtra("isAppConnected");
    String str5 = paramIntent.getStringExtra("halfCloseStatus");
    paramIntent.getStringExtra("processStatus");
    QLog.i("MsfServiceSdk", 1, "onReceive ACTION_MSF_IPC_EXCEPTION, type=" + str2 + " process=" + paramContext + " exception=" + str3 + " appConned=" + str4 + " halfClose=" + str5);
    MsfServiceSdk.access$000(this.a).registerMsfService(true, true);
    e.c.b().a(str1, str2, str3, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.t
 * JD-Core Version:    0.7.0.1
 */