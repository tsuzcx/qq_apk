package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class SearchCostStat
{
  private static SearchCostStat.SearchScene a;
  private static final Object b = new Object();
  
  public static void a()
  {
    for (;;)
    {
      synchronized (b)
      {
        if (a != null)
        {
          Object localObject1 = new SearchCostStat.SearchStep(null);
          ((SearchCostStat.SearchStep)localObject1).a = "End";
          ((SearchCostStat.SearchStep)localObject1).b = System.currentTimeMillis();
          ((SearchCostStat.SearchStep)localObject1).c = true;
          a.c.add(localObject1);
          localObject1 = a.a();
          a = null;
          a((SearchCostStat.SearchSceneRecord)localObject1);
          return;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public static void a(int paramInt)
  {
    synchronized (b)
    {
      if (a != null)
      {
        SearchCostStat.SearchScene localSearchScene = a;
        localSearchScene.b |= paramInt;
      }
      return;
    }
  }
  
  private static void a(SearchCostStat.SearchSceneRecord paramSearchSceneRecord)
  {
    if (paramSearchSceneRecord == null) {
      return;
    }
    Object localObject = paramSearchSceneRecord.a;
    ((StringBuilder)localObject).append(",needReport=");
    ((StringBuilder)localObject).append(paramSearchSceneRecord.c);
    QLog.i("SearchCostStat", 1, paramSearchSceneRecord.a.toString());
    if (paramSearchSceneRecord.c)
    {
      if (Utils.d()) {
        localObject = "qq_search_vip_cost";
      } else {
        localObject = "qq_search_cost";
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject, true, 0L, 0L, paramSearchSceneRecord.b, "");
    }
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(paramString);
    a(localStringBuilder.toString(), false);
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1) {
      return;
    }
    for (;;)
    {
      synchronized (b)
      {
        if (a != null)
        {
          localSearchSceneRecord = a.a();
          a = new SearchCostStat.SearchScene(null);
          a.a = paramString;
          paramString = new SearchCostStat.SearchParam(null);
          paramString.a = "from";
          paramString.b = String.valueOf(paramInt);
          a.d.add(paramString);
          paramString = new SearchCostStat.SearchParam(null);
          paramString.a = "isActivityFirstTime";
          paramString.b = String.valueOf(paramBoolean);
          a.d.add(paramString);
          paramString = new SearchCostStat.SearchStep(null);
          paramString.a = "Start";
          paramString.b = System.currentTimeMillis();
          a.c.add(paramString);
          a(localSearchSceneRecord);
          return;
        }
      }
      SearchCostStat.SearchSceneRecord localSearchSceneRecord = null;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    synchronized (b)
    {
      if (a != null)
      {
        SearchCostStat.SearchParam localSearchParam = new SearchCostStat.SearchParam(null);
        localSearchParam.a = paramString1;
        localSearchParam.b = paramString2;
        a.d.add(localSearchParam);
      }
      return;
    }
  }
  
  private static void a(String paramString, boolean paramBoolean)
  {
    synchronized (b)
    {
      if (a != null)
      {
        SearchCostStat.SearchStep localSearchStep = new SearchCostStat.SearchStep(null);
        localSearchStep.a = paramString;
        localSearchStep.b = System.currentTimeMillis();
        localSearchStep.c = paramBoolean;
        a.c.add(localSearchStep);
      }
      return;
    }
  }
  
  public static void b(String paramString)
  {
    a(paramString, true);
  }
  
  public static void c(String paramString)
  {
    synchronized (b)
    {
      if ((a != null) && (!TextUtils.isEmpty(paramString)) && (!paramString.equals(a.e)))
      {
        a.e = paramString;
        a.f = System.currentTimeMillis();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveShowContactTime time=");
        localStringBuilder.append(a.f);
        localStringBuilder.append(",contactList=[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("SearchCostStat", 1, localStringBuilder.toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchCostStat
 * JD-Core Version:    0.7.0.1
 */