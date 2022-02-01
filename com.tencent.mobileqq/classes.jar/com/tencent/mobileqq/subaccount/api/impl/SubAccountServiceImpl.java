package com.tencent.mobileqq.subaccount.api.impl;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService.SubAccountUnReadItem;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SubAccountServiceImpl
  implements ISubAccountService
{
  EntityManager em;
  ArrayList<SubAccountInfo> listSubInfo = new ArrayList();
  Lock lock = new ReentrantLock();
  private AppInterface mApp;
  private boolean mNotifySwitch = true;
  public HashMap<String, ArrayList<SubAccountMessage>> mapSubMsg = new HashMap();
  
  private void inflateMsgData()
  {
    this.lock.lock();
    try
    {
      this.mapSubMsg.clear();
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        Object localObject1 = localSubAccountInfo.subuin;
        ArrayList localArrayList = (ArrayList)this.em.query(SubAccountMessage.class, SubAccountMessage.class.getSimpleName(), false, "subUin=?", new String[] { localObject1 }, null, null, "time desc", null);
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          this.mapSubMsg.put(localObject1, localArrayList);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("init() query subUin:");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" allMsg and put map.list=");
          if (localArrayList == null) {
            localObject1 = null;
          } else {
            localObject1 = Integer.valueOf(localArrayList.size());
          }
          localStringBuilder.append(localObject1);
          QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
        }
        countUnreadDatum(localSubAccountInfo, localArrayList, 0);
      }
      this.lock.unlock();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void addNewMessage(SubAccountMessage paramSubAccountMessage)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      if (paramSubAccountMessage == null)
      {
        localObject1 = "null";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("subUin=");
        ((StringBuilder)localObject1).append(paramSubAccountMessage.subUin);
        ((StringBuilder)localObject1).append(" senderUin=");
        ((StringBuilder)localObject1).append(paramSubAccountMessage.senderuin);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("addNewMessage() ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
    if (!this.mNotifySwitch)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "addNewMessage notify off");
      }
      return;
    }
    if ((paramSubAccountMessage != null) && (paramSubAccountMessage.subUin != null))
    {
      if (paramSubAccountMessage.senderuin == null) {
        return;
      }
      this.lock.lock();
      localObject2 = null;
      try
      {
        Iterator localIterator = this.listSubInfo.iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (SubAccountInfo)localIterator.next();
        } while ((localObject1 == null) || (!paramSubAccountMessage.subUin.equals(((SubAccountInfo)localObject1).subuin)));
        if (this.mapSubMsg.containsKey(paramSubAccountMessage.subUin))
        {
          localObject2 = (ArrayList)this.mapSubMsg.get(paramSubAccountMessage.subUin);
          if (localObject2 == null)
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramSubAccountMessage);
            this.mapSubMsg.put(paramSubAccountMessage.subUin, localObject2);
            countUnreadDatum((SubAccountInfo)localObject1, (ArrayList)localObject2, 1);
          }
          else
          {
            localIterator = ((ArrayList)localObject2).iterator();
            while (localIterator.hasNext())
            {
              SubAccountMessage localSubAccountMessage = (SubAccountMessage)localIterator.next();
              if ((paramSubAccountMessage.subUin.equals(localSubAccountMessage.subUin)) && (paramSubAccountMessage.senderuin.equals(localSubAccountMessage.senderuin)))
              {
                if ((AppConstants.SUBACCOUNT_TROOP_UIN.equals(paramSubAccountMessage.senderuin)) && (paramSubAccountMessage.time == 0L) && (paramSubAccountMessage.unreadNum == 0))
                {
                  paramSubAccountMessage.time = localSubAccountMessage.time;
                }
                else if ((AppConstants.SUBACCOUNT_TROOP_UIN.equals(paramSubAccountMessage.senderuin)) && (paramSubAccountMessage.time <= localSubAccountMessage.time))
                {
                  paramSubAccountMessage.unreadNum = localSubAccountMessage.unreadNum;
                  paramSubAccountMessage.time = localSubAccountMessage.time;
                }
                ((ArrayList)localObject2).remove(localSubAccountMessage);
                this.em.remove(localSubAccountMessage);
              }
            }
            ((ArrayList)localObject2).add(0, paramSubAccountMessage);
            countUnreadDatum((SubAccountInfo)localObject1, (ArrayList)localObject2, 1);
          }
        }
        else
        {
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(paramSubAccountMessage);
          this.mapSubMsg.put(paramSubAccountMessage.subUin, localObject2);
          countUnreadDatum((SubAccountInfo)localObject1, (ArrayList)localObject2, 1);
        }
        this.lock.unlock();
        updateEntity(paramSubAccountMessage);
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  SubAccountMessage buildTroopMsgBox(String paramString)
  {
    SubAccountMessage localSubAccountMessage = new SubAccountMessage();
    localSubAccountMessage.frienduin = String.valueOf(13002L);
    localSubAccountMessage.unreadNum = 0;
    localSubAccountMessage.msgtype = -1000;
    localSubAccountMessage.senderuin = String.valueOf(13002L);
    localSubAccountMessage.subUin = paramString;
    localSubAccountMessage.istroop = 1;
    localSubAccountMessage.sendername = HardCodeUtil.a(2131719336);
    localSubAccountMessage.msg = "";
    return localSubAccountMessage;
  }
  
  public void cancelHintIsNew(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cancelHintIsNew() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString != null)
    {
      if (paramString.length() <= 4) {
        return;
      }
      Object localObject2 = null;
      this.lock.lock();
      try
      {
        Iterator localIterator = this.listSubInfo.iterator();
        SubAccountInfo localSubAccountInfo;
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localSubAccountInfo = (SubAccountInfo)localIterator.next();
        } while (!paramString.equals(localSubAccountInfo.subuin));
        localObject1 = localObject2;
        if (localSubAccountInfo.hintIsNew)
        {
          localSubAccountInfo.hintIsNew = false;
          localObject1 = localSubAccountInfo;
        }
        this.lock.unlock();
        if (localObject1 != null) {
          ThreadManager.getFileThreadHandler().post(new SubAccountServiceImpl.3(this, (SubAccountInfo)localObject1));
        }
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public void clearAllUnNotifySenderNum()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "clearAllUnNotifySenderNum()");
    }
    if (this.listSubInfo == null) {
      return;
    }
    if (this.mapSubMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "clearAllUnNotifySenderNum() mapSubMsg is null.");
      }
      return;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (SubAccountInfo)localIterator.next();
        if (localObject2 != null)
        {
          ((SubAccountInfo)localObject2).unNotifySender = 0;
          localObject2 = ((SubAccountInfo)localObject2).subuin;
          localObject2 = (ArrayList)this.mapSubMsg.get(localObject2);
          if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              SubAccountMessage localSubAccountMessage = (SubAccountMessage)((Iterator)localObject2).next();
              if (localSubAccountMessage.needNotify) {
                localSubAccountMessage.needNotify = false;
              }
            }
          }
        }
      }
      this.lock.unlock();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void clearUnreadNum(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clearUnreadNum() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString == null) {
      return;
    }
    Object localObject1 = this.listSubInfo;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      localObject1 = this.mapSubMsg;
      if ((localObject1 != null) && (((HashMap)localObject1).size() != 0)) {
        this.lock.lock();
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = this.listSubInfo.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
          if ((localObject1 == null) || (!paramString.equals(((SubAccountInfo)localObject1).subuin))) {
            continue;
          }
          ArrayList localArrayList = (ArrayList)this.mapSubMsg.get(paramString);
          if ((localArrayList == null) || (localArrayList.size() == 0)) {
            continue;
          }
          paramString = localArrayList.iterator();
          if (paramString.hasNext())
          {
            localObject2 = (SubAccountMessage)paramString.next();
            if (localObject2 == null) {
              continue;
            }
            if (!((SubAccountMessage)localObject2).needNotify) {
              break label488;
            }
            ((SubAccountMessage)localObject2).needNotify = false;
            i = 1;
            if (((SubAccountMessage)localObject2).unreadNum != 0)
            {
              ((SubAccountMessage)localObject2).unreadNum = 0;
              i = 1;
            }
            if (i == 0) {
              continue;
            }
            updateEntity((Entity)localObject2);
            continue;
          }
          ((SubAccountInfo)localObject1).unNotifySender = 0;
          ((SubAccountInfo)localObject1).unreadMsgNum = 0;
          ((SubAccountInfo)localObject1).unreadSenderNum = 0;
          ((SubAccountInfo)localObject1).unreadTroopMsgNum = 0;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("clearUnreadNum() info.subuin=");
            paramString.append(((SubAccountInfo)localObject1).subuin);
            paramString.append(" unreadMsgNum=");
            paramString.append(((SubAccountInfo)localObject1).unreadMsgNum);
            paramString.append(" unNotify=");
            paramString.append(((SubAccountInfo)localObject1).unNotifySender);
            paramString.append(" unreadSender=");
            paramString.append(((SubAccountInfo)localObject1).unreadSenderNum);
            QLog.d("SUB_ACCOUNT", 2, paramString.toString());
          }
        }
        return;
      }
      finally
      {
        this.lock.unlock();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clearUnreadNum() ");
        if (this.listSubInfo == null) {
          paramString = "listSubInfo == null";
        } else {
          paramString = "listSubInfo.size() == 0";
        }
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clearUnreadNum() ");
        if (this.mapSubMsg == null) {
          paramString = "mapSubMsg == null";
        } else {
          paramString = "mapSubMsg.size() == 0";
        }
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
      }
      return;
      label488:
      int i = 0;
    }
  }
  
  public void countUnreadDatum(SubAccountInfo paramSubAccountInfo, ArrayList<SubAccountMessage> paramArrayList, int paramInt)
  {
    if ((paramSubAccountInfo != null) && (paramArrayList != null))
    {
      Collections.sort(paramArrayList);
      paramArrayList = paramArrayList.iterator();
      int k = 0;
      int i1 = 0;
      int j = 0;
      int i = 0;
      int m = 1;
      Object localObject;
      while (paramArrayList.hasNext())
      {
        localObject = (SubAccountMessage)paramArrayList.next();
        if (localObject != null)
        {
          int n = m;
          if (m != 0)
          {
            if ((((SubAccountMessage)localObject).mEmoRecentMsg == null) && (((SubAccountMessage)localObject).msg != null)) {
              ((SubAccountMessage)localObject).mEmoRecentMsg = new QQText(((SubAccountMessage)localObject).msg, 3, 16);
            }
            paramSubAccountInfo.lastMsg = ((SubAccountMessage)localObject).mEmoRecentMsg;
            long l;
            if (paramSubAccountInfo.lasttime > ((SubAccountMessage)localObject).time) {
              l = paramSubAccountInfo.lasttime;
            } else {
              l = ((SubAccountMessage)localObject).time;
            }
            paramSubAccountInfo.lasttime = l;
            paramSubAccountInfo.lastUin = ((SubAccountMessage)localObject).frienduin;
            paramSubAccountInfo.lastUinNick = ((SubAccountMessage)localObject).sendername;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("countUnreadDatum() change lasttime=");
              localStringBuilder.append(paramSubAccountInfo.lasttime);
              QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
            }
            n = 0;
          }
          int i3;
          int i4;
          int i2;
          if (((SubAccountMessage)localObject).istroop == 1)
          {
            i3 = i + ((SubAccountMessage)localObject).unreadNum;
            i4 = i1;
            i2 = j;
          }
          else
          {
            i4 = i1;
            i2 = j;
            i3 = i;
            if (!((SubAccountMessage)localObject).isread)
            {
              i4 = i1 + ((SubAccountMessage)localObject).unreadNum;
              i2 = j + 1;
              i3 = i;
            }
          }
          i1 = i4;
          j = i2;
          i = i3;
          m = n;
          if (((SubAccountMessage)localObject).needNotify)
          {
            k += 1;
            i1 = i4;
            j = i2;
            i = i3;
            m = n;
          }
        }
      }
      paramSubAccountInfo.unNotifySender = k;
      paramSubAccountInfo.unreadMsgNum = i1;
      paramSubAccountInfo.unreadSenderNum = j;
      paramSubAccountInfo.unreadTroopMsgNum = i;
      if (m != 0)
      {
        paramSubAccountInfo.lastMsg = null;
        paramSubAccountInfo.lasttime = 0L;
        paramSubAccountInfo.lastUin = null;
        paramSubAccountInfo.lastUinNick = null;
      }
      if ((paramInt == 1) && (paramSubAccountInfo.hintIsNew))
      {
        paramSubAccountInfo.hintIsNew = false;
        updateEntity(paramSubAccountInfo);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "countUnreadDatum() set hintIsNew=false");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("countUnreadDatum() info.subuin=");
        ((StringBuilder)localObject).append(paramSubAccountInfo.subuin);
        ((StringBuilder)localObject).append(" unreadMsg=");
        ((StringBuilder)localObject).append(paramSubAccountInfo.unreadMsgNum);
        ((StringBuilder)localObject).append(" unNotify=");
        ((StringBuilder)localObject).append(paramSubAccountInfo.unNotifySender);
        ((StringBuilder)localObject).append(" unreadSender=");
        ((StringBuilder)localObject).append(paramSubAccountInfo.unreadSenderNum);
        ((StringBuilder)localObject).append(" lastUin=");
        ((StringBuilder)localObject).append(paramSubAccountInfo.lastUin);
        ((StringBuilder)localObject).append(" lastNick=");
        if (paramSubAccountInfo.lastUinNick == null) {
          paramArrayList = "null";
        } else {
          paramArrayList = Integer.valueOf(paramSubAccountInfo.lastUinNick.length());
        }
        ((StringBuilder)localObject).append(paramArrayList);
        ((StringBuilder)localObject).append(" lastTime=");
        ((StringBuilder)localObject).append(paramSubAccountInfo.lasttime);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("countUnreadDatum() return,");
      if (paramSubAccountInfo == null) {
        paramSubAccountInfo = "info == null";
      } else {
        paramSubAccountInfo = "list == null";
      }
      paramArrayList.append(paramSubAccountInfo);
      QLog.d("SUB_ACCOUNT", 2, paramArrayList.toString());
    }
  }
  
  public AbsSubAccountMessageProcessor createSubAccountMessageProcessor(AppInterface paramAppInterface, BaseMessageHandler paramBaseMessageHandler)
  {
    return new SubAccountMessageProcessor(paramAppInterface, paramBaseMessageHandler);
  }
  
  public SubAccountMessage findSubAccountMessage(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramString1 != null) && (paramString2 != null))
    {
      Object localObject3 = getAllMessage(paramString1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        if (((List)localObject3).size() == 0) {
          return null;
        }
        localObject3 = ((List)localObject3).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (SubAccountMessage)((Iterator)localObject3).next();
        } while ((localObject1 == null) || (!paramString1.equals(((SubAccountMessage)localObject1).subUin)) || (!paramString2.equals(((SubAccountMessage)localObject1).senderuin)));
      }
      return localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("findSubAccountMessage() return, subUin=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" sendUin=");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public String getA2(String paramString)
  {
    paramString = getSubAccountInfo(paramString);
    if (paramString != null) {
      return paramString.A2;
    }
    return "";
  }
  
  public long getActionTime(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getActionTime() subUin is null.");
      }
      return 0L;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getActionTime() listSubInfo is null.");
      }
      return 0L;
    }
    Object localObject2 = null;
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      Object localObject1;
      boolean bool;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (SubAccountInfo)localIterator.next();
        bool = paramString.equals(((SubAccountInfo)localObject1).subuin);
      } while (!bool);
      this.lock.unlock();
      if (localObject1 != null) {
        return ((SubAccountInfo)localObject1).lasttime;
      }
      return 0L;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<SubAccountMessage> getAllMessage(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    this.lock.lock();
    try
    {
      Object localObject2 = this.mapSubMsg;
      SubAccountMessage localSubAccountMessage = null;
      Object localObject1 = null;
      if ((localObject2 != null) && (this.mapSubMsg.containsKey(paramString)))
      {
        localObject2 = ((ArrayList)this.mapSubMsg.get(paramString)).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localSubAccountMessage = (SubAccountMessage)((Iterator)localObject2).next();
          if (AppConstants.SUBACCOUNT_TROOP_UIN.equals(localSubAccountMessage.senderuin)) {
            localObject1 = localSubAccountMessage;
          } else {
            localArrayList.add(localSubAccountMessage);
          }
        }
        if (!((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
          if (localObject1 == null)
          {
            if (this.mNotifySwitch) {
              localArrayList.add(0, buildTroopMsgBox(paramString));
            }
          }
          else {
            localArrayList.add(0, localObject1);
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getAllMessage() subUin:");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" mspSubMsg=");
          if (this.mapSubMsg == null)
          {
            localObject1 = localSubAccountMessage;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("containsKey=");
            ((StringBuilder)localObject1).append(this.mapSubMsg.containsKey(paramString));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
        }
        if ((!((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) && (this.mNotifySwitch)) {
          localArrayList.add(0, buildTroopMsgBox(paramString));
        }
      }
      this.lock.unlock();
      return localArrayList;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public ArrayList<SubAccountInfo> getAllSubAccountInfo()
  {
    ArrayList localArrayList = new ArrayList();
    this.lock.lock();
    try
    {
      localArrayList.addAll(this.listSubInfo);
      return localArrayList;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public ArrayList<String> getAllSubUin()
  {
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getAllSubUin() listSubInfo is null. return null;");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    this.lock.lock();
    try
    {
      Object localObject2 = this.listSubInfo.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)((Iterator)localObject2).next();
        if (localSubAccountInfo != null) {
          localArrayList.add(localSubAccountInfo.subuin);
        }
      }
      this.lock.unlock();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAllSubUin() return:");
        ((StringBuilder)localObject2).append(String.valueOf(localArrayList));
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
      }
      return localArrayList;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public int getBindedNumber()
  {
    this.lock.lock();
    try
    {
      int i;
      if (this.listSubInfo != null) {
        i = this.listSubInfo.size();
      } else {
        i = 0;
      }
      this.lock.unlock();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBindedNumber() bindedNum=");
        localStringBuilder.append(i);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public byte[] getCookie(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCookie() subUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getCookie() subUin is null.");
      }
      return null;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getCookie() listSubInfo is null.");
      }
      return null;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        localObject = (SubAccountInfo)localIterator.next();
        boolean bool = paramString.equals(((SubAccountInfo)localObject).subuin);
        if (bool)
        {
          paramString = (String)localObject;
          break label142;
        }
      }
      paramString = null;
      label142:
      this.lock.unlock();
      if (paramString != null) {
        return paramString.cookie;
      }
      return null;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public CharSequence getLatestMsg(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestMsg() subUin is null.");
      }
      return null;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestMsg() listSubInfo is null.");
      }
      return null;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        boolean bool = paramString.equals(localSubAccountInfo.subuin);
        if (bool)
        {
          paramString = localSubAccountInfo;
          break label104;
        }
      }
      paramString = null;
      label104:
      this.lock.unlock();
      if (paramString != null) {
        return paramString.lastMsg;
      }
      return null;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public String getLatestUin(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestUin() subUin is null.");
      }
      return null;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestUin() listSubInfo is null.");
      }
      return null;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        boolean bool = paramString.equals(localSubAccountInfo.subuin);
        if (bool)
        {
          paramString = localSubAccountInfo;
          break label104;
        }
      }
      paramString = null;
      label104:
      this.lock.unlock();
      if (paramString != null) {
        return paramString.lastUin;
      }
      return null;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public String getLatestUinNick(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestNick() subUin is null.");
      }
      return null;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestNick() listSubInfo is null.");
      }
      return null;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        boolean bool = paramString.equals(localSubAccountInfo.subuin);
        if (bool)
        {
          paramString = localSubAccountInfo;
          break label104;
        }
      }
      paramString = null;
      label104:
      this.lock.unlock();
      if (paramString != null) {
        return paramString.lastUinNick;
      }
      return null;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public HashMap<String, ArrayList<SubAccountMessage>> getMapSubMsg()
  {
    return this.mapSubMsg;
  }
  
  public boolean getNotifySwitch()
  {
    return this.mNotifySwitch;
  }
  
  public Pair<Integer, String> getServerError(String paramString)
  {
    Pair localPair = null;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getServerError() subUin is null.");
      }
      return null;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getServerError() listSubInfo is null.");
      }
      return null;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      Object localObject = null;
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        boolean bool = paramString.equals(localSubAccountInfo.subuin);
        if (bool) {
          localObject = localSubAccountInfo;
        }
      }
      this.lock.unlock();
      if (localObject != null)
      {
        localPair = new Pair(Integer.valueOf(localObject.serverErrorType), localObject.serverErrorMsg);
        paramString = localPair;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getServerError() findInfo errType=");
          paramString.append(localObject.serverErrorType);
          paramString.append(" errMsg=");
          paramString.append(localObject.serverErrorMsg);
          QLog.d("SUB_ACCOUNT", 2, paramString.toString());
          return localPair;
        }
      }
      else
      {
        paramString = localPair;
        if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "getServerError() findInfo is null.");
          paramString = localPair;
        }
      }
      return paramString;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public int getStatus(String paramString)
  {
    int j = 0;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getStatus() subUin is null.");
      }
      return 0;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getStatus() listSubInfo is null.");
      }
      return 0;
    }
    Object localObject = null;
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        boolean bool = paramString.equals(localSubAccountInfo.subuin);
        if (bool) {
          localObject = localSubAccountInfo;
        }
      }
      this.lock.unlock();
      int i;
      if (localObject != null)
      {
        j = localObject.status;
        i = j;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getStatus() findInfo status=");
          paramString.append(j);
          QLog.d("SUB_ACCOUNT", 2, paramString.toString());
          return j;
        }
      }
      else
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "getStatus() findInfo is null. return default 0");
          i = j;
        }
      }
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public SubAccountInfo getSubAccountInfo(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getSubAccountInfo() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    if (paramString == null) {
      return null;
    }
    this.lock.lock();
    Object localObject1 = localObject2;
    try
    {
      if (this.listSubInfo != null)
      {
        Iterator localIterator = this.listSubInfo.iterator();
        boolean bool;
        do
        {
          do
          {
            localObject1 = localObject2;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (SubAccountInfo)localIterator.next();
          } while (localObject1 == null);
          if ("sub.uin.default".equals(paramString)) {
            break;
          }
          bool = paramString.equals(((SubAccountInfo)localObject1).subuin);
        } while (!bool);
      }
      this.lock.unlock();
      return localObject1;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public int getUnNotifySenderNum(String paramString)
  {
    int i = 0;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnNotificationSenderNum() subUin is null.");
      }
      return 0;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnNotificationSenderNum() listSubInfo is null.");
      }
      return 0;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        if (paramString.equals(localSubAccountInfo.subuin)) {
          i = localSubAccountInfo.unNotifySender;
        }
      }
      this.lock.unlock();
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public int getUnreadAllMsgNum(String paramString)
  {
    int i = 0;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnreadAllMsgNum() subUin is null.");
      }
      return 0;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnreadAllMsgNum() listSubInfo is null.");
      }
      return 0;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        if (paramString.equals(localSubAccountInfo.subuin)) {
          i = localSubAccountInfo.unreadMsgNum;
        }
      }
      this.lock.unlock();
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public int getUnreadAllTroopMsgNum(String paramString)
  {
    int i = 0;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnreadAllTroopMsgNum() subUin is null.");
      }
      return 0;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnreadAllTroopMsgNum() listSubInfo is null.");
      }
      return 0;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        if (paramString.equals(localSubAccountInfo.subuin)) {
          i = localSubAccountInfo.unreadTroopMsgNum;
        }
      }
      this.lock.unlock();
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public int getUnreadSenderNum(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUnreadSenderNum() subUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnreadSenderNum() listSubInfo is null.");
      }
      return 0;
    }
    this.lock.lock();
    try
    {
      localObject = this.listSubInfo.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)((Iterator)localObject).next();
        if (paramString.equals(localSubAccountInfo.subuin)) {
          i = localSubAccountInfo.unreadSenderNum;
        }
      }
      this.lock.unlock();
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean hintIsNew(String paramString)
  {
    boolean bool2 = false;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "hintIsNew() subUin is null.");
      }
      return false;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      SubAccountInfo localSubAccountInfo;
      do
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        localSubAccountInfo = (SubAccountInfo)localIterator.next();
      } while (!paramString.equals(localSubAccountInfo.subuin));
      boolean bool1 = localSubAccountInfo.hintIsNew;
      this.lock.unlock();
      return bool1;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean isRecentListTop(String paramString)
  {
    boolean bool2 = false;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "isRecentListTop() subUin is null.");
      }
      return false;
    }
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      SubAccountInfo localSubAccountInfo;
      do
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        localSubAccountInfo = (SubAccountInfo)localIterator.next();
      } while (!paramString.equals(localSubAccountInfo.subuin));
      boolean bool1 = localSubAccountInfo.isTop;
      this.lock.unlock();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isRecentListTop() subUin.top=");
        paramString.append(bool1);
        QLog.d("SUB_ACCOUNT", 2, paramString.toString());
      }
      return bool1;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean isSubAccountUin(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSubAccountUin() , subUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool2 = false;
    if (paramString == null) {
      return false;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "isSubAccountUin() listSubInfo is null.");
      }
      return false;
    }
    this.lock.lock();
    try
    {
      localObject = this.listSubInfo.iterator();
      do
      {
        SubAccountInfo localSubAccountInfo;
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localSubAccountInfo = (SubAccountInfo)((Iterator)localObject).next();
        } while (localSubAccountInfo == null);
        bool1 = paramString.equals(localSubAccountInfo.subuin);
      } while (!bool1);
      boolean bool1 = true;
      this.lock.unlock();
      return bool1;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    this.em = this.mApp.getEntityManagerFactory().createEntityManager();
    List localList = this.em.query(SubAccountInfo.class);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initSubAccountInfos() uin=");
      localStringBuilder.append(this.mApp.getCurrentAccountUin());
      localStringBuilder.append(" result=");
      if (localList == null) {
        paramAppRuntime = null;
      } else {
        paramAppRuntime = Integer.valueOf(localList.size());
      }
      localStringBuilder.append(paramAppRuntime);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    if (localList != null)
    {
      if (localList.size() == 0) {
        return;
      }
      this.listSubInfo.clear();
      this.listSubInfo.addAll(localList);
      inflateMsgData();
      this.mNotifySwitch = SettingCloneUtil.readValue(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, new Object[] { "NotifySwitch ", Boolean.valueOf(this.mNotifySwitch) });
      }
    }
  }
  
  public void onDestroy()
  {
    this.lock.lock();
    try
    {
      this.listSubInfo.clear();
      this.mapSubMsg.clear();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void removeAllMessage()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "removeAllMessage()");
    }
    this.lock.lock();
    try
    {
      this.mapSubMsg.clear();
      if (this.listSubInfo != null)
      {
        Iterator localIterator = this.listSubInfo.iterator();
        while (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          localSubAccountInfo.unNotifySender = 0;
          localSubAccountInfo.unreadSenderNum = 0;
          localSubAccountInfo.unreadMsgNum = 0;
          localSubAccountInfo.unreadTroopMsgNum = 0;
          localSubAccountInfo.lastMsg = null;
          localSubAccountInfo.lastUin = null;
          localSubAccountInfo.lastUinNick = null;
          updateEntity(localSubAccountInfo);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("removeAllMessage() info.subuin=");
            localStringBuilder.append(localSubAccountInfo.subuin);
            localStringBuilder.append(" unreadMsg=");
            localStringBuilder.append(localSubAccountInfo.unreadMsgNum);
            localStringBuilder.append(" unNotify=");
            localStringBuilder.append(localSubAccountInfo.unNotifySender);
            localStringBuilder.append(" unreadSender=");
            localStringBuilder.append(localSubAccountInfo.unreadSenderNum);
            QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
          }
        }
      }
      this.lock.unlock();
      this.em.drop(SubAccountMessage.class.getSimpleName());
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void removeAllMessage(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("removeAllMessage() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString == null) {
      return;
    }
    this.lock.lock();
    try
    {
      if (this.mapSubMsg.containsKey(paramString))
      {
        localObject1 = (List)this.mapSubMsg.remove(paramString);
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SubAccountMessage)((Iterator)localObject1).next();
            this.em.remove((Entity)localObject2);
          }
        }
      }
      Object localObject2 = this.listSubInfo.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
      } while ((localObject1 == null) || (!paramString.equals(((SubAccountInfo)localObject1).subuin)));
      paramString = (String)localObject1;
    }
    finally
    {
      for (;;)
      {
        this.lock.unlock();
        for (;;)
        {
          throw paramString;
        }
        paramString = null;
      }
    }
    if (paramString != null)
    {
      paramString.unNotifySender = 0;
      paramString.unreadSenderNum = 0;
      paramString.unreadMsgNum = 0;
      paramString.unreadTroopMsgNum = 0;
      paramString.lastMsg = null;
      paramString.lastUin = null;
      paramString.lastUinNick = null;
      updateEntity(paramString);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("removeAllMessage() info.subuin=");
        ((StringBuilder)localObject1).append(paramString.subuin);
        ((StringBuilder)localObject1).append(" unreadMsg=");
        ((StringBuilder)localObject1).append(paramString.unreadMsgNum);
        ((StringBuilder)localObject1).append(" unNotify=");
        ((StringBuilder)localObject1).append(paramString.unNotifySender);
        ((StringBuilder)localObject1).append(" unreadSender=");
        ((StringBuilder)localObject1).append(paramString.unreadSenderNum);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
      }
    }
    this.lock.unlock();
  }
  
  public void removeAllSubAccount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "removeAllSubAccount()");
    }
    this.lock.lock();
    try
    {
      this.listSubInfo.clear();
      this.lock.unlock();
      this.em.drop(SubAccountInfo.class.getSimpleName());
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public int removeMessage(String paramString1, String paramString2)
  {
    int j = 0;
    if ((paramString1 != null) && (paramString2 != null)) {
      this.lock.lock();
    }
    for (;;)
    {
      try
      {
        if (this.mapSubMsg.containsKey(paramString1))
        {
          ArrayList localArrayList = (ArrayList)this.mapSubMsg.get(paramString1);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            i = localArrayList.size() - 1;
            Object localObject3 = null;
            if (i < 0) {
              break label382;
            }
            localObject1 = (SubAccountMessage)localArrayList.get(i);
            if ((!paramString1.equals(((SubAccountMessage)localObject1).subUin)) || (!paramString2.equals(((SubAccountMessage)localObject1).senderuin))) {
              break label375;
            }
            localArrayList.remove(i);
            i = 0 - ((SubAccountMessage)localObject1).unreadNum;
            Iterator localIterator = this.listSubInfo.iterator();
            Object localObject2 = localObject3;
            if (localIterator.hasNext())
            {
              localObject2 = (SubAccountInfo)localIterator.next();
              if ((localObject2 == null) || (!paramString1.equals(((SubAccountInfo)localObject2).subuin))) {
                continue;
              }
            }
            countUnreadDatum((SubAccountInfo)localObject2, localArrayList, 2);
            this.lock.unlock();
            if (localObject1 != null) {
              this.em.remove((Entity)localObject1);
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("removeMessage() subUin=");
              ((StringBuilder)localObject1).append(paramString1);
              ((StringBuilder)localObject1).append(" sendUin=");
              ((StringBuilder)localObject1).append(paramString2);
              ((StringBuilder)localObject1).append(" changedNum=");
              ((StringBuilder)localObject1).append(i);
              QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
            }
            return i;
          }
        }
        return 0;
      }
      finally
      {
        this.lock.unlock();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("removeMessage() return, NULL, subUin=");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" sendUin=");
        ((StringBuilder)localObject1).append(paramString2);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
      }
      return 0;
      label375:
      i -= 1;
      continue;
      label382:
      Object localObject1 = null;
      int i = j;
    }
  }
  
  public void removeSubAccountInfo(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("removeSubAccountInfo() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString == null) {
      return;
    }
    this.lock.lock();
    Object localObject2 = null;
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (SubAccountInfo)localIterator.next();
      } while (!paramString.equals(((SubAccountInfo)localObject1).subuin));
      this.listSubInfo.remove(localObject1);
      this.lock.unlock();
      if (localObject1 != null) {
        this.em.remove((Entity)localObject1);
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void saveSubAccountInfo(SubAccountInfo paramSubAccountInfo)
  {
    boolean bool = QLog.isColorLevel();
    Object localObject2 = "saveInfo is null.";
    Object localObject3;
    Object localObject1;
    if (bool)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("saveSubAccountInfo() ");
      if (paramSubAccountInfo == null)
      {
        localObject1 = "saveInfo is null.";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("saveInfo.subuin=");
        ((StringBuilder)localObject1).append(paramSubAccountInfo.subuin);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject3).toString());
    }
    if ((paramSubAccountInfo != null) && (paramSubAccountInfo.subuin != null))
    {
      if (this.listSubInfo == null) {
        this.listSubInfo = new ArrayList();
      }
      localObject1 = null;
      this.lock.lock();
      try
      {
        localObject3 = this.listSubInfo.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (SubAccountInfo)((Iterator)localObject3).next();
          if (paramSubAccountInfo.subuin.equals(((SubAccountInfo)localObject2).subuin))
          {
            ((SubAccountInfo)localObject2).cloneTo(paramSubAccountInfo);
            localObject1 = localObject2;
          }
        }
        this.lock.unlock();
        if (localObject1 != null) {
          updateEntity((Entity)localObject1);
        }
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("saveSubAccountInfo() ");
      if (paramSubAccountInfo == null) {
        paramSubAccountInfo = (SubAccountInfo)localObject2;
      } else {
        paramSubAccountInfo = "saveInfo.subuin is null";
      }
      ((StringBuilder)localObject1).append(paramSubAccountInfo);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void setActionTime(String paramString, long paramLong)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setActionTime() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" time=");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString == null) {
      return;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setActionTime() listSubInfo is null.");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setActionTime() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" change lasttime=");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (SubAccountInfo)localIterator.next();
      } while (!paramString.equals(((SubAccountInfo)localObject1).subuin));
      ((SubAccountInfo)localObject1).lasttime = paramLong;
      this.lock.unlock();
      if (localObject1 != null) {
        ThreadManager.getFileThreadHandler().post(new SubAccountServiceImpl.2(this, (SubAccountInfo)localObject1));
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void setAllMessageReaded(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setAllSubMessageReaded() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString == null) {
      return;
    }
    this.lock.lock();
    try
    {
      if (this.mapSubMsg.containsKey(paramString))
      {
        localObject1 = (List)this.mapSubMsg.get(paramString);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SubAccountMessage)((Iterator)localObject1).next();
            ((SubAccountMessage)localObject2).isread = true;
            ((SubAccountMessage)localObject2).needNotify = false;
            ((SubAccountMessage)localObject2).unreadNum = 0;
          }
          Object localObject2 = null;
          Iterator localIterator = this.listSubInfo.iterator();
          do
          {
            localObject1 = localObject2;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (SubAccountInfo)localIterator.next();
          } while ((localObject1 == null) || (!paramString.equals(((SubAccountInfo)localObject1).subuin)));
          if (localObject1 != null)
          {
            ((SubAccountInfo)localObject1).unNotifySender = 0;
            ((SubAccountInfo)localObject1).unreadSenderNum = 0;
            ((SubAccountInfo)localObject1).unreadSenderNum = 0;
            ((SubAccountInfo)localObject1).unreadMsgNum = 0;
            ((SubAccountInfo)localObject1).unreadTroopMsgNum = 0;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("setAllMessageReaded() info.subuin=");
              ((StringBuilder)localObject2).append(((SubAccountInfo)localObject1).subuin);
              ((StringBuilder)localObject2).append(" unreadMsg=");
              ((StringBuilder)localObject2).append(((SubAccountInfo)localObject1).unreadMsgNum);
              ((StringBuilder)localObject2).append(" unNotify=");
              ((StringBuilder)localObject2).append(((SubAccountInfo)localObject1).unNotifySender);
              ((StringBuilder)localObject2).append(" unreadSender=");
              ((StringBuilder)localObject2).append(((SubAccountInfo)localObject1).unreadSenderNum);
              QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
            }
          }
          this.lock.unlock();
          localObject1 = new SubAccountMessage().getTableName();
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("isread", Boolean.valueOf(true));
          ((ContentValues)localObject2).put("unreadNum", Integer.valueOf(0));
          boolean bool = this.em.update((String)localObject1, (ContentValues)localObject2, "subUin=?", new String[] { paramString });
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("setAllSubMessageReaded() set isRead and unreadNum, result");
            paramString.append(bool);
            QLog.d("SUB_ACCOUNT", 2, paramString.toString());
          }
          return;
        }
      }
      this.lock.unlock();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void setNotifySwitch(boolean paramBoolean)
  {
    this.mNotifySwitch = paramBoolean;
  }
  
  public void setRecentListTop(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setRecentListTop() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" isTop=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString != null)
    {
      if (paramString.length() < 5) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setRecentListTop() subUin=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" isTop=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = null;
      this.lock.lock();
      try
      {
        Iterator localIterator = this.listSubInfo.iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (SubAccountInfo)localIterator.next();
        } while (!paramString.equals(((SubAccountInfo)localObject1).subuin));
        ((SubAccountInfo)localObject1).isTop = paramBoolean;
        this.lock.unlock();
        if (localObject1 != null) {
          updateEntity((Entity)localObject1);
        }
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public boolean setStatus(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setStatus() subUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" status=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = false;
    if (paramString == null) {
      return false;
    }
    Object localObject = null;
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        boolean bool2 = paramString.equals(localSubAccountInfo.subuin);
        if (bool2) {
          localObject = localSubAccountInfo;
        }
      }
      this.lock.unlock();
      if (localObject != null)
      {
        if (((SubAccountInfo)localObject).status != paramInt)
        {
          if ((paramInt == 2) || (paramInt == 3))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("setStatus() need2setMsgNum_1=");
              paramString.append(true);
              QLog.d("SUB_ACCOUNT", 2, paramString.toString());
            }
            bool1 = true;
          }
          ((SubAccountInfo)localObject).status = paramInt;
          updateEntity((Entity)localObject);
          return bool1;
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setStatus() findInfo is null. return default 0");
      }
      return false;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void updateA2(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateA2() subUin=");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" A2=");
      if (paramString2 == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(paramString2.length());
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(" change=");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateA2() subUin is null.");
      }
      return;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateA2() listSubInfo is null.");
      }
      return;
    }
    this.lock.lock();
    try
    {
      localObject2 = this.listSubInfo.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
      } while (!paramString1.equals(((SubAccountInfo)localObject1).subuin));
      j = 1;
      if (((paramString2 != null) || (((SubAccountInfo)localObject1).A2 == null)) && ((paramString2 == null) || (paramString2.equals(((SubAccountInfo)localObject1).A2)))) {
        break label469;
      }
      if (paramBoolean)
      {
        ((SubAccountInfo)localObject1).lasttime = (System.currentTimeMillis() / 1000L);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("updateA2() change lasttime=");
          paramString1.append(((SubAccountInfo)localObject1).lasttime);
          QLog.d("SUB_ACCOUNT", 2, paramString1.toString());
        }
      }
      ((SubAccountInfo)localObject1).A2 = paramString2;
      if (paramString2 != null) {
        break label463;
      }
      ((SubAccountInfo)localObject1).hintIsNew = false;
      if (!QLog.isColorLevel()) {
        break label463;
      }
      QLog.d("SUB_ACCOUNT", 2, "updateA2() set hintIsNew=false");
    }
    finally
    {
      for (;;)
      {
        int j;
        this.lock.unlock();
        for (;;)
        {
          throw paramString1;
        }
        int i = 1;
        continue;
        i = 0;
      }
    }
    if (paramString2 == null)
    {
      ((SubAccountInfo)localObject1).cookie = null;
      if (((SubAccountInfo)localObject1).status == 0)
      {
        ((SubAccountInfo)localObject1).status = 3;
        i = j;
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("updateA2() change status=");
          paramString1.append(((SubAccountInfo)localObject1).status);
          QLog.d("SUB_ACCOUNT", 2, paramString1.toString());
          i = j;
        }
      }
    }
    else
    {
      ((SubAccountInfo)localObject1).serverErrorMsg = null;
      ((SubAccountInfo)localObject1).serverErrorType = 0;
    }
    if (i != 0) {
      paramString1 = (String)localObject1;
    } else {
      paramString1 = null;
    }
    this.lock.unlock();
    if (paramString1 != null) {
      ThreadManager.getFileThreadHandler().post(new SubAccountServiceImpl.1(this, paramString1));
    }
  }
  
  public void updateAnotherSubAccountUnreadMsg(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mNotifySwitch))
    {
      Object localObject1 = (IConversationFacade)this.mApp.getRuntimeService(IConversationFacade.class, "");
      int i = ((IConversationFacade)localObject1).getUnreadCount(paramString, 7000);
      int j = ((IConversationFacade)localObject1).getUnreadCountFromExtInt2(paramString, 7000);
      if ((i <= 0) && (j <= 0))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("cur uin no unreadMsg uin=");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" troopUnread=");
        ((StringBuilder)localObject2).append(j);
        QLog.d("SUB_ACCOUNT", 2, new Object[] { "cur uin has unreadMsg: c2cUnread=", Integer.valueOf(i), ((StringBuilder)localObject2).toString(), " uin=", paramString });
      }
      paramString = this.listSubInfo.iterator();
      while (paramString.hasNext())
      {
        localObject2 = (SubAccountInfo)paramString.next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject2).subuin)) && (((SubAccountInfo)localObject2).status == 1))
        {
          ISubAccountControlService.SubAccountUnReadItem localSubAccountUnReadItem = SubAccountControllUtil.a(this.mApp, ((SubAccountInfo)localObject2).subuin);
          j = ((IConversationFacade)localObject1).getUnreadCount(((SubAccountInfo)localObject2).subuin, 7000);
          int k = ((IConversationFacade)localObject1).getUnreadCountFromExtInt2(((SubAccountInfo)localObject2).subuin, 7000);
          Object localObject3;
          if ((!localSubAccountUnReadItem.jdField_a_of_type_Boolean) && (j != localSubAccountUnReadItem.jdField_a_of_type_Int))
          {
            ((IConversationFacade)localObject1).increaseUnread(((SubAccountInfo)localObject2).subuin, 7000, localSubAccountUnReadItem.jdField_a_of_type_Int - j);
          }
          else if ((localSubAccountUnReadItem.jdField_a_of_type_Boolean) && (localSubAccountUnReadItem.jdField_a_of_type_Int != k))
          {
            localObject3 = ((SubAccountInfo)localObject2).subuin;
            if (localSubAccountUnReadItem.jdField_a_of_type_Int > 0) {
              i = 1;
            } else {
              i = 0;
            }
            ((IConversationFacade)localObject1).setSubAccountTroopUnReadMsg((String)localObject3, 7000, i);
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder("updateAnotherSubAccountUnreadMsg");
            ((StringBuilder)localObject3).append(" info.subuin=");
            ((StringBuilder)localObject3).append(((SubAccountInfo)localObject2).subuin);
            ((StringBuilder)localObject3).append(" anotherC2cUnread=");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append(" anotherTroopUnread=");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append(" item.showRedDot=");
            ((StringBuilder)localObject3).append(localSubAccountUnReadItem.jdField_a_of_type_Boolean);
            ((StringBuilder)localObject3).append(" item.unReadCount=");
            ((StringBuilder)localObject3).append(localSubAccountUnReadItem.jdField_a_of_type_Int);
            QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, new Object[] { "cur uin=", paramString, " mNotifySwitch=", Boolean.valueOf(this.mNotifySwitch) });
    }
  }
  
  public void updateCookie(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCookie() subUin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" cookie=");
      if (paramArrayOfByte == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramArrayOfByte.length);
      }
      localStringBuilder.append(localObject);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateCookie() subUin is null.");
      }
      return;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateCookie() listSubInfo is null.");
      }
      return;
    }
    StringBuilder localStringBuilder = null;
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      do
      {
        localObject = localStringBuilder;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (SubAccountInfo)localIterator.next();
      } while (!paramString.equals(((SubAccountInfo)localObject).subuin));
      ((SubAccountInfo)localObject).cookie = paramArrayOfByte;
      this.lock.unlock();
      if (localObject != null) {
        updateEntity((Entity)localObject);
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  boolean updateEntity(Entity paramEntity)
  {
    boolean bool2 = this.em.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.em.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.em.update(paramEntity);
      }
    }
    return false;
  }
  
  public void updateMsgData2SupportSubUin(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateMsgData2SupportSubUin() subuin==null");
      }
      return;
    }
    Object localObject = new SubAccountMessage().getTableName();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("subUin", paramString);
    boolean bool = this.em.update((String)localObject, localContentValues, null, null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateMsgData2SupportSubUin() set subUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" result");
      ((StringBuilder)localObject).append(bool);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      inflateMsgData();
      return;
    }
    removeAllMessage();
  }
  
  public void updateMsgTimeStr(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateSubAccountMsgTimeStr() dateFormate=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString == null) {
      return;
    }
    Object localObject1 = this.listSubInfo;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      localObject1 = this.mapSubMsg;
      if ((localObject1 != null) && (((HashMap)localObject1).size() != 0))
      {
        this.lock.lock();
        try
        {
          localObject1 = this.listSubInfo.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (SubAccountInfo)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject2 = ((SubAccountInfo)localObject2).subuin;
              localObject2 = (ArrayList)this.mapSubMsg.get(localObject2);
              if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
              {
                localObject2 = ((ArrayList)localObject2).iterator();
                int i = 1;
                while (((Iterator)localObject2).hasNext())
                {
                  SubAccountMessage localSubAccountMessage = (SubAccountMessage)((Iterator)localObject2).next();
                  if (localSubAccountMessage != null)
                  {
                    localSubAccountMessage.mTimeString = TimeFormatterUtils.a(localSubAccountMessage.time * 1000L, true, paramString);
                    if (i != 0) {
                      i = 0;
                    }
                  }
                }
              }
            }
          }
          return;
        }
        finally
        {
          this.lock.unlock();
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateSubAccountMsgTimeStr() ");
      if (this.listSubInfo == null) {
        paramString = "listSubInfo == null";
      } else {
        paramString = "listSubInfo.size() == 0";
      }
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateSubAccountMsgTimeStr() ");
      if (this.mapSubMsg == null) {
        paramString = "mapSubMsg == null";
      } else {
        paramString = "mapSubMsg.size() == 0";
      }
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void updateNotifySwitch(AppInterface paramAppInterface)
  {
    this.mNotifySwitch = SettingCloneUtil.readValue(paramAppInterface.getApp(), paramAppInterface.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, new Object[] { "updateNotifySwitch ", Boolean.valueOf(this.mNotifySwitch) });
    }
    if (!this.mNotifySwitch)
    {
      paramAppInterface = getAllSubUin();
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.iterator();
        while (paramAppInterface.hasNext()) {
          setAllMessageReaded((String)paramAppInterface.next());
        }
      }
      removeAllMessage();
    }
  }
  
  public void updateServerError(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateServerError() subUin=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" error type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" msg=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateServerError() subUin is null.");
      }
      return;
    }
    if (this.listSubInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateServerError() listSubInfo is null.");
      }
      return;
    }
    Object localObject = null;
    this.lock.lock();
    try
    {
      Iterator localIterator = this.listSubInfo.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        if (paramString1.equals(localSubAccountInfo.subuin))
        {
          localSubAccountInfo.serverErrorType = paramInt;
          localSubAccountInfo.serverErrorMsg = paramString2;
          localObject = localSubAccountInfo;
        }
      }
      this.lock.unlock();
      if (localObject != null) {
        updateEntity((Entity)localObject);
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void updateSubAccountInfo(SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    boolean bool = QLog.isColorLevel();
    Object localObject2 = "data == null";
    Object localObject3;
    Object localObject1;
    if (bool)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("addAllSubAccountInfo() ");
      if (paramSubAccountBackProtocData == null)
      {
        localObject1 = "data == null";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("data.mMainAccount=");
        ((StringBuilder)localObject1).append(paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(" data.mSubUin=");
        ((StringBuilder)localObject1).append(paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject3).toString());
    }
    if ((paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString != null) && (paramSubAccountBackProtocData.c()))
    {
      localObject3 = paramSubAccountBackProtocData.a();
      localObject1 = paramSubAccountBackProtocData.c();
      ArrayList localArrayList1 = paramSubAccountBackProtocData.b();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addAllSubAccountInfo() allSubUin:");
        ((StringBuilder)localObject2).append(((ArrayList)localObject1).toString());
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("removeOverdueSubAccountInfo() overdueUin:");
        ((StringBuilder)localObject2).append(localArrayList1.toString());
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
      }
      ArrayList localArrayList2 = new ArrayList();
      this.lock.lock();
      try
      {
        Iterator localIterator1 = ((ArrayList)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          localObject2 = null;
          Iterator localIterator2 = this.listSubInfo.iterator();
          do
          {
            localObject1 = localObject2;
            if (!localIterator2.hasNext()) {
              break;
            }
            localObject1 = (SubAccountInfo)localIterator2.next();
          } while ((!paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString.equals(((SubAccountInfo)localObject1).trunkuin)) || (!str.equals(((SubAccountInfo)localObject1).subuin)));
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new SubAccountInfo();
            this.listSubInfo.add(localObject2);
          }
          ((SubAccountInfo)localObject2).subuin = str;
          ((SubAccountInfo)localObject2).trunkuin = paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString;
          ((SubAccountInfo)localObject2).serverErrorType = paramSubAccountBackProtocData.jdField_b_of_type_Int;
          ((SubAccountInfo)localObject2).serverErrorMsg = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          if ((localObject3 != null) && (((ArrayList)localObject3).contains(str)))
          {
            ((SubAccountInfo)localObject2).hintIsNew = true;
            ((SubAccountInfo)localObject2).lasttime = (System.currentTimeMillis() / 1000L);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("addSubAccountInfo() change subUin=");
              ((StringBuilder)localObject1).append(((SubAccountInfo)localObject2).subuin);
              ((StringBuilder)localObject1).append(" hintIsNew=");
              ((StringBuilder)localObject1).append(((SubAccountInfo)localObject2).hintIsNew);
              ((StringBuilder)localObject1).append(" lasttime=");
              ((StringBuilder)localObject1).append(((SubAccountInfo)localObject2).lasttime);
              QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
            }
          }
          localArrayList2.add(localObject2);
        }
        if ((localArrayList1 != null) && (localArrayList1.size() > 0))
        {
          paramSubAccountBackProtocData = localArrayList1.iterator();
          while (paramSubAccountBackProtocData.hasNext()) {
            removeSubAccountInfo((String)paramSubAccountBackProtocData.next());
          }
        }
        this.lock.unlock();
        if (localArrayList2.size() > 0)
        {
          paramSubAccountBackProtocData = localArrayList2.iterator();
          while (paramSubAccountBackProtocData.hasNext()) {
            updateEntity((SubAccountInfo)paramSubAccountBackProtocData.next());
          }
        }
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addAllSubAccountInfo() return,");
      if (paramSubAccountBackProtocData == null)
      {
        paramSubAccountBackProtocData = (SubAccountBackProtocData)localObject2;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("data.mMainAccount=");
        ((StringBuilder)localObject2).append(paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" data.mSubUin=");
        ((StringBuilder)localObject2).append(paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString);
        paramSubAccountBackProtocData = ((StringBuilder)localObject2).toString();
      }
      ((StringBuilder)localObject1).append(paramSubAccountBackProtocData);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void updateTroopMsgRedDot(SubAccountMessage paramSubAccountMessage)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      if (paramSubAccountMessage == null)
      {
        localObject1 = "null";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("subUin=");
        ((StringBuilder)localObject1).append(paramSubAccountMessage.subUin);
        ((StringBuilder)localObject1).append(" senderUin=");
        ((StringBuilder)localObject1).append(paramSubAccountMessage.senderuin);
        ((StringBuilder)localObject1).append(" msg.time=");
        ((StringBuilder)localObject1).append(paramSubAccountMessage.time);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateTroopMsgRedDot() ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
    if (!this.mNotifySwitch)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateTroopMsgRedDot notify off");
      }
      return;
    }
    if ((paramSubAccountMessage != null) && (paramSubAccountMessage.subUin != null))
    {
      if (paramSubAccountMessage.senderuin == null) {
        return;
      }
      this.lock.lock();
    }
    for (;;)
    {
      try
      {
        bool1 = this.mapSubMsg.containsKey(paramSubAccountMessage.subUin);
        boolean bool2 = true;
        if (!bool1) {
          break label514;
        }
        localObject1 = (ArrayList)this.mapSubMsg.get(paramSubAccountMessage.subUin);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label514;
          }
          localObject2 = (SubAccountMessage)((Iterator)localObject1).next();
          if ((!paramSubAccountMessage.subUin.equals(((SubAccountMessage)localObject2).subUin)) || (!paramSubAccountMessage.senderuin.equals(((SubAccountMessage)localObject2).senderuin))) {
            continue;
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateTroopMsgRedDot() tMsg.time=");
            localStringBuilder.append(((SubAccountMessage)localObject2).time);
            QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
          }
          if ((AppConstants.SUBACCOUNT_TROOP_UIN.equals(paramSubAccountMessage.senderuin)) && (paramSubAccountMessage.time > ((SubAccountMessage)localObject2).time))
          {
            bool1 = bool2;
          }
          else
          {
            if ((!AppConstants.SUBACCOUNT_TROOP_UIN.equals(paramSubAccountMessage.senderuin)) || (paramSubAccountMessage.unreadNum != 0) || (paramSubAccountMessage.time != 0L)) {
              continue;
            }
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "updateTroopMsgRedDot() list is empty");
            bool1 = bool2;
          }
        }
        if (bool1) {
          ((IConversationFacade)this.mApp.getRuntimeService(IConversationFacade.class, "")).setSubAccountTroopUnReadMsg(paramSubAccountMessage.subUin, 7000, paramSubAccountMessage.unreadNum);
        }
        if (QLog.isColorLevel())
        {
          paramSubAccountMessage = new StringBuilder();
          paramSubAccountMessage.append("updateTroopMsgRedDot() needUpdate=");
          paramSubAccountMessage.append(bool1);
          QLog.d("SUB_ACCOUNT", 2, paramSubAccountMessage.toString());
        }
        return;
      }
      finally
      {
        this.lock.unlock();
      }
      return;
      label514:
      boolean bool1 = false;
    }
  }
  
  public void updateUnreadNum(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "updateUnreadNum");
    }
    SubAccountMessage localSubAccountMessage = findSubAccountMessage(paramString1, paramString2);
    if (localSubAccountMessage == null) {
      return;
    }
    this.lock.lock();
    try
    {
      int i = localSubAccountMessage.unreadNum;
      i -= paramInt;
      if (i == 0)
      {
        this.lock.unlock();
        return;
      }
      localSubAccountMessage.unreadNum = paramInt;
      Object localObject = null;
      Iterator localIterator = this.listSubInfo.iterator();
      boolean bool;
      do
      {
        do
        {
          paramString2 = localObject;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString2 = (SubAccountInfo)localIterator.next();
        } while (paramString2 == null);
        bool = paramString1.equals(paramString2.subuin);
      } while (!bool);
      if (paramString2 == null)
      {
        this.lock.unlock();
        return;
      }
      if (localSubAccountMessage.istroop == 1)
      {
        paramString2.unreadTroopMsgNum -= i;
        paramString2.unreadTroopMsgNum = Math.max(0, paramString2.unreadTroopMsgNum);
      }
      else
      {
        paramString2.unreadMsgNum -= i;
      }
      this.lock.unlock();
      updateEntity(localSubAccountMessage);
      SubAccountControllUtil.a(paramAppInterface, paramString1, 6);
      ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).increaseUnread(paramString1, 7000, -i);
      ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, paramString1 });
      ((IAppBadgeService)paramAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
      paramAppInterface = new SubAccountBackProtocData();
      paramAppInterface.jdField_c_of_type_JavaLangString = paramString1;
      paramAppInterface.jdField_c_of_type_Boolean = true;
      paramAppInterface.d = true;
      paramAppInterface.jdField_a_of_type_Int = 0;
      ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).notifyBusinessMessage(8003, true, paramAppInterface);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl
 * JD-Core Version:    0.7.0.1
 */