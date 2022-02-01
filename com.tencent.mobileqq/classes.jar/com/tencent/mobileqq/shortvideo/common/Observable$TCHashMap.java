package com.tencent.mobileqq.shortvideo.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class Observable$TCHashMap<K, V>
{
  private HashMap<K, ArrayList<V>> b = new HashMap();
  
  public Observable$TCHashMap(Observable paramObservable) {}
  
  public void a(V paramV)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ArrayList localArrayList = (ArrayList)localEntry.getValue();
      int i = 0;
      while (i < localArrayList.size())
      {
        Object localObject = localArrayList.get(i);
        if ((localObject != paramV) && ((localObject == null) || (!localObject.equals(paramV)))) {
          i += 1;
        } else {
          ((ArrayList)localEntry.getValue()).remove(paramV);
        }
      }
    }
  }
  
  public void a(K paramK, V paramV)
  {
    ArrayList localArrayList2 = (ArrayList)this.b.get(paramK);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.b.put(paramK, localArrayList1);
    }
    if (!localArrayList1.contains(paramV)) {
      localArrayList1.add(paramV);
    }
  }
  
  public ArrayList<V> b(K paramK)
  {
    return (ArrayList)this.b.get(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.common.Observable.TCHashMap
 * JD-Core Version:    0.7.0.1
 */