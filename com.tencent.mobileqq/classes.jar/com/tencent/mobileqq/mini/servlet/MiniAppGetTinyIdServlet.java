package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StTinyidOpenidPair;
import NS_MINI_INTERFACE.INTERFACE.StTrans4TinyidRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import java.util.List;
import mqq.app.Packet;

public class MiniAppGetTinyIdServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_OPEN_ID = "key_open_id";
  public static final String KEY_TINY_ID = "key_tiny_id";
  public static final String TAG = "MiniAppGetTinyIdServlet";
  
  public MiniAppGetTinyIdServlet()
  {
    this.observerId = 1024;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StTrans4TinyidRsp localStTrans4TinyidRsp = new INTERFACE.StTrans4TinyidRsp();
    localStTrans4TinyidRsp.mergeFrom(paramArrayOfByte);
    if (localStTrans4TinyidRsp.tinyidOpenids.isEmpty())
    {
      notifyObserver(paramIntent, 1036, false, paramBundle, MiniAppObserver.class);
      return;
    }
    paramArrayOfByte = localStTrans4TinyidRsp.tinyidOpenids.get();
    if (paramArrayOfByte.size() == 0)
    {
      notifyObserver(paramIntent, 1036, false, paramBundle, MiniAppObserver.class);
      return;
    }
    paramBundle.putString("key_open_id", ((INTERFACE.StTinyidOpenidPair)paramArrayOfByte.get(0)).openid.get());
    paramBundle.putLong("key_tiny_id", ((INTERFACE.StTinyidOpenidPair)paramArrayOfByte.get(0)).tinyid.get());
    notifyObserver(paramIntent, 1036, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringExtra("key_app_id");
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new GetTinyIdRequest((String)localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_user_info.Trans4Tinyid");
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetTinyIdServlet
 * JD-Core Version:    0.7.0.1
 */