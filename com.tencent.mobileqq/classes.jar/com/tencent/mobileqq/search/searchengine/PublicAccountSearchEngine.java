package com.tencent.mobileqq.search.searchengine;

import android.text.TextUtils;
import aoan;
import bcff;
import bcgn;
import bclw;
import bclx;
import bcmi;
import bcmj;
import bcmk;
import bjxa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import olh;
import uuc;

public class PublicAccountSearchEngine
  implements bclw<bcgn>, Runnable
{
  private static final Comparator<bcgn> jdField_a_of_type_JavaUtilComparator = new bcmi();
  private static final Comparator<bcgn> b = new bcmj();
  private int jdField_a_of_type_Int = -1;
  private aoan jdField_a_of_type_Aoan;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aoan = ((aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int b(bcff parambcff1, bcff parambcff2)
  {
    int j = 0;
    int i = j;
    if (parambcff2.a() != null)
    {
      i = j;
      if (parambcff1.a() != null) {
        i = parambcff1.a().toString().compareTo(parambcff2.a().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (parambcff2.b() != null)
      {
        j = i;
        if (parambcff1.b() != null) {
          j = parambcff1.b().toString().compareTo(parambcff2.b().toString());
        }
      }
    }
    return j;
  }
  
  public List<bcgn> a(bcmk parambcmk)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_Aoan.a()) {}
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = this.jdField_a_of_type_Aoan.a();
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
      Object localObject3 = (Entity)localArrayList.get(i);
      if ((localObject3 == null) || (!(localObject3 instanceof PublicAccountInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject4 = (bjxa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        if ((localObject4 == null) || (!((bjxa)localObject4).f(((PublicAccountInfo)localObject3).getUin())))
        {
          localObject3 = (PublicAccountInfo)localObject3;
          if ((!TextUtils.equals(((PublicAccountInfo)localObject3).getUin(), "2173223560")) && ((this.jdField_a_of_type_Int != 12) || (uuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject3).getUin()))))
          {
            localObject4 = new bcgn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject3, this.jdField_a_of_type_Int);
            ((bcgn)localObject4).b(parambcmk.a);
            if (((bcgn)localObject4).b() != -9223372036854775808L)
            {
              bcgn localbcgn = (bcgn)((HashMap)localObject2).get(((bcgn)localObject4).a());
              if ((localbcgn == null) || (localbcgn.b() < ((bcgn)localObject4).b())) {
                ((HashMap)localObject2).put(((bcgn)localObject4).a(), localObject4);
              }
            }
            if ((localObject3 != null) && (((PublicAccountInfo)localObject3).displayNumber != null) && (((PublicAccountInfo)localObject3).displayNumber.equalsIgnoreCase(((bcgn)localObject4).a()))) {
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
    parambcmk = new ArrayList();
    parambcmk.addAll((Collection)localObject2);
    parambcmk.addAll(localArrayList.subList(i, localArrayList.size()));
    parambcmk.removeAll((Collection)localObject1);
    parambcmk.addAll(0, (Collection)localObject1);
    localObject1 = parambcmk.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bcgn)((Iterator)localObject1).next();
      i += 1;
      ((bcgn)localObject2).a(i);
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
    }
    return parambcmk;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aoan == null) {}
    while (this.jdField_a_of_type_Aoan.a) {
      return;
    }
    ThreadManager.post(this, 5, null, true);
  }
  
  public void a(bcmk parambcmk, bclx<bcgn> parambclx)
  {
    ThreadManager.postImmediately(new PublicAccountSearchEngine.1(this, parambcmk, parambclx), null, true);
    if (!TextUtils.isEmpty(parambcmk.a)) {
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", parambcmk.a, "", false);
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run()
  {
    this.jdField_a_of_type_Aoan.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */