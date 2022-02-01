package com.tencent.mobileqq.qwallet.transaction.impl;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qwallet.temp.IQWalletPBTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QWalletGoldMsgTipsElem;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.mobileqq.qwallet.transaction.NotifyMsgObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class NotifyMsgApiImpl
  implements INotifyMsgApi
{
  public static final int BTYPE_AA_PAY = 1;
  public static final int BTYPE_GROUP_HB_GRABBED_LIST = 2;
  public static final String KEY_AAPAY_STATE = "qqpay_state";
  public static final String KEY_GROUP_TYPE = "groupType";
  public static final String KEY_GROUP_UIN = "groupUin";
  public static final String KEY_STATE = "state";
  public static final int LOAD_DB_STATE_FINISH = 2;
  public static final int LOAD_DB_STATE_LOADING = 1;
  public static final int LOAD_DB_STATE_RAW = 0;
  protected static final long MAX_KEEP_GROUP_HB_GRABBED_LIST_TIME_IN_SEC = 172800L;
  protected static final long MAX_KEEP_NOTIFY_RECORD_TIME_IN_SEC = 2592000L;
  private static final String TAG = "NotifyMsgApi";
  protected static NotifyMsgDBHelper gDbHelper;
  protected static Object gDbHelperLock = new Object();
  protected static ArrayList<NotifyMsgRecord> gList = new ArrayList(128);
  protected static int gLoadDbState;
  protected static ArrayList<NotifyMsgRecord> gWaitNotifyRecords;
  protected static ArrayList<NotifyMsgApiImpl.WaitRecord> gWaitRecords;
  
  static
  {
    gDbHelper = null;
    gWaitRecords = new ArrayList();
    gWaitNotifyRecords = new ArrayList();
  }
  
  public static boolean checkAndUpdateToMesageRecord(MessageRecord paramMessageRecord, NotifyMsgRecord paramNotifyMsgRecord, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramMessageRecord != null) && (paramString != null))
    {
      bool = true;
      NotifyMsgRecord localNotifyMsgRecord;
      if (paramInt == 1)
      {
        localNotifyMsgRecord = paramNotifyMsgRecord;
        if (paramNotifyMsgRecord == null) {
          localNotifyMsgRecord = getRecord(gList, paramInt, paramString);
        }
        if (localNotifyMsgRecord != null)
        {
          int i = localNotifyMsgRecord.a("state", -1);
          paramNotifyMsgRecord = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
          if (!TextUtils.isEmpty(paramNotifyMsgRecord)) {
            try
            {
              paramInt = Integer.valueOf(paramNotifyMsgRecord).intValue();
            }
            catch (Exception paramNotifyMsgRecord)
            {
              if (QLog.isColorLevel()) {
                paramNotifyMsgRecord.printStackTrace();
              }
            }
          } else {
            paramInt = -1;
          }
          if ((i != -1) && (i != paramInt))
          {
            paramMessageRecord.saveExtInfoToExtStr("qqpay_state", String.valueOf(i));
            break label230;
          }
        }
      }
      else if (paramInt == 2)
      {
        localNotifyMsgRecord = paramNotifyMsgRecord;
        if (paramNotifyMsgRecord == null) {
          localNotifyMsgRecord = getRecord(gList, paramInt, paramString);
        }
        if ((localNotifyMsgRecord != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramNotifyMsgRecord = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramNotifyMsgRecord.mQQWalletRedPacketMsg != null) && (paramNotifyMsgRecord.mQQWalletRedPacketMsg.isOpened))
          {
            paramNotifyMsgRecord.mQQWalletRedPacketMsg.isOpened = true;
            paramNotifyMsgRecord.msgData = paramNotifyMsgRecord.getBytes();
            if (QWalletTools.b() != null) {
              ((IMessageFacade)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramNotifyMsgRecord.frienduin, paramNotifyMsgRecord.istroop, paramNotifyMsgRecord.uniseq, paramNotifyMsgRecord.msgData);
            }
          }
        }
      }
    }
    boolean bool = false;
    label230:
    if ((bool) && (paramBoolean)) {
      ThreadManager.post(new NotifyMsgApiImpl.3(paramMessageRecord), 5, null, false);
    }
    return bool;
  }
  
  public static boolean checkBusinessTypeStatic(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected static NotifyMsgRecord getRecord(ArrayList<NotifyMsgRecord> paramArrayList, int paramInt, String paramString)
  {
    if (paramArrayList == null) {
      return null;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      NotifyMsgRecord localNotifyMsgRecord = (NotifyMsgRecord)paramArrayList.get(i);
      if ((localNotifyMsgRecord != null) && (localNotifyMsgRecord.c == paramInt) && (localNotifyMsgRecord.d != null) && (localNotifyMsgRecord.d.equals(paramString))) {
        return localNotifyMsgRecord;
      }
      i += 1;
    }
    return null;
  }
  
  protected static ArrayList<NotifyMsgRecord> getRecords(ArrayList<NotifyMsgRecord> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      NotifyMsgRecord localNotifyMsgRecord = (NotifyMsgRecord)paramArrayList.get(i);
      if ((localNotifyMsgRecord != null) && (localNotifyMsgRecord.c == paramInt)) {
        localArrayList.add(localNotifyMsgRecord);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  protected static boolean isInWaitList(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    int i = 0;
    while (i < gWaitRecords.size())
    {
      NotifyMsgApiImpl.WaitRecord localWaitRecord = (NotifyMsgApiImpl.WaitRecord)gWaitRecords.get(i);
      if ((localWaitRecord != null) && (localWaitRecord.a == paramInt) && (localWaitRecord.b != null) && (localWaitRecord.b.equals(paramString)) && (localWaitRecord.c == paramMessageRecord)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected static void loadFromDb()
  {
    gLoadDbState = 1;
    ThreadManager.post(new NotifyMsgApiImpl.1(), 10, null, false);
  }
  
  protected static void notifyUI(NotifyMsgApiImpl.WaitRecord paramWaitRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgApi", 2, "notifyUI start");
    }
    if ((paramWaitRecord != null) && (paramWaitRecord.c != null))
    {
      Object localObject = QWalletTools.b();
      if (localObject == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramWaitRecord.a);
      localBundle.putString("bid", paramWaitRecord.b);
      ((BaseQQAppInterface)localObject).notifyObservers(NotifyMsgObserver.class, 1, true, localBundle);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyUI btype:");
        ((StringBuilder)localObject).append(paramWaitRecord.a);
        ((StringBuilder)localObject).append(" bid:");
        ((StringBuilder)localObject).append(paramWaitRecord.b);
        QLog.i("NotifyMsgApi", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static void onGroupHbGrabbedNotify(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt == 1) || (paramInt == 3000)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
      if (localBaseQQAppInterface == null) {
        return;
      }
      paramString2 = new NotifyMsgRecord(0, localBaseQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
      paramString2.a("groupUin", paramString1);
      paramString2.b("groupType", paramInt);
      updateOrCreate(localBaseQQAppInterface.getLongAccountUin(), paramString2);
    }
  }
  
  protected static NotifyMsgRecord onMergeMsg(NotifyMsgRecord paramNotifyMsgRecord1, NotifyMsgRecord paramNotifyMsgRecord2)
  {
    if (paramNotifyMsgRecord1 != null)
    {
      if (paramNotifyMsgRecord2 == null) {
        return paramNotifyMsgRecord2;
      }
      if ((paramNotifyMsgRecord1.c == paramNotifyMsgRecord2.c) && (paramNotifyMsgRecord1.d != null))
      {
        if (!paramNotifyMsgRecord1.d.equals(paramNotifyMsgRecord2.d)) {
          return paramNotifyMsgRecord2;
        }
        if (paramNotifyMsgRecord1.c == 1)
        {
          int i = paramNotifyMsgRecord2.a("state", 0);
          int j = paramNotifyMsgRecord1.a("state", 0);
          if (i != 2) {
            i = j;
          }
          paramNotifyMsgRecord2.b("state", i);
          return paramNotifyMsgRecord2;
        }
        paramNotifyMsgRecord2.f = paramNotifyMsgRecord1.f;
      }
    }
    return paramNotifyMsgRecord2;
  }
  
  public static void onReceiveAAPaySysNotifyStatic(int paramInt, QWalletGoldMsgTipsElem paramQWalletGoldMsgTipsElem1, QWalletGoldMsgTipsElem paramQWalletGoldMsgTipsElem2)
  {
    int i = 0;
    Object localObject = null;
    QWalletGoldMsgTipsElem localQWalletGoldMsgTipsElem = null;
    int j;
    if ((paramInt == 3000) && (paramQWalletGoldMsgTipsElem2 != null))
    {
      if (paramQWalletGoldMsgTipsElem2.type != 0) {
        paramInt = paramQWalletGoldMsgTipsElem2.type;
      } else {
        paramInt = 0;
      }
      paramQWalletGoldMsgTipsElem1 = localQWalletGoldMsgTipsElem;
      if (!TextUtils.isEmpty(paramQWalletGoldMsgTipsElem2.billno)) {
        paramQWalletGoldMsgTipsElem1 = paramQWalletGoldMsgTipsElem2.billno;
      }
      localQWalletGoldMsgTipsElem = paramQWalletGoldMsgTipsElem1;
      j = paramInt;
      if (paramQWalletGoldMsgTipsElem2.action != 0)
      {
        i = paramQWalletGoldMsgTipsElem2.action;
        j = paramInt;
        localQWalletGoldMsgTipsElem = paramQWalletGoldMsgTipsElem1;
      }
    }
    for (;;)
    {
      break;
      if (((paramInt != 1) && (paramInt != 0)) || (paramQWalletGoldMsgTipsElem1 == null)) {
        return;
      }
      if (paramQWalletGoldMsgTipsElem1.type != 0) {
        paramInt = paramQWalletGoldMsgTipsElem1.type;
      } else {
        paramInt = 0;
      }
      paramQWalletGoldMsgTipsElem2 = localObject;
      if (!TextUtils.isEmpty(paramQWalletGoldMsgTipsElem1.billno)) {
        paramQWalletGoldMsgTipsElem2 = paramQWalletGoldMsgTipsElem1.billno;
      }
      localQWalletGoldMsgTipsElem = paramQWalletGoldMsgTipsElem2;
      j = paramInt;
      if (paramQWalletGoldMsgTipsElem1.action != 0)
      {
        i = paramQWalletGoldMsgTipsElem1.action;
        localQWalletGoldMsgTipsElem = paramQWalletGoldMsgTipsElem2;
        j = paramInt;
      }
    }
    if (QLog.isColorLevel())
    {
      paramQWalletGoldMsgTipsElem1 = new StringBuilder();
      paramQWalletGoldMsgTipsElem1.append("onReceiveAAPaySysNotify type:");
      paramQWalletGoldMsgTipsElem1.append(j);
      paramQWalletGoldMsgTipsElem1.append(" billno:");
      paramQWalletGoldMsgTipsElem1.append(localQWalletGoldMsgTipsElem);
      paramQWalletGoldMsgTipsElem1.append(" action:");
      paramQWalletGoldMsgTipsElem1.append(i);
      QLog.i("NotifyMsgApi", 2, paramQWalletGoldMsgTipsElem1.toString());
    }
    if (j != 3) {
      return;
    }
    paramQWalletGoldMsgTipsElem1 = QWalletTools.b();
    if (paramQWalletGoldMsgTipsElem1 == null) {
      return;
    }
    paramQWalletGoldMsgTipsElem2 = new NotifyMsgRecord(0, paramQWalletGoldMsgTipsElem1.getLongAccountUin(), 1, localQWalletGoldMsgTipsElem, 0L, null);
    paramQWalletGoldMsgTipsElem2.b("state", i);
    updateOrCreate(paramQWalletGoldMsgTipsElem1.getLongAccountUin(), paramQWalletGoldMsgTipsElem2);
    paramQWalletGoldMsgTipsElem2 = new Bundle();
    paramQWalletGoldMsgTipsElem2.putInt("btype", 1);
    paramQWalletGoldMsgTipsElem2.putString("bid", localQWalletGoldMsgTipsElem);
    paramQWalletGoldMsgTipsElem1.notifyObservers(NotifyMsgObserver.class, 1, true, paramQWalletGoldMsgTipsElem2);
  }
  
  public static void preloadData()
  {
    if (gLoadDbState == 0) {
      loadFromDb();
    }
  }
  
  public static NotifyMsgRecord queryNotifyMsgRecord(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    boolean bool = checkBusinessTypeStatic(paramInt);
    NotifyMsgRecord localNotifyMsgRecord = null;
    ??? = localNotifyMsgRecord;
    if (bool)
    {
      ??? = localNotifyMsgRecord;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord == null) {
          return null;
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("queryGoldMsgRecord btype:");
          ((StringBuilder)???).append(paramInt);
          ((StringBuilder)???).append(" bid:");
          ((StringBuilder)???).append(paramString);
          ((StringBuilder)???).append(" dbstate:");
          ((StringBuilder)???).append(gLoadDbState);
          QLog.i("NotifyMsgApi", 2, ((StringBuilder)???).toString());
        }
        if (gLoadDbState == 2)
        {
          localNotifyMsgRecord = getRecord(gList, paramInt, paramString);
          if (localNotifyMsgRecord != null) {
            checkAndUpdateToMesageRecord(paramMessageRecord, localNotifyMsgRecord, paramInt, paramString, true);
          }
          ??? = localNotifyMsgRecord;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("queryGoldMsgRecord check in cache:");
            paramString.append(localNotifyMsgRecord);
            QLog.i("NotifyMsgApi", 2, paramString.toString());
            return localNotifyMsgRecord;
          }
        }
        else
        {
          if (paramInt != 2) {
            synchronized (gWaitRecords)
            {
              if (!isInWaitList(paramInt, paramString, paramMessageRecord)) {
                gWaitRecords.add(new NotifyMsgApiImpl.WaitRecord(paramInt, paramString, paramMessageRecord));
              }
            }
          }
          ??? = localNotifyMsgRecord;
          if (gLoadDbState == 0)
          {
            loadFromDb();
            ??? = localNotifyMsgRecord;
          }
        }
      }
    }
    return ???;
  }
  
  public static ArrayList<NotifyMsgRecord> queryRecordsInMemory(int paramInt)
  {
    if (!checkBusinessTypeStatic(paramInt)) {
      return null;
    }
    int i = gLoadDbState;
    if (i == 2)
    {
      ArrayList localArrayList = getRecords(gList, paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryRecordsInMemory size:");
        if (localArrayList != null) {
          paramInt = localArrayList.size();
        } else {
          paramInt = 0;
        }
        localStringBuilder.append(paramInt);
        QLog.i("NotifyMsgApi", 2, localStringBuilder.toString());
      }
      return localArrayList;
    }
    if (i == 0) {
      loadFromDb();
    }
    return null;
  }
  
  protected static void updateOrCreate(long paramLong, NotifyMsgRecord paramNotifyMsgRecord)
  {
    if ((paramNotifyMsgRecord != null) && (checkBusinessTypeStatic(paramNotifyMsgRecord.c)))
    {
      if (TextUtils.isEmpty(paramNotifyMsgRecord.d)) {
        return;
      }
      Object localObject = getRecord(gList, paramNotifyMsgRecord.c, paramNotifyMsgRecord.d);
      if (localObject == null)
      {
        if (gLoadDbState == 2)
        {
          gList.add(paramNotifyMsgRecord);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramNotifyMsgRecord);
          updateOrCreateToDb((ArrayList)localObject, true);
          return;
        }
        localObject = getRecord(gWaitNotifyRecords, paramNotifyMsgRecord.c, paramNotifyMsgRecord.d);
        if (localObject == null) {
          gWaitNotifyRecords.add(paramNotifyMsgRecord);
        } else {
          onMergeMsg(paramNotifyMsgRecord, (NotifyMsgRecord)localObject);
        }
        if (gLoadDbState == 0) {
          loadFromDb();
        }
      }
      else if (paramNotifyMsgRecord.c != 2)
      {
        onMergeMsg(paramNotifyMsgRecord, (NotifyMsgRecord)localObject);
        paramNotifyMsgRecord = new ArrayList();
        paramNotifyMsgRecord.add(localObject);
        updateOrCreateToDb(paramNotifyMsgRecord, false);
      }
    }
  }
  
  protected static void updateOrCreateToDb(ArrayList<NotifyMsgRecord> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgApiImpl.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  protected static void updateToMessageRecord(List<NotifyMsgApiImpl.WaitRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        NotifyMsgApiImpl.WaitRecord localWaitRecord = (NotifyMsgApiImpl.WaitRecord)paramList.next();
        if ((localWaitRecord != null) && (checkAndUpdateToMesageRecord(localWaitRecord.c, null, localWaitRecord.a, localWaitRecord.b, false))) {
          localArrayList.add(localWaitRecord);
        }
      }
      if (localArrayList.size() <= 0) {
        return;
      }
      ThreadManager.post(new NotifyMsgApiImpl.2(localArrayList), 5, null, false);
    }
  }
  
  public boolean checkBusinessType(int paramInt)
  {
    return checkBusinessTypeStatic(paramInt);
  }
  
  public int getAAPayState(String paramString, MessageRecord paramMessageRecord)
  {
    paramString = queryNotifyMsgRecord(1, paramString, paramMessageRecord);
    int i = -1;
    if (paramString != null) {
      i = paramString.a("state", -1);
    }
    return i;
  }
  
  public String getAAPayState(@NonNull MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
  }
  
  public boolean isBusinessTypeAAPay(int paramInt)
  {
    return paramInt == 1;
  }
  
  public void onActiveAccount()
  {
    gLoadDbState = 0;
    gList.clear();
    gWaitRecords.clear();
    gWaitNotifyRecords.clear();
    NotifyMsgDBHelper localNotifyMsgDBHelper = gDbHelper;
    if (localNotifyMsgDBHelper != null)
    {
      try
      {
        localNotifyMsgDBHelper.close();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      gDbHelper = null;
    }
  }
  
  public void onReceiveAAPaySysNotify(int paramInt, Object paramObject1, Object paramObject2)
  {
    try
    {
      onReceiveAAPaySysNotifyStatic(paramInt, ((IQWalletPBTemp)QRoute.api(IQWalletPBTemp.class)).convertTroopTips(paramObject1), ((IQWalletPBTemp)QRoute.api(IQWalletPBTemp.class)).convertTroopTips(paramObject2));
      return;
    }
    catch (Exception paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl
 * JD-Core Version:    0.7.0.1
 */