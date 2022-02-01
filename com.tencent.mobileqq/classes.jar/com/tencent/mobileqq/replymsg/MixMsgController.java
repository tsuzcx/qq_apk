package com.tencent.mobileqq.replymsg;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MixMsgController
  extends ReplyMsgController
{
  public MixMsgController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private HashMap<String, ArrayList<MessageRecord>> a(List<MessageRecord> paramList, ArrayList<ChatMessage> paramArrayList)
  {
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.next();
      if ((localMessageRecord1 instanceof MessageForMixedMsg))
      {
        Iterator localIterator = ((MessageForMixedMsg)localMessageRecord1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
          if (((localMessageRecord2 instanceof MessageForReplyText)) && (((MessageForReplyText)localMessageRecord2).getSourceMessage() != null))
          {
            localArrayList.add(localMessageRecord2);
            localHashMap.put(String.valueOf(localMessageRecord1.uniseq), localArrayList);
          }
        }
        paramArrayList.add((ChatMessage)localMessageRecord1);
      }
    }
    return localHashMap;
  }
  
  private void h(MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.a == null) {
      return;
    }
    Iterator localIterator = paramMultiMsgRequest.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatMessage)localIterator.next();
      if ((localObject instanceof MessageForMixedMsg))
      {
        MixedMsgManager localMixedMsgManager = (MixedMsgManager)this.a.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
        SessionInfo localSessionInfo = paramMultiMsgRequest.a;
        localObject = (MessageForMixedMsg)localObject;
        localMixedMsgManager.a(localSessionInfo, (MessageForMixedMsg)localObject, false, ((MessageForMixedMsg)localObject).forwardID);
      }
    }
  }
  
  protected void c(MultiMsgRequest paramMultiMsgRequest)
  {
    h(paramMultiMsgRequest);
  }
  
  protected void d(MultiMsgRequest paramMultiMsgRequest)
  {
    Object localObject = paramMultiMsgRequest.b;
    ArrayList localArrayList = new ArrayList(1);
    QQAppInterface localQQAppInterface = this.a;
    int j = paramMultiMsgRequest.h;
    int i = 0;
    boolean bool;
    if (j != 2) {
      bool = true;
    } else {
      bool = false;
    }
    paramMultiMsgRequest.f = a(a(localQQAppInterface, (List)localObject, bool), localArrayList);
    paramMultiMsgRequest.b = localArrayList;
    if (paramMultiMsgRequest.f.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "preHandleData dstMsgMap is empty");
      }
      h(paramMultiMsgRequest);
      return;
    }
    if ((paramMultiMsgRequest.h != 0) && (paramMultiMsgRequest.h == 2)) {
      i = 1;
    }
    localObject = this.e.obtainMessage(i);
    ((Message)localObject).obj = paramMultiMsgRequest;
    ((Message)localObject).sendToTarget();
  }
  
  protected void g(MultiMsgRequest paramMultiMsgRequest)
  {
    h(paramMultiMsgRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.replymsg.MixMsgController
 * JD-Core Version:    0.7.0.1
 */