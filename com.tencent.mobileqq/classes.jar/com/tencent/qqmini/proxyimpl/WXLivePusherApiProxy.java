package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListenerInvocationHandler;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotifyInvocationHandler;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.TXLivePushListenerInvocationHandler;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePushConfig;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

@ProxyService(proxy=IWXLivePusherProxy.class)
public class WXLivePusherApiProxy
  implements IWXLivePusherProxy
{
  private WXLivePusher a;
  private final WXLivePushConfig b = new WXLivePushConfig();
  
  public void enableAGC(boolean paramBoolean)
  {
    this.b.enableAGC(paramBoolean);
  }
  
  public void enableANS(boolean paramBoolean)
  {
    this.b.enableANS(paramBoolean);
  }
  
  public void enableAudioEarMonitoring(boolean paramBoolean)
  {
    this.b.enableAudioEarMonitoring(paramBoolean);
  }
  
  public void enablePureAudioPush(boolean paramBoolean)
  {
    this.b.enablePureAudioPush(paramBoolean);
  }
  
  public void initInstance(Context paramContext)
  {
    try
    {
      this.a = new WXLivePusher(paramContext);
      setConfig();
      return;
    }
    finally {}
  }
  
  public boolean isPushing()
  {
    return this.a.isPushing();
  }
  
  public Object newITXLivePushListener(TXLivePushListenerReflect.ITXLivePushListener paramITXLivePushListener)
  {
    ClassLoader localClassLoader = getClass().getClassLoader();
    paramITXLivePushListener = new TXLivePushListenerReflect.TXLivePushListenerInvocationHandler(paramITXLivePushListener);
    return Proxy.newProxyInstance(localClassLoader, new Class[] { ITXLivePushListener.class }, paramITXLivePushListener);
  }
  
  public Object newITXSnapshotListener(TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener)
  {
    ClassLoader localClassLoader = getClass().getClassLoader();
    paramITXSnapshotListener = new TXLivePushListenerReflect.ITXSnapshotListenerInvocationHandler(paramITXSnapshotListener);
    return Proxy.newProxyInstance(localClassLoader, new Class[] { TXLivePusher.ITXSnapshotListener.class }, paramITXSnapshotListener);
  }
  
  public Object newOnBGMNotify(TXLivePushListenerReflect.OnBGMNotify paramOnBGMNotify)
  {
    ClassLoader localClassLoader = getClass().getClassLoader();
    paramOnBGMNotify = new TXLivePushListenerReflect.OnBGMNotifyInvocationHandler(paramOnBGMNotify);
    return Proxy.newProxyInstance(localClassLoader, new Class[] { TXLivePusher.OnBGMNotify.class }, paramOnBGMNotify);
  }
  
  public boolean pauseBGM()
  {
    return this.a.pauseBGM();
  }
  
  public void pausePusher()
  {
    this.a.pausePusher();
  }
  
  public boolean playBGM(String paramString)
  {
    return this.a.playBGM(paramString);
  }
  
  public boolean resumeBGM()
  {
    return this.a.resumeBGM();
  }
  
  public void resumePusher()
  {
    this.a.resumePusher();
  }
  
  public boolean sendMessageEx(byte[] paramArrayOfByte)
  {
    return this.a.sendMessageEx(paramArrayOfByte);
  }
  
  public void setAudioSampleRate(int paramInt)
  {
    this.b.setAudioSampleRate(paramInt);
  }
  
  public void setBGMNofify(Object paramObject)
  {
    if ((paramObject instanceof TXLivePusher.OnBGMNotify)) {
      this.a.setBGMNofify((TXLivePusher.OnBGMNotify)paramObject);
    }
  }
  
  public void setBGMPosition(int paramInt)
  {
    this.a.setBGMPosition(paramInt);
  }
  
  public boolean setBGMVolume(float paramFloat)
  {
    return this.a.setBGMVolume(paramFloat);
  }
  
  public void setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.setBeautyFilter(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setConfig()
  {
    this.a.setConfig(this.b);
  }
  
  public void setEnableCamera(JSONObject paramJSONObject, Object paramObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("enable-camera", true)) && ((paramObject instanceof TXCloudVideoView))) {
      this.a.startCameraPreview((TXCloudVideoView)paramObject);
    }
  }
  
  public void setEnableZoom(boolean paramBoolean)
  {
    this.b.setEnableZoom(paramBoolean);
  }
  
  public void setFrontCamera(boolean paramBoolean)
  {
    this.b.setFrontCamera(paramBoolean);
  }
  
  public void setHomeOrientation(int paramInt)
  {
    this.b.setHomeOrientation(paramInt);
  }
  
  public void setLocalVideoMirrorType(int paramInt)
  {
    this.b.setLocalVideoMirrorType(paramInt);
  }
  
  public void setMaxVideoBitrate(int paramInt)
  {
    this.b.setMaxVideoBitrate(paramInt);
  }
  
  public void setMicVolume(float paramFloat)
  {
    this.a.setMicVolume(paramFloat);
  }
  
  public void setMinVideoBitrate(int paramInt)
  {
    this.b.setMinVideoBitrate(paramInt);
  }
  
  public void setMirror(boolean paramBoolean)
  {
    this.a.setMirror(paramBoolean);
  }
  
  public void setMode(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("mode", "RTC");
      int i = 6;
      if ("SD".equals(paramJSONObject))
      {
        i = 1;
      }
      else if ("HD".equals(paramJSONObject))
      {
        i = 2;
      }
      else if ("FHD".equals(paramJSONObject))
      {
        i = 3;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMode unknown mode ");
        localStringBuilder.append(paramJSONObject);
        QMLog.w("WXLivePusherApiProxy", localStringBuilder.toString());
      }
      this.a.setVideoQuality(i, true, true);
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    this.a.setMute(paramBoolean);
  }
  
  public void setPauseFlag(int paramInt)
  {
    this.b.setPauseFlag(paramInt);
  }
  
  public void setPauseImg(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.b.setPauseImg(paramBitmap);
    }
  }
  
  public void setPushListener(Object paramObject)
  {
    if ((paramObject instanceof ITXLivePushListener)) {
      this.a.setPushListener((ITXLivePushListener)paramObject);
    }
  }
  
  public void setPusherUrl(String paramString)
  {
    this.a.setPusherUrl(paramString);
  }
  
  public void setRenderRotation(int paramInt)
  {
    this.a.setRenderRotation(paramInt);
  }
  
  public void setReverb(int paramInt)
  {
    this.a.setReverb(paramInt);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.a.setSurface(paramSurface);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    this.a.setSurfaceSize(paramInt1, paramInt2);
  }
  
  public void setTouchFocus(boolean paramBoolean)
  {
    this.b.setTouchFocus(paramBoolean);
  }
  
  public void setVideoEncodeGop(int paramInt)
  {
    this.b.setVideoEncodeGop(paramInt);
  }
  
  public void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.setVideoQuality(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setVideoResolution(int paramInt)
  {
    this.b.setVideoResolution(paramInt);
  }
  
  public void setVideoResolution(int paramInt1, int paramInt2)
  {
    this.b.setVideoResolution(paramInt1, paramInt2);
  }
  
  public void setVolumeType(int paramInt)
  {
    this.b.setVolumeType(paramInt);
  }
  
  public void setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.b.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void showDebugLog(boolean paramBoolean)
  {
    this.a.showDebugLog(paramBoolean);
  }
  
  public void snapshot(Object paramObject)
  {
    if ((paramObject instanceof TXLivePusher.ITXSnapshotListener)) {
      this.a.snapshot((TXLivePusher.ITXSnapshotListener)paramObject);
    }
  }
  
  public void startAudioRecord()
  {
    this.a.startAudioRecord();
  }
  
  public void startCameraPreview(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCameraPreview: ");
    localStringBuilder.append(paramObject);
    QMLog.e("WXLivePusherApiProxy", localStringBuilder.toString());
    if (!(paramObject instanceof TXCloudVideoView))
    {
      this.a.startCameraPreview(null);
      return;
    }
    this.a.startCameraPreview((TXCloudVideoView)paramObject);
  }
  
  public int startDumpAudioData(String paramString)
  {
    return this.a.startDumpAudioData(paramString);
  }
  
  public boolean startPusher(String paramString)
  {
    return this.a.startPusher(paramString) == 0;
  }
  
  public void stopAudioRecord()
  {
    this.a.stopAudioRecord();
  }
  
  public boolean stopBGM()
  {
    return this.a.stopBGM();
  }
  
  public void stopCameraPreview(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopCameraPreview: ");
    localStringBuilder.append(paramBoolean);
    QMLog.e("WXLivePusherApiProxy", localStringBuilder.toString());
    this.a.stopCameraPreview(paramBoolean);
  }
  
  public void stopDumpAudioData()
  {
    this.a.stopDumpAudioData();
  }
  
  public void stopPusher()
  {
    try
    {
      this.a.stopPusher();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop pusher exception: ");
      localStringBuilder.append(localException.getMessage());
      QMLog.i("WXLivePusherApiProxy", localStringBuilder.toString());
    }
  }
  
  public void switchCamera()
  {
    QMLog.e("WXLivePusherApiProxy", "switchCamera...");
    this.a.switchCamera();
  }
  
  public void toggleTorch(Object paramObject)
  {
    QMLog.w("WXLivePusherApiProxy", "toggleTorch: not implement");
  }
  
  public boolean turnOnFlashLight(boolean paramBoolean)
  {
    return this.a.turnOnFlashLight(paramBoolean);
  }
  
  public void txCloudVideoView_disableLog(Boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof TXCloudVideoView)) {
      ((TXCloudVideoView)paramObject).disableLog(paramBoolean.booleanValue());
    }
  }
  
  public void txLivePlayer_setVisibility(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof View)) {
      ((View)paramObject).setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WXLivePusherApiProxy
 * JD-Core Version:    0.7.0.1
 */