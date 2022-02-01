package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.GlobalSearchObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.query.QueryArgs;
import com.tencent.mobileqq.fts.query.QueryArgs.Builder;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchEngine;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultDetailModel;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultModel;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.MsgSearchContactInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FTSMessageSearchEngine
  extends FTSEntitySearchEngine
{
  private static ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, SoftReference<ArrayList<FTSEntity>>> b = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, SoftReference<ArrayList<FTSEntitySearchResultModel>>> c = new ConcurrentHashMap();
  private GlobalSearchObserver jdField_a_of_type_ComTencentMobileqqAppGlobalSearchObserver = new FTSMessageSearchEngine.8(this);
  private RecentUserProxy jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private Comparator<FTSEntity> jdField_a_of_type_JavaUtilComparator = new FTSMessageSearchEngine.6(this);
  private ConcurrentHashMap<String, StringBuilder> d = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object> e = new ConcurrentHashMap();
  
  public FTSMessageSearchEngine(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    }
    int i = 0;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.a(paramString, paramInt)) {
      i = 10;
    }
    if (paramInt == 3000) {
      return i + 2;
    }
    if (paramInt == 1)
    {
      int j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isTroopMark(paramString, paramInt)) {
        j = i + 4;
      }
      return j + 3;
    }
    return i + 1;
  }
  
  private ArrayList<FTSMessageSearchEngine.FTSSearchResultItem> a(ArrayList<FTSEntity> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Object localObject1 = new HashMap();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        FTSMessage localFTSMessage = (FTSMessage)paramArrayList.next();
        if ((localFTSMessage != null) && (localFTSMessage.msgExts != null))
        {
          int i = localFTSMessage.istroop;
          Object localObject2 = String.valueOf(localFTSMessage.uin);
          String str = UinTypeUtil.a((String)localObject2, i);
          if (!((HashMap)localObject1).containsKey(str))
          {
            FTSMessageSearchEngine.FTSSearchResultItem localFTSSearchResultItem = new FTSMessageSearchEngine.FTSSearchResultItem();
            localFTSSearchResultItem.jdField_a_of_type_JavaUtilList = new ArrayList();
            localFTSSearchResultItem.jdField_a_of_type_JavaUtilList.add(localFTSMessage);
            localFTSSearchResultItem.jdField_a_of_type_Int = localFTSMessage.mSearchScene;
            localFTSSearchResultItem.b = localFTSMessage.mProximity;
            localFTSSearchResultItem.c = a((String)localObject2, i);
            localFTSSearchResultItem.jdField_a_of_type_Long = ((TextMsgExts)localFTSMessage.msgExts).time;
            localFTSSearchResultItem.jdField_a_of_type_JavaUtilHashSet = new HashSet();
            localFTSSearchResultItem.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localFTSMessage.mOId));
            localFTSSearchResultItem.d = localFTSMessage.searchStrategy;
            localFTSSearchResultItem.e = localFTSMessage.senderNum;
            localFTSSearchResultItem.f = localFTSMessage.friendNum;
            localFTSSearchResultItem.g = localFTSMessage.friendIndex;
            ((HashMap)localObject1).put(str, localFTSSearchResultItem);
          }
          else
          {
            localObject2 = (FTSMessageSearchEngine.FTSSearchResultItem)((HashMap)localObject1).get(str);
            if (((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localFTSMessage.mOId)))
            {
              if (localFTSMessage.mSearchScene == ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Int)
              {
                if (localFTSMessage.mProximity < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).b) {
                  ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).b = localFTSMessage.mProximity;
                }
                if (((TextMsgExts)localFTSMessage.msgExts).time > ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Long) {
                  ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Long = ((TextMsgExts)localFTSMessage.msgExts).time;
                }
                if (localFTSMessage.senderNum > ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).e) {
                  ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).e = localFTSMessage.senderNum;
                }
                if (localFTSMessage.friendNum > ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).f) {
                  ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).f = localFTSMessage.friendNum;
                }
                if (localFTSMessage.friendIndex > ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).g) {
                  ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).g = localFTSMessage.friendIndex;
                }
              }
              else if (localFTSMessage.mSearchScene < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Int)
              {
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).b = localFTSMessage.mProximity;
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Long = ((TextMsgExts)localFTSMessage.msgExts).time;
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).e = localFTSMessage.senderNum;
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).f = localFTSMessage.friendNum;
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).g = localFTSMessage.friendIndex;
              }
              if (localFTSMessage.mSearchScene < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Int) {
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Int = localFTSMessage.mSearchScene;
              }
              if (localFTSMessage.searchStrategy < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).d) {
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).d = localFTSMessage.searchStrategy;
              }
              ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_JavaUtilList.add(localFTSMessage);
            }
          }
        }
      }
      paramArrayList = new ArrayList();
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramArrayList.add(((Map.Entry)((Iterator)localObject1).next()).getValue());
      }
      Collections.sort(paramArrayList, new FTSMessageSearchEngine.7(this));
      return paramArrayList;
    }
    return new ArrayList();
  }
  
  private List<FTSEntitySearchResultModel> a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, ArrayList<FTSEntity> paramArrayList, boolean paramBoolean2)
  {
    Object localObject1 = new HashMap();
    paramArrayList = paramArrayList.iterator();
    int i;
    Object localObject4;
    Object localObject5;
    while (paramArrayList.hasNext())
    {
      localObject2 = (FTSMessage)paramArrayList.next();
      if ((localObject2 != null) && (((FTSMessage)localObject2).msgExts != null))
      {
        i = ((FTSMessage)localObject2).istroop;
        localObject3 = String.valueOf(((FTSMessage)localObject2).uin);
        localObject4 = UinTypeUtil.a((String)localObject3, i);
        if (!((HashMap)localObject1).containsKey(localObject4))
        {
          localObject5 = new FTSMessageSearchEngine.FTSSearchResultItem();
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_JavaUtilList = new ArrayList();
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_JavaUtilList.add(localObject2);
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).b = ((FTSMessage)localObject2).mProximity;
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).c = a((String)localObject3, i);
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_Long = ((TextMsgExts)((FTSMessage)localObject2).msgExts).time;
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_JavaUtilHashSet = new HashSet();
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(((FTSMessage)localObject2).mOId));
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).d = ((FTSMessage)localObject2).searchStrategy;
          ((HashMap)localObject1).put(localObject4, localObject5);
        }
        else
        {
          localObject3 = (FTSMessageSearchEngine.FTSSearchResultItem)((HashMap)localObject1).get(localObject4);
          if (((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(((FTSMessage)localObject2).mOId)))
          {
            if (((FTSMessage)localObject2).mProximity < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).b) {
              ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).b = ((FTSMessage)localObject2).mProximity;
            }
            if (((TextMsgExts)((FTSMessage)localObject2).msgExts).time > ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).jdField_a_of_type_Long) {
              ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).jdField_a_of_type_Long = ((TextMsgExts)((FTSMessage)localObject2).msgExts).time;
            }
            if (((FTSMessage)localObject2).searchStrategy < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).d) {
              ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).d = ((FTSMessage)localObject2).searchStrategy;
            }
            ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
      }
    }
    paramArrayList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramArrayList.add(((Map.Entry)((Iterator)localObject1).next()).getValue());
    }
    Collections.sort(paramArrayList, new FTSMessageSearchEngine.4(this));
    localObject1 = SQLiteFTSUtils.a(paramString2);
    Object localObject2 = new ArrayList();
    Object localObject3 = paramArrayList.iterator();
    do
    {
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (FTSMessageSearchEngine.FTSSearchResultItem)((Iterator)localObject3).next();
      } while (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(((FTSMessage)((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).jdField_a_of_type_JavaUtilList.get(0)).uin), ((FTSMessage)((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).jdField_a_of_type_JavaUtilList.get(0)).istroop));
      localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramString1 == null) {
        paramArrayList = paramString2;
      } else {
        paramArrayList = paramString1;
      }
      paramArrayList = new FTSMessageSearchResultModel((QQAppInterface)localObject5, paramArrayList, paramString2, (ArrayList)localObject1, ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).jdField_a_of_type_JavaUtilList, paramString3, null);
      paramArrayList.jdField_a_of_type_Int = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).d;
      paramArrayList.b = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).e;
      paramArrayList.c = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).f;
      paramArrayList.d = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).g;
      ((List)localObject2).add(paramArrayList);
      i = SearchEntryConfigManager.a("fts_native_chathistory_maxnum", 3);
    } while ((!paramBoolean1) || (((List)localObject2).size() < i + 1));
    return localObject2;
  }
  
  private List<FTSEntitySearchResultDetailModel> a(String paramString, ArrayList<FTSEntity> paramArrayList)
  {
    ArrayList localArrayList = SQLiteFTSUtils.a(paramString);
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (paramArrayList != null)
    {
      localObject2 = new HashSet();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        FTSEntity localFTSEntity = (FTSEntity)paramArrayList.next();
        if (((HashSet)localObject2).add(Long.valueOf(localFTSEntity.mOId))) {
          ((ArrayList)localObject1).add(localFTSEntity);
        }
      }
    }
    Collections.sort((List)localObject1, this.jdField_a_of_type_JavaUtilComparator);
    paramArrayList = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FTSEntity)((Iterator)localObject1).next();
      paramArrayList.add(new FTSMessageSearchResultDetailModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localArrayList, (FTSEntity)localObject2));
    }
    return paramArrayList;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      if ((localTroopInfo == null) || (localTroopInfo.troopname == null))
      {
        paramQQAppInterface = ((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
        return (paramQQAppInterface != null) && (paramQQAppInterface.name != null);
      }
    }
    else if (3000 == paramInt)
    {
      paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
      if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.discussionName))) {
        return false;
      }
    }
    else if (paramInt != 0) {}
    return true;
  }
  
  public static boolean a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      paramString = (Boolean)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString == null) {
        return false;
      }
      boolean bool = paramString.booleanValue();
      return bool;
    }
  }
  
  public List<FTSEntitySearchResultModel> a(SearchRequest paramSearchRequest)
  {
    if (paramSearchRequest == null) {
      return null;
    }
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.e = System.nanoTime();
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 0L;
    boolean bool;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null) {
      bool = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("fts_search_is_limited", true);
    } else {
      bool = true;
    }
    if (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {
      return b(paramSearchRequest, bool);
    }
    return a(paramSearchRequest, bool);
  }
  
  public List<FTSEntitySearchResultModel> a(SearchRequest arg1, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine");
    }
    int i1 = TextUtils.isEmpty(???.jdField_a_of_type_JavaLangString) ^ true;
    if (TextUtils.isEmpty(???.jdField_a_of_type_JavaLangString)) {
      j = 0;
    } else {
      j = ???.jdField_a_of_type_JavaLangString.length();
    }
    int k;
    if (paramBoolean) {
      k = 1;
    } else {
      k = 2;
    }
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Int = i1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.b = j;
    Object localObject1 = ???.jdField_a_of_type_JavaLangString;
    Object localObject3;
    int i;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("keyword bytes length: ");
      if (localObject1 == null) {
        i = 0;
      } else {
        i = ((String)localObject1).getBytes().length;
      }
      ((StringBuilder)localObject3).append(i);
      QLog.i("FTSMessageSearchEngine", 2, ((StringBuilder)localObject3).toString());
    }
    boolean bool;
    int m;
    if ((???.jdField_a_of_type_AndroidOsBundle != null) && (???.jdField_a_of_type_AndroidOsBundle.containsKey("search_restrict_mem")))
    {
      localObject3 = ???.jdField_a_of_type_AndroidOsBundle.getString("search_restrict_mem");
      localObject4 = ???.jdField_a_of_type_AndroidOsBundle.getString("search_restrict_uin");
      bool = ???.jdField_a_of_type_AndroidOsBundle.getBoolean("search_restrict_empty");
      i = ???.jdField_a_of_type_AndroidOsBundle.getInt("search_restrict_uintype");
      m = 1;
    }
    else
    {
      if (TextUtils.isEmpty(???.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine, keyword is null");
        }
        return new ArrayList();
      }
      m = 0;
      i = -1;
      localObject4 = null;
      bool = false;
      localObject3 = null;
    }
    long l3 = 0L;
    Object localObject5;
    if (m == 0) {
      if (paramBoolean)
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        b.clear();
      }
      else
      {
        synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
        {
          if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().contains(localObject1)) {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          }
          synchronized (b)
          {
            if (!b.keySet().contains(localObject1))
            {
              b.clear();
            }
            else
            {
              localObject5 = (ArrayList)((SoftReference)b.get(localObject1)).get();
              if (localObject5 != null)
              {
                i = ((ArrayList)localObject5).size();
                l1 = System.nanoTime();
                localObject1 = a((String)localObject1, (String)localObject1, null, paramBoolean, (ArrayList)localObject5, true);
                l1 = (System.nanoTime() - l1) / 1000000L;
                l2 = l1 + 0L;
                localObject3 = new HashMap();
                ((HashMap)localObject3).put("keyNum", String.valueOf(i1));
                ((HashMap)localObject3).put("firstKeyLen", String.valueOf(j));
                ((HashMap)localObject3).put("searchPage", String.valueOf(k));
                ((HashMap)localObject3).put("useCache", String.valueOf(1));
                ((HashMap)localObject3).put("searchCost", String.valueOf(l2));
                ((HashMap)localObject3).put("singleSearchResultNum", String.valueOf(i));
                ((HashMap)localObject3).put("singleSearchCost", String.valueOf(0L));
                ((HashMap)localObject3).put("groupSortCost", String.valueOf(l1));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFtsSearchEvent", true, l2, 0L, (HashMap)localObject3, null);
                return localObject1;
              }
            }
          }
        }
      }
    }
    long l6 = System.nanoTime();
    ((IFTSDBRuntimeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).refreshFTS(1);
    long l7 = System.nanoTime();
    if (m != 0)
    {
      if (bool) {
        ??? = (ArrayList)new QueryArgs.Builder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Long.valueOf((String)localObject4).longValue()).a().a();
      }
      for (;;)
      {
        l2 = 0L;
        l1 = 0L;
        i = 0;
        break;
        localObject5 = (ArrayList)new QueryArgs.Builder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Long.valueOf((String)localObject4).longValue()).a(str).a(FTSMessage.class).a(false).b(false).a(null).a().a();
        ??? = (SearchRequest)localObject5;
        if (i != -1)
        {
          ??? = (ArrayList)new QueryArgs.Builder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(str).a(Long.valueOf((String)localObject4).longValue(), i).a(FTSMessage.class).b(false).a(false).a().a();
          if ((localObject5 != null) && (??? != null))
          {
            ((ArrayList)localObject5).addAll(???);
            ??? = (SearchRequest)localObject5;
          }
          else if (localObject5 != null)
          {
            ??? = (SearchRequest)localObject5;
          }
        }
      }
    }
    long l1 = System.nanoTime();
    ??? = (ArrayList)new QueryArgs.Builder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(str).a(FTSMessage.class).a(paramBoolean).b(false).a().a();
    if ((??? != null) && (!???.isEmpty()))
    {
      localObject4 = ???.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((FTSMessage)((Iterator)localObject4).next()).searchStrategy = 1;
      }
    }
    l1 = (System.nanoTime() - l1) / 1000000L;
    if (??? == null) {
      i = 0;
    } else {
      i = ???.size();
    }
    long l2 = l1;
    l1 = 0L + l1;
    Object localObject4 = null;
    long l8 = System.nanoTime();
    if (??? != null)
    {
      l3 = System.nanoTime();
      localObject4 = str;
      localObject5 = a(str, str, (String)localObject3, paramBoolean, ???, m ^ 0x1);
      l4 = (System.nanoTime() - l3) / 1000000L;
      l5 = l1 + l4;
      localObject3 = localObject5;
      l3 = l4;
      l1 = l5;
      if (m == 0) {
        if (paramBoolean)
        {
          if (???.size() < 2000) {
            bool = true;
          } else {
            bool = false;
          }
          localObject3 = localObject5;
          l3 = l4;
          l1 = l5;
          if (bool)
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject4, Boolean.valueOf(bool));
            b.put(localObject4, new SoftReference(???));
            localObject3 = localObject5;
            l3 = l4;
            l1 = l5;
          }
        }
        else
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject4, Boolean.valueOf(true));
          b.put(localObject4, new SoftReference(???));
          localObject3 = localObject5;
          l3 = l4;
          l1 = l5;
        }
      }
    }
    else
    {
      localObject3 = localObject4;
    }
    long l4 = System.nanoTime();
    localObject4 = new HashMap();
    int n;
    if (localObject3 != null) {
      n = ((List)localObject3).size();
    } else {
      n = 0;
    }
    ((HashMap)localObject4).put("queryConversationSize", Integer.toString(n));
    if (??? != null) {
      n = ???.size();
    } else {
      n = 0;
    }
    ((HashMap)localObject4).put("resultSize", Integer.toString(n));
    if (str != null) {
      n = str.length();
    } else {
      n = 0;
    }
    ((HashMap)localObject4).put("keyLength", Integer.toString(n));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchMessageStatistic_FTS", true, (l4 - l7) / 1000000L, 0L, (HashMap)localObject4, null);
    long l5 = System.nanoTime();
    if (QLog.isColorLevel())
    {
      if (??? != null) {
        n = ???.size();
      } else {
        n = 0;
      }
      QLog.d("FTSMessageSearchEngine", 2, String.format("fts search,size:%d, refresh time: %dms, query time: %dms, convert time: %dms, report time: %dms", new Object[] { Integer.valueOf(n), Long.valueOf((l7 - l6) / 1000000L), Long.valueOf((l8 - l7) / 1000000L), Long.valueOf((l4 - l8) / 1000000L), Long.valueOf((l5 - l4) / 1000000L) }));
    }
    if (m == 0)
    {
      ??? = new HashMap();
      ???.put("keyNum", String.valueOf(i1));
      ???.put("firstKeyLen", String.valueOf(j));
      ???.put("searchPage", String.valueOf(k));
      ???.put("useCache", String.valueOf(0));
      ???.put("searchCost", String.valueOf(l1));
      ???.put("singleSearchResultNum", String.valueOf(i));
      ???.put("singleSearchCost", String.valueOf(l2));
      ???.put("groupSortCost", String.valueOf(l3));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFtsSearchEvent", true, l1, 0L, ???, null);
    }
    int j = 0;
    if ((m == 0) && ((localObject3 == null) || (((List)localObject3).isEmpty())) && (!TextUtils.isEmpty(str)) && (str.getBytes().length < 255))
    {
      ??? = Pattern.compile("[一-龥]*").matcher(str);
      do
      {
        i = j;
        if (!???.find()) {
          break;
        }
      } while (???.group().length() < 4);
      i = 1;
      if (i != 0)
      {
        this.e.put(str, new Object());
        return a(str, paramBoolean);
      }
    }
    return localObject3;
  }
  
  /* Error */
  public List<FTSEntitySearchResultModel> a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 609	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokestatic 615	com/tencent/mobileqq/utils/NetworkUtil:isNetSupport	(Landroid/content/Context;)Z
    //   10: istore 8
    //   12: aconst_null
    //   13: astore 25
    //   15: iload 8
    //   17: ifne +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_0
    //   23: getfield 65	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: getstatic 620	com/tencent/mobileqq/app/BusinessHandlerFactory:GLOBAL_SEARCH_HANDLER	Ljava/lang/String;
    //   29: invokevirtual 624	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   32: checkcast 626	com/tencent/mobileqq/app/GlobalSearchHandler
    //   35: astore 26
    //   37: new 88	java/util/ArrayList
    //   40: dup
    //   41: invokespecial 143	java/util/ArrayList:<init>	()V
    //   44: astore 27
    //   46: aload 27
    //   48: aload_1
    //   49: invokevirtual 230	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload 26
    //   55: aload 27
    //   57: invokevirtual 629	com/tencent/mobileqq/app/GlobalSearchHandler:a	(Ljava/util/ArrayList;)V
    //   60: aload_0
    //   61: getfield 56	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   64: aload_1
    //   65: invokevirtual 336	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: astore 26
    //   70: aload 26
    //   72: ifnull +1208 -> 1280
    //   75: aload 26
    //   77: monitorenter
    //   78: aload 26
    //   80: ldc2_w 630
    //   83: invokevirtual 635	java/lang/Object:wait	(J)V
    //   86: aload 26
    //   88: monitorexit
    //   89: aload_0
    //   90: getfield 43	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   93: astore 26
    //   95: aload 26
    //   97: monitorenter
    //   98: aload_0
    //   99: getfield 636	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: aload_1
    //   103: invokestatic 640	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   106: ifne +8 -> 114
    //   109: aload 26
    //   111: monitorexit
    //   112: aconst_null
    //   113: areturn
    //   114: aload 26
    //   116: monitorexit
    //   117: aload_0
    //   118: getfield 54	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   121: aload_1
    //   122: invokevirtual 336	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast 397	java/lang/StringBuilder
    //   128: astore 26
    //   130: aload 26
    //   132: ifnull +1104 -> 1236
    //   135: aload 26
    //   137: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokevirtual 643	java/lang/String:trim	()Ljava/lang/String;
    //   143: astore 27
    //   145: aload 27
    //   147: invokevirtual 393	java/lang/String:length	()I
    //   150: ifne +5 -> 155
    //   153: aconst_null
    //   154: areturn
    //   155: aload 27
    //   157: invokestatic 334	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: iconst_1
    //   161: ixor
    //   162: istore 7
    //   164: aload 27
    //   166: invokestatic 334	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifeq +8 -> 177
    //   172: iconst_0
    //   173: istore_3
    //   174: goto +9 -> 183
    //   177: aload 27
    //   179: invokevirtual 393	java/lang/String:length	()I
    //   182: istore_3
    //   183: iload_2
    //   184: ifeq +9 -> 193
    //   187: iconst_1
    //   188: istore 4
    //   190: goto +6 -> 196
    //   193: iconst_2
    //   194: istore 4
    //   196: iload 7
    //   198: putstatic 394	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils$FtsItemClickEvent:jdField_a_of_type_Int	I
    //   201: iload_3
    //   202: putstatic 395	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils$FtsItemClickEvent:b	I
    //   205: lconst_0
    //   206: lstore 9
    //   208: iload_2
    //   209: ifeq +18 -> 227
    //   212: getstatic 30	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   215: invokevirtual 443	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   218: getstatic 32	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   221: invokevirtual 443	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   224: goto +279 -> 503
    //   227: getstatic 30	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   230: astore 26
    //   232: aload 26
    //   234: monitorenter
    //   235: getstatic 30	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   238: invokevirtual 446	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   241: aload_1
    //   242: invokeinterface 449 2 0
    //   247: ifne +9 -> 256
    //   250: getstatic 30	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   253: invokevirtual 443	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   256: aload 26
    //   258: monitorexit
    //   259: getstatic 32	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   262: astore 26
    //   264: aload 26
    //   266: monitorenter
    //   267: getstatic 32	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   270: invokevirtual 446	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   273: aload_1
    //   274: invokeinterface 449 2 0
    //   279: ifne +12 -> 291
    //   282: getstatic 32	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   285: invokevirtual 443	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   288: goto +212 -> 500
    //   291: getstatic 32	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   294: aload_1
    //   295: invokevirtual 336	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   298: checkcast 451	java/lang/ref/SoftReference
    //   301: invokevirtual 453	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   304: checkcast 88	java/util/ArrayList
    //   307: astore 28
    //   309: aload 28
    //   311: ifnull +189 -> 500
    //   314: aload 28
    //   316: invokevirtual 454	java/util/ArrayList:size	()I
    //   319: istore 5
    //   321: invokestatic 348	java/lang/System:nanoTime	()J
    //   324: lstore 9
    //   326: aload_0
    //   327: aload_1
    //   328: aload 27
    //   330: aconst_null
    //   331: iload_2
    //   332: aload 28
    //   334: iconst_1
    //   335: invokespecial 456	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;Z)Ljava/util/List;
    //   338: astore_1
    //   339: invokestatic 348	java/lang/System:nanoTime	()J
    //   342: lload 9
    //   344: lsub
    //   345: ldc2_w 457
    //   348: ldiv
    //   349: lstore 9
    //   351: lload 9
    //   353: lconst_0
    //   354: ladd
    //   355: lstore 11
    //   357: new 94	java/util/HashMap
    //   360: dup
    //   361: invokespecial 95	java/util/HashMap:<init>	()V
    //   364: astore 25
    //   366: aload 25
    //   368: ldc_w 460
    //   371: iload 7
    //   373: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   376: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   379: pop
    //   380: aload 25
    //   382: ldc_w 465
    //   385: iload_3
    //   386: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   389: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   392: pop
    //   393: aload 25
    //   395: ldc_w 467
    //   398: iload 4
    //   400: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   403: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   406: pop
    //   407: aload 25
    //   409: ldc_w 469
    //   412: iconst_1
    //   413: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   416: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   419: pop
    //   420: aload 25
    //   422: ldc_w 471
    //   425: lload 11
    //   427: invokestatic 130	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   430: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   433: pop
    //   434: aload 25
    //   436: ldc_w 473
    //   439: iload 5
    //   441: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   444: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   447: pop
    //   448: aload 25
    //   450: ldc_w 475
    //   453: lconst_0
    //   454: invokestatic 130	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   457: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   460: pop
    //   461: aload 25
    //   463: ldc_w 477
    //   466: lload 9
    //   468: invokestatic 130	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   471: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   474: pop
    //   475: invokestatic 483	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   478: invokestatic 489	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   481: aconst_null
    //   482: ldc_w 491
    //   485: iconst_1
    //   486: lload 11
    //   488: lconst_0
    //   489: aload 25
    //   491: aconst_null
    //   492: invokevirtual 495	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   495: aload 26
    //   497: monitorexit
    //   498: aload_1
    //   499: areturn
    //   500: aload 26
    //   502: monitorexit
    //   503: invokestatic 348	java/lang/System:nanoTime	()J
    //   506: lstore 13
    //   508: aload_0
    //   509: getfield 65	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   512: ldc_w 497
    //   515: ldc_w 499
    //   518: invokevirtual 503	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   521: checkcast 497	com/tencent/mobileqq/fts/api/IFTSDBRuntimeService
    //   524: iconst_1
    //   525: invokeinterface 647 2 0
    //   530: invokeinterface 651 1 0
    //   535: invokestatic 348	java/lang/System:nanoTime	()J
    //   538: lstore 15
    //   540: invokestatic 348	java/lang/System:nanoTime	()J
    //   543: lstore 11
    //   545: new 509	com/tencent/mobileqq/fts/query/QueryArgs$Builder
    //   548: dup
    //   549: aload_0
    //   550: getfield 65	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   553: invokespecial 512	com/tencent/mobileqq/fts/query/QueryArgs$Builder:<init>	(Lmqq/app/AppRuntime;)V
    //   556: aload 27
    //   558: invokevirtual 532	com/tencent/mobileqq/fts/query/QueryArgs$Builder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/fts/query/QueryArgs$Builder;
    //   561: ldc 112
    //   563: invokevirtual 535	com/tencent/mobileqq/fts/query/QueryArgs$Builder:a	(Ljava/lang/Class;)Lcom/tencent/mobileqq/fts/query/QueryArgs$Builder;
    //   566: iload_2
    //   567: invokevirtual 538	com/tencent/mobileqq/fts/query/QueryArgs$Builder:a	(Z)Lcom/tencent/mobileqq/fts/query/QueryArgs$Builder;
    //   570: iconst_0
    //   571: invokevirtual 540	com/tencent/mobileqq/fts/query/QueryArgs$Builder:b	(Z)Lcom/tencent/mobileqq/fts/query/QueryArgs$Builder;
    //   574: invokevirtual 524	com/tencent/mobileqq/fts/query/QueryArgs$Builder:a	()Lcom/tencent/mobileqq/fts/query/QueryArgs;
    //   577: invokevirtual 529	com/tencent/mobileqq/fts/query/QueryArgs:a	()Ljava/util/List;
    //   580: checkcast 88	java/util/ArrayList
    //   583: astore 26
    //   585: aload 26
    //   587: ifnull +48 -> 635
    //   590: aload 26
    //   592: invokevirtual 92	java/util/ArrayList:isEmpty	()Z
    //   595: ifne +40 -> 635
    //   598: aload 26
    //   600: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   603: astore 28
    //   605: aload 28
    //   607: invokeinterface 104 1 0
    //   612: ifeq +23 -> 635
    //   615: aload 28
    //   617: invokeinterface 108 1 0
    //   622: checkcast 110	com/tencent/mobileqq/fts/v1/FTSEntity
    //   625: checkcast 112	com/tencent/mobileqq/fts/data/msg/FTSMessage
    //   628: iconst_1
    //   629: putfield 190	com/tencent/mobileqq/fts/data/msg/FTSMessage:searchStrategy	I
    //   632: goto -27 -> 605
    //   635: invokestatic 348	java/lang/System:nanoTime	()J
    //   638: lload 11
    //   640: lsub
    //   641: ldc2_w 457
    //   644: ldiv
    //   645: lstore 17
    //   647: aload 26
    //   649: ifnonnull +9 -> 658
    //   652: iconst_0
    //   653: istore 5
    //   655: goto +10 -> 665
    //   658: aload 26
    //   660: invokevirtual 454	java/util/ArrayList:size	()I
    //   663: istore 5
    //   665: lconst_0
    //   666: lload 17
    //   668: ladd
    //   669: lstore 11
    //   671: invokestatic 348	java/lang/System:nanoTime	()J
    //   674: lstore 19
    //   676: aload 26
    //   678: ifnull +151 -> 829
    //   681: aload 26
    //   683: invokevirtual 92	java/util/ArrayList:isEmpty	()Z
    //   686: ifne +143 -> 829
    //   689: invokestatic 348	java/lang/System:nanoTime	()J
    //   692: lstore 9
    //   694: aload_0
    //   695: aload_1
    //   696: aload 27
    //   698: aconst_null
    //   699: iload_2
    //   700: aload 26
    //   702: iconst_0
    //   703: invokespecial 456	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;Z)Ljava/util/List;
    //   706: astore 25
    //   708: invokestatic 348	java/lang/System:nanoTime	()J
    //   711: lload 9
    //   713: lsub
    //   714: ldc2_w 457
    //   717: ldiv
    //   718: lstore 9
    //   720: lload 11
    //   722: lload 9
    //   724: ladd
    //   725: lstore 11
    //   727: iload_2
    //   728: ifeq +66 -> 794
    //   731: aload 26
    //   733: invokevirtual 454	java/util/ArrayList:size	()I
    //   736: sipush 2000
    //   739: if_icmpge +8 -> 747
    //   742: iconst_1
    //   743: istore_2
    //   744: goto +5 -> 749
    //   747: iconst_0
    //   748: istore_2
    //   749: iload_2
    //   750: ifeq +38 -> 788
    //   753: getstatic 30	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   756: aload_1
    //   757: iload_2
    //   758: invokestatic 553	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   761: invokevirtual 554	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   764: pop
    //   765: getstatic 32	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   768: aload_1
    //   769: new 451	java/lang/ref/SoftReference
    //   772: dup
    //   773: aload 26
    //   775: invokespecial 557	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   778: invokevirtual 554	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   781: pop
    //   782: aload 25
    //   784: astore_1
    //   785: goto +47 -> 832
    //   788: aload 25
    //   790: astore_1
    //   791: goto +41 -> 832
    //   794: getstatic 30	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   797: aload_1
    //   798: iconst_1
    //   799: invokestatic 553	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   802: invokevirtual 554	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   805: pop
    //   806: getstatic 32	com/tencent/mobileqq/search/ftsmsg/FTSMessageSearchEngine:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   809: aload_1
    //   810: new 451	java/lang/ref/SoftReference
    //   813: dup
    //   814: aload 26
    //   816: invokespecial 557	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   819: invokevirtual 554	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   822: pop
    //   823: aload 25
    //   825: astore_1
    //   826: goto +6 -> 832
    //   829: aload 25
    //   831: astore_1
    //   832: invokestatic 348	java/lang/System:nanoTime	()J
    //   835: lstore 21
    //   837: new 94	java/util/HashMap
    //   840: dup
    //   841: invokespecial 95	java/util/HashMap:<init>	()V
    //   844: astore 25
    //   846: aload_1
    //   847: ifnull +14 -> 861
    //   850: aload_1
    //   851: invokeinterface 274 1 0
    //   856: istore 6
    //   858: goto +6 -> 864
    //   861: iconst_0
    //   862: istore 6
    //   864: aload 25
    //   866: ldc_w 559
    //   869: iload 6
    //   871: invokestatic 563	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   874: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   877: pop
    //   878: aload 26
    //   880: ifnull +13 -> 893
    //   883: aload 26
    //   885: invokevirtual 454	java/util/ArrayList:size	()I
    //   888: istore 6
    //   890: goto +6 -> 896
    //   893: iconst_0
    //   894: istore 6
    //   896: aload 25
    //   898: ldc_w 565
    //   901: iload 6
    //   903: invokestatic 563	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   906: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   909: pop
    //   910: aload 27
    //   912: ifnull +13 -> 925
    //   915: aload 27
    //   917: invokevirtual 393	java/lang/String:length	()I
    //   920: istore 6
    //   922: goto +6 -> 928
    //   925: iconst_0
    //   926: istore 6
    //   928: aload 25
    //   930: ldc_w 567
    //   933: iload 6
    //   935: invokestatic 563	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   938: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   941: pop
    //   942: invokestatic 483	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   945: invokestatic 489	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   948: aconst_null
    //   949: ldc_w 569
    //   952: iconst_1
    //   953: lload 21
    //   955: lload 15
    //   957: lsub
    //   958: ldc2_w 457
    //   961: ldiv
    //   962: lconst_0
    //   963: aload 25
    //   965: aconst_null
    //   966: invokevirtual 495	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   969: invokestatic 348	java/lang/System:nanoTime	()J
    //   972: lstore 23
    //   974: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   977: ifeq +106 -> 1083
    //   980: aload 26
    //   982: ifnull +13 -> 995
    //   985: aload 26
    //   987: invokevirtual 454	java/util/ArrayList:size	()I
    //   990: istore 6
    //   992: goto +6 -> 998
    //   995: iconst_0
    //   996: istore 6
    //   998: ldc_w 383
    //   1001: iconst_2
    //   1002: ldc_w 571
    //   1005: iconst_5
    //   1006: anewarray 40	java/lang/Object
    //   1009: dup
    //   1010: iconst_0
    //   1011: iload 6
    //   1013: invokestatic 574	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1016: aastore
    //   1017: dup
    //   1018: iconst_1
    //   1019: lload 15
    //   1021: lload 13
    //   1023: lsub
    //   1024: ldc2_w 457
    //   1027: ldiv
    //   1028: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1031: aastore
    //   1032: dup
    //   1033: iconst_2
    //   1034: lload 19
    //   1036: lload 15
    //   1038: lsub
    //   1039: ldc2_w 457
    //   1042: ldiv
    //   1043: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1046: aastore
    //   1047: dup
    //   1048: iconst_3
    //   1049: lload 21
    //   1051: lload 19
    //   1053: lsub
    //   1054: ldc2_w 457
    //   1057: ldiv
    //   1058: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1061: aastore
    //   1062: dup
    //   1063: iconst_4
    //   1064: lload 23
    //   1066: lload 21
    //   1068: lsub
    //   1069: ldc2_w 457
    //   1072: ldiv
    //   1073: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1076: aastore
    //   1077: invokestatic 578	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1080: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: new 94	java/util/HashMap
    //   1086: dup
    //   1087: invokespecial 95	java/util/HashMap:<init>	()V
    //   1090: astore 26
    //   1092: aload 26
    //   1094: ldc_w 460
    //   1097: iload 7
    //   1099: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1102: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1105: pop
    //   1106: aload 26
    //   1108: ldc_w 465
    //   1111: iload_3
    //   1112: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1115: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1118: pop
    //   1119: aload 26
    //   1121: ldc_w 467
    //   1124: iload 4
    //   1126: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1129: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1132: pop
    //   1133: aload 26
    //   1135: ldc_w 469
    //   1138: iconst_0
    //   1139: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1142: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1145: pop
    //   1146: aload 26
    //   1148: ldc_w 471
    //   1151: lload 11
    //   1153: invokestatic 130	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1156: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1159: pop
    //   1160: aload 26
    //   1162: ldc_w 473
    //   1165: iload 5
    //   1167: invokestatic 463	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1170: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1173: pop
    //   1174: aload 26
    //   1176: ldc_w 475
    //   1179: lload 17
    //   1181: invokestatic 130	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1184: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1187: pop
    //   1188: aload 26
    //   1190: ldc_w 477
    //   1193: lload 9
    //   1195: invokestatic 130	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1198: invokevirtual 213	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1201: pop
    //   1202: invokestatic 483	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   1205: invokestatic 489	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1208: aconst_null
    //   1209: ldc_w 491
    //   1212: iconst_1
    //   1213: lload 11
    //   1215: lconst_0
    //   1216: aload 25
    //   1218: aconst_null
    //   1219: invokevirtual 495	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1222: aload_1
    //   1223: areturn
    //   1224: astore_1
    //   1225: aload 26
    //   1227: monitorexit
    //   1228: aload_1
    //   1229: athrow
    //   1230: astore_1
    //   1231: aload 26
    //   1233: monitorexit
    //   1234: aload_1
    //   1235: athrow
    //   1236: aconst_null
    //   1237: areturn
    //   1238: astore_1
    //   1239: aload 26
    //   1241: monitorexit
    //   1242: aload_1
    //   1243: athrow
    //   1244: astore_1
    //   1245: goto +30 -> 1275
    //   1248: astore_1
    //   1249: aload_1
    //   1250: invokevirtual 654	java/lang/InterruptedException:printStackTrace	()V
    //   1253: invokestatic 381	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1256: ifeq +14 -> 1270
    //   1259: ldc_w 383
    //   1262: iconst_2
    //   1263: ldc_w 656
    //   1266: aload_1
    //   1267: invokestatic 660	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1270: aload 26
    //   1272: monitorexit
    //   1273: aconst_null
    //   1274: areturn
    //   1275: aload 26
    //   1277: monitorexit
    //   1278: aload_1
    //   1279: athrow
    //   1280: aconst_null
    //   1281: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1282	0	this	FTSMessageSearchEngine
    //   0	1282	1	paramString	String
    //   0	1282	2	paramBoolean	boolean
    //   173	939	3	i	int
    //   188	937	4	j	int
    //   319	847	5	k	int
    //   856	156	6	m	int
    //   162	936	7	n	int
    //   10	6	8	bool	boolean
    //   206	988	9	l1	long
    //   355	859	11	l2	long
    //   506	516	13	l3	long
    //   538	499	15	l4	long
    //   645	535	17	l5	long
    //   674	378	19	l6	long
    //   835	232	21	l7	long
    //   972	93	23	l8	long
    //   13	1204	25	localObject1	Object
    //   44	872	27	localObject3	Object
    //   307	309	28	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   267	288	1224	finally
    //   291	309	1224	finally
    //   314	351	1224	finally
    //   357	498	1224	finally
    //   500	503	1224	finally
    //   1225	1228	1224	finally
    //   235	256	1230	finally
    //   256	259	1230	finally
    //   1231	1234	1230	finally
    //   98	112	1238	finally
    //   114	117	1238	finally
    //   1239	1242	1238	finally
    //   78	86	1244	finally
    //   86	89	1244	finally
    //   1249	1270	1244	finally
    //   1270	1273	1244	finally
    //   1275	1278	1244	finally
    //   78	86	1248	java/lang/InterruptedException
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<FTSEntitySearchResultModel> paramISearchListener)
  {
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.e = System.nanoTime();
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 0L;
    ThreadManager.post(new FTSMessageSearchEngine.1(this, paramSearchRequest, paramISearchListener), 8, null, true);
  }
  
  public void a(String paramString, List<FTSEntity> paramList)
  {
    Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
  }
  
  public List<FTSEntitySearchResultDetailModel> b(SearchRequest paramSearchRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine");
    }
    long l1 = System.nanoTime();
    ((IFTSDBRuntimeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).refreshFTS(1);
    long l2 = System.nanoTime();
    Object localObject = paramSearchRequest.jdField_a_of_type_JavaLangString;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      return new ArrayList();
    }
    long l3 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getLong("uin");
    int i = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getInt("uinType");
    paramSearchRequest = (ArrayList)new QueryArgs.Builder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((String)localObject).a(FTSMessage.class).a(false).b(false).a(l3, i).a().a();
    l3 = System.nanoTime();
    localObject = a((String)localObject, paramSearchRequest);
    long l4 = System.nanoTime();
    if (paramSearchRequest != null) {
      i = paramSearchRequest.size();
    } else {
      i = 0;
    }
    QLog.d("FTSMessageSearchEngine", 2, String.format("fts searchDetail,size:%d, refresh time: %dms, query time: %dms, convert time: %dms", new Object[] { Integer.valueOf(i), Long.valueOf((l2 - l1) / 1000000L), Long.valueOf((l3 - l2) / 1000000L), Long.valueOf((l4 - l3) / 1000000L) }));
    return localObject;
  }
  
  public List<FTSEntitySearchResultModel> b(SearchRequest arg1, boolean paramBoolean)
  {
    Object localObject1 = this;
    if (QLog.isColorLevel()) {
      QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine");
    }
    String str = ???.jdField_a_of_type_JavaLangString;
    int i;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("keyword bytes length: ");
      if (str == null) {
        i = 0;
      } else {
        i = str.getBytes().length;
      }
      ((StringBuilder)???).append(i);
      QLog.i("FTSMessageSearchEngine", 2, ((StringBuilder)???).toString());
    }
    synchronized (((FTSMessageSearchEngine)localObject1).jdField_a_of_type_JavaLangObject)
    {
      if ((!TextUtils.isEmpty(((FTSMessageSearchEngine)localObject1).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((FTSMessageSearchEngine)localObject1).jdField_a_of_type_JavaLangString, str)))
      {
        i = 1;
        Object localObject5;
        if (i != 0)
        {
          localObject5 = ((FTSMessageSearchEngine)localObject1).e.get(((FTSMessageSearchEngine)localObject1).jdField_a_of_type_JavaLangString);
          if (localObject5 != null) {
            try
            {
              localObject5.notify();
            }
            finally {}
          }
        }
        ((FTSMessageSearchEngine)localObject1).jdField_a_of_type_JavaLangString = str;
        if (TextUtils.isEmpty(str)) {
          return a(???, paramBoolean);
        }
        ??? = SQLiteFTSUtils.a(str);
        if ((((ArrayList)???).size() != 0) && (((ArrayList)???).size() != 1))
        {
          if ((???.jdField_a_of_type_AndroidOsBundle != null) && (???.jdField_a_of_type_AndroidOsBundle.containsKey("search_restrict_mem"))) {
            return a(???, paramBoolean);
          }
          int n = ((ArrayList)???).size();
          int i7 = ((String)((ArrayList)???).get(0)).length();
          int i2;
          if (paramBoolean) {
            i2 = 1;
          } else {
            i2 = 2;
          }
          com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Int = n;
          com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.b = i7;
          if (paramBoolean)
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            c.clear();
          }
          synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().contains(str)) {
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            }
            synchronized (c)
            {
              if (!c.keySet().contains(str))
              {
                c.clear();
              }
              else
              {
                localObject5 = (ArrayList)((SoftReference)c.get(str)).get();
                if (localObject5 != null)
                {
                  localObject1 = new HashMap();
                  ((HashMap)localObject1).put("keyNum", String.valueOf(n));
                  ((HashMap)localObject1).put("firstKeyLen", String.valueOf(i7));
                  ((HashMap)localObject1).put("searchPage", String.valueOf(i2));
                  ((HashMap)localObject1).put("useCache", String.valueOf(1));
                  ((HashMap)localObject1).put("searchCost", String.valueOf(0L));
                  ((HashMap)localObject1).put("andSearchResultNum", String.valueOf(0));
                  ((HashMap)localObject1).put("andSearchCost", String.valueOf(0L));
                  ((HashMap)localObject1).put("senderSearchResultNum", String.valueOf(0));
                  ((HashMap)localObject1).put("senderSearchCost", String.valueOf(0L));
                  ((HashMap)localObject1).put("fallSearchResultNum", String.valueOf(0));
                  ((HashMap)localObject1).put("fallSearchCost", String.valueOf(0L));
                  ((HashMap)localObject1).put("groupSortCost", String.valueOf(0L));
                  ((HashMap)localObject1).put("contactSearchCost", String.valueOf(0L));
                  ((HashMap)localObject1).put("contactNum", String.valueOf(0));
                  ((HashMap)localObject1).put("friendNum", String.valueOf(0));
                  ((HashMap)localObject1).put("isMyself", String.valueOf(0));
                  StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFtsSearchEvent", true, 0L, 0L, (HashMap)localObject1, null);
                  return localObject5;
                }
              }
              localObject5 = new ArrayList();
              long l1 = System.nanoTime();
              ??? = (ArrayList)new QueryArgs.Builder(((FTSMessageSearchEngine)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(str).a(FTSMessage.class).b(false).a(false).b(1).a().a();
              long l6 = (System.nanoTime() - l1) / 1000000L;
              int i3;
              if (??? == null) {
                i3 = 0;
              } else {
                i3 = ???.size();
              }
              int i4;
              if ((??? != null) && (!???.isEmpty())) {
                i4 = 1;
              } else {
                i4 = 0;
              }
              Object localObject7;
              if ((??? != null) && (!???.isEmpty()))
              {
                localObject6 = ???.iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  localObject7 = (FTSEntity)((Iterator)localObject6).next();
                  ((FTSEntity)localObject7).mSearchScene = 0;
                  ((FTSMessage)localObject7).searchStrategy = 2;
                }
                ((ArrayList)localObject5).addAll(???);
                i = 1;
              }
              else
              {
                i = 0;
              }
              ??? = (String)((ArrayList)???).get(0);
              ??? = str.substring(str.indexOf((String)???) + ((String)???).length()).trim();
              l1 = System.nanoTime();
              localObject1 = SQLiteFTSUtils.a(((FTSMessageSearchEngine)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)???);
              long l7 = (System.nanoTime() - l1) / 1000000L;
              int i5;
              int j;
              int k;
              if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
              {
                i5 = ((ArrayList)localObject1).size();
                ??? = ((ArrayList)localObject1).iterator();
                for (j = 0; ((Iterator)???).hasNext(); j = k)
                {
                  localObject6 = (SQLiteFTSUtils.MsgSearchContactInfo)((Iterator)???).next();
                  if (((SQLiteFTSUtils.MsgSearchContactInfo)localObject6).jdField_a_of_type_Int != 0)
                  {
                    k = j;
                    if (((SQLiteFTSUtils.MsgSearchContactInfo)localObject6).jdField_a_of_type_Int != 1004) {}
                  }
                  else
                  {
                    k = j + 1;
                  }
                }
              }
              else
              {
                j = 0;
                i5 = 0;
              }
              l1 = 0L + l6 + l7;
              int m;
              long l2;
              int i1;
              Object localObject8;
              long l3;
              if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
              {
                k = i;
                int i6 = 0;
                m = 0;
                i = 0;
                l2 = 0L;
                for (;;)
                {
                  ??? = this;
                  if (i6 >= ((ArrayList)localObject1).size()) {
                    break;
                  }
                  localObject6 = ((SQLiteFTSUtils.MsgSearchContactInfo)((ArrayList)localObject1).get(i6)).jdField_a_of_type_JavaLangString;
                  int i8 = ((SQLiteFTSUtils.MsgSearchContactInfo)((ArrayList)localObject1).get(i6)).jdField_a_of_type_Int;
                  localObject7 = ((SQLiteFTSUtils.MsgSearchContactInfo)((ArrayList)localObject1).get(i6)).jdField_a_of_type_AndroidUtilPair;
                  if (TextUtils.equals(((FTSMessageSearchEngine)???).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (CharSequence)localObject6)) {
                    i1 = 1;
                  } else {
                    i1 = m;
                  }
                  if ((!TextUtils.equals((CharSequence)localObject6, ((FTSMessageSearchEngine)???).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (SQLiteFTSUtils.c(((FTSMessageSearchEngine)???).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1))
                  {
                    localObject8 = (ArrayList)new QueryArgs.Builder(((FTSMessageSearchEngine)???).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(str).a(FTSMessage.class).b(false).a(false).a(Long.valueOf((String)localObject6).longValue(), i8).a().a();
                    m = k;
                    if (localObject8 != null)
                    {
                      m = k;
                      if (!((ArrayList)localObject8).isEmpty())
                      {
                        Iterator localIterator = ((ArrayList)localObject8).iterator();
                        while (localIterator.hasNext())
                        {
                          FTSEntity localFTSEntity = (FTSEntity)localIterator.next();
                          localFTSEntity.mSearchScene = k;
                          ((FTSMessage)localFTSEntity).searchStrategy = 3;
                        }
                        m = k + 1;
                        ((ArrayList)localObject5).addAll((Collection)localObject8);
                      }
                    }
                  }
                  else
                  {
                    m = k;
                  }
                  k = i1;
                  i1 = i;
                  l3 = l1;
                  l4 = l2;
                  if (i8 != 1) {
                    if (i8 == 3000)
                    {
                      i1 = i;
                      l3 = l1;
                      l4 = l2;
                    }
                    else
                    {
                      if (i8 != 0)
                      {
                        i1 = i;
                        l3 = l1;
                        l4 = l2;
                        if (i8 != 1004) {
                          break label1596;
                        }
                      }
                      l3 = System.nanoTime();
                      ??? = (ArrayList)new QueryArgs.Builder(((FTSMessageSearchEngine)???).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(str).a(Long.valueOf((String)localObject6).longValue()).b(false).a(false).a((Pair)localObject7).a(FTSMessage.class).a().a();
                      l2 += (System.nanoTime() - l3) / 1000000L;
                      if (??? == null) {
                        i1 = 0;
                      } else {
                        i1 = ((ArrayList)???).size();
                      }
                      i += i1;
                      l1 += l2;
                      i1 = i;
                      l3 = l1;
                      l4 = l2;
                      if (??? != null)
                      {
                        i1 = i;
                        l3 = l1;
                        l4 = l2;
                        if (!((ArrayList)???).isEmpty())
                        {
                          localObject6 = ((ArrayList)???).iterator();
                          while (((Iterator)localObject6).hasNext())
                          {
                            localObject7 = (FTSEntity)((Iterator)localObject6).next();
                            ((FTSEntity)localObject7).mSearchScene = m;
                            localObject7 = (FTSMessage)localObject7;
                            ((FTSMessage)localObject7).searchStrategy = 3;
                            ((FTSMessage)localObject7).senderNum = i5;
                            ((FTSMessage)localObject7).friendNum = j;
                            if (k == 1) {
                              i1 = 0;
                            } else {
                              i1 = i6 + 1;
                            }
                            ((FTSMessage)localObject7).friendIndex = i1;
                          }
                          i1 = k;
                          k = m + 1;
                          ((ArrayList)localObject5).addAll((Collection)???);
                          break label1615;
                        }
                      }
                    }
                  }
                  label1596:
                  l2 = l4;
                  l1 = l3;
                  i = i1;
                  i1 = k;
                  k = m;
                  label1615:
                  i6 += 1;
                  m = i1;
                }
                i1 = k;
                k = i;
              }
              else
              {
                k = 0;
                l2 = 0L;
                m = 0;
                i1 = i;
              }
              if ((i4 == 0) && (((ArrayList)localObject5).isEmpty()))
              {
                l3 = System.nanoTime();
                localObject1 = (ArrayList)new QueryArgs.Builder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(str).a(FTSMessage.class).a(false).b(false).b(0).a().a();
                l4 = (System.nanoTime() - l3) / 1000000L;
                if (localObject1 == null) {
                  i = 0;
                } else {
                  i = ((ArrayList)localObject1).size();
                }
                long l5 = l1 + l4;
                i4 = i;
                l1 = l5;
                l3 = l4;
                if (localObject1 != null)
                {
                  i4 = i;
                  l1 = l5;
                  l3 = l4;
                  if (!((ArrayList)localObject1).isEmpty())
                  {
                    ??? = ((ArrayList)localObject1).iterator();
                    while (((Iterator)???).hasNext())
                    {
                      localObject6 = (FTSEntity)((Iterator)???).next();
                      ((FTSEntity)localObject6).mSearchScene = i1;
                      ((FTSMessage)localObject6).searchStrategy = 4;
                    }
                    ((ArrayList)localObject5).addAll((Collection)localObject1);
                    i4 = i;
                    l1 = l5;
                    l3 = l4;
                  }
                }
              }
              else
              {
                i4 = 0;
                l3 = 0L;
              }
              Object localObject6 = new ArrayList();
              long l4 = System.nanoTime();
              localObject1 = a((ArrayList)localObject5);
              l4 = (System.nanoTime() - l4) / 1000000L;
              l1 += l4;
              localObject5 = SQLiteFTSUtils.a(str);
              localObject1 = ((ArrayList)localObject1).iterator();
              for (;;)
              {
                ??? = this;
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject7 = (FTSMessageSearchEngine.FTSSearchResultItem)((Iterator)localObject1).next();
                localObject8 = (FTSMessage)((FTSMessageSearchEngine.FTSSearchResultItem)localObject7).jdField_a_of_type_JavaUtilList.get(0);
                if (a(((FTSMessageSearchEngine)???).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(((FTSMessage)localObject8).uin), ((FTSMessage)localObject8).istroop))
                {
                  ??? = new FTSMessageSearchResultModel(((FTSMessageSearchEngine)???).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, str, (ArrayList)localObject5, ((FTSMessageSearchEngine.FTSSearchResultItem)localObject7).jdField_a_of_type_JavaUtilList, null, null);
                  ((FTSMessageSearchResultModel)???).jdField_a_of_type_Int = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject7).d;
                  ((FTSMessageSearchResultModel)???).b = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject7).e;
                  ((FTSMessageSearchResultModel)???).c = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject7).f;
                  ((FTSMessageSearchResultModel)???).d = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject7).g;
                  ((ArrayList)localObject6).add(???);
                }
              }
              localObject1 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
              i = 1;
              ((ConcurrentHashMap)localObject1).put(str, Boolean.valueOf(true));
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(???, Boolean.valueOf(true));
              c.put(str, new SoftReference(localObject6));
              ??? = new HashMap();
              ???.put("keyNum", String.valueOf(n));
              ???.put("firstKeyLen", String.valueOf(i7));
              ???.put("searchPage", String.valueOf(i2));
              ???.put("useCache", String.valueOf(0));
              ???.put("searchCost", String.valueOf(l1));
              ???.put("andSearchResultNum", String.valueOf(i3));
              ???.put("andSearchCost", String.valueOf(l6));
              ???.put("senderSearchResultNum", String.valueOf(k));
              ???.put("senderSearchCost", String.valueOf(l2));
              ???.put("fallSearchResultNum", String.valueOf(i4));
              ???.put("fallSearchCost", String.valueOf(l3));
              ???.put("groupSortCost", String.valueOf(l4));
              ???.put("contactSearchCost", String.valueOf(l7));
              ???.put("contactNum", String.valueOf(i5));
              ???.put("friendNum", String.valueOf(j));
              ???.put("isMyself", String.valueOf(m));
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFtsSearchEvent", true, l1, 0L, ???, null);
              if ((((ArrayList)localObject6).isEmpty()) && (!TextUtils.isEmpty(str)) && (str.getBytes().length < 255))
              {
                ??? = Pattern.compile("[一-龥]*").matcher(str);
                while (???.find()) {
                  if (???.group().length() >= 4) {
                    break label2405;
                  }
                }
                i = 0;
                label2405:
                if (i != 0)
                {
                  this.e.put(str, new Object());
                  return a(str, paramBoolean);
                }
                return localObject6;
              }
              return localObject6;
            }
          }
        }
        return a(???, paramBoolean);
      }
    }
  }
  
  public void b(SearchRequest paramSearchRequest, ISearchListener<FTSEntitySearchResultDetailModel> paramISearchListener)
  {
    ThreadManager.post(new FTSMessageSearchEngine.2(this, paramSearchRequest, paramISearchListener), 8, null, true);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppGlobalSearchObserver);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppGlobalSearchObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine
 * JD-Core Version:    0.7.0.1
 */