package com.tencent.mobileqq.troop.essence.api;

import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import java.util.ArrayList;

public abstract interface ITroopEssenceHandler
{
  public abstract void a(long paramLong, ArrayList<TroopEssenceMsgItem> paramArrayList);
  
  public abstract void a(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.api.ITroopEssenceHandler
 * JD-Core Version:    0.7.0.1
 */