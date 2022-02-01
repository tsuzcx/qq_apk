package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.relation.api.IIceBreakingMsg;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import mqq.app.AppRuntime;

public class IceBreakingMsgImpl
  implements IIceBreakingMsg
{
  public void handleGetIceBreakHotPicResponse(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString)
  {
    if (("BreakIceSvr.Pull".equals(paramString)) && ((paramAppRuntime instanceof QQAppInterface))) {
      ((IceBreakingMng)paramAppRuntime.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.IceBreakingMsgImpl
 * JD-Core Version:    0.7.0.1
 */