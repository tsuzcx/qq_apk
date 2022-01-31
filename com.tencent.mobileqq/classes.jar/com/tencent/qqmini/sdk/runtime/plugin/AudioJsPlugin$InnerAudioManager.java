package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bgkk;
import bgkz;
import bhge;
import bhgg;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class AudioJsPlugin$InnerAudioManager
  implements bhgg
{
  private JSONObject audioContext = new JSONObject();
  public int audioId;
  private volatile boolean isStart;
  private long lastStartTime;
  private bhge mPlayer;
  private String src = "";
  private int startTime;
  
  public AudioJsPlugin$InnerAudioManager(AudioJsPlugin paramAudioJsPlugin) {}
  
  private void destroy()
  {
    release();
  }
  
  private void evaluateAudioState(String paramString)
  {
    paramString = bgkz.a(null, "state", paramString);
    bgkz.a(paramString, "audioId", Integer.valueOf(this.audioId));
    AudioJsPlugin.access$2300(this.this$0, "onAudioStateChange", paramString.toString());
  }
  
  private void evaluateErrorCallback(int paramInt1, int paramInt2)
  {
    int i = -1;
    paramInt2 = i;
    switch (paramInt1)
    {
    default: 
      paramInt2 = i;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("state", "Error");
        localJSONObject.put("audioId", this.audioId);
        localJSONObject.put("errCode", paramInt2);
        AudioJsPlugin.access$2400(this.this$0, "onAudioStateChange", localJSONObject.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      paramInt2 = 10002;
      continue;
      paramInt2 = 10001;
      continue;
      paramInt2 = 10003;
    }
  }
  
  private int getCurrentPosition()
  {
    int i = 0;
    if (this.mPlayer != null) {
      i = this.mPlayer.c();
    }
    return i;
  }
  
  private int getDuration()
  {
    int i = 0;
    if (this.mPlayer != null) {
      i = this.mPlayer.b();
    }
    return i;
  }
  
  private boolean isPaused()
  {
    return (this.mPlayer == null) || (!this.mPlayer.a());
  }
  
  private void pause()
  {
    long l = System.currentTimeMillis() - this.lastStartTime;
    if (l < 50L) {
      bgkk.a(new AudioJsPlugin.InnerAudioManager.2(this), 50L - l);
    }
    while ((this.mPlayer == null) || (!this.mPlayer.a())) {
      return;
    }
    this.mPlayer.a();
  }
  
  private void play()
  {
    boolean bool = true;
    if ((this.mPlayer != null) && ((this.mPlayer.b()) || (this.mPlayer.c())))
    {
      bhge localbhge = this.mPlayer;
      if (!AudioJsPlugin.access$2200()) {}
      for (;;)
      {
        localbhge.a(bool);
        this.mPlayer.d();
        return;
        bool = false;
      }
    }
    playNew(true);
  }
  
  private void playNew(boolean paramBoolean)
  {
    String str;
    int i;
    boolean bool;
    double d;
    if (this.audioContext != null)
    {
      str = this.audioContext.optString("src");
      i = this.audioContext.optInt("startTime");
      bool = this.audioContext.optBoolean("loop");
      d = this.audioContext.optDouble("volume");
      if (!TextUtils.isEmpty(str)) {}
    }
    else
    {
      return;
    }
    if (this.mPlayer == null) {
      this.mPlayer = new bhge(ThreadManager.a());
    }
    if ((this.mPlayer.a()) && (this.src.equals(str)) && (this.startTime == i))
    {
      this.mPlayer.a((float)d);
      this.mPlayer.b(bool);
      return;
    }
    this.src = str;
    this.startTime = i;
    this.mPlayer.a(this);
    this.mPlayer.a(AppLoaderFactory.g().getContext());
    this.mPlayer.a(this.startTime);
    this.mPlayer.a(this.src, new AudioJsPlugin.InnerAudioManager.1(this, paramBoolean, bool, d));
    this.lastStartTime = System.currentTimeMillis();
  }
  
  private void release()
  {
    if (this.mPlayer != null)
    {
      this.mPlayer.c();
      this.mPlayer = null;
    }
  }
  
  private void seek(int paramInt)
  {
    long l = System.currentTimeMillis() - this.lastStartTime;
    if (l < 100L) {
      bgkk.a(new AudioJsPlugin.InnerAudioManager.3(this, paramInt), 100L - l);
    }
    while (this.mPlayer == null) {
      return;
    }
    this.mPlayer.b(paramInt);
  }
  
  private void stop()
  {
    if (this.mPlayer != null) {
      this.mPlayer.b();
    }
  }
  
  public JSONObject getAudioContext()
  {
    return this.audioContext;
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    evaluateErrorCallback(paramInt1, paramInt2);
  }
  
  public void onPlayerBufferingUpdate(int paramInt) {}
  
  public void onPlayerProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (this.isStart) {
      evaluateAudioState("TimeUpdate");
    }
  }
  
  public void onPlayerSeek(boolean paramBoolean, int paramInt)
  {
    QMLog.i("AudioJsPlugin", "onPlayerSeek Completed : " + paramBoolean + "; position : " + paramInt);
    if (paramBoolean) {}
    for (String str = "Seeked";; str = "Seeking")
    {
      evaluateAudioState(str);
      return;
    }
  }
  
  public void onPlayerStateChange(int paramInt)
  {
    if (paramInt == 0) {
      evaluateAudioState("Waiting");
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        evaluateAudioState("Canplay");
        return;
      }
      if (paramInt == 2)
      {
        this.isStart = true;
        evaluateAudioState("Play");
        return;
      }
      if (paramInt == 3)
      {
        this.isStart = false;
        evaluateAudioState("Pause");
        return;
      }
      if (paramInt == 4)
      {
        this.isStart = false;
        evaluateAudioState("Stop");
        return;
      }
    } while (paramInt != 5);
    this.isStart = false;
    evaluateAudioState("Ended");
    release();
  }
  
  public void setAudioContext(JSONObject paramJSONObject)
  {
    this.audioContext = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.AudioJsPlugin.InnerAudioManager
 * JD-Core Version:    0.7.0.1
 */