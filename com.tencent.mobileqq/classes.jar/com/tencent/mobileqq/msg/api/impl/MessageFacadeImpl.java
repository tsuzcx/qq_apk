package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.core.codec.IPBMsgElemDecoder;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.imcore.message.core.codec.RoutingTypeGenerator;
import com.tencent.imcore.message.core.codec.UinTypeRoutingTypeMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfoInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime;
import msf.msgsvc.msg_svc.RoutingHead;

public class MessageFacadeImpl
  implements IMessageFacade
{
  public static final String TAG = "MessageFacadeImpl";
  private QQAppInterface mApp;
  
  public void addMessage(ArrayList<Entity> paramArrayList, String paramString)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Entity localEntity = (Entity)paramArrayList.next();
        if ((localEntity instanceof MessageRecord)) {
          localArrayList.add((MessageRecord)localEntity);
        }
      }
    }
    this.mApp.getMessageFacade().a(localArrayList, paramString, this.mApp.isBackgroundStop);
  }
  
  public void addObserver(Observer paramObserver)
  {
    this.mApp.getMessageFacade().addObserver(paramObserver);
  }
  
  public boolean checkAppRuntimeInValid()
  {
    if (QLog.isColorLevel()) {
      if (this.mApp != null) {
        break label46;
      }
    }
    label46:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("MessageFacadeImpl", 2, new Object[] { "checkAppRuntimeInValid: ", Boolean.valueOf(bool) });
      if (this.mApp != null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public Entity constructMessageForText(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.selfuin = this.mApp.getCurrentAccountUin();
    localMessageForText.frienduin = paramString3;
    localMessageForText.istroop = paramInt;
    localMessageForText.senderuin = "";
    localMessageForText.time = NetConnInfoCenter.getServerTime();
    localMessageForText.msg = paramString1;
    localMessageForText.uniseq = paramString2.hashCode();
    return localMessageForText;
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    this.mApp.getMessageFacade().deleteObserver(paramObserver);
  }
  
  public List<Entity> getAllMessages(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    paramString = this.mApp.getMessageFacade().a(paramString, paramInt, paramArrayOfInt);
    paramArrayOfInt = new ArrayList();
    if (paramString != null) {
      paramArrayOfInt.addAll(paramString);
    }
    return paramArrayOfInt;
  }
  
  public List<Entity> getAllMessages(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (checkAppRuntimeInValid()) {
      paramString = null;
    }
    List localList;
    do
    {
      return paramString;
      localList = this.mApp.getMessageFacade().a(paramString, paramInt1, paramArrayOfInt, paramInt2);
      paramArrayOfInt = new ArrayList();
      paramString = paramArrayOfInt;
    } while (localList == null);
    paramArrayOfInt.addAll(localList);
    return paramArrayOfInt;
  }
  
  public DraftSummaryInfoInterface getDraftSummaryInfo(String paramString, int paramInt)
  {
    return this.mApp.getMessageFacade().getDraftSummaryInfo(paramString, paramInt);
  }
  
  public Entity getLastMessage(String paramString, int paramInt)
  {
    return this.mApp.getMessageFacade().a(paramString, paramInt);
  }
  
  public List<Entity> getMessagesFromDB(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3)
  {
    if (checkAppRuntimeInValid()) {
      paramString = null;
    }
    List localList;
    do
    {
      return paramString;
      localList = this.mApp.getMessageFacade().a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramArrayOfInt, paramInt3);
      paramArrayOfInt = new ArrayList();
      paramString = paramArrayOfInt;
    } while (localList == null);
    paramArrayOfInt.addAll(localList);
    return paramArrayOfInt;
  }
  
  public List<Entity> getMsgList(String paramString, int paramInt)
  {
    if (checkAppRuntimeInValid()) {
      paramString = null;
    }
    List localList;
    ArrayList localArrayList;
    do
    {
      return paramString;
      localList = this.mApp.getMessageFacade().b(paramString, paramInt);
      localArrayList = new ArrayList();
      paramString = localArrayList;
    } while (localList == null);
    localArrayList.addAll(localList);
    return localArrayList;
  }
  
  public long getMsgUinSeq(Entity paramEntity)
  {
    if ((paramEntity instanceof MessageRecord)) {
      return ((MessageRecord)paramEntity).uniseq;
    }
    return -1L;
  }
  
  public List<IPBMsgElemDecoder> getPBMsgElemsDecoders()
  {
    return this.mApp.getMessageFacade().a().a();
  }
  
  public Object getQQMessageFacadeStub()
  {
    return this.mApp.getMessageFacade();
  }
  
  public int getRoutingType(int paramInt)
  {
    return this.mApp.getMessageFacade().a().a().a(paramInt);
  }
  
  public int getUinType(int paramInt)
  {
    return ((RoutingType)this.mApp.getMessageFacade().a().a().a(Integer.valueOf(paramInt))).a();
  }
  
  public void handleReceivedMessage(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mApp.handleReceivedMessage(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public boolean isMessageForText(Entity paramEntity)
  {
    return (paramEntity instanceof MessageForText);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    boolean bool1 = true;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      bool2 = paramAppRuntime instanceof QQAppInterface;
      if (paramAppRuntime != null) {
        break label67;
      }
    }
    for (;;)
    {
      QLog.d("MessageFacadeImpl", 2, new Object[] { "MessageFacadeImpl onCreate: app instanceOf QQApp: ", Boolean.valueOf(bool2), "app is null: ", Boolean.valueOf(bool1) });
      if ((paramAppRuntime instanceof QQAppInterface)) {
        this.mApp = ((QQAppInterface)paramAppRuntime);
      }
      return;
      label67:
      bool1 = false;
    }
  }
  
  public void onDestroy() {}
  
  public void removeMsgByMessageRecord(Entity paramEntity, boolean paramBoolean)
  {
    if (checkAppRuntimeInValid()) {}
    while (!(paramEntity instanceof MessageRecord)) {
      return;
    }
    paramEntity = (MessageRecord)paramEntity;
    this.mApp.getMessageFacade().a(paramEntity, paramBoolean);
  }
  
  public void removeMsgByUniseq(String paramString, int paramInt, long paramLong)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    this.mApp.getMessageFacade().b(paramString, paramInt, paramLong);
  }
  
  public void setChangeAndNotify(Object paramObject)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    this.mApp.getMessageFacade().a(paramObject);
  }
  
  public boolean setRoutingHead(AppInterface paramAppInterface, int paramInt, Object paramObject1, Object paramObject2)
  {
    if (((paramObject2 instanceof MessageRecord)) && ((paramObject1 instanceof msg_svc.RoutingHead)) && ((paramAppInterface instanceof QQAppInterface))) {
      return ((RoutingType)this.mApp.getMessageFacade().a().a().a(Integer.valueOf(paramInt))).a((msg_svc.RoutingHead)paramObject1, (MessageRecord)paramObject2, (QQAppInterface)paramAppInterface);
    }
    return false;
  }
  
  public void updateMsgContentByUniseq(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    this.mApp.getMessageFacade().a(paramString, paramInt, paramLong, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.MessageFacadeImpl
 * JD-Core Version:    0.7.0.1
 */