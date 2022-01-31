package com.tencent.mobileqq.search.searchengine;

import alzl;
import android.text.TextUtils;
import awge;
import aynq;
import ayoy;
import ayug;
import ayuh;
import ayus;
import ayut;
import ayuu;
import bfyh;
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
  implements ayug<ayoy>, Runnable
{
  private static final Comparator<ayoy> jdField_a_of_type_JavaUtilComparator = new ayus();
  private static final Comparator<ayoy> b = new ayut();
  private int jdField_a_of_type_Int = -1;
  private alzl jdField_a_of_type_Alzl;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Alzl = ((alzl)paramQQAppInterface.getManager(56));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int b(aynq paramaynq1, aynq paramaynq2)
  {
    int j = 0;
    int i = j;
    if (paramaynq2.a() != null)
    {
      i = j;
      if (paramaynq1.a() != null) {
        i = paramaynq1.a().toString().compareTo(paramaynq2.a().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramaynq2.b() != null)
      {
        j = i;
        if (paramaynq1.b() != null) {
          j = paramaynq1.b().toString().compareTo(paramaynq2.b().toString());
        }
      }
    }
    return j;
  }
  
  public List<ayoy> a(ayuu paramayuu)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_Alzl.a()) {}
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = this.jdField_a_of_type_Alzl.a();
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
      Object localObject3 = (awge)localArrayList.get(i);
      if ((localObject3 == null) || (!(localObject3 instanceof PublicAccountInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject4 = (bfyh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        if ((localObject4 == null) || (!((bfyh)localObject4).f(((PublicAccountInfo)localObject3).getUin())))
        {
          localObject3 = (PublicAccountInfo)localObject3;
          if ((!TextUtils.equals(((PublicAccountInfo)localObject3).getUin(), "2173223560")) && ((this.jdField_a_of_type_Int != 12) || (syb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject3).getUin()))))
          {
            localObject4 = new ayoy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject3, this.jdField_a_of_type_Int);
            ((ayoy)localObject4).b(paramayuu.a);
            if (((ayoy)localObject4).b() != -9223372036854775808L)
            {
              ayoy localayoy = (ayoy)((HashMap)localObject2).get(((ayoy)localObject4).a());
              if ((localayoy == null) || (localayoy.b() < ((ayoy)localObject4).b())) {
                ((HashMap)localObject2).put(((ayoy)localObject4).a(), localObject4);
              }
            }
            if ((localObject3 != null) && (((PublicAccountInfo)localObject3).displayNumber != null) && (((PublicAccountInfo)localObject3).displayNumber.equalsIgnoreCase(((ayoy)localObject4).a()))) {
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
    paramayuu = new ArrayList();
    paramayuu.addAll((Collection)localObject2);
    paramayuu.addAll(localArrayList.subList(i, localArrayList.size()));
    paramayuu.removeAll((Collection)localObject1);
    paramayuu.addAll(0, (Collection)localObject1);
    localObject1 = paramayuu.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ayoy)((Iterator)localObject1).next();
      i += 1;
      ((ayoy)localObject2).a(i);
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
    }
    return paramayuu;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alzl == null) {}
    while (this.jdField_a_of_type_Alzl.a) {
      return;
    }
    ThreadManager.post(this, 5, null, true);
  }
  
  public void a(ayuu paramayuu, ayuh<ayoy> paramayuh)
  {
    ThreadManager.postImmediately(new PublicAccountSearchEngine.1(this, paramayuu, paramayuh), null, true);
    if (!TextUtils.isEmpty(paramayuu.a)) {
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", paramayuu.a, "", false);
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run()
  {
    this.jdField_a_of_type_Alzl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */