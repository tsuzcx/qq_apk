package com.tencent.mobileqq.troop.recommend.api;

import java.util.ArrayList;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;

public abstract interface ITroopRecommendHandler
{
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, oidb_0x935.GPS paramGPS);
  
  public abstract void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, ArrayList<Long> paramArrayList);
  
  public abstract void b(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler
 * JD-Core Version:    0.7.0.1
 */