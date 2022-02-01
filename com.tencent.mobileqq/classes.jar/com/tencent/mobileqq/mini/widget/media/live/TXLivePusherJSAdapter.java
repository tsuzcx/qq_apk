package com.tencent.mobileqq.mini.widget.media.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import bmio;
import com.tencent.qphone.base.util.QLog;
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
  private boolean mAutoPush;
  private TXLivePushListenerReflect.OnBGMNotify mBGMNotifyListener;
  private boolean mBGMPlaying;
  private boolean mBGMPlayingWhenPusherPaused;
  private int mBeauty = 5;
  private Context mContext;
  private boolean mDebug;
  private String mDevicePosition = "front";
  private boolean mEnableAgc;
  private boolean mEnableAns;
  private boolean mEnableCamera = true;
  private boolean mEnableEarMonitor;
  private boolean mEnableMic = true;
  private boolean mEnableZoom = true;
  private boolean mFlashLight;
  private int mFocusMode;
  private boolean mForceStop;
  private boolean mFrontCamera = true;
  private Handler mHandler;
  private boolean mInited;
  private boolean mIsCameraPreviewing;
  private int mLastAngle = 0;
  private Object mLivePushConfig;
  private TXLivePushListenerReflect.ITXLivePushListener mLivePushListener;
  private Object mLivePusher;
  private String mLocalMirror = "auto";
  private int mMaxBitrate = -1;
  private int mMinBitrate = -1;
  private int mMode = 1;
  private boolean mMute;
  private boolean mNeedBGMEvent;
  private boolean mNeedEvent;
  private String mOrientation = "vertical";
  private boolean mPauseAudio;
  private String mPauseImageFilePath = "";
  private String mPusherUrl;
  private boolean mPushingBeforeEnterBackground;
  private boolean mRemoteMirror;
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
  
  private Bundle adaptJsonToBundle(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    if (paramJSONObject == null) {
      return localBundle;
    }
    if (this.pusherKeyList == null)
    {
      QLog.e("TXLivePusherJSAdapter", 1, "adaptJsonToBundle - pusherKeyList is null");
      return localBundle;
    }
    Iterator localIterator = this.pusherKeyList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.equalsIgnoreCase("pushUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("backgroundImage")) || (str.equalsIgnoreCase("audioQuality")) || (str.equalsIgnoreCase("watermarkImage")) || (str.equalsIgnoreCase("audioVolumeType")) || (str.equalsIgnoreCase("localMirror")) || (str.equalsIgnoreCase("devicePosition"))) {
        try
        {
          localBundle.putString(str, paramJSONObject.getString(str));
        }
        catch (JSONException localJSONException1) {}
      } else if ((localJSONException1.equalsIgnoreCase("mode")) || (localJSONException1.equalsIgnoreCase("focusMode")) || (localJSONException1.equalsIgnoreCase("beauty")) || (localJSONException1.equalsIgnoreCase("whiteness")) || (localJSONException1.equalsIgnoreCase("aspect")) || (localJSONException1.equalsIgnoreCase("videoWidth")) || (localJSONException1.equalsIgnoreCase("videoHeight")) || (localJSONException1.equalsIgnoreCase("audioReverbType")) || (localJSONException1.equalsIgnoreCase("minBitrate")) || (localJSONException1.equalsIgnoreCase("maxBitrate"))) {
        try
        {
          localBundle.putInt(localJSONException1, paramJSONObject.getInt(localJSONException1));
        }
        catch (JSONException localJSONException2) {}
      } else if ((localJSONException2.equalsIgnoreCase("hide")) || (localJSONException2.equalsIgnoreCase("autopush")) || (localJSONException2.equalsIgnoreCase("muted")) || (localJSONException2.equalsIgnoreCase("enableCamera")) || (localJSONException2.equalsIgnoreCase("enableMic")) || (localJSONException2.equalsIgnoreCase("enableAGC")) || (localJSONException2.equalsIgnoreCase("enableANS")) || (localJSONException2.equalsIgnoreCase("backgroundMute")) || (localJSONException2.equalsIgnoreCase("zoom")) || (localJSONException2.equalsIgnoreCase("needEvent")) || (localJSONException2.equalsIgnoreCase("needBGMEvent")) || (localJSONException2.equalsIgnoreCase("debug")) || (localJSONException2.equalsIgnoreCase("mirror")) || (localJSONException2.equalsIgnoreCase("remoteMirror")) || (localJSONException2.equalsIgnoreCase("enableEarMonitor"))) {
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
    QLog.d("TXLivePusherJSAdapter", 2, "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1) {
      if (paramString.equals("horizontal")) {
        paramInt = i;
      }
    }
    for (;;)
    {
      QLog.d("TXLivePusherJSAdapter", 2, "adjustHomeOrientation, homeOrientation:" + paramInt);
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
  
  private void parseAndApplyParams(Bundle paramBundle, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0)) {
      return;
    }
    int i1 = paramBundle.getInt("mode", this.mMode);
    if ((paramBoolean) || (i1 != this.mMode)) {}
    int m;
    int n;
    int i;
    int j;
    int k;
    switch (i1)
    {
    default: 
      m = this.mMinBitrate;
      n = this.mMaxBitrate;
      i = paramBundle.getInt("minBitrate", -1);
      j = paramBundle.getInt("maxBitrate", -1);
      if (i > j)
      {
        QLog.e("TXLivePusherJSAdapter", 1, "parseAndApplyParams -> swap min and max bitrate, may be something error. min = " + i + " max = " + j);
        k = j;
      }
      break;
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
      for (i = j;; i = m)
      {
        m = paramBundle.getInt("aspect", this.mVideoAspect);
        n = paramBundle.getInt("videoWidth", this.mVideoWidth);
        int i2 = paramBundle.getInt("videoHeight", this.mVideoHeight);
        String str1 = paramBundle.getString("audioQuality", this.mAudioQuality);
        label296:
        boolean bool1;
        label391:
        label412:
        boolean bool2;
        String str2;
        label544:
        String str3;
        label587:
        float f1;
        label646:
        float f2;
        float f3;
        Object localObject2;
        if (i1 == 6)
        {
          if (m == 1)
          {
            WXLivePushConfigReflect.setVideoResolution(13, this.mLivePushConfig);
            if ((n > 0) && (n <= 1920) && (i2 > 0) && (i2 <= 1920)) {
              WXLivePushConfigReflect.setVideoResolution(n, i2, this.mLivePushConfig);
            }
            if ((i != -1) && (k != -1) && (i <= k))
            {
              WXLivePushConfigReflect.setMinVideoBitrate(i, this.mLivePushConfig);
              WXLivePushConfigReflect.setMaxVideoBitrate(k, this.mLivePushConfig);
            }
            if (!str1.equalsIgnoreCase("low")) {
              break label1724;
            }
            WXLivePushConfigReflect.setAudioSampleRate(16000, this.mLivePushConfig);
          }
        }
        else
        {
          int i3 = paramBundle.getInt("focusMode", this.mFocusMode);
          if (i3 == 0) {
            break label1747;
          }
          bool1 = true;
          WXLivePushConfigReflect.setTouchFocus(bool1, this.mLivePushConfig);
          bool2 = this.mFrontCamera;
          bool1 = bool2;
          if (paramBundle.keySet().contains("devicePosition"))
          {
            this.mDevicePosition = paramBundle.getString("devicePosition", this.mDevicePosition);
            bool1 = bool2;
            if (this.mDevicePosition.equalsIgnoreCase("back")) {
              bool1 = false;
            }
            WXLivePushConfigReflect.setFrontCamera(bool1, this.mLivePushConfig);
          }
          str2 = paramBundle.getString("orientation", this.mOrientation);
          if (!str2.equalsIgnoreCase(this.mOrientation))
          {
            if (!str2.equalsIgnoreCase("horizontal")) {
              break label1753;
            }
            adjustHomeOrientation(this.mLastAngle, str2);
            WXLivePusherReflect.setRenderRotation(90, this.mLivePusher);
          }
          str3 = paramBundle.getString("localMirror", this.mLocalMirror);
          if (!str3.equalsIgnoreCase(this.mLocalMirror))
          {
            if (!str3.equalsIgnoreCase("auto")) {
              break label1784;
            }
            WXLivePusherReflect.setLocalVideoMirrorType(0, this.mLivePushConfig);
          }
          String str4 = paramBundle.getString("backgroundImage", this.mPauseImageFilePath);
          Object localObject1 = BitmapFactory.decodeFile(str4);
          if (localObject1 != null) {
            WXLivePushConfigReflect.setPauseImg((Bitmap)localObject1, this.mLivePushConfig);
          }
          boolean bool3 = paramBundle.getBoolean("backgroundMute", this.mPauseAudio);
          if (!bool3) {
            break label1828;
          }
          WXLivePushConfigReflect.setPauseFlag(3, this.mLivePushConfig);
          boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
          WXLivePushConfigReflect.setEnableZoom(bool4, this.mLivePushConfig);
          f1 = paramBundle.getFloat("watermarkLeft", this.mWatermarkLeft);
          f2 = paramBundle.getFloat("watermarkTop", this.mWatermarkTop);
          f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
          localObject1 = paramBundle.getString("watermarkImage", this.mWatermarkImage);
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          if (localObject2 == null) {
            break label1839;
          }
          WXLivePushConfigReflect.setWatermark((Bitmap)localObject2, f1, f2, f3, this.mLivePushConfig);
          label745:
          boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
          WXLivePushConfigReflect.enableAGC(bool5, this.mLivePushConfig);
          boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
          WXLivePushConfigReflect.enableANS(bool6, this.mLivePushConfig);
          boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.mEnableEarMonitor);
          WXLivePushConfigReflect.enableAudioEarMonitoring(bool7, this.mLivePushConfig);
          localObject2 = paramBundle.getString("audioVolumeType", this.mAudioVolumeType);
          if (!((String)localObject2).equalsIgnoreCase("voicecall")) {
            break label1881;
          }
          WXLivePushConfigReflect.setVolumeType(0, this.mLivePushConfig);
          label842:
          boolean bool8 = paramBundle.getBoolean("enableCamera", this.mEnableCamera);
          if (bool8) {
            break label1903;
          }
          bool2 = true;
          label863:
          WXLivePushConfigReflect.enablePureAudioPush(bool2, this.mLivePushConfig);
          j = 0;
          if ((m != this.mVideoAspect) || (i != this.mMinBitrate) || (k != this.mMaxBitrate) || (i3 != this.mFocusMode) || (bool1 != this.mFrontCamera) || (bool3 != this.mPauseAudio) || (bool4 != this.mEnableZoom) || (bool5 != this.mEnableAgc) || (bool6 != this.mEnableAns) || (bool7 != this.mEnableEarMonitor) || (bool8 != this.mEnableCamera) || (!str3.equalsIgnoreCase(this.mLocalMirror)) || (n != this.mVideoWidth) || (i2 != this.mVideoHeight) || (f1 != this.mWatermarkLeft) || (f2 != this.mWatermarkTop) || (f3 != this.mWatermarkWidth) || (!((String)localObject2).equalsIgnoreCase(this.mAudioVolumeType)) || (!str4.equalsIgnoreCase(this.mPauseImageFilePath)) || (!str2.equalsIgnoreCase(this.mOrientation)) || (!str1.equalsIgnoreCase(this.mAudioQuality)) || (!((String)localObject1).equalsIgnoreCase(this.mWatermarkImage))) {
            j = 1;
          }
          if ((paramBoolean) || (j != 0)) {
            WXLivePusherReflect.setConfig(this.mLivePushConfig, this.mLivePusher);
          }
          if (bool8 != this.mEnableCamera)
          {
            if (!bool8) {
              break label1909;
            }
            stopPreview();
            startPreview(bool8);
          }
          label1140:
          if (!paramBundle.keySet().contains("enableMic")) {
            break label1935;
          }
          boolean bool9 = paramBundle.getBoolean("enableMic", this.mEnableMic);
          if (bool9 != this.mEnableMic)
          {
            if (!bool9) {
              break label1916;
            }
            stopAudioRecord();
            startAudioRecord(true);
          }
          label1191:
          if ((paramBoolean) || (bool9 != this.mEnableMic))
          {
            if (bool9) {
              break label1923;
            }
            bool2 = true;
            label1212:
            WXLivePusherReflect.setMuted(bool2, this.mLivePusher);
          }
          this.mEnableMic = bool9;
          if (bool9) {
            break label1929;
          }
          bool2 = true;
          label1235:
          this.mMute = bool2;
          label1241:
          this.mMode = i1;
          this.mVideoAspect = m;
          this.mFocusMode = i3;
          this.mEnableCamera = bool8;
          this.mEnableAgc = bool5;
          this.mEnableAns = bool6;
          this.mEnableEarMonitor = bool7;
          this.mLocalMirror = str3;
          this.mAudioVolumeType = ((String)localObject2);
          this.mVideoWidth = n;
          this.mVideoHeight = i2;
          this.mFrontCamera = bool1;
          this.mOrientation = str2;
          this.mPauseAudio = bool3;
          this.mPauseImageFilePath = str4;
          this.mMinBitrate = i;
          this.mMaxBitrate = k;
          this.mAudioQuality = str1;
          this.mEnableZoom = bool4;
          this.mWatermarkLeft = f1;
          this.mWatermarkTop = f2;
          this.mWatermarkWidth = f3;
          this.mWatermarkImage = ((String)localObject1);
          this.mNeedEvent = paramBundle.getBoolean("needEvent", this.mNeedEvent);
          this.mNeedBGMEvent = paramBundle.getBoolean("needBGMEvent", this.mNeedBGMEvent);
          bool1 = this.mRemoteMirror;
          if (!paramBundle.keySet().contains("remoteMirror")) {
            break label1994;
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
          WXLivePusherReflect.setVideoQuality(1, false, false, this.mLivePusher);
          WXLivePushConfigReflect.setVideoEncodeGop(5, this.mLivePushConfig);
          break;
          WXLivePusherReflect.setVideoQuality(2, true, false, this.mLivePusher);
          WXLivePushConfigReflect.setVideoEncodeGop(5, this.mLivePushConfig);
          break;
          WXLivePusherReflect.setVideoQuality(3, true, false, this.mLivePusher);
          WXLivePushConfigReflect.setVideoEncodeGop(5, this.mLivePushConfig);
          break;
          WXLivePusherReflect.setVideoQuality(4, true, false, this.mLivePusher);
          break;
          WXLivePusherReflect.setVideoQuality(5, true, false, this.mLivePusher);
          break;
          WXLivePusherReflect.setVideoQuality(6, false, false, this.mLivePusher);
          break;
          if (m != 2) {
            break label296;
          }
          WXLivePushConfigReflect.setVideoResolution(0, this.mLivePushConfig);
          break label296;
          label1724:
          if (!str1.equalsIgnoreCase("high")) {
            break label391;
          }
          WXLivePushConfigReflect.setAudioSampleRate(48000, this.mLivePushConfig);
          break label391;
          label1747:
          bool1 = false;
          break label412;
          label1753:
          if (!str2.equalsIgnoreCase("vertical")) {
            break label544;
          }
          adjustHomeOrientation(this.mLastAngle, str2);
          WXLivePusherReflect.setRenderRotation(0, this.mLivePusher);
          break label544;
          label1784:
          if (str3.equalsIgnoreCase("enable"))
          {
            WXLivePusherReflect.setLocalVideoMirrorType(1, this.mLivePushConfig);
            break label587;
          }
          if (!str3.equalsIgnoreCase("disable")) {
            break label587;
          }
          WXLivePusherReflect.setLocalVideoMirrorType(2, this.mLivePushConfig);
          break label587;
          label1828:
          WXLivePushConfigReflect.setPauseFlag(1, this.mLivePushConfig);
          break label646;
          label1839:
          if ((!WXLivePusherReflect.isPushing(this.mLivePusher)) || (!paramBundle.keySet().contains("watermarkImage"))) {
            break label745;
          }
          WXLivePushConfigReflect.setWatermark((Bitmap)localObject2, f1, f2, f3, this.mLivePushConfig);
          break label745;
          label1881:
          if (!((String)localObject2).equalsIgnoreCase("media")) {
            break label842;
          }
          WXLivePushConfigReflect.setVolumeType(1, this.mLivePushConfig);
          break label842;
          label1903:
          bool2 = false;
          break label863;
          label1909:
          stopPreview();
          break label1140;
          label1916:
          stopAudioRecord();
          break label1191;
          label1923:
          bool2 = false;
          break label1212;
          label1929:
          bool2 = false;
          break label1235;
          label1935:
          if (!paramBundle.keySet().contains("muted")) {
            break label1241;
          }
          bool2 = paramBundle.getBoolean("muted", this.mMute);
          if ((paramBoolean) || (bool2 != this.mMute)) {
            WXLivePusherReflect.setMuted(bool2, this.mLivePusher);
          }
          this.mMute = bool2;
          break label1241;
          label1994:
          if (paramBundle.keySet().contains("mirror")) {
            bool1 = paramBundle.getBoolean("mirror");
          }
        }
        k = n;
      }
      k = i;
      i = j;
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
        if ((str.equalsIgnoreCase("pushUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("backgroundImage")) || (str.equalsIgnoreCase("audioQuality")) || (str.equalsIgnoreCase("watermarkImage")) || (str.equalsIgnoreCase("audioVolumeType")) || (str.equalsIgnoreCase("localMirror")) || (str.equalsIgnoreCase("devicePosition"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
        } else if ((str.equalsIgnoreCase("mode")) || (str.equalsIgnoreCase("focusMode")) || (str.equalsIgnoreCase("beauty")) || (str.equalsIgnoreCase("whiteness")) || (str.equalsIgnoreCase("aspect")) || (str.equalsIgnoreCase("videoWidth")) || (str.equalsIgnoreCase("videoHeight")) || (str.equalsIgnoreCase("audioReverbType")) || (str.equalsIgnoreCase("minBitrate")) || (str.equalsIgnoreCase("maxBitrate"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
        } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autopush")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("enableCamera")) || (str.equalsIgnoreCase("enableMic")) || (str.equalsIgnoreCase("enableAGC")) || (str.equalsIgnoreCase("enableANS")) || (str.equalsIgnoreCase("enableEarMonitor")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("zoom")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needBGMEvent")) || (str.equalsIgnoreCase("debug")) || (str.equalsIgnoreCase("mirror")) || (str.equalsIgnoreCase("remoteMirror"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
        } else if ((str.equalsIgnoreCase("watermarkLeft")) || (str.equalsIgnoreCase("watermarkTop")) || (str.equalsIgnoreCase("watermarkWidth"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
        }
      }
      QLog.d("TXLivePusherJSAdapter", 2, paramString);
    }
  }
  
  private void safeRecycleBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      QLog.d("TXLivePusherJSAdapter", 2, "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
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
        txCloudVideoView_setVisibility(0, this.mVideoView);
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
    bmio.a(paramObject, "disableLog", false, bmio.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txCloudVideoView_setVisibility(int paramInt, Object paramObject)
  {
    bmio.a(paramObject, "setVisibility", false, bmio.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
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
      QLog.d("TXLivePusherJSAdapter", 1, "initEmbeddedLivePusher: startPusher");
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
      QLog.d("TXLivePusherJSAdapter", 2, "initLivePusher: startPusher");
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
    if (QLog.isColorLevel())
    {
      paramBundle = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") });
      QLog.d("TXLivePusherJSAdapter", 2, "onNetStatus:" + paramBundle);
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
      QLog.d("TXLivePusherJSAdapter", 2, "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      return;
      if ((paramInt == 1003) && (this.mFlashLight)) {
        WXLivePusherReflect.turnOnFlashLight(this.mFlashLight, this.mLivePusher);
      }
    }
  }
  
  public TXJSAdapterError operateLivePusher(String paramString, JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    double d = 1.0D;
    int j = 0;
    int k = 0;
    int i = 0;
    if (paramString == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePusher");
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    QLog.d("TXLivePusherJSAdapter", 2, "operateLivePusher: type = " + paramString + " params = " + str);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.mPusherUrl != null) && (!this.mPusherUrl.isEmpty()) && (!WXLivePusherReflect.isPushing(this.mLivePusher)))
      {
        startPreview(this.mEnableCamera);
        startAudioRecord(this.mEnableMic);
        WXLivePusherReflect.startPusher(this.mPusherUrl, this.mLivePusher);
      }
    }
    for (;;)
    {
      return new TXJSAdapterError();
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.mFlashLight = false;
        WXLivePusherReflect.stopBGM(this.mLivePusher);
        stopPreview();
        stopAudioRecord();
        WXLivePusherReflect.stopPusher(this.mLivePusher);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.mFlashLight) && (WXLivePusherReflect.isPushing(this.mLivePusher))) {
          WXLivePusherReflect.turnOnFlashLight(false, this.mLivePusher);
        }
        WXLivePusherReflect.pausePusher(this.mLivePusher);
        this.mBGMPlayingWhenPusherPaused = this.mBGMPlaying;
        if (this.mBGMPlayingWhenPusherPaused) {
          operateLivePusher("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        WXLivePusherReflect.resumePusher(this.mLivePusher);
        if (this.mBGMPlayingWhenPusherPaused) {
          operateLivePusher("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (WXLivePusherReflect.isPushing(this.mLivePusher))
        {
          QLog.d("TXLivePusherJSAdapter", 2, "do not support startPreview when pushing");
        }
        else
        {
          stopPreview();
          startPreview(this.mEnableCamera);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (WXLivePusherReflect.isPushing(this.mLivePusher)) {
          QLog.d("TXLivePusherJSAdapter", 2, "do not support stopPreview when pushing");
        } else {
          stopPreview();
        }
      }
      else
      {
        if (paramString.equalsIgnoreCase("switchCamera"))
        {
          if (!this.mFrontCamera) {}
          for (bool1 = true;; bool1 = false)
          {
            this.mFrontCamera = bool1;
            WXLivePushConfigReflect.setFrontCamera(this.mFrontCamera, this.mLivePushConfig);
            WXLivePusherReflect.switchCamera(this.mLivePusher);
            break;
          }
        }
        if (paramString.equalsIgnoreCase("toggleTorch"))
        {
          if (WXLivePusherReflect.isPushing(this.mLivePusher))
          {
            if (!this.mFlashLight)
            {
              boolean bool2 = WXLivePusherReflect.turnOnFlashLight(bool1, this.mLivePusher);
              if (!bool2) {
                break label540;
              }
              label503:
              this.mFlashLight = bool1;
              if (!bool2) {
                break label549;
              }
              label514:
              if (!bool2) {
                break label556;
              }
            }
            label540:
            label549:
            label556:
            for (paramString = "Success";; paramString = "Failed")
            {
              return new TXJSAdapterError(i, paramString);
              bool1 = false;
              break;
              bool1 = this.mFlashLight;
              break label503;
              i = -2;
              break label514;
            }
          }
          return new TXJSAdapterError(-2, "fail");
        }
        if (paramString.equalsIgnoreCase("playBGM"))
        {
          paramString = "";
          if (paramJSONObject != null) {
            paramString = paramJSONObject.optString("BGMFilePath", "");
          }
          QLog.d("TXLivePusherJSAdapter", 2, "playBGM filePath = " + paramString);
          if ((paramString != null) && (paramString.length() > 0)) {
            WXLivePusherReflect.playBGM(paramString, this.mLivePusher);
          } else {
            return new TXJSAdapterError(-2, "fail");
          }
        }
        else if (paramString.equalsIgnoreCase("stopBGM"))
        {
          WXLivePusherReflect.stopBGM(this.mLivePusher);
          this.mBGMPlaying = false;
        }
        else if (paramString.equalsIgnoreCase("pauseBGM"))
        {
          WXLivePusherReflect.pauseBGM(this.mLivePusher);
          this.mBGMPlaying = false;
        }
        else if (paramString.equalsIgnoreCase("resumeBGM"))
        {
          WXLivePusherReflect.resumeBGM(this.mLivePusher);
          this.mBGMPlaying = true;
        }
        else
        {
          if (!paramString.equalsIgnoreCase("setBGMPosition")) {
            break;
          }
          if ((this.mBGMPlaying) && (paramJSONObject != null))
          {
            i = paramJSONObject.optInt("BGMPosition", -1);
            if (i > 0) {
              WXLivePusherReflect.setBGMPosition(i, this.mLivePusher);
            }
          }
        }
      }
    }
    if (paramString.equalsIgnoreCase("setBGMVolume")) {
      if (paramJSONObject == null) {
        break label1012;
      }
    }
    label939:
    label1012:
    for (d = paramJSONObject.optDouble("volume", 1.0D);; d = 1.0D)
    {
      WXLivePusherReflect.setBGMVolume((float)d, this.mLivePusher);
      break;
      if (paramString.equalsIgnoreCase("setMICVolume"))
      {
        if (paramJSONObject != null) {
          d = paramJSONObject.optDouble("volume", 1.0D);
        }
        WXLivePusherReflect.setMicVolume((float)d, this.mLivePusher);
        break;
      }
      if (paramString.equalsIgnoreCase("sendMessage"))
      {
        paramString = null;
        if (paramJSONObject != null) {
          paramString = paramJSONObject.optString("msg");
        }
        if (paramString != null)
        {
          bool1 = WXLivePusherReflect.sendMessageEx(paramString.getBytes(), this.mLivePusher);
          if (bool1)
          {
            i = j;
            if (!bool1) {
              break label939;
            }
          }
          for (paramString = "Success";; paramString = "Failed")
          {
            return new TXJSAdapterError(i, paramString);
            i = -2;
            break;
          }
        }
        return new TXJSAdapterError(-2, "fail");
      }
      if (paramString.equalsIgnoreCase("setAudioReverbType"))
      {
        i = k;
        if (paramJSONObject != null) {
          i = paramJSONObject.optInt("audioReverbType", 0);
        }
        WXLivePusherReflect.setReverb(i, this.mLivePusher);
        break;
      }
      return new TXJSAdapterError(-4, "invalid operate command");
    }
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
      QLog.d("TXLivePusherJSAdapter", 2, "updateLivePusher: stopPusher");
      stopPreview();
      stopAudioRecord();
      WXLivePusherReflect.stopPusher(this.mLivePusher);
    }
    this.mPusherUrl = str;
    WXLivePusherReflect.setPusherUrl(this.mPusherUrl, this.mLivePusher);
    this.mAutoPush = paramJSONObject.getBoolean("autopush", this.mAutoPush);
    if ((this.mAutoPush) && (this.mPusherUrl != null) && (!this.mPusherUrl.isEmpty()) && (!WXLivePusherReflect.isPushing(this.mLivePusher)))
    {
      QLog.d("TXLivePusherJSAdapter", 2, "updateLivePusher: startPusher");
      startPreview(this.mEnableCamera);
      startAudioRecord(this.mEnableMic);
      WXLivePusherReflect.startPusher(this.mPusherUrl, this.mLivePusher);
    }
    return new TXJSAdapterError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePusherJSAdapter
 * JD-Core Version:    0.7.0.1
 */