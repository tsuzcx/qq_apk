package com.tencent.mobileqq.mini.widget.media.live;

import android.content.Context;
import bgfg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class WXLivePusherReflect
{
  public static final String FULL_QUALIFIED_CLASS_NAME = "com.tencent.rtmp.WXLivePusher";
  public static final String ON_BGM_NOTIFY_CLASS_NAME = "com.tencent.rtmp.TXLivePusher$OnBGMNotify";
  private static final String TAG = "WXLivePusherReflect";
  public static boolean backgroundMute;
  
  public static boolean isPushing(Object paramObject)
  {
    paramObject = (Boolean)bgfg.a(paramObject, "isPushing", false, null, new Object[0]);
    if (paramObject != null) {
      return paramObject.booleanValue();
    }
    return false;
  }
  
  public static Object newInstance(Context paramContext)
  {
    return bgfg.a("com.tencent.rtmp.WXLivePusher", bgfg.a(new Class[] { Context.class }), new Object[] { paramContext });
  }
  
  public static boolean pauseBGM(Object paramObject)
  {
    paramObject = bgfg.a(paramObject, "pauseBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void pausePusher(Object paramObject)
  {
    bgfg.a(paramObject, "pausePusher", false, null, new Object[0]);
  }
  
  public static boolean playBGM(String paramString, Object paramObject)
  {
    paramString = bgfg.a(paramObject, "playBGM", false, bgfg.a(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue());
  }
  
  public static boolean resumeBGM(Object paramObject)
  {
    paramObject = bgfg.a(paramObject, "resumeBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void resumePusher(Object paramObject)
  {
    bgfg.a(paramObject, "resumePusher", false, null, new Object[0]);
  }
  
  public static boolean sendMessageEx(byte[] paramArrayOfByte, Object paramObject)
  {
    paramArrayOfByte = (Boolean)bgfg.a(paramObject, "sendMessageEx", false, bgfg.a(new Class[] { [B.class }), new Object[] { paramArrayOfByte });
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.booleanValue();
    }
    return false;
  }
  
  public static void setBGMNofify(Object paramObject1, Object paramObject2)
  {
    try
    {
      bgfg.a(paramObject2, "setBGMNofify", false, bgfg.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void setBGMPosition(int paramInt, Object paramObject)
  {
    bgfg.a(paramObject, "setBGMPosition", false, bgfg.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static boolean setBGMVolume(float paramFloat, Object paramObject)
  {
    paramObject = bgfg.a(paramObject, "setBGMVolume", false, bgfg.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    bgfg.a(paramObject, "setBeautyFilter", false, bgfg.a(new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public static void setConfig(Object paramObject1, Object paramObject2)
  {
    try
    {
      bgfg.a(paramObject2, "setConfig", false, bgfg.a(new Class[] { Class.forName("com.tencent.rtmp.WXLivePushConfig") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void setEnableCamera(JSONObject paramJSONObject, Object paramObject1, Object paramObject2)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("enable-camera", true))) {
      bgfg.a(paramObject1, "startCameraPreview", false, bgfg.a(new Class[] { paramObject2.getClass() }), new Object[] { paramObject2 });
    }
  }
  
  public static void setLocalVideoMirrorType(int paramInt, Object paramObject)
  {
    bgfg.a(paramObject, "setLocalVideoMirrorType", false, bgfg.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setMicVolume(float paramFloat, Object paramObject)
  {
    bgfg.a(paramObject, "setMicVolume", false, bgfg.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public static void setMirror(boolean paramBoolean, Object paramObject)
  {
    bgfg.a(paramObject, "setMirror", false, bgfg.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setMode(JSONObject paramJSONObject, Object paramObject)
  {
    String str;
    if (paramJSONObject != null)
    {
      str = paramJSONObject.optString("mode", "RTC");
      paramJSONObject = "VIDEO_QUALITY_REALTIEM_VIDEOCHAT";
      if (!"SD".equals(str)) {
        break label98;
      }
      paramJSONObject = "VIDEO_QUALITY_STANDARD_DEFINITION";
    }
    for (;;)
    {
      paramJSONObject = bgfg.a("com.tencent.rtmp.TXLiveConstants", paramJSONObject);
      if ((paramJSONObject instanceof Integer)) {
        bgfg.a(paramObject, "setVideoQuality", false, bgfg.a(new Class[] { Integer.TYPE, Boolean.TYPE, Boolean.TYPE }), new Object[] { paramJSONObject, Boolean.valueOf(true), Boolean.valueOf(true) });
      }
      return;
      label98:
      if ("HD".equals(str)) {
        paramJSONObject = "VIDEO_QUALITY_HIGH_DEFINITION";
      } else if ("FHD".equals(str)) {
        paramJSONObject = "VIDEO_QUALITY_SUPER_DEFINITION";
      } else {
        QLog.w("WXLivePusherReflect", 1, "setMode unknown mode " + str);
      }
    }
  }
  
  public static void setMuted(boolean paramBoolean, Object paramObject)
  {
    bgfg.a(paramObject, "setMute", false, bgfg.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void setPushListener(Object paramObject1, Object paramObject2)
  {
    try
    {
      bgfg.a(paramObject2, "setPushListener", false, bgfg.a(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePushListener") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void setPusherUrl(String paramString, Object paramObject)
  {
    bgfg.a(paramObject, "setPusherUrl", false, bgfg.a(new Class[] { String.class }), new Object[] { paramString });
  }
  
  public static void setRenderRotation(int paramInt, Object paramObject)
  {
    bgfg.a(paramObject, "setRenderRotation", false, bgfg.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setReverb(int paramInt, Object paramObject)
  {
    bgfg.a(paramObject, "setReverb", false, bgfg.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    bgfg.a(paramObject, "setVideoQuality", false, bgfg.a(new Class[] { Integer.TYPE, Boolean.TYPE, Boolean.TYPE }), new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public static void showDebugLog(boolean paramBoolean, Object paramObject)
  {
    bgfg.a(paramObject, "showDebugLog", false, bgfg.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void snapshot(Object paramObject1, Object paramObject2)
  {
    try
    {
      bgfg.a(paramObject2, "snapshot", false, bgfg.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void startAudioRecord(Object paramObject)
  {
    bgfg.a(paramObject, "startAudioRecord", false, null, new Object[0]);
  }
  
  public static void startCameraPreview(Object paramObject1, Object paramObject2)
  {
    bgfg.a(paramObject2, "startCameraPreview", false, bgfg.a(new Class[] { paramObject1.getClass() }), new Object[] { paramObject1 });
  }
  
  public static boolean startPusher(String paramString, Object paramObject)
  {
    paramString = bgfg.a(paramObject, "startPusher", false, bgfg.a(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Integer)) && (((Integer)paramString).intValue() == 0);
  }
  
  public static void stopAudioRecord(Object paramObject)
  {
    bgfg.a(paramObject, "stopAudioRecord", false, null, new Object[0]);
  }
  
  public static boolean stopBGM(Object paramObject)
  {
    paramObject = bgfg.a(paramObject, "stopBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void stopCameraPreview(boolean paramBoolean, Object paramObject)
  {
    bgfg.a(paramObject, "stopCameraPreview", false, bgfg.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void stopPusher(Object paramObject)
  {
    bgfg.a(paramObject, "stopPusher", false, null, new Object[0]);
  }
  
  public static void switchCamera(Object paramObject)
  {
    bgfg.a(paramObject, "switchCamera", false, null, new Object[0]);
  }
  
  public static void toggleTorch(Object paramObject)
  {
    QLog.w("WXLivePusherReflect", 1, "toggleTorch: not implement");
  }
  
  public static boolean turnOnFlashLight(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Boolean)bgfg.a(paramObject, "turnOnFlashLight", false, bgfg.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramObject != null) {
      return paramObject.booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.WXLivePusherReflect
 * JD-Core Version:    0.7.0.1
 */