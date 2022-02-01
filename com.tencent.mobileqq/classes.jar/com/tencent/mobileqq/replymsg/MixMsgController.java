package com.tencent.mobileqq.replymsg;

import android.os.Message;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMultiMsgRequest.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if ((localChatMessage instanceof MessageForMixedMsg)) {
          ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForMixedMsg)localChatMessage, false, ((MessageForMixedMsg)localChatMessage).forwardID);
        }
      }
    }
  }
  
  public void c(MultiMsgRequest paramMultiMsgRequest)
  {
    h(paramMultiMsgRequest);
  }
  
  public void d(MultiMsgRequest paramMultiMsgRequest)
  {
    int i = 0;
    Object localObject = paramMultiMsgRequest.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList(1);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMultiMsgRequest.jdField_a_of_type_Int != 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap = a(a(localQQAppInterface, (List)localObject, bool), localArrayList);
      paramMultiMsgRequest.jdField_a_of_type_JavaUtilList = localArrayList;
      if (paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "preHandleData dstMsgMap is empty");
      }
      h(paramMultiMsgRequest);
      return;
    }
    if (paramMultiMsgRequest.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject).obj = paramMultiMsgRequest;
      ((Message)localObject).sendToTarget();
      return;
      if (paramMultiMsgRequest.jdField_a_of_type_Int == 2) {
        i = 1;
      }
    }
  }
  
  public void g(MultiMsgRequest paramMultiMsgRequest)
  {
    h(paramMultiMsgRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.replymsg.MixMsgController
 * JD-Core Version:    0.7.0.1
 */