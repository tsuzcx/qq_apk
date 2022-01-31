package com.tencent.mobileqq.mini.widget.media.live;

import android.graphics.Bitmap;
import bhom;

public class WXLivePushConfigReflect
{
  public static final String FULL_QUALIFIED_CLASS_NAME = "com.tencent.rtmp.WXLivePushConfig";
  private static final String TAG = "WXLivePushConfigReflect";
  
  public static void enableAGC(boolean paramBoolean, Object paramObject)
  {
    bhom.a(paramObject, "enableAGC", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enableANS(boolean paramBoolean, Object paramObject)
  {
    bhom.a(paramObject, "enableANS", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enableAudioEarMonitoring(boolean paramBoolean, Object paramObject)
  {
    bhom.a(paramObject, "enableAudioEarMonitoring", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void enablePureAudioPush(boolean paramBoolean, Object paramObject)
  {
    bhom.a(paramObject, "enablePureAudioPush", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static Object newInstance()
  {
    return bhom.a("com.tencent.rtmp.WXLivePushConfig", null, new Object[0]);
  }
  
  public static void setAudioSampleRate(int paramInt, Object paramObject)
  {
    bhom.a(paramObject, "setAudioSampleRate", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setEnableZoom(boolean paramBoolean, Object paramObject)
  {
    bhom.a(paramObject, "setEnableZoom", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setFrontCamera(boolean paramBoolean, Object paramObject)
  {
    bhom.a(paramObject, "setFrontCamera", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setHomeOrientation(int paramInt, Object paramObject)
  {
    bhom.a(paramObject, "setHomeOrientation", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMaxVideoBitrate(int paramInt, Object paramObject)
  {
    bhom.a(paramObject, "setMaxVideoBitrate", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMinVideoBitrate(int paramInt, Object paramObject)
  {
    bhom.a(paramObject, "setMinVideoBitrate", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setPauseFlag(int paramInt, Object paramObject)
  {
    bhom.a(paramObject, "setPauseFlag", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setPauseImg(Bitmap paramBitmap, Object paramObject)
  {
    if (paramBitmap != null) {
      bhom.a(paramObject, "setPauseImg", false, bhom.a(new Class[] { Bitmap.class }), new Object[] { paramBitmap });
    }
  }
  
  public static void setTouchFocus(boolean paramBoolean, Object paramObject)
  {
    bhom.a(paramObject, "setTouchFocus", false, bhom.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setVideoEncodeGop(int paramInt, Object paramObject)
  {
    bhom.a(paramObject, "setVideoEncodeGop", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setVideoResolution(int paramInt1, int paramInt2, Object paramObject)
  {
    bhom.a(paramObject, "setVideoResolution", false, bhom.a(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void setVideoResolution(int paramInt, Object paramObject)
  {
    bhom.a(paramObject, "setVideoResolution", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setVolumeType(int paramInt, Object paramObject)
  {
    bhom.a(paramObject, "setVolumeType", false, bhom.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, Object paramObject)
  {
    bhom.a(paramObject, "setWatermark", false, bhom.a(new Class[] { Bitmap.class, Float.TYPE, Float.TYPE, Float.TYPE }), new Object[] { paramBitmap, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.WXLivePushConfigReflect
 * JD-Core Version:    0.7.0.1
 */