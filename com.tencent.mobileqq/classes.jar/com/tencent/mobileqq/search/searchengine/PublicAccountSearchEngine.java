package com.tencent.mobileqq.search.searchengine;

import android.text.TextUtils;
import anrs;
import bbmu;
import bboc;
import bbtj;
import bbtk;
import bbtv;
import bbtw;
import bbtx;
import bjft;
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
import oat;
import tzo;

public class PublicAccountSearchEngine
  implements bbtj<bboc>, Runnable
{
  private static final Comparator<bboc> jdField_a_of_type_JavaUtilComparator = new bbtv();
  private static final Comparator<bboc> b = new bbtw();
  private int jdField_a_of_type_Int = -1;
  private anrs jdField_a_of_type_Anrs;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anrs = ((anrs)paramQQAppInterface.getManager(56));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int b(bbmu parambbmu1, bbmu parambbmu2)
  {
    int j = 0;
    int i = j;
    if (parambbmu2.a() != null)
    {
      i = j;
      if (parambbmu1.a() != null) {
        i = parambbmu1.a().toString().compareTo(parambbmu2.a().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (parambbmu2.b() != null)
      {
        j = i;
        if (parambbmu1.b() != null) {
          j = parambbmu1.b().toString().compareTo(parambbmu2.b().toString());
        }
      }
    }
    return j;
  }
  
  public List<bboc> a(bbtx parambbtx)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_Anrs.a()) {}
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = this.jdField_a_of_type_Anrs.a();
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
        Object localObject4 = (bjft)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        if ((localObject4 == null) || (!((bjft)localObject4).f(((PublicAccountInfo)localObject3).getUin())))
        {
          localObject3 = (PublicAccountInfo)localObject3;
          if ((!TextUtils.equals(((PublicAccountInfo)localObject3).getUin(), "2173223560")) && ((this.jdField_a_of_type_Int != 12) || (tzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject3).getUin()))))
          {
            localObject4 = new bboc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject3, this.jdField_a_of_type_Int);
            ((bboc)localObject4).b(parambbtx.a);
            if (((bboc)localObject4).b() != -9223372036854775808L)
            {
              bboc localbboc = (bboc)((HashMap)localObject2).get(((bboc)localObject4).a());
              if ((localbboc == null) || (localbboc.b() < ((bboc)localObject4).b())) {
                ((HashMap)localObject2).put(((bboc)localObject4).a(), localObject4);
              }
            }
            if ((localObject3 != null) && (((PublicAccountInfo)localObject3).displayNumber != null) && (((PublicAccountInfo)localObject3).displayNumber.equalsIgnoreCase(((bboc)localObject4).a()))) {
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
    parambbtx = new ArrayList();
    parambbtx.addAll((Collection)localObject2);
    parambbtx.addAll(localArrayList.subList(i, localArrayList.size()));
    parambbtx.removeAll((Collection)localObject1);
    parambbtx.addAll(0, (Collection)localObject1);
    localObject1 = parambbtx.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bboc)((Iterator)localObject1).next();
      i += 1;
      ((bboc)localObject2).a(i);
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
    }
    return parambbtx;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anrs == null) {}
    while (this.jdField_a_of_type_Anrs.a) {
      return;
    }
    ThreadManager.post(this, 5, null, true);
  }
  
  public void a(bbtx parambbtx, bbtk<bboc> parambbtk)
  {
    ThreadManager.postImmediately(new PublicAccountSearchEngine.1(this, parambbtx, parambbtk), null, true);
    if (!TextUtils.isEmpty(parambbtx.a)) {
      oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", parambbtx.a, "", false);
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run()
  {
    this.jdField_a_of_type_Anrs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */