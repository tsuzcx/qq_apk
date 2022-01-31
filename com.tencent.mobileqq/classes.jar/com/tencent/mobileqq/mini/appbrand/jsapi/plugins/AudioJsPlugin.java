package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import aumi;
import aumk;
import bdcb;
import bdje;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder;
import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class AudioJsPlugin
  extends BaseJsPlugin
{
  private static final String API_CREATE_AUDIO_INSTANCE = "createAudioInstance";
  private static final String API_DESTROY_AUDIO_INSTANCE = "destroyAudioInstance";
  private static final String API_GET_AUDIO_STATE = "getAudioState";
  private static final String API_GET_AVAILABLE_AUDIO_SOURCES = "getAvailableAudioSources";
  private static final String API_GET_BACKGROUND_AUDIO_STATE = "getBackgroundAudioState";
  private static final String API_GET_MUSIC_PLAYER_STATE = "getMusicPlayerState";
  private static final String API_OPERATE_AUDIO = "operateAudio";
  private static final String API_OPERATE_BACKGROUND_AUDIO = "operateBackgroundAudio";
  private static final String API_OPERATE_MUSIC_PLAYER = "operateMusicPlayer";
  private static final String API_SET_AUDIO_STATE = "setAudioState";
  private static final String API_SET_BACKGROUND_AUDIO_STATE = "setBackgroundAudioState";
  private static final String API_SET_INNER_AUDIO_OPTION = "setInnerAudioOption";
  private static final String EVENT_ON_AUDIO_STATE_CHANGE = "onAudioStateChange";
  private static final String EVENT_ON_BACKGROUND_STATE_CHANGE = "onBackgroundAudioStateChange";
  private static final String EVENT_RECORD_STATE_CHANGE = "onRecorderStateChange";
  private static final int RECORD_TO_CANCEL = 1;
  private static final int RECORD_TO_SEND = 0;
  public static final String TAG = "[mini] AudioJsPlugin";
  private static boolean mMixWithOther = true;
  public static AtomicInteger sId = new AtomicInteger();
  private static String sToken;
  private final Set<String> eventMap = new HashSet();
  private boolean isNativePause;
  private long lastBindServiceTime = -1L;
  private AudioJsPlugin.BgMusicData lastPlayData;
  private Activity mActivity;
  private volatile AudioJsPlugin.AudioManager mAudioManager;
  private JSONObject mBgAudioState;
  private BridgeInfo mBgMusicBridge;
  private volatile AudioJsPlugin.BgMusicManager mBgMusicManager;
  private aumi mCallback = new AudioJsPlugin.2(this);
  private ServiceConnection mConn = new AudioJsPlugin.1(this);
  private int mCurrentSongDuration = -1;
  private SongInfo mCurrentSongInfo;
  private int mCurrentSongPosition = -1;
  private volatile SparseArray<AudioJsPlugin.InnerAudioManager> mInnerAudioManagers = new SparseArray();
  private int mPlayState;
  private aumk mService;
  
  public AudioJsPlugin()
  {
    this.eventMap.add("startRecord");
    this.eventMap.add("stopRecord");
    this.eventMap.add("playVoice");
    this.eventMap.add("pauseVoice");
    this.eventMap.add("stopVoice");
    this.eventMap.add("operateMusicPlayer");
    this.eventMap.add("getMusicPlayerState");
    this.eventMap.add("setBackgroundAudioState");
    this.eventMap.add("operateBackgroundAudio");
    this.eventMap.add("operateRecorder");
    this.eventMap.add("getAvailableAudioSources");
    this.eventMap.add("getBackgroundAudioState");
    this.eventMap.add("createAudioInstance");
    this.eventMap.add("destroyAudioInstance");
    this.eventMap.add("setAudioState");
    this.eventMap.add("getAudioState");
    this.eventMap.add("operateAudio");
    this.eventMap.add("setInnerAudioOption");
  }
  
  private void bindQQPlayerService()
  {
    for (;;)
    {
      try
      {
        if (this.mService == null)
        {
          long l = System.currentTimeMillis();
          if ((this.lastBindServiceTime != -1L) && (l - this.lastBindServiceTime <= 10000L)) {
            continue;
          }
          this.lastBindServiceTime = l;
          Intent localIntent = new Intent(BaseApplication.getContext(), QQPlayerService.class);
          BaseApplication.getContext().bindService(localIntent, this.mConn, 33);
          QLog.e("[mini] AudioJsPlugin", 1, "bindQQPlayerService end!");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "bindQQPlayerService exception", localThrowable);
        continue;
      }
      finally {}
      return;
      QLog.e("[mini] AudioJsPlugin", 1, "waiting for binding service");
    }
  }
  
  private boolean checkAvalibleSdCard()
  {
    boolean bool = true;
    if (this.mActivity == null) {
      return false;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label98;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = bdcb.b();
        if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
        {
          return bool;
          i = 0;
          break;
          label98:
          i = 0;
          continue;
        }
        QLog.d("[mini] AudioJsPlugin", 2, "startRecord() " + this.mActivity.getString(2131719540));
      }
    }
    for (;;)
    {
      bool = false;
      break;
      QLog.w("[mini] AudioJsPlugin", 2, "startRecord() " + this.mActivity.getString(2131694851));
    }
  }
  
  private int convertAudioType(String paramString)
  {
    int i = 0;
    if (("slk".equalsIgnoreCase(paramString)) || ("silk".equalsIgnoreCase(paramString))) {
      i = 1;
    }
    return i;
  }
  
  private String createAudioInstance(BridgeInfo paramBridgeInfo)
  {
    if (this.isNativePause)
    {
      handleNativeResponseFail("createAudioInstance", paramBridgeInfo);
      return ApiUtil.wrapCallbackFail("createAudioInstance", null).toString();
    }
    Object localObject = new AudioJsPlugin.InnerAudioManager(this);
    JSONObject localJSONObject = ((AudioJsPlugin.InnerAudioManager)localObject).getAudioContext();
    try
    {
      int i = AudioJsPlugin.InnerAudioManager.access$000((AudioJsPlugin.InnerAudioManager)localObject);
      double d = AudioJsPlugin.InnerAudioManager.access$100((AudioJsPlugin.InnerAudioManager)localObject);
      boolean bool = AudioJsPlugin.InnerAudioManager.access$200((AudioJsPlugin.InnerAudioManager)localObject);
      int j = sId.incrementAndGet();
      localJSONObject.put("duration", i);
      localJSONObject.put("currentTime", d);
      localJSONObject.put("paused", bool);
      localJSONObject.put("buffered", i);
      localJSONObject.put("audioId", j);
      ((AudioJsPlugin.InnerAudioManager)localObject).audioId = j;
      this.mInnerAudioManagers.put(j, localObject);
      handleNativeResponseOk("createAudioInstance", paramBridgeInfo, localJSONObject);
      localObject = ApiUtil.wrapCallbackOk("createAudioInstance", localJSONObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "createAudioInstance failed:", localException);
      handleNativeResponseFail("createAudioInstance", paramBridgeInfo);
    }
    return ApiUtil.wrapCallbackFail("createAudioInstance", null).toString();
  }
  
  private void destroyAudioInstance(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString = new JSONObject(paramString);
      AudioJsPlugin.InnerAudioManager localInnerAudioManager = getInnerAudioManager(paramString);
      if (localInnerAudioManager != null)
      {
        AudioJsPlugin.InnerAudioManager.access$700(localInnerAudioManager);
        int i = paramString.optInt("audioId", -1);
        this.mInnerAudioManagers.remove(i);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "destroyAudioInstance failed:", paramString);
      handleNativeResponseFail("destroyAudioInstance", paramBridgeInfo);
    }
  }
  
  private void evaluateBgAudioStateJs(String paramString)
  {
    evaluateSubscribeJs("onBackgroundAudioStateChange", JSONUtil.append(null, "state", paramString).toString());
  }
  
  private void evaluateSubscribeJs(String paramString)
  {
    evaluateSubscribeJs(paramString, null);
  }
  
  private void evaluateSubscribeJs(String paramString1, String paramString2)
  {
    if ((this.jsPluginEngine == null) || (this.jsPluginEngine.appBrandRuntime == null) || (this.jsPluginEngine.getServiceRuntime() == null)) {
      return;
    }
    this.jsPluginEngine.appBrandRuntime.evaluateServiceSubcribeJS(paramString1, paramString2);
  }
  
  private AudioJsPlugin.AudioManager getAudioManager()
  {
    if (this.mAudioManager == null) {
      this.mAudioManager = new AudioJsPlugin.AudioManager(this, this.mActivity, null);
    }
    return this.mAudioManager;
  }
  
  private void getAudioState(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = getInnerAudioManager(paramString);
      if (localObject != null)
      {
        localObject = ((AudioJsPlugin.InnerAudioManager)localObject).getAudioContext();
        paramString = getInnerAudioManager(paramString);
        int i = AudioJsPlugin.InnerAudioManager.access$000(paramString);
        double d = AudioJsPlugin.InnerAudioManager.access$100(paramString);
        boolean bool = AudioJsPlugin.InnerAudioManager.access$200(paramString);
        ((JSONObject)localObject).put("duration", i);
        ((JSONObject)localObject).put("currentTime", d);
        ((JSONObject)localObject).put("paused", bool);
        ((JSONObject)localObject).put("buffered", i);
        handleNativeResponseOk("getAudioState", paramBridgeInfo, (JSONObject)localObject);
        return;
      }
      handleNativeResponseFail("getAudioState", paramBridgeInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "getAudioState failed:", paramString);
      handleNativeResponseFail("getAudioState", paramBridgeInfo);
    }
  }
  
  private void getAvailableAudioSources(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioSources", Arrays.toString(new String[] { "auto", "mic", "camcorder", "voice_communication", "voice_recognition" }));
      handleNativeResponseOk(paramString, paramBridgeInfo, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "getAvailableAudioSources failed:", localException);
      handleNativeResponseFail(paramString, paramBridgeInfo);
    }
  }
  
  private AudioJsPlugin.BgMusicManager getBgMusicManager()
  {
    if (this.mBgMusicManager == null) {
      this.mBgMusicManager = new AudioJsPlugin.BgMusicManager(this, null);
    }
    return this.mBgMusicManager;
  }
  
  private int getCurrentSongDuration()
  {
    if (this.mService != null) {}
    try
    {
      this.mCurrentSongDuration = Math.max(this.mService.c(), 0);
      return this.mCurrentSongDuration;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "getCurrentSongDuration exception ", localException);
      }
    }
  }
  
  private SongInfo getCurrentSongInfo()
  {
    SongInfo localSongInfo2 = this.mCurrentSongInfo;
    SongInfo localSongInfo1 = localSongInfo2;
    if (localSongInfo2 == null)
    {
      localSongInfo1 = localSongInfo2;
      if (this.mService == null) {}
    }
    try
    {
      localSongInfo1 = this.mService.a();
      return localSongInfo1;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "getCurrentSongInfo exception ", localException);
    }
    return localSongInfo2;
  }
  
  private int getCurrentSongPosition()
  {
    if (this.mPlayState == 3) {
      return this.mCurrentSongPosition;
    }
    if (this.mService != null) {}
    try
    {
      this.mCurrentSongPosition = Math.max(this.mService.d(), 0);
      if (this.mCurrentSongPosition % 1000 != 0) {
        this.mCurrentSongPosition = ((this.mCurrentSongPosition / 1000 + 1) * 1000);
      }
      this.mCurrentSongPosition = Math.min(this.mCurrentSongPosition, this.mCurrentSongDuration);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "getCurrentSongPosition exception ", localException);
      }
    }
    return this.mCurrentSongPosition;
  }
  
  private AudioJsPlugin.InnerAudioManager getInnerAudioManager(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("audioId", -1);
    return (AudioJsPlugin.InnerAudioManager)this.mInnerAudioManagers.get(i);
  }
  
  private LameMp3Recorder getLameMp3Recorder()
  {
    return AudioJsPlugin.AudioManager.access$900(getAudioManager());
  }
  
  private String getMyToken()
  {
    if (sToken == null) {
      sToken = QQPlayerService.a(8, "[mini] AudioJsPlugin" + this.jsPluginEngine.appBrandRuntime.appId);
    }
    return sToken;
  }
  
  private JSONObject getStateJson()
  {
    SongInfo localSongInfo = this.mService.a();
    if (localSongInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("duration", mSecToSec(getCurrentSongDuration()));
    localJSONObject.put("currentTime", mSecToSec(getCurrentSongPosition()));
    localJSONObject.put("paused", isPaused());
    localJSONObject.put("src", localSongInfo.b);
    localJSONObject.put("title", localSongInfo.c);
    localJSONObject.put("epname", localSongInfo.g);
    localJSONObject.put("singer", localSongInfo.h);
    localJSONObject.put("coverImgUrl", localSongInfo.e);
    localJSONObject.put("webUrl", localSongInfo.f);
    localJSONObject.put("buffered", mSecToSec(getCurrentSongDuration()));
    return localJSONObject;
  }
  
  private void handleMusicPlayerNativeRequest(boolean paramBoolean, BridgeInfo paramBridgeInfo)
  {
    if (paramBoolean)
    {
      handleNativeResponseOk("operateMusicPlayer", paramBridgeInfo, null);
      return;
    }
    handleNativeResponseFail("operateMusicPlayer", paramBridgeInfo);
  }
  
  private void handleNativeResponseFail(String paramString, BridgeInfo paramBridgeInfo)
  {
    if ((this.jsPluginEngine != null) && (paramBridgeInfo != null)) {
      this.jsPluginEngine.callbackJsEventFail(paramBridgeInfo.getWebView(), paramString, null, paramBridgeInfo.callbackId);
    }
  }
  
  private void handleNativeResponseOk(String paramString, BridgeInfo paramBridgeInfo)
  {
    handleNativeResponseOk(paramString, paramBridgeInfo, null);
  }
  
  private void handleNativeResponseOk(String paramString, BridgeInfo paramBridgeInfo, JSONObject paramJSONObject)
  {
    if ((this.jsPluginEngine != null) && (paramBridgeInfo != null)) {
      this.jsPluginEngine.callbackJsEventOK(paramBridgeInfo.getWebView(), paramString, paramJSONObject, paramBridgeInfo.callbackId);
    }
  }
  
  private boolean isPaused()
  {
    return this.mPlayState != 2;
  }
  
  private double mSecToSec(int paramInt)
  {
    return Math.max(paramInt / 1000, 0);
  }
  
  private void operateAudio(String paramString, BridgeInfo paramBridgeInfo)
  {
    for (;;)
    {
      AudioJsPlugin.InnerAudioManager localInnerAudioManager;
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        localInnerAudioManager = getInnerAudioManager(paramString);
        if (localInnerAudioManager == null) {
          break;
        }
        if (this.isNativePause)
        {
          handleNativeResponseFail("operateAudio", paramBridgeInfo);
          return;
        }
        str = paramString.optString("operationType");
        if ("play".equals(str))
        {
          AudioJsPlugin.InnerAudioManager.access$300(localInnerAudioManager);
          handleNativeResponseOk("operateAudio", paramBridgeInfo);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "operateAudio failed:", paramString);
        handleNativeResponseFail("operateAudio", paramBridgeInfo);
        return;
      }
      if ("pause".equals(str)) {
        AudioJsPlugin.InnerAudioManager.access$400(localInnerAudioManager);
      } else if ("stop".equals(str)) {
        AudioJsPlugin.InnerAudioManager.access$500(localInnerAudioManager);
      } else if ("seek".equals(str)) {
        AudioJsPlugin.InnerAudioManager.access$600(localInnerAudioManager, (int)paramString.optDouble("currentTime"));
      }
    }
  }
  
  private void operateBackgroundAudio(String paramString, BridgeInfo paramBridgeInfo)
  {
    if (paramBridgeInfo == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString);
          str = paramString.optString("operationType");
          if ("play".equals(str))
          {
            if (this.mBgAudioState == null) {
              continue;
            }
            getBgMusicManager().handleMessage(1, paramBridgeInfo, this.mBgAudioState);
          }
        }
        catch (Exception paramString)
        {
          QLog.e("[mini] AudioJsPlugin", 1, "operateBackgroundAudio failed:", paramString);
          handleNativeResponseFail("operateBackgroundAudio", paramBridgeInfo);
          return;
        }
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, paramBridgeInfo);
        return;
      }
      if ("stop".equals(str))
      {
        getBgMusicManager().handleMessage(3, paramBridgeInfo);
        return;
      }
    } while ((!"seek".equals(str)) || (this.mBgAudioState == null));
    getBgMusicManager().handleMessage(4, paramBridgeInfo, paramString);
    handleNativeResponseOk("operateBackgroundAudio", paramBridgeInfo);
  }
  
  private void operateMusicPlayer(String paramString, BridgeInfo paramBridgeInfo)
  {
    bindQQPlayerService();
    String str;
    try
    {
      paramString = new JSONObject(paramString);
      str = paramString.optString("operationType");
      Log.i("[mini] AudioJsPlugin", "operateMusicPlayer: " + str);
      if ("play".equals(str))
      {
        this.mBgAudioState = paramString;
        getBgMusicManager().handleMessage(1, paramBridgeInfo, paramString);
        return;
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, paramBridgeInfo);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "operateMusicPlayer failed:", paramString);
      handleMusicPlayerNativeRequest(false, paramBridgeInfo);
      return;
    }
    if ("stop".equals(str))
    {
      getBgMusicManager().handleMessage(3, paramBridgeInfo);
      return;
    }
    if ("seek".equals(str))
    {
      getBgMusicManager().handleMessage(4, paramBridgeInfo, paramString);
      handleNativeResponseOk("operateMusicPlayer", paramBridgeInfo);
    }
  }
  
  private void operateRecorder(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      operateRecorderByLameMp3(paramString, paramBridgeInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "operateRecorder failed:", paramString);
      handleNativeResponseFail("operateRecorder", paramBridgeInfo);
    }
  }
  
  private void operateRecorderByLameMp3(String paramString, BridgeInfo paramBridgeInfo)
  {
    LameMp3Recorder localLameMp3Recorder = getLameMp3Recorder();
    for (;;)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        str = paramString.optString("operationType");
        if ("start".equals(str))
        {
          if (!checkAvalibleSdCard())
          {
            handleNativeResponseFail("operateRecorder", paramBridgeInfo);
            return;
          }
          updateAudioConfig(localLameMp3Recorder, paramString, paramBridgeInfo);
          getAudioManager().startRecord(paramBridgeInfo, true);
          handleNativeResponseOk("operateRecorder", paramBridgeInfo);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "operateRecorderByLameMp3 failed:", paramString);
        handleNativeResponseFail("operateRecorder", paramBridgeInfo);
        return;
      }
      if ("stop".equals(str)) {
        getAudioManager().stopRecord(0, paramBridgeInfo, true);
      } else if ("pause".equals(str)) {
        localLameMp3Recorder.recordPause();
      } else if ("resume".equals(str)) {
        localLameMp3Recorder.recordResume();
      }
    }
  }
  
  private String parseAudioFormat(String paramString)
  {
    String str2 = "mp3";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase();
      if (!paramString.endsWith("aac")) {
        break label34;
      }
      str1 = "m4a";
    }
    label34:
    do
    {
      return str1;
      str1 = str2;
    } while (!paramString.endsWith("mp3"));
    return "mp3";
  }
  
  private void playVoice(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("filePath");
      if (!bdje.a(paramString))
      {
        paramString = MiniAppFileManager.getInstance().getAbsolutePath(paramString);
        getAudioManager().playVoice(paramString, paramBridgeInfo);
        return;
      }
      handleNativeResponseFail("playVoice", paramBridgeInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "playVoice failed:", paramString);
      handleNativeResponseFail("playVoice", paramBridgeInfo);
    }
  }
  
  private void setAudioState(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      getInnerAudioManager((JSONObject)localObject).setAudioContext((JSONObject)localObject);
      String str = ((JSONObject)localObject).optString("src");
      if (!bdje.a(str))
      {
        ((JSONObject)localObject).put("src", MiniAppFileManager.getInstance().getAbsolutePath(str));
        boolean bool = ((JSONObject)localObject).optBoolean("autoplay");
        AudioJsPlugin.InnerAudioManager.access$800(getInnerAudioManager((JSONObject)localObject), bool);
        paramString = getInnerAudioManager((JSONObject)localObject).getAudioContext();
        localObject = getInnerAudioManager((JSONObject)localObject);
        int i = AudioJsPlugin.InnerAudioManager.access$000((AudioJsPlugin.InnerAudioManager)localObject);
        double d = AudioJsPlugin.InnerAudioManager.access$100((AudioJsPlugin.InnerAudioManager)localObject);
        bool = AudioJsPlugin.InnerAudioManager.access$200((AudioJsPlugin.InnerAudioManager)localObject);
        paramString.put("duration", i);
        paramString.put("currentTime", d);
        paramString.put("paused", bool);
        paramString.put("buffered", i);
        handleNativeResponseOk("setAudioState", paramBridgeInfo, paramString);
        return;
      }
      QLog.e("[mini] AudioJsPlugin", 2, "setAudioState err" + paramString);
      handleNativeResponseFail("setAudioState", paramBridgeInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 2, "setAudioState err", paramString);
      handleNativeResponseFail("setAudioState", paramBridgeInfo);
    }
  }
  
  private void setBackgroundAudioState(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str = localJSONObject.optString("src");
      Log.i("[mini] AudioJsPlugin", "setBackgroundAudioState: " + paramString);
      if (!bdje.a(str))
      {
        localJSONObject.put("src", MiniAppFileManager.getInstance().getAbsolutePath(str));
        this.mBgAudioState = localJSONObject;
        getBgMusicManager().handleMessage(1, paramBridgeInfo, this.mBgAudioState);
        handleNativeResponseOk("setBackgroundAudioState", paramBridgeInfo);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "setBackgroundAudioState failed:", paramString);
      handleNativeResponseFail("setBackgroundAudioState", paramBridgeInfo);
    }
  }
  
  private void setInnerAudioOption(String paramString, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("mixWithOther");
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramString.equalsIgnoreCase("true")) {
          mMixWithOther = true;
        }
        for (;;)
        {
          handleNativeResponseOk("setInnerAudioOption", paramBridgeInfo);
          return;
          if (paramString.equalsIgnoreCase("false")) {
            mMixWithOther = false;
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "setInnerAudioOption failed:", paramString);
      handleNativeResponseFail("setInnerAudioOption", paramBridgeInfo);
    }
  }
  
  private void startRecord(String paramString1, String paramString2, BridgeInfo paramBridgeInfo)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      updateAudioConfig(getLameMp3Recorder(), paramString2, paramBridgeInfo);
      getAudioManager().startRecord(paramBridgeInfo, false);
      return;
    }
    catch (Exception paramString2)
    {
      QLog.e("[mini] AudioJsPlugin", 1, "startRecord failed:", paramString2);
      handleNativeResponseFail(paramString1, paramBridgeInfo);
    }
  }
  
  private void unbindQQPlayerService()
  {
    try
    {
      if (this.mService != null)
      {
        BaseApplication.getContext().unbindService(this.mConn);
        this.mService = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "unbindQQPlayerService exception", localThrowable);
      }
    }
    finally {}
  }
  
  private void updateAudioConfig(LameMp3Recorder paramLameMp3Recorder, JSONObject paramJSONObject, BridgeInfo paramBridgeInfo)
  {
    int i = 600000;
    String str3 = paramJSONObject.optString("format");
    paramBridgeInfo = paramJSONObject.optString("sampleRate");
    String str1 = paramJSONObject.optString("numberOfChannels");
    String str2 = paramJSONObject.optString("encodeBitRate");
    int j = paramJSONObject.optInt("duration");
    int k = paramJSONObject.optInt("frameSize");
    paramJSONObject = paramJSONObject.optString("audioSource");
    str3 = parseAudioFormat(str3);
    if (!TextUtils.isEmpty(paramJSONObject)) {
      paramLameMp3Recorder.setAudioSource(paramJSONObject);
    }
    if (!TextUtils.isEmpty(paramBridgeInfo)) {
      paramLameMp3Recorder.setSampleRate(Integer.parseInt(paramBridgeInfo));
    }
    if (!TextUtils.isEmpty(str1)) {
      paramLameMp3Recorder.setOutChannel(Integer.parseInt(str1));
    }
    if (!TextUtils.isEmpty(str2)) {
      paramLameMp3Recorder.setOutBitRate(Integer.parseInt(str2));
    }
    if (!TextUtils.isEmpty(str3)) {
      paramLameMp3Recorder.setRecordFileFormat(str3);
    }
    if (j < 0) {
      i = 1000;
    }
    for (;;)
    {
      if (i > 1) {
        paramLameMp3Recorder.setMaxRecordTime(i / 1000);
      }
      paramLameMp3Recorder.setCallbackFrameSize(k * 1024);
      paramLameMp3Recorder.setRecordFilPath(MiniAppFileManager.getInstance().getTmpPath(str3));
      return;
      if (j <= 600000) {
        i = j;
      }
    }
  }
  
  @NonNull
  private BridgeInfo wrapBridge(JsRuntime paramJsRuntime, int paramInt)
  {
    return new BridgeInfo(paramJsRuntime, paramInt);
  }
  
  public void getBackgroundAudioState(BridgeInfo paramBridgeInfo)
  {
    for (;;)
    {
      try
      {
        if (((this.mPlayState == 3) || (this.mPlayState == 1)) && (this.mBgAudioState != null))
        {
          this.mBgAudioState.put("paused", isPaused());
          handleNativeResponseOk("getBackgroundAudioState", paramBridgeInfo, this.mBgAudioState);
          Log.i("[mini] AudioJsPlugin", "getBackgroundAudioState: pause");
          return;
        }
        if ((this.mService != null) && (this.mService.a(getMyToken()))) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("getBackgroundAudioState: null ");
        if (this.mService == null)
        {
          bool = true;
          Log.i("[mini] AudioJsPlugin", bool);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "getBackgroundAudioState failed:", localException);
        handleNativeResponseFail("getBackgroundAudioState", paramBridgeInfo);
        return;
      }
      boolean bool = false;
    }
    JSONObject localJSONObject = getStateJson();
    Log.i("[mini] AudioJsPlugin", "getBackgroundAudioState: " + localJSONObject);
    if (localJSONObject != null)
    {
      Log.i("[mini] AudioJsPlugin", "getBackgroundAudioState: ok " + Thread.currentThread().getId() + " " + localJSONObject.toString());
      handleNativeResponseOk("getBackgroundAudioState", paramBridgeInfo, localJSONObject);
      this.mBgAudioState = localJSONObject;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] AudioJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    BridgeInfo localBridgeInfo = wrapBridge(paramJsRuntime, paramInt);
    if ("startRecord".equals(paramString1)) {
      startRecord(paramString1, paramString2, localBridgeInfo);
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if ("stopRecord".equals(paramString1))
      {
        getAudioManager().stopRecord(0, localBridgeInfo, false);
      }
      else if ("operateRecorder".equals(paramString1))
      {
        operateRecorder(paramString2, localBridgeInfo);
      }
      else if ("playVoice".equals(paramString1))
      {
        playVoice(paramString2, localBridgeInfo);
      }
      else if ("pauseVoice".equals(paramString1))
      {
        getAudioManager().pauseVoice(localBridgeInfo);
      }
      else if ("stopVoice".equals(paramString1))
      {
        getAudioManager().stopVoice(localBridgeInfo);
      }
      else if ("operateMusicPlayer".equals(paramString1))
      {
        operateMusicPlayer(paramString2, localBridgeInfo);
      }
      else if ("getMusicPlayerState".equals(paramString1))
      {
        getBgMusicManager().handleMessage(5, localBridgeInfo);
      }
      else if ("setBackgroundAudioState".equals(paramString1))
      {
        setBackgroundAudioState(paramString2, localBridgeInfo);
      }
      else if ("getBackgroundAudioState".equals(paramString1))
      {
        getBackgroundAudioState(localBridgeInfo);
      }
      else if ("operateBackgroundAudio".equals(paramString1))
      {
        operateBackgroundAudio(paramString2, localBridgeInfo);
      }
      else if ("getAvailableAudioSources".equals(paramString1))
      {
        getAvailableAudioSources(paramString1, localBridgeInfo);
      }
      else
      {
        if ("createAudioInstance".equals(paramString1)) {
          return createAudioInstance(localBridgeInfo);
        }
        if ("destroyAudioInstance".equals(paramString1)) {
          destroyAudioInstance(paramString2, localBridgeInfo);
        } else if ("setAudioState".equals(paramString1)) {
          setAudioState(paramString2, localBridgeInfo);
        } else if ("getAudioState".equals(paramString1)) {
          getAudioState(paramString2, localBridgeInfo);
        } else if ("operateAudio".equals(paramString1)) {
          operateAudio(paramString2, localBridgeInfo);
        } else if ("setInnerAudioOption".equals(paramString1)) {
          setInnerAudioOption(paramString2, localBridgeInfo);
        }
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mActivity = paramBaseJsPluginEngine.getActivityContext();
    bindQQPlayerService();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    for (;;)
    {
      int i;
      try
      {
        QLog.d("[mini] AudioJsPlugin", 1, "audio plugin onDestroy");
        if ((this.mService != null) && (QQPlayerService.a(getMyToken())))
        {
          Intent localIntent = new Intent("qqplayer_exit_action");
          BaseApplication.getContext().sendBroadcast(localIntent);
        }
        if (this.mAudioManager == null) {
          break label114;
        }
        this.mAudioManager.release();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[mini] AudioJsPlugin", 1, "onDestroy Exception ", localThrowable);
        return;
      }
      if (i > this.mInnerAudioManagers.size())
      {
        AudioJsPlugin.InnerAudioManager.access$3600((AudioJsPlugin.InnerAudioManager)this.mInnerAudioManagers.valueAt(i));
        i += 1;
      }
      else
      {
        unbindQQPlayerService();
        return;
        label114:
        i = 0;
      }
    }
  }
  
  public void onPause()
  {
    this.isNativePause = true;
    Object localObject;
    if ((this.mInnerAudioManagers != null) && (this.mInnerAudioManagers.size() > 0))
    {
      int i = 0;
      while (i < this.mInnerAudioManagers.size())
      {
        localObject = (AudioJsPlugin.InnerAudioManager)this.mInnerAudioManagers.valueAt(i);
        if ((localObject != null) && (!AudioJsPlugin.InnerAudioManager.access$200((AudioJsPlugin.InnerAudioManager)localObject))) {
          AudioJsPlugin.InnerAudioManager.access$400((AudioJsPlugin.InnerAudioManager)localObject);
        }
        i += 1;
      }
    }
    if (this.lastPlayData == null) {}
    String str;
    do
    {
      return;
      if (isPaused())
      {
        this.lastPlayData = null;
        return;
      }
      localObject = getCurrentSongInfo();
      if (localObject == null)
      {
        this.lastPlayData = null;
        return;
      }
      localObject = ((SongInfo)localObject).b;
      str = this.lastPlayData.jsonObject.optString("dataUrl", this.lastPlayData.jsonObject.optString("src"));
    } while ((!TextUtils.isEmpty(str)) && (str.equals(localObject)));
    this.lastPlayData = null;
  }
  
  public void onResume()
  {
    super.onResume();
    this.isNativePause = false;
    if (this.lastPlayData == null) {
      return;
    }
    Log.i("[mini] AudioJsPlugin", "onResume: resume play");
    AudioJsPlugin.BgMusicManager.access$3700(getBgMusicManager(), this.lastPlayData.jsonObject, this.lastPlayData.bridgeInfo);
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin
 * JD-Core Version:    0.7.0.1
 */