package com.tencent.mobileqq.winkreport.datong;

import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.utils.WinkReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.Random;

public class WinkNativeSessionManager
{
  private static final String CAMERA_SESSION_FORMAT = "android_camera_session_wink_%s_%d_%d";
  private static final String SESSION_FORMAT = "android_session_wink_%s_%d_%d";
  private static final String TAG = "WinkNativeSessionManager";
  private static volatile WinkNativeSessionManager sSingleton;
  private String mCameraSessionId;
  private String mSessionId;
  
  public static WinkNativeSessionManager g()
  {
    if (sSingleton == null) {
      try
      {
        if (sSingleton == null) {
          sSingleton = new WinkNativeSessionManager();
        }
      }
      finally {}
    }
    return sSingleton;
  }
  
  private void generateNativeCameraSessionId()
  {
    this.mCameraSessionId = generateNativeId("android_camera_session_wink_%s_%d_%d");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("generateNativeCameraSessionId：");
    localStringBuilder.append(this.mCameraSessionId);
    QLog.i("WinkNativeSessionManager", 1, localStringBuilder.toString());
  }
  
  private String generateNativeId(String paramString)
  {
    return String.format(Locale.getDefault(), paramString, new Object[] { WinkReportUtils.getAccountUin(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(100)) });
  }
  
  private void generateNativeSessionId()
  {
    this.mSessionId = generateNativeId("android_session_wink_%s_%d_%d");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("generateNativeSessionId：");
    localStringBuilder.append(this.mSessionId);
    QLog.i("WinkNativeSessionManager", 1, localStringBuilder.toString());
  }
  
  public String getCameraSessionId()
  {
    generateNativeCameraSessionId();
    return this.mCameraSessionId;
  }
  
  public String getCameraSessionId(boolean paramBoolean)
  {
    if ((paramBoolean) || (TextUtils.isEmpty(this.mCameraSessionId))) {
      generateNativeCameraSessionId();
    }
    return this.mCameraSessionId;
  }
  
  public String getSessionId()
  {
    if (this.mSessionId == null) {
      generateNativeSessionId();
    }
    return this.mSessionId;
  }
  
  public void resetCameraSessionId()
  {
    this.mCameraSessionId = null;
  }
  
  public void resetSessionId()
  {
    this.mSessionId = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkreport.datong.WinkNativeSessionManager
 * JD-Core Version:    0.7.0.1
 */