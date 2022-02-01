package com.tencent.ttpic.baseutils.api;

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
    boolean bool2 = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool1 = true;
      HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label845;
      }
      bool1 = true;
      label26:
      HAS_AUTO_FOCUS_MOVE_CALLBACK = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label850;
      }
      bool1 = true;
      label40:
      HAS_CAMERA_FOCUS_AREA = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label855;
      }
      bool1 = true;
      label54:
      HAS_CAMERA_METERING_AREA = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label860;
      }
      bool1 = true;
      label68:
      HAS_CAMERA_HDR = bool1;
      if (Build.VERSION.SDK_INT < 19) {
        break label865;
      }
      bool1 = true;
      label82:
      HAS_CAMERA_HDR_PLUS = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label870;
      }
      bool1 = true;
      label96:
      HAS_DISPLAY_LISTENER = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label875;
      }
      bool1 = true;
      label110:
      CAN_START_PREVIEW_IN_JPEG_CALLBACK = bool1;
      if (Build.VERSION.SDK_INT >= 9) {
        break label880;
      }
      bool1 = true;
      label124:
      USE_COOLPAD8013_PORTING = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label885;
      }
      bool1 = true;
      label138:
      USE_888_PIXEL_FORMAT = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label890;
      }
      bool1 = true;
      label152:
      ENABLE_PHOTO_EDITOR = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label895;
      }
      bool1 = true;
      label166:
      HAS_HARDWARE_ACCELERATION = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label900;
      }
      bool1 = hasField(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");
      label186:
      HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label905;
      }
      bool1 = hasField(MediaStore.MediaColumns.class, "WIDTH");
      label206:
      HAS_VIEW_SYSTEM_UI_FLAG_HIDE_NAVIGATION = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label910;
      }
      bool1 = true;
      label220:
      HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label915;
      }
      bool1 = true;
      label234:
      HAS_REUSING_BITMAP_IN_BITMAP_FACTORY = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label920;
      }
      bool1 = true;
      label248:
      HAS_SET_BEAM_PUSH_URIS = bool1;
      if (Build.VERSION.SDK_INT < 15) {
        break label925;
      }
      bool1 = hasMethod("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
      label284:
      HAS_SET_DEFALT_BUFFER_SIZE = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label930;
      }
      bool1 = hasMethod("android.graphics.SurfaceTexture", "release", new Class[0]);
      label308:
      HAS_RELEASE_SURFACE_TEXTURE = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label935;
      }
      bool1 = true;
      label322:
      HAS_SURFACE_TEXTURE = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label940;
      }
      bool1 = true;
      label336:
      HAS_MTP = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label945;
      }
      bool1 = true;
      label350:
      HAS_REMOTE_VIEWS_SERVICE = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label950;
      }
      bool1 = true;
      label364:
      HAS_INTENT_EXTRA_LOCAL_ONLY = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label955;
      }
      bool1 = hasMethod(View.class, "setSystemUiVisibility", new Class[] { Integer.TYPE });
      label394:
      HAS_SET_SYSTEM_UI_VISIBILITY = bool1;
      if (Build.VERSION.SDK_INT < 9) {
        break label960;
      }
      bool1 = hasMethod(SharedPreferences.Editor.class, "apply", (Class[])null);
      label418:
      HAS_EDITOR_APPLY = bool1;
    }
    for (;;)
    {
      try
      {
        if ((!hasMethod(Camera.class, "setFaceDetectionListener", new Class[] { Class.forName("android.hardware.Camera$FaceDetectionListener") })) || (!hasMethod(Camera.class, "startFaceDetection", new Class[0])) || (!hasMethod(Camera.class, "stopFaceDetection", new Class[0]))) {
          continue;
        }
        bool1 = hasMethod(Camera.Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
        if (!bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Throwable localThrowable)
      {
        label845:
        label850:
        label855:
        label860:
        label865:
        label870:
        label875:
        label880:
        label885:
        label890:
        label895:
        bool1 = false;
        label900:
        label905:
        label910:
        label915:
        label920:
        label925:
        label930:
        label935:
        label940:
        label945:
        label950:
        label955:
        label960:
        continue;
        bool1 = false;
        continue;
      }
      HAS_FACE_DETECTION = bool1;
      try
      {
        Class localClass = Class.forName("android.graphics.BitmapRegionDecoder");
        if (localClass == null) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
      HAS_BITMAP_REGION_DECODER = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label987;
      }
      if (!hasMethod(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class })) {
        break label987;
      }
      bool1 = true;
      HAS_GET_CAMERA_DISABLED = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label992;
      }
      bool1 = true;
      HAS_MEDIA_ACTION_SOUND = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label997;
      }
      bool1 = true;
      HAS_OLD_PANORAMA = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1002;
      }
      bool1 = true;
      HAS_TIME_LAPSE_RECORDING = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label1007;
      }
      bool1 = true;
      HAS_ZOOM_WHEN_RECORDING = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1012;
      }
      bool1 = true;
      HAS_FINE_RESOLUTION_QUALITY_LEVELS = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1017;
      }
      bool1 = true;
      HAS_MOTION_EVENT_TRANSFORM = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label1022;
      }
      bool1 = true;
      HAS_EFFECTS_RECORDING_CONTEXT_INPUT = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1027;
      }
      bool1 = true;
      HAS_GET_SUPPORTED_VIDEO_SIZE = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1032;
      }
      bool1 = true;
      HAS_SET_ICON_ATTRIBUTE = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1037;
      }
      bool1 = true;
      HAS_MEDIA_PROVIDER_FILES_TABLE = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label1042;
      }
      bool1 = true;
      HAS_SURFACE_TEXTURE_RECORDING = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1047;
      }
      bool1 = true;
      HAS_ACTION_BAR = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1052;
      }
      bool1 = true;
      HAS_VIEW_TRANSFORM_PROPERTIES = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1057;
      }
      bool1 = true;
      HAS_OPTIONS_IN_MUTABLE = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label1062;
      }
      bool1 = true;
      HAS_VIEW_PROPERTY_ANIMATOR = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label1067;
      }
      bool1 = true;
      HAS_POST_ON_ANIMATION = bool1;
      if (Build.VERSION.SDK_INT < 9) {
        break label1072;
      }
      bool1 = true;
      HAS_CAMERAINFO = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label1077;
      }
      bool1 = true;
      HAS_SD_CARD = bool1;
      if (Build.VERSION.SDK_INT < 9) {
        break label1082;
      }
      bool1 = true;
      HAS_CAMCORDERPROFILE_METHOD = bool1;
      if (Runtime.getRuntime().availableProcessors() <= 1) {
        break label1087;
      }
      bool1 = true;
      HAS_MULTICORE_CHIPS = bool1;
      if (Build.VERSION.SDK_INT < 10) {
        break label1092;
      }
      bool1 = bool2;
      CAN_TAKE_VIDEO = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label26;
      bool1 = false;
      break label40;
      bool1 = false;
      break label54;
      bool1 = false;
      break label68;
      bool1 = false;
      break label82;
      bool1 = false;
      break label96;
      bool1 = false;
      break label110;
      bool1 = false;
      break label124;
      bool1 = false;
      break label138;
      bool1 = false;
      break label152;
      bool1 = false;
      break label166;
      bool1 = false;
      break label186;
      bool1 = false;
      break label206;
      bool1 = false;
      break label220;
      bool1 = false;
      break label234;
      bool1 = false;
      break label248;
      bool1 = false;
      break label284;
      bool1 = false;
      break label308;
      bool1 = false;
      break label322;
      bool1 = false;
      break label336;
      bool1 = false;
      break label350;
      bool1 = false;
      break label364;
      bool1 = false;
      break label394;
      bool1 = false;
      break label418;
      bool1 = false;
    }
  }
  
  private static boolean hasField(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass.getDeclaredField(paramString);
      return true;
    }
    catch (NoSuchFieldException paramClass) {}
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
  
  private static boolean hasMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return true;
    }
    catch (NoSuchMethodException paramClass) {}
    return false;
  }
  
  private static boolean hasMethod(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.api.ApiHelper
 * JD-Core Version:    0.7.0.1
 */