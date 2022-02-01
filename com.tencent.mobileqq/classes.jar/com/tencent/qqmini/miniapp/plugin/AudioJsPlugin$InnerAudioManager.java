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
    if (paramInt1 != -1010)
    {
      if (paramInt1 != -1007) {
        if ((paramInt1 != -1004) && (paramInt1 != -110))
        {
          paramInt2 = i;
          if (paramInt1 == 1) {
            break label72;
          }
          if ((paramInt1 != 100) && (paramInt1 != 200))
          {
            paramInt2 = i;
            break label72;
          }
        }
        else
        {
          paramInt2 = 10002;
          break label72;
        }
      }
      paramInt2 = 10001;
    }
    else
    {
      paramInt2 = 10003;
    }
    try
    {
      label72:
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
  }
  
  private int getCurrentPosition()
  {
    MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
    if (localMiniAppAudioPlayer != null) {
      return localMiniAppAudioPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  private int getDuration()
  {
    MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
    if (localMiniAppAudioPlayer != null) {
      return localMiniAppAudioPlayer.getDuration();
    }
    return 0;
  }
  
  private boolean isPaused()
  {
    MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
    return (localMiniAppAudioPlayer == null) || (!localMiniAppAudioPlayer.isPlaying());
  }
  
  private void pause()
  {
    long l = System.currentTimeMillis() - this.lastStartTime;
    if (l < 50L)
    {
      AppBrandTask.runTaskOnUiThreadDelay(new AudioJsPlugin.InnerAudioManager.2(this), 50L - l);
      return;
    }
    MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
    if ((localMiniAppAudioPlayer != null) && (localMiniAppAudioPlayer.isPlaying())) {
      this.mPlayer.pause();
    }
  }
  
  private void play()
  {
    MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
    if ((localMiniAppAudioPlayer != null) && ((localMiniAppAudioPlayer.isPaused()) || (this.mPlayer.isPrepared())))
    {
      this.mPlayer.setAudioFocus(true ^ AudioJsPlugin.access$3400());
      this.mPlayer.start();
      return;
    }
    playNew(true, null);
  }
  
  private void playNew(boolean paramBoolean, MiniAppAudioPlayer.OnPreparedListener paramOnPreparedListener)
  {
    Object localObject = this.audioContext;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("src");
      int i = this.audioContext.optInt("startTime");
      boolean bool = this.audioContext.optBoolean("loop");
      double d = this.audioContext.optDouble("volume");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      if (this.mPlayer == null) {
        this.mPlayer = new MiniAppAudioPlayer(ThreadManager.getSubThreadHandler());
      }
      if ((this.mPlayer.isPlaying()) && (this.src.equals(localObject)) && (this.startTime == i))
      {
        this.mPlayer.setVolume((float)d);
        this.mPlayer.setLooping(bool);
        return;
      }
      this.src = ((String)localObject);
      this.startTime = i;
      this.mPlayer.setAudioPlayerListener(this);
      this.mPlayer.setAudioContext(AppLoaderFactory.g().getContext());
      this.mPlayer.setStartTime(this.startTime);
      this.mPlayer.setDataSource(this.src, new AudioJsPlugin.InnerAudioManager.1(this, paramBoolean, bool, d, paramOnPreparedListener));
      this.lastStartTime = System.currentTimeMillis();
    }
  }
  
  private void release()
  {
    MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
    if (localMiniAppAudioPlayer != null)
    {
      localMiniAppAudioPlayer.release();
      this.mPlayer = null;
    }
  }
  
  private void seek(int paramInt)
  {
    long l = System.currentTimeMillis() - this.lastStartTime;
    if (l < 100L)
    {
      AppBrandTask.runTaskOnUiThreadDelay(new AudioJsPlugin.InnerAudioManager.3(this, paramInt), 100L - l);
      return;
    }
    MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
    if (localMiniAppAudioPlayer != null) {
      localMiniAppAudioPlayer.seekTo(paramInt);
    }
  }
  
  private void stop()
  {
    MiniAppAudioPlayer localMiniAppAudioPlayer = this.mPlayer;
    if (localMiniAppAudioPlayer != null) {
      localMiniAppAudioPlayer.stop();
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayerSeek Completed : ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("; position : ");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.i("AudioJsPlugin", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = "Seeked";
    } else {
      localObject = "Seeking";
    }
    evaluateAudioState((String)localObject);
  }
  
  public void onPlayerStateChange(int paramInt)
  {
    if (paramInt == 0)
    {
      evaluateAudioState("Waiting");
      return;
    }
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
    if (paramInt == 5)
    {
      this.isStart = false;
      evaluateAudioState("Ended");
      release();
    }
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