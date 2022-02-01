package com.tencent.mobileqq.troop.api.handler;

import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.List;

public abstract interface ITroopTokenHandler
{
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, long paramLong, String paramString);
  
  public abstract void a(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  public abstract void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2);
  
  public abstract void a(List<TroopInfo> paramList, boolean paramBoolean);
  
  public abstract void b(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.handler.ITroopTokenHandler
 * JD-Core Version:    0.7.0.1
 */