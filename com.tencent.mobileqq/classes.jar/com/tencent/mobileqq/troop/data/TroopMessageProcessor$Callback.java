package com.tencent.mobileqq.troop.data;

import PushNotifyPack.GroupMsgReadedNotify;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import java.util.ArrayList;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;

public abstract interface TroopMessageProcessor$Callback
{
  public abstract BaseMessageManagerForTroopAndDisc a(TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(int paramInt, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, ArrayList<MessageRecord> paramArrayList1, PBDecodeContext paramPBDecodeContext, MessageInfo paramMessageInfo, ArrayList<MessageRecord> paramArrayList2, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(long paramLong, MessageRecord paramMessageRecord, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(long paramLong, ArrayList<MessageRecord> paramArrayList1, String paramString, ArrayList<MessageRecord> paramArrayList2, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(long paramLong, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(GroupMsgReadedNotify paramGroupMsgReadedNotify, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(MessageRecord paramMessageRecord, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(MessageInfo paramMessageInfo, String paramString, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(String paramString, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(ArrayList<TroopMemberInfo> paramArrayList, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract void a(ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract boolean a(MessageRecord paramMessageRecord);
  
  public abstract boolean a(MessageRecord paramMessageRecord, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract boolean a(TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract boolean a(ArrayList<MessageRecord> paramArrayList);
  
  public abstract void b(ArrayList<MessageRecord> paramArrayList, TroopMessageProcessor paramTroopMessageProcessor);
  
  public abstract boolean b(TroopMessageProcessor paramTroopMessageProcessor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageProcessor.Callback
 * JD-Core Version:    0.7.0.1
 */