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
    QLog.i("GroupVideoManager|Communicate", 2, "get message from plugin: " + paramIntent.getExtras());
    switch (i)
    {
    case 4: 
    default: 
      return;
    case 1: 
      CommunicateWithPluginHandler.a(this.a, paramIntent, CommunicateWithPluginHandler.a(this.a));
      return;
    case 2: 
      CommunicateWithPluginHandler.a(this.a, paramIntent, CommunicateWithPluginHandler.b(this.a));
      return;
    case 3: 
      CommunicateWithPluginHandler.a(this.a, paramIntent);
      return;
    }
    CommunicateWithPluginHandler.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.CommunicateWithPluginHandler.2
 * JD-Core Version:    0.7.0.1
 */