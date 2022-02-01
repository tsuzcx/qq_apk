package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StFriendRanking;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StOperationApp;
import NS_MINI_INTERFACE.INTERFACE.StSearchModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.springfestival.HBEntryBannerData;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.DesktopAdData;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class DesktopDataManager
  implements Manager
{
  private static final String DESKTOP_SP_NAME = "mini_app_desktop";
  private static final String NOTIFY_NATIVE_ADDAPPTOMINE = "addAppToMine";
  private static final String NOTIFY_NATIVE_DELETEAPP = "deleteApp";
  private static final String NOTIFY_NATIVE_EXCHANGEAPPORDER = "exchangeAppOrder";
  private static final String NOTIFY_NATIVE_REMOVEAPPFROMMINE = "removeAppFromMine";
  private static final String RECOMMEND_EXPOSURE_SP_NAME = "app_recommend_exposure";
  public static final String TAG = "DesktopDataManager";
  public static final String TAG_RECOMMEND = "DesktopDataManager-Recommend";
  private static byte[] mLock = new byte[0];
  private List<DesktopItemInfo> adapterItemInfos;
  private boolean canLoadMoreRecent = true;
  private Runnable deleteErrorSpFile = new DesktopDataManager.35(this);
  private List<DesktopItemInfo> desktopItemInfos = new ArrayList();
  private volatile boolean hasInitData = false;
  private volatile boolean hasPullSearchData = false;
  private Runnable initLocalDataRunnable = new DesktopDataManager.18(this);
  private boolean isLoadingMoreRecent = false;
  private ConcurrentHashMap<String, DesktopAdData> mAdReportMap = new ConcurrentHashMap();
  private DesktopDataManager.DataChangeListener mDataChangeListener;
  private DesktopOperationAppEntryInfo mDesktopOperationAppEntryInfo;
  private volatile COMM.StCommonExt mExtInfo;
  private volatile HBEntryBannerData mHBEntryBannerData;
  private final AtomicBoolean mHBEntryDataAddedState = new AtomicBoolean(false);
  private volatile DesktopDataManager.HongBaoResBuilder mHongBaoResBuilder;
  private volatile COMM.StCommonExt mMoreRencentExtInfo;
  private ConcurrentHashMap<String, Integer> mPublicAccountRedDotMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> mPushRedDotMap = new ConcurrentHashMap();
  private ArrayList<RecommendAppInfo> mRecommendExposureList = new ArrayList();
  private Set<String> mRecommendListFixAppidSet = new HashSet();
  private volatile int mRedDataState = -1;
  private volatile long mRefreshInternal = 3600L;
  private volatile int mRequestCount = 0;
  private BusinessObserver redDotObserver = new DesktopDataManager.31(this);
  
  public DesktopDataManager(QQAppInterface paramQQAppInterface)
  {
    QLog.d("DesktopDataManager", 1, "DesktopDataManager init.");
    registerObserver();
  }
  
  private void appendMyAppData(List<INTERFACE.StModuleInfo> paramList)
  {
    runOnMainThread(new DesktopDataManager.7(this, paramList));
  }
  
  private void appendRecentAppData(List<INTERFACE.StModuleInfo> paramList)
  {
    runOnMainThread(new DesktopDataManager.8(this, paramList));
  }
  
  private static String buildDeskTopAppInfoString(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append("moduletype:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append("appid:");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String buildDeskTopModuleInfoString(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append("moduletype:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append("title:");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void changeMyAppOrder(String paramString, int paramInt1, int paramInt2)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    runOnMainThread(new DesktopDataManager.30(this, paramInt1, paramInt2));
  }
  
  private void checkAddHBMiniBanner(List<DesktopItemInfo> paramList, HBEntryBannerData paramHBEntryBannerData)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = paramList.iterator();
      DesktopItemInfo localDesktopItemInfo;
      while (((Iterator)localObject).hasNext())
      {
        localDesktopItemInfo = (DesktopItemInfo)((Iterator)localObject).next();
        if ((localDesktopItemInfo instanceof DesktopSearchInfo)) {
          ((DesktopSearchInfo)localDesktopItemInfo).isSpringFestivalMode = false;
        }
        if ((localDesktopItemInfo instanceof HBEntryBannerData))
        {
          i = paramList.indexOf(localDesktopItemInfo);
          break label83;
        }
      }
      int i = -1;
      label83:
      if (i != -1) {
        paramList.remove(i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DesktopDataManager", 2, "HBEntryBannerData: checkAddHBMiniBanner, removed item");
      }
      if ((this.mHBEntryDataAddedState.get()) && (paramHBEntryBannerData != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DesktopDataManager", 2, "HBEntryBannerData: checkAddHBMiniBanner, add item");
        }
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localDesktopItemInfo = (DesktopItemInfo)((Iterator)localObject).next();
          if ((localDesktopItemInfo instanceof DesktopSearchInfo))
          {
            localObject = (DesktopSearchInfo)localDesktopItemInfo;
            ((DesktopSearchInfo)localObject).isSpringFestivalMode = true;
            paramList.add(paramList.indexOf(localObject) + 1, paramHBEntryBannerData);
          }
        }
        if (!paramList.contains(paramHBEntryBannerData)) {
          paramList.add(0, paramHBEntryBannerData);
        }
      }
    }
  }
  
  private void checkData(boolean paramBoolean)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    Object localObject = this.adapterItemInfos;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    processUIData();
    localObject = this.adapterItemInfos;
    int j;
    if (localObject != null) {
      j = ((List)localObject).size();
    } else {
      j = 0;
    }
    int m;
    if (j != i) {
      m = 1;
    } else {
      m = 0;
    }
    int i1 = getTopModuleInfoIndex();
    if (i1 < 0)
    {
      this.adapterItemInfos.add(new DesktopAppModuleInfo(3, HardCodeUtil.a(2131901253)));
      this.adapterItemInfos.add(new DesktopEmptyGuideInfo(3));
      if (paramBoolean)
      {
        localObject = this.mDataChangeListener;
        if (localObject != null) {
          ((DesktopDataManager.DataChangeListener)localObject).onDataChanged();
        }
      }
      return;
    }
    int i = i1;
    int k = 0;
    int n = -1;
    while (i < this.adapterItemInfos.size())
    {
      localObject = (DesktopItemInfo)this.adapterItemInfos.get(i);
      j = k;
      if ((localObject instanceof DesktopAppInfo))
      {
        j = k;
        if (((DesktopItemInfo)localObject).mModuleType == 3) {
          j = k + 1;
        }
      }
      if (((localObject instanceof DesktopAppGroupInfo)) && (((DesktopItemInfo)localObject).mModuleType == 3))
      {
        k = j + 1;
      }
      else
      {
        k = j;
        if ((localObject instanceof DesktopEmptyGuideInfo))
        {
          n = i;
          k = j;
        }
      }
      i += 1;
    }
    if ((k == 0) && (n < 0))
    {
      this.adapterItemInfos.add(i1 + 1, new DesktopEmptyGuideInfo(3));
      if (paramBoolean)
      {
        localObject = this.mDataChangeListener;
        if (localObject != null) {
          ((DesktopDataManager.DataChangeListener)localObject).onDataChanged();
        }
      }
    }
    else if ((k > 0) && (n > 0))
    {
      this.adapterItemInfos.remove(n);
      if (paramBoolean)
      {
        localObject = this.mDataChangeListener;
        if (localObject != null) {
          ((DesktopDataManager.DataChangeListener)localObject).onDataChanged();
        }
      }
    }
    else if ((m != 0) && (paramBoolean))
    {
      localObject = this.mDataChangeListener;
      if (localObject != null) {
        ((DesktopDataManager.DataChangeListener)localObject).onDataChanged();
      }
    }
    if (this.mHBEntryDataAddedState.get()) {
      checkAddHBMiniBanner(this.adapterItemInfos, this.mHBEntryBannerData);
    }
    setDesktopAppPositionInfoToSp(this.desktopItemInfos);
  }
  
  private void checkRedDotSwitch()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null)
    {
      QLog.e("DesktopDataManager", 1, "initLocalDataRunnable, app is null.");
      return;
    }
    if (MiniAppConfProcessor.n())
    {
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      if (localObject != null)
      {
        localObject = ((EntityManager)localObject).query(MiniAppSettingSwitchInfoEntity.class, MiniAppSettingSwitchInfoEntity.class.getSimpleName(), false, "key = ?", new String[] { "redDot" }, null, null, null, null);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = (MiniAppSettingSwitchInfoEntity)((List)localObject).get(0);
          if ((localObject != null) && ("redDot".equals(((MiniAppSettingSwitchInfoEntity)localObject).key)))
          {
            this.mRedDataState = ((MiniAppSettingSwitchInfoEntity)localObject).value;
            Bundle localBundle = new Bundle();
            localBundle.putInt(((MiniAppSettingSwitchInfoEntity)localObject).key, ((MiniAppSettingSwitchInfoEntity)localObject).value);
            localBundle.putBoolean("refreshUI", false);
            BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppDesktop.class, 102, true, localBundle);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("initLocalDataRunnable, redDot switch: ");
            ((StringBuilder)localObject).append(this.mRedDataState);
            QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  private void clearNoticeRedDotData()
  {
    this.mPublicAccountRedDotMap.clear();
    Object localObject1 = this.desktopItemInfos;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      localObject1 = new ArrayList();
      Object localObject2 = this.desktopItemInfos.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (DesktopItemInfo)((Iterator)localObject2).next();
        if (((localObject3 instanceof DesktopAppInfo)) && ((((DesktopItemInfo)localObject3).getModuleType() == 1) || (((DesktopItemInfo)localObject3).getModuleType() == 3) || (((DesktopItemInfo)localObject3).getModuleType() == 2)))
        {
          localObject3 = (DesktopAppInfo)localObject3;
          if (((DesktopAppInfo)localObject3).mMiniAppInfo != null) {
            ((List)localObject1).add(((DesktopAppInfo)localObject3).mMiniAppInfo);
          }
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MiniAppInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject2).appId)))
        {
          localObject3 = (Integer)this.mPushRedDotMap.get(((MiniAppInfo)localObject2).appId);
          if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0)) {
            updateRedDotData(new MiniAppRedDotEntity(((MiniAppInfo)localObject2).appId, 0, ((Integer)localObject3).intValue()));
          } else {
            deleteRedDotDataFromDB(((MiniAppInfo)localObject2).appId);
          }
        }
      }
    }
  }
  
  private void convertData(List<INTERFACE.StUserAppInfo> paramList, List<INTERFACE.StModuleInfo> paramList1, INTERFACE.StSearchModuleInfo paramStSearchModuleInfo, INTERFACE.StOperationApp paramStOperationApp)
  {
    QLog.d("DesktopDataManager", 1, "convertData start!");
    if (((paramList1 == null) || (paramList1.size() <= 0)) && ((paramList == null) || (paramList.isEmpty())) && (paramStSearchModuleInfo == null))
    {
      handleEmptyModuleInStudyMode();
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    this.hasPullSearchData = false;
    if ((paramStSearchModuleInfo != null) && (paramStSearchModuleInfo.searchApp.get() != null))
    {
      localObject1 = (INTERFACE.StUserAppInfo)paramStSearchModuleInfo.searchApp.get();
      if (localObject1 != null)
      {
        localArrayList1.add(new DesktopSearchInfo(MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject1), paramStSearchModuleInfo.keywords.get(), 0));
        this.hasPullSearchData = true;
      }
    }
    ArrayList localArrayList4 = new ArrayList();
    Object localObject1 = new HashSet();
    int i = 2;
    Object localObject2;
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramStSearchModuleInfo = (INTERFACE.StUserAppInfo)paramList.next();
        if (paramStSearchModuleInfo != null)
        {
          localObject2 = new DesktopAppInfo(2, MiniAppInfo.from(paramStSearchModuleInfo));
          ((DesktopAppInfo)localObject2).setIsFixApp(true);
          ((DesktopAppInfo)localObject2).deleteEnable = false;
          ((DesktopAppInfo)localObject2).dragEnable = false;
          ((DesktopAppInfo)localObject2).dropEnable = false;
          localArrayList4.add(localObject2);
          ((Set)localObject1).add(paramStSearchModuleInfo.appInfo.appId.get());
        }
      }
    }
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (INTERFACE.StModuleInfo)paramList.next();
      if (localObject2 != null)
      {
        int j = ((INTERFACE.StModuleInfo)localObject2).moduleType.get();
        if (6 == j)
        {
          paramList1 = new DesktopPopularModuleInfo(6);
          paramList1.mergePbData((INTERFACE.StModuleInfo)localObject2);
          localArrayList1.add(paramList1);
          localArrayList3.add(localObject2);
        }
        else if (4 == j)
        {
          localArrayList1.add(new DesktopRecommendModuleInfo(4, (INTERFACE.StModuleInfo)localObject2));
          localArrayList3.add(localObject2);
        }
        else if (5 == j)
        {
          paramList1 = ((INTERFACE.StModuleInfo)localObject2).ranks.get();
          if ((paramList1 != null) && (!paramList1.isEmpty()))
          {
            paramList1 = paramList1.iterator();
            while (paramList1.hasNext()) {
              localArrayList1.add(new DesktopFriendsPkModuleInfo(5, (INTERFACE.StModuleInfo)localObject2, (INTERFACE.StFriendRanking)paramList1.next()));
            }
          }
          localArrayList3.add(localObject2);
        }
        else if (8 == j)
        {
          paramList1 = ((INTERFACE.StModuleInfo)localObject2).userAppList.get();
          if ((paramList1 != null) && (!paramList1.isEmpty())) {
            localArrayList1.add(new DesktopMostCommonlyUsedInfo(8, (INTERFACE.StModuleInfo)localObject2));
          }
        }
        else if (7 == j)
        {
          paramList1 = new DesktopDittoInfo(7);
          paramList1.mergePbData((INTERFACE.StModuleInfo)localObject2);
          localArrayList1.add(paramList1);
          localArrayList3.add(localObject2);
        }
        else if (10 == j)
        {
          paramList1 = new DesktopChessRoomModuleInfo(10);
          paramList1.mergePbData((INTERFACE.StModuleInfo)localObject2);
          localArrayList1.add(paramList1);
          localArrayList3.add(localObject2);
        }
        else if (9 == j)
        {
          paramList1 = new DesktopChessRoomCardModuleInfo(9);
          paramList1.mergePbData((INTERFACE.StModuleInfo)localObject2);
          localArrayList1.add(paramList1);
          localArrayList3.add(localObject2);
        }
        else
        {
          if ((((INTERFACE.StModuleInfo)localObject2).moduleType.get() >= 0) && (!TextUtils.isEmpty(((INTERFACE.StModuleInfo)localObject2).title.get())))
          {
            paramStSearchModuleInfo = new DesktopAppModuleInfo(((INTERFACE.StModuleInfo)localObject2).moduleType.get(), ((INTERFACE.StModuleInfo)localObject2).title.get(), (INTERFACE.StUserAppInfo)((INTERFACE.StModuleInfo)localObject2).jumpMoreApp.get());
            localArrayList1.add(paramStSearchModuleInfo);
            paramList1 = paramStSearchModuleInfo;
            if (paramStSearchModuleInfo.getModuleType() == i)
            {
              paramList1 = paramStSearchModuleInfo;
              if (localArrayList4.size() > 0)
              {
                localArrayList1.addAll(localArrayList4);
                paramList1 = paramStSearchModuleInfo;
              }
            }
          }
          else
          {
            paramList1 = null;
          }
          if ((paramList1 != null) && (((INTERFACE.StModuleInfo)localObject2).userAppList.get() != null) && (((INTERFACE.StModuleInfo)localObject2).userAppList.get().size() > 0))
          {
            paramStSearchModuleInfo = ((INTERFACE.StModuleInfo)localObject2).userAppList.get().iterator();
            while (paramStSearchModuleInfo.hasNext())
            {
              Object localObject3 = (INTERFACE.StUserAppInfo)paramStSearchModuleInfo.next();
              localObject3 = new DesktopAppInfo(((INTERFACE.StModuleInfo)localObject2).moduleType.get(), MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject3));
              if ((paramList1.getModuleType() == i) && (((DesktopAppInfo)localObject3).mMiniAppInfo != null))
              {
                RecommendAppInfo localRecommendAppInfo = new RecommendAppInfo(((DesktopAppInfo)localObject3).mMiniAppInfo.appId, 0, System.currentTimeMillis());
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("convertData add ");
                localStringBuilder.append(localRecommendAppInfo.toString());
                QLog.d("DesktopDataManager-Recommend", 2, localStringBuilder.toString());
                localArrayList2.add(localRecommendAppInfo);
              }
              if ((((DesktopAppInfo)localObject3).mMiniAppInfo != null) && (((DesktopAppInfo)localObject3).mMiniAppInfo.isLimitedAccessApp())) {
                ((DesktopAppInfo)localObject3).dragEnable = false;
              }
              if (((DesktopAppInfo)localObject3).mMiniAppInfo != null) {
                ((DesktopAppInfo)localObject3).mMiniAppInfo.debugInfo = null;
              }
              localArrayList1.add(localObject3);
              i = 2;
            }
          }
          else
          {
            paramList1 = paramList;
            int k = ((INTERFACE.StModuleInfo)localObject2).moduleType.get();
            j = 2;
            i = j;
            paramList = paramList1;
            if (k == 2)
            {
              i = j;
              paramList = paramList1;
              if (((INTERFACE.StModuleInfo)localObject2).useOld.get() == 0)
              {
                localArrayList2.clear();
                paramList = paramList1;
                i = j;
              }
            }
          }
        }
      }
    }
    setDesktopAppPositionInfoToSp(localArrayList1);
    paramList = new ArrayList();
    paramList.addAll(localArrayList1);
    insertEntityWithBatch(paramList);
    saveCardModuleData(localArrayList3);
    updateRecommendExposureSp();
    paramList = new StringBuilder();
    paramList.append("convertData end. size = ");
    paramList.append(localArrayList1.size());
    QLog.d("DesktopDataManager", 1, paramList.toString());
    runOnMainThread(new DesktopDataManager.12(this, localArrayList2, localArrayList1, handleOperationAppEntryData(paramStOperationApp), (Set)localObject1));
  }
  
  private void convertMyAppData(List<INTERFACE.StModuleInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        INTERFACE.StModuleInfo localStModuleInfo = (INTERFACE.StModuleInfo)paramList.next();
        if ((localStModuleInfo != null) && (localStModuleInfo.moduleType.get() == 3) && (localStModuleInfo.userAppList.get() != null) && (localStModuleInfo.userAppList.get().size() > 0))
        {
          Iterator localIterator = localStModuleInfo.userAppList.get().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (INTERFACE.StUserAppInfo)localIterator.next();
            localObject = new DesktopAppInfo(localStModuleInfo.moduleType.get(), MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject));
            this.desktopItemInfos.add(localObject);
          }
        }
      }
    }
  }
  
  private void deleteApp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.desktopItemInfos == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("test1: size: ");
    localStringBuilder.append(this.desktopItemInfos.size());
    QLog.e("DesktopDataManager", 2, localStringBuilder.toString());
    runOnMainThread(new DesktopDataManager.28(this, paramString));
  }
  
  private void deleteEntity(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.excute(new DesktopDataManager.19(this, paramMiniAppInfo), 32, null, true);
  }
  
  private void deleteEntity(List<DesktopItemInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (DesktopItemInfo)paramList.next();
        if ((localObject instanceof DesktopAppInfo))
        {
          localObject = (DesktopAppInfo)localObject;
          if ((((DesktopAppInfo)localObject).mMiniAppInfo != null) && (!findMiniApp(((DesktopAppInfo)localObject).mMiniAppInfo))) {
            deleteEntity(((DesktopAppInfo)localObject).mMiniAppInfo);
          }
        }
      }
    }
  }
  
  private void deleteMiniAppCache(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (TextUtils.isEmpty(paramMiniAppInfo.appId)) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteMiniApp, delete miniAppInfo: ");
        ((StringBuilder)localObject).append(paramMiniAppInfo.toString());
        QLog.i("DesktopDataManager", 2, ((StringBuilder)localObject).toString());
      }
      int i = this.desktopItemInfos.size();
      int k = 1;
      i -= 1;
      int j;
      for (;;)
      {
        j = k;
        if (i < 0) {
          break;
        }
        localObject = (DesktopItemInfo)this.desktopItemInfos.get(i);
        if ((localObject instanceof DesktopAppInfo))
        {
          localObject = (DesktopAppInfo)localObject;
          if ((((DesktopAppInfo)localObject).mMiniAppInfo != null) && (((DesktopAppInfo)localObject).mMiniAppInfo != paramMiniAppInfo) && (paramMiniAppInfo.appId.equals(((DesktopAppInfo)localObject).mMiniAppInfo.appId)))
          {
            j = 0;
            break;
          }
        }
        i -= 1;
      }
      if (j == 0) {
        return;
      }
      MiniCacheFreeManager.freeCache(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramMiniAppInfo);
    }
  }
  
  private void deleteOldEntity(List<DeskTopAppEntity> paramList)
  {
    Object localObject;
    EntityManager localEntityManager;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject = MiniAppUtils.getAppInterface();
      if (localObject == null)
      {
        QLog.e("DesktopDataManager", 1, "deleteOldEntity, app is null.");
        return;
      }
      localEntityManager = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      if (localEntityManager == null) {}
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new StringBuilder();
        i = 0;
        if (i < paramList.size())
        {
          DeskTopAppEntity localDeskTopAppEntity = (DeskTopAppEntity)paramList.get(i);
          localDeskTopAppEntity.setStatus(1001);
          if (localEntityManager.remove(localDeskTopAppEntity, "uniqueId=?", new String[] { localDeskTopAppEntity.uniqueId }))
          {
            ((StringBuilder)localObject).append(localDeskTopAppEntity.name);
            ((StringBuilder)localObject).append("_0, ");
            break label225;
          }
          ((StringBuilder)localObject).append(localDeskTopAppEntity.name);
          ((StringBuilder)localObject).append("_1, ");
          break label225;
        }
        paramList = new StringBuilder();
        paramList.append("deleteOldEntity, ");
        paramList.append(((StringBuilder)localObject).toString());
        QLog.e("DesktopDataManager", 2, paramList.toString());
        return;
      }
      catch (Throwable paramList)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteOldEntity, Exception: ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramList));
        QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
      }
      return;
      label225:
      i += 1;
    }
  }
  
  private void deleteRedDotDataFromDB(String paramString)
  {
    ThreadManager.excute(new DesktopDataManager.33(this, paramString), 32, null, true);
  }
  
  private boolean findMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject1 = this.desktopItemInfos;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = this.desktopItemInfos.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (DesktopItemInfo)((Iterator)localObject1).next();
        if ((localObject2 instanceof DesktopAppInfo))
        {
          localObject2 = (DesktopAppInfo)localObject2;
          if ((((DesktopAppInfo)localObject2).mMiniAppInfo != null) && (((DesktopAppInfo)localObject2).mMiniAppInfo.verType == paramMiniAppInfo.verType) && (paramMiniAppInfo.appId.equals(((DesktopAppInfo)localObject2).mMiniAppInfo.appId))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static List<DesktopDataManager.PositionItemInfo> getDesktopAppPositionInfoFromSp()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((AppInterface)localObject1).getCurrentAccountUin();
      Object localObject2 = BaseApplication.getContext();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = "_";
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("mini_app_desktop");
      localObject2 = ((BaseApplication)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
      int i2 = 0;
      localObject2 = ((SharedPreferences)localObject2).getStringSet("key_mini_app_desktop_position_info", null);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getDesktopAppPositionInfo, start--info: ");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.d("DesktopDataManager", 2, ((StringBuilder)localObject3).toString());
      }
      if ((localObject2 != null) && (((Set)localObject2).size() > 0))
      {
        Iterator localIterator = ((Set)localObject2).iterator();
        label744:
        while (localIterator.hasNext())
        {
          Object localObject4 = (String)localIterator.next();
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            String[] arrayOfString = ((String)localObject4).split((String)localObject1);
            boolean bool = ((String)localObject4).contains("appid");
            localObject3 = "";
            int i1;
            int k;
            int i;
            int j;
            int m;
            int n;
            if (bool)
            {
              if (arrayOfString.length <= 0) {
                break label744;
              }
              i1 = arrayOfString.length;
              k = -1;
              i = 0;
              for (j = -1; i < i1; j = n)
              {
                localObject4 = arrayOfString[i].split(":");
                if (localObject4 != null)
                {
                  m = k;
                  localObject2 = localObject3;
                  n = j;
                  if (localObject4.length > 1) {
                    if ("appid".equals(localObject4[0]))
                    {
                      localObject2 = localObject4[1];
                      m = k;
                      n = j;
                    }
                    else if ("moduletype".equals(localObject4[0]))
                    {
                      m = Integer.valueOf(localObject4[1]).intValue();
                      localObject2 = localObject3;
                      n = j;
                    }
                    else
                    {
                      m = k;
                      localObject2 = localObject3;
                      n = j;
                      if ("position".equals(localObject4[0]))
                      {
                        n = Integer.valueOf(localObject4[1]).intValue();
                        m = k;
                        localObject2 = localObject3;
                      }
                    }
                  }
                }
                else
                {
                  n = j;
                  localObject2 = localObject3;
                  m = k;
                }
                i += 1;
                k = m;
                localObject3 = localObject2;
              }
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                localObject2 = new DesktopDataManager.PositionItemInfo(null);
                ((DesktopDataManager.PositionItemInfo)localObject2).moduleType = k;
                ((DesktopDataManager.PositionItemInfo)localObject2).appId = ((String)localObject3);
                ((DesktopDataManager.PositionItemInfo)localObject2).position = j;
                localArrayList.add(localObject2);
                localObject2 = localObject1;
              }
            }
            else
            {
              localObject2 = localObject1;
              if (((String)localObject4).contains("title"))
              {
                localObject2 = localObject1;
                if (arrayOfString.length > 0)
                {
                  j = arrayOfString.length;
                  k = 0;
                  m = -1;
                  i = -1;
                  while (k < j)
                  {
                    localObject4 = arrayOfString[k].split(":");
                    if (localObject4 != null)
                    {
                      n = m;
                      i1 = i;
                      localObject2 = localObject3;
                      if (localObject4.length > 1) {
                        if ("title".equals(localObject4[0]))
                        {
                          localObject2 = localObject4[1];
                          n = m;
                          i1 = i;
                        }
                        else if ("moduletype".equals(localObject4[0]))
                        {
                          n = Integer.valueOf(localObject4[1]).intValue();
                          i1 = i;
                          localObject2 = localObject3;
                        }
                        else
                        {
                          n = m;
                          i1 = i;
                          localObject2 = localObject3;
                          if ("position".equals(localObject4[0]))
                          {
                            i1 = Integer.valueOf(localObject4[1]).intValue();
                            n = m;
                            localObject2 = localObject3;
                          }
                        }
                      }
                    }
                    else
                    {
                      localObject2 = localObject3;
                      i1 = i;
                      n = m;
                    }
                    k += 1;
                    m = n;
                    i = i1;
                    localObject3 = localObject2;
                  }
                  localObject2 = localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    i2 = 0;
                    localObject2 = new DesktopDataManager.PositionItemInfo(null);
                    ((DesktopDataManager.PositionItemInfo)localObject2).moduleType = m;
                    ((DesktopDataManager.PositionItemInfo)localObject2).moduleTitle = ((String)localObject3);
                    ((DesktopDataManager.PositionItemInfo)localObject2).position = i;
                    localArrayList.add(localObject2);
                    break label744;
                  }
                }
              }
            }
            i2 = 0;
            localObject1 = localObject2;
          }
        }
      }
    }
    Collections.sort(localArrayList);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getDesktopAppPositionInfo, end--info: ");
    ((StringBuilder)localObject1).append(localArrayList);
    QLog.d("DesktopDataManager", 2, ((StringBuilder)localObject1).toString());
    return localArrayList;
  }
  
  private int getLastFixAppIndex(List<DesktopItemInfo> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    if (((DesktopItemInfo)paramList.get(0) instanceof DesktopSearchInfo)) {
      i = 1;
    }
    int k;
    for (i = 0; j < paramList.size(); i = k)
    {
      DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)paramList.get(j);
      k = i;
      if (localDesktopItemInfo != null)
      {
        k = i;
        if (localDesktopItemInfo.isFixApp()) {
          k = j;
        }
      }
      if ((k > 1) && (localDesktopItemInfo != null) && (!localDesktopItemInfo.isFixApp())) {
        return k;
      }
      j += 1;
    }
    return i;
  }
  
  private int getMyAppFirstPos()
  {
    List localList = this.desktopItemInfos;
    if ((localList != null) && (localList.size() > 0))
    {
      int j = this.desktopItemInfos.size();
      int i = 0;
      while (i < j)
      {
        if (((DesktopItemInfo)this.desktopItemInfos.get(i)).getModuleType() == 3) {
          return i + 1;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static SharedPreferences getSharedPreferences(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface != null)
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localAppInterface.getAccount());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
    }
    return null;
  }
  
  private void handleEmptyModuleInStudyMode()
  {
    if (StudyModeManager.h()) {
      runOnMainThread(new DesktopDataManager.13(this));
    }
  }
  
  private DesktopOperationAppEntryInfo handleOperationAppEntryData(INTERFACE.StOperationApp paramStOperationApp)
  {
    saveOperationAppEntryData(paramStOperationApp);
    if (paramStOperationApp == null)
    {
      QLog.d("DesktopDataManager", 2, "[handleOperationAppEntryData] empty data.");
      return null;
    }
    DesktopOperationAppEntryInfo localDesktopOperationAppEntryInfo = new DesktopOperationAppEntryInfo();
    localDesktopOperationAppEntryInfo.mergePbData(paramStOperationApp);
    return localDesktopOperationAppEntryInfo;
  }
  
  private boolean hasGdtCookie(COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null)
    {
      if (paramStCommonExt.mapInfo == null) {
        return false;
      }
      int i = 0;
      while (i < paramStCommonExt.mapInfo.size())
      {
        if ("gdt_cookie".equals(((COMM.Entry)paramStCommonExt.mapInfo.get(i)).key.get())) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void insertEntity(DesktopItemInfo paramDesktopItemInfo)
  {
    ThreadManagerV2.excute(new DesktopDataManager.21(this, paramDesktopItemInfo), 32, null, true);
  }
  
  private void insertEntityWithBatch(List<DesktopItemInfo> paramList)
  {
    ThreadManagerV2.excute(new DesktopDataManager.22(this, paramList), 32, null, true);
  }
  
  private boolean isFixApp(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      if (paramMiniAppInfo.isSpecialMiniApp()) {
        return true;
      }
      DesktopOperationAppEntryInfo localDesktopOperationAppEntryInfo = this.mDesktopOperationAppEntryInfo;
      if ((localDesktopOperationAppEntryInfo != null) && (localDesktopOperationAppEntryInfo.getMiniAppInfo() != null) && (TextUtils.equals(paramMiniAppInfo.appId, this.mDesktopOperationAppEntryInfo.getMiniAppInfo().appId))) {
        return true;
      }
      return this.mRecommendListFixAppidSet.contains(paramMiniAppInfo.appId);
    }
    return false;
  }
  
  private int mappingPosition(int paramInt)
  {
    if (this.adapterItemInfos == null) {
      return paramInt;
    }
    int i = -1;
    int j = 0;
    while ((j < this.adapterItemInfos.size()) && (j <= paramInt))
    {
      Object localObject = (DesktopItemInfo)this.adapterItemInfos.get(j);
      if ((localObject instanceof DesktopAppGroupInfo))
      {
        localObject = (DesktopAppGroupInfo)localObject;
        if (((DesktopAppGroupInfo)localObject).datas != null)
        {
          i += ((DesktopAppGroupInfo)localObject).datas.size();
          break label89;
        }
      }
      i += 1;
      label89:
      j += 1;
    }
    return i;
  }
  
  private void processScrollModeData(List<DesktopItemInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    Object localObject;
    int k;
    for (int j = -1; i >= 0; j = k)
    {
      localObject = (DesktopItemInfo)paramList.get(i);
      k = j;
      if (((DesktopItemInfo)localObject).getModuleType() == paramInt) {
        if ((localObject instanceof DesktopAppInfo))
        {
          localArrayList.add(0, (DesktopAppInfo)localObject);
          paramList.remove(i);
          k = j;
        }
        else
        {
          k = j;
          if ((localObject instanceof DesktopAppModuleInfo)) {
            k = i;
          }
        }
      }
      i -= 1;
    }
    if (j >= 0)
    {
      if (localArrayList.size() > 0)
      {
        localObject = new DesktopAppGroupInfo(paramInt);
        ((DesktopAppGroupInfo)localObject).setData(localArrayList);
        paramList.add(j + 1, localObject);
        return;
      }
      if (paramInt != 3) {
        paramList.remove(j);
      }
    }
  }
  
  private void processUIData()
  {
    if (this.adapterItemInfos == null) {
      this.adapterItemInfos = new ArrayList();
    }
    this.adapterItemInfos.clear();
    List localList = this.desktopItemInfos;
    if (localList != null) {
      this.adapterItemInfos.addAll(localList);
    }
    processScrollModeData(this.adapterItemInfos, 1);
    processScrollModeData(this.adapterItemInfos, 2);
    processScrollModeData(this.adapterItemInfos, 3);
  }
  
  private List<DesktopItemInfo> query(AppInterface paramAppInterface)
  {
    Object localObject1 = paramAppInterface.getEntityManagerFactory().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      List localList1 = ((EntityManager)localObject1).query(DeskTopAppEntity.class, DeskTopAppEntity.class.getSimpleName(), false, null, null, null, null, null, null);
      List localList2 = queryCardModuleData(paramAppInterface);
      localObject1 = getDesktopAppPositionInfoFromSp();
      StringBuilder localStringBuilder = new StringBuilder();
      if (localList1 != null)
      {
        int i = localList1.size();
        paramAppInterface = new HashMap();
        Object localObject2 = localList1.iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DeskTopAppEntity)((Iterator)localObject2).next();
          if ((localObject3 != null) && (!TextUtils.isEmpty(((DeskTopAppEntity)localObject3).appId))) {
            paramAppInterface.put(((DeskTopAppEntity)localObject3).appId, localObject3);
          }
        }
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            DesktopDataManager.PositionItemInfo localPositionItemInfo = (DesktopDataManager.PositionItemInfo)((Iterator)localObject1).next();
            if (!TextUtils.isEmpty(localPositionItemInfo.appId))
            {
              localObject4 = (DeskTopAppEntity)paramAppInterface.get(localPositionItemInfo.appId);
              localObject2 = null;
              localObject3 = localObject2;
              if (localObject4 != null)
              {
                localObject3 = localObject2;
                if (((DeskTopAppEntity)localObject4).appInfo != null) {
                  localObject3 = ((DeskTopAppEntity)localObject4).createAppInfoFromBuffer(((DeskTopAppEntity)localObject4).appInfo);
                }
              }
              localObject2 = localObject1;
              if (localObject3 != null)
              {
                localList1.remove(localObject4);
                if (localPositionItemInfo.moduleType == 0)
                {
                  localObject2 = new DesktopSearchInfo((MiniAppInfo)localObject3, new ArrayList(), 0);
                  ((DesktopItemInfo)localObject2).deleteEnable = false;
                  ((DesktopItemInfo)localObject2).dragEnable = false;
                  ((DesktopItemInfo)localObject2).dropEnable = false;
                  this.hasPullSearchData = true;
                }
                else
                {
                  localObject2 = new DesktopAppInfo(localPositionItemInfo.moduleType, (MiniAppInfo)localObject3);
                  if (isFixApp((MiniAppInfo)localObject3))
                  {
                    ((DesktopItemInfo)localObject2).setIsFixApp(true);
                    ((DesktopItemInfo)localObject2).deleteEnable = false;
                    ((DesktopItemInfo)localObject2).dragEnable = false;
                    ((DesktopItemInfo)localObject2).dropEnable = false;
                  }
                  ((DesktopAppInfo)localObject2).setFromCache(true);
                }
                localArrayList.add(localObject2);
                localStringBuilder.append(((MiniAppInfo)localObject3).name);
                localStringBuilder.append(":");
                localStringBuilder.append(((MiniAppInfo)localObject3).appId);
                localStringBuilder.append(", ");
                localObject2 = localObject1;
              }
            }
            else
            {
              localObject2 = localObject1;
              if (!TextUtils.isEmpty(localPositionItemInfo.moduleTitle)) {
                if (localPositionItemInfo.moduleType == 4)
                {
                  localObject2 = localObject1;
                  if (localList2 != null)
                  {
                    localObject2 = localObject1;
                    if (localList2.size() > 0)
                    {
                      localObject3 = localList2.iterator();
                      for (;;)
                      {
                        localObject2 = localObject1;
                        if (!((Iterator)localObject3).hasNext()) {
                          break;
                        }
                        localObject2 = (DesktopCardEntity)((Iterator)localObject3).next();
                        if ((localObject2 != null) && (localPositionItemInfo.moduleType == ((DesktopCardEntity)localObject2).moduleType))
                        {
                          localObject4 = ((DesktopCardEntity)localObject2).createStModuleInfo();
                          if (localObject4 != null)
                          {
                            localArrayList.add(new DesktopRecommendModuleInfo(4, (INTERFACE.StModuleInfo)localObject4));
                            localStringBuilder.append(((DesktopCardEntity)localObject2).moduleType);
                            localStringBuilder.append(":");
                            localStringBuilder.append(((DesktopCardEntity)localObject2).title);
                            localStringBuilder.append(", ");
                          }
                        }
                      }
                    }
                  }
                }
                else
                {
                  localObject2 = localObject1;
                  Object localObject5;
                  if (localPositionItemInfo.moduleType == 5)
                  {
                    localObject4 = paramAppInterface;
                    localObject3 = localObject2;
                    if (localList2 == null) {
                      break label1276;
                    }
                    localObject4 = paramAppInterface;
                    localObject3 = localObject2;
                    if (localList2.size() <= 0) {
                      break label1276;
                    }
                    for (localObject1 = localList2.iterator();; localObject1 = localObject3)
                    {
                      localObject4 = paramAppInterface;
                      localObject3 = localObject2;
                      if (!((Iterator)localObject1).hasNext()) {
                        break;
                      }
                      localObject5 = (DesktopCardEntity)((Iterator)localObject1).next();
                      localObject3 = localObject1;
                      localObject4 = paramAppInterface;
                      if (localObject5 != null)
                      {
                        localObject3 = localObject1;
                        localObject4 = paramAppInterface;
                        if (localPositionItemInfo.moduleType == ((DesktopCardEntity)localObject5).moduleType)
                        {
                          INTERFACE.StModuleInfo localStModuleInfo = ((DesktopCardEntity)localObject5).createStModuleInfo();
                          localObject3 = localObject1;
                          localObject4 = paramAppInterface;
                          if (localStModuleInfo != null)
                          {
                            Object localObject6 = localStModuleInfo.ranks.get();
                            localObject3 = localObject1;
                            localObject4 = paramAppInterface;
                            if (localObject6 != null)
                            {
                              localObject3 = localObject1;
                              localObject4 = paramAppInterface;
                              if (!((List)localObject6).isEmpty())
                              {
                                localObject6 = ((List)localObject6).iterator();
                                for (;;)
                                {
                                  localObject3 = localObject1;
                                  localObject4 = paramAppInterface;
                                  if (!((Iterator)localObject6).hasNext()) {
                                    break;
                                  }
                                  localArrayList.add(new DesktopFriendsPkModuleInfo(5, localStModuleInfo, (INTERFACE.StFriendRanking)((Iterator)localObject6).next()));
                                  localStringBuilder.append(((DesktopCardEntity)localObject5).moduleType);
                                  localStringBuilder.append(":");
                                  localStringBuilder.append(((DesktopCardEntity)localObject5).title);
                                  localStringBuilder.append(", ");
                                }
                              }
                            }
                          }
                        }
                      }
                      paramAppInterface = (AppInterface)localObject4;
                    }
                  }
                  localObject3 = paramAppInterface;
                  if (localPositionItemInfo.moduleType == 6)
                  {
                    localObject1 = localObject3;
                    paramAppInterface = (AppInterface)localObject2;
                    if (localList2 == null) {
                      break label1282;
                    }
                    localObject1 = localObject3;
                    paramAppInterface = (AppInterface)localObject2;
                    if (localList2.size() <= 0) {
                      break label1282;
                    }
                    localObject4 = localList2.iterator();
                    for (;;)
                    {
                      localObject1 = localObject3;
                      paramAppInterface = (AppInterface)localObject2;
                      if (!((Iterator)localObject4).hasNext()) {
                        break;
                      }
                      paramAppInterface = (DesktopCardEntity)((Iterator)localObject4).next();
                      if ((paramAppInterface != null) && (localPositionItemInfo.moduleType == paramAppInterface.moduleType))
                      {
                        localObject1 = paramAppInterface.createStModuleInfo();
                        if (localObject1 != null)
                        {
                          localObject5 = new DesktopPopularModuleInfo(6);
                          ((DesktopPopularModuleInfo)localObject5).mergePbData((INTERFACE.StModuleInfo)localObject1);
                          localArrayList.add(localObject5);
                          localStringBuilder.append(paramAppInterface.moduleType);
                          localStringBuilder.append(":");
                          localStringBuilder.append(paramAppInterface.title);
                          localStringBuilder.append(", ");
                        }
                      }
                    }
                  }
                  if (localPositionItemInfo.moduleType == 7)
                  {
                    localObject1 = localObject3;
                    paramAppInterface = (AppInterface)localObject2;
                    if (localList2 == null) {
                      break label1282;
                    }
                    localObject1 = localObject3;
                    paramAppInterface = (AppInterface)localObject2;
                    if (localList2.size() <= 0) {
                      break label1282;
                    }
                    localObject4 = localList2.iterator();
                    for (;;)
                    {
                      localObject1 = localObject3;
                      paramAppInterface = (AppInterface)localObject2;
                      if (!((Iterator)localObject4).hasNext()) {
                        break;
                      }
                      paramAppInterface = (DesktopCardEntity)((Iterator)localObject4).next();
                      if ((paramAppInterface != null) && (localPositionItemInfo.moduleType == paramAppInterface.moduleType) && (!TextUtils.isEmpty(localPositionItemInfo.moduleTitle)) && (localPositionItemInfo.moduleTitle.equals(paramAppInterface.title)))
                      {
                        localObject1 = paramAppInterface.createStModuleInfo();
                        if (localObject1 != null)
                        {
                          localObject5 = new DesktopDittoInfo(7);
                          ((DesktopDittoInfo)localObject5).mergePbData((INTERFACE.StModuleInfo)localObject1);
                          localArrayList.add(localObject5);
                          localStringBuilder.append(paramAppInterface.moduleType);
                          localStringBuilder.append(":");
                          localStringBuilder.append(paramAppInterface.title);
                          localStringBuilder.append(", ");
                        }
                      }
                    }
                  }
                  localArrayList.add(new DesktopAppModuleInfo(localPositionItemInfo.moduleType, localPositionItemInfo.moduleTitle));
                  localObject1 = localObject3;
                  paramAppInterface = (AppInterface)localObject2;
                  break label1282;
                }
              }
            }
            localObject3 = localObject2;
            Object localObject4 = paramAppInterface;
            label1276:
            localObject1 = localObject4;
            paramAppInterface = (AppInterface)localObject3;
            label1282:
            localObject2 = localObject1;
            localObject1 = paramAppInterface;
            paramAppInterface = (AppInterface)localObject2;
          }
        }
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("query, before size=");
        paramAppInterface.append(i);
        paramAppInterface.append(", after size = ");
        paramAppInterface.append(localList1.size());
        paramAppInterface.append(", DB cache app List = [");
        paramAppInterface.append(localStringBuilder.toString());
        paramAppInterface.append("]");
        QLog.e("DesktopDataManager", 1, paramAppInterface.toString());
        if (localList1.size() < i)
        {
          deleteOldEntity(localList1);
          return localArrayList;
        }
      }
      else
      {
        QLog.e("DesktopDataManager", 1, "query, tempList is null.");
      }
    }
    return localArrayList;
  }
  
  private List<DesktopCardEntity> queryCardModuleData(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager();
    new ArrayList();
    if (paramAppInterface != null) {
      return paramAppInterface.query(DesktopCardEntity.class, DesktopCardEntity.class.getSimpleName(), false, null, null, null, null, null, null);
    }
    return null;
  }
  
  public static void recordMiniAppStart(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new DesktopDataManager.15(paramMiniAppInfo));
  }
  
  private void registerObserver()
  {
    ThreadManager.getSubThreadHandler().post(new DesktopDataManager.1(this));
  }
  
  private void removeAppFromMine(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("test: size: ");
    localStringBuilder.append(this.desktopItemInfos.size());
    QLog.d("DesktopDataManager", 2, localStringBuilder.toString());
    runOnMainThread(new DesktopDataManager.26(this, paramString));
  }
  
  private void reportToGdt(DesktopAdData paramDesktopAdData)
  {
    try
    {
      localObject = new JSONObject(paramDesktopAdData.miniAppInfo.amsAdInfo);
      localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.exposure_url.get());
      localStringBuilder.append("&slot=");
      localStringBuilder.append(paramDesktopAdData.position);
      localObject = localStringBuilder.toString();
      MiniAppUtils.reportMiniAppAd((String)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("gdtAdReport, exposure_url: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", name: ");
      localStringBuilder.append(paramDesktopAdData.miniAppInfo.name);
      QLog.d("DesktopDataManager", 1, localStringBuilder.toString());
      return;
    }
    catch (Exception paramDesktopAdData)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gdtAdReport exception: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramDesktopAdData));
      QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void reportToTianshu(DesktopAdData paramDesktopAdData)
  {
    if ((paramDesktopAdData.miniAppInfo != null) && (paramDesktopAdData.miniAppInfo.tianshuAdId != 0)) {
      try
      {
        Object localObject = new TianShuReportData();
        int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(CommonDataAdapter.a().c());
        localStringBuilder.append("_");
        localStringBuilder.append(i);
        ((TianShuReportData)localObject).b = localStringBuilder.toString();
        ((TianShuReportData)localObject).c = 1;
        ((TianShuReportData)localObject).p = 101;
        ((TianShuReportData)localObject).q = 1;
        ((TianShuReportData)localObject).o = i;
        ((TianShuReportData)localObject).h = String.valueOf(paramDesktopAdData.miniAppInfo.tianshuAdId);
        ((TianShuReportData)localObject).g = "tianshu.78";
        ((TianShuReportData)localObject).f = "tianshu.81";
        TianShuManager.getInstance().report((TianShuReportData)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportToTianshu() called with: data = [");
        ((StringBuilder)localObject).append(paramDesktopAdData);
        ((StringBuilder)localObject).append("]");
        QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
        return;
      }
      catch (Throwable paramDesktopAdData)
      {
        QLog.d("DesktopDataManager", 1, paramDesktopAdData, new Object[0]);
      }
    }
  }
  
  private void saveCardModuleData(List<INTERFACE.StModuleInfo> paramList)
  {
    ThreadManagerV2.excute(new DesktopDataManager.23(this, paramList), 32, null, true);
  }
  
  private void saveOperationAppEntryData(INTERFACE.StOperationApp paramStOperationApp)
  {
    ThreadManagerV2.excute(new DesktopDataManager.11(this, paramStOperationApp), 32, null, true);
  }
  
  private void sendUserAppListRequestV2(COMM.StCommonExt paramStCommonExt, ArrayList<RecommendAppInfo> paramArrayList, GetAppListV2Scene paramGetAppListV2Scene)
  {
    ThreadManager.excute(new DesktopDataManager.2(this, paramStCommonExt, paramArrayList, paramGetAppListV2Scene), 128, null, false);
  }
  
  private void sendUserAppListRequestV2(COMM.StCommonExt paramStCommonExt, ArrayList<RecommendAppInfo> paramArrayList, ArrayList<Integer> paramArrayList1, GetAppListV2Scene paramGetAppListV2Scene)
  {
    Object localObject = this.desktopItemInfos;
    int i;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendUserAppListRequestV2, cacheValue: ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", recommendAppList size: ");
    ((StringBuilder)localObject).append(paramArrayList.size());
    QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
    MiniAppCmdUtil.getInstance().getUserAppListV2(paramStCommonExt, paramGetAppListV2Scene, paramArrayList, paramArrayList1, new ArrayList(), new ArrayList(), i, new DesktopDataManager.3(this));
    paramArrayList = MiniAppUtils.getAppInterface();
    if (paramArrayList != null)
    {
      paramStCommonExt = paramArrayList.getPreferences();
      paramArrayList1 = new StringBuilder();
      paramArrayList1.append(paramArrayList.getCurrentAccountUin());
      paramArrayList1.append("key_update_applets_notification_setting_time");
      paramArrayList1 = paramArrayList1.toString();
      long l1 = paramStCommonExt.getLong(paramArrayList1, 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 > QzoneConfig.getInstance().getConfig("qqminiapp", "getappletsnotificationsettinginterval", 1L) * 1000L)
      {
        paramArrayList = (AppletsHandler)paramArrayList.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
        if (paramArrayList != null)
        {
          paramArrayList.a();
          paramStCommonExt.edit().putLong(paramArrayList1, l2).commit();
        }
      }
    }
  }
  
  private static void setDesktopAppPositionInfoToSp(List<DesktopItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    ThreadManager.executeOnFileThread(new DesktopDataManager.6(localArrayList));
  }
  
  private static void setGetRecommendIntervalTime(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGetRecommendIntervalTime : ");
    localStringBuilder.append(paramLong);
    QLog.d("DesktopDataManager-Recommend", 2, localStringBuilder.toString());
    if (paramLong > 0L) {
      StorageUtil.getPreference().edit().putLong("key_mini_app_recommend_time", paramLong).apply();
    }
  }
  
  private void updateCardModuleInfo(List<INTERFACE.StModuleInfo> paramList)
  {
    runOnMainThread(new DesktopDataManager.9(this, paramList));
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
      QLog.d("DesktopDataManager", 2, paramEntityManager.toString());
    }
    return false;
  }
  
  private void updateMiniAppStartRecord(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (this.desktopItemInfos != null))
    {
      if (isFixApp(paramMiniAppInfo)) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int k;
      for (int j = -1; i < this.desktopItemInfos.size(); j = k)
      {
        localObject = (DesktopItemInfo)this.desktopItemInfos.get(i);
        k = j;
        if ((localObject instanceof DesktopAppInfo))
        {
          k = j;
          if (((DesktopItemInfo)localObject).getModuleType() == 1)
          {
            localArrayList.add(localObject);
            k = j;
            if (j == -1) {
              k = i;
            }
          }
        }
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        localObject = null;
        i = 0;
        while (i < localArrayList.size())
        {
          DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)localArrayList.get(i);
          DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)localDesktopItemInfo;
          if ((paramMiniAppInfo.appId.equals(localDesktopAppInfo.mMiniAppInfo.appId)) && (paramMiniAppInfo.verType == localDesktopAppInfo.mMiniAppInfo.verType))
          {
            this.desktopItemInfos.remove(localDesktopItemInfo);
            localObject = localDesktopItemInfo;
            i = 1;
            break label237;
          }
          i += 1;
        }
        i = 0;
        label237:
        if (i != 0)
        {
          if ((j != -1) && (localObject != null))
          {
            ((DesktopAppInfo)localObject).mMiniAppInfo = paramMiniAppInfo;
            this.desktopItemInfos.add(j, localObject);
          }
        }
        else
        {
          localObject = new DesktopAppInfo(1, paramMiniAppInfo);
          if (j != -1)
          {
            if (paramMiniAppInfo.isLimitedAccessApp()) {
              ((DesktopItemInfo)localObject).dragEnable = false;
            }
            this.desktopItemInfos.add(j, localObject);
            insertEntity((DesktopItemInfo)localObject);
          }
        }
      }
      else
      {
        paramMiniAppInfo = new DesktopAppInfo(1, paramMiniAppInfo);
        this.desktopItemInfos.add(paramMiniAppInfo);
        insertEntity(paramMiniAppInfo);
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insertAppInfo error app info is invalid, appInfo = ");
    ((StringBuilder)localObject).append(paramMiniAppInfo);
    QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private void updateRecommendExposureSp()
  {
    ArrayList localArrayList = new ArrayList(this.mRecommendExposureList);
    ThreadManager.getSubThreadHandler().post(new DesktopDataManager.25(this, localArrayList));
  }
  
  private void updateRedDotData(MiniAppRedDotEntity paramMiniAppRedDotEntity)
  {
    if (paramMiniAppRedDotEntity == null) {
      return;
    }
    ThreadManagerV2.excute(new DesktopDataManager.32(this, paramMiniAppRedDotEntity), 32, null, true);
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
      QLog.d("DesktopDataManager", 2, paramEntityManager.toString());
    }
    return false;
  }
  
  private void useDefaultRecommendApps()
  {
    ThreadManager.getSubThreadHandler().post(new DesktopDataManager.17(this));
  }
  
  public void addAppToMyApp(MiniAppInfo paramMiniAppInfo)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    runOnMainThread(new DesktopDataManager.29(this, paramMiniAppInfo));
  }
  
  public void asyncQueryMiniAppPushRedDotData()
  {
    ThreadManagerV2.excute(new DesktopDataManager.34(this), 32, null, true);
  }
  
  public void checkMiniAppAdReport(MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    Object localObject = (DesktopAdData)this.mAdReportMap.get(paramMiniAppInfo.appId);
    if ((localObject != null) && (((DesktopAdData)localObject).position != paramInt) && (((DesktopAdData)localObject).hasReport())) {
      this.mAdReportMap.remove(paramMiniAppInfo.appId);
    }
    if (this.mAdReportMap.get(paramMiniAppInfo.appId) == null)
    {
      localObject = new DesktopAdData(paramInt, false, paramMiniAppInfo);
      this.mAdReportMap.put(paramMiniAppInfo.appId, localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("collectAdReport, name: ");
      ((StringBuilder)localObject).append(paramMiniAppInfo.name);
      QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void clearRecommendExposureList()
  {
    ThreadManager.getUIHandler().post(new DesktopDataManager.24(this));
  }
  
  public MiniAppInfo findMiniApp(String paramString, int paramInt)
  {
    Object localObject1 = this.desktopItemInfos;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = this.desktopItemInfos.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (DesktopItemInfo)((Iterator)localObject1).next();
        if ((localObject2 instanceof DesktopAppInfo))
        {
          localObject2 = (DesktopAppInfo)localObject2;
          if ((((DesktopAppInfo)localObject2).mMiniAppInfo != null) && (((DesktopAppInfo)localObject2).mMiniAppInfo.appId.equals(paramString)) && (((DesktopAppInfo)localObject2).mMiniAppInfo.verType == paramInt)) {
            return ((DesktopAppInfo)localObject2).mMiniAppInfo;
          }
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("findMiniApp, failed to find Miniapp, appId = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public MiniAppInfo findTopMiniApp(String paramString, int paramInt)
  {
    Object localObject1 = this.desktopItemInfos;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = this.desktopItemInfos.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (DesktopItemInfo)((Iterator)localObject1).next();
        if (((localObject2 instanceof DesktopAppInfo)) && (((DesktopItemInfo)localObject2).getModuleType() == 3))
        {
          localObject2 = (DesktopAppInfo)localObject2;
          if ((((DesktopAppInfo)localObject2).mMiniAppInfo != null) && (((DesktopAppInfo)localObject2).mMiniAppInfo.appId.equals(paramString)) && (((DesktopAppInfo)localObject2).mMiniAppInfo.verType == paramInt)) {
            return ((DesktopAppInfo)localObject2).mMiniAppInfo;
          }
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("findMiniApp, failed to find Miniapp, appId = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public List<DesktopItemInfo> getData()
  {
    checkData(false);
    return this.adapterItemInfos;
  }
  
  public DesktopOperationAppEntryInfo getDeskTopOperationAppEntryInfo()
  {
    return this.mDesktopOperationAppEntryInfo;
  }
  
  public DesktopDataManager.HongBaoResBuilder getHongBaoResBuilder()
  {
    return this.mHongBaoResBuilder;
  }
  
  public COMM.StCommonExt getPullDownEntryExtInfo()
  {
    return this.mExtInfo;
  }
  
  public ArrayList<RecommendAppInfo> getRecommendExposureList()
  {
    Iterator localIterator = this.mRecommendExposureList.iterator();
    while (localIterator.hasNext())
    {
      RecommendAppInfo localRecommendAppInfo = (RecommendAppInfo)localIterator.next();
      if (localRecommendAppInfo != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRecommendExposureList : ");
        localStringBuilder.append(localRecommendAppInfo.toString());
        QLog.d("DesktopDataManager-Recommend", 2, localStringBuilder.toString());
      }
    }
    return this.mRecommendExposureList;
  }
  
  public Map<String, Integer> getRedDotData()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      localObject1 = this.desktopItemInfos;
      if ((localObject1 == null) || (i >= ((List)localObject1).size())) {
        break;
      }
      localObject1 = (DesktopItemInfo)this.desktopItemInfos.get(i);
      if (((localObject1 instanceof DesktopAppInfo)) && ((((DesktopItemInfo)localObject1).getModuleType() == 1) || (((DesktopItemInfo)localObject1).getModuleType() == 3) || (((DesktopItemInfo)localObject1).getModuleType() == 2)))
      {
        localObject1 = (DesktopAppInfo)localObject1;
        if (((DesktopAppInfo)localObject1).mMiniAppInfo != null) {
          localArrayList.add(((DesktopAppInfo)localObject1).mMiniAppInfo);
        }
      }
      i += 1;
    }
    if (localArrayList.size() <= 0) {
      return localHashMap;
    }
    boolean bool = MiniAppConfProcessor.h();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getRedDotData, showPublicAccountRedDot: ");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("DesktopDataManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2 = MiniAppUtils.getAppInterface();
    if (localObject2 != null) {
      localObject1 = ((AppletsFolderManager)((AppInterface)localObject2).getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).g();
    }
    int j = 0;
    while (j < localArrayList.size())
    {
      localObject2 = (MiniAppInfo)localArrayList.get(j);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject2).appId)))
      {
        Object localObject3;
        if ((localObject1 != null) && (((Set)localObject1).contains(((MiniAppInfo)localObject2).appId)))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getRedDotData, unReceiveMsgAppids ignore appid: ");
            ((StringBuilder)localObject3).append(((MiniAppInfo)localObject2).appId);
            QLog.d("DesktopDataManager", 2, ((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          localObject3 = (Integer)this.mPublicAccountRedDotMap.get(((MiniAppInfo)localObject2).appId);
          Integer localInteger = (Integer)this.mPushRedDotMap.get(((MiniAppInfo)localObject2).appId);
          if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0) && (bool)) {
            i = ((Integer)localObject3).intValue() + 0;
          } else {
            i = 0;
          }
          int k = i;
          if (localInteger != null)
          {
            k = i;
            if (localInteger.intValue() > 0) {
              k = i + localInteger.intValue();
            }
          }
          localHashMap.put(((MiniAppInfo)localObject2).appId, Integer.valueOf(k));
        }
      }
      j += 1;
    }
    return localHashMap;
  }
  
  public long getRefreshInterval()
  {
    return this.mRefreshInternal;
  }
  
  public int getTopMiniAppNumber()
  {
    Object localObject = this.desktopItemInfos;
    int k = 0;
    int i = 0;
    int j = k;
    if (localObject != null)
    {
      j = k;
      if (((List)localObject).size() > 0)
      {
        localObject = this.desktopItemInfos.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)((Iterator)localObject).next();
          if (((localDesktopItemInfo instanceof DesktopAppInfo)) && (localDesktopItemInfo.getModuleType() == 3)) {
            i += 1;
          }
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTopMiniAppNumber : ");
    ((StringBuilder)localObject).append(j);
    QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
    return j;
  }
  
  public int getTopModuleInfoIndex()
  {
    Object localObject = this.adapterItemInfos;
    if (localObject == null) {
      return -1;
    }
    localObject = ((List)localObject).iterator();
    int i = -1;
    while (((Iterator)localObject).hasNext())
    {
      DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)((Iterator)localObject).next();
      int j = i + 1;
      i = j;
      if ((localDesktopItemInfo instanceof DesktopAppModuleInfo))
      {
        i = j;
        if (((DesktopAppModuleInfo)localDesktopItemInfo).getModuleType() == 3) {
          return j;
        }
      }
    }
    return -1;
  }
  
  public boolean hasPullSearchData()
  {
    return this.hasPullSearchData;
  }
  
  public void initLocalCacheData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initLocalCacheData, hasInitData: ");
    localStringBuilder.append(this.hasInitData);
    QLog.d("DesktopDataManager", 2, localStringBuilder.toString());
    if (!this.hasInitData)
    {
      ThreadManager.excute(this.initLocalDataRunnable, 32, null, false);
      ThreadManager.excute(this.deleteErrorSpFile, 64, null, false);
    }
  }
  
  public void loadMoreMyApp(COMM.StCommonExt paramStCommonExt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(3));
    MiniAppCmdUtil.getInstance().getUserAppListV2(paramStCommonExt, GetAppListV2Scene.UN_KNOWN, null, localArrayList, new ArrayList(), new ArrayList(), 0, new DesktopDataManager.5(this));
  }
  
  public void loadMoreRecentIfNeed()
  {
    int i = this.desktopItemInfos.size() - 1;
    int k;
    for (int j = 0; i >= 0; j = k)
    {
      k = j;
      if (this.desktopItemInfos.get(i) != null)
      {
        k = j;
        if (((DesktopItemInfo)this.desktopItemInfos.get(i)).getModuleType() == 1)
        {
          k = j;
          if ((this.desktopItemInfos.get(i) instanceof DesktopAppInfo)) {
            k = j + 1;
          }
        }
      }
      i -= 1;
    }
    if ((j > 0) && (j < 4) && (this.canLoadMoreRecent) && (!this.isLoadingMoreRecent))
    {
      this.isLoadingMoreRecent = true;
      QLog.i("DesktopDataManager", 1, "loadMoreRencentApp start");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(1));
      MiniAppCmdUtil.getInstance().getUserAppListV2(this.mMoreRencentExtInfo, GetAppListV2Scene.RECENT, null, localArrayList, new ArrayList(), new ArrayList(), 0, new DesktopDataManager.14(this));
    }
  }
  
  public void miniAppAdReport()
  {
    if (this.mAdReportMap.size() <= 0) {
      return;
    }
    Iterator localIterator = this.mAdReportMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      DesktopAdData localDesktopAdData = (DesktopAdData)((Map.Entry)localIterator.next()).getValue();
      if ((localDesktopAdData != null) && (!localDesktopAdData.hasReport))
      {
        localDesktopAdData.hasReport = true;
        if (localDesktopAdData.miniAppInfo != null) {
          if (localDesktopAdData.miniAppInfo.tianshuAdId != 0) {
            reportToTianshu(localDesktopAdData);
          } else {
            reportToGdt(localDesktopAdData);
          }
        }
      }
    }
  }
  
  public void onDataDirtyFromAdapter(int paramInt, List<DesktopItemInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    int i = 0;
    while (i < this.desktopItemInfos.size())
    {
      if (((this.desktopItemInfos.get(i) instanceof DesktopAppModuleInfo)) && (((DesktopItemInfo)this.desktopItemInfos.get(i)).mModuleType == paramInt)) {
        break label77;
      }
      i += 1;
    }
    i = -1;
    label77:
    if (i >= 0)
    {
      int j = this.desktopItemInfos.size() - 1;
      while (j > i)
      {
        if ((this.desktopItemInfos.get(j) != null) && (((DesktopItemInfo)this.desktopItemInfos.get(j)).mModuleType == paramInt)) {
          this.desktopItemInfos.remove(j);
        }
        j -= 1;
      }
      this.desktopItemInfos.addAll(i + 1, paramList);
      setDesktopAppPositionInfoToSp(this.desktopItemInfos);
    }
  }
  
  public void onDestroy()
  {
    if (this.mDataChangeListener != null) {
      this.mDataChangeListener = null;
    }
  }
  
  public void onItemChanged(int paramInt, DesktopItemInfo paramDesktopItemInfo)
  {
    List localList = this.adapterItemInfos;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size()) && (((DesktopItemInfo)this.adapterItemInfos.get(paramInt) instanceof DesktopEmptyGuideInfo)))
    {
      this.desktopItemInfos.add(paramDesktopItemInfo);
      setDesktopAppPositionInfoToSp(this.desktopItemInfos);
      return;
    }
    paramInt = mappingPosition(paramInt);
    localList = this.desktopItemInfos;
    if ((localList != null) && (paramInt >= 0))
    {
      if (paramInt >= localList.size()) {
        return;
      }
      this.desktopItemInfos.set(paramInt, paramDesktopItemInfo);
      setDesktopAppPositionInfoToSp(this.desktopItemInfos);
    }
  }
  
  @Deprecated
  public void onItemDeleted(int paramInt1, int paramInt2)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    int i = mappingPosition(paramInt1);
    ArrayList localArrayList = new ArrayList();
    if (paramInt2 == 1)
    {
      localArrayList.add((DesktopItemInfo)this.desktopItemInfos.remove(i));
    }
    else if ((paramInt2 > 1) && (i >= 0))
    {
      paramInt1 = paramInt2 + i;
      if (paramInt1 < this.desktopItemInfos.size()) {
        while (paramInt1 >= i)
        {
          localArrayList.add((DesktopItemInfo)this.desktopItemInfos.remove(paramInt1));
          paramInt1 -= 1;
        }
      }
    }
    checkData(true);
    deleteEntity(localArrayList);
  }
  
  public void onItemDeleted(DesktopAppInfo paramDesktopAppInfo)
  {
    if ((this.desktopItemInfos != null) && (paramDesktopAppInfo != null))
    {
      if (paramDesktopAppInfo.mMiniAppInfo == null) {
        return;
      }
      int i = this.desktopItemInfos.size() - 1;
      while (i >= 0)
      {
        DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)this.desktopItemInfos.get(i);
        if ((localDesktopItemInfo.getModuleType() == paramDesktopAppInfo.getModuleType()) && ((localDesktopItemInfo instanceof DesktopAppInfo)) && (paramDesktopAppInfo.mMiniAppInfo.equals(((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo)))
        {
          this.desktopItemInfos.remove(i);
          break;
        }
        i -= 1;
      }
      checkData(true);
      deleteEntity(paramDesktopAppInfo.mMiniAppInfo);
      deleteMiniAppCache(paramDesktopAppInfo.mMiniAppInfo);
    }
  }
  
  @Deprecated
  public void onItemInserted(int paramInt, List<DesktopAppInfo> paramList)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    paramInt = mappingPosition(paramInt);
    this.desktopItemInfos.addAll(paramInt, paramList);
    setDesktopAppPositionInfoToSp(this.desktopItemInfos);
  }
  
  @Deprecated
  public void onItemMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    paramInt1 = mappingPosition(paramInt1);
    paramInt3 = mappingPosition(paramInt2);
    paramInt2 = paramInt1;
    if (paramInt1 < paramInt3) {
      while (paramInt1 < paramInt3)
      {
        List localList = this.desktopItemInfos;
        paramInt2 = paramInt1 + 1;
        Collections.swap(localList, paramInt1, paramInt2);
        paramInt1 = paramInt2;
      }
    }
    while (paramInt2 > paramInt3)
    {
      Collections.swap(this.desktopItemInfos, paramInt2, paramInt2 - 1);
      paramInt2 -= 1;
    }
    setDesktopAppPositionInfoToSp(this.desktopItemInfos);
  }
  
  public ArrayList<RecommendAppInfo> parseRecommendExposureFromSp()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("app_recommend_exposure");
    localArrayList = new ArrayList();
    if (localSharedPreferences != null) {
      try
      {
        Object localObject1 = localSharedPreferences.getString("app_recommend_exposure", null);
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).split(";");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int i = 0;
            while (i < localObject1.length)
            {
              Object localObject2 = localObject1[i];
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject2 = ((String)localObject2).split("_");
                if ((localObject2 != null) && (localObject2.length == 3)) {
                  localArrayList.add(new RecommendAppInfo(localObject2[0], Integer.parseInt(localObject2[1]), Long.parseLong(localObject2[2])));
                }
              }
              i += 1;
            }
          }
        }
        return localArrayList;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DesktopDataManager-Recommend", 1, "parseRecommendExposureFromSp error.", localThrowable);
        localSharedPreferences.edit().clear().apply();
      }
    }
  }
  
  public void removeAppByModuleType(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeAppByModuleType appId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", moduleType: ");
    localStringBuilder.append(paramInt);
    QLog.d("DesktopDataManager", 2, localStringBuilder.toString());
    runOnMainThread(new DesktopDataManager.27(this, paramInt));
  }
  
  public void removeRedDotData(String paramString)
  {
    this.mPublicAccountRedDotMap.remove(paramString);
    this.mPushRedDotMap.remove(paramString);
    deleteRedDotDataFromDB(paramString);
  }
  
  public void runOnMainThread(Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  public void sendDropDownAppListRequestAsync(GetAppListV2Scene paramGetAppListV2Scene)
  {
    Object localObject2 = this.mExtInfo;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new COMM.StCommonExt();
    }
    localObject2 = new ArrayList();
    if (this.mRecommendExposureList.size() > 0) {
      ((ArrayList)localObject2).addAll(this.mRecommendExposureList);
    }
    sendUserAppListRequestV2((COMM.StCommonExt)localObject1, (ArrayList)localObject2, paramGetAppListV2Scene);
  }
  
  public void sendModuleRequest(ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2, ArrayList<String> paramArrayList, GetAppListV2Scene paramGetAppListV2Scene)
  {
    MiniAppCmdUtil.getInstance().getUserAppListV2(null, paramGetAppListV2Scene, null, paramArrayList1, paramArrayList2, paramArrayList, 0, new DesktopDataManager.4(this));
  }
  
  public void setDataChangeListener(DesktopDataManager.DataChangeListener paramDataChangeListener)
  {
    this.mDataChangeListener = paramDataChangeListener;
  }
  
  public void setHongBaoResBuilder(DesktopDataManager.HongBaoResBuilder paramHongBaoResBuilder)
  {
    this.mHongBaoResBuilder = paramHongBaoResBuilder;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHongBaoResBuilder : ");
    localStringBuilder.append(paramHongBaoResBuilder);
    QLog.i("DesktopDataManager", 2, localStringBuilder.toString());
    MiniAppUtils.notifyUpdateHongBaoRes();
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
    QLog.d("DesktopDataManager", 1, "setMiniAppNoticeRedDotData, data is null or data size = 0");
    clearNoticeRedDotData();
    MiniAppUtils.updateMiniAppList(101);
  }
  
  public void setMiniAppPushRedDotData(MiniAppRedDotEntity paramMiniAppRedDotEntity)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setMiniAppPushRedDotData, data: ");
    ((StringBuilder)localObject1).append(paramMiniAppRedDotEntity);
    QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject1).toString());
    if ((paramMiniAppRedDotEntity != null) && (!TextUtils.isEmpty(paramMiniAppRedDotEntity.appId)))
    {
      localObject1 = this.desktopItemInfos;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        localObject1 = this.desktopItemInfos.iterator();
        int j;
        Object localObject2;
        do
        {
          do
          {
            boolean bool = ((Iterator)localObject1).hasNext();
            j = 0;
            if (!bool) {
              break;
            }
            localObject2 = (DesktopItemInfo)((Iterator)localObject1).next();
          } while ((!(localObject2 instanceof DesktopAppInfo)) || ((((DesktopItemInfo)localObject2).getModuleType() != 1) && (((DesktopItemInfo)localObject2).getModuleType() != 3) && (((DesktopItemInfo)localObject2).getModuleType() != 2)));
          localObject2 = (DesktopAppInfo)localObject2;
        } while ((((DesktopAppInfo)localObject2).mMiniAppInfo == null) || (!paramMiniAppRedDotEntity.appId.equals(((DesktopAppInfo)localObject2).mMiniAppInfo.appId)));
        int i = 1;
        break label188;
        i = 0;
        label188:
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DesktopDataManager", 1, "setMiniAppPushRedDotData, current app is not opened");
          }
          return;
        }
        this.mPushRedDotMap.put(paramMiniAppRedDotEntity.appId, Integer.valueOf(paramMiniAppRedDotEntity.wnsPushRedDotNum));
        localObject1 = (Integer)this.mPublicAccountRedDotMap.get(paramMiniAppRedDotEntity.appId);
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (((Integer)localObject1).intValue() > 0) {
            i = ((Integer)localObject1).intValue();
          }
        }
        updateRedDotData(new MiniAppRedDotEntity(paramMiniAppRedDotEntity.appId, i, paramMiniAppRedDotEntity.wnsPushRedDotNum));
        MiniAppUtils.updateMiniAppList(101);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DesktopDataManager", 1, "setMiniAppPushRedDotData, current app is not opened");
      }
    }
  }
  
  public void updateData(List<INTERFACE.StUserAppInfo> paramList, List<INTERFACE.StModuleInfo> paramList1, INTERFACE.StSearchModuleInfo paramStSearchModuleInfo, INTERFACE.StOperationApp paramStOperationApp)
  {
    convertData(paramList, paramList1, paramStSearchModuleInfo, paramStOperationApp);
  }
  
  public void updateDesktopData(List<DesktopItemInfo> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.desktopItemInfos = new ArrayList(paramList);
      if (paramBoolean)
      {
        paramList = this.mDataChangeListener;
        if (paramList != null) {
          paramList.onDataChanged();
        }
      }
    }
  }
  
  public void updateEntryList(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("command");
    if ("addAppToMine".equals(str))
    {
      paramJSONObject.optString("appId");
      addAppToMyApp(MiniAppInfo.createMiniAppInfo(paramJSONObject));
      return;
    }
    if ("deleteApp".equals(str))
    {
      deleteApp(paramJSONObject.optString("appId"));
      return;
    }
    if ("exchangeAppOrder".equals(str))
    {
      str = paramJSONObject.optString("appId");
      int i = paramJSONObject.optInt("new_order");
      changeMyAppOrder(str, paramJSONObject.optInt("old_order"), i);
      return;
    }
    if ("removeAppFromMine".equals(str)) {
      removeAppFromMine(paramJSONObject.optString("appId"));
    }
  }
  
  public void updateMiniHBBanner(HBEntryBannerData paramHBEntryBannerData)
  {
    this.mHBEntryBannerData = paramHBEntryBannerData;
    paramHBEntryBannerData = this.mHBEntryDataAddedState;
    boolean bool;
    if (this.mHBEntryBannerData != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramHBEntryBannerData.set(bool);
    runOnMainThread(new DesktopDataManager.36(this));
  }
  
  public void updateModuleInfo(INTERFACE.StModuleInfo paramStModuleInfo)
  {
    runOnMainThread(new DesktopDataManager.10(this, paramStModuleInfo));
  }
  
  public void updateModuleMyApp(MiniAppInfo paramMiniAppInfo)
  {
    runOnMainThread(new DesktopDataManager.20(this, paramMiniAppInfo));
  }
  
  public void updateRecommendExposureNumber(String paramString)
  {
    Object localObject = this.mRecommendExposureList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.mRecommendExposureList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecommendAppInfo localRecommendAppInfo = (RecommendAppInfo)((Iterator)localObject).next();
        if ((localRecommendAppInfo != null) && (localRecommendAppInfo.appId != null) && (localRecommendAppInfo.appId.equals(paramString))) {
          localRecommendAppInfo.exposuredNum += 1;
        }
      }
    }
    updateRecommendExposureSp();
  }
  
  public void useLocalDataIfRequestFailed()
  {
    ThreadManager.excute(new DesktopDataManager.16(this), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager
 * JD-Core Version:    0.7.0.1
 */