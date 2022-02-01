package com.tencent.mobileqq.fts.interfaces;

import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public abstract interface IFTSMsgInterface
  extends IFTSOperator
{
  public abstract void a();
  
  public abstract void a(MsgQueueItem paramMsgQueueItem, EntityManager paramEntityManager, List<MessageRecord> paramList);
  
  public abstract void a(Entity paramEntity);
  
  public abstract void a(Entity paramEntity, EntityManager paramEntityManager);
  
  public abstract void b(MsgQueueItem paramMsgQueueItem, EntityManager paramEntityManager, List<MessageRecord> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.interfaces.IFTSMsgInterface
 * JD-Core Version:    0.7.0.1
 */