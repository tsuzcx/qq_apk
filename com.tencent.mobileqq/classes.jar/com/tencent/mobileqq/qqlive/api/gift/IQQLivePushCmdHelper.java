package com.tencent.mobileqq.qqlive.api.gift;

import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQLivePushCmdHelper
  extends QRouteApi
{
  public static final int GIFT_MESSAGE_CMD_GUILD = 16;
  public static final int GIFT_MESSAGE_CMD_QQLIVE = 16;
  public static final int HIGH_PRIORITY_MESSAGE_CMD_GUILD = 232;
  public static final int HIGH_PRIORITY_MESSAGE_CMD_QQLIVE = 167;
  public static final int LOW_PRIORITY_MESSAGE_CMD_GUILD = 233;
  public static final int LOW_PRIORITY_MESSAGE_CMD_QQLIVE = 234;
  
  public abstract GiftMessage covertPushDataToGiftMessage(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract int getGiftPushSubCmd(String paramString);
  
  public abstract int getHighPriorityPushCmd(String paramString);
  
  public abstract int getLowPriorityPushCmd(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper
 * JD-Core Version:    0.7.0.1
 */