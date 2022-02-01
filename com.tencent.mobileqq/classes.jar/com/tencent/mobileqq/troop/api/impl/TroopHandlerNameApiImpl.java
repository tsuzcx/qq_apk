package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.essence.handler.TroopEssenceMsgHandler;
import com.tencent.mobileqq.troop.api.troopgame.handler.TroopGameHandler;
import com.tencent.mobileqq.troop.honor.handler.TroopHonorHandler;

public class TroopHandlerNameApiImpl
  implements ITroopHandlerNameApi
{
  public String getTroopEssenceHandlerName()
  {
    return TroopEssenceMsgHandler.class.getName();
  }
  
  public String getTroopGameHandlerName()
  {
    return TroopGameHandler.class.getName();
  }
  
  public String getTroopHonorHandlerName()
  {
    return TroopHonorHandler.class.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopHandlerNameApiImpl
 * JD-Core Version:    0.7.0.1
 */