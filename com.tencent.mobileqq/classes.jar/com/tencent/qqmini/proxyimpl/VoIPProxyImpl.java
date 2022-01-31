package com.tencent.qqmini.proxyimpl;

import bfvb;
import bfvd;
import bfvg;
import bfvl;
import bfvo;
import bfvp;
import bfvr;
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
  private bfvo mQavMultiObserver = new VoIPProxyImpl.2(this);
  private VoIPProxy.VoIPListener mVoIPListener;
  
  private void qavDeInitSDK()
  {
    QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    bfvd localbfvd = bfvd.a();
    localbfvd.b(this.mQavMultiObserver);
    localbfvd.a();
  }
  
  public int enableLocalAudio(boolean paramBoolean)
  {
    bfvl localbfvl = bfvd.a().a();
    if (localbfvl != null)
    {
      localbfvl.a(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int enableRemoteAudio(boolean paramBoolean)
  {
    bfvl localbfvl = bfvd.a().a();
    if (localbfvl != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbfvl.b(paramBoolean);
        return 0;
      }
    }
    return -1;
  }
  
  public void exitRoom()
  {
    bfvl localbfvl = bfvd.a().a();
    if (localbfvl != null) {
      localbfvl.a();
    }
  }
  
  public void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    bfvp.a(new bfvr());
    bfvg localbfvg = bfvg.a();
    localbfvg.a((AppRuntime)localObject);
    localbfvg.a(new VoIPProxyImpl.1(this));
    localObject = bfvd.a();
    ((bfvd)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localbfvg);
    this.mVoIPListener = paramVoIPListener;
    ((bfvd)localObject).a(this.mQavMultiObserver);
  }
  
  public int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    bfvl localbfvl = bfvd.a().a();
    if (localbfvl != null)
    {
      bfvb localbfvb = new bfvb();
      localbfvb.jdField_a_of_type_Int = 11;
      localbfvb.b = 14;
      localbfvb.c = 1;
      localbfvb.d = paramInt;
      localbfvb.jdField_a_of_type_Long = paramLong;
      localbfvb.jdField_a_of_type_JavaLangString = paramString;
      localbfvb.e = 1;
      localbfvb.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      return localbfvl.a(localbfvb);
    }
    return -4;
  }
  
  public void setAudioRoute(int paramInt)
  {
    bfvl localbfvl = bfvd.a().a();
    if (localbfvl != null) {
      localbfvl.a(paramInt);
    }
  }
  
  public void unInit()
  {
    qavDeInitSDK();
    this.mVoIPListener = null;
  }
  
  public void updateRoomInfo()
  {
    bfvl localbfvl = bfvd.a().a();
    if (localbfvl != null) {
      localbfvl.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VoIPProxyImpl
 * JD-Core Version:    0.7.0.1
 */