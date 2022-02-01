package com.tencent.timi.game.team.impl.main;

import com.tencent.timi.game.room.api.GuildShequnParams;
import java.util.List;

public class TeamConfigBean
{
  public String a;
  public int b;
  public int c = 1;
  public int d = 11;
  public int e = 0;
  public long f;
  public int g;
  public int h;
  public long i;
  public List<Integer> j;
  public GuildShequnParams k;
  
  public TeamConfigBean(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, long paramLong2, List<Integer> paramList, GuildShequnParams paramGuildShequnParams)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramLong1;
    this.g = paramInt5;
    this.h = paramInt6;
    this.i = paramLong2;
    this.j = paramList;
    this.k = paramGuildShequnParams;
  }
  
  public static TeamConfigBean a(int paramInt1, int paramInt2, int paramInt3, long paramLong, GuildShequnParams paramGuildShequnParams)
  {
    return new TeamConfigBean(null, 0, 1, 11, paramInt1, 0L, paramInt2, paramInt3, paramLong, null, paramGuildShequnParams);
  }
  
  public static TeamConfigBean a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, List<Integer> paramList)
  {
    return new TeamConfigBean(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramLong, 0, 0, 0L, paramList, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamConfigBean
 * JD-Core Version:    0.7.0.1
 */