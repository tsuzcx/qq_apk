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
  protected List<Long> a;
  protected BizTroopObserver b = new TroopFileSearchEngine.4(this);
  private int c = 0;
  private QQAppInterface d;
  private Context e;
  private long f;
  private List<IContactSearchable> g;
  private SearchTask h;
  private boolean i = false;
  private volatile boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private long m = 0L;
  private String n = "";
  private String o = "";
  private List<TroopFileSearchItemData> p;
  private volatile boolean q = true;
  private ISearchViewBinder r;
  private ISearchListener<TroopFileSearchResultModel> s;
  private int t = 1;
  
  public TroopFileSearchEngine(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt, ISearchViewBinder paramISearchViewBinder)
  {
    this.d = paramQQAppInterface;
    this.e = paramContext;
    this.c = paramInt;
    this.f = paramLong;
    this.r = paramISearchViewBinder;
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, List<Long> paramList, String paramString1, String paramString2)
  {
    try
    {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch.");
      boolean bool = this.q;
      if (!bool) {
        return;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.d("TroopFileSearchEngine<QFile>", 1, "doReqTroopFileSearch err marchWord is null--------------");
      }
      else
      {
        this.m = System.currentTimeMillis();
        this.q = false;
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
  
  private void c(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("execSearch. keyWord[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("TroopFileSearchEngine<QFile>", 4, localStringBuilder.toString());
      boolean bool = this.k;
      if (bool) {
        return;
      }
      if (this.g == null)
      {
        this.j = true;
        QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. friend set is null. wait");
        return;
      }
      if (this.h != null)
      {
        this.h.cancel(true);
        this.h = null;
      }
      QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. success.");
      this.h = new SearchTask(paramString, paramString, this.g, this);
      this.h.a();
      return;
    }
    finally {}
  }
  
  private void f()
  {
    this.j = false;
    this.k = false;
    this.l = false;
    this.n = "";
    this.o = "";
    this.q = true;
    List localList = this.p;
    if (localList != null)
    {
      localList.clear();
      this.p = null;
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
    this.t = paramInt;
  }
  
  public void a(int paramInt, List<? extends ISearchable> paramList)
  {
    QLog.i("TroopFileSearchEngine<QFile>", 4, "onSearchFinish. search contact with keyWord finish.");
    ThreadManagerV2.getUIHandlerV2().post(new TroopFileSearchEngine.5(this, paramInt, paramList));
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<TroopFileSearchResultModel> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.a != null))
    {
      if (TextUtils.isEmpty(paramSearchRequest.a.trim())) {
        return;
      }
      if (this.s == null) {
        this.s = paramISearchListener;
      }
      ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileSearchEngine.1(this), 800L);
    }
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.o)))
    {
      if (!this.q)
      {
        QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish.");
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMoreSearchData. but last search is not finish. keyWord[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] lastKeyWord[");
      localStringBuilder.append(this.o);
      localStringBuilder.append("]");
      QLog.i("TroopFileSearchEngine<QFile>", 1, localStringBuilder.toString());
      a(this.d, this.f, this.a, this.o, this.n);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadMoreSearchData. keyword is not match keyWord[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] lastKeyWord[");
    localStringBuilder.append(this.o);
    localStringBuilder.append("]");
    QLog.i("TroopFileSearchEngine<QFile>", 1, localStringBuilder.toString());
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "cancel.");
    }
    f();
  }
  
  public boolean b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.o))) {
      return this.l;
    }
    return true;
  }
  
  public void c()
  {
    BizTroopObserver localBizTroopObserver = this.b;
    if (localBizTroopObserver != null) {
      this.d.removeObserver(localBizTroopObserver);
    }
  }
  
  public void d()
  {
    BizTroopObserver localBizTroopObserver = this.b;
    if (localBizTroopObserver != null) {
      this.d.addObserver(localBizTroopObserver);
    }
  }
  
  public void e()
  {
    Object localObject = this.b;
    if (localObject != null) {
      this.d.removeObserver((BusinessObserver)localObject);
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.g = null;
    }
    localObject = this.h;
    if (localObject != null) {
      ((SearchTask)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine
 * JD-Core Version:    0.7.0.1
 */