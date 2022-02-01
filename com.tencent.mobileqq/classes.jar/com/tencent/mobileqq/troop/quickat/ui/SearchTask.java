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
  public int a;
  private LinkedHashMap<String, List<ChatHistoryTroopMemberFragment.ATroopMember>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<ChatHistoryTroopMemberFragment.ATroopMember> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  public int b;
  private List<ChatHistoryTroopMemberFragment.ATroopMember> b;
  public int c;
  private List<ChatHistoryTroopMemberFragment.ATroopMember> c;
  
  public SearchTask(List<ChatHistoryTroopMemberFragment.ATroopMember> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
  }
  
  private SearchTask.SearchResult a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, String paramString, SearchTask.SearchResult paramSearchResult, boolean paramBoolean)
  {
    if (((AtUtil.a(paramQQAppInterface, paramTroopInfo)) || (AtUtil.b(paramQQAppInterface, paramTroopInfo))) && (!paramBoolean))
    {
      paramQQAppInterface = QuickAtListHelper.a();
      if ((TextUtils.isEmpty(paramString)) || (QuickAtListHelper.a(paramString, paramQQAppInterface))) {
        paramSearchResult.jdField_a_of_type_JavaUtilList.add(0, paramQQAppInterface);
      }
    }
    return paramSearchResult;
  }
  
  private SearchTask.SearchResult a(String paramString, boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    paramTroopInfo = a(paramString, paramTroopInfo);
    if (paramTroopInfo.length >= 3)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramTroopInfo[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])paramTroopInfo[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramTroopInfo[2]);
    }
    else
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_ArrayOfInt = new int[0];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    }
    this.jdField_c_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    paramTroopInfo = new SearchTask.SearchResult();
    paramTroopInfo.jdField_a_of_type_JavaLangString = paramString;
    paramTroopInfo.jdField_a_of_type_Boolean = paramBoolean;
    paramTroopInfo.jdField_a_of_type_ArrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    paramTroopInfo.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
    paramTroopInfo.jdField_a_of_type_JavaUtilList = this.jdField_c_of_type_JavaUtilList;
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
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        this.jdField_c_of_type_Int = 0;
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        boolean bool = localIterator.hasNext();
        c2 = 'A';
        if (!bool) {
          continue;
        }
        localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)localIterator.next();
        if ((localATroopMember.jdField_a_of_type_Boolean) || ((!TextUtils.isEmpty(paramString)) && (AtUtil.a(localATroopMember.jdField_a_of_type_JavaLangString, paramTroopInfo))) || ((!TextUtils.isEmpty(paramString)) && (AtUtil.b(localATroopMember.jdField_a_of_type_JavaLangString, paramTroopInfo)))) {
          continue;
        }
        localObject1 = localATroopMember.x;
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          continue;
        }
        localObject1 = ((String)localObject1).substring(0, 1);
      }
      finally
      {
        char c2;
        ChatHistoryTroopMemberFragment.ATroopMember localATroopMember;
        int i;
        long l;
        continue;
        throw paramString;
        continue;
        Object localObject1 = "#";
        continue;
        localObject1 = "★";
        continue;
        if ((97 <= i) && (i <= 122)) {
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
        i = ((String)localObject1).charAt(0);
        localObject2 = localObject1;
        if (!((String)localObject1).equals("★"))
        {
          if ((65 > i) || (i > 90)) {
            continue;
          }
          localObject2 = ((String)localObject1).toUpperCase();
        }
      }
      if (localLinkedHashMap.get(localObject2) == null) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      this.jdField_b_of_type_Int += 1;
      ((List)localLinkedHashMap.get(localObject2)).add(localATroopMember);
    }
    paramTroopInfo = new AtUtil.AlphabetComparator(paramTroopInfo);
    paramString = new LinkedHashMap();
    l = System.currentTimeMillis();
    c1 = c2;
    if (localLinkedHashMap.get("★") != null)
    {
      this.jdField_a_of_type_Int += 1;
      Collections.sort((List)localLinkedHashMap.get("★"), paramTroopInfo);
      paramString.put("★", localLinkedHashMap.get("★"));
      c1 = c2;
    }
    if (c1 <= 'Z')
    {
      if (localLinkedHashMap.get(String.valueOf(c1)) != null)
      {
        this.jdField_a_of_type_Int += 1;
        Collections.sort((List)localLinkedHashMap.get(String.valueOf(c1)), paramTroopInfo);
        paramString.put(String.valueOf(c1), localLinkedHashMap.get(String.valueOf(c1)));
      }
    }
    else
    {
      if (localLinkedHashMap.get("#") != null)
      {
        this.jdField_a_of_type_Int += 1;
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
      i = 1;
      while (i < paramTroopInfo.length)
      {
        paramTroopInfo[i] += paramTroopInfo[(i - 1)] + ((List)paramString.get(((Iterator)localObject2).next())).size();
        i += 1;
      }
      localObject2 = paramString.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = ((String)((Iterator)localObject2).next());
        i += 1;
      }
      return new Object[] { paramString, paramTroopInfo, localObject1 };
    }
  }
  
  public SearchTask.SearchResult a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, SessionInfo paramSessionInfo, boolean paramBoolean2)
  {
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramSessionInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramSessionInfo);
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_b_of_type_JavaUtilList = QuickAtListHelper.a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList, paramBoolean1);
    } else {
      this.jdField_b_of_type_JavaUtilList = new ArrayList(QuickAtListHelper.a(paramString, QuickAtListHelper.a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList, paramBoolean1), paramQQAppInterface, paramSessionInfo));
    }
    return a(paramQQAppInterface, paramSessionInfo, paramString, a(paramString, paramBoolean1, paramSessionInfo), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.SearchTask
 * JD-Core Version:    0.7.0.1
 */