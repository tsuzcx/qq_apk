package com.tencent.qqmini.miniapp.widget.media.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class TXLivePlayerJSAdapter
{
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
  private boolean mAutoPlay = false;
  @Deprecated
  private boolean mBackgroundMute = true;
  private Context mContext;
  private boolean mDebug = false;
  private boolean mEnableMetaData = false;
  private boolean mEnableRecvMessage = false;
  private boolean mInited = false;
  private float mMaxCache = 3.0F;
  private float mMinCache = 1.0F;
  private int mMode = 1;
  private boolean mMute = false;
  private boolean mMuteAudio = false;
  private boolean mMuteVideo = false;
  private boolean mNeedAudioVolumeNotify = false;
  private boolean mNeedEvent = false;
  private String mObjectFit = "contain";
  private String mOrientation = "vertical";
  private int mPlayType = 0;
  private String mPlayerUrl = "";
  private boolean mPlayingBeforeEnterBackground = false;
  private String mSoundMode = "speaker";
  private Surface mSurface;
  private final IWXLivePlayerProxy trtc;
  
  public TXLivePlayerJSAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.trtc = ((IWXLivePlayerProxy)ProxyManager.getNew(IWXLivePlayerProxy.class));
    this.trtc.init(this.mContext, new TXLivePlayerJSAdapter.InnerTXLivePlayListenerImpl(this), new TXLivePlayerJSAdapter.InnerAudioVolumeEvaluationListenerImpl(this));
  }
  
  private int getPlayType(Bundle paramBundle)
  {
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      paramBundle = this.mPlayerUrl;
      if (paramBundle == null) {
        return 0;
      }
      if ((paramBundle != null) && ((paramBundle.startsWith("http://")) || (this.mPlayerUrl.startsWith("https://"))) && (this.mPlayerUrl.contains(".flv"))) {
        return 1;
      }
      return 0;
    }
    return 5;
  }
  
  private void handleMuteAudioProperty(Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = this.mMuteAudio;
    if (paramBundle.keySet().contains("muteAudio")) {
      bool = paramBundle.getBoolean("muteAudio");
    } else if (paramBundle.keySet().contains("muted")) {
      bool = paramBundle.getBoolean("muted");
    }
    if ((paramBoolean) || (bool != this.mMuteAudio)) {
      this.trtc.txLivePlayer_muteAudio(Boolean.valueOf(bool));
    }
    this.mMuteAudio = bool;
  }
  
  private void handleMuteVideoProperty(Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = paramBundle.getBoolean("muteVideo", this.mMuteVideo);
    if ((paramBoolean) || (bool != this.mMuteVideo)) {
      this.trtc.txLivePlayer_muteVideo(Boolean.valueOf(bool));
    }
    this.mMuteVideo = bool;
  }
  
  private void handleObjectFitProperty(Bundle paramBundle, boolean paramBoolean)
  {
    paramBundle = paramBundle.getString("objectFit", this.mObjectFit);
    if ((paramBoolean) || (!paramBundle.equalsIgnoreCase(this.mObjectFit))) {
      if (paramBundle.equalsIgnoreCase("fillCrop")) {
        this.trtc.txLivePlayer_setRenderMode(0);
      } else if (paramBundle.equalsIgnoreCase("contain")) {
        this.trtc.txLivePlayer_setRenderMode(1);
      }
    }
    this.mObjectFit = paramBundle;
  }
  
  private void handleOrientationProperty(Bundle paramBundle, boolean paramBoolean)
  {
    paramBundle = paramBundle.getString("orientation", this.mOrientation);
    if ((paramBoolean) || (!paramBundle.equalsIgnoreCase(this.mOrientation))) {
      if (paramBundle.equalsIgnoreCase("horizontal")) {
        this.trtc.txLivePlayer_setRenderRotation(270);
      } else if (paramBundle.equalsIgnoreCase("vertical")) {
        this.trtc.txLivePlayer_setRenderRotation(0);
      }
    }
    this.mOrientation = paramBundle;
  }
  
  private void handleSoundModeProperty(Bundle paramBundle)
  {
    if (paramBundle.keySet().contains("soundMode"))
    {
      this.mSoundMode = paramBundle.getString("soundMode", this.mSoundMode);
      if (this.mSoundMode.equalsIgnoreCase("speaker"))
      {
        this.trtc.txLivePlayer_setAudioRoute(0);
        return;
      }
      if (this.mSoundMode.equalsIgnoreCase("ear")) {
        this.trtc.txLivePlayer_setAudioRoute(1);
      }
    }
  }
  
  private boolean isBooleanValueKey(String paramString)
  {
    return (paramString.equalsIgnoreCase("hide")) || (paramString.equalsIgnoreCase("autoplay")) || (paramString.equalsIgnoreCase("muted")) || (paramString.equalsIgnoreCase("muteAudio")) || (paramString.equalsIgnoreCase("muteVideo")) || (paramString.equalsIgnoreCase("backgroundMute")) || (paramString.equalsIgnoreCase("needEvent")) || (paramString.equalsIgnoreCase("autoPauseIfNavigate")) || (paramString.equalsIgnoreCase("needAudioVolume")) || (paramString.equalsIgnoreCase("enableRecvMessage")) || (paramString.equalsIgnoreCase("autoPauseIfOpenNative")) || (paramString.equalsIgnoreCase("enableMetadata")) || (paramString.equalsIgnoreCase("debug"));
  }
  
  private void onNetStatus(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == 1)
    {
      paramArrayOfObject = (Bundle)paramArrayOfObject[0];
      Object localObject1 = this.iWXLivePlayerOuterListener;
      if (localObject1 != null) {
        ((TXLivePlayerJSAdapter.IPlayOuterListener)localObject1).onNetStatus(paramArrayOfObject);
      }
      if (QMLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CPU:");
        ((StringBuilder)localObject1).append(paramArrayOfObject.getString("CPU_USAGE"));
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("RES:");
        ((StringBuilder)localObject2).append(paramArrayOfObject.getInt("VIDEO_WIDTH"));
        ((StringBuilder)localObject2).append("*");
        ((StringBuilder)localObject2).append(paramArrayOfObject.getInt("VIDEO_HEIGHT"));
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("SPD:");
        ((StringBuilder)localObject3).append(paramArrayOfObject.getInt("NET_SPEED"));
        ((StringBuilder)localObject3).append("Kbps");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("JIT:");
        ((StringBuilder)localObject4).append(paramArrayOfObject.getInt("NET_JITTER"));
        localObject4 = ((StringBuilder)localObject4).toString();
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("FPS:");
        ((StringBuilder)localObject5).append(paramArrayOfObject.getInt("VIDEO_FPS"));
        localObject5 = ((StringBuilder)localObject5).toString();
        Object localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("GOP:");
        ((StringBuilder)localObject6).append(paramArrayOfObject.getInt("VIDEO_GOP"));
        ((StringBuilder)localObject6).append("s");
        localObject6 = ((StringBuilder)localObject6).toString();
        Object localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append("ARA:");
        ((StringBuilder)localObject7).append(paramArrayOfObject.getInt("AUDIO_BITRATE"));
        ((StringBuilder)localObject7).append("Kbps");
        localObject7 = ((StringBuilder)localObject7).toString();
        Object localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append("QUE:");
        ((StringBuilder)localObject8).append(paramArrayOfObject.getInt("AUDIO_CACHE"));
        ((StringBuilder)localObject8).append(" | ");
        ((StringBuilder)localObject8).append(paramArrayOfObject.getInt("VIDEO_CACHE"));
        ((StringBuilder)localObject8).append(",");
        ((StringBuilder)localObject8).append(paramArrayOfObject.getInt("V_SUM_CACHE_SIZE"));
        ((StringBuilder)localObject8).append(",");
        ((StringBuilder)localObject8).append(paramArrayOfObject.getInt("V_DEC_CACHE_SIZE"));
        ((StringBuilder)localObject8).append(" | ");
        ((StringBuilder)localObject8).append(paramArrayOfObject.getInt("AV_RECV_INTERVAL"));
        ((StringBuilder)localObject8).append(",");
        ((StringBuilder)localObject8).append(paramArrayOfObject.getInt("AV_PLAY_INTERVAL"));
        ((StringBuilder)localObject8).append(",");
        ((StringBuilder)localObject8).append(String.format("%.1f", new Object[] { Float.valueOf(paramArrayOfObject.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString());
        localObject8 = ((StringBuilder)localObject8).toString();
        Object localObject9 = new StringBuilder();
        ((StringBuilder)localObject9).append("VRA:");
        ((StringBuilder)localObject9).append(paramArrayOfObject.getInt("VIDEO_BITRATE"));
        ((StringBuilder)localObject9).append("Kbps");
        localObject9 = ((StringBuilder)localObject9).toString();
        Object localObject10 = new StringBuilder();
        ((StringBuilder)localObject10).append("DRP:");
        ((StringBuilder)localObject10).append(paramArrayOfObject.getInt("AUDIO_DROP"));
        ((StringBuilder)localObject10).append("|");
        ((StringBuilder)localObject10).append(paramArrayOfObject.getInt("VIDEO_DROP"));
        localObject10 = ((StringBuilder)localObject10).toString();
        Object localObject11 = new StringBuilder();
        ((StringBuilder)localObject11).append("SVR:");
        ((StringBuilder)localObject11).append(paramArrayOfObject.getString("SERVER_IP"));
        localObject11 = ((StringBuilder)localObject11).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AUDIO:");
        localStringBuilder.append(paramArrayOfObject.getString("AUDIO_PLAY_INFO"));
        paramArrayOfObject = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localStringBuilder.toString() });
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onNetStatus:");
        ((StringBuilder)localObject1).append(paramArrayOfObject);
        QMLog.d("TXLivePlayerJSAdapter", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void onPlayEvent(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == 2)
    {
      Integer localInteger = (Integer)paramArrayOfObject[0];
      Object localObject = (Bundle)paramArrayOfObject[1];
      if ((localInteger.equals(Integer.valueOf(2006))) || (localInteger.equals(Integer.valueOf(-2301)))) {
        operateLivePlayer("stop", null);
      }
      if ((localInteger.intValue() == 2012) && (localObject != null))
      {
        paramArrayOfObject = ((Bundle)localObject).getByteArray("EVT_GET_MSG");
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
          try
          {
            paramArrayOfObject = new String(paramArrayOfObject, "UTF-8");
          }
          catch (UnsupportedEncodingException paramArrayOfObject)
          {
            paramArrayOfObject.printStackTrace();
          }
        } else {
          paramArrayOfObject = "";
        }
        ((Bundle)localObject).putString("EVT_MSG", paramArrayOfObject);
      }
      if (this.mNeedEvent)
      {
        paramArrayOfObject = this.iWXLivePlayerOuterListener;
        if (paramArrayOfObject != null) {
          paramArrayOfObject.onPlayEvent(localInteger.intValue(), (Bundle)localObject);
        }
      }
      if (localObject != null)
      {
        paramArrayOfObject = ((Bundle)localObject).getString("EVT_MSG");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPlayEvent: event = ");
        ((StringBuilder)localObject).append(localInteger);
        ((StringBuilder)localObject).append(" message = ");
        ((StringBuilder)localObject).append(paramArrayOfObject);
        QMLog.d("TXLivePlayerJSAdapter", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void parseAndApplyParams(Bundle paramBundle, boolean paramBoolean)
  {
    handleMuteAudioProperty(paramBundle, paramBoolean);
    handleMuteVideoProperty(paramBundle, paramBoolean);
    handleOrientationProperty(paramBundle, paramBoolean);
    handleObjectFitProperty(paramBundle, paramBoolean);
    handleSoundModeProperty(paramBundle);
    this.mMinCache = paramBundle.getFloat("minCache", this.mMinCache);
    this.mMaxCache = paramBundle.getFloat("maxCache", this.mMaxCache);
    this.mEnableMetaData = paramBundle.getBoolean("enableMetadata", this.mEnableMetaData);
    this.trtc.txLivePlayConfig_setAutoAdjustCacheTime(Boolean.valueOf(true));
    this.trtc.txLivePlayConfig_setCacheTime(this.mMinCache);
    this.trtc.txLivePlayConfig_setEnableMetaData(Boolean.valueOf(this.mEnableMetaData));
    this.trtc.txLivePlayConfig_setMinAutoAdjustCacheTime(this.mMinCache);
    this.trtc.txLivePlayConfig_setMaxAutoAdjustCacheTime(this.mMaxCache);
    this.mEnableRecvMessage = paramBundle.getBoolean("enableRecvMessage", this.mEnableRecvMessage);
    this.trtc.txPlayConfig_setEnableMessage(Boolean.valueOf(this.mEnableRecvMessage));
    this.trtc.txLivePlayer_setConfig();
    this.mNeedEvent = paramBundle.getBoolean("needEvent", this.mNeedEvent);
    this.mAutoPauseIfNavigate = paramBundle.getBoolean("autoPauseIfNavigate", this.mAutoPauseIfNavigate);
    this.mAutoPauseIfOpenNative = paramBundle.getBoolean("autoPauseIfOpenNative", this.mAutoPauseIfOpenNative);
    paramBoolean = paramBundle.getBoolean("needAudioVolume", this.mNeedAudioVolumeNotify);
    if (paramBoolean != this.mNeedAudioVolumeNotify)
    {
      IWXLivePlayerProxy localIWXLivePlayerProxy = this.trtc;
      int i;
      if (paramBoolean) {
        i = 300;
      } else {
        i = 0;
      }
      localIWXLivePlayerProxy.txLivePlayer_enableAudioVolumeEvaluation(i);
    }
    this.mNeedAudioVolumeNotify = paramBoolean;
    paramBoolean = paramBundle.getBoolean("debug", this.mDebug);
    if (paramBoolean != this.mDebug) {
      this.trtc.txLivePlayer_showDebugLog(Boolean.valueOf(paramBoolean));
    }
    this.mDebug = paramBoolean;
  }
  
  private void printJSParams(String paramString, Bundle paramBundle)
  {
    if (QMLog.isColorLevel())
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder;
        if ((!str.equalsIgnoreCase("playUrl")) && (!str.equalsIgnoreCase("orientation")) && (!str.equalsIgnoreCase("objectFit")) && (!str.equalsIgnoreCase("soundMode")))
        {
          if ((!str.equalsIgnoreCase("mode")) && (!str.equalsIgnoreCase("playType")))
          {
            if ((!str.equalsIgnoreCase("minCache")) && (!str.equalsIgnoreCase("maxCache")))
            {
              if (isBooleanValueKey(str))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(paramString);
                localStringBuilder.append("\n");
                localStringBuilder.append(str);
                localStringBuilder.append(" = ");
                localStringBuilder.append(paramBundle.getBoolean(str));
                paramString = localStringBuilder.toString();
              }
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString);
              localStringBuilder.append("\n");
              localStringBuilder.append(str);
              localStringBuilder.append(" = ");
              localStringBuilder.append(paramBundle.getFloat(str));
              paramString = localStringBuilder.toString();
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append("\n");
            localStringBuilder.append(str);
            localStringBuilder.append(" = ");
            localStringBuilder.append(paramBundle.getInt(str));
            paramString = localStringBuilder.toString();
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("\n");
          localStringBuilder.append(str);
          localStringBuilder.append(" = ");
          localStringBuilder.append(paramBundle.getString(str));
          paramString = localStringBuilder.toString();
        }
      }
      QMLog.d("TXLivePlayerJSAdapter", paramString);
    }
  }
  
  private void safeRecycleBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bitmap recycle ");
      localStringBuilder.append(paramBitmap.toString());
      QMLog.d("TXLivePlayerJSAdapter", localStringBuilder.toString());
      paramBitmap.recycle();
    }
  }
  
  public Bundle createBundleFromJsonObject(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    String[] arrayOfString = new String[4];
    int j = 0;
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
    arrayOfString = new String[13];
    arrayOfString[0] = "hide";
    arrayOfString[1] = "muted";
    arrayOfString[2] = "muteAudio";
    arrayOfString[3] = "muteVideo";
    arrayOfString[4] = "autoplay";
    arrayOfString[5] = "enableRecvMessage";
    arrayOfString[6] = "needAudioVolume";
    arrayOfString[7] = "needEvent";
    arrayOfString[8] = "autoPauseIfNavigate";
    arrayOfString[9] = "autoPauseIfOpenNative";
    arrayOfString[10] = "enableMetadata";
    arrayOfString[11] = "backgroundMute";
    arrayOfString[12] = "debug";
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
    QMLog.d("TXLivePlayerJSAdapter", "enterBackground");
    if (((paramInt == 2) && (!this.mAutoPauseIfOpenNative)) || ((paramInt == 1) && (!this.mAutoPauseIfNavigate)))
    {
      this.mPlayingBeforeEnterBackground = false;
      return new TXJSAdapterError();
    }
    this.mPlayingBeforeEnterBackground = this.trtc.txLivePlayer_isPlaying();
    if (this.mPlayingBeforeEnterBackground)
    {
      if (this.mNeedEvent)
      {
        TXLivePlayerJSAdapter.IPlayOuterListener localIPlayOuterListener = this.iWXLivePlayerOuterListener;
        if (localIPlayOuterListener != null) {
          localIPlayOuterListener.onPlayEvent(6000, new Bundle());
        }
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
  
  public TXJSAdapterError initEmbeddedLivePlayer(JSONObject paramJSONObject)
  {
    paramJSONObject = createBundleFromJsonObject(paramJSONObject);
    if (paramJSONObject == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    printJSParams("initLivePlayer", paramJSONObject);
    this.trtc.txLivePlayer_setPlayerView(null);
    this.mPlayerUrl = paramJSONObject.getString("playUrl", this.mPlayerUrl);
    this.mPlayType = getPlayType(paramJSONObject);
    parseAndApplyParams(paramJSONObject, true);
    this.mAutoPlay = paramJSONObject.getBoolean("autoplay", this.mAutoPlay);
    if (this.mAutoPlay)
    {
      paramJSONObject = this.mPlayerUrl;
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()))
      {
        QMLog.d("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
        this.trtc.txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
      }
    }
    this.mInited = true;
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initLivePlayer(Object paramObject, Bundle paramBundle)
  {
    if ((paramObject != null) && (paramBundle != null))
    {
      printJSParams("initLivePlayer", paramBundle);
      this.trtc.initLivePlayer(paramObject);
      this.trtc.txCloudVideoView_disableLog(Boolean.valueOf(false));
      this.trtc.txLivePlayer_setPlayerView(paramObject);
      this.mPlayerUrl = paramBundle.getString("playUrl", this.mPlayerUrl);
      this.mPlayType = getPlayType(paramBundle);
      parseAndApplyParams(paramBundle, true);
      this.mAutoPlay = paramBundle.getBoolean("autoplay", this.mAutoPlay);
      if (this.mAutoPlay)
      {
        paramObject = this.mPlayerUrl;
        if ((paramObject != null) && (!paramObject.isEmpty()))
        {
          QMLog.d("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
          this.trtc.txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
        }
      }
      this.mInited = true;
      return new TXJSAdapterError();
    }
    return new TXJSAdapterError(-1, "invalid params");
  }
  
  public TXJSAdapterError initLivePlayer(Object paramObject, JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initLivePlayer: params = ");
      localStringBuilder.append(paramJSONObject.toString());
      QMLog.d("TXLivePlayerJSAdapter", localStringBuilder.toString());
    }
    return initLivePlayer(paramObject, createBundleFromJsonObject(paramJSONObject));
  }
  
  public boolean isMute()
  {
    return this.mMute;
  }
  
  public boolean isPlaying()
  {
    return this.trtc.txLivePlayer_isPlaying();
  }
  
  public TXJSAdapterError operateLivePlayer(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.toString();
    } else {
      paramJSONObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("operateLivePlayer: type = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" params = ");
    localStringBuilder.append(paramJSONObject);
    QMLog.d("TXLivePlayerJSAdapter", localStringBuilder.toString());
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePlayer");
    }
    if (paramString.equalsIgnoreCase("play"))
    {
      this.trtc.txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    else if (paramString.equalsIgnoreCase("stop"))
    {
      this.trtc.txLivePlayer_stopPlay(Boolean.valueOf(true));
    }
    else if (paramString.equalsIgnoreCase("pause"))
    {
      this.trtc.txLivePlayer_pause();
    }
    else if (paramString.equalsIgnoreCase("resume"))
    {
      this.trtc.txLivePlayer_resume();
    }
    else
    {
      if (!paramString.equalsIgnoreCase("mute")) {
        break label242;
      }
      this.mMute ^= true;
      this.trtc.txLivePlayer_muteAudio(Boolean.valueOf(this.mMute));
    }
    return new TXJSAdapterError();
    label242:
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
  
  public TXJSAdapterError setSurface(Surface paramSurface)
  {
    this.mSurface = paramSurface;
    this.trtc.txLivePlayer_setSurface(paramSurface);
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError setSurfaceSize(int paramInt1, int paramInt2)
  {
    this.trtc.txLivePlayer_setSurfaceSize(paramInt1, paramInt2);
    return new TXJSAdapterError();
  }
  
  public void takePhoto(boolean paramBoolean)
  {
    TXLivePlayerJSAdapter.InnerITXSnapshotListenerImpl localInnerITXSnapshotListenerImpl = new TXLivePlayerJSAdapter.InnerITXSnapshotListenerImpl(this);
    localInnerITXSnapshotListenerImpl.setNeedCompress(paramBoolean);
    this.trtc.txLivePlay_snapshot(localInnerITXSnapshotListenerImpl);
  }
  
  public TXJSAdapterError uninitLivePlayer()
  {
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePlayer");
    }
    this.trtc.txLivePlayer_stopPlay(Boolean.valueOf(true));
    this.trtc.txLivePlayer_setPlayListener(null);
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
    Object localObject1 = paramBundle.getString("playUrl", this.mPlayerUrl);
    if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
    {
      Object localObject2 = this.mPlayerUrl;
      if ((localObject2 != null) && (!((String)localObject2).equalsIgnoreCase((String)localObject1)) && (this.trtc.txLivePlayer_isPlaying()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateLivePlayer: stopPlay playUrl-old = ");
        ((StringBuilder)localObject2).append(this.mPlayerUrl);
        ((StringBuilder)localObject2).append(" playUrl-new = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QMLog.d("TXLivePlayerJSAdapter", ((StringBuilder)localObject2).toString());
        this.trtc.txLivePlayer_stopPlay(Boolean.valueOf(true));
      }
    }
    this.mPlayerUrl = ((String)localObject1);
    int i = getPlayType(paramBundle);
    if ((i != this.mPlayType) && (this.trtc.txLivePlayer_isPlaying()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateLivePlayer: stopPlay  playType-old = ");
      ((StringBuilder)localObject1).append(this.mPlayType);
      ((StringBuilder)localObject1).append(" playType-new = ");
      ((StringBuilder)localObject1).append(i);
      QMLog.d("TXLivePlayerJSAdapter", ((StringBuilder)localObject1).toString());
      this.trtc.txLivePlayer_stopPlay(Boolean.valueOf(true));
    }
    this.mPlayType = i;
    this.mAutoPlay = paramBundle.getBoolean("autoplay", this.mAutoPlay);
    boolean bool = this.trtc.txLivePlayer_isPlaying();
    if ((this.mAutoPlay) || (bool))
    {
      paramBundle = this.mPlayerUrl;
      if ((paramBundle != null) && (!paramBundle.isEmpty()) && (!this.trtc.txLivePlayer_isPlaying()))
      {
        QMLog.d("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        this.trtc.txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
      }
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError updateLivePlayer(JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateLivePlayer: params = ");
      localStringBuilder.append(paramJSONObject.toString());
      QMLog.d("TXLivePlayerJSAdapter", localStringBuilder.toString());
    }
    return updateLivePlayer(createBundleFromJsonObject(paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter
 * JD-Core Version:    0.7.0.1
 */