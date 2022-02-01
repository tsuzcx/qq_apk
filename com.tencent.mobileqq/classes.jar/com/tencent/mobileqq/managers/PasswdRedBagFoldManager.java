package com.tencent.mobileqq.managers;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedHashSet<Ljava.lang.String;>;
import java.util.List;
import java.util.concurrent.locks.Lock;
import mqq.manager.Manager;

public class PasswdRedBagFoldManager
  implements Manager
{
  public int a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, MessageForFoldMsgGrayTips> a;
  public boolean a;
  public HashMap<String, MessageForFoldMsgGrayTips> b;
  public boolean b;
  public HashMap<String, String> c;
  public boolean c;
  public HashMap<String, String> d;
  public boolean d;
  
  public PasswdRedBagFoldManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 10;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    PasswdRedBagFoldManager localPasswdRedBagFoldManager = (PasswdRedBagFoldManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
    if (!localPasswdRedBagFoldManager.jdField_a_of_type_Boolean)
    {
      String str = paramQQAppInterface.getAccount();
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append("redbag_fold_msg_config_version");
      if (paramQQAppInterface.contains(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("redbag_fold_msg_switch");
        localPasswdRedBagFoldManager.jdField_b_of_type_Boolean = paramQQAppInterface.getBoolean(localStringBuilder.toString(), MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("redbag_fold_msg_num");
        localPasswdRedBagFoldManager.jdField_a_of_type_Int = paramQQAppInterface.getInt(localStringBuilder.toString(), MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("redbag_fold_index_switch");
        localPasswdRedBagFoldManager.jdField_c_of_type_Boolean = paramQQAppInterface.getBoolean(localStringBuilder.toString(), MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("redbag_fold_index_with_redbagid");
        localPasswdRedBagFoldManager.jdField_d_of_type_Boolean = paramQQAppInterface.getBoolean(localStringBuilder.toString(), MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("getFoldSwitch, first init, switch: %s, num: %d, indexSwitch: %s, indexWithId: %s ", new Object[] { Boolean.valueOf(localPasswdRedBagFoldManager.jdField_b_of_type_Boolean), Integer.valueOf(localPasswdRedBagFoldManager.jdField_a_of_type_Int), Boolean.valueOf(localPasswdRedBagFoldManager.jdField_c_of_type_Boolean), Boolean.valueOf(localPasswdRedBagFoldManager.jdField_d_of_type_Boolean) }));
      }
    }
    localPasswdRedBagFoldManager.jdField_a_of_type_Boolean = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    boolean bool1 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    int m = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    boolean bool2 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    boolean bool3 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    for (;;)
    {
      int n;
      int k;
      int i3;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = paramString.split("\\|");
          if (paramString != null)
          {
            int i10 = paramString.length;
            n = 0;
            k = 0;
            j = 0;
            i = 0;
            bool4 = bool1;
            int i8 = 0;
            bool1 = bool3;
            bool3 = bool4;
            if (i8 < i10)
            {
              localObject = paramString[i8];
              boolean bool7 = bool3;
              int i7 = m;
              bool6 = bool2;
              i5 = n;
              i4 = k;
              i2 = j;
              try
              {
                bool4 = ((String)localObject).contains("msgfold_switch");
                if (!bool4) {
                  break label1251;
                }
                bool7 = bool3;
                i7 = m;
                bool6 = bool2;
                i5 = n;
                i4 = k;
                i2 = j;
                String[] arrayOfString = ((String)localObject).split("=");
                if (arrayOfString == null) {
                  break label1251;
                }
                bool4 = bool3;
                i1 = n;
                bool7 = bool3;
                i7 = m;
                bool6 = bool2;
                i5 = n;
                i4 = k;
                i2 = j;
                if (arrayOfString.length == 2)
                {
                  bool7 = bool3;
                  i7 = m;
                  bool6 = bool2;
                  i5 = n;
                  i4 = k;
                  i2 = j;
                  i3 = Integer.valueOf(arrayOfString[1].trim()).intValue();
                  if (i3 == 1) {
                    break label1226;
                  }
                  bool4 = bool3;
                  i1 = n;
                  if (i3 == 0) {
                    break label1226;
                  }
                }
                n = m;
                i3 = k;
                bool7 = bool4;
                i7 = m;
                bool6 = bool2;
                i5 = i1;
                i4 = k;
                i2 = j;
                if (((String)localObject).contains("msgfold_num"))
                {
                  bool7 = bool4;
                  i7 = m;
                  bool6 = bool2;
                  i5 = i1;
                  i4 = k;
                  i2 = j;
                  arrayOfString = ((String)localObject).split("=");
                  n = m;
                  i3 = k;
                  if (arrayOfString != null)
                  {
                    n = m;
                    i3 = k;
                    bool7 = bool4;
                    i7 = m;
                    bool6 = bool2;
                    i5 = i1;
                    i4 = k;
                    i2 = j;
                    if (arrayOfString.length == 2)
                    {
                      bool7 = bool4;
                      i7 = m;
                      bool6 = bool2;
                      i5 = i1;
                      i4 = k;
                      i2 = j;
                      i6 = Integer.valueOf(arrayOfString[1].trim()).intValue();
                      n = m;
                      i3 = k;
                      if (i6 >= 0)
                      {
                        n = i6;
                        i3 = 1;
                      }
                    }
                  }
                }
                bool5 = bool2;
                i6 = j;
                bool7 = bool4;
                i7 = n;
                bool6 = bool2;
                i5 = i1;
                i4 = i3;
                i2 = j;
                if (((String)localObject).contains("Index_switch"))
                {
                  bool7 = bool4;
                  i7 = n;
                  bool6 = bool2;
                  i5 = i1;
                  i4 = i3;
                  i2 = j;
                  arrayOfString = ((String)localObject).split("=");
                  bool5 = bool2;
                  i6 = j;
                  if (arrayOfString != null)
                  {
                    bool5 = bool2;
                    i6 = j;
                    bool7 = bool4;
                    i7 = n;
                    bool6 = bool2;
                    i5 = i1;
                    i4 = i3;
                    i2 = j;
                    if (arrayOfString.length == 2)
                    {
                      bool7 = bool4;
                      i7 = n;
                      bool6 = bool2;
                      i5 = i1;
                      i4 = i3;
                      i2 = j;
                      k = Integer.valueOf(arrayOfString[1].trim()).intValue();
                      if (k == 1) {
                        break label1262;
                      }
                      bool5 = bool2;
                      i6 = j;
                      if (k == 0) {
                        break label1262;
                      }
                    }
                  }
                }
                boolean bool8 = bool1;
                int i9 = i;
                bool7 = bool4;
                i7 = n;
                bool6 = bool5;
                i5 = i1;
                i4 = i3;
                i2 = i6;
                if (((String)localObject).contains("with_redbagid"))
                {
                  bool7 = bool4;
                  i7 = n;
                  bool6 = bool5;
                  i5 = i1;
                  i4 = i3;
                  i2 = i6;
                  localObject = ((String)localObject).split("=");
                  bool8 = bool1;
                  i9 = i;
                  if (localObject != null)
                  {
                    bool8 = bool1;
                    i9 = i;
                    bool7 = bool4;
                    i7 = n;
                    bool6 = bool5;
                    i5 = i1;
                    i4 = i3;
                    i2 = i6;
                    if (localObject.length == 2)
                    {
                      bool7 = bool4;
                      i7 = n;
                      bool6 = bool5;
                      i5 = i1;
                      i4 = i3;
                      i2 = i6;
                      j = Integer.valueOf(localObject[1].trim()).intValue();
                      if (j != 1)
                      {
                        bool8 = bool1;
                        i9 = i;
                        if (j != 0) {}
                      }
                      else
                      {
                        if (j == 1) {
                          bool1 = true;
                        } else {
                          bool1 = false;
                        }
                        i9 = 1;
                        bool8 = bool1;
                      }
                    }
                  }
                }
                i8 += 1;
                bool3 = bool4;
                m = n;
                bool2 = bool5;
                bool1 = bool8;
                n = i1;
                k = i3;
                j = i6;
                i = i9;
              }
              catch (Exception paramString)
              {
                bool4 = bool7;
                j = i7;
                bool5 = bool6;
                bool6 = bool1;
                continue;
              }
            }
            bool4 = bool1;
            bool1 = bool3;
            bool3 = bool4;
            i1 = j;
            i3 = i;
            break label1065;
          }
        }
        n = 0;
        k = 0;
        i1 = 0;
        i3 = 0;
      }
      catch (Exception paramString)
      {
        Object localObject;
        int i5 = 0;
        int i4 = 0;
        int i2 = 0;
        int i = 0;
        boolean bool6 = bool3;
        bool5 = bool2;
        int j = m;
        bool4 = bool1;
        bool1 = bool4;
        m = j;
        bool2 = bool5;
        bool3 = bool6;
        n = i5;
        k = i4;
        i1 = i2;
        i3 = i;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updatePasswdMsgFodConfig error ");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.e("msgFold", 2, ((StringBuilder)localObject).toString());
          i3 = i;
          i1 = i2;
          k = i4;
          n = i5;
          bool3 = bool6;
          bool2 = bool5;
          m = j;
          bool1 = bool4;
        }
      }
      label1065:
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("received RedBagFoldMsgConfig remote version: %d, msgFoldSwitch: %s, msgFoldNum: %s, msgFoldIndexSwitch: %s, msgFoldIndexWithId: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool1), Integer.valueOf(m), Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
      }
      if ((k == 0) || (n == 0) || (i1 == 0) || (i3 == 0))
      {
        bool1 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
        m = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
        bool2 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
        bool3 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
      }
      paramString = (PasswdRedBagFoldManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
      paramString.jdField_a_of_type_Boolean = true;
      paramString.jdField_b_of_type_Boolean = bool1;
      paramString.jdField_a_of_type_Int = m;
      paramString.jdField_c_of_type_Boolean = bool2;
      paramString.jdField_d_of_type_Boolean = bool3;
      SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), paramInt, bool1, m, bool2, bool3);
      return;
      label1226:
      if (i3 == 1) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      int i1 = 1;
      boolean bool4 = bool3;
      continue;
      label1251:
      bool4 = bool3;
      i1 = n;
      continue;
      label1262:
      if (k == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      int i6 = 1;
      boolean bool5 = bool2;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return ((PasswdRedBagFoldManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER)).jdField_b_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return (paramInt == 1) && (!((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramString));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return ((PasswdRedBagFoldManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER)).jdField_c_of_type_Boolean;
  }
  
  public MessageRecord a(List<MessageRecord> paramList, MessageForFoldMsg paramMessageForFoldMsg, LinkedHashSet<String> paramLinkedHashSet, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject4;
    if ((QLog.isColorLevel()) && (StartupTrackerForAio.a()) && (paramList.size() > 0))
    {
      localObject1 = new StringBuilder(paramList.size() * 48 + 64);
      ((StringBuilder)localObject1).append("getFoldGrayTipsFormAIOList before insert,aioList size=");
      ((StringBuilder)localObject1).append(paramList.size());
      ((StringBuilder)localObject1).append(":");
      if (paramBoolean2)
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).a().a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
        ((Lock)???).lock();
        try
        {
          localObject3 = paramList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject3).next();
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(((MessageRecord)localObject4).time);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(((MessageRecord)localObject4).shmsgseq);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(((MessageRecord)localObject4).msgtype);
            ((StringBuilder)localObject1).append(") ");
          }
        }
        finally
        {
          ((Lock)???).unlock();
        }
      }
      else
      {
        ??? = paramList.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)???).next();
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(((MessageRecord)localObject3).time);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(((MessageRecord)localObject3).shmsgseq);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(((MessageRecord)localObject3).msgtype);
          ((StringBuilder)localObject1).append(") ");
        }
      }
      QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (this.jdField_b_of_type_JavaUtilHashMap == null) {
      this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramMessageForFoldMsg.frienduin);
    ((StringBuilder)localObject1).append(paramMessageForFoldMsg.istroop);
    ((StringBuilder)localObject1).append(paramMessageForFoldMsg.redBagId);
    ??? = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramMessageForFoldMsg.frienduin);
    ((StringBuilder)localObject1).append(paramMessageForFoldMsg.istroop);
    ((StringBuilder)localObject1).append(paramMessageForFoldMsg.redBagIndex);
    Object localObject3 = ((StringBuilder)localObject1).toString();
    if ((paramBoolean1) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject3)))
    {
      localObject1 = (MessageForFoldMsgGrayTips)this.jdField_b_of_type_JavaUtilHashMap.get(localObject3);
      ((MessageForFoldMsgGrayTips)localObject1).update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, paramLinkedHashSet, paramInt, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(???)) {
        a(paramList, (String)localObject3, (String)???, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramBoolean2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("update foldmsg graytips, index mode, uin: %s, type: %d, redBagId: %s, index: %s, num: %d", new Object[] { ((MessageForFoldMsgGrayTips)localObject1).frienduin, Integer.valueOf(((MessageForFoldMsgGrayTips)localObject1).istroop), paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, Integer.valueOf(((MessageForFoldMsgGrayTips)localObject1).foldMsgCount) }));
      }
    }
    else
    {
      if ((!paramBoolean1) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(???))) {
        break label780;
      }
      paramList = (MessageForFoldMsgGrayTips)this.jdField_a_of_type_JavaUtilHashMap.get(???);
      paramList.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, paramLinkedHashSet, paramInt, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
      if (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(???);
        this.jdField_b_of_type_JavaUtilHashMap.put(localObject3, paramList);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("update foldmsg graytips, id mode, uin: %s, type: %d, redBagId: %s, index: %s,  num: %d", new Object[] { paramList.frienduin, Integer.valueOf(paramList.istroop), paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, Integer.valueOf(paramList.foldMsgCount) }));
      }
    }
    localObject1 = null;
    break label1269;
    label780:
    localObject1 = (MessageForFoldMsgGrayTips)MessageRecordFactory.a(-5011);
    MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
    ((MessageForFoldMsgGrayTips)localObject1).shmsgseq = paramMessageForFoldMsg.shmsgseq;
    ((MessageForFoldMsgGrayTips)localObject1).time = paramMessageForFoldMsg.time;
    ((MessageForFoldMsgGrayTips)localObject1).foldMsgCount = paramInt;
    ((MessageForFoldMsgGrayTips)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.mPasswdRedBagSender, paramLinkedHashSet, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex))
      {
        if (paramBoolean2)
        {
          paramLinkedHashSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).a().a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
          paramLinkedHashSet.lock();
        }
        try
        {
          MsgProxyUtils.c(paramList, (MessageRecord)localObject1, true);
          paramLinkedHashSet.unlock();
        }
        finally
        {
          paramLinkedHashSet.unlock();
        }
        localObject3 = paramMessageForFoldMsg.frienduin;
        paramInt = paramMessageForFoldMsg.istroop;
        localObject4 = paramMessageForFoldMsg.redBagId;
        String str = paramMessageForFoldMsg.redBagIndex;
        paramLinkedHashSet = (LinkedHashSet<String>)localObject1;
        a((String)localObject3, paramInt, (String)localObject4, str, (MessageForFoldMsgGrayTips)localObject1);
        localObject1 = paramLinkedHashSet;
        if (QLog.isColorLevel())
        {
          localObject1 = paramLinkedHashSet;
          if (StartupTrackerForAio.a())
          {
            localObject1 = paramLinkedHashSet;
            if (paramList != null)
            {
              localObject1 = paramLinkedHashSet;
              if (paramList.size() > 0)
              {
                localObject1 = new StringBuilder(paramList.size() * 48 + 64);
                ((StringBuilder)localObject1).append("getFoldGrayTipsFormAIOList after insert,isNeedMsgListLock=");
                ((StringBuilder)localObject1).append(paramBoolean2);
                ((StringBuilder)localObject1).append(",aioList size=");
                ((StringBuilder)localObject1).append(paramList.size());
                ((StringBuilder)localObject1).append(":");
                paramMessageForFoldMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).a().a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
                paramMessageForFoldMsg.lock();
                try
                {
                  paramList = paramList.iterator();
                  while (paramList.hasNext())
                  {
                    ??? = (MessageRecord)paramList.next();
                    ((StringBuilder)localObject1).append("(");
                    ((StringBuilder)localObject1).append(((MessageRecord)???).time);
                    ((StringBuilder)localObject1).append(",");
                    ((StringBuilder)localObject1).append(((MessageRecord)???).shmsgseq);
                    ((StringBuilder)localObject1).append(",");
                    ((StringBuilder)localObject1).append(((MessageRecord)???).msgtype);
                    ((StringBuilder)localObject1).append(") ");
                  }
                  paramMessageForFoldMsg.unlock();
                  QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
                  localObject1 = paramLinkedHashSet;
                }
                finally
                {
                  paramMessageForFoldMsg.unlock();
                }
              }
            }
          }
        }
        label1269:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BC", "0X80064BC", 0, 0, "", "", "", "");
        return localObject1;
      }
      paramList = new StringBuilder();
      paramList.append("filter repeat msg:");
      paramList.append(paramMessageForFoldMsg.redBagId);
      paramList.append("_");
      paramList.append(paramMessageForFoldMsg.redBagIndex);
      QLog.i("msgFold", 1, paramList.toString());
      return null;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public Boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int i = this.jdField_a_of_type_Int;
    Boolean localBoolean = Boolean.valueOf(true);
    if (i == 0) {
      return localBoolean;
    }
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, paramInt);
    if (localObject == null) {
      return Boolean.valueOf(false);
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString1, paramInt);
    if ((paramString1 == null) || (((List)localObject).size() >= paramString1.size())) {
      paramString1 = (String)localObject;
    }
    paramInt = paramString1.size() - 1;
    while (paramInt > 0)
    {
      localObject = (MessageRecord)paramString1.get(paramInt);
      i = j;
      if ((localObject instanceof MessageForFoldMsg))
      {
        MessageForFoldMsg localMessageForFoldMsg = (MessageForFoldMsg)localObject;
        if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(localMessageForFoldMsg.redBagId)))
        {
          i = j;
          if (!TextUtils.isEmpty(paramString3))
          {
            i = j;
            if (!paramString3.equals(localMessageForFoldMsg.redBagIndex)) {}
          }
        }
        else
        {
          j += 1;
          localObject = localBoolean;
          if (localMessageForFoldMsg.foldFlag) {
            break label229;
          }
          i = j;
          if (j >= this.jdField_a_of_type_Int) {
            return localBoolean;
          }
        }
      }
      paramInt -= 1;
      j = i;
    }
    localObject = Boolean.valueOf(false);
    label229:
    return localObject;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, MessageForFoldMsgGrayTips paramMessageForFoldMsgGrayTips)
  {
    HashMap localHashMap;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramInt);
      paramString2.append(paramString3);
      paramString2 = paramString2.toString();
      localHashMap = this.jdField_b_of_type_JavaUtilHashMap;
      if ((localHashMap != null) && (!localHashMap.containsKey(paramString2)))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString2, paramMessageForFoldMsgGrayTips);
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagIndex: %s num: %d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Integer.valueOf(paramMessageForFoldMsgGrayTips.foldMsgCount) }));
        }
      }
    }
    else if (!TextUtils.isEmpty(paramString2))
    {
      paramString3 = new StringBuilder();
      paramString3.append(paramString1);
      paramString3.append(paramInt);
      paramString3.append(paramString2);
      paramString3 = paramString3.toString();
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if ((localHashMap != null) && (!localHashMap.containsKey(paramString3)))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString3, paramMessageForFoldMsgGrayTips);
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagId: %s num: %d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(paramMessageForFoldMsgGrayTips.foldMsgCount) }));
        }
      }
    }
  }
  
  public void a(List<MessageRecord> paramList, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    MessageForFoldMsgGrayTips localMessageForFoldMsgGrayTips = (MessageForFoldMsgGrayTips)this.jdField_b_of_type_JavaUtilHashMap.get(paramString1);
    paramString2 = (MessageForFoldMsgGrayTips)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    localMessageForFoldMsgGrayTips.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2.frienduin, paramString2.foldUinList, paramString2.foldMsgCount, paramString2.redBagId, paramString2.redBagIndex);
    if (paramBoolean)
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).a().a(paramString3, paramInt);
      paramString1.lock();
    }
    try
    {
      paramList.remove(paramString2);
      paramString1.unlock();
    }
    finally
    {
      paramString1.unlock();
    }
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, new Object[] { "update foldmsg graytips, index mode merge,", ",mst.time=", Long.valueOf(paramString2.time), ".msg.shmsgseq=", Long.valueOf(paramString2.shmsgseq), ",msg.type=", Integer.valueOf(paramString2.msgtype), ",isNeedMsgListLock=", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      ((IPasswdRedBagService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPasswdRedBagService.class)).loadRedBagInfoToCache(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      a(false);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString1)) {
        this.jdField_c_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      }
      if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString2)) {
        this.jdField_d_of_type_JavaUtilHashMap.put(paramString2, paramString1);
      }
    }
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString3);
    paramString1 = localStringBuilder.toString();
    boolean bool2 = TextUtils.isEmpty(paramString2);
    boolean bool1 = true;
    if (!bool2)
    {
      paramString2 = this.jdField_a_of_type_JavaUtilHashMap;
      if ((paramString2 != null) && (paramString2.containsKey(localObject)))
      {
        paramInt = 1;
        break label113;
      }
    }
    paramInt = 0;
    label113:
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString2 = this.jdField_b_of_type_JavaUtilHashMap;
      if ((paramString2 != null) && (paramString2.containsKey(paramString1)))
      {
        i = 1;
        break label147;
      }
    }
    int i = 0;
    label147:
    if (paramInt == 0)
    {
      if (i != 0) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.PasswdRedBagFoldManager
 * JD-Core Version:    0.7.0.1
 */