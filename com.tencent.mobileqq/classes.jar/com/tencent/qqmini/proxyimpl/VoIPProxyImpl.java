package com.tencent.qqmini.proxyimpl;

import bfqs;
import bfqu;
import bfqx;
import bfrc;
import bfrf;
import bfrg;
import bfri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.VoIPListener;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;

public class VoIPProxyImpl
  extends VoIPProxy
{
  private static final String TAG = "VoIPProxyImpl";
  private bfrf mQavMultiObserver = new VoIPProxyImpl.2(this);
  private VoIPProxy.VoIPListener mVoIPListener;
  
  private void qavDeInitSDK()
  {
    QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    bfqu localbfqu = bfqu.a();
    localbfqu.b(this.mQavMultiObserver);
    localbfqu.a();
  }
  
  public int enableLocalAudio(boolean paramBoolean)
  {
    bfrc localbfrc = bfqu.a().a();
    if (localbfrc != null)
    {
      localbfrc.a(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int enableRemoteAudio(boolean paramBoolean)
  {
    bfrc localbfrc = bfqu.a().a();
    if (localbfrc != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbfrc.b(paramBoolean);
        return 0;
      }
    }
    return -1;
  }
  
  public void exitRoom()
  {
    bfrc localbfrc = bfqu.a().a();
    if (localbfrc != null) {
      localbfrc.a();
    }
  }
  
  public void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    bfrg.a(new bfri());
    bfqx localbfqx = bfqx.a();
    localbfqx.a((AppRuntime)localObject);
    localbfqx.a(new VoIPProxyImpl.1(this));
    localObject = bfqu.a();
    ((bfqu)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localbfqx);
    this.mVoIPListener = paramVoIPListener;
    ((bfqu)localObject).a(this.mQavMultiObserver);
  }
  
  public int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    bfrc localbfrc = bfqu.a().a();
    if (localbfrc != null)
    {
      bfqs localbfqs = new bfqs();
      localbfqs.jdField_a_of_type_Int = 11;
      localbfqs.b = 14;
      localbfqs.c = 1;
      localbfqs.d = paramInt;
      localbfqs.jdField_a_of_type_Long = paramLong;
      localbfqs.jdField_a_of_type_JavaLangString = paramString;
      localbfqs.e = 1;
      localbfqs.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      return localbfrc.a(localbfqs);
    }
    return -4;
  }
  
  public void setAudioRoute(int paramInt)
  {
    bfrc localbfrc = bfqu.a().a();
    if (localbfrc != null) {
      localbfrc.a(paramInt);
    }
  }
  
  public void unInit()
  {
    qavDeInitSDK();
    this.mVoIPListener = null;
  }
  
  public void updateRoomInfo()
  {
    bfrc localbfrc = bfqu.a().a();
    if (localbfrc != null) {
      localbfrc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VoIPProxyImpl
 * JD-Core Version:    0.7.0.1
 */