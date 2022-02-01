package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.SongInfo;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@JsPlugin
public class AudioJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_ON_AUDIO_STATE_CHANGE = "onAudioStateChange";
  private static final String EVENT_ON_BACKGROUND_STATE_CHANGE = "onBackgroundAudioStateChange";
  private static final String EVENT_RECORD_STATE_CHANGE = "onRecorderStateChange";
  private static final int RECORD_TO_CANCEL = 1;
  private static final int RECORD_TO_SEND = 0;
  public static final int STATE_ERROR = 8;
  public static final String TAG = "AudioJsPlugin";
  private static boolean mMixWithOther = true;
  public static AtomicInteger sId = new AtomicInteger();
  private AudioJsPlugin.BgMusicData lastPlayData;
  private volatile AudioJsPlugin.AudioManager mAudioManager;
  private JSONObject mBgAudioState;
  private volatile AudioJsPlugin.BgMusicManager mBgMusicManager;
  private RequestEvent mBgMusicReq;
  private int mCurrentSongDuration = -1;
  private SongInfo mCurrentSongInfo;
  private int mCurrentSongPosition = -1;
  private volatile SparseArray<AudioJsPlugin.InnerAudioManager> mInnerAudioManagers = new SparseArray();
  private MusicPlayerProxy.MusicPlayerListener mMusicPlayerListener = new AudioJsPlugin.1(this);
  private int mPlayState;
  
  private boolean checkAvalibleSdCard()
  {
    boolean bool = true;
    if (this.mMiniAppContext.getAttachedActivity() == null) {
      return false;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label102;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = DeviceInfoUtil.getSDCardMemory();
        if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
        {
          return bool;
          i = 0;
          break;
          label102:
          i = 0;
          continue;
        }
        QMLog.d("AudioJsPlugin", "startRecord() " + this.mMiniAppContext.getAttachedActivity().getString(R.string.mini_sdk_sdcard_full_no_send));
      }
    }
    for (;;)
    {
      bool = false;
      break;
      QMLog.w("AudioJsPlugin", "startRecord() " + this.mMiniAppContext.getAttachedActivity().getString(R.string.mini_sdk_nosdcardnosend));
    }
  }
  
  private void evaluateBgAudioStateJs(String paramString)
  {
    sendSubscribeEvent("onBackgroundAudioStateChange", JSONUtil.append(null, "state", paramString).toString());
  }
  
  private AudioJsPlugin.AudioManager getAudioManager()
  {
    if (this.mAudioManager == null) {
      this.mAudioManager = new AudioJsPlugin.AudioManager(this, this.mMiniAppContext.getAttachedActivity(), null);
    }
    return this.mAudioManager;
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
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    if (localMusicPlayerProxy != null) {}
    try
    {
      this.mCurrentSongDuration = Math.max(localMusicPlayerProxy.getDuration(), 0);
      return this.mCurrentSongDuration;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("AudioJsPlugin", "getCurrentSongDuration exception ", localException);
      }
    }
  }
  
  private SongInfo getCurrentSongInfo()
  {
    SongInfo localSongInfo = this.mCurrentSongInfo;
    if (localSongInfo == null)
    {
      Object localObject = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
      if (localObject != null) {
        try
        {
          localObject = ((MusicPlayerProxy)localObject).getCurrentSong();
          return localObject;
        }
        catch (Exception localException)
        {
          QMLog.e("AudioJsPlugin", "getCurrentSongInfo exception ", localException);
        }
      }
    }
    return localSongInfo;
  }
  
  private int getCurrentSongPosition()
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    if (this.mPlayState == 3) {
      return this.mCurrentSongPosition;
    }
    if (localMusicPlayerProxy != null) {}
    try
    {
      this.mCurrentSongPosition = Math.max(localMusicPlayerProxy.getCurrentSongPosition(), 0);
      if (this.mCurrentSongPosition % 1000 != 0) {
        this.mCurrentSongPosition = ((this.mCurrentSongPosition / 1000 + 1) * 1000);
      }
      this.mCurrentSongPosition = Math.min(this.mCurrentSongPosition, this.mCurrentSongDuration);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("AudioJsPlugin", "getCurrentSongPosition exception ", localException);
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
    return AudioJsPlugin.AudioManager.access$2200(getAudioManager());
  }
  
  private JSONObject getStateJson()
  {
    SongInfo localSongInfo = ((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).getCurrentSong();
    if (localSongInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("duration", mSecToSec(getCurrentSongDuration()));
    localJSONObject.put("currentTime", mSecToSec(getCurrentSongPosition()));
    localJSONObject.put("paused", isPaused());
    localJSONObject.put("src", localSongInfo.url);
    localJSONObject.put("title", localSongInfo.title);
    localJSONObject.put("epname", localSongInfo.album);
    localJSONObject.put("singer", localSongInfo.singer);
    localJSONObject.put("coverImgUrl", localSongInfo.coverUrl);
    localJSONObject.put("webUrl", localSongInfo.detailUrl);
    localJSONObject.put("buffered", mSecToSec(getCurrentSongDuration()));
    return localJSONObject;
  }
  
  private boolean isPaused()
  {
    return this.mPlayState != 2;
  }
  
  private double mSecToSec(int paramInt)
  {
    return Math.max(paramInt / 1000, 0);
  }
  
  private void operateRecorderByLameMp3(String paramString, RequestEvent paramRequestEvent)
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
            paramRequestEvent.fail();
            return;
          }
          updateAudioConfig(localLameMp3Recorder, paramString);
          getAudioManager().startRecord(paramRequestEvent, true);
          paramRequestEvent.ok();
          return;
        }
      }
      catch (Exception paramString)
      {
        QMLog.e("AudioJsPlugin", "operateRecorderByLameMp3 failed:", paramString);
        paramRequestEvent.fail();
        return;
      }
      if ("stop".equals(str)) {
        getAudioManager().stopRecord(0, paramRequestEvent, true);
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
  
  private void updateAudioConfig(LameMp3Recorder paramLameMp3Recorder, JSONObject paramJSONObject)
  {
    int i = 600000;
    String str4 = paramJSONObject.optString("format");
    String str1 = paramJSONObject.optString("sampleRate");
    String str2 = paramJSONObject.optString("numberOfChannels");
    String str3 = paramJSONObject.optString("encodeBitRate");
    int j = paramJSONObject.optInt("duration");
    int k = paramJSONObject.optInt("frameSize");
    paramJSONObject = paramJSONObject.optString("audioSource");
    str4 = parseAudioFormat(str4);
    if (!TextUtils.isEmpty(paramJSONObject)) {
      paramLameMp3Recorder.setAudioSource(paramJSONObject);
    }
    if (!TextUtils.isEmpty(str1)) {
      paramLameMp3Recorder.setSampleRate(Integer.parseInt(str1));
    }
    if (!TextUtils.isEmpty(str2)) {
      paramLameMp3Recorder.setOutChannel(Integer.parseInt(str2));
    }
    if (!TextUtils.isEmpty(str3)) {
      paramLameMp3Recorder.setOutBitRate(Integer.parseInt(str3));
    }
    if (!TextUtils.isEmpty(str4)) {
      paramLameMp3Recorder.setRecordFileFormat(str4);
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
      paramLameMp3Recorder.setRecordFilPath(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str4));
      return;
      if (j <= 600000) {
        i = j;
      }
    }
  }
  
  @JsEvent({"createAudioInstance"})
  public String createAudioInstance(RequestEvent paramRequestEvent)
  {
    Object localObject = new AudioJsPlugin.InnerAudioManager(this);
    JSONObject localJSONObject = ((AudioJsPlugin.InnerAudioManager)localObject).getAudioContext();
    try
    {
      int i = AudioJsPlugin.InnerAudioManager.access$1400((AudioJsPlugin.InnerAudioManager)localObject);
      double d = AudioJsPlugin.InnerAudioManager.access$1500((AudioJsPlugin.InnerAudioManager)localObject);
      boolean bool = AudioJsPlugin.InnerAudioManager.access$1100((AudioJsPlugin.InnerAudioManager)localObject);
      int j = sId.incrementAndGet();
      localJSONObject.put("duration", i);
      localJSONObject.put("currentTime", d);
      localJSONObject.put("paused", bool);
      localJSONObject.put("buffered", i);
      localJSONObject.put("audioId", j);
      ((AudioJsPlugin.InnerAudioManager)localObject).audioId = j;
      this.mInnerAudioManagers.put(j, localObject);
      paramRequestEvent.ok(localJSONObject);
      localObject = ApiUtil.wrapCallbackOk("createAudioInstance", localJSONObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "createAudioInstance failed:", localException);
      paramRequestEvent.fail();
    }
    return ApiUtil.wrapCallbackFail("createAudioInstance", null).toString();
  }
  
  @JsEvent({"destroyAudioInstance"})
  public void destroyAudioInstance(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      AudioJsPlugin.InnerAudioManager localInnerAudioManager = getInnerAudioManager(localJSONObject);
      if (localInnerAudioManager != null)
      {
        AudioJsPlugin.InnerAudioManager.access$2100(localInnerAudioManager);
        int i = localJSONObject.optInt("audioId", -1);
        this.mInnerAudioManagers.remove(i);
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "destroyAudioInstance failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"getAudioState"})
  public void getAudioState(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject2 = getInnerAudioManager((JSONObject)localObject1);
      if (localObject2 != null)
      {
        localObject2 = ((AudioJsPlugin.InnerAudioManager)localObject2).getAudioContext();
        localObject1 = getInnerAudioManager((JSONObject)localObject1);
        int i = AudioJsPlugin.InnerAudioManager.access$1400((AudioJsPlugin.InnerAudioManager)localObject1);
        double d = AudioJsPlugin.InnerAudioManager.access$1500((AudioJsPlugin.InnerAudioManager)localObject1);
        boolean bool = AudioJsPlugin.InnerAudioManager.access$1100((AudioJsPlugin.InnerAudioManager)localObject1);
        ((JSONObject)localObject2).put("duration", i);
        ((JSONObject)localObject2).put("currentTime", d);
        ((JSONObject)localObject2).put("paused", bool);
        ((JSONObject)localObject2).put("buffered", i);
        paramRequestEvent.ok((JSONObject)localObject2);
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "getAudioState failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"getAvailableAudioSources"})
  public void getAvailableAudioSources(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioSources", Arrays.toString(new String[] { "auto", "mic", "camcorder", "voice_communication", "voice_recognition" }));
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "getAvailableAudioSources failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"getBackgroundAudioState"})
  public void getBackgroundAudioState(RequestEvent paramRequestEvent)
  {
    try
    {
      if (((this.mPlayState == 3) || (this.mPlayState == 1)) && (this.mBgAudioState != null))
      {
        this.mBgAudioState.put("paused", isPaused());
        paramRequestEvent.ok(this.mBgAudioState);
        Log.i("AudioJsPlugin", "getBackgroundAudioState: pause");
        return;
      }
      if (!((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).isPlaying())
      {
        Log.i("AudioJsPlugin", "getBackgroundAudioState: isPlaying = false ");
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "getBackgroundAudioState failed:", localException);
      paramRequestEvent.fail();
      return;
    }
    JSONObject localJSONObject = getStateJson();
    Log.i("AudioJsPlugin", "getBackgroundAudioState: " + localJSONObject);
    if (localJSONObject != null)
    {
      Log.i("AudioJsPlugin", "getBackgroundAudioState: ok " + Thread.currentThread().getId() + " " + localJSONObject.toString());
      paramRequestEvent.ok(localJSONObject);
      this.mBgAudioState = localJSONObject;
    }
  }
  
  @JsEvent({"getMusicPlayerState"})
  public void getMusicPlayerState(RequestEvent paramRequestEvent)
  {
    getBgMusicManager().handleMessage(5, paramRequestEvent);
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    ((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).init(this.mMusicPlayerListener, this.mMiniAppInfo.appId, this.mMiniAppInfo.name);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    for (;;)
    {
      int i;
      try
      {
        localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
        QMLog.d("AudioJsPlugin", "audio plugin onDestroy");
        if (this.mAudioManager == null) {
          break label89;
        }
        this.mAudioManager.release();
      }
      catch (Throwable localThrowable)
      {
        MusicPlayerProxy localMusicPlayerProxy;
        QMLog.e("AudioJsPlugin", "onDestroy Exception ", localThrowable);
        return;
      }
      if (i > this.mInnerAudioManagers.size())
      {
        AudioJsPlugin.InnerAudioManager.access$1300((AudioJsPlugin.InnerAudioManager)this.mInnerAudioManagers.valueAt(i));
        i += 1;
      }
      else
      {
        localMusicPlayerProxy.unInit();
        return;
        label89:
        i = 0;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject;
    if ((this.mInnerAudioManagers != null) && (this.mInnerAudioManagers.size() > 0))
    {
      int i = 0;
      while (i < this.mInnerAudioManagers.size())
      {
        localObject = (AudioJsPlugin.InnerAudioManager)this.mInnerAudioManagers.valueAt(i);
        if ((localObject != null) && (!AudioJsPlugin.InnerAudioManager.access$1100((AudioJsPlugin.InnerAudioManager)localObject))) {
          AudioJsPlugin.InnerAudioManager.access$1200((AudioJsPlugin.InnerAudioManager)localObject);
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
      localObject = ((SongInfo)localObject).url;
      str = this.lastPlayData.jsonObject.optString("dataUrl", this.lastPlayData.jsonObject.optString("src"));
    } while ((!TextUtils.isEmpty(str)) && (str.equals(localObject)));
    this.lastPlayData = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.lastPlayData == null) {
      return;
    }
    Log.i("AudioJsPlugin", "onResume: resume play");
    AudioJsPlugin.BgMusicManager.access$1000(getBgMusicManager(), this.lastPlayData.jsonObject, this.lastPlayData.req);
  }
  
  @JsEvent({"operateAudio"})
  public void operateAudio(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      AudioJsPlugin.InnerAudioManager localInnerAudioManager;
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        localInnerAudioManager = getInnerAudioManager(localJSONObject);
        if (localInnerAudioManager == null) {
          break;
        }
        str = localJSONObject.optString("operationType");
        if ("play".equals(str))
        {
          AudioJsPlugin.InnerAudioManager.access$1800(localInnerAudioManager);
          paramRequestEvent.ok();
          return;
        }
        if ("pause".equals(str))
        {
          AudioJsPlugin.InnerAudioManager.access$1200(localInnerAudioManager);
          continue;
        }
        if (!"stop".equals(str)) {
          break label104;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("AudioJsPlugin", "operateAudio failed:", localException);
        paramRequestEvent.fail();
        return;
      }
      AudioJsPlugin.InnerAudioManager.access$1900(localInnerAudioManager);
      continue;
      label104:
      if ("seek".equals(str)) {
        AudioJsPlugin.InnerAudioManager.access$2000(localInnerAudioManager, (int)localException.optDouble("currentTime"));
      }
    }
  }
  
  @JsEvent({"operateBackgroundAudio"})
  public void operateBackgroundAudio(RequestEvent paramRequestEvent)
  {
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      str = localJSONObject.optString("operationType");
      if ("play".equals(str))
      {
        if (this.mBgAudioState == null) {
          return;
        }
        getBgMusicManager().handleMessage(1, paramRequestEvent, this.mBgAudioState);
        return;
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, paramRequestEvent);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "operateBackgroundAudio failed:", localException);
      paramRequestEvent.fail();
      return;
    }
    if ("stop".equals(str))
    {
      getBgMusicManager().handleMessage(3, paramRequestEvent);
      return;
    }
    if (("seek".equals(str)) && (this.mBgAudioState != null))
    {
      getBgMusicManager().handleMessage(4, paramRequestEvent, localException);
      paramRequestEvent.ok();
    }
  }
  
  @JsEvent({"operateMusicPlayer"})
  public void operateMusicPlayer(RequestEvent paramRequestEvent)
  {
    ((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).init(this.mMusicPlayerListener, this.mMiniAppInfo.appId, this.mMiniAppInfo.name);
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      str = localJSONObject.optString("operationType");
      Log.i("AudioJsPlugin", "operateMusicPlayer: " + str);
      if ("play".equals(str))
      {
        this.mBgAudioState = localJSONObject;
        getBgMusicManager().handleMessage(1, paramRequestEvent, localJSONObject);
        return;
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, paramRequestEvent);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "operateMusicPlayer failed:", localException);
      paramRequestEvent.fail();
      return;
    }
    if ("stop".equals(str))
    {
      getBgMusicManager().handleMessage(3, paramRequestEvent);
      return;
    }
    if ("seek".equals(str))
    {
      getBgMusicManager().handleMessage(4, paramRequestEvent, localException);
      paramRequestEvent.ok();
    }
  }
  
  @JsEvent({"operateRecorder"})
  public void operateRecorder(RequestEvent paramRequestEvent)
  {
    try
    {
      operateRecorderByLameMp3(paramRequestEvent.jsonParams, paramRequestEvent);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "operateRecorder failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"pauseVoice"})
  public void pauseVoice(RequestEvent paramRequestEvent)
  {
    getAudioManager().pauseVoice(paramRequestEvent);
  }
  
  @JsEvent({"playVoice"})
  public void playVoice(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("filePath");
      if (!TextUtils.isEmpty(str))
      {
        str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
        getAudioManager().playVoice(str, paramRequestEvent);
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "playVoice failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"setAudioState"})
  public void setAudioState(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      getInnerAudioManager(localJSONObject).setAudioContext(localJSONObject);
      String str = localJSONObject.optString("src");
      if (!TextUtils.isEmpty(str))
      {
        localJSONObject.put("src", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str));
        boolean bool = localJSONObject.optBoolean("autoplay");
        AudioJsPlugin.InnerAudioManager.access$1700(getInnerAudioManager(localJSONObject), bool, new AudioJsPlugin.2(this, localJSONObject, paramRequestEvent));
        return;
      }
      QMLog.e("AudioJsPlugin", "setAudioState err" + paramRequestEvent.jsonParams);
      paramRequestEvent.fail();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "setAudioState err", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"setBackgroundAudioState"})
  public void setBackgroundAudioState(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("src");
      Log.i("AudioJsPlugin", "setBackgroundAudioState: " + paramRequestEvent.jsonParams);
      if (!TextUtils.isEmpty(str))
      {
        localJSONObject.put("src", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str));
        this.mBgAudioState = localJSONObject;
        getBgMusicManager().handleMessage(1, paramRequestEvent, this.mBgAudioState);
        paramRequestEvent.ok();
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "setBackgroundAudioState failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"setInnerAudioOption"})
  public void setInnerAudioOption(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("mixWithOther");
      if (!TextUtils.isEmpty(str))
      {
        if (str.equalsIgnoreCase("true")) {
          mMixWithOther = true;
        }
        for (;;)
        {
          paramRequestEvent.ok();
          return;
          if (str.equalsIgnoreCase("false")) {
            mMixWithOther = false;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "setInnerAudioOption failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"startRecord"})
  public void startRecord(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      updateAudioConfig(getLameMp3Recorder(), localJSONObject);
      getAudioManager().startRecord(paramRequestEvent, false);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "startRecord failed:", localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"stopRecord"})
  public void stopRecord(RequestEvent paramRequestEvent)
  {
    getAudioManager().stopRecord(0, paramRequestEvent, false);
  }
  
  @JsEvent({"stopVoice"})
  public void stopVoice(RequestEvent paramRequestEvent)
  {
    getAudioManager().stopVoice(paramRequestEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin
 * JD-Core Version:    0.7.0.1
 */