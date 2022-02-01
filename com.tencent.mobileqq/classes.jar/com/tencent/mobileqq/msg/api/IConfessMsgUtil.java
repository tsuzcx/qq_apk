package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IConfessMsgUtil
  extends QRouteApi
{
  public abstract void bindC2CFirstMsgConfessInfo(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString);
  
  public abstract void bindConfessInfo(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt1, int paramInt2);
  
  public abstract void bindGroupFirstMsgConfessInfo(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IConfessMsgUtil
 * JD-Core Version:    0.7.0.1
 */