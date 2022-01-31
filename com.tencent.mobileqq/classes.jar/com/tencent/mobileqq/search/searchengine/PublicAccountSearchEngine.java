package com.tencent.mobileqq.search.searchengine;

import aluw;
import android.text.TextUtils;
import awbv;
import ayjh;
import aykp;
import aypx;
import aypy;
import ayqj;
import ayqk;
import ayql;
import bfua;
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
import nrt;
import syb;

public class PublicAccountSearchEngine
  implements aypx<aykp>, Runnable
{
  private static final Comparator<aykp> jdField_a_of_type_JavaUtilComparator = new ayqj();
  private static final Comparator<aykp> b = new ayqk();
  private int jdField_a_of_type_Int = -1;
  private aluw jdField_a_of_type_Aluw;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aluw = ((aluw)paramQQAppInterface.getManager(56));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int b(ayjh paramayjh1, ayjh paramayjh2)
  {
    int j = 0;
    int i = j;
    if (paramayjh2.a() != null)
    {
      i = j;
      if (paramayjh1.a() != null) {
        i = paramayjh1.a().toString().compareTo(paramayjh2.a().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramayjh2.b() != null)
      {
        j = i;
        if (paramayjh1.b() != null) {
          j = paramayjh1.b().toString().compareTo(paramayjh2.b().toString());
        }
      }
    }
    return j;
  }
  
  public List<aykp> a(ayql paramayql)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_Aluw.a()) {}
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = this.jdField_a_of_type_Aluw.a();
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
      Object localObject3 = (awbv)localArrayList.get(i);
      if ((localObject3 == null) || (!(localObject3 instanceof PublicAccountInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject4 = (bfua)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        if ((localObject4 == null) || (!((bfua)localObject4).f(((PublicAccountInfo)localObject3).getUin())))
        {
          localObject3 = (PublicAccountInfo)localObject3;
          if ((!TextUtils.equals(((PublicAccountInfo)localObject3).getUin(), "2173223560")) && ((this.jdField_a_of_type_Int != 12) || (syb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject3).getUin()))))
          {
            localObject4 = new aykp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject3, this.jdField_a_of_type_Int);
            ((aykp)localObject4).b(paramayql.a);
            if (((aykp)localObject4).b() != -9223372036854775808L)
            {
              aykp localaykp = (aykp)((HashMap)localObject2).get(((aykp)localObject4).a());
              if ((localaykp == null) || (localaykp.b() < ((aykp)localObject4).b())) {
                ((HashMap)localObject2).put(((aykp)localObject4).a(), localObject4);
              }
            }
            if ((localObject3 != null) && (((PublicAccountInfo)localObject3).displayNumber != null) && (((PublicAccountInfo)localObject3).displayNumber.equalsIgnoreCase(((aykp)localObject4).a()))) {
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
    paramayql = new ArrayList();
    paramayql.addAll((Collection)localObject2);
    paramayql.addAll(localArrayList.subList(i, localArrayList.size()));
    paramayql.removeAll((Collection)localObject1);
    paramayql.addAll(0, (Collection)localObject1);
    localObject1 = paramayql.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aykp)((Iterator)localObject1).next();
      i += 1;
      ((aykp)localObject2).a(i);
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
    }
    return paramayql;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aluw == null) {}
    while (this.jdField_a_of_type_Aluw.a) {
      return;
    }
    ThreadManager.post(this, 5, null, true);
  }
  
  public void a(ayql paramayql, aypy<aykp> paramaypy)
  {
    ThreadManager.postImmediately(new PublicAccountSearchEngine.1(this, paramayql, paramaypy), null, true);
    if (!TextUtils.isEmpty(paramayql.a)) {
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", paramayql.a, "", false);
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run()
  {
    this.jdField_a_of_type_Aluw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */