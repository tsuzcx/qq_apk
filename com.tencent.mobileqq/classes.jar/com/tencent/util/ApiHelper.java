package com.tencent.util;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import android.provider.MediaStore.MediaColumns;
import android.view.View;
import java.lang.reflect.Field;

public class ApiHelper
{
  public static final boolean CAN_START_PREVIEW_IN_JPEG_CALLBACK;
  public static final boolean CAN_TAKE_VIDEO;
  public static final boolean ENABLE_FAST_LOAD_MODE = true;
  public static final boolean ENABLE_MYCUSTOM_BITMAP_RECYLED = true;
  public static final boolean ENABLE_PHOTO_EDITOR;
  public static final boolean ENABLE_RGB565_IN_THUMB_DECODE = false;
  public static final boolean ENABLE_VIDEO = true;
  public static final boolean HAS_ACTION_BAR;
  public static final boolean HAS_AUTO_FOCUS_MOVE_CALLBACK;
  public static final boolean HAS_BITMAP_REGION_DECODER;
  public static final boolean HAS_CAMCORDERPROFILE_METHOD;
  public static final boolean HAS_CAMERAINFO;
  public static final boolean HAS_CAMERA_FOCUS_AREA;
  public static final boolean HAS_CAMERA_HDR;
  public static final boolean HAS_CAMERA_METERING_AREA;
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
    if (Build.VERSION.SDK_INT < 9)
    {
      bool1 = true;
      USE_COOLPAD8013_PORTING = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label847;
      }
      bool1 = true;
      label26:
      USE_888_PIXEL_FORMAT = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label852;
      }
      bool1 = true;
      label40:
      ENABLE_PHOTO_EDITOR = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label857;
      }
      bool1 = true;
      label54:
      HAS_HARDWARE_ACCELERATION = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label862;
      }
      bool1 = hasField(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");
      label74:
      HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label867;
      }
      bool1 = hasField(MediaStore.MediaColumns.class, "WIDTH");
      label94:
      HAS_VIEW_SYSTEM_UI_FLAG_HIDE_NAVIGATION = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label872;
      }
      bool1 = true;
      label108:
      HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label877;
      }
      bool1 = true;
      label122:
      HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label882;
      }
      bool1 = true;
      label136:
      HAS_REUSING_BITMAP_IN_BITMAP_FACTORY = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label887;
      }
      bool1 = true;
      label150:
      HAS_SET_BEAM_PUSH_URIS = bool1;
      if (Build.VERSION.SDK_INT < 15) {
        break label892;
      }
      bool1 = hasMethod("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
      label186:
      HAS_SET_DEFALT_BUFFER_SIZE = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label897;
      }
      bool1 = hasMethod("android.graphics.SurfaceTexture", "release", new Class[0]);
      label210:
      HAS_RELEASE_SURFACE_TEXTURE = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label902;
      }
      bool1 = true;
      label224:
      HAS_SURFACE_TEXTURE = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label907;
      }
      bool1 = true;
      label238:
      HAS_MTP = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label912;
      }
      bool1 = true;
      label252:
      HAS_AUTO_FOCUS_MOVE_CALLBACK = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label917;
      }
      bool1 = true;
      label266:
      HAS_REMOTE_VIEWS_SERVICE = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label922;
      }
      bool1 = true;
      label280:
      HAS_INTENT_EXTRA_LOCAL_ONLY = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label927;
      }
      bool1 = hasMethod(View.class, "setSystemUiVisibility", new Class[] { Integer.TYPE });
      label310:
      HAS_SET_SYSTEM_UI_VISIBILITY = bool1;
      if (Build.VERSION.SDK_INT < 9) {
        break label932;
      }
      bool1 = hasMethod(SharedPreferences.Editor.class, "apply", (Class[])null);
      label334:
      HAS_EDITOR_APPLY = bool1;
      bool3 = false;
      if ((HAS_SURFACE_TEXTURE) && (PhoneProperty.instance().isNotUseSurfaceTexture())) {
        HAS_SURFACE_TEXTURE = false;
      }
      bool1 = bool3;
      if (!PhoneProperty.instance().hasFaceDetection()) {}
    }
    try
    {
      if ((!hasMethod(Camera.class, "setFaceDetectionListener", new Class[] { Class.forName("android.hardware.Camera$FaceDetectionListener") })) || (!hasMethod(Camera.class, "startFaceDetection", new Class[0])) || (!hasMethod(Camera.class, "stopFaceDetection", new Class[0]))) {
        break label937;
      }
      bool1 = hasMethod(Camera.Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
      if (!bool1) {
        break label937;
      }
      bool1 = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label438:
        bool1 = bool3;
      }
    }
    HAS_FACE_DETECTION = bool1;
    bool1 = false;
    try
    {
      Class localClass = Class.forName("android.graphics.BitmapRegionDecoder");
      if (localClass == null) {
        break label942;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      label456:
      break label456;
    }
    HAS_BITMAP_REGION_DECODER = bool1;
    if (Build.VERSION.SDK_INT >= 14)
    {
      bool1 = hasMethod(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class });
      label485:
      HAS_GET_CAMERA_DISABLED = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label952;
      }
      bool1 = true;
      label499:
      HAS_MEDIA_ACTION_SOUND = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label957;
      }
      bool1 = true;
      label513:
      HAS_OLD_PANORAMA = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label962;
      }
      bool1 = true;
      label527:
      HAS_TIME_LAPSE_RECORDING = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label967;
      }
      bool1 = true;
      label541:
      HAS_ZOOM_WHEN_RECORDING = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label972;
      }
      bool1 = true;
      label555:
      HAS_CAMERA_FOCUS_AREA = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label977;
      }
      bool1 = true;
      label569:
      HAS_CAMERA_METERING_AREA = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label982;
      }
      bool1 = true;
      label583:
      HAS_FINE_RESOLUTION_QUALITY_LEVELS = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label987;
      }
      bool1 = true;
      label597:
      HAS_MOTION_EVENT_TRANSFORM = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label992;
      }
      bool1 = true;
      label611:
      HAS_EFFECTS_RECORDING_CONTEXT_INPUT = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label997;
      }
      bool1 = true;
      label625:
      HAS_GET_SUPPORTED_VIDEO_SIZE = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1002;
      }
      bool1 = true;
      label639:
      HAS_SET_ICON_ATTRIBUTE = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1007;
      }
      bool1 = true;
      label653:
      HAS_MEDIA_PROVIDER_FILES_TABLE = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label1012;
      }
      bool1 = true;
      label667:
      HAS_SURFACE_TEXTURE_RECORDING = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1017;
      }
      bool1 = true;
      label681:
      HAS_ACTION_BAR = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1022;
      }
      bool1 = true;
      label695:
      HAS_VIEW_TRANSFORM_PROPERTIES = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label1027;
      }
      bool1 = true;
      label709:
      HAS_CAMERA_HDR = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label1032;
      }
      bool1 = true;
      label723:
      HAS_OPTIONS_IN_MUTABLE = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label1037;
      }
      bool1 = true;
      label737:
      CAN_START_PREVIEW_IN_JPEG_CALLBACK = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label1042;
      }
      bool1 = true;
      label751:
      HAS_VIEW_PROPERTY_ANIMATOR = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label1047;
      }
      bool1 = true;
      label765:
      HAS_POST_ON_ANIMATION = bool1;
      if (Build.VERSION.SDK_INT < 9) {
        break label1052;
      }
      bool1 = true;
      label779:
      HAS_CAMERAINFO = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label1057;
      }
      bool1 = true;
      label793:
      HAS_SD_CARD = bool1;
      if (Build.VERSION.SDK_INT < 9) {
        break label1062;
      }
      bool1 = true;
      label807:
      HAS_CAMCORDERPROFILE_METHOD = bool1;
      if (Runtime.getRuntime().availableProcessors() <= 1) {
        break label1067;
      }
      bool1 = true;
      label823:
      HAS_MULTICORE_CHIPS = bool1;
      if (Build.VERSION.SDK_INT < 10) {
        break label1072;
      }
    }
    label897:
    label902:
    label907:
    label912:
    label917:
    label922:
    label927:
    label932:
    label937:
    label942:
    label1072:
    for (bool1 = bool2;; bool1 = false)
    {
      CAN_TAKE_VIDEO = bool1;
      return;
      bool1 = false;
      break;
      label847:
      bool1 = false;
      break label26;
      label852:
      bool1 = false;
      break label40;
      label857:
      bool1 = false;
      break label54;
      label862:
      bool1 = false;
      break label74;
      label867:
      bool1 = false;
      break label94;
      label872:
      bool1 = false;
      break label108;
      label877:
      bool1 = false;
      break label122;
      label882:
      bool1 = false;
      break label136;
      label887:
      bool1 = false;
      break label150;
      label892:
      bool1 = false;
      break label186;
      bool1 = false;
      break label210;
      bool1 = false;
      break label224;
      bool1 = false;
      break label238;
      bool1 = false;
      break label252;
      bool1 = false;
      break label266;
      bool1 = false;
      break label280;
      bool1 = false;
      break label310;
      bool1 = false;
      break label334;
      bool1 = false;
      break label438;
      bool1 = false;
      break label456;
      bool1 = false;
      break label485;
      label952:
      bool1 = false;
      break label499;
      label957:
      bool1 = false;
      break label513;
      label962:
      bool1 = false;
      break label527;
      label967:
      bool1 = false;
      break label541;
      label972:
      bool1 = false;
      break label555;
      label977:
      bool1 = false;
      break label569;
      label982:
      bool1 = false;
      break label583;
      label987:
      bool1 = false;
      break label597;
      label992:
      bool1 = false;
      break label611;
      label997:
      bool1 = false;
      break label625;
      label1002:
      bool1 = false;
      break label639;
      label1007:
      bool1 = false;
      break label653;
      label1012:
      bool1 = false;
      break label667;
      label1017:
      bool1 = false;
      break label681;
      label1022:
      bool1 = false;
      break label695;
      bool1 = false;
      break label709;
      bool1 = false;
      break label723;
      bool1 = false;
      break label737;
      bool1 = false;
      break label751;
      bool1 = false;
      break label765;
      bool1 = false;
      break label779;
      bool1 = false;
      break label793;
      bool1 = false;
      break label807;
      bool1 = false;
      break label823;
    }
  }
  
  public static int getIntFieldIfExists(Class<?> paramClass1, String paramString, Class<?> paramClass2, int paramInt)
  {
    try
    {
      int i = paramClass1.getDeclaredField(paramString).getInt(paramClass2);
      return i;
    }
    catch (Exception paramClass1) {}
    return paramInt;
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
  
  public static abstract interface VERSION_CODES
  {
    public static final int FROYO = 8;
    public static final int GINGERBREAD = 9;
    public static final int GINGERBREAD_MR1 = 10;
    public static final int HONEYCOMB = 11;
    public static final int HONEYCOMB_MR1 = 12;
    public static final int HONEYCOMB_MR2 = 13;
    public static final int ICE_CREAM_SANDWICH = 14;
    public static final int ICE_CREAM_SANDWICH_MR1 = 15;
    public static final int JELLY_BEAN = 16;
    public static final int JELLY_BEAN_MR1 = 17;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.util.ApiHelper
 * JD-Core Version:    0.7.0.1
 */