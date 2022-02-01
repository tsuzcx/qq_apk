package com.tencent.timi.game.smoba.impl.config;

import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import mqq.app.NewIntent;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaConfigReq;

public class GetSmobaConfigServlet
  extends BaseTimiGameServlet
{
  public static NewIntent b()
  {
    return BaseTimiGameServlet.CreateReqIntentUtil.a(new GameDataServerOuterClass.GetSmobaConfigReq(), GetSmobaConfigServlet.class);
  }
  
  protected int a()
  {
    return 307;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.config.GetSmobaConfigServlet
 * JD-Core Version:    0.7.0.1
 */