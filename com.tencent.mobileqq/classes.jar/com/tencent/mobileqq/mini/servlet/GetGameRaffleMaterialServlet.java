package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_RAFFLE.GameRaffleInfo.StGetGameRaffleMaterialRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;
import org.json.JSONObject;

public class GetGameRaffleMaterialServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_RESULT_DATA = "key_result_data";
  public static final String KEY_UIN = "key_uin";
  public static final String TAG = "GetGameRaffleMaterialServlet";
  
  public GetGameRaffleMaterialServlet()
  {
    this.observerId = 1089;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    GameRaffleInfo.StGetGameRaffleMaterialRsp localStGetGameRaffleMaterialRsp = GetGameRaffleMaterialRequest.onResponse(paramArrayOfByte);
    if (localStGetGameRaffleMaterialRsp != null)
    {
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.putOpt("raffleImg", localStGetGameRaffleMaterialRsp.raffleImg.get());
        paramArrayOfByte.putOpt("shareImg", localStGetGameRaffleMaterialRsp.shareImg.get());
        paramArrayOfByte.putOpt("shareBtn", localStGetGameRaffleMaterialRsp.shareBtn.get());
        paramArrayOfByte.putOpt("openedPackImg", localStGetGameRaffleMaterialRsp.openedPackImg.get());
        paramArrayOfByte.putOpt("backBtn", localStGetGameRaffleMaterialRsp.backBtn.get());
        paramArrayOfByte.putOpt("wishingImg", localStGetGameRaffleMaterialRsp.wishingImg.get());
        paramArrayOfByte.putOpt("promotion_id", Integer.valueOf(localStGetGameRaffleMaterialRsp.promotion_id.get()));
        paramArrayOfByte.putOpt("active_id", Integer.valueOf(localStGetGameRaffleMaterialRsp.active_id.get()));
        paramArrayOfByte.putOpt("watchAdBtn", localStGetGameRaffleMaterialRsp.watchAdBtn.get());
        paramBundle.putString("key_result_data", paramArrayOfByte.toString());
        notifyObserver(paramIntent, 1089, true, paramBundle, MiniAppObserver.class);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.i("GetGameRaffleMaterialServlet", 1, "onProcessData", localThrowable);
        }
      }
    }
    notifyObserver(paramIntent, 1089, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringExtra("key_appid");
    paramIntent.getStringExtra("key_uin");
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new GetGameRaffleMaterialRequest((String)localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_game_raffle.GetGameRaffleMaterial");
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetGameRaffleMaterialServlet
 * JD-Core Version:    0.7.0.1
 */