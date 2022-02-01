package com.tencent.mobileqq.search.searchengine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
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
  private IPublicAccountDataManager jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager = ((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all"));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int b(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i;
    if ((paramIContactSearchModel2.b() != null) && (paramIContactSearchModel1.b() != null)) {
      i = paramIContactSearchModel1.b().toString().compareTo(paramIContactSearchModel2.b().toString());
    } else {
      i = 0;
    }
    int j = i;
    if (i == 0)
    {
      j = i;
      if (paramIContactSearchModel2.c() != null)
      {
        j = i;
        if (paramIContactSearchModel1.c() != null) {
          j = paramIContactSearchModel1.c().toString().compareTo(paramIContactSearchModel2.c().toString());
        }
      }
    }
    return j;
  }
  
  public List<PublicAccountSearchResultModel> a(SearchRequest paramSearchRequest)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager.isBuildingList()) {}
    long l2 = System.currentTimeMillis();
    Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager.getPublicAccountList();
    if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = new HashMap();
      int k = ((List)localObject3).size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        Object localObject4 = (Entity)((List)localObject3).get(i);
        if ((localObject4 != null) && ((localObject4 instanceof PublicAccountInfo)))
        {
          Object localObject5 = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
          if ((localObject5 == null) || (!((QidianManager)localObject5).f(((PublicAccountInfo)localObject4).getUin())))
          {
            localObject4 = (PublicAccountInfo)localObject4;
            if ((!TextUtils.equals(((PublicAccountInfo)localObject4).getUin(), "2173223560")) && ((this.jdField_a_of_type_Int != 12) || (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject4).getUin()))))
            {
              localObject5 = new PublicAccountSearchResultModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject4, this.jdField_a_of_type_Int);
              ((PublicAccountSearchResultModel)localObject5).b(paramSearchRequest.a);
              if (((PublicAccountSearchResultModel)localObject5).b() != -9223372036854775808L)
              {
                PublicAccountSearchResultModel localPublicAccountSearchResultModel = (PublicAccountSearchResultModel)((HashMap)localObject2).get(((PublicAccountSearchResultModel)localObject5).a());
                if ((localPublicAccountSearchResultModel == null) || (localPublicAccountSearchResultModel.b() < ((PublicAccountSearchResultModel)localObject5).b())) {
                  ((HashMap)localObject2).put(((PublicAccountSearchResultModel)localObject5).a(), localObject5);
                }
              }
              if ((localObject4 != null) && (((PublicAccountInfo)localObject4).displayNumber != null) && (((PublicAccountInfo)localObject4).displayNumber.equalsIgnoreCase(((PublicAccountSearchResultModel)localObject5).b()))) {
                ((List)localObject1).add(localObject5);
              }
            }
          }
        }
        i += 1;
      }
      localObject3 = new ArrayList();
      ((List)localObject3).addAll(((HashMap)localObject2).values());
      Collections.sort((List)localObject3, jdField_a_of_type_JavaUtilComparator);
      i = Math.min(((List)localObject3).size(), 30);
      localObject2 = ((List)localObject3).subList(0, i);
      Collections.sort((List)localObject2, b);
      paramSearchRequest = new ArrayList();
      paramSearchRequest.addAll((Collection)localObject2);
      paramSearchRequest.addAll(((List)localObject3).subList(i, ((List)localObject3).size()));
      paramSearchRequest.removeAll((Collection)localObject1);
      paramSearchRequest.addAll(0, (Collection)localObject1);
      localObject1 = paramSearchRequest.iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PublicAccountSearchResultModel)((Iterator)localObject1).next();
        i += 1;
        ((PublicAccountSearchResultModel)localObject2).a(i);
      }
      long l3 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("pubacc search cost:");
        ((StringBuilder)localObject1).append(l3 - l1);
        ((StringBuilder)localObject1).append(", pure search cost:");
        ((StringBuilder)localObject1).append(l3 - l2);
        QLog.d("PublicAccountSearchEngine", 4, ((StringBuilder)localObject1).toString());
      }
      return paramSearchRequest;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountSearchEngine", 2, "all publicAccountInfoList is null or empty");
    }
    return null;
  }
  
  public void a()
  {
    IPublicAccountDataManager localIPublicAccountDataManager = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager;
    if (localIPublicAccountDataManager == null) {
      return;
    }
    if (!localIPublicAccountDataManager.isCached()) {
      ThreadManager.post(this, 5, null, true);
    }
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
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager.initPublicAccountDataManager();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */