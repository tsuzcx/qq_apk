package com.tencent.mobileqq.servlet;

import NS_GROUP_COUNT.mobile_group_count_rsp;
import NS_UNDEAL_COUNT.entrance_cfg;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneReq;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
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
  private static boolean d = true;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile Boolean jdField_a_of_type_JavaLangBoolean = null;
  public ArrayList<entrance_cfg> a;
  public HashMap<String, QZoneManagerImp.QzoneGroupInfo> a;
  public ConcurrentHashMap<Integer, QZoneCountInfo> a;
  private boolean jdField_a_of_type_Boolean;
  private HashMap<String, Long> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = false;
  
  public QZoneManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver == null) {
      this.jdField_a_of_type_AndroidDatabaseContentObserver = new QZoneManagerImp.1(this, null);
    }
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        paramQQAppInterface.getApplication().getContentResolver().registerContentObserver(QZoneConfigConst.h, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      }
    }
    catch (Exception localException)
    {
      a(localException);
    }
    ThreadManager.post(new QZoneManagerImp.2(this, paramQQAppInterface), 8, null, true);
  }
  
  private long a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    long l1 = 0L;
    long l2 = l1;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      for (;;)
      {
        l2 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        l1 |= 1L << ((Integer)((Iterator)localObject).next()).intValue();
      }
    }
    return l2;
  }
  
  private void a(int paramInt, QZoneCountInfo paramQZoneCountInfo)
  {
    if (paramQZoneCountInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      ThreadManager.post(new QZoneManagerImp.3(this, new QZoneCountInfo(paramQZoneCountInfo), paramInt), 5, null, false);
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getApp().getApplicationContext().getString(2131718396));
    localStringBuilder.append(paramQQAppInterface.getAccount());
    return LocalMultiProcConfig.getBool(localStringBuilder.toString(), true);
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 109	java/util/concurrent/ConcurrentHashMap
    //   11: dup
    //   12: invokespecial 193	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   15: putfield 35	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   18: aload_0
    //   19: getfield 35	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   22: invokevirtual 196	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   25: aconst_null
    //   26: astore_1
    //   27: aconst_null
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 59	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 74	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   36: invokevirtual 80	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   39: getstatic 199	com/tencent/common/config/provider/QZoneConfigProvider:h	Landroid/net/Uri;
    //   42: aconst_null
    //   43: ldc 201
    //   45: iconst_1
    //   46: anewarray 203	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_0
    //   52: getfield 59	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   58: aastore
    //   59: aconst_null
    //   60: invokevirtual 210	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore_3
    //   64: aload_3
    //   65: astore_2
    //   66: aload_3
    //   67: astore_1
    //   68: aload_3
    //   69: invokestatic 214	cooperation/qzone/UndealCount/QZoneCountInfo:createFromCursor	(Landroid/database/Cursor;)Ljava/util/HashMap;
    //   72: astore 4
    //   74: aload 4
    //   76: ifnull +16 -> 92
    //   79: aload_3
    //   80: astore_2
    //   81: aload_3
    //   82: astore_1
    //   83: aload_0
    //   84: getfield 35	com/tencent/mobileqq/servlet/QZoneManagerImp:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   87: aload 4
    //   89: invokevirtual 218	java/util/concurrent/ConcurrentHashMap:putAll	(Ljava/util/Map;)V
    //   92: aload_3
    //   93: ifnull +48 -> 141
    //   96: aload_3
    //   97: invokeinterface 223 1 0
    //   102: ifne +39 -> 141
    //   105: aload_3
    //   106: astore_1
    //   107: goto +28 -> 135
    //   110: astore_1
    //   111: goto +31 -> 142
    //   114: astore_3
    //   115: aload_1
    //   116: astore_2
    //   117: aload_0
    //   118: aload_3
    //   119: invokevirtual 95	com/tencent/mobileqq/servlet/QZoneManagerImp:a	(Ljava/lang/Exception;)V
    //   122: aload_1
    //   123: ifnull +18 -> 141
    //   126: aload_1
    //   127: invokeinterface 223 1 0
    //   132: ifne +9 -> 141
    //   135: aload_1
    //   136: invokeinterface 226 1 0
    //   141: return
    //   142: aload_2
    //   143: ifnull +18 -> 161
    //   146: aload_2
    //   147: invokeinterface 223 1 0
    //   152: ifne +9 -> 161
    //   155: aload_2
    //   156: invokeinterface 226 1 0
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	QZoneManagerImp
    //   26	81	1	localObject1	Object
    //   110	52	1	localObject2	Object
    //   28	128	2	localObject3	Object
    //   63	43	3	localCursor	android.database.Cursor
    //   114	5	3	localException	Exception
    //   72	16	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   29	64	110	finally
    //   68	74	110	finally
    //   83	92	110	finally
    //   117	122	110	finally
    //   29	64	114	java/lang/Exception
    //   68	74	114	java/lang/Exception
    //   83	92	114	java/lang/Exception
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
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
              if ((str != null) && (str.length() > 0))
              {
                arrayOfContentValues[i] = arrayOfQZoneCountInfo[i].convertToContentValues();
                arrayOfContentValues[i].put("own_uin", str);
                arrayOfContentValues[i].put("type", arrayOfInteger[i]);
              }
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getContentResolver().bulkInsert(QZoneConfigProvider.h, arrayOfContentValues);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        a(localException);
        return;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    int i = j;
    if (str != null)
    {
      i = j;
      if (str.length() > 0) {
        i = ((SharedPreferences)localObject).getInt(str, 0);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGetUndealCountFlag:");
      ((StringBuilder)localObject).append(i);
      QLog.d("QZoneManagerImp.", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QZoneManagerImp getFeedCount type :");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QZoneManagerImp.", 2, ((StringBuilder)localObject).toString());
    }
    int j = 0;
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    int i = j;
    if (localObject != null)
    {
      localObject = (QZoneCountInfo)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt));
      i = j;
      if (localObject != null) {
        i = (int)((QZoneCountInfo)localObject).uCount;
      }
    }
    return i;
  }
  
  public QZoneCountInfo a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QZoneManagerImp getFeedCount type :");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QZoneManagerImp.", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null) {
      return (QZoneCountInfo)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      localObject = (QZoneCountInfo)((ConcurrentHashMap)localObject).get(Integer.valueOf(2));
      if ((localObject != null) && (((QZoneCountInfo)localObject).friendList != null) && (((QZoneCountInfo)localObject).friendList.size() > 0))
      {
        Iterator localIterator = ((QZoneCountInfo)localObject).friendList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (QZoneCountUserInfo)localIterator.next();
          if ((localObject != null) && (((QZoneCountUserInfo)localObject).uin >= 10000L))
          {
            localArrayList.add(String.valueOf(((QZoneCountUserInfo)localObject).uin));
          }
          else
          {
            if (localObject == null) {
              localObject = "userInfo==null";
            } else {
              localObject = "userInfo,uin<10000,不是合法qq号";
            }
            QLog.w("UndealCount.QZoneManagerImp.", 1, (String)localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    IQzoneReq localIQzoneReq = (IQzoneReq)QRoute.api(IQzoneReq.class);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localIQzoneReq.sentOnlineServlet(localQQAppInterface, localQQAppInterface.getAccount(), CliNotifyPush.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (paramInt <= 0) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null)
      {
        if (((QQAppInterface)localObject).getApplication() == null) {
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendGetFeedByTime. by servlet. type:");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("QZoneManagerImp..UndealCount", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt == 2)
        {
          try
          {
            localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
            ((NewIntent)localObject).setAction("Qzone_Get_NewAndUnread_Count");
            ((NewIntent)localObject).putExtra("qzone_send_by_time", paramInt);
            ((NewIntent)localObject).putExtra("scene", 103);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.i("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.switch to forground.");
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return;
          }
        }
        else
        {
          if (paramInt == 3)
          {
            ThreadManager.post(new QZoneManagerImp.4(this, paramInt), 8, null, true);
            return;
          }
          if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8))
          {
            NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
            localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
            localNewIntent.putExtra("qzone_send_by_time", paramInt);
            if ((paramInt != 5) && (paramInt != 6))
            {
              if ((paramInt == 7) || (paramInt == 8)) {
                localNewIntent.putExtra("scene", 104);
              }
            }
            else {
              localNewIntent.putExtra("scene", 100);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l;
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
    catch (Exception localException)
    {
      a(localException);
      l = 0L;
    }
    if (l > 0L) {
      LocalMultiProcConfig.putInt4Uin("mine_message_count", paramInt2, l);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPushCount type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",count");
      localStringBuilder.append(paramInt2);
      QLog.d("QZoneManagerImp.", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = new NewIntent(((QQAppInterface)localObject).getApplication(), QZoneNotifyServlet.class);
      ((NewIntent)localObject).setAction("Qzone_Refresh_UI");
      ((NewIntent)localObject).putExtra("notify_type", paramLong);
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QZoneManagerImp.", 1, "", localThrowable);
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
    if ((paramException instanceof IllegalArgumentException))
    {
      if ((paramException.getMessage() != null) && (paramException.getMessage().contains("Unknown URI"))) {
        str = "0";
      } else {
        str = "1";
      }
    }
    else {
      str = "2";
    }
    QLog.e("QZoneManagerImp.", 1, paramException, new Object[0]);
    HashMap localHashMap = new HashMap();
    localHashMap.put("exception", paramException.getClass().getSimpleName());
    localHashMap.put("type", str);
    localHashMap.put("msg", paramException.getMessage());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qzoneconfigdberror", true, 0L, 0L, localHashMap, null, true);
    ((IQzoneExceptionReport)QRoute.api(IQzoneExceptionReport.class)).doReport(paramException, "QZoneConfigProvider error");
  }
  
  public void a(String paramString, mobile_group_count_rsp parammobile_group_count_rsp)
  {
    Object localObject2 = (QZoneManagerImp.QzoneGroupInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new QZoneManagerImp.QzoneGroupInfo();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    paramString = new ArrayList();
    localObject2 = parammobile_group_count_rsp.vecUinList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramString.add(String.valueOf((Long)((Iterator)localObject2).next()));
    }
    ((QZoneManagerImp.QzoneGroupInfo)localObject1).jdField_a_of_type_JavaUtilArrayList = paramString;
    ((QZoneManagerImp.QzoneGroupInfo)localObject1).jdField_a_of_type_Long = parammobile_group_count_rsp.stCount;
    ((QZoneManagerImp.QzoneGroupInfo)localObject1).b = parammobile_group_count_rsp.iNextTimeout;
    int i = parammobile_group_count_rsp.iShowRedPoint;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    ((QZoneManagerImp.QzoneGroupInfo)localObject1).jdField_a_of_type_Boolean = bool;
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramString1 == null) {
      return;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      paramString1 = new NewIntent(paramString1.getApplication(), QZoneNotifyServlet.class);
      paramString1.setAction("Qzone_Get_NewAndUnread_Count");
      paramString1.putExtra("qzone_send_by_time", 1);
      paramString1.putExtra("scene", 100);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "sendGetFeedCount");
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(HashMap<Integer, QZoneCountInfo> paramHashMap)
  {
    int k;
    int j;
    try
    {
      if (!this.c) {
        break label341;
      }
      if (!QLog.isDevelopLevel()) {
        break label340;
      }
      QLog.d("ZebraAlbum.QZoneManagerImp.", 4, "setFeedCount.user enter qzone.dismiss data.");
      return;
    }
    catch (Exception paramHashMap)
    {
      int m;
      Integer localInteger;
      Object localObject;
      StringBuilder localStringBuilder;
      if (!QLog.isColorLevel()) {
        break label339;
      }
      QLog.d("QZoneManagerImp.", 2, paramHashMap.toString());
    }
    if (paramHashMap.size() == 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    paramHashMap = paramHashMap.entrySet().toArray();
    int i = 0;
    label65:
    boolean bool;
    if (paramHashMap != null)
    {
      m = paramHashMap.length;
      k = 0;
      i = 0;
      if (k >= m) {
        break label376;
      }
      localInteger = paramHashMap[k];
      j = i;
      if (localInteger == null) {
        break label365;
      }
      j = i;
      if (!(localInteger instanceof Map.Entry)) {
        break label365;
      }
      localObject = (Map.Entry)localInteger;
      localInteger = (Integer)((Map.Entry)localObject).getKey();
      localObject = (QZoneCountInfo)((Map.Entry)localObject).getValue();
      bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("QZoneManagerImp.checkShowQZonePush");
          localStringBuilder.append(Long.toBinaryString(this.jdField_a_of_type_Long));
          localStringBuilder.append(",count");
          localStringBuilder.append(((QZoneCountInfo)localObject).uCount);
          QLog.d("FeedAlert.", 2, localStringBuilder.toString());
        }
        if (localInteger.intValue() == 17)
        {
          j = i;
          break label365;
        }
      }
      bool = a(localInteger.intValue(), (QZoneCountInfo)localObject);
      if ((!bool) || (!QLog.isColorLevel())) {
        break label346;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QZoneManagerImp.set feedcout map type:");
      ((StringBuilder)localObject).append(Long.toBinaryString(this.jdField_a_of_type_Long));
      ((StringBuilder)localObject).append("count change ,key=");
      ((StringBuilder)localObject).append(localInteger);
      QLog.d("FeedAlert.", 2, ((StringBuilder)localObject).toString());
    }
    label339:
    label340:
    label341:
    label346:
    label365:
    label376:
    for (;;)
    {
      if (i != 0)
      {
        c();
        return;
      }
      return;
      return;
      if (paramHashMap != null) {
        break;
      }
      return;
      if ((i == 0) && (!bool)) {
        j = 0;
      } else {
        j = 1;
      }
      k += 1;
      i = j;
      break label65;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEnterQZone.isenter=");
      localStringBuilder.append(paramBoolean);
      QLog.d("QZoneManagerImp.", 2, localStringBuilder.toString());
    }
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(int paramInt, long paramLong, ArrayList<QZoneCountUserInfo> paramArrayList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qzone redtypeinfo:setFeedCount.feedtype=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",count=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(",uin");
    QLog.i("QZoneManagerImp.", 1, ((StringBuilder)localObject).toString());
    if (paramInt >= 1)
    {
      if (paramInt > 1014) {
        return false;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      localObject = new QZoneCountInfo();
      ((QZoneCountInfo)localObject).uCount = paramLong;
      ((QZoneCountInfo)localObject).friendList = paramArrayList;
      ((QZoneCountInfo)localObject).existDL = paramBoolean1;
      ((QZoneCountInfo)localObject).pushMesssage = paramString1;
      if (!TextUtils.isEmpty(paramString2)) {
        ((QZoneCountInfo)localObject).schema = paramString2;
      }
      paramArrayList = (QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      paramBoolean1 = ((QZoneCountInfo)localObject).equals(paramArrayList) ^ true;
      if (paramBoolean1)
      {
        if ((paramLong > 0L) && (paramArrayList != null) && (paramArrayList.friendList != null) && (((QZoneCountInfo)localObject).friendList != null) && (((QZoneCountInfo)localObject).friendList.size() > 0))
        {
          paramString1 = ((QZoneCountInfo)localObject).friendList.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (QZoneCountUserInfo)paramString1.next();
            int i = 0;
            while ((i < paramArrayList.friendList.size()) && (((QZoneCountUserInfo)paramArrayList.friendList.get(i)).uin != paramString2.uin)) {
              i += 1;
            }
            if ((i != -1) && (i < paramArrayList.friendList.size())) {
              paramArrayList.friendList.remove(i);
            }
          }
          ((QZoneCountInfo)localObject).friendList.addAll(paramArrayList.friendList);
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject);
        a(paramInt, (QZoneCountInfo)localObject);
      }
      return paramBoolean1;
    }
    return false;
  }
  
  public boolean a(int paramInt, QZoneCountInfo paramQZoneCountInfo)
  {
    boolean bool1 = false;
    if (paramQZoneCountInfo == null)
    {
      QZLog.e("QZoneManagerImp.", "saveCountInfoInMemIfChanged qZoneCountInfo == null");
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFeedCountAll.feedtype=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",count=");
      localStringBuilder.append(paramQZoneCountInfo.uCount);
      localStringBuilder.append(",uin");
      QLog.d("QZoneManagerImp.", 2, localStringBuilder.toString());
    }
    if (paramInt >= 1)
    {
      if (paramInt > 1014) {
        return false;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      boolean bool2 = paramQZoneCountInfo.equals((QZoneCountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))) ^ true;
      bool1 = bool2;
      if (bool2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramQZoneCountInfo);
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  @TargetApi(9)
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0).edit();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if ((str != null) && (str.length() > 0)) {
      ((SharedPreferences.Editor)localObject).putInt(str, paramInt);
    }
    if (Build.VERSION.SDK_INT < 9) {
      ((SharedPreferences.Editor)localObject).commit();
    } else {
      ((SharedPreferences.Editor)localObject).apply();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setGetUndealCountFlag:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QZoneManagerImp.", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_JavaLangBoolean == null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
      boolean bool = true;
      if ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, l) & 0x80) == 0) {
        bool = false;
      }
      b(bool);
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public void c(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QZoneManagerImp clearUnReadCount cache arrays.type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QZoneManagerImp.", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).remove(Integer.valueOf(paramInt));
    }
    localObject = new StringBuilder("own_uin");
    ((StringBuilder)localObject).append("=? AND ");
    ((StringBuilder)localObject).append("type");
    ((StringBuilder)localObject).append("=?");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getContentResolver().delete(QZoneConfigConst.h, ((StringBuilder)localObject).toString(), new String[] { str, String.valueOf(paramInt) });
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
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp
 * JD-Core Version:    0.7.0.1
 */