package com.tencent.mobileqq.mini.widget.media.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import bhom;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class TXLivePlayerJSAdapter
{
  public static final String CLASS_NAME_ITX_AUDIO_VOLUME_EVALUATION_LISTENER = "com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener";
  public static final String CLASS_NAME_ITX_LIVEPLAY_LISTENER = "com.tencent.rtmp.ITXLivePlayListener";
  public static final String CLASS_NAME_ITX_SNAPSHOT_LISTENER = "com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener";
  public static final String CLASS_NAME_TX_CLOUD_VIDEO_VIEW = "com.tencent.rtmp.ui.TXCloudVideoView";
  public static final String CLASS_NAME_TX_LIVEPLAY = "com.tencent.rtmp.WXLivePlayer";
  public static final String CLASS_NAME_TX_LIVEPLAY_CONFIG = "com.tencent.rtmp.WXLivePlayConfig";
  public static final String EVT_DESCRIPTION = "EVT_MSG";
  public static final String EVT_GET_MSG = "EVT_GET_MSG";
  public static final String NET_STATUS_AUDIO_BITRATE = "AUDIO_BITRATE";
  public static final String NET_STATUS_AUDIO_CACHE = "AUDIO_CACHE";
  public static final String NET_STATUS_AUDIO_CACHE_THRESHOLD = "AUDIO_CACHE_THRESHOLD";
  public static final String NET_STATUS_AUDIO_DROP = "AUDIO_DROP";
  public static final String NET_STATUS_AUDIO_INFO = "AUDIO_PLAY_INFO";
  public static final String NET_STATUS_AV_PLAY_INTERVAL = "AV_PLAY_INTERVAL";
  public static final String NET_STATUS_AV_RECV_INTERVAL = "AV_RECV_INTERVAL";
  public static final String NET_STATUS_CPU_USAGE = "CPU_USAGE";
  public static final String NET_STATUS_NET_JITTER = "NET_JITTER";
  public static final String NET_STATUS_NET_SPEED = "NET_SPEED";
  public static final String NET_STATUS_SERVER_IP = "SERVER_IP";
  public static final String NET_STATUS_VIDEO_BITRATE = "VIDEO_BITRATE";
  public static final String NET_STATUS_VIDEO_CACHE = "VIDEO_CACHE";
  public static final String NET_STATUS_VIDEO_DROP = "VIDEO_DROP";
  public static final String NET_STATUS_VIDEO_FPS = "VIDEO_FPS";
  public static final String NET_STATUS_VIDEO_GOP = "VIDEO_GOP";
  public static final String NET_STATUS_VIDEO_HEIGHT = "VIDEO_HEIGHT";
  public static final String NET_STATUS_VIDEO_WIDTH = "VIDEO_WIDTH";
  public static final String NET_STATUS_V_DEC_CACHE_SIZE = "V_DEC_CACHE_SIZE";
  public static final String NET_STATUS_V_SUM_CACHE_SIZE = "V_SUM_CACHE_SIZE";
  public static final int PLAY_ERR_NET_DISCONNECT = -2301;
  public static final int PLAY_EVT_GET_MESSAGE = 2012;
  public static final int PLAY_EVT_PLAY_END = 2006;
  private static final String TAG = "TXLivePlayerJSAdapter";
  public static final int TX_LIVEPLAY_PLAY_TYPE_LIVE_FLV = 1;
  public static final int TX_LIVEPLAY_PLAY_TYPE_LIVE_RTMP = 0;
  public static final int TX_LIVEPLAY_PLAY_TYPE_LIVE_RTMP_ACC = 5;
  public static final int TX_LIVEPLAY_PLAY_TYPE_LOCAL_VIDEO = 6;
  public static final int TX_LIVEPLAY_PLAY_TYPE_VOD_FLV = 2;
  public static final int TX_LIVEPLAY_PLAY_TYPE_VOD_HLS = 3;
  public static final int TX_LIVEPLAY_PLAY_TYPE_VOD_MP4 = 4;
  public static final int VIDEO_ANGLE_HOME_DOWN = 1;
  private TXLivePlayerJSAdapter.ISnapshotOuterListener iTXSnapshotListener;
  private TXLivePlayerJSAdapter.IPlayOuterListener iWXLivePlayerOuterListener;
  private TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener itxAudioVolumeEvaluationOuterListener;
  private boolean mAutoPauseIfNavigate = true;
  private boolean mAutoPauseIfOpenNative = true;
  private boolean mAutoPlay;
  @Deprecated
  private boolean mBackgroundMute = true;
  private Context mContext;
  private boolean mDebug;
  private boolean mEnableRecvMessage;
  private boolean mInited;
  private float mMaxCache = 3.0F;
  private float mMinCache = 1.0F;
  private int mMode = 1;
  private boolean mMute;
  private boolean mMuteAudio;
  private boolean mMuteVideo;
  private boolean mNeedAudioVolumeNotify;
  private boolean mNeedEvent;
  private String mObjectFit = "contain";
  private String mOrientation = "vertical";
  private int mPlayType;
  private String mPlayerUrl = "";
  private boolean mPlayingBeforeEnterBackground;
  private String mSoundMode = "speaker";
  private Object txCloudVideoView;
  private Object txLivePlayConfig;
  private Object txLivePlayer;
  
  public TXLivePlayerJSAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.txLivePlayConfig = bhom.a("com.tencent.rtmp.WXLivePlayConfig", null, new Object[0]);
    this.txLivePlayer = bhom.a("com.tencent.rtmp.WXLivePlayer", bhom.a(new Class[] { Context.class }), new Object[] { this.mContext });
    txLivePlayer_enableHardwareDecode(Boolean.valueOf(true));
    try
    {
      bhom.a(this.txLivePlayer, "setConfig", false, bhom.a(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { this.txLivePlayConfig });
      paramContext = Class.forName("com.tencent.rtmp.ITXLivePlayListener");
      Object localObject = new TXLivePlayerJSAdapter.InnerTXLivePlayListenerImpl(this);
      txLivePlayer_setPlayListener(Proxy.newProxyInstance(TXLivePlayerJSAdapter.class.getClassLoader(), new Class[] { paramContext }, (InvocationHandler)localObject));
      paramContext = Class.forName("com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener");
      localObject = new TXLivePlayerJSAdapter.InnerAudioVolumeEvaluationListenerImpl(this);
      txLivePlayer_setAudioVolumeEvaluationListener(Proxy.newProxyInstance(TXLivePlayerJSAdapter.class.getClassLoader(), new Class[] { paramContext }, (InvocationHandler)localObject));
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      QLog.e("TXLivePlayerJSAdapter", 1, "bind InnerTXLivePlayListenerImpl failed, e" + paramContext.toString());
    }
  }
  
  private int getPlayType(Bundle paramBundle)
  {
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.mPlayerUrl == null) {}
      while ((this.mPlayerUrl == null) || ((!this.mPlayerUrl.startsWith("http://")) && (!this.mPlayerUrl.startsWith("https://"))) || (!this.mPlayerUrl.contains(".flv"))) {
        return 0;
      }
      return 1;
    }
    return 5;
  }
  
  private void parseAndApplyParams(Bundle paramBundle, boolean paramBoolean)
  {
    int i = 0;
    boolean bool = this.mMuteAudio;
    String str;
    if (paramBundle.keySet().contains("muteAudio"))
    {
      bool = paramBundle.getBoolean("muteAudio");
      if ((paramBoolean) || (bool != this.mMuteAudio)) {
        txLivePlayer_muteAudio(Boolean.valueOf(bool));
      }
      this.mMuteAudio = bool;
      bool = paramBundle.getBoolean("muteVideo", this.mMuteVideo);
      if ((paramBoolean) || (bool != this.mMuteVideo)) {
        txLivePlayer_muteVideo(Boolean.valueOf(bool));
      }
      this.mMuteVideo = bool;
      str = paramBundle.getString("orientation", this.mOrientation);
      if ((paramBoolean) || (!str.equalsIgnoreCase(this.mOrientation)))
      {
        if (!str.equalsIgnoreCase("horizontal")) {
          break label492;
        }
        txLivePlayer_setRenderRotation(270);
      }
      label148:
      this.mOrientation = str;
      str = paramBundle.getString("objectFit", this.mObjectFit);
      if ((paramBoolean) || (!str.equalsIgnoreCase(this.mObjectFit)))
      {
        if (!str.equalsIgnoreCase("fillCrop")) {
          break label510;
        }
        txLivePlayer_setRenderMode(0);
      }
      label199:
      this.mObjectFit = str;
      if (paramBundle.keySet().contains("soundMode"))
      {
        this.mSoundMode = paramBundle.getString("soundMode", this.mSoundMode);
        if (!this.mSoundMode.equalsIgnoreCase("speaker")) {
          break label528;
        }
        txLivePlayer_setAudioRoute(0);
      }
    }
    for (;;)
    {
      this.mMinCache = paramBundle.getFloat("minCache", this.mMinCache);
      this.mMaxCache = paramBundle.getFloat("maxCache", this.mMaxCache);
      txLivePlayConfig_setAutoAdjustCacheTime(Boolean.valueOf(true));
      txLivePlayConfig_setCacheTime(this.mMinCache);
      txLivePlayConfig_setMinAutoAdjustCacheTime(this.mMinCache);
      txLivePlayConfig_setMaxAutoAdjustCacheTime(this.mMaxCache);
      this.mEnableRecvMessage = paramBundle.getBoolean("enableRecvMessage", this.mEnableRecvMessage);
      txPlayConfig_setEnableMessage(Boolean.valueOf(this.mEnableRecvMessage));
      txLivePlayer_setConfig(this.txLivePlayConfig);
      this.mNeedEvent = paramBundle.getBoolean("needEvent", this.mNeedEvent);
      this.mAutoPauseIfNavigate = paramBundle.getBoolean("autoPauseIfNavigate", this.mAutoPauseIfNavigate);
      this.mAutoPauseIfOpenNative = paramBundle.getBoolean("autoPauseIfOpenNative", this.mAutoPauseIfOpenNative);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.mNeedAudioVolumeNotify);
      if (paramBoolean != this.mNeedAudioVolumeNotify)
      {
        if (paramBoolean) {
          i = 300;
        }
        txLivePlayer_enableAudioVolumeEvaluation(i);
      }
      this.mNeedAudioVolumeNotify = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.mDebug);
      if (paramBoolean != this.mDebug) {
        txLivePlayer_showDebugLog(Boolean.valueOf(paramBoolean));
      }
      this.mDebug = paramBoolean;
      return;
      if (!paramBundle.keySet().contains("muted")) {
        break;
      }
      bool = paramBundle.getBoolean("muted");
      break;
      label492:
      if (!str.equalsIgnoreCase("vertical")) {
        break label148;
      }
      txLivePlayer_setRenderRotation(0);
      break label148;
      label510:
      if (!str.equalsIgnoreCase("contain")) {
        break label199;
      }
      txLivePlayer_setRenderMode(1);
      break label199;
      label528:
      if (this.mSoundMode.equalsIgnoreCase("ear")) {
        txLivePlayer_setAudioRoute(1);
      }
    }
  }
  
  private void printJSParams(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str.equalsIgnoreCase("playUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("objectFit")) || (str.equalsIgnoreCase("soundMode"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
        } else if ((str.equalsIgnoreCase("mode")) || (str.equalsIgnoreCase("playType"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
        } else if ((str.equalsIgnoreCase("minCache")) || (str.equalsIgnoreCase("maxCache"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
        } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autoplay")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("muteAudio")) || (str.equalsIgnoreCase("muteVideo")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needAudioVolume")) || (str.equalsIgnoreCase("enableRecvMessage")) || (str.equalsIgnoreCase("debug"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
        }
      }
      QLog.d("TXLivePlayerJSAdapter", 2, paramString);
    }
  }
  
  private void safeRecycleBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
  }
  
  private void txCloudVideoView_disableLog(Boolean paramBoolean)
  {
    bhom.a(this.txCloudVideoView, "disableLog", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txCloudVideoView_showLog(Boolean paramBoolean)
  {
    bhom.a(this.txCloudVideoView, "showLog", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayConfig_setAutoAdjustCacheTime(Boolean paramBoolean)
  {
    bhom.a(this.txLivePlayConfig, "setAutoAdjustCacheTime", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayConfig_setCacheTime(float paramFloat)
  {
    bhom.a(this.txLivePlayConfig, "setCacheTime", false, bhom.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void txLivePlayConfig_setMaxAutoAdjustCacheTime(float paramFloat)
  {
    bhom.a(this.txLivePlayConfig, "setMaxAutoAdjustCacheTime", false, bhom.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void txLivePlayConfig_setMinAutoAdjustCacheTime(float paramFloat)
  {
    bhom.a(this.txLivePlayConfig, "setMinAutoAdjustCacheTime", false, bhom.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void txLivePlay_snapshot(Object paramObject)
  {
    try
    {
      bhom.a(this.txLivePlayer, "snapshot", false, bhom.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_enableAudioVolumeEvaluation(int paramInt)
  {
    bhom.a(this.txLivePlayer, "enableAudioVolumeEvaluation", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_enableHardwareDecode(Boolean paramBoolean)
  {
    bhom.a(this.txLivePlayer, "enableHardwareDecode", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private boolean txLivePlayer_isPlaying()
  {
    Object localObject = bhom.a(this.txLivePlayer, "isPlaying", false, null, new Object[0]);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  private void txLivePlayer_muteAudio(Boolean paramBoolean)
  {
    bhom.a(this.txLivePlayer, "muteAudio", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayer_muteVideo(Boolean paramBoolean)
  {
    bhom.a(this.txLivePlayer, "muteVideo", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayer_pause()
  {
    bhom.a(this.txLivePlayer, "pause", false, null, new Object[0]);
  }
  
  private void txLivePlayer_resume()
  {
    bhom.a(this.txLivePlayer, "resume", false, null, new Object[0]);
  }
  
  private void txLivePlayer_setAudioRoute(int paramInt)
  {
    bhom.a(this.txLivePlayer, "setAudioRoute", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_setAudioVolumeEvaluationListener(Object paramObject)
  {
    try
    {
      bhom.a(this.txLivePlayer, "setAudioVolumeEvaluationListener", false, bhom.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_setConfig(Object paramObject)
  {
    try
    {
      bhom.a(this.txLivePlayer, "setConfig", false, bhom.a(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_setPlayListener(Object paramObject)
  {
    try
    {
      bhom.a(this.txLivePlayer, "setPlayListener", false, bhom.a(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePlayListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_setPlayerView(Object paramObject)
  {
    try
    {
      bhom.a(this.txLivePlayer, "setPlayerView", false, bhom.a(new Class[] { Class.forName("com.tencent.rtmp.ui.TXCloudVideoView") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_setRenderMode(int paramInt)
  {
    bhom.a(this.txLivePlayer, "setRenderMode", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_setRenderRotation(int paramInt)
  {
    bhom.a(this.txLivePlayer, "setRenderRotation", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_showDebugLog(Boolean paramBoolean)
  {
    bhom.a(this.txLivePlayer, "showDebugLog", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private int txLivePlayer_startPlay(String paramString, int paramInt)
  {
    paramString = bhom.a(this.txLivePlayer, "startPlay", false, bhom.a(new Class[] { String.class, Integer.TYPE }), new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramString != null) {
      return ((Integer)paramString).intValue();
    }
    return -1;
  }
  
  private int txLivePlayer_stopPlay(Boolean paramBoolean)
  {
    paramBoolean = bhom.a(this.txLivePlayer, "stopPlay", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
    if (paramBoolean != null) {
      return ((Integer)paramBoolean).intValue();
    }
    return -1;
  }
  
  private void txPlayConfig_setEnableMessage(Boolean paramBoolean)
  {
    bhom.a(this.txLivePlayConfig, "setEnableMessage", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public Bundle createBundleFromJsonObject(JSONObject paramJSONObject)
  {
    int j = 0;
    Bundle localBundle = new Bundle();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "playUrl";
    arrayOfString[1] = "orientation";
    arrayOfString[2] = "objectFit";
    arrayOfString[3] = "soundMode";
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      if (paramJSONObject.has(str)) {
        localBundle.putString(str, paramJSONObject.optString(str));
      }
      i += 1;
    }
    arrayOfString = new String[10];
    arrayOfString[0] = "muted";
    arrayOfString[1] = "muteAudio";
    arrayOfString[2] = "muteVideo";
    arrayOfString[3] = "autoplay";
    arrayOfString[4] = "enableRecvMessage";
    arrayOfString[5] = "needAudioVolume";
    arrayOfString[6] = "needEvent";
    arrayOfString[7] = "autoPauseIfNavigate";
    arrayOfString[8] = "autoPauseIfOpenNative";
    arrayOfString[9] = "debug";
    k = arrayOfString.length;
    i = 0;
    while (i < k)
    {
      str = arrayOfString[i];
      if (paramJSONObject.has(str)) {
        localBundle.putBoolean(str, paramJSONObject.optBoolean(str));
      }
      i += 1;
    }
    arrayOfString = new String[2];
    arrayOfString[0] = "minCache";
    arrayOfString[1] = "maxCache";
    k = arrayOfString.length;
    i = 0;
    while (i < k)
    {
      str = arrayOfString[i];
      if (paramJSONObject.has(str)) {
        localBundle.putFloat(str, (float)paramJSONObject.optDouble(str));
      }
      i += 1;
    }
    arrayOfString = new String[1];
    arrayOfString[0] = "mode";
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      if (paramJSONObject.has(str)) {
        localBundle.putInt(str, paramJSONObject.optInt(str));
      }
      i += 1;
    }
    return localBundle;
  }
  
  public TXJSAdapterError enterBackground(int paramInt)
  {
    QLog.d("TXLivePlayerJSAdapter", 4, "enterBackground");
    if (((paramInt == 2) && (!this.mAutoPauseIfOpenNative)) || ((paramInt == 1) && (!this.mAutoPauseIfNavigate)))
    {
      this.mPlayingBeforeEnterBackground = false;
      return new TXJSAdapterError();
    }
    this.mPlayingBeforeEnterBackground = txLivePlayer_isPlaying();
    if (this.mPlayingBeforeEnterBackground)
    {
      if ((this.mNeedEvent) && (this.iWXLivePlayerOuterListener != null)) {
        this.iWXLivePlayerOuterListener.onPlayEvent(6000, new Bundle());
      }
      return operateLivePlayer("pause", null);
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError enterForeground()
  {
    if (this.mPlayingBeforeEnterBackground) {
      return operateLivePlayer("resume", null);
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initLivePlayer(Object paramObject, Bundle paramBundle)
  {
    if ((paramObject == null) || (paramBundle == null)) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    printJSParams("initLivePlayer", paramBundle);
    this.txCloudVideoView = paramObject;
    txCloudVideoView_disableLog(Boolean.valueOf(false));
    txLivePlayer_setPlayerView(paramObject);
    this.mPlayerUrl = paramBundle.getString("playUrl", this.mPlayerUrl);
    this.mPlayType = getPlayType(paramBundle);
    parseAndApplyParams(paramBundle, true);
    this.mAutoPlay = paramBundle.getBoolean("autoplay", this.mAutoPlay);
    if ((this.mAutoPlay) && (this.mPlayerUrl != null) && (!this.mPlayerUrl.isEmpty()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "initLivePlayer: startPlay");
      txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    this.mInited = true;
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initLivePlayer(Object paramObject, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TXLivePlayerJSAdapter", 2, "initLivePlayer: params = " + paramJSONObject.toString());
    }
    return initLivePlayer(paramObject, createBundleFromJsonObject(paramJSONObject));
  }
  
  public boolean isMute()
  {
    return this.mMute;
  }
  
  public boolean isPlaying()
  {
    return txLivePlayer_isPlaying();
  }
  
  public TXJSAdapterError operateLivePlayer(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    QLog.d("TXLivePlayerJSAdapter", 2, "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePlayer");
    }
    if (paramString.equalsIgnoreCase("play")) {
      txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    for (;;)
    {
      return new TXJSAdapterError();
      if (paramString.equalsIgnoreCase("stop"))
      {
        txLivePlayer_stopPlay(Boolean.valueOf(true));
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        txLivePlayer_pause();
      }
      else
      {
        if (!paramString.equalsIgnoreCase("resume")) {
          break;
        }
        txLivePlayer_resume();
      }
    }
    if (paramString.equalsIgnoreCase("mute"))
    {
      if (!this.mMute) {}
      for (boolean bool = true;; bool = false)
      {
        this.mMute = bool;
        txLivePlayer_muteAudio(Boolean.valueOf(this.mMute));
        break;
      }
    }
    return new TXJSAdapterError(-4, "invalid operate command");
  }
  
  public void setItxAudioVolumeEvaluationOuterListener(TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener paramITXAudioVolumeEvaluationOuterListener)
  {
    this.itxAudioVolumeEvaluationOuterListener = paramITXAudioVolumeEvaluationOuterListener;
  }
  
  public void setPlayListener(TXLivePlayerJSAdapter.IPlayOuterListener paramIPlayOuterListener)
  {
    this.iWXLivePlayerOuterListener = paramIPlayOuterListener;
  }
  
  public void setSnapshotListener(TXLivePlayerJSAdapter.ISnapshotOuterListener paramISnapshotOuterListener)
  {
    this.iTXSnapshotListener = paramISnapshotOuterListener;
  }
  
  public void takePhoto(boolean paramBoolean)
  {
    if (this.txLivePlayer != null) {}
    try
    {
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener");
      TXLivePlayerJSAdapter.InnerITXSnapshotListenerImpl localInnerITXSnapshotListenerImpl = new TXLivePlayerJSAdapter.InnerITXSnapshotListenerImpl(this);
      localInnerITXSnapshotListenerImpl.setNeedCompress(paramBoolean);
      txLivePlay_snapshot(Proxy.newProxyInstance(TXLivePlayerJSAdapter.class.getClassLoader(), new Class[] { localClass }, localInnerITXSnapshotListenerImpl));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
  
  public TXJSAdapterError uninitLivePlayer()
  {
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePlayer");
    }
    txLivePlayer_stopPlay(Boolean.valueOf(true));
    txLivePlayer_setPlayListener(null);
    this.mInited = false;
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError updateLivePlayer(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePlayer");
    }
    printJSParams("updateLivePlayer", paramBundle);
    parseAndApplyParams(paramBundle, false);
    boolean bool = txLivePlayer_isPlaying();
    String str = paramBundle.getString("playUrl", this.mPlayerUrl);
    if ((str != null) && (!str.isEmpty()) && (this.mPlayerUrl != null) && (!this.mPlayerUrl.equalsIgnoreCase(str)) && (txLivePlayer_isPlaying()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "updateLivePlayer: stopPlay playUrl-old = " + this.mPlayerUrl + " playUrl-new = " + str);
      txLivePlayer_stopPlay(Boolean.valueOf(true));
    }
    this.mPlayerUrl = str;
    int i = getPlayType(paramBundle);
    if ((i != this.mPlayType) && (txLivePlayer_isPlaying()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "updateLivePlayer: stopPlay  playType-old = " + this.mPlayType + " playType-new = " + i);
      txLivePlayer_stopPlay(Boolean.valueOf(true));
    }
    this.mPlayType = i;
    this.mAutoPlay = paramBundle.getBoolean("autoplay", this.mAutoPlay);
    if (((this.mAutoPlay) || (bool)) && (this.mPlayerUrl != null) && (!this.mPlayerUrl.isEmpty()) && (!txLivePlayer_isPlaying()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "updateLivePlayer: startPlay");
      txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError updateLivePlayer(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TXLivePlayerJSAdapter", 2, "updateLivePlayer: params = " + paramJSONObject.toString());
    }
    return updateLivePlayer(createBundleFromJsonObject(paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter
 * JD-Core Version:    0.7.0.1
 */