package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.WupUtil;
import mqq.app.Packet;

public class MiniAppDataReportServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_CMD = "key_cmd";
  public static final String TAG = "MiniAppDataReportServlet";
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    APP_REPORT_TRANSFER.StDataReportRsp localStDataReportRsp = new APP_REPORT_TRANSFER.StDataReportRsp();
    localStDataReportRsp.mergeFrom(paramArrayOfByte);
    int i = localStDataReportRsp.ret.get();
    if (i == 0)
    {
      notifyObserver(paramIntent, 1005, true, paramBundle, MiniAppObserver.class);
      return;
    }
    paramBundle.putInt("ret", i);
    notifyObserver(paramIntent, 1005, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    setShouldPerformDCReport(false);
    Object localObject = paramIntent.getByteArrayExtra("key_data");
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new DataReportRequest((byte[])localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_report_transfer.DataReport");
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppDataReportServlet
 * JD-Core Version:    0.7.0.1
 */