package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.EnvUtils;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MiniAppReportManager
{
  public static final int DEFAULT_DURATION = 1;
  public static final long DELAY_CHECK_DB;
  public static final long DELAY_WAITING;
  public static final String KEY_ACTION_TYPE = "action_type";
  public static final String KEY_ADD_DURATION_MS = "add_duration_ms";
  public static final String KEY_APP_CONFIG = "app_config";
  public static final String KEY_APP_TYPE = "app_type";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESERVES = "reserves";
  public static final String KEY_RESERVES2 = "reserves2";
  public static final String KEY_SUB_ACTION = "sub_action";
  public static final String KEY_X5_ENABLE = "x5_enable";
  public static final long MAX_TIME_VALUE = 9999999L;
  public static final long OPEN_TIME_OUT = ;
  public static final String TAG = "MiniAppReportManager";
  public static HashMap<String, Long> appPauseTimeMap;
  public static HashMap<String, Long> clickTimeMap;
  public static HashSet<String> hasPkgSet;
  public static HashSet<String> jsErrorSet;
  private static Application.ActivityLifecycleCallbacks lifecycleCallbacks;
  public static HashMap<String, MiniAppReportEntity> miniAppReportEntityHashMap = new HashMap();
  private static volatile boolean needCheckReportForeground;
  public static HashMap<String, Long> showTimeMap;
  public static HashSet<String> x5EnableSet;
  
  static
  {
    DELAY_WAITING = GameWnsUtils.getReportDelayWaiting();
    DELAY_CHECK_DB = GameWnsUtils.getReportDelayCheckDB();
    clickTimeMap = new HashMap();
    showTimeMap = new HashMap();
    appPauseTimeMap = new HashMap();
    jsErrorSet = new HashSet();
    x5EnableSet = new HashSet();
    hasPkgSet = new HashSet();
    needCheckReportForeground = true;
  }
  
  private static void checkReportDataFromDB()
  {
    ThreadManagerV2.excute(new MiniAppReportManager.5(), 32, null, true);
  }
  
  public static void clearAppPauseTime(MiniAppConfig paramMiniAppConfig)
  {
    appPauseTimeMap.remove(MiniProgramReportHelper.getLaunchIdFromMainProcess(paramMiniAppConfig));
  }
  
  private static void clearDuration(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    ThreadManagerV2.excute(new MiniAppReportManager.10(paramMiniAppConfig, paramString), 16, null, false);
  }
  
  private static void deleteReportDcDataFromDB(MiniAppReportEntity paramMiniAppReportEntity)
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (!(localObject instanceof QQAppInterface))
    {
      QLog.e("MiniAppReportManager", 1, "deleteMiniAppFromDB, app is null.");
      return;
    }
    try
    {
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      if ((localObject != null) && (paramMiniAppReportEntity != null))
      {
        ((EntityManager)localObject).remove(paramMiniAppReportEntity);
        return;
      }
    }
    catch (Throwable paramMiniAppReportEntity)
    {
      QLog.e("MiniAppReportManager", 1, "deleteReportDcDataFromDB exception", paramMiniAppReportEntity);
    }
  }
  
  private static String getAppId(MiniAppConfig paramMiniAppConfig)
  {
    String str1;
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null)) {
      str1 = paramMiniAppConfig.launchParam.miniAppId;
    } else {
      str1 = null;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
    {
      str2 = str1;
      if (paramMiniAppConfig != null)
      {
        str2 = str1;
        if (paramMiniAppConfig.config != null) {
          str2 = paramMiniAppConfig.config.appId;
        }
      }
    }
    return str2;
  }
  
  private static String getDurationAndDelete(MiniAppConfig paramMiniAppConfig)
  {
    paramMiniAppConfig = MiniProgramReportHelper.getLaunchIdFromMainProcess(paramMiniAppConfig);
    if ((paramMiniAppConfig != null) && (showTimeMap.containsKey(paramMiniAppConfig)))
    {
      long l = ((Long)showTimeMap.get(paramMiniAppConfig)).longValue();
      showTimeMap.remove(paramMiniAppConfig);
      l = System.currentTimeMillis() - l;
      if (l > 0L) {
        return String.valueOf(l);
      }
    }
    return "0";
  }
  
  private static String getDurationKey(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_duration");
    return localStringBuilder.toString();
  }
  
  private static SharedPreferences getDurationSp(long paramLong, String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  private static String getPatientDurationAndDelete(MiniAppConfig paramMiniAppConfig)
  {
    paramMiniAppConfig = MiniProgramReportHelper.getLaunchIdFromMainProcess(paramMiniAppConfig);
    if ((paramMiniAppConfig != null) && (clickTimeMap.containsKey(paramMiniAppConfig)))
    {
      long l = ((Long)clickTimeMap.get(paramMiniAppConfig)).longValue();
      clickTimeMap.remove(paramMiniAppConfig);
      l = System.currentTimeMillis() - l;
      if (l > 0L) {
        return String.valueOf(l);
      }
    }
    return "0";
  }
  
  private static String getSaveDuration(MiniAppReportEntity paramMiniAppReportEntity)
  {
    Object localObject3 = null;
    String str1 = null;
    Object localObject4 = null;
    Object localObject2 = str1;
    if (paramMiniAppReportEntity != null)
    {
      Object localObject1 = localObject3;
      try
      {
        long l = CommonDataAdapter.a().c();
        localObject1 = localObject3;
        String str2 = paramMiniAppReportEntity.appId;
        localObject1 = localObject3;
        localObject2 = str1;
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = localObject3;
          localObject2 = getDurationSp(l, str2);
          localObject1 = localObject3;
          str1 = getDurationKey(l, paramMiniAppReportEntity.launchId);
          localObject1 = localObject3;
          l = ((SharedPreferences)localObject2).getLong(str1, 0L);
          paramMiniAppReportEntity = localObject4;
          if (l > 0L)
          {
            localObject1 = localObject3;
            paramMiniAppReportEntity = String.valueOf(l);
          }
          localObject1 = paramMiniAppReportEntity;
          localObject2 = paramMiniAppReportEntity;
          if (QLog.isColorLevel())
          {
            localObject1 = paramMiniAppReportEntity;
            localObject2 = new StringBuilder();
            localObject1 = paramMiniAppReportEntity;
            ((StringBuilder)localObject2).append("getSaveDuration ");
            localObject1 = paramMiniAppReportEntity;
            ((StringBuilder)localObject2).append(paramMiniAppReportEntity);
            localObject1 = paramMiniAppReportEntity;
            ((StringBuilder)localObject2).append(" key=");
            localObject1 = paramMiniAppReportEntity;
            ((StringBuilder)localObject2).append(str1);
            localObject1 = paramMiniAppReportEntity;
            QLog.i("MiniAppReportManager", 2, ((StringBuilder)localObject2).toString());
            return paramMiniAppReportEntity;
          }
        }
      }
      catch (Throwable paramMiniAppReportEntity)
      {
        QLog.e("MiniAppReportManager", 1, "getSaveDuration exception ", paramMiniAppReportEntity);
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  private static long getTimeFromClickToHide(String paramString)
  {
    if ((paramString != null) && (clickTimeMap.containsKey(paramString)) && (appPauseTimeMap.containsKey(paramString)))
    {
      long l = ((Long)clickTimeMap.get(paramString)).longValue();
      l = ((Long)appPauseTimeMap.get(paramString)).longValue() - l;
      if (l < 0L) {
        return 9999999L;
      }
      return l;
    }
    return 9999999L;
  }
  
  private static String getTimeOutCode(long paramLong)
  {
    if (paramLong < 0L) {
      return "timeout";
    }
    if (paramLong < 10000L)
    {
      paramLong /= 1000L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeout_");
      localStringBuilder.append(paramLong);
      return localStringBuilder.toString();
    }
    if (paramLong < 15000L) {
      return "timeout_15";
    }
    if (paramLong < 20000L) {
      return "timeout_20";
    }
    return "timeout";
  }
  
  private static String getX5AndPkgCode(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = "";
    if (paramBoolean1) {
      str1 = "hasX5";
    } else {
      str1 = "";
    }
    localStringBuilder.append(str1);
    String str1 = str2;
    if (paramBoolean2) {
      str1 = "_hasPkg";
    }
    localStringBuilder.append(str1);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static void insertReportDcDataToDB(List<MiniAppReportEntity> paramList)
  {
    // Byte code:
    //   0: invokestatic 210	com/tencent/mobileqq/mini/entry/MiniAppUtils:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull +168 -> 173
    //   8: aload_0
    //   9: invokeinterface 386 1 0
    //   14: ifeq +159 -> 173
    //   17: aload_1
    //   18: instanceof 212
    //   21: ifne +6 -> 27
    //   24: goto +149 -> 173
    //   27: aload_1
    //   28: invokevirtual 226	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   31: invokevirtual 232	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +136 -> 172
    //   39: aload_2
    //   40: invokevirtual 390	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   48: aload_0
    //   49: invokeinterface 399 1 0
    //   54: astore_0
    //   55: aload_0
    //   56: invokeinterface 404 1 0
    //   61: ifeq +67 -> 128
    //   64: aload_0
    //   65: invokeinterface 408 1 0
    //   70: checkcast 333	com/tencent/mobileqq/mini/report/MiniAppReportEntity
    //   73: astore_3
    //   74: aload_2
    //   75: aload_3
    //   76: invokestatic 412	com/tencent/mobileqq/mini/report/MiniAppReportManager:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   79: pop
    //   80: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq -28 -> 55
    //   86: new 295	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   93: astore 4
    //   95: aload 4
    //   97: ldc_w 414
    //   100: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 4
    //   106: aload_3
    //   107: invokevirtual 415	com/tencent/mobileqq/mini/report/MiniAppReportEntity:toString	()Ljava/lang/String;
    //   110: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 45
    //   116: iconst_2
    //   117: aload 4
    //   119: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 354	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: goto -70 -> 55
    //   128: aload_1
    //   129: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   132: aload_1
    //   133: invokevirtual 421	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   136: return
    //   137: astore_0
    //   138: goto +17 -> 155
    //   141: astore_0
    //   142: ldc 45
    //   144: iconst_1
    //   145: ldc_w 423
    //   148: aload_0
    //   149: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: goto -20 -> 132
    //   155: aload_1
    //   156: invokevirtual 421	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   159: aload_0
    //   160: athrow
    //   161: astore_0
    //   162: ldc 45
    //   164: iconst_1
    //   165: ldc_w 425
    //   168: aload_0
    //   169: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: return
    //   173: new 295	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   180: astore_0
    //   181: aload_0
    //   182: ldc_w 427
    //   185: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_0
    //   190: aload_1
    //   191: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 45
    //   197: iconst_1
    //   198: aload_0
    //   199: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramList	List<MiniAppReportEntity>
    //   3	188	1	localObject	Object
    //   34	41	2	localEntityManager	EntityManager
    //   73	34	3	localMiniAppReportEntity	MiniAppReportEntity
    //   93	25	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	55	137	finally
    //   55	125	137	finally
    //   128	132	137	finally
    //   142	152	137	finally
    //   48	55	141	java/lang/Exception
    //   55	125	141	java/lang/Exception
    //   128	132	141	java/lang/Exception
    //   27	35	161	java/lang/Throwable
    //   39	48	161	java/lang/Throwable
    //   132	136	161	java/lang/Throwable
    //   155	161	161	java/lang/Throwable
  }
  
  private static boolean needCheckReportForeground()
  {
    return needCheckReportForeground;
  }
  
  private static boolean needReport(String paramString1, String paramString2)
  {
    boolean bool3 = TextUtils.isEmpty(paramString2);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (miniAppReportEntityHashMap.containsKey(paramString1))
      {
        paramString1 = (MiniAppReportEntity)miniAppReportEntityHashMap.get(paramString1);
        bool1 = bool2;
        if (paramString1 != null) {
          if ((!"load_fail".equals(paramString1.subActionType)) && (!"show_fail".equals(paramString1.subActionType)))
          {
            bool1 = bool2;
            if (!"show".equals(paramString1.subActionType)) {}
          }
          else
          {
            if ((!"load_fail".equals(paramString2)) && (!"show_fail".equals(paramString2))) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public static void onEnterBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppReportManager", 2, "onEnterBackground");
    }
    try
    {
      MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager.6());
      setNeedCheckReportForeground(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppReportManager", 1, "onEnterBackground exception", localThrowable);
    }
  }
  
  public static void onEnterForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppReportManager", 2, "onEnterForeground");
    }
    if (!needCheckReportForeground())
    {
      QLog.e("MiniAppReportManager", 1, "onEnterForeground needCheckReportForground=false");
      return;
    }
    try
    {
      MiniProgramReporter.getInstance().reportImmediatelyLaunchDcData();
      MiniProgramReporter.getInstance().getReportHandler().postDelayed(new MiniAppReportManager.7(), DELAY_CHECK_DB);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppReportManager", 1, "onEnterForeground exception", localThrowable);
    }
  }
  
  private static List<MiniAppReportEntity> queryReportDcDataFromDB()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (!(localObject instanceof QQAppInterface))
    {
      QLog.e("MiniAppReportManager", 1, "queryReportDcDataFromDB, app is null.");
      return null;
    }
    try
    {
      if (((AppInterface)localObject).getAccount() == null) {
        return null;
      }
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      if (localObject != null)
      {
        localObject = ((EntityManager)localObject).query(MiniAppReportEntity.class, MiniAppReportEntity.class.getSimpleName(), false, null, null, null, null, null, null);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppReportManager", 1, "queryReportDcDataFromDB exception", localThrowable);
    }
    return null;
  }
  
  public static void recordDuration(MiniAppConfig paramMiniAppConfig, long paramLong)
  {
    ThreadManagerV2.excute(new MiniAppReportManager.9(paramMiniAppConfig, paramLong), 16, null, false);
  }
  
  public static void recordReportItemToDB(List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      ThreadManagerV2.excute(new MiniAppReportManager.8(paramList), 32, null, true);
    }
  }
  
  public static void registerActivityLifecycleCallbacks()
  {
    if ((Build.VERSION.SDK_INT >= 15) && (lifecycleCallbacks == null))
    {
      lifecycleCallbacks = new MiniAppReportManager.1();
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(lifecycleCallbacks);
    }
  }
  
  private static void report(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, boolean paramBoolean)
  {
    String str1 = paramString7;
    if ("click".equals(paramString5))
    {
      MiniProgramReportHelper.generateLaunchIdInMainProcess(paramMiniAppConfig);
      setClickTime(paramMiniAppConfig);
    }
    String str2;
    if (TextUtils.isEmpty(paramString1)) {
      str2 = MiniProgramReportHelper.getLaunchIdFromMainProcess(paramMiniAppConfig);
    } else {
      str2 = paramString1;
    }
    if ((paramBoolean) && (!x5EnableSet.contains(str2)))
    {
      if (x5EnableSet.size() > 50) {
        x5EnableSet.clear();
      }
      x5EnableSet.add(str2);
    }
    if ((!hasPkgSet.contains(str2)) && (EnvUtils.isPkgDownloaded(paramMiniAppConfig)))
    {
      if (hasPkgSet.size() > 50) {
        hasPkgSet.clear();
      }
      hasPkgSet.add(str2);
    }
    if (!needReport(str2, paramString5))
    {
      paramMiniAppConfig = new StringBuilder();
      paramMiniAppConfig.append("no need report! called with: [subActionType = ");
      paramMiniAppConfig.append(paramString5);
      paramMiniAppConfig.append("], [appType = ");
      paramMiniAppConfig.append(paramString2);
      paramMiniAppConfig.append("], [reserves = ");
      paramMiniAppConfig.append(paramString6);
      paramMiniAppConfig.append("], [reserves2 = ");
      paramMiniAppConfig.append(str1);
      paramMiniAppConfig.append("], [reserves3 = ");
      paramMiniAppConfig.append(paramString8);
      paramMiniAppConfig.append("], [launchid =");
      paramMiniAppConfig.append(str2);
      QLog.e("MiniAppReportManager", 1, paramMiniAppConfig.toString());
      return;
    }
    if ("show".equals(paramString5))
    {
      setShowTime(paramMiniAppConfig);
      recordDuration(paramMiniAppConfig, 1L);
      getPatientDurationAndDelete(paramMiniAppConfig);
      paramBoolean = x5EnableSet.contains(str2);
      bool = hasPkgSet.contains(str2);
      paramString1 = str1;
      if (TextUtils.isEmpty(paramString7)) {
        paramString1 = getX5AndPkgCode(paramBoolean, bool);
      }
      jsErrorSet.remove(str2);
      appPauseTimeMap.remove(str2);
      x5EnableSet.remove(str2);
      hasPkgSet.remove(str2);
      paramString7 = paramString8;
    }
    else
    {
      paramString1 = str1;
      paramString7 = paramString8;
      if ("hide".equals(paramString5))
      {
        paramString1 = getDurationAndDelete(paramMiniAppConfig);
        paramString7 = paramString8;
        if (!"delay_report".equals(str1)) {
          paramString7 = paramString1;
        }
        clearDuration(paramMiniAppConfig, str2);
        paramString1 = str1;
      }
    }
    if ((!"loading_page_kill".equals(paramString6)) && (!"loading_page_back_press".equals(paramString6))) {
      break label519;
    }
    paramString8 = getPatientDurationAndDelete(paramMiniAppConfig);
    paramBoolean = x5EnableSet.contains(str2);
    boolean bool = hasPkgSet.contains(str2);
    paramString7 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString7 = getX5AndPkgCode(paramBoolean, bool);
    }
    jsErrorSet.remove(str2);
    appPauseTimeMap.remove(str2);
    x5EnableSet.remove(str2);
    hasPkgSet.remove(str2);
    paramString1 = paramString7;
    paramString7 = paramString8;
    label519:
    if (QLog.isColorLevel())
    {
      paramString8 = new StringBuilder();
      paramString8.append("report called with: [subActionType = ");
      paramString8.append(paramString5);
      paramString8.append("], [appType = ");
      paramString8.append(paramString2);
      paramString8.append("], [reserves = ");
      paramString8.append(paramString6);
      paramString8.append("], [reserves2 = ");
      paramString8.append(paramString1);
      paramString8.append("], [reserves3 = ");
      paramString8.append(paramString7);
      paramString8.append("], [launchid =");
      paramString8.append(str2);
      QLog.d("MiniAppReportManager", 2, paramString8.toString());
    }
    paramString8 = new ArrayList();
    paramString8.addAll(MiniProgramReportHelper.newUserInfoEntries());
    str1 = AppBrandUtil.getUrlWithoutParams(paramString3);
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null)) {
      paramString3 = String.valueOf(paramMiniAppConfig.launchParam.scene);
    } else {
      paramString3 = null;
    }
    paramString8.addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppConfig, str1, paramString3, paramString4, paramString5, paramString6, paramString1, paramString7, null, null, null, paramString2, str2));
    paramString8.addAll(MiniProgramReportHelper.newGenericEntries());
    paramMiniAppConfig = MiniProgramReportHelper.newSingleReportData(2, paramString8, null);
    MiniProgramReporter.getInstance().addDcData(paramMiniAppConfig);
    updateReportMap(str2, paramMiniAppConfig);
  }
  
  public static void reportClickDc04239(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager.4(paramMiniAppConfig, paramString1, paramString2, paramString3, paramString4));
  }
  
  private static void reportPageViewToDc04239(MiniAppReportEntity paramMiniAppReportEntity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramMiniAppReportEntity == null)
    {
      paramMiniAppReportEntity = new StringBuilder();
      paramMiniAppReportEntity.append("reportPageViewToDc04239 fail, called with: [subActionType = ");
      paramMiniAppReportEntity.append(paramString1);
      paramMiniAppReportEntity.append("], [reserves = ");
      paramMiniAppReportEntity.append(paramString2);
      paramMiniAppReportEntity.append("], [reserves2 = ");
      paramMiniAppReportEntity.append(paramString3);
      QLog.e("MiniAppReportManager", 1, paramMiniAppReportEntity.toString());
      return;
    }
    Object localObject = new MiniAppInfo();
    ((MiniAppInfo)localObject).appId = paramMiniAppReportEntity.appId;
    try
    {
      ((MiniAppInfo)localObject).verType = Integer.valueOf(paramMiniAppReportEntity.verType).intValue();
      ((MiniAppInfo)localObject).setReportType(Integer.valueOf(paramMiniAppReportEntity.appType).intValue());
      label113:
      localObject = new MiniAppConfig((MiniAppInfo)localObject);
      MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager.3((MiniAppConfig)localObject, paramMiniAppReportEntity, paramString1, paramString2, paramString3, paramString4));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label113;
    }
  }
  
  public static void reportToDc04239(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager.2(paramMiniAppConfig, paramString5, paramString1, paramString2, paramString3, paramString4, paramBoolean));
  }
  
  public static void setAppPauseTime(MiniAppConfig paramMiniAppConfig)
  {
    if (appPauseTimeMap.size() > 50) {
      appPauseTimeMap.clear();
    }
    appPauseTimeMap.put(MiniProgramReportHelper.getLaunchIdFromMainProcess(paramMiniAppConfig), Long.valueOf(System.currentTimeMillis()));
  }
  
  private static void setClickTime(MiniAppConfig paramMiniAppConfig)
  {
    if (clickTimeMap.size() > 50) {
      clickTimeMap.clear();
    }
    clickTimeMap.put(MiniProgramReportHelper.getLaunchIdFromMainProcess(paramMiniAppConfig), Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void setJsError(MiniAppConfig paramMiniAppConfig)
  {
    if (jsErrorSet.size() > 50) {
      jsErrorSet.clear();
    }
    jsErrorSet.add(MiniProgramReportHelper.getLaunchIdFromMainProcess(paramMiniAppConfig));
  }
  
  private static void setNeedCheckReportForeground(boolean paramBoolean)
  {
    needCheckReportForeground = paramBoolean;
  }
  
  private static void setShowTime(MiniAppConfig paramMiniAppConfig)
  {
    if (showTimeMap.size() > 50) {
      showTimeMap.clear();
    }
    showTimeMap.put(MiniProgramReportHelper.getLaunchIdFromMainProcess(paramMiniAppConfig), Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void splashMiniGameClickReport(SplashMiniGameData paramSplashMiniGameData)
  {
    MiniAppInfo localMiniAppInfo;
    if (paramSplashMiniGameData != null)
    {
      localMiniAppInfo = new MiniAppInfo();
      localMiniAppInfo.appId = paramSplashMiniGameData.appId;
    }
    try
    {
      localMiniAppInfo.verType = Integer.valueOf(paramSplashMiniGameData.version).intValue();
      localMiniAppInfo.setReportType(Integer.valueOf("1").intValue());
      label47:
      reportClickDc04239(new MiniAppConfig(localMiniAppInfo), "1", null, "click", null, false);
      return;
    }
    catch (NumberFormatException paramSplashMiniGameData)
    {
      break label47;
    }
  }
  
  private static boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool2 = paramEntityManager.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
      }
      else if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002))
      {
        bool1 = paramEntityManager.update(paramEntity);
      }
      paramEntityManager.close();
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      paramEntityManager = new StringBuilder();
      paramEntityManager.append("updateEntity em closed e=");
      paramEntityManager.append(paramEntity.getTableName());
      QLog.d("MiniAppReportManager", 2, paramEntityManager.toString());
    }
    return false;
  }
  
  private static void updateReportMap(String paramString, APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    if (miniAppReportEntityHashMap.size() > 50) {
      miniAppReportEntityHashMap.clear();
    }
    MiniAppReportEntity localMiniAppReportEntity;
    if (miniAppReportEntityHashMap.containsKey(paramString)) {
      localMiniAppReportEntity = (MiniAppReportEntity)miniAppReportEntityHashMap.get(paramString);
    } else {
      localMiniAppReportEntity = new MiniAppReportEntity();
    }
    int i = 0;
    Iterator localIterator = paramSingleDcData.report_data.get().iterator();
    Object localObject3 = "";
    Object localObject2 = "";
    Object localObject1 = localObject2;
    Object localObject4 = localObject1;
    paramSingleDcData = paramString;
    Object localObject5 = localObject1;
    paramString = (String)localObject2;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    for (;;)
    {
      localObject6 = localObject3;
      localObject7 = paramString;
      localObject8 = paramSingleDcData;
      if (!localIterator.hasNext()) {
        break;
      }
      COMM.Entry localEntry = (COMM.Entry)localIterator.next();
      localObject1 = paramSingleDcData;
      if ("launchid".equals(localEntry.key.get())) {
        localObject1 = localEntry.value.get();
      }
      localObject2 = localObject3;
      if ("appid".equals(localEntry.key.get())) {
        localObject2 = localEntry.value.get();
      }
      int j = i;
      localObject6 = paramString;
      if ("sub_actiontype".equals(localEntry.key.get()))
      {
        paramString = localEntry.value.get();
        if ((!"click".equals(paramString)) && (!"load".equals(paramString)) && (!"show".equals(paramString)) && (!"load_fail".equals(paramString)))
        {
          localObject6 = localObject2;
          localObject7 = paramString;
          localObject8 = localObject1;
          if (!"show_fail".equals(paramString)) {
            break;
          }
        }
        j = 1;
        localObject6 = paramString;
      }
      localObject7 = localObject5;
      if ("app_type".equals(localEntry.key.get())) {
        localObject7 = localEntry.value.get();
      }
      i = j;
      localObject3 = localObject2;
      paramString = (String)localObject6;
      localObject5 = localObject7;
      paramSingleDcData = (APP_REPORT_TRANSFER.SingleDcData)localObject1;
      if ("app_status".equals(localEntry.key.get()))
      {
        localObject4 = localEntry.value.get();
        i = j;
        localObject3 = localObject2;
        paramString = (String)localObject6;
        localObject5 = localObject7;
        paramSingleDcData = (APP_REPORT_TRANSFER.SingleDcData)localObject1;
      }
    }
    if ((localMiniAppReportEntity != null) && (i != 0))
    {
      localMiniAppReportEntity.appId = ((String)localObject6);
      localMiniAppReportEntity.appType = localObject5;
      localMiniAppReportEntity.launchId = ((String)localObject8);
      localMiniAppReportEntity.subActionType = ((String)localObject7);
      localMiniAppReportEntity.verType = ((String)localObject4);
      miniAppReportEntityHashMap.put(localObject8, localMiniAppReportEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager
 * JD-Core Version:    0.7.0.1
 */