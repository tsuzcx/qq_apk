package com.tencent.timi.game.smoba.impl.config;

import trpc.yes.common.GameDataServerOuterClass.GetSmobaConfigRsp;

public class SmobaConfigManager
{
  private static SmobaConfigManager a;
  private GetSmobaConfigRepo b = new GetSmobaConfigRepo();
  
  public static SmobaConfigManager a()
  {
    try
    {
      if (a == null) {
        a = new SmobaConfigManager();
      }
      SmobaConfigManager localSmobaConfigManager = a;
      return localSmobaConfigManager;
    }
    finally {}
  }
  
  public GameDataServerOuterClass.GetSmobaConfigRsp b()
  {
    try
    {
      GameDataServerOuterClass.GetSmobaConfigRsp localGetSmobaConfigRsp = this.b.a();
      return localGetSmobaConfigRsp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      this.b = null;
      a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.config.SmobaConfigManager
 * JD-Core Version:    0.7.0.1
 */