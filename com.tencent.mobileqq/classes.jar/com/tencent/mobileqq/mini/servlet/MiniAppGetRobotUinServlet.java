package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetRobotUinRsp;
import android.content.Intent;
import android.os.Bundle;
import bdpd;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetRobotUinServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_COMMON_EXT = "key_common_ext";
  public static final String KEY_ROBOT_RESULT_UIN = "key_robot_result_uin";
  private static final String TAG = "MiniAppGetRobotUinServlet";
  
  public MiniAppGetRobotUinServlet()
  {
    this.observerId = 1045;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetRobotUinRsp localStGetRobotUinRsp = new INTERFACE.StGetRobotUinRsp();
    localStGetRobotUinRsp.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = localStGetRobotUinRsp.uin.get();
    if (paramArrayOfByte != null)
    {
      paramBundle.putString("key_robot_result_uin", paramArrayOfByte);
      notifyObserver(paramIntent, 1045, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1045, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_common_ext");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject = null;
    if (arrayOfByte != null) {
      localObject = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte);
      arrayOfByte = new GetRobotUinRequest((COMM.StCommonExt)localObject, paramIntent.getStringExtra("key_app_id")).encode(paramIntent, i, getTraceId());
      localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_info.GetRobotUin");
      paramPacket.putSendData(bdpd.a((byte[])localObject));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MiniAppGetRobotUinServlet", 1, "onSend. StCommonExt mergeFrom exception!", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetRobotUinServlet
 * JD-Core Version:    0.7.0.1
 */