package com.tencent.mobileqq.search.fragment;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.kandian.biz.search.api.OnTipClickListener;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.BusinessGroupWord.ClueWordItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord.GroupID;
import com.tencent.mobileqq.search.model.BusinessGroupWord.HotWordItem;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.HotWordForSubTipsContainer;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HotWordsForSubBussFragment
  extends BaseFragment
{
  public static final String a;
  protected static int i = -1;
  protected View b;
  protected TextView c;
  protected HotWordForSubTipsContainer d;
  protected UniteSearchHandler e;
  protected UnifySearchHandler f;
  protected QQAppInterface g;
  protected long[] h;
  protected UnifySearchObserver j = new HotWordsForSubBussFragment.3(this);
  protected UniteSearchObserver k = new HotWordsForSubBussFragment.4(this);
  OnTipClickListener l = new HotWordsForSubBussFragment.5(this);
  private int m;
  private boolean n = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unify_search");
    localStringBuilder.append(HotWordsForSubBussFragment.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  private void a(List<BusinessGroupWord.HotWordItem> paramList)
  {
    if (this.h == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.c.setVisibility(0);
      if (this.n)
      {
        this.d.a(paramList, 2130841117, getResources().getColor(2131167923), getResources().getColor(2131167922));
        return;
      }
      this.d.a(paramList, 2130841114, getResources().getColor(2131165564), getResources().getColor(2131167921));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "update BusiHotWords results is null");
    }
    this.c.setVisibility(8);
  }
  
  private void b(List<BusinessGroupWord> paramList)
  {
    if (this.h == null) {
      return;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "updateBusiHotWords results is null");
      }
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (BusinessGroupWord)paramList.next();
      Object localObject2 = SearchUtils.b(((BusinessGroupWord)localObject1).groupID.a);
      if ((localObject2 != null) && (Arrays.equals((long[])localObject2, this.h)))
      {
        localObject2 = ((BusinessGroupWord)localObject1).clueWordItem;
        BaseActivity localBaseActivity = getBaseActivity();
        if ((localBaseActivity instanceof ActiveEntitySearchActivity)) {
          ((ActiveEntitySearchActivity)localBaseActivity).d(((BusinessGroupWord.ClueWordItem)localObject2).b);
        }
        localObject1 = ((BusinessGroupWord)localObject1).hotWordItemList;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          this.c.setVisibility(0);
          if (this.n) {
            this.d.a((List)localObject1, 2130841117, getResources().getColor(2131167923), getResources().getColor(2131167922));
          } else {
            this.d.a((List)localObject1, 2130841114, getResources().getColor(2131165564), getResources().getColor(2131167921));
          }
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.e;
    long l1 = -1L;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject != null)
    {
      localObject = BaseApplication.getContext().getSharedPreferences(UniteSearchHandler.d, 0).getString(UniteSearchHandler.e, "");
      l2 = l1;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      l2 = Long.parseLong((String)localObject);
    }
    catch (Exception localException1)
    {
      label64:
      int i1;
      break label64;
    }
    long l2 = l1;
    if (QLog.isColorLevel())
    {
      QLog.i(a, 2, "reqTimeStr number format error");
      l2 = l1;
    }
    l1 = System.currentTimeMillis();
    i1 = i;
    if ((i1 == -1) || (l1 - l2 > i1 * 1000)) {
      bool1 = true;
    }
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "requestData, send netWork request");
      }
      this.e.a();
    }
    ThreadManager.post(new HotWordsForSubBussFragment.1(this, bool1), 5, null, true);
    return;
    if (this.f != null)
    {
      localObject = BaseApplication.getContext().getSharedPreferences(UnifySearchHandler.d, 0).getString(UnifySearchHandler.e, "");
      l2 = l1;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      l2 = Long.parseLong((String)localObject);
    }
    catch (Exception localException2)
    {
      label209:
      break label209;
    }
    l2 = l1;
    if (QLog.isColorLevel())
    {
      QLog.i(a, 2, "UnifySearchHandler reqTimeStr number format error");
      l2 = l1;
    }
    l1 = System.currentTimeMillis();
    i1 = i;
    if (i1 != -1)
    {
      bool1 = bool2;
      if (l1 - l2 <= i1 * 1000) {}
    }
    else
    {
      bool1 = true;
    }
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "UnifySearchHandler requestData, send netWork request");
      }
      this.f.a();
    }
    ThreadManager.post(new HotWordsForSubBussFragment.2(this, bool1), 5, null, true);
    return;
    QLog.e(a, 2, "requestData HANDLE is null");
  }
  
  protected void a()
  {
    if (this.m == 10)
    {
      this.e = ((UniteSearchHandler)this.g.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      this.f = null;
      this.g.addObserver(this.k);
      return;
    }
    this.f = ((UnifySearchHandler)this.g.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    this.e = null;
    this.g.addObserver(this.j);
  }
  
  protected void b()
  {
    if (this.m == 10)
    {
      this.g.removeObserver(this.k);
      return;
    }
    this.g.removeObserver(this.j);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.h = ((Bundle)localObject).getLongArray("group_masks");
      this.m = ((Bundle)localObject).getInt("fromType", -1);
    }
    localObject = getBaseActivity();
    if ((localObject instanceof BaseActivity))
    {
      this.g = ((BaseActivity)localObject).app;
      a();
      c();
      super.onCreate(paramBundle);
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = paramLayoutInflater.inflate(2131628001, null);
    this.c = ((TextView)this.b.findViewById(2131448532));
    this.d = ((HotWordForSubTipsContainer)this.b.findViewById(2131447419));
    this.d.setOnTipsClickListener(this.l);
    this.n = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (this.n)
    {
      this.c.setTextColor(Color.parseColor("#44608A"));
      this.b.setBackgroundResource(2130839569);
    }
    else
    {
      this.c.setTextColor(Color.parseColor("#999999"));
      this.b.setBackgroundResource(2130839568);
    }
    a((List)FunctionModuleConfigManager.b.get(FunctionModuleConfigManager.a(this.h)));
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment
 * JD-Core Version:    0.7.0.1
 */