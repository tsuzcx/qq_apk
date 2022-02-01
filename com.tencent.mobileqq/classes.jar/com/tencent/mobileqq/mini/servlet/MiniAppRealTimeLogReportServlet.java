package com.tencent.mobileqq.mini.servlet;

import NS_MINI_REALTIMELOG.REALTIMELOG.StReportLogRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.WupUtil;
import java.util.ArrayList;
import mqq.app.Packet;

public class MiniAppRealTimeLogReportServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_FILTER_MSG = "key_filter_msg";
  public static final String KEY_JSLIB_VERSION = "key_jslib_version";
  public static final String KEY_LOG_ITEMS = "key_log_items";
  public static final String KEY_PAGE = "key_page";
  public static final String TAG = "[mini] MiniAppRealTimeLogReportServlet";
  
  public MiniAppRealTimeLogReportServlet()
  {
    this.observerId = 1075;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    new REALTIMELOG.StReportLogRsp().mergeFrom(paramArrayOfByte);
    notifyObserver(paramIntent, this.observerId, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("key_page");
    Object localObject2 = paramIntent.getStringArrayExtra("key_filter_msg");
    ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("key_log_items");
    String str1 = paramIntent.getStringExtra("key_jslib_version");
    String str2 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_index", -1);
    localObject2 = new RealTimeLogReportRequest((String)localObject1, str1, str2, (String[])localObject2, localArrayList).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_log_report.ReportLog");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppRealTimeLogReportServlet
 * JD-Core Version:    0.7.0.1
 */