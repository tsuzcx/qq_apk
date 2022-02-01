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
    boolean bool = paramFromServiceMsg.isSuccess();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive:--success=");
      ((StringBuilder)localObject2).append(bool);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new Bundle();
    int k = 0;
    int m = 0;
    int i;
    try
    {
      paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg.clear();
      localObject2 = new byte[paramFromServiceMsg.getInt() - 4];
      paramFromServiceMsg.get((byte[])localObject2);
      paramFromServiceMsg = ByteBuffer.wrap(((oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject2)).bytes_bodybuffer.get().toByteArray());
      i = m;
      if (paramFromServiceMsg.get() == 0)
      {
        paramFromServiceMsg.getInt();
        int n = paramFromServiceMsg.getShort();
        int j = 0;
        for (;;)
        {
          i = m;
          if (j >= n) {
            break label203;
          }
          if (paramFromServiceMsg.getShort() == 5) {
            break;
          }
          i = paramFromServiceMsg.getShort();
          paramFromServiceMsg.position(paramFromServiceMsg.position() + i);
          j += 1;
        }
        paramFromServiceMsg.getShort();
        i = paramFromServiceMsg.getShort();
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      label203:
      paramFromServiceMsg.printStackTrace();
      bool = false;
      i = k;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive:--speed=");
      ((StringBuilder)localObject2).append(i);
      QLog.d(paramFromServiceMsg, 2, ((StringBuilder)localObject2).toString());
    }
    ((Bundle)localObject1).putInt("key_qqlevelacc", i);
    notifyObserver(paramIntent, 1, bool, (Bundle)localObject1, QQLevelACCObserver.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QQLevelACCServlet
 * JD-Core Version:    0.7.0.1
 */