package com.tencent.mobileqq.imaxad;

import android.content.Intent;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ImaxAdReportServlet
  extends MSFServlet
{
  private byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    PkgTools.dWord2Byte(arrayOfByte, 0, paramArrayOfByte.length + 4);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "MQInference.IMaxADReport" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(paramFromServiceMsg.isSuccess());
      paramIntent.append(" onReceive with code: ");
      paramIntent.append(paramFromServiceMsg.getResultCode());
      QLog.d("Imax.ImaxAdReportServlet", 2, paramIntent.toString());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("ImaxAdReportServletCMD");
    paramPacket.setSSOCommand(str);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend with cmd: ");
      localStringBuilder.append(str);
      QLog.d("Imax.ImaxAdReportServlet", 2, localStringBuilder.toString());
    }
    paramIntent = paramIntent.getByteArrayExtra("ImaxAdReportServletRequestBytes");
    if (paramIntent != null) {
      paramPacket.putSendData(a(paramIntent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdReportServlet
 * JD-Core Version:    0.7.0.1
 */