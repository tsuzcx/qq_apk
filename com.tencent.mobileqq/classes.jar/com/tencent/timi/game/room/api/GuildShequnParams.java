package com.tencent.timi.game.room.api;

import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.utils.Logger;

public class GuildShequnParams
{
  public long a = 0L;
  public long b = 0L;
  public String c = "";
  
  public GuildShequnParams() {}
  
  public GuildShequnParams(long paramLong1, long paramLong2, String paramString)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramString;
  }
  
  public static GuildShequnParams a(ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    GuildShequnParams localGuildShequnParams = new GuildShequnParams();
    localGuildShequnParams.a = paramExpandHallLaunchParam.c;
    try
    {
      localGuildShequnParams.b = Long.parseLong(paramExpandHallLaunchParam.f);
    }
    catch (Exception localException)
    {
      Logger.a("GuildShequnParams", 1, "parseLong channelId failed", localException);
    }
    localGuildShequnParams.c = paramExpandHallLaunchParam.d;
    return localGuildShequnParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.api.GuildShequnParams
 * JD-Core Version:    0.7.0.1
 */