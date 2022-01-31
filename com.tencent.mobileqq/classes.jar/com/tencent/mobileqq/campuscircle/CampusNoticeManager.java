package com.tencent.mobileqq.campuscircle;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
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
  final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData == null) {
      return null;
    }
    RecentItemNoticeData localRecentItemNoticeData = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText = ((MessageForText)MessageRecordFactory.a(-1000));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msgtype = -1000;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.istroop = 1030;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.isread = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.senderuin = AppConstants.aB;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.frienduin = AppConstants.aB;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = localRecentItemNoticeData.a;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = localRecentItemNoticeData.c;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg.equals(localRecentItemNoticeData.b))) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = localRecentItemNoticeData.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time != localRecentItemNoticeData.c) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = localRecentItemNoticeData.c;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  }
  
  /* Error */
  public void a(int paramInt, long paramLong, String arg4, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 102	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore 8
    //   5: aload 8
    //   7: invokestatic 107	com/tencent/mobileqq/utils/QQUtils:a	(Landroid/content/Context;)Z
    //   10: istore 7
    //   12: aload_0
    //   13: getfield 26	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16: getfield 110	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   19: ifne +18 -> 37
    //   22: aload_0
    //   23: getfield 26	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: getfield 113	com/tencent/mobileqq/app/QQAppInterface:isBackground_Stop	Z
    //   29: ifne +8 -> 37
    //   32: iload 7
    //   34: ifeq +243 -> 277
    //   37: aload_0
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 19	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_Int	I
    //   43: iconst_1
    //   44: iadd
    //   45: istore_1
    //   46: aload_0
    //   47: iload_1
    //   48: putfield 19	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_Int	I
    //   51: aload_0
    //   52: monitorexit
    //   53: new 115	android/content/Intent
    //   56: dup
    //   57: aload_0
    //   58: getfield 26	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   64: ldc 120
    //   66: invokespecial 123	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   69: astore 9
    //   71: aload 9
    //   73: ldc 125
    //   75: iconst_1
    //   76: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   79: pop
    //   80: aload 9
    //   82: ldc 131
    //   84: iconst_4
    //   85: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   88: pop
    //   89: aload 9
    //   91: ldc 132
    //   93: invokevirtual 136	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   96: pop
    //   97: aload 9
    //   99: ldc 138
    //   101: iconst_3
    //   102: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   105: pop
    //   106: aload 9
    //   108: ldc 140
    //   110: aload 5
    //   112: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   115: pop
    //   116: aload 9
    //   118: ldc 145
    //   120: ldc 147
    //   122: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   125: pop
    //   126: aload 9
    //   128: ldc 149
    //   130: sipush 1030
    //   133: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   136: pop
    //   137: aload 9
    //   139: ldc 151
    //   141: ldc 153
    //   143: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   146: pop
    //   147: aload 9
    //   149: ldc 155
    //   151: iload_1
    //   152: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   155: pop
    //   156: aload_0
    //   157: getfield 30	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData	Lcom/tencent/mobileqq/activity/recent/data/RecentItemNoticeData;
    //   160: ifnull +12 -> 172
    //   163: aload_0
    //   164: getfield 30	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData	Lcom/tencent/mobileqq/activity/recent/data/RecentItemNoticeData;
    //   167: aload 9
    //   169: invokevirtual 158	com/tencent/mobileqq/activity/recent/data/RecentItemNoticeData:a	(Landroid/content/Intent;)V
    //   172: new 160	com/tencent/qphone/base/remote/ToServiceMsg
    //   175: dup
    //   176: ldc 162
    //   178: aload_0
    //   179: getfield 26	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   185: ldc 164
    //   187: invokespecial 167	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   190: astore 5
    //   192: aload 5
    //   194: getfield 171	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   197: ldc 173
    //   199: iconst_3
    //   200: anewarray 91	java/lang/String
    //   203: dup
    //   204: iconst_0
    //   205: aload 4
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: aload 6
    //   212: aastore
    //   213: dup
    //   214: iconst_2
    //   215: aload 4
    //   217: aastore
    //   218: invokevirtual 179	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   221: aload 5
    //   223: getfield 171	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   226: ldc 181
    //   228: aload 9
    //   230: invokevirtual 185	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   233: aload 5
    //   235: getfield 171	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   238: ldc 187
    //   240: aconst_null
    //   241: invokevirtual 185	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   244: aload_0
    //   245: getfield 26	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   248: aload 5
    //   250: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:sendToService	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   253: aload_0
    //   254: getfield 24	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   257: astore 4
    //   259: aload 4
    //   261: monitorenter
    //   262: aload_0
    //   263: getfield 24	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   266: iload_1
    //   267: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: invokevirtual 200	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   273: pop
    //   274: aload 4
    //   276: monitorexit
    //   277: iload 7
    //   279: ifeq +86 -> 365
    //   282: aload_0
    //   283: getfield 26	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   286: bipush 71
    //   288: invokevirtual 204	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   291: checkcast 206	com/tencent/mobileqq/managers/QQLSRecentManager
    //   294: astore 4
    //   296: aload 8
    //   298: aload_0
    //   299: getfield 26	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   305: aload 8
    //   307: ldc 207
    //   309: invokevirtual 213	android/content/Context:getString	(I)Ljava/lang/String;
    //   312: ldc 215
    //   314: iconst_1
    //   315: invokestatic 221	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   318: ifeq +33 -> 351
    //   321: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq +11 -> 335
    //   327: ldc 229
    //   329: iconst_2
    //   330: ldc 231
    //   332: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload 4
    //   337: aload_0
    //   338: getfield 26	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   341: getstatic 66	com/tencent/mobileqq/app/AppConstants:aB	Ljava/lang/String;
    //   344: sipush 1030
    //   347: iconst_0
    //   348: invokevirtual 238	com/tencent/mobileqq/managers/QQLSRecentManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IZ)V
    //   351: aload_0
    //   352: getfield 26	com/tencent/mobileqq/campuscircle/CampusNoticeManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   355: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   358: aload_0
    //   359: invokevirtual 243	com/tencent/mobileqq/campuscircle/CampusNoticeManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentBaseData;
    //   362: invokevirtual 249	com/tencent/mobileqq/app/message/QQMessageFacade:notifyObservers	(Ljava/lang/Object;)V
    //   365: return
    //   366: astore 4
    //   368: aload_0
    //   369: monitorexit
    //   370: aload 4
    //   372: athrow
    //   373: astore 5
    //   375: aload 4
    //   377: monitorexit
    //   378: aload 5
    //   380: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	CampusNoticeManager
    //   0	381	1	paramInt	int
    //   0	381	2	paramLong	long
    //   0	381	5	paramString2	String
    //   0	381	6	paramString3	String
    //   10	268	7	bool	boolean
    //   3	303	8	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   69	160	9	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   39	53	366	finally
    //   368	370	366	finally
    //   262	277	373	finally
    //   375	378	373	finally
  }
  
  public void a(QNotificationManager arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "setReaded seq: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData = null;
    QNotificationManager localQNotificationManager = ???;
    if (??? == null) {}
    try
    {
      localQNotificationManager = new QNotificationManager(BaseApplicationImpl.getContext());
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
            localQNotificationManager.cancelUseTag("CampusNoticeManager_removeNotification", "campus_notification_tag", localInteger.intValue());
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusNoticeManager", 2, "setReaded", ???);
      }
      return;
    }
  }
  
  public void a(SubMsgType0x27.MQQCampusNotify paramMQQCampusNotify)
  {
    if (paramMQQCampusNotify == null) {
      return;
    }
    int i = paramMQQCampusNotify.uint32_type.get();
    long l1 = paramMQQCampusNotify.uint64_from_uin.get();
    if (paramMQQCampusNotify.str_wording.has()) {}
    for (String str3 = paramMQQCampusNotify.str_wording.get();; str3 = null)
    {
      String str1;
      if (paramMQQCampusNotify.str_target.has())
      {
        str1 = paramMQQCampusNotify.str_target.get();
        if (TextUtils.isEmpty(str1)) {}
      }
      for (;;)
      {
        Object localObject;
        long l2;
        try
        {
          str1 = new String(Base64.a(str1), "UTF-8");
          if (!paramMQQCampusNotify.str_source.has()) {
            break label378;
          }
          paramMQQCampusNotify = paramMQQCampusNotify.str_source.get();
          localObject = paramMQQCampusNotify;
          if (paramMQQCampusNotify == null) {
            localObject = "";
          }
          if (QLog.isColorLevel()) {
            QLog.i("CampusNoticeManager", 2, String.format(Locale.getDefault(), "onReceiveNotice [type: %d uin: %d wording: %s url: %s from: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), str3, str1, localObject }));
          }
          if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1))) {
            break;
          }
          paramMQQCampusNotify = new PushReportController.PushReportItem();
          paramMQQCampusNotify.e = "0X800923D";
          paramMQQCampusNotify.d = "收到Push协议";
          PushReportController.a(str1, paramMQQCampusNotify);
          PushReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMQQCampusNotify);
          l2 = MessageCache.a();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData == null)
          {
            paramMQQCampusNotify = new RecentUser();
            paramMQQCampusNotify.uin = AppConstants.aB;
            paramMQQCampusNotify.msgType = 1030;
            paramMQQCampusNotify.type = 1030;
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData = new RecentItemNoticeData(paramMQQCampusNotify);
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(i, l1, str3, str1, (String)localObject, l2);
            a(i, l1, str3, str1, (String)localObject);
            return;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CampusNoticeManager", 2, "decode url fail ", localException);
          }
          str2 = null;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(i, l1, str3, str2, (String)localObject, l2)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(i, l1, str3, str2, (String)localObject, l2);
        a(i, l1, str3, str2, (String)localObject);
        return;
        label378:
        paramMQQCampusNotify = null;
        continue;
        continue;
        String str2 = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusNoticeManager
 * JD-Core Version:    0.7.0.1
 */