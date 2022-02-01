package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import bbmf;
import bbmi;
import bbml;
import bbmx;
import bbmy;
import bbsj;
import bbti;
import bbtj;
import bbtk;
import bbtl;
import bbtx;
import bbuo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class GroupSearchEngine$SearchRunnable
  implements Runnable
{
  private bbtk jdField_a_of_type_Bbtk;
  private bbtx jdField_a_of_type_Bbtx;
  private boolean jdField_a_of_type_Boolean;
  
  public GroupSearchEngine$SearchRunnable(GroupSearchEngine paramGroupSearchEngine, bbtx parambbtx, bbtk parambbtk)
  {
    this.jdField_a_of_type_Bbtx = parambbtx;
    this.jdField_a_of_type_Bbtk = parambbtk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bbtk = null;
  }
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "begin local search at :" + l1);
    }
    int j = 0;
    int k = 0;
    for (;;)
    {
      if (k >= GroupSearchEngine.a(this.this$0).size()) {
        break label821;
      }
      Object localObject3 = (bbti)GroupSearchEngine.a(this.this$0).get(k);
      if ((((bbti)localObject3).a instanceof NetSearchEngine)) {}
      try
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        Thread.sleep(300L);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject4;
          ArrayList localArrayList2;
          localInterruptedException.printStackTrace();
          continue;
          int i = 1;
          continue;
          localObject2 = (bbmi)localInterruptedException.get(1);
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "start search : " + ((bbti)localObject3).a.getClass().getSimpleName());
      }
      localObject1 = ((bbti)localObject3).a(this.jdField_a_of_type_Bbtx);
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "end search : " + ((bbti)localObject3).a.getClass().getSimpleName());
      }
      i = j;
      if ((((bbti)localObject3).a instanceof bbtl)) {
        if (localObject1 != null)
        {
          i = j;
          if (!((List)localObject1).isEmpty()) {}
        }
        else
        {
          if (localArrayList1.isEmpty()) {
            break;
          }
          localObject4 = new bbml(null, this.jdField_a_of_type_Bbtx.jdField_a_of_type_JavaLangString);
          localArrayList1.add(new bbmf((bbmx)localObject4));
          localArrayList1.add(localObject4);
          bbuo.a(40);
          i = j;
        }
      }
      j = i;
      if (localObject1 != null)
      {
        j = i;
        if (!((List)localObject1).isEmpty())
        {
          j = i;
          if ((((bbti)localObject3).a instanceof NetSearchEngine))
          {
            j = i;
            if (localArrayList1.isEmpty()) {
              j = 0;
            }
          }
          i = j;
          if (j != 0)
          {
            localObject4 = new bbml(null, this.jdField_a_of_type_Bbtx.jdField_a_of_type_JavaLangString);
            localArrayList1.add(new bbmf((bbmx)localObject4));
            localArrayList1.add(localObject4);
            bbuo.a(40);
            i = 0;
          }
          localArrayList1.addAll((Collection)localObject1);
          j = i;
          if (!(((bbti)localObject3).a instanceof NetSearchEngine))
          {
            bbuo.a(((bbti)localObject3).b);
            j = i;
          }
        }
      }
      if (((((bbti)localObject3).a instanceof bbsj)) && (((bbsj)((bbti)GroupSearchEngine.a(this.this$0).get(k)).a).a() != 64))
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        if ((this.jdField_a_of_type_Bbtk != null) && (!localArrayList1.isEmpty())) {
          this.jdField_a_of_type_Bbtk.a(localArrayList1);
        }
        if (this.jdField_a_of_type_Bbtx.jdField_a_of_type_AndroidOsBundle == null) {
          this.jdField_a_of_type_Bbtx.jdField_a_of_type_AndroidOsBundle = new Bundle();
        }
        this.jdField_a_of_type_Bbtx.jdField_a_of_type_AndroidOsBundle.putBoolean("searchCreateDiscussion", true);
        localObject3 = ((bbti)localObject3).a.a(this.jdField_a_of_type_Bbtx);
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          localObject4 = (bbmy)((List)localObject3).get(0);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label805;
          }
          localArrayList2 = new ArrayList();
          localObject3 = new bbmi(null, GroupSearchEngine.a(this.this$0), GroupSearchEngine.a(this.this$0));
          localArrayList2.add(new bbmf((bbmx)localObject3));
          localArrayList2.add(localObject3);
          localArrayList1.addAll(localArrayList2);
          localObject1 = localObject3;
          if (localArrayList2.size() > 0)
          {
            this.jdField_a_of_type_Bbtx.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
            localObject1 = localObject3;
          }
          ((bbmi)localObject1).a((bbmy)localObject4);
          if (this.jdField_a_of_type_Boolean) {
            return;
          }
          if ((this.jdField_a_of_type_Bbtk != null) && (!localArrayList1.isEmpty())) {
            this.jdField_a_of_type_Bbtk.a(localArrayList1);
          }
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      if ((this.jdField_a_of_type_Bbtk != null) && (!localArrayList1.isEmpty())) {
        this.jdField_a_of_type_Bbtk.a(localArrayList1);
      }
      k += 1;
    }
    label805:
    Object localObject2;
    label821:
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Bbtx.jdField_a_of_type_AndroidOsBundle == null) {
        this.jdField_a_of_type_Bbtx.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      boolean bool = this.jdField_a_of_type_Bbtx.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember");
      localObject2 = new CountDownLatch(1);
      if (bool)
      {
        this.jdField_a_of_type_Bbtx.jdField_a_of_type_AndroidOsBundle.putBoolean("searchCreateDiscussion", false);
        if (GroupSearchEngine.a(this.this$0) == null) {
          GroupSearchEngine.a(this.this$0, (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1));
        }
        GroupSearchEngine.a(this.this$0, new GroupSearchEngine.TroopMemberSearchRunnable(this.jdField_a_of_type_Bbtx, (ArrayList)((ArrayList)localArrayList1).clone(), this.jdField_a_of_type_Bbtk, GroupSearchEngine.a(this.this$0), (CountDownLatch)localObject2, this.this$0));
        GroupSearchEngine.a(this.this$0, GroupSearchEngine.a(this.this$0).schedule(GroupSearchEngine.a(this.this$0), 0L, TimeUnit.MILLISECONDS));
      }
      if (this.jdField_a_of_type_Bbtk != null)
      {
        if (!bool) {
          break label1088;
        }
        this.jdField_a_of_type_Bbtk.a(localArrayList1, 1);
        ((CountDownLatch)localObject2).countDown();
      }
      while (!this.jdField_a_of_type_Boolean)
      {
        long l2 = System.currentTimeMillis();
        GroupSearchEngine.a(this.this$0, l2 - l1);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("GroupSearchEngine", 4, "search process cost:" + GroupSearchEngine.a(this.this$0));
        return;
        label1088:
        if (this.jdField_a_of_type_Bbtx.jdField_a_of_type_AndroidOsBundle.getBoolean("hasLocalPeopleOrTroop", false)) {
          this.jdField_a_of_type_Bbtk.a(localArrayList1, 5);
        } else {
          this.jdField_a_of_type_Bbtk.a(localArrayList1, 4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */