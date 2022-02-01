package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class CommunicateWithPluginHandler$2
  extends BroadcastReceiver
{
  CommunicateWithPluginHandler$2(CommunicateWithPluginHandler paramCommunicateWithPluginHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("command_type", 0);
    paramContext = new StringBuilder();
    paramContext.append("get message from plugin: ");
    paramContext.append(paramIntent.getExtras());
    QLog.i("GroupVideoManager|Communicate", 2, paramContext.toString());
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5) {
            return;
          }
          CommunicateWithPluginHandler.c(this.a);
          return;
        }
        CommunicateWithPluginHandler.a(this.a, paramIntent);
        return;
      }
      paramContext = this.a;
      CommunicateWithPluginHandler.a(paramContext, paramIntent, CommunicateWithPluginHandler.b(paramContext));
      return;
    }
    paramContext = this.a;
    CommunicateWithPluginHandler.a(paramContext, paramIntent, CommunicateWithPluginHandler.a(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.CommunicateWithPluginHandler.2
 * JD-Core Version:    0.7.0.1
 */