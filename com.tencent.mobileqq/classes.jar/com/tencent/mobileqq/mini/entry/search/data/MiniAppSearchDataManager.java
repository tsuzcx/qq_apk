package com.tencent.mobileqq.mini.entry.search.data;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StoreAppInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch.SearchExtInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch.StGetHotSearchAppsRsp;
import NS_STORE_APP_SEARCH.MiniAppSearch.StHotWatching;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.GuessYouLikeItem;
import com.tencent.mobileqq.mini.entry.search.comm.ItemInfo;
import com.tencent.mobileqq.mini.entry.search.comm.LiveInfo;
import com.tencent.mobileqq.mini.entry.search.comm.RecommendForYouItem;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.comm.TitleInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class MiniAppSearchDataManager
  implements Manager
{
  public static final int GUESS_YOU_LIKE_COUNT = 4;
  public static final int MAX_HISTORY_SEARCH_NUM = 20;
  private static final String MINI_APP_NATIVE_SEARCH = "mini_app_native_search";
  public static final String TAG = "MiniAppSearchDataManager";
  private volatile boolean isFinished = true;
  private volatile boolean isLoading;
  private volatile boolean isNoResult;
  private volatile COMM.StCommonExt mExtInfo;
  private LinkedList<String> mHistorySearchList = new LinkedList();
  private MiniAppSearchDataManager.HotSearchDataChangedListener mHotSearchDataChangedListener;
  private volatile COMM.StCommonExt mHotSearchExtInfo;
  private List<ItemInfo> mHotSearchList = new ArrayList();
  private Object mLock = new Object();
  private MiniAppSearchDataManager.SearchResultDataChangedListener mResultDataChangedListener;
  private List<SearchInfo> mSearchResultList = new ArrayList();
  private ConcurrentHashMap<Integer, List<ItemInfo>> mSearchResultMap = new ConcurrentHashMap();
  private List<Integer> mSortList = new ArrayList();
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
    runOnMainThread(new MiniAppSearchDataManager.8(this, localArrayList));
  }
  
  private void checkNetwork()
  {
    if ((!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) && (this.mResultDataChangedListener != null))
    {
      this.mSearchResultList.clear();
      this.mResultDataChangedListener.onResultDataChanged();
      QLog.d("MiniAppSearchDataManager", 1, "checkNetwork, network not available");
    }
  }
  
  private void updateGuessYouLikeData(List<STORE_APP_CLIENT.StoreAppInfo> arg1)
  {
    if (??? == null) {
      QLog.d("MiniAppSearchDataManager", 1, "updateGuessYouLikeData, data is null!");
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localArrayList = new ArrayList();
      } while ((??? == null) || (???.isEmpty()));
      localObject1 = (List)this.mSearchResultMap.get(Integer.valueOf(3));
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ItemInfo)((Iterator)localObject1).next();
          if ((localObject2 instanceof TitleInfo)) {
            localArrayList.add(localObject2);
          }
        }
      }
      ??? = ???.iterator();
      while (???.hasNext())
      {
        localObject1 = (STORE_APP_CLIENT.StoreAppInfo)???.next();
        if ((localObject1 != null) && (((STORE_APP_CLIENT.StoreAppInfo)localObject1).userAppInfo.get() != null)) {
          localArrayList.add(new GuessYouLikeItem((STORE_APP_CLIENT.StoreAppInfo)localObject1));
        }
      }
    } while (localArrayList.isEmpty());
    this.mSearchResultMap.put(Integer.valueOf(3), localArrayList);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mLock)
    {
      QLog.d("MiniAppSearchDataManager", 1, "updateGuessYouLikeData, sortList: " + this.mSortList);
      if ((this.mSortList != null) && (!this.mSortList.isEmpty()))
      {
        localObject1 = this.mSortList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          int i = ((Integer)((Iterator)localObject1).next()).intValue();
          localObject2 = (List)this.mSearchResultMap.get(Integer.valueOf(i));
          if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
            localArrayList.addAll((Collection)localObject2);
          }
        }
      }
    }
    runOnMainThread(new MiniAppSearchDataManager.7(this, localList));
  }
  
  private void updateHotSearchData(MiniAppSearch.StGetHotSearchAppsRsp arg1)
  {
    int j = 0;
    if (??? == null)
    {
      QLog.e("MiniAppSearchDataManager", 1, "updateHotSearchData, response is null!");
      return;
    }
    this.mTitle = ???.title.get();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = ???.appList.get();
    int i;
    Object localObject4;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      ((List)localObject1).add(new TitleInfo(???.title.get()));
      localObject3 = ((List)localObject3).iterator();
      i = 0;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (STORE_APP_CLIENT.StoreAppInfo)((Iterator)localObject3).next();
        if ((localObject4 == null) || (((STORE_APP_CLIENT.StoreAppInfo)localObject4).userAppInfo.get() == null)) {
          break label710;
        }
        localObject4 = new SearchInfo((STORE_APP_CLIENT.StoreAppInfo)localObject4);
        ((SearchInfo)localObject4).setPosition(i);
        ((List)localObject1).add(localObject4);
        i += 1;
      }
    }
    label670:
    label710:
    for (;;)
    {
      break;
      this.mSearchResultMap.put(Integer.valueOf(1), localObject1);
      localObject3 = ???.watchingList.get();
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        localArrayList1.add(new TitleInfo(???.watchTitle.get()));
        localObject3 = ((List)localObject3).iterator();
        i = j;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (MiniAppSearch.StHotWatching)((Iterator)localObject3).next();
          if (localObject4 != null)
          {
            localObject4 = new LiveInfo((MiniAppSearch.StHotWatching)localObject4);
            ((LiveInfo)localObject4).setPosition(i);
            localArrayList1.add(localObject4);
            i += 1;
          }
        }
        this.mSearchResultMap.put(Integer.valueOf(2), localArrayList1);
      }
      localObject3 = ???.guessYouList.get();
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        localObject4 = new TitleInfo(???.guessTitle.get());
        ((TitleInfo)localObject4).setRefreshButtonVisibility(true);
        localArrayList2.add(localObject4);
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (STORE_APP_CLIENT.StoreAppInfo)((Iterator)localObject3).next();
          if ((localObject4 != null) && (((STORE_APP_CLIENT.StoreAppInfo)localObject4).userAppInfo.get() != null)) {
            localArrayList2.add(new GuessYouLikeItem((STORE_APP_CLIENT.StoreAppInfo)localObject4));
          }
        }
        this.mSearchResultMap.put(Integer.valueOf(3), localArrayList2);
      }
      localObject3 = new ArrayList();
      localObject4 = ???.sortList.get();
      QLog.d("MiniAppSearchDataManager", 1, "updateHotSearchData, sortList: " + localObject4);
      if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
        ??? = ((List)localObject4).iterator();
      }
      while (???.hasNext())
      {
        i = ((Integer)???.next()).intValue();
        localObject1 = (List)this.mSearchResultMap.get(Integer.valueOf(i));
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          ((List)localObject3).addAll((Collection)localObject1);
          continue;
          if (???.sort.get() != 2) {
            break label670;
          }
          ((List)localObject3).addAll(localArrayList1);
          ((List)localObject3).addAll((Collection)localObject1);
          ((List)localObject3).addAll(localArrayList2);
        }
      }
      synchronized (this.mLock)
      {
        this.mSortList = ((List)localObject4);
        runOnMainThread(new MiniAppSearchDataManager.5(this, (List)localObject3));
        return;
        ((List)localObject3).addAll((Collection)localObject1);
        ((List)localObject3).addAll(localArrayList1);
        ((List)localObject3).addAll(localArrayList2);
      }
    }
  }
  
  private void updateSearchResultData(List<STORE_APP_CLIENT.StoreAppInfo> paramList1, List<MiniAppSearch.SearchExtInfo> paramList, List<STORE_APP_CLIENT.StoreAppInfo> paramList2)
  {
    if (paramList1 == null)
    {
      QLog.d("MiniAppSearchDataManager", 1, "updateSearchResultData, data is null!");
      return;
    }
    this.isNoResult = false;
    HashMap localHashMap = new HashMap();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (MiniAppSearch.SearchExtInfo)paramList.next();
        if ((localObject1 != null) && (((MiniAppSearch.SearchExtInfo)localObject1).appid != null))
        {
          localHashMap.put(((MiniAppSearch.SearchExtInfo)localObject1).appid.get(), localObject1);
          QLog.d("MiniAppSearchDataManager", 1, "updateSearchResultData, appid: " + ((MiniAppSearch.SearchExtInfo)localObject1).appid.get());
        }
      }
    }
    paramList = new ArrayList();
    Object localObject1 = paramList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (STORE_APP_CLIENT.StoreAppInfo)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((STORE_APP_CLIENT.StoreAppInfo)localObject2).userAppInfo.get() != null))
      {
        localObject2 = new SearchInfo((STORE_APP_CLIENT.StoreAppInfo)localObject2);
        if (localHashMap.get(((SearchInfo)localObject2).miniAppInfo.appId) != null) {
          ((SearchInfo)localObject2).setSearchExtInfo((MiniAppSearch.SearchExtInfo)localHashMap.get(((SearchInfo)localObject2).miniAppInfo.appId));
        }
        paramList.add(localObject2);
      }
    }
    if ((paramList1 == null) || (paramList1.isEmpty()))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (STORE_APP_CLIENT.StoreAppInfo)paramList1.next();
        if ((paramList2 != null) && (paramList2.userAppInfo.get() != null)) {
          paramList.add(new RecommendForYouItem(paramList2));
        }
      }
      this.isNoResult = true;
      QLog.d("MiniAppSearchDataManager", 1, "updateSearchResultData, use recommend list");
    }
    runOnMainThread(new MiniAppSearchDataManager.6(this, paramList));
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
  
  public boolean isNoResult()
  {
    return this.isNoResult;
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
      MiniAppCmdUtil.getInstance().searchApp(localStCommonExt, paramString, new MiniAppSearchDataManager.4(this));
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
  
  public void sendGuessYouLikeRequest()
  {
    checkNetwork();
    MiniAppCmdUtil.getInstance().guessYouLike(this.mHotSearchExtInfo, 4, new MiniAppSearchDataManager.3(this));
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