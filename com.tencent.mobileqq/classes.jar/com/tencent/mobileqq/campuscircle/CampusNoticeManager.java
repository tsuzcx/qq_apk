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
  int a = 1000;
  final ArrayList<Integer> b = new ArrayList();
  QQAppInterface c;
  RecentItemNoticeData d;
  MessageForText e;
  
  public CampusNoticeManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
  }
  
  public RecentBaseData a()
  {
    return this.d;
  }
  
  /* Error */
  public void a(int paramInt, long paramLong, String arg4, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore 9
    //   5: aload 9
    //   7: invokestatic 47	com/tencent/mobileqq/utils/QQUtils:a	(Landroid/content/Context;)Z
    //   10: istore 7
    //   12: aload_0
    //   13: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16: getfield 53	com/tencent/mobileqq/app/QQAppInterface:isBackgroundPause	Z
    //   19: ifne +27 -> 46
    //   22: aload_0
    //   23: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: getfield 56	com/tencent/mobileqq/app/QQAppInterface:isBackgroundStop	Z
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
    //   49: getfield 24	com/tencent/mobileqq/campuscircle/CampusNoticeManager:a	I
    //   52: iconst_1
    //   53: iadd
    //   54: istore_1
    //   55: aload_0
    //   56: iload_1
    //   57: putfield 24	com/tencent/mobileqq/campuscircle/CampusNoticeManager:a	I
    //   60: aload_0
    //   61: monitorexit
    //   62: new 58	android/content/Intent
    //   65: dup
    //   66: aload_0
    //   67: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 61	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   73: ldc 63
    //   75: invokespecial 66	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   78: astore 8
    //   80: aload 8
    //   82: ldc 68
    //   84: iconst_1
    //   85: invokevirtual 72	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   88: pop
    //   89: aload 8
    //   91: ldc 74
    //   93: iconst_4
    //   94: invokevirtual 72	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   97: pop
    //   98: aload 8
    //   100: ldc 75
    //   102: invokevirtual 79	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   105: pop
    //   106: aload 8
    //   108: ldc 81
    //   110: iconst_3
    //   111: invokevirtual 72	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload 8
    //   117: ldc 83
    //   119: aload 5
    //   121: invokevirtual 86	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   124: pop
    //   125: aload 8
    //   127: ldc 88
    //   129: ldc 90
    //   131: invokevirtual 86	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   134: pop
    //   135: aload 8
    //   137: ldc 92
    //   139: sipush 1030
    //   142: invokevirtual 72	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   145: pop
    //   146: aload 8
    //   148: ldc 94
    //   150: lload_2
    //   151: invokestatic 100	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   154: invokevirtual 86	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   157: pop
    //   158: aload 8
    //   160: ldc 102
    //   162: ldc 104
    //   164: invokevirtual 86	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   167: pop
    //   168: aload 8
    //   170: ldc 106
    //   172: iload_1
    //   173: invokevirtual 72	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   176: pop
    //   177: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +35 -> 215
    //   183: ldc 114
    //   185: iconst_2
    //   186: iconst_4
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: ldc 116
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: iload_1
    //   198: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: aastore
    //   202: dup
    //   203: iconst_2
    //   204: ldc 123
    //   206: aastore
    //   207: dup
    //   208: iconst_3
    //   209: aload 5
    //   211: aastore
    //   212: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   215: aload_0
    //   216: getfield 35	com/tencent/mobileqq/campuscircle/CampusNoticeManager:d	Lcom/tencent/mobileqq/activity/recent/data/RecentItemNoticeData;
    //   219: astore 5
    //   221: aload 5
    //   223: ifnull +10 -> 233
    //   226: aload 5
    //   228: aload 8
    //   230: invokevirtual 131	com/tencent/mobileqq/activity/recent/data/RecentItemNoticeData:a	(Landroid/content/Intent;)V
    //   233: new 133	com/tencent/qphone/base/remote/ToServiceMsg
    //   236: dup
    //   237: ldc 135
    //   239: aload_0
    //   240: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: invokevirtual 139	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   246: ldc 141
    //   248: invokespecial 144	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   251: astore 5
    //   253: aload 5
    //   255: getfield 148	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   258: ldc 150
    //   260: iconst_3
    //   261: anewarray 96	java/lang/String
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
    //   279: invokevirtual 156	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   282: aload 5
    //   284: getfield 148	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   287: ldc 158
    //   289: aload 8
    //   291: invokevirtual 162	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   294: aload 5
    //   296: getfield 148	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   299: ldc 164
    //   301: aconst_null
    //   302: invokevirtual 162	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   305: aload_0
    //   306: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   309: aload 5
    //   311: invokevirtual 168	com/tencent/mobileqq/app/QQAppInterface:sendToService	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   314: aload_0
    //   315: getfield 29	com/tencent/mobileqq/campuscircle/CampusNoticeManager:b	Ljava/util/ArrayList;
    //   318: astore 4
    //   320: aload 4
    //   322: monitorenter
    //   323: aload_0
    //   324: getfield 29	com/tencent/mobileqq/campuscircle/CampusNoticeManager:b	Ljava/util/ArrayList;
    //   327: iload_1
    //   328: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   331: invokevirtual 172	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   334: pop
    //   335: aload 4
    //   337: monitorexit
    //   338: aload 8
    //   340: astore 4
    //   342: iload 7
    //   344: ifeq +98 -> 442
    //   347: aload_0
    //   348: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   351: getstatic 177	com/tencent/mobileqq/app/QQManagerFactory:QQLS_DATA_MANAGER	I
    //   354: invokevirtual 181	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   357: checkcast 183	com/tencent/mobileqq/managers/QQLSRecentManager
    //   360: astore 5
    //   362: aload 9
    //   364: aload_0
    //   365: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   368: invokevirtual 139	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   371: aload 9
    //   373: ldc 184
    //   375: invokevirtual 190	android/content/Context:getString	(I)Ljava/lang/String;
    //   378: ldc 192
    //   380: iconst_1
    //   381: invokestatic 198	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   384: ifeq +44 -> 428
    //   387: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +11 -> 401
    //   393: ldc 114
    //   395: iconst_2
    //   396: ldc 200
    //   398: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: aload 5
    //   403: aload_0
    //   404: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: getstatic 209	com/tencent/mobileqq/app/AppConstants:CAMPUS_NOTICE_UIN	Ljava/lang/String;
    //   410: sipush 1030
    //   413: iconst_0
    //   414: getstatic 209	com/tencent/mobileqq/app/AppConstants:CAMPUS_NOTICE_UIN	Ljava/lang/String;
    //   417: sipush 1030
    //   420: aload 4
    //   422: invokestatic 214	com/tencent/mobileqq/managers/MsgPushReportHelper:a	(Ljava/lang/String;ILandroid/content/Intent;)I
    //   425: invokevirtual 217	com/tencent/mobileqq/managers/QQLSRecentManager:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;IZI)V
    //   428: aload_0
    //   429: getfield 31	com/tencent/mobileqq/campuscircle/CampusNoticeManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   432: invokevirtual 221	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   435: aload_0
    //   436: invokevirtual 223	com/tencent/mobileqq/campuscircle/CampusNoticeManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentBaseData;
    //   439: invokevirtual 229	com/tencent/imcore/message/QQMessageFacade:notifyObservers	(Ljava/lang/Object;)V
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
      QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "setReaded seq: %d", new Object[] { Integer.valueOf(this.a) }));
    }
    this.d = null;
    QQNotificationManager localQQNotificationManager = ???;
    if (??? == null) {}
    try
    {
      BaseApplicationImpl.getContext();
      localQQNotificationManager = QQNotificationManager.getInstance();
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
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
        this.b.clear();
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
          str1 = new String(Base64.b(str3), "UTF-8");
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
      PushReportController.a(this.c, (PushReportController.PushReportItem)localObject);
      long l2 = MessageCache.c();
      localObject = this.d;
      if (localObject == null)
      {
        localObject = new RecentUser();
        ((RecentUser)localObject).uin = AppConstants.CAMPUS_NOTICE_UIN;
        ((RecentUser)localObject).msgType = 1030;
        ((RecentUser)localObject).setType(1030);
        this.d = new RecentItemNoticeData((RecentUser)localObject);
        this.d.a(i, l1, str2, localCharSequence, paramMQQCampusNotify, l2);
        a(i, l1, str2, localCharSequence, paramMQQCampusNotify);
        return;
      }
      if (!((RecentItemNoticeData)localObject).b(i, l1, str2, localCharSequence, paramMQQCampusNotify, l2))
      {
        this.d.a(i, l1, str2, localCharSequence, paramMQQCampusNotify, l2);
        a(i, l1, str2, localCharSequence, paramMQQCampusNotify);
      }
    }
  }
  
  public MessageForText b()
  {
    RecentItemNoticeData localRecentItemNoticeData = this.d;
    if (localRecentItemNoticeData == null) {
      return null;
    }
    if (this.e == null)
    {
      this.e = ((MessageForText)MessageRecordFactory.a(-1000));
      MessageForText localMessageForText = this.e;
      localMessageForText.msgtype = -1000;
      localMessageForText.istroop = 1030;
      localMessageForText.isread = false;
      localMessageForText.selfuin = this.c.getCurrentAccountUin();
      this.e.senderuin = AppConstants.CAMPUS_NOTICE_UIN;
      this.e.frienduin = AppConstants.CAMPUS_NOTICE_UIN;
      this.e.msg = localRecentItemNoticeData.wording;
      this.e.time = localRecentItemNoticeData.time;
    }
    if ((this.e.msg == null) || (!this.e.msg.equals(localRecentItemNoticeData.mTitleName))) {
      this.e.msg = localRecentItemNoticeData.mTitleName;
    }
    if (this.e.time != localRecentItemNoticeData.time) {
      this.e.time = localRecentItemNoticeData.time;
    }
    return this.e;
  }
  
  public int c()
  {
    if (this.d == null) {
      return 0;
    }
    return 1;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusNoticeManager", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusNoticeManager
 * JD-Core Version:    0.7.0.1
 */