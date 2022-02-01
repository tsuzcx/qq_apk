package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryAIOGreetInfoRsp;

public abstract interface IGameMsgSayHiCallback
{
  public abstract void a(long paramLong, String paramString, GameMsgGreeting.QueryAIOGreetInfoRsp paramQueryAIOGreetInfoRsp);
  
  public abstract void a(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameMsgSayHiCallback
 * JD-Core Version:    0.7.0.1
 */