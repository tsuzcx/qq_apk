package com.tencent.mobileqq.mini.widget.media.live;

import android.graphics.Bitmap;
import bjue;

public class WXLivePushConfigReflect
{
  public static final String FULL_QUALIFIED_CLASS_NAME = "com.tencent.rtmp.WXLivePushConfig";
  private static final String TAG = "WXLivePushConfigReflect";
  
  public static void enableAGC(boolean paramBoolean, Object paramObject)
  {
    bjue.a(paramObject, "enableAGC", false, bjue.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enableANS(boolean paramBoolean, Object paramObject)
  {
    bjue.a(paramObject, "enableANS", false, bjue.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enableAudioEarMonitoring(boolean paramBoolean, Object paramObject)
  {
    bjue.a(paramObject, "enableAudioEarMonitoring", false, bjue.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enablePureAudioPush(boolean paramBoolean, Object paramObject)
  {
    bjue.a(paramObject, "enablePureAudioPush", false, bjue.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static Object newInstance()
  {
    return bjue.a("com.tencent.rtmp.WXLivePushConfig", null, new Object[0]);
  }
  
  public static void setAudioSampleRate(int paramInt, Object paramObject)
  {
    bjue.a(paramObject, "setAudioSampleRate", false, bjue.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setEnableZoom(boolean paramBoolean, Object paramObject)
  {
    bjue.a(paramObject, "setEnableZoom", false, bjue.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setFrontCamera(boolean paramBoolean, Object paramObject)
  {
    bjue.a(paramObject, "setFrontCamera", false, bjue.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setHomeOrientation(int paramInt, Object paramObject)
  {
    bjue.a(paramObject, "setHomeOrientation", false, bjue.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMaxVideoBitrate(int paramInt, Object paramObject)
  {
    bjue.a(paramObject, "setMaxVideoBitrate", false, bjue.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMinVideoBitrate(int paramInt, Object paramObject)
  {
    bjue.a(paramObject, "setMinVideoBitrate", false, bjue.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setPauseFlag(int paramInt, Object paramObject)
  {
    bjue.a(paramObject, "setPauseFlag", false, bjue.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setPauseImg(Bitmap paramBitmap, Object paramObject)
  {
    if (paramBitmap != null) {
      bjue.a(paramObject, "setPauseImg", false, bjue.a(new Class[] { Bitmap.class }), new Object[] { paramBitmap });
    }
  }
  
  public static void setTouchFocus(boolean paramBoolean, Object paramObject)
  {
    bjue.a(paramObject, "setTouchFocus", false, bjue.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setVideoEncodeGop(int paramInt, Object paramObject)
  {
    bjue.a(paramObject, "setVideoEncodeGop", false, bjue.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setVideoResolution(int paramInt1, int paramInt2, Object paramObject)
  {
    bjue.a(paramObject, "setVideoResolution", false, bjue.a(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void setVideoResolution(int paramInt, Object paramObject)
  {
    bjue.a(paramObject, "setVideoResolution", false, bjue.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setVolumeType(int paramInt, Object paramObject)
  {
    bjue.a(paramObject, "setVolumeType", false, bjue.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, Object paramObject)
  {
    bjue.a(paramObject, "setWatermark", false, bjue.a(new Class[] { Bitmap.class, Float.TYPE, Float.TYPE, Float.TYPE }), new Object[] { paramBitmap, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.WXLivePushConfigReflect
 * JD-Core Version:    0.7.0.1
 */