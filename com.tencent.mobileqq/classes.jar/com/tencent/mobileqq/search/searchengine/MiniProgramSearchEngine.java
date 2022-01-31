package com.tencent.mobileqq.search.searchengine;

import aynu;
import aynz;
import ayug;
import ayuh;
import ayuk;
import ayuu;
import ayvm;
import ayvp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MiniProgramSearchEngine
  implements ayug<aynz>, Runnable
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
  
  public List<aynz> a(ayuu paramayuu)
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
      int[] arrayOfInt = ayvm.a(paramayuu.a, localMiniAppLocalSearchEntity.appName, false);
      if ((arrayOfInt != null) && (arrayOfInt.length >= 3) && (arrayOfInt[0] > -1))
      {
        aynz localaynz = new aynz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localMiniAppLocalSearchEntity, paramayuu.a);
        localaynz.a = arrayOfInt;
        if (localMiniAppLocalSearchEntity.appName.equals(paramayuu.a)) {
          localArrayList2.add(0, localaynz);
        } else {
          localArrayList2.add(localaynz);
        }
      }
    }
    localArrayList1.addAll(localArrayList2);
    Collections.sort(localArrayList2, new ayuk(this));
    int j = localArrayList1.size();
    while (i < j)
    {
      ayvp.a((aynu)localArrayList1.get(i), j, i);
      i += 1;
    }
    return localArrayList1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchManager = ((MiniAppLocalSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(310));
  }
  
  public void a(ayuu paramayuu, ayuh<aynz> paramayuh) {}
  
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