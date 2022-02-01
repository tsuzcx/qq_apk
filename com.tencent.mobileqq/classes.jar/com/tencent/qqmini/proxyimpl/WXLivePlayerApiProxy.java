package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.view.Surface;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter;
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
  private WXLivePlayConfig jdField_a_of_type_ComTencentRtmpWXLivePlayConfig;
  private WXLivePlayer jdField_a_of_type_ComTencentRtmpWXLivePlayer;
  private TXCloudVideoView jdField_a_of_type_ComTencentRtmpUiTXCloudVideoView;
  
  public void hookListenerAndGoOn(String paramString, InvocationHandler paramInvocationHandler)
  {
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
      this.jdField_a_of_type_ComTencentRtmpWXLivePlayConfig = new WXLivePlayConfig();
      this.jdField_a_of_type_ComTencentRtmpWXLivePlayer = new WXLivePlayer(paramContext);
      txLivePlayer_enableHardwareDecode(Boolean.valueOf(true));
      try
      {
        this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setConfig(this.jdField_a_of_type_ComTencentRtmpWXLivePlayConfig);
        txLivePlayer_setPlayListener((ITXLivePlayListener)Proxy.newProxyInstance(TXLivePlayerJSAdapter.class.getClassLoader(), new Class[] { ITXLivePlayListener.class }, paramInvocationHandler1));
        txLivePlayer_setAudioVolumeEvaluationListener((TXLivePlayer.ITXAudioVolumeEvaluationListener)Proxy.newProxyInstance(TXLivePlayerJSAdapter.class.getClassLoader(), new Class[] { TXLivePlayer.ITXAudioVolumeEvaluationListener.class }, paramInvocationHandler2));
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
      this.jdField_a_of_type_ComTencentRtmpUiTXCloudVideoView = ((TXCloudVideoView)paramObject);
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
    this.jdField_a_of_type_ComTencentRtmpUiTXCloudVideoView.disableLog(paramBoolean.booleanValue());
  }
  
  public void txCloudVideoView_showLog(Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpUiTXCloudVideoView.showLog(paramBoolean.booleanValue());
  }
  
  public void txLivePlayConfig_setAutoAdjustCacheTime(Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayConfig.setAutoAdjustCacheTime(paramBoolean.booleanValue());
  }
  
  public void txLivePlayConfig_setCacheTime(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayConfig.setCacheTime(paramFloat);
  }
  
  public void txLivePlayConfig_setEnableMetaData(Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayConfig.setEnableMessage(paramBoolean.booleanValue());
  }
  
  public void txLivePlayConfig_setMaxAutoAdjustCacheTime(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayConfig.setMaxAutoAdjustCacheTime(paramFloat);
  }
  
  public void txLivePlayConfig_setMinAutoAdjustCacheTime(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayConfig.setMinAutoAdjustCacheTime(paramFloat);
  }
  
  public void txLivePlay_snapshot(InvocationHandler paramInvocationHandler)
  {
    paramInvocationHandler = Proxy.newProxyInstance(TXLivePlayerJSAdapter.class.getClassLoader(), new Class[] { TXLivePlayer.ITXSnapshotListener.class }, paramInvocationHandler);
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.snapshot((TXLivePlayer.ITXSnapshotListener)paramInvocationHandler);
  }
  
  public void txLivePlayer_enableAudioVolumeEvaluation(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.enableAudioVolumeEvaluation(paramInt);
  }
  
  public void txLivePlayer_enableHardwareDecode(Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.enableHardwareDecode(paramBoolean.booleanValue());
  }
  
  public boolean txLivePlayer_isPlaying()
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.isPlaying();
  }
  
  public void txLivePlayer_muteAudio(Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.muteAudio(paramBoolean.booleanValue());
  }
  
  public void txLivePlayer_muteVideo(Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.muteVideo(paramBoolean.booleanValue());
  }
  
  public void txLivePlayer_pause()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.pause();
  }
  
  public void txLivePlayer_resume()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.resume();
  }
  
  public void txLivePlayer_setAudioRoute(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setAudioRoute(paramInt);
  }
  
  public void txLivePlayer_setAudioVolumeEvaluationListener(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setAudioVolumeEvaluationListener((TXLivePlayer.ITXAudioVolumeEvaluationListener)paramObject);
  }
  
  public void txLivePlayer_setConfig()
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setConfig(this.jdField_a_of_type_ComTencentRtmpWXLivePlayConfig);
  }
  
  public void txLivePlayer_setPlayListener(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setPlayListener((ITXLivePlayListener)paramObject);
  }
  
  public void txLivePlayer_setPlayerView(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentRtmpUiTXCloudVideoView = null;
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setPlayerView((TXCloudVideoView)paramObject);
  }
  
  public void txLivePlayer_setRenderMode(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setRenderMode(paramInt);
  }
  
  public void txLivePlayer_setRenderRotation(int paramInt)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setRenderRotation(paramInt);
  }
  
  public void txLivePlayer_setSurface(Surface paramSurface)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setSurface(paramSurface);
  }
  
  public void txLivePlayer_setSurfaceSize(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.setSurfaceSize(paramInt1, paramInt2);
  }
  
  public void txLivePlayer_showDebugLog(Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.showDebugLog(paramBoolean.booleanValue());
  }
  
  public int txLivePlayer_startPlay(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.startPlay(paramString, paramInt);
  }
  
  public int txLivePlayer_stopPlay(Boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentRtmpWXLivePlayer.stopPlay(paramBoolean.booleanValue());
  }
  
  public void txPlayConfig_setEnableMessage(Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentRtmpWXLivePlayConfig.setEnableMessage(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WXLivePlayerApiProxy
 * JD-Core Version:    0.7.0.1
 */