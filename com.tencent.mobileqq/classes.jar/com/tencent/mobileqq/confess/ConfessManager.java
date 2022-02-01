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
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final ConfessCache jdField_a_of_type_ComTencentMobileqqConfessConfessCache;
  ConfessConfig jdField_a_of_type_ComTencentMobileqqConfessConfessConfig;
  ConfessManager.FrdChatExtra jdField_a_of_type_ComTencentMobileqqConfessConfessManager$FrdChatExtra = null;
  ConfessManager.GroupChatExtra jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra = null;
  final FrdConfessInfo jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  final ArrayList<ConfessManager.FrdChatExtra> jdField_a_of_type_JavaUtilArrayList;
  ConfessManager.FrdChatExtra jdField_b_of_type_ComTencentMobileqqConfessConfessManager$FrdChatExtra = null;
  ConfessManager.GroupChatExtra jdField_b_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra = null;
  final Object jdField_b_of_type_JavaLangObject = new Object();
  final ArrayList<ConfessManager.GroupChatExtra> jdField_b_of_type_JavaUtilArrayList;
  
  public ConfessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo = new FrdConfessInfo(paramQQAppInterface.getAccount());
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessCache = new ConfessCache();
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessConfig = new ConfessConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ThreadManager.post(new ConfessManager.1(this), 5, null, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private ConfessManager.FrdChatExtra a(String paramString1, String paramString2, int paramInt)
  {
    ConfessManager.FrdChatExtra localFrdChatExtra;
    label154:
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label154;
        }
        localFrdChatExtra = (ConfessManager.FrdChatExtra)((Iterator)localObject).next();
        if ((localFrdChatExtra != null) && (localFrdChatExtra.jdField_a_of_type_Int == paramInt) && (TextUtils.equals(localFrdChatExtra.jdField_b_of_type_JavaLangString, paramString1)) && (TextUtils.equals(localFrdChatExtra.jdField_c_of_type_JavaLangString, paramString2))) {
          break;
        }
      }
      localObject = localFrdChatExtra;
      if (localFrdChatExtra == null)
      {
        localObject = new ConfessManager.FrdChatExtra();
        ((ConfessManager.FrdChatExtra)localObject).jdField_b_of_type_JavaLangString = paramString1;
        ((ConfessManager.FrdChatExtra)localObject).jdField_c_of_type_JavaLangString = paramString2;
        ((ConfessManager.FrdChatExtra)localObject).jdField_a_of_type_Int = paramInt;
        ((ConfessManager.FrdChatExtra)localObject).g = 0;
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      return localObject;
    }
  }
  
  private ConfessManager.GroupChatExtra a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    ConfessManager.GroupChatExtra localGroupChatExtra;
    label194:
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label194;
        }
        localGroupChatExtra = (ConfessManager.GroupChatExtra)((Iterator)localObject).next();
        if ((localGroupChatExtra != null) && (localGroupChatExtra.jdField_a_of_type_Int == paramInt) && (TextUtils.equals(localGroupChatExtra.jdField_a_of_type_JavaLangString, paramString1)) && (TextUtils.equals(localGroupChatExtra.jdField_d_of_type_JavaLangString, paramString2)) && (TextUtils.equals(localGroupChatExtra.jdField_b_of_type_JavaLangString, paramString3)) && (TextUtils.equals(localGroupChatExtra.jdField_e_of_type_JavaLangString, paramString4))) {
          break;
        }
      }
      localObject = localGroupChatExtra;
      if (localGroupChatExtra == null)
      {
        localObject = new ConfessManager.GroupChatExtra();
        ((ConfessManager.GroupChatExtra)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((ConfessManager.GroupChatExtra)localObject).jdField_d_of_type_JavaLangString = paramString2;
        ((ConfessManager.GroupChatExtra)localObject).jdField_b_of_type_JavaLangString = paramString3;
        ((ConfessManager.GroupChatExtra)localObject).jdField_e_of_type_JavaLangString = paramString4;
        ((ConfessManager.GroupChatExtra)localObject).jdField_a_of_type_Int = paramInt;
        ((ConfessManager.GroupChatExtra)localObject).jdField_e_of_type_Int = 0;
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
      }
      return localObject;
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, 0, new int[] { -2065 });
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
            i = 2;
            break label132;
          }
        }
      }
    }
    int i = 1;
    label132:
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkNeedAddConfessElem frdUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    return i;
  }
  
  public int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, 1, new int[] { -2065 });
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
            i = 2;
            break label157;
          }
        }
      }
    }
    int i = 1;
    label157:
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkGroupNeedAddConfessElem groupUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, paramString4, Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    return i;
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
  
  public ConfessManager.FrdChatExtra a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$FrdChatExtra;
  }
  
  public ConfessManager.GroupChatExtra a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra;
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
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.jdField_a_of_type_Long >= paramRedTouchItem.lastRecvTime) && (this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.jdField_a_of_type_Int == paramRedTouchItem.count)) {
      bool = false;
    } else {
      bool = true;
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.a(paramRedTouchItem);
      ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false);
      ((ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).b(this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "onFrdRecNewConfess bNeedUpdate: %s, info: %s", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo }));
    }
  }
  
  public void a(String paramString)
  {
    ConfessManager.FrdChatExtra localFrdChatExtra = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$FrdChatExtra;
    Integer localInteger = null;
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$FrdChatExtra = null;
    if (localFrdChatExtra != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqConfessConfessManager$FrdChatExtra = localFrdChatExtra;
      if (localFrdChatExtra.g == 1) {
        ThreadManager.postImmediately(new ConfessManager.3(this, paramString, localFrdChatExtra), null, false);
      }
    }
    if (QLog.isDevelopLevel())
    {
      Locale localLocale = Locale.getDefault();
      if (localFrdChatExtra != null) {
        localInteger = Integer.valueOf(localFrdChatExtra.g);
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
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramFrdChatExtra.g == 1)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 0, new int[] { -2065 });
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
                if ((localMessageForConfessNews.nTopicId == paramFrdChatExtra.jdField_a_of_type_Int) && (TextUtils.equals(paramFrdChatExtra.jdField_c_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramFrdChatExtra.jdField_b_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeFrdConfessNews frdUin: %s confessorUin: %s topicId: %s", new Object[] { paramFrdChatExtra.jdField_b_of_type_JavaLangString, paramFrdChatExtra.jdField_c_of_type_JavaLangString, Integer.valueOf(paramFrdChatExtra.jdField_a_of_type_Int) }));
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
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramFrdChatExtra.g == 0) {
          paramFrdChatExtra.g = a(paramString, paramFrdChatExtra.jdField_b_of_type_JavaLangString, paramFrdChatExtra.jdField_c_of_type_JavaLangString, paramFrdChatExtra.jdField_a_of_type_Int);
        }
        int i = paramFrdChatExtra.g;
        if (i != 1) {
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
          String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          try
          {
            ((MessageRecord)localObject2).init(str2, paramString, paramString, str1, paramLong1, -2065, 0, paramLong2);
            ((MessageRecord)localObject2).isread = true;
            if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, false)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, ((MessageRecord)localObject2).selfuin);
          }
          catch (Exception localException1) {}
          localObject2 = new StringBuilder();
        }
        catch (Exception localException2) {}
        ((StringBuilder)localObject2).append("addFrdConfessNews error: ");
        ((StringBuilder)localObject2).append(localException2.getMessage());
        QLog.i("ConfessManager", 1, ((StringBuilder)localObject2).toString());
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addFrdConfessNews frdUin: %s recUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramFrdChatExtra.jdField_b_of_type_JavaLangString, paramFrdChatExtra.jdField_c_of_type_JavaLangString, Integer.valueOf(paramFrdChatExtra.jdField_a_of_type_Int) }));
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
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramGroupChatExtra.jdField_e_of_type_Int == 1)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 1, new int[] { -2065 });
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
                if ((localMessageForConfessNews.nTopicId == paramGroupChatExtra.jdField_a_of_type_Int) && (TextUtils.equals(paramGroupChatExtra.jdField_a_of_type_JavaLangString, localMessageForConfessNews.strGroupUin)) && (TextUtils.equals(paramGroupChatExtra.jdField_e_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramGroupChatExtra.jdField_b_of_type_JavaLangString, localMessageForConfessNews.senderuin)) && (TextUtils.equals(paramGroupChatExtra.jdField_d_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeGroupConfessNews groupUin: %s, strRecUin: %s, sendUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramGroupChatExtra.jdField_a_of_type_JavaLangString, paramGroupChatExtra.jdField_d_of_type_JavaLangString, paramGroupChatExtra.jdField_b_of_type_JavaLangString, paramGroupChatExtra.jdField_e_of_type_JavaLangString, Integer.valueOf(paramGroupChatExtra.jdField_a_of_type_Int) }));
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
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramGroupChatExtra.jdField_e_of_type_Int == 0) {
          paramGroupChatExtra.jdField_e_of_type_Int = a(paramString, paramGroupChatExtra.jdField_d_of_type_JavaLangString, paramGroupChatExtra.jdField_b_of_type_JavaLangString, paramGroupChatExtra.jdField_e_of_type_JavaLangString, paramGroupChatExtra.jdField_a_of_type_Int);
        }
        int i = paramGroupChatExtra.jdField_e_of_type_Int;
        if (i == 1) {
          try
          {
            String str = paramGroupChatExtra.a();
            if (!TextUtils.isEmpty(str))
            {
              localObject2 = MessageRecordFactory.a(-2065);
              ((MessageRecord)localObject2).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramGroupChatExtra.jdField_b_of_type_JavaLangString, str, paramLong1, -2065, 1, paramLong2);
              ((MessageRecord)localObject2).isread = true;
              ((MessageRecord)localObject2).shmsgseq = paramLong3;
              if (QLog.isDevelopLevel()) {
                QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 1 %s", new Object[] { Long.valueOf(paramLong3) }));
              }
              if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, false))
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, ((MessageRecord)localObject2).selfuin);
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
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews groupUin: %s recUin: %s, sendUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramGroupChatExtra.jdField_d_of_type_JavaLangString, paramGroupChatExtra.jdField_b_of_type_JavaLangString, paramGroupChatExtra.jdField_e_of_type_JavaLangString, Integer.valueOf(paramGroupChatExtra.jdField_a_of_type_Int) }));
        }
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt).g = 2;
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
    for (;;)
    {
      boolean bool2 = ((Iterator)localObject1).hasNext();
      bool1 = true;
      if (!bool2) {
        break;
      }
      localObject2 = (ConfessManager.GroupChatExtra)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if ((((ConfessManager.GroupChatExtra)localObject2).jdField_a_of_type_Int == paramInt) && (TextUtils.equals(((ConfessManager.GroupChatExtra)localObject2).jdField_a_of_type_JavaLangString, paramString1)) && (TextUtils.equals(((ConfessManager.GroupChatExtra)localObject2).jdField_d_of_type_JavaLangString, paramString2)) && (TextUtils.equals(((ConfessManager.GroupChatExtra)localObject2).jdField_b_of_type_JavaLangString, paramString3)) && (TextUtils.equals(((ConfessManager.GroupChatExtra)localObject2).jdField_e_of_type_JavaLangString, paramString4)))
        {
          if (((ConfessManager.GroupChatExtra)localObject2).jdField_a_of_type_Boolean)
          {
            ((ConfessManager.GroupChatExtra)localObject2).jdField_a_of_type_Boolean = false;
            break label343;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, 1, 6);
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject2 = (MessageRecord)((List)localObject1).get(i);
            if ((localObject2 instanceof MessageForConfessNews))
            {
              localObject2 = (MessageForConfessNews)localObject2;
              ((MessageForConfessNews)localObject2).parse();
              if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) && (TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) && (TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) && (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)))
              {
                int j = i + 1;
                if (j < ((List)localObject1).size())
                {
                  localObject2 = (MessageRecord)((List)localObject1).get(j);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
                }
              }
            }
            i += 1;
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, 1, new int[] { -2065 });
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
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MessageForConfessNews)localObject2).frienduin, ((MessageForConfessNews)localObject2).istroop, ((MessageForConfessNews)localObject2).uniseq, paramLong, ((MessageForConfessNews)localObject2).time);
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
  
  public boolean a(String paramString)
  {
    ConfessManager.FrdChatExtra localFrdChatExtra = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$FrdChatExtra;
    if ((!TextUtils.isEmpty(paramString)) && (localFrdChatExtra != null))
    {
      if (!TextUtils.equals(localFrdChatExtra.jdField_b_of_type_JavaLangString, paramString)) {
        return false;
      }
      if (localFrdChatExtra.g == 0) {
        localFrdChatExtra.g = a(paramString, localFrdChatExtra.jdField_b_of_type_JavaLangString, localFrdChatExtra.jdField_c_of_type_JavaLangString, localFrdChatExtra.jdField_a_of_type_Int);
      }
      return localFrdChatExtra.g == 1;
    }
    return false;
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
      int i = paramIntent.getIntExtra("key_confess_topicid", 0);
      String str3 = paramIntent.getStringExtra("key_confess_desc");
      String str4 = paramIntent.getStringExtra("key_confessor_nick");
      int j = paramIntent.getIntExtra("key_confessor_sex", 0);
      int k = paramIntent.getIntExtra("key_confess_bg_type", 0);
      String str5 = paramIntent.getStringExtra("key_confess_rec_nick_name");
      long l = paramIntent.getLongExtra("key_confess_time", 0L);
      if ((TextUtils.equals(paramString, str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str3)))
      {
        if (i == 0) {
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
        this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$FrdChatExtra = paramIntent;
        if (paramIntent.g != 2) {
          ThreadManager.postImmediately(new ConfessManager.2(this, paramString), null, false);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRecConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramIntent.g) }));
        }
        return true;
      }
    }
    return false;
  }
  
  public ConfessConfig b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfessConfessConfig;
  }
  
  public void b(String paramString)
  {
    ConfessManager.GroupChatExtra localGroupChatExtra = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra;
    Integer localInteger = null;
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra = null;
    if (localGroupChatExtra != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra = localGroupChatExtra;
      if (localGroupChatExtra.jdField_e_of_type_Int == 1) {
        ThreadManager.postImmediately(new ConfessManager.5(this, paramString, localGroupChatExtra), null, false);
      }
    }
    if (QLog.isDevelopLevel())
    {
      Locale localLocale = Locale.getDefault();
      if (localGroupChatExtra != null) {
        localInteger = Integer.valueOf(localGroupChatExtra.jdField_e_of_type_Int);
      }
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveGroupRecConfessChat groupUin: %s, flag: %s", new Object[] { paramString, localInteger }));
    }
  }
  
  public boolean b(String paramString)
  {
    ConfessManager.GroupChatExtra localGroupChatExtra = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra;
    if ((!TextUtils.isEmpty(paramString)) && (localGroupChatExtra != null))
    {
      if (!TextUtils.equals(localGroupChatExtra.jdField_a_of_type_JavaLangString, paramString)) {
        return false;
      }
      if (localGroupChatExtra.jdField_e_of_type_Int == 0) {
        localGroupChatExtra.jdField_e_of_type_Int = a(paramString, localGroupChatExtra.jdField_d_of_type_JavaLangString, localGroupChatExtra.jdField_b_of_type_JavaLangString, localGroupChatExtra.jdField_e_of_type_JavaLangString, localGroupChatExtra.jdField_a_of_type_Int);
      }
      return localGroupChatExtra.jdField_e_of_type_Int == 1;
    }
    return false;
  }
  
  public boolean b(String paramString, Intent paramIntent)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramIntent != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
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
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      if ((!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str1)) && (i != 0))
      {
        ConfessManager.GroupChatExtra localGroupChatExtra = a(paramString, str4, paramIntent, str2, i);
        if (!TextUtils.isEmpty(str5)) {
          localGroupChatExtra.jdField_c_of_type_JavaLangString = str5;
        }
        localGroupChatExtra.g = str3;
        localGroupChatExtra.jdField_c_of_type_Int = j;
        localGroupChatExtra.f = str1;
        localGroupChatExtra.jdField_b_of_type_Int = k;
        localGroupChatExtra.jdField_a_of_type_Long = l;
        localGroupChatExtra.jdField_d_of_type_Int = m;
        this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra = localGroupChatExtra;
        if (localGroupChatExtra.jdField_e_of_type_Int != 2) {
          ThreadManager.postImmediately(new ConfessManager.4(this, paramString, localGroupChatExtra), null, false);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat recUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str4, paramIntent, str2, Integer.valueOf(i), Integer.valueOf(localGroupChatExtra.jdField_e_of_type_Int) }));
        }
        return true;
      }
      return false;
    }
    return false;
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
      int i = paramIntent.getIntExtra("key_confess_topicid", 0);
      String str3 = paramIntent.getStringExtra("key_confessor_nick");
      int j = paramIntent.getIntExtra("key_confessor_sex", 0);
      int k = paramIntent.getIntExtra("key_confessor_friend_sex", 0);
      String str4 = paramIntent.getStringExtra("key_confess_desc");
      int m = paramIntent.getIntExtra("key_confess_bg_type", 0);
      long l = paramIntent.getLongExtra("key_confess_time", 0L);
      int n = paramIntent.getIntExtra("key_confessor_num", 0);
      if ((TextUtils.equals(paramString, str1)) && (!TextUtils.isEmpty(str4)))
      {
        if (i == 0) {
          return false;
        }
        paramIntent = a(str1, str2, i);
        paramIntent.jdField_c_of_type_Int = j;
        paramIntent.jdField_e_of_type_Int = k;
        paramIntent.jdField_d_of_type_JavaLangString = str4;
        paramIntent.jdField_e_of_type_JavaLangString = str3;
        paramIntent.jdField_b_of_type_Int = m;
        paramIntent.jdField_a_of_type_Long = l;
        paramIntent.jdField_d_of_type_Int = n;
        paramIntent.f = 1;
        this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$FrdChatExtra = paramIntent;
        if (paramIntent.g != 2) {
          ThreadManager.postImmediately(new ConfessManager.6(this, paramString), null, false);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRankConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s, friendSex: %s, extra.strConfessorNick : %s", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramIntent.g), Integer.valueOf(k), paramIntent.jdField_e_of_type_JavaLangString }));
        }
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager
 * JD-Core Version:    0.7.0.1
 */