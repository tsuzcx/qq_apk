package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aumk;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AudioJsPlugin$BgMusicManager
{
  private static final int MSG_GET_MUSIC_PLAYER_STATE = 5;
  private static final int MSG_PAUSE = 2;
  private static final int MSG_PLAY = 1;
  private static final int MSG_SEEK = 4;
  private static final int MSG_STOP = 3;
  
  private AudioJsPlugin$BgMusicManager(AudioJsPlugin paramAudioJsPlugin)
  {
    AudioJsPlugin.access$1800(paramAudioJsPlugin);
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
  
  private void getMusicPlayerState(BridgeInfo paramBridgeInfo)
  {
    try
    {
      if ((AudioJsPlugin.access$2100(this.this$0) == null) || (AudioJsPlugin.access$2100(this.this$0).a() == null)) {
        return;
      }
      if (!AudioJsPlugin.access$2100(this.this$0).a().equals(AudioJsPlugin.access$2400(this.this$0))) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      if (AudioJsPlugin.access$2500(this.this$0) != null)
      {
        localJSONObject.put("currentPosition", AudioJsPlugin.access$2700(this.this$0, AudioJsPlugin.access$2600(this.this$0)));
        localJSONObject.put("duration", AudioJsPlugin.access$2700(this.this$0, AudioJsPlugin.access$2800(this.this$0)));
        localJSONObject.put("status", convertState(AudioJsPlugin.access$2900(this.this$0)));
        localJSONObject.put("dataUrl", AudioJsPlugin.access$2500(this.this$0).jdField_b_of_type_JavaLangString);
        AudioJsPlugin.access$1400(this.this$0, "getMusicPlayerState", paramBridgeInfo, localJSONObject);
        return;
      }
    }
    catch (Exception localException)
    {
      AudioJsPlugin.access$1200(this.this$0, "getMusicPlayerState", paramBridgeInfo);
      return;
    }
    AudioJsPlugin.access$1200(this.this$0, "getMusicPlayerState", paramBridgeInfo);
  }
  
  private void pauseQQMusic(BridgeInfo paramBridgeInfo)
  {
    AudioJsPlugin.access$3002(this.this$0, paramBridgeInfo);
    try
    {
      AudioJsPlugin.access$2100(this.this$0).a();
      return;
    }
    catch (Exception localException)
    {
      AudioJsPlugin.access$2300(this.this$0, false, paramBridgeInfo);
    }
  }
  
  private void playNew(JSONObject paramJSONObject)
  {
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
    AudioJsPlugin.access$2100(this.this$0).a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
    Bundle localBundle = AudioJsPlugin.access$2100(this.this$0).a();
    paramJSONObject = localBundle;
    if (localBundle == null)
    {
      paramJSONObject = new Bundle();
      AudioJsPlugin.access$2100(this.this$0).a(paramJSONObject);
    }
    paramJSONObject.putString("KEY_SOURCE_NAME", this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().apkgName);
    AudioJsPlugin.access$2100(this.this$0).a(paramJSONObject);
    AudioJsPlugin.access$2100(this.this$0).a(100);
    AudioJsPlugin.access$2100(this.this$0).a(AudioJsPlugin.access$2400(this.this$0), new SongInfo[] { localSongInfo }, 0);
  }
  
  private void playQQMusic(JSONObject paramJSONObject, BridgeInfo paramBridgeInfo)
  {
    if ((AudioJsPlugin.access$2100(this.this$0) == null) || (paramJSONObject == null)) {
      AudioJsPlugin.access$2300(this.this$0, false, paramBridgeInfo);
    }
    do
    {
      return;
      AudioJsPlugin.access$3002(this.this$0, paramBridgeInfo);
      try
      {
        SongInfo localSongInfo = AudioJsPlugin.access$2100(this.this$0).a();
        String str = paramJSONObject.optString("dataUrl", paramJSONObject.optString("src"));
        if ((localSongInfo == null) || (!str.equals(localSongInfo.jdField_b_of_type_JavaLangString))) {
          break;
        }
        if ((AudioJsPlugin.access$2900(this.this$0) == 3) || (AudioJsPlugin.access$2900(this.this$0) == 1))
        {
          AudioJsPlugin.access$2100(this.this$0).b();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        AudioJsPlugin.access$2300(this.this$0, false, paramBridgeInfo);
        return;
      }
    } while ((AudioJsPlugin.access$2900(this.this$0) != 4) && (AudioJsPlugin.access$2900(this.this$0) != 0) && (AudioJsPlugin.access$2900(this.this$0) != 8));
    playNew(paramJSONObject);
    return;
    playNew(paramJSONObject);
  }
  
  private void seekMusic(JSONObject paramJSONObject, BridgeInfo paramBridgeInfo)
  {
    float f2 = 0.0F;
    if ((AudioJsPlugin.access$2100(this.this$0) != null) && (paramJSONObject != null)) {
      try
      {
        String str = paramJSONObject.optString("position");
        paramJSONObject = paramJSONObject.optString("currentTime");
        float f1;
        if (TextUtils.isEmpty(str))
        {
          f1 = 0.0F;
          if (!TextUtils.isEmpty(paramJSONObject)) {
            break label145;
          }
        }
        for (;;)
        {
          int i = (int)(Math.max(f1, f2) * 1000.0F);
          if (i < 0) {
            break label157;
          }
          AudioJsPlugin.access$2200(this.this$0, "waiting");
          AudioJsPlugin.access$2200(this.this$0, "seeking");
          AudioJsPlugin.access$2100(this.this$0).b(i);
          AudioJsPlugin.access$2300(this.this$0, true, paramBridgeInfo);
          AudioJsPlugin.access$2200(this.this$0, "seeked");
          AudioJsPlugin.access$2200(this.this$0, "play");
          return;
          f1 = Float.valueOf(str).floatValue();
          break;
          label145:
          f2 = Float.valueOf(paramJSONObject).floatValue();
        }
        label157:
        AudioJsPlugin.access$2300(this.this$0, false, paramBridgeInfo);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("[mini] AudioJsPlugin", 1, "seekMusic error. " + paramJSONObject);
        AudioJsPlugin.access$2300(this.this$0, false, paramBridgeInfo);
      }
    }
  }
  
  private void stopQQmMusic(BridgeInfo paramBridgeInfo)
  {
    AudioJsPlugin.access$3002(this.this$0, paramBridgeInfo);
    try
    {
      AudioJsPlugin.access$2100(this.this$0).c();
      return;
    }
    catch (Exception localException)
    {
      AudioJsPlugin.access$2300(this.this$0, false, paramBridgeInfo);
    }
  }
  
  public void handleMessage(int paramInt, BridgeInfo paramBridgeInfo)
  {
    handleMessage(paramInt, paramBridgeInfo, null);
  }
  
  public void handleMessage(int paramInt, BridgeInfo paramBridgeInfo, JSONObject paramJSONObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      playQQMusic(paramJSONObject, paramBridgeInfo);
      AudioJsPlugin.access$1902(this.this$0, new AudioJsPlugin.BgMusicData(paramJSONObject, paramBridgeInfo, null));
      return;
    case 2: 
      pauseQQMusic(paramBridgeInfo);
      AudioJsPlugin.access$1902(this.this$0, null);
      return;
    case 3: 
      stopQQmMusic(paramBridgeInfo);
      AudioJsPlugin.access$1902(this.this$0, null);
      return;
    case 4: 
      seekMusic(paramJSONObject, paramBridgeInfo);
      return;
    }
    getMusicPlayerState(paramBridgeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.BgMusicManager
 * JD-Core Version:    0.7.0.1
 */