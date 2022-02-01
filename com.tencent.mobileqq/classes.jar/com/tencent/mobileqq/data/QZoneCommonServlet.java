package com.tencent.mobileqq.data;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.QzoneExternalRequest;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneCommonServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null) {
      return;
    }
    if (!(paramIntent instanceof QzoneCommonIntent)) {
      return;
    }
    paramIntent = (QzoneCommonIntent)paramIntent;
    paramIntent.getProcessor().a(this, paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if ((paramIntent instanceof QzoneCommonIntent))
    {
      QZoneCommonRequest localQZoneCommonRequest = ((QzoneCommonIntent)paramIntent).getRequest();
      Object localObject = localQZoneCommonRequest.encode();
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(30000L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SQQzoneSvc.");
      ((StringBuilder)localObject).append(localQZoneCommonRequest.uniKey());
      paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QZoneCommonServlet
 * JD-Core Version:    0.7.0.1
 */