package com.tencent.ttpic.baseutils.device;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera.Parameters;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class DeviceAttrs
{
  public static final String ACTION_CHECK_ONLINE_UPDATE_FINISH = "action_check_online_update_finish";
  public static final int CAMERASDK_FAILED_THRESHOLD = 4;
  public static final int DEGREE_0 = 0;
  public static final int DEGREE_180 = 180;
  public static final int DEGREE_270 = 270;
  public static final int DEGREE_90 = 90;
  public static final int DEGREE_INVALIDATE = -1;
  public static final Boolean ENABLE_LOG = Boolean.valueOf(false);
  public static final int ENABLE_PERFORMANCE_MONITOR_THRESHOLD = 604800000;
  private static final DeviceAttrs INSTANCE = new DeviceAttrs();
  public static final String KEY_CAMERASDK_DISABLE = "pref_camerasdk_disable";
  public static final String KEY_CAMERASDK_FAILED_TIMES = "pref_camerasdk_open_failed_times";
  public static final String KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME = "enable_performance_monitor_begin_time";
  public static final String KEY_NEED_PARSE_XML = "is_need_parse_xml";
  public static final String KEY_PARSE_RESULT = "parse_result";
  public static final String KEY_URL_VALUE = "black_list_url";
  public static final String KEY_VERSION = "xml_version";
  public static final Boolean PARSE_XML_DEBUG_MODE = Boolean.valueOf(false);
  private static final String TAG;
  private static final Boolean TEST_URL = Boolean.valueOf(false);
  private static final String XML_FILE_NAME = "phone_attrs_config.dat";
  private static final String ZIP_FILE_NAME = "phone_attrs_config.zip";
  private static final String backCamCannotRotateKey = "backCamCannotRotate";
  private static final String backExposureStepOneKey = "backExposureStepOne";
  private static final String backFlashModeExceptionKey = "backFlashModeException";
  private static final String backFlashNoAutoKey = "backFlashNoAuto";
  private static final String backFlashNoOnKey = "backFlashNoOn";
  private static final String backFlashNoTorchKey = "backFlashNoTorch";
  private static final String beBlurredPicAfterTakePicKey = "beBlurredPicAfterTakePic";
  private static final String beBlurredPreviewAfterTakePicKey = "beBlurredPreviewAfterTakePic";
  private static final String cannotFlashWhileAutoFocusKey = "cannotFlashWhileAutoFocus";
  private static final String cannotFlashWhileFlashOnKey = "cannotFlashWhileFlashOn";
  private static final String cannotRotatePreviewKey = "cannotRotatePreview";
  private static final String deviceJpegDisableKey = "deviceJpegDisable";
  private static final String disableAutoFocusDoubleKey = "disableAutoFocusDouble";
  private static final String disableBackExposureKey = "disableBackExposure";
  private static final String disableBackFlashModeKey = "disableBackFlashMode";
  private static final String disableCameraSDKKey = "disableCameraSDK";
  private static final String disableCameraVideoKey = "disableCameraVideo";
  private static final String disableFaceDetectionKey = "disableFaceDetection";
  private static final String disableFocusModeContinuousPictureKey = "disableFocusModeContinuousPicture";
  private static final String disableFocusModeKey = "disableFocusMode";
  private static final String disableFrontCameraKey = "disableFrontCamera";
  private static final String disableFrontExposureKey = "disableFrontExposure";
  private static final String disableGridCaptureKey = "disableGridCapture";
  private static final String disableLiteEditorKey = "disableLiteEditor";
  private static final String disableMultiPreviewKey = "disableMultiPreview";
  private static final String disableVideoTransformKey = "disableVideoTransform";
  private static final String enableFastCapture4BackCameraKey = "enableFastCapture4BackCamera";
  private static final String enableFastCapture4FrontCameraKey = "enableFastCapture4FrontCamera";
  private static final String enablePerformanceMonitorKey = "enablePerformanceMonitor";
  private static final String es_GL_EXT_shader_framebuffer_fetch_key = "es_GL_EXT_shader_framebuffer_fetch";
  private static final String frontCamCannotRotateKey = "frontCamCannotRotate";
  private static final String frontCamFlipHKey = "frontCamFlipH";
  private static final String frontExposureStepOneKey = "frontExposureStepOne";
  private static final String frontFlashModeExceptionKey = "frontFlashModeException";
  private static final String frontFlashNoAutoKey = "frontFlashNoAuto";
  private static final String gpuProcessNeedBackTexture_key = "gpuProcessNeedBackTexture";
  private static final String int_backCamRotate0Key = "int_backCamRotate0";
  private static final String int_backCamRotate180Key = "int_backCamRotate180";
  private static final String int_backCamRotate270Key = "int_backCamRotate270";
  private static final String int_backCamRotate90Key = "int_backCamRotate90";
  private static final String int_backExifRotate0Key = "int_backExifRotate0";
  private static final String int_backExifRotate180Key = "int_backExifRotate180";
  private static final String int_backExifRotate270Key = "int_backExifRotate270";
  private static final String int_backExifRotate90Key = "int_backExifRotate90";
  private static final String int_frontCamRotate0Key = "int_frontCamRotate0";
  private static final String int_frontCamRotate180Key = "int_frontCamRotate180";
  private static final String int_frontCamRotate270Key = "int_frontCamRotate270";
  private static final String int_frontCamRotate90Key = "int_frontCamRotate90";
  private static final String int_frontExifRotate0Key = "int_frontExifRotate0";
  private static final String int_frontExifRotate180Key = "int_frontExifRotate180";
  private static final String int_frontExifRotate270Key = "int_frontExifRotate270";
  private static final String int_frontExifRotate90Key = "int_frontExifRotate90";
  private static final String readCamNumExceptionKey = "readCamNumException";
  private static final String readMaxNumFocusAreasAbnormalKey = "readMaxNumFocusAreasAbnormal";
  private static final String readMaxNumMeteringAreasAbnormalKey = "readMaxNumMeteringAreasAbnormal";
  private static final String sReleaseURL = "http://xiangji.qq.com/services/cameraCoreSvr.php";
  private static final String sTestURL = "http://test.xiangji.qq.com/services/cameraCoreSvr.php";
  private static final String str_backPictureSize169Key = "str_backPictureSize169";
  private static final String str_backPictureSize43Key = "str_backPictureSize43";
  private static final String str_backPreviewSize169Key = "str_backPreviewSize169";
  private static final String str_backPreviewSize43Key = "str_backPreviewSize43";
  private static final String str_deviceSocInfoKey = "str_deviceSocInfo";
  private static final String str_frontPictureSize169Key = "str_frontPictureSize169";
  private static final String str_frontPictureSize43Key = "str_frontPictureSize43";
  private static final String str_frontPreviewSize169Key = "str_frontPreviewSize169";
  private static final String str_frontPreviewSize43Key = "str_frontPreviewSize43";
  private static final String str_recordVideoSizeKey = "str_recordVideoSize";
  private static final String str_videoPreviewFpsKey = "str_videoPreview720Fps";
  private static final String useNewPreviewKey = "useNewPreview";
  private boolean backCamCannotRotate = false;
  public boolean backExposureStepOne = false;
  public boolean backFlashModeException = false;
  public boolean backFlashNoAuto = false;
  public boolean backFlashNoOn = false;
  public boolean backFlashNoTorch = true;
  public boolean beBlurredPicAfterTakePic = false;
  public boolean beBlurredPreviewAfterTakePic = false;
  private boolean cannotFlashWhileAutoFocus = false;
  private boolean cannotFlashWhileFlashOn = false;
  private boolean cannotRotatePreview = false;
  public boolean deviceJpegDisable;
  public boolean disableAutoFocusDouble = false;
  public boolean disableBackCamera = false;
  public boolean disableBackExposure = false;
  public boolean disableBackFlashMode = false;
  public boolean disableCameraSDK = false;
  public boolean disableCameraVideo = false;
  public boolean disableFaceDetection = false;
  public boolean disableFocusMode = false;
  public boolean disableFocusModeContinuousPicture = false;
  public boolean disableFrontCamera = false;
  public boolean disableFrontExposure = false;
  public boolean disableLiteEditor = false;
  public boolean enableFastCapture4BackCamera = false;
  public boolean enableFastCapture4FrontCamera = false;
  public boolean enablePerformanceMonitor = false;
  public boolean es_GL_EXT_shader_framebuffer_fetch;
  private boolean frontCamCannotRotate = false;
  public boolean frontCamFlipH = false;
  public boolean frontExposureStepOne = false;
  public boolean frontFlashModeException = false;
  public boolean frontFlashNoAuto = false;
  public boolean gpuProcessNeedBackTexture;
  public boolean gpuWorkaroundForTU880;
  public int int_backCamRotate0 = -1;
  public int int_backCamRotate180 = -1;
  public int int_backCamRotate270 = -1;
  public int int_backCamRotate90 = -1;
  public int int_backExifRotate0 = -1;
  public int int_backExifRotate180 = -1;
  public int int_backExifRotate270 = -1;
  public int int_backExifRotate90 = -1;
  public int int_frontCamRotate0 = -1;
  public int int_frontCamRotate180 = -1;
  public int int_frontCamRotate270 = -1;
  public int int_frontCamRotate90 = -1;
  public int int_frontExifRotate0 = -1;
  public int int_frontExifRotate180 = -1;
  public int int_frontExifRotate270 = -1;
  public int int_frontExifRotate90 = -1;
  private String mBuildInFileDir;
  private SharedPreferences mCameraMatchPref;
  private Context mContext;
  private List<String> mFastCaptureKeys;
  private List<String> mFastCaptureOnValues;
  private String mPrevUrl = "";
  private String mRequestUrl;
  private String mSignature;
  public boolean readCamNumException = false;
  private boolean readMaxNumFocusAreasAbnormal = false;
  private boolean readMaxNumMeteringAreasAbnormal = false;
  public boolean serverJpegEnable = true;
  public String str_backPictureSize169;
  public String str_backPictureSize43;
  public String str_backPreviewSize169;
  public String str_backPreviewSize43;
  public String str_deviceSocInfo;
  public String str_frontPictureSize169;
  public String str_frontPictureSize43;
  public String str_frontPreviewSize169;
  public String str_frontPreviewSize43;
  public String str_recordVideoSize;
  public String str_videoPreview720Fps;
  
  static
  {
    TAG = DeviceAttrs.class.getSimpleName();
  }
  
  private DeviceAttrs()
  {
    if (TEST_URL.booleanValue()) {}
    for (String str = "http://test.xiangji.qq.com/services/cameraCoreSvr.php";; str = "http://xiangji.qq.com/services/cameraCoreSvr.php")
    {
      this.mRequestUrl = str;
      this.mFastCaptureKeys = new ArrayList();
      this.mFastCaptureOnValues = new ArrayList();
      return;
    }
  }
  
  private String editKey(Set<String> paramSet, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramSet.contains(paramString1)) {
      str = paramString1 + "_" + paramString2;
    }
    return str;
  }
  
  private String getCameraPrefName(Context paramContext)
  {
    return paramContext.getPackageName() + "_preferences_camera_adapter";
  }
  
  public static DeviceAttrs getInstance()
  {
    return INSTANCE;
  }
  
  private void initFastCaptureKeyValue()
  {
    int j = 0;
    if ((this.mFastCaptureKeys != null) && (this.mFastCaptureOnValues != null) && (this.mFastCaptureKeys.isEmpty()) && (this.mFastCaptureOnValues.isEmpty()))
    {
      this.mFastCaptureKeys.clear();
      this.mFastCaptureOnValues.clear();
      try
      {
        Object localObject = parseFastCaptureFile();
        if (localObject != null)
        {
          JsonArray localJsonArray = ((JsonObject)localObject).getAsJsonArray("key");
          int i;
          if (localJsonArray != null)
          {
            i = 0;
            while (i < localJsonArray.size())
            {
              this.mFastCaptureKeys.add(GsonUtils.getStringUnsafe(localJsonArray, i));
              i += 1;
            }
          }
          localObject = ((JsonObject)localObject).getAsJsonArray("value");
          if (localObject != null)
          {
            i = j;
            while (i < ((JsonArray)localObject).size())
            {
              this.mFastCaptureOnValues.add(GsonUtils.getStringUnsafe((JsonArray)localObject, i));
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean isInFastCaptureWhiteList(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getInstance().enableFastCapture4FrontCamera;
    }
    return getInstance().enableFastCapture4BackCamera;
  }
  
  private void loadAttrsFromPref()
  {
    LogUtils.i(TAG, "[loadAttrsFromPref] + BEGIN");
    this.str_deviceSocInfo = this.mCameraMatchPref.getString("str_deviceSocInfo", "");
    this.disableCameraSDK = this.mCameraMatchPref.getBoolean("disableCameraSDK", false);
    if (this.disableCameraSDK)
    {
      this.mCameraMatchPref.edit().putBoolean("pref_camerasdk_disable", true).apply();
      LogUtils.i(TAG, "set camerasdk disable flag true");
    }
    this.disableCameraVideo = this.mCameraMatchPref.getBoolean("disableCameraVideo", false);
    this.enablePerformanceMonitor = this.mCameraMatchPref.getBoolean("enablePerformanceMonitor", false);
    this.disableLiteEditor = this.mCameraMatchPref.getBoolean("disableLiteEditor", false);
    this.readCamNumException = this.mCameraMatchPref.getBoolean("readCamNumException", false);
    this.disableFrontCamera = this.mCameraMatchPref.getBoolean("disableFrontCamera", false);
    this.str_frontPreviewSize43 = this.mCameraMatchPref.getString("str_frontPreviewSize43", null);
    this.str_frontPreviewSize169 = this.mCameraMatchPref.getString("str_frontPreviewSize169", null);
    this.str_backPreviewSize43 = this.mCameraMatchPref.getString("str_backPreviewSize43", null);
    this.str_backPreviewSize169 = this.mCameraMatchPref.getString("str_backPreviewSize169", null);
    this.str_videoPreview720Fps = this.mCameraMatchPref.getString("str_videoPreview720Fps", null);
    this.str_frontPictureSize43 = this.mCameraMatchPref.getString("str_frontPictureSize43", null);
    this.str_frontPictureSize169 = this.mCameraMatchPref.getString("str_frontPictureSize169", null);
    this.str_backPictureSize43 = this.mCameraMatchPref.getString("str_backPictureSize43", null);
    this.str_backPictureSize169 = this.mCameraMatchPref.getString("str_backPictureSize169", null);
    this.str_recordVideoSize = this.mCameraMatchPref.getString("str_recordVideoSize", null);
    this.beBlurredPreviewAfterTakePic = this.mCameraMatchPref.getBoolean("beBlurredPreviewAfterTakePic", false);
    this.beBlurredPicAfterTakePic = this.mCameraMatchPref.getBoolean("beBlurredPicAfterTakePic", false);
    this.enableFastCapture4FrontCamera = this.mCameraMatchPref.getBoolean("enableFastCapture4FrontCamera", false);
    this.enableFastCapture4BackCamera = this.mCameraMatchPref.getBoolean("enableFastCapture4BackCamera", false);
    this.disableBackFlashMode = this.mCameraMatchPref.getBoolean("disableBackFlashMode", false);
    this.backFlashModeException = this.mCameraMatchPref.getBoolean("backFlashModeException", false);
    this.frontFlashModeException = this.mCameraMatchPref.getBoolean("frontFlashModeException", false);
    this.backFlashNoOn = this.mCameraMatchPref.getBoolean("backFlashNoOn", false);
    this.backFlashNoAuto = this.mCameraMatchPref.getBoolean("backFlashNoAuto", false);
    this.backFlashNoTorch = this.mCameraMatchPref.getBoolean("backFlashNoTorch", true);
    this.frontFlashNoAuto = this.mCameraMatchPref.getBoolean("frontFlashNoAuto", false);
    this.disableFocusMode = this.mCameraMatchPref.getBoolean("disableFocusMode", false);
    this.disableFocusModeContinuousPicture = this.mCameraMatchPref.getBoolean("disableFocusModeContinuousPicture", false);
    this.disableAutoFocusDouble = this.mCameraMatchPref.getBoolean("disableAutoFocusDouble", false);
    this.disableFaceDetection = this.mCameraMatchPref.getBoolean("disableFaceDetection", false);
    this.int_frontCamRotate0 = this.mCameraMatchPref.getInt("int_frontCamRotate0", -1);
    this.int_frontCamRotate90 = this.mCameraMatchPref.getInt("int_frontCamRotate90", -1);
    this.int_frontCamRotate180 = this.mCameraMatchPref.getInt("int_frontCamRotate180", -1);
    this.int_frontCamRotate270 = this.mCameraMatchPref.getInt("int_frontCamRotate270", -1);
    this.int_backCamRotate0 = this.mCameraMatchPref.getInt("int_backCamRotate0", -1);
    this.int_backCamRotate90 = this.mCameraMatchPref.getInt("int_backCamRotate90", -1);
    this.int_backCamRotate180 = this.mCameraMatchPref.getInt("int_backCamRotate180", -1);
    this.int_backCamRotate270 = this.mCameraMatchPref.getInt("int_backCamRotate270", -1);
    this.int_frontExifRotate0 = this.mCameraMatchPref.getInt("int_frontExifRotate0", -1);
    this.int_frontExifRotate90 = this.mCameraMatchPref.getInt("int_frontExifRotate90", -1);
    this.int_frontExifRotate180 = this.mCameraMatchPref.getInt("int_frontExifRotate180", -1);
    this.int_frontExifRotate270 = this.mCameraMatchPref.getInt("int_frontExifRotate270", -1);
    this.int_backExifRotate0 = this.mCameraMatchPref.getInt("int_backExifRotate0", -1);
    this.int_backExifRotate90 = this.mCameraMatchPref.getInt("int_backExifRotate90", -1);
    this.int_backExifRotate180 = this.mCameraMatchPref.getInt("int_backExifRotate180", -1);
    this.int_backExifRotate270 = this.mCameraMatchPref.getInt("int_backExifRotate270", -1);
    this.frontCamFlipH = this.mCameraMatchPref.getBoolean("frontCamFlipH", false);
    this.disableFrontExposure = this.mCameraMatchPref.getBoolean("disableFrontExposure", false);
    this.disableBackExposure = this.mCameraMatchPref.getBoolean("disableBackExposure", false);
    this.frontExposureStepOne = this.mCameraMatchPref.getBoolean("frontExposureStepOne", false);
    this.backExposureStepOne = this.mCameraMatchPref.getBoolean("backExposureStepOne", false);
    this.deviceJpegDisable = this.mCameraMatchPref.getBoolean("deviceJpegDisable", false);
    this.es_GL_EXT_shader_framebuffer_fetch = this.mCameraMatchPref.getBoolean("es_GL_EXT_shader_framebuffer_fetch", true);
    this.cannotFlashWhileAutoFocus = this.mCameraMatchPref.getBoolean("cannotFlashWhileAutoFocus", false);
    this.frontCamCannotRotate = this.mCameraMatchPref.getBoolean("frontCamCannotRotate", false);
    this.readMaxNumMeteringAreasAbnormal = this.mCameraMatchPref.getBoolean("readMaxNumMeteringAreasAbnormal", false);
    this.readMaxNumFocusAreasAbnormal = this.mCameraMatchPref.getBoolean("readMaxNumFocusAreasAbnormal", false);
    this.cannotRotatePreview = this.mCameraMatchPref.getBoolean("cannotRotatePreview", false);
    this.cannotFlashWhileFlashOn = this.mCameraMatchPref.getBoolean("cannotFlashWhileFlashOn", false);
    this.backCamCannotRotate = this.mCameraMatchPref.getBoolean("backCamCannotRotate", false);
    LogUtils.i(TAG, "[loadAttrsFromPref] + END");
  }
  
  private void logAttrsValues()
  {
    LogUtils.i(TAG, "DeviceAttrs start-------------------------------------------------------------");
    LogUtils.i(TAG, "DeviceAttrs str_deviceSocInfo = " + this.str_deviceSocInfo);
    LogUtils.d(TAG, "DeviceAttrs str_deviceSocInfo = " + this.str_deviceSocInfo);
    LogUtils.i(TAG, "DeviceAttrs disableCameraSDK = " + this.disableCameraSDK);
    LogUtils.i(TAG, "DeviceAttrs disableCameraVideo = " + this.disableCameraVideo);
    LogUtils.i(TAG, "DeviceAttrs enablePerformanceMonitor = " + this.enablePerformanceMonitor);
    LogUtils.i(TAG, "DeviceAttrs disableLiteEditor = " + this.disableLiteEditor);
    LogUtils.i(TAG, "DeviceAttrs readCamNumException = " + this.readCamNumException);
    LogUtils.i(TAG, "DeviceAttrs disableFrontCamera = " + this.disableFrontCamera);
    LogUtils.i(TAG, "DeviceAttrs beBlurredPreviewAfterTakePic = " + this.beBlurredPreviewAfterTakePic);
    LogUtils.i(TAG, "DeviceAttrs beBlurredPicAfterTakePic = " + this.beBlurredPicAfterTakePic);
    LogUtils.i(TAG, "DeviceAttrs enableFastCapture4FrontCamera = " + this.enableFastCapture4FrontCamera);
    LogUtils.i(TAG, "DeviceAttrs enableFastCapture4BackCamera = " + this.enableFastCapture4BackCamera);
    LogUtils.i(TAG, "DeviceAttrs str_videoPreview720Fps = " + this.str_videoPreview720Fps);
    LogUtils.i(TAG, "DeviceAttrs str_frontPreviewSize43 = " + this.str_frontPreviewSize43);
    LogUtils.i(TAG, "DeviceAttrs str_frontPreviewSize169 = " + this.str_frontPreviewSize169);
    LogUtils.i(TAG, "DeviceAttrs str_backPreviewSize43 = " + this.str_backPreviewSize43);
    LogUtils.i(TAG, "DeviceAttrs str_backPreviewSize169 = " + this.str_backPreviewSize169);
    LogUtils.i(TAG, "DeviceAttrs str_frontPictureSize43 = " + this.str_frontPictureSize43);
    LogUtils.i(TAG, "DeviceAttrs str_backPictureSize43 = " + this.str_backPictureSize43);
    LogUtils.i(TAG, "DeviceAttrs str_recordVideoSize = " + this.str_recordVideoSize);
    LogUtils.i(TAG, "DeviceAttrs disableBackFlashMode = " + this.disableBackFlashMode);
    LogUtils.i(TAG, "DeviceAttrs frontFlashModeException = " + this.frontFlashModeException);
    LogUtils.i(TAG, "DeviceAttrs backFlashModeException = " + this.backFlashModeException);
    LogUtils.i(TAG, "DeviceAttrs backFlashNoOn = " + this.backFlashNoOn);
    LogUtils.i(TAG, "DeviceAttrs backFlashNoAuto = " + this.backFlashNoAuto);
    LogUtils.i(TAG, "DeviceAttrs backFlashNoTorch = " + this.backFlashNoTorch);
    LogUtils.i(TAG, "DeviceAttrs frontFlashNoAuto = " + this.frontFlashNoAuto);
    LogUtils.i(TAG, "DeviceAttrs disableFocusMode = " + this.disableFocusMode);
    LogUtils.i(TAG, "DeviceAttrs disableFocusModeContinuousPicture = " + this.disableFocusModeContinuousPicture);
    LogUtils.i(TAG, "DeviceAttrs disableAutoFocusDouble = " + this.disableAutoFocusDouble);
    LogUtils.i(TAG, "DeviceAttrs disableFaceDetection = " + this.disableFaceDetection);
    LogUtils.i(TAG, "DeviceAttrs int_frontCamRotate0 = " + this.int_frontCamRotate0);
    LogUtils.i(TAG, "DeviceAttrs int_frontCamRotate90 = " + this.int_frontCamRotate90);
    LogUtils.i(TAG, "DeviceAttrs int_frontCamRotate180 = " + this.int_frontCamRotate180);
    LogUtils.i(TAG, "DeviceAttrs int_frontCamRotate270 = " + this.int_frontCamRotate270);
    LogUtils.i(TAG, "DeviceAttrs int_backCamRotate0 = " + this.int_backCamRotate0);
    LogUtils.i(TAG, "DeviceAttrs int_backCamRotate90 = " + this.int_backCamRotate90);
    LogUtils.i(TAG, "DeviceAttrs int_backCamRotate180 = " + this.int_backCamRotate180);
    LogUtils.i(TAG, "DeviceAttrs int_backCamRotate270 = " + this.int_backCamRotate270);
    LogUtils.i(TAG, "DeviceAttrs int_frontExifRotate0 = " + this.int_frontExifRotate0);
    LogUtils.i(TAG, "DeviceAttrs int_frontExifRotate90 = " + this.int_frontExifRotate90);
    LogUtils.i(TAG, "DeviceAttrs int_frontExifRotate180 = " + this.int_frontExifRotate180);
    LogUtils.i(TAG, "DeviceAttrs int_frontExifRotate270 = " + this.int_frontExifRotate270);
    LogUtils.i(TAG, "DeviceAttrs int_backExifRotate0 = " + this.int_backExifRotate0);
    LogUtils.i(TAG, "DeviceAttrs int_backExifRotate90 = " + this.int_backExifRotate90);
    LogUtils.i(TAG, "DeviceAttrs int_backExifRotate180 = " + this.int_backExifRotate180);
    LogUtils.i(TAG, "DeviceAttrs int_backExifRotate270 = " + this.int_backExifRotate270);
    LogUtils.i(TAG, "DeviceAttrs frontCamFlipH = " + this.frontCamFlipH);
    LogUtils.i(TAG, "DeviceAttrs disableFrontExposure = " + this.disableFrontExposure);
    LogUtils.i(TAG, "DeviceAttrs disableBackExposure = " + this.disableBackExposure);
    LogUtils.i(TAG, "DeviceAttrs frontExposureStepOne = " + this.frontExposureStepOne);
    LogUtils.i(TAG, "DeviceAttrs backExposureStepOne = " + this.backExposureStepOne);
    LogUtils.i(TAG, "DeviceAttrs serverJpegEnable = " + this.serverJpegEnable);
    LogUtils.i(TAG, "DeviceAttrs deviceJpegDisable = " + this.deviceJpegDisable);
    LogUtils.i(TAG, "DeviceAttrs es_GL_EXT_shader_framebuffer_fetch = " + this.es_GL_EXT_shader_framebuffer_fetch);
    LogUtils.i(TAG, "DeviceAttrs gpuProcessNeedBackTexture = " + this.gpuProcessNeedBackTexture);
    LogUtils.i(TAG, "DeviceAttrs cannotFlashWhileAutoFocus = " + this.cannotFlashWhileAutoFocus);
    LogUtils.i(TAG, "DeviceAttrs frontCamCannotRotate = " + this.frontCamCannotRotate);
    LogUtils.i(TAG, "DeviceAttrs readMaxNumMeteringAreasAbnormal = " + this.readMaxNumMeteringAreasAbnormal);
    LogUtils.i(TAG, "DeviceAttrs readMaxNumFocusAreasAbnormal = " + this.readMaxNumFocusAreasAbnormal);
    LogUtils.i(TAG, "DeviceAttrs cannotRotatePreview = " + this.cannotRotatePreview);
    LogUtils.i(TAG, "DeviceAttrs cannotFlashWhileFlashOn = " + this.cannotFlashWhileFlashOn);
    LogUtils.i(TAG, "DeviceAttrs backCamCannotRotate = " + this.backCamCannotRotate);
    LogUtils.i(TAG, "DeviceAttrs end-------------------------------------------------------------");
  }
  
  private boolean openFastCaptureMode(Camera.Parameters paramParameters)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramParameters != null)
    {
      bool1 = bool2;
      if (this.mFastCaptureKeys != null)
      {
        bool1 = bool2;
        if (this.mFastCaptureOnValues != null)
        {
          int i = 0;
          bool1 = false;
          while ((i < this.mFastCaptureKeys.size()) && (i < this.mFastCaptureOnValues.size()))
          {
            String str = (String)this.mFastCaptureKeys.get(i);
            if (paramParameters.get(str) != null)
            {
              paramParameters.set(str, (String)this.mFastCaptureOnValues.get(i));
              bool1 = true;
            }
            i += 1;
          }
        }
      }
    }
    return bool1;
  }
  
  private void parseCurrentAttrsXML(String paramString)
  {
    LogUtils.i(TAG, "[parseCurrentAttrsXML] + BEGIN");
    if (TextUtils.isEmpty(paramString))
    {
      LogUtils.e(TAG, "[parseCurrentAttrsXML] sourceString is empty");
      return;
    }
    try
    {
      localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      i = localXmlPullParser.getEventType();
      localEditor = this.mCameraMatchPref.edit();
      paramString = Boolean.valueOf(false);
    }
    catch (XmlPullParserException paramString)
    {
      for (;;)
      {
        LogUtils.e(paramString);
        LogUtils.i(TAG, "[parseCurrentAttrsXML] + END");
        return;
        localEditor.putBoolean(paramString, Boolean.valueOf(Boolean.parseBoolean(str2)).booleanValue());
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        XmlPullParser localXmlPullParser;
        int i;
        SharedPreferences.Editor localEditor;
        String str3;
        Object localObject;
        String str4;
        int j;
        String str2;
        LogUtils.e(paramString);
        continue;
        paramString = Boolean.valueOf(true);
        continue;
        if (((String)localObject).startsWith(str3))
        {
          LogUtils.d(TAG, "parseCurrentAttrsXML myPhoneType = " + str2 + ", subTagName = " + (String)localObject);
          j = localXmlPullParser.getAttributeCount();
          i = 0;
          if (i < j)
          {
            str2 = localXmlPullParser.getAttributeName(i);
            str3 = localXmlPullParser.getAttributeValue(i);
            if (str2.startsWith("int_")) {
              localEditor.putInt(str2, Integer.valueOf(Integer.parseInt(str3)).intValue());
            }
            for (;;)
            {
              LogUtils.i(TAG, "parseCurrentAttrsXML(subNode) item[" + (i + 1) + "] name = " + str2 + ", value = " + str3);
              i += 1;
              break;
              if (str2.startsWith("str_")) {
                localEditor.putString(str2, String.valueOf(str3));
              } else {
                localEditor.putBoolean(str2, Boolean.valueOf(Boolean.parseBoolean(str3)).booleanValue());
              }
            }
          }
        }
        else if (str3.equals(str4))
        {
          j = localXmlPullParser.getAttributeCount();
          if (j != 0)
          {
            str2 = localXmlPullParser.getAttributeName(0);
            str3 = localXmlPullParser.getAttributeValue(0);
            if (str2.startsWith("condition"))
            {
              localObject = new HashSet();
              i = 1;
              if (i < j)
              {
                str4 = localXmlPullParser.getAttributeName(i) + "_" + str2 + "_" + str3;
                String str5 = localXmlPullParser.getAttributeValue(i);
                if (str4.startsWith("int_")) {
                  localEditor.putInt(str4, Integer.valueOf(Integer.parseInt(str5)).intValue());
                }
                for (;;)
                {
                  ((Set)localObject).add(localXmlPullParser.getAttributeName(i));
                  LogUtils.i(TAG, "parseCurrentAttrsXML(condition) item[" + (i + 1) + "] name = " + str4 + ", value = " + str5);
                  i += 1;
                  break;
                  if (str4.startsWith("str_")) {
                    localEditor.putString(str4, String.valueOf(str5));
                  } else {
                    localEditor.putBoolean(str4, Boolean.valueOf(Boolean.parseBoolean(str5)).booleanValue());
                  }
                }
              }
              localEditor.putStringSet(str2 + "_" + str3, (Set)localObject);
              localEditor.apply();
              continue;
              do
              {
                if (!paramString.booleanValue()) {
                  break;
                }
                localEditor.putBoolean("is_need_parse_xml", false);
                localEditor.apply();
                break;
              } while (i == 1);
            }
          }
        }
        else
        {
          switch (i)
          {
          case 2: 
          case 1: 
          default: 
            break;
          }
        }
      }
    }
    i = localXmlPullParser.next();
    break label1019;
    str3 = localXmlPullParser.getName();
    for (;;)
    {
      try
      {
        String str1 = DeviceInstance.getInstance().getDeviceName();
        localObject = str1 + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase();
        str4 = str1 + "_Condition";
        if (!str3.equals(str1)) {
          break label432;
        }
        LogUtils.d(TAG, "parseCurrentAttrsXML myPhoneType = " + str1 + ", subTagName = " + (String)localObject);
        j = localXmlPullParser.getAttributeCount();
        i = 0;
        if (i >= j) {
          break label424;
        }
        paramString = localXmlPullParser.getAttributeName(i);
        str1 = localXmlPullParser.getAttributeValue(i);
        if (paramString.startsWith("int_"))
        {
          localEditor.putInt(paramString, Integer.valueOf(Integer.parseInt(str1)).intValue());
          LogUtils.i(TAG, "parseCurrentAttrsXML item[" + (i + 1) + "] name = " + paramString + ", value = " + str1);
          i += 1;
          continue;
        }
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        LogUtils.e(localNoClassDefFoundError);
        str2 = "default_defalut";
        continue;
      }
      if (!paramString.startsWith("str_")) {
        break;
      }
      localEditor.putString(paramString, String.valueOf(str2));
    }
  }
  
  /* Error */
  private JsonObject parseFastCaptureFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 413
    //   5: astore 4
    //   7: getstatic 292	com/tencent/ttpic/baseutils/device/DeviceAttrs:PARSE_XML_DEBUG_MODE	Ljava/lang/Boolean;
    //   10: invokevirtual 419	java/lang/Boolean:booleanValue	()Z
    //   13: ifne +48 -> 61
    //   16: aload_0
    //   17: getfield 442	com/tencent/ttpic/baseutils/device/DeviceAttrs:mContext	Landroid/content/Context;
    //   20: ldc_w 912
    //   23: aload_0
    //   24: getfield 445	com/tencent/ttpic/baseutils/device/DeviceAttrs:mSignature	Ljava/lang/String;
    //   27: invokestatic 917	com/tencent/ttpic/baseutils/device/DeviceParser:parseFastCaptureFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_2
    //   36: astore_3
    //   37: aload_1
    //   38: ifnull +9 -> 47
    //   41: aload_1
    //   42: invokestatic 923	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   45: aload_2
    //   46: astore_3
    //   47: aload_3
    //   48: invokestatic 774	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +78 -> 129
    //   54: aload_3
    //   55: invokestatic 927	com/tencent/ttpic/util/GsonUtils:json2JsonObject	(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    //   58: astore_1
    //   59: aload_1
    //   60: areturn
    //   61: aload_0
    //   62: getfield 442	com/tencent/ttpic/baseutils/device/DeviceAttrs:mContext	Landroid/content/Context;
    //   65: invokevirtual 931	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   68: ldc_w 933
    //   71: invokevirtual 939	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   74: astore_1
    //   75: aload_1
    //   76: astore_2
    //   77: aload_1
    //   78: invokestatic 942	com/tencent/ttpic/baseutils/io/IOUtils:toString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   81: astore_3
    //   82: aload_3
    //   83: astore_2
    //   84: goto -49 -> 35
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: astore_2
    //   92: aload_3
    //   93: invokestatic 880	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   96: aload 4
    //   98: astore_3
    //   99: aload_1
    //   100: ifnull -53 -> 47
    //   103: aload_1
    //   104: invokestatic 923	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   107: aload 4
    //   109: astore_3
    //   110: goto -63 -> 47
    //   113: astore_1
    //   114: aload_2
    //   115: ifnull +7 -> 122
    //   118: aload_2
    //   119: invokestatic 923	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_1
    //   132: goto -18 -> 114
    //   135: astore_3
    //   136: goto -46 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	DeviceAttrs
    //   30	74	1	localObject1	Object
    //   113	10	1	localObject2	Object
    //   124	2	1	localException1	Exception
    //   131	1	1	localObject3	Object
    //   1	118	2	localObject4	Object
    //   36	47	3	localObject5	Object
    //   87	6	3	localException2	Exception
    //   98	12	3	str1	String
    //   135	1	3	localException3	Exception
    //   5	103	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   7	31	87	java/lang/Exception
    //   61	75	87	java/lang/Exception
    //   7	31	113	finally
    //   61	75	113	finally
    //   54	59	124	java/lang/Exception
    //   77	82	131	finally
    //   92	96	131	finally
    //   77	82	135	java/lang/Exception
  }
  
  public void checkOnlineUpdate(String paramString, DeviceAttrs.UpdateListener paramUpdateListener)
  {
    LogUtils.i(TAG, "[checkOnlineUpdate] + BEGIN, downloadUrl = " + paramString);
    Object localObject = this.mBuildInFileDir + "phone_attrs_config.zip";
    String str = this.mCameraMatchPref.getString("black_list_url", null);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equalsIgnoreCase(str))) {
      if (DeviceUpdate.httpDownloadFile(paramString, (String)localObject))
      {
        str = DeviceUpdate.unZip((String)localObject, this.mBuildInFileDir);
        if (!TextUtils.isEmpty(str))
        {
          LogUtils.d(TAG, "[checkOnlineUpdate] storageName = " + (String)localObject + ", mBuildInFileDir = " + this.mBuildInFileDir);
          localObject = this.mCameraMatchPref.edit();
          ((SharedPreferences.Editor)localObject).putString("black_list_url", paramString);
          ((SharedPreferences.Editor)localObject).apply();
          localObject = DeviceParser.parseCameraAttrsFile(this.mContext, str, DeviceInstance.getInstance().getDeviceName(), this.mSignature);
          LogUtils.d(TAG, "[checkOnlineUpdate] source = " + (String)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            parseCurrentAttrsXML((String)localObject);
          }
          if (paramUpdateListener != null) {
            paramUpdateListener.onSuccess(paramString + ", download and parse success");
          }
          loadAttrsFromPref();
          logAttrsValues();
          paramString = new Intent();
          paramString.setAction("action_check_online_update_finish");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramString.putExtra("parse_result", true);
            this.mContext.sendBroadcast(paramString);
          }
        }
      }
    }
    for (;;)
    {
      LogUtils.i(TAG, "[checkOnlineUpdate] + END");
      return;
      paramString.putExtra("parse_result", false);
      break;
      paramUpdateListener.onFailed(paramString + ", download success, but unZip failed");
      continue;
      paramUpdateListener.onFailed(paramString + ", download failed!");
      continue;
      if (paramUpdateListener != null) {
        paramUpdateListener.onFailed(paramString + ", this url has been downloaded, no need check update!");
      }
    }
  }
  
  public void checkVersion(String paramString1, String paramString2, String paramString3, DeviceAttrs.UpdateListener paramUpdateListener)
  {
    LogUtils.i(TAG, "[checkVersion] + BEGIN");
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new DeviceAttrs.1(this, paramString1, paramString2, paramString3, paramUpdateListener));
    LogUtils.i(TAG, "[checkVersion] + END");
  }
  
  public void clearAllPreference()
  {
    if (this.mCameraMatchPref != null) {
      this.mCameraMatchPref.edit().clear().apply();
    }
  }
  
  public long getMonitorEnableTime()
  {
    long l = 0L;
    if (this.mCameraMatchPref != null) {
      l = this.mCameraMatchPref.getLong("enable_performance_monitor_begin_time", 0L);
    }
    return l;
  }
  
  public String getPreviousUrl()
  {
    String str = "";
    if (this.mCameraMatchPref != null) {
      str = this.mCameraMatchPref.getString("black_list_url", "");
    }
    return str;
  }
  
  public SizeI getRecordVideoSize(int paramInt1, int paramInt2)
  {
    SizeI localSizeI = new SizeI(paramInt1, paramInt2);
    Object localObject = getInstance().str_recordVideoSize;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\*");
      if (localObject.length >= 2) {}
    }
    else
    {
      return localSizeI;
    }
    try
    {
      paramInt1 = Integer.parseInt(localObject[0]);
      localObject = new SizeI(Integer.parseInt(localObject[1]), paramInt1);
      return localObject;
    }
    catch (Exception localException)
    {
      LogUtils.e(TAG, "Parse record size error!");
      localException.printStackTrace();
    }
    return localSizeI;
  }
  
  public void init(Context paramContext, String paramString)
  {
    LogUtils.i(TAG, "[init] + BEGIN");
    long l = System.currentTimeMillis();
    this.mContext = paramContext;
    this.mSignature = paramString;
    if (paramContext.getFilesDir() != null) {
      this.mBuildInFileDir = (paramContext.getFilesDir().toString() + "/");
    }
    this.mCameraMatchPref = this.mContext.getSharedPreferences(getCameraPrefName(this.mContext), 0);
    boolean bool;
    if (this.mCameraMatchPref != null)
    {
      bool = this.mCameraMatchPref.getBoolean("is_need_parse_xml", true);
      paramContext = "default_defalut";
    }
    try
    {
      paramString = DeviceInstance.getInstance().getDeviceName();
      paramContext = paramString;
    }
    catch (NoClassDefFoundError paramString)
    {
      for (;;)
      {
        LogUtils.e(paramString);
        continue;
        LogUtils.d(TAG, "本地适配文件解密并解析 [失败]");
      }
    }
    LogUtils.d(TAG, "[init] deviceName = " + paramContext);
    if (bool)
    {
      paramContext = DeviceParser.parseCameraAttrsFile(this.mContext, "phone_attrs_config.dat", paramContext, this.mSignature);
      LogUtils.d(TAG, "[init] source: " + paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        parseCurrentAttrsXML(paramContext);
      }
      if (LogUtils.isEnabled())
      {
        if (TextUtils.isEmpty(paramContext)) {
          break label267;
        }
        LogUtils.d(TAG, "本地适配文件解密并解析 [成功]");
      }
    }
    loadAttrsFromPref();
    logAttrsValues();
    LogUtils.i(TAG, "[init] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  public boolean isCameraSDKDisable()
  {
    boolean bool = false;
    if (this.mCameraMatchPref != null) {
      bool = this.mCameraMatchPref.getBoolean("pref_camerasdk_disable", false);
    }
    return bool;
  }
  
  public boolean isEnableEXTShaderFramebufferFetch()
  {
    return getInstance().es_GL_EXT_shader_framebuffer_fetch;
  }
  
  public boolean isNativeJpegCompressEnable()
  {
    return (getInstance().serverJpegEnable) && (!getInstance().deviceJpegDisable);
  }
  
  public void setMonitorEnableTime(long paramLong)
  {
    if (this.mCameraMatchPref != null) {
      this.mCameraMatchPref.edit().putLong("enable_performance_monitor_begin_time", paramLong).apply();
    }
  }
  
  public void setRecordVideoSize(int paramInt1, int paramInt2)
  {
    if (this.mCameraMatchPref != null) {
      this.mCameraMatchPref.edit().putString("str_recordVideoSize", paramInt2 + "*" + paramInt1).apply();
    }
  }
  
  public void update(String paramString, DeviceAttrs.UpdateListener paramUpdateListener)
  {
    Object localObject = "default_defalut";
    try
    {
      String str = DeviceInstance.getInstance().getDeviceName();
      localObject = str;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      for (;;)
      {
        LogUtils.e(localNoClassDefFoundError);
      }
    }
    LogUtils.d(TAG, "[update] deviceName = " + (String)localObject);
    localObject = DeviceParser.parseCameraAttrsFile(this.mContext, paramString, (String)localObject, this.mSignature);
    LogUtils.d(TAG, "[update] source: " + (String)localObject);
    if (localObject != null) {
      parseCurrentAttrsXML((String)localObject);
    }
    loadAttrsFromPref();
    logAttrsValues();
    if (paramUpdateListener != null) {
      paramUpdateListener.onSuccess(paramString + ", parse and reload success");
    }
    paramString = new Intent();
    paramString.setAction("action_check_online_update_finish");
    if (this.mContext != null) {
      this.mContext.sendBroadcast(paramString);
    }
  }
  
  public boolean updateCameraParametersFastCapture(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    if (isInFastCaptureWhiteList(paramBoolean))
    {
      initFastCaptureKeyValue();
      boolean bool = openFastCaptureMode(paramParameters);
      LogUtils.d(TAG, "[updateCameraParametersFastCapture] this camera id in white list YES, OPEN fast mode, isFrontCamera = " + paramBoolean + ", updated = " + bool);
      return bool;
    }
    LogUtils.d(TAG, "[updateCameraParametersFastCapture] this camera id in white list NO, do NOTHING, isFrontCamera = " + paramBoolean);
    return false;
  }
  
  public void updatePreviewCondition(int paramInt1, int paramInt2)
  {
    if (this.mCameraMatchPref == null) {
      return;
    }
    String str = "conditionPreviewSize" + "_" + paramInt1 + "*" + paramInt2;
    Set localSet = this.mCameraMatchPref.getStringSet(str, new HashSet());
    this.int_frontCamRotate0 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontCamRotate0", str), -1);
    this.int_frontCamRotate90 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontCamRotate90", str), -1);
    this.int_frontCamRotate180 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontCamRotate180", str), -1);
    this.int_frontCamRotate270 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontCamRotate270", str), -1);
    this.int_backCamRotate0 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backCamRotate0", str), -1);
    this.int_backCamRotate90 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backCamRotate90", str), -1);
    this.int_backCamRotate180 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backCamRotate180", str), -1);
    this.int_backCamRotate270 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backCamRotate270", str), -1);
    this.int_frontExifRotate0 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontExifRotate0", str), -1);
    this.int_frontExifRotate90 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontExifRotate90", str), -1);
    this.int_frontExifRotate180 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontExifRotate180", str), -1);
    this.int_frontExifRotate270 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontExifRotate270", str), -1);
    this.int_backExifRotate0 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backExifRotate0", str), -1);
    this.int_backExifRotate90 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backExifRotate90", str), -1);
    this.int_backExifRotate180 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backExifRotate180", str), -1);
    this.int_backExifRotate270 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backExifRotate270", str), -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceAttrs
 * JD-Core Version:    0.7.0.1
 */