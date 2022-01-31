package com.tencent.mobileqq.servlet;

import aicn;
import aicp;
import aicq;
import aicr;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.provider.QZoneConfigConst;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class QZoneManagerImp
  implements QZoneManager
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList a;
  public ConcurrentHashMap a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private boolean c;
  
  public QZoneManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver == null) {
      this.jdField_a_of_type_AndroidDatabaseContentObserver = new aicn(this, null);
    }
    try
    {
      paramQQAppInterface.getApplication().getContentResolver().registerContentObserver(QZoneConfigConst.h, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      ThreadManager.post(new aicp(this), 8, null, true);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        a(paramQQAppInterface);
      }
    }
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      for (long l1 = 0L;; l1 = 1L << ((Integer)localIterator.next()).intValue() | l1)
      {
        l2 = l1;
        if (!localIterator.hasNext()) {
          break;
        }
      }
    }
    long l2 = 0L;
    return l2;
  }
  
  private void a(int paramInt, QZoneCountInfo paramQZoneCountInfo)
  {
    if ((paramQZoneCountInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ThreadManager.post(new aicq(this, new QZoneCountInfo(paramQZoneCountInfo), paramInt), 5, null, false);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return LocalMultiProcConfig.getBool(paramQQAppInterface.getApp().getApplicationContext().getString(2131434223) + paramQQAppInterface.getAccount(), true);
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 83	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 85	java/util/concurrent/ConcurrentHashMap
    //   13: dup
    //   14: invokespecial 170	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   17: putfield 83	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   20: aload_0
    //   21: getfield 83	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: invokevirtual 173	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   27: aload_0
    //   28: getfield 34	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   34: invokevirtual 53	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   37: getstatic 176	com/tencent/common/config/provider/QZoneConfigProvider:h	Landroid/net/Uri;
    //   40: aconst_null
    //   41: ldc 178
    //   43: iconst_1
    //   44: anewarray 180	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: getfield 34	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokevirtual 183	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   56: aastore
    //   57: aconst_null
    //   58: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: aload_2
    //   67: invokestatic 190	cooperation/qzone/UndealCount/QZoneCountInfo:a	(Landroid/database/Cursor;)Ljava/util/HashMap;
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull +13 -> 85
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 83	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   81: aload_3
    //   82: invokevirtual 194	java/util/concurrent/ConcurrentHashMap:putAll	(Ljava/util/Map;)V
    //   85: aload_2
    //   86: ifnull +18 -> 104
    //   89: aload_2
    //   90: invokeinterface 199 1 0
    //   95: ifne +9 -> 104
    //   98: aload_2
    //   99: invokeinterface 202 1 0
    //   104: return
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: aload_0
    //   111: aload_3
    //   112: invokevirtual 79	com/tencent/mobileqq/servlet/QZoneManagerImp:a	(Ljava/lang/Exception;)V
    //   115: aload_2
    //   116: ifnull -12 -> 104
    //   119: aload_2
    //   120: invokeinterface 199 1 0
    //   125: ifne -21 -> 104
    //   128: aload_2
    //   129: invokeinterface 202 1 0
    //   134: return
    //   135: astore_1
    //   136: aload_2
    //   137: ifnull +18 -> 155
    //   140: aload_2
    //   141: invokeinterface 199 1 0
    //   146: ifne +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 202 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_3
    //   158: aload_1
    //   159: astore_2
    //   160: aload_3
    //   161: astore_1
    //   162: goto -26 -> 136
    //   165: astore_3
    //   166: goto -58 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	QZoneManagerImp
    //   61	49	1	localObject1	Object
    //   135	24	1	localObject2	Object
    //   161	1	1	localObject3	Object
    //   1	159	2	localObject4	Object
    //   70	12	3	localHashMap	HashMap
    //   105	7	3	localException1	Exception
    //   157	4	3	localObject5	Object
    //   165	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   27	62	105	java/lang/Exception
    //   27	62	135	finally
    //   66	71	157	finally
    //   77	85	157	finally
    //   110	115	157	finally
    //   66	71	165	java/lang/Exception
    //   77	85	165	java/lang/Exception
  }
  
  private void c()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
            return;
          }
          QZoneCountInfo[] arrayOfQZoneCountInfo = (QZoneCountInfo[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().toArray(new QZoneCountInfo[this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()]);
          Integer[] arrayOfInteger = (Integer[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().toArray(new Integer[this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()]);
          ContentValues[] arrayOfContentValues = new ContentValues[arrayOfQZoneCountInfo.length];
          i = 0;
          if (i < arrayOfQZoneCountInfo.length)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break label184;
            }
            String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
            if ((str == null) || (str.length() <= 0)) {
              break label184;
            }
            arrayOfContentValues[i] = arrayOfQZoneCountInfo[i].a();
            arrayOfContentValues[i].put("own_uin", str);
            arrayOfContentValues[i].put("type", arrayOfInteger[i]);
            break label184;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getContentResolver().bulkInsert(QZoneConfigProvider.h, arrayOfContentValues);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        a(localException);
      }
      return;
      label184:
      i += 1;
    }
  }
  
  public int a()
  {
    int j = 0;
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      j = i;
    }
    do
    {
      return j;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      i = j;
      if (str != null)
      {
        i = j;
        if (str.length() > 0) {
          i = localSharedPreferences.getInt(str, 0);
        }
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d("QZoneManagerImp.", 2, "getGetUndealCountFlag:" + i);
    return i;
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "QZoneManagerImp getFeedCount type :" + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (localQZoneCountInfo != null) {
        return (int)localQZoneCountInfo.jdField_a_of_type_Long;
      }
    }
    return 0;
  }
  
  public QZoneCountInfo a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "QZoneManagerImp getFeedCount type :" + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      return (QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Object localObject = (QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(2));
      if ((localObject != null) && (((QZoneCountInfo)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (((QZoneCountInfo)localObject).jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = ((QZoneCountInfo)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (QZoneCountUserInfo)localIterator.next();
          if ((localObject != null) && (((QZoneCountUserInfo)localObject).jdField_a_of_type_Long >= 10000L))
          {
            localArrayList.add(String.valueOf(((QZoneCountUserInfo)localObject).jdField_a_of_type_Long));
          }
          else
          {
            if (localObject == null) {}
            for (localObject = "userInfo==null";; localObject = "userInfo,uin<10000,不是合法qq号")
            {
              QLog.w("UndealCount.QZoneManagerImp.", 1, (String)localObject);
              break;
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneOnLineServlet.class);
    localNewIntent.putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localNewIntent.putExtra("lastPushMsgTime", CliNotifyPush.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(int paramInt)
  {
    if ((this.b) || (paramInt <= 0)) {}
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication() != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime. by servlet. type:" + paramInt);
          }
          if (paramInt == 2) {
            try
            {
              NewIntent localNewIntent1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
              localNewIntent1.setAction("Qzone_Get_NewAndUnread_Count");
              localNewIntent1.putExtra("qzone_send_by_time", paramInt);
              localNewIntent1.putExtra("scene", 103);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent1);
              if (QLog.isColorLevel())
              {
                QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.switch to forground.");
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
      if (paramInt == 3)
      {
        ThreadManager.post(new aicr(this, paramInt), 8, null, true);
        return;
      }
    } while ((paramInt != 5) && (paramInt != 6) && (paramInt != 7) && (paramInt != 8));
    NewIntent localNewIntent2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
    localNewIntent2.setAction("Qzone_Get_NewAndUnread_Count");
    localNewIntent2.putExtra("qzone_send_by_time", paramInt);
    if ((paramInt == 5) || (paramInt == 6)) {
      localNewIntent2.putExtra("scene", 100);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent2);
      return;
      if ((paramInt == 7) || (paramInt == 8)) {
        localNewIntent2.putExtra("scene", 104);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (l > 0L) {
        LocalMultiProcConfig.putInt4Uin("mine_message_count", paramInt2, l);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneManagerImp.", 2, "setPushCount type:" + paramInt1 + ",count" + paramInt2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a(localException);
        long l = 0L;
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
        localNewIntent.setAction("Qzone_Refresh_UI");
        localNewIntent.putExtra("notify_type", paramLong);
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QZoneManagerImp.", 1, "", localThrowable);
      }
    }
  }
  
  public void a(Exception paramException)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QZLog.e("QZoneManagerImp.", "handleException app == null");
      return;
    }
    String str;
    if ((paramException instanceof IllegalArgumentException)) {
      if ((paramException.getMessage() != null) && (paramException.getMessage().contains("Unknown URI"))) {
        str = "0";
      }
    }
    for (;;)
    {
      QLog.e("QZoneManagerImp.", 1, paramException, new Object[0]);
      HashMap localHashMap = new HashMap();
      localHashMap.put("exception", paramException.getClass().getSimpleName());
      localHashMap.put("type", str);
      localHashMap.put("msg", paramException.getMessage());
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qzoneconfigdberror", true, 0L, 0L, localHashMap, null, true);
      return;
      str = "1";
      continue;
      str = "2";
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      paramString1.setAction("Qzone_Get_NewAndUnread_Count");
      paramString1.putExtra("qzone_send_by_time", 1);
      paramString1.putExtra("scene", 100);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "sendGetFeedCount");
    }
    this.b = false;
  }
  
  public void a(HashMap paramHashMap)
  {
    for (;;)
    {
      int j;
      int i;
      boolean bool;
      try
      {
        if (this.c)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ZebraAlbum.QZoneManagerImp.", 4, "setFeedCount.user enter qzone.dismiss data.");
          }
        }
        else if ((paramHashMap != null) && (paramHashMap.size() != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          paramHashMap = paramHashMap.entrySet().toArray();
          if (paramHashMap == null) {
            break label329;
          }
          int m = paramHashMap.length;
          j = 0;
          i = 0;
          k = i;
          if (j < m)
          {
            Integer localInteger = paramHashMap[j];
            if ((localInteger != null) && ((localInteger instanceof Map.Entry)))
            {
              Object localObject = (Map.Entry)localInteger;
              localInteger = (Integer)((Map.Entry)localObject).getKey();
              localObject = (QZoneCountInfo)((Map.Entry)localObject).getValue();
              if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FeedAlert.", 2, "QZoneManagerImp.checkShowQZonePush" + Long.toBinaryString(this.jdField_a_of_type_Long) + ",count" + ((QZoneCountInfo)localObject).jdField_a_of_type_Long);
                }
                if (localInteger.intValue() == 17) {
                  break label303;
                }
              }
              bool = a(localInteger.intValue(), (QZoneCountInfo)localObject);
              if ((!bool) || (!QLog.isColorLevel())) {
                break label310;
              }
              QLog.d("FeedAlert.", 2, "QZoneManagerImp.set feedcout map type:" + Long.toBinaryString(this.jdField_a_of_type_Long) + "count change ,key=" + localInteger);
              break label310;
            }
          }
          else
          {
            if (k == 0) {
              break label302;
            }
            c();
            return;
          }
        }
      }
      catch (Exception paramHashMap)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QZoneManagerImp.", 2, paramHashMap.toString());
          return;
        }
      }
      label302:
      return;
      for (;;)
      {
        label303:
        j += 1;
        break;
        label310:
        if ((i != 0) || (bool)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      label329:
      int k = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "setEnterQZone.isenter=" + paramBoolean);
    }
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(int paramInt, long paramLong, ArrayList paramArrayList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    QLog.i("QZoneManagerImp.", 1, "qzone redtypeinfo:setFeedCount.feedtype=" + paramInt + ",count=" + paramLong + ",uin");
    if ((paramInt < 1) || (paramInt > 100)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
    localQZoneCountInfo.jdField_a_of_type_Long = paramLong;
    localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    localQZoneCountInfo.jdField_a_of_type_Boolean = paramBoolean1;
    localQZoneCountInfo.d = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      localQZoneCountInfo.c = paramString2;
    }
    paramBoolean1 = false;
    paramArrayList = (QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (!localQZoneCountInfo.a(paramArrayList)) {
      paramBoolean1 = true;
    }
    if (paramBoolean1)
    {
      if ((paramLong > 0L) && (paramArrayList != null) && (paramArrayList.jdField_a_of_type_JavaUtilArrayList != null) && (localQZoneCountInfo != null) && (localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramString1 = localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (paramString1.hasNext())
        {
          paramString2 = (QZoneCountUserInfo)paramString1.next();
          i = 0;
          for (;;)
          {
            if ((i >= paramArrayList.jdField_a_of_type_JavaUtilArrayList.size()) || (((QZoneCountUserInfo)paramArrayList.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramString2.jdField_a_of_type_Long))
            {
              if ((i == -1) || (i >= paramArrayList.jdField_a_of_type_JavaUtilArrayList.size())) {
                break;
              }
              paramArrayList.jdField_a_of_type_JavaUtilArrayList.remove(i);
              break;
            }
            i += 1;
          }
        }
        localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList.jdField_a_of_type_JavaUtilArrayList);
        int i = localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.size();
        if (i > 3) {
          localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.remove(i - 1);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localQZoneCountInfo);
      a(paramInt, localQZoneCountInfo);
    }
    return paramBoolean1;
  }
  
  public boolean a(int paramInt, QZoneCountInfo paramQZoneCountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "setFeedCountAll.feedtype=" + paramInt + ",count=" + String.valueOf(paramQZoneCountInfo) + ",uin");
    }
    boolean bool2;
    if ((paramInt < 1) || (paramInt > 100))
    {
      bool2 = false;
      return bool2;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (!paramQZoneCountInfo.a((QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramQZoneCountInfo);
      return bool1;
    }
  }
  
  @TargetApi(9)
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0).edit();
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((str != null) && (str.length() > 0)) {
        localEditor.putInt(str, paramInt);
      }
      if (Build.VERSION.SDK_INT < 9) {
        localEditor.commit();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("QZoneManagerImp.", 2, "setGetUndealCountFlag:" + paramInt);
        return;
        localEditor.apply();
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneManagerImp.", 4, "QZoneManagerImp clearUnReadCount cache arrays.type = " + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
    StringBuilder localStringBuilder = new StringBuilder("own_uin").append("=? AND ").append("type").append("=?");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getContentResolver().delete(QZoneConfigConst.h, localStringBuilder.toString(), new String[] { str, String.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      a(localException);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
      this.jdField_a_of_type_AndroidDatabaseContentObserver = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp
 * JD-Core Version:    0.7.0.1
 */