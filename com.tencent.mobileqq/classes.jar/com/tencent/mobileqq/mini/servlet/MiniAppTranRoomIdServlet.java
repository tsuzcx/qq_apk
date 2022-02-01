package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_MISC.MISC.StTrans4RoomidRsp;
import android.content.Intent;
import android.os.Bundle;
import bgau;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.app.Packet;

public class MiniAppTranRoomIdServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_GROUP_ID = "key_group_id";
  public static final String KEY_OPEN_ID = "key_open_id";
  public static final String KEY_ROOM_ID = "key_room_id";
  public static final String KEY_TINY_ID = "key_tiny_id";
  public static final String TAG = "MiniAppGetTinyIdServlet";
  
  public MiniAppTranRoomIdServlet()
  {
    this.observerId = 1024;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    MISC.StTrans4RoomidRsp localStTrans4RoomidRsp = new MISC.StTrans4RoomidRsp();
    localStTrans4RoomidRsp.mergeFrom(paramArrayOfByte);
    if (paramBundle.getLong("retCode") == 0L)
    {
      paramBundle.putString("key_open_id", localStTrans4RoomidRsp.openid.get());
      paramBundle.putLong("key_tiny_id", localStTrans4RoomidRsp.tinyid.get());
      paramBundle.putInt("key_room_id", localStTrans4RoomidRsp.roomid.get());
      notifyObserver(paramIntent, 1037, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1037, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("key_app_id");
    Object localObject2 = paramIntent.getStringExtra("key_group_id");
    int i = paramIntent.getIntExtra("key_index", -1);
    localObject2 = new GetTransRoomIdRequest((String)localObject1, (String)localObject2).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_misc.Trans4Roomid");
    paramPacket.putSendData(bgau.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet
 * JD-Core Version:    0.7.0.1
 */