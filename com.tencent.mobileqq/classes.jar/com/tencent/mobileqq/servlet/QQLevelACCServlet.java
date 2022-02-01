package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.observer.QQLevelACCObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QQLevelACCServlet
  extends MSFServlet
{
  private static String a = "QQLevelACCServlet";
  
  byte[] a(long paramLong)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2086);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.putInt((int)paramLong);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    bool = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onReceive:--success=" + bool);
    }
    Bundle localBundle = new Bundle();
    try
    {
      paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg.clear();
      byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
      paramFromServiceMsg.get(arrayOfByte);
      paramFromServiceMsg = ByteBuffer.wrap(((oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(arrayOfByte)).bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg.get() != 0) {
        break label237;
      }
      paramFromServiceMsg.getInt();
      int j = paramFromServiceMsg.getShort();
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label237;
        }
        if (paramFromServiceMsg.getShort() == 5) {
          break;
        }
        paramFromServiceMsg.position(paramFromServiceMsg.getShort() + paramFromServiceMsg.position());
        i += 1;
      }
      paramFromServiceMsg.getShort();
      i = paramFromServiceMsg.getShort();
    }
    catch (Exception paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        int i = 0;
        bool = false;
        continue;
        i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onReceive:--speed=" + i);
    }
    localBundle.putInt("key_qqlevelacc", i);
    notifyObserver(paramIntent, 1, bool, localBundle, QQLevelACCObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket.putSendData(a(Long.parseLong(paramIntent.getStringExtra("k_uin"))));
    paramPacket.setSSOCommand("OidbSvc.0x826_0");
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "--onSend--");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QQLevelACCServlet
 * JD-Core Version:    0.7.0.1
 */