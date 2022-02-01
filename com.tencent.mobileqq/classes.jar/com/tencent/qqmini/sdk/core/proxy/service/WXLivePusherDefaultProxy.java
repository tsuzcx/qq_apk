package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListenerInvocationHandler;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotifyInvocationHandler;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.TXLivePushListenerInvocationHandler;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

@ProxyService(proxy=IWXLivePusherProxy.class)
public class WXLivePusherDefaultProxy
  implements IWXLivePusherProxy
{
  private Object a;
  private final Object b = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePushConfig", null, new Object[0]);
  
  public void enableAGC(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "enableAGC", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void enableANS(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "enableANS", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void enableAudioEarMonitoring(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "enableAudioEarMonitoring", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void enablePureAudioPush(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "enablePureAudioPush", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void initInstance(Context paramContext)
  {
    this.a = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePusher", JarReflectUtil.getParamsClass(new Class[] { Context.class }), new Object[] { paramContext });
    setConfig();
  }
  
  public boolean isPushing()
  {
    boolean bool = false;
    Boolean localBoolean = (Boolean)JarReflectUtil.callSpecifiedMethod(this.a, "isPushing", false, null, new Object[0]);
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    }
    return bool;
  }
  
  public Object newITXLivePushListener(TXLivePushListenerReflect.ITXLivePushListener paramITXLivePushListener)
  {
    try
    {
      ClassLoader localClassLoader = getClass().getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.ITXLivePushListener");
      paramITXLivePushListener = new TXLivePushListenerReflect.TXLivePushListenerInvocationHandler(paramITXLivePushListener);
      paramITXLivePushListener = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, paramITXLivePushListener);
      return paramITXLivePushListener;
    }
    catch (ClassNotFoundException paramITXLivePushListener)
    {
      QMLog.e("WXLivePusherReflect", "newInstance", paramITXLivePushListener);
    }
    return null;
  }
  
  public Object newITXSnapshotListener(TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener)
  {
    try
    {
      ClassLoader localClassLoader = getClass().getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener");
      paramITXSnapshotListener = new TXLivePushListenerReflect.ITXSnapshotListenerInvocationHandler(paramITXSnapshotListener);
      paramITXSnapshotListener = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, paramITXSnapshotListener);
      return paramITXSnapshotListener;
    }
    catch (ClassNotFoundException paramITXSnapshotListener)
    {
      QMLog.e("WXLivePusherReflect", "newInstance", paramITXSnapshotListener);
    }
    return null;
  }
  
  public Object newOnBGMNotify(TXLivePushListenerReflect.OnBGMNotify paramOnBGMNotify)
  {
    try
    {
      ClassLoader localClassLoader = getClass().getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify");
      paramOnBGMNotify = new TXLivePushListenerReflect.OnBGMNotifyInvocationHandler(paramOnBGMNotify);
      paramOnBGMNotify = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, paramOnBGMNotify);
      return paramOnBGMNotify;
    }
    catch (ClassNotFoundException paramOnBGMNotify)
    {
      QMLog.e("WXLivePusherReflect", "newInstance", paramOnBGMNotify);
    }
    return null;
  }
  
  public boolean pauseBGM()
  {
    Object localObject = this.a;
    boolean bool2 = false;
    localObject = JarReflectUtil.callSpecifiedMethod(localObject, "pauseBGM", false, null, new Object[0]);
    boolean bool1 = bool2;
    if ((localObject instanceof Boolean))
    {
      bool1 = bool2;
      if (((Boolean)localObject).booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void pausePusher()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "pausePusher", false, null, new Object[0]);
  }
  
  public boolean playBGM(String paramString)
  {
    paramString = JarReflectUtil.callSpecifiedMethod(this.a, "playBGM", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue());
  }
  
  public boolean resumeBGM()
  {
    Object localObject = this.a;
    boolean bool2 = false;
    localObject = JarReflectUtil.callSpecifiedMethod(localObject, "resumeBGM", false, null, new Object[0]);
    boolean bool1 = bool2;
    if ((localObject instanceof Boolean))
    {
      bool1 = bool2;
      if (((Boolean)localObject).booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void resumePusher()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "resumePusher", false, null, new Object[0]);
  }
  
  public boolean sendMessageEx(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (Boolean)JarReflectUtil.callSpecifiedMethod(this.a, "sendMessageEx", false, JarReflectUtil.getParamsClass(new Class[] { [B.class }), new Object[] { paramArrayOfByte });
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.booleanValue();
    }
    return false;
  }
  
  public void setAudioSampleRate(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setAudioSampleRate", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setBGMNofify(Object paramObject)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.a, "setBGMNofify", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void setBGMPosition(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setBGMPosition", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public boolean setBGMVolume(float paramFloat)
  {
    Object localObject = JarReflectUtil.callSpecifiedMethod(this.a, "setBGMVolume", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
    return ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue());
  }
  
  public void setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setBeautyFilter", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public void setConfig()
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.a, "setConfig", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.WXLivePushConfig") }), new Object[] { this.b });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
  
  public void setEnableCamera(JSONObject paramJSONObject, Object paramObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("enable-camera", true))) {
      JarReflectUtil.callSpecifiedMethod(this.a, "startCameraPreview", false, JarReflectUtil.getParamsClass(new Class[] { paramObject.getClass() }), new Object[] { paramObject });
    }
  }
  
  public void setEnableZoom(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setEnableZoom", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setFrontCamera(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setFrontCamera", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setHomeOrientation(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setHomeOrientation", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setLocalVideoMirrorType(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setLocalVideoMirrorType", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setMaxVideoBitrate(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setMaxVideoBitrate", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setMicVolume(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setMicVolume", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public void setMinVideoBitrate(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setMinVideoBitrate", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setMirror(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setMirror", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setMode(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("mode", "RTC");
      if ("SD".equals(paramJSONObject))
      {
        paramJSONObject = "VIDEO_QUALITY_STANDARD_DEFINITION";
      }
      else if ("HD".equals(paramJSONObject))
      {
        paramJSONObject = "VIDEO_QUALITY_HIGH_DEFINITION";
      }
      else if ("FHD".equals(paramJSONObject))
      {
        paramJSONObject = "VIDEO_QUALITY_SUPER_DEFINITION";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMode unknown mode ");
        localStringBuilder.append(paramJSONObject);
        QMLog.w("WXLivePusherReflect", localStringBuilder.toString());
        paramJSONObject = "VIDEO_QUALITY_REALTIEM_VIDEOCHAT";
      }
      paramJSONObject = JarReflectUtil.getStaticField("com.tencent.rtmp.TXLiveConstants", paramJSONObject);
      if ((paramJSONObject instanceof Integer)) {
        JarReflectUtil.callSpecifiedMethod(this.a, "setVideoQuality", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Boolean.TYPE, Boolean.TYPE }), new Object[] { paramJSONObject, Boolean.valueOf(true), Boolean.valueOf(true) });
      }
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setMute", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setPauseFlag(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setPauseFlag", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setPauseImg(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      JarReflectUtil.callSpecifiedMethod(this.b, "setPauseImg", false, JarReflectUtil.getParamsClass(new Class[] { Bitmap.class }), new Object[] { paramBitmap });
    }
  }
  
  public void setPushListener(Object paramObject)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.a, "setPushListener", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePushListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void setPusherUrl(String paramString)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setPusherUrl", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { paramString });
  }
  
  public void setRenderRotation(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setRenderRotation", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setReverb(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setReverb", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setSurface(Surface paramSurface)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setSurface", false, JarReflectUtil.getParamsClass(new Class[] { Surface.class }), new Object[] { paramSurface });
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setSurfaceSize", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void setTouchFocus(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setTouchFocus", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setVideoEncodeGop(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setVideoEncodeGop", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setVideoQuality", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Boolean.TYPE, Boolean.TYPE }), new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public void setVideoResolution(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setVideoResolution", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setVideoResolution(int paramInt1, int paramInt2)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setVideoResolution", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void setVolumeType(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setVolumeType", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setWatermark", false, JarReflectUtil.getParamsClass(new Class[] { Bitmap.class, Float.TYPE, Float.TYPE, Float.TYPE }), new Object[] { paramBitmap, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
  }
  
  public void showDebugLog(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "showDebugLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void snapshot(Object paramObject)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.a, "snapshot", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void startAudioRecord()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "startAudioRecord", false, null, new Object[0]);
  }
  
  public void startCameraPreview(Object paramObject)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.a, "startCameraPreview", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ui.TXCloudVideoView") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public int startDumpAudioData(String paramString)
  {
    paramString = (Integer)JarReflectUtil.callSpecifiedMethod(this.a, "startDumpAudioData", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { paramString });
    if (paramString != null) {
      return paramString.intValue();
    }
    return -10;
  }
  
  public boolean startPusher(String paramString)
  {
    paramString = JarReflectUtil.callSpecifiedMethod(this.a, "startPusher", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Integer)) && (((Integer)paramString).intValue() == 0);
  }
  
  public void stopAudioRecord()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "stopAudioRecord", false, null, new Object[0]);
  }
  
  public boolean stopBGM()
  {
    Object localObject = this.a;
    boolean bool2 = false;
    localObject = JarReflectUtil.callSpecifiedMethod(localObject, "stopBGM", false, null, new Object[0]);
    boolean bool1 = bool2;
    if ((localObject instanceof Boolean))
    {
      bool1 = bool2;
      if (((Boolean)localObject).booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void stopCameraPreview(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "stopCameraPreview", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void stopDumpAudioData()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "stopDumpAudioData", false, null, new Object[0]);
  }
  
  public void stopPusher()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "stopPusher", false, null, new Object[0]);
  }
  
  public void switchCamera()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "switchCamera", false, null, new Object[0]);
  }
  
  public void toggleTorch(Object paramObject)
  {
    QMLog.w("WXLivePusherReflect", "toggleTorch: not implement");
  }
  
  public boolean turnOnFlashLight(boolean paramBoolean)
  {
    Boolean localBoolean = (Boolean)JarReflectUtil.callSpecifiedMethod(this.a, "turnOnFlashLight", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return false;
  }
  
  public void txCloudVideoView_disableLog(Boolean paramBoolean, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "disableLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public void txLivePlayer_setVisibility(int paramInt, Object paramObject)
  {
    JarReflectUtil.callSpecifiedMethod(paramObject, "setVisibility", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.WXLivePusherDefaultProxy
 * JD-Core Version:    0.7.0.1
 */