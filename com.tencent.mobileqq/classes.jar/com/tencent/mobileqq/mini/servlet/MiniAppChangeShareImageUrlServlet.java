package com.tencent.mobileqq.mini.servlet;

import NS_MINI_SHARE.MiniProgramShare.StAdaptSharePicRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import bdpd;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.Packet;

public class MiniAppChangeShareImageUrlServlet
  extends MiniAppAbstractServlet
{
  private static final String CMD_STRING = "LightAppSvc.mini_app_share.AdaptSharePic";
  public static final String KEY_OLD_IMAGE_URL = "key_old_image_url";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
    PROTOCAL.StQWebRsp localStQWebRsp;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      localStQWebRsp = new PROTOCAL.StQWebRsp();
    }
    for (;;)
    {
      try
      {
        localStQWebRsp.mergeFrom(bdpd.b(paramFromServiceMsg.getWupBuffer()));
        MiniProgramShare.StAdaptSharePicRsp localStAdaptSharePicRsp = new MiniProgramShare.StAdaptSharePicRsp();
        localStAdaptSharePicRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        localBundle.putString("imageUrl", localStAdaptSharePicRsp.picUrl.get());
        notifyObserver(paramIntent, 1029, true, localBundle, MiniAppObserver.class);
        doReport(paramIntent, paramFromServiceMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        notifyObserver(paramIntent, 1029, false, localBundle, MiniAppObserver.class);
        continue;
      }
      notifyObserver(paramIntent, 1029, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = new MiniAppChangeShareImageUrlServlet.1(this, paramIntent).encode(paramIntent, paramIntent.getIntExtra("key_index", -1), getTraceId());
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_share.AdaptSharePic");
    paramPacket.putSendData(bdpd.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppChangeShareImageUrlServlet
 * JD-Core Version:    0.7.0.1
 */