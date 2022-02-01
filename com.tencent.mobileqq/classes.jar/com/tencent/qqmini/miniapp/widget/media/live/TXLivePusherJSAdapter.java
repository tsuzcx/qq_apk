package com.tencent.qqmini.miniapp.widget.media.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
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
  private Object mLivePushConfig;
  private TXLivePushListenerReflect.ITXLivePushListener mLivePushListener;
  private Object mLivePusher;
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
    this.mLivePushConfig = WXLivePushConfigReflect.newInstance();
    this.mLivePusher = WXLivePusherReflect.newInstance(paramContext);
    WXLivePusherReflect.setConfig(this.mLivePushConfig, this.mLivePusher);
    WXLivePusherReflect.setPushListener(TXLivePushListenerReflect.newITXLivePushListener(this), this.mLivePusher);
    WXLivePusherReflect.setBGMNofify(TXLivePushListenerReflect.newOnBGMNotify(this), this.mLivePusher);
  }
  
  private TXJSAdapterError BGMLivePusherOperate(String paramString, JSONObject paramJSONObject)
  {
    double d = 1.0D;
    if (paramString.equalsIgnoreCase("playBGM"))
    {
      paramString = "";
      if (paramJSONObject != null) {
        paramString = paramJSONObject.optString("BGMFilePath", "");
      }
      QMLog.d("TXLivePusherJSAdapter", "playBGM filePath = " + paramString);
      if ((paramString != null) && (paramString.length() > 0))
      {
        WXLivePusherReflect.playBGM(paramString, this.mLivePusher);
        return new TXJSAdapterError();
      }
      return new TXJSAdapterError(-2, "fail");
    }
    if (paramString.equalsIgnoreCase("stopBGM"))
    {
      WXLivePusherReflect.stopBGM(this.mLivePusher);
      this.mBGMPlaying = false;
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("pauseBGM"))
    {
      WXLivePusherReflect.pauseBGM(this.mLivePusher);
      this.mBGMPlaying = false;
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("resumeBGM"))
    {
      WXLivePusherReflect.resumeBGM(this.mLivePusher);
      this.mBGMPlaying = true;
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("setBGMPosition"))
    {
      if ((this.mBGMPlaying) && (paramJSONObject != null))
      {
        int i = paramJSONObject.optInt("BGMPosition", -1);
        if (i > 0) {
          WXLivePusherReflect.setBGMPosition(i, this.mLivePusher);
        }
      }
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("setBGMVolume"))
    {
      if (paramJSONObject != null) {
        d = paramJSONObject.optDouble("volume", 1.0D);
      }
      WXLivePusherReflect.setBGMVolume((float)d, this.mLivePusher);
      return new TXJSAdapterError();
    }
    if (paramString.equalsIgnoreCase("setMICVolume"))
    {
      if (paramJSONObject != null) {
        d = paramJSONObject.optDouble("volume", 1.0D);
      }
      WXLivePusherReflect.setMicVolume((float)d, this.mLivePusher);
    }
    return null;
  }
  
  private Bundle adaptJsonToBundle(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    if (paramJSONObject == null) {
      return localBundle;
    }
    if (this.pusherKeyList == null)
    {
      QMLog.e("TXLivePusherJSAdapter", "adaptJsonToBundle - pusherKeyList is null");
      return localBundle;
    }
    Iterator localIterator = this.pusherKeyList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (isStringValueKey(str)) {
        try
        {
          localBundle.putString(str, paramJSONObject.getString(str));
        }
        catch (JSONException localJSONException1) {}
      } else if (isIntKeyForParams(localJSONException1)) {
        try
        {
          localBundle.putInt(localJSONException1, paramJSONObject.getInt(localJSONException1));
        }
        catch (JSONException localJSONException2) {}
      } else if (isBooleanKeyForParams(localJSONException2)) {
        try
        {
          localBundle.putBoolean(localJSONException2, paramJSONObject.getBoolean(localJSONException2));
        }
        catch (JSONException localJSONException3) {}
      } else if ((localJSONException3.equalsIgnoreCase("watermarkLeft")) || (localJSONException3.equalsIgnoreCase("watermarkTop")) || (localJSONException3.equalsIgnoreCase("watermarkWidth"))) {
        try
        {
          localBundle.putDouble(localJSONException3, paramJSONObject.getDouble(localJSONException3));
        }
        catch (JSONException localJSONException4) {}
      }
    }
    return localBundle;
  }
  
  private void adjustHomeOrientation(int paramInt, String paramString)
  {
    int i = 3;
    QMLog.d("TXLivePusherJSAdapter", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1) {
      if (paramString.equals("horizontal")) {
        paramInt = i;
      }
    }
    for (;;)
    {
      QMLog.d("TXLivePusherJSAdapter", "adjustHomeOrientation, homeOrientation:" + paramInt);
      if (paramInt != -2147483648)
      {
        WXLivePushConfigReflect.setHomeOrientation(paramInt, this.mLivePushConfig);
        WXLivePusherReflect.setConfig(this.mLivePushConfig, this.mLivePusher);
      }
      return;
      paramInt = 0;
      continue;
      if (paramInt == 3)
      {
        if (paramString.equals("horizontal")) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
      }
      else if (paramInt == 0)
      {
        if (paramString.equals("horizontal")) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
      }
      else if (paramInt == 2)
      {
        paramInt = i;
        if (paramString.equals("horizontal")) {
          paramInt = 2;
        }
      }
      else
      {
        paramInt = -2147483648;
      }
    }
  }
  
  private void applyPushMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      WXLivePusherReflect.setVideoQuality(1, false, false, this.mLivePusher);
      WXLivePushConfigReflect.setVideoEncodeGop(5, this.mLivePushConfig);
      return;
    case 2: 
      WXLivePusherReflect.setVideoQuality(2, true, false, this.mLivePusher);
      WXLivePushConfigReflect.setVideoEncodeGop(5, this.mLivePushConfig);
      return;
    case 3: 
      WXLivePusherReflect.setVideoQuality(3, true, false, this.mLivePusher);
      WXLivePushConfigReflect.setVideoEncodeGop(5, this.mLivePushConfig);
      return;
    case 4: 
      WXLivePusherReflect.setVideoQuality(4, true, false, this.mLivePusher);
      return;
    case 5: 
      WXLivePusherReflect.setVideoQuality(5, true, false, this.mLivePusher);
      return;
    }
    WXLivePusherReflect.setVideoQuality(6, false, false, this.mLivePusher);
  }
  
  private TXJSAdapterError baseLivePusherOperate(String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = null;
    if (paramString.equalsIgnoreCase("start"))
    {
      if ((this.mPusherUrl != null) && (!this.mPusherUrl.isEmpty()) && (!WXLivePusherReflect.isPushing(this.mLivePusher)))
      {
        startPreview(this.mEnableCamera);
        startAudioRecord(this.mEnableMic);
        WXLivePusherReflect.startPusher(this.mPusherUrl, this.mLivePusher);
      }
      paramJSONObject = new TXJSAdapterError();
    }
    do
    {
      return paramJSONObject;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.mFlashLight = false;
        WXLivePusherReflect.stopBGM(this.mLivePusher);
        stopPreview();
        stopAudioRecord();
        WXLivePusherReflect.stopPusher(this.mLivePusher);
        return new TXJSAdapterError();
      }
      if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.mFlashLight) && (WXLivePusherReflect.isPushing(this.mLivePusher))) {
          WXLivePusherReflect.turnOnFlashLight(false, this.mLivePusher);
        }
        WXLivePusherReflect.pausePusher(this.mLivePusher);
        this.mBGMPlayingWhenPusherPaused = this.mBGMPlaying;
        if (this.mBGMPlayingWhenPusherPaused) {
          operateLivePusher("pauseBGM", null);
        }
        return new TXJSAdapterError();
      }
    } while (!paramString.equalsIgnoreCase("resume"));
    WXLivePusherReflect.resumePusher(this.mLivePusher);
    if (this.mBGMPlayingWhenPusherPaused) {
      operateLivePusher("resumeBGM", null);
    }
    return new TXJSAdapterError();
  }
  
  private TXJSAdapterError cameraLivePusherOperate(String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i = 0;
    if (paramString.equalsIgnoreCase("startPreview"))
    {
      if (WXLivePusherReflect.isPushing(this.mLivePusher)) {
        QMLog.d("TXLivePusherJSAdapter", "do not support startPreview when pushing");
      }
      for (;;)
      {
        return new TXJSAdapterError();
        stopPreview();
        startPreview(this.mEnableCamera);
      }
    }
    if (paramString.equalsIgnoreCase("stopPreview"))
    {
      if (WXLivePusherReflect.isPushing(this.mLivePusher)) {
        QMLog.d("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
      }
      for (;;)
      {
        return new TXJSAdapterError();
        stopPreview();
      }
    }
    if (paramString.equalsIgnoreCase("switchCamera"))
    {
      if (!this.mFrontCamera) {}
      for (;;)
      {
        this.mFrontCamera = bool1;
        WXLivePushConfigReflect.setFrontCamera(this.mFrontCamera, this.mLivePushConfig);
        WXLivePusherReflect.switchCamera(this.mLivePusher);
        return new TXJSAdapterError();
        bool1 = false;
      }
    }
    if (paramString.equalsIgnoreCase("toggleTorch"))
    {
      if (WXLivePusherReflect.isPushing(this.mLivePusher))
      {
        if (!this.mFlashLight)
        {
          bool1 = bool2;
          bool2 = WXLivePusherReflect.turnOnFlashLight(bool1, this.mLivePusher);
          if (!bool2) {
            break label240;
          }
          label204:
          this.mFlashLight = bool1;
          if (!bool2) {
            break label249;
          }
          label215:
          if (!bool2) {
            break label255;
          }
        }
        label240:
        label249:
        label255:
        for (paramString = "Success";; paramString = "Failed")
        {
          return new TXJSAdapterError(i, paramString);
          bool1 = false;
          break;
          bool1 = this.mFlashLight;
          break label204;
          i = -2;
          break label215;
        }
      }
      return new TXJSAdapterError(-2, "fail");
    }
    return null;
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
    return (paramString.equalsIgnoreCase("hide")) || (paramString.equalsIgnoreCase("autopush")) || (paramString.equalsIgnoreCase("muted")) || (paramString.equalsIgnoreCase("enableCamera")) || (paramString.equalsIgnoreCase("enableMic")) || (paramString.equalsIgnoreCase("enableAGC")) || (paramString.equalsIgnoreCase("enableANS")) || (paramString.equalsIgnoreCase("enableEarMonitor")) || (paramString.equalsIgnoreCase("backgroundMute")) || (paramString.equalsIgnoreCase("zoom")) || (paramString.equalsIgnoreCase("needEvent")) || (paramString.equalsIgnoreCase("needBGMEvent")) || (paramString.equalsIgnoreCase("debug")) || (paramString.equalsIgnoreCase("mirror")) || (paramString.equalsIgnoreCase("remoteMirror"));
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
  
  private boolean needApplyConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString1, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2, float paramFloat3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return (paramInt1 != this.mVideoAspect) || (paramInt2 != this.mMinBitrate) || (paramInt3 != this.mMaxBitrate) || (paramInt4 != this.mFocusMode) || (paramBoolean1 != this.mFrontCamera) || (paramBoolean2 != this.mPauseAudio) || (paramBoolean3 != this.mEnableZoom) || (paramBoolean4 != this.mEnableAgc) || (paramBoolean5 != this.mEnableAns) || (paramBoolean6 != this.mEnableEarMonitor) || (paramBoolean7 != this.mEnableCamera) || (!paramString1.equalsIgnoreCase(this.mLocalMirror)) || (paramInt5 != this.mVideoWidth) || (paramInt6 != this.mVideoHeight) || (paramFloat1 != this.mWatermarkLeft) || (paramFloat2 != this.mWatermarkTop) || (paramFloat3 != this.mWatermarkWidth) || (!paramString2.equalsIgnoreCase(this.mAudioVolumeType)) || (!paramString3.equalsIgnoreCase(this.mPauseImageFilePath)) || (!paramString4.equalsIgnoreCase(this.mOrientation)) || (!paramString5.equalsIgnoreCase(this.mAudioQuality)) || (!paramString6.equalsIgnoreCase(this.mWatermarkImage));
  }
  
  private TXJSAdapterError otherLivePusherOperate(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = null;
    int i = -2;
    int j = 0;
    if (paramString.equalsIgnoreCase("sendMessage"))
    {
      paramString = localObject;
      if (paramJSONObject != null) {
        paramString = paramJSONObject.optString("msg");
      }
      if (paramString != null)
      {
        boolean bool = WXLivePusherReflect.sendMessageEx(paramString.getBytes(), this.mLivePusher);
        if (bool) {
          i = 0;
        }
        if (bool) {}
        for (paramString = "Success";; paramString = "Failed") {
          return new TXJSAdapterError(i, paramString);
        }
      }
      return new TXJSAdapterError(-2, "fail");
    }
    if (paramString.equalsIgnoreCase("setAudioReverbType"))
    {
      i = j;
      if (paramJSONObject != null) {
        i = paramJSONObject.optInt("audioReverbType", 0);
      }
      WXLivePusherReflect.setReverb(i, this.mLivePusher);
      return new TXJSAdapterError();
    }
    return null;
  }
  
  private void parseAndApplyParams(Bundle paramBundle, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0)) {
      return;
    }
    int i1 = paramBundle.getInt("mode", this.mMode);
    if ((paramBoolean) || (i1 != this.mMode)) {
      applyPushMode(i1);
    }
    int m = this.mMinBitrate;
    int n = this.mMaxBitrate;
    int i = paramBundle.getInt("minBitrate", -1);
    int j = paramBundle.getInt("maxBitrate", -1);
    int k;
    if (i > j)
    {
      QMLog.e("TXLivePusherJSAdapter", "parseAndApplyParams -> swap min and max bitrate, may be something error. min = " + i + " max = " + j);
      k = j;
    }
    for (;;)
    {
      if ((k != -1) && (i != -1))
      {
        j = k;
        if (k < 200) {
          j = 200;
        }
        k = i;
        if (i > 1800) {
          k = 1800;
        }
        if (j > k) {}
      }
      for (;;)
      {
        i = paramBundle.getInt("aspect", this.mVideoAspect);
        m = paramBundle.getInt("videoWidth", this.mVideoWidth);
        n = paramBundle.getInt("videoHeight", this.mVideoHeight);
        String str1 = paramBundle.getString("audioQuality", this.mAudioQuality);
        setRealTimeVideoChatMode(i1, i, m, n, str1, j, k);
        int i2 = paramBundle.getInt("focusMode", this.mFocusMode);
        boolean bool1;
        String str2;
        if (i2 != 0)
        {
          bool1 = true;
          WXLivePushConfigReflect.setTouchFocus(bool1, this.mLivePushConfig);
          boolean bool2 = setFrontCamera(paramBundle, this.mFrontCamera);
          str2 = paramBundle.getString("orientation", this.mOrientation);
          if (!str2.equalsIgnoreCase(this.mOrientation))
          {
            if (!str2.equalsIgnoreCase("horizontal")) {
              break label1082;
            }
            adjustHomeOrientation(this.mLastAngle, str2);
            WXLivePusherReflect.setRenderRotation(90, this.mLivePusher);
          }
          label348:
          String str3 = paramBundle.getString("localMirror", this.mLocalMirror);
          setLocalVideoMirror(str3);
          String str4 = paramBundle.getString("backgroundImage", this.mPauseImageFilePath);
          WXLivePushConfigReflect.setPauseImg(BitmapFactory.decodeFile(str4), this.mLivePushConfig);
          boolean bool3 = paramBundle.getBoolean("backgroundMute", this.mPauseAudio);
          setPauseAudioFlag(bool3);
          boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
          WXLivePushConfigReflect.setEnableZoom(bool4, this.mLivePushConfig);
          float f1 = paramBundle.getFloat("watermarkLeft", this.mWatermarkLeft);
          float f2 = paramBundle.getFloat("watermarkTop", this.mWatermarkTop);
          float f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
          String str5 = paramBundle.getString("watermarkImage", this.mWatermarkImage);
          setWaterMark(paramBundle, f1, f2, f3, BitmapFactory.decodeFile(str5));
          boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
          WXLivePushConfigReflect.enableAGC(bool5, this.mLivePushConfig);
          boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
          WXLivePushConfigReflect.enableANS(bool6, this.mLivePushConfig);
          boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.mEnableEarMonitor);
          WXLivePushConfigReflect.enableAudioEarMonitoring(bool7, this.mLivePushConfig);
          String str6 = paramBundle.getString("audioVolumeType", this.mAudioVolumeType);
          setAudioVolumeType(str6);
          boolean bool8 = paramBundle.getBoolean("enableCamera", this.mEnableCamera);
          if (bool8) {
            break label1113;
          }
          bool1 = true;
          label605:
          WXLivePushConfigReflect.enablePureAudioPush(bool1, this.mLivePushConfig);
          bool1 = needApplyConfig(i, j, k, i2, bool2, bool3, bool4, bool5, bool6, bool7, bool8, str3, m, n, f1, f2, f3, str6, str4, str2, str1, str5);
          if ((paramBoolean) || (bool1)) {
            WXLivePusherReflect.setConfig(this.mLivePushConfig, this.mLivePusher);
          }
          if (bool8 != this.mEnableCamera)
          {
            if (!bool8) {
              break label1119;
            }
            stopPreview();
            startPreview(bool8);
          }
          label707:
          setEnableMic(paramBundle, paramBoolean);
          this.mMode = i1;
          this.mVideoAspect = i;
          this.mFocusMode = i2;
          this.mEnableCamera = bool8;
          this.mEnableAgc = bool5;
          this.mEnableAns = bool6;
          this.mEnableEarMonitor = bool7;
          this.mLocalMirror = str3;
          this.mAudioVolumeType = str6;
          this.mVideoWidth = m;
          this.mVideoHeight = n;
          this.mFrontCamera = bool2;
          this.mOrientation = str2;
          this.mPauseAudio = bool3;
          this.mPauseImageFilePath = str4;
          this.mMinBitrate = j;
          this.mMaxBitrate = k;
          this.mAudioQuality = str1;
          this.mEnableZoom = bool4;
          this.mWatermarkLeft = f1;
          this.mWatermarkTop = f2;
          this.mWatermarkWidth = f3;
          this.mWatermarkImage = str5;
          this.mNeedEvent = paramBundle.getBoolean("needEvent", this.mNeedEvent);
          this.mNeedBGMEvent = paramBundle.getBoolean("needBGMEvent", this.mNeedBGMEvent);
          bool1 = this.mRemoteMirror;
          if (!paramBundle.keySet().contains("remoteMirror")) {
            break label1126;
          }
          bool1 = paramBundle.getBoolean("remoteMirror");
        }
        for (;;)
        {
          if (bool1 != this.mRemoteMirror) {
            WXLivePusherReflect.setMirror(bool1, this.mLivePusher);
          }
          this.mRemoteMirror = bool1;
          i = paramBundle.getInt("beauty", this.mBeauty);
          j = paramBundle.getInt("whiteness", this.mWhiteness);
          if (i != this.mBeauty) {
            WXLivePusherReflect.setBeautyFilter(0, i, j, 2, this.mLivePusher);
          }
          this.mBeauty = i;
          this.mWhiteness = j;
          i = paramBundle.getInt("audioReverbType", this.mAudioReverbType);
          if (i != this.mAudioReverbType) {
            WXLivePusherReflect.setReverb(i, this.mLivePusher);
          }
          this.mAudioReverbType = i;
          bool1 = paramBundle.getBoolean("debug", this.mDebug);
          if ((paramBoolean) || (bool1 != this.mDebug)) {
            WXLivePusherReflect.showDebugLog(bool1, this.mLivePusher);
          }
          this.mDebug = bool1;
          return;
          bool1 = false;
          break;
          label1082:
          if (!str2.equalsIgnoreCase("vertical")) {
            break label348;
          }
          adjustHomeOrientation(this.mLastAngle, str2);
          WXLivePusherReflect.setRenderRotation(0, this.mLivePusher);
          break label348;
          label1113:
          bool1 = false;
          break label605;
          label1119:
          stopPreview();
          break label707;
          label1126:
          if (paramBundle.keySet().contains("mirror")) {
            bool1 = paramBundle.getBoolean("mirror");
          }
        }
        k = n;
        j = m;
      }
      k = i;
      i = j;
    }
  }
  
  private void printJSParams(String paramString, Bundle paramBundle)
  {
    if (QMLog.isColorLevel())
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (isStringKeyForParams(str)) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
        } else if (isIntKeyForParams(str)) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
        } else if (isBooleanKeyForParams(str)) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
        } else if (isFloatKeyForParams(str)) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
        }
      }
      QMLog.d("TXLivePusherJSAdapter", paramString);
    }
  }
  
  private void safeRecycleBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      QMLog.d("TXLivePusherJSAdapter", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
  }
  
  private void setAudioVolumeType(String paramString)
  {
    if (paramString.equalsIgnoreCase("voicecall")) {
      WXLivePushConfigReflect.setVolumeType(0, this.mLivePushConfig);
    }
    while (!paramString.equalsIgnoreCase("media")) {
      return;
    }
    WXLivePushConfigReflect.setVolumeType(1, this.mLivePushConfig);
  }
  
  private void setEnableMic(Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool1 = true;
    if (paramBundle.keySet().contains("enableMic"))
    {
      bool2 = paramBundle.getBoolean("enableMic", this.mEnableMic);
      if (bool2 != this.mEnableMic)
      {
        if (bool2)
        {
          stopAudioRecord();
          startAudioRecord(true);
        }
      }
      else
      {
        if ((paramBoolean) || (bool2 != this.mEnableMic))
        {
          if (bool2) {
            break label107;
          }
          paramBoolean = true;
          WXLivePusherReflect.setMuted(paramBoolean, this.mLivePusher);
        }
        this.mEnableMic = bool2;
        if (bool2) {
          break label112;
        }
        paramBoolean = bool1;
        this.mMute = paramBoolean;
      }
    }
    label107:
    label112:
    while (!paramBundle.keySet().contains("muted")) {
      for (;;)
      {
        boolean bool2;
        return;
        stopAudioRecord();
        continue;
        paramBoolean = false;
        continue;
        paramBoolean = false;
      }
    }
    bool1 = paramBundle.getBoolean("muted", this.mMute);
    if ((paramBoolean) || (bool1 != this.mMute)) {
      WXLivePusherReflect.setMuted(bool1, this.mLivePusher);
    }
    this.mMute = bool1;
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
      WXLivePushConfigReflect.setFrontCamera(paramBoolean, this.mLivePushConfig);
      bool = paramBoolean;
    }
    return bool;
  }
  
  private void setLocalVideoMirror(String paramString)
  {
    if (!paramString.equalsIgnoreCase(this.mLocalMirror))
    {
      if (!paramString.equalsIgnoreCase("auto")) {
        break label29;
      }
      WXLivePusherReflect.setLocalVideoMirrorType(0, this.mLivePushConfig);
    }
    label29:
    do
    {
      return;
      if (paramString.equalsIgnoreCase("enable"))
      {
        WXLivePusherReflect.setLocalVideoMirrorType(1, this.mLivePushConfig);
        return;
      }
    } while (!paramString.equalsIgnoreCase("disable"));
    WXLivePusherReflect.setLocalVideoMirrorType(2, this.mLivePushConfig);
  }
  
  private void setPauseAudioFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WXLivePushConfigReflect.setPauseFlag(3, this.mLivePushConfig);
      return;
    }
    WXLivePushConfigReflect.setPauseFlag(1, this.mLivePushConfig);
  }
  
  private void setRealTimeVideoChatMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, int paramInt6)
  {
    if (paramInt1 == 6)
    {
      if (paramInt2 != 1) {
        break label113;
      }
      WXLivePushConfigReflect.setVideoResolution(13, this.mLivePushConfig);
    }
    label113:
    do
    {
      for (;;)
      {
        if ((paramInt3 > 0) && (paramInt3 <= 1920) && (paramInt4 > 0) && (paramInt4 <= 1920)) {
          WXLivePushConfigReflect.setVideoResolution(paramInt3, paramInt4, this.mLivePushConfig);
        }
        if ((paramInt5 != -1) && (paramInt6 != -1) && (paramInt5 <= paramInt6))
        {
          WXLivePushConfigReflect.setMinVideoBitrate(paramInt5, this.mLivePushConfig);
          WXLivePushConfigReflect.setMaxVideoBitrate(paramInt6, this.mLivePushConfig);
        }
        if (!paramString.equalsIgnoreCase("low")) {
          break;
        }
        WXLivePushConfigReflect.setAudioSampleRate(16000, this.mLivePushConfig);
        return;
        if (paramInt2 == 2) {
          WXLivePushConfigReflect.setVideoResolution(0, this.mLivePushConfig);
        }
      }
    } while (!paramString.equalsIgnoreCase("high"));
    WXLivePushConfigReflect.setAudioSampleRate(48000, this.mLivePushConfig);
  }
  
  private void setWaterMark(Bundle paramBundle, float paramFloat1, float paramFloat2, float paramFloat3, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      WXLivePushConfigReflect.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3, this.mLivePushConfig);
    }
    while ((!WXLivePusherReflect.isPushing(this.mLivePusher)) || (!paramBundle.keySet().contains("watermarkImage"))) {
      return;
    }
    WXLivePushConfigReflect.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3, this.mLivePushConfig);
  }
  
  private void startAudioRecord(boolean paramBoolean)
  {
    if (paramBoolean) {
      WXLivePusherReflect.startAudioRecord(this.mLivePusher);
    }
  }
  
  private void startPreview(boolean paramBoolean)
  {
    if ((!this.mIsCameraPreviewing) && (paramBoolean))
    {
      if (this.mVideoView != null) {
        txLivePlayer_setVisibility(0, this.mVideoView);
      }
      if (this.mSurface != null) {
        WXLivePusherReflect.setSurface(this.mSurface, this.mLivePusher);
      }
      WXLivePusherReflect.startCameraPreview(this.mVideoView, this.mLivePusher);
      this.mIsCameraPreviewing = true;
    }
  }
  
  private void stopAudioRecord()
  {
    WXLivePusherReflect.stopAudioRecord(this.mLivePusher);
  }
  
  private void stopPreview()
  {
    WXLivePusherReflect.stopCameraPreview(true, this.mLivePusher);
    this.mIsCameraPreviewing = false;
  }
  
  private void txCloudVideoView_disableLog(Boolean paramBoolean, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "disableLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayer_setVisibility(int paramInt, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setVisibility", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public TXJSAdapterError enterBackground(boolean paramBoolean)
  {
    this.mPushingBeforeEnterBackground = WXLivePusherReflect.isPushing(this.mLivePusher);
    if (this.mPushingBeforeEnterBackground)
    {
      if (paramBoolean)
      {
        this.mForceStop = paramBoolean;
        if ((this.mNeedEvent) && (this.mLivePushListener != null)) {
          this.mLivePushListener.onPushEvent(5000, new Bundle());
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
    WXLivePusherReflect.setPusherUrl(this.mPusherUrl, this.mLivePusher);
    parseAndApplyParams(paramJSONObject, true);
    this.mAutoPush = paramJSONObject.getBoolean("autopush", this.mAutoPush);
    if ((this.mAutoPush) && (this.mPusherUrl != null) && (!this.mPusherUrl.isEmpty()) && (!WXLivePusherReflect.isPushing(this.mLivePusher)))
    {
      QMLog.d("TXLivePusherJSAdapter", "initEmbeddedLivePusher: startPusher");
      startPreview(this.mEnableCamera);
      startAudioRecord(this.mEnableMic);
      if ((this.mEnableCamera) && (this.mSurface != null)) {
        WXLivePusherReflect.setSurface(this.mSurface, this.mLivePusher);
      }
      WXLivePusherReflect.startPusher(this.mPusherUrl, this.mLivePusher);
    }
    this.mInited = true;
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initLivePusher(Object paramObject, JSONObject paramJSONObject)
  {
    paramJSONObject = adaptJsonToBundle(paramJSONObject);
    if ((paramObject == null) || (paramJSONObject == null)) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    printJSParams("InitLivePusher", paramJSONObject);
    this.mVideoView = paramObject;
    txCloudVideoView_disableLog(Boolean.valueOf(false), this.mVideoView);
    this.mPusherUrl = paramJSONObject.getString("pushUrl", "");
    WXLivePusherReflect.setPusherUrl(this.mPusherUrl, this.mLivePusher);
    parseAndApplyParams(paramJSONObject, true);
    this.mAutoPush = paramJSONObject.getBoolean("autopush", this.mAutoPush);
    if ((this.mAutoPush) && (this.mPusherUrl != null) && (!this.mPusherUrl.isEmpty()) && (!WXLivePusherReflect.isPushing(this.mLivePusher)))
    {
      QMLog.d("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      startPreview(this.mEnableCamera);
      startAudioRecord(this.mEnableMic);
      WXLivePusherReflect.startPusher(this.mPusherUrl, this.mLivePusher);
    }
    this.mInited = true;
    return new TXJSAdapterError();
  }
  
  public void notifyOrientationChanged(int paramInt)
  {
    this.mHandler.post(new TXLivePusherJSAdapter.1(this, paramInt));
  }
  
  public void onBGMComplete(int paramInt)
  {
    this.mBGMPlaying = false;
    if ((this.mNeedBGMEvent) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMComplete(paramInt);
    }
  }
  
  public void onBGMProgress(long paramLong1, long paramLong2)
  {
    if ((this.mNeedBGMEvent) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMProgress(paramLong1, paramLong2);
    }
  }
  
  public void onBGMStart()
  {
    this.mBGMPlaying = true;
    if ((this.mNeedBGMEvent) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMStart();
    }
  }
  
  public void onNetStatus(Bundle paramBundle)
  {
    if (this.mLivePushListener != null) {
      this.mLivePushListener.onNetStatus(paramBundle);
    }
    if (QMLog.isColorLevel())
    {
      paramBundle = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") });
      QMLog.d("TXLivePusherJSAdapter", "onNetStatus:" + paramBundle);
    }
  }
  
  public void onPushEvent(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == -1307) || (paramInt == -1313)) {
      operateLivePusher("stop", null);
    }
    for (;;)
    {
      if ((this.mNeedEvent) && (this.mLivePushListener != null)) {
        this.mLivePushListener.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      QMLog.d("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      return;
      if ((paramInt == 1003) && (this.mFlashLight)) {
        WXLivePusherReflect.turnOnFlashLight(this.mFlashLight, this.mLivePusher);
      }
    }
  }
  
  public TXJSAdapterError operateLivePusher(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      paramString = new TXJSAdapterError(-1, "invalid params");
    }
    Object localObject1;
    do
    {
      return paramString;
      if (!this.mInited) {
        return new TXJSAdapterError(-3, "uninited livePusher");
      }
      localObject1 = "";
      if (paramJSONObject != null) {
        localObject1 = paramJSONObject.toString();
      }
      QMLog.d("TXLivePusherJSAdapter", "operateLivePusher: type = " + paramString + " params = " + (String)localObject1);
      Object localObject2 = baseLivePusherOperate(paramString, paramJSONObject);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = cameraLivePusherOperate(paramString, paramJSONObject);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = BGMLivePusherOperate(paramString, paramJSONObject);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = otherLivePusherOperate(paramString, paramJSONObject);
      }
      paramString = (String)localObject1;
    } while (localObject1 != null);
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
    WXLivePusherReflect.setSurface(this.mSurface, this.mLivePusher);
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError setSurfaceSize(int paramInt1, int paramInt2)
  {
    WXLivePusherReflect.setSurfaceSize(paramInt1, paramInt2, this.mLivePusher);
    return new TXJSAdapterError();
  }
  
  public int startDumpAudioData(String paramString)
  {
    return WXLivePusherReflect.startDumpAudioData(paramString, this.mLivePusher);
  }
  
  public void stopDumpAudioData()
  {
    WXLivePusherReflect.stopDumpAudioData(this.mLivePusher);
  }
  
  public void takePhoto(boolean paramBoolean, TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener)
  {
    if ((this.mLivePusher != null) && (WXLivePusherReflect.isPushing(this.mLivePusher))) {
      WXLivePusherReflect.snapshot(TXLivePushListenerReflect.newITXSnapshotListener(new TXLivePusherJSAdapter.2(this, paramITXSnapshotListener, paramBoolean)), this.mLivePusher);
    }
  }
  
  public TXJSAdapterError unInitLivePusher()
  {
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePusher");
    }
    WXLivePusherReflect.stopBGM(this.mLivePusher);
    stopPreview();
    stopAudioRecord();
    WXLivePusherReflect.stopPusher(this.mLivePusher);
    WXLivePusherReflect.setPushListener(null, this.mLivePusher);
    this.mInited = false;
    return new TXJSAdapterError();
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
    String str = paramJSONObject.getString("pushUrl", this.mPusherUrl);
    if ((str != null) && (!str.isEmpty()) && (this.mPusherUrl != null) && (!this.mPusherUrl.equalsIgnoreCase(str)) && (WXLivePusherReflect.isPushing(this.mLivePusher)))
    {
      QMLog.d("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      stopPreview();
      stopAudioRecord();
      WXLivePusherReflect.stopPusher(this.mLivePusher);
    }
    this.mPusherUrl = str;
    WXLivePusherReflect.setPusherUrl(this.mPusherUrl, this.mLivePusher);
    this.mAutoPush = paramJSONObject.getBoolean("autopush", this.mAutoPush);
    if ((this.mAutoPush) && (this.mPusherUrl != null) && (!this.mPusherUrl.isEmpty()) && (!WXLivePusherReflect.isPushing(this.mLivePusher)))
    {
      QMLog.d("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      startPreview(this.mEnableCamera);
      startAudioRecord(this.mEnableMic);
      WXLivePusherReflect.startPusher(this.mPusherUrl, this.mLivePusher);
    }
    return new TXJSAdapterError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter
 * JD-Core Version:    0.7.0.1
 */