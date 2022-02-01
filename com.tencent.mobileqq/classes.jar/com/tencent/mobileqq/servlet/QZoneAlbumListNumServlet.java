package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.album.QZonePhotoObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneGetAlbumListNumRequest;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneAlbumListNumServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = QZoneGetAlbumListNumRequest.onResponse(paramFromServiceMsg.getWupBuffer());
      if (paramIntent != null)
      {
        paramFromServiceMsg = new Bundle();
        paramFromServiceMsg.putSerializable("data", paramIntent);
        notifyObserver(null, 1002, true, paramFromServiceMsg, QZonePhotoObserver.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneAlbumListNumServlet", 2, "inform QZoneAlbumListNumServlet isSuccess false");
      }
      notifyObserver(null, 1002, false, new Bundle(), QZonePhotoObserver.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneAlbumListNumServlet", 2, "inform QZoneAlbumListNumServlet resultcode fail.");
    }
    notifyObserver(null, 1002, false, new Bundle(), QZonePhotoObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject = new QZoneGetAlbumListNumRequest(paramIntent.getLongExtra("selfuin", 0L), paramIntent.getStringExtra("refer")).encode();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append("getAlbumListNum");
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneAlbumListNumServlet
 * JD-Core Version:    0.7.0.1
 */