package com.tencent.mobileqq.troop.quickat.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SearchTask
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  private int[] d = new int[0];
  private String[] e = new String[0];
  private List<ChatHistoryTroopMemberFragment.ATroopMember> f;
  private List<ChatHistoryTroopMemberFragment.ATroopMember> g;
  private LinkedHashMap<String, List<ChatHistoryTroopMemberFragment.ATroopMember>> h = new LinkedHashMap();
  private List<ChatHistoryTroopMemberFragment.ATroopMember> i;
  
  public SearchTask(List<ChatHistoryTroopMemberFragment.ATroopMember> paramList)
  {
    this.f = paramList;
    this.i = new ArrayList();
  }
  
  private SearchTask.SearchResult a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, String paramString, SearchTask.SearchResult paramSearchResult, boolean paramBoolean)
  {
    if (((AtUtil.a(paramQQAppInterface, paramTroopInfo)) || (AtUtil.b(paramQQAppInterface, paramTroopInfo))) && (!paramBoolean))
    {
      paramQQAppInterface = QuickAtListHelper.d();
      if ((TextUtils.isEmpty(paramString)) || (QuickAtListHelper.a(paramString, paramQQAppInterface))) {
        paramSearchResult.c.add(0, paramQQAppInterface);
      }
    }
    return paramSearchResult;
  }
  
  private SearchTask.SearchResult a(String paramString, boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    paramTroopInfo = a(paramString, paramTroopInfo);
    if (paramTroopInfo.length >= 3)
    {
      this.h = ((LinkedHashMap)paramTroopInfo[0]);
      this.d = ((int[])paramTroopInfo[1]);
      this.e = ((String[])paramTroopInfo[2]);
    }
    else
    {
      this.h.clear();
      this.d = new int[0];
      this.e = new String[0];
    }
    this.i = a(this.h);
    paramTroopInfo = new SearchTask.SearchResult();
    paramTroopInfo.a = paramString;
    paramTroopInfo.b = paramBoolean;
    paramTroopInfo.d = this.d;
    paramTroopInfo.e = this.e;
    paramTroopInfo.c = this.i;
    return paramTroopInfo;
  }
  
  private List<ChatHistoryTroopMemberFragment.ATroopMember> a(LinkedHashMap<String, List<ChatHistoryTroopMemberFragment.ATroopMember>> paramLinkedHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
    while (paramLinkedHashMap.hasNext()) {
      localArrayList.addAll((Collection)((Map.Entry)paramLinkedHashMap.next()).getValue());
    }
    return localArrayList;
  }
  
  private Object[] a(String paramString, TroopInfo paramTroopInfo)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    for (;;)
    {
      try
      {
        this.b = 0;
        this.a = 0;
        this.c = 0;
        Iterator localIterator = this.g.iterator();
        boolean bool = localIterator.hasNext();
        c2 = 'A';
        if (!bool) {
          continue;
        }
        localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)localIterator.next();
        if ((localATroopMember.A) || ((!TextUtils.isEmpty(paramString)) && (AtUtil.a(localATroopMember.a, paramTroopInfo))) || ((!TextUtils.isEmpty(paramString)) && (AtUtil.b(localATroopMember.a, paramTroopInfo)))) {
          continue;
        }
        localObject1 = localATroopMember.U;
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          continue;
        }
        localObject1 = ((String)localObject1).substring(0, 1);
      }
      finally
      {
        char c2;
        ChatHistoryTroopMemberFragment.ATroopMember localATroopMember;
        int j;
        long l;
        continue;
        throw paramString;
        continue;
        Object localObject1 = "#";
        continue;
        localObject1 = "★";
        continue;
        if ((97 <= j) && (j <= 122)) {
          continue;
        }
        Object localObject2 = "#";
        continue;
        char c1 = (char)(c1 + '\001');
        continue;
      }
      localObject2 = localObject1;
      if (((String)localObject1).length() == 1)
      {
        j = ((String)localObject1).charAt(0);
        localObject2 = localObject1;
        if (!((String)localObject1).equals("★"))
        {
          if ((65 > j) || (j > 90)) {
            continue;
          }
          localObject2 = ((String)localObject1).toUpperCase();
        }
      }
      if (localLinkedHashMap.get(localObject2) == null) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      this.b += 1;
      ((List)localLinkedHashMap.get(localObject2)).add(localATroopMember);
    }
    paramTroopInfo = new AtUtil.AlphabetComparator(paramTroopInfo);
    paramString = new LinkedHashMap();
    l = System.currentTimeMillis();
    c1 = c2;
    if (localLinkedHashMap.get("★") != null)
    {
      this.a += 1;
      Collections.sort((List)localLinkedHashMap.get("★"), paramTroopInfo);
      paramString.put("★", localLinkedHashMap.get("★"));
      c1 = c2;
    }
    if (c1 <= 'Z')
    {
      if (localLinkedHashMap.get(String.valueOf(c1)) != null)
      {
        this.a += 1;
        Collections.sort((List)localLinkedHashMap.get(String.valueOf(c1)), paramTroopInfo);
        paramString.put(String.valueOf(c1), localLinkedHashMap.get(String.valueOf(c1)));
      }
    }
    else
    {
      if (localLinkedHashMap.get("#") != null)
      {
        this.a += 1;
        Collections.sort((List)localLinkedHashMap.get("#"), paramTroopInfo);
        paramString.put("#", localLinkedHashMap.get("#"));
      }
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder();
        paramTroopInfo.append("constructHashStruct-sort: invoked.  cost: ");
        paramTroopInfo.append(System.currentTimeMillis() - l);
        QLog.i("SearchTask", 2, paramTroopInfo.toString());
      }
      localLinkedHashMap.clear();
      paramTroopInfo = new int[paramString.keySet().size()];
      localObject1 = new String[paramTroopInfo.length];
      localObject2 = paramString.keySet().iterator();
      if (paramTroopInfo.length == 0) {
        return new Object[0];
      }
      paramTroopInfo[0] = 0;
      j = 1;
      while (j < paramTroopInfo.length)
      {
        paramTroopInfo[j] += paramTroopInfo[(j - 1)] + ((List)paramString.get(((Iterator)localObject2).next())).size();
        j += 1;
      }
      localObject2 = paramString.keySet().iterator();
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[j] = ((String)((Iterator)localObject2).next());
        j += 1;
      }
      return new Object[] { paramString, paramTroopInfo, localObject1 };
    }
  }
  
  public SearchTask.SearchResult a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, SessionInfo paramSessionInfo, boolean paramBoolean2)
  {
    paramSessionInfo = paramSessionInfo.b;
    paramSessionInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramSessionInfo);
    if (TextUtils.isEmpty(paramString)) {
      this.g = QuickAtListHelper.a(paramQQAppInterface, this.f, paramBoolean1);
    } else {
      this.g = new ArrayList(QuickAtListHelper.a(paramString, QuickAtListHelper.a(paramQQAppInterface, this.f, paramBoolean1), paramQQAppInterface, paramSessionInfo));
    }
    return a(paramQQAppInterface, paramSessionInfo, paramString, a(paramString, paramBoolean1, paramSessionInfo), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.SearchTask
 * JD-Core Version:    0.7.0.1
 */