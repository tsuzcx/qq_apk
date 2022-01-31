package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StFriendRanking;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StSearchModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import ahfz;
import ahjz;
import ajtg;
import ajyc;
import akwq;
import amtc;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import aukm;
import aukn;
import auko;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.DesktopAdData;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import yxr;

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
  private Runnable deleteErrorSpFile = new DesktopDataManager.31(this);
  private List<DesktopItemInfo> desktopItemInfos = new ArrayList();
  private DesktopSpringEntryInfo desktopSpringEntryInfo;
  private volatile boolean hasInitData;
  private volatile boolean hasPullSearchData;
  private Runnable initLocalDataRunnable = new DesktopDataManager.15(this);
  private boolean isLoadingMoreRecent;
  private ConcurrentHashMap<String, DesktopAdData> mAdReportMap = new ConcurrentHashMap();
  private DesktopDataManager.DataChangeListener mDataChangeListener;
  private volatile COMM.StCommonExt mExtInfo;
  private volatile DesktopDataManager.HongBaoResBuilder mHongBaoResBuilder;
  private volatile COMM.StCommonExt mMoreRencentExtInfo;
  private ConcurrentHashMap<String, Integer> mPublicAccountRedDotMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> mPushRedDotMap = new ConcurrentHashMap();
  private ArrayList<RecommendAppInfo> mRecommendExposureList = new ArrayList();
  private volatile int mRedDataState = -1;
  private volatile long mRefreshInternal = 3600L;
  private volatile int mRequestCount;
  private ajtg redDotObserver = new DesktopDataManager.27(this);
  
  public DesktopDataManager(QQAppInterface paramQQAppInterface)
  {
    QLog.d("DesktopDataManager", 1, "DesktopDataManager init.");
    registerObserver();
  }
  
  private void addAppToMyApp(MiniAppInfo paramMiniAppInfo)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    runOnMainThread(new DesktopDataManager.25(this, paramMiniAppInfo));
  }
  
  private void appendMyAppData(List<INTERFACE.StModuleInfo> paramList)
  {
    runOnMainThread(new DesktopDataManager.6(this, paramList));
  }
  
  private void appendRecentAppData(List<INTERFACE.StModuleInfo> paramList)
  {
    runOnMainThread(new DesktopDataManager.7(this, paramList));
  }
  
  private static String buildDeskTopAppInfoString(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position:").append(paramInt1).append("_").append("moduletype:").append(paramInt2).append("_").append("appid:").append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String buildDeskTopModuleInfoString(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position:").append(paramInt1).append("_").append("moduletype:").append(paramInt2).append("_").append("title:").append(paramString);
    return localStringBuilder.toString();
  }
  
  private void changeMyAppOrder(String paramString, int paramInt1, int paramInt2)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    runOnMainThread(new DesktopDataManager.26(this, paramInt1, paramInt2));
  }
  
  private void checkAddSpringBanner()
  {
    if (this.adapterItemInfos != null)
    {
      localObject = MiniAppUtils.getAppInterface();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    Object localObject = (ahfz)((AppInterface)localObject).getManager(342);
    Iterator localIterator = this.adapterItemInfos.iterator();
    DesktopItemInfo localDesktopItemInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localDesktopItemInfo = (DesktopItemInfo)localIterator.next();
    } while (!(localDesktopItemInfo instanceof DesktopSpringEntryInfo));
    for (int i = this.adapterItemInfos.indexOf(localDesktopItemInfo);; i = -1)
    {
      if (i != -1) {
        this.adapterItemInfos.remove(i);
      }
      if ((((ahfz)localObject).h()) && (this.desktopSpringEntryInfo != null))
      {
        localIterator = this.adapterItemInfos.iterator();
        while (localIterator.hasNext())
        {
          localDesktopItemInfo = (DesktopItemInfo)localIterator.next();
          if ((localDesktopItemInfo instanceof DesktopSearchInfo))
          {
            i = this.adapterItemInfos.indexOf(localDesktopItemInfo);
            this.adapterItemInfos.add(i + 1, this.desktopSpringEntryInfo);
          }
        }
        if (!this.adapterItemInfos.contains(this.desktopSpringEntryInfo)) {
          this.adapterItemInfos.add(0, this.desktopSpringEntryInfo);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("DesktopDataManager", 1, "getData...isShowEntryBanner:" + ((ahfz)localObject).h() + ",desktopSpringEntryInfo" + this.desktopSpringEntryInfo);
      return;
    }
  }
  
  private void checkData(boolean paramBoolean)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    label25:
    int j;
    if (this.adapterItemInfos != null)
    {
      i = this.adapterItemInfos.size();
      processUIData();
      if (this.adapterItemInfos == null) {
        break label133;
      }
      j = this.adapterItemInfos.size();
      label46:
      if (j == i) {
        break label138;
      }
    }
    int i1;
    label133:
    label138:
    for (int m = 1;; m = 0)
    {
      i1 = getTopModuleInfoIndex();
      if (i1 >= 0) {
        break label144;
      }
      this.adapterItemInfos.add(new DesktopAppModuleInfo(3, ajyc.a(2131703127)));
      this.adapterItemInfos.add(new DesktopEmptyGuideInfo(3));
      if ((!paramBoolean) || (this.mDataChangeListener == null)) {
        break;
      }
      this.mDataChangeListener.onDataChanged();
      return;
      i = 0;
      break label25;
      j = 0;
      break label46;
    }
    label144:
    int n = -1;
    int k = 0;
    int i = i1;
    if (i < this.adapterItemInfos.size())
    {
      DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)this.adapterItemInfos.get(i);
      j = k;
      if ((localDesktopItemInfo instanceof DesktopAppInfo))
      {
        j = k;
        if (localDesktopItemInfo.mModuleType == 3) {
          j = k + 1;
        }
      }
      if (((localDesktopItemInfo instanceof DesktopAppGroupInfo)) && (localDesktopItemInfo.mModuleType == 3)) {
        k = j + 1;
      }
      for (;;)
      {
        i += 1;
        break;
        k = j;
        if ((localDesktopItemInfo instanceof DesktopEmptyGuideInfo))
        {
          n = i;
          k = j;
        }
      }
    }
    if ((k == 0) && (n < 0))
    {
      this.adapterItemInfos.add(i1 + 1, new DesktopEmptyGuideInfo(3));
      if ((paramBoolean) && (this.mDataChangeListener != null)) {
        this.mDataChangeListener.onDataChanged();
      }
    }
    for (;;)
    {
      setDesktopAppPositionInfoToSp(this.desktopItemInfos);
      return;
      if ((k > 0) && (n > 0))
      {
        this.adapterItemInfos.remove(n);
        if ((paramBoolean) && (this.mDataChangeListener != null)) {
          this.mDataChangeListener.onDataChanged();
        }
      }
      else if ((m != 0) && (paramBoolean) && (this.mDataChangeListener != null))
      {
        this.mDataChangeListener.onDataChanged();
      }
    }
  }
  
  private void checkRedDotSwitch()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("DesktopDataManager", 1, "initLocalDataRunnable, app is null.");
    }
    label17:
    do
    {
      do
      {
        do
        {
          break label17;
          do
          {
            return;
          } while (!amtc.m());
          localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
        } while (localObject == null);
        localObject = ((aukn)localObject).a(MiniAppSettingSwitchInfoEntity.class, MiniAppSettingSwitchInfoEntity.class.getSimpleName(), false, "key = ?", new String[] { "redDot" }, null, null, null, null);
      } while ((localObject == null) || (((List)localObject).size() <= 0));
      localObject = (MiniAppSettingSwitchInfoEntity)((List)localObject).get(0);
    } while ((localObject == null) || (!"redDot".equals(((MiniAppSettingSwitchInfoEntity)localObject).key)));
    this.mRedDataState = ((MiniAppSettingSwitchInfoEntity)localObject).value;
    Bundle localBundle = new Bundle();
    localBundle.putInt(((MiniAppSettingSwitchInfoEntity)localObject).key, ((MiniAppSettingSwitchInfoEntity)localObject).value);
    localBundle.putBoolean("refreshUI", false);
    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppDesktop.class, 102, true, localBundle);
    QLog.e("DesktopDataManager", 1, "initLocalDataRunnable, redDot switch: " + this.mRedDataState);
  }
  
  private void clearNoticeRedDotData()
  {
    this.mPublicAccountRedDotMap.clear();
    if ((this.desktopItemInfos == null) || (this.desktopItemInfos.size() == 0)) {}
    for (;;)
    {
      return;
      Object localObject1 = new ArrayList();
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
  
  private void convertData(List<INTERFACE.StUserAppInfo> paramList, List<INTERFACE.StModuleInfo> paramList1, INTERFACE.StSearchModuleInfo paramStSearchModuleInfo)
  {
    QLog.d("DesktopDataManager", 1, "convertData start!");
    if ((paramList1 == null) || (paramList1.size() <= 0))
    {
      QLog.e("DesktopDataManager", 1, "convertData, moduleInfos is null.");
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
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
    paramStSearchModuleInfo = new ArrayList();
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (INTERFACE.StUserAppInfo)paramList.next();
        if (localObject1 != null)
        {
          localObject1 = new DesktopAppInfo(2, MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject1));
          ((DesktopAppInfo)localObject1).setIsFixApp(true);
          ((DesktopAppInfo)localObject1).deleteEnable = false;
          ((DesktopAppInfo)localObject1).dragEnable = false;
          ((DesktopAppInfo)localObject1).dropEnable = false;
          paramStSearchModuleInfo.add(localObject1);
        }
      }
    }
    Object localObject1 = paramList1.iterator();
    INTERFACE.StModuleInfo localStModuleInfo;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localStModuleInfo = (INTERFACE.StModuleInfo)((Iterator)localObject1).next();
        if (localStModuleInfo != null) {
          if (localStModuleInfo.moduleType.get() == 6)
          {
            paramList = new DesktopPopularModuleInfo(6);
            paramList.mergePbData(localStModuleInfo);
            localArrayList1.add(paramList);
            localArrayList2.add(localStModuleInfo);
          }
          else if (localStModuleInfo.moduleType.get() == 4)
          {
            localArrayList1.add(new DesktopRecommendModuleInfo(4, localStModuleInfo));
            localArrayList2.add(localStModuleInfo);
          }
          else if (localStModuleInfo.moduleType.get() == 5)
          {
            paramList = localStModuleInfo.ranks.get();
            if ((paramList != null) && (!paramList.isEmpty()))
            {
              paramList = paramList.iterator();
              while (paramList.hasNext()) {
                localArrayList1.add(new DesktopFriendsPkModuleInfo(5, localStModuleInfo, (INTERFACE.StFriendRanking)paramList.next()));
              }
            }
            localArrayList2.add(localStModuleInfo);
          }
          else if (localStModuleInfo.moduleType.get() == 7)
          {
            paramList = new DesktopDittoInfo(7);
            paramList.mergePbData(localStModuleInfo);
            localArrayList1.add(paramList);
            localArrayList2.add(localStModuleInfo);
          }
          else
          {
            if ((localStModuleInfo.moduleType.get() < 0) || (TextUtils.isEmpty(localStModuleInfo.title.get()))) {
              break label944;
            }
            paramList1 = new DesktopAppModuleInfo(localStModuleInfo.moduleType.get(), localStModuleInfo.title.get(), (INTERFACE.StUserAppInfo)localStModuleInfo.jumpMoreApp.get());
            localArrayList1.add(paramList1);
            paramList = paramList1;
            if (paramList1.getModuleType() == 2)
            {
              paramList = paramList1;
              if (paramStSearchModuleInfo.size() > 0) {
                localArrayList1.addAll(paramStSearchModuleInfo);
              }
            }
          }
        }
      }
    }
    label944:
    for (paramList = paramList1;; paramList = null)
    {
      if ((paramList != null) && (localStModuleInfo.userAppList.get() != null) && (localStModuleInfo.userAppList.get().size() > 0))
      {
        paramList1 = localStModuleInfo.userAppList.get().iterator();
        while (paramList1.hasNext())
        {
          Object localObject2 = (INTERFACE.StUserAppInfo)paramList1.next();
          localObject2 = new DesktopAppInfo(localStModuleInfo.moduleType.get(), MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject2));
          if ((paramList.getModuleType() == 2) && (((DesktopAppInfo)localObject2).mMiniAppInfo != null))
          {
            RecommendAppInfo localRecommendAppInfo = new RecommendAppInfo(((DesktopAppInfo)localObject2).mMiniAppInfo.appId, 0, System.currentTimeMillis());
            QLog.d("DesktopDataManager-Recommend", 2, "convertData add " + localRecommendAppInfo.toString());
            localArrayList3.add(localRecommendAppInfo);
          }
          if ((((DesktopAppInfo)localObject2).mMiniAppInfo != null) && (((DesktopAppInfo)localObject2).mMiniAppInfo.isLimitedAccessApp())) {
            ((DesktopAppInfo)localObject2).dragEnable = false;
          }
          if (((DesktopAppInfo)localObject2).mMiniAppInfo != null) {
            ((DesktopAppInfo)localObject2).mMiniAppInfo.debugInfo = null;
          }
          localArrayList1.add(localObject2);
        }
        break;
      }
      if ((localStModuleInfo.moduleType.get() != 2) || (localStModuleInfo.useOld.get() != 0)) {
        break;
      }
      localArrayList3.clear();
      break;
      setDesktopAppPositionInfoToSp(localArrayList1);
      paramList = new ArrayList();
      paramList.addAll(localArrayList1);
      insertEntityWithBatch(paramList);
      saveCardModuleData(localArrayList2);
      updateRecommendExposureSp();
      QLog.d("DesktopDataManager", 1, "convertData end. size = " + localArrayList1.size());
      runOnMainThread(new DesktopDataManager.9(this, localArrayList3, localArrayList1));
      return;
    }
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
    if (TextUtils.isEmpty(paramString)) {}
    while (this.desktopItemInfos == null) {
      return;
    }
    QLog.e("DesktopDataManager", 2, "test1: size: " + this.desktopItemInfos.size());
    runOnMainThread(new DesktopDataManager.24(this, paramString));
  }
  
  private void deleteEntity(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.excute(new DesktopDataManager.16(this, paramMiniAppInfo), 32, null, true);
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
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {}
    label149:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("DesktopDataManager", 2, "deleteMiniApp, delete miniAppInfo: " + paramMiniAppInfo.toString());
      }
      int i = this.desktopItemInfos.size() - 1;
      if (i >= 0)
      {
        Object localObject = (DesktopItemInfo)this.desktopItemInfos.get(i);
        if ((localObject instanceof DesktopAppInfo))
        {
          localObject = (DesktopAppInfo)localObject;
          if ((((DesktopAppInfo)localObject).mMiniAppInfo == null) || (!paramMiniAppInfo.appId.equals(((DesktopAppInfo)localObject).mMiniAppInfo.appId))) {}
        }
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label149;
        }
        ThreadManagerV2.excute(new DesktopDataManager.10(this, paramMiniAppInfo), 16, null, true);
        return;
        i -= 1;
        break;
      }
    }
  }
  
  private void deleteOldEntity(List<DeskTopAppEntity> paramList)
  {
    Object localObject;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject = MiniAppUtils.getAppInterface();
      if (localObject != null) {
        break label31;
      }
      QLog.e("DesktopDataManager", 1, "deleteOldEntity, app is null.");
    }
    label31:
    do
    {
      return;
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i;
      try
      {
        localStringBuilder = new StringBuilder();
        i = 0;
        if (i < paramList.size())
        {
          DeskTopAppEntity localDeskTopAppEntity = (DeskTopAppEntity)paramList.get(i);
          localDeskTopAppEntity.setStatus(1001);
          if (((aukn)localObject).a(localDeskTopAppEntity, "uniqueId=?", new String[] { localDeskTopAppEntity.uniqueId })) {
            localStringBuilder.append(localDeskTopAppEntity.name).append("_0, ");
          } else {
            localStringBuilder.append(localDeskTopAppEntity.name).append("_1, ");
          }
        }
      }
      catch (Throwable paramList)
      {
        QLog.e("DesktopDataManager", 1, "deleteOldEntity, Exception: " + Log.getStackTraceString(paramList));
        return;
      }
      QLog.e("DesktopDataManager", 2, "deleteOldEntity, " + localStringBuilder.toString());
      return;
      i += 1;
    }
  }
  
  private void deleteRedDotDataFromDB(String paramString)
  {
    ThreadManager.excute(new DesktopDataManager.29(this, paramString), 32, null, true);
  }
  
  private boolean findMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if ((this.desktopItemInfos != null) && (this.desktopItemInfos.size() > 0))
    {
      Iterator localIterator = this.desktopItemInfos.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (DesktopItemInfo)localIterator.next();
        if ((localObject instanceof DesktopAppInfo))
        {
          localObject = (DesktopAppInfo)localObject;
          if ((((DesktopAppInfo)localObject).mMiniAppInfo != null) && (((DesktopAppInfo)localObject).mMiniAppInfo.verType == paramMiniAppInfo.verType) && (paramMiniAppInfo.appId.equals(((DesktopAppInfo)localObject).mMiniAppInfo.appId))) {
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
      localObject1 = BaseApplication.getContext().getSharedPreferences((String)localObject1 + "_" + "mini_app_desktop", 0).getStringSet("key_mini_app_desktop_position_info", null);
      if (QLog.isColorLevel()) {
        QLog.d("DesktopDataManager", 2, "getDesktopAppPositionInfo, start--info: " + localObject1);
      }
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        Iterator localIterator = ((Set)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (String)localIterator.next();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            String[] arrayOfString1 = ((String)localObject1).split("_");
            int i1;
            int i;
            int k;
            int j;
            String[] arrayOfString2;
            int m;
            Object localObject2;
            int n;
            if (((String)localObject1).contains("appid"))
            {
              if (arrayOfString1.length > 0)
              {
                localObject1 = "";
                i1 = arrayOfString1.length;
                i = 0;
                k = -1;
                j = -1;
                if (i < i1)
                {
                  arrayOfString2 = arrayOfString1[i].split(":");
                  m = k;
                  localObject2 = localObject1;
                  n = j;
                  if (arrayOfString2 != null)
                  {
                    m = k;
                    localObject2 = localObject1;
                    n = j;
                    if (arrayOfString2.length > 1)
                    {
                      if (!"appid".equals(arrayOfString2[0])) {
                        break label288;
                      }
                      localObject2 = arrayOfString2[1];
                      n = j;
                      m = k;
                    }
                  }
                  for (;;)
                  {
                    i += 1;
                    k = m;
                    localObject1 = localObject2;
                    j = n;
                    break;
                    label288:
                    if ("moduletype".equals(arrayOfString2[0]))
                    {
                      n = Integer.valueOf(arrayOfString2[1]).intValue();
                      m = k;
                      localObject2 = localObject1;
                    }
                    else
                    {
                      m = k;
                      localObject2 = localObject1;
                      n = j;
                      if ("position".equals(arrayOfString2[0]))
                      {
                        m = Integer.valueOf(arrayOfString2[1]).intValue();
                        localObject2 = localObject1;
                        n = j;
                      }
                    }
                  }
                }
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject2 = new DesktopDataManager.PositionItemInfo(null);
                  ((DesktopDataManager.PositionItemInfo)localObject2).moduleType = j;
                  ((DesktopDataManager.PositionItemInfo)localObject2).appId = ((String)localObject1);
                  ((DesktopDataManager.PositionItemInfo)localObject2).position = k;
                  localArrayList.add(localObject2);
                }
              }
            }
            else if ((((String)localObject1).contains("title")) && (arrayOfString1.length > 0))
            {
              localObject1 = "";
              i1 = arrayOfString1.length;
              i = 0;
              k = -1;
              j = -1;
              if (i < i1)
              {
                arrayOfString2 = arrayOfString1[i].split(":");
                m = k;
                localObject2 = localObject1;
                n = j;
                if (arrayOfString2 != null)
                {
                  m = k;
                  localObject2 = localObject1;
                  n = j;
                  if (arrayOfString2.length > 1)
                  {
                    if (!"title".equals(arrayOfString2[0])) {
                      break label536;
                    }
                    localObject2 = arrayOfString2[1];
                    n = j;
                    m = k;
                  }
                }
                for (;;)
                {
                  i += 1;
                  k = m;
                  localObject1 = localObject2;
                  j = n;
                  break;
                  label536:
                  if ("moduletype".equals(arrayOfString2[0]))
                  {
                    n = Integer.valueOf(arrayOfString2[1]).intValue();
                    m = k;
                    localObject2 = localObject1;
                  }
                  else
                  {
                    m = k;
                    localObject2 = localObject1;
                    n = j;
                    if ("position".equals(arrayOfString2[0]))
                    {
                      m = Integer.valueOf(arrayOfString2[1]).intValue();
                      localObject2 = localObject1;
                      n = j;
                    }
                  }
                }
              }
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                localObject2 = new DesktopDataManager.PositionItemInfo(null);
                ((DesktopDataManager.PositionItemInfo)localObject2).moduleType = j;
                ((DesktopDataManager.PositionItemInfo)localObject2).moduleTitle = ((String)localObject1);
                ((DesktopDataManager.PositionItemInfo)localObject2).position = k;
                localArrayList.add(localObject2);
              }
            }
          }
        }
      }
    }
    Collections.sort(localArrayList);
    QLog.d("DesktopDataManager", 2, "getDesktopAppPositionInfo, end--info: " + localArrayList);
    return localArrayList;
  }
  
  private int getLastFixAppIndex(List<DesktopItemInfo> paramList)
  {
    int k = 0;
    if (paramList.size() == 0) {
      return 0;
    }
    if (((DesktopItemInfo)paramList.get(0) instanceof DesktopSearchInfo)) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      i = k;
      for (;;)
      {
        k = j;
        if (i < paramList.size())
        {
          DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)paramList.get(i);
          k = j;
          if (localDesktopItemInfo != null)
          {
            k = j;
            if (localDesktopItemInfo.isFixApp()) {
              k = i;
            }
          }
          if ((k <= 1) || (localDesktopItemInfo == null) || (localDesktopItemInfo.isFixApp())) {}
        }
        else
        {
          return k;
        }
        i += 1;
        j = k;
      }
    }
  }
  
  private int getMyAppFirstPos()
  {
    if ((this.desktopItemInfos != null) && (this.desktopItemInfos.size() > 0))
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
    if (TextUtils.isEmpty(paramString)) {}
    AppInterface localAppInterface;
    do
    {
      return null;
      localAppInterface = MiniAppUtils.getAppInterface();
    } while (localAppInterface == null);
    return BaseApplication.getContext().getSharedPreferences(localAppInterface.getAccount() + "_" + paramString, 0);
  }
  
  private boolean hasGdtCookie(COMM.StCommonExt paramStCommonExt)
  {
    if ((paramStCommonExt == null) || (paramStCommonExt.mapInfo == null)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramStCommonExt.mapInfo.size())
      {
        if ("gdt_cookie".equals(((COMM.Entry)paramStCommonExt.mapInfo.get(i)).key.get())) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void insertEntity(DesktopItemInfo paramDesktopItemInfo)
  {
    ThreadManagerV2.excute(new DesktopDataManager.18(this, paramDesktopItemInfo), 32, null, true);
  }
  
  private void insertEntityWithBatch(List<DesktopItemInfo> paramList)
  {
    ThreadManagerV2.excute(new DesktopDataManager.19(this, paramList), 32, null, true);
  }
  
  private int mappingPosition(int paramInt)
  {
    if (this.adapterItemInfos == null) {
      return paramInt;
    }
    int j = 0;
    int i = -1;
    if ((j < this.adapterItemInfos.size()) && (j <= paramInt))
    {
      DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)this.adapterItemInfos.get(j);
      if (((localDesktopItemInfo instanceof DesktopAppGroupInfo)) && (((DesktopAppGroupInfo)localDesktopItemInfo).datas != null)) {
        i += ((DesktopAppGroupInfo)localDesktopItemInfo).datas.size();
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  private ArrayList<RecommendAppInfo> parseRecommendExposureFromSp()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = getSharedPreferences("app_recommend_exposure");
    if (localSharedPreferences != null) {
      try
      {
        Object localObject1 = localSharedPreferences.getString("app_recommend_exposure", null);
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).split(";");
          if ((localObject1 != null) && (localObject1.length > 0)) {
            while (i < localObject1.length)
            {
              Object localObject2 = localObject1[i];
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject2 = ((String)localObject2).split("_");
                if ((localObject2 != null) && (localObject2.length == 3))
                {
                  localObject2 = new RecommendAppInfo(localObject2[0], Integer.parseInt(localObject2[1]), Long.parseLong(localObject2[2]));
                  this.mRecommendExposureList.add(localObject2);
                }
              }
              i += 1;
            }
          }
        }
        return this.mRecommendExposureList;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DesktopDataManager-Recommend", 1, "parseRecommendExposureFromSp error.", localThrowable);
        localSharedPreferences.edit().clear().commit();
      }
    }
  }
  
  private void processScrollModeData(List<DesktopItemInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = -1;
    int j = paramList.size() - 1;
    Object localObject;
    if (j >= 0)
    {
      localObject = (DesktopItemInfo)paramList.get(j);
      if (((DesktopItemInfo)localObject).getModuleType() != paramInt) {
        break label158;
      }
      if ((localObject instanceof DesktopAppInfo))
      {
        localArrayList.add(0, (DesktopAppInfo)localObject);
        paramList.remove(j);
      }
    }
    label144:
    label158:
    for (;;)
    {
      j -= 1;
      break;
      if ((localObject instanceof DesktopAppModuleInfo))
      {
        i = j;
        continue;
        if (i >= 0)
        {
          if (localArrayList.size() <= 0) {
            break label144;
          }
          localObject = new DesktopAppGroupInfo(paramInt);
          ((DesktopAppGroupInfo)localObject).setData(localArrayList);
          paramList.add(i + 1, localObject);
        }
        while (paramInt == 3) {
          return;
        }
        paramList.remove(i);
        return;
      }
    }
  }
  
  private void processUIData()
  {
    if (this.adapterItemInfos == null) {
      this.adapterItemInfos = new ArrayList();
    }
    this.adapterItemInfos.clear();
    if (this.desktopItemInfos != null) {
      this.adapterItemInfos.addAll(this.desktopItemInfos);
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
      List localList1 = ((aukn)localObject1).a(DeskTopAppEntity.class, DeskTopAppEntity.class.getSimpleName(), false, null, null, null, null, null, null);
      List localList2 = queryCardModuleData(paramAppInterface);
      paramAppInterface = getDesktopAppPositionInfoFromSp();
      StringBuilder localStringBuilder = new StringBuilder();
      if (localList1 == null) {
        break label1135;
      }
      int i = localList1.size();
      HashMap localHashMap = new HashMap();
      localObject1 = localList1.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DeskTopAppEntity)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((DeskTopAppEntity)localObject2).appId))) {
          localHashMap.put(((DeskTopAppEntity)localObject2).appId, localObject2);
        }
      }
      if ((paramAppInterface != null) && (paramAppInterface.size() > 0))
      {
        localObject2 = paramAppInterface.iterator();
        break label571;
        for (;;)
        {
          label168:
          if (!((Iterator)localObject2).hasNext()) {
            break label1053;
          }
          DesktopDataManager.PositionItemInfo localPositionItemInfo = (DesktopDataManager.PositionItemInfo)((Iterator)localObject2).next();
          Object localObject3;
          if (!TextUtils.isEmpty(localPositionItemInfo.appId))
          {
            localObject3 = (DeskTopAppEntity)localHashMap.get(localPositionItemInfo.appId);
            localObject1 = null;
            paramAppInterface = (AppInterface)localObject1;
            if (localObject3 != null)
            {
              paramAppInterface = (AppInterface)localObject1;
              if (((DeskTopAppEntity)localObject3).appInfo != null) {
                paramAppInterface = ((DeskTopAppEntity)localObject3).createAppInfoFromBuffer(((DeskTopAppEntity)localObject3).appInfo);
              }
            }
            if (paramAppInterface != null)
            {
              localList1.remove(localObject3);
              if (localPositionItemInfo.moduleType == 0)
              {
                localObject1 = new DesktopSearchInfo(paramAppInterface, new ArrayList(), 0);
                ((DesktopItemInfo)localObject1).deleteEnable = false;
                ((DesktopItemInfo)localObject1).dragEnable = false;
                ((DesktopItemInfo)localObject1).dropEnable = false;
                this.hasPullSearchData = true;
              }
              for (;;)
              {
                localArrayList.add(localObject1);
                localStringBuilder.append(paramAppInterface.name).append(":").append(paramAppInterface.appId).append(", ");
                break;
                localObject1 = new DesktopAppInfo(localPositionItemInfo.moduleType, paramAppInterface);
                if (paramAppInterface.isSpecialMiniApp())
                {
                  ((DesktopItemInfo)localObject1).setIsFixApp(true);
                  ((DesktopItemInfo)localObject1).deleteEnable = false;
                  ((DesktopItemInfo)localObject1).dragEnable = false;
                  ((DesktopItemInfo)localObject1).dropEnable = false;
                }
                ((DesktopAppInfo)localObject1).setFromCache(true);
              }
            }
          }
          else if (!TextUtils.isEmpty(localPositionItemInfo.moduleTitle))
          {
            if (localPositionItemInfo.moduleType == 4)
            {
              if ((localList2 != null) && (localList2.size() > 0))
              {
                paramAppInterface = localList2.iterator();
                while (paramAppInterface.hasNext())
                {
                  localObject1 = (DesktopCardEntity)paramAppInterface.next();
                  if ((localObject1 != null) && (localPositionItemInfo.moduleType == ((DesktopCardEntity)localObject1).moduleType))
                  {
                    localObject3 = ((DesktopCardEntity)localObject1).createStModuleInfo();
                    if (localObject3 != null)
                    {
                      localArrayList.add(new DesktopRecommendModuleInfo(4, (INTERFACE.StModuleInfo)localObject3));
                      localStringBuilder.append(((DesktopCardEntity)localObject1).moduleType).append(":").append(((DesktopCardEntity)localObject1).title).append(", ");
                    }
                  }
                }
              }
            }
            else
            {
              label571:
              Object localObject4;
              if (localPositionItemInfo.moduleType == 5)
              {
                if ((localList2 != null) && (localList2.size() > 0))
                {
                  paramAppInterface = localList2.iterator();
                  for (;;)
                  {
                    if (!paramAppInterface.hasNext()) {
                      break label168;
                    }
                    localObject1 = (DesktopCardEntity)paramAppInterface.next();
                    if ((localObject1 == null) || (localPositionItemInfo.moduleType != ((DesktopCardEntity)localObject1).moduleType)) {
                      break;
                    }
                    localObject3 = ((DesktopCardEntity)localObject1).createStModuleInfo();
                    if (localObject3 == null) {
                      break;
                    }
                    localObject4 = ((INTERFACE.StModuleInfo)localObject3).ranks.get();
                    if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
                      break;
                    }
                    localObject4 = ((List)localObject4).iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localArrayList.add(new DesktopFriendsPkModuleInfo(5, (INTERFACE.StModuleInfo)localObject3, (INTERFACE.StFriendRanking)((Iterator)localObject4).next()));
                      localStringBuilder.append(((DesktopCardEntity)localObject1).moduleType).append(":").append(((DesktopCardEntity)localObject1).title).append(", ");
                    }
                  }
                }
              }
              else if (localPositionItemInfo.moduleType == 6)
              {
                if ((localList2 != null) && (localList2.size() > 0))
                {
                  paramAppInterface = localList2.iterator();
                  while (paramAppInterface.hasNext())
                  {
                    localObject1 = (DesktopCardEntity)paramAppInterface.next();
                    if ((localObject1 != null) && (localPositionItemInfo.moduleType == ((DesktopCardEntity)localObject1).moduleType))
                    {
                      localObject3 = ((DesktopCardEntity)localObject1).createStModuleInfo();
                      if (localObject3 != null)
                      {
                        localObject4 = new DesktopPopularModuleInfo(6);
                        ((DesktopPopularModuleInfo)localObject4).mergePbData((INTERFACE.StModuleInfo)localObject3);
                        localArrayList.add(localObject4);
                        localStringBuilder.append(((DesktopCardEntity)localObject1).moduleType).append(":").append(((DesktopCardEntity)localObject1).title).append(", ");
                      }
                    }
                  }
                }
              }
              else if (localPositionItemInfo.moduleType == 7)
              {
                if ((localList2 != null) && (localList2.size() > 0))
                {
                  paramAppInterface = localList2.iterator();
                  while (paramAppInterface.hasNext())
                  {
                    localObject1 = (DesktopCardEntity)paramAppInterface.next();
                    if ((localObject1 != null) && (localPositionItemInfo.moduleType == ((DesktopCardEntity)localObject1).moduleType) && (!TextUtils.isEmpty(localPositionItemInfo.moduleTitle)) && (localPositionItemInfo.moduleTitle.equals(((DesktopCardEntity)localObject1).title)))
                    {
                      localObject3 = ((DesktopCardEntity)localObject1).createStModuleInfo();
                      if (localObject3 != null)
                      {
                        localObject4 = new DesktopDittoInfo(7);
                        ((DesktopDittoInfo)localObject4).mergePbData((INTERFACE.StModuleInfo)localObject3);
                        localArrayList.add(localObject4);
                        localStringBuilder.append(((DesktopCardEntity)localObject1).moduleType).append(":").append(((DesktopCardEntity)localObject1).title).append(", ");
                      }
                    }
                  }
                }
              }
              else {
                localArrayList.add(new DesktopAppModuleInfo(localPositionItemInfo.moduleType, localPositionItemInfo.moduleTitle));
              }
            }
          }
        }
      }
      label1053:
      QLog.e("DesktopDataManager", 1, "query, before size=" + i + ", after size = " + localList1.size() + ", DB cache app List = [" + localStringBuilder.toString() + "]");
      if (localList1.size() < i) {
        deleteOldEntity(localList1);
      }
    }
    return localArrayList;
    label1135:
    QLog.e("DesktopDataManager", 1, "query, tempList is null.");
    return localArrayList;
  }
  
  private List<DesktopCardEntity> queryCardModuleData(AppInterface paramAppInterface)
  {
    Object localObject = null;
    aukn localaukn = paramAppInterface.getEntityManagerFactory().createEntityManager();
    new ArrayList();
    paramAppInterface = localObject;
    if (localaukn != null) {
      paramAppInterface = localaukn.a(DesktopCardEntity.class, DesktopCardEntity.class.getSimpleName(), false, null, null, null, null, null, null);
    }
    return paramAppInterface;
  }
  
  public static void recordMiniAppStart(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new DesktopDataManager.12(paramMiniAppInfo));
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
    QLog.d("DesktopDataManager", 2, "test: size: " + this.desktopItemInfos.size());
    runOnMainThread(new DesktopDataManager.23(this, paramString));
  }
  
  private void saveCardModuleData(List<INTERFACE.StModuleInfo> paramList)
  {
    ThreadManagerV2.excute(new DesktopDataManager.20(this, paramList), 32, null, true);
  }
  
  private void sendUserAppListRequestV2(COMM.StCommonExt paramStCommonExt, ArrayList<RecommendAppInfo> paramArrayList)
  {
    ThreadManager.excute(new DesktopDataManager.2(this, paramStCommonExt, paramArrayList), 128, null, false);
  }
  
  private void sendUserAppListRequestV2(COMM.StCommonExt paramStCommonExt, ArrayList<RecommendAppInfo> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    if ((this.desktopItemInfos != null) && (this.desktopItemInfos.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      QLog.d("DesktopDataManager", 1, "sendUserAppListRequestV2, cacheValue: " + i);
      MiniAppCmdUtil.getInstance().getUserAppListV2(paramStCommonExt, paramArrayList, paramArrayList1, i, new DesktopDataManager.3(this));
      paramArrayList1 = MiniAppUtils.getAppInterface();
      if (paramArrayList1 != null)
      {
        paramStCommonExt = paramArrayList1.getPreferences();
        paramArrayList = paramArrayList1.getCurrentAccountUin() + "key_update_applets_notification_setting_time";
        long l1 = paramStCommonExt.getLong(paramArrayList, 0L);
        long l2 = System.currentTimeMillis();
        if (l2 - l1 > QzoneConfig.getInstance().getConfig("qqminiapp", "getappletsnotificationsettinginterval", 1L) * 1000L)
        {
          paramArrayList1 = (akwq)paramArrayList1.getBusinessHandler(148);
          if (paramArrayList1 != null)
          {
            paramArrayList1.a();
            paramStCommonExt.edit().putLong(paramArrayList, l2).commit();
          }
        }
      }
      return;
    }
  }
  
  private static void setDesktopAppPositionInfoToSp(List<DesktopItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    ThreadManager.executeOnFileThread(new DesktopDataManager.5(localArrayList));
  }
  
  private static void setGetRecommendIntervalTime(long paramLong)
  {
    QLog.d("DesktopDataManager-Recommend", 2, "setGetRecommendIntervalTime : " + paramLong);
    if (paramLong > 0L) {
      StorageUtil.getPreference().edit().putLong("key_mini_app_recommend_time", paramLong).apply();
    }
  }
  
  private boolean updateEntity(aukn paramaukn, aukm paramaukm)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramaukn.a()) {
      if (paramaukm.getStatus() == 1000)
      {
        paramaukn.b(paramaukm);
        if (paramaukm.getStatus() == 1001) {
          bool1 = true;
        }
        paramaukn.a();
      }
    }
    do
    {
      return bool1;
      if ((paramaukm.getStatus() != 1001) && (paramaukm.getStatus() != 1002)) {
        break;
      }
      bool1 = paramaukn.a(paramaukm);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("DesktopDataManager", 2, "updateEntity em closed e=" + paramaukm.getTableName());
    return false;
  }
  
  private void updateMiniAppStartRecord(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId)) || (this.desktopItemInfos == null))
    {
      QLog.e("DesktopDataManager", 1, "insertAppInfo error app info is invalid, appInfo = " + paramMiniAppInfo);
      break label47;
    }
    label47:
    while (paramMiniAppInfo.isSpecialMiniApp()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
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
      i = 0;
      label162:
      if (i >= localArrayList.size()) {
        break label349;
      }
      localObject = (DesktopItemInfo)localArrayList.get(i);
      DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)localObject;
      if ((paramMiniAppInfo.appId.equals(localDesktopAppInfo.mMiniAppInfo.appId)) && (paramMiniAppInfo.verType == localDesktopAppInfo.mMiniAppInfo.verType)) {
        this.desktopItemInfos.remove(localObject);
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((j == -1) || (localObject == null)) {
          break;
        }
        this.desktopItemInfos.add(j, localObject);
        return;
        i += 1;
        break label162;
      }
      localObject = new DesktopAppInfo(1, paramMiniAppInfo);
      if (j == -1) {
        break;
      }
      if (paramMiniAppInfo.isLimitedAccessApp()) {
        ((DesktopItemInfo)localObject).dragEnable = false;
      }
      this.desktopItemInfos.add(j, localObject);
      insertEntity((DesktopItemInfo)localObject);
      return;
      paramMiniAppInfo = new DesktopAppInfo(1, paramMiniAppInfo);
      this.desktopItemInfos.add(paramMiniAppInfo);
      insertEntity(paramMiniAppInfo);
      return;
      label349:
      localObject = null;
    }
  }
  
  private void updateRecommendExposureSp()
  {
    ArrayList localArrayList = new ArrayList(this.mRecommendExposureList);
    ThreadManager.getSubThreadHandler().post(new DesktopDataManager.22(this, localArrayList));
  }
  
  private void updateRedDotData(MiniAppRedDotEntity paramMiniAppRedDotEntity)
  {
    if (paramMiniAppRedDotEntity == null) {
      return;
    }
    ThreadManagerV2.excute(new DesktopDataManager.28(this, paramMiniAppRedDotEntity), 32, null, true);
  }
  
  private boolean updateRedDotData(aukn paramaukn, aukm paramaukm)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramaukn.a()) {
      if (paramaukm.getStatus() == 1000)
      {
        paramaukn.b(paramaukm);
        if (paramaukm.getStatus() == 1001) {
          bool1 = true;
        }
        paramaukn.a();
      }
    }
    do
    {
      return bool1;
      if ((paramaukm.getStatus() != 1001) && (paramaukm.getStatus() != 1002)) {
        break;
      }
      bool1 = paramaukn.a(paramaukm);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("DesktopDataManager", 2, "updateEntity em closed e=" + paramaukm.getTableName());
    return false;
  }
  
  private void useDefaultRecommendApps()
  {
    ThreadManager.getSubThreadHandler().post(new DesktopDataManager.14(this));
  }
  
  public void asyncQueryMiniAppPushRedDotData()
  {
    ThreadManagerV2.excute(new DesktopDataManager.30(this), 32, null, true);
  }
  
  public void checkMiniAppAdReport(MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    DesktopAdData localDesktopAdData = (DesktopAdData)this.mAdReportMap.get(paramMiniAppInfo.appId);
    if ((localDesktopAdData != null) && (localDesktopAdData.position != paramInt) && (localDesktopAdData.hasReport())) {
      this.mAdReportMap.remove(paramMiniAppInfo.appId);
    }
    if (this.mAdReportMap.get(paramMiniAppInfo.appId) == null)
    {
      localDesktopAdData = new DesktopAdData(paramInt, false, paramMiniAppInfo);
      this.mAdReportMap.put(paramMiniAppInfo.appId, localDesktopAdData);
      QLog.d("DesktopDataManager", 1, "collectAdReport, name: " + paramMiniAppInfo.name);
    }
  }
  
  public void clearRecommendExposureList()
  {
    ThreadManager.getUIHandler().post(new DesktopDataManager.21(this));
  }
  
  public MiniAppInfo findMiniApp(String paramString, int paramInt)
  {
    if ((this.desktopItemInfos != null) && (this.desktopItemInfos.size() > 0))
    {
      Iterator localIterator = this.desktopItemInfos.iterator();
      while (localIterator.hasNext())
      {
        DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)localIterator.next();
        if (((localDesktopItemInfo instanceof DesktopAppInfo)) && (((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo != null) && (((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.appId.equals(paramString)) && (((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.verType == paramInt)) {
          return ((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo;
        }
      }
    }
    QLog.d("DesktopDataManager", 1, "findMiniApp, failed to find Miniapp, appId = " + paramString);
    return null;
  }
  
  public MiniAppInfo findTopMiniApp(String paramString, int paramInt)
  {
    if ((this.desktopItemInfos != null) && (this.desktopItemInfos.size() > 0))
    {
      Iterator localIterator = this.desktopItemInfos.iterator();
      while (localIterator.hasNext())
      {
        DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)localIterator.next();
        if (((localDesktopItemInfo instanceof DesktopAppInfo)) && (localDesktopItemInfo.getModuleType() == 3) && (((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo != null) && (((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.appId.equals(paramString)) && (((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.verType == paramInt)) {
          return ((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo;
        }
      }
    }
    QLog.d("DesktopDataManager", 1, "findMiniApp, failed to find Miniapp, appId = " + paramString);
    return null;
  }
  
  public List<DesktopItemInfo> getData()
  {
    checkData(false);
    checkAddSpringBanner();
    return this.adapterItemInfos;
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
      if (localRecommendAppInfo != null) {
        QLog.d("DesktopDataManager-Recommend", 2, "getRecommendExposureList : " + localRecommendAppInfo.toString());
      }
    }
    return this.mRecommendExposureList;
  }
  
  public Map<String, Integer> getRedDotData()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while ((this.desktopItemInfos != null) && (i < this.desktopItemInfos.size()))
    {
      localObject = (DesktopItemInfo)this.desktopItemInfos.get(i);
      if (((localObject instanceof DesktopAppInfo)) && ((((DesktopItemInfo)localObject).getModuleType() == 1) || (((DesktopItemInfo)localObject).getModuleType() == 3) || (((DesktopItemInfo)localObject).getModuleType() == 2)))
      {
        localObject = (DesktopAppInfo)localObject;
        if (((DesktopAppInfo)localObject).mMiniAppInfo != null) {
          localArrayList.add(((DesktopAppInfo)localObject).mMiniAppInfo);
        }
      }
      i += 1;
    }
    if ((localArrayList == null) || (localArrayList.size() <= 0)) {
      return localHashMap;
    }
    boolean bool = amtc.i();
    if (QLog.isColorLevel()) {
      QLog.d("DesktopDataManager", 2, "getRedDotData, showPublicAccountRedDot: " + bool);
    }
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null) {}
    for (localObject = ((ahjz)((AppInterface)localObject).getManager(315)).a();; localObject = null)
    {
      int j = 0;
      MiniAppInfo localMiniAppInfo;
      label312:
      Integer localInteger1;
      Integer localInteger2;
      while (j < localArrayList.size())
      {
        localMiniAppInfo = (MiniAppInfo)localArrayList.get(j);
        if ((localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId)))
        {
          if ((localObject == null) || (!((Set)localObject).contains(localMiniAppInfo.appId))) {
            break label312;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DesktopDataManager", 2, "getRedDotData, unReceiveMsgAppids ignore appid: " + localMiniAppInfo.appId);
          }
        }
        j += 1;
        continue;
        localInteger1 = (Integer)this.mPublicAccountRedDotMap.get(localMiniAppInfo.appId);
        localInteger2 = (Integer)this.mPushRedDotMap.get(localMiniAppInfo.appId);
        if ((localInteger1 == null) || (localInteger1.intValue() <= 0) || (!bool)) {
          break label420;
        }
      }
      label420:
      for (i = localInteger1.intValue() + 0;; i = 0)
      {
        int k = i;
        if (localInteger2 != null)
        {
          k = i;
          if (localInteger2.intValue() > 0) {
            k = i + localInteger2.intValue();
          }
        }
        localHashMap.put(localMiniAppInfo.appId, Integer.valueOf(k));
        break;
        return localHashMap;
      }
    }
  }
  
  public long getRefreshInterval()
  {
    return this.mRefreshInternal;
  }
  
  public int getTopMiniAppNumber()
  {
    int j = 0;
    int i = j;
    if (this.desktopItemInfos != null)
    {
      i = j;
      if (this.desktopItemInfos.size() > 0)
      {
        Iterator localIterator = this.desktopItemInfos.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)localIterator.next();
          if ((!(localDesktopItemInfo instanceof DesktopAppInfo)) || (localDesktopItemInfo.getModuleType() != 3)) {
            break label109;
          }
          i += 1;
        }
      }
    }
    label109:
    for (;;)
    {
      break;
      QLog.d("DesktopDataManager", 1, "getTopMiniAppNumber : " + i);
      return i;
    }
  }
  
  public int getTopModuleInfoIndex()
  {
    if (this.adapterItemInfos == null) {}
    DesktopItemInfo localDesktopItemInfo;
    int j;
    do
    {
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          return -1;
          localIterator = this.adapterItemInfos.iterator();
          i = -1;
        }
        localDesktopItemInfo = (DesktopItemInfo)localIterator.next();
        j = i + 1;
        i = j;
      } while (!(localDesktopItemInfo instanceof DesktopAppModuleInfo));
      int i = j;
    } while (((DesktopAppModuleInfo)localDesktopItemInfo).getModuleType() != 3);
    return j;
  }
  
  public boolean hasPullSearchData()
  {
    return this.hasPullSearchData;
  }
  
  public void initLocalCacheData()
  {
    QLog.d("DesktopDataManager", 2, "initLocalCacheData, hasInitData: " + this.hasInitData);
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
    MiniAppCmdUtil.getInstance().getUserAppListV2(paramStCommonExt, null, localArrayList, 0, new DesktopDataManager.4(this));
  }
  
  public void loadMoreRecentIfNeed()
  {
    int j = this.desktopItemInfos.size() - 1;
    int i = 0;
    if (j >= 0)
    {
      if ((this.desktopItemInfos.get(j) == null) || (((DesktopItemInfo)this.desktopItemInfos.get(j)).getModuleType() != 1) || (!(this.desktopItemInfos.get(j) instanceof DesktopAppInfo))) {
        break label154;
      }
      i += 1;
    }
    label154:
    for (;;)
    {
      j -= 1;
      break;
      if ((i > 0) && (i < 4) && (this.canLoadMoreRecent) && (!this.isLoadingMoreRecent))
      {
        this.isLoadingMoreRecent = true;
        QLog.i("DesktopDataManager", 1, "loadMoreRencentApp start");
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(1));
        MiniAppCmdUtil.getInstance().getUserAppListV2(this.mMoreRencentExtInfo, null, localArrayList, 0, new DesktopDataManager.11(this));
      }
      return;
    }
  }
  
  public void miniAppAdReport()
  {
    if (this.mAdReportMap.size() <= 0) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mAdReportMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        DesktopAdData localDesktopAdData = (DesktopAdData)((Map.Entry)localIterator.next()).getValue();
        if ((localDesktopAdData != null) && (!localDesktopAdData.hasReport))
        {
          localDesktopAdData.hasReport = true;
          try
          {
            Object localObject = new JSONObject(localDesktopAdData.miniAppInfo.amsAdInfo);
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxr.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
            localObject = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.exposure_url.get() + "&slot=" + localDesktopAdData.position;
            MiniAppUtils.reportMiniAppAd((String)localObject);
            QLog.d("DesktopDataManager", 1, "gdtAdReport, exposure_url: " + (String)localObject + ", name: " + localDesktopAdData.miniAppInfo.name);
          }
          catch (Exception localException)
          {
            QLog.e("DesktopDataManager", 1, "gdtAdReport exception: " + Log.getStackTraceString(localException));
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
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i < this.desktopItemInfos.size())
      {
        if (((this.desktopItemInfos.get(i) instanceof DesktopAppModuleInfo)) && (((DesktopItemInfo)this.desktopItemInfos.get(i)).mModuleType == paramInt)) {
          j = i;
        }
      }
      else
      {
        if (j < 0) {
          break;
        }
        i = this.desktopItemInfos.size() - 1;
        while (i > j)
        {
          if ((this.desktopItemInfos.get(i) != null) && (((DesktopItemInfo)this.desktopItemInfos.get(i)).mModuleType == paramInt)) {
            this.desktopItemInfos.remove(i);
          }
          i -= 1;
        }
      }
      i += 1;
    }
    this.desktopItemInfos.addAll(j + 1, paramList);
    setDesktopAppPositionInfoToSp(this.desktopItemInfos);
  }
  
  public void onDestroy()
  {
    if (this.mDataChangeListener != null) {
      this.mDataChangeListener = null;
    }
  }
  
  public void onItemChanged(int paramInt, DesktopItemInfo paramDesktopItemInfo)
  {
    if ((this.adapterItemInfos != null) && (paramInt >= 0) && (paramInt < this.adapterItemInfos.size()) && (((DesktopItemInfo)this.adapterItemInfos.get(paramInt) instanceof DesktopEmptyGuideInfo)))
    {
      this.desktopItemInfos.add(paramDesktopItemInfo);
      setDesktopAppPositionInfoToSp(this.desktopItemInfos);
    }
    do
    {
      return;
      paramInt = mappingPosition(paramInt);
    } while ((this.desktopItemInfos == null) || (paramInt < 0) || (paramInt >= this.desktopItemInfos.size()));
    this.desktopItemInfos.set(paramInt, paramDesktopItemInfo);
    setDesktopAppPositionInfoToSp(this.desktopItemInfos);
  }
  
  @Deprecated
  public void onItemDeleted(int paramInt1, int paramInt2)
  {
    if (this.desktopItemInfos == null) {
      return;
    }
    int i = mappingPosition(paramInt1);
    ArrayList localArrayList = new ArrayList();
    if (paramInt2 == 1) {
      localArrayList.add((DesktopItemInfo)this.desktopItemInfos.remove(i));
    }
    for (;;)
    {
      checkData(true);
      deleteEntity(localArrayList);
      return;
      if ((paramInt2 > 1) && (i >= 0) && (i + paramInt2 < this.desktopItemInfos.size()))
      {
        paramInt1 = i + paramInt2;
        while (paramInt1 >= i)
        {
          localArrayList.add((DesktopItemInfo)this.desktopItemInfos.remove(paramInt1));
          paramInt1 -= 1;
        }
      }
    }
  }
  
  public void onItemDeleted(DesktopAppInfo paramDesktopAppInfo)
  {
    if ((this.desktopItemInfos == null) || (paramDesktopAppInfo == null) || (paramDesktopAppInfo.mMiniAppInfo == null)) {
      return;
    }
    int i = this.desktopItemInfos.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)this.desktopItemInfos.get(i);
        if ((localDesktopItemInfo.getModuleType() == paramDesktopAppInfo.getModuleType()) && ((localDesktopItemInfo instanceof DesktopAppInfo)) && (paramDesktopAppInfo.mMiniAppInfo.equals(((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo))) {
          this.desktopItemInfos.remove(i);
        }
      }
      else
      {
        checkData(true);
        deleteEntity(paramDesktopAppInfo.mMiniAppInfo);
        deleteMiniAppCache(paramDesktopAppInfo.mMiniAppInfo);
        return;
      }
      i -= 1;
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
        Collections.swap(this.desktopItemInfos, paramInt1, paramInt1 + 1);
        paramInt1 += 1;
      }
    }
    while (paramInt2 > paramInt3)
    {
      Collections.swap(this.desktopItemInfos, paramInt2, paramInt2 - 1);
      paramInt2 -= 1;
    }
    setDesktopAppPositionInfoToSp(this.desktopItemInfos);
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
  
  public void sendDropDownAppListRequestAsync()
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
    sendUserAppListRequestV2((COMM.StCommonExt)localObject1, (ArrayList)localObject2);
  }
  
  public void setDataChangeListener(DesktopDataManager.DataChangeListener paramDataChangeListener)
  {
    this.mDataChangeListener = paramDataChangeListener;
  }
  
  public void setHongBaoResBuilder(DesktopDataManager.HongBaoResBuilder paramHongBaoResBuilder)
  {
    this.mHongBaoResBuilder = paramHongBaoResBuilder;
    QLog.i("DesktopDataManager", 2, "setHongBaoResBuilder : " + paramHongBaoResBuilder);
    MiniAppUtils.notifyUpdateHongBaoRes();
  }
  
  public void setMiniAppNoticeRedDotData(Map<String, Integer> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      QLog.d("DesktopDataManager", 1, "setMiniAppNoticeRedDotData, data is null or data size = 0");
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
    QLog.d("DesktopDataManager", 1, "setMiniAppPushRedDotData, data: " + paramMiniAppRedDotEntity);
    if ((paramMiniAppRedDotEntity != null) && (!TextUtils.isEmpty(paramMiniAppRedDotEntity.appId)))
    {
      if ((this.desktopItemInfos != null) && (this.desktopItemInfos.size() != 0)) {
        break label75;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DesktopDataManager", 1, "setMiniAppPushRedDotData, current app is not opened");
      }
    }
    return;
    label75:
    Object localObject1 = this.desktopItemInfos.iterator();
    Object localObject2;
    do
    {
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (DesktopItemInfo)((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof DesktopAppInfo)) || ((((DesktopItemInfo)localObject2).getModuleType() != 1) && (((DesktopItemInfo)localObject2).getModuleType() != 3) && (((DesktopItemInfo)localObject2).getModuleType() != 2)));
      localObject2 = (DesktopAppInfo)localObject2;
    } while ((((DesktopAppInfo)localObject2).mMiniAppInfo == null) || (!paramMiniAppRedDotEntity.appId.equals(((DesktopAppInfo)localObject2).mMiniAppInfo.appId)));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("DesktopDataManager", 1, "setMiniAppPushRedDotData, current app is not opened");
        return;
      }
      this.mPushRedDotMap.put(paramMiniAppRedDotEntity.appId, Integer.valueOf(paramMiniAppRedDotEntity.wnsPushRedDotNum));
      localObject1 = (Integer)this.mPublicAccountRedDotMap.get(paramMiniAppRedDotEntity.appId);
      if ((localObject1 != null) && (((Integer)localObject1).intValue() > 0)) {}
      for (i = ((Integer)localObject1).intValue();; i = 0)
      {
        updateRedDotData(new MiniAppRedDotEntity(paramMiniAppRedDotEntity.appId, i, paramMiniAppRedDotEntity.wnsPushRedDotNum));
        MiniAppUtils.updateMiniAppList(101);
        return;
      }
    }
  }
  
  public void updateData(List<INTERFACE.StUserAppInfo> paramList, List<INTERFACE.StModuleInfo> paramList1, INTERFACE.StSearchModuleInfo paramStSearchModuleInfo)
  {
    convertData(paramList, paramList1, paramStSearchModuleInfo);
  }
  
  public void updateDesktopData(List<DesktopItemInfo> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.desktopItemInfos = new ArrayList(paramList);
      if ((paramBoolean) && (this.mDataChangeListener != null)) {
        this.mDataChangeListener.onDataChanged();
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
    }
    do
    {
      return;
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
    } while (!"removeAppFromMine".equals(str));
    removeAppFromMine(paramJSONObject.optString("appId"));
  }
  
  public void updateModuleInfo(INTERFACE.StModuleInfo paramStModuleInfo)
  {
    runOnMainThread(new DesktopDataManager.8(this, paramStModuleInfo));
  }
  
  public void updateModuleMyApp(MiniAppInfo paramMiniAppInfo)
  {
    runOnMainThread(new DesktopDataManager.17(this, paramMiniAppInfo));
  }
  
  public void updateRecommendExposureNumber(String paramString)
  {
    if ((this.mRecommendExposureList != null) && (this.mRecommendExposureList.size() > 0))
    {
      Iterator localIterator = this.mRecommendExposureList.iterator();
      while (localIterator.hasNext())
      {
        RecommendAppInfo localRecommendAppInfo = (RecommendAppInfo)localIterator.next();
        if ((localRecommendAppInfo != null) && (localRecommendAppInfo.appId != null) && (localRecommendAppInfo.appId.equals(paramString))) {
          localRecommendAppInfo.exposuredNum += 1;
        }
      }
    }
    updateRecommendExposureSp();
  }
  
  public void updateSpringEntryBanner(DesktopSpringEntryInfo paramDesktopSpringEntryInfo)
  {
    this.desktopSpringEntryInfo = paramDesktopSpringEntryInfo;
    if (this.mDataChangeListener != null) {
      this.mDataChangeListener.onDataChanged();
    }
  }
  
  public void useLocalDataIfRequestFailed()
  {
    ThreadManager.excute(new DesktopDataManager.13(this), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager
 * JD-Core Version:    0.7.0.1
 */