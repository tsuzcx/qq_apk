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
  public int a;
  private FixPosArticleInterface.FixPosArticleAsyncListener jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiFixPosArticleInterface$FixPosArticleAsyncListener = new ReadinjoyFixPosArticleManager.ADArticleController.1(this);
  HashMap<Integer, ArrayList<Integer>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  HashMap<Integer, ArrayList<Integer>> b = new HashMap();
  HashMap<Integer, ArrayList<AbsBaseArticleInfo>> c = new HashMap();
  
  ReadinjoyFixPosArticleManager$ADArticleController(ReadinjoyFixPosArticleManager paramReadinjoyFixPosArticleManager, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private FixPosArticleInterface a()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if (localAppRuntime != null) {
      return ((ReadInJoyLogicManager)localAppRuntime.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a();
    }
    return null;
  }
  
  public AbsBaseArticleInfo a(int paramInt1, int paramInt2)
  {
    Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int i = ((ArrayList)localObject).indexOf(Integer.valueOf(paramInt2));
      if (i != -1)
      {
        if ((this.c.containsKey(Integer.valueOf(paramInt1))) && (i < ((ArrayList)this.c.get(Integer.valueOf(paramInt1))).size()))
        {
          localObject = (AbsBaseArticleInfo)((ArrayList)this.c.get(Integer.valueOf(paramInt1))).get(i);
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
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList1);
      this.b.put(Integer.valueOf(paramInt), localArrayList2);
      localObject1 = ((FixPosArticleInterface)localObject1).a(paramInt);
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject2 = new ArrayList((Collection)localObject1);
        this.c.put(Integer.valueOf(paramInt), localObject2);
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
  
  void a(int paramInt1, int paramInt2)
  {
    Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      int i = ((ArrayList)localObject).indexOf(Integer.valueOf(paramInt2));
      if (i != -1)
      {
        ((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1))).remove(i);
        ((ArrayList)this.b.get(Integer.valueOf(paramInt1))).remove(i);
        ((ArrayList)this.c.get(Integer.valueOf(paramInt1))).remove(i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delete ad article , position : ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("ReadinjoyFixPosArticleManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  boolean a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).size() > 0) && (this.c.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.c.get(Integer.valueOf(paramInt))).size() > 0))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
      this.c.remove(Integer.valueOf(paramInt));
      this.b.remove(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  void c(int paramInt)
  {
    FixPosArticleInterface localFixPosArticleInterface = a();
    if (localFixPosArticleInterface != null) {
      localFixPosArticleInterface.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiFixPosArticleInterface$FixPosArticleAsyncListener);
    }
  }
  
  void d(int paramInt)
  {
    FixPosArticleInterface localFixPosArticleInterface = a();
    if (localFixPosArticleInterface != null) {
      localFixPosArticleInterface.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager.ADArticleController
 * JD-Core Version:    0.7.0.1
 */