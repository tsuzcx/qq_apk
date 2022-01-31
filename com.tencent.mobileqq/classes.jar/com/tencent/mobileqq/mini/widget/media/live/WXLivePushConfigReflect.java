package com.tencent.mobileqq.mini.widget.media.live;

import android.graphics.Bitmap;
import bhnv;

public class WXLivePushConfigReflect
{
  public static final String FULL_QUALIFIED_CLASS_NAME = "com.tencent.rtmp.WXLivePushConfig";
  private static final String TAG = "WXLivePushConfigReflect";
  
  public static void enableAGC(boolean paramBoolean, Object paramObject)
  {
    bhnv.a(paramObject, "enableAGC", false, bhnv.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enableANS(boolean paramBoolean, Object paramObject)
  {
    bhnv.a(paramObject, "enableANS", false, bhnv.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enableAudioEarMonitoring(boolean paramBoolean, Object paramObject)
  {
    bhnv.a(paramObject, "enableAudioEarMonitoring", false, bhnv.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enablePureAudioPush(boolean paramBoolean, Object paramObject)
  {
    bhnv.a(paramObject, "enablePureAudioPush", false, bhnv.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static Object newInstance()
  {
    return bhnv.a("com.tencent.rtmp.WXLivePushConfig", null, new Object[0]);
  }
  
  public static void setAudioSampleRate(int paramInt, Object paramObject)
  {
    bhnv.a(paramObject, "setAudioSampleRate", false, bhnv.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setEnableZoom(boolean paramBoolean, Object paramObject)
  {
    bhnv.a(paramObject, "setEnableZoom", false, bhnv.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setFrontCamera(boolean paramBoolean, Object paramObject)
  {
    bhnv.a(paramObject, "setFrontCamera", false, bhnv.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setHomeOrientation(int paramInt, Object paramObject)
  {
    bhnv.a(paramObject, "setHomeOrientation", false, bhnv.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMaxVideoBitrate(int paramInt, Object paramObject)
  {
    bhnv.a(paramObject, "setMaxVideoBitrate", false, bhnv.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMinVideoBitrate(int paramInt, Object paramObject)
  {
    bhnv.a(paramObject, "setMinVideoBitrate", false, bhnv.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setPauseFlag(int paramInt, Object paramObject)
  {
    bhnv.a(paramObject, "setPauseFlag", false, bhnv.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setPauseImg(Bitmap paramBitmap, Object paramObject)
  {
    if (paramBitmap != null) {
      bhnv.a(paramObject, "setPauseImg", false, bhnv.a(new Class[] { Bitmap.class }), new Object[] { paramBitmap });
    }
  }
  
  public static void setTouchFocus(boolean paramBoolean, Object paramObject)
  {
    bhnv.a(paramObject, "setTouchFocus", false, bhnv.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setVideoEncodeGop(int paramInt, Object paramObject)
  {
    bhnv.a(paramObject, "setVideoEncodeGop", false, bhnv.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setVideoResolution(int paramInt1, int paramInt2, Object paramObject)
  {
    bhnv.a(paramObject, "setVideoResolution", false, bhnv.a(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void setVideoResolution(int paramInt, Object paramObject)
  {
    bhnv.a(paramObject, "setVideoResolution", false, bhnv.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setVolumeType(int paramInt, Object paramObject)
  {
    bhnv.a(paramObject, "setVolumeType", false, bhnv.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, Object paramObject)
  {
    bhnv.a(paramObject, "setWatermark", false, bhnv.a(new Class[] { Bitmap.class, Float.TYPE, Float.TYPE, Float.TYPE }), new Object[] { paramBitmap, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.WXLivePushConfigReflect
 * JD-Core Version:    0.7.0.1
 */