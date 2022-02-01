package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GProServlet
  extends MSFServlet
{
  private int a(FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    paramBundle.putByteArray("bytes_bodybuffer", WupUtil.b(paramFromServiceMsg.getWupBuffer()));
    paramBundle.putString("data_error_msg", "");
    return 0;
  }
  
  private int b(FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
      paramFromServiceMsg = (FromServiceMsg)localObject;
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
    {
      int i = paramFromServiceMsg.uint32_result.get();
      if (i == 0)
      {
        if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
          paramBundle.putByteArray("bytes_bodybuffer", paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        } else {
          GProLog.b("GProServlet", false, "network", "onReceive error: result is 0, but pkg is error");
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive error: result is ");
        ((StringBuilder)localObject).append(i);
        GProLog.b("GProServlet", false, "network", ((StringBuilder)localObject).toString());
      }
      paramBundle.putString("data_error_msg", paramFromServiceMsg.str_error_msg.get());
      return i;
    }
    GProLog.b("GProServlet", false, "network", "onReceive error: response.getResultCode()  is ok, but buff is null");
    paramBundle.putString("data_error_msg", "出错了，请稍后再试。");
    return -91;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive cmd=");
    ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
    GProLog.b("GProServlet", false, "network", ((StringBuilder)localObject).toString());
    localObject = paramIntent.getExtras();
    int i = ((Bundle)localObject).getInt("type", 0);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      if (i == 1) {
        i = a(paramFromServiceMsg, (Bundle)localObject);
      } else {
        i = b(paramFromServiceMsg, (Bundle)localObject);
      }
    }
    else
    {
      i = -92;
      ((Bundle)localObject).putString("data_error_msg", "出错了，请稍后再试。");
      GProLog.b("GProServlet", false, "network", "onReceive error: response.getResultCode() is not ok!");
    }
    ((Bundle)localObject).putInt("result", i);
    notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSend cmd= ");
    ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
    GProLog.b("GProServlet", false, "network", ((StringBuilder)localObject).toString());
    localObject = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProServlet
 * JD-Core Version:    0.7.0.1
 */