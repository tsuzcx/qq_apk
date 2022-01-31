package com.tencent.mobileqq.search.searchengine;

import ayjl;
import ayjq;
import aypx;
import aypy;
import ayqb;
import ayql;
import ayrd;
import ayrg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MiniProgramSearchEngine
  implements aypx<ayjq>, Runnable
{
  protected int a;
  protected QQAppInterface a;
  protected MiniAppLocalSearchManager a;
  
  public MiniProgramSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List<ayjq> a(ayql paramayql)
  {
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchManager.getLocalSearchData();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList(((List)localObject).size() + 1);
    ArrayList localArrayList2 = new ArrayList(((List)localObject).size() + 1);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MiniAppLocalSearchEntity localMiniAppLocalSearchEntity = (MiniAppLocalSearchEntity)((Iterator)localObject).next();
      int[] arrayOfInt = ayrd.a(paramayql.a, localMiniAppLocalSearchEntity.appName, false);
      if ((arrayOfInt != null) && (arrayOfInt.length >= 3) && (arrayOfInt[0] > -1))
      {
        ayjq localayjq = new ayjq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localMiniAppLocalSearchEntity, paramayql.a);
        localayjq.a = arrayOfInt;
        if (localMiniAppLocalSearchEntity.appName.equals(paramayql.a)) {
          localArrayList2.add(0, localayjq);
        } else {
          localArrayList2.add(localayjq);
        }
      }
    }
    localArrayList1.addAll(localArrayList2);
    Collections.sort(localArrayList2, new ayqb(this));
    int j = localArrayList1.size();
    while (i < j)
    {
      ayrg.a((ayjl)localArrayList1.get(i), j, i);
      i += 1;
    }
    return localArrayList1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchManager = ((MiniAppLocalSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(310));
  }
  
  public void a(ayql paramayql, aypy<ayjq> paramaypy) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine
 * JD-Core Version:    0.7.0.1
 */