package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWerewolvesMsgUtilDelegate
  extends QRouteApi
{
  public abstract boolean isWerewolvesMsg(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.IWerewolvesMsgUtilDelegate
 * JD-Core Version:    0.7.0.1
 */