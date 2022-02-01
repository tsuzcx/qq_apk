package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer;
import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.AudioPlayerListener;
import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AudioJsPlugin$InnerAudioManager
  implements MiniAppAudioPlayer.AudioPlayerListener
{
  private JSONObject audioContext = new JSONObject();
  public int audioId;
  private volatile boolean isStart;
  private long lastStartTime;
  private MiniAppAudioPlayer mPlayer;
  private String src = "";
  private int startTime;
  
  public AudioJsPlugin$InnerAudioManager(AudioJsPlugin paramAudioJsPlugin) {}
  
  private void destroy()
  {
    release();
  }
  
  private void evaluateAudioState(String paramString)
  {
    paramString = JSONUtil.append(null, "state", paramString);
    JSONUtil.append(paramString, "audioId", Integer.valueOf(this.audioId));
    AudioJsPlugin.access$3500(this.this$0, "onAudioStateChange", paramString.toString());
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
        AudioJsPlugin.access$3600(this.this$0, "onAudioStateChange", localJSONObject.toString());
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
      i = this.mPlayer.getCurrentPosition();
    }
    return i;
  }
  
  private int getDuration()
  {
    int i = 0;
    if (this.mPlayer != null) {
      i = this.mPlayer.getDuration();
    }
    return i;
  }
  
  private boolean isPaused()
  {
    return (this.mPlayer == null) || (!this.mPlayer.isPlaying());
  }
  
  private void pause()
  {
    long l = System.currentTimeMillis() - this.lastStartTime;
    if (l < 50L) {
      AppBrandTask.runTaskOnUiThreadDelay(new AudioJsPlugin.InnerAudioManager.2(this), 50L - l);
    }
    while ((this.mPlayer == null) || (!this.mPlayer.isPlaying())) {
      return;
    }
    this.mPlayer.pause();
  }
  
  private void play()
  {
    boolean bool = true;
    if ((this.mPlayer != null) && ((this.mPlayer.isPaused()) || (this.mPlayer.isPrepared())))
    {
      MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
      if (!AudioJsPlugin.access$3400()) {}
      for (;;)
      {
        localMiniAppAudioPlayer.setAudioFocus(bool);
        this.mPlayer.start();
        return;
        bool = false;
      }
    }
    playNew(true, null);
  }
  
  private void playNew(boolean paramBoolean, MiniAppAudioPlayer.OnPreparedListener paramOnPreparedListener)
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
      this.mPlayer = new MiniAppAudioPlayer(ThreadManager.getSubThreadHandler());
    }
    if ((this.mPlayer.isPlaying()) && (this.src.equals(str)) && (this.startTime == i))
    {
      this.mPlayer.setVolume((float)d);
      this.mPlayer.setLooping(bool);
      return;
    }
    this.src = str;
    this.startTime = i;
    this.mPlayer.setAudioPlayerListener(this);
    this.mPlayer.setAudioContext(AppLoaderFactory.g().getContext());
    this.mPlayer.setStartTime(this.startTime);
    this.mPlayer.setDataSource(this.src, new AudioJsPlugin.InnerAudioManager.1(this, paramBoolean, bool, d, paramOnPreparedListener));
    this.lastStartTime = System.currentTimeMillis();
  }
  
  private void release()
  {
    if (this.mPlayer != null)
    {
      this.mPlayer.release();
      this.mPlayer = null;
    }
  }
  
  private void seek(int paramInt)
  {
    long l = System.currentTimeMillis() - this.lastStartTime;
    if (l < 100L) {
      AppBrandTask.runTaskOnUiThreadDelay(new AudioJsPlugin.InnerAudioManager.3(this, paramInt), 100L - l);
    }
    while (this.mPlayer == null) {
      return;
    }
    this.mPlayer.seekTo(paramInt);
  }
  
  private void stop()
  {
    if (this.mPlayer != null) {
      this.mPlayer.stop();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.InnerAudioManager
 * JD-Core Version:    0.7.0.1
 */