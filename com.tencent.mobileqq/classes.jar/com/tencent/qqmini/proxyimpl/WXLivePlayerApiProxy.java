package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.view.Surface;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayConfig;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@ProxyService(proxy=IWXLivePlayerProxy.class)
public class WXLivePlayerApiProxy
  implements IWXLivePlayerProxy
{
  private static volatile String d;
  private TXCloudVideoView a;
  private WXLivePlayConfig b;
  private WXLivePlayer c;
  
  public void hookListenerAndGoOn(String paramString, InvocationHandler paramInvocationHandler)
  {
    d = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hookListenerAndGoOn: ");
    localStringBuilder.append(paramString);
    QMLog.i("WXLivePlayerApiProxy", localStringBuilder.toString());
    SoLoadManager.getInstance().load("trtc_entry", new WXLivePlayerApiProxy.1(this));
    try
    {
      TXLiveBase.setLibraryPath(paramString);
      TXLiveBase.setListener((ITXLiveBaseListener)Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { ITXLiveBaseListener.class }, paramInvocationHandler));
      return;
    }
    finally {}
  }
  
  public void init(Context paramContext, InvocationHandler paramInvocationHandler1, InvocationHandler paramInvocationHandler2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QMLog.i("WXLivePlayerApiProxy", "WXLivePlayerApiProxy init...");
      }
      this.b = new WXLivePlayConfig();
      this.c = new WXLivePlayer(paramContext);
      txLivePlayer_enableHardwareDecode(Boolean.valueOf(true));
      try
      {
        this.c.setConfig(this.b);
        txLivePlayer_setPlayListener((ITXLivePlayListener)Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { ITXLivePlayListener.class }, paramInvocationHandler1));
        txLivePlayer_setAudioVolumeEvaluationListener((TXLivePlayer.ITXAudioVolumeEvaluationListener)Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { TXLivePlayer.ITXAudioVolumeEvaluationListener.class }, paramInvocationHandler2));
      }
      catch (Exception paramContext)
      {
        paramInvocationHandler1 = new StringBuilder();
        paramInvocationHandler1.append("bind InnerTXLivePlayListenerImpl failed, e");
        paramInvocationHandler1.append(paramContext.toString());
        QMLog.e("WXLivePlayerApiProxy", paramInvocationHandler1.toString());
      }
      return;
    }
    finally {}
  }
  
  public void initLivePlayer(Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initLivePlayer view: ");
      localStringBuilder.append(paramObject);
      QMLog.i("WXLivePlayerApiProxy", localStringBuilder.toString());
    }
    if ((paramObject instanceof TXCloudVideoView))
    {
      this.a = ((TXCloudVideoView)paramObject);
      return;
    }
    throw new RuntimeException("txCloudVideoView type error");
  }
  
  public boolean needLoadAvJar()
  {
    return false;
  }
  
  public void txCloudVideoView_disableLog(Boolean paramBoolean)
  {
    this.a.disableLog(paramBoolean.booleanValue());
  }
  
  public void txCloudVideoView_showLog(Boolean paramBoolean)
  {
    this.a.showLog(paramBoolean.booleanValue());
  }
  
  public void txLivePlayConfig_setAutoAdjustCacheTime(Boolean paramBoolean)
  {
    this.b.setAutoAdjustCacheTime(paramBoolean.booleanValue());
  }
  
  public void txLivePlayConfig_setCacheTime(float paramFloat)
  {
    this.b.setCacheTime(paramFloat);
  }
  
  public void txLivePlayConfig_setEnableMetaData(Boolean paramBoolean)
  {
    this.b.setEnableMessage(paramBoolean.booleanValue());
  }
  
  public void txLivePlayConfig_setMaxAutoAdjustCacheTime(float paramFloat)
  {
    this.b.setMaxAutoAdjustCacheTime(paramFloat);
  }
  
  public void txLivePlayConfig_setMinAutoAdjustCacheTime(float paramFloat)
  {
    this.b.setMinAutoAdjustCacheTime(paramFloat);
  }
  
  public void txLivePlay_snapshot(InvocationHandler paramInvocationHandler)
  {
    paramInvocationHandler = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { TXLivePlayer.ITXSnapshotListener.class }, paramInvocationHandler);
    if (d != null) {
      this.c.snapshot((TXLivePlayer.ITXSnapshotListener)paramInvocationHandler);
    }
  }
  
  public void txLivePlayer_enableAudioVolumeEvaluation(int paramInt)
  {
    if (d != null) {
      this.c.enableAudioVolumeEvaluation(paramInt);
    }
  }
  
  public void txLivePlayer_enableHardwareDecode(Boolean paramBoolean)
  {
    if (d != null) {
      this.c.enableHardwareDecode(paramBoolean.booleanValue());
    }
  }
  
  public boolean txLivePlayer_isPlaying()
  {
    if (d != null) {
      return this.c.isPlaying();
    }
    return false;
  }
  
  public void txLivePlayer_muteAudio(Boolean paramBoolean)
  {
    if (d != null) {
      this.c.muteAudio(paramBoolean.booleanValue());
    }
  }
  
  public void txLivePlayer_muteVideo(Boolean paramBoolean)
  {
    if (d != null) {
      this.c.muteVideo(paramBoolean.booleanValue());
    }
  }
  
  public void txLivePlayer_pause()
  {
    if (d != null) {
      try
      {
        this.c.pause();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("WXLivePlayerApiProxy", 1, "txLivePlayer_pause failed", localThrowable);
      }
    }
  }
  
  public void txLivePlayer_resume()
  {
    if (d != null) {
      try
      {
        this.c.resume();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("WXLivePlayerApiProxy", 1, "txLivePlayer_resume failed", localException);
      }
    }
  }
  
  public void txLivePlayer_setAudioRoute(int paramInt)
  {
    if (d != null) {
      this.c.setAudioRoute(paramInt);
    }
  }
  
  public void txLivePlayer_setAudioVolumeEvaluationListener(Object paramObject)
  {
    if (d != null) {
      this.c.setAudioVolumeEvaluationListener((TXLivePlayer.ITXAudioVolumeEvaluationListener)paramObject);
    }
  }
  
  public void txLivePlayer_setConfig()
  {
    if (d != null) {
      this.c.setConfig(this.b);
    }
  }
  
  public void txLivePlayer_setPlayListener(Object paramObject)
  {
    if (d != null) {
      this.c.setPlayListener((ITXLivePlayListener)paramObject);
    }
  }
  
  public void txLivePlayer_setPlayerView(Object paramObject)
  {
    this.a = null;
    if (d != null) {
      this.c.setPlayerView((TXCloudVideoView)paramObject);
    }
  }
  
  public void txLivePlayer_setRenderMode(int paramInt)
  {
    if (d != null) {
      this.c.setRenderMode(paramInt);
    }
  }
  
  public void txLivePlayer_setRenderRotation(int paramInt)
  {
    if (d != null) {
      this.c.setRenderRotation(paramInt);
    }
  }
  
  public void txLivePlayer_setSurface(Surface paramSurface)
  {
    if (d != null) {
      this.c.setSurface(paramSurface);
    }
  }
  
  public void txLivePlayer_setSurfaceSize(int paramInt1, int paramInt2)
  {
    if (d != null) {
      this.c.setSurfaceSize(paramInt1, paramInt2);
    }
  }
  
  public void txLivePlayer_showDebugLog(Boolean paramBoolean)
  {
    if (d != null) {
      this.c.showDebugLog(paramBoolean.booleanValue());
    }
  }
  
  public int txLivePlayer_startPlay(String paramString, int paramInt)
  {
    if (d != null) {
      return this.c.startPlay(paramString, paramInt);
    }
    return -1;
  }
  
  public int txLivePlayer_stopPlay(Boolean paramBoolean)
  {
    if (d != null) {
      try
      {
        int i = this.c.stopPlay(paramBoolean.booleanValue());
        return i;
      }
      catch (Throwable paramBoolean)
      {
        QLog.e("WXLivePlayerApiProxy", 1, "txLivePlayer_stopPlay failed", paramBoolean);
      }
    }
    return -1;
  }
  
  public void txPlayConfig_setEnableMessage(Boolean paramBoolean)
  {
    this.b.setEnableMessage(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WXLivePlayerApiProxy
 * JD-Core Version:    0.7.0.1
 */