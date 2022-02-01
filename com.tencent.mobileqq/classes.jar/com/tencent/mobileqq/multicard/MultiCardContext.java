package com.tencent.mobileqq.multicard;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MultiCardContext
{
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private List<CardIndicator> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, CardContent> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, String> b = new HashMap();
  
  public MultiCardContext(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static MultiCardContext a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create() called with: app = [");
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append("]");
      QLog.d("MultiCardContext", 2, localStringBuilder.toString());
    }
    return new MultiCardContext(paramQQAppInterface, paramString);
  }
  
  public int a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return 0;
      }
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
    finally {}
  }
  
  public CardContent a(int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (paramInt >= 0) && (this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        CardIndicator localCardIndicator = (CardIndicator)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (localCardIndicator != null)
        {
          CardContent localCardContent = (CardContent)this.jdField_a_of_type_JavaUtilMap.get(localCardIndicator.a());
          if ((localCardContent != null) && (TextUtils.isEmpty(localCardContent.b()))) {
            localCardContent.a((String)this.b.get(localCardIndicator.a()));
          }
          return localCardContent;
        }
        return null;
      }
      return null;
    }
    finally {}
  }
  
  public CardIndicator a(int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt <= this.jdField_a_of_type_JavaUtilList.size()))
      {
        CardIndicator localCardIndicator = (CardIndicator)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        return localCardIndicator;
      }
      return null;
    }
    finally {}
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.b.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public ArrayList<Long> a(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt1) || (paramInt1 < 0) || (paramInt2 <= 0)) {
        break label127;
      }
      i = paramInt2;
      if (paramInt1 + paramInt2 > this.jdField_a_of_type_JavaUtilList.size()) {
        i = this.jdField_a_of_type_JavaUtilList.size() - paramInt1;
      }
      localArrayList = new ArrayList();
      paramInt2 = paramInt1;
    }
    finally
    {
      try
      {
        ArrayList localArrayList;
        for (;;)
        {
          int i;
          String str;
          localArrayList.add(Long.valueOf(Long.valueOf(str).longValue()));
          label115:
          paramInt2 += 1;
        }
        return localArrayList;
        label127:
        return null;
        localObject = finally;
        for (;;)
        {
          throw localObject;
        }
      }
      catch (Exception localException)
      {
        break label115;
      }
    }
    if (paramInt2 < paramInt1 + i) {
      str = ((CardIndicator)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).a();
    }
  }
  
  public List<CardIndicator> a(List<Long> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = String.valueOf((Long)paramList.next());
        localArrayList.add(new CardIndicator(str, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, str)));
      }
      return localArrayList;
    }
    return null;
  }
  
  public Map<String, CardContent> a(Map<Long, IntimateInfo> paramMap)
  {
    if (paramMap != null)
    {
      HashMap localHashMap = new HashMap();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(String.valueOf(localEntry.getKey()), new CardContent((IntimateInfo)localEntry.getValue()));
      }
      return localHashMap;
    }
    return null;
  }
  
  public void a(List<CardIndicator> paramList, Map<String, CardContent> paramMap, Map<String, String> paramMap1)
  {
    if (paramList != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (paramMap != null) {
        this.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
      }
      if (paramMap1 != null) {
        this.b.putAll(paramMap1);
      }
      return;
    }
    finally
    {
      label60:
      break label60;
    }
    throw paramList;
  }
  
  public Map<String, String> b(Map<Long, String> paramMap)
  {
    if (paramMap != null)
    {
      HashMap localHashMap = new HashMap();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(String.valueOf(localEntry.getKey()), localEntry.getValue());
      }
      return localHashMap;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardContext
 * JD-Core Version:    0.7.0.1
 */