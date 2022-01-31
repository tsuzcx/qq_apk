package com.tencent.mobileqq.search.searchengine;

import akdh;
import android.text.TextUtils;
import auko;
import awoe;
import awpm;
import awuu;
import awuv;
import awvg;
import awvh;
import awvi;
import bduf;
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
import nol;
import sgg;

public class PublicAccountSearchEngine
  implements awuu<awpm>, Runnable
{
  private static final Comparator<awpm> jdField_a_of_type_JavaUtilComparator = new awvg();
  private static final Comparator<awpm> b = new awvh();
  private int jdField_a_of_type_Int = -1;
  private akdh jdField_a_of_type_Akdh;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Akdh = ((akdh)paramQQAppInterface.getManager(56));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int b(awoe paramawoe1, awoe paramawoe2)
  {
    int j = 0;
    int i = j;
    if (paramawoe2.a() != null)
    {
      i = j;
      if (paramawoe1.a() != null) {
        i = paramawoe1.a().toString().compareTo(paramawoe2.a().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramawoe2.b() != null)
      {
        j = i;
        if (paramawoe1.b() != null) {
          j = paramawoe1.b().toString().compareTo(paramawoe2.b().toString());
        }
      }
    }
    return j;
  }
  
  public List<awpm> a(awvi paramawvi)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_Akdh.a()) {}
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = this.jdField_a_of_type_Akdh.a();
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
      Object localObject3 = (auko)localArrayList.get(i);
      if ((localObject3 == null) || (!(localObject3 instanceof PublicAccountInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject4 = (bduf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        if ((localObject4 == null) || (!((bduf)localObject4).f(((PublicAccountInfo)localObject3).getUin())))
        {
          localObject3 = (PublicAccountInfo)localObject3;
          if ((!TextUtils.equals(((PublicAccountInfo)localObject3).getUin(), "2173223560")) && ((this.jdField_a_of_type_Int != 12) || (sgg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject3).getUin()))))
          {
            localObject4 = new awpm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject3, this.jdField_a_of_type_Int);
            ((awpm)localObject4).b(paramawvi.a);
            if (((awpm)localObject4).b() != -9223372036854775808L)
            {
              awpm localawpm = (awpm)((HashMap)localObject2).get(((awpm)localObject4).a());
              if ((localawpm == null) || (localawpm.b() < ((awpm)localObject4).b())) {
                ((HashMap)localObject2).put(((awpm)localObject4).a(), localObject4);
              }
            }
            if ((localObject3 != null) && (((PublicAccountInfo)localObject3).displayNumber != null) && (((PublicAccountInfo)localObject3).displayNumber.equalsIgnoreCase(((awpm)localObject4).a()))) {
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
    paramawvi = new ArrayList();
    paramawvi.addAll((Collection)localObject2);
    paramawvi.addAll(localArrayList.subList(i, localArrayList.size()));
    paramawvi.removeAll((Collection)localObject1);
    paramawvi.addAll(0, (Collection)localObject1);
    localObject1 = paramawvi.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (awpm)((Iterator)localObject1).next();
      i += 1;
      ((awpm)localObject2).a(i);
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
    }
    return paramawvi;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akdh == null) {}
    while (this.jdField_a_of_type_Akdh.a) {
      return;
    }
    ThreadManager.post(this, 5, null, true);
  }
  
  public void a(awvi paramawvi, awuv<awpm> paramawuv)
  {
    ThreadManager.postImmediately(new PublicAccountSearchEngine.1(this, paramawvi, paramawuv), null, true);
    if (!TextUtils.isEmpty(paramawvi.a)) {
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", paramawvi.a, "", false);
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run()
  {
    this.jdField_a_of_type_Akdh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */