package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import awbv;
import awbw;
import awbx;
import bexd;
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
    if (!(localObject instanceof QQAppInterface)) {
      QLog.e("MiniAppReportManager", 1, "deleteMiniAppFromDB, app is null.");
    }
    for (;;)
    {
      return;
      try
      {
        localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
        if ((localObject != null) && (paramMiniAppReportEntity != null))
        {
          ((awbw)localObject).b(paramMiniAppReportEntity);
          return;
        }
      }
      catch (Throwable paramMiniAppReportEntity)
      {
        QLog.e("MiniAppReportManager", 1, "deleteReportDcDataFromDB exception", paramMiniAppReportEntity);
      }
    }
  }
  
  private static String getAppId(MiniAppConfig paramMiniAppConfig)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMiniAppConfig != null)
    {
      localObject1 = localObject2;
      if (paramMiniAppConfig.launchParam != null) {
        localObject1 = paramMiniAppConfig.launchParam.miniAppId;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (paramMiniAppConfig != null)
      {
        localObject2 = localObject1;
        if (paramMiniAppConfig.config != null) {
          localObject2 = paramMiniAppConfig.config.appId;
        }
      }
    }
    return localObject2;
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
    return paramLong + "_" + paramString + "_duration";
  }
  
  private static SharedPreferences getDurationSp(long paramLong, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramLong + "_" + paramString, 0);
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
    String str1 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2 = str1;
    Object localObject1;
    if (paramMiniAppReportEntity != null) {
      localObject1 = localObject3;
    }
    try
    {
      long l = bexd.a().a();
      localObject1 = localObject3;
      String str2 = paramMiniAppReportEntity.appId;
      localObject2 = str1;
      localObject1 = localObject3;
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
        localObject2 = paramMiniAppReportEntity;
        localObject1 = paramMiniAppReportEntity;
        if (QLog.isColorLevel())
        {
          localObject1 = paramMiniAppReportEntity;
          QLog.i("MiniAppReportManager", 2, "getSaveDuration " + paramMiniAppReportEntity + " key=" + str1);
          localObject2 = paramMiniAppReportEntity;
        }
      }
      return localObject2;
    }
    catch (Throwable paramMiniAppReportEntity)
    {
      QLog.e("MiniAppReportManager", 1, "getSaveDuration exception ", paramMiniAppReportEntity);
    }
    return localObject1;
  }
  
  private static long getTimeFromClickToHide(String paramString)
  {
    if ((paramString != null) && (clickTimeMap.containsKey(paramString)) && (appPauseTimeMap.containsKey(paramString)))
    {
      long l1 = ((Long)clickTimeMap.get(paramString)).longValue();
      long l2 = ((Long)appPauseTimeMap.get(paramString)).longValue() - l1;
      l1 = l2;
      if (l2 < 0L) {
        l1 = 9999999L;
      }
      return l1;
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
      return "timeout_" + paramLong;
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
    if (paramBoolean1)
    {
      str = "hasX5";
      localStringBuilder = localStringBuilder.append(str);
      if (!paramBoolean2) {
        break label46;
      }
    }
    label46:
    for (String str = "_hasPkg";; str = "")
    {
      return str;
      str = "";
      break;
    }
  }
  
  /* Error */
  private static void insertReportDcDataToDB(List<MiniAppReportEntity> paramList)
  {
    // Byte code:
    //   0: invokestatic 210	com/tencent/mobileqq/mini/entry/MiniAppUtils:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull +19 -> 24
    //   8: aload_0
    //   9: invokeinterface 386 1 0
    //   14: ifeq +10 -> 24
    //   17: aload_1
    //   18: instanceof 212
    //   21: ifne +30 -> 51
    //   24: ldc 45
    //   26: iconst_1
    //   27: new 296	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 388
    //   37: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: return
    //   51: aload_1
    //   52: invokevirtual 226	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lawbx;
    //   55: invokevirtual 232	awbx:createEntityManager	()Lawbw;
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull -10 -> 50
    //   63: aload_2
    //   64: invokevirtual 394	awbw:a	()Lawby;
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 398	awby:a	()V
    //   72: aload_0
    //   73: invokeinterface 402 1 0
    //   78: astore_0
    //   79: aload_0
    //   80: invokeinterface 407 1 0
    //   85: ifeq +85 -> 170
    //   88: aload_0
    //   89: invokeinterface 411 1 0
    //   94: checkcast 333	com/tencent/mobileqq/mini/report/MiniAppReportEntity
    //   97: astore_3
    //   98: aload_2
    //   99: aload_3
    //   100: invokestatic 415	com/tencent/mobileqq/mini/report/MiniAppReportManager:updateEntity	(Lawbw;Lawbv;)Z
    //   103: pop
    //   104: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -28 -> 79
    //   110: ldc 45
    //   112: iconst_2
    //   113: new 296	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 417
    //   123: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_3
    //   127: invokevirtual 418	com/tencent/mobileqq/mini/report/MiniAppReportEntity:toString	()Ljava/lang/String;
    //   130: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 354	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: goto -60 -> 79
    //   142: astore_0
    //   143: ldc 45
    //   145: iconst_1
    //   146: ldc_w 420
    //   149: aload_0
    //   150: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_1
    //   154: invokevirtual 422	awby:b	()V
    //   157: return
    //   158: astore_0
    //   159: ldc 45
    //   161: iconst_1
    //   162: ldc_w 424
    //   165: aload_0
    //   166: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   169: return
    //   170: aload_1
    //   171: invokevirtual 427	awby:c	()V
    //   174: aload_1
    //   175: invokevirtual 422	awby:b	()V
    //   178: return
    //   179: astore_0
    //   180: aload_1
    //   181: invokevirtual 422	awby:b	()V
    //   184: aload_0
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramList	List<MiniAppReportEntity>
    //   3	178	1	localObject	Object
    //   58	41	2	localawbw	awbw
    //   97	30	3	localMiniAppReportEntity	MiniAppReportEntity
    // Exception table:
    //   from	to	target	type
    //   72	79	142	java/lang/Exception
    //   79	139	142	java/lang/Exception
    //   170	174	142	java/lang/Exception
    //   51	59	158	java/lang/Throwable
    //   63	72	158	java/lang/Throwable
    //   153	157	158	java/lang/Throwable
    //   174	178	158	java/lang/Throwable
    //   180	186	158	java/lang/Throwable
    //   72	79	179	finally
    //   79	139	179	finally
    //   143	153	179	finally
    //   170	174	179	finally
  }
  
  private static boolean needCheckReportForeground()
  {
    return needCheckReportForeground;
  }
  
  private static boolean needReport(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (miniAppReportEntityHashMap.containsKey(paramString1)))
    {
      paramString1 = (MiniAppReportEntity)miniAppReportEntityHashMap.get(paramString1);
      if ((paramString1 != null) && (("load_fail".equals(paramString1.subActionType)) || ("show_fail".equals(paramString1.subActionType)) || ("show".equals(paramString1.subActionType)))) {
        return (!"load_fail".equals(paramString2)) && (!"show_fail".equals(paramString2));
      }
    }
    return true;
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
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (!(localObject1 instanceof QQAppInterface)) {
      QLog.e("MiniAppReportManager", 1, "queryReportDcDataFromDB, app is null.");
    }
    for (;;)
    {
      return null;
      try
      {
        if (((AppInterface)localObject1).getAccount() != null)
        {
          localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
          if (localObject1 == null) {
            break label75;
          }
          localObject1 = ((awbw)localObject1).a(MiniAppReportEntity.class, MiniAppReportEntity.class.getSimpleName(), false, null, null, null, null, null, null);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("MiniAppReportManager", 1, "queryReportDcDataFromDB exception", localThrowable);
          Object localObject2 = null;
        }
      }
    }
    return localObject1;
  }
  
  public static void recordDuration(MiniAppConfig paramMiniAppConfig, long paramLong)
  {
    ThreadManagerV2.excute(new MiniAppReportManager.9(paramMiniAppConfig, paramLong), 16, null, false);
  }
  
  public static void recordReportItemToDB(List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ThreadManagerV2.excute(new MiniAppReportManager.8(paramList), 32, null, true);
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
    if ("click".equals(paramString5))
    {
      MiniProgramReportHelper.generateLaunchIdInMainProcess(paramMiniAppConfig);
      setClickTime(paramMiniAppConfig);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    for (String str2 = MiniProgramReportHelper.getLaunchIdFromMainProcess(paramMiniAppConfig);; str2 = paramString1)
    {
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
      if (needReport(str2, paramString5)) {
        break;
      }
      QLog.e("MiniAppReportManager", 1, "no need report! called with: [subActionType = " + paramString5 + "], [appType = " + paramString2 + "], [reserves = " + paramString6 + "], [reserves2 = " + paramString7 + "], [reserves3 = " + paramString8 + "], [launchid =" + str2);
      return;
    }
    String str1;
    if ("show".equals(paramString5))
    {
      setShowTime(paramMiniAppConfig);
      recordDuration(paramMiniAppConfig, 1L);
      getPatientDurationAndDelete(paramMiniAppConfig);
      paramBoolean = x5EnableSet.contains(str2);
      boolean bool = hasPkgSet.contains(str2);
      paramString1 = paramString7;
      if (TextUtils.isEmpty(paramString7)) {
        paramString1 = getX5AndPkgCode(paramBoolean, bool);
      }
      jsErrorSet.remove(str2);
      appPauseTimeMap.remove(str2);
      x5EnableSet.remove(str2);
      hasPkgSet.remove(str2);
      str1 = paramString8;
      if ((!"loading_page_kill".equals(paramString6)) && (!"loading_page_back_press".equals(paramString6))) {
        break label685;
      }
      paramString8 = getPatientDurationAndDelete(paramMiniAppConfig);
      paramBoolean = x5EnableSet.contains(str2);
      bool = hasPkgSet.contains(str2);
      paramString7 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramString7 = getX5AndPkgCode(paramBoolean, bool);
      }
      jsErrorSet.remove(str2);
      appPauseTimeMap.remove(str2);
      x5EnableSet.remove(str2);
      hasPkgSet.remove(str2);
      paramString1 = paramString7;
    }
    label685:
    for (paramString7 = paramString8;; paramString7 = str1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppReportManager", 2, "report called with: [subActionType = " + paramString5 + "], [appType = " + paramString2 + "], [reserves = " + paramString6 + "], [reserves2 = " + paramString1 + "], [reserves3 = " + paramString7 + "], [launchid =" + str2);
      }
      paramString8 = new ArrayList();
      paramString8.addAll(MiniProgramReportHelper.newUserInfoEntries());
      str1 = AppBrandUtil.getUrlWithoutParams(paramString3);
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null)) {}
      for (paramString3 = String.valueOf(paramMiniAppConfig.launchParam.scene);; paramString3 = null)
      {
        paramString8.addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppConfig, str1, paramString3, paramString4, paramString5, paramString6, paramString1, paramString7, null, null, null, paramString2, str2));
        paramString8.addAll(MiniProgramReportHelper.newGenericEntries());
        paramMiniAppConfig = MiniProgramReportHelper.newSingleReportData(2, paramString8, null);
        MiniProgramReporter.getInstance().addDcData(paramMiniAppConfig);
        updateReportMap(str2, paramMiniAppConfig);
        return;
        paramString1 = paramString7;
        str1 = paramString8;
        if (!"hide".equals(paramString5)) {
          break;
        }
        paramString1 = getDurationAndDelete(paramMiniAppConfig);
        if (!"delay_report".equals(paramString7)) {
          paramString8 = paramString1;
        }
        clearDuration(paramMiniAppConfig, str2);
        paramString1 = paramString7;
        str1 = paramString8;
        break;
      }
    }
  }
  
  public static void reportClickDc04239(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager.4(paramMiniAppConfig, paramString1, paramString2, paramString3, paramString4));
  }
  
  private static void reportPageViewToDc04239(MiniAppReportEntity paramMiniAppReportEntity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramMiniAppReportEntity == null)
    {
      QLog.e("MiniAppReportManager", 1, "reportPageViewToDc04239 fail, called with: [subActionType = " + paramString1 + "], [reserves = " + paramString2 + "], [reserves2 = " + paramString3);
      return;
    }
    Object localObject = new MiniAppInfo();
    ((MiniAppInfo)localObject).appId = paramMiniAppReportEntity.appId;
    try
    {
      ((MiniAppInfo)localObject).verType = Integer.valueOf(paramMiniAppReportEntity.verType).intValue();
      ((MiniAppInfo)localObject).setReportType(Integer.valueOf(paramMiniAppReportEntity.appType).intValue());
      label99:
      localObject = new MiniAppConfig((MiniAppInfo)localObject);
      MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager.3((MiniAppConfig)localObject, paramMiniAppReportEntity, paramString1, paramString2, paramString3, paramString4));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label99;
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
  
  private static boolean updateEntity(awbw paramawbw, awbv paramawbv)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramawbw.a()) {
      if (paramawbv.getStatus() == 1000)
      {
        paramawbw.b(paramawbv);
        if (paramawbv.getStatus() == 1001) {
          bool1 = true;
        }
        paramawbw.a();
      }
    }
    do
    {
      return bool1;
      if ((paramawbv.getStatus() != 1001) && (paramawbv.getStatus() != 1002)) {
        break;
      }
      bool1 = paramawbw.a(paramawbv);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("MiniAppReportManager", 2, "updateEntity em closed e=" + paramawbv.getTableName());
    return false;
  }
  
  private static void updateReportMap(String paramString, APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    if (miniAppReportEntityHashMap.size() > 50) {
      miniAppReportEntityHashMap.clear();
    }
    MiniAppReportEntity localMiniAppReportEntity;
    Object localObject;
    String str3;
    int i;
    label78:
    String str4;
    String str5;
    int j;
    if (miniAppReportEntityHashMap.containsKey(paramString))
    {
      localMiniAppReportEntity = (MiniAppReportEntity)miniAppReportEntityHashMap.get(paramString);
      localObject = "";
      Iterator localIterator = paramSingleDcData.report_data.get().iterator();
      String str1 = "";
      String str2 = "";
      str3 = "";
      i = 0;
      paramSingleDcData = (APP_REPORT_TRANSFER.SingleDcData)localObject;
      localObject = str2;
      str4 = str1;
      str5 = paramString;
      if (!localIterator.hasNext()) {
        break label330;
      }
      COMM.Entry localEntry = (COMM.Entry)localIterator.next();
      if ("launchid".equals(localEntry.key.get())) {
        paramString = localEntry.value.get();
      }
      if ("appid".equals(localEntry.key.get())) {
        str1 = localEntry.value.get();
      }
      j = i;
      if ("sub_actiontype".equals(localEntry.key.get()))
      {
        str2 = localEntry.value.get();
        if ((!"click".equals(str2)) && (!"load".equals(str2)) && (!"show".equals(str2)) && (!"load_fail".equals(str2)))
        {
          localObject = str2;
          str4 = str1;
          str5 = paramString;
          if (!"show_fail".equals(str2)) {
            break label330;
          }
        }
        j = 1;
      }
      if ("app_type".equals(localEntry.key.get())) {
        str3 = localEntry.value.get();
      }
      if (!"app_status".equals(localEntry.key.get())) {
        break label385;
      }
      paramSingleDcData = localEntry.value.get();
    }
    label385:
    for (;;)
    {
      i = j;
      break label78;
      localMiniAppReportEntity = new MiniAppReportEntity();
      break;
      label330:
      if ((localMiniAppReportEntity != null) && (i != 0))
      {
        localMiniAppReportEntity.appId = str4;
        localMiniAppReportEntity.appType = str3;
        localMiniAppReportEntity.launchId = str5;
        localMiniAppReportEntity.subActionType = ((String)localObject);
        localMiniAppReportEntity.verType = paramSingleDcData;
        miniAppReportEntityHashMap.put(str5, localMiniAppReportEntity);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager
 * JD-Core Version:    0.7.0.1
 */