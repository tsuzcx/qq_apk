package com.tencent.qqmini.proxyimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qav.QavDef.MultiParams;
import com.tencent.qav.QavSDK;
import com.tencent.qav.channel.VideoChannelImpl;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.controller.multi.QavMultiObserver;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.log.AVLogImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;

@ProxyService(proxy=VoIPProxy.class)
public class VoIPProxyImpl
  extends VoIPProxy
{
  private VoIPProxy.VoIPListener a;
  private QavMultiObserver b = new VoIPProxyImpl.2(this);
  
  private void a()
  {
    QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.d(), BaseApplicationImpl.getApplication().getQQProcessName());
    QavSDK localQavSDK = QavSDK.a();
    localQavSDK.b(this.b);
    localQavSDK.b();
  }
  
  public int enableLocalAudio(boolean paramBoolean)
  {
    IMultiOperator localIMultiOperator = QavSDK.a().c();
    if (localIMultiOperator != null)
    {
      localIMultiOperator.a(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int enableRemoteAudio(boolean paramBoolean)
  {
    IMultiOperator localIMultiOperator = QavSDK.a().c();
    if (localIMultiOperator != null)
    {
      localIMultiOperator.b(paramBoolean ^ true);
      return 0;
    }
    return -1;
  }
  
  public void exitRoom()
  {
    IMultiOperator localIMultiOperator = QavSDK.a().c();
    if (localIMultiOperator != null) {
      localIMultiOperator.g();
    }
  }
  
  public void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.d(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    AVLog.a(new AVLogImpl());
    VideoChannelImpl localVideoChannelImpl = VideoChannelImpl.c();
    localVideoChannelImpl.a((AppRuntime)localObject);
    localVideoChannelImpl.a(new VoIPProxyImpl.1(this));
    localObject = QavSDK.a();
    ((QavSDK)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localVideoChannelImpl);
    this.a = paramVoIPListener;
    ((QavSDK)localObject).a(this.b);
  }
  
  public int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    IMultiOperator localIMultiOperator = QavSDK.a().c();
    if (localIMultiOperator != null)
    {
      QavDef.MultiParams localMultiParams = new QavDef.MultiParams();
      localMultiParams.a = 11;
      localMultiParams.b = 14;
      localMultiParams.c = 1;
      localMultiParams.d = paramInt;
      localMultiParams.e = paramLong;
      localMultiParams.f = paramString;
      localMultiParams.g = 1;
      localMultiParams.h = paramArrayOfByte;
      return localIMultiOperator.a(localMultiParams);
    }
    return -4;
  }
  
  public void setAudioRoute(int paramInt)
  {
    IMultiOperator localIMultiOperator = QavSDK.a().c();
    if (localIMultiOperator != null) {
      localIMultiOperator.b(paramInt);
    }
  }
  
  public void unInit()
  {
    a();
    this.a = null;
  }
  
  public void updateRoomInfo()
  {
    IMultiOperator localIMultiOperator = QavSDK.a().c();
    if (localIMultiOperator != null) {
      localIMultiOperator.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VoIPProxyImpl
 * JD-Core Version:    0.7.0.1
 */