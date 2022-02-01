package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_RAFFLE.GameRaffleInfo.StGetGameRaffleMaterialReq;
import NS_MINI_GAME_RAFFLE.GameRaffleInfo.StGetGameRaffleMaterialRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetGameRaffleMaterialRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_game_raffle.GetGameRaffleMaterial";
  public static final String TAG = "GetGameRaffleMaterialRequest";
  private GameRaffleInfo.StGetGameRaffleMaterialReq req = new GameRaffleInfo.StGetGameRaffleMaterialReq();
  
  public GetGameRaffleMaterialRequest(String paramString)
  {
    this.req.appid.set(paramString);
  }
  
  public static GameRaffleInfo.StGetGameRaffleMaterialRsp onResponse(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new GameRaffleInfo.StGetGameRaffleMaterialRsp();
      ((GameRaffleInfo.StGetGameRaffleMaterialRsp)localObject).mergeFrom(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse fail.");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("GetGameRaffleMaterialRequest", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetGameRaffleMaterialRequest
 * JD-Core Version:    0.7.0.1
 */