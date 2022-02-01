package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.adapter.SubBusinessSearchAdapter;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class PublicAcntSearchFragment
  extends BaseSearchFragment
  implements AbsListView.OnScrollListener
{
  private static int g = -1;
  public boolean a = false;
  protected boolean b;
  public byte[] c = null;
  protected String d = "";
  protected UniteSearchObserver e = new PublicAcntSearchFragment.2(this);
  protected int f;
  private long h = -1L;
  
  public static PublicAcntSearchFragment a(int paramInt)
  {
    g = paramInt;
    return new PublicAcntSearchFragment();
  }
  
  public void a(List paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    if ((SearchUtils.b(g)) && (!this.j))
    {
      this.j = true;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.q);
      localObject = ((StringBuilder)localObject).toString();
      if (paramList == null)
      {
        paramList = "0";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramList.size());
        paramList = localStringBuilder.toString();
      }
      SearchUtils.a("all_result", "exp_public_uin_page", new String[] { localObject, paramList });
    }
    if ((this.r != null) && (!this.r.isEmpty()))
    {
      paramInt = 0;
      while (paramInt < this.r.size())
      {
        SearchViewUtils.a((ISearchResultModel)this.r.get(paramInt), this.r.size(), paramInt);
        paramInt += 1;
      }
      this.r.add(0, new GroupSearchModeTitle(HardCodeUtil.a(2131906512), "", ""));
    }
    this.c = null;
    if (!TextUtils.isEmpty(this.q))
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onFinish, search net result ,keyword = ");
        paramList.append(this.q);
        QLog.i("PublicAcntSearchFragment", 2, paramList.toString());
      }
      e(this.r);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "keyword is empty ");
    }
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.q))
    {
      a(paramList, paramSearchRespData.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAcntSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.a, " keyword2:", this.q });
    }
  }
  
  protected BaseMvpAdapter b()
  {
    return new SubBusinessSearchAdapter(this.l, this.n, this, 0);
  }
  
  protected ISearchEngine c()
  {
    return new PublicAccountSearchEngine((QQAppInterface)this.p, g);
  }
  
  protected boolean cj_()
  {
    return false;
  }
  
  protected String d()
  {
    if (g == 12) {
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.p, BaseApplicationImpl.getContext());
    }
    return HardCodeUtil.a(2131906557);
  }
  
  protected void d(List paramList)
  {
    super.d(paramList);
    this.z.setVisibility(0);
    this.y.setVisibility(8);
    h_(false);
    o_(false);
  }
  
  protected String e()
  {
    return HardCodeUtil.a(2131899287);
  }
  
  protected void e(List paramList)
  {
    this.a = true;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendNetPublicAcntRequest ,keyword=");
      ((StringBuilder)localObject1).append(this.q);
      QLog.i("PublicAcntSearchFragment", 2, ((StringBuilder)localObject1).toString());
    }
    ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.1(this));
    Object localObject2 = ((IPublicAccountDataManager)this.p.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountList();
    Object localObject1 = new ArrayList();
    int i;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        i = 0;
      }
    }
    else {
      while (i < paramList.size())
      {
        localObject3 = (IModel)paramList.get(i);
        if ((localObject3 instanceof PublicAccountSearchResultModel))
        {
          localObject3 = (PublicAccountSearchResultModel)localObject3;
          int j = 0;
          while (j < ((List)localObject2).size())
          {
            PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((List)localObject2).get(j);
            if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(((PublicAccountSearchResultModel)localObject3).a.uin))) {
              ((List)localObject1).add(Long.valueOf(localPublicAccountInfo.uin));
            }
            j += 1;
          }
        }
        i += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAcntSearchFragment", 2, "all publicAccountInfoList is null or empty");
        }
      }
    }
    paramList = (UniteSearchHandler)this.p.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("isLoadMore", true);
    ((Bundle)localObject2).putInt("fromType", g);
    Object localObject3 = new ArrayList();
    ((List)localObject3).add(Long.valueOf(1003L));
    paramList.a(this.q, this.d, 20, (List)localObject3, (List)localObject1, this.c, 0.0D, 0.0D, (Bundle)localObject2);
  }
  
  protected boolean j()
  {
    return false;
  }
  
  protected int l()
  {
    return 50;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.p.addObserver(this.e);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    this.d = localStringBuilder.toString();
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.o instanceof PublicAccountSearchEngine)) {
      ((PublicAccountSearchEngine)this.o).e();
    }
    this.c = null;
    this.p.removeObserver(this.e);
  }
  
  public void onPause()
  {
    super.onPause();
    this.o.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.o.d();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.m != null) && (this.m.getCount() != 0))
    {
      if (this.f == 0) {
        return;
      }
      if ((paramInt3 - paramInt1 - paramInt2 < 10) && (!this.a) && (!this.b)) {
        e(this.r);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment
 * JD-Core Version:    0.7.0.1
 */