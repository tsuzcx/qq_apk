package com.tencent.mobileqq.richmedia.ordersend;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class OrderMediaMsgManager
  implements OrderMediaMsgSessionQueue.IMsgPhaseListener, Manager
{
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MediaMsgController jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController;
  private HashMap<String, OrderMediaMsgSessionQueue> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public OrderMediaMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private MediaMsgController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController = new MediaMsgController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    ((OrderMediaMsgManager)paramQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).b(paramString, paramLong);
  }
  
  public OrderMediaMsgSessionQueue a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          paramString = (OrderMediaMsgSessionQueue)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          return paramString;
        }
      }
      OrderMediaMsgSessionQueue localOrderMediaMsgSessionQueue = new OrderMediaMsgSessionQueue(paramString, a());
      localOrderMediaMsgSessionQueue.a(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localOrderMediaMsgSessionQueue);
      paramString = localOrderMediaMsgSessionQueue;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new OrderMediaMsgManager.1(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    a(paramMessageRecord, paramMessageObserver, null);
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, OrderMediaMsgManager.IMsgSendingListener paramIMsgSendingListener)
  {
    OrderMediaMsgSessionQueue localOrderMediaMsgSessionQueue = a(paramMessageRecord.frienduin);
    String str = null;
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      str = ((MessageForShortVideo)paramMessageRecord).videoFileName;
    }
    while (localOrderMediaMsgSessionQueue.a(paramMessageRecord.uniseq, str))
    {
      localOrderMediaMsgSessionQueue.a(paramMessageRecord, paramMessageObserver, paramIMsgSendingListener);
      return;
      if ((paramMessageRecord instanceof MessageForPic)) {
        str = ((MessageForPic)paramMessageRecord).path;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("OrderMediaMsgManager", 2, "sendOrderMsg but not in queue, uniseq:" + paramMessageRecord.uniseq);
    }
    a().a(paramMessageRecord, paramMessageObserver, paramIMsgSendingListener);
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = a(paramMessageRecord.frienduin);
    if (((OrderMediaMsgSessionQueue)localObject).a(paramMessageRecord.uniseq, paramString))
    {
      ((OrderMediaMsgSessionQueue)localObject).a(paramMessageRecord, paramMessageRecord.uniseq, paramString, true);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addOrderMsg but not in queue, uniseq:").append(paramMessageRecord.uniseq).append(", path:").append(paramString);
      QLog.d("OrderMediaMsgManager", 2, ((StringBuilder)localObject).toString());
    }
    a().a(paramMessageRecord);
  }
  
  public void a(String paramString)
  {
    OrderMediaMsgSessionQueue localOrderMediaMsgSessionQueue = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localOrderMediaMsgSessionQueue = (OrderMediaMsgSessionQueue)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)???).append("remove orderSession, suin = ").append(paramString).append(", addr = ");
          if (localOrderMediaMsgSessionQueue != null)
          {
            paramString = localOrderMediaMsgSessionQueue.toString();
            localStringBuilder.append(paramString);
            QLog.d("OrderMediaMsgManager", 2, ((StringBuilder)???).toString());
          }
        }
        else
        {
          return;
        }
      }
      paramString = Integer.valueOf(0);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    a(paramString).a(paramLong, "");
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    a(paramString).a(paramLong1, paramLong2);
  }
  
  public void a(String paramString1, MessageRecord paramMessageRecord, String paramString2)
  {
    OrderMediaMsgSessionQueue localOrderMediaMsgSessionQueue = a(paramMessageRecord.frienduin);
    if (!localOrderMediaMsgSessionQueue.a(paramMessageRecord.uniseq, paramString2)) {
      a(paramString1, paramMessageRecord.uniseq);
    }
    localOrderMediaMsgSessionQueue.a(paramMessageRecord, paramMessageRecord.uniseq, paramString2, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (a().a(paramString2)) {
      return;
    }
    a(paramString1).a(0L, paramString2);
  }
  
  public void a(String paramString, ArrayList<ChatMessage> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      int k;
      for (int j = 0; paramArrayList.hasNext(); j = k)
      {
        ChatMessage localChatMessage = (ChatMessage)paramArrayList.next();
        k = j + 1;
        j = i;
        if (MediaMsgController.a(localChatMessage.msgtype))
        {
          j = i + 1;
          a(paramString).a(localChatMessage.uniseq, "", a().a(localChatMessage));
        }
        i = j;
      }
      OrderMediaMsgReporter.b(j, i);
    }
  }
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {}
    while (a(paramString).a()) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {}
    while (a(paramString).a().a(paramLong) == 0) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, long paramLong, View paramView, FileTransferManager.Callback paramCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return false;
    }
    return a(paramString).a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramView, paramCallback);
  }
  
  public void b(String paramString, long paramLong)
  {
    a(paramString).a(paramLong);
  }
  
  public boolean b(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {}
    while (a(paramString).a().a(paramLong) != 2) {
      return false;
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((OrderMediaMsgSessionQueue)localIterator.next()).a();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager
 * JD-Core Version:    0.7.0.1
 */