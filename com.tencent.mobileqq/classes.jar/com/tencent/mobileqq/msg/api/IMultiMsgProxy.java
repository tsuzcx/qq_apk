package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.ArrayList;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IMultiMsgProxy
  extends QRouteApi
{
  public abstract void addMultiMsgWithNest(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, HashMap<String, ArrayList<MessageRecord>> paramHashMap, Object paramObject);
  
  public abstract byte[] packPbFromMultiMsgWithNest(BaseQQAppInterface paramBaseQQAppInterface, HashMap<String, ArrayList<MessageRecord>> paramHashMap, HashMap<String, String> paramHashMap1, boolean paramBoolean);
  
  public abstract HashMap<String, ArrayList<MessageRecord>> queryMultiMsgWithNest(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract HashMap<String, ArrayList<MessageRecord>> unpackPbToMultiMsgWithNest(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, MessageInfo paramMessageInfo);
  
  public abstract void updateMultiMsg(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IMultiMsgProxy
 * JD-Core Version:    0.7.0.1
 */