package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppTopRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppSetUserAppTopServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_EXTENDINFO = "key_extendinfo";
  public static final String KEY_FROM_NEW_DOWNLOAD = "key_from_new_download";
  public static final String KEY_NEW_INDEX = "key_new_index";
  public static final String KEY_OLD_INDEX = "key_old_index";
  public static final String KEY_TOP_TYPE = "key_top_type";
  public static final String KEY_VERSION_TYPE = "key_version_type";
  public static final String TAG = "MiniAppSetUserAppTopServlet";
  
  public MiniAppSetUserAppTopServlet()
  {
    this.observerId = 1007;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StSetUserAppTopRsp localStSetUserAppTopRsp = new INTERFACE.StSetUserAppTopRsp();
    localStSetUserAppTopRsp.mergeFrom(paramArrayOfByte);
    long l = paramBundle.getLong("retCode");
    paramArrayOfByte = paramBundle.getString("errMsg");
    if ((l == 0L) && (localStSetUserAppTopRsp.extInfo != null))
    {
      paramBundle.putByteArray("key_extendinfo", localStSetUserAppTopRsp.extInfo.toByteArray());
      notifyObserver(paramIntent, 1007, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1007, false, paramBundle, MiniAppObserver.class);
    paramIntent = new StringBuilder();
    paramIntent.append("MiniAppSetUserAppTopServlet retCode : ");
    paramIntent.append(l);
    paramIntent.append("; errMsg : ");
    paramIntent.append(paramArrayOfByte);
    QLog.e("MiniAppSetUserAppTopServlet", 1, paramIntent.toString());
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_top_type", 0);
    int j = paramIntent.getIntExtra("key_version_type", 3);
    int k = paramIntent.getIntExtra("key_old_index", 0);
    int m = paramIntent.getIntExtra("key_new_index", 0);
    int n = paramIntent.getIntExtra("key_from_new_download", 0);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int i1 = paramIntent.getIntExtra("key_index", -1);
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
          QLog.e("MiniAppSetUserAppTopServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = new SetUserAppTopRequest((COMM.StCommonExt)localObject1, (String)localObject2, i, j, k, m, n).encode(paramIntent, i1, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.SetUserAppTop");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSend. intent: ");
      ((StringBuilder)localObject1).append(paramIntent.toString());
      QLog.d("MiniAppSetUserAppTopServlet", 2, ((StringBuilder)localObject1).toString());
    }
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSetUserAppTopServlet
 * JD-Core Version:    0.7.0.1
 */