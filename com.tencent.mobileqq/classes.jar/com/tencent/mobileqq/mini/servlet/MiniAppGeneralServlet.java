package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bhjl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGeneralServlet
  extends MiniAppAbstractServlet
{
  public static final String DATA_REPORT_CMD_STRING = "LightAppSvc.mini_app_report_transfer.DataReport";
  public static final int ERR_MSF_EXCEPTION = -1000001;
  public static final int ERR_MSF_FAIL = -1000000;
  public static final String TAG = "MiniAppGetLoginCodeServlet";
  
  public MiniAppGeneralServlet()
  {
    this.observerId = 9000;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramFromServiceMsg = bhjl.b(paramFromServiceMsg.getWupBuffer());
          localBundle.putLong("retCode", 0L);
          localBundle.putString("errMsg", "");
          localBundle.putByteArray("key_response_data", paramFromServiceMsg);
          notifyObserver(paramIntent, this.observerId, true, localBundle, MiniAppObserver.class);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppGetLoginCodeServlet", 2, "onReceive. " + MiniAppObserver.getCmdByObserverId(this.observerId) + " failed: " + paramFromServiceMsg.getBusinessFailCode() + "  errMsg:" + paramFromServiceMsg.getBusinessFailMsg());
        }
        localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
        localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.e("MiniAppGetLoginCodeServlet", 1, "onReceive error", paramFromServiceMsg);
      localBundle.putLong("retCode", -1000001L);
      localBundle.putString("errMsg", "onReceive exception");
      notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppGetLoginCodeServlet", 2, "onReceive. inform  resultcode fail.");
    }
    localBundle.putLong("retCode", -1000000L);
    localBundle.putString("errMsg", "msf response fail.");
    notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_request_data");
    String str1 = paramIntent.getStringExtra("key_cmd_string");
    if (str1.equals("LightAppSvc.mini_app_report_transfer.DataReport")) {
      setShouldPerformDCReport(false);
    }
    String str2 = getTraceId();
    if (arrayOfByte == null) {
      throw new RuntimeException("req data is null!");
    }
    if (TextUtils.isEmpty(str1)) {
      throw new RuntimeException("cmd_string is null!");
    }
    Object localObject = new APP_REPORT_TRANSFER.StDataReportReq();
    try
    {
      ((APP_REPORT_TRANSFER.StDataReportReq)localObject).mergeFrom(arrayOfByte);
      QLog.e("MiniAppGetLoginCodeServlet", 2, "wesley test, dc: " + ((APP_REPORT_TRANSFER.StDataReportReq)localObject).dcdata.get());
      label124:
      localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = new byte[4];
      }
      QLog.e("MiniAppGetLoginCodeServlet", 2, "wesley: cmdString:" + str1 + "  traceId:" + str2);
      paramPacket.setSSOCommand(str1);
      paramPacket.putSendData(bhjl.a((byte[])localObject));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (Exception localException)
    {
      break label124;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGeneralServlet
 * JD-Core Version:    0.7.0.1
 */