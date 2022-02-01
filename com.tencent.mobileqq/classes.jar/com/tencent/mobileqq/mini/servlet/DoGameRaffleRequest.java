package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_RAFFLE.GameRaffleInfo.StDoGameRaffleReq;
import NS_MINI_GAME_RAFFLE.GameRaffleInfo.StDoGameRaffleRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class DoGameRaffleRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_game_raffle.DoGameRaffle";
  public static final String TAG = "DoGameRaffleRequest";
  private GameRaffleInfo.StDoGameRaffleReq req = new GameRaffleInfo.StDoGameRaffleReq();
  
  public DoGameRaffleRequest(String paramString1, String paramString2)
  {
    this.req.appid.set(paramString1);
    this.req.uin.set(paramString2);
  }
  
  public static GameRaffleInfo.StDoGameRaffleRsp onResponse(byte[] paramArrayOfByte)
  {
    try
    {
      GameRaffleInfo.StDoGameRaffleRsp localStDoGameRaffleRsp = new GameRaffleInfo.StDoGameRaffleRsp();
      localStDoGameRaffleRsp.mergeFrom(paramArrayOfByte);
      return localStDoGameRaffleRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.d("DoGameRaffleRequest", 1, "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.DoGameRaffleRequest
 * JD-Core Version:    0.7.0.1
 */