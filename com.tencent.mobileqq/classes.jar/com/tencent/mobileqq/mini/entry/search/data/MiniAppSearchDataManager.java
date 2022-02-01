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
  private volatile boolean isLoading = false;
  private volatile boolean isNoResult = false;
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
    if ((paramList != null) && (paramList.size() > 0))
    {
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
      return;
    }
    QLog.d("MiniAppSearchDataManager", 1, "updateSearchResultData, data is null!");
  }
  
  private void checkNetwork()
  {
    if ((!NetworkUtil.a(BaseApplicationImpl.getContext())) && (this.mResultDataChangedListener != null))
    {
      this.mSearchResultList.clear();
      this.mResultDataChangedListener.onResultDataChanged();
      QLog.d("MiniAppSearchDataManager", 1, "checkNetwork, network not available");
    }
  }
  
  private void updateGuessYouLikeData(List<STORE_APP_CLIENT.StoreAppInfo> arg1)
  {
    if (??? == null)
    {
      QLog.d("MiniAppSearchDataManager", 1, "updateGuessYouLikeData, data is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((??? != null) && (!???.isEmpty()))
    {
      Object localObject2 = (List)this.mSearchResultMap.get(Integer.valueOf(3));
      Object localObject3;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ItemInfo)((Iterator)localObject2).next();
          if ((localObject3 instanceof TitleInfo)) {
            localArrayList.add(localObject3);
          }
        }
      }
      ??? = ???.iterator();
      while (???.hasNext())
      {
        localObject2 = (STORE_APP_CLIENT.StoreAppInfo)???.next();
        if ((localObject2 != null) && (((STORE_APP_CLIENT.StoreAppInfo)localObject2).userAppInfo.get() != null)) {
          localArrayList.add(new GuessYouLikeItem((STORE_APP_CLIENT.StoreAppInfo)localObject2));
        }
      }
      if (!localArrayList.isEmpty())
      {
        this.mSearchResultMap.put(Integer.valueOf(3), localArrayList);
        localArrayList = new ArrayList();
        synchronized (this.mLock)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateGuessYouLikeData, sortList: ");
          ((StringBuilder)localObject2).append(this.mSortList);
          QLog.d("MiniAppSearchDataManager", 1, ((StringBuilder)localObject2).toString());
          if ((this.mSortList != null) && (!this.mSortList.isEmpty()))
          {
            localObject2 = this.mSortList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              int i = ((Integer)((Iterator)localObject2).next()).intValue();
              localObject3 = (List)this.mSearchResultMap.get(Integer.valueOf(i));
              if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
                localArrayList.addAll((Collection)localObject3);
              }
            }
          }
          runOnMainThread(new MiniAppSearchDataManager.7(this, localArrayList));
          return;
        }
      }
    }
  }
  
  private void updateHotSearchData(MiniAppSearch.StGetHotSearchAppsRsp arg1)
  {
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
    int j = 0;
    int i;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      ((List)localObject1).add(new TitleInfo(???.title.get()));
      localObject3 = ((List)localObject3).iterator();
      i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (STORE_APP_CLIENT.StoreAppInfo)((Iterator)localObject3).next();
        if ((localObject4 != null) && (((STORE_APP_CLIENT.StoreAppInfo)localObject4).userAppInfo.get() != null))
        {
          localObject4 = new SearchInfo((STORE_APP_CLIENT.StoreAppInfo)localObject4);
          ((SearchInfo)localObject4).setPosition(i);
          ((List)localObject1).add(localObject4);
          i += 1;
        }
      }
      this.mSearchResultMap.put(Integer.valueOf(1), localObject1);
    }
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
    Object localObject4 = ???.sortList.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateHotSearchData, sortList: ");
    localStringBuilder.append(localObject4);
    QLog.d("MiniAppSearchDataManager", 1, localStringBuilder.toString());
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
        if (???.sort.get() == 2)
        {
          ((List)localObject3).addAll(localArrayList1);
          ((List)localObject3).addAll((Collection)localObject1);
          ((List)localObject3).addAll(localArrayList2);
        }
        else
        {
          ((List)localObject3).addAll((Collection)localObject1);
          ((List)localObject3).addAll(localArrayList1);
          ((List)localObject3).addAll(localArrayList2);
        }
      }
    }
    synchronized (this.mLock)
    {
      this.mSortList = ((List)localObject4);
      runOnMainThread(new MiniAppSearchDataManager.5(this, (List)localObject3));
      return;
    }
    for (;;)
    {
      throw localObject2;
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
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (MiniAppSearch.SearchExtInfo)paramList.next();
        if ((localObject1 != null) && (((MiniAppSearch.SearchExtInfo)localObject1).appid != null))
        {
          localHashMap.put(((MiniAppSearch.SearchExtInfo)localObject1).appid.get(), localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateSearchResultData, appid: ");
          ((StringBuilder)localObject2).append(((MiniAppSearch.SearchExtInfo)localObject1).appid.get());
          QLog.d("MiniAppSearchDataManager", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
    paramList = new ArrayList();
    Object localObject1 = paramList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (STORE_APP_CLIENT.StoreAppInfo)((Iterator)localObject1).next();
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
      BaseApplication localBaseApplication = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localStringBuilder.append("mini_app_native_search");
      localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().remove("key_mini_app_native_search_history").apply();
    }
  }
  
  public void clearSearchResult()
  {
    this.mSearchResultList.clear();
  }
  
  public List<String> getCachedHistorySearchList()
  {
    this.mHistorySearchList.clear();
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null)
    {
      String str = ((AppInterface)localObject).getCurrentAccountUin();
      localObject = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append("mini_app_native_search");
      str = localStringBuilder.toString();
      int i = 0;
      localObject = ((BaseApplication)localObject).getSharedPreferences(str, 0).getString("key_mini_app_native_search_history", null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("_");
        int j = localObject.length;
        while (i < j)
        {
          str = localObject[i];
          if (!TextUtils.isEmpty(str)) {
            this.mHistorySearchList.add(str);
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
      if ((!this.isFinished) && (!this.isLoading))
      {
        this.isLoading = true;
        COMM.StCommonExt localStCommonExt = this.mExtInfo;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("loadMoreSearchAppDataRequest, isFinished: ");
        ((StringBuilder)???).append(this.isFinished);
        ((StringBuilder)???).append(", isLoading: ");
        ((StringBuilder)???).append(this.isLoading);
        ((StringBuilder)???).append(", keyWord: ");
        ((StringBuilder)???).append(paramString);
        QLog.d("MiniAppSearchDataManager", 1, ((StringBuilder)???).toString());
        MiniAppCmdUtil.getInstance().searchApp(localStCommonExt, paramString, new MiniAppSearchDataManager.4(this));
        return;
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.mHotSearchDataChangedListener = null;
    this.mResultDataChangedListener = null;
    List localList = this.mSearchResultList;
    if (localList != null) {
      localList.clear();
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
      Object localObject1 = paramString.getCurrentAccountUin();
      paramString = BaseApplication.getContext();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append("mini_app_native_search");
      localObject1 = ((StringBuilder)localObject2).toString();
      int i = 0;
      paramString = paramString.getSharedPreferences((String)localObject1, 0);
      localObject1 = new StringBuilder();
      while ((i < 20) && (i < this.mHistorySearchList.size()))
      {
        localObject2 = (String)this.mHistorySearchList.get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("_");
        }
        i += 1;
      }
      paramString.edit().putString("key_mini_app_native_search_history", ((StringBuilder)localObject1).toString()).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager
 * JD-Core Version:    0.7.0.1
 */