package com.tencent.timi.game.room.impl.network;

import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import mqq.app.NewIntent;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserRouteInfoReq;

public class GetUserOnlineRouteInfoListServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(long paramLong)
  {
    return BaseTimiGameServlet.CreateReqIntentUtil.a(new UserProxyCmdOuterClass.GetUserRouteInfoReq(), GetUserOnlineRouteInfoListServlet.class);
  }
  
  protected int a()
  {
    return 104;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.network.GetUserOnlineRouteInfoListServlet
 * JD-Core Version:    0.7.0.1
 */