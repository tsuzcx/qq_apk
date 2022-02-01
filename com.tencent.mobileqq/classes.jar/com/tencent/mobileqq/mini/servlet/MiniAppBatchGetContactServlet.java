package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StBatchGetContactRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.utils.WupUtil;
import mqq.app.Packet;

public class MiniAppBatchGetContactServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_IDS = "key_app_ids";
  public static final String KEY_CONTACT_LIST = "contact_list";
  public static final String TAG = "MiniAppBatchGetContactServlet";
  
  public MiniAppBatchGetContactServlet()
  {
    this.observerId = 1039;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StBatchGetContactRsp localStBatchGetContactRsp = new INTERFACE.StBatchGetContactRsp();
    localStBatchGetContactRsp.mergeFrom(paramArrayOfByte);
    if (paramBundle.getLong("retCode") == 0L)
    {
      paramArrayOfByte = GdtJsonPbUtil.a(localStBatchGetContactRsp);
      if (paramArrayOfByte != null) {
        paramBundle.putString("contact_list", paramArrayOfByte.toString());
      }
      notifyObserver(paramIntent, 1039, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1039, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte2 = new BatchGetContactRequest(paramIntent.getStringArrayListExtra("key_app_ids")).encode(paramIntent, i, getTraceId());
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_info.BatchGetContact");
    paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppBatchGetContactServlet
 * JD-Core Version:    0.7.0.1
 */