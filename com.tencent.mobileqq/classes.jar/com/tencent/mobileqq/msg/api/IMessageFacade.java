package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfoInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IMessageFacade
  extends IRuntimeService
{
  public abstract void addMessage(ArrayList<Entity> paramArrayList, String paramString);
  
  public abstract void addObserver(Observer paramObserver);
  
  public abstract Entity constructMessageForText(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void deleteObserver(Observer paramObserver);
  
  public abstract List<Entity> getAllMessages(String paramString, int paramInt, int[] paramArrayOfInt);
  
  public abstract List<Entity> getAllMessages(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public abstract DraftSummaryInfoInterface getDraftSummaryInfo(String paramString, int paramInt);
  
  public abstract Entity getLastMessage(String paramString, int paramInt);
  
  public abstract List<Entity> getMessagesFromDB(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3);
  
  public abstract List<Entity> getMsgList(String paramString, int paramInt);
  
  public abstract long getMsgUinSeq(Entity paramEntity);
  
  public abstract <T> List<T> getPBMsgElemsDecoders();
  
  public abstract Object getQQMessageFacadeStub();
  
  public abstract int getRoutingType(int paramInt);
  
  public abstract int getUinType(int paramInt);
  
  public abstract void handleReceivedMessage(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean isMessageForText(Entity paramEntity);
  
  public abstract void removeMsgByMessageRecord(Entity paramEntity, boolean paramBoolean);
  
  public abstract void removeMsgByUniseq(String paramString, int paramInt, long paramLong);
  
  public abstract void setChangeAndNotify(Object paramObject);
  
  public abstract boolean setRoutingHead(AppInterface paramAppInterface, int paramInt, Object paramObject1, Object paramObject2);
  
  public abstract void updateMsgContentByUniseq(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IMessageFacade
 * JD-Core Version:    0.7.0.1
 */