package com.tencent.mobileqq.search.util;

import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.app.MobileQQ;

class SearchCostStat$SearchScene
{
  public String a;
  public long b = 0L;
  public final LinkedList<SearchCostStat.SearchStep> c = new LinkedList();
  public final LinkedList<SearchCostStat.SearchParam> d = new LinkedList();
  public String e;
  public long f = 0L;
  
  public SearchCostStat.SearchSceneRecord a()
  {
    SimpleAccount localSimpleAccount = null;
    SearchCostStat.SearchSceneRecord localSearchSceneRecord = new SearchCostStat.SearchSceneRecord(null);
    boolean bool;
    if ((this.b & 0x4) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    localSearchSceneRecord.c = bool;
    Object localObject1 = localSearchSceneRecord.a;
    ((StringBuilder)localObject1).append("keyword=");
    ((StringBuilder)localObject1).append(this.a);
    localObject1 = localSearchSceneRecord.a;
    ((StringBuilder)localObject1).append(",keyEvents=");
    ((StringBuilder)localObject1).append(this.b);
    if (localSearchSceneRecord.c) {
      localSearchSceneRecord.b.put("keyEvents", String.valueOf(this.b));
    }
    localObject1 = this.d.iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SearchCostStat.SearchParam)((Iterator)localObject1).next();
      localObject3 = localSearchSceneRecord.a;
      ((StringBuilder)localObject3).append(",");
      ((StringBuilder)localObject3).append(((SearchCostStat.SearchParam)localObject2).a);
      ((StringBuilder)localObject3).append("=");
      ((StringBuilder)localObject3).append(((SearchCostStat.SearchParam)localObject2).b);
      if (localSearchSceneRecord.c) {
        localSearchSceneRecord.b.put(((SearchCostStat.SearchParam)localObject2).a, ((SearchCostStat.SearchParam)localObject2).b);
      }
    }
    localSearchSceneRecord.a.append(",allStep=[");
    localObject1 = this.c.iterator();
    long l3 = 0L;
    for (long l2 = l3; ((Iterator)localObject1).hasNext(); l2 = l1)
    {
      localObject2 = (SearchCostStat.SearchStep)((Iterator)localObject1).next();
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((SearchCostStat.SearchStep)localObject2).b;
      }
      if (l3 != 0L)
      {
        l2 = ((SearchCostStat.SearchStep)localObject2).b - l3;
        localObject3 = localSearchSceneRecord.a;
        ((StringBuilder)localObject3).append("-");
        ((StringBuilder)localObject3).append(l2);
        ((StringBuilder)localObject3).append("->");
      }
      else
      {
        l2 = 0L;
      }
      l3 = ((SearchCostStat.SearchStep)localObject2).b;
      localSearchSceneRecord.a.append(((SearchCostStat.SearchStep)localObject2).a);
      if ((localSearchSceneRecord.c) && (((SearchCostStat.SearchStep)localObject2).c))
      {
        localObject3 = localSearchSceneRecord.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((SearchCostStat.SearchStep)localObject2).a);
        localStringBuilder.append("Cost");
        ((HashMap)localObject3).put(localStringBuilder.toString(), String.valueOf(l2));
      }
    }
    long l1 = l3 - l2;
    localObject1 = localSearchSceneRecord.a;
    ((StringBuilder)localObject1).append("],startTime=");
    ((StringBuilder)localObject1).append(l2);
    localObject1 = localSearchSceneRecord.a;
    ((StringBuilder)localObject1).append(",consumeTime=");
    ((StringBuilder)localObject1).append(l1);
    localObject1 = localSearchSceneRecord.a;
    ((StringBuilder)localObject1).append(",lastShowContactTime=");
    ((StringBuilder)localObject1).append(this.f);
    localObject1 = localSearchSceneRecord.a;
    ((StringBuilder)localObject1).append(",lastShowContact=[");
    ((StringBuilder)localObject1).append(this.e);
    ((StringBuilder)localObject1).append("]");
    l3 = this.f;
    if (l3 > l2)
    {
      l2 = l3 - l2;
      localObject1 = localSearchSceneRecord.a;
      ((StringBuilder)localObject1).append(",searchContactCost=");
      ((StringBuilder)localObject1).append(l2);
      if (localSearchSceneRecord.c) {
        localSearchSceneRecord.b.put("searchContactCostTime", String.valueOf(l2));
      }
    }
    if (localSearchSceneRecord.c)
    {
      localSearchSceneRecord.b.put("detail", localSearchSceneRecord.a.toString());
      localSearchSceneRecord.b.put("totalCost", String.valueOf(l1));
      if (MobileQQ.sMobileQQ != null) {
        localSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      }
      if (localSimpleAccount != null) {
        localSearchSceneRecord.b.put("searchUin", localSimpleAccount.getUin());
      }
    }
    return localSearchSceneRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchCostStat.SearchScene
 * JD-Core Version:    0.7.0.1
 */