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
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SendFollowMsg request error ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      QLog.e("MsfChannelService", 1, localStringBuilder.toString());
      paramArrayOfByte = null;
    }
    ((ILiveDelivery)RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO(paramString, paramArrayOfByte, null, -1, new MsfChannelService.2(this, paramChannelCallback));
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ForwardReq localForwardReq = new ForwardReq();
    Object localObject = (AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class);
    localForwardReq.d = ((AppGeneralInfoService)localObject).getClientType();
    localForwardReq.f = paramArrayOfByte;
    localForwardReq.e = ((AppGeneralInfoService)localObject).getVersionName();
    localForwardReq.g = ((AppGeneralInfoService)localObject).getVersionCode();
    localForwardReq.h = 1;
    localForwardReq.p = ((AppGeneralInfoService)localObject).getDeviceID().getBytes();
    if (((AppGeneralInfoService)localObject).isSvrTestEnv()) {
      localForwardReq.n = 2;
    } else {
      localForwardReq.n = 0;
    }
    localObject = this.a;
    paramArrayOfByte = (byte[])localObject;
    if (localObject == null) {
      paramArrayOfByte = a();
    }
    if (paramArrayOfByte != null)
    {
      int i = MsfChannelService.3.a[paramArrayOfByte.loginType.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          localForwardReq.k = 3;
        } else {
          localForwardReq.k = 2;
        }
      }
      else {
        localForwardReq.k = 1;
      }
    }
    else
    {
      localForwardReq.k = 3;
    }
    localForwardReq.q = 37;
    if (paramArrayOfByte != null)
    {
      localForwardReq.a = paramArrayOfByte.uid;
      localForwardReq.c = HexUtil.bytesToHexString(paramArrayOfByte.a2);
      localForwardReq.b = paramArrayOfByte.tinyid;
      if (!TextUtils.isEmpty(paramArrayOfByte.access_token)) {
        localForwardReq.j = paramArrayOfByte.access_token;
      }
      if (!TextUtils.isEmpty(paramArrayOfByte.openId)) {
        localForwardReq.i = paramArrayOfByte.openId;
      }
    }
    return MessageNano.toByteArray(localForwardReq);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    a(localStringBuilder.toString(), a(paramArrayOfByte), paramChannelCallback);
  }
  
  public void sendWithTRpc(String paramString1, String paramString2, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("iliveProxyTrpc.");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString2);
    a(localStringBuilder.toString(), a(paramArrayOfByte), paramChannelCallback);
  }
  
  public void sendWithTRpc(String paramString, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("iliveProxyTrpc.");
    localStringBuilder.append(paramString);
    a(localStringBuilder.toString(), a(paramArrayOfByte), paramChannelCallback);
  }
  
  public void setAuthTicket(String paramString1, String paramString2)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (!TextUtils.equals(paramString1, ((LoginInfo)localObject).openId))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setAuthTicket-> Id has changed, oldId=");
        ((StringBuilder)localObject).append(this.a.openId);
        ((StringBuilder)localObject).append(", newId=");
        ((StringBuilder)localObject).append(paramString1);
        QLog.e("MsfChannelService", 1, ((StringBuilder)localObject).toString());
      }
      localObject = this.a;
      ((LoginInfo)localObject).openId = paramString1;
      ((LoginInfo)localObject).access_token = paramString2;
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