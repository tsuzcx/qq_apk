package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel;

import android.content.Context;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.channel.ChannelCreateCallback;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.CsTask;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.utils.HexUtil;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.mobileqq.now.msfilivehead.ForwardReq;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.qphone.base.util.QLog;

public class MsfChannelService
  implements ChannelInterface, ThreadCenter.HandlerKeyable
{
  private LoginInfo a;
  
  public MsfChannelService()
  {
    CsTaskImpl.a = this;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback)
  {
    paramChannelCallback = new MsfChannelService.1(this, paramChannelCallback);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "ISO8859_1");
      ((ILiveDelivery)RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO(paramString, paramArrayOfByte, null, -1, new MsfChannelService.2(this, paramChannelCallback));
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        QLog.e("MsfChannelService", 1, "SendFollowMsg request error " + paramArrayOfByte.getMessage());
        paramArrayOfByte = null;
      }
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ForwardReq localForwardReq = new ForwardReq();
    Object localObject = (AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class);
    localForwardReq.jdField_a_of_type_Int = ((AppGeneralInfoService)localObject).getClientType();
    localForwardReq.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localForwardReq.jdField_b_of_type_JavaLangString = ((AppGeneralInfoService)localObject).getVersionName();
    localForwardReq.jdField_b_of_type_Int = ((AppGeneralInfoService)localObject).getVersionCode();
    localForwardReq.jdField_c_of_type_Int = 1;
    localForwardReq.jdField_b_of_type_ArrayOfByte = ((AppGeneralInfoService)localObject).getDeviceID().getBytes();
    if (((AppGeneralInfoService)localObject).isSvrTestEnv())
    {
      localForwardReq.f = 2;
      localObject = this.a;
      paramArrayOfByte = (byte[])localObject;
      if (localObject == null) {
        paramArrayOfByte = a();
      }
      if (paramArrayOfByte == null) {
        break label251;
      }
      switch (MsfChannelService.3.a[paramArrayOfByte.loginType.ordinal()])
      {
      default: 
        localForwardReq.jdField_d_of_type_Int = 3;
      }
    }
    for (;;)
    {
      localForwardReq.g = 37;
      if (paramArrayOfByte != null)
      {
        localForwardReq.jdField_a_of_type_Long = paramArrayOfByte.uid;
        localForwardReq.jdField_a_of_type_JavaLangString = HexUtil.bytesToHexString(paramArrayOfByte.a2);
        localForwardReq.jdField_b_of_type_Long = paramArrayOfByte.tinyid;
        if (!TextUtils.isEmpty(paramArrayOfByte.access_token)) {
          localForwardReq.jdField_d_of_type_JavaLangString = paramArrayOfByte.access_token;
        }
        if (!TextUtils.isEmpty(paramArrayOfByte.openId)) {
          localForwardReq.jdField_c_of_type_JavaLangString = paramArrayOfByte.openId;
        }
      }
      return MessageNano.toByteArray(localForwardReq);
      localForwardReq.f = 0;
      break;
      localForwardReq.jdField_d_of_type_Int = 1;
      continue;
      localForwardReq.jdField_d_of_type_Int = 2;
      continue;
      label251:
      localForwardReq.jdField_d_of_type_Int = 3;
    }
  }
  
  protected LoginInfo a()
  {
    return null;
  }
  
  protected void a(LoginInfo paramLoginInfo) {}
  
  public void clearEventOutput()
  {
    ThreadCenter.clear(this);
  }
  
  public void create(ChannelCreateCallback paramChannelCreateCallback)
  {
    paramChannelCreateCallback.onSucceed();
  }
  
  public CsTask createCsTask()
  {
    return new CsTaskImpl();
  }
  
  public PushReceiver createPushReceiver()
  {
    return null;
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy()
  {
    clearEventOutput();
    CsTaskImpl.a = null;
  }
  
  public void send(int paramInt1, int paramInt2, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback)
  {
    sendWithCmd(paramInt1, paramInt2, paramArrayOfByte, paramChannelCallback);
  }
  
  public void sendWithCmd(int paramInt1, int paramInt2, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback)
  {
    a(String.format("iliveProxyCmd.0x%x_0x%x", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), a(paramArrayOfByte), paramChannelCallback);
  }
  
  public void sendWithNewWay(String paramString, byte[] paramArrayOfByte, int paramInt, ChannelCallback paramChannelCallback) {}
  
  public void sendWithOldWay(String paramString, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback) {}
  
  public void sendWithPrefix(String paramString1, String paramString2, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback)
  {
    a(paramString1 + "." + paramString2, a(paramArrayOfByte), paramChannelCallback);
  }
  
  public void sendWithTRpc(String paramString1, String paramString2, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback)
  {
    a("iliveProxyTrpc." + paramString1 + "-" + paramString2, a(paramArrayOfByte), paramChannelCallback);
  }
  
  public void sendWithTRpc(String paramString, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback)
  {
    a("iliveProxyTrpc." + paramString, a(paramArrayOfByte), paramChannelCallback);
  }
  
  public void setAuthTicket(String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      if (!TextUtils.equals(paramString1, this.a.openId)) {
        QLog.e("MsfChannelService", 1, "setAuthTicket-> Id has changed, oldId=" + this.a.openId + ", newId=" + paramString1);
      }
      this.a.openId = paramString1;
      this.a.access_token = paramString2;
    }
  }
  
  public void setLoginInfo(LoginInfo paramLoginInfo)
  {
    this.a = paramLoginInfo;
    a(paramLoginInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.MsfChannelService
 * JD-Core Version:    0.7.0.1
 */