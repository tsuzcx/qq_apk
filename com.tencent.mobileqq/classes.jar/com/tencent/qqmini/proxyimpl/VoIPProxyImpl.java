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
  private QavMultiObserver jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver = new VoIPProxyImpl.2(this);
  private VoIPProxy.VoIPListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener;
  
  private void a()
  {
    QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    QavSDK localQavSDK = QavSDK.a();
    localQavSDK.b(this.jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver);
    localQavSDK.a();
  }
  
  public int enableLocalAudio(boolean paramBoolean)
  {
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null)
    {
      localIMultiOperator.a(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int enableRemoteAudio(boolean paramBoolean)
  {
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localIMultiOperator.b(paramBoolean);
        return 0;
      }
    }
    return -1;
  }
  
  public void exitRoom()
  {
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null) {
      localIMultiOperator.e();
    }
  }
  
  public void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    AVLog.a(new AVLogImpl());
    VideoChannelImpl localVideoChannelImpl = VideoChannelImpl.a();
    localVideoChannelImpl.a((AppRuntime)localObject);
    localVideoChannelImpl.a(new VoIPProxyImpl.1(this));
    localObject = QavSDK.a();
    ((QavSDK)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localVideoChannelImpl);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = paramVoIPListener;
    ((QavSDK)localObject).a(this.jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver);
  }
  
  public int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null)
    {
      QavDef.MultiParams localMultiParams = new QavDef.MultiParams();
      localMultiParams.jdField_a_of_type_Int = 11;
      localMultiParams.b = 14;
      localMultiParams.c = 1;
      localMultiParams.d = paramInt;
      localMultiParams.jdField_a_of_type_Long = paramLong;
      localMultiParams.jdField_a_of_type_JavaLangString = paramString;
      localMultiParams.e = 1;
      localMultiParams.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      return localIMultiOperator.a(localMultiParams);
    }
    return -4;
  }
  
  public void setAudioRoute(int paramInt)
  {
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null) {
      localIMultiOperator.b(paramInt);
    }
  }
  
  public void unInit()
  {
    a();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = null;
  }
  
  public void updateRoomInfo()
  {
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null) {
      localIMultiOperator.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VoIPProxyImpl
 * JD-Core Version:    0.7.0.1
 */