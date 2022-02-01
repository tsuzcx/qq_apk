package com.tencent.mobileqq.confess;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;

public class ConfessManager
  implements Manager
{
  QQAppInterface a;
  ConfessConfig b;
  final FrdConfessInfo c;
  final ConfessCache d;
  final ArrayList<ConfessManager.FrdChatExtra> e;
  final Object f = new Object();
  ConfessManager.FrdChatExtra g = null;
  ConfessManager.FrdChatExtra h = null;
  final ArrayList<ConfessManager.GroupChatExtra> i;
  final Object j = new Object();
  ConfessManager.GroupChatExtra k = null;
  ConfessManager.GroupChatExtra l = null;
  
  public ConfessManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.e = new ArrayList();
    this.c = new FrdConfessInfo(paramQQAppInterface.getAccount());
    this.d = new ConfessCache();
    this.b = new ConfessConfig(this.a.getAccount());
    ThreadManager.post(new ConfessManager.1(this), 5, null, true);
    this.i = new ArrayList();
  }
  
  private ConfessManager.FrdChatExtra b(String paramString1, String paramString2, int paramInt)
  {
    ConfessManager.FrdChatExtra localFrdChatExtra;
    label154:
    synchronized (this.e)
    {
      Object localObject = this.e.iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label154;
        }
        localFrdChatExtra = (ConfessManager.FrdChatExtra)((Iterator)localObject).next();
        if ((localFrdChatExtra != null) && (localFrdChatExtra.a == paramInt) && (TextUtils.equals(localFrdChatExtra.h, paramString1)) && (TextUtils.equals(localFrdChatExtra.i, paramString2))) {
          break;
        }
      }
      localObject = localFrdChatExtra;
      if (localFrdChatExtra == null)
      {
        localObject = new ConfessManager.FrdChatExtra();
        ((ConfessManager.FrdChatExtra)localObject).h = paramString1;
        ((ConfessManager.FrdChatExtra)localObject).i = paramString2;
        ((ConfessManager.FrdChatExtra)localObject).a = paramInt;
        ((ConfessManager.FrdChatExtra)localObject).m = 0;
        this.e.add(localObject);
      }
      return localObject;
    }
  }
  
  private ConfessManager.GroupChatExtra c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    ConfessManager.GroupChatExtra localGroupChatExtra;
    label194:
    synchronized (this.i)
    {
      Object localObject = this.i.iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label194;
        }
        localGroupChatExtra = (ConfessManager.GroupChatExtra)((Iterator)localObject).next();
        if ((localGroupChatExtra != null) && (localGroupChatExtra.c == paramInt) && (TextUtils.equals(localGroupChatExtra.a, paramString1)) && (TextUtils.equals(localGroupChatExtra.h, paramString2)) && (TextUtils.equals(localGroupChatExtra.b, paramString3)) && (TextUtils.equals(localGroupChatExtra.i, paramString4))) {
          break;
        }
      }
      localObject = localGroupChatExtra;
      if (localGroupChatExtra == null)
      {
        localObject = new ConfessManager.GroupChatExtra();
        ((ConfessManager.GroupChatExtra)localObject).a = paramString1;
        ((ConfessManager.GroupChatExtra)localObject).h = paramString2;
        ((ConfessManager.GroupChatExtra)localObject).b = paramString3;
        ((ConfessManager.GroupChatExtra)localObject).i = paramString4;
        ((ConfessManager.GroupChatExtra)localObject).c = paramInt;
        ((ConfessManager.GroupChatExtra)localObject).m = 0;
        this.i.add(localObject);
      }
      return localObject;
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject1 = this.a.getMessageFacade().a(paramString1, 0, new int[] { -2065 });
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForConfessNews))
        {
          localObject2 = (MessageForConfessNews)localObject2;
          ((MessageForConfessNews)localObject2).parse();
          if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).strConfessorUin)) && (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)))
          {
            m = 2;
            break label132;
          }
        }
      }
    }
    int m = 1;
    label132:
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkNeedAddConfessElem frdUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt), Integer.valueOf(m) }));
    }
    return m;
  }
  
  public ConfessConfig a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessManager", 2, "getConfigSync");
    }
    this.b.a();
    return this.b;
  }
  
  public void a(RedTouchItem paramRedTouchItem)
  {
    if (paramRedTouchItem == null) {
      return;
    }
    if (!this.c.a) {
      this.c.a();
    }
    boolean bool;
    if ((this.c.c >= paramRedTouchItem.lastRecvTime) && (this.c.b == paramRedTouchItem.count)) {
      bool = false;
    } else {
      bool = true;
    }
    if (bool)
    {
      this.c.a(paramRedTouchItem);
      ConfessMsgUtil.a(this.a, false, false);
      ((ConfessHandler)this.a.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).b(this.c);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "onFrdRecNewConfess bNeedUpdate: %s, info: %s", new Object[] { Boolean.valueOf(bool), this.c }));
    }
  }
  
  public void a(String paramString)
  {
    ConfessManager.FrdChatExtra localFrdChatExtra = this.g;
    Integer localInteger = null;
    this.g = null;
    if (localFrdChatExtra != null)
    {
      this.h = localFrdChatExtra;
      if (localFrdChatExtra.m == 1) {
        ThreadManager.postImmediately(new ConfessManager.3(this, paramString, localFrdChatExtra), null, false);
      }
    }
    if (QLog.isDevelopLevel())
    {
      Locale localLocale = Locale.getDefault();
      if (localFrdChatExtra != null) {
        localInteger = Integer.valueOf(localFrdChatExtra.m);
      }
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveFrdRecConfessChat frdUin: %s, flag: %s", new Object[] { paramString, localInteger }));
    }
  }
  
  public void a(String paramString, ConfessManager.FrdChatExtra paramFrdChatExtra)
  {
    if (paramFrdChatExtra != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      synchronized (this.f)
      {
        if (paramFrdChatExtra.m == 1)
        {
          paramString = this.a.getMessageFacade().a(paramString, 0, new int[] { -2065 });
          if ((paramString != null) && (paramString.size() > 0))
          {
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)paramString.next();
              if ((localMessageRecord instanceof MessageForConfessNews))
              {
                MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)localMessageRecord;
                localMessageForConfessNews.parse();
                if ((localMessageForConfessNews.nTopicId == paramFrdChatExtra.a) && (TextUtils.equals(paramFrdChatExtra.i, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramFrdChatExtra.h, localMessageForConfessNews.strRecUin)))
                {
                  this.a.getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.a.getMessageFacade().h(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeFrdConfessNews frdUin: %s confessorUin: %s topicId: %s", new Object[] { paramFrdChatExtra.h, paramFrdChatExtra.i, Integer.valueOf(paramFrdChatExtra.a) }));
        }
        return;
      }
    }
  }
  
  public void a(String paramString, ConfessManager.FrdChatExtra paramFrdChatExtra, long paramLong1, long paramLong2)
  {
    if (paramFrdChatExtra != null) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    label263:
    for (;;)
    {
      synchronized (this.f)
      {
        if (paramFrdChatExtra.m == 0) {
          paramFrdChatExtra.m = a(paramString, paramFrdChatExtra.h, paramFrdChatExtra.i, paramFrdChatExtra.a);
        }
        int m = paramFrdChatExtra.m;
        if (m != 1) {
          break label263;
        }
        Object localObject2;
        try
        {
          String str1 = paramFrdChatExtra.a();
          if (TextUtils.isEmpty(str1)) {
            break label263;
          }
          localObject2 = MessageRecordFactory.a(-2065);
          String str2 = this.a.getCurrentAccountUin();
          try
          {
            ((MessageRecord)localObject2).init(str2, paramString, paramString, str1, paramLong1, -2065, 0, paramLong2);
            ((MessageRecord)localObject2).isread = true;
            if (MessageHandlerUtils.a(this.a, (MessageRecord)localObject2, false)) {
              continue;
            }
            this.a.getMessageFacade().a((MessageRecord)localObject2, ((MessageRecord)localObject2).selfuin);
          }
          catch (Exception localException1) {}
          localObject2 = new StringBuilder();
        }
        catch (Exception localException2) {}
        ((StringBuilder)localObject2).append("addFrdConfessNews error: ");
        ((StringBuilder)localObject2).append(localException2.getMessage());
        QLog.i("ConfessManager", 1, ((StringBuilder)localObject2).toString());
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addFrdConfessNews frdUin: %s recUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramFrdChatExtra.h, paramFrdChatExtra.i, Integer.valueOf(paramFrdChatExtra.a) }));
        }
        return;
      }
      return;
    }
  }
  
  public void a(String paramString, ConfessManager.GroupChatExtra paramGroupChatExtra)
  {
    if (paramGroupChatExtra != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      synchronized (this.j)
      {
        if (paramGroupChatExtra.m == 1)
        {
          paramString = this.a.getMessageFacade().a(paramString, 1, new int[] { -2065 });
          if ((paramString != null) && (paramString.size() > 0))
          {
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)paramString.next();
              if ((localMessageRecord instanceof MessageForConfessNews))
              {
                MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)localMessageRecord;
                localMessageForConfessNews.parse();
                if ((localMessageForConfessNews.nTopicId == paramGroupChatExtra.c) && (TextUtils.equals(paramGroupChatExtra.a, localMessageForConfessNews.strGroupUin)) && (TextUtils.equals(paramGroupChatExtra.i, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramGroupChatExtra.b, localMessageForConfessNews.senderuin)) && (TextUtils.equals(paramGroupChatExtra.h, localMessageForConfessNews.strRecUin)))
                {
                  this.a.getMessageFacade().a(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.a.getMessageFacade().h(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeGroupConfessNews groupUin: %s, strRecUin: %s, sendUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramGroupChatExtra.a, paramGroupChatExtra.h, paramGroupChatExtra.b, paramGroupChatExtra.i, Integer.valueOf(paramGroupChatExtra.c) }));
        }
        return;
      }
    }
  }
  
  public void a(String paramString, ConfessManager.GroupChatExtra paramGroupChatExtra, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramGroupChatExtra != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      synchronized (this.j)
      {
        if (paramGroupChatExtra.m == 0) {
          paramGroupChatExtra.m = b(paramString, paramGroupChatExtra.h, paramGroupChatExtra.b, paramGroupChatExtra.i, paramGroupChatExtra.c);
        }
        int m = paramGroupChatExtra.m;
        if (m == 1) {
          try
          {
            String str = paramGroupChatExtra.a();
            if (!TextUtils.isEmpty(str))
            {
              localObject2 = MessageRecordFactory.a(-2065);
              ((MessageRecord)localObject2).init(this.a.getCurrentAccountUin(), paramString, paramGroupChatExtra.b, str, paramLong1, -2065, 1, paramLong2);
              ((MessageRecord)localObject2).isread = true;
              ((MessageRecord)localObject2).shmsgseq = paramLong3;
              if (QLog.isDevelopLevel()) {
                QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 1 %s", new Object[] { Long.valueOf(paramLong3) }));
              }
              if (!MessageHandlerUtils.a(this.a, (MessageRecord)localObject2, false))
              {
                this.a.getMessageFacade().a((MessageRecord)localObject2, ((MessageRecord)localObject2).selfuin);
                if (QLog.isDevelopLevel()) {
                  QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 2", new Object[0]));
                }
              }
            }
          }
          catch (Exception localException)
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("addGroupConfessNews error: ");
            ((StringBuilder)localObject2).append(localException.getMessage());
            QLog.i("ConfessManager", 1, ((StringBuilder)localObject2).toString());
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews groupUin: %s recUin: %s, sendUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramGroupChatExtra.h, paramGroupChatExtra.b, paramGroupChatExtra.i, Integer.valueOf(paramGroupChatExtra.c) }));
        }
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    b(paramString1, paramString2, paramInt).m = 2;
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markFrdChatExtra recUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    c(paramString1, paramString2, paramString3, paramString4, paramInt).m = 2;
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markGroupChatExtra groupUin: %s recUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    Object localObject1 = this.i.iterator();
    Object localObject2;
    for (;;)
    {
      boolean bool2 = ((Iterator)localObject1).hasNext();
      bool1 = true;
      if (!bool2) {
        break;
      }
      localObject2 = (ConfessManager.GroupChatExtra)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if ((((ConfessManager.GroupChatExtra)localObject2).c == paramInt) && (TextUtils.equals(((ConfessManager.GroupChatExtra)localObject2).a, paramString1)) && (TextUtils.equals(((ConfessManager.GroupChatExtra)localObject2).h, paramString2)) && (TextUtils.equals(((ConfessManager.GroupChatExtra)localObject2).b, paramString3)) && (TextUtils.equals(((ConfessManager.GroupChatExtra)localObject2).i, paramString4)))
        {
          if (((ConfessManager.GroupChatExtra)localObject2).n)
          {
            ((ConfessManager.GroupChatExtra)localObject2).n = false;
            break label343;
          }
          localObject1 = this.a.getMessageFacade().a(paramString1, 1, 6);
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          int m = 0;
          while (m < ((List)localObject1).size())
          {
            localObject2 = (MessageRecord)((List)localObject1).get(m);
            if ((localObject2 instanceof MessageForConfessNews))
            {
              localObject2 = (MessageForConfessNews)localObject2;
              ((MessageForConfessNews)localObject2).parse();
              if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) && (TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) && (TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) && (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)))
              {
                int n = m + 1;
                if (n < ((List)localObject1).size())
                {
                  localObject2 = (MessageRecord)((List)localObject1).get(n);
                  this.a.getMessageFacade().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
                }
              }
            }
            m += 1;
          }
        }
      }
    }
    boolean bool1 = false;
    label343:
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkUpdateGroupMessageForConfessNewsShmsgseq find: ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(" shmsgseq: ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.i("ConfessManager", 4, ((StringBuilder)localObject1).toString());
    }
    if (bool1)
    {
      localObject1 = this.a.getMessageFacade().a(paramString1, 1, new int[] { -2065 });
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject2 instanceof MessageForConfessNews))
          {
            localObject2 = (MessageForConfessNews)localObject2;
            ((MessageForConfessNews)localObject2).parse();
            if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin))) {
              if ((TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) && (TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)))
              {
                if (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin))
                {
                  this.a.getMessageFacade().a(((MessageForConfessNews)localObject2).frienduin, ((MessageForConfessNews)localObject2).istroop, ((MessageForConfessNews)localObject2).uniseq, paramLong, ((MessageForConfessNews)localObject2).time);
                  if (!QLog.isDevelopLevel()) {
                    break;
                  }
                  QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq updated");
                }
              }
              else {}
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIntent == null) {
        return false;
      }
      String str1 = paramIntent.getStringExtra("key_confess_rec_uin");
      String str2 = paramIntent.getStringExtra("key_confessor_uin");
      int m = paramIntent.getIntExtra("key_confess_topicid", 0);
      String str3 = paramIntent.getStringExtra("key_confess_desc");
      String str4 = paramIntent.getStringExtra("key_confessor_nick");
      int n = paramIntent.getIntExtra("key_confessor_sex", 0);
      int i1 = paramIntent.getIntExtra("key_confess_bg_type", 0);
      String str5 = paramIntent.getStringExtra("key_confess_rec_nick_name");
      long l1 = paramIntent.getLongExtra("key_confess_time", 0L);
      if ((TextUtils.equals(paramString, str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str3)))
      {
        if (m == 0) {
          return false;
        }
        paramIntent = b(str1, str2, m);
        if (!TextUtils.isEmpty(str5)) {
          paramIntent.g = str5;
        }
        paramIntent.k = str4;
        paramIntent.c = n;
        paramIntent.j = str3;
        paramIntent.b = i1;
        paramIntent.l = l1;
        this.g = paramIntent;
        if (paramIntent.m != 2) {
          ThreadManager.postImmediately(new ConfessManager.2(this, paramString), null, false);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRecConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str1, str2, Integer.valueOf(m), Integer.valueOf(paramIntent.m) }));
        }
        return true;
      }
    }
    return false;
  }
  
  public int b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject1 = this.a.getMessageFacade().a(paramString1, 1, new int[] { -2065 });
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForConfessNews))
        {
          localObject2 = (MessageForConfessNews)localObject2;
          ((MessageForConfessNews)localObject2).parse();
          if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) && (TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) && (TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) && (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)))
          {
            m = 2;
            break label157;
          }
        }
      }
    }
    int m = 1;
    label157:
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkGroupNeedAddConfessElem groupUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, paramString4, Integer.valueOf(paramInt), Integer.valueOf(m) }));
    }
    return m;
  }
  
  public FrdConfessInfo b()
  {
    if (!this.c.a) {
      this.c.a();
    }
    return this.c;
  }
  
  public boolean b(String paramString)
  {
    ConfessManager.FrdChatExtra localFrdChatExtra = this.g;
    if ((!TextUtils.isEmpty(paramString)) && (localFrdChatExtra != null))
    {
      if (!TextUtils.equals(localFrdChatExtra.h, paramString)) {
        return false;
      }
      if (localFrdChatExtra.m == 0) {
        localFrdChatExtra.m = a(paramString, localFrdChatExtra.h, localFrdChatExtra.i, localFrdChatExtra.a);
      }
      return localFrdChatExtra.m == 1;
    }
    return false;
  }
  
  public boolean b(String paramString, Intent paramIntent)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramIntent != null) && (this.a != null))
    {
      int m = paramIntent.getIntExtra("key_confess_topicid", 0);
      String str1 = paramIntent.getStringExtra("key_confess_desc");
      String str2 = paramIntent.getStringExtra("key_confessor_uin");
      String str3 = paramIntent.getStringExtra("key_confessor_nick");
      int n = paramIntent.getIntExtra("key_confessor_sex", 0);
      int i1 = paramIntent.getIntExtra("key_confess_bg_type", 0);
      String str4 = paramIntent.getStringExtra("key_confess_rec_uin");
      String str5 = paramIntent.getStringExtra("key_confess_rec_nick_name");
      long l1 = paramIntent.getLongExtra("key_confess_time", 0L);
      int i2 = paramIntent.getIntExtra("key_confess_rec_nick_type", 0);
      paramIntent = this.a.getCurrentUin();
      if ((!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str1)) && (m != 0))
      {
        ConfessManager.GroupChatExtra localGroupChatExtra = c(paramString, str4, paramIntent, str2, m);
        if (!TextUtils.isEmpty(str5)) {
          localGroupChatExtra.f = str5;
        }
        localGroupChatExtra.k = str3;
        localGroupChatExtra.e = n;
        localGroupChatExtra.j = str1;
        localGroupChatExtra.d = i1;
        localGroupChatExtra.l = l1;
        localGroupChatExtra.g = i2;
        this.k = localGroupChatExtra;
        if (localGroupChatExtra.m != 2) {
          ThreadManager.postImmediately(new ConfessManager.4(this, paramString, localGroupChatExtra), null, false);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat recUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str4, paramIntent, str2, Integer.valueOf(m), Integer.valueOf(localGroupChatExtra.m) }));
        }
        return true;
      }
      return false;
    }
    return false;
  }
  
  public ConfessCache c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    ConfessManager.GroupChatExtra localGroupChatExtra = this.k;
    Integer localInteger = null;
    this.k = null;
    if (localGroupChatExtra != null)
    {
      this.l = localGroupChatExtra;
      if (localGroupChatExtra.m == 1) {
        ThreadManager.postImmediately(new ConfessManager.5(this, paramString, localGroupChatExtra), null, false);
      }
    }
    if (QLog.isDevelopLevel())
    {
      Locale localLocale = Locale.getDefault();
      if (localGroupChatExtra != null) {
        localInteger = Integer.valueOf(localGroupChatExtra.m);
      }
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveGroupRecConfessChat groupUin: %s, flag: %s", new Object[] { paramString, localInteger }));
    }
  }
  
  public boolean c(String paramString, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIntent == null) {
        return false;
      }
      String str1 = paramIntent.getStringExtra("key_confess_rec_uin");
      String str2 = paramIntent.getStringExtra("key_confessor_uin");
      int m = paramIntent.getIntExtra("key_confess_topicid", 0);
      String str3 = paramIntent.getStringExtra("key_confessor_nick");
      int n = paramIntent.getIntExtra("key_confessor_sex", 0);
      int i1 = paramIntent.getIntExtra("key_confessor_friend_sex", 0);
      String str4 = paramIntent.getStringExtra("key_confess_desc");
      int i2 = paramIntent.getIntExtra("key_confess_bg_type", 0);
      long l1 = paramIntent.getLongExtra("key_confess_time", 0L);
      int i3 = paramIntent.getIntExtra("key_confessor_num", 0);
      if ((TextUtils.equals(paramString, str1)) && (!TextUtils.isEmpty(str4)))
      {
        if (m == 0) {
          return false;
        }
        paramIntent = b(str1, str2, m);
        paramIntent.c = n;
        paramIntent.e = i1;
        paramIntent.j = str4;
        paramIntent.k = str3;
        paramIntent.b = i2;
        paramIntent.l = l1;
        paramIntent.d = i3;
        paramIntent.f = 1;
        this.g = paramIntent;
        if (paramIntent.m != 2) {
          ThreadManager.postImmediately(new ConfessManager.6(this, paramString), null, false);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRankConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s, friendSex: %s, extra.strConfessorNick : %s", new Object[] { str1, str2, Integer.valueOf(m), Integer.valueOf(paramIntent.m), Integer.valueOf(i1), paramIntent.k }));
        }
        return true;
      }
    }
    return false;
  }
  
  public ConfessConfig d()
  {
    return this.b;
  }
  
  public boolean d(String paramString)
  {
    ConfessManager.GroupChatExtra localGroupChatExtra = this.k;
    if ((!TextUtils.isEmpty(paramString)) && (localGroupChatExtra != null))
    {
      if (!TextUtils.equals(localGroupChatExtra.a, paramString)) {
        return false;
      }
      if (localGroupChatExtra.m == 0) {
        localGroupChatExtra.m = b(paramString, localGroupChatExtra.h, localGroupChatExtra.b, localGroupChatExtra.i, localGroupChatExtra.c);
      }
      return localGroupChatExtra.m == 1;
    }
    return false;
  }
  
  public ConfessManager.FrdChatExtra e()
  {
    return this.g;
  }
  
  public ConfessManager.GroupChatExtra f()
  {
    return this.k;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager
 * JD-Core Version:    0.7.0.1
 */