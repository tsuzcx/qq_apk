package com.tencent.mobileqq.troop.troopgag.api;

import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import java.util.ArrayList;

public abstract interface ITroopGagHandler
{
  public abstract void a(GagStatus paramGagStatus);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, long paramLong);
  
  public abstract void a(String paramString, ArrayList<ITroopGagHandler.GagMemberParam> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.ITroopGagHandler
 * JD-Core Version:    0.7.0.1
 */