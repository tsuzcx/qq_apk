package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
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
  private BusinessObserver redDotObserver = new MiniAppUserAppInfoListManager.1(this);
  
  public MiniAppUserAppInfoListManager(QQAppInterface paramQQAppInterface)
  {
    int i = 1;
    QLog.d("MiniAppUserAppInfoListManager", 1, "MiniAppUserAppInfoListManager init.");
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "oldEntryCloseRedDot", 0) != 0) {
      i = 0;
    }
    if (i != 0)
    {
      paramQQAppInterface = MiniAppUtils.getAppInterface();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.addObserver(this.redDotObserver);
      }
    }
  }
  
  private void clearNoticeRedDotData()
  {
    this.mPublicAccountRedDotMap.clear();
    Object localObject1 = new ArrayList();
    try
    {
      ((List)localObject1).addAll(this.mTopAppList);
      ((List)localObject1).addAll(this.mUsedAppList);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void compareServerAndDbDataAsync(AppInterface paramAppInterface, List<MiniAppInfo> paramList)
  {
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager().query(MiniAppEntity.class, MiniAppEntity.class.getSimpleName(), false, null, null, null, null, null, null);
    if ((paramList != null) && (paramList.size() != 0) && (paramAppInterface != null))
    {
      if (paramAppInterface.size() == 0) {
        return;
      }
      paramAppInterface = paramAppInterface.iterator();
      while (paramAppInterface.hasNext())
      {
        Object localObject = (MiniAppEntity)paramAppInterface.next();
        if ((localObject != null) && (((MiniAppEntity)localObject).appInfo != null))
        {
          localObject = ((MiniAppEntity)localObject).createFromBuffer(((MiniAppEntity)localObject).appInfo);
          int j = 0;
          Iterator localIterator = paramList.iterator();
          MiniAppInfo localMiniAppInfo;
          do
          {
            i = j;
            if (!localIterator.hasNext()) {
              break;
            }
            localMiniAppInfo = (MiniAppInfo)localIterator.next();
          } while ((localObject == null) || (((MiniAppInfo)localObject).appId == null) || (localMiniAppInfo == null) || (!((MiniAppInfo)localObject).appId.equals(localMiniAppInfo.appId)) || (((MiniAppInfo)localObject).verType != localMiniAppInfo.verType));
          int i = 1;
          if ((i == 0) && (localObject != null)) {
            deleteMiniAppFromDB((MiniAppInfo)localObject);
          }
        }
      }
    }
  }
  
  /* Error */
  private void deleteDB(AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 10
    //   6: iconst_1
    //   7: ldc_w 261
    //   10: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 212	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   18: invokevirtual 218	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnonnull +4 -> 27
    //   26: return
    //   27: aload_2
    //   28: invokevirtual 268	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 273	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   36: aload_2
    //   37: ldc_w 275
    //   40: invokevirtual 279	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_2
    //   45: ldc_w 281
    //   48: invokevirtual 279	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   51: pop
    //   52: aload_2
    //   53: ldc_w 283
    //   56: invokevirtual 279	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   59: pop
    //   60: aload_1
    //   61: invokevirtual 286	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   64: goto +12 -> 76
    //   67: astore_2
    //   68: goto +22 -> 90
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   76: aload_1
    //   77: invokevirtual 292	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   80: ldc 10
    //   82: iconst_2
    //   83: ldc_w 294
    //   86: invokestatic 297	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: return
    //   90: aload_1
    //   91: invokevirtual 292	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	MiniAppUserAppInfoListManager
    //   0	96	1	paramAppInterface	AppInterface
    //   21	32	2	localEntityManager	EntityManager
    //   67	1	2	localObject	Object
    //   71	24	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   32	64	67	finally
    //   72	76	67	finally
    //   32	64	71	java/lang/Exception
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
    if (paramStGetUserAppListRsp != null)
    {
      Object localObject1 = paramStGetUserAppListRsp.userAppList.get();
      Object localObject2 = paramStGetUserAppListRsp.fixApps.get();
      if ((localObject1 == null) && (localObject2 == null))
      {
        paramStGetUserAppListRsp = new StringBuilder();
        paramStGetUserAppListRsp.append("handleGetUserAppListData, userAppInfoList = ");
        paramStGetUserAppListRsp.append(localObject1);
        paramStGetUserAppListRsp.append(", fixApps = ");
        paramStGetUserAppListRsp.append(localObject2);
        QLog.e("MiniAppUserAppInfoListManager", 1, paramStGetUserAppListRsp.toString());
        return;
      }
      if ((localObject1 != null) && (localObject2 != null) && (((List)localObject1).size() == 0) && (((List)localObject2).size() == 0))
      {
        removeAllMiniAppInfo();
        paramStGetUserAppListRsp = new StringBuilder();
        paramStGetUserAppListRsp.append("handleGetUserAppListData, userAppInfoList = ");
        paramStGetUserAppListRsp.append(localObject1);
        paramStGetUserAppListRsp.append(", fixApps = ");
        paramStGetUserAppListRsp.append(localObject2);
        QLog.e("MiniAppUserAppInfoListManager", 1, paramStGetUserAppListRsp.toString());
        return;
      }
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      List localList = getOldRecommendMiniAppList();
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject3;
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
            localStringBuilder.append(((MiniAppInfo)localObject3).name);
            localStringBuilder.append("(fixApp), ");
          }
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (INTERFACE.StUserAppInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((INTERFACE.StUserAppInfo)localObject2).appInfo != null))
          {
            localObject3 = MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject2);
            if ((!((MiniAppInfo)localObject3).isEngineTypeMiniGame()) || (GameWnsUtils.gameEnable()))
            {
              if ((((MiniAppInfo)localObject3).recommend == 1) && (localList != null))
              {
                localObject2 = new RecommendMiniAppEntity(((MiniAppInfo)localObject3).appId, ((MiniAppInfo)localObject3).name, ((MiniAppInfo)localObject3).recommend);
                int j = 0;
                Iterator localIterator = localList.iterator();
                RecommendMiniAppEntity localRecommendMiniAppEntity;
                do
                {
                  i = j;
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  localRecommendMiniAppEntity = (RecommendMiniAppEntity)localIterator.next();
                } while ((((MiniAppInfo)localObject3).appId == null) || (!((MiniAppInfo)localObject3).appId.equals(localRecommendMiniAppEntity.appId)));
                int i = 1;
                if (i != 0)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("handleGetUserAppListData, filter recommend mini app: ");
                  ((StringBuilder)localObject3).append(localObject2);
                  QLog.d("MiniAppUserAppInfoListManager", 2, ((StringBuilder)localObject3).toString());
                  continue;
                }
              }
              if (((MiniAppInfo)localObject3).topType == 0) {
                localLinkedList2.add(localObject3);
              } else {
                localLinkedList1.add(localObject3);
              }
              localStringBuilder.append(((MiniAppInfo)localObject3).name);
              localStringBuilder.append(", ");
            }
          }
        }
      }
      this.mExtInfo = paramStGetUserAppListRsp.extInfo;
      if ((localLinkedList2.size() > 0) || (localLinkedList1.size() > 0))
      {
        removeAllMiniAppInfo();
        saveMiniAppInfoList(localLinkedList1, localLinkedList2);
      }
      paramStGetUserAppListRsp = new StringBuilder();
      paramStGetUserAppListRsp.append("handleGetUserAppListData, app List = ");
      paramStGetUserAppListRsp.append(localStringBuilder.toString());
      QLog.d("MiniAppUserAppInfoListManager", 1, paramStGetUserAppListRsp.toString());
      return;
    }
    QLog.e("MiniAppUserAppInfoListManager", 2, "handleGetUserAppListData, rsp = null");
  }
  
  private void insertRecommendMiniAppToDB(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.12(this, paramMiniAppInfo), 32, null, true);
  }
  
  public static void recordMiniAppStart(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)localAppRuntime.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
      if (localMiniAppUserAppInfoListManager != null) {
        localMiniAppUserAppInfoListManager.updateMiniAppStartRecord(paramMiniAppInfo);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordMiniAppStart, appInfo = ");
      localStringBuilder.append(paramMiniAppInfo);
      localStringBuilder.append(", appRuntime = ");
      localStringBuilder.append(localAppRuntime);
      localStringBuilder.append("， manager = ");
      localStringBuilder.append(localMiniAppUserAppInfoListManager);
      QLog.d("MiniAppUserAppInfoListManager", 1, localStringBuilder.toString());
    }
  }
  
  private void saveDataToDBWithBatch(List<MiniAppInfo> paramList, boolean paramBoolean)
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.11(this, paramBoolean, paramList), 32, null, true);
  }
  
  private void saveToDB(Entity paramEntity)
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.9(this, paramEntity), 32, null, true);
  }
  
  private void updateAppInfoTopRecord(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      localObject = new ArrayList();
      try
      {
        if (this.mTopAppList.contains(paramMiniAppInfo)) {
          this.mTopAppList.remove(paramMiniAppInfo);
        }
        if (this.mUsedAppList.contains(paramMiniAppInfo)) {
          this.mUsedAppList.remove(paramMiniAppInfo);
        }
        if (paramMiniAppInfo.topType == 0) {
          this.mUsedAppList.addFirst(paramMiniAppInfo);
        } else if (paramMiniAppInfo.topType == 1) {
          this.mTopAppList.addFirst(paramMiniAppInfo);
        }
        ((List)localObject).addAll(this.mTopAppList);
        ((List)localObject).addAll(this.mUsedAppList);
        saveDataToDBWithBatch((List)localObject, false);
        return;
      }
      finally {}
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insertAppInfo error app info is invalid, appInfo = ");
    ((StringBuilder)localObject).append(paramMiniAppInfo);
    QLog.e("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
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
      QLog.d("MiniAppUserAppInfoListManager", 2, paramEntityManager.toString());
    }
    return false;
  }
  
  private void updateMiniAppStartRecord(MiniAppInfo paramMiniAppInfo)
  {
    int j = 1;
    Object localObject;
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      try
      {
        if (this.mTopAppList.contains(paramMiniAppInfo)) {
          return;
        }
        if (!this.mUsedAppList.contains(paramMiniAppInfo)) {
          break label267;
        }
        this.mUsedAppList.remove(paramMiniAppInfo);
        i = 1;
        if (i != 0) {
          break label272;
        }
        MiniAppInfo localMiniAppInfo = findMiniApp(paramMiniAppInfo.appId, paramMiniAppInfo.verType);
        if (this.mTopAppList.contains(localMiniAppInfo))
        {
          i = this.mTopAppList.indexOf(localMiniAppInfo);
          this.mTopAppList.set(i, paramMiniAppInfo);
          i = j;
        }
        else
        {
          if (localMiniAppInfo == null) {
            break label272;
          }
          this.mUsedAppList.remove(localMiniAppInfo);
          break label272;
        }
        if (i == 0)
        {
          i = this.mTopAppList.size();
          if (this.mUsedAppList.size() + i >= 20)
          {
            this.mUsedAppList.removeLast();
            continue;
          }
          this.mUsedAppList.addFirst(paramMiniAppInfo);
        }
        ((List)localObject).addAll(this.mTopAppList);
        ((List)localObject).addAll(this.mUsedAppList);
        saveDataToDBWithBatch((List)localObject, false);
        return;
      }
      finally {}
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertAppInfo error app info is invalid, appInfo = ");
      ((StringBuilder)localObject).append(paramMiniAppInfo);
      QLog.e("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject).toString());
      return;
      label267:
      int i = 0;
      continue;
      label272:
      i = 0;
    }
  }
  
  private void updateRedDotData(MiniAppRedDotEntity paramMiniAppRedDotEntity)
  {
    if (paramMiniAppRedDotEntity == null) {
      return;
    }
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.13(this, paramMiniAppRedDotEntity), 32, null, true);
  }
  
  private boolean updateRedDotData(EntityManager paramEntityManager, Entity paramEntity)
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
      QLog.d("MiniAppUserAppInfoListManager", 2, paramEntityManager.toString());
    }
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
          break label42;
        }
        if (this.mUsedAppList.size() <= 0) {
          break label37;
        }
      }
      finally {}
      return bool;
      label37:
      boolean bool = false;
      continue;
      label42:
      bool = true;
    }
  }
  
  public MiniAppInfo findMiniApp(String paramString)
  {
    try
    {
      Iterator localIterator = this.mTopAppList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (MiniAppInfo)localIterator.next();
        if ((localObject != null) && (paramString.equals(((MiniAppInfo)localObject).appId)))
        {
          paramString = new StringBuilder();
          paramString.append("findMiniApp, appInfo = ");
          paramString.append(localObject);
          QLog.d("MiniAppUserAppInfoListManager", 1, paramString.toString());
          return localObject;
        }
      }
      localIterator = this.mUsedAppList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (MiniAppInfo)localIterator.next();
        if ((localObject != null) && (paramString.equals(((MiniAppInfo)localObject).appId)))
        {
          paramString = new StringBuilder();
          paramString.append("findMiniApp, appInfo = ");
          paramString.append(localObject);
          QLog.d("MiniAppUserAppInfoListManager", 1, paramString.toString());
          return localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findMiniApp, failed to find Miniapp, appId = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public MiniAppInfo findMiniApp(String paramString, int paramInt)
  {
    try
    {
      Iterator localIterator = this.mTopAppList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (MiniAppInfo)localIterator.next();
        if ((localObject != null) && (paramString.equals(((MiniAppInfo)localObject).appId)) && (paramInt == ((MiniAppInfo)localObject).verType))
        {
          paramString = new StringBuilder();
          paramString.append("findMiniApp, appInfo = ");
          paramString.append(localObject);
          QLog.d("MiniAppUserAppInfoListManager", 1, paramString.toString());
          return localObject;
        }
      }
      localIterator = this.mUsedAppList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (MiniAppInfo)localIterator.next();
        if ((localObject != null) && (paramString.equals(((MiniAppInfo)localObject).appId)) && (paramInt == ((MiniAppInfo)localObject).verType))
        {
          paramString = new StringBuilder();
          paramString.append("findMiniApp, appInfo = ");
          paramString.append(localObject);
          QLog.d("MiniAppUserAppInfoListManager", 1, paramString.toString());
          return localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findMiniApp, failed to find Miniapp, appId = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
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
          paramString = new StringBuilder();
          paramString.append("findMiniApp, appInfo = ");
          paramString.append(localMiniAppInfo);
          QLog.d("MiniAppUserAppInfoListManager", 1, paramString.toString());
          return localMiniAppInfo;
        }
      }
      QLog.d("MiniAppUserAppInfoListManager", 1, "findMiniApp, failed to find  top Miniapp");
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMiniAppInfoData, user DB cache data. size = ");
        localStringBuilder.append(localLinkedList.size());
        QLog.e("MiniAppUserAppInfoListManager", 1, localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMiniAppInfoData, size = ");
      localStringBuilder.append(localLinkedList.size());
      QLog.d("MiniAppUserAppInfoListManager", 2, localStringBuilder.toString());
      return localLinkedList;
    }
    finally {}
  }
  
  public List<RecommendMiniAppEntity> getOldRecommendMiniAppList()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    List localList = null;
    if (localObject == null)
    {
      QLog.e("MiniAppUserAppInfoListManager", 1, "getOldRecommendMiniAppList, app is null.");
      return null;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    if (localObject != null) {
      localList = ((EntityManager)localObject).query(RecommendMiniAppEntity.class, RecommendMiniAppEntity.class.getSimpleName(), false, null, null, null, null, null, null);
    }
    return localList;
  }
  
  public COMM.StCommonExt getPullDownEntryExtInfo()
  {
    return this.mExtInfo;
  }
  
  public Map<String, Integer> getRedDotData()
  {
    HashMap localHashMap = new HashMap();
    Object localObject2 = new ArrayList();
    try
    {
      ((List)localObject2).addAll(this.mTopAppList);
      ((List)localObject2).addAll(this.mUsedAppList);
      if (((List)localObject2).size() <= 0) {
        return localHashMap;
      }
      boolean bool = MiniAppConfProcessor.e();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MiniAppInfo localMiniAppInfo = (MiniAppInfo)((Iterator)localObject2).next();
        if ((localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId)))
        {
          int j = 0;
          Integer localInteger1 = (Integer)this.mPublicAccountRedDotMap.get(localMiniAppInfo.appId);
          Integer localInteger2 = (Integer)this.mPushRedDotMap.get(localMiniAppInfo.appId);
          int i = j;
          if (localInteger1 != null)
          {
            i = j;
            if (localInteger1.intValue() > 0)
            {
              i = j;
              if (bool) {
                i = 0 + localInteger1.intValue();
              }
            }
          }
          j = i;
          if (localInteger2 != null)
          {
            j = i;
            if (localInteger2.intValue() > 0) {
              j = i + localInteger2.intValue();
            }
          }
          localHashMap.put(localMiniAppInfo.appId, Integer.valueOf(j));
        }
      }
      return localHashMap;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
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
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 != null)
    {
      SharedPreferences localSharedPreferences = ((AppInterface)localObject1).getPreferences();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((AppInterface)localObject1).getCurrentAccountUin());
      ((StringBuilder)localObject2).append("key_update_applets_notification_setting_time");
      localObject2 = ((StringBuilder)localObject2).toString();
      paramLong1 = localSharedPreferences.getLong((String)localObject2, 0L);
      paramLong2 = System.currentTimeMillis();
      if (paramLong2 - paramLong1 > QzoneConfig.getInstance().getConfig("qqminiapp", "getappletsnotificationsettinginterval", 1L) * 1000L)
      {
        localObject1 = (AppletsHandler)((AppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
        if (localObject1 != null)
        {
          ((AppletsHandler)localObject1).a();
          localSharedPreferences.edit().putLong((String)localObject2, paramLong2).commit();
        }
      }
    }
  }
  
  public void setMiniAppNoticeRedDotData(Map<String, Integer> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
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
      return;
    }
    QLog.d("MiniAppUserAppInfoListManager", 1, "setMiniAppNoticeRedDotData, data is null or data size = 0");
    clearNoticeRedDotData();
    MiniAppUtils.updateMiniAppList(101);
  }
  
  public void setMiniAppPushRedDotData(MiniAppRedDotEntity paramMiniAppRedDotEntity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMiniAppPushRedDotData, data: ");
    ((StringBuilder)localObject).append(paramMiniAppRedDotEntity);
    QLog.d("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject).toString());
    if ((paramMiniAppRedDotEntity != null) && (!TextUtils.isEmpty(paramMiniAppRedDotEntity.appId)))
    {
      if (findMiniApp(paramMiniAppRedDotEntity.appId) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppUserAppInfoListManager", 1, "setMiniAppPushRedDotData, current app is not opened");
        }
        return;
      }
      this.mPushRedDotMap.put(paramMiniAppRedDotEntity.appId, Integer.valueOf(paramMiniAppRedDotEntity.wnsPushRedDotNum));
      localObject = (Integer)this.mPublicAccountRedDotMap.get(paramMiniAppRedDotEntity.appId);
      int j = 0;
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (((Integer)localObject).intValue() > 0) {
          i = ((Integer)localObject).intValue();
        }
      }
      updateRedDotData(new MiniAppRedDotEntity(paramMiniAppRedDotEntity.appId, i, paramMiniAppRedDotEntity.wnsPushRedDotNum));
      MiniAppUtils.updateMiniAppList(101);
    }
  }
  
  public void updateMiniAppTopStatus(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new MiniAppUserAppInfoListManager.8(this, paramMiniAppInfo), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager
 * JD-Core Version:    0.7.0.1
 */