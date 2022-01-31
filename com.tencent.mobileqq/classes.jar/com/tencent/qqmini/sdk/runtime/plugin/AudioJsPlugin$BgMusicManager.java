package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bgok;
import com.tencent.qqmini.sdk.core.model.SongInfo;
import com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
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
    this.musicPlayerProxy.init(AudioJsPlugin.access$2500(paramAudioJsPlugin));
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
  
  private void getMusicPlayerState(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (AudioJsPlugin.access$2900(this.this$0) != null)
      {
        localJSONObject.put("currentPosition", AudioJsPlugin.access$3100(this.this$0, AudioJsPlugin.access$3000(this.this$0)));
        localJSONObject.put("duration", AudioJsPlugin.access$3100(this.this$0, AudioJsPlugin.access$3200(this.this$0)));
        localJSONObject.put("status", convertState(AudioJsPlugin.access$3300(this.this$0)));
        localJSONObject.put("dataUrl", AudioJsPlugin.access$2900(this.this$0).jdField_b_of_type_JavaLangString);
        parambgok.a(localJSONObject);
        return;
      }
      parambgok.b();
      return;
    }
    catch (Exception localException)
    {
      parambgok.b();
    }
  }
  
  private void pauseQQMusic(bgok parambgok)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    AudioJsPlugin.access$3402(this.this$0, parambgok);
    try
    {
      localMusicPlayerProxy.pause();
      return;
    }
    catch (Exception localException)
    {
      parambgok.b();
    }
  }
  
  private void playNew(JSONObject paramJSONObject)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.jdField_a_of_type_Long = System.currentTimeMillis();
    localSongInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("dataUrl", paramJSONObject.optString("src"));
    localSongInfo.c = paramJSONObject.optString("title");
    localSongInfo.g = paramJSONObject.optString("epname");
    localSongInfo.h = paramJSONObject.optString("singer");
    localSongInfo.e = paramJSONObject.optString("coverImgUrl");
    localSongInfo.f = paramJSONObject.optString("webUrl");
    localSongInfo.jdField_b_of_type_Int = 9;
    localSongInfo.jdField_a_of_type_Int = (paramJSONObject.optInt("startTime", 0) * 1000);
    localSongInfo.jdField_a_of_type_Boolean = true;
    localMusicPlayerProxy.setPlayMode(100);
    localMusicPlayerProxy.startPlay(new SongInfo[] { localSongInfo }, 0);
  }
  
  private void playQQMusic(JSONObject paramJSONObject, bgok parambgok)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    if ((!localMusicPlayerProxy.isInit()) || (paramJSONObject == null)) {
      parambgok.b();
    }
    do
    {
      return;
      AudioJsPlugin.access$3402(this.this$0, parambgok);
      try
      {
        SongInfo localSongInfo = localMusicPlayerProxy.getCurrentSong();
        String str = paramJSONObject.optString("dataUrl", paramJSONObject.optString("src"));
        if ((localSongInfo == null) || (!str.equals(localSongInfo.jdField_b_of_type_JavaLangString))) {
          break;
        }
        if ((AudioJsPlugin.access$3300(this.this$0) == 3) || (AudioJsPlugin.access$3300(this.this$0) == 1))
        {
          localMusicPlayerProxy.resume();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        parambgok.b();
        return;
      }
    } while ((AudioJsPlugin.access$3300(this.this$0) != 4) && (AudioJsPlugin.access$3300(this.this$0) != 0) && (AudioJsPlugin.access$3300(this.this$0) != 8));
    playNew(paramJSONObject);
    return;
    playNew(paramJSONObject);
  }
  
  private void seekMusic(JSONObject paramJSONObject, bgok parambgok)
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
            break label128;
          }
        }
        for (;;)
        {
          int i = (int)(Math.max(f1, f2) * 1000.0F);
          if (i < 0) {
            break label140;
          }
          AudioJsPlugin.access$2800(this.this$0, "waiting");
          AudioJsPlugin.access$2800(this.this$0, "seeking");
          this.musicPlayerProxy.seekTo(i);
          parambgok.a();
          AudioJsPlugin.access$2800(this.this$0, "seeked");
          AudioJsPlugin.access$2800(this.this$0, "play");
          return;
          f1 = Float.valueOf(str).floatValue();
          break;
          label128:
          f2 = Float.valueOf(paramJSONObject).floatValue();
        }
        label140:
        parambgok.b();
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QMLog.e("AudioJsPlugin", "seekMusic error. " + paramJSONObject);
        parambgok.b();
      }
    }
  }
  
  private void stopQQmMusic(bgok parambgok)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    AudioJsPlugin.access$3402(this.this$0, parambgok);
    try
    {
      localMusicPlayerProxy.stop();
      return;
    }
    catch (Exception localException)
    {
      parambgok.b();
    }
  }
  
  public void handleMessage(int paramInt, bgok parambgok)
  {
    handleMessage(paramInt, parambgok, null);
  }
  
  public void handleMessage(int paramInt, bgok parambgok, JSONObject paramJSONObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      playQQMusic(paramJSONObject, parambgok);
      AudioJsPlugin.access$2602(this.this$0, new AudioJsPlugin.BgMusicData(paramJSONObject, parambgok, null));
      return;
    case 2: 
      pauseQQMusic(parambgok);
      AudioJsPlugin.access$2602(this.this$0, null);
      return;
    case 3: 
      stopQQmMusic(parambgok);
      AudioJsPlugin.access$2602(this.this$0, null);
      return;
    case 4: 
      seekMusic(paramJSONObject, parambgok);
      return;
    }
    getMusicPlayerState(parambgok);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.AudioJsPlugin.BgMusicManager
 * JD-Core Version:    0.7.0.1
 */