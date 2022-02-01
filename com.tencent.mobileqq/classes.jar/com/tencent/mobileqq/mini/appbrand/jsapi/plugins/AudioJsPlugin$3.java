package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.util.Log;
import axqq;
import axqs;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AudioJsPlugin$3
  extends axqq
{
  AudioJsPlugin$3(AudioJsPlugin paramAudioJsPlugin) {}
  
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
    Log.i("[mini] AudioJsPlugin", "onMusicCanplay: " + Thread.currentThread().getId());
    AudioJsPlugin.access$2300(this.this$0, "canplay");
  }
  
  private void onMusicError()
  {
    QLog.i("[mini] AudioJsPlugin", 2, "onMusicError " + AudioJsPlugin.access$3000(this.this$0));
    if (AudioJsPlugin.access$3000(this.this$0) == 5) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "error");
      localJSONObject.put("errorCode", convertErrorCode(AudioJsPlugin.access$3000(this.this$0)));
      AudioJsPlugin.access$1600(this.this$0, "onBackgroundAudioStateChange", localJSONObject.toString());
      AudioJsPlugin.access$2400(this.this$0, false, AudioJsPlugin.access$3100(this.this$0));
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
    AudioJsPlugin.access$3500(this.this$0, "onMusicPause");
    AudioJsPlugin.access$2300(this.this$0, "pause");
    AudioJsPlugin.access$2400(this.this$0, true, AudioJsPlugin.access$3100(this.this$0));
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
        JSONObject localJSONObject = AudioJsPlugin.access$3400(this.this$0);
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
          Log.w("[mini] AudioJsPlugin", "onMusicPlay: ", localException);
          Object localObject2 = localObject3;
        }
      }
      Log.i("[mini] AudioJsPlugin", "onMusicPlay: " + (String)localObject1);
      AudioJsPlugin.access$1600(this.this$0, "onMusicPlay", (String)localObject1);
      AudioJsPlugin.access$2300(this.this$0, "play");
      AudioJsPlugin.access$2400(this.this$0, true, AudioJsPlugin.access$3100(this.this$0));
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
    AudioJsPlugin.access$3500(this.this$0, "onMusicEnd");
    AudioJsPlugin.access$2300(this.this$0, "stop");
    AudioJsPlugin.access$2400(this.this$0, true, AudioJsPlugin.access$3100(this.this$0));
  }
  
  private void onMusicWaiting()
  {
    AudioJsPlugin.access$2300(this.this$0, "waiting");
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if (AudioJsPlugin.access$2200(this.this$0) != null) {
      AudioJsPlugin.access$3602(this.this$0, AudioJsPlugin.access$2200(this.this$0).a());
    }
    onMusicStop();
    QLog.i("[mini] AudioJsPlugin", 2, "onPlaySongChanged title:" + paramSongInfo.c + " url:" + paramSongInfo.b);
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((AudioJsPlugin.access$2200(this.this$0) == null) || ((AudioJsPlugin.access$2200(this.this$0).a() != null) && (!AudioJsPlugin.access$2200(this.this$0).a().equals(AudioJsPlugin.access$2500(this.this$0))))) {
      return;
    }
    AudioJsPlugin.access$3002(this.this$0, paramInt);
    switch (AudioJsPlugin.access$3000(this.this$0))
    {
    default: 
      return;
    case 1: 
      onMusicWaiting();
      return;
    case 2: 
      onMusicPlay();
      onMusicCanplay();
      return;
    case 3: 
      onMusicPause();
      AudioJsPlugin.access$3302(this.this$0, Math.max(AudioJsPlugin.access$2200(this.this$0).g(), 0));
      return;
    case 4: 
      onMusicStop();
      return;
    case 5: 
    case 6: 
    case 7: 
      onMusicError();
      return;
    }
    AudioJsPlugin.access$2300(this.this$0, "ended");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */