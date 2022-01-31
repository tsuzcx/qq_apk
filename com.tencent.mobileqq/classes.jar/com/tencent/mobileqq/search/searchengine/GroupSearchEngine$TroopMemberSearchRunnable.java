package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import aymg;
import aynb;
import ayne;
import ayng;
import aynq;
import ayns;
import aynt;
import aynu;
import aytg;
import ayuf;
import ayuh;
import ayuu;
import ayvm;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class GroupSearchEngine$TroopMemberSearchRunnable
  implements Runnable
{
  private ayuh jdField_a_of_type_Ayuh;
  private ayuu jdField_a_of_type_Ayuu;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<GroupSearchEngine> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<ayns> jdField_a_of_type_JavaUtilArrayList;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  private boolean jdField_a_of_type_Boolean;
  
  public GroupSearchEngine$TroopMemberSearchRunnable(ayuu paramayuu, ArrayList<ayns> paramArrayList, ayuh paramayuh, String paramString, CountDownLatch paramCountDownLatch, GroupSearchEngine paramGroupSearchEngine)
  {
    this.jdField_a_of_type_Ayuu = paramayuu;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Ayuh = paramayuh;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = paramCountDownLatch;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGroupSearchEngine);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(ArrayList<ayns> paramArrayList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      do
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      } while (this.jdField_a_of_type_Ayuh == null);
      if (this.jdField_a_of_type_Ayuu.a.getBoolean("hasLocalPeopleOrTroop", false))
      {
        this.jdField_a_of_type_Ayuh.a(paramArrayList, 5);
        return;
      }
      this.jdField_a_of_type_Ayuh.a(paramArrayList, 4);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ayuh = null;
    while (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.getCount() > 0L) {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    }
  }
  
  public void run()
  {
    int n = -1;
    int m = 0;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, begin local search at :" + l);
    }
    Object localObject1 = (GroupSearchEngine)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str;
    if (localObject1 != null)
    {
      str = GroupSearchEngine.a((GroupSearchEngine)localObject1);
      if (localObject1 == null) {
        break label107;
      }
    }
    label107:
    for (int j = GroupSearchEngine.a((GroupSearchEngine)localObject1);; j = 0)
    {
      if ((localObject1 != null) && (this.jdField_a_of_type_JavaLangString.equals(str))) {
        break label112;
      }
      a();
      return;
      str = "";
      break;
    }
    label112:
    Object localObject3 = GroupSearchEngine.a((GroupSearchEngine)localObject1);
    int i = 0;
    localObject1 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (i < ((ArrayList)localObject3).size())
      {
        if ((((ayuf)((ArrayList)localObject3).get(i)).a instanceof aytg))
        {
          localObject2 = (aytg)((ayuf)((ArrayList)localObject3).get(i)).a;
          localObject1 = localObject2;
          if (((aytg)localObject2).a() == 64) {}
        }
      }
      else
      {
        if ((!this.jdField_a_of_type_Boolean) && (localObject2 != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
          break;
        }
        a();
        return;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, start search");
    }
    localObject3 = ((aytg)localObject2).a(this.jdField_a_of_type_Ayuu);
    if ((this.jdField_a_of_type_Boolean) || (localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      a();
      return;
    }
    localObject1 = new ArrayList();
    ((List)localObject1).addAll((Collection)localObject3);
    Object localObject4;
    int i1;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = -1;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ayns)((Iterator)localObject3).next();
        k = i + 1;
        i = k;
        if ((localObject4 instanceof ayne))
        {
          localObject3 = ((ayne)localObject4).a.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((List)localObject1).add((aynq)((Iterator)localObject3).next());
          }
          i1 = 1;
          i = k;
        }
      }
    }
    for (int k = i1;; k = 0)
    {
      if (k != 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i - 1);
        this.jdField_a_of_type_JavaUtilArrayList.remove(i - 1);
      }
      if (SearchConfigManager.needSeparate)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        i = n;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ayns)((Iterator)localObject3).next();
          k = i + 1;
          i = k;
          if ((localObject4 instanceof ayng))
          {
            localObject3 = ((ayng)localObject4).a.iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((List)localObject1).add((aynq)((Iterator)localObject3).next());
            }
            n = 1;
            i = k;
          }
        }
      }
      for (k = n;; k = 0)
      {
        if (k != 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i - 1);
          this.jdField_a_of_type_JavaUtilArrayList.remove(i - 1);
        }
        localObject3 = new ArrayList();
        ((aytg)localObject2).a((List)localObject1, (List)localObject3, null, str);
        if ((this.jdField_a_of_type_Boolean) || (((List)localObject3).isEmpty()))
        {
          a();
          return;
        }
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject3).iterator();
        i = m;
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (aynq)((Iterator)localObject1).next();
          if ((localObject3 instanceof aymg))
          {
            k = i + 1;
            i = k;
            if (k <= 200)
            {
              ((List)localObject2).add(localObject3);
              i = k;
            }
          }
          else
          {
            ((List)localObject2).add(localObject3);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable troopCount:" + i);
        }
        localObject3 = new ArrayList(((List)localObject2).size());
        localObject1 = new ArrayList(((List)localObject2).size());
        if (SearchConfigManager.needSeparate)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (aynq)((Iterator)localObject2).next();
            if (ayvm.a((aynu)localObject4)) {
              ((List)localObject1).add(localObject4);
            } else {
              ((List)localObject3).add(localObject4);
            }
          }
        }
        ((List)localObject3).addAll((Collection)localObject2);
        localObject2 = new ArrayList();
        if (localObject3 != null)
        {
          localObject3 = new ayne((List)localObject3, str, j);
          ((ArrayList)localObject2).add(new aynb((aynt)localObject3));
          ((ArrayList)localObject2).add(localObject3);
        }
        if ((SearchConfigManager.needSeparate) && (localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = new ayng((List)localObject1, str, j);
          ((ArrayList)localObject2).add(new aynb((aynt)localObject1));
          ((ArrayList)localObject2).add(localObject1);
        }
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          ((ArrayList)localObject2).addAll(this.jdField_a_of_type_JavaUtilArrayList);
        }
        if ((this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_JavaLangString.equals(str)))
        {
          a();
          return;
        }
        if ((this.jdField_a_of_type_Ayuh != null) && (!((ArrayList)localObject2).isEmpty())) {
          a((ArrayList)localObject2);
        }
        localObject1 = (GroupSearchEngine)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject1 == null) {
          break;
        }
        GroupSearchEngine.a((GroupSearchEngine)localObject1, System.currentTimeMillis() - l);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, end search, cost: " + GroupSearchEngine.a((GroupSearchEngine)localObject1));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.TroopMemberSearchRunnable
 * JD-Core Version:    0.7.0.1
 */