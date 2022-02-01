package com.tencent.timi.game.room.api;

import java.util.ArrayList;
import java.util.List;

public class RoomInterceptCheckParam
{
  public boolean a;
  public int b;
  public int c;
  public int d;
  public long e;
  public int f;
  public int g;
  public List<Integer> h;
  
  public RoomInterceptCheckParam(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, List<Integer> paramList)
  {
    this.a = paramBoolean;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramLong;
    this.f = paramInt4;
    this.g = paramInt5;
    this.h = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.h.addAll(paramList);
    }
  }
  
  public static RoomInterceptCheckParam a(int paramInt)
  {
    return new RoomInterceptCheckParam(true, paramInt, 0, 0, 0L, 0, 0, null);
  }
  
  public static RoomInterceptCheckParam a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return new RoomInterceptCheckParam(false, paramInt1, paramInt2, paramInt3, paramLong, 0, 0, null);
  }
  
  public static RoomInterceptCheckParam a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, List<Integer> paramList)
  {
    return new RoomInterceptCheckParam(false, paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.api.RoomInterceptCheckParam
 * JD-Core Version:    0.7.0.1
 */