package com.tencent.mobileqq.filemanager.data.search.troop;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopFileHandler;
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
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
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
  private ISearchListener<TroopFileSearchResultModel> jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
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
      }
      else
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
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
        ((TroopFileHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).a("GroupFileAppSvr.GetFileSearch", paramList.toByteArray(), (Bundle)localObject);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("doReqTroopFileSearch troopUin = ");
          paramQQAppInterface.append(paramLong);
          paramQQAppInterface.append(", marchWord = ");
          paramQQAppInterface.append(paramString1);
          paramQQAppInterface.append(", cookie = ");
          paramQQAppInterface.append(paramString2);
          QLog.d("TroopFileSearchEngine<QFile>", 4, paramQQAppInterface.toString());
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean, List<TroopFileSearchItemData> paramList)
  {
    ThreadManagerV2.getUIHandlerV2().post(new TroopFileSearchEngine.3(this, paramBoolean, paramList));
  }
  
  private void b(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("execSearch. keyWord[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("TroopFileSearchEngine<QFile>", 4, localStringBuilder.toString());
      boolean bool = this.jdField_c_of_type_Boolean;
      if (bool) {
        return;
      }
      if (this.jdField_b_of_type_JavaUtilList == null)
      {
        this.jdField_b_of_type_Boolean = true;
        QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. friend set is null. wait");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.cancel(true);
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = null;
      }
      QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. success.");
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask = new SearchTask(paramString, paramString, this.jdField_b_of_type_JavaUtilList, this);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.a();
      return;
    }
    finally {}
  }
  
  private void f()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.e = true;
    List localList = this.jdField_c_of_type_JavaUtilList;
    if (localList != null)
    {
      localList.clear();
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
    if ((paramSearchRequest != null) && (paramSearchRequest.jdField_a_of_type_JavaLangString != null))
    {
      if (TextUtils.isEmpty(paramSearchRequest.jdField_a_of_type_JavaLangString.trim())) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = paramISearchListener;
      }
      ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileSearchEngine.1(this), 800L);
    }
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_b_of_type_JavaLangString)))
    {
      if (!this.e)
      {
        QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish.");
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMoreSearchData. but last search is not finish. keyWord[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] lastKeyWord[");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("]");
      QLog.i("TroopFileSearchEngine<QFile>", 1, localStringBuilder.toString());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadMoreSearchData. keyword is not match keyWord[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] lastKeyWord[");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("]");
    QLog.i("TroopFileSearchEngine<QFile>", 1, localStringBuilder.toString());
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
    BizTroopObserver localBizTroopObserver = this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
    if (localBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(localBizTroopObserver);
    }
  }
  
  public void d()
  {
    BizTroopObserver localBizTroopObserver = this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
    if (localBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(localBizTroopObserver);
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask;
    if (localObject != null) {
      ((SearchTask)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine
 * JD-Core Version:    0.7.0.1
 */