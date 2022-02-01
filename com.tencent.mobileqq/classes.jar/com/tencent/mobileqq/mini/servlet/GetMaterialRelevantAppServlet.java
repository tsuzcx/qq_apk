package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.WupUtil;
import mqq.app.Packet;

public class GetMaterialRelevantAppServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_EXTRA_INFO = "key_extra_info";
  public static final String KEY_MIME_TYPE = "key_mime_type";
  
  public GetMaterialRelevantAppServlet()
  {
    this.observerId = 1031;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    super.onProcessData(paramIntent, paramBundle, paramArrayOfByte);
    paramBundle.putByteArray("key_response_data", paramArrayOfByte);
    notifyObserver(paramIntent, this.observerId, true, paramBundle, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = new GetMaterialRelevantAppRequest(paramIntent.getStringExtra("key_mime_type"), paramIntent.getStringExtra("key_extra_info")).encode(paramIntent, MiniAppCmdUtil.getReqSeqIndex(), getTraceId());
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("miniapp.Openmaterial.GetMaterialRelevantApp");
    paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetMaterialRelevantAppServlet
 * JD-Core Version:    0.7.0.1
 */