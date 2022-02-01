package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneAlbumRedTouchServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null)
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("resultcode:");
        paramIntent.append(paramFromServiceMsg.getResultCode());
        paramIntent.append(",failMsg:");
        paramIntent.append(paramFromServiceMsg.getBusinessFailMsg());
        QLog.d("QzoneAlbumRedDotServlet", 2, paramIntent.toString());
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedDotServlet", 2, "fromServiceMsg==msg");
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getSerializableExtra("req");
    if ((paramIntent != null) && ((paramIntent instanceof operation_red_touch_req)))
    {
      QzoneAlbumRedTouchRequest localQzoneAlbumRedTouchRequest = new QzoneAlbumRedTouchRequest(getAppRuntime().getLongAccountUin(), (operation_red_touch_req)paramIntent);
      Object localObject = localQzoneAlbumRedTouchRequest.encode();
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SQQzoneSvc.");
      ((StringBuilder)localObject).append(localQzoneAlbumRedTouchRequest.uniKey());
      paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchServlet
 * JD-Core Version:    0.7.0.1
 */