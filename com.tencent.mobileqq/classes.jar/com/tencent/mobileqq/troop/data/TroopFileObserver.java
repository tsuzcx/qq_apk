package com.tencent.mobileqq.troop.data;

import java.util.List;

public abstract interface TroopFileObserver
{
  public abstract void a(int paramInt);
  
  public abstract void a(TroopFileInfo paramTroopFileInfo);
  
  public abstract void a(TroopFileInfo paramTroopFileInfo, String paramString);
  
  public abstract void a(List<TroopFileInfo> paramList, boolean paramBoolean, String paramString, long paramLong);
  
  public abstract void b(TroopFileInfo paramTroopFileInfo);
  
  public abstract void c(TroopFileInfo paramTroopFileInfo);
  
  public abstract void d(TroopFileInfo paramTroopFileInfo);
  
  public abstract void e(TroopFileInfo paramTroopFileInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileObserver
 * JD-Core Version:    0.7.0.1
 */