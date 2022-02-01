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
  public static final Boolean ENABLE_LOG;
  public static final int ENABLE_PERFORMANCE_MONITOR_THRESHOLD = 604800000;
  private static final DeviceAttrs INSTANCE = new DeviceAttrs();
  public static final String KEY_CAMERASDK_DISABLE = "pref_camerasdk_disable";
  public static final String KEY_CAMERASDK_FAILED_TIMES = "pref_camerasdk_open_failed_times";
  public static final String KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME = "enable_performance_monitor_begin_time";
  public static final String KEY_NEED_PARSE_XML = "is_need_parse_xml";
  public static final String KEY_PARSE_RESULT = "parse_result";
  public static final String KEY_URL_VALUE = "black_list_url";
  public static final String KEY_VERSION = "xml_version";
  public static final Boolean PARSE_XML_DEBUG_MODE;
  private static final String TAG;
  private static final Boolean TEST_URL;
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
  private static final String sReleaseURL = "https://xiangji.qq.com/services/cameraCoreSvr.php";
  private static final String sTestURL = "https://test.xiangji.qq.com/services/cameraCoreSvr.php";
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
    Boolean localBoolean = Boolean.valueOf(false);
    ENABLE_LOG = localBoolean;
    PARSE_XML_DEBUG_MODE = localBoolean;
    TEST_URL = localBoolean;
    TAG = DeviceAttrs.class.getSimpleName();
  }
  
  private DeviceAttrs()
  {
    String str;
    if (TEST_URL.booleanValue()) {
      str = "https://test.xiangji.qq.com/services/cameraCoreSvr.php";
    } else {
      str = "https://xiangji.qq.com/services/cameraCoreSvr.php";
    }
    this.mRequestUrl = str;
    this.mFastCaptureKeys = new ArrayList();
    this.mFastCaptureOnValues = new ArrayList();
  }
  
  private String editKey(Set<String> paramSet, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramSet.contains(paramString1))
    {
      paramSet = new StringBuilder();
      paramSet.append(paramString1);
      paramSet.append("_");
      paramSet.append(paramString2);
      str = paramSet.toString();
    }
    return str;
  }
  
  private String getCameraPrefName(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("_preferences_camera_adapter");
    return localStringBuilder.toString();
  }
  
  public static DeviceAttrs getInstance()
  {
    return INSTANCE;
  }
  
  private void initFastCaptureKeyValue()
  {
    Object localObject = this.mFastCaptureKeys;
    if ((localObject != null) && (this.mFastCaptureOnValues != null) && (((List)localObject).isEmpty()) && (this.mFastCaptureOnValues.isEmpty()))
    {
      this.mFastCaptureKeys.clear();
      this.mFastCaptureOnValues.clear();
      try
      {
        localObject = parseFastCaptureFile();
        if (localObject != null)
        {
          JsonArray localJsonArray = ((JsonObject)localObject).getAsJsonArray("key");
          int j = 0;
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
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_deviceSocInfo = ");
    localStringBuilder.append(this.str_deviceSocInfo);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_deviceSocInfo = ");
    localStringBuilder.append(this.str_deviceSocInfo);
    LogUtils.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableCameraSDK = ");
    localStringBuilder.append(this.disableCameraSDK);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableCameraVideo = ");
    localStringBuilder.append(this.disableCameraVideo);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs enablePerformanceMonitor = ");
    localStringBuilder.append(this.enablePerformanceMonitor);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableLiteEditor = ");
    localStringBuilder.append(this.disableLiteEditor);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs readCamNumException = ");
    localStringBuilder.append(this.readCamNumException);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableFrontCamera = ");
    localStringBuilder.append(this.disableFrontCamera);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs beBlurredPreviewAfterTakePic = ");
    localStringBuilder.append(this.beBlurredPreviewAfterTakePic);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs beBlurredPicAfterTakePic = ");
    localStringBuilder.append(this.beBlurredPicAfterTakePic);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs enableFastCapture4FrontCamera = ");
    localStringBuilder.append(this.enableFastCapture4FrontCamera);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs enableFastCapture4BackCamera = ");
    localStringBuilder.append(this.enableFastCapture4BackCamera);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_videoPreview720Fps = ");
    localStringBuilder.append(this.str_videoPreview720Fps);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_frontPreviewSize43 = ");
    localStringBuilder.append(this.str_frontPreviewSize43);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_frontPreviewSize169 = ");
    localStringBuilder.append(this.str_frontPreviewSize169);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_backPreviewSize43 = ");
    localStringBuilder.append(this.str_backPreviewSize43);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_backPreviewSize169 = ");
    localStringBuilder.append(this.str_backPreviewSize169);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_frontPictureSize43 = ");
    localStringBuilder.append(this.str_frontPictureSize43);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_backPictureSize43 = ");
    localStringBuilder.append(this.str_backPictureSize43);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs str_recordVideoSize = ");
    localStringBuilder.append(this.str_recordVideoSize);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableBackFlashMode = ");
    localStringBuilder.append(this.disableBackFlashMode);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs frontFlashModeException = ");
    localStringBuilder.append(this.frontFlashModeException);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs backFlashModeException = ");
    localStringBuilder.append(this.backFlashModeException);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs backFlashNoOn = ");
    localStringBuilder.append(this.backFlashNoOn);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs backFlashNoAuto = ");
    localStringBuilder.append(this.backFlashNoAuto);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs backFlashNoTorch = ");
    localStringBuilder.append(this.backFlashNoTorch);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs frontFlashNoAuto = ");
    localStringBuilder.append(this.frontFlashNoAuto);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableFocusMode = ");
    localStringBuilder.append(this.disableFocusMode);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableFocusModeContinuousPicture = ");
    localStringBuilder.append(this.disableFocusModeContinuousPicture);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableAutoFocusDouble = ");
    localStringBuilder.append(this.disableAutoFocusDouble);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableFaceDetection = ");
    localStringBuilder.append(this.disableFaceDetection);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_frontCamRotate0 = ");
    localStringBuilder.append(this.int_frontCamRotate0);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_frontCamRotate90 = ");
    localStringBuilder.append(this.int_frontCamRotate90);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_frontCamRotate180 = ");
    localStringBuilder.append(this.int_frontCamRotate180);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_frontCamRotate270 = ");
    localStringBuilder.append(this.int_frontCamRotate270);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_backCamRotate0 = ");
    localStringBuilder.append(this.int_backCamRotate0);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_backCamRotate90 = ");
    localStringBuilder.append(this.int_backCamRotate90);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_backCamRotate180 = ");
    localStringBuilder.append(this.int_backCamRotate180);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_backCamRotate270 = ");
    localStringBuilder.append(this.int_backCamRotate270);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_frontExifRotate0 = ");
    localStringBuilder.append(this.int_frontExifRotate0);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_frontExifRotate90 = ");
    localStringBuilder.append(this.int_frontExifRotate90);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_frontExifRotate180 = ");
    localStringBuilder.append(this.int_frontExifRotate180);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_frontExifRotate270 = ");
    localStringBuilder.append(this.int_frontExifRotate270);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_backExifRotate0 = ");
    localStringBuilder.append(this.int_backExifRotate0);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_backExifRotate90 = ");
    localStringBuilder.append(this.int_backExifRotate90);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_backExifRotate180 = ");
    localStringBuilder.append(this.int_backExifRotate180);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs int_backExifRotate270 = ");
    localStringBuilder.append(this.int_backExifRotate270);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs frontCamFlipH = ");
    localStringBuilder.append(this.frontCamFlipH);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableFrontExposure = ");
    localStringBuilder.append(this.disableFrontExposure);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs disableBackExposure = ");
    localStringBuilder.append(this.disableBackExposure);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs frontExposureStepOne = ");
    localStringBuilder.append(this.frontExposureStepOne);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs backExposureStepOne = ");
    localStringBuilder.append(this.backExposureStepOne);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs serverJpegEnable = ");
    localStringBuilder.append(this.serverJpegEnable);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs deviceJpegDisable = ");
    localStringBuilder.append(this.deviceJpegDisable);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs es_GL_EXT_shader_framebuffer_fetch = ");
    localStringBuilder.append(this.es_GL_EXT_shader_framebuffer_fetch);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs gpuProcessNeedBackTexture = ");
    localStringBuilder.append(this.gpuProcessNeedBackTexture);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs cannotFlashWhileAutoFocus = ");
    localStringBuilder.append(this.cannotFlashWhileAutoFocus);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs frontCamCannotRotate = ");
    localStringBuilder.append(this.frontCamCannotRotate);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs readMaxNumMeteringAreasAbnormal = ");
    localStringBuilder.append(this.readMaxNumMeteringAreasAbnormal);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs readMaxNumFocusAreasAbnormal = ");
    localStringBuilder.append(this.readMaxNumFocusAreasAbnormal);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs cannotRotatePreview = ");
    localStringBuilder.append(this.cannotRotatePreview);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs cannotFlashWhileFlashOn = ");
    localStringBuilder.append(this.cannotFlashWhileFlashOn);
    LogUtils.i(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceAttrs backCamCannotRotate = ");
    localStringBuilder.append(this.backCamCannotRotate);
    LogUtils.i(str, localStringBuilder.toString());
    LogUtils.i(TAG, "DeviceAttrs end-------------------------------------------------------------");
  }
  
  private boolean openFastCaptureMode(Camera.Parameters paramParameters)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (paramParameters != null)
    {
      bool1 = bool2;
      if (this.mFastCaptureKeys != null)
      {
        bool1 = bool2;
        if (this.mFastCaptureOnValues != null)
        {
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
    int i;
    try
    {
      localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      i = localXmlPullParser.getEventType();
      localEditor = this.mCameraMatchPref.edit();
      paramString = Boolean.valueOf(false);
    }
    catch (IOException paramString)
    {
      XmlPullParser localXmlPullParser;
      SharedPreferences.Editor localEditor;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      Object localObject5;
      boolean bool;
      int j;
      LogUtils.e(paramString);
      break label1206;
    }
    catch (XmlPullParserException paramString)
    {
      LogUtils.e(paramString);
    }
    localObject3 = localXmlPullParser.getName();
    Object localObject1 = "default_defalut";
    try
    {
      String str1 = DeviceInstance.getInstance().getDeviceName();
      localObject1 = str1;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      LogUtils.e(localNoClassDefFoundError);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(Build.DISPLAY.replace(" ", "_").toUpperCase());
    localObject4 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_Condition");
    localObject5 = ((StringBuilder)localObject2).toString();
    bool = ((String)localObject3).equals(localObject1);
    localObject2 = "str_";
    if (bool)
    {
      paramString = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseCurrentAttrsXML myPhoneType = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", subTagName = ");
      ((StringBuilder)localObject2).append((String)localObject4);
      LogUtils.d(paramString, ((StringBuilder)localObject2).toString());
      j = localXmlPullParser.getAttributeCount();
      i = 0;
      while (i < j)
      {
        paramString = localXmlPullParser.getAttributeName(i);
        localObject1 = localXmlPullParser.getAttributeValue(i);
        if (paramString.startsWith("int_")) {
          localEditor.putInt(paramString, Integer.valueOf(Integer.parseInt((String)localObject1)).intValue());
        } else if (paramString.startsWith("str_")) {
          localEditor.putString(paramString, String.valueOf(localObject1));
        } else {
          localEditor.putBoolean(paramString, Boolean.valueOf(Boolean.parseBoolean((String)localObject1)).booleanValue());
        }
        localObject2 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("parseCurrentAttrsXML item[");
        i += 1;
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("] name = ");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(", value = ");
        ((StringBuilder)localObject3).append((String)localObject1);
        LogUtils.i((String)localObject2, ((StringBuilder)localObject3).toString());
      }
      localObject1 = Boolean.valueOf(true);
    }
    else
    {
      j = 1;
      if (((String)localObject4).startsWith((String)localObject3))
      {
        localObject2 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("parseCurrentAttrsXML myPhoneType = ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(", subTagName = ");
        ((StringBuilder)localObject3).append((String)localObject4);
        LogUtils.d((String)localObject2, ((StringBuilder)localObject3).toString());
        j = localXmlPullParser.getAttributeCount();
        i = 0;
        for (;;)
        {
          localObject1 = paramString;
          if (i >= j) {
            break;
          }
          localObject1 = localXmlPullParser.getAttributeName(i);
          localObject2 = localXmlPullParser.getAttributeValue(i);
          if (((String)localObject1).startsWith("int_")) {
            localEditor.putInt((String)localObject1, Integer.valueOf(Integer.parseInt((String)localObject2)).intValue());
          } else if (((String)localObject1).startsWith("str_")) {
            localEditor.putString((String)localObject1, String.valueOf(localObject2));
          } else {
            localEditor.putBoolean((String)localObject1, Boolean.valueOf(Boolean.parseBoolean((String)localObject2)).booleanValue());
          }
          localObject3 = TAG;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("parseCurrentAttrsXML(subNode) item[");
          i += 1;
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append("] name = ");
          ((StringBuilder)localObject4).append((String)localObject1);
          ((StringBuilder)localObject4).append(", value = ");
          ((StringBuilder)localObject4).append((String)localObject2);
          LogUtils.i((String)localObject3, ((StringBuilder)localObject4).toString());
        }
      }
      localObject1 = paramString;
      if (((String)localObject3).equals(localObject5))
      {
        i = localXmlPullParser.getAttributeCount();
        if (i == 0)
        {
          localObject1 = paramString;
        }
        else
        {
          localObject3 = localXmlPullParser.getAttributeName(0);
          localObject4 = localXmlPullParser.getAttributeValue(0);
          if (!((String)localObject3).startsWith("condition"))
          {
            localObject1 = paramString;
          }
          else
          {
            localObject5 = new HashSet();
            localObject1 = localObject2;
            while (j < i)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(localXmlPullParser.getAttributeName(j));
              ((StringBuilder)localObject2).append("_");
              ((StringBuilder)localObject2).append((String)localObject3);
              ((StringBuilder)localObject2).append("_");
              ((StringBuilder)localObject2).append((String)localObject4);
              localObject2 = ((StringBuilder)localObject2).toString();
              String str2 = localXmlPullParser.getAttributeValue(j);
              if (((String)localObject2).startsWith("int_")) {
                localEditor.putInt((String)localObject2, Integer.valueOf(Integer.parseInt(str2)).intValue());
              } else if (((String)localObject2).startsWith((String)localObject1)) {
                localEditor.putString((String)localObject2, String.valueOf(str2));
              } else {
                localEditor.putBoolean((String)localObject2, Boolean.valueOf(Boolean.parseBoolean(str2)).booleanValue());
              }
              ((Set)localObject5).add(localXmlPullParser.getAttributeName(j));
              String str3 = TAG;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("parseCurrentAttrsXML(condition) item[");
              j += 1;
              localStringBuilder.append(j);
              localStringBuilder.append("] name = ");
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append(", value = ");
              localStringBuilder.append(str2);
              LogUtils.i(str3, localStringBuilder.toString());
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject3);
            ((StringBuilder)localObject1).append("_");
            ((StringBuilder)localObject1).append((String)localObject4);
            localEditor.putStringSet(((StringBuilder)localObject1).toString(), (Set)localObject5);
            localEditor.apply();
            localObject1 = paramString;
          }
        }
      }
    }
    for (;;)
    {
      i = localXmlPullParser.next();
      paramString = (String)localObject1;
      label1206:
      while (i == 1)
      {
        if (paramString.booleanValue())
        {
          localEditor.putBoolean("is_need_parse_xml", false);
          localEditor.apply();
        }
        LogUtils.i(TAG, "[parseCurrentAttrsXML] + END");
        return;
      }
      localObject1 = paramString;
      if (i != 0)
      {
        if (i == 2) {
          break;
        }
        localObject1 = paramString;
      }
    }
  }
  
  /* Error */
  private JsonObject parseFastCaptureFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 292	com/tencent/ttpic/baseutils/device/DeviceAttrs:PARSE_XML_DEBUG_MODE	Ljava/lang/Boolean;
    //   5: invokevirtual 419	java/lang/Boolean:booleanValue	()Z
    //   8: ifne +25 -> 33
    //   11: aload_0
    //   12: getfield 442	com/tencent/ttpic/baseutils/device/DeviceAttrs:mContext	Landroid/content/Context;
    //   15: ldc_w 912
    //   18: aload_0
    //   19: getfield 445	com/tencent/ttpic/baseutils/device/DeviceAttrs:mSignature	Ljava/lang/String;
    //   22: invokestatic 917	com/tencent/ttpic/baseutils/device/DeviceParser:parseFastCaptureFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_3
    //   29: astore_2
    //   30: goto +22 -> 52
    //   33: aload_0
    //   34: getfield 442	com/tencent/ttpic/baseutils/device/DeviceAttrs:mContext	Landroid/content/Context;
    //   37: invokevirtual 921	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   40: ldc_w 923
    //   43: invokevirtual 929	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   46: astore_1
    //   47: aload_1
    //   48: invokestatic 934	com/tencent/ttpic/baseutils/io/IOUtils:toString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   51: astore_2
    //   52: aload_2
    //   53: astore_3
    //   54: aload_1
    //   55: ifnull +47 -> 102
    //   58: aload_1
    //   59: invokestatic 938	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   62: aload_2
    //   63: astore_3
    //   64: goto +38 -> 102
    //   67: astore_2
    //   68: goto +56 -> 124
    //   71: astore_2
    //   72: goto +14 -> 86
    //   75: astore_3
    //   76: aload_2
    //   77: astore_1
    //   78: aload_3
    //   79: astore_2
    //   80: goto +44 -> 124
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_2
    //   87: invokestatic 818	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokestatic 938	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   98: ldc_w 413
    //   101: astore_3
    //   102: aload_3
    //   103: invokestatic 774	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifne +15 -> 121
    //   109: aload_3
    //   110: invokestatic 942	com/tencent/ttpic/util/GsonUtils:json2JsonObject	(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    //   113: astore_1
    //   114: aload_1
    //   115: areturn
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_2
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokestatic 938	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   132: aload_2
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	DeviceAttrs
    //   27	88	1	localObject1	Object
    //   116	13	1	localException1	Exception
    //   1	62	2	localObject2	Object
    //   67	1	2	localObject3	Object
    //   71	6	2	localException2	Exception
    //   79	1	2	localObject4	Object
    //   83	4	2	localException3	Exception
    //   123	10	2	localObject5	Object
    //   25	39	3	localObject6	Object
    //   75	4	3	localObject7	Object
    //   101	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   47	52	67	finally
    //   47	52	71	java/lang/Exception
    //   2	26	75	finally
    //   33	47	75	finally
    //   2	26	83	java/lang/Exception
    //   33	47	83	java/lang/Exception
    //   109	114	116	java/lang/Exception
    //   86	90	123	finally
  }
  
  public void checkOnlineUpdate(String paramString, DeviceAttrs.UpdateListener paramUpdateListener)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[checkOnlineUpdate] + BEGIN, downloadUrl = ");
    ((StringBuilder)localObject2).append(paramString);
    LogUtils.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mBuildInFileDir);
    ((StringBuilder)localObject1).append("phone_attrs_config.zip");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = this.mCameraMatchPref.getString("black_list_url", null);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equalsIgnoreCase((String)localObject2)))
    {
      if (DeviceUpdate.httpDownloadFile(paramString, (String)localObject1))
      {
        localObject2 = DeviceUpdate.unZip((String)localObject1, this.mBuildInFileDir);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          Object localObject3 = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[checkOnlineUpdate] storageName = ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(", mBuildInFileDir = ");
          localStringBuilder.append(this.mBuildInFileDir);
          LogUtils.d((String)localObject3, localStringBuilder.toString());
          localObject1 = this.mCameraMatchPref.edit();
          ((SharedPreferences.Editor)localObject1).putString("black_list_url", paramString);
          ((SharedPreferences.Editor)localObject1).apply();
          localObject1 = DeviceParser.parseCameraAttrsFile(this.mContext, (String)localObject2, DeviceInstance.getInstance().getDeviceName(), this.mSignature);
          localObject2 = TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[checkOnlineUpdate] source = ");
          ((StringBuilder)localObject3).append((String)localObject1);
          LogUtils.d((String)localObject2, ((StringBuilder)localObject3).toString());
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            parseCurrentAttrsXML((String)localObject1);
          }
          if (paramUpdateListener != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(", download and parse success");
            paramUpdateListener.onSuccess(((StringBuilder)localObject2).toString());
          }
          loadAttrsFromPref();
          logAttrsValues();
          paramString = new Intent();
          paramString.setAction("action_check_online_update_finish");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString.putExtra("parse_result", true);
          } else {
            paramString.putExtra("parse_result", false);
          }
          this.mContext.sendBroadcast(paramString);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(", download success, but unZip failed");
          paramUpdateListener.onFailed(((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", download failed!");
        paramUpdateListener.onFailed(((StringBuilder)localObject1).toString());
      }
    }
    else if (paramUpdateListener != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", this url has been downloaded, no need check update!");
      paramUpdateListener.onFailed(((StringBuilder)localObject1).toString());
    }
    LogUtils.i(TAG, "[checkOnlineUpdate] + END");
  }
  
  public void checkVersion(String paramString1, String paramString2, String paramString3, DeviceAttrs.UpdateListener paramUpdateListener)
  {
    LogUtils.i(TAG, "[checkVersion] + BEGIN");
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new DeviceAttrs.1(this, paramString1, paramString2, paramString3, paramUpdateListener));
    LogUtils.i(TAG, "[checkVersion] + END");
  }
  
  public void clearAllPreference()
  {
    SharedPreferences localSharedPreferences = this.mCameraMatchPref;
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().clear().apply();
    }
  }
  
  public long getMonitorEnableTime()
  {
    SharedPreferences localSharedPreferences = this.mCameraMatchPref;
    long l = 0L;
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("enable_performance_monitor_begin_time", 0L);
    }
    return l;
  }
  
  public String getPreviousUrl()
  {
    SharedPreferences localSharedPreferences = this.mCameraMatchPref;
    String str = "";
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("black_list_url", "");
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
      if (localObject.length < 2) {
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
    }
    return localSizeI;
  }
  
  public void init(Context paramContext, String paramString)
  {
    LogUtils.i(TAG, "[init] + BEGIN");
    long l = System.currentTimeMillis();
    this.mContext = paramContext;
    this.mSignature = paramString;
    if (paramContext.getFilesDir() != null)
    {
      paramString = new StringBuilder();
      paramString.append(paramContext.getFilesDir().toString());
      paramString.append("/");
      this.mBuildInFileDir = paramString.toString();
    }
    paramContext = this.mContext;
    this.mCameraMatchPref = paramContext.getSharedPreferences(getCameraPrefName(paramContext), 0);
    paramContext = this.mCameraMatchPref;
    if (paramContext != null)
    {
      boolean bool = paramContext.getBoolean("is_need_parse_xml", true);
      try
      {
        paramContext = DeviceInstance.getInstance().getDeviceName();
      }
      catch (NoClassDefFoundError paramContext)
      {
        LogUtils.e(paramContext);
        paramContext = "default_defalut";
      }
      paramString = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[init] deviceName = ");
      localStringBuilder.append(paramContext);
      LogUtils.d(paramString, localStringBuilder.toString());
      if (bool)
      {
        paramContext = DeviceParser.parseCameraAttrsFile(this.mContext, "phone_attrs_config.dat", paramContext, this.mSignature);
        paramString = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[init] source: ");
        localStringBuilder.append(paramContext);
        LogUtils.d(paramString, localStringBuilder.toString());
        if (!TextUtils.isEmpty(paramContext)) {
          parseCurrentAttrsXML(paramContext);
        }
        if (LogUtils.isEnabled()) {
          if (!TextUtils.isEmpty(paramContext)) {
            LogUtils.d(TAG, "本地适配文件解密并解析 [成功]");
          } else {
            LogUtils.d(TAG, "本地适配文件解密并解析 [失败]");
          }
        }
      }
      loadAttrsFromPref();
      logAttrsValues();
    }
    paramContext = TAG;
    paramString = new StringBuilder();
    paramString.append("[init] + END, time cost = ");
    paramString.append(System.currentTimeMillis() - l);
    LogUtils.i(paramContext, paramString.toString());
  }
  
  public boolean isCameraSDKDisable()
  {
    SharedPreferences localSharedPreferences = this.mCameraMatchPref;
    boolean bool = false;
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("pref_camerasdk_disable", false);
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
    SharedPreferences localSharedPreferences = this.mCameraMatchPref;
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("enable_performance_monitor_begin_time", paramLong).apply();
    }
  }
  
  public void setRecordVideoSize(int paramInt1, int paramInt2)
  {
    Object localObject = this.mCameraMatchPref;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("*");
      localStringBuilder.append(paramInt1);
      ((SharedPreferences.Editor)localObject).putString("str_recordVideoSize", localStringBuilder.toString()).apply();
    }
  }
  
  public void update(String paramString, DeviceAttrs.UpdateListener paramUpdateListener)
  {
    try
    {
      String str1 = DeviceInstance.getInstance().getDeviceName();
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      LogUtils.e(localNoClassDefFoundError);
      localObject = "default_defalut";
    }
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[update] deviceName = ");
    localStringBuilder.append((String)localObject);
    LogUtils.d(str2, localStringBuilder.toString());
    Object localObject = DeviceParser.parseCameraAttrsFile(this.mContext, paramString, (String)localObject, this.mSignature);
    str2 = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[update] source: ");
    localStringBuilder.append((String)localObject);
    LogUtils.d(str2, localStringBuilder.toString());
    if (localObject != null) {
      parseCurrentAttrsXML((String)localObject);
    }
    loadAttrsFromPref();
    logAttrsValues();
    if (paramUpdateListener != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", parse and reload success");
      paramUpdateListener.onSuccess(((StringBuilder)localObject).toString());
    }
    paramString = new Intent();
    paramString.setAction("action_check_online_update_finish");
    paramUpdateListener = this.mContext;
    if (paramUpdateListener != null) {
      paramUpdateListener.sendBroadcast(paramString);
    }
  }
  
  public boolean updateCameraParametersFastCapture(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    if (isInFastCaptureWhiteList(paramBoolean))
    {
      initFastCaptureKeyValue();
      boolean bool = openFastCaptureMode(paramParameters);
      paramParameters = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateCameraParametersFastCapture] this camera id in white list YES, OPEN fast mode, isFrontCamera = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", updated = ");
      localStringBuilder.append(bool);
      LogUtils.d(paramParameters, localStringBuilder.toString());
      return bool;
    }
    paramParameters = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateCameraParametersFastCapture] this camera id in white list NO, do NOTHING, isFrontCamera = ");
    localStringBuilder.append(paramBoolean);
    LogUtils.d(paramParameters, localStringBuilder.toString());
    return false;
  }
  
  public void updatePreviewCondition(int paramInt1, int paramInt2)
  {
    if (this.mCameraMatchPref == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("conditionPreviewSize");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("*");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    Set localSet = this.mCameraMatchPref.getStringSet((String)localObject, new HashSet());
    this.int_frontCamRotate0 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontCamRotate0", (String)localObject), -1);
    this.int_frontCamRotate90 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontCamRotate90", (String)localObject), -1);
    this.int_frontCamRotate180 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontCamRotate180", (String)localObject), -1);
    this.int_frontCamRotate270 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontCamRotate270", (String)localObject), -1);
    this.int_backCamRotate0 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backCamRotate0", (String)localObject), -1);
    this.int_backCamRotate90 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backCamRotate90", (String)localObject), -1);
    this.int_backCamRotate180 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backCamRotate180", (String)localObject), -1);
    this.int_backCamRotate270 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backCamRotate270", (String)localObject), -1);
    this.int_frontExifRotate0 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontExifRotate0", (String)localObject), -1);
    this.int_frontExifRotate90 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontExifRotate90", (String)localObject), -1);
    this.int_frontExifRotate180 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontExifRotate180", (String)localObject), -1);
    this.int_frontExifRotate270 = this.mCameraMatchPref.getInt(editKey(localSet, "int_frontExifRotate270", (String)localObject), -1);
    this.int_backExifRotate0 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backExifRotate0", (String)localObject), -1);
    this.int_backExifRotate90 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backExifRotate90", (String)localObject), -1);
    this.int_backExifRotate180 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backExifRotate180", (String)localObject), -1);
    this.int_backExifRotate270 = this.mCameraMatchPref.getInt(editKey(localSet, "int_backExifRotate270", (String)localObject), -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceAttrs
 * JD-Core Version:    0.7.0.1
 */