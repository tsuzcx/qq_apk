package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.aio.AIOAssist;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopNotificationHelper
{
  private static HashMap<String, Boolean> a = new HashMap();
  private static HashMap<String, Boolean> b = new HashMap();
  private static HashMap<String, TroopNotificationFlagMsg> c = new HashMap();
  private static HashMap<String, Boolean> d = new HashMap();
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 39
    //   8: iconst_2
    //   9: ldc 41
    //   11: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: getstatic 22	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:b	Ljava/util/HashMap;
    //   17: invokevirtual 47	java/util/HashMap:clear	()V
    //   20: getstatic 20	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:a	Ljava/util/HashMap;
    //   23: invokevirtual 47	java/util/HashMap:clear	()V
    //   26: getstatic 26	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:d	Ljava/util/HashMap;
    //   29: invokevirtual 47	java/util/HashMap:clear	()V
    //   32: getstatic 24	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:c	Ljava/util/HashMap;
    //   35: invokevirtual 47	java/util/HashMap:clear	()V
    //   38: new 15	java/util/HashMap
    //   41: dup
    //   42: invokespecial 18	java/util/HashMap:<init>	()V
    //   45: astore 7
    //   47: new 15	java/util/HashMap
    //   50: dup
    //   51: invokespecial 18	java/util/HashMap:<init>	()V
    //   54: astore 5
    //   56: new 15	java/util/HashMap
    //   59: dup
    //   60: invokespecial 18	java/util/HashMap:<init>	()V
    //   63: astore 8
    //   65: aload_0
    //   66: invokevirtual 53	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   69: invokevirtual 59	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   72: astore 9
    //   74: ldc 61
    //   76: invokevirtual 67	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   79: astore 6
    //   81: aload 5
    //   83: astore_0
    //   84: aload 9
    //   86: iconst_1
    //   87: aload 6
    //   89: iconst_3
    //   90: anewarray 69	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: ldc 71
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: ldc 73
    //   102: aastore
    //   103: dup
    //   104: iconst_2
    //   105: ldc 75
    //   107: aastore
    //   108: ldc 77
    //   110: iconst_1
    //   111: anewarray 69	java/lang/String
    //   114: dup
    //   115: iconst_0
    //   116: iconst_0
    //   117: invokestatic 81	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: aastore
    //   121: ldc 71
    //   123: aconst_null
    //   124: aconst_null
    //   125: aconst_null
    //   126: invokevirtual 87	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore 10
    //   131: aload 10
    //   133: ifnull +427 -> 560
    //   136: aload_0
    //   137: astore 5
    //   139: aload 10
    //   141: invokeinterface 92 1 0
    //   146: ifeq +361 -> 507
    //   149: aload_0
    //   150: astore 5
    //   152: aload 10
    //   154: ldc 71
    //   156: invokeinterface 96 2 0
    //   161: istore_1
    //   162: iload_1
    //   163: iconst_m1
    //   164: if_icmpeq +422 -> 586
    //   167: aload_0
    //   168: astore 5
    //   170: aload 10
    //   172: iload_1
    //   173: invokeinterface 100 2 0
    //   178: lstore_2
    //   179: aload_0
    //   180: astore 5
    //   182: aload 10
    //   184: ldc 75
    //   186: invokeinterface 96 2 0
    //   191: istore_1
    //   192: iload_1
    //   193: iconst_m1
    //   194: if_icmpeq +386 -> 580
    //   197: aload_0
    //   198: astore 5
    //   200: aload 10
    //   202: iload_1
    //   203: invokeinterface 104 2 0
    //   208: istore_1
    //   209: goto +3 -> 212
    //   212: aload_0
    //   213: astore 5
    //   215: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +50 -> 268
    //   221: aload_0
    //   222: astore 5
    //   224: new 106	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   231: astore 6
    //   233: aload_0
    //   234: astore 5
    //   236: aload 6
    //   238: ldc 109
    //   240: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_0
    //   245: astore 5
    //   247: aload 6
    //   249: lload_2
    //   250: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_0
    //   255: astore 5
    //   257: ldc 39
    //   259: iconst_2
    //   260: aload 6
    //   262: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload_0
    //   269: astore 5
    //   271: aload 7
    //   273: lload_2
    //   274: invokestatic 122	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   277: iconst_1
    //   278: invokestatic 127	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   281: invokevirtual 131	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   284: pop
    //   285: iload_1
    //   286: bipush 27
    //   288: if_icmpne +76 -> 364
    //   291: aload_0
    //   292: astore 5
    //   294: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +50 -> 347
    //   300: aload_0
    //   301: astore 5
    //   303: new 106	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   310: astore 6
    //   312: aload_0
    //   313: astore 5
    //   315: aload 6
    //   317: ldc 133
    //   319: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_0
    //   324: astore 5
    //   326: aload 6
    //   328: lload_2
    //   329: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_0
    //   334: astore 5
    //   336: ldc 39
    //   338: iconst_2
    //   339: aload 6
    //   341: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload_0
    //   348: astore 5
    //   350: aload 8
    //   352: lload_2
    //   353: invokestatic 122	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   356: iconst_1
    //   357: invokestatic 127	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   360: invokevirtual 131	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: aload_0
    //   365: astore 5
    //   367: aload 10
    //   369: ldc 73
    //   371: invokeinterface 96 2 0
    //   376: istore_1
    //   377: iload_1
    //   378: iconst_m1
    //   379: if_icmpeq +207 -> 586
    //   382: aload_0
    //   383: astore 5
    //   385: aload 10
    //   387: iload_1
    //   388: invokeinterface 104 2 0
    //   393: bipush 34
    //   395: if_icmpne +191 -> 586
    //   398: aload_0
    //   399: astore 5
    //   401: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +50 -> 454
    //   407: aload_0
    //   408: astore 5
    //   410: new 106	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   417: astore 6
    //   419: aload_0
    //   420: astore 5
    //   422: aload 6
    //   424: ldc 135
    //   426: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_0
    //   431: astore 5
    //   433: aload 6
    //   435: lload_2
    //   436: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload_0
    //   441: astore 5
    //   443: ldc 39
    //   445: iconst_2
    //   446: aload 6
    //   448: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: aload_0
    //   455: lload_2
    //   456: invokestatic 122	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   459: iconst_1
    //   460: invokestatic 127	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   463: invokevirtual 131	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   466: pop
    //   467: goto +3 -> 470
    //   470: aload_0
    //   471: astore 5
    //   473: aload 10
    //   475: invokeinterface 138 1 0
    //   480: istore 4
    //   482: iload 4
    //   484: ifne +9 -> 493
    //   487: aload 5
    //   489: astore_0
    //   490: goto +17 -> 507
    //   493: aload 5
    //   495: astore_0
    //   496: goto -347 -> 149
    //   499: astore 6
    //   501: aload_0
    //   502: astore 5
    //   504: goto +19 -> 523
    //   507: aload 10
    //   509: invokeinterface 141 1 0
    //   514: goto +46 -> 560
    //   517: astore_0
    //   518: goto +33 -> 551
    //   521: astore 6
    //   523: aload 6
    //   525: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   528: aload 5
    //   530: astore_0
    //   531: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq -27 -> 507
    //   537: ldc 39
    //   539: iconst_2
    //   540: ldc 146
    //   542: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   545: aload 5
    //   547: astore_0
    //   548: goto -41 -> 507
    //   551: aload 10
    //   553: invokeinterface 141 1 0
    //   558: aload_0
    //   559: athrow
    //   560: aload 9
    //   562: invokevirtual 147	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   565: aload 7
    //   567: putstatic 22	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:b	Ljava/util/HashMap;
    //   570: aload 8
    //   572: putstatic 20	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:a	Ljava/util/HashMap;
    //   575: aload_0
    //   576: putstatic 26	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:d	Ljava/util/HashMap;
    //   579: return
    //   580: bipush 27
    //   582: istore_1
    //   583: goto -371 -> 212
    //   586: goto -116 -> 470
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	paramQQAppInterface	QQAppInterface
    //   161	422	1	i	int
    //   178	278	2	l	long
    //   480	3	4	bool	boolean
    //   54	492	5	localObject1	Object
    //   79	368	6	localObject2	Object
    //   499	1	6	localException1	java.lang.Exception
    //   521	3	6	localException2	java.lang.Exception
    //   45	521	7	localHashMap1	HashMap
    //   63	508	8	localHashMap2	HashMap
    //   72	489	9	localEntityManager	EntityManager
    //   129	423	10	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   454	467	499	java/lang/Exception
    //   473	482	499	java/lang/Exception
    //   139	149	517	finally
    //   152	162	517	finally
    //   170	179	517	finally
    //   182	192	517	finally
    //   200	209	517	finally
    //   215	221	517	finally
    //   224	233	517	finally
    //   236	244	517	finally
    //   247	254	517	finally
    //   257	268	517	finally
    //   271	285	517	finally
    //   294	300	517	finally
    //   303	312	517	finally
    //   315	323	517	finally
    //   326	333	517	finally
    //   336	347	517	finally
    //   350	364	517	finally
    //   367	377	517	finally
    //   385	398	517	finally
    //   401	407	517	finally
    //   410	419	517	finally
    //   422	430	517	finally
    //   433	440	517	finally
    //   443	454	517	finally
    //   454	467	517	finally
    //   473	482	517	finally
    //   523	528	517	finally
    //   531	545	517	finally
    //   139	149	521	java/lang/Exception
    //   152	162	521	java/lang/Exception
    //   170	179	521	java/lang/Exception
    //   182	192	521	java/lang/Exception
    //   200	209	521	java/lang/Exception
    //   215	221	521	java/lang/Exception
    //   224	233	521	java/lang/Exception
    //   236	244	521	java/lang/Exception
    //   247	254	521	java/lang/Exception
    //   257	268	521	java/lang/Exception
    //   271	285	521	java/lang/Exception
    //   294	300	521	java/lang/Exception
    //   303	312	521	java/lang/Exception
    //   315	323	521	java/lang/Exception
    //   326	333	521	java/lang/Exception
    //   336	347	521	java/lang/Exception
    //   350	364	521	java/lang/Exception
    //   367	377	521	java/lang/Exception
    //   385	398	521	java/lang/Exception
    //   401	407	521	java/lang/Exception
    //   410	419	521	java/lang/Exception
    //   422	430	521	java/lang/Exception
    //   433	440	521	java/lang/Exception
    //   443	454	521	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject;
    if (paramString == null)
    {
      QLog.e("TroopNotificationHelper", 1, "setReadNewAIOTroopNotification, troopCode is NULL!");
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setReadNewTroopNotification, troop = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopNotificationHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString != null)
    {
      b.remove(paramString);
      localObject = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new_notify_");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().remove(paramString).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null)
    {
      QLog.e("TroopNotificationHelper", 1, "setUnReadRepeatTroopNotification, feeds_id is NULL!");
      return;
    }
    if (paramString2 == null)
    {
      QLog.e("TroopNotificationHelper", 1, "setUnReadRepeatTroopNotification, troopUin is NULL!");
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setUnReadRepeatTroopNotification, type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", troop = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", feedsId = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("TroopNotificationHelper", 2, ((StringBuilder)localObject).toString());
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject = paramQQAppInterface.f(paramString2);
    if (localObject == null)
    {
      QLog.e("TroopNotificationHelper", 2, "setUnReadRepeatTroopNotification, troopInfo not found!");
      return;
    }
    ((TroopInfo)localObject).feeds_id = paramString1;
    ((TroopInfo)localObject).troopRepeatType = paramInt;
    paramQQAppInterface.b((TroopInfo)localObject);
    paramQQAppInterface = new TroopNotificationFlagMsg(paramString1, paramInt);
    c.put(paramString2, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, List<TroopNotificationCache> paramList, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject2;
    if (paramString1 == null)
    {
      QLog.e("TroopNotificationHelper", 1, "saveTroopNotificationsAndShowTips, troopUin is NULL!");
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("saveTroopNotificationsAndShowTips. troop = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", feedsId = ");
      if (TextUtils.isEmpty(paramString2)) {
        localObject1 = "";
      } else {
        localObject1 = paramString2;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("TroopNotificationHelper", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramList = paramList.iterator();
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    while (paramList.hasNext())
    {
      localObject2 = (TroopNotificationCache)paramList.next();
      int j;
      if (((TroopNotificationCache)localObject2).userUin == paramQQAppInterface.getLongAccountUin())
      {
        ((TroopNotificationCache)localObject2).read = true;
        j = i;
      }
      else
      {
        ((TroopNotificationCache)localObject2).read = false;
        j = i + 1;
      }
      ((TroopNotificationCache)localObject2).currentUin = paramQQAppInterface.getCurrentAccountUin();
      ((EntityManager)localObject1).persist((Entity)localObject2);
      boolean bool3 = bool2;
      if (((TroopNotificationCache)localObject2).serviceID == 27) {
        bool3 = true;
      }
      i = j;
      bool2 = bool3;
      if (((TroopNotificationCache)localObject2).needConfirm)
      {
        bool1 = true;
        i = j;
        bool2 = bool3;
      }
    }
    ((EntityManager)localObject1).close();
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("setUnReadFlag = ");
      paramList.append(i);
      paramList.append(", isTroopNotification = ");
      paramList.append(bool2);
      QLog.d("TroopNotificationHelper", 2, paramList.toString());
    }
    if (i == 0) {
      return;
    }
    if (bool2)
    {
      paramList = AIOAssist.a();
      if ((paramList != null) && (paramList.bb() < 5) && (paramList.ag().equals(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "AIO is opened. Do not popout troop notification.");
        }
        e(paramQQAppInterface, paramString1);
        return;
      }
    }
    a(paramQQAppInterface, paramString2, paramString1, 0);
    b(paramQQAppInterface, paramString1);
    paramList = paramQQAppInterface.getHandler(Conversation.class);
    if ((paramList != null) && (bool2))
    {
      paramString2 = paramQQAppInterface.getProxyManager();
      paramString1 = paramString2.g().b(paramString1, 1);
      if (paramQQAppInterface.getTroopMask(paramString1.uin) == 3) {
        return;
      }
      if ((paramInt2 != 1) && ((paramString1.msg instanceof TroopNotificationMsg)) && (((TroopNotificationMsg)paramString1.msg).i == 1)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "update recent user list with TroopNotification orange mark.");
      }
      paramQQAppInterface = RecentDataListManager.a(paramString1.uin, paramString1.getType());
      RecentDataListManager.a().b(paramQQAppInterface);
      if (paramInt2 == 1) {
        i = 28;
      } else {
        i = 11;
      }
      paramString1.msgType = i;
      if ((paramString1.msg instanceof TroopNotificationMsg))
      {
        localObject1 = (TroopNotificationMsg)paramString1.msg;
        if (bool1) {
          paramQQAppInterface = BaseApplication.getContext().getString(2131917247);
        } else {
          paramQQAppInterface = BaseApplication.getContext().getString(2131917246);
        }
        ((TroopNotificationMsg)localObject1).c = paramQQAppInterface;
      }
      else
      {
        paramString1.msg = new TroopNotificationMsg(BaseApplication.getContext(), bool1);
      }
      ((TroopNotificationMsg)paramString1.msg).i = paramInt2;
      paramString1.lastmsgtime = paramInt1;
      paramString2.g().b(paramString1);
      paramList.sendEmptyMessage(1009);
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramString != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      Object localObject = TroopNotificationCache.class.getSimpleName();
      int i = 0;
      localObject = paramQQAppInterface.query(TroopNotificationCache.class, (String)localObject, false, "troopUin=?", new String[] { paramString }, null, null, null, null);
      if (localObject == null) {
        return;
      }
      while (i < ((List)localObject).size())
      {
        paramQQAppInterface.remove((TroopNotificationCache)((List)localObject).get(i));
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(TroopNotificationHelper.class.getSimpleName());
        paramQQAppInterface.append("-->clearTroopNotification. troop = ");
        paramQQAppInterface.append(paramString);
        QLog.d("TroopNotificationHelper", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (paramString2 == null)
    {
      QLog.e("TroopNotificationHelper", 1, "isTroopNotificationRead, feedsId is NULL!");
      return false;
    }
    if (paramString2.isEmpty())
    {
      QLog.e("TroopNotificationHelper", 1, "isTroopNotificationRead, feedsId is empty!");
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = paramQQAppInterface.query(TroopNotificationCache.class, true, "troopUin=? and read=? and feedsId=?", new String[] { paramString1, "1", paramString2 }, null, null, null, null);
    paramQQAppInterface.close();
    boolean bool1 = bool2;
    if (localList != null)
    {
      bool1 = bool2;
      if (localList.size() > 0) {
        bool1 = true;
      }
    }
    if (paramString1 == null)
    {
      QLog.e("TroopNotificationHelper", 1, "isTroopNotificationRead, troopCode is NULL!");
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isTroopNotificationRead. feedsId = ");
      paramQQAppInterface.append(paramString2);
      paramQQAppInterface.append(", troop = ");
      paramQQAppInterface.append(paramString1);
      QLog.d("TroopNotificationHelper", 2, paramQQAppInterface.toString());
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool;
    if (a.containsKey(paramString)) {
      bool = ((Boolean)a.get(paramString)).booleanValue();
    } else {
      bool = false;
    }
    if (paramString == null)
    {
      QLog.e("TroopNotificationHelper", 1, "hasNewTroopNotification, troopCode is NULL!");
      return bool;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNewTroopNotification, troop = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", bHasNewNotification = ");
      localStringBuilder.append(bool);
      QLog.d("TroopNotificationHelper", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject;
    if (paramString == null)
    {
      QLog.e("TroopNotificationHelper", 1, "setUnReadAIONewTroopNotification, troopCode is NULL!");
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setUnReadAIONewTroopNotification. troop = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopNotificationHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString != null)
    {
      b.put(paramString, Boolean.valueOf(true));
      localObject = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new_notify_");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(paramString, true).commit();
      TroopNewGuidePopWindow.b("https://gdynamic.qpic.cn/gdynamic/");
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {
      return;
    }
    a(paramQQAppInterface, paramString1, paramString2, paramInt);
    paramString1 = paramQQAppInterface.getHandler(Conversation.class);
    if (paramString1 != null)
    {
      paramQQAppInterface = paramQQAppInterface.getProxyManager();
      paramString2 = paramQQAppInterface.g().b(paramString2, 1);
      if (((paramString2.msg instanceof TroopNotificationMsg)) && (((TroopNotificationMsg)paramString2.msg).i == 1)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "setUnReadRepeatTroopNotificationPre, update recent user list");
      }
      Object localObject = RecentDataListManager.a(paramString2.uin, paramString2.getType());
      RecentDataListManager.a().b((String)localObject);
      paramString2.msgType = 11;
      localObject = new TroopNotificationMsg(BaseApplication.getContext(), true);
      ((TroopNotificationMsg)localObject).i = 0;
      paramString2.msg = localObject;
      long l = MessageCache.c();
      if (l <= paramString2.lastmsgtime) {
        l = paramString2.lastmsgtime;
      }
      paramString2.lastmsgtime = l;
      paramQQAppInterface.g().b(paramString2);
      paramString1.sendEmptyMessage(1009);
    }
  }
  
  public static void b(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("TroopNotificationHelper", 1, "setReadNewTroopNotification, troopCode is NULL!");
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setReadNewTroopNotification, troop:");
      localStringBuilder.append(paramString);
      QLog.d("TroopNotificationHelper", 2, localStringBuilder.toString());
    }
    a.remove(paramString);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null)
    {
      QLog.e("TroopNotificationHelper", 1, "setReadRepeatTroopNotification, troopUin is NULL!");
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setReadRepeatTroopNotification. troop = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopNotificationHelper", 2, ((StringBuilder)localObject).toString());
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject = paramQQAppInterface.f(paramString);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setReadRepeatTroopNotification. type: ");
        localStringBuilder.append(((TroopInfo)localObject).troopRepeatType);
        QLog.d("TroopNotificationHelper", 2, localStringBuilder.toString());
      }
      ((TroopInfo)localObject).feeds_id = "";
      ((TroopInfo)localObject).troopRepeatType = 0;
      paramQQAppInterface.b((TroopInfo)localObject);
    }
    if (c.containsKey(paramString)) {
      c.remove(paramString);
    }
  }
  
  public static boolean c(String paramString)
  {
    boolean bool;
    if (d.containsKey(paramString)) {
      bool = ((Boolean)d.get(paramString)).booleanValue();
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("hasNewGuide = ");
      paramString.append(bool);
      QLog.d("TroopNotificationHelper", 2, paramString.toString());
    }
    return bool;
  }
  
  public static TroopNotificationFlagMsg d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null)
    {
      QLog.e("TroopNotificationHelper", 1, "HasUnReadRepeatTroopNotification, troopUin is NULL!");
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HasUnReadRepeatTroopNotification. troop = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopNotificationHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (TroopNotificationFlagMsg)c.get(paramString);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("HasUnReadRepeatTroopNotification. found in mTroopNotificationRepeatAIOFlag. type = ");
        paramString.append(((TroopNotificationFlagMsg)localObject).b);
        paramString.append(", feedsId = ");
        if (TextUtils.isEmpty(((TroopNotificationFlagMsg)localObject).a)) {
          paramQQAppInterface = "";
        } else {
          paramQQAppInterface = ((TroopNotificationFlagMsg)localObject).a;
        }
        paramString.append(paramQQAppInterface);
        QLog.d("TroopNotificationHelper", 2, paramString.toString());
      }
      return localObject;
    }
    localObject = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. nothing in DB. return null");
      }
      return null;
    }
    if (((TroopInfo)localObject).feeds_id == null)
    {
      if (b.containsKey(paramString))
      {
        localObject = (Boolean)b.get(paramString);
        if ((localObject != null) && (((Boolean)localObject).booleanValue() == true))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification = false, but mTroopNotificationAIOFlag is set. Checking old version DB.");
          }
          localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          List localList = ((EntityManager)localObject).query(TroopNotificationCache.class, true, "troopUin=? and read=?", new String[] { paramString, "0" }, null, null, null, null);
          ((EntityManager)localObject).close();
          if ((localList != null) && (localList.size() > 0) && (localList.get(0) != null) && (((TroopNotificationCache)localList.get(0)).feedsId != null))
          {
            a(paramQQAppInterface, ((TroopNotificationCache)localList.get(0)).feedsId, paramString, 0);
            paramQQAppInterface = (TroopNotificationFlagMsg)c.get(paramString);
            if (QLog.isColorLevel()) {
              QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification(Old Flag). type = 0");
            }
            return paramQQAppInterface;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. feedisId is empty. return null");
      }
      return null;
    }
    paramQQAppInterface = new TroopNotificationFlagMsg(((TroopInfo)localObject).feeds_id, ((TroopInfo)localObject).troopRepeatType);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("HasUnReadRepeatTroopNotification. type = ");
      paramString.append(paramQQAppInterface.b);
      QLog.d("TroopNotificationHelper", 2, paramString.toString());
    }
    return paramQQAppInterface;
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null)
    {
      QLog.e("TroopNotificationHelper", 1, "readTroopNotification, troopUin is NULL!");
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readTroopNotification troop:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopNotificationHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    List localList = ((TroopManager)localObject).l(paramString);
    if ((localList != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readTroopNotification--->troopNotificationCaches size:");
      localStringBuilder.append(localList.size());
      QLog.d("TroopNotificationHelper", 2, localStringBuilder.toString());
    }
    ((TroopManager)localObject).m(paramString);
    b(paramString);
    a(paramQQAppInterface, paramString);
    c(paramQQAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNotificationHelper
 * JD-Core Version:    0.7.0.1
 */