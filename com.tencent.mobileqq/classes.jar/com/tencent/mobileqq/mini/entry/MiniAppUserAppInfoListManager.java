package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import alpg;
import amru;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import aoom;
import awge;
import awgf;
import awgg;
import awgh;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class MiniAppUserAppInfoListManager
  implements Manager
{
  private static final String TAG = "MiniAppUserAppInfoListManager";
  public Runnable initLocalDataRunnable = new MiniAppUserAppInfoListManager.5(this);
  private LinkedList<MiniAppInfo> mDbCacheAppList = new LinkedList();
  private COMM.StCommonExt mDelExtInfo;
  private volatile COMM.StCommonExt mExtInfo;
  private ConcurrentHashMap<String, Integer> mPublicAccountRedDotMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> mPushRedDotMap = new ConcurrentHashMap();
  private LinkedList<MiniAppInfo> mTopAppList = new LinkedList();
  private COMM.StCommonExt mTopExtInfo;
  private LinkedList<MiniAppInfo> mUsedAppList = new LinkedList();
  private alpg redDotObserver = new MiniAppUserAppInfoListManager.1(this);
  
  public MiniAppUserAppInfoListManager(QQAppInterface paramQQAppInterface)
  {
    QLog.d("MiniAppUserAppInfoListManager", 1, "MiniAppUserAppInfoListManager init.");
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "oldEntryCloseRedDot", 0) == 0) {}
    for (;;)
    {
      if (i != 0)
      {
        paramQQAppInterface = MiniAppUtils.getAppInterface();
        if (paramQQAppInterface != null) {
          paramQQAppInterface.addObserver(this.redDotObserver);
        }
      }
      return;
      i = 0;
    }
  }
  
  private void clearNoticeRedDotData()
  {
    this.mPublicAccountRedDotMap.clear();
    Object localObject1 = new ArrayList();
    for (;;)
    {
      try
      {
        ((List)localObject1).addAll(this.mTopAppList);
        ((List)localObject1).addAll(this.mUsedAppList);
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        MiniAppInfo localMiniAppInfo = (MiniAppInfo)((Iterator)localObject1).next();
        if ((localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId)))
        {
          Integer localInteger = (Integer)this.mPushRedDotMap.get(localMiniAppInfo.appId);
          if ((localInteger != null) && (localInteger.intValue() > 0)) {
            updateRedDotData(new MiniAppRedDotEntity(localMiniAppInfo.appId, 0, localInteger.intValue()));
          } else {
            deleteRedDotDataFromDB(localMiniAppInfo.appId);
          }
        }
      }
      finally {}
    }
  }
  
  private void compareServerAndDbDataAsync(AppInterface paramAppInterface, List<MiniAppInfo> paramList)
  {
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager().a(MiniAppEntity.class, MiniAppEntity.class.getSimpleName(), false, null, null, null, null, null, null);
    if ((paramList == null) || (paramList.size() == 0) || (paramAppInterface == null) || (paramAppInterface.size() == 0)) {
      return;
    }
    paramAppInterface = paramAppInterface.iterator();
    label59:
    label204:
    for (;;)
    {
      Object localObject;
      if (paramAppInterface.hasNext())
      {
        localObject = (MiniAppEntity)paramAppInterface.next();
        if ((localObject != null) && (((MiniAppEntity)localObject).appInfo != null))
        {
          localObject = ((MiniAppEntity)localObject).createFromBuffer(((MiniAppEntity)localObject).appInfo);
          Iterator localIterator = paramList.iterator();
          MiniAppInfo localMiniAppInfo;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localMiniAppInfo = (MiniAppInfo)localIterator.next();
          } while ((localObject == null) || (((MiniAppInfo)localObject).appId == null) || (localMiniAppInfo == null) || (!((MiniAppInfo)localObject).appId.equals(localMiniAppInfo.appId)) || (((MiniAppInfo)localObject).verType != localMiniAppInfo.verType));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if ((i != 0) || (localObject == null)) {
            break label204;
          }
          deleteMiniAppFromDB((MiniAppInfo)localObject);
          break label59;
          break;
        }
      }
    }
  }
  
  private void deleteDB(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "clear DB, app is null.");
    }
    awgf localawgf;
    do
    {
      return;
      localawgf = paramAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localawgf == null);
    paramAppInterface = localawgf.a();
    try
    {
      paramAppInterface.a();
      localawgf.b(" DELETE FROM MiniAppEntity ");
      localawgf.b("delete from sqlite_sequence where name='MiniAppEntity'");
      localawgf.b("update sqlite_sequence SET seq = 0 where name = 'MiniAppEntity'");
      paramAppInterface.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        paramAppInterface.b();
      }
    }
    finally
    {
      paramAppInterface.b();
    }
    QLog.i("MiniAppUserAppInfoListManager", 2, "clear mini app List DB");
  }
  
  private void deleteMiniAppFromDB(MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      if (this.mUsedAppList.contains(paramMiniAppInfo)) {
        this.mUsedAppList.remove(paramMiniAppInfo);
      }
      if (this.mTopAppList.contains(paramMiniAppInfo)) {
        this.mTopAppList.remove(paramMiniAppInfo);
      }
      ThreadManager.excute(new MiniAppUserAppInfoListManager.10(this, paramMiniAppInfo), 32, null, true);
      return;
    }
    finally {}
  }
  
  private void deleteRedDotDataFromDB(String paramString)
  {
    ThreadManager.excute(new MiniAppUserAppInfoListManager.14(this, paramString), 32, null, true);
  }
  
  private void handleGetUserAppListData(INTERFACE.StGetUserAppListRsp paramStGetUserAppListRsp)
  {
    Object localObject2;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    StringBuilder localStringBuilder;
    Object localObject3;
    if (paramStGetUserAppListRsp != null)
    {
      Object localObject1 = paramStGetUserAppListRsp.userAppList.get();
      localObject2 = paramStGetUserAppListRsp.fixApps.get();
      if ((localObject1 == null) && (localObject2 == null))
      {
        QLog.e("MiniAppUserAppInfoListManager", 1, "handleGetUserAppListData, userAppInfoList = " + localObject1 + ", fixApps = " + localObject2);
        return;
      }
      if ((localObject1 != null) && (localObject2 != null) && (((List)localObject1).size() == 0) && (((List)localObject2).size() == 0))
      {
        removeAllMiniAppInfo();
        QLog.e("MiniAppUserAppInfoListManager", 1, "handleGetUserAppListData, userAppInfoList = " + localObject1 + ", fixApps = " + localObject2);
        return;
      }
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      List localList = getOldRecommendMiniAppList();
      localStringBuilder = new StringBuilder();
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (INTERFACE.StUserAppInfo)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((INTERFACE.StUserAppInfo)localObject3).appInfo != null))
          {
            localObject3 = MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject3);
            localLinkedList1.add(localObject3);
            localStringBuilder.append(((MiniAppInfo)localObject3).name).append("(fixApp), ");
          }
        }
      }
      if (localLinkedList2 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (INTERFACE.StUserAppInfo)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((INTERFACE.StUserAppInfo)localObject2).appInfo != null))
            {
              localObject2 = MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject2);
              if ((!((MiniAppInfo)localObject2).isEngineTypeMiniGame()) || (GameWnsUtils.gameEnable())) {
                if ((((MiniAppInfo)localObject2).recommend == 1) && (localList != null))
                {
                  localObject3 = new RecommendMiniAppEntity(((MiniAppInfo)localObject2).appId, ((MiniAppInfo)localObject2).name, ((MiniAppInfo)localObject2).recommend);
                  Iterator localIterator = localList.iterator();
                  RecommendMiniAppEntity localRecommendMiniAppEntity;
                  do
                  {
                    if (!localIterator.hasNext()) {
                      break;
                    }
                    localRecommendMiniAppEntity = (RecommendMiniAppEntity)localIterator.next();
                  } while ((((MiniAppInfo)localObject2).appId == null) || (!((MiniAppInfo)localObject2).appId.equals(localRecommendMiniAppEntity.appId)));
                }
              }
            }
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        QLog.d("MiniAppUserAppInfoListManager", 2, "handleGetUserAppListData, filter recommend mini app: " + localObject3);
        break;
      }
      if (((MiniAppInfo)localObject2).topType == 0) {
        localLinkedList2.add(localObject2);
      }
      for (;;)
      {
        localStringBuilder.append(((MiniAppInfo)localObject2).name).append(", ");
        break;
        localLinkedList1.add(localObject2);
      }
      this.mExtInfo = paramStGetUserAppListRsp.extInfo;
      if ((localLinkedList2.size() > 0) || (localLinkedList1.size() > 0))
      {
        removeAllMiniAppInfo();
        saveMiniAppInfoList(localLinkedList1, localLinkedList2);
      }
      QLog.d("MiniAppUserAppInfoListManager", 1, "handleGetUserAppListData, app List = " + localStringBuilder.toString());
      return;
      QLog.e("MiniAppUserAppInfoListManager", 2, "handleGetUserAppListData, rsp = null");
      return;
    }
  }
  
  private void insertRecommendMiniAppToDB(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.12(this, paramMiniAppInfo), 32, null, true);
  }
  
  public static void recordMiniAppStart(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)localAppRuntime.getManager(309);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.updateMiniAppStartRecord(paramMiniAppInfo);
    }
    QLog.d("MiniAppUserAppInfoListManager", 1, "recordMiniAppStart, appInfo = " + paramMiniAppInfo + ", appRuntime = " + localAppRuntime + "， manager = " + localMiniAppUserAppInfoListManager);
  }
  
  private void saveDataToDBWithBatch(List<MiniAppInfo> paramList, boolean paramBoolean)
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.11(this, paramBoolean, paramList), 32, null, true);
  }
  
  private void saveToDB(awge paramawge)
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.9(this, paramawge), 32, null, true);
  }
  
  /* Error */
  private void updateAppInfoTopRecord(MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 180	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   8: invokestatic 186	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +30 -> 41
    //   14: ldc 10
    //   16: iconst_1
    //   17: new 331	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 453
    //   27: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: return
    //   41: new 154	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 155	java/util/ArrayList:<init>	()V
    //   48: astore_2
    //   49: ldc 2
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 37	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:mTopAppList	Ljava/util/LinkedList;
    //   56: aload_1
    //   57: invokevirtual 297	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   60: ifeq +12 -> 72
    //   63: aload_0
    //   64: getfield 37	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:mTopAppList	Ljava/util/LinkedList;
    //   67: aload_1
    //   68: invokevirtual 300	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   71: pop
    //   72: aload_0
    //   73: getfield 39	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:mUsedAppList	Ljava/util/LinkedList;
    //   76: aload_1
    //   77: invokevirtual 297	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   80: ifeq +12 -> 92
    //   83: aload_0
    //   84: getfield 39	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:mUsedAppList	Ljava/util/LinkedList;
    //   87: aload_1
    //   88: invokevirtual 300	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: aload_1
    //   93: getfield 391	com/tencent/mobileqq/mini/apkg/MiniAppInfo:topType	I
    //   96: ifne +43 -> 139
    //   99: aload_0
    //   100: getfield 39	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:mUsedAppList	Ljava/util/LinkedList;
    //   103: aload_1
    //   104: invokevirtual 457	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   107: aload_2
    //   108: aload_0
    //   109: getfield 37	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:mTopAppList	Ljava/util/LinkedList;
    //   112: invokeinterface 161 2 0
    //   117: pop
    //   118: aload_2
    //   119: aload_0
    //   120: getfield 39	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:mUsedAppList	Ljava/util/LinkedList;
    //   123: invokeinterface 161 2 0
    //   128: pop
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: aload_2
    //   134: iconst_0
    //   135: invokespecial 459	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:saveDataToDBWithBatch	(Ljava/util/List;Z)V
    //   138: return
    //   139: aload_1
    //   140: getfield 391	com/tencent/mobileqq/mini/apkg/MiniAppInfo:topType	I
    //   143: iconst_1
    //   144: if_icmpne -37 -> 107
    //   147: aload_0
    //   148: getfield 37	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:mTopAppList	Ljava/util/LinkedList;
    //   151: aload_1
    //   152: invokevirtual 457	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   155: goto -48 -> 107
    //   158: astore_1
    //   159: ldc 2
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	MiniAppUserAppInfoListManager
    //   0	164	1	paramMiniAppInfo	MiniAppInfo
    //   48	86	2	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   52	72	158	finally
    //   72	92	158	finally
    //   92	107	158	finally
    //   107	132	158	finally
    //   139	155	158	finally
    //   159	162	158	finally
  }
  
  private boolean updateEntity(awgf paramawgf, awge paramawge)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramawgf.a()) {
      if (paramawge.getStatus() == 1000)
      {
        paramawgf.b(paramawge);
        if (paramawge.getStatus() == 1001) {
          bool1 = true;
        }
        paramawgf.a();
      }
    }
    do
    {
      return bool1;
      if ((paramawge.getStatus() != 1001) && (paramawge.getStatus() != 1002)) {
        break;
      }
      bool1 = paramawgf.a(paramawge);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("MiniAppUserAppInfoListManager", 2, "updateEntity em closed e=" + paramawge.getTableName());
    return false;
  }
  
  private void updateMiniAppStartRecord(MiniAppInfo paramMiniAppInfo)
  {
    int j = 1;
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      QLog.e("MiniAppUserAppInfoListManager", 1, "insertAppInfo error app info is invalid, appInfo = " + paramMiniAppInfo);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (this.mTopAppList.contains(paramMiniAppInfo)) {
        return;
      }
    }
    finally {}
    MiniAppInfo localMiniAppInfo;
    if (this.mUsedAppList.contains(paramMiniAppInfo))
    {
      this.mUsedAppList.remove(paramMiniAppInfo);
      i = 1;
      if (i != 0) {
        break label253;
      }
      localMiniAppInfo = findMiniApp(paramMiniAppInfo.appId, paramMiniAppInfo.verType);
      if (this.mTopAppList.contains(localMiniAppInfo))
      {
        i = this.mTopAppList.indexOf(localMiniAppInfo);
        this.mTopAppList.set(i, paramMiniAppInfo);
      }
    }
    label253:
    for (int i = j;; i = 0)
    {
      if (i == 0)
      {
        i = this.mTopAppList.size();
        while (this.mUsedAppList.size() + i >= 20)
        {
          this.mUsedAppList.removeLast();
          continue;
          if (localMiniAppInfo == null) {
            break label253;
          }
          this.mUsedAppList.remove(localMiniAppInfo);
          break label253;
        }
        this.mUsedAppList.addFirst(paramMiniAppInfo);
      }
      localArrayList.addAll(this.mTopAppList);
      localArrayList.addAll(this.mUsedAppList);
      saveDataToDBWithBatch(localArrayList, false);
      return;
      i = 0;
      break;
    }
  }
  
  private void updateRedDotData(MiniAppRedDotEntity paramMiniAppRedDotEntity)
  {
    if (paramMiniAppRedDotEntity == null) {
      return;
    }
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.13(this, paramMiniAppRedDotEntity), 32, null, true);
  }
  
  private boolean updateRedDotData(awgf paramawgf, awge paramawge)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramawgf.a()) {
      if (paramawge.getStatus() == 1000)
      {
        paramawgf.b(paramawge);
        if (paramawge.getStatus() == 1001) {
          bool1 = true;
        }
        paramawgf.a();
      }
    }
    do
    {
      return bool1;
      if ((paramawge.getStatus() != 1001) && (paramawge.getStatus() != 1002)) {
        break;
      }
      bool1 = paramawgf.a(paramawge);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("MiniAppUserAppInfoListManager", 2, "updateEntity em closed e=" + paramawge.getTableName());
    return false;
  }
  
  public void asyncQueryMiniAppPushRedDotData()
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.6(this), 32, null, true);
  }
  
  public boolean checkAutoShowPullDownEntry()
  {
    for (;;)
    {
      try
      {
        if (this.mTopAppList.size() > 0) {
          break label37;
        }
        if (this.mUsedAppList.size() <= 0) {
          break label42;
        }
      }
      finally {}
      return bool;
      label37:
      boolean bool = true;
      continue;
      label42:
      bool = false;
    }
  }
  
  public MiniAppInfo findMiniApp(String paramString)
  {
    try
    {
      Iterator localIterator = this.mTopAppList.iterator();
      MiniAppInfo localMiniAppInfo;
      while (localIterator.hasNext())
      {
        localMiniAppInfo = (MiniAppInfo)localIterator.next();
        if ((localMiniAppInfo != null) && (paramString.equals(localMiniAppInfo.appId)))
        {
          QLog.d("MiniAppUserAppInfoListManager", 1, "findMiniApp, appInfo = " + localMiniAppInfo);
          return localMiniAppInfo;
        }
      }
      localIterator = this.mUsedAppList.iterator();
      while (localIterator.hasNext())
      {
        localMiniAppInfo = (MiniAppInfo)localIterator.next();
        if ((localMiniAppInfo != null) && (paramString.equals(localMiniAppInfo.appId)))
        {
          QLog.d("MiniAppUserAppInfoListManager", 1, "findMiniApp, appInfo = " + localMiniAppInfo);
          return localMiniAppInfo;
        }
      }
    }
    finally {}
    QLog.d("MiniAppUserAppInfoListManager", 1, "findMiniApp, failed to find Miniapp, appId = " + paramString);
    return null;
  }
  
  public MiniAppInfo findMiniApp(String paramString, int paramInt)
  {
    try
    {
      Iterator localIterator = this.mTopAppList.iterator();
      MiniAppInfo localMiniAppInfo;
      while (localIterator.hasNext())
      {
        localMiniAppInfo = (MiniAppInfo)localIterator.next();
        if ((localMiniAppInfo != null) && (paramString.equals(localMiniAppInfo.appId)) && (paramInt == localMiniAppInfo.verType))
        {
          QLog.d("MiniAppUserAppInfoListManager", 1, "findMiniApp, appInfo = " + localMiniAppInfo);
          return localMiniAppInfo;
        }
      }
      localIterator = this.mUsedAppList.iterator();
      while (localIterator.hasNext())
      {
        localMiniAppInfo = (MiniAppInfo)localIterator.next();
        if ((localMiniAppInfo != null) && (paramString.equals(localMiniAppInfo.appId)) && (paramInt == localMiniAppInfo.verType))
        {
          QLog.d("MiniAppUserAppInfoListManager", 1, "findMiniApp, appInfo = " + localMiniAppInfo);
          return localMiniAppInfo;
        }
      }
    }
    finally {}
    QLog.d("MiniAppUserAppInfoListManager", 1, "findMiniApp, failed to find Miniapp, appId = " + paramString);
    return null;
  }
  
  public MiniAppInfo findTopMiniApp(String paramString)
  {
    try
    {
      Iterator localIterator = this.mTopAppList.iterator();
      while (localIterator.hasNext())
      {
        MiniAppInfo localMiniAppInfo = (MiniAppInfo)localIterator.next();
        if ((localMiniAppInfo != null) && (paramString.equals(localMiniAppInfo.appId)))
        {
          QLog.d("MiniAppUserAppInfoListManager", 1, "findMiniApp, appInfo = " + localMiniAppInfo);
          return localMiniAppInfo;
        }
      }
      QLog.d("MiniAppUserAppInfoListManager", 1, "findMiniApp, failed to find  top Miniapp");
      return null;
    }
    finally {}
  }
  
  public List<MiniAppInfo> getMiniAppInfoData()
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      if (this.mTopAppList.size() > 0) {
        localLinkedList.addAll(this.mTopAppList);
      }
      if (this.mUsedAppList.size() > 0) {
        localLinkedList.addAll(this.mUsedAppList);
      }
      if (localLinkedList.size() <= 0)
      {
        localLinkedList.addAll(this.mDbCacheAppList);
        QLog.e("MiniAppUserAppInfoListManager", 1, "getMiniAppInfoData, user DB cache data. size = " + localLinkedList.size());
      }
      QLog.d("MiniAppUserAppInfoListManager", 2, "getMiniAppInfoData, size = " + localLinkedList.size());
      return localLinkedList;
    }
    finally {}
  }
  
  public List<RecommendMiniAppEntity> getOldRecommendMiniAppList()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "getOldRecommendMiniAppList, app is null.");
    }
    do
    {
      return null;
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    return ((awgf)localObject).a(RecommendMiniAppEntity.class, RecommendMiniAppEntity.class.getSimpleName(), false, null, null, null, null, null, null);
  }
  
  public COMM.StCommonExt getPullDownEntryExtInfo()
  {
    return this.mExtInfo;
  }
  
  public Map<String, Integer> getRedDotData()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new ArrayList();
    try
    {
      ((List)localObject).addAll(this.mTopAppList);
      ((List)localObject).addAll(this.mUsedAppList);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        return localHashMap;
      }
    }
    finally {}
    boolean bool = aoom.i();
    localObject = ((List)localObject).iterator();
    MiniAppInfo localMiniAppInfo;
    Integer localInteger1;
    Integer localInteger2;
    while (((Iterator)localObject).hasNext())
    {
      localMiniAppInfo = (MiniAppInfo)((Iterator)localObject).next();
      if ((localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId)))
      {
        localInteger1 = (Integer)this.mPublicAccountRedDotMap.get(localMiniAppInfo.appId);
        localInteger2 = (Integer)this.mPushRedDotMap.get(localMiniAppInfo.appId);
        if ((localInteger1 == null) || (localInteger1.intValue() <= 0) || (!bool)) {
          break label232;
        }
      }
    }
    label232:
    for (int i = localInteger1.intValue() + 0;; i = 0)
    {
      int j = i;
      if (localInteger2 != null)
      {
        j = i;
        if (localInteger2.intValue() > 0) {
          j = i + localInteger2.intValue();
        }
      }
      localMap.put(localMiniAppInfo.appId, Integer.valueOf(j));
      break;
      return localMap;
    }
  }
  
  public int getTopMiniAppNumber()
  {
    try
    {
      int i = this.mTopAppList.size();
      return i;
    }
    finally {}
  }
  
  public void initLocalCacheData()
  {
    ThreadManagerV2.executeOnSubThread(this.initLocalDataRunnable);
  }
  
  public void onDestroy() {}
  
  public void queryMiniAppInfoFromDb()
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.7(this), 32, null, true);
  }
  
  public void removeAllMiniAppInfo()
  {
    QLog.i("MiniAppUserAppInfoListManager", 2, "clear memory cache");
    try
    {
      this.mUsedAppList.clear();
      this.mTopAppList.clear();
      return;
    }
    finally {}
  }
  
  public void removeRedDotData(String paramString)
  {
    this.mPublicAccountRedDotMap.remove(paramString);
    this.mPushRedDotMap.remove(paramString);
    deleteRedDotDataFromDB(paramString);
  }
  
  public void saveMiniAppInfoList(List<MiniAppInfo> paramList1, List<MiniAppInfo> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      this.mTopAppList.addAll(paramList1);
      this.mUsedAppList.addAll(paramList2);
      localArrayList.addAll(this.mTopAppList);
      localArrayList.addAll(this.mUsedAppList);
      saveDataToDBWithBatch(localArrayList, true);
      return;
    }
    finally {}
  }
  
  public void sendDelUserAppRequest(MiniAppInfo paramMiniAppInfo)
  {
    MiniAppCmdUtil.getInstance().delUserApp(paramMiniAppInfo.appId, paramMiniAppInfo.verType, paramMiniAppInfo.recommend, 1, this.mDelExtInfo, new MiniAppUserAppInfoListManager.3(this, paramMiniAppInfo));
  }
  
  public void sendSetUserAppTopRequest(MiniAppInfo paramMiniAppInfo)
  {
    MiniAppCmdUtil.getInstance().setUserAppTop(paramMiniAppInfo.appId, paramMiniAppInfo.topType, paramMiniAppInfo.verType, this.mTopExtInfo, new MiniAppUserAppInfoListManager.4(this, paramMiniAppInfo));
  }
  
  public void sendUserAppListRequest(long paramLong1, long paramLong2)
  {
    QLog.d("MiniAppUserAppInfoListManager", 1, "sendUserAppListRequest");
    MiniAppCmdUtil.getInstance().getUserAppList(paramLong1, paramLong2, null, new MiniAppUserAppInfoListManager.2(this));
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null)
    {
      SharedPreferences localSharedPreferences = ((AppInterface)localObject).getPreferences();
      String str = ((AppInterface)localObject).getCurrentAccountUin() + "key_update_applets_notification_setting_time";
      paramLong1 = localSharedPreferences.getLong(str, 0L);
      paramLong2 = System.currentTimeMillis();
      if (paramLong2 - paramLong1 > QzoneConfig.getInstance().getConfig("qqminiapp", "getappletsnotificationsettinginterval", 1L) * 1000L)
      {
        localObject = (amru)((AppInterface)localObject).getBusinessHandler(148);
        if (localObject != null)
        {
          ((amru)localObject).a();
          localSharedPreferences.edit().putLong(str, paramLong2).commit();
        }
      }
    }
  }
  
  public void setMiniAppNoticeRedDotData(Map<String, Integer> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      QLog.d("MiniAppUserAppInfoListManager", 1, "setMiniAppNoticeRedDotData, data is null or data size = 0");
      clearNoticeRedDotData();
      MiniAppUtils.updateMiniAppList(101);
      return;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      String str = (String)paramMap.getKey();
      Integer localInteger2 = (Integer)paramMap.getValue();
      if ((!TextUtils.isEmpty(str)) && (localInteger2 != null) && (localInteger2.intValue() > 0))
      {
        this.mPublicAccountRedDotMap.put(str, localInteger2);
        Integer localInteger1 = (Integer)this.mPushRedDotMap.get(str);
        paramMap = localInteger1;
        if (localInteger1 == null) {
          paramMap = Integer.valueOf(0);
        }
        updateRedDotData(new MiniAppRedDotEntity(str, localInteger2.intValue(), paramMap.intValue()));
      }
    }
    MiniAppUtils.updateMiniAppList(101);
  }
  
  public void setMiniAppPushRedDotData(MiniAppRedDotEntity paramMiniAppRedDotEntity)
  {
    QLog.d("MiniAppUserAppInfoListManager", 1, "setMiniAppPushRedDotData, data: " + paramMiniAppRedDotEntity);
    if ((paramMiniAppRedDotEntity != null) && (!TextUtils.isEmpty(paramMiniAppRedDotEntity.appId)))
    {
      if (findMiniApp(paramMiniAppRedDotEntity.appId) != null) {
        break label67;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppUserAppInfoListManager", 1, "setMiniAppPushRedDotData, current app is not opened");
      }
    }
    return;
    label67:
    this.mPushRedDotMap.put(paramMiniAppRedDotEntity.appId, Integer.valueOf(paramMiniAppRedDotEntity.wnsPushRedDotNum));
    Integer localInteger = (Integer)this.mPublicAccountRedDotMap.get(paramMiniAppRedDotEntity.appId);
    if ((localInteger != null) && (localInteger.intValue() > 0)) {}
    for (int i = localInteger.intValue();; i = 0)
    {
      updateRedDotData(new MiniAppRedDotEntity(paramMiniAppRedDotEntity.appId, i, paramMiniAppRedDotEntity.wnsPushRedDotNum));
      MiniAppUtils.updateMiniAppList(101);
      return;
    }
  }
  
  public void updateMiniAppTopStatus(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.8(this, paramMiniAppInfo), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager
 * JD-Core Version:    0.7.0.1
 */