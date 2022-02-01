package com.tencent.mobileqq.mini.entry.search.data;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StoreAppInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch.StGetHotSearchAppsRsp;
import NS_STORE_APP_SEARCH.MiniAppSearch.StHotWatching;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.ItemInfo;
import com.tencent.mobileqq.mini.entry.search.comm.LiveInfo;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.comm.TitleInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import nmd;

public class MiniAppSearchDataManager
  implements Manager
{
  public static final int MAX_HISTORY_SEARCH_NUM = 20;
  private static final String MINI_APP_NATIVE_SEARCH = "mini_app_native_search";
  public static final String TAG = "MiniAppSearchDataManager";
  private volatile boolean isFinished = true;
  private volatile boolean isLoading;
  private volatile COMM.StCommonExt mExtInfo;
  private LinkedList<String> mHistorySearchList = new LinkedList();
  private MiniAppSearchDataManager.HotSearchDataChangedListener mHotSearchDataChangedListener;
  private List<ItemInfo> mHotSearchList = new ArrayList();
  private Object mLock = new Object();
  private MiniAppSearchDataManager.SearchResultDataChangedListener mResultDataChangedListener;
  private List<SearchInfo> mSearchResultList = new ArrayList();
  private volatile String mTitle;
  
  private void appendSearchResultData(List<STORE_APP_CLIENT.StoreAppInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      QLog.d("MiniAppSearchDataManager", 1, "updateSearchResultData, data is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      STORE_APP_CLIENT.StoreAppInfo localStoreAppInfo = (STORE_APP_CLIENT.StoreAppInfo)paramList.next();
      if ((localStoreAppInfo != null) && (localStoreAppInfo.userAppInfo.get() != null)) {
        localArrayList.add(new SearchInfo(localStoreAppInfo));
      }
    }
    runOnMainThread(new MiniAppSearchDataManager.6(this, localArrayList));
  }
  
  private void checkNetwork()
  {
    if ((!nmd.a(BaseApplicationImpl.getContext())) && (this.mResultDataChangedListener != null))
    {
      this.mSearchResultList.clear();
      this.mResultDataChangedListener.onResultDataChanged();
      QLog.d("MiniAppSearchDataManager", 1, "checkNetwork, network not available");
    }
  }
  
  private void updateHotSearchData(MiniAppSearch.StGetHotSearchAppsRsp paramStGetHotSearchAppsRsp)
  {
    int j = 0;
    if (paramStGetHotSearchAppsRsp == null)
    {
      QLog.e("MiniAppSearchDataManager", 1, "updateHotSearchData, response is null!");
      return;
    }
    this.mTitle = paramStGetHotSearchAppsRsp.title.get();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = paramStGetHotSearchAppsRsp.appList.get();
    int i;
    Object localObject2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localArrayList1.add(new TitleInfo(paramStGetHotSearchAppsRsp.title.get()));
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (STORE_APP_CLIENT.StoreAppInfo)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((STORE_APP_CLIENT.StoreAppInfo)localObject2).userAppInfo.get() == null)) {
          break label369;
        }
        localObject2 = new SearchInfo((STORE_APP_CLIENT.StoreAppInfo)localObject2);
        ((SearchInfo)localObject2).setPosition(i);
        localArrayList1.add(localObject2);
        i += 1;
      }
    }
    label369:
    for (;;)
    {
      break;
      localObject1 = paramStGetHotSearchAppsRsp.watchingList.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localArrayList2.add(new TitleInfo(paramStGetHotSearchAppsRsp.watchTitle.get()));
        localObject1 = ((List)localObject1).iterator();
        i = j;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MiniAppSearch.StHotWatching)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = new LiveInfo((MiniAppSearch.StHotWatching)localObject2);
            ((LiveInfo)localObject2).setPosition(i);
            localArrayList2.add(localObject2);
            i += 1;
          }
        }
      }
      localObject1 = new ArrayList();
      if (paramStGetHotSearchAppsRsp.sort.get() == 2)
      {
        ((List)localObject1).addAll(localArrayList2);
        ((List)localObject1).addAll(localArrayList1);
      }
      for (;;)
      {
        runOnMainThread(new MiniAppSearchDataManager.4(this, (List)localObject1));
        return;
        ((List)localObject1).addAll(localArrayList1);
        ((List)localObject1).addAll(localArrayList2);
      }
    }
  }
  
  private void updateSearchResultData(List<STORE_APP_CLIENT.StoreAppInfo> paramList, List<String> paramList1)
  {
    if (paramList == null)
    {
      QLog.d("MiniAppSearchDataManager", 1, "updateSearchResultData, data is null!");
      return;
    }
    paramList1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      STORE_APP_CLIENT.StoreAppInfo localStoreAppInfo = (STORE_APP_CLIENT.StoreAppInfo)paramList.next();
      if ((localStoreAppInfo != null) && (localStoreAppInfo.userAppInfo.get() != null)) {
        paramList1.add(new SearchInfo(localStoreAppInfo));
      }
    }
    runOnMainThread(new MiniAppSearchDataManager.5(this, paramList1));
  }
  
  public void clearHistorySearch()
  {
    this.mHistorySearchList.clear();
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null)
    {
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
      BaseApplication.getContext().getSharedPreferences((String)localObject + "_" + "mini_app_native_search", 0).edit().remove("key_mini_app_native_search_history").apply();
    }
  }
  
  public void clearSearchResult()
  {
    this.mSearchResultList.clear();
  }
  
  public List<String> getCachedHistorySearchList()
  {
    int i = 0;
    this.mHistorySearchList.clear();
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null)
    {
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
      localObject = BaseApplication.getContext().getSharedPreferences((String)localObject + "_" + "mini_app_native_search", 0).getString("key_mini_app_native_search_history", null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("_");
        int j = localObject.length;
        while (i < j)
        {
          CharSequence localCharSequence = localObject[i];
          if (!TextUtils.isEmpty(localCharSequence)) {
            this.mHistorySearchList.add(localCharSequence);
          }
          i += 1;
        }
      }
    }
    return this.mHistorySearchList;
  }
  
  public List<String> getHistorySearchList()
  {
    return this.mHistorySearchList;
  }
  
  public List<ItemInfo> getHotSearchData()
  {
    return this.mHotSearchList;
  }
  
  public String getHotSearchTitle()
  {
    return this.mTitle;
  }
  
  public List<SearchInfo> getSearchResultData()
  {
    return this.mSearchResultList;
  }
  
  public void loadMoreSearchAppDataRequest(String paramString)
  {
    synchronized (this.mLock)
    {
      if ((this.isFinished) || (this.isLoading)) {
        return;
      }
      this.isLoading = true;
      COMM.StCommonExt localStCommonExt = this.mExtInfo;
      QLog.d("MiniAppSearchDataManager", 1, "loadMoreSearchAppDataRequest, isFinished: " + this.isFinished + ", isLoading: " + this.isLoading + ", keyWord: " + paramString);
      MiniAppCmdUtil.getInstance().searchApp(localStCommonExt, paramString, new MiniAppSearchDataManager.3(this));
      return;
    }
  }
  
  public void onDestroy()
  {
    this.mHotSearchDataChangedListener = null;
    this.mResultDataChangedListener = null;
    if (this.mSearchResultList != null) {
      this.mSearchResultList.clear();
    }
  }
  
  public void runOnMainThread(Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  public void sendHotSearchAppRequest()
  {
    MiniAppCmdUtil.getInstance().getHotSearchApps(null, new MiniAppSearchDataManager.1(this));
  }
  
  public void sendSearchAppRequest(String paramString)
  {
    checkNetwork();
    MiniAppCmdUtil.getInstance().searchApp(null, paramString, new MiniAppSearchDataManager.2(this));
  }
  
  public void setDataChangedListener(MiniAppSearchDataManager.SearchResultDataChangedListener paramSearchResultDataChangedListener)
  {
    this.mResultDataChangedListener = paramSearchResultDataChangedListener;
  }
  
  public void setHotSearchDataChangedListener(MiniAppSearchDataManager.HotSearchDataChangedListener paramHotSearchDataChangedListener)
  {
    this.mHotSearchDataChangedListener = paramHotSearchDataChangedListener;
  }
  
  public void updateHistorySearchList(String paramString)
  {
    if (this.mHistorySearchList.contains(paramString)) {
      this.mHistorySearchList.remove(paramString);
    }
    this.mHistorySearchList.addFirst(paramString);
    paramString = MiniAppUtils.getAppInterface();
    if (paramString != null)
    {
      paramString = paramString.getCurrentAccountUin();
      paramString = BaseApplication.getContext().getSharedPreferences(paramString + "_" + "mini_app_native_search", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while ((i < 20) && (i < this.mHistorySearchList.size()))
      {
        String str = (String)this.mHistorySearchList.get(i);
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append(str).append("_");
        }
        i += 1;
      }
      paramString.edit().putString("key_mini_app_native_search_history", localStringBuilder.toString()).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager
 * JD-Core Version:    0.7.0.1
 */