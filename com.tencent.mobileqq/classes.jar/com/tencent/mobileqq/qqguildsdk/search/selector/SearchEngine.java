package com.tencent.mobileqq.qqguildsdk.search.selector;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import com.tencent.mobileqq.qqguildsdk.search.model.SearchRequestModel;
import com.tencent.mobileqq.qqguildsdk.search.model.SearchResultModel;
import com.tencent.mobileqq.qqguildsdk.search.util.ISearchable;
import com.tencent.mobileqq.qqguildsdk.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SearchEngine<T>
{
  private SearchEngine<T>.SearchThread a;
  protected Handler b = new Handler(Looper.getMainLooper());
  protected String c = "";
  protected int d;
  protected ISearchSink e;
  protected Vector<T> f = new Vector();
  private ConcurrentHashMap<String, Runnable> g = new ConcurrentHashMap();
  private String h = "CURRENT_TASK";
  
  private long a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (paramInt == 2) {
      return SearchUtils.a(paramString1, paramString2, paramLong, false);
    }
    return SearchUtils.a(paramString1, paramString2, paramLong, true);
  }
  
  private List<Map.Entry<SearchEngine<T>.SearchMsg, List<T>>> a(List<T> paramList, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = a(localObject1, paramInt);
      paramList = null;
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        String str = (String)localEntry.getValue();
        int i = ((Integer)localEntry.getKey()).intValue();
        long l = a(paramString, str, i, a(i));
        if (paramList == null)
        {
          paramList = new SearchEngine.SearchMsg(this, str, l);
        }
        else if (l > paramList.a)
        {
          paramList.b = str;
          paramList.a = l;
        }
      }
      if (paramList.a > -9223372036854775808L)
      {
        if (!localHashMap.containsKey(paramList)) {
          localHashMap.put(paramList, new ArrayList());
        }
        ((List)localHashMap.get(paramList)).add(localObject1);
      }
    }
    paramList = new ArrayList(localHashMap.entrySet());
    Collections.sort(paramList, new SearchEngine.2(this));
    return paramList;
  }
  
  long a(int paramInt)
  {
    if (paramInt == 2) {
      return ISearchable.b;
    }
    return ISearchable.a;
  }
  
  protected List<ISearchResultModel<T>> a(SearchRequestModel paramSearchRequestModel)
  {
    if (paramSearchRequestModel == null) {
      return null;
    }
    String str = paramSearchRequestModel.a();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramSearchRequestModel = a(this.f, str, paramSearchRequestModel.b());
    if (paramSearchRequestModel.size() > 0)
    {
      paramSearchRequestModel = paramSearchRequestModel.iterator();
      while (paramSearchRequestModel.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramSearchRequestModel.next();
        SearchResultModel localSearchResultModel = new SearchResultModel(str);
        localSearchResultModel.a((List)localEntry.getValue());
        localArrayList.add(localSearchResultModel);
      }
    }
    return localArrayList;
  }
  
  abstract Map<Integer, String> a(T paramT, int paramInt);
  
  public void a(String paramString, int paramInt, ISearchSink paramISearchSink)
  {
    this.c = paramString;
    this.d = paramInt;
    this.e = paramISearchSink;
    if (e())
    {
      this.f.clear();
      d();
    }
    this.g.put(this.h, b());
    paramString = this.a;
    if ((paramString == null) || (!paramString.isAlive()))
    {
      this.a = new SearchEngine.SearchThread(this);
      this.a.start();
    }
  }
  
  protected Runnable b()
  {
    return new SearchEngine.1(this);
  }
  
  protected boolean c()
  {
    return this.f.isEmpty() ^ true;
  }
  
  protected abstract void d();
  
  protected abstract boolean e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.SearchEngine
 * JD-Core Version:    0.7.0.1
 */