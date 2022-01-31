package com.tencent.qqmini.sdk.runtime.plugin;

import android.util.Log;
import bgok;
import com.tencent.qqmini.sdk.core.model.SongInfo;
import com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxy.MusicPlayerListener;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class AudioJsPlugin$1
  implements MusicPlayerProxy.MusicPlayerListener
{
  AudioJsPlugin$1(AudioJsPlugin paramAudioJsPlugin) {}
  
  private int convertErrorCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 5: 
      return 10001;
    case 7: 
      return 10003;
    }
    return 10002;
  }
  
  private void onMusicCanplay()
  {
    Log.i("AudioJsPlugin", "onMusicCanplay: " + Thread.currentThread().getId());
    AudioJsPlugin.access$2800(this.this$0, "canplay");
  }
  
  private void onMusicError()
  {
    QMLog.i("AudioJsPlugin", "onMusicError " + AudioJsPlugin.access$3300(this.this$0));
    if (AudioJsPlugin.access$3300(this.this$0) == 5) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "error");
      localJSONObject.put("errorCode", convertErrorCode(AudioJsPlugin.access$3300(this.this$0)));
      AudioJsPlugin.access$4100(this.this$0, "onBackgroundAudioStateChange", localJSONObject.toString());
      AudioJsPlugin.access$3400(this.this$0).b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void onMusicPause()
  {
    AudioJsPlugin.access$3900(this.this$0, "onMusicPause", null);
    AudioJsPlugin.access$2800(this.this$0, "pause");
    AudioJsPlugin.access$3400(this.this$0).a();
  }
  
  private void onMusicPlay()
  {
    try
    {
      Thread.sleep(500L);
      label6:
      localObject3 = null;
      try
      {
        JSONObject localJSONObject = AudioJsPlugin.access$3700(this.this$0);
        localObject1 = localObject3;
        if (localJSONObject != null) {
          localObject1 = localJSONObject.toString();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Log.w("AudioJsPlugin", "onMusicPlay: ", localException);
          Object localObject2 = localObject3;
        }
      }
      Log.i("AudioJsPlugin", "onMusicPlay: " + (String)localObject1);
      AudioJsPlugin.access$3800(this.this$0, "onMusicPlay", (String)localObject1);
      AudioJsPlugin.access$2800(this.this$0, "play");
      AudioJsPlugin.access$3400(this.this$0).a();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Object localObject3;
      break label6;
    }
  }
  
  private void onMusicStop()
  {
    AudioJsPlugin.access$4000(this.this$0, "onMusicEnd", null);
    AudioJsPlugin.access$2800(this.this$0, "stop");
    AudioJsPlugin.access$3400(this.this$0).a();
  }
  
  private void onMusicWaiting()
  {
    AudioJsPlugin.access$2800(this.this$0, "waiting");
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    if (localMusicPlayerProxy != null) {
      AudioJsPlugin.access$3602(this.this$0, localMusicPlayerProxy.getCurrentSong());
    }
    onMusicStop();
    QMLog.i("AudioJsPlugin", "onPlaySongChanged title:" + paramSongInfo.c + " url:" + paramSongInfo.b);
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    AudioJsPlugin.access$3302(this.this$0, paramInt);
    switch (AudioJsPlugin.access$3300(this.this$0))
    {
    default: 
      return;
    case 2: 
      onMusicPlay();
      onMusicCanplay();
      return;
    case 3: 
      onMusicPause();
      AudioJsPlugin.access$3502(this.this$0, Math.max(localMusicPlayerProxy.getCurrentSongPosition(), 0));
      return;
    case 4: 
      onMusicStop();
      return;
    case 5: 
    case 6: 
    case 7: 
      onMusicError();
      return;
    case 1: 
      onMusicWaiting();
      return;
    }
    AudioJsPlugin.access$2800(this.this$0, "ended");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.AudioJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */