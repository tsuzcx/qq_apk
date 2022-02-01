package com.tencent.mobileqq.musicgene;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.IQQPlayerService.Stub;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class MusicGeneWebViewPlugin$1
  implements ServiceConnection
{
  MusicGeneWebViewPlugin$1(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    MusicGeneWebViewPlugin.a(this.a, IQQPlayerService.Stub.a(paramIBinder));
    try
    {
      MusicGeneWebViewPlugin.b(this.a).a(MusicGeneWebViewPlugin.a(this.a));
      if (MusicGeneWebViewPlugin.c(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        MusicGeneWebViewPlugin.c(this.a).a(paramComponentName);
        MusicGeneWebViewPlugin.a(this.a, null);
        return;
      }
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (MusicGeneWebViewPlugin.b(this.a) != null) {
        MusicGeneWebViewPlugin.b(this.a).b(MusicGeneWebViewPlugin.a(this.a));
      }
      if (MusicGeneWebViewPlugin.c(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        MusicGeneWebViewPlugin.c(this.a).a(paramComponentName);
        MusicGeneWebViewPlugin.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
    MusicGeneWebViewPlugin.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.1
 * JD-Core Version:    0.7.0.1
 */