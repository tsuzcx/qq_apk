package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import asvl;
import asvm;
import com.tencent.qphone.base.util.QLog;

class AudioJsPlugin$1
  implements ServiceConnection
{
  AudioJsPlugin$1(AudioJsPlugin paramAudioJsPlugin) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AudioJsPlugin.access$2102(this.this$0, asvm.a(paramIBinder));
    try
    {
      if (AudioJsPlugin.access$2100(this.this$0) != null) {
        AudioJsPlugin.access$2100(this.this$0).a(AudioJsPlugin.access$3100(this.this$0));
      }
      if (paramIBinder != null) {
        paramIBinder.linkToDeath(new AudioJsPlugin.1.1(this, paramIBinder), 0);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.i("[mini] AudioJsPlugin", 2, "onServiceConnected " + paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.i("[mini] AudioJsPlugin", 2, "onServiceDisconnected " + paramComponentName);
    try
    {
      if (AudioJsPlugin.access$2100(this.this$0) != null)
      {
        AudioJsPlugin.access$2100(this.this$0).b(AudioJsPlugin.access$3100(this.this$0));
        AudioJsPlugin.access$2102(this.this$0, null);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.i("[mini] AudioJsPlugin", 2, "onServiceDisconnected " + paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */