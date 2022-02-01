package org.light.device;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import android.provider.MediaStore.MediaColumns;
import android.view.View;

public class ApiHelper
{
  public static final boolean CAN_START_PREVIEW_IN_JPEG_CALLBACK;
  public static final boolean CAN_TAKE_VIDEO;
  public static final boolean ENABLE_PHOTO_EDITOR;
  public static final boolean HAS_ACTION_BAR;
  public static final boolean HAS_AUTO_FOCUS_MOVE_CALLBACK;
  public static final boolean HAS_BITMAP_REGION_DECODER;
  public static final boolean HAS_CAMCORDERPROFILE_METHOD;
  public static final boolean HAS_CAMERAINFO;
  public static final boolean HAS_CAMERA_FOCUS_AREA;
  public static final boolean HAS_CAMERA_HDR;
  public static final boolean HAS_CAMERA_HDR_PLUS;
  public static final boolean HAS_CAMERA_METERING_AREA;
  public static final boolean HAS_DISPLAY_LISTENER;
  public static final boolean HAS_EDITOR_APPLY;
  public static final boolean HAS_EFFECTS_RECORDING = false;
  public static final boolean HAS_EFFECTS_RECORDING_CONTEXT_INPUT;
  public static final boolean HAS_FACE_DETECTION;
  public static final boolean HAS_FINE_RESOLUTION_QUALITY_LEVELS;
  public static final boolean HAS_GET_CAMERA_DISABLED;
  public static final boolean HAS_GET_SUPPORTED_VIDEO_SIZE;
  public static final boolean HAS_HARDWARE_ACCELERATION;
  public static final boolean HAS_INTENT_EXTRA_LOCAL_ONLY;
  public static final boolean HAS_MEDIA_ACTION_SOUND;
  public static final boolean HAS_MEDIA_COLUMNS_RESOLUTION = true;
  public static final boolean HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT;
  public static final boolean HAS_MEDIA_PROVIDER_FILES_TABLE;
  public static final boolean HAS_MOTION_EVENT_TRANSFORM;
  public static final boolean HAS_MTP;
  public static final boolean HAS_MULTICORE_CHIPS;
  public static final boolean HAS_OLD_PANORAMA;
  public static final boolean HAS_OPTIONS_IN_MUTABLE;
  public static final boolean HAS_POST_ON_ANIMATION;
  public static final boolean HAS_RELEASE_SURFACE_TEXTURE;
  public static final boolean HAS_REMOTE_VIEWS_SERVICE;
  public static final boolean HAS_REUSING_BITMAP_IN_BITMAP_FACTORY;
  public static final boolean HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER;
  public static final boolean HAS_SD_CARD;
  public static final boolean HAS_SET_BEAM_PUSH_URIS;
  public static final boolean HAS_SET_DEFALT_BUFFER_SIZE;
  public static final boolean HAS_SET_ICON_ATTRIBUTE;
  public static final boolean HAS_SET_SYSTEM_UI_VISIBILITY;
  public static boolean HAS_SURFACE_TEXTURE;
  public static final boolean HAS_SURFACE_TEXTURE_RECORDING;
  public static final boolean HAS_TIME_LAPSE_RECORDING;
  public static final boolean HAS_VIEW_PROPERTY_ANIMATOR;
  public static final boolean HAS_VIEW_SYSTEM_UI_FLAG_HIDE_NAVIGATION;
  public static final boolean HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE;
  public static final boolean HAS_VIEW_TRANSFORM_PROPERTIES;
  public static final boolean HAS_ZOOM_WHEN_RECORDING;
  public static final boolean USE_888_PIXEL_FORMAT;
  public static final boolean USE_COOLPAD8013_PORTING;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    if (i >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_AUTO_FOCUS_MOVE_CALLBACK = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_CAMERA_FOCUS_AREA = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_CAMERA_METERING_AREA = bool1;
    if (Build.VERSION.SDK_INT >= 17) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_CAMERA_HDR = bool1;
    if (Build.VERSION.SDK_INT >= 19) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_CAMERA_HDR_PLUS = bool1;
    if (Build.VERSION.SDK_INT >= 17) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_DISPLAY_LISTENER = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    CAN_START_PREVIEW_IN_JPEG_CALLBACK = bool1;
    if (Build.VERSION.SDK_INT < 9) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    USE_COOLPAD8013_PORTING = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    USE_888_PIXEL_FORMAT = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ENABLE_PHOTO_EDITOR = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_HARDWARE_ACCELERATION = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = hasField(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");
    } else {
      bool1 = false;
    }
    HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = hasField(MediaStore.MediaColumns.class, "WIDTH");
    } else {
      bool1 = false;
    }
    HAS_VIEW_SYSTEM_UI_FLAG_HIDE_NAVIGATION = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_REUSING_BITMAP_IN_BITMAP_FACTORY = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_SET_BEAM_PUSH_URIS = bool1;
    if (Build.VERSION.SDK_INT >= 15) {
      bool1 = hasMethod("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
    } else {
      bool1 = false;
    }
    HAS_SET_DEFALT_BUFFER_SIZE = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = hasMethod("android.graphics.SurfaceTexture", "release", new Class[0]);
    } else {
      bool1 = false;
    }
    HAS_RELEASE_SURFACE_TEXTURE = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_SURFACE_TEXTURE = bool1;
    if (Build.VERSION.SDK_INT >= 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_MTP = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_REMOTE_VIEWS_SERVICE = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_INTENT_EXTRA_LOCAL_ONLY = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = hasMethod(View.class, "setSystemUiVisibility", new Class[] { Integer.TYPE });
    } else {
      bool1 = false;
    }
    HAS_SET_SYSTEM_UI_VISIBILITY = bool1;
    if (Build.VERSION.SDK_INT >= 9) {
      bool1 = hasMethod(SharedPreferences.Editor.class, "apply", (Class[])null);
    } else {
      bool1 = false;
    }
    HAS_EDITOR_APPLY = bool1;
    try
    {
      if ((hasMethod(Camera.class, "setFaceDetectionListener", new Class[] { Class.forName("android.hardware.Camera$FaceDetectionListener") })) && (hasMethod(Camera.class, "startFaceDetection", new Class[0])) && (hasMethod(Camera.class, "stopFaceDetection", new Class[0])))
      {
        bool1 = hasMethod(Camera.Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
        if (bool1) {
          bool1 = true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label620:
      break label620;
    }
    boolean bool1 = false;
    HAS_FACE_DETECTION = bool1;
    try
    {
      Class localClass = Class.forName("android.graphics.BitmapRegionDecoder");
      if (localClass != null) {
        bool1 = true;
      }
    }
    catch (Exception localException)
    {
      label641:
      break label641;
    }
    bool1 = false;
    HAS_BITMAP_REGION_DECODER = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      if (hasMethod(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class }))
      {
        bool1 = true;
        break label681;
      }
    }
    bool1 = false;
    label681:
    HAS_GET_CAMERA_DISABLED = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_MEDIA_ACTION_SOUND = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_OLD_PANORAMA = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_TIME_LAPSE_RECORDING = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_ZOOM_WHEN_RECORDING = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_FINE_RESOLUTION_QUALITY_LEVELS = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_MOTION_EVENT_TRANSFORM = bool1;
    if (Build.VERSION.SDK_INT >= 17) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_EFFECTS_RECORDING_CONTEXT_INPUT = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_GET_SUPPORTED_VIDEO_SIZE = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_SET_ICON_ATTRIBUTE = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_MEDIA_PROVIDER_FILES_TABLE = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_SURFACE_TEXTURE_RECORDING = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_ACTION_BAR = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_VIEW_TRANSFORM_PROPERTIES = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_OPTIONS_IN_MUTABLE = bool1;
    if (Build.VERSION.SDK_INT >= 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_VIEW_PROPERTY_ANIMATOR = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_POST_ON_ANIMATION = bool1;
    if (Build.VERSION.SDK_INT >= 9) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_CAMERAINFO = bool1;
    if (Build.VERSION.SDK_INT >= 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_SD_CARD = bool1;
    if (Build.VERSION.SDK_INT >= 9) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_CAMCORDERPROFILE_METHOD = bool1;
    if (Runtime.getRuntime().availableProcessors() > 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HAS_MULTICORE_CHIPS = bool1;
    if (Build.VERSION.SDK_INT >= 10) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    CAN_TAKE_VIDEO = bool1;
  }
  
  private static boolean hasField(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass.getDeclaredField(paramString);
      return true;
    }
    catch (NoSuchFieldException paramClass)
    {
      label8:
      break label8;
    }
    return false;
  }
  
  public static boolean hasGingerbread()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  public static boolean hasHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean hasHoneycombMR1()
  {
    return Build.VERSION.SDK_INT >= 12;
  }
  
  public static boolean hasIceCreamSandwich()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean hasJellyBean()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean hasJellyBeanMR1()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean hasJellyBeanMR2()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean hasKitkat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean hasLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public static boolean hasLollipopMR1()
  {
    return Build.VERSION.SDK_INT >= 22;
  }
  
  public static boolean hasMarshmallow()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private static boolean hasMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return true;
    }
    catch (NoSuchMethodException paramClass)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  private static boolean hasMethod(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1)
    {
      label12:
      break label12;
    }
    return false;
  }
  
  public static boolean hasNougat()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean isAndroid_8_1()
  {
    return Build.VERSION.SDK_INT == 27;
  }
  
  public static boolean isExactlyKitkat()
  {
    return Build.VERSION.SDK_INT == 19;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.device.ApiHelper
 * JD-Core Version:    0.7.0.1
 */