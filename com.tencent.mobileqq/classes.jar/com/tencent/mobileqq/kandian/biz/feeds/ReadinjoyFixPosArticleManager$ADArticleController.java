package com.tencent.mobileqq.kandian.biz.feeds;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.FixPosArticleInterface;
import com.tencent.mobileqq.kandian.biz.feeds.api.FixPosArticleInterface.FixPosArticleAsyncListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import mqq.app.AppRuntime;

class ReadinjoyFixPosArticleManager$ADArticleController
{
  public int a = 0;
  HashMap<Integer, ArrayList<Integer>> b = new HashMap();
  HashMap<Integer, ArrayList<Integer>> c = new HashMap();
  HashMap<Integer, ArrayList<AbsBaseArticleInfo>> d = new HashMap();
  private FixPosArticleInterface.FixPosArticleAsyncListener f = new ReadinjoyFixPosArticleManager.ADArticleController.1(this);
  
  ReadinjoyFixPosArticleManager$ADArticleController(ReadinjoyFixPosArticleManager paramReadinjoyFixPosArticleManager, int paramInt)
  {
    this.a = paramInt;
  }
  
  private FixPosArticleInterface a()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.b();
    if (localAppRuntime != null) {
      return ((ReadInJoyLogicManager)localAppRuntime.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().M();
    }
    return null;
  }
  
  public AbsBaseArticleInfo a(int paramInt1, int paramInt2)
  {
    Object localObject = (ArrayList)this.b.get(Integer.valueOf(paramInt1));
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int i = ((ArrayList)localObject).indexOf(Integer.valueOf(paramInt2));
      if (i != -1)
      {
        if ((this.d.containsKey(Integer.valueOf(paramInt1))) && (i < ((ArrayList)this.d.get(Integer.valueOf(paramInt1))).size()))
        {
          localObject = (AbsBaseArticleInfo)((ArrayList)this.d.get(Integer.valueOf(paramInt1))).get(i);
          if (localObject != null) {
            ((AbsBaseArticleInfo)localObject).mRecommendSeq = ReadinjoyFixPosArticleManager.access$100(1, paramInt2);
          }
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("article isn't exist ! positon : ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("ReadinjoyFixPosArticleManager", 1, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "positons is null !");
    }
    return null;
  }
  
  void a(int paramInt)
  {
    b(paramInt);
    Object localObject1 = a();
    if (localObject1 == null)
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "adinterface is null !");
      return;
    }
    Object localObject2 = ((FixPosArticleInterface)localObject1).a(paramInt);
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int j = 0;
      int i = 0;
      while (i < localObject2.length)
      {
        localArrayList1.add(Integer.valueOf(localObject2[i]));
        localArrayList2.add(Integer.valueOf(0));
        i += 1;
      }
      Collections.sort(localArrayList1, new ReadinjoyFixPosArticleManager.ADArticleController.2(this));
      this.b.put(Integer.valueOf(paramInt), localArrayList1);
      this.c.put(Integer.valueOf(paramInt), localArrayList2);
      localObject1 = ((FixPosArticleInterface)localObject1).b(paramInt);
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject2 = new ArrayList((Collection)localObject1);
        this.d.put(Integer.valueOf(paramInt), localObject2);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ad pos : ");
      ((StringBuilder)localObject2).append(localArrayList1);
      ((StringBuilder)localObject2).append(", channelID : ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", articleSize : ");
      paramInt = j;
      if (localObject1 != null) {
        paramInt = ((ArrayList)localObject1).size();
      }
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d("ReadinjoyFixPosArticleManager", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    QLog.d("ReadinjoyFixPosArticleManager", 1, "get ad position fail ~ return data is null !");
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.b.remove(Integer.valueOf(paramInt));
      this.d.remove(Integer.valueOf(paramInt));
      this.c.remove(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  void b(int paramInt1, int paramInt2)
  {
    Object localObject = (ArrayList)this.b.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      int i = ((ArrayList)localObject).indexOf(Integer.valueOf(paramInt2));
      if (i != -1)
      {
        ((ArrayList)this.b.get(Integer.valueOf(paramInt1))).remove(i);
        ((ArrayList)this.c.get(Integer.valueOf(paramInt1))).remove(i);
        ((ArrayList)this.d.get(Integer.valueOf(paramInt1))).remove(i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delete ad article , position : ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("ReadinjoyFixPosArticleManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  void c(int paramInt)
  {
    FixPosArticleInterface localFixPosArticleInterface = a();
    if (localFixPosArticleInterface != null) {
      localFixPosArticleInterface.a(paramInt, this.f);
    }
  }
  
  void d(int paramInt)
  {
    FixPosArticleInterface localFixPosArticleInterface = a();
    if (localFixPosArticleInterface != null) {
      localFixPosArticleInterface.c(paramInt);
    }
  }
  
  boolean e(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.b.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.b.get(Integer.valueOf(paramInt))).size() > 0) && (this.d.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.d.get(Integer.valueOf(paramInt))).size() > 0))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager.ADArticleController
 * JD-Core Version:    0.7.0.1
 */