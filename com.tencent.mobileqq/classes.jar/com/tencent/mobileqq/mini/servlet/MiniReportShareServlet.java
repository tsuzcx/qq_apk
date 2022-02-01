package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StReportShareRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniReportShareServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_APP_TYPE = "key_app_type";
  public static final String KEY_DEST_ID = "key_dest_id";
  public static final String KEY_DEST_TYPE = "key_dest_type";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_REPORT_TIME = "key_report_time";
  public static final String KEY_SHARE_SCENE = "key_share_scene";
  public static final String KEY_SHARE_TYPE = "key_share_type";
  public static final String TAG = "MiniReportShareServlet";
  private int index;
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    new INTERFACE.StReportShareRsp().mergeFrom(paramArrayOfByte);
    notifyObserver(paramIntent, 1063, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.index = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    long l = paramIntent.getLongExtra("key_report_time", 0L);
    Object localObject1 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_app_type", 0);
    int j = paramIntent.getIntExtra("key_share_scene", 0);
    int k = paramIntent.getIntExtra("key_share_type", 0);
    int m = paramIntent.getIntExtra("key_dest_type", 0);
    Object localObject2 = paramIntent.getStringExtra("key_dest_id");
    COMM.StCommonExt localStCommonExt;
    if (arrayOfByte != null) {
      localStCommonExt = new COMM.StCommonExt();
    }
    try
    {
      localStCommonExt.mergeFrom(arrayOfByte);
      localObject2 = new ReportShareRequest(l, (String)localObject1, i, j, k, m, (String)localObject2).encode(paramIntent, this.index, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_usr_time.ReportShare");
      paramPacket.putSendData(WupUtil.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniReportShareServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniReportShareServlet
 * JD-Core Version:    0.7.0.1
 */