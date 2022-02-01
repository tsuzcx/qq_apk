package com.tencent.qqmini.miniapp.widget.media.live;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TXLivePusherJSAdapter
  implements TXLivePushListenerReflect.ITXLivePushListener, TXLivePushListenerReflect.OnBGMNotify
{
  private static final String TAG = "TXLivePusherJSAdapter";
  private String mAudioQuality = "high";
  private int mAudioReverbType = 0;
  private String mAudioVolumeType = "voicecall";
  private boolean mAutoPush = false;
  private TXLivePushListenerReflect.OnBGMNotify mBGMNotifyListener;
  private boolean mBGMPlaying = false;
  private boolean mBGMPlayingWhenPusherPaused = false;
  private int mBeauty = 5;
  private Context mContext;
  private boolean mDebug = false;
  private String mDevicePosition = "front";
  private boolean mEnableAgc = false;
  private boolean mEnableAns = false;
  private boolean mEnableCamera = true;
  private boolean mEnableEarMonitor = false;
  private boolean mEnableMic = true;
  private boolean mEnableZoom = true;
  private boolean mFlashLight = false;
  private int mFocusMode = 0;
  private boolean mForceStop = false;
  private boolean mFrontCamera = true;
  private Handler mHandler;
  private boolean mInited = false;
  private boolean mIsCameraPreviewing = false;
  private int mLastAngle = 0;
  private TXLivePushListenerReflect.ITXLivePushListener mLivePushListener;
  private String mLocalMirror = "auto";
  private int mMaxBitrate = -1;
  private int mMinBitrate = -1;
  private int mMode = 1;
  private boolean mMute = false;
  private boolean mNeedBGMEvent = false;
  private boolean mNeedEvent = false;
  private String mOrientation = "vertical";
  private boolean mPauseAudio = false;
  private String mPauseImageFilePath = "";
  private String mPusherUrl;
  private boolean mPushingBeforeEnterBackground = false;
  private boolean mRemoteMirror = false;
  private Surface mSurface;
  private int mVideoAspect = 2;
  private int mVideoHeight = 640;
  private Object mVideoView;
  private int mVideoWidth = 368;
  private final IWXLivePusherProxy mWXLivePusherProxy = (IWXLivePusherProxy)ProxyManager.get(IWXLivePusherProxy.class);
  private String mWatermarkImage = "";
  private float mWatermarkLeft = 0.0F;
  private float mWatermarkTop = 0.0F;
  private float mWatermarkWidth = 0.1F;
  private int mWhiteness = 3;
  private ArrayList<String> pusherKeyList;
  
  public TXLivePusherJSAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(this.mContext.getMainLooper());
    initPusherKeyList();
    this.mWXLivePusherProxy.initInstance(paramContext);
    paramContext = this.mWXLivePusherProxy;
    paramContext.setPushListener(paramContext.newITXLivePushListener(this));
    paramContext = this.mWXLivePusherProxy;
    paramContext.setBGMNofify(paramContext.newOnBGMNotify(this));
  }
  
  private Bundle adaptJsonToBundle(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    if (paramJSONObject == null) {
      return localBundle;
    }
    Object localObject = this.pusherKeyList;
    if (localObject == null)
    {
      QMLog.e("TXLivePusherJSAdapter", "adaptJsonToBundle - pusherKeyList is null");
      return localBundle;
    }
    localObject = ((ArrayList)localObject).iterator();
    for (;;)
    {
      String str;
      if (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (!isStringValueKey(str)) {}
      }
      try
      {
        localBundle.putString(str, paramJSONObject.getString(str));
      }
      catch (JSONException localJSONException) {}
      if (isIntKeyForParams(str))
      {
        localBundle.putInt(str, paramJSONObject.getInt(str));
      }
      else if (isBooleanKeyForParams(str))
      {
        localBundle.putBoolean(str, paramJSONObject.getBoolean(str));
      }
      else if ((str.equalsIgnoreCase("watermarkLeft")) || (str.equalsIgnoreCase("watermarkTop")) || (str.equalsIgnoreCase("watermarkWidth")))
      {
        localBundle.putDouble(str, paramJSONObject.getDouble(str));
        continue;
        return localBundle;
      }
    }
  }
  
  private void adjustHomeOrientation(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustHomeOrientation, angle:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", orientation:");
    localStringBuilder.append(paramString);
    QMLog.d("TXLivePusherJSAdapter", localStringBuilder.toString());
    int i = 0;
    if (paramInt == 1)
    {
      paramInt = i;
      if (paramString.equals("horizontal")) {
        paramInt = 3;
      }
    }
    else
    {
      if (paramInt == 3) {
        if (paramString.equals("horizontal"))
        {
          label90:
          paramInt = 1;
          break label141;
        }
      }
      for (;;)
      {
        paramInt = 2;
        break label141;
        if (paramInt == 0)
        {
          if (!paramString.equals("horizontal")) {
            break label90;
          }
          paramInt = i;
          break label141;
        }
        if (paramInt != 2) {
          break label137;
        }
        if (!paramString.equals("horizontal")) {
          break;
        }
      }
      label137:
      paramInt = -2147483648;
    }
    label141:
    paramString = new StringBuilder();
    paramString.append("adjustHomeOrientation, homeOrientation:");
    paramString.append(paramInt);
    QMLog.d("TXLivePusherJSAdapter", paramString.toString());
    if (paramInt != -2147483648)
    {
      this.mWXLivePusherProxy.setHomeOrientation(paramInt);
      this.mWXLivePusherProxy.setConfig();
    }
  }
  
  private void applyPushMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      this.mWXLivePusherProxy.setVideoQuality(6, false, false);
      return;
    case 5: 
      this.mWXLivePusherProxy.setVideoQuality(5, true, false);
      return;
    case 4: 
      this.mWXLivePusherProxy.setVideoQuality(4, true, false);
      return;
    case 3: 
      this.mWXLivePusherProxy.setVideoQuality(3, true, false);
      this.mWXLivePusherProxy.setVideoEncodeGop(5);
      return;
    case 2: 
      this.mWXLivePusherProxy.setVideoQuality(2, true, false);
      this.mWXLivePusherProxy.setVideoEncodeGop(5);
      return;
    }
    this.mWXLivePusherProxy.setVideoQuality(1, false, false);
    this.mWXLivePusherProxy.setVideoEncodeGop(5);
  }
  
  private TXJSAdapterError baseLivePusherOperate(String paramString, JSONObject paramJSONObject)
  {
    if (paramString.equalsIgnoreCase("start"))
    {
      paramString = this.mPusherUrl;
      if ((paramString != null) && (!paramString.isEmpty()) && (!this.mWXLivePusherProxy.isPushing()))
      {
        startPreview(this.mEnableCamera);
        startAudioRecord(this.mEnableMic);
        this.mWXLivePusherProxy.startPusher(this.mPusherUrl);
      }
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("stop"))
    {
      this.mFlashLight = false;
      this.mWXLivePusherProxy.stopBGM();
      stopPreview();
      stopAudioRecord();
      this.mWXLivePusherProxy.stopPusher();
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("pause"))
    {
      if ((this.mFlashLight) && (this.mWXLivePusherProxy.isPushing())) {
        this.mWXLivePusherProxy.turnOnFlashLight(false);
      }
      this.mWXLivePusherProxy.pausePusher();
      this.mBGMPlayingWhenPusherPaused = this.mBGMPlaying;
      if (this.mBGMPlayingWhenPusherPaused) {
        operateLivePusher("pauseBGM", null);
      }
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("resume"))
    {
      this.mWXLivePusherProxy.resumePusher();
      if (this.mBGMPlayingWhenPusherPaused) {
        operateLivePusher("resumeBGM", null);
      }
      return new TXJSAdapterError();
    }
    return null;
  }
  
  private TXJSAdapterError bgmLivePusherOperate(String paramString, JSONObject paramJSONObject)
  {
    if (paramString.equalsIgnoreCase("playBGM")) {
      return playBGM(paramJSONObject);
    }
    if (paramString.equalsIgnoreCase("stopBGM"))
    {
      this.mWXLivePusherProxy.stopBGM();
      this.mBGMPlaying = false;
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("pauseBGM"))
    {
      this.mWXLivePusherProxy.pauseBGM();
      this.mBGMPlaying = false;
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("resumeBGM"))
    {
      this.mWXLivePusherProxy.resumeBGM();
      this.mBGMPlaying = true;
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("setBGMPosition")) {
      return setBGMPosition(paramJSONObject);
    }
    if (paramString.equalsIgnoreCase("setBGMVolume")) {
      return setBGMVolume(paramJSONObject);
    }
    if (paramString.equalsIgnoreCase("setMICVolume")) {
      setMICVolume(paramJSONObject);
    }
    return null;
  }
  
  private TXJSAdapterError cameraLivePusherOperate(String paramString, JSONObject paramJSONObject)
  {
    if (paramString.equalsIgnoreCase("startPreview"))
    {
      if (this.mWXLivePusherProxy.isPushing())
      {
        QMLog.d("TXLivePusherJSAdapter", "do not support startPreview when pushing");
      }
      else
      {
        stopPreview();
        startPreview(this.mEnableCamera);
      }
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("stopPreview"))
    {
      if (this.mWXLivePusherProxy.isPushing()) {
        QMLog.d("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
      } else {
        stopPreview();
      }
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("switchCamera"))
    {
      this.mFrontCamera ^= true;
      this.mWXLivePusherProxy.setFrontCamera(this.mFrontCamera);
      this.mWXLivePusherProxy.switchCamera();
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("toggleTorch"))
    {
      boolean bool1 = this.mWXLivePusherProxy.isPushing();
      int i = -2;
      if (bool1)
      {
        bool1 = this.mFlashLight ^ true;
        boolean bool2 = this.mWXLivePusherProxy.turnOnFlashLight(bool1);
        if (!bool2) {
          bool1 = this.mFlashLight;
        }
        this.mFlashLight = bool1;
        if (bool2) {
          i = 0;
        }
        if (bool2) {
          paramString = "Success";
        } else {
          paramString = "Failed";
        }
        return new TXJSAdapterError(i, paramString);
      }
      return new TXJSAdapterError(-2, "fail");
    }
    return null;
  }
  
  private void handleAudioReverbType(Bundle paramBundle)
  {
    int i = paramBundle.getInt("audioReverbType", this.mAudioReverbType);
    if (i != this.mAudioReverbType) {
      this.mWXLivePusherProxy.setReverb(i);
    }
    this.mAudioReverbType = i;
  }
  
  private void handleBeatyAndWhiteness(Bundle paramBundle)
  {
    int i = paramBundle.getInt("beauty", this.mBeauty);
    int j = paramBundle.getInt("whiteness", this.mWhiteness);
    if (i != this.mBeauty) {
      this.mWXLivePusherProxy.setBeautyFilter(0, i, j, 2);
    }
    this.mBeauty = i;
    this.mWhiteness = j;
  }
  
  private void handleDebug(Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = paramBundle.getBoolean("debug", this.mDebug);
    if ((paramBoolean) || (bool != this.mDebug)) {
      this.mWXLivePusherProxy.showDebugLog(bool);
    }
    this.mDebug = bool;
  }
  
  private void handleRemoteMirror(Bundle paramBundle)
  {
    boolean bool = this.mRemoteMirror;
    if (paramBundle.keySet().contains("remoteMirror")) {
      bool = paramBundle.getBoolean("remoteMirror");
    } else if (paramBundle.keySet().contains("mirror")) {
      bool = paramBundle.getBoolean("mirror");
    }
    if (bool != this.mRemoteMirror) {
      this.mWXLivePusherProxy.setMirror(bool);
    }
    this.mRemoteMirror = bool;
  }
  
  private void initPusherKeyList()
  {
    if (this.pusherKeyList == null)
    {
      this.pusherKeyList = new ArrayList();
      this.pusherKeyList.add("pushUrl");
      this.pusherKeyList.add("mode");
      this.pusherKeyList.add("hide");
      this.pusherKeyList.add("autopush");
      this.pusherKeyList.add("muted");
      this.pusherKeyList.add("enableCamera");
      this.pusherKeyList.add("enableMic");
      this.pusherKeyList.add("enableAGC");
      this.pusherKeyList.add("enableANS");
      this.pusherKeyList.add("audioVolumeType");
      this.pusherKeyList.add("audioReverbType");
      this.pusherKeyList.add("devicePosition");
      this.pusherKeyList.add("focusMode");
      this.pusherKeyList.add("orientation");
      this.pusherKeyList.add("beauty");
      this.pusherKeyList.add("whiteness");
      this.pusherKeyList.add("aspect");
      this.pusherKeyList.add("videoWidth");
      this.pusherKeyList.add("videoHeight");
      this.pusherKeyList.add("minBitrate");
      this.pusherKeyList.add("maxBitrate");
      this.pusherKeyList.add("audioQuality");
      this.pusherKeyList.add("backgroundImage");
      this.pusherKeyList.add("backgroundMute");
      this.pusherKeyList.add("zoom");
      this.pusherKeyList.add("needEvent");
      this.pusherKeyList.add("needBGMEvent");
      this.pusherKeyList.add("watermarkImage");
      this.pusherKeyList.add("watermarkLeft");
      this.pusherKeyList.add("watermarkTop");
      this.pusherKeyList.add("watermarkWidth");
      this.pusherKeyList.add("debug");
      this.pusherKeyList.add("mirror");
      this.pusherKeyList.add("remoteMirror");
      this.pusherKeyList.add("localMirror");
      this.pusherKeyList.add("enableEarMonitor");
    }
  }
  
  private boolean isBooleanKeyForParams(String paramString)
  {
    return (paramString.equalsIgnoreCase("hide")) || (paramString.equalsIgnoreCase("autopush")) || (paramString.equalsIgnoreCase("muted")) || (paramString.equalsIgnoreCase("enableCamera")) || (paramString.equalsIgnoreCase("enableMic")) || (paramString.equalsIgnoreCase("enableAGC")) || (paramString.equalsIgnoreCase("enableANS")) || (isaBooleanKeyP2(paramString));
  }
  
  private boolean isFloatKeyForParams(String paramString)
  {
    return (paramString.equalsIgnoreCase("watermarkLeft")) || (paramString.equalsIgnoreCase("watermarkTop")) || (paramString.equalsIgnoreCase("watermarkWidth"));
  }
  
  private boolean isIntKeyForParams(String paramString)
  {
    return (paramString.equalsIgnoreCase("mode")) || (paramString.equalsIgnoreCase("focusMode")) || (paramString.equalsIgnoreCase("beauty")) || (paramString.equalsIgnoreCase("whiteness")) || (paramString.equalsIgnoreCase("aspect")) || (paramString.equalsIgnoreCase("videoWidth")) || (paramString.equalsIgnoreCase("videoHeight")) || (paramString.equalsIgnoreCase("audioReverbType")) || (paramString.equalsIgnoreCase("minBitrate")) || (paramString.equalsIgnoreCase("maxBitrate"));
  }
  
  private boolean isStringKeyForParams(String paramString)
  {
    return (paramString.equalsIgnoreCase("pushUrl")) || (paramString.equalsIgnoreCase("orientation")) || (paramString.equalsIgnoreCase("backgroundImage")) || (paramString.equalsIgnoreCase("audioQuality")) || (paramString.equalsIgnoreCase("watermarkImage")) || (paramString.equalsIgnoreCase("audioVolumeType")) || (paramString.equalsIgnoreCase("localMirror")) || (paramString.equalsIgnoreCase("devicePosition"));
  }
  
  private boolean isStringValueKey(String paramString)
  {
    return (paramString.equalsIgnoreCase("pushUrl")) || (paramString.equalsIgnoreCase("orientation")) || (paramString.equalsIgnoreCase("backgroundImage")) || (paramString.equalsIgnoreCase("audioQuality")) || (paramString.equalsIgnoreCase("watermarkImage")) || (paramString.equalsIgnoreCase("audioVolumeType")) || (paramString.equalsIgnoreCase("localMirror")) || (paramString.equalsIgnoreCase("devicePosition"));
  }
  
  private boolean isVideoWHValid(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && (paramInt1 <= 1920) && (paramInt2 > 0) && (paramInt2 <= 1920);
  }
  
  private boolean isaBooleanKeyP2(String paramString)
  {
    return (paramString.equalsIgnoreCase("enableEarMonitor")) || (paramString.equalsIgnoreCase("backgroundMute")) || (paramString.equalsIgnoreCase("zoom")) || (paramString.equalsIgnoreCase("needEvent")) || (paramString.equalsIgnoreCase("needBGMEvent")) || (paramString.equalsIgnoreCase("debug")) || (paramString.equalsIgnoreCase("mirror")) || (paramString.equalsIgnoreCase("remoteMirror"));
  }
  
  private boolean needApplyConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString1, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2, float paramFloat3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return (needApplyVideoConfig(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean7, paramString1, paramInt5)) || (needApplyOtherConfig(paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramInt6, paramFloat1, paramFloat2, paramFloat3)) || (needApplyStrConfig(paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  private boolean needApplyOtherConfig(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramInt != this.mVideoHeight) || (paramBoolean1 != this.mPauseAudio) || (paramBoolean2 != this.mEnableZoom) || (paramBoolean3 != this.mEnableAgc) || (paramBoolean4 != this.mEnableAns) || (paramBoolean5 != this.mEnableEarMonitor) || (paramFloat1 != this.mWatermarkLeft) || (paramFloat2 != this.mWatermarkTop) || (paramFloat3 != this.mWatermarkWidth);
  }
  
  private boolean needApplyStrConfig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return (!paramString1.equalsIgnoreCase(this.mAudioVolumeType)) || (!paramString2.equalsIgnoreCase(this.mPauseImageFilePath)) || (!paramString3.equalsIgnoreCase(this.mOrientation)) || (!paramString4.equalsIgnoreCase(this.mAudioQuality)) || (!paramString5.equalsIgnoreCase(this.mWatermarkImage));
  }
  
  private boolean needApplyVideoConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt5)
  {
    return (paramInt1 != this.mVideoAspect) || (paramInt2 != this.mMinBitrate) || (paramInt3 != this.mMaxBitrate) || (paramInt4 != this.mFocusMode) || (paramBoolean1 != this.mFrontCamera) || (paramBoolean2 != this.mEnableCamera) || (!paramString.equalsIgnoreCase(this.mLocalMirror)) || (paramInt5 != this.mVideoWidth);
  }
  
  private TXJSAdapterError otherLivePusherOperate(String paramString, JSONObject paramJSONObject)
  {
    boolean bool = paramString.equalsIgnoreCase("sendMessage");
    Object localObject = null;
    int i = 0;
    if (bool)
    {
      paramString = localObject;
      if (paramJSONObject != null) {
        paramString = paramJSONObject.optString("msg");
      }
      i = -2;
      if (paramString != null)
      {
        bool = this.mWXLivePusherProxy.sendMessageEx(paramString.getBytes());
        if (bool) {
          i = 0;
        }
        if (bool) {
          paramString = "Success";
        } else {
          paramString = "Failed";
        }
        return new TXJSAdapterError(i, paramString);
      }
      return new TXJSAdapterError(-2, "fail");
    }
    if (paramString.equalsIgnoreCase("setAudioReverbType"))
    {
      if (paramJSONObject != null) {
        i = paramJSONObject.optInt("audioReverbType", 0);
      }
      this.mWXLivePusherProxy.setReverb(i);
      return new TXJSAdapterError();
    }
    return null;
  }
  
  private void parseAndApplyParams(Bundle paramBundle, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0)) {
      return;
    }
    int i2 = paramBundle.getInt("mode", this.mMode);
    if ((paramBoolean) || (i2 != this.mMode)) {
      applyPushMode(i2);
    }
    int i1 = this.mMinBitrate;
    int n = this.mMaxBitrate;
    int m = paramBundle.getInt("minBitrate", -1);
    int k = paramBundle.getInt("maxBitrate", -1);
    int j = m;
    int i = k;
    if (m > k)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseAndApplyParams -> swap min and max bitrate, may be something error. min = ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(" max = ");
      ((StringBuilder)localObject1).append(k);
      QMLog.e("TXLivePusherJSAdapter", ((StringBuilder)localObject1).toString());
      i = m;
      j = k;
    }
    if ((j != -1) && (i != -1))
    {
      k = 200;
      if (j < 200) {
        j = k;
      }
      k = 1800;
      if (i > 1800) {
        i = k;
      }
      if (j <= i) {}
    }
    else
    {
      j = i1;
      i = n;
    }
    k = paramBundle.getInt("aspect", this.mVideoAspect);
    m = paramBundle.getInt("videoWidth", this.mVideoWidth);
    n = paramBundle.getInt("videoHeight", this.mVideoHeight);
    Object localObject1 = paramBundle.getString("audioQuality", this.mAudioQuality);
    setRealTimeVideoChatMode(i2, k, m, n, (String)localObject1, j, i);
    i1 = paramBundle.getInt("focusMode", this.mFocusMode);
    Object localObject2 = this.mWXLivePusherProxy;
    if (i1 != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((IWXLivePusherProxy)localObject2).setTouchFocus(bool1);
    boolean bool1 = setFrontCamera(paramBundle, this.mFrontCamera);
    localObject2 = paramBundle.getString("orientation", this.mOrientation);
    setRenderOrientation((String)localObject2);
    String str1 = paramBundle.getString("localMirror", this.mLocalMirror);
    setLocalVideoMirror(str1);
    String str2 = paramBundle.getString("backgroundImage", this.mPauseImageFilePath);
    Object localObject3 = BitmapFactory.decodeFile(str2);
    this.mWXLivePusherProxy.setPauseImg((Bitmap)localObject3);
    boolean bool2 = paramBundle.getBoolean("backgroundMute", this.mPauseAudio);
    setPauseAudioFlag(bool2);
    boolean bool3 = paramBundle.getBoolean("zoom", this.mEnableZoom);
    this.mWXLivePusherProxy.setEnableZoom(bool3);
    float f1 = paramBundle.getFloat("watermarkLeft", this.mWatermarkLeft);
    float f2 = paramBundle.getFloat("watermarkTop", this.mWatermarkTop);
    float f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
    localObject3 = paramBundle.getString("watermarkImage", this.mWatermarkImage);
    setWaterMark(paramBundle, f1, f2, f3, BitmapFactory.decodeFile((String)localObject3));
    boolean bool4 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
    this.mWXLivePusherProxy.enableAGC(bool4);
    boolean bool5 = paramBundle.getBoolean("enableANS", this.mEnableAns);
    this.mWXLivePusherProxy.enableANS(bool5);
    boolean bool6 = paramBundle.getBoolean("enableEarMonitor", this.mEnableEarMonitor);
    this.mWXLivePusherProxy.enableAudioEarMonitoring(bool6);
    String str3 = paramBundle.getString("audioVolumeType", this.mAudioVolumeType);
    setAudioVolumeType(str3);
    boolean bool7 = paramBundle.getBoolean("enableCamera", this.mEnableCamera);
    this.mWXLivePusherProxy.enablePureAudioPush(bool7 ^ true);
    setLivePusherConfig(paramBoolean, needApplyConfig(k, j, i, i1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, str1, m, n, f1, f2, f3, str3, str2, (String)localObject2, (String)localObject1, (String)localObject3));
    setEnableCamera(bool7);
    setEnableMic(paramBundle, paramBoolean);
    this.mMode = i2;
    this.mVideoAspect = k;
    this.mFocusMode = i1;
    this.mEnableCamera = bool7;
    this.mEnableAgc = bool4;
    this.mEnableAns = bool5;
    this.mEnableEarMonitor = bool6;
    this.mLocalMirror = str1;
    this.mAudioVolumeType = str3;
    this.mVideoWidth = m;
    this.mVideoHeight = n;
    this.mFrontCamera = bool1;
    this.mOrientation = ((String)localObject2);
    this.mPauseAudio = bool2;
    this.mPauseImageFilePath = str2;
    this.mMinBitrate = j;
    this.mMaxBitrate = i;
    this.mAudioQuality = ((String)localObject1);
    this.mEnableZoom = bool3;
    this.mWatermarkLeft = f1;
    this.mWatermarkTop = f2;
    this.mWatermarkWidth = f3;
    this.mWatermarkImage = ((String)localObject3);
    this.mNeedEvent = paramBundle.getBoolean("needEvent", this.mNeedEvent);
    this.mNeedBGMEvent = paramBundle.getBoolean("needBGMEvent", this.mNeedBGMEvent);
    handleRemoteMirror(paramBundle);
    handleBeatyAndWhiteness(paramBundle);
    handleAudioReverbType(paramBundle);
    handleDebug(paramBundle, paramBoolean);
  }
  
  private TXJSAdapterError playBGM(JSONObject paramJSONObject)
  {
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.optString("BGMFilePath", "");
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("playBGM filePath = ");
    paramJSONObject.append(str);
    QMLog.d("TXLivePusherJSAdapter", paramJSONObject.toString());
    if ((str != null) && (str.length() > 0))
    {
      this.mWXLivePusherProxy.playBGM(str);
      return new TXJSAdapterError();
    }
    return new TXJSAdapterError(-2, "fail");
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
        if (isStringKeyForParams(str))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("\n");
          localStringBuilder.append(str);
          localStringBuilder.append(" = ");
          localStringBuilder.append(paramBundle.getString(str));
          paramString = localStringBuilder.toString();
        }
        else if (isIntKeyForParams(str))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("\n");
          localStringBuilder.append(str);
          localStringBuilder.append(" = ");
          localStringBuilder.append(paramBundle.getInt(str));
          paramString = localStringBuilder.toString();
        }
        else if (isBooleanKeyForParams(str))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("\n");
          localStringBuilder.append(str);
          localStringBuilder.append(" = ");
          localStringBuilder.append(paramBundle.getBoolean(str));
          paramString = localStringBuilder.toString();
        }
        else if (isFloatKeyForParams(str))
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
      QMLog.d("TXLivePusherJSAdapter", paramString);
    }
  }
  
  private void safeRecycleBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bitmap recycle ");
      localStringBuilder.append(paramBitmap.toString());
      QMLog.d("TXLivePusherJSAdapter", localStringBuilder.toString());
      paramBitmap.recycle();
    }
  }
  
  private void setAudioVolumeType(String paramString)
  {
    if (paramString.equalsIgnoreCase("voicecall"))
    {
      this.mWXLivePusherProxy.setVolumeType(0);
      return;
    }
    if (paramString.equalsIgnoreCase("media")) {
      this.mWXLivePusherProxy.setVolumeType(1);
    }
  }
  
  private TXJSAdapterError setBGMPosition(JSONObject paramJSONObject)
  {
    if ((this.mBGMPlaying) && (paramJSONObject != null))
    {
      int i = paramJSONObject.optInt("BGMPosition", -1);
      if (i > 0) {
        this.mWXLivePusherProxy.setBGMPosition(i);
      }
    }
    return new TXJSAdapterError();
  }
  
  private TXJSAdapterError setBGMVolume(JSONObject paramJSONObject)
  {
    double d = 1.0D;
    if (paramJSONObject != null) {
      d = paramJSONObject.optDouble("volume", 1.0D);
    }
    this.mWXLivePusherProxy.setBGMVolume((float)d);
    return new TXJSAdapterError();
  }
  
  private void setEnableCamera(boolean paramBoolean)
  {
    if (paramBoolean != this.mEnableCamera)
    {
      if (paramBoolean)
      {
        stopPreview();
        startPreview(paramBoolean);
        return;
      }
      stopPreview();
    }
  }
  
  private void setEnableMic(Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool;
    if (paramBundle.keySet().contains("enableMic"))
    {
      bool = paramBundle.getBoolean("enableMic", this.mEnableMic);
      if (bool != this.mEnableMic) {
        if (bool)
        {
          stopAudioRecord();
          startAudioRecord(true);
        }
        else
        {
          stopAudioRecord();
        }
      }
      if ((paramBoolean) || (bool != this.mEnableMic)) {
        this.mWXLivePusherProxy.setMuted(bool ^ true);
      }
      this.mEnableMic = bool;
      this.mMute = (bool ^ true);
      return;
    }
    if (paramBundle.keySet().contains("muted"))
    {
      bool = paramBundle.getBoolean("muted", this.mMute);
      if ((paramBoolean) || (bool != this.mMute)) {
        this.mWXLivePusherProxy.setMuted(bool);
      }
      this.mMute = bool;
    }
  }
  
  private boolean setFrontCamera(Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBundle.keySet().contains("devicePosition"))
    {
      this.mDevicePosition = paramBundle.getString("devicePosition", this.mDevicePosition);
      if (this.mDevicePosition.equalsIgnoreCase("back")) {
        paramBoolean = false;
      }
      this.mWXLivePusherProxy.setFrontCamera(paramBoolean);
      bool = paramBoolean;
    }
    return bool;
  }
  
  private void setLivePusherConfig(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (paramBoolean2)) {
      this.mWXLivePusherProxy.setConfig();
    }
  }
  
  private void setLocalVideoMirror(String paramString)
  {
    if (!paramString.equalsIgnoreCase(this.mLocalMirror))
    {
      if (paramString.equalsIgnoreCase("auto"))
      {
        this.mWXLivePusherProxy.setLocalVideoMirrorType(0);
        return;
      }
      if (paramString.equalsIgnoreCase("enable"))
      {
        this.mWXLivePusherProxy.setLocalVideoMirrorType(1);
        return;
      }
      if (paramString.equalsIgnoreCase("disable")) {
        this.mWXLivePusherProxy.setLocalVideoMirrorType(2);
      }
    }
  }
  
  private void setMICVolume(JSONObject paramJSONObject)
  {
    double d = 1.0D;
    if (paramJSONObject != null) {
      d = paramJSONObject.optDouble("volume", 1.0D);
    }
    this.mWXLivePusherProxy.setMicVolume((float)d);
  }
  
  private void setPauseAudioFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mWXLivePusherProxy.setPauseFlag(3);
      return;
    }
    this.mWXLivePusherProxy.setPauseFlag(1);
  }
  
  private void setRealTimeVideoChatMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, int paramInt6)
  {
    if (paramInt1 == 6)
    {
      if (paramInt2 == 1) {
        this.mWXLivePusherProxy.setVideoResolution(13);
      } else if (paramInt2 == 2) {
        this.mWXLivePusherProxy.setVideoResolution(0);
      }
      if (isVideoWHValid(paramInt3, paramInt4)) {
        this.mWXLivePusherProxy.setVideoResolution(paramInt3, paramInt4);
      }
      if ((paramInt5 != -1) && (paramInt6 != -1) && (paramInt5 <= paramInt6))
      {
        this.mWXLivePusherProxy.setMinVideoBitrate(paramInt5);
        this.mWXLivePusherProxy.setMaxVideoBitrate(paramInt6);
      }
      if (paramString.equalsIgnoreCase("low"))
      {
        this.mWXLivePusherProxy.setAudioSampleRate(16000);
        return;
      }
      if (paramString.equalsIgnoreCase("high")) {
        this.mWXLivePusherProxy.setAudioSampleRate(48000);
      }
    }
  }
  
  private void setRenderOrientation(String paramString)
  {
    if (!paramString.equalsIgnoreCase(this.mOrientation))
    {
      if (paramString.equalsIgnoreCase("horizontal"))
      {
        adjustHomeOrientation(this.mLastAngle, paramString);
        this.mWXLivePusherProxy.setRenderRotation(90);
        return;
      }
      if (paramString.equalsIgnoreCase("vertical"))
      {
        adjustHomeOrientation(this.mLastAngle, paramString);
        this.mWXLivePusherProxy.setRenderRotation(0);
      }
    }
  }
  
  private void setWaterMark(Bundle paramBundle, float paramFloat1, float paramFloat2, float paramFloat3, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.mWXLivePusherProxy.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
      return;
    }
    if ((this.mWXLivePusherProxy.isPushing()) && (paramBundle.keySet().contains("watermarkImage"))) {
      this.mWXLivePusherProxy.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  private void startAudioRecord(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mWXLivePusherProxy.startAudioRecord();
    }
  }
  
  private void startPreview(boolean paramBoolean)
  {
    if ((!this.mIsCameraPreviewing) && (paramBoolean))
    {
      Object localObject = this.mVideoView;
      if (localObject != null) {
        this.mWXLivePusherProxy.txLivePlayer_setVisibility(0, localObject);
      }
      localObject = this.mSurface;
      if (localObject != null) {
        this.mWXLivePusherProxy.setSurface((Surface)localObject);
      }
      this.mWXLivePusherProxy.startCameraPreview(this.mVideoView);
      this.mIsCameraPreviewing = true;
    }
  }
  
  private void stopAudioRecord()
  {
    this.mWXLivePusherProxy.stopAudioRecord();
  }
  
  private void stopPreview()
  {
    this.mWXLivePusherProxy.stopCameraPreview(true);
    this.mIsCameraPreviewing = false;
  }
  
  public TXJSAdapterError enterBackground(boolean paramBoolean)
  {
    this.mPushingBeforeEnterBackground = this.mWXLivePusherProxy.isPushing();
    if (this.mPushingBeforeEnterBackground)
    {
      if (paramBoolean)
      {
        this.mForceStop = paramBoolean;
        if (this.mNeedEvent)
        {
          TXLivePushListenerReflect.ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
          if (localITXLivePushListener != null) {
            localITXLivePushListener.onPushEvent(5000, new Bundle());
          }
        }
        return operateLivePusher("stop", null);
      }
      return operateLivePusher("pause", null);
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError enterForeground()
  {
    if (this.mPushingBeforeEnterBackground)
    {
      if (this.mForceStop) {
        return operateLivePusher("start", null);
      }
      return operateLivePusher("resume", null);
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initEmbeddedLivePusher(JSONObject paramJSONObject)
  {
    paramJSONObject = adaptJsonToBundle(paramJSONObject);
    printJSParams("InitLivePusher", paramJSONObject);
    this.mVideoView = null;
    this.mPusherUrl = paramJSONObject.getString("pushUrl", "");
    this.mWXLivePusherProxy.setPusherUrl(this.mPusherUrl);
    parseAndApplyParams(paramJSONObject, true);
    this.mAutoPush = paramJSONObject.getBoolean("autopush", this.mAutoPush);
    if (this.mAutoPush)
    {
      paramJSONObject = this.mPusherUrl;
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()) && (!this.mWXLivePusherProxy.isPushing()))
      {
        QMLog.d("TXLivePusherJSAdapter", "initEmbeddedLivePusher: startPusher");
        startPreview(this.mEnableCamera);
        startAudioRecord(this.mEnableMic);
        if (this.mEnableCamera)
        {
          paramJSONObject = this.mSurface;
          if (paramJSONObject != null) {
            this.mWXLivePusherProxy.setSurface(paramJSONObject);
          }
        }
        this.mWXLivePusherProxy.startPusher(this.mPusherUrl);
      }
    }
    this.mInited = true;
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initLivePusher(Object paramObject, JSONObject paramJSONObject)
  {
    paramJSONObject = adaptJsonToBundle(paramJSONObject);
    if ((paramObject != null) && (paramJSONObject != null))
    {
      printJSParams("InitLivePusher", paramJSONObject);
      this.mVideoView = paramObject;
      this.mWXLivePusherProxy.txCloudVideoView_disableLog(Boolean.valueOf(false), this.mVideoView);
      this.mPusherUrl = paramJSONObject.getString("pushUrl", "");
      this.mWXLivePusherProxy.setPusherUrl(this.mPusherUrl);
      parseAndApplyParams(paramJSONObject, true);
      this.mAutoPush = paramJSONObject.getBoolean("autopush", this.mAutoPush);
      if (this.mAutoPush)
      {
        paramObject = this.mPusherUrl;
        if ((paramObject != null) && (!paramObject.isEmpty()) && (!this.mWXLivePusherProxy.isPushing()))
        {
          QMLog.d("TXLivePusherJSAdapter", "initLivePusher: startPusher");
          startPreview(this.mEnableCamera);
          startAudioRecord(this.mEnableMic);
          this.mWXLivePusherProxy.startPusher(this.mPusherUrl);
        }
      }
      this.mInited = true;
      return new TXJSAdapterError();
    }
    return new TXJSAdapterError(-1, "invalid params");
  }
  
  public void onBGMComplete(int paramInt)
  {
    this.mBGMPlaying = false;
    if (this.mNeedBGMEvent)
    {
      TXLivePushListenerReflect.OnBGMNotify localOnBGMNotify = this.mBGMNotifyListener;
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMComplete(paramInt);
      }
    }
  }
  
  public void onBGMProgress(long paramLong1, long paramLong2)
  {
    if (this.mNeedBGMEvent)
    {
      TXLivePushListenerReflect.OnBGMNotify localOnBGMNotify = this.mBGMNotifyListener;
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMProgress(paramLong1, paramLong2);
      }
    }
  }
  
  public void onBGMStart()
  {
    this.mBGMPlaying = true;
    if (this.mNeedBGMEvent)
    {
      TXLivePushListenerReflect.OnBGMNotify localOnBGMNotify = this.mBGMNotifyListener;
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMStart();
      }
    }
  }
  
  public void onNetStatus(Bundle paramBundle)
  {
    Object localObject1 = this.mLivePushListener;
    if (localObject1 != null) {
      ((TXLivePushListenerReflect.ITXLivePushListener)localObject1).onNetStatus(paramBundle);
    }
    if (QMLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("CPU:");
      ((StringBuilder)localObject1).append(paramBundle.getString("CPU_USAGE"));
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("RES:");
      ((StringBuilder)localObject2).append(paramBundle.getInt("VIDEO_WIDTH"));
      ((StringBuilder)localObject2).append("*");
      ((StringBuilder)localObject2).append(paramBundle.getInt("VIDEO_HEIGHT"));
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("SPD:");
      ((StringBuilder)localObject3).append(paramBundle.getInt("NET_SPEED"));
      ((StringBuilder)localObject3).append("Kbps");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("JIT:");
      ((StringBuilder)localObject4).append(paramBundle.getInt("NET_JITTER"));
      localObject4 = ((StringBuilder)localObject4).toString();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("FPS:");
      ((StringBuilder)localObject5).append(paramBundle.getInt("VIDEO_FPS"));
      localObject5 = ((StringBuilder)localObject5).toString();
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("GOP:");
      ((StringBuilder)localObject6).append(paramBundle.getInt("VIDEO_GOP"));
      ((StringBuilder)localObject6).append("s");
      localObject6 = ((StringBuilder)localObject6).toString();
      Object localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append("ARA:");
      ((StringBuilder)localObject7).append(paramBundle.getInt("AUDIO_BITRATE"));
      ((StringBuilder)localObject7).append("Kbps");
      localObject7 = ((StringBuilder)localObject7).toString();
      Object localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append("QUE:");
      ((StringBuilder)localObject8).append(paramBundle.getInt("AUDIO_CACHE"));
      ((StringBuilder)localObject8).append(" | ");
      ((StringBuilder)localObject8).append(paramBundle.getInt("VIDEO_CACHE"));
      ((StringBuilder)localObject8).append(",");
      ((StringBuilder)localObject8).append(paramBundle.getInt("V_SUM_CACHE_SIZE"));
      ((StringBuilder)localObject8).append(",");
      ((StringBuilder)localObject8).append(paramBundle.getInt("V_DEC_CACHE_SIZE"));
      ((StringBuilder)localObject8).append(" | ");
      ((StringBuilder)localObject8).append(paramBundle.getInt("AV_RECV_INTERVAL"));
      ((StringBuilder)localObject8).append(",");
      ((StringBuilder)localObject8).append(paramBundle.getInt("AV_PLAY_INTERVAL"));
      ((StringBuilder)localObject8).append(",");
      ((StringBuilder)localObject8).append(String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString());
      localObject8 = ((StringBuilder)localObject8).toString();
      Object localObject9 = new StringBuilder();
      ((StringBuilder)localObject9).append("VRA:");
      ((StringBuilder)localObject9).append(paramBundle.getInt("VIDEO_BITRATE"));
      ((StringBuilder)localObject9).append("Kbps");
      localObject9 = ((StringBuilder)localObject9).toString();
      Object localObject10 = new StringBuilder();
      ((StringBuilder)localObject10).append("DRP:");
      ((StringBuilder)localObject10).append(paramBundle.getInt("AUDIO_DROP"));
      ((StringBuilder)localObject10).append("|");
      ((StringBuilder)localObject10).append(paramBundle.getInt("VIDEO_DROP"));
      localObject10 = ((StringBuilder)localObject10).toString();
      Object localObject11 = new StringBuilder();
      ((StringBuilder)localObject11).append("SVR:");
      ((StringBuilder)localObject11).append(paramBundle.getString("SERVER_IP"));
      localObject11 = ((StringBuilder)localObject11).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AUDIO:");
      localStringBuilder.append(paramBundle.getString("AUDIO_PLAY_INFO"));
      paramBundle = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localStringBuilder.toString() });
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onNetStatus:");
      ((StringBuilder)localObject1).append(paramBundle);
      QMLog.d("TXLivePusherJSAdapter", ((StringBuilder)localObject1).toString());
    }
  }
  
  public void onPushEvent(int paramInt, Bundle paramBundle)
  {
    if ((paramInt != -1307) && (paramInt != -1313))
    {
      if (paramInt == 1003)
      {
        boolean bool = this.mFlashLight;
        if (bool) {
          this.mWXLivePusherProxy.turnOnFlashLight(bool);
        }
      }
    }
    else {
      operateLivePusher("stop", null);
    }
    if (this.mNeedEvent)
    {
      localObject = this.mLivePushListener;
      if (localObject != null) {
        ((TXLivePushListenerReflect.ITXLivePushListener)localObject).onPushEvent(paramInt, paramBundle);
      }
    }
    paramBundle = paramBundle.getString("EVT_MSG");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPushEvent: event = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" message = ");
    ((StringBuilder)localObject).append(paramBundle);
    QMLog.d("TXLivePusherJSAdapter", ((StringBuilder)localObject).toString());
  }
  
  public TXJSAdapterError operateLivePusher(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePusher");
    }
    if (paramJSONObject != null) {
      localObject1 = paramJSONObject.toString();
    } else {
      localObject1 = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("operateLivePusher: type = ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" params = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QMLog.d("TXLivePusherJSAdapter", ((StringBuilder)localObject2).toString());
    localObject2 = baseLivePusherOperate(paramString, paramJSONObject);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = cameraLivePusherOperate(paramString, paramJSONObject);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bgmLivePusherOperate(paramString, paramJSONObject);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = otherLivePusherOperate(paramString, paramJSONObject);
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return new TXJSAdapterError(-4, "invalid operate command");
  }
  
  public void setBGMNotifyListener(TXLivePushListenerReflect.OnBGMNotify paramOnBGMNotify)
  {
    this.mBGMNotifyListener = paramOnBGMNotify;
  }
  
  public void setPushListener(TXLivePushListenerReflect.ITXLivePushListener paramITXLivePushListener)
  {
    this.mLivePushListener = paramITXLivePushListener;
  }
  
  public TXJSAdapterError setSurface(Surface paramSurface)
  {
    this.mSurface = paramSurface;
    this.mWXLivePusherProxy.setSurface(this.mSurface);
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError setSurfaceSize(int paramInt1, int paramInt2)
  {
    this.mWXLivePusherProxy.setSurfaceSize(paramInt1, paramInt2);
    return new TXJSAdapterError();
  }
  
  public int startDumpAudioData(String paramString)
  {
    return this.mWXLivePusherProxy.startDumpAudioData(paramString);
  }
  
  public void stopDumpAudioData()
  {
    this.mWXLivePusherProxy.stopDumpAudioData();
  }
  
  public void takePhoto(boolean paramBoolean, TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener)
  {
    if (this.mWXLivePusherProxy.isPushing())
    {
      IWXLivePusherProxy localIWXLivePusherProxy = this.mWXLivePusherProxy;
      localIWXLivePusherProxy.snapshot(localIWXLivePusherProxy.newITXSnapshotListener(new TXLivePusherJSAdapter.1(this, paramITXSnapshotListener, paramBoolean)));
    }
  }
  
  public TXJSAdapterError unInitLivePusher()
  {
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePusher");
    }
    this.mWXLivePusherProxy.stopBGM();
    stopPreview();
    stopAudioRecord();
    this.mWXLivePusherProxy.stopPusher();
    this.mWXLivePusherProxy.setPushListener(null);
    this.mInited = false;
    return new TXJSAdapterError();
  }
  
  public void updateCurHomeOrientation(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCurHomeOrientation, orientation:");
    localStringBuilder.append(paramString);
    QMLog.d("TXLivePusherJSAdapter", localStringBuilder.toString());
    adjustHomeOrientation(this.mLastAngle, paramString);
  }
  
  public void updateHomeOrientation(IMiniAppContext paramIMiniAppContext)
  {
    try
    {
      int i = paramIMiniAppContext.getContext().getResources().getConfiguration().orientation;
      if (i == 2)
      {
        updateCurHomeOrientation("horizontal");
        return;
      }
      if (i == 1)
      {
        updateCurHomeOrientation("vertical");
        return;
      }
    }
    catch (Exception paramIMiniAppContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCurHomeOrientation get an Exception:");
      localStringBuilder.append(paramIMiniAppContext);
      QMLog.e("TXLivePusherJSAdapter", localStringBuilder.toString());
    }
  }
  
  public TXJSAdapterError updateLivePusher(JSONObject paramJSONObject)
  {
    paramJSONObject = adaptJsonToBundle(paramJSONObject);
    if (paramJSONObject == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    printJSParams("updateLivePusher", paramJSONObject);
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePusher");
    }
    parseAndApplyParams(paramJSONObject, false);
    String str1 = paramJSONObject.getString("pushUrl", this.mPusherUrl);
    if ((str1 != null) && (!str1.isEmpty()))
    {
      String str2 = this.mPusherUrl;
      if ((str2 != null) && (!str2.equalsIgnoreCase(str1)) && (this.mWXLivePusherProxy.isPushing()))
      {
        QMLog.d("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
        stopPreview();
        stopAudioRecord();
        this.mWXLivePusherProxy.stopPusher();
      }
    }
    this.mPusherUrl = str1;
    this.mWXLivePusherProxy.setPusherUrl(this.mPusherUrl);
    this.mAutoPush = paramJSONObject.getBoolean("autopush", this.mAutoPush);
    if (this.mAutoPush)
    {
      paramJSONObject = this.mPusherUrl;
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()) && (!this.mWXLivePusherProxy.isPushing()))
      {
        QMLog.d("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
        startPreview(this.mEnableCamera);
        startAudioRecord(this.mEnableMic);
        this.mWXLivePusherProxy.startPusher(this.mPusherUrl);
      }
    }
    return new TXJSAdapterError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter
 * JD-Core Version:    0.7.0.1
 */