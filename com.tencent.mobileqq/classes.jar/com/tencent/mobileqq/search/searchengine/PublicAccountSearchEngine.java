package com.tencent.mobileqq.search.searchengine;

import akdi;
import android.text.TextUtils;
import aukm;
import awoc;
import awpk;
import awus;
import awut;
import awve;
import awvf;
import awvg;
import bdto;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import noo;
import sgj;

public class PublicAccountSearchEngine
  implements awus<awpk>, Runnable
{
  private static final Comparator<awpk> jdField_a_of_type_JavaUtilComparator = new awve();
  private static final Comparator<awpk> b = new awvf();
  private int jdField_a_of_type_Int = -1;
  private akdi jdField_a_of_type_Akdi;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Akdi = ((akdi)paramQQAppInterface.getManager(56));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int b(awoc paramawoc1, awoc paramawoc2)
  {
    int j = 0;
    int i = j;
    if (paramawoc2.a() != null)
    {
      i = j;
      if (paramawoc1.a() != null) {
        i = paramawoc1.a().toString().compareTo(paramawoc2.a().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramawoc2.b() != null)
      {
        j = i;
        if (paramawoc1.b() != null) {
          j = paramawoc1.b().toString().compareTo(paramawoc2.b().toString());
        }
      }
    }
    return j;
  }
  
  public List<awpk> a(awvg paramawvg)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_Akdi.a()) {}
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = this.jdField_a_of_type_Akdi.a();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountSearchEngine", 2, "all publicAccountInfoList is null or empty");
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    int j = localArrayList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject3 = (aukm)localArrayList.get(i);
      if ((localObject3 == null) || (!(localObject3 instanceof PublicAccountInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject4 = (bdto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        if ((localObject4 == null) || (!((bdto)localObject4).f(((PublicAccountInfo)localObject3).getUin())))
        {
          localObject3 = (PublicAccountInfo)localObject3;
          if ((!TextUtils.equals(((PublicAccountInfo)localObject3).getUin(), "2173223560")) && ((this.jdField_a_of_type_Int != 12) || (sgj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject3).getUin()))))
          {
            localObject4 = new awpk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject3, this.jdField_a_of_type_Int);
            ((awpk)localObject4).b(paramawvg.a);
            if (((awpk)localObject4).b() != -9223372036854775808L)
            {
              awpk localawpk = (awpk)((HashMap)localObject2).get(((awpk)localObject4).a());
              if ((localawpk == null) || (localawpk.b() < ((awpk)localObject4).b())) {
                ((HashMap)localObject2).put(((awpk)localObject4).a(), localObject4);
              }
            }
            if ((localObject3 != null) && (((PublicAccountInfo)localObject3).displayNumber != null) && (((PublicAccountInfo)localObject3).displayNumber.equalsIgnoreCase(((awpk)localObject4).a()))) {
              ((List)localObject1).add(localObject4);
            }
          }
        }
      }
    }
    localArrayList = new ArrayList();
    localArrayList.addAll(((HashMap)localObject2).values());
    Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
    i = Math.min(localArrayList.size(), 30);
    localObject2 = localArrayList.subList(0, i);
    Collections.sort((List)localObject2, b);
    paramawvg = new ArrayList();
    paramawvg.addAll((Collection)localObject2);
    paramawvg.addAll(localArrayList.subList(i, localArrayList.size()));
    paramawvg.removeAll((Collection)localObject1);
    paramawvg.addAll(0, (Collection)localObject1);
    localObject1 = paramawvg.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (awpk)((Iterator)localObject1).next();
      i += 1;
      ((awpk)localObject2).a(i);
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
    }
    return paramawvg;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akdi == null) {}
    while (this.jdField_a_of_type_Akdi.a) {
      return;
    }
    ThreadManager.post(this, 5, null, true);
  }
  
  public void a(awvg paramawvg, awut<awpk> paramawut)
  {
    ThreadManager.postImmediately(new PublicAccountSearchEngine.1(this, paramawvg, paramawut), null, true);
    if (!TextUtils.isEmpty(paramawvg.a)) {
      noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", paramawvg.a, "", false);
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run()
  {
    this.jdField_a_of_type_Akdi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */