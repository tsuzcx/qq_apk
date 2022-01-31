package com.tencent.mobileqq.confess;

import abyt;
import abyu;
import abyv;
import abyw;
import abyx;
import abyy;
import abyz;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
  public abyy a;
  public abyz a;
  public QQAppInterface a;
  final ConfessCache jdField_a_of_type_ComTencentMobileqqConfessConfessCache;
  ConfessConfig jdField_a_of_type_ComTencentMobileqqConfessConfessConfig;
  public final FrdConfessInfo a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  final ArrayList jdField_a_of_type_JavaUtilArrayList;
  abyy jdField_b_of_type_Abyy = null;
  abyz jdField_b_of_type_Abyz = null;
  final Object jdField_b_of_type_JavaLangObject = new Object();
  final ArrayList jdField_b_of_type_JavaUtilArrayList;
  
  public ConfessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Abyy = null;
    this.jdField_a_of_type_Abyz = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo = new FrdConfessInfo(paramQQAppInterface.getAccount());
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessCache = new ConfessCache();
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessConfig = new ConfessConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ThreadManager.post(new abyt(this), 5, null, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private abyy a(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localabyy = (abyy)((Iterator)localObject).next();
          if ((localabyy == null) || (localabyy.jdField_a_of_type_Int != paramInt) || (!TextUtils.equals(localabyy.jdField_b_of_type_JavaLangString, paramString1)) || (!TextUtils.equals(localabyy.jdField_c_of_type_JavaLangString, paramString2))) {
            continue;
          }
          localObject = localabyy;
          if (localabyy == null)
          {
            localObject = new abyy();
            ((abyy)localObject).jdField_b_of_type_JavaLangString = paramString1;
            ((abyy)localObject).jdField_c_of_type_JavaLangString = paramString2;
            ((abyy)localObject).jdField_a_of_type_Int = paramInt;
            ((abyy)localObject).jdField_d_of_type_Int = 0;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          return localObject;
        }
      }
      abyy localabyy = null;
    }
  }
  
  private abyz a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localabyz = (abyz)((Iterator)localObject).next();
          if ((localabyz == null) || (localabyz.jdField_a_of_type_Int != paramInt) || (!TextUtils.equals(localabyz.jdField_a_of_type_JavaLangString, paramString1)) || (!TextUtils.equals(localabyz.jdField_d_of_type_JavaLangString, paramString2)) || (!TextUtils.equals(localabyz.jdField_b_of_type_JavaLangString, paramString3)) || (!TextUtils.equals(localabyz.jdField_e_of_type_JavaLangString, paramString4))) {
            continue;
          }
          localObject = localabyz;
          if (localabyz == null)
          {
            localObject = new abyz();
            ((abyz)localObject).jdField_a_of_type_JavaLangString = paramString1;
            ((abyz)localObject).jdField_d_of_type_JavaLangString = paramString2;
            ((abyz)localObject).jdField_b_of_type_JavaLangString = paramString3;
            ((abyz)localObject).jdField_e_of_type_JavaLangString = paramString4;
            ((abyz)localObject).jdField_a_of_type_Int = paramInt;
            ((abyz)localObject).jdField_e_of_type_Int = 0;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          }
          return localObject;
        }
      }
      abyz localabyz = null;
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, new int[] { -2065 });
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof MessageForConfessNews));
        localObject2 = (MessageForConfessNews)localObject2;
        ((MessageForConfessNews)localObject2).parse();
      } while ((((MessageForConfessNews)localObject2).nTopicId != paramInt) || (!TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).strConfessorUin)) || (!TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)));
    }
    for (int i = 2;; i = 1)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkNeedAddConfessElem frdUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt), Integer.valueOf(i) }));
      }
      return i;
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1, new int[] { -2065 });
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof MessageForConfessNews));
        localObject2 = (MessageForConfessNews)localObject2;
        ((MessageForConfessNews)localObject2).parse();
      } while ((((MessageForConfessNews)localObject2).nTopicId != paramInt) || (!TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) || (!TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) || (!TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) || (!TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)));
    }
    for (int i = 2;; i = 1)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkGroupNeedAddConfessElem groupUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, paramString4, Integer.valueOf(paramInt), Integer.valueOf(i) }));
      }
      return i;
    }
  }
  
  public abyy a()
  {
    return this.jdField_a_of_type_Abyy;
  }
  
  public abyz a()
  {
    return this.jdField_a_of_type_Abyz;
  }
  
  public ConfessCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfessConfessCache;
  }
  
  public ConfessConfig a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessManager", 2, "getConfigSync");
    }
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessConfig.a();
    return this.jdField_a_of_type_ComTencentMobileqqConfessConfessConfig;
  }
  
  public FrdConfessInfo a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo;
  }
  
  public void a(RedTouchItem paramRedTouchItem)
  {
    if (paramRedTouchItem == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.jdField_a_of_type_Long < paramRedTouchItem.lastRecvTime) || (this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.jdField_a_of_type_Int != paramRedTouchItem.count)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.a(paramRedTouchItem);
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false);
        ((ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125)).b(this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "onFrdRecNewConfess bNeedUpdate: %s, info: %s", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo }));
      return;
    }
  }
  
  public void a(String paramString)
  {
    Integer localInteger = null;
    abyy localabyy = this.jdField_a_of_type_Abyy;
    this.jdField_a_of_type_Abyy = null;
    if (localabyy != null)
    {
      this.jdField_b_of_type_Abyy = localabyy;
      if (localabyy.jdField_d_of_type_Int == 1) {
        ThreadManager.postImmediately(new abyv(this, paramString, localabyy), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (localabyy != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveFrdRecConfessChat frdUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label90:
      localInteger = Integer.valueOf(localabyy.jdField_d_of_type_Int);
    }
  }
  
  public void a(String paramString, abyy paramabyy)
  {
    if ((paramabyy == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramabyy.jdField_d_of_type_Int == 1)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0, new int[] { -2065 });
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
                if ((localMessageForConfessNews.nTopicId == paramabyy.jdField_a_of_type_Int) && (TextUtils.equals(paramabyy.jdField_c_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramabyy.jdField_b_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeFrdConfessNews frdUin: %s confessorUin: %s topicId: %s", new Object[] { paramabyy.jdField_b_of_type_JavaLangString, paramabyy.jdField_c_of_type_JavaLangString, Integer.valueOf(paramabyy.jdField_a_of_type_Int) }));
  }
  
  public void a(String paramString, abyy paramabyy, long paramLong1, long paramLong2)
  {
    if ((paramabyy == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramabyy.jdField_d_of_type_Int == 0) {
          paramabyy.jdField_d_of_type_Int = a(paramString, paramabyy.jdField_b_of_type_JavaLangString, paramabyy.jdField_c_of_type_JavaLangString, paramabyy.jdField_a_of_type_Int);
        }
        int i = paramabyy.jdField_d_of_type_Int;
        if (i == 1) {}
        try
        {
          String str = paramabyy.a();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = MessageRecordFactory.a(-2065);
            localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramString, str, paramLong1, -2065, 0, paramLong2);
            localMessageRecord.isread = true;
            if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
            }
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addFrdConfessNews frdUin: %s recUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramabyy.jdField_b_of_type_JavaLangString, paramabyy.jdField_c_of_type_JavaLangString, Integer.valueOf(paramabyy.jdField_a_of_type_Int) }));
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("ConfessManager", 1, "addFrdConfessNews error: " + localException.getMessage());
          }
        }
      }
    }
  }
  
  public void a(String paramString, abyz paramabyz)
  {
    if ((paramabyz == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramabyz.jdField_e_of_type_Int == 1)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1, new int[] { -2065 });
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
                if ((localMessageForConfessNews.nTopicId == paramabyz.jdField_a_of_type_Int) && (TextUtils.equals(paramabyz.jdField_a_of_type_JavaLangString, localMessageForConfessNews.strGroupUin)) && (TextUtils.equals(paramabyz.jdField_e_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramabyz.jdField_b_of_type_JavaLangString, localMessageForConfessNews.senderuin)) && (TextUtils.equals(paramabyz.jdField_d_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeGroupConfessNews groupUin: %s, strRecUin: %s, sendUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramabyz.jdField_a_of_type_JavaLangString, paramabyz.jdField_d_of_type_JavaLangString, paramabyz.jdField_b_of_type_JavaLangString, paramabyz.jdField_e_of_type_JavaLangString, Integer.valueOf(paramabyz.jdField_a_of_type_Int) }));
  }
  
  public void a(String paramString, abyz paramabyz, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramabyz == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramabyz.jdField_e_of_type_Int == 0) {
          paramabyz.jdField_e_of_type_Int = a(paramString, paramabyz.jdField_d_of_type_JavaLangString, paramabyz.jdField_b_of_type_JavaLangString, paramabyz.jdField_e_of_type_JavaLangString, paramabyz.jdField_a_of_type_Int);
        }
        int i = paramabyz.jdField_e_of_type_Int;
        if (i == 1) {}
        try
        {
          String str = paramabyz.a();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = MessageRecordFactory.a(-2065);
            localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramabyz.jdField_b_of_type_JavaLangString, str, paramLong1, -2065, 1, paramLong2);
            localMessageRecord.isread = true;
            localMessageRecord.shmsgseq = paramLong3;
            if (QLog.isDevelopLevel()) {
              QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 1 %s", new Object[] { Long.valueOf(paramLong3) }));
            }
            if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
              if (QLog.isDevelopLevel()) {
                QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 2", new Object[0]));
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("ConfessManager", 1, "addGroupConfessNews error: " + localException.getMessage());
          }
        }
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews groupUin: %s recUin: %s, sendUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramabyz.jdField_d_of_type_JavaLangString, paramabyz.jdField_b_of_type_JavaLangString, paramabyz.jdField_e_of_type_JavaLangString, Integer.valueOf(paramabyz.jdField_a_of_type_Int) }));
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt).jdField_d_of_type_Int = 2;
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markFrdChatExtra recUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramInt).jdField_e_of_type_Int = 2;
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markGroupChatExtra groupUin: %s recUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    Object localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (abyz)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((abyz)localObject2).jdField_a_of_type_Int == paramInt) && (TextUtils.equals(((abyz)localObject2).jdField_a_of_type_JavaLangString, paramString1)) && (TextUtils.equals(((abyz)localObject2).jdField_d_of_type_JavaLangString, paramString2)) && (TextUtils.equals(((abyz)localObject2).jdField_b_of_type_JavaLangString, paramString3)) && (TextUtils.equals(((abyz)localObject2).jdField_e_of_type_JavaLangString, paramString4))) {
        if (((abyz)localObject2).jdField_a_of_type_Boolean) {
          ((abyz)localObject2).jdField_a_of_type_Boolean = false;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq find: " + bool + " shmsgseq: " + paramLong);
      }
      if (bool)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1, new int[] { -2065 });
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
              if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) && (TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) && (TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) && (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)))
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForConfessNews)localObject2).frienduin, ((MessageForConfessNews)localObject2).istroop, ((MessageForConfessNews)localObject2).uniseq, paramLong, ((MessageForConfessNews)localObject2).time);
                if (QLog.isDevelopLevel()) {
                  QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq updated");
                }
              }
            }
          }
        }
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    abyy localabyy = this.jdField_a_of_type_Abyy;
    if ((TextUtils.isEmpty(paramString)) || (localabyy == null) || (!TextUtils.equals(localabyy.jdField_b_of_type_JavaLangString, paramString))) {
      bool = false;
    }
    do
    {
      return bool;
      if (localabyy.jdField_d_of_type_Int == 0) {
        localabyy.jdField_d_of_type_Int = a(paramString, localabyy.jdField_b_of_type_JavaLangString, localabyy.jdField_c_of_type_JavaLangString, localabyy.jdField_a_of_type_Int);
      }
    } while (localabyy.jdField_d_of_type_Int == 1);
    return false;
  }
  
  public boolean a(String paramString, Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntent == null)) {
      return false;
    }
    String str1 = paramIntent.getStringExtra("key_confess_rec_uin");
    String str2 = paramIntent.getStringExtra("key_confessor_uin");
    int i = paramIntent.getIntExtra("key_confess_topicid", 0);
    String str3 = paramIntent.getStringExtra("key_confess_desc");
    String str4 = paramIntent.getStringExtra("key_confessor_nick");
    int j = paramIntent.getIntExtra("key_confessor_sex", 0);
    int k = paramIntent.getIntExtra("key_confess_bg_type", 0);
    String str5 = paramIntent.getStringExtra("key_confess_rec_nick_name");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    if ((!TextUtils.equals(paramString, str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str3)) || (i == 0)) {
      return false;
    }
    paramIntent = a(str1, str2, i);
    if (!TextUtils.isEmpty(str5)) {
      paramIntent.jdField_a_of_type_JavaLangString = str5;
    }
    paramIntent.jdField_e_of_type_JavaLangString = str4;
    paramIntent.jdField_c_of_type_Int = j;
    paramIntent.jdField_d_of_type_JavaLangString = str3;
    paramIntent.jdField_b_of_type_Int = k;
    paramIntent.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Abyy = paramIntent;
    if (paramIntent.jdField_d_of_type_Int != 2) {
      ThreadManager.postImmediately(new abyu(this, paramString), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRecConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramIntent.jdField_d_of_type_Int) }));
    }
    return true;
  }
  
  public ConfessConfig b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfessConfessConfig;
  }
  
  public void b(String paramString)
  {
    Integer localInteger = null;
    abyz localabyz = this.jdField_a_of_type_Abyz;
    this.jdField_a_of_type_Abyz = null;
    if (localabyz != null)
    {
      this.jdField_b_of_type_Abyz = localabyz;
      if (localabyz.jdField_e_of_type_Int == 1) {
        ThreadManager.postImmediately(new abyx(this, paramString, localabyz), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (localabyz != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveGroupRecConfessChat groupUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label90:
      localInteger = Integer.valueOf(localabyz.jdField_e_of_type_Int);
    }
  }
  
  public boolean b(String paramString)
  {
    abyz localabyz = this.jdField_a_of_type_Abyz;
    if ((TextUtils.isEmpty(paramString)) || (localabyz == null) || (!TextUtils.equals(localabyz.jdField_a_of_type_JavaLangString, paramString))) {
      return false;
    }
    if (localabyz.jdField_e_of_type_Int == 0) {
      localabyz.jdField_e_of_type_Int = a(paramString, localabyz.jdField_d_of_type_JavaLangString, localabyz.jdField_b_of_type_JavaLangString, localabyz.jdField_e_of_type_JavaLangString, localabyz.jdField_a_of_type_Int);
    }
    return localabyz.jdField_e_of_type_Int == 1;
  }
  
  public boolean b(String paramString, Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    int i = paramIntent.getIntExtra("key_confess_topicid", 0);
    String str1 = paramIntent.getStringExtra("key_confess_desc");
    String str2 = paramIntent.getStringExtra("key_confessor_uin");
    String str3 = paramIntent.getStringExtra("key_confessor_nick");
    int j = paramIntent.getIntExtra("key_confessor_sex", 0);
    int k = paramIntent.getIntExtra("key_confess_bg_type", 0);
    String str4 = paramIntent.getStringExtra("key_confess_rec_uin");
    String str5 = paramIntent.getStringExtra("key_confess_rec_nick_name");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    int m = paramIntent.getIntExtra("key_confess_rec_nick_type", 0);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1)) || (i == 0)) {
      return false;
    }
    abyz localabyz = a(paramString, str4, paramIntent, str2, i);
    if (!TextUtils.isEmpty(str5)) {
      localabyz.jdField_c_of_type_JavaLangString = str5;
    }
    localabyz.g = str3;
    localabyz.jdField_c_of_type_Int = j;
    localabyz.f = str1;
    localabyz.jdField_b_of_type_Int = k;
    localabyz.jdField_a_of_type_Long = l;
    localabyz.jdField_d_of_type_Int = m;
    this.jdField_a_of_type_Abyz = localabyz;
    if (localabyz.jdField_e_of_type_Int != 2) {
      ThreadManager.postImmediately(new abyw(this, paramString, localabyz), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat recUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str4, paramIntent, str2, Integer.valueOf(i), Integer.valueOf(localabyz.jdField_e_of_type_Int) }));
    }
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager
 * JD-Core Version:    0.7.0.1
 */