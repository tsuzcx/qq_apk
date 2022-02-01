package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMsgBackupProxy;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgProxy;

public class MsgBackupProxyImpl
  implements IMsgBackupProxy
{
  public Object transToBackupEntity(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = (MsgBackupMsgProxy)((QQAppInterface)paramBaseQQAppInterface).getProxyManager().getProxy(14);
      if (paramBaseQQAppInterface != null) {
        return paramBaseQQAppInterface.a(paramMessageRecord);
      }
    }
    return null;
  }
  
  public MessageRecord transToMessageRecord(BaseQQAppInterface paramBaseQQAppInterface, Object paramObject)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = (MsgBackupMsgProxy)((QQAppInterface)paramBaseQQAppInterface).getProxyManager().getProxy(14);
      if (paramBaseQQAppInterface != null) {
        return paramBaseQQAppInterface.a(paramObject);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.MsgBackupProxyImpl
 * JD-Core Version:    0.7.0.1
 */