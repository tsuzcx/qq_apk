package com.tencent.mobileqq.search.searchengine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PublicAccountSearchEngine
  implements ISearchEngine<PublicAccountSearchResultModel>, Runnable
{
  private static final Comparator<PublicAccountSearchResultModel> jdField_a_of_type_JavaUtilComparator = new PublicAccountSearchEngine.2();
  private static final Comparator<PublicAccountSearchResultModel> b = new PublicAccountSearchEngine.3();
  private int jdField_a_of_type_Int = -1;
  private PublicAccountDataManager jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int b(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int j = 0;
    int i = j;
    if (paramIContactSearchModel2.a() != null)
    {
      i = j;
      if (paramIContactSearchModel1.a() != null) {
        i = paramIContactSearchModel1.a().toString().compareTo(paramIContactSearchModel2.a().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramIContactSearchModel2.b() != null)
      {
        j = i;
        if (paramIContactSearchModel1.b() != null) {
          j = paramIContactSearchModel1.b().toString().compareTo(paramIContactSearchModel2.b().toString());
        }
      }
    }
    return j;
  }
  
  public List<PublicAccountSearchResultModel> a(SearchRequest paramSearchRequest)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a()) {}
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a();
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
        Object localObject4 = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        if ((localObject4 == null) || (!((QidianManager)localObject4).f(((PublicAccountInfo)localObject3).getUin())))
        {
          localObject3 = (PublicAccountInfo)localObject3;
          if ((!TextUtils.equals(((PublicAccountInfo)localObject3).getUin(), "2173223560")) && ((this.jdField_a_of_type_Int != 12) || (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject3).getUin()))))
          {
            localObject4 = new PublicAccountSearchResultModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject3, this.jdField_a_of_type_Int);
            ((PublicAccountSearchResultModel)localObject4).b(paramSearchRequest.a);
            if (((PublicAccountSearchResultModel)localObject4).b() != -9223372036854775808L)
            {
              PublicAccountSearchResultModel localPublicAccountSearchResultModel = (PublicAccountSearchResultModel)((HashMap)localObject2).get(((PublicAccountSearchResultModel)localObject4).a());
              if ((localPublicAccountSearchResultModel == null) || (localPublicAccountSearchResultModel.b() < ((PublicAccountSearchResultModel)localObject4).b())) {
                ((HashMap)localObject2).put(((PublicAccountSearchResultModel)localObject4).a(), localObject4);
              }
            }
            if ((localObject3 != null) && (((PublicAccountInfo)localObject3).displayNumber != null) && (((PublicAccountInfo)localObject3).displayNumber.equalsIgnoreCase(((PublicAccountSearchResultModel)localObject4).a()))) {
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
    paramSearchRequest = new ArrayList();
    paramSearchRequest.addAll((Collection)localObject2);
    paramSearchRequest.addAll(localArrayList.subList(i, localArrayList.size()));
    paramSearchRequest.removeAll((Collection)localObject1);
    paramSearchRequest.addAll(0, (Collection)localObject1);
    localObject1 = paramSearchRequest.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PublicAccountSearchResultModel)((Iterator)localObject1).next();
      i += 1;
      ((PublicAccountSearchResultModel)localObject2).a(i);
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
    }
    return paramSearchRequest;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a) {
      return;
    }
    ThreadManager.post(this, 5, null, true);
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<PublicAccountSearchResultModel> paramISearchListener)
  {
    ThreadManager.postImmediately(new PublicAccountSearchEngine.1(this, paramSearchRequest, paramISearchListener), null, true);
    if (!TextUtils.isEmpty(paramSearchRequest.a)) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", paramSearchRequest.a, "", false);
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */