package com.tencent.timi.game.smoba.api;

import java.util.ArrayList;
import java.util.List;

public class SmobaGangupCheckParam
{
  public int a;
  public boolean b;
  public long c;
  public int d;
  public int e;
  public List<Integer> f;
  
  public SmobaGangupCheckParam(int paramInt1, boolean paramBoolean, long paramLong, int paramInt2, int paramInt3, List<Integer> paramList)
  {
    this.a = paramInt1;
    this.b = paramBoolean;
    this.c = paramLong;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.f.addAll(paramList);
    }
  }
  
  public static SmobaGangupCheckParam a(int paramInt)
  {
    return new SmobaGangupCheckParam(paramInt, true, 0L, 0, 0, null);
  }
  
  public static SmobaGangupCheckParam a(int paramInt1, long paramLong, int paramInt2, int paramInt3, List<Integer> paramList)
  {
    return new SmobaGangupCheckParam(paramInt1, false, paramLong, paramInt2, paramInt3, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.SmobaGangupCheckParam
 * JD-Core Version:    0.7.0.1
 */