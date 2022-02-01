package com.tencent.mobileqq.troop.troopmanager.api;

import android.os.Bundle;
import java.util.List;

public abstract interface ITroopManagerBizHandler
{
  public abstract void a(long paramLong);
  
  @Deprecated
  public abstract void a(long paramLong, int paramInt);
  
  @Deprecated
  public abstract void a(long paramLong, int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(long paramLong, boolean paramBoolean, String paramString);
  
  public abstract void a(Long paramLong);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, Bundle paramBundle);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, List<String> paramList);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void b(Long paramLong);
  
  public abstract void b(String paramString);
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract void b(String paramString, boolean paramBoolean);
  
  public abstract void c(String paramString);
  
  public abstract void c(String paramString, boolean paramBoolean);
  
  public abstract void d(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler
 * JD-Core Version:    0.7.0.1
 */