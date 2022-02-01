package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMultiMsgProxy;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class MultiMsgProxyImpl
  implements IMultiMsgProxy
{
  public void addMultiMsgWithNest(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, HashMap<String, ArrayList<MessageRecord>> paramHashMap, Object paramObject)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getMultiMessageProxy();
      if (paramBaseQQAppInterface != null) {
        paramBaseQQAppInterface.a(paramMessageRecord, paramHashMap, null);
      }
    }
  }
  
  public byte[] packPbFromMultiMsgWithNest(BaseQQAppInterface paramBaseQQAppInterface, HashMap<String, ArrayList<MessageRecord>> paramHashMap, HashMap<String, String> paramHashMap1, boolean paramBoolean)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getMultiMessageProxy();
      if (paramBaseQQAppInterface != null) {
        return paramBaseQQAppInterface.a(paramHashMap, paramHashMap1, paramBoolean);
      }
    }
    return null;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> queryMultiMsgWithNest(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getMultiMessageProxy();
      if (paramBaseQQAppInterface != null) {
        return paramBaseQQAppInterface.c(paramMessageRecord);
      }
    }
    return null;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> unpackPbToMultiMsgWithNest(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, MessageInfo paramMessageInfo)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getMultiMessageProxy();
      if (paramBaseQQAppInterface != null) {
        paramBaseQQAppInterface.b(paramArrayOfByte, paramHashMap, paramMessageRecord, paramMessageInfo);
      }
    }
    return null;
  }
  
  public void updateMultiMsg(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getMultiMessageProxy();
      if (paramBaseQQAppInterface != null) {
        paramBaseQQAppInterface.a(paramMessageRecord, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.MultiMsgProxyImpl
 * JD-Core Version:    0.7.0.1
 */