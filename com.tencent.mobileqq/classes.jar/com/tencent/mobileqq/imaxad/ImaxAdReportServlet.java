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
    PkgTools.a(arrayOfByte, 0, paramArrayOfByte.length + 4);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "MQInference.IMaxADReport" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Imax.ImaxAdReportServlet", 2, paramFromServiceMsg.isSuccess() + " onReceive with code: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      String str = paramIntent.getStringExtra("ImaxAdReportServletCMD");
      paramPacket.setSSOCommand(str);
      if (QLog.isColorLevel()) {
        QLog.d("Imax.ImaxAdReportServlet", 2, "onSend with cmd: " + str);
      }
      paramIntent = paramIntent.getByteArrayExtra("ImaxAdReportServletRequestBytes");
    } while (paramIntent == null);
    paramPacket.putSendData(a(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdReportServlet
 * JD-Core Version:    0.7.0.1
 */