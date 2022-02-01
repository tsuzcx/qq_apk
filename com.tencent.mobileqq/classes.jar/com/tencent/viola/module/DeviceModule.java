package com.tencent.viola.module;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.utils.OrientationDetector;
import com.tencent.viola.utils.OrientationDetector.OnOrientationChangedListener;
import com.tencent.viola.utils.ViolaBrightnessController;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONObject;

public class DeviceModule
  extends BaseModule
{
  public static final String MODULE_NAME = "device";
  public static final String TAG = "DeviceModule";
  private AudioManager mAudioManager;
  private ViolaBrightnessController mBrightnessController;
  private Handler mHandler;
  private int mHorizontalAngle = 20;
  private int mLastOrientation = 1;
  private long mLastOrientationTime = 0L;
  private OrientationDetector.OnOrientationChangedListener mListener;
  private float mMaxVolume;
  private OrientationDetector mOrientationDetector;
  private int mVerticalAngle = 30;
  private ContentObserver mVolumeChangedObserver;
  
  private void initAudioManager()
  {
    if ((this.mAudioManager == null) && (getViolaInstance().getContext() != null))
    {
      this.mAudioManager = ((AudioManager)getViolaInstance().getContext().getApplicationContext().getSystemService("audio"));
      this.mMaxVolume = this.mAudioManager.getStreamMaxVolume(3);
    }
  }
  
  private void initBrightnessController()
  {
    if ((this.mBrightnessController == null) && (getViolaInstance().getActivity() != null)) {
      this.mBrightnessController = new ViolaBrightnessController(getViolaInstance().getActivity());
    }
  }
  
  @JSMethod
  public void brightnessChange(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      initBrightnessController();
      ViolaBrightnessController localViolaBrightnessController = this.mBrightnessController;
      if ((localViolaBrightnessController != null) && (localViolaBrightnessController.getOnBrightNessChangeListener() == null)) {
        this.mBrightnessController.setOnBrightNessChangeListener(new DeviceModule.2(this, paramString));
      }
    }
  }
  
  @JSMethod(uiThread=false)
  public void getOrientationChanged(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mListener == null) {
        this.mListener = new DeviceModule.1(this, paramString);
      }
      if ((this.mOrientationDetector == null) && ((getViolaInstance().getContext() instanceof Activity)))
      {
        this.mOrientationDetector = new OrientationDetector((Activity)getViolaInstance().getContext(), this.mListener);
        this.mOrientationDetector.setHorizontalAngle(this.mHorizontalAngle);
        this.mOrientationDetector.setVerticalAngle(this.mVerticalAngle);
        this.mHandler = new Handler();
      }
      paramString = this.mOrientationDetector;
      if (paramString != null) {
        paramString.enable(true);
      }
    }
  }
  
  @JSMethod(uiThread=false)
  public void getOrientationChangedWithAngle(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      this.mVerticalAngle = paramJSONObject.optInt("verticalAngle", 30);
      this.mHorizontalAngle = paramJSONObject.optInt("horizontalAngle", 30);
    }
    getOrientationChanged(paramString);
  }
  
  @JSMethod
  public void getSystemBrightness(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      initBrightnessController();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("value", this.mBrightnessController.getScreenBrightness());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSystemBrightness error:");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e("DeviceModule", localStringBuilder.toString());
        localException.printStackTrace();
      }
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "device", "callback", paramString, localJSONObject, true);
    }
  }
  
  @JSMethod(uiThread=false)
  public void getSystemVolume(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      initAudioManager();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("value", this.mAudioManager.getStreamVolume(3) / this.mMaxVolume);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSystemVolume error:");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e("DeviceModule", localStringBuilder.toString());
        localException.printStackTrace();
      }
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "device", "callback", paramString, localJSONObject, true);
    }
  }
  
  public void onActivityDestroy()
  {
    Object localObject = this.mOrientationDetector;
    if (localObject != null) {
      ((OrientationDetector)localObject).destroy();
    }
    localObject = this.mBrightnessController;
    if (localObject != null) {
      ((ViolaBrightnessController)localObject).doOnDestory();
    }
    if (this.mVolumeChangedObserver != null)
    {
      if (getViolaInstance().getContext() != null)
      {
        getViolaInstance().getContext().getApplicationContext().getContentResolver().unregisterContentObserver(this.mVolumeChangedObserver);
        return;
      }
      if (ViolaEnvironment.getApplication() != null) {
        ViolaEnvironment.getApplication().getContentResolver().unregisterContentObserver(this.mVolumeChangedObserver);
      }
    }
  }
  
  @JSMethod
  public void setSystemBrightness(float paramFloat)
  {
    initBrightnessController();
    this.mBrightnessController.setScreenBrightness(paramFloat);
  }
  
  @JSMethod(uiThread=false)
  public void setSystemVolume(float paramFloat)
  {
    initAudioManager();
    int i = (int)(this.mMaxVolume * paramFloat);
    this.mAudioManager.setStreamVolume(3, i, 0);
  }
  
  @JSMethod(uiThread=false)
  public void volumeChange(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      initAudioManager();
      if (this.mVolumeChangedObserver == null)
      {
        this.mVolumeChangedObserver = new DeviceModule.3(this, new Handler(), paramString);
        getViolaInstance().getContext().getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.mVolumeChangedObserver);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.module.DeviceModule
 * JD-Core Version:    0.7.0.1
 */