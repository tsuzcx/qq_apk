package com.tencent.timi.game.accusation.impl;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import mqq.app.NewIntent;
import trpc.yes.common.SafeOuterClass.QQGetUserSafeSercetReq;

public class GenEncryptedUinServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(String paramString)
  {
    SafeOuterClass.QQGetUserSafeSercetReq localQQGetUserSafeSercetReq = new SafeOuterClass.QQGetUserSafeSercetReq();
    localQQGetUserSafeSercetReq.uin.set(Long.valueOf(paramString).longValue());
    return BaseTimiGameServlet.CreateReqIntentUtil.a(localQQGetUserSafeSercetReq, GenEncryptedUinServlet.class);
  }
  
  protected int a()
  {
    return 1002;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.accusation.impl.GenEncryptedUinServlet
 * JD-Core Version:    0.7.0.1
 */