package com.tencent.mobileqq.search.searchengine;

import android.text.TextUtils;
import aody;
import bcfn;
import bcgv;
import bcmc;
import bcmd;
import bcmo;
import bcmp;
import bcmq;
import bkgt;
import com.tencent.mobileqq.app.QQAppInterface;
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
import ocd;
import tzq;

public class PublicAccountSearchEngine
  implements bcmc<bcgv>, Runnable
{
  private static final Comparator<bcgv> jdField_a_of_type_JavaUtilComparator = new bcmo();
  private static final Comparator<bcgv> b = new bcmp();
  private int jdField_a_of_type_Int = -1;
  private aody jdField_a_of_type_Aody;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aody = ((aody)paramQQAppInterface.getManager(56));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int b(bcfn parambcfn1, bcfn parambcfn2)
  {
    int j = 0;
    int i = j;
    if (parambcfn2.a() != null)
    {
      i = j;
      if (parambcfn1.a() != null) {
        i = parambcfn1.a().toString().compareTo(parambcfn2.a().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (parambcfn2.b() != null)
      {
        j = i;
        if (parambcfn1.b() != null) {
          j = parambcfn1.b().toString().compareTo(parambcfn2.b().toString());
        }
      }
    }
    return j;
  }
  
  public List<bcgv> a(bcmq parambcmq)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_Aody.a()) {}
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = this.jdField_a_of_type_Aody.a();
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
        Object localObject4 = (bkgt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        if ((localObject4 == null) || (!((bkgt)localObject4).f(((PublicAccountInfo)localObject3).getUin())))
        {
          localObject3 = (PublicAccountInfo)localObject3;
          if ((!TextUtils.equals(((PublicAccountInfo)localObject3).getUin(), "2173223560")) && ((this.jdField_a_of_type_Int != 12) || (tzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject3).getUin()))))
          {
            localObject4 = new bcgv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject3, this.jdField_a_of_type_Int);
            ((bcgv)localObject4).b(parambcmq.a);
            if (((bcgv)localObject4).b() != -9223372036854775808L)
            {
              bcgv localbcgv = (bcgv)((HashMap)localObject2).get(((bcgv)localObject4).a());
              if ((localbcgv == null) || (localbcgv.b() < ((bcgv)localObject4).b())) {
                ((HashMap)localObject2).put(((bcgv)localObject4).a(), localObject4);
              }
            }
            if ((localObject3 != null) && (((PublicAccountInfo)localObject3).displayNumber != null) && (((PublicAccountInfo)localObject3).displayNumber.equalsIgnoreCase(((bcgv)localObject4).a()))) {
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
    parambcmq = new ArrayList();
    parambcmq.addAll((Collection)localObject2);
    parambcmq.addAll(localArrayList.subList(i, localArrayList.size()));
    parambcmq.removeAll((Collection)localObject1);
    parambcmq.addAll(0, (Collection)localObject1);
    localObject1 = parambcmq.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bcgv)((Iterator)localObject1).next();
      i += 1;
      ((bcgv)localObject2).a(i);
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
    }
    return parambcmq;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aody == null) {}
    while (this.jdField_a_of_type_Aody.a) {
      return;
    }
    ThreadManager.post(this, 5, null, true);
  }
  
  public void a(bcmq parambcmq, bcmd<bcgv> parambcmd)
  {
    ThreadManager.postImmediately(new PublicAccountSearchEngine.1(this, parambcmq, parambcmd), null, true);
    if (!TextUtils.isEmpty(parambcmq.a)) {
      ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", parambcmq.a, "", false);
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run()
  {
    this.jdField_a_of_type_Aody.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */