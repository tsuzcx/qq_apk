package com.tencent.proxyinner.channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import com.tencent.proxyinner.log.XLog;
import java.util.ArrayList;
import java.util.List;

public class PluginChannel
{
  static final String TAG = "XProxy|PluginChannel";
  Context mContext;
  List<Event> mEventListener = new ArrayList();
  String mHostType;
  String mPluginId;
  private BroadcastReceiver pluginProcReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent == null)
      {
        Log.i("XProxy|PluginChannel", "收到插件进程的广播　intent = null");
        return;
      }
      Log.i("XProxy|PluginChannel", "收到插件进程的广播 action = " + paramAnonymousIntent.getAction());
      PluginChannel.this.onRecvMessage(paramAnonymousIntent.getAction(), paramAnonymousIntent.getExtras());
    }
  };
  public RemoteMessageSender sender;
  
  public PluginChannel()
  {
    if (this.mContext != null) {
      this.mContext.unregisterReceiver(this.pluginProcReceiver);
    }
  }
  
  private String getCmd(String paramString)
  {
    return paramString.substring(0, paramString.indexOf("|"));
  }
  
  private String getSendCmd(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new StringBuffer(paramString1);
    paramString1.append("|");
    paramString1.append(paramString2);
    paramString1.append("|");
    paramString1.append(paramString3);
    return paramString1.toString();
  }
  
  public void addEventListener(Event paramEvent)
  {
    if (!this.mEventListener.contains(paramEvent)) {
      this.mEventListener.add(paramEvent);
    }
  }
  
  public void create(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.sender = new RemoteMessageSender(this.mContext);
    this.mPluginId = paramString1;
    this.mHostType = paramString2;
  }
  
  public void destroy()
  {
    if (this.mContext != null)
    {
      this.mContext.unregisterReceiver(this.pluginProcReceiver);
      this.mContext = null;
    }
    this.mEventListener.clear();
  }
  
  public Bundle onRecvMessage(String paramString, Bundle paramBundle)
  {
    if (this.mEventListener != null)
    {
      int i = 0;
      while (i < this.mEventListener.size())
      {
        ((Event)this.mEventListener.get(i)).onRemoteRequest(getCmd(paramString), paramBundle);
        i += 1;
      }
    }
    return null;
  }
  
  public void register(String paramString)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(getSendCmd(paramString, this.mPluginId, this.mHostType));
    this.mContext.registerReceiver(this.pluginProcReceiver, localIntentFilter);
  }
  
  public void removeEventListener(Event paramEvent)
  {
    this.mEventListener.remove(paramEvent);
  }
  
  public void sendMessage(String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent(getSendCmd(paramString, this.mPluginId, this.mHostType));
    localIntent.setPackage(this.mContext.getPackageName());
    localIntent.putExtras(paramBundle);
    XLog.i("XProxy | XStub", "sendMessage cmd = " + getSendCmd(paramString, this.mPluginId, this.mHostType));
    this.mContext.sendBroadcast(localIntent);
  }
  
  public void start()
  {
    XLog.i("XProxy|PluginChannel", "start");
  }
  
  public void stop()
  {
    XLog.i("XProxy|PluginChannel", "stop");
  }
  
  public void unRegisterAllCmd() {}
  
  public static abstract interface Event
  {
    public abstract void onRemoteRequest(String paramString, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.channel.PluginChannel
 * JD-Core Version:    0.7.0.1
 */