package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StReportLogFileRsp;
import android.content.Intent;
import android.os.Bundle;
import bhuf;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppReportLogFileServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_FILE_SIZE = "key_file_size";
  public static final String KEY_FILE_URL = "key_file_url";
  public static final String TAG = "MiniAppReportLogFileServlet";
  
  public MiniAppReportLogFileServlet()
  {
    this.observerId = 1024;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    new INTERFACE.StReportLogFileRsp().mergeFrom(paramArrayOfByte);
    notifyObserver(paramIntent, 1035, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject2 = paramIntent.getStringExtra("key_app_id");
    String str = paramIntent.getStringExtra("key_file_url");
    int i = paramIntent.getIntExtra("key_file_size", 0);
    int j = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new ReportLogFileRequest((COMM.StCommonExt)localObject1, (String)localObject2, str, i).encode(paramIntent, j, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_info.ReportLogFile");
      paramPacket.putSendData(bhuf.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppReportLogFileServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppReportLogFileServlet
 * JD-Core Version:    0.7.0.1
 */