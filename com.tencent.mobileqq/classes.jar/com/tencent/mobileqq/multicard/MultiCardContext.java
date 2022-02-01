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
  private String b;
  private Map<String, CardContent> c = new HashMap();
  private List<CardIndicator> d = new ArrayList();
  private Map<String, String> e = new HashMap();
  
  public MultiCardContext(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.a = paramQQAppInterface;
    this.b = paramString;
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
  
  public CardIndicator a(int paramInt)
  {
    try
    {
      if ((this.d != null) && (paramInt >= 0) && (paramInt <= this.d.size()))
      {
        CardIndicator localCardIndicator = (CardIndicator)this.d.get(paramInt);
        return localCardIndicator;
      }
      return null;
    }
    finally {}
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.e.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public ArrayList<Long> a(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.d == null) || (this.d.size() <= paramInt1) || (paramInt1 < 0) || (paramInt2 <= 0)) {
        break label127;
      }
      i = paramInt2;
      if (paramInt1 + paramInt2 > this.d.size()) {
        i = this.d.size() - paramInt1;
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
      str = ((CardIndicator)this.d.get(paramInt2)).a();
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
        localArrayList.add(new CardIndicator(str, ContactUtils.b(this.a, this.b, str)));
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
      this.d.clear();
      this.d.addAll(paramList);
      if (paramMap != null) {
        this.c.putAll(paramMap);
      }
      if (paramMap1 != null) {
        this.e.putAll(paramMap1);
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
  
  public int b()
  {
    try
    {
      if (this.d == null) {
        return 0;
      }
      int i = this.d.size();
      return i;
    }
    finally {}
  }
  
  public CardContent b(int paramInt)
  {
    try
    {
      if ((this.c != null) && (paramInt >= 0) && (this.d != null) && (paramInt < this.d.size()))
      {
        CardIndicator localCardIndicator = (CardIndicator)this.d.get(paramInt);
        if (localCardIndicator != null)
        {
          CardContent localCardContent = (CardContent)this.c.get(localCardIndicator.a());
          if ((localCardContent != null) && (TextUtils.isEmpty(localCardContent.d()))) {
            localCardContent.a((String)this.e.get(localCardIndicator.a()));
          }
          return localCardContent;
        }
        return null;
      }
      return null;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardContext
 * JD-Core Version:    0.7.0.1
 */