package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMsgBackupProxy
  extends QRouteApi
{
  public abstract Object transToBackupEntity(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract MessageRecord transToMessageRecord(BaseQQAppInterface paramBaseQQAppInterface, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IMsgBackupProxy
 * JD-Core Version:    0.7.0.1
 */