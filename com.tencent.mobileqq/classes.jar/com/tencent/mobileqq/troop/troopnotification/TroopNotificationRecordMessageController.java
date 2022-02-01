package com.tencent.mobileqq.troop.troopnotification;

import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.ITroopNotificationLoadDBListener;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationConfig;
import com.tencent.mobileqq.troop.util.TroopSystemMsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopNotificationRecordMessageController
  extends TroopNotificationController
{
  private List<MessageRecord> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<Integer, List<MessageRecord>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private boolean c;
  
  public TroopNotificationRecordMessageController(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.has()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.valueOf(((structmsg.SystemMsg)paramMessageRecord.msg.get()).group_code.get()));
        localStringBuilder.append("_");
        localStringBuilder.append(String.valueOf(paramMessageRecord.req_uin.get()));
        localStringBuilder.append("_");
        localStringBuilder.append(String.valueOf(((structmsg.SystemMsg)paramMessageRecord.msg.get()).group_msg_type.get()));
        return localStringBuilder.toString();
      }
    }
    return "";
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    a(paramList);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sortListBySeqAndMsgSubType list:");
      localStringBuilder.append(paramList.toString());
      localStringBuilder.append("size:");
      localStringBuilder.append(paramList.size());
      QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "removeDuplicatesMessages", localStringBuilder.toString() });
    }
    paramList = b(paramList);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNoRepeatSeqMsg list:");
      localStringBuilder.append(paramList.toString());
      localStringBuilder.append("size:");
      localStringBuilder.append(paramList.size());
      QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "removeDuplicatesMessages", localStringBuilder.toString() });
    }
    a(paramList, localArrayList);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeDuplicatesMessagesByKey list:");
      localStringBuilder.append(localArrayList.toString());
      localStringBuilder.append("size:");
      localStringBuilder.append(localArrayList.size());
      QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "removeDuplicatesMessages", localStringBuilder.toString() });
    }
    a(localArrayList);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeExpiredMessage list:");
      localStringBuilder.append(paramList.toString());
      localStringBuilder.append("size:");
      localStringBuilder.append(paramList.size());
      QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "removeDuplicatesMessages", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    paramList1 = b(paramList1, paramList2);
    if (paramList1.isEmpty()) {
      return paramList1;
    }
    return a(paramList1);
  }
  
  private void a()
  {
    Object localObject1 = Looper.myLooper();
    Object localObject2 = Looper.getMainLooper();
    boolean bool2 = false;
    if (localObject1 != localObject2)
    {
      localObject1 = (IMessageFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "");
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        String str = String.valueOf(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
        boolean bool1 = bool2;
        if (TroopSystemMsgUtils.a((ArrayList)this.jdField_a_of_type_JavaUtilList))
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_MqqAppAppRuntime.isBackgroundStop) {
            bool1 = true;
          }
        }
        ((IMessageFacade)localObject1).addMessage((List)localObject2, str, bool1);
      }
    }
    else
    {
      ThreadManager.postImmediately(new TroopNotificationRecordMessageController.3(this), null, false);
    }
  }
  
  private void a(int paramInt)
  {
    List localList1 = b(2);
    List localList2 = b(0);
    List localList3 = b(1);
    localList1.clear();
    localList2.clear();
    localList3.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      Object localObject = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg.has()))
      {
        int j = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).group_msg_type.get();
        int k = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).sub_type.get();
        if ((j != 13) && (j != 6))
        {
          localList2.add(localMessageRecord);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("message is not quit Troop");
            ((StringBuilder)localObject).append(localMessageRecord.toString());
            ((StringBuilder)localObject).append("size:");
            ((StringBuilder)localObject).append(localList2.size());
            QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "classifyMessageRecord", ((StringBuilder)localObject).toString() });
          }
        }
        else
        {
          localList1.add(localMessageRecord);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("message is quit Troop");
            ((StringBuilder)localObject).append(localMessageRecord.toString());
            ((StringBuilder)localObject).append("size:");
            ((StringBuilder)localObject).append(localList1.size());
            QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "classifyMessageRecord", ((StringBuilder)localObject).toString() });
          }
        }
        if (k == 1)
        {
          localList3.add(localMessageRecord);
          if ((i < paramInt) && (!this.jdField_a_of_type_Boolean)) {
            this.jdField_a_of_type_Boolean = true;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("message is undeal");
            ((StringBuilder)localObject).append(localMessageRecord.toString());
            ((StringBuilder)localObject).append("size:");
            ((StringBuilder)localObject).append(localList3.size());
            ((StringBuilder)localObject).append("mHasUndealDataList");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
            QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "classifyMessageRecord", ((StringBuilder)localObject).toString() });
          }
        }
      }
      i += 1;
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)paramArrayList.get(i)).getSystemMsg();
      TroopNotificationConfig localTroopNotificationConfig = (TroopNotificationConfig)QConfigManager.a().a(634);
      if ((localStructMsg != null) && (localStructMsg.msg_time != null) && (localStructMsg.msg_time.has()) && (localTroopNotificationConfig != null) && (NetConnInfoCenter.getServerTimeMillis() - localStructMsg.msg_time.get() * 1000L > localTroopNotificationConfig.b * 1000L)) {
        paramArrayList.remove(i);
      }
      i += 1;
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    Collections.sort(paramList, new TroopNotificationRecordMessageController.4(this));
  }
  
  private void a(List<MessageRecord> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("message is quit Troop");
        localStringBuilder.append(paramList.toString());
        localStringBuilder.append("size:");
        localStringBuilder.append(paramList.size());
        localStringBuilder.append("saveDB");
        localStringBuilder.append(paramBoolean);
        QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "addMessageRecordInner", localStringBuilder.toString() });
      }
      b(paramList, paramInt);
      if (paramBoolean) {
        a();
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      String str = a(localMessageRecord);
      structmsg.StructMsg localStructMsg1 = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
      if (localStructMsg1 != null) {
        if (localHashMap.containsKey(str))
        {
          structmsg.StructMsg localStructMsg2 = ((MessageForSystemMsg)localHashMap.get(str)).getSystemMsg();
          if (a(localStructMsg1.msg.group_msg_type.get()))
          {
            paramArrayList.add(localMessageRecord);
          }
          else if ((localStructMsg2.msg.has()) && (localStructMsg2.msg.sub_type.get() != 1))
          {
            paramArrayList.add(localMessageRecord);
          }
          else if (localStructMsg1.msg_time.get() > localStructMsg2.msg_time.get())
          {
            int i = paramArrayList.indexOf(localHashMap.get(str));
            paramArrayList.remove(i);
            paramArrayList.add(i, localMessageRecord);
            localHashMap.put(str, localMessageRecord);
          }
        }
        else
        {
          paramArrayList.add(localMessageRecord);
          localHashMap.put(str, localMessageRecord);
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return TroopSystemMsgUtils.a(paramInt);
  }
  
  @NotNull
  private List<MessageRecord> b(int paramInt)
  {
    List localList;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      localList = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    } else {
      localList = null;
    }
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new CopyOnWriteArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
    }
    return localObject;
  }
  
  private List<MessageRecord> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    label18:
    structmsg.StructMsg localStructMsg;
    for (paramList = null; localIterator.hasNext(); paramList = localStructMsg)
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
      if ((paramList != null) && (localStructMsg.msg_seq.get() == paramList.msg_seq.get())) {
        break label18;
      }
      localArrayList.add(localMessageRecord);
    }
    return localArrayList;
  }
  
  private List<MessageRecord> b(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localArrayList.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      localArrayList.addAll(paramList2);
    }
    return localArrayList;
  }
  
  private void b(List<MessageRecord> paramList, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilList, paramList);
      boolean bool = this.jdField_a_of_type_JavaUtilList.isEmpty();
      if (bool) {
        return;
      }
      paramList = (TroopNotificationConfig)QConfigManager.a().a(634);
      if ((paramList != null) && (paramList.jdField_a_of_type_Boolean))
      {
        a(paramInt);
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), this.jdField_a_of_type_JavaUtilList);
      return;
    }
    finally {}
  }
  
  private boolean d()
  {
    return Looper.myLooper() != Looper.getMainLooper();
  }
  
  @Nullable
  protected String a()
  {
    return "TroopNotificationRecordMessageController";
  }
  
  public List<MessageRecord> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localArrayList;
  }
  
  public List<MessageRecord> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b(paramInt));
    return localArrayList;
  }
  
  public List<MessageRecord> a(ITroopNotificationService.ITroopNotificationLoadDBListener paramITroopNotificationLoadDBListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (QLog.isColorLevel())
      {
        paramITroopNotificationLoadDBListener = new StringBuilder();
        paramITroopNotificationLoadDBListener.append("getMessageRecordMayBeLoadDB Cache is not empty:");
        paramITroopNotificationLoadDBListener.append(this.jdField_a_of_type_JavaUtilList.toString());
        paramITroopNotificationLoadDBListener.append("size:");
        paramITroopNotificationLoadDBListener.append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "getMessageRecordMayBeLoadDB", paramITroopNotificationLoadDBListener.toString() });
      }
      paramITroopNotificationLoadDBListener = new ArrayList();
      paramITroopNotificationLoadDBListener.addAll(this.jdField_a_of_type_JavaUtilList);
      return paramITroopNotificationLoadDBListener;
    }
    if (d())
    {
      paramITroopNotificationLoadDBListener = (IMessageFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "");
      if (paramITroopNotificationLoadDBListener != null)
      {
        b(paramITroopNotificationLoadDBListener.getAllMessages(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null), GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
        paramITroopNotificationLoadDBListener = new ArrayList();
        paramITroopNotificationLoadDBListener.addAll(this.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getMessageRecordMayBeLoadDB Cache is empty, currentThread is not mainThread:");
          localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.toString());
          localStringBuilder.append("size:");
          localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
          QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "getMessageRecordMayBeLoadDB", localStringBuilder.toString() });
        }
        return paramITroopNotificationLoadDBListener;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationRecordMessageController", 2, new Object[] { "getMessageRecordMayBeLoadDB", "getMessageRecordMayBeLoadDB Cache is empty, currentThread is mainThread:" });
      }
      ThreadManager.postImmediately(new TroopNotificationRecordMessageController.1(this), new TroopNotificationRecordMessageController.2(this, paramITroopNotificationLoadDBListener), false);
    }
    return null;
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord.uniseq == paramLong) {
          this.jdField_a_of_type_JavaUtilList.remove(localMessageRecord);
        }
      }
      a(GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
      localObject = (IMessageFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "");
      if (localObject != null) {
        ((IMessageFacade)localObject).removeMsgByUniseq(paramString, paramInt, paramLong, paramBoolean);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(List<MessageRecord> paramList, int paramInt)
  {
    a(paramList, paramInt, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    b();
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationRecordMessageController
 * JD-Core Version:    0.7.0.1
 */