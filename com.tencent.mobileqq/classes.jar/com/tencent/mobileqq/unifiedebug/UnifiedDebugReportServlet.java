package com.tencent.mobileqq.unifiedebug;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class UnifiedDebugReportServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugReportServlet", 2, "onReceive");
    }
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("extra_result_code", paramFromServiceMsg.getResultCode());
      localBundle.putString("extra_cmd", paramIntent.getStringExtra("extra_cmd"));
      localBundle.putByteArray("extra_data", arrayOfByte);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugReportServlet", 2, "onSend");
    }
    Object localObject = paramIntent.getStringExtra("extra_cmd");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return;
      paramIntent = paramIntent.getByteArrayExtra("extra_data");
      paramPacket.setSSOCommand((String)localObject);
    } while (paramIntent == null);
    localObject = new byte[paramIntent.length + 4];
    PkgTools.a((byte[])localObject, 0, paramIntent.length + 4);
    PkgTools.a((byte[])localObject, 4, paramIntent, paramIntent.length);
    paramPacket.putSendData((byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugReportServlet
 * JD-Core Version:    0.7.0.1
 */