package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.SongInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class AudioJsPlugin$BgMusicManager
{
  private static final int MSG_GET_MUSIC_PLAYER_STATE = 5;
  private static final int MSG_PAUSE = 2;
  private static final int MSG_PLAY = 1;
  private static final int MSG_SEEK = 4;
  private static final int MSG_STOP = 3;
  private MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
  
  private AudioJsPlugin$BgMusicManager(AudioJsPlugin paramAudioJsPlugin)
  {
    this.musicPlayerProxy.init(AudioJsPlugin.access$3700(paramAudioJsPlugin), AudioJsPlugin.access$3800(paramAudioJsPlugin).appId, AudioJsPlugin.access$3900(paramAudioJsPlugin).name);
  }
  
  private int convertState(int paramInt)
  {
    int i = 2;
    if (paramInt == 2) {
      i = 1;
    }
    while (paramInt != 3) {
      return i;
    }
    return 0;
  }
  
  private void getMusicPlayerState(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (AudioJsPlugin.access$4200(this.this$0) != null)
      {
        localJSONObject.put("currentPosition", AudioJsPlugin.access$4400(this.this$0, AudioJsPlugin.access$4300(this.this$0)));
        localJSONObject.put("duration", AudioJsPlugin.access$4400(this.this$0, AudioJsPlugin.access$4500(this.this$0)));
        localJSONObject.put("status", convertState(AudioJsPlugin.access$000(this.this$0)));
        localJSONObject.put("dataUrl", AudioJsPlugin.access$4200(this.this$0).url);
        paramRequestEvent.ok(localJSONObject);
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
    }
  }
  
  private void pauseQQMusic(RequestEvent paramRequestEvent)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    AudioJsPlugin.access$602(this.this$0, paramRequestEvent);
    try
    {
      localMusicPlayerProxy.pause();
      return;
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
    }
  }
  
  private void playNew(JSONObject paramJSONObject)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.id = System.currentTimeMillis();
    localSongInfo.url = paramJSONObject.optString("dataUrl", paramJSONObject.optString("src"));
    localSongInfo.title = paramJSONObject.optString("title");
    localSongInfo.album = paramJSONObject.optString("epname");
    localSongInfo.singer = paramJSONObject.optString("singer");
    localSongInfo.coverUrl = paramJSONObject.optString("coverImgUrl");
    localSongInfo.detailUrl = paramJSONObject.optString("webUrl");
    localSongInfo.type = 9;
    localSongInfo.startTime = (paramJSONObject.optInt("startTime", 0) * 1000);
    localSongInfo.fromMini = true;
    localMusicPlayerProxy.setPlayMode(100);
    localMusicPlayerProxy.startPlay(new SongInfo[] { localSongInfo }, 0);
  }
  
  private void playQQMusic(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    if ((!localMusicPlayerProxy.isInit()) || (paramJSONObject == null)) {
      paramRequestEvent.fail();
    }
    do
    {
      return;
      AudioJsPlugin.access$602(this.this$0, paramRequestEvent);
      try
      {
        SongInfo localSongInfo = localMusicPlayerProxy.getCurrentSong();
        String str = paramJSONObject.optString("dataUrl", paramJSONObject.optString("src"));
        if ((localSongInfo == null) || (!str.equals(localSongInfo.url))) {
          break;
        }
        if ((AudioJsPlugin.access$000(this.this$0) == 3) || (AudioJsPlugin.access$000(this.this$0) == 1))
        {
          localMusicPlayerProxy.resume();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramRequestEvent.fail();
        return;
      }
    } while ((AudioJsPlugin.access$000(this.this$0) != 4) && (AudioJsPlugin.access$000(this.this$0) != 0) && (AudioJsPlugin.access$000(this.this$0) != 8));
    playNew(paramJSONObject);
    return;
    playNew(paramJSONObject);
  }
  
  private void seekMusic(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    float f2 = 0.0F;
    if ((this.musicPlayerProxy != null) && (paramJSONObject != null)) {
      try
      {
        String str = paramJSONObject.optString("position");
        paramJSONObject = paramJSONObject.optString("currentTime");
        float f1;
        if (TextUtils.isEmpty(str))
        {
          f1 = 0.0F;
          if (!TextUtils.isEmpty(paramJSONObject)) {
            break label130;
          }
        }
        for (;;)
        {
          int i = (int)(Math.max(f1, f2) * 1000.0F);
          if (i < 0) {
            break label142;
          }
          AudioJsPlugin.access$200(this.this$0, "waiting");
          AudioJsPlugin.access$200(this.this$0, "seeking");
          this.musicPlayerProxy.seekTo(i);
          paramRequestEvent.ok();
          AudioJsPlugin.access$200(this.this$0, "seeked");
          AudioJsPlugin.access$200(this.this$0, "play");
          return;
          f1 = Float.valueOf(str).floatValue();
          break;
          label130:
          f2 = Float.valueOf(paramJSONObject).floatValue();
        }
        label142:
        paramRequestEvent.fail();
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QMLog.e("AudioJsPlugin", "seekMusic error. " + paramJSONObject);
        paramRequestEvent.fail();
      }
    }
  }
  
  private void stopQQmMusic(RequestEvent paramRequestEvent)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    AudioJsPlugin.access$602(this.this$0, paramRequestEvent);
    try
    {
      localMusicPlayerProxy.stop();
      return;
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
    }
  }
  
  public void handleMessage(int paramInt, RequestEvent paramRequestEvent)
  {
    handleMessage(paramInt, paramRequestEvent, null);
  }
  
  public void handleMessage(int paramInt, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      playQQMusic(paramJSONObject, paramRequestEvent);
      AudioJsPlugin.access$4002(this.this$0, new AudioJsPlugin.BgMusicData(paramJSONObject, paramRequestEvent, null));
      return;
    case 2: 
      pauseQQMusic(paramRequestEvent);
      AudioJsPlugin.access$4002(this.this$0, null);
      return;
    case 3: 
      stopQQmMusic(paramRequestEvent);
      AudioJsPlugin.access$4002(this.this$0, null);
      return;
    case 4: 
      seekMusic(paramJSONObject, paramRequestEvent);
      return;
    }
    getMusicPlayerState(paramRequestEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.BgMusicManager
 * JD-Core Version:    0.7.0.1
 */