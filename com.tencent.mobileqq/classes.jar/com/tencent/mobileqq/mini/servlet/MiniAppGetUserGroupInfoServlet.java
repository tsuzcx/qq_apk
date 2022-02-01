package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserGroupInfoRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetUserGroupInfoServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_EXTRA_JSON_DATA = "extra_json_data";
  public static final String KEY_GROUP_CLASS = "group_class";
  public static final String KEY_GROUP_ID = "group_id";
  public static final String TAG = "MiniAppGetUserGroupInfoServlet";
  
  public MiniAppGetUserGroupInfoServlet()
  {
    this.observerId = 1062;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetUserGroupInfoRsp localStGetUserGroupInfoRsp = new INTERFACE.StGetUserGroupInfoRsp();
    if (paramArrayOfByte != null)
    {
      localStGetUserGroupInfoRsp.mergeFrom(paramArrayOfByte);
      if (localStGetUserGroupInfoRsp.userGroupInfo != null)
      {
        paramBundle.putString("extra_json_data", localStGetUserGroupInfoRsp.userGroupInfo.get());
        notifyObserver(paramIntent, 1062, true, paramBundle, MiniAppObserver.class);
        return;
      }
      notifyObserver(paramIntent, 1062, false, paramBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_appid");
    String str = paramIntent.getStringExtra("group_id");
    long l = paramIntent.getLongExtra("group_class", -1L);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int i = paramIntent.getIntExtra("key_index", -1);
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label68:
      break label68;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MiniAppGetUserGroupInfoServlet", 2, "onSend. mergeFrom extData exception!");
    }
    break label88;
    Object localObject1 = null;
    label88:
    localObject2 = new GetUserGroupInfoRequest((String)localObject2, str, l, (COMM.StCommonExt)localObject1).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetUserGroupInfo");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserGroupInfoServlet
 * JD-Core Version:    0.7.0.1
 */