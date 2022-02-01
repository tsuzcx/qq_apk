package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.WupUtil;
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
          paramFromServiceMsg = WupUtil.b(paramFromServiceMsg.getWupBuffer());
          localBundle.putLong("retCode", 0L);
          localBundle.putString("errMsg", "");
          localBundle.putByteArray("key_response_data", paramFromServiceMsg);
          notifyObserver(paramIntent, this.observerId, true, localBundle, MiniAppObserver.class);
          return;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onReceive. ");
          localStringBuilder.append(MiniAppObserver.getCmdByObserverId(this.observerId));
          localStringBuilder.append(" failed: ");
          localStringBuilder.append(paramFromServiceMsg.getBusinessFailCode());
          localStringBuilder.append("  errMsg:");
          localStringBuilder.append(paramFromServiceMsg.getBusinessFailMsg());
          QLog.d("MiniAppGetLoginCodeServlet", 2, localStringBuilder.toString());
        }
        localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
        localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppGetLoginCodeServlet", 2, "onReceive. inform  resultcode fail.");
      }
      localBundle.putLong("retCode", -1000000L);
      localBundle.putString("errMsg", "msf response fail.");
      notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
      return;
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.e("MiniAppGetLoginCodeServlet", 1, "onReceive error", paramFromServiceMsg);
      localBundle.putLong("retCode", -1000001L);
      localBundle.putString("errMsg", "onReceive exception");
      notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent.getIntExtra("key_index", -1);
    Object localObject2 = paramIntent.getByteArrayExtra("key_request_data");
    String str1 = paramIntent.getStringExtra("key_cmd_string");
    if (str1.equals("LightAppSvc.mini_app_report_transfer.DataReport")) {
      setShouldPerformDCReport(false);
    }
    String str2 = getTraceId();
    if (localObject2 != null)
    {
      if (!TextUtils.isEmpty(str1))
      {
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new byte[4];
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" cmdString:");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append("  traceId:");
        ((StringBuilder)localObject2).append(str2);
        QLog.e("MiniAppGetLoginCodeServlet", 2, ((StringBuilder)localObject2).toString());
        paramPacket.setSSOCommand(str1);
        paramPacket.putSendData(WupUtil.a((byte[])localObject1));
        paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
        super.onSend(paramIntent, paramPacket);
        return;
      }
      throw new RuntimeException("cmd_string is null!");
    }
    throw new RuntimeException("req data is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGeneralServlet
 * JD-Core Version:    0.7.0.1
 */