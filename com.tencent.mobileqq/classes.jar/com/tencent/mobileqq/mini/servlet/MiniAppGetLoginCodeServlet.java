package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetCodeRsp;
import android.content.Intent;
import android.os.Bundle;
import bhuf;
import com.tencent.mobileqq.pb.PBStringField;
import mqq.app.Packet;

public class MiniAppGetLoginCodeServlet
  extends MiniAppAbstractServlet
{
  public static final String TAG = "MiniAppGetLoginCodeServlet";
  
  public MiniAppGetLoginCodeServlet()
  {
    this.observerId = 1000;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetCodeRsp localStGetCodeRsp = new INTERFACE.StGetCodeRsp();
    localStGetCodeRsp.mergeFrom(paramArrayOfByte);
    if (localStGetCodeRsp.code != null)
    {
      paramBundle.putString("code", localStGetCodeRsp.code.get());
      notifyObserver(paramIntent, 1000, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1000, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new GetLoginCodeRequest((String)localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_program_auth.GetCode");
    paramPacket.putSendData(bhuf.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetLoginCodeServlet
 * JD-Core Version:    0.7.0.1
 */