package com.tencent.mobileqq.mini.servlet;

import NS_MINI_REPORT.REPORT.StDcReportRsp;
import NS_MINI_REPORT.REPORT.StGameDcReportRsp;
import NS_MINI_REPORT.REPORT.StThirdDcReportRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bgau;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppDcReportServlet
  extends MiniAppAbstractServlet
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_dcreport.DcReport";
  public static final String CMD_STRING_GAME_CP_REPORT = "LightAppSvc.mini_app_dcreport.GameDcReport";
  public static final String CMD_STRING_MINI_LOG = "MiniLogSvr.mini_app_apireport.DcReport";
  public static final String CMD_STRING_THIRD_PARTY_REPORT = "LightAppSvc.mini_app_dcreport.ThirdDcReport";
  public static final String KEY_CMD = "key_cmd";
  public static final String TAG = "MiniAppDcReportServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if (paramFromServiceMsg == null) {
          continue;
        }
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bgau.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if (!"LightAppSvc.mini_app_dcreport.ThirdDcReport".equals(paramFromServiceMsg.getServiceCmd())) {
          continue;
        }
        localObject = new REPORT.StThirdDcReportRsp();
        ((REPORT.StThirdDcReportRsp)localObject).mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
        i = ((REPORT.StThirdDcReportRsp)localObject).ret.get();
        if (i != 0) {
          continue;
        }
        localBundle.putInt("ret", i);
        notifyObserver(paramIntent, 1005, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        PROTOCAL.StQWebRsp localStQWebRsp;
        Object localObject;
        int i;
        QLog.e("MiniAppDcReportServlet", 1, localThrowable + "onReceive error");
        notifyObserver(paramIntent, 1005, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniAppDcReportServlet", 2, "inform MiniAppGetLoginCodeServlet isSuccess false");
        notifyObserver(paramIntent, 1005, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniAppDcReportServlet", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
        notifyObserver(paramIntent, 1005, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      if ("LightAppSvc.mini_app_dcreport.GameDcReport".equals(paramFromServiceMsg.getServiceCmd()))
      {
        localObject = new REPORT.StGameDcReportRsp();
        ((REPORT.StGameDcReportRsp)localObject).mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
        i = ((REPORT.StGameDcReportRsp)localObject).ret.get();
      }
      else
      {
        localObject = new REPORT.StDcReportRsp();
        ((REPORT.StDcReportRsp)localObject).mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
        i = ((REPORT.StDcReportRsp)localObject).ret.get();
        continue;
        notifyObserver(paramIntent, 1005, false, localBundle, MiniAppObserver.class);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    setShouldPerformDCReport(false);
    Object localObject1 = paramIntent.getByteArrayExtra("key_data");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject2 = new DcReportRequest((byte[])localObject1).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    String str = paramIntent.getStringExtra("key_cmd");
    localObject2 = str;
    if (TextUtils.isEmpty(str)) {
      localObject2 = "LightAppSvc.mini_app_dcreport.DcReport";
    }
    paramPacket.setSSOCommand((String)localObject2);
    paramPacket.putSendData(bgau.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppDcReportServlet
 * JD-Core Version:    0.7.0.1
 */