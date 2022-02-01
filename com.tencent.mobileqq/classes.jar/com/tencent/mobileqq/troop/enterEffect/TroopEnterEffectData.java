package com.tencent.mobileqq.troop.entereffect;

public class TroopEnterEffectData
{
  public int a;
  public String b;
  public String c;
  public long d;
  public int e;
  public int f;
  public int g;
  public long h;
  
  public TroopEnterEffectData(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h = paramLong;
    this.d = System.currentTimeMillis();
  }
  
  public String toString()
  {
    return String.format("{id: %d, uin: %s, troopUin: %s, createTime: %d, svipLevel: %d, svipType: %d, globalTroopLevel: %d, mode: %d}", new Object[] { Integer.valueOf(this.a), this.b, this.c, Long.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Long.valueOf(this.h) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData
 * JD-Core Version:    0.7.0.1
 */