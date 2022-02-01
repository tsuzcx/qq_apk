package com.tencent.mobileqq.mini.servlet;

import NS_STORE_APP_CLIENT.MiniAppStore.StGetFirstPageByTypeRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.WupUtil;
import mqq.app.Packet;
import org.json.JSONArray;

public class MiniAppStoreGetAppListServlet
  extends MiniAppAbstractServlet
{
  private static final String CMD_STRING = "LightAppSvc.store_app_client.GetFirstPageByType";
  
  public MiniAppStoreGetAppListServlet()
  {
    this.observerId = 1022;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    MiniAppStore.StGetFirstPageByTypeRsp localStGetFirstPageByTypeRsp = new MiniAppStore.StGetFirstPageByTypeRsp();
    localStGetFirstPageByTypeRsp.mergeFrom(paramArrayOfByte);
    paramBundle.putString("data", JSONConverter.a(localStGetFirstPageByTypeRsp.vecAppInfo.get()).toString());
    notifyObserver(paramIntent, 1022, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = new MiniAppStoreGetAppListServlet.1(this, paramIntent).encode(paramIntent, paramIntent.getIntExtra("key_index", -1), getTraceId());
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.store_app_client.GetFirstPageByType");
    paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppStoreGetAppListServlet
 * JD-Core Version:    0.7.0.1
 */