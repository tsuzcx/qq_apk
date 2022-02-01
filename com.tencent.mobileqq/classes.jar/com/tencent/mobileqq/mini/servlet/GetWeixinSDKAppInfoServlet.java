package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetWeixinSDKAppInfoRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.WupUtil;
import mqq.app.Packet;

public class GetWeixinSDKAppInfoServlet
  extends MiniAppAbstractServlet
{
  public static final String TAG = "[mini] GetWeixinSDKAppInfoServlet";
  
  public GetWeixinSDKAppInfoServlet()
  {
    this.observerId = 1092;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetWeixinSDKAppInfoRsp localStGetWeixinSDKAppInfoRsp = new INTERFACE.StGetWeixinSDKAppInfoRsp();
    localStGetWeixinSDKAppInfoRsp.mergeFrom(paramArrayOfByte);
    if (localStGetWeixinSDKAppInfoRsp.appInfo != null)
    {
      paramBundle.putByteArray("mini_app_info_pb_data", paramArrayOfByte);
      notifyObserver(paramIntent, this.observerId, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, this.observerId, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringExtra("key_code");
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new GetWeixinSDKAppInfoRequest((String)localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_weixin_sdk_qrcode.GetWeixinSDKAppInfo");
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetWeixinSDKAppInfoServlet
 * JD-Core Version:    0.7.0.1
 */