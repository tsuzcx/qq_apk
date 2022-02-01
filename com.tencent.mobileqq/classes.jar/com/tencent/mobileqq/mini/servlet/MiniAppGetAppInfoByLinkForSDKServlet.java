package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp;
import android.content.Intent;
import android.os.Bundle;
import bgau;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import mqq.app.Packet;

public class MiniAppGetAppInfoByLinkForSDKServlet
  extends MiniAppAbstractServlet
{
  public static final String TAG = "[mini] MiniAppGetAppInfoByLinkForSDKServlet";
  
  public MiniAppGetAppInfoByLinkForSDKServlet()
  {
    this.observerId = 1056;
  }
  
  private void savaMiniAppInfo(Intent paramIntent, INTERFACE.StGetAppInfoByLinkRsp paramStGetAppInfoByLinkRsp)
  {
    ThreadManagerV2.excute(new MiniAppGetAppInfoByLinkForSDKServlet.1(this, paramIntent, paramStGetAppInfoByLinkRsp), 32, null, true);
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetAppInfoByLinkRsp();
    ((INTERFACE.StGetAppInfoByLinkRsp)localObject).mergeFrom(paramArrayOfByte);
    if (((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo != null)
    {
      if (((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo.type.get() == 3) {
        savaMiniAppInfo(paramIntent, (INTERFACE.StGetAppInfoByLinkRsp)localObject);
      }
      paramArrayOfByte = MiniAppInfo.from(((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo);
      localObject = ((INTERFACE.StGetAppInfoByLinkRsp)localObject).shareTicket.get();
      paramBundle.putParcelable("mini_app_info_data", paramArrayOfByte);
      paramBundle.putString("shareTicket", (String)localObject);
      QLog.i("[mini] MiniAppGetAppInfoByLinkForSDKServlet", 1, "[MiniEng]" + paramArrayOfByte.downloadUrl + "," + paramArrayOfByte.fileSize);
      notifyObserver(paramIntent, this.observerId, true, paramBundle, MiniAppObserver.class);
      return;
    }
    QLog.i("[mini] MiniAppGetAppInfoByLinkForSDKServlet", 1, "[MiniEng]inform MiniAppGetAppInfoByLinkServlet result.appInfo==null");
    notifyObserver(paramIntent, this.observerId, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringExtra("key_link");
    int i = paramIntent.getIntExtra("key_link_type", 0);
    paramIntent.getLongExtra("key_uin", 0L);
    int j = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new GetAppInfoByLinkRequest((String)localObject, i).encode(paramIntent, j, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_info.GetAppInfoByLink");
    paramPacket.putSendData(bgau.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByLinkForSDKServlet
 * JD-Core Version:    0.7.0.1
 */