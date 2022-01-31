package com.tencent.mobileqq.search.ftsmsg;

import ahyl;
import ahym;
import ahyn;
import ahyo;
import ahyp;
import ahyq;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.GlobalSearchHandler;
import com.tencent.mobileqq.app.GlobalSearchObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
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
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static ConcurrentHashMap b = new ConcurrentHashMap();
  private static ConcurrentHashMap c = new ConcurrentHashMap();
  private GlobalSearchObserver jdField_a_of_type_ComTencentMobileqqAppGlobalSearchObserver = new ahyq(this);
  private RecentUserProxy jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private Comparator jdField_a_of_type_JavaUtilComparator = new ahyo(this);
  private ConcurrentHashMap d = new ConcurrentHashMap();
  private ConcurrentHashMap e = new ConcurrentHashMap();
  
  public FTSMessageSearchEngine(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, paramInt)) {
        j = i + 4;
      }
      return j + 3;
    }
    return i + 1;
  }
  
  private ArrayList a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return new ArrayList();
    }
    Object localObject1 = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      FTSMessage localFTSMessage = (FTSMessage)paramArrayList.next();
      if ((localFTSMessage != null) && (localFTSMessage.msgExts != null))
      {
        int i = localFTSMessage.istroop;
        Object localObject2 = String.valueOf(localFTSMessage.uin);
        String str = MsgProxyUtils.a((String)localObject2, i);
        if (!((HashMap)localObject1).containsKey(str))
        {
          FTSMessageSearchEngine.FTSSearchResultItem localFTSSearchResultItem = new FTSMessageSearchEngine.FTSSearchResultItem();
          localFTSSearchResultItem.jdField_a_of_type_JavaUtilList = new ArrayList();
          localFTSSearchResultItem.jdField_a_of_type_JavaUtilList.add(localFTSMessage);
          localFTSSearchResultItem.jdField_a_of_type_Int = localFTSMessage.mSearchScene;
          localFTSSearchResultItem.b = localFTSMessage.mProximity;
          localFTSSearchResultItem.c = a((String)localObject2, i);
          localFTSSearchResultItem.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time;
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
              if (((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time > ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Long) {
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time;
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
            for (;;)
            {
              if (localFTSMessage.mSearchScene < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Int) {
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Int = localFTSMessage.mSearchScene;
              }
              if (localFTSMessage.searchStrategy < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).d) {
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).d = localFTSMessage.searchStrategy;
              }
              ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_JavaUtilList.add(localFTSMessage);
              break;
              if (localFTSMessage.mSearchScene < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Int)
              {
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).b = localFTSMessage.mProximity;
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time;
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).e = localFTSMessage.senderNum;
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).f = localFTSMessage.friendNum;
                ((FTSMessageSearchEngine.FTSSearchResultItem)localObject2).g = localFTSMessage.friendIndex;
              }
            }
          }
        }
      }
    }
    paramArrayList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramArrayList.add(((Map.Entry)((Iterator)localObject1).next()).getValue());
    }
    Collections.sort(paramArrayList, new ahyp(this));
    return paramArrayList;
  }
  
  private List a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    Object localObject1 = new HashMap();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    while (paramArrayList.hasNext())
    {
      localObject2 = (FTSMessage)paramArrayList.next();
      if ((localObject2 != null) && (((FTSMessage)localObject2).msgExts != null))
      {
        int j = ((FTSMessage)localObject2).istroop;
        localObject3 = String.valueOf(((FTSMessage)localObject2).uin);
        localObject4 = MsgProxyUtils.a((String)localObject3, j);
        if (!((HashMap)localObject1).containsKey(localObject4))
        {
          localObject5 = new FTSMessageSearchEngine.FTSSearchResultItem();
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_JavaUtilList = new ArrayList();
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_JavaUtilList.add(localObject2);
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).b = ((FTSMessage)localObject2).mProximity;
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).c = a((String)localObject3, j);
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)((FTSMessage)localObject2).msgExts).time;
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_JavaUtilHashSet = new HashSet();
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(((FTSMessage)localObject2).mOId));
          ((FTSMessageSearchEngine.FTSSearchResultItem)localObject5).d = ((FTSMessage)localObject2).searchStrategy;
          ((HashMap)localObject1).put(localObject4, localObject5);
        }
        else
        {
          localObject3 = (FTSMessageSearchEngine.FTSSearchResultItem)((HashMap)localObject1).get(localObject4);
          if (!((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(((FTSMessage)localObject2).mOId)))
          {
            i = 1;
          }
          else
          {
            if (((FTSMessage)localObject2).mProximity < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).b) {
              ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).b = ((FTSMessage)localObject2).mProximity;
            }
            if (((FTSMessageCodec.TextMsgExts)((FTSMessage)localObject2).msgExts).time > ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).jdField_a_of_type_Long) {
              ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)((FTSMessage)localObject2).msgExts).time;
            }
            if (((FTSMessage)localObject2).searchStrategy < ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).d) {
              ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).d = ((FTSMessage)localObject2).searchStrategy;
            }
            ((FTSMessageSearchEngine.FTSSearchResultItem)localObject3).jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
      }
    }
    if (i != 0) {}
    paramArrayList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramArrayList.add(((Map.Entry)((Iterator)localObject1).next()).getValue());
    }
    Collections.sort(paramArrayList, new ahyn(this));
    localObject1 = SQLiteFTSUtils.a(paramString2);
    Object localObject2 = new ArrayList();
    if (paramArrayList != null)
    {
      localObject3 = paramArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (FTSMessageSearchEngine.FTSSearchResultItem)((Iterator)localObject3).next();
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(((FTSMessage)((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).jdField_a_of_type_JavaUtilList.get(0)).uin), ((FTSMessage)((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).jdField_a_of_type_JavaUtilList.get(0)).istroop))
        {
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramString1 == null) {}
          for (paramArrayList = paramString2;; paramArrayList = paramString1)
          {
            paramArrayList = new FTSMessageSearchResultModel((QQAppInterface)localObject5, paramArrayList, paramString2, (ArrayList)localObject1, ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).jdField_a_of_type_JavaUtilList, paramString3, null);
            paramArrayList.jdField_a_of_type_Int = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).d;
            paramArrayList.b = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).e;
            paramArrayList.c = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).f;
            paramArrayList.d = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject4).g;
            ((List)localObject2).add(paramArrayList);
            i = SearchEntryConfigManager.a("fts_native_chathistory_maxnum", 3);
            if ((!paramBoolean1) || (((List)localObject2).size() < i + 1)) {
              break;
            }
            return localObject2;
          }
        }
      }
    }
    return localObject2;
  }
  
  private List a(String paramString, ArrayList paramArrayList)
  {
    ArrayList localArrayList = SQLiteFTSUtils.a(paramString);
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (paramArrayList != null)
    {
      localObject2 = new HashSet();
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      for (;;)
      {
        j = i;
        if (!paramArrayList.hasNext()) {
          break;
        }
        FTSEntity localFTSEntity = (FTSEntity)paramArrayList.next();
        if (!((HashSet)localObject2).add(Long.valueOf(localFTSEntity.mOId))) {
          i = 1;
        } else {
          ((ArrayList)localObject1).add(localFTSEntity);
        }
      }
    }
    int j = 0;
    if (j != 0) {}
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
      TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
      if ((localTroopInfo == null) || (localTroopInfo.troopname == null))
      {
        paramQQAppInterface = ((HotChatManager)paramQQAppInterface.getManager(59)).a(paramString);
        return (paramQQAppInterface != null) && (paramQQAppInterface.name != null);
      }
    }
    else if (3000 == paramInt)
    {
      paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
      if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.discussionName))) {
        return false;
      }
    }
    else if (paramInt == 0)
    {
      return true;
    }
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
  
  public List a(SearchRequest paramSearchRequest)
  {
    if (paramSearchRequest == null) {
      return null;
    }
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.e = System.nanoTime();
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 0L;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null) {}
    for (boolean bool = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("fts_search_is_limited", true);; bool = true)
    {
      if (SQLiteFTSUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {
        return b(paramSearchRequest, bool);
      }
      return a(paramSearchRequest, bool);
    }
  }
  
  public List a(SearchRequest arg1, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine");
    }
    int j;
    int k;
    label42:
    int m;
    label49:
    String str;
    Object localObject1;
    int i;
    label93:
    boolean bool;
    Object localObject5;
    int n;
    if (TextUtils.isEmpty(???.jdField_a_of_type_JavaLangString))
    {
      j = 0;
      if (!TextUtils.isEmpty(???.jdField_a_of_type_JavaLangString)) {
        break label872;
      }
      k = 0;
      if (!paramBoolean) {
        break label884;
      }
      m = 1;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Int = j;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.b = k;
      str = ???.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("keyword bytes length: ");
        if (str != null) {
          break label890;
        }
        i = 0;
        QLog.i("FTSMessageSearchEngine", 2, i);
      }
      bool = false;
      if ((???.jdField_a_of_type_AndroidOsBundle == null) || (!???.jdField_a_of_type_AndroidOsBundle.containsKey("search_restrict_mem"))) {
        break label900;
      }
      localObject5 = ???.jdField_a_of_type_AndroidOsBundle.getString("search_restrict_mem");
      localObject1 = ???.jdField_a_of_type_AndroidOsBundle.getString("search_restrict_uin");
      bool = ???.jdField_a_of_type_AndroidOsBundle.getBoolean("search_restrict_empty");
      i = ???.jdField_a_of_type_AndroidOsBundle.getInt("search_restrict_uintype");
      n = 1;
    }
    for (;;)
    {
      long l4;
      long l5;
      long l2;
      long l1;
      if (n == 0)
      {
        if (paramBoolean)
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          b.clear();
        }
      }
      else
      {
        l4 = System.nanoTime();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(1);
        l5 = System.nanoTime();
        if (n == 0) {
          break label1326;
        }
        if (!bool) {
          break label1222;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(Long.valueOf((String)localObject1).longValue(), null);
        l2 = 0L;
        i = 0;
        l1 = 0L;
      }
      for (;;)
      {
        long l6 = System.nanoTime();
        localObject1 = null;
        long l3;
        if (??? != null)
        {
          l3 = System.nanoTime();
          if (n == 0)
          {
            bool = true;
            label290:
            localObject1 = a(str, str, (String)localObject5, paramBoolean, ???, bool);
            l3 = (System.nanoTime() - l3) / 1000000L;
            l1 += l3;
            if (n != 0) {
              break label1479;
            }
            if (!paramBoolean) {
              break label1449;
            }
            if (???.size() >= 2000) {
              break label1443;
            }
            bool = true;
            label347:
            if (bool)
            {
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(bool));
              b.put(str, new SoftReference(???));
            }
          }
        }
        label411:
        label1443:
        label1449:
        for (;;)
        {
          label383:
          long l7 = System.nanoTime();
          localObject5 = new HashMap();
          label435:
          label461:
          long l8;
          if (localObject1 != null)
          {
            i1 = ((List)localObject1).size();
            ((HashMap)localObject5).put("queryConversationSize", Integer.toString(i1));
            if (??? == null) {
              break label1488;
            }
            i1 = ???.size();
            ((HashMap)localObject5).put("resultSize", Integer.toString(i1));
            if (str == null) {
              break label1494;
            }
            i1 = str.length();
            ((HashMap)localObject5).put("keyLength", Integer.toString(i1));
            StatisticCollector.a(BaseApplication.getContext()).a(null, "SearchMessageStatistic_FTS", true, (l7 - l5) / 1000000L, 0L, (HashMap)localObject5, null);
            l8 = System.nanoTime();
            if (QLog.isColorLevel()) {
              if (??? == null) {
                break label1500;
              }
            }
          }
          label1222:
          label1479:
          label1488:
          label1494:
          label1500:
          for (int i1 = ???.size();; i1 = 0)
          {
            QLog.d("FTSMessageSearchEngine", 2, String.format("fts search,size:%d, refresh time: %dms, query time: %dms, convert time: %dms, report time: %dms", new Object[] { Integer.valueOf(i1), Long.valueOf((l5 - l4) / 1000000L), Long.valueOf((l6 - l5) / 1000000L), Long.valueOf((l7 - l6) / 1000000L), Long.valueOf((l8 - l7) / 1000000L) }));
            if (n == 0)
            {
              ??? = new HashMap();
              ???.put("keyNum", String.valueOf(j));
              ???.put("firstKeyLen", String.valueOf(k));
              ???.put("searchPage", String.valueOf(m));
              ???.put("useCache", String.valueOf(0));
              ???.put("searchCost", String.valueOf(l1));
              ???.put("singleSearchResultNum", String.valueOf(i));
              ???.put("singleSearchCost", String.valueOf(l2));
              ???.put("groupSortCost", String.valueOf(l3));
              StatisticCollector.a(BaseApplication.getContext()).a(null, "actFtsSearchEvent", true, l1, 0L, ???, null);
            }
            ??? = (SearchRequest)localObject1;
            if (n == 0) {
              if (localObject1 != null)
              {
                ??? = (SearchRequest)localObject1;
                if (!((List)localObject1).isEmpty()) {}
              }
              else
              {
                ??? = (SearchRequest)localObject1;
                if (!TextUtils.isEmpty(str))
                {
                  ??? = (SearchRequest)localObject1;
                  if (str.getBytes().length < 255)
                  {
                    j = 0;
                    ??? = Pattern.compile("[一-龥]*").matcher(str);
                    do
                    {
                      i = j;
                      if (!???.find()) {
                        break;
                      }
                    } while (???.group().length() < 4);
                    i = 1;
                    ??? = (SearchRequest)localObject1;
                    if (i != 0)
                    {
                      this.e.put(str, new Object());
                      ??? = a(str, paramBoolean);
                    }
                  }
                }
              }
            }
            return ???;
            j = 1;
            break;
            label872:
            k = ???.jdField_a_of_type_JavaLangString.length();
            break label42;
            label884:
            m = 2;
            break label49;
            label890:
            i = str.getBytes().length;
            break label93;
            if (!TextUtils.isEmpty(???.jdField_a_of_type_JavaLangString)) {
              break label1523;
            }
            if (QLog.isColorLevel()) {
              QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine, keyword is null");
            }
            return new ArrayList();
            ArrayList localArrayList;
            do
            {
              synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
              {
                for (;;)
                {
                  if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().contains(str)) {
                    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
                  }
                  synchronized (b)
                  {
                    if (!b.keySet().contains(str)) {
                      b.clear();
                    }
                  }
                }
              }
              localArrayList = (ArrayList)((SoftReference)b.get(str)).get();
            } while (localArrayList == null);
            i = localArrayList.size();
            l1 = System.nanoTime();
            localObject4 = a(str, str, null, paramBoolean, localArrayList, true);
            l1 = (System.nanoTime() - l1) / 1000000L;
            l2 = 0L + l1;
            localObject5 = new HashMap();
            ((HashMap)localObject5).put("keyNum", String.valueOf(j));
            ((HashMap)localObject5).put("firstKeyLen", String.valueOf(k));
            ((HashMap)localObject5).put("searchPage", String.valueOf(m));
            ((HashMap)localObject5).put("useCache", String.valueOf(1));
            ((HashMap)localObject5).put("searchCost", String.valueOf(l2));
            ((HashMap)localObject5).put("singleSearchResultNum", String.valueOf(i));
            ((HashMap)localObject5).put("singleSearchCost", String.valueOf(0L));
            ((HashMap)localObject5).put("groupSortCost", String.valueOf(l1));
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actFtsSearchEvent", true, l2, 0L, (HashMap)localObject5, null);
            return localObject4;
            ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, FTSMessage.class, false, false, Long.valueOf((String)localObject4).longValue(), null);
            if (i == -1) {
              break label1512;
            }
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, FTSMessage.class, false, false, Long.valueOf((String)localObject4).longValue(), i);
            if ((??? != null) && (localObject4 != null)) {
              ???.addAll((Collection)localObject4);
            }
            for (;;)
            {
              l2 = 0L;
              i = 0;
              l1 = 0L;
              break;
              if (??? != null) {
                localObject4 = ???;
              }
              ??? = (SearchRequest)localObject4;
            }
            l1 = System.nanoTime();
            ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, FTSMessage.class, paramBoolean, false);
            if ((??? != null) && (!???.isEmpty()))
            {
              localObject4 = ???.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((FTSMessage)((Iterator)localObject4).next()).searchStrategy = 1;
              }
            }
            l1 = (System.nanoTime() - l1) / 1000000L;
            if (??? == null) {}
            for (i = 0;; i = ???.size())
            {
              l2 = l1;
              l1 = 0L + l1;
              break;
            }
            bool = false;
            break label290;
            bool = false;
            break label347;
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
            b.put(str, new SoftReference(???));
            break label383;
            i1 = 0;
            break label411;
            i1 = 0;
            break label435;
            i1 = 0;
            break label461;
          }
          label1326:
          l3 = 0L;
        }
        label900:
        label1512:
        l2 = 0L;
        i = 0;
        l1 = 0L;
      }
      label1523:
      i = -1;
      n = 0;
      localObject5 = null;
      Object localObject4 = null;
    }
  }
  
  public List a(String paramString, boolean paramBoolean)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      return null;
    }
    ??? = (GlobalSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(81);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(paramString);
    ((GlobalSearchHandler)???).a((ArrayList)localObject2);
    ??? = this.e.get(paramString);
    if (??? != null) {
      try
      {
        ???.wait(5000L);
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) {
            break label147;
          }
          return null;
        }
        return null;
      }
      catch (InterruptedException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("FTSMessageSearchEngine", 2, "searchByWaitServerSeg Exception: ", paramString);
        }
        return null;
      }
      finally {}
    }
    label147:
    ??? = (StringBuilder)this.d.get(paramString);
    String str;
    if (??? != null)
    {
      str = ((StringBuilder)???).toString().trim();
      if (str.length() == 0) {
        return null;
      }
    }
    else
    {
      return null;
    }
    int i;
    int j;
    if (TextUtils.isEmpty(str))
    {
      i = 0;
      if (!TextUtils.isEmpty(str)) {
        break label350;
      }
      j = 0;
      label211:
      if (!paramBoolean) {
        break label360;
      }
    }
    long l4;
    long l5;
    long l6;
    ArrayList localArrayList;
    label350:
    label360:
    for (int k = 1;; k = 2)
    {
      l4 = 0L;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Int = i;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.b = j;
      if (!paramBoolean) {
        break label366;
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      b.clear();
      l5 = System.nanoTime();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().d();
      l6 = System.nanoTime();
      l1 = System.nanoTime();
      localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, FTSMessage.class, paramBoolean, false);
      if ((localArrayList == null) || (localArrayList.isEmpty())) {
        break label654;
      }
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        ((FTSMessage)((Iterator)???).next()).searchStrategy = 1;
      }
      i = 1;
      break;
      j = str.length();
      break label211;
    }
    label366:
    do
    {
      synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        for (;;)
        {
          if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().contains(paramString)) {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          }
          synchronized (b)
          {
            if (!b.keySet().contains(paramString)) {
              b.clear();
            }
          }
        }
      }
      localObject2 = (ArrayList)((SoftReference)b.get(paramString)).get();
    } while (localObject2 == null);
    int m = ((ArrayList)localObject2).size();
    long l1 = System.nanoTime();
    paramString = a(paramString, str, null, paramBoolean, (ArrayList)localObject2, true);
    l1 = (System.nanoTime() - l1) / 1000000L;
    long l2 = 0L + l1;
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("keyNum", String.valueOf(i));
    ((HashMap)localObject2).put("firstKeyLen", String.valueOf(j));
    ((HashMap)localObject2).put("searchPage", String.valueOf(k));
    ((HashMap)localObject2).put("useCache", String.valueOf(1));
    ((HashMap)localObject2).put("searchCost", String.valueOf(l2));
    ((HashMap)localObject2).put("singleSearchResultNum", String.valueOf(m));
    ((HashMap)localObject2).put("singleSearchCost", String.valueOf(0L));
    ((HashMap)localObject2).put("groupSortCost", String.valueOf(l1));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actFtsSearchEvent", true, l2, 0L, (HashMap)localObject2, null);
    return paramString;
    label654:
    long l7 = (System.nanoTime() - l1) / 1000000L;
    long l3;
    long l8;
    if (localArrayList == null)
    {
      m = 0;
      l3 = 0L + l7;
      l8 = System.nanoTime();
      localObject2 = null;
      ??? = localObject2;
      l2 = l4;
      l1 = l3;
      if (localArrayList == null) {
        break label1234;
      }
      ??? = localObject2;
      l2 = l4;
      l1 = l3;
      if (localArrayList.isEmpty()) {
        break label1234;
      }
      l1 = System.nanoTime();
      ??? = a(paramString, str, null, paramBoolean, localArrayList, false);
      l2 = (System.nanoTime() - l1) / 1000000L;
      l3 += l2;
      if (!paramBoolean) {
        break label1201;
      }
      if (localArrayList.size() >= 2000) {
        break label1196;
      }
      paramBoolean = true;
      label780:
      if (paramBoolean)
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(paramBoolean));
        b.put(paramString, new SoftReference(localArrayList));
      }
      l1 = l2;
      l2 = l3;
      label821:
      l3 = System.nanoTime();
      paramString = new HashMap();
      if (??? == null) {
        break label1249;
      }
      n = ((List)???).size();
      label848:
      paramString.put("queryConversationSize", Integer.toString(n));
      if (localArrayList == null) {
        break label1255;
      }
      n = localArrayList.size();
      label873:
      paramString.put("resultSize", Integer.toString(n));
      if (str == null) {
        break label1261;
      }
      n = str.length();
      label898:
      paramString.put("keyLength", Integer.toString(n));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "SearchMessageStatistic_FTS", true, (l3 - l6) / 1000000L, 0L, paramString, null);
      l4 = System.nanoTime();
      if (QLog.isColorLevel()) {
        if (localArrayList == null) {
          break label1267;
        }
      }
    }
    label1196:
    label1201:
    label1234:
    label1249:
    label1255:
    label1261:
    label1267:
    for (int n = localArrayList.size();; n = 0)
    {
      QLog.d("FTSMessageSearchEngine", 2, String.format("fts search,size:%d, refresh time: %dms, query time: %dms, convert time: %dms, report time: %dms", new Object[] { Integer.valueOf(n), Long.valueOf((l6 - l5) / 1000000L), Long.valueOf((l8 - l6) / 1000000L), Long.valueOf((l3 - l8) / 1000000L), Long.valueOf((l4 - l3) / 1000000L) }));
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("keyNum", String.valueOf(i));
      ((HashMap)localObject2).put("firstKeyLen", String.valueOf(j));
      ((HashMap)localObject2).put("searchPage", String.valueOf(k));
      ((HashMap)localObject2).put("useCache", String.valueOf(0));
      ((HashMap)localObject2).put("searchCost", String.valueOf(l2));
      ((HashMap)localObject2).put("singleSearchResultNum", String.valueOf(m));
      ((HashMap)localObject2).put("singleSearchCost", String.valueOf(l7));
      ((HashMap)localObject2).put("groupSortCost", String.valueOf(l1));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actFtsSearchEvent", true, l2, 0L, paramString, null);
      return ???;
      m = localArrayList.size();
      break;
      paramBoolean = false;
      break label780;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
      b.put(paramString, new SoftReference(localArrayList));
      l1 = l3;
      l3 = l1;
      l1 = l2;
      l2 = l3;
      break label821;
      n = 0;
      break label848;
      n = 0;
      break label873;
      n = 0;
      break label898;
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.e = System.nanoTime();
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 0L;
    ThreadManager.post(new ahyl(this, paramSearchRequest, paramISearchListener), 8, null, true);
  }
  
  public void a(String paramString, List paramList)
  {
    Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
  }
  
  public List b(SearchRequest paramSearchRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine");
    }
    long l1 = System.nanoTime();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(1);
    long l2 = System.nanoTime();
    Object localObject = paramSearchRequest.jdField_a_of_type_JavaLangString;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      return new ArrayList();
    }
    long l3 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getLong("uin");
    int i = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getInt("uinType");
    paramSearchRequest = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((String)localObject, FTSMessage.class, false, false, l3, i);
    l3 = System.nanoTime();
    localObject = a((String)localObject, paramSearchRequest);
    long l4 = System.nanoTime();
    if (paramSearchRequest != null) {}
    for (i = paramSearchRequest.size();; i = 0)
    {
      QLog.d("FTSMessageSearchEngine", 2, String.format("fts searchDetail,size:%d, refresh time: %dms, query time: %dms, convert time: %dms", new Object[] { Integer.valueOf(i), Long.valueOf((l2 - l1) / 1000000L), Long.valueOf((l3 - l2) / 1000000L), Long.valueOf((l4 - l3) / 1000000L) }));
      return localObject;
    }
  }
  
  public List b(SearchRequest arg1, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine");
    }
    String str = ???.jdField_a_of_type_JavaLangString;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("keyword bytes length: ");
      if (str != null) {
        break label165;
      }
      i = 0;
    }
    int j;
    for (;;)
    {
      QLog.i("FTSMessageSearchEngine", 2, i);
      localObject3 = this.jdField_a_of_type_JavaLangObject;
      j = 0;
      i = j;
      try
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          i = j;
          if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, str)) {
            i = 1;
          }
        }
        if (i != 0)
        {
          localObject4 = this.e.get(this.jdField_a_of_type_JavaLangString);
          if (localObject4 == null) {}
        }
        label165:
        try
        {
          localObject4.notify();
          this.jdField_a_of_type_JavaLangString = str;
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          return a(???, paramBoolean);
        }
        finally {}
        i = str.getBytes().length;
      }
      finally {}
    }
    Object localObject4 = SQLiteFTSUtils.a(str);
    if ((((ArrayList)localObject4).size() == 0) || (((ArrayList)localObject4).size() == 1)) {
      return a(???, paramBoolean);
    }
    if ((???.jdField_a_of_type_AndroidOsBundle != null) && (???.jdField_a_of_type_AndroidOsBundle.containsKey("search_restrict_mem"))) {
      return a(???, paramBoolean);
    }
    int i7 = ((ArrayList)localObject4).size();
    int i8 = ((String)((ArrayList)localObject4).get(0)).length();
    int n;
    int m;
    int k;
    long l5;
    int i1;
    if (paramBoolean)
    {
      n = 1;
      j = 0;
      m = 0;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Int = i7;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.b = i8;
      if (!paramBoolean) {
        break label445;
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      c.clear();
      localObject3 = new ArrayList();
      k = 0;
      l1 = System.nanoTime();
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, FTSMessage.class, false, false, 1);
      l5 = (System.nanoTime() - l1) / 1000000L;
      if (??? != null) {
        break label790;
      }
      i1 = 0;
      label362:
      if ((??? != null) && (!???.isEmpty())) {
        break label799;
      }
    }
    Object localObject5;
    Object localObject6;
    label445:
    HashMap localHashMap;
    label790:
    label799:
    for (int i2 = 0;; i2 = 1)
    {
      i = k;
      if (??? == null) {
        break label814;
      }
      i = k;
      if (???.isEmpty()) {
        break label814;
      }
      localObject5 = ???.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (FTSEntity)((Iterator)localObject5).next();
        ((FTSEntity)localObject6).mSearchScene = 0;
        ((FTSMessage)localObject6).searchStrategy = 2;
      }
      n = 2;
      break;
      do
      {
        synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
        {
          for (;;)
          {
            if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().contains(str)) {
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            }
            synchronized (c)
            {
              if (!c.keySet().contains(str)) {
                c.clear();
              }
            }
          }
        }
        localObject3 = (ArrayList)((SoftReference)c.get(localObject2)).get();
      } while (localObject3 == null);
      localHashMap = new HashMap();
      localHashMap.put("keyNum", String.valueOf(i7));
      localHashMap.put("firstKeyLen", String.valueOf(i8));
      localHashMap.put("searchPage", String.valueOf(n));
      localHashMap.put("useCache", String.valueOf(1));
      localHashMap.put("searchCost", String.valueOf(0L));
      localHashMap.put("andSearchResultNum", String.valueOf(0));
      localHashMap.put("andSearchCost", String.valueOf(0L));
      localHashMap.put("senderSearchResultNum", String.valueOf(0));
      localHashMap.put("senderSearchCost", String.valueOf(0L));
      localHashMap.put("fallSearchResultNum", String.valueOf(0));
      localHashMap.put("fallSearchCost", String.valueOf(0L));
      localHashMap.put("groupSortCost", String.valueOf(0L));
      localHashMap.put("contactSearchCost", String.valueOf(0L));
      localHashMap.put("contactNum", String.valueOf(0));
      localHashMap.put("friendNum", String.valueOf(0));
      localHashMap.put("isMyself", String.valueOf(0));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actFtsSearchEvent", true, 0L, 0L, localHashMap, null);
      return localObject3;
      i1 = ???.size();
      break label362;
    }
    ((ArrayList)localObject3).addAll(???);
    int i = 1;
    label814:
    localObject4 = (String)((ArrayList)localObject4).get(0);
    ??? = localHashMap.substring(localHashMap.indexOf((String)localObject4) + ((String)localObject4).length()).trim();
    long l1 = System.nanoTime();
    localObject4 = SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4);
    long l6 = (System.nanoTime() - l1) / 1000000L;
    int i4;
    int i3;
    if ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty()))
    {
      i4 = ((ArrayList)localObject4).size();
      localObject5 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (SQLiteFTSUtils.MsgSearchContactInfo)((Iterator)localObject5).next();
        if ((((SQLiteFTSUtils.MsgSearchContactInfo)localObject6).jdField_a_of_type_Int != 0) && (((SQLiteFTSUtils.MsgSearchContactInfo)localObject6).jdField_a_of_type_Int != 1004)) {
          break label2300;
        }
        j += 1;
      }
      i3 = j;
    }
    for (;;)
    {
      l1 = 0L + l5 + l6;
      long l2;
      Object localObject7;
      long l3;
      long l4;
      if ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty()))
      {
        int i5 = 0;
        j = 0;
        l2 = 0L;
        k = i;
        if (i5 < ((ArrayList)localObject4).size())
        {
          localObject5 = ((SQLiteFTSUtils.MsgSearchContactInfo)((ArrayList)localObject4).get(i5)).jdField_a_of_type_JavaLangString;
          int i9 = ((SQLiteFTSUtils.MsgSearchContactInfo)((ArrayList)localObject4).get(i5)).jdField_a_of_type_Int;
          localObject6 = ((SQLiteFTSUtils.MsgSearchContactInfo)((ArrayList)localObject4).get(i5)).jdField_a_of_type_AndroidUtilPair;
          int i6 = m;
          if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (CharSequence)localObject5)) {
            i6 = 1;
          }
          i = k;
          if (!TextUtils.equals((CharSequence)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
          {
            i = k;
            if (SQLiteFTSUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)
            {
              localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(???, FTSMessage.class, false, false, Long.valueOf((String)localObject5).longValue(), i9);
              i = k;
              if (localObject7 != null)
              {
                i = k;
                if (!((ArrayList)localObject7).isEmpty())
                {
                  Iterator localIterator = ((ArrayList)localObject7).iterator();
                  while (localIterator.hasNext())
                  {
                    FTSEntity localFTSEntity = (FTSEntity)localIterator.next();
                    localFTSEntity.mSearchScene = k;
                    ((FTSMessage)localFTSEntity).searchStrategy = 3;
                  }
                  i = k + 1;
                  ((ArrayList)localObject3).addAll((Collection)localObject7);
                }
              }
            }
          }
          l3 = l2;
          m = j;
          l4 = l1;
          if (i9 != 1)
          {
            if (i9 == 3000) {
              k = i;
            }
            for (;;)
            {
              i5 += 1;
              m = i6;
              break;
              if (i9 != 0)
              {
                l3 = l2;
                m = j;
                l4 = l1;
                if (i9 != 1004) {
                  break label2267;
                }
              }
              l3 = System.nanoTime();
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(???, FTSMessage.class, false, false, Long.valueOf((String)localObject5).longValue(), (Pair)localObject6);
              l2 += (System.nanoTime() - l3) / 1000000L;
              if (localObject5 == null)
              {
                k = 0;
                j += k;
                l1 += l2;
                l3 = l2;
                m = j;
                l4 = l1;
                if (localObject5 == null) {
                  break label2267;
                }
                l3 = l2;
                m = j;
                l4 = l1;
                if (((ArrayList)localObject5).isEmpty()) {
                  break label2267;
                }
                localObject6 = ((ArrayList)localObject5).iterator();
                label1392:
                if (!((Iterator)localObject6).hasNext()) {
                  break label1494;
                }
                localObject7 = (FTSEntity)((Iterator)localObject6).next();
                ((FTSEntity)localObject7).mSearchScene = i;
                ((FTSMessage)localObject7).searchStrategy = 3;
                ((FTSMessage)localObject7).senderNum = i4;
                ((FTSMessage)localObject7).friendNum = i3;
                localObject7 = (FTSMessage)localObject7;
                if (i6 != 1) {
                  break label1485;
                }
              }
              label1485:
              for (k = 0;; k = i5 + 1)
              {
                ((FTSMessage)localObject7).friendIndex = k;
                break label1392;
                k = ((ArrayList)localObject5).size();
                break;
              }
              label1494:
              k = i + 1;
              ((ArrayList)localObject3).addAll((Collection)localObject5);
            }
          }
        }
        else
        {
          i = k;
          k = j;
          j = m;
        }
      }
      for (m = i;; m = i)
      {
        if ((i2 == 0) && (((ArrayList)localObject3).isEmpty()))
        {
          l3 = System.nanoTime();
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localHashMap, FTSMessage.class, false, false, 0);
          l3 = (System.nanoTime() - l3) / 1000000L;
          if (localObject4 == null) {
            i = 0;
          }
          while ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty()))
          {
            localObject5 = ((ArrayList)localObject4).iterator();
            for (;;)
            {
              if (((Iterator)localObject5).hasNext())
              {
                localObject6 = (FTSEntity)((Iterator)localObject5).next();
                ((FTSEntity)localObject6).mSearchScene = m;
                ((FTSMessage)localObject6).searchStrategy = 4;
                continue;
                i = ((ArrayList)localObject4).size();
                break;
              }
            }
            ((ArrayList)localObject3).addAll((Collection)localObject4);
          }
          l4 = l1 + l3;
          l1 = l3;
          l3 = l4;
        }
        for (;;)
        {
          localObject4 = new ArrayList();
          l4 = System.nanoTime();
          localObject5 = a((ArrayList)localObject3);
          l4 = (System.nanoTime() - l4) / 1000000L;
          l3 += l4;
          localObject3 = SQLiteFTSUtils.a(localHashMap);
          localObject5 = ((ArrayList)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (FTSMessageSearchEngine.FTSSearchResultItem)((Iterator)localObject5).next();
            localObject7 = (FTSMessage)((FTSMessageSearchEngine.FTSSearchResultItem)localObject6).jdField_a_of_type_JavaUtilList.get(0);
            if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(((FTSMessage)localObject7).uin), ((FTSMessage)localObject7).istroop))
            {
              localObject7 = new FTSMessageSearchResultModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHashMap, localHashMap, (ArrayList)localObject3, ((FTSMessageSearchEngine.FTSSearchResultItem)localObject6).jdField_a_of_type_JavaUtilList, null, null);
              ((FTSMessageSearchResultModel)localObject7).jdField_a_of_type_Int = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject6).d;
              ((FTSMessageSearchResultModel)localObject7).b = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject6).e;
              ((FTSMessageSearchResultModel)localObject7).c = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject6).f;
              ((FTSMessageSearchResultModel)localObject7).d = ((FTSMessageSearchEngine.FTSSearchResultItem)localObject6).g;
              ((ArrayList)localObject4).add(localObject7);
            }
          }
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localHashMap, Boolean.valueOf(true));
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(???, Boolean.valueOf(true));
          c.put(localHashMap, new SoftReference(localObject4));
          ??? = new HashMap();
          ???.put("keyNum", String.valueOf(i7));
          ???.put("firstKeyLen", String.valueOf(i8));
          ???.put("searchPage", String.valueOf(n));
          ???.put("useCache", String.valueOf(0));
          ???.put("searchCost", String.valueOf(l3));
          ???.put("andSearchResultNum", String.valueOf(i1));
          ???.put("andSearchCost", String.valueOf(l5));
          ???.put("senderSearchResultNum", String.valueOf(k));
          ???.put("senderSearchCost", String.valueOf(l2));
          ???.put("fallSearchResultNum", String.valueOf(i));
          ???.put("fallSearchCost", String.valueOf(l1));
          ???.put("groupSortCost", String.valueOf(l4));
          ???.put("contactSearchCost", String.valueOf(l6));
          ???.put("contactNum", String.valueOf(i4));
          ???.put("friendNum", String.valueOf(i3));
          ???.put("isMyself", String.valueOf(j));
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actFtsSearchEvent", true, l3, 0L, ???, null);
          if (((localObject4 == null) || (((ArrayList)localObject4).isEmpty())) && (!TextUtils.isEmpty(localHashMap)) && (localHashMap.getBytes().length < 255))
          {
            j = 0;
            ??? = Pattern.compile("[一-龥]*").matcher(localHashMap);
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
              this.e.put(localHashMap, new Object());
              return a(localHashMap, paramBoolean);
            }
            return localObject4;
          }
          return localObject4;
          l4 = 0L;
          i = 0;
          l3 = l1;
          l1 = l4;
        }
        label2267:
        l1 = l4;
        k = i;
        l2 = l3;
        j = m;
        break;
        j = 0;
        l2 = 0L;
        k = 0;
      }
      label2300:
      break;
      i3 = 0;
      i4 = 0;
    }
  }
  
  public void b(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    ThreadManager.post(new ahym(this, paramSearchRequest, paramISearchListener), 8, null, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine
 * JD-Core Version:    0.7.0.1
 */