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
  private final WXLivePushConfig jdField_a_of_type_ComTencentRtmpWXLivePushConfig = new WXLivePushConfig();
  private WXLivePusher jdField_a_of_type_ComTencentRtmpWXLivePusher;
  
  public void enableAGC(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.enableAGC(paramBoolean);
  }
  
  public void enableANS(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.enableANS(paramBoolean);
  }
  
  public void enableAudioEarMonitoring(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.enableAudioEarMonitoring(paramBoolean);
  }
  
  public void enablePureAudioPush(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.enablePureAudioPush(paramBoolean);
  }
  
  public void initInstance(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher = new WXLivePusher(paramContext);
    setConfig();
  }
  
  public boolean isPushing()
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.isPushing();
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
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.pauseBGM();
  }
  
  public void pausePusher()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.pausePusher();
  }
  
  public boolean playBGM(String paramString)
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.playBGM(paramString);
  }
  
  public boolean resumeBGM()
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.resumeBGM();
  }
  
  public void resumePusher()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.resumePusher();
  }
  
  public boolean sendMessageEx(byte[] paramArrayOfByte)
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.sendMessageEx(paramArrayOfByte);
  }
  
  public void setAudioSampleRate(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setAudioSampleRate(paramInt);
  }
  
  public void setBGMNofify(Object paramObject)
  {
    if ((paramObject instanceof TXLivePusher.OnBGMNotify)) {
      this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setBGMNofify((TXLivePusher.OnBGMNotify)paramObject);
    }
  }
  
  public void setBGMPosition(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setBGMPosition(paramInt);
  }
  
  public boolean setBGMVolume(float paramFloat)
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setBGMVolume(paramFloat);
  }
  
  public void setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setBeautyFilter(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setConfig()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setConfig(this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig);
  }
  
  public void setEnableCamera(JSONObject paramJSONObject, Object paramObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("enable-camera", true)) && ((paramObject instanceof TXCloudVideoView))) {
      this.jdField_a_of_type_ComTencentRtmpWXLivePusher.startCameraPreview((TXCloudVideoView)paramObject);
    }
  }
  
  public void setEnableZoom(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setEnableZoom(paramBoolean);
  }
  
  public void setFrontCamera(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setFrontCamera(paramBoolean);
  }
  
  public void setHomeOrientation(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setHomeOrientation(paramInt);
  }
  
  public void setLocalVideoMirrorType(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setLocalVideoMirrorType(paramInt);
  }
  
  public void setMaxVideoBitrate(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setMaxVideoBitrate(paramInt);
  }
  
  public void setMicVolume(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setMicVolume(paramFloat);
  }
  
  public void setMinVideoBitrate(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setMinVideoBitrate(paramInt);
  }
  
  public void setMirror(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setMirror(paramBoolean);
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
      this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setVideoQuality(i, true, true);
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setMute(paramBoolean);
  }
  
  public void setPauseFlag(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setPauseFlag(paramInt);
  }
  
  public void setPauseImg(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setPauseImg(paramBitmap);
    }
  }
  
  public void setPushListener(Object paramObject)
  {
    if ((paramObject instanceof ITXLivePushListener)) {
      this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setPushListener((ITXLivePushListener)paramObject);
    }
  }
  
  public void setPusherUrl(String paramString)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setPusherUrl(paramString);
  }
  
  public void setRenderRotation(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setRenderRotation(paramInt);
  }
  
  public void setReverb(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setReverb(paramInt);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setSurface(paramSurface);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setSurfaceSize(paramInt1, paramInt2);
  }
  
  public void setTouchFocus(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setTouchFocus(paramBoolean);
  }
  
  public void setVideoEncodeGop(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setVideoEncodeGop(paramInt);
  }
  
  public void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.setVideoQuality(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setVideoResolution(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setVideoResolution(paramInt);
  }
  
  public void setVideoResolution(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setVideoResolution(paramInt1, paramInt2);
  }
  
  public void setVolumeType(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setVolumeType(paramInt);
  }
  
  public void setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePushConfig.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void showDebugLog(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.showDebugLog(paramBoolean);
  }
  
  public void snapshot(Object paramObject)
  {
    if ((paramObject instanceof TXLivePusher.ITXSnapshotListener)) {
      this.jdField_a_of_type_ComTencentRtmpWXLivePusher.snapshot((TXLivePusher.ITXSnapshotListener)paramObject);
    }
  }
  
  public void startAudioRecord()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.startAudioRecord();
  }
  
  public void startCameraPreview(Object paramObject)
  {
    if ((paramObject instanceof TXCloudVideoView)) {
      this.jdField_a_of_type_ComTencentRtmpWXLivePusher.startCameraPreview((TXCloudVideoView)paramObject);
    }
  }
  
  public int startDumpAudioData(String paramString)
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.startDumpAudioData(paramString);
  }
  
  public boolean startPusher(String paramString)
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.startPusher(paramString) == 0;
  }
  
  public void stopAudioRecord()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.stopAudioRecord();
  }
  
  public boolean stopBGM()
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.stopBGM();
  }
  
  public void stopCameraPreview(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.stopCameraPreview(paramBoolean);
  }
  
  public void stopDumpAudioData()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.stopDumpAudioData();
  }
  
  public void stopPusher()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.stopPusher();
  }
  
  public void switchCamera()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePusher.switchCamera();
  }
  
  public void toggleTorch(Object paramObject)
  {
    QMLog.w("WXLivePusherApiProxy", "toggleTorch: not implement");
  }
  
  public boolean turnOnFlashLight(boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePusher.turnOnFlashLight(paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WXLivePusherApiProxy
 * JD-Core Version:    0.7.0.1
 */