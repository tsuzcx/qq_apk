package com.tencent.qqmini.sdk.runtime.plugin;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import bglv;
import bgnt;
import bgok;
import bgop;
import bgpg;
import bher;
import com.tencent.qqmini.sdk.core.model.SongInfo;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxy.MusicPlayerListener;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

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
  private bgok mBgMusicReq;
  private int mCurrentSongDuration = -1;
  private SongInfo mCurrentSongInfo;
  private int mCurrentSongPosition = -1;
  private volatile SparseArray<AudioJsPlugin.InnerAudioManager> mInnerAudioManagers = new SparseArray();
  private MusicPlayerProxy.MusicPlayerListener mMusicPlayerListener = new AudioJsPlugin.1(this);
  private int mPlayState;
  
  private boolean checkAvalibleSdCard()
  {
    boolean bool = true;
    if (this.mMiniAppContext.a() == null) {
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
        QMLog.d("AudioJsPlugin", "startRecord() " + this.mMiniAppContext.a().getString(2131694403));
      }
    }
    for (;;)
    {
      bool = false;
      break;
      QMLog.w("AudioJsPlugin", "startRecord() " + this.mMiniAppContext.a().getString(2131694351));
    }
  }
  
  private void evaluateBgAudioStateJs(String paramString)
  {
    sendSubscribeEvent("onBackgroundAudioStateChange", bgpg.a(null, "state", paramString).toString());
  }
  
  private AudioJsPlugin.AudioManager getAudioManager()
  {
    if (this.mAudioManager == null) {
      this.mAudioManager = new AudioJsPlugin.AudioManager(this, this.mMiniAppContext.a(), null);
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
  
  private bher getLameMp3Recorder()
  {
    return AudioJsPlugin.AudioManager.access$1100(getAudioManager());
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
    localJSONObject.put("src", localSongInfo.b);
    localJSONObject.put("title", localSongInfo.c);
    localJSONObject.put("epname", localSongInfo.g);
    localJSONObject.put("singer", localSongInfo.h);
    localJSONObject.put("coverImgUrl", localSongInfo.e);
    localJSONObject.put("webUrl", localSongInfo.f);
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
  
  private void operateRecorderByLameMp3(String paramString, bgok parambgok)
  {
    bher localbher = getLameMp3Recorder();
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
            parambgok.b();
            return;
          }
          updateAudioConfig(localbher, paramString);
          getAudioManager().startRecord(parambgok, true);
          parambgok.a();
          return;
        }
      }
      catch (Exception paramString)
      {
        QMLog.e("AudioJsPlugin", "operateRecorderByLameMp3 failed:", paramString);
        parambgok.b();
        return;
      }
      if ("stop".equals(str)) {
        getAudioManager().stopRecord(0, parambgok, true);
      } else if ("pause".equals(str)) {
        localbher.c();
      } else if ("resume".equals(str)) {
        localbher.d();
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
  
  private void updateAudioConfig(bher parambher, JSONObject paramJSONObject)
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
      parambher.b(paramJSONObject);
    }
    if (!TextUtils.isEmpty(str1)) {
      parambher.a(Integer.parseInt(str1));
    }
    if (!TextUtils.isEmpty(str2)) {
      parambher.c(Integer.parseInt(str2));
    }
    if (!TextUtils.isEmpty(str3)) {
      parambher.d(Integer.parseInt(str3));
    }
    if (!TextUtils.isEmpty(str4)) {
      parambher.c(str4);
    }
    if (j < 0) {
      i = 1000;
    }
    for (;;)
    {
      if (i > 1) {
        parambher.e(i / 1000);
      }
      parambher.f(k * 1024);
      parambher.a(bgnt.a().b(str4));
      return;
      if (j <= 600000) {
        i = j;
      }
    }
  }
  
  public String createAudioInstance(bgok parambgok)
  {
    Object localObject = new AudioJsPlugin.InnerAudioManager(this);
    JSONObject localJSONObject = ((AudioJsPlugin.InnerAudioManager)localObject).getAudioContext();
    try
    {
      int i = AudioJsPlugin.InnerAudioManager.access$400((AudioJsPlugin.InnerAudioManager)localObject);
      double d = AudioJsPlugin.InnerAudioManager.access$500((AudioJsPlugin.InnerAudioManager)localObject);
      boolean bool = AudioJsPlugin.InnerAudioManager.access$100((AudioJsPlugin.InnerAudioManager)localObject);
      int j = sId.incrementAndGet();
      localJSONObject.put("duration", i);
      localJSONObject.put("currentTime", d);
      localJSONObject.put("paused", bool);
      localJSONObject.put("buffered", i);
      localJSONObject.put("audioId", j);
      ((AudioJsPlugin.InnerAudioManager)localObject).audioId = j;
      this.mInnerAudioManagers.put(j, localObject);
      parambgok.a(localJSONObject);
      localObject = bgop.a("createAudioInstance", localJSONObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "createAudioInstance failed:", localException);
      parambgok.b();
    }
    return bgop.b("createAudioInstance", null).toString();
  }
  
  public void destroyAudioInstance(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      AudioJsPlugin.InnerAudioManager localInnerAudioManager = getInnerAudioManager(localJSONObject);
      if (localInnerAudioManager != null)
      {
        AudioJsPlugin.InnerAudioManager.access$1000(localInnerAudioManager);
        int i = localJSONObject.optInt("audioId", -1);
        this.mInnerAudioManagers.remove(i);
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "destroyAudioInstance failed:", localException);
      parambgok.b();
    }
  }
  
  public void getAudioState(bgok parambgok)
  {
    try
    {
      Object localObject1 = new JSONObject(parambgok.b);
      Object localObject2 = getInnerAudioManager((JSONObject)localObject1);
      if (localObject2 != null)
      {
        localObject2 = ((AudioJsPlugin.InnerAudioManager)localObject2).getAudioContext();
        localObject1 = getInnerAudioManager((JSONObject)localObject1);
        int i = AudioJsPlugin.InnerAudioManager.access$400((AudioJsPlugin.InnerAudioManager)localObject1);
        double d = AudioJsPlugin.InnerAudioManager.access$500((AudioJsPlugin.InnerAudioManager)localObject1);
        boolean bool = AudioJsPlugin.InnerAudioManager.access$100((AudioJsPlugin.InnerAudioManager)localObject1);
        ((JSONObject)localObject2).put("duration", i);
        ((JSONObject)localObject2).put("currentTime", d);
        ((JSONObject)localObject2).put("paused", bool);
        ((JSONObject)localObject2).put("buffered", i);
        parambgok.a((JSONObject)localObject2);
        return;
      }
      parambgok.b();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "getAudioState failed:", localException);
      parambgok.b();
    }
  }
  
  public void getAvailableAudioSources(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioSources", Arrays.toString(new String[] { "auto", "mic", "camcorder", "voice_communication", "voice_recognition" }));
      parambgok.a(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "getAvailableAudioSources failed:", localException);
      parambgok.b();
    }
  }
  
  public void getBackgroundAudioState(bgok parambgok)
  {
    try
    {
      if (((this.mPlayState == 3) || (this.mPlayState == 1)) && (this.mBgAudioState != null))
      {
        this.mBgAudioState.put("paused", isPaused());
        parambgok.a(this.mBgAudioState);
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
      parambgok.b();
      return;
    }
    JSONObject localJSONObject = getStateJson();
    Log.i("AudioJsPlugin", "getBackgroundAudioState: " + localJSONObject);
    if (localJSONObject != null)
    {
      Log.i("AudioJsPlugin", "getBackgroundAudioState: ok " + Thread.currentThread().getId() + " " + localJSONObject.toString());
      parambgok.a(localJSONObject);
      this.mBgAudioState = localJSONObject;
    }
  }
  
  public void getMusicPlayerState(bgok parambgok)
  {
    getBgMusicManager().handleMessage(5, parambgok);
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    ((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).init(this.mMusicPlayerListener);
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
        AudioJsPlugin.InnerAudioManager.access$300((AudioJsPlugin.InnerAudioManager)this.mInnerAudioManagers.valueAt(i));
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
        if ((localObject != null) && (!AudioJsPlugin.InnerAudioManager.access$100((AudioJsPlugin.InnerAudioManager)localObject))) {
          AudioJsPlugin.InnerAudioManager.access$200((AudioJsPlugin.InnerAudioManager)localObject);
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
    if (this.lastPlayData == null) {
      return;
    }
    Log.i("AudioJsPlugin", "onResume: resume play");
    AudioJsPlugin.BgMusicManager.access$000(getBgMusicManager(), this.lastPlayData.jsonObject, this.lastPlayData.req);
  }
  
  public void operateAudio(bgok parambgok)
  {
    for (;;)
    {
      AudioJsPlugin.InnerAudioManager localInnerAudioManager;
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject(parambgok.b);
        localInnerAudioManager = getInnerAudioManager(localJSONObject);
        if (localInnerAudioManager == null) {
          break;
        }
        str = localJSONObject.optString("operationType");
        if ("play".equals(str))
        {
          AudioJsPlugin.InnerAudioManager.access$700(localInnerAudioManager);
          parambgok.a();
          return;
        }
        if ("pause".equals(str))
        {
          AudioJsPlugin.InnerAudioManager.access$200(localInnerAudioManager);
          continue;
        }
        if (!"stop".equals(str)) {
          break label104;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("AudioJsPlugin", "operateAudio failed:", localException);
        parambgok.b();
        return;
      }
      AudioJsPlugin.InnerAudioManager.access$800(localInnerAudioManager);
      continue;
      label104:
      if ("seek".equals(str)) {
        AudioJsPlugin.InnerAudioManager.access$900(localInnerAudioManager, (int)localException.optDouble("currentTime"));
      }
    }
  }
  
  public void operateBackgroundAudio(bgok parambgok)
  {
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      str = localJSONObject.optString("operationType");
      if ("play".equals(str))
      {
        if (this.mBgAudioState == null) {
          return;
        }
        getBgMusicManager().handleMessage(1, parambgok, this.mBgAudioState);
        return;
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, parambgok);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "operateBackgroundAudio failed:", localException);
      parambgok.b();
      return;
    }
    if ("stop".equals(str))
    {
      getBgMusicManager().handleMessage(3, parambgok);
      return;
    }
    if (("seek".equals(str)) && (this.mBgAudioState != null))
    {
      getBgMusicManager().handleMessage(4, parambgok, localException);
      parambgok.a();
    }
  }
  
  public void operateMusicPlayer(bgok parambgok)
  {
    ((MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class)).init(this.mMusicPlayerListener);
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      str = localJSONObject.optString("operationType");
      Log.i("AudioJsPlugin", "operateMusicPlayer: " + str);
      if ("play".equals(str))
      {
        this.mBgAudioState = localJSONObject;
        getBgMusicManager().handleMessage(1, parambgok, localJSONObject);
        return;
      }
      if ("pause".equals(str))
      {
        getBgMusicManager().handleMessage(2, parambgok);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "operateMusicPlayer failed:", localException);
      parambgok.b();
      return;
    }
    if ("stop".equals(str))
    {
      getBgMusicManager().handleMessage(3, parambgok);
      return;
    }
    if ("seek".equals(str))
    {
      getBgMusicManager().handleMessage(4, parambgok, localException);
      parambgok.a();
    }
  }
  
  public void operateRecorder(bgok parambgok)
  {
    try
    {
      operateRecorderByLameMp3(parambgok.b, parambgok);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "operateRecorder failed:", localException);
      parambgok.b();
    }
  }
  
  public void pauseVoice(bgok parambgok)
  {
    getAudioManager().pauseVoice(parambgok);
  }
  
  public void playVoice(bgok parambgok)
  {
    try
    {
      String str = new JSONObject(parambgok.b).optString("filePath");
      if (!TextUtils.isEmpty(str))
      {
        str = bgnt.a().a(str);
        getAudioManager().playVoice(str, parambgok);
        return;
      }
      parambgok.b();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "playVoice failed:", localException);
      parambgok.b();
    }
  }
  
  public void setAudioState(bgok parambgok)
  {
    try
    {
      Object localObject1 = new JSONObject(parambgok.b);
      getInnerAudioManager((JSONObject)localObject1).setAudioContext((JSONObject)localObject1);
      Object localObject2 = ((JSONObject)localObject1).optString("src");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((JSONObject)localObject1).put("src", bgnt.a().a((String)localObject2));
        boolean bool = ((JSONObject)localObject1).optBoolean("autoplay");
        AudioJsPlugin.InnerAudioManager.access$600(getInnerAudioManager((JSONObject)localObject1), bool);
        localObject2 = getInnerAudioManager((JSONObject)localObject1).getAudioContext();
        localObject1 = getInnerAudioManager((JSONObject)localObject1);
        int i = AudioJsPlugin.InnerAudioManager.access$400((AudioJsPlugin.InnerAudioManager)localObject1);
        double d = AudioJsPlugin.InnerAudioManager.access$500((AudioJsPlugin.InnerAudioManager)localObject1);
        bool = AudioJsPlugin.InnerAudioManager.access$100((AudioJsPlugin.InnerAudioManager)localObject1);
        ((JSONObject)localObject2).put("duration", i);
        ((JSONObject)localObject2).put("currentTime", d);
        ((JSONObject)localObject2).put("paused", bool);
        ((JSONObject)localObject2).put("buffered", i);
        parambgok.a((JSONObject)localObject2);
        return;
      }
      QMLog.e("AudioJsPlugin", "setAudioState err" + parambgok.b);
      parambgok.b();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "setAudioState err", localException);
      parambgok.b();
    }
  }
  
  public void setBackgroundAudioState(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      String str = localJSONObject.optString("src");
      Log.i("AudioJsPlugin", "setBackgroundAudioState: " + parambgok.b);
      if (!TextUtils.isEmpty(str))
      {
        localJSONObject.put("src", bgnt.a().a(str));
        this.mBgAudioState = localJSONObject;
        getBgMusicManager().handleMessage(1, parambgok, this.mBgAudioState);
        parambgok.a();
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "setBackgroundAudioState failed:", localException);
      parambgok.b();
    }
  }
  
  public void setInnerAudioOption(bgok parambgok)
  {
    try
    {
      String str = new JSONObject(parambgok.b).optString("mixWithOther");
      if (!TextUtils.isEmpty(str))
      {
        if (str.equalsIgnoreCase("true")) {
          mMixWithOther = true;
        }
        for (;;)
        {
          parambgok.a();
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
      parambgok.b();
    }
  }
  
  public void startRecord(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      updateAudioConfig(getLameMp3Recorder(), localJSONObject);
      getAudioManager().startRecord(parambgok, false);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("AudioJsPlugin", "startRecord failed:", localException);
      parambgok.b();
    }
  }
  
  public void stopRecord(bgok parambgok)
  {
    getAudioManager().stopRecord(0, parambgok, false);
  }
  
  public void stopVoice(bgok parambgok)
  {
    getAudioManager().stopVoice(parambgok);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.AudioJsPlugin
 * JD-Core Version:    0.7.0.1
 */