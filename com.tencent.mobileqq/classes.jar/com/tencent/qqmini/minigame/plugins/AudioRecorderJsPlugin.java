package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
public class AudioRecorderJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_RECORD_STATE_CHANGE = "onRecorderStateChange";
  private static final String LAME_MP3_SO_PATH_STRING = "lameMp3SoPath";
  private static final String MINI_GAME_LAME_MP3_SO_PATH = "MiniGameLameMp3SoPath";
  private static final String RECORD_PAUSE = "pause";
  private static final String RECORD_RESUME = "resume";
  private static final String RECORD_START = "start";
  private static final String RECORD_STOP = "stop";
  private static final String TAG = "AudioRecorderJsPlugin";
  private boolean hasLoadedSo = false;
  private volatile AudioRecorderJsPlugin.AudioManager mAudioManager;
  
  private AudioRecorderJsPlugin.AudioManager getAudioManager()
  {
    if (this.mAudioManager == null) {
      this.mAudioManager = new AudioRecorderJsPlugin.AudioManager(this, this.mMiniAppContext.getAttachedActivity(), null);
    }
    return this.mAudioManager;
  }
  
  public static String getLameMp3SoPath(Context paramContext)
  {
    return getSharedPreferences(paramContext).getString("lameMp3SoPath", "");
  }
  
  private static SharedPreferences getSharedPreferences(Context paramContext)
  {
    return paramContext.getSharedPreferences("MiniGameLameMp3SoPath", 4);
  }
  
  private boolean loadLameMp3So()
  {
    if (this.hasLoadedSo) {
      return true;
    }
    String str = getLameMp3SoPath(this.mMiniAppContext.getContext());
    if (TextUtils.isEmpty(str))
    {
      this.hasLoadedSo = false;
      return false;
    }
    try
    {
      System.load(str);
      this.hasLoadedSo = true;
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QMLog.e(TAG, "loadLameMp3So error", localUnsatisfiedLinkError);
    }
    return false;
  }
  
  public static void setLameMp3SoPath(Context paramContext, String paramString)
  {
    getSharedPreferences(paramContext).edit().putString("lameMp3SoPath", paramString).apply();
  }
  
  @JsEvent({"getRecorderManager"})
  public void getRecorderManager(RequestEvent paramRequestEvent)
  {
    paramRequestEvent.ok();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mAudioManager != null) {
      this.mAudioManager.destroy();
    }
  }
  
  @JsEvent({"operateRecorder"})
  public void operateRecorder(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("operationType");
      if ("start".equals(str)) {
        getAudioManager().startRecord(paramRequestEvent);
      } else if ("resume".equals(str)) {
        getAudioManager().resumeRecord(paramRequestEvent);
      } else if ("pause".equals(str)) {
        getAudioManager().pauseRecord(paramRequestEvent);
      } else if ("stop".equals(str)) {
        getAudioManager().stopRecord(paramRequestEvent);
      }
      paramRequestEvent.ok();
      return;
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
      QMLog.e(TAG, "operateRecorder failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin
 * JD-Core Version:    0.7.0.1
 */