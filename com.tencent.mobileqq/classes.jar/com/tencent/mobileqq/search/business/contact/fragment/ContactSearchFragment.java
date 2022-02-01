package com.tencent.mobileqq.search.business.contact.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.base.util.ObjectTransfer;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.business.contact.ApproximateSearchEngine;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.PhoneContactBinedSearchEngine;
import com.tencent.mobileqq.search.business.contact.PhoneContactMultiBindSearchEngine;
import com.tencent.mobileqq.search.business.contact.TroopBatchAddFrdsMultipleSearchEngine;
import com.tencent.mobileqq.search.business.contact.TroopBatchAddFrdsSearchEngine;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGuild;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ContactSearchFragment
  extends BaseSearchFragment
{
  private Set<String> G = new HashSet();
  private List<PhoneContact> H = new ArrayList();
  private ContactSearchResultPresenter.OnActionListener I = null;
  private int J = 0;
  private int a;
  private int b;
  private boolean c;
  private String d;
  private boolean e = false;
  private Set<String> f;
  private boolean g = false;
  private long h = -1L;
  private Set<String> i = new HashSet();
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List<String> paramList, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    return a(paramInt1, paramInt2, paramString, paramList, paramOnActionListener, false, 0, -1L);
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List<String> paramList, ContactSearchResultPresenter.OnActionListener paramOnActionListener, boolean paramBoolean, int paramInt3, long paramLong)
  {
    ContactSearchFragment localContactSearchFragment = new ContactSearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("contactSearchSource", paramInt2);
    localBundle.putString("specifiedTroopUin", paramString);
    localBundle.putBoolean("isApproximate", paramBoolean);
    localBundle.putInt("ContactCombineType", paramInt3);
    if (paramList != null) {
      localBundle.putStringArray("hiddenUinSet", (String[])paramList.toArray(new String[paramList.size()]));
    }
    if (paramOnActionListener != null) {
      localBundle.putLong("contactSearchOnActionListener", ObjectTransfer.a().a(paramOnActionListener));
    }
    if (paramLong > 0L) {
      localBundle.putLong("contactSearchResultFilterType", paramLong);
    }
    localContactSearchFragment.setArguments(localBundle);
    return localContactSearchFragment;
  }
  
  private void f()
  {
    if (this.l != null)
    {
      this.l.post(new ContactSearchFragment.3(this));
      this.l.setOnScrollListener(new ContactSearchFragment.4(this));
    }
  }
  
  private void m()
  {
    if ((this.l != null) && (this.m != null))
    {
      int j = this.l.getFirstVisiblePosition();
      int k = this.l.getLastVisiblePosition();
      while (j <= k)
      {
        IModel localIModel = this.m.c(j);
        if ((localIModel != null) && ((localIModel instanceof ContactSearchModelGuild))) {
          SearchUtils.a("Sgrp", "search_result2", "exp", 0, 0, new String[] { String.valueOf(((ContactSearchModelGuild)localIModel).i()) });
        }
        j += 1;
      }
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (((!SearchUtils.b(this.b)) || (this.b == -1)) && (this.k != null))
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.e = false;
        if (this.b == -1)
        {
          this.k.setBackgroundResource(2131168376);
          return;
        }
        this.k.setBackgroundResource(2131165740);
        return;
      }
      this.e = true;
      this.k.setBackgroundResource(2130838958);
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish with status:", Integer.valueOf(paramInt) });
    }
    Object localObject1 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(2048);
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        Object localObject3;
        if ((QLog.isColorLevel()) && ((localObject2 instanceof IContactSearchModel)))
        {
          localObject3 = (IContactSearchModel)localObject2;
          localStringBuilder.append("model name:");
          localStringBuilder.append(((IContactSearchModel)localObject3).m());
          localStringBuilder.append(" clss:");
          localStringBuilder.append(localObject3.getClass().getSimpleName());
          localStringBuilder.append(" degree:");
          localStringBuilder.append(((IContactSearchModel)localObject3).u());
          localStringBuilder.append(" second:");
          localStringBuilder.append(((IContactSearchModel)localObject3).dk_());
          localStringBuilder.append("\n");
        }
        if ((localObject2 instanceof ISearchResultModel))
        {
          localObject3 = (ISearchResultModel)localObject2;
          if ((!this.g) || (!((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isQQAppInterface(this.p)) || (!SearchViewUtils.a(this.p, ((ISearchResultModel)localObject3).c())))
          {
            long l = this.h;
            if ((l > 0L) && ((l & 1L) != 0L) && ((localObject3 instanceof ContactSearchModelRecentUser)))
            {
              localObject2 = (ContactSearchModelRecentUser)localObject3;
              if ((((ContactSearchModelRecentUser)localObject2).j() == 1000) || (((ContactSearchModelRecentUser)localObject2).j() == 1004) || (((ContactSearchModelRecentUser)localObject2).j() == 1003) || (((ContactSearchModelRecentUser)localObject2).j() == 1006) || (((ContactSearchModelRecentUser)localObject2).j() == 2016))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("onFinish filter a result ,uintype = ");
                ((StringBuilder)localObject3).append(((ContactSearchModelRecentUser)localObject2).j());
                QLog.d("ContactSearchFragment", 2, ((StringBuilder)localObject3).toString());
                continue;
              }
            }
            if ((this.J == 2) && (SearchUtils.a((ISearchResultModel)localObject3))) {
              ((List)localObject1).add(localObject3);
            } else if ((this.J == 1) && (!SearchUtils.a((ISearchResultModel)localObject3)) && (!SearchUtils.b((ISearchResultModel)localObject3))) {
              ((List)localObject1).add(localObject3);
            } else if (this.J == 0) {
              ((List)localObject1).add(localObject3);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, localStringBuilder.toString());
    }
    super.a((List)localObject1, paramInt);
    if ((SearchUtils.b(this.b)) && (!this.j))
    {
      this.j = true;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.q);
      localObject1 = ((StringBuilder)localObject1).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      if (paramList == null) {
        paramInt = 0;
      } else {
        paramInt = paramList.size();
      }
      localStringBuilder.append(paramInt);
      SearchUtils.a("contact", "exp_page", new String[] { localObject1, localStringBuilder.toString() });
    }
    if (this.c)
    {
      this.c = false;
      this.u = false;
      this.o = c();
      this.o.a();
      this.u = true;
    }
    if (this.J == 3) {
      f();
    }
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish with respData:", paramSearchRespData.toString() });
    }
    if (paramSearchRespData.a(this.q))
    {
      a(paramList, paramSearchRespData.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.a, " keyword2:", this.q });
    }
  }
  
  public void a(List<String> paramList1, List<String> paramList2)
  {
    this.i.clear();
    this.G.clear();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        this.i.add(str);
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        this.G.add(paramList2);
      }
    }
  }
  
  protected BaseMvpAdapter b()
  {
    return new ContactSearchFragment.2(this, this.l, this.n);
  }
  
  protected ISearchEngine c()
  {
    int j = this.a;
    if (j == 524288)
    {
      if (this.b == 19) {
        return new PhoneContactMultiBindSearchEngine(this.p, this.b, this.a, this.d, this.f);
      }
      return new PhoneContactBinedSearchEngine(this.p, this.b, this.a, this.d, this.f);
    }
    if (this.c) {
      return new ApproximateSearchEngine(this.p, this.b, this.a, this.d, this.f);
    }
    if (j == 1048576)
    {
      if (this.b == 23) {
        return new TroopBatchAddFrdsSearchEngine(this.p, this.b, this.a, this.d, this.f);
      }
      return new TroopBatchAddFrdsMultipleSearchEngine(this.p, this.b, this.a, this.d, this.f);
    }
    return new ContactSearchEngine(this.p, this.b, this.a, this.d, this.f);
  }
  
  protected void c(List paramList)
  {
    super.c(paramList);
    if ((SearchUtils.b(this.b)) && (paramList != null) && (!this.j))
    {
      this.j = true;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.q);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramList.size());
      SearchUtils.a("contact", "exp_page", new String[] { localObject, localStringBuilder.toString() });
    }
  }
  
  protected boolean cj_()
  {
    return SearchUtils.b(this.b);
  }
  
  protected String d()
  {
    int j = this.J;
    if (j == 2) {
      return HardCodeUtil.a(2131900693);
    }
    if (j == 3) {
      return BaseApplication.getContext().getResources().getString(2131897857);
    }
    return HardCodeUtil.a(2131900696);
  }
  
  public void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  protected String e()
  {
    return HardCodeUtil.a(2131899283);
  }
  
  public void e(List<PhoneContact> paramList)
  {
    this.H.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.H.addAll(paramList);
    }
  }
  
  protected int l()
  {
    return 20;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.a = localBundle.getInt("contactSearchSource", 33751869);
      this.b = localBundle.getInt("fromType", -1);
      this.h = localBundle.getLong("contactSearchResultFilterType", -1L);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onCreate searchSource = ");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append(",fromType = ");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(",filterType = ");
        ((StringBuilder)localObject1).append(this.h);
        QLog.d("ContactSearchFragment", 2, ((StringBuilder)localObject1).toString());
      }
      int j = 0;
      this.c = localBundle.getBoolean("isApproximate", false);
      this.J = localBundle.getInt("ContactCombineType", 0);
      this.d = localBundle.getString("specifiedTroopUin");
      Object localObject1 = localBundle.getStringArray("hiddenUinSet");
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.f = new HashSet();
        int k = localObject1.length;
        while (j < k)
        {
          Object localObject2 = localObject1[j];
          this.f.add(localObject2);
          j += 1;
        }
      }
      long l = localBundle.getLong("contactSearchOnActionListener", -1L);
      if (l != -1L) {
        this.I = ((ContactSearchResultPresenter.OnActionListener)ObjectTransfer.a().a(l));
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!SearchUtils.b(this.b))
    {
      if (this.b == -1) {
        this.k.setBackgroundResource(2131168376);
      } else {
        this.k.setBackgroundResource(2131165740);
      }
      this.e = false;
      this.l.setOnTouchListener(new ContactSearchFragment.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */