package com.tencent.mobileqq.campuscircle;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MQQCampusNotify;

public class CampusNoticeManager
  implements Manager
{
  int jdField_a_of_type_Int = 1000;
  RecentItemNoticeData jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageForText jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  final ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public CampusNoticeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData == null) {
      return 0;
    }
    return 1;
  }
  
  public RecentBaseData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData;
  }
  
  public MessageForText a()
  {
    RecentItemNoticeData localRecentItemNoticeData = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData;
    if (localRecentItemNoticeData == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText = ((MessageForText)MessageRecordFactory.a(-1000));
      MessageForText localMessageForText = this.jdField_a_of_type_ComTencentMobileqqDataMessageForText;
      localMessageForText.msgtype = -1000;
      localMessageForText.istroop = 1030;
      localMessageForText.isread = false;
      localMessageForText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.senderuin = AppConstants.CAMPUS_NOTICE_UIN;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.frienduin = AppConstants.CAMPUS_NOTICE_UIN;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = localRecentItemNoticeData.wording;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = localRecentItemNoticeData.time;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg.equals(localRecentItemNoticeData.mTitleName))) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = localRecentItemNoticeData.mTitleName;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time != localRecentItemNoticeData.time) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = localRecentItemNoticeData.time;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  }
  
  /* Error */
  public void a(int paramInt, long paramLong, String arg4, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 102	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore 9
    //   5: aload 9
    //   7: invokestatic 107	com/tencent/mobileqq/utils/QQUtils:a	(Landroid/content/Context;)Z
    //   10: istore 7
    //   12: aload_0
    //   13: getfield 27	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16: getfield 110	com/tencent/mobileqq/app/QQAppInterface:isBackgroundPause	Z
    //   19: ifne +27 -> 46
    //   22: aload_0
    //   23: getfield 27	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: getfield 113	com/tencent/mobileqq/app/QQAppInterface:isBackgroundStop	Z
    //   29: ifne +17 -> 46
    //   32: iload 7
    //   34: ifeq +6 -> 40
    //   37: goto +9 -> 46
    //   40: aconst_null
    //   41: astore 4
    //   43: goto +299 -> 342
    //   46: aload_0
    //   47: monitorenter
    //   48: aload_0
    //   49: getfield 20	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_Int	I
    //   52: iconst_1
    //   53: iadd
    //   54: istore_1
    //   55: aload_0
    //   56: iload_1
    //   57: putfield 20	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_Int	I
    //   60: aload_0
    //   61: monitorexit
    //   62: new 115	android/content/Intent
    //   65: dup
    //   66: aload_0
    //   67: getfield 27	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   73: ldc 120
    //   75: invokespecial 123	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   78: astore 8
    //   80: aload 8
    //   82: ldc 125
    //   84: iconst_1
    //   85: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   88: pop
    //   89: aload 8
    //   91: ldc 131
    //   93: iconst_4
    //   94: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   97: pop
    //   98: aload 8
    //   100: ldc 132
    //   102: invokevirtual 136	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   105: pop
    //   106: aload 8
    //   108: ldc 138
    //   110: iconst_3
    //   111: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload 8
    //   117: ldc 140
    //   119: aload 5
    //   121: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   124: pop
    //   125: aload 8
    //   127: ldc 145
    //   129: ldc 147
    //   131: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   134: pop
    //   135: aload 8
    //   137: ldc 149
    //   139: sipush 1030
    //   142: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   145: pop
    //   146: aload 8
    //   148: ldc 151
    //   150: lload_2
    //   151: invokestatic 155	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   154: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   157: pop
    //   158: aload 8
    //   160: ldc 157
    //   162: ldc 159
    //   164: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   167: pop
    //   168: aload 8
    //   170: ldc 161
    //   172: iload_1
    //   173: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   176: pop
    //   177: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +35 -> 215
    //   183: ldc 169
    //   185: iconst_2
    //   186: iconst_4
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: ldc 171
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: iload_1
    //   198: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: aastore
    //   202: dup
    //   203: iconst_2
    //   204: ldc 178
    //   206: aastore
    //   207: dup
    //   208: iconst_3
    //   209: aload 5
    //   211: aastore
    //   212: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   215: aload_0
    //   216: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData	Lcom/tencent/mobileqq/activity/recent/data/RecentItemNoticeData;
    //   219: astore 5
    //   221: aload 5
    //   223: ifnull +10 -> 233
    //   226: aload 5
    //   228: aload 8
    //   230: invokevirtual 185	com/tencent/mobileqq/activity/recent/data/RecentItemNoticeData:a	(Landroid/content/Intent;)V
    //   233: new 187	com/tencent/qphone/base/remote/ToServiceMsg
    //   236: dup
    //   237: ldc 189
    //   239: aload_0
    //   240: getfield 27	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   246: ldc 191
    //   248: invokespecial 194	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   251: astore 5
    //   253: aload 5
    //   255: getfield 198	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   258: ldc 200
    //   260: iconst_3
    //   261: anewarray 91	java/lang/String
    //   264: dup
    //   265: iconst_0
    //   266: aload 4
    //   268: aastore
    //   269: dup
    //   270: iconst_1
    //   271: aload 6
    //   273: aastore
    //   274: dup
    //   275: iconst_2
    //   276: aload 4
    //   278: aastore
    //   279: invokevirtual 206	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   282: aload 5
    //   284: getfield 198	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   287: ldc 208
    //   289: aload 8
    //   291: invokevirtual 212	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   294: aload 5
    //   296: getfield 198	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   299: ldc 214
    //   301: aconst_null
    //   302: invokevirtual 212	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   305: aload_0
    //   306: getfield 27	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   309: aload 5
    //   311: invokevirtual 218	com/tencent/mobileqq/app/QQAppInterface:sendToService	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   314: aload_0
    //   315: getfield 25	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   318: astore 4
    //   320: aload 4
    //   322: monitorenter
    //   323: aload_0
    //   324: getfield 25	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   327: iload_1
    //   328: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   331: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   334: pop
    //   335: aload 4
    //   337: monitorexit
    //   338: aload 8
    //   340: astore 4
    //   342: iload 7
    //   344: ifeq +98 -> 442
    //   347: aload_0
    //   348: getfield 27	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   351: getstatic 226	com/tencent/mobileqq/app/QQManagerFactory:QQLS_DATA_MANAGER	I
    //   354: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   357: checkcast 232	com/tencent/mobileqq/managers/QQLSRecentManager
    //   360: astore 5
    //   362: aload 9
    //   364: aload_0
    //   365: getfield 27	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   368: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   371: aload 9
    //   373: ldc 233
    //   375: invokevirtual 239	android/content/Context:getString	(I)Ljava/lang/String;
    //   378: ldc 241
    //   380: iconst_1
    //   381: invokestatic 247	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   384: ifeq +44 -> 428
    //   387: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +11 -> 401
    //   393: ldc 169
    //   395: iconst_2
    //   396: ldc 249
    //   398: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: aload 5
    //   403: aload_0
    //   404: getfield 27	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: getstatic 67	com/tencent/mobileqq/app/AppConstants:CAMPUS_NOTICE_UIN	Ljava/lang/String;
    //   410: sipush 1030
    //   413: iconst_0
    //   414: getstatic 67	com/tencent/mobileqq/app/AppConstants:CAMPUS_NOTICE_UIN	Ljava/lang/String;
    //   417: sipush 1030
    //   420: aload 4
    //   422: invokestatic 257	com/tencent/mobileqq/managers/MsgPushReportHelper:a	(Ljava/lang/String;ILandroid/content/Intent;)I
    //   425: invokevirtual 260	com/tencent/mobileqq/managers/QQLSRecentManager:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;IZI)V
    //   428: aload_0
    //   429: getfield 27	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   432: invokevirtual 264	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   435: aload_0
    //   436: invokevirtual 266	com/tencent/mobileqq/campuscircle/CampusNoticeManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentBaseData;
    //   439: invokevirtual 272	com/tencent/imcore/message/QQMessageFacade:notifyObservers	(Ljava/lang/Object;)V
    //   442: return
    //   443: astore 5
    //   445: aload 4
    //   447: monitorexit
    //   448: aload 5
    //   450: athrow
    //   451: astore 4
    //   453: aload_0
    //   454: monitorexit
    //   455: aload 4
    //   457: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	CampusNoticeManager
    //   0	458	1	paramInt	int
    //   0	458	2	paramLong	long
    //   0	458	5	paramString2	String
    //   0	458	6	paramString3	String
    //   10	333	7	bool	boolean
    //   78	261	8	localIntent	android.content.Intent
    //   3	369	9	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    // Exception table:
    //   from	to	target	type
    //   323	338	443	finally
    //   445	448	443	finally
    //   48	62	451	finally
    //   453	455	451	finally
  }
  
  public void a(QQNotificationManager arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "setReaded seq: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData = null;
    QQNotificationManager localQQNotificationManager = ???;
    if (??? == null) {}
    try
    {
      BaseApplicationImpl.getContext();
      localQQNotificationManager = QQNotificationManager.getInstance();
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          Integer localInteger = (Integer)localIterator.next();
          if (localInteger != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "cancel campus_notice [%d, %s]", new Object[] { localInteger, "campus_notification_tag" }));
            }
            localQQNotificationManager.cancelUseTag("CampusNoticeManager_removeNotification", "campus_notification_tag", localInteger.intValue());
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      }
      return;
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusNoticeManager", 2, "setReaded", ???);
      }
    }
  }
  
  public void a(SubMsgType0x27.MQQCampusNotify paramMQQCampusNotify)
  {
    if (paramMQQCampusNotify == null) {
      return;
    }
    int i = paramMQQCampusNotify.uint32_type.get();
    long l1 = paramMQQCampusNotify.uint64_from_uin.get();
    boolean bool = paramMQQCampusNotify.str_wording.has();
    Object localObject = null;
    String str2;
    if (bool) {
      str2 = paramMQQCampusNotify.str_wording.get();
    } else {
      str2 = null;
    }
    CharSequence localCharSequence;
    if (paramMQQCampusNotify.str_target.has())
    {
      String str3 = paramMQQCampusNotify.str_target.get();
      String str1 = str3;
      if (!TextUtils.isEmpty(str3)) {
        try
        {
          str1 = new String(Base64.a(str3), "UTF-8");
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CampusNoticeManager", 2, "decode url fail ", localException);
          }
        }
      }
    }
    else
    {
      localCharSequence = null;
    }
    if (paramMQQCampusNotify.str_source.has()) {
      localObject = paramMQQCampusNotify.str_source.get();
    }
    if (localObject == null) {
      paramMQQCampusNotify = "";
    } else {
      paramMQQCampusNotify = (SubMsgType0x27.MQQCampusNotify)localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CampusNoticeManager", 2, String.format(Locale.getDefault(), "onReceiveNotice [type: %d uin: %d wording: %s url: %s from: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), str2, localCharSequence, paramMQQCampusNotify }));
    }
    if (!TextUtils.isEmpty(str2))
    {
      if (TextUtils.isEmpty(localCharSequence)) {
        return;
      }
      localObject = new PushReportController.PushReportItem();
      ((PushReportController.PushReportItem)localObject).e = "0X800923D";
      ((PushReportController.PushReportItem)localObject).d = "收到Push协议";
      PushReportController.a(localCharSequence, (PushReportController.PushReportItem)localObject);
      PushReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PushReportController.PushReportItem)localObject);
      long l2 = MessageCache.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData;
      if (localObject == null)
      {
        localObject = new RecentUser();
        ((RecentUser)localObject).uin = AppConstants.CAMPUS_NOTICE_UIN;
        ((RecentUser)localObject).msgType = 1030;
        ((RecentUser)localObject).setType(1030);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData = new RecentItemNoticeData((RecentUser)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(i, l1, str2, localCharSequence, paramMQQCampusNotify, l2);
        a(i, l1, str2, localCharSequence, paramMQQCampusNotify);
        return;
      }
      if (!((RecentItemNoticeData)localObject).a(i, l1, str2, localCharSequence, paramMQQCampusNotify, l2))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(i, l1, str2, localCharSequence, paramMQQCampusNotify, l2);
        a(i, l1, str2, localCharSequence, paramMQQCampusNotify);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusNoticeManager", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusNoticeManager
 * JD-Core Version:    0.7.0.1
 */