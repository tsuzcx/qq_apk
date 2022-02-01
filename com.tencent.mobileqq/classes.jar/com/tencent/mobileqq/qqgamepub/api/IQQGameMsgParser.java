package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQGameMsgParser
  extends QRouteApi
{
  public abstract QQGameMsgInfo parseMessageRecord(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameMsgParser
 * JD-Core Version:    0.7.0.1
 */