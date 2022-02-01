package com.tencent.mobileqq.filemanager.data.search.troop;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.search.ISearchViewBinder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.search.SearchTask;
import com.tencent.mobileqq.search.SearchTask.SearchTaskCallBack;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ReqBody;

public class TroopFileSearchEngine
  implements SearchTask.SearchTaskCallBack, ISearchEngine<TroopFileSearchResultModel>
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  protected BizTroopObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ISearchViewBinder jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchISearchViewBinder;
  private SearchTask jdField_a_of_type_ComTencentMobileqqSearchSearchTask;
  private ISearchListener<TroopFileSearchResultModel> jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private String jdField_a_of_type_JavaLangString = "";
  protected List<Long> a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "";
  private List<IContactSearchable> jdField_b_of_type_JavaUtilList;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private List<TroopFileSearchItemData> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private volatile boolean e = true;
  
  public TroopFileSearchEngine(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt, ISearchViewBinder paramISearchViewBinder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopFileSearchEngine.4(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchISearchViewBinder = paramISearchViewBinder;
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, List<Long> paramList, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        QLog.i("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch.");
        boolean bool = this.e;
        if (!bool) {
          return;
        }
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.d("TroopFileSearchEngine<QFile>", 1, "doReqTroopFileSearch err marchWord is null--------------");
          continue;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      finally {}
      this.e = false;
      Object localObject = new cmd0x383.ApplyFileSearchReqBody();
      ((cmd0x383.ApplyFileSearchReqBody)localObject).bytes_key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
      if (paramList != null) {
        ((cmd0x383.ApplyFileSearchReqBody)localObject).uint64_uin_list.set(paramList);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        ((cmd0x383.ApplyFileSearchReqBody)localObject).bytes_sync_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      ((cmd0x383.ApplyFileSearchReqBody)localObject).uint32_count.set(20);
      paramList = new cmd0x383.ReqBody();
      paramList.uint64_groupcode.set(paramLong);
      paramList.uint32_app_id.set(3);
      paramList.msg_file_search_req_body.set((MessageMicro)localObject);
      paramList.setHasFlag(true);
      localObject = new Bundle();
      ((Bundle)localObject).putLong("troopUin", paramLong);
      ((Bundle)localObject).putString("reqKeyword", paramString1);
      ((BizTroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).a("GroupFileAppSvr.GetFileSearch", paramList.toByteArray(), (Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch troopUin = " + paramLong + ", marchWord = " + paramString1 + ", cookie = " + paramString2);
      }
    }
  }
  
  private void a(boolean paramBoolean, List<TroopFileSearchItemData> paramList)
  {
    ThreadManagerV2.getUIHandlerV2().post(new TroopFileSearchEngine.3(this, paramBoolean, paramList));
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      try
      {
        QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. keyWord[" + paramString + "]");
        boolean bool = this.jdField_c_of_type_Boolean;
        if (bool) {
          return;
        }
        if (this.jdField_b_of_type_JavaUtilList == null)
        {
          this.jdField_b_of_type_Boolean = true;
          QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. friend set is null. wait");
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask == null) {
          break label96;
        }
      }
      finally {}
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.cancel(true);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = null;
      label96:
      QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. success.");
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = new SearchTask(paramString, paramString, this.jdField_b_of_type_JavaUtilList, this);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.a();
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.e = true;
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList = null;
    }
  }
  
  private void g()
  {
    ThreadManagerV2.executeOnSubThread(new TroopFileSearchEngine.2(this));
  }
  
  public List<TroopFileSearchResultModel> a(SearchRequest paramSearchRequest)
  {
    return null;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "init. get contact info.");
    }
    g();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, List<? extends ISearchable> paramList)
  {
    QLog.i("TroopFileSearchEngine<QFile>", 4, "onSearchFinish. search contact with keyWord finish.");
    ThreadManagerV2.getUIHandlerV2().post(new TroopFileSearchEngine.5(this, paramInt, paramList));
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<TroopFileSearchResultModel> paramISearchListener)
  {
    if ((paramSearchRequest == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramSearchRequest.jdField_a_of_type_JavaLangString.trim()))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileSearchEngine.1(this), 800L);
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.jdField_b_of_type_JavaLangString)))
    {
      QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. keyword is not match keyWord[" + paramString + "] lastKeyWord[" + this.jdField_b_of_type_JavaLangString + "]");
      return;
    }
    if (!this.e)
    {
      QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish.");
      return;
    }
    QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish. keyWord[" + paramString + "] lastKeyWord[" + this.jdField_b_of_type_JavaLangString + "]");
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_b_of_type_JavaLangString))) {
      return this.d;
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "cancel.");
    }
    f();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine
 * JD-Core Version:    0.7.0.1
 */