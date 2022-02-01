package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_RAFFLE.GameRaffleInfo.Pack;
import NS_MINI_GAME_RAFFLE.GameRaffleInfo.StDoGameRaffleRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;
import org.json.JSONObject;

public class DoGameRaffleServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_RESULT_DATA = "key_result_data";
  public static final String KEY_UIN = "key_uin";
  public static final String TAG = "GetGameRaffleMaterialServlet";
  
  public DoGameRaffleServlet()
  {
    this.observerId = 1090;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Object localObject = DoGameRaffleRequest.onResponse(paramArrayOfByte);
    if (localObject != null)
    {
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.putOpt("state", Integer.valueOf(((GameRaffleInfo.StDoGameRaffleRsp)localObject).state.get()));
        paramArrayOfByte.putOpt("onlinePrizeImg", ((GameRaffleInfo.StDoGameRaffleRsp)localObject).onlinePrizeImg.get());
        paramArrayOfByte.putOpt("active_id", Integer.valueOf(((GameRaffleInfo.StDoGameRaffleRsp)localObject).active_id.get()));
      }
      catch (Throwable localThrowable2)
      {
        QLog.i("GetGameRaffleMaterialServlet", 1, "onProcessData", localThrowable2);
      }
      localObject = (GameRaffleInfo.Pack)((GameRaffleInfo.StDoGameRaffleRsp)localObject).pack.get();
      if (localObject != null)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.putOpt("pack_id", ((GameRaffleInfo.Pack)localObject).pack_id.get());
          localJSONObject.putOpt("state", Integer.valueOf(((GameRaffleInfo.Pack)localObject).state.get()));
          localJSONObject.putOpt("type", Integer.valueOf(((GameRaffleInfo.Pack)localObject).type.get()));
          localJSONObject.putOpt("ctime", Integer.valueOf(((GameRaffleInfo.Pack)localObject).ctime.get()));
          localJSONObject.putOpt("money", Integer.valueOf(((GameRaffleInfo.Pack)localObject).money.get()));
          localJSONObject.putOpt("business_id", Integer.valueOf(((GameRaffleInfo.Pack)localObject).business_id.get()));
          localJSONObject.putOpt("signature", ((GameRaffleInfo.Pack)localObject).signature.get());
          localJSONObject.putOpt("url", ((GameRaffleInfo.Pack)localObject).url.get());
          localJSONObject.putOpt("mtime", Integer.valueOf(((GameRaffleInfo.Pack)localObject).mtime.get()));
          localJSONObject.putOpt("order", ((GameRaffleInfo.Pack)localObject).order.get());
          localJSONObject.putOpt("uin", Long.valueOf(((GameRaffleInfo.Pack)localObject).uin.get()));
          localJSONObject.putOpt("send_uin", Long.valueOf(((GameRaffleInfo.Pack)localObject).send_uin.get()));
          localJSONObject.putOpt("wishing", ((GameRaffleInfo.Pack)localObject).wishing.get());
          localJSONObject.putOpt("promotion_id", Integer.valueOf(((GameRaffleInfo.Pack)localObject).promotion_id.get()));
          localJSONObject.putOpt("req_id", ((GameRaffleInfo.Pack)localObject).req_id.get());
          localJSONObject.putOpt("business_name", ((GameRaffleInfo.Pack)localObject).business_name.get());
          localJSONObject.putOpt("business_logo", ((GameRaffleInfo.Pack)localObject).business_logo.get());
          localJSONObject.putOpt("business_cover", ((GameRaffleInfo.Pack)localObject).business_cover.get());
          localJSONObject.putOpt("business_video_cover", ((GameRaffleInfo.Pack)localObject).business_video_cover.get());
          localJSONObject.putOpt("business_video", ((GameRaffleInfo.Pack)localObject).business_video.get());
          localJSONObject.putOpt("business_name_pic", ((GameRaffleInfo.Pack)localObject).business_name_pic.get());
          paramArrayOfByte.putOpt("pack", localJSONObject);
        }
        catch (Throwable localThrowable1)
        {
          QLog.i("GetGameRaffleMaterialServlet", 1, "onProcessData", localThrowable1);
        }
      }
      paramBundle.putString("key_result_data", paramArrayOfByte.toString());
      notifyObserver(paramIntent, 1090, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1090, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("key_appid");
    Object localObject2 = paramIntent.getStringExtra("key_uin");
    int i = paramIntent.getIntExtra("key_index", -1);
    localObject2 = new DoGameRaffleRequest((String)localObject1, (String)localObject2).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_game_raffle.DoGameRaffle");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.DoGameRaffleServlet
 * JD-Core Version:    0.7.0.1
 */