package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StContentAccelerateRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.app.PreCacheManager.ContentAccelerateRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.Packet;

public class MiniAppContentAccelerateServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_DATA_URL = "key_dataurl";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_NEED_CODE = "key_need_code";
  public static final String KEY_REQ_HEADER = "mini_req_header";
  public static final String KEY_RSP_DATA = "mini_rsp_data";
  public static final String TAG = "MiniAppContentAccelerateServlet";
  
  public MiniAppContentAccelerateServlet()
  {
    this.observerId = 1070;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StContentAccelerateRsp localStContentAccelerateRsp = new INTERFACE.StContentAccelerateRsp();
    localStContentAccelerateRsp.mergeFrom(paramArrayOfByte);
    if ((localStContentAccelerateRsp.cacheData.get() != null) && (localStContentAccelerateRsp.cacheData.get().size() > 0))
    {
      paramArrayOfByte = new PreCacheManager.ContentAccelerateRsp();
      paramArrayOfByte.rspHeaders = localStContentAccelerateRsp.rspHeaders.get();
      paramArrayOfByte.cacheData = localStContentAccelerateRsp.cacheData.get().toByteArray();
      paramArrayOfByte.httpReturnCode = localStContentAccelerateRsp.httpReturnCode.get();
      paramBundle.putParcelable("mini_rsp_data", paramArrayOfByte);
      notifyObserver(paramIntent, 1070, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1070, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject2 = paramIntent.getStringExtra("key_app_id");
    String str = paramIntent.getStringExtra("key_dataurl");
    int i = paramIntent.getIntExtra("key_need_code", 0);
    Map localMap = (Map)paramIntent.getSerializableExtra("mini_req_header");
    int j = paramIntent.getIntExtra("key_index", -1);
    if (arrayOfByte != null)
    {
      localObject1 = new COMM.StCommonExt();
      try
      {
        ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppContentAccelerateServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = new ContentAccelerateRequest((COMM.StCommonExt)localObject1, (String)localObject2, str, i, localMap).encode(paramIntent, j, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_accelerate_proxy.ContentAccelerate");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppContentAccelerateServlet
 * JD-Core Version:    0.7.0.1
 */