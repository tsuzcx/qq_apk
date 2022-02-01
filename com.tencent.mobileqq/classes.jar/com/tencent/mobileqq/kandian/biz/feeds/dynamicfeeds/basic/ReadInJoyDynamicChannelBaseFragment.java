package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelHeaderModule;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter.OnBindHeaderObserver;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ReadInJoyDynamicChannelBaseFragment
  extends ReadInJoyBaseFragment
  implements DataRefreshInterface, FragmentInitInterface, RecyclerViewHeaderViewAdapter.OnBindHeaderObserver
{
  protected int a = 1;
  protected List<View> b = new ArrayList();
  protected XRecyclerView c;
  protected int d = -1;
  protected int m;
  protected String n;
  protected boolean o = false;
  protected String p = "0X8007626";
  protected String q = "0X8007625";
  protected boolean r = true;
  
  public static TemplateFactory a(String paramString)
  {
    TemplateFactory localTemplateFactory2 = TemplateFactory.a(paramString, false);
    TemplateFactory localTemplateFactory1 = localTemplateFactory2;
    if (localTemplateFactory2 == null) {
      localTemplateFactory1 = TemplateFactory.a(paramString, true);
    }
    return localTemplateFactory1;
  }
  
  public static String d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamic_feeds_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void y()
  {
    z();
    this.c = new XRecyclerView(v());
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(this.a, 1);
    localStaggeredGridLayoutManager.setGapStrategy(0);
    this.c.getRecyclerView().setLayoutManager(localStaggeredGridLayoutManager);
    this.c.getRecyclerView().setOnBindHeaderObserver(this);
    this.c.getRecyclerView().addOnScrollListener(new ReadInJoyDynamicChannelBaseFragment.3(this, localStaggeredGridLayoutManager));
    cX_();
    cY_();
  }
  
  private void z()
  {
    Object localObject1 = a(w());
    String str1 = "ReadInJoyDynamicChannelBaseFragment";
    if (localObject1 == null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "initOfflineConfig failed, templateFactory is null.");
      return;
    }
    if (((TemplateFactory)localObject1).e() > 0) {
      this.a = ((TemplateFactory)localObject1).e();
    }
    localObject1 = ((TemplateFactory)localObject1).f();
    if (localObject1 != null)
    {
      String str2 = ((DynamicChannelConfig)localObject1).a("expose_t_name");
      String str3 = ((DynamicChannelConfig)localObject1).a("click_t_name");
      if (!TextUtils.isEmpty(str2)) {
        this.p = str2;
      }
      if (!TextUtils.isEmpty(str3)) {
        this.q = str3;
      }
      str2 = ((DynamicChannelConfig)localObject1).a("is_support_pull_refresh");
      if (!TextUtils.isEmpty(str2)) {
        this.r = str2.equals("1");
      }
      str2 = ((DynamicChannelConfig)localObject1).b("is_need_id_list");
      boolean bool;
      if (!TextUtils.isEmpty(str2)) {
        bool = str2.equals("1");
      } else {
        bool = false;
      }
      str2 = ((DynamicChannelConfig)localObject1).b("cgi");
      str3 = ((DynamicChannelConfig)localObject1).b("request_pre_process");
      String str4 = ((DynamicChannelConfig)localObject1).b("receive_pre_process");
      Object localObject2 = new ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig();
      ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2).a = str2;
      ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2).b = bool;
      ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2).c = str3;
      ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2).d = str4;
      Object localObject3 = DynamicChannelDataModule.a();
      if (localObject3 != null) {
        ((DynamicChannelDataModule)localObject3).a(this.d, (ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2);
      }
      int j = ((DynamicChannelConfig)localObject1).a();
      localObject2 = new ArrayList();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          localObject3 = ((DynamicChannelConfig)localObject1).a(i);
          if (localObject3 != null)
          {
            ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig localOfflineHeaderConfig = new ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig();
            localOfflineHeaderConfig.a = ((DynamicChannelConfig.HeadData)localObject3).a;
            localOfflineHeaderConfig.b = ((DynamicChannelConfig.HeadData)localObject3).b;
            localOfflineHeaderConfig.c = ((DynamicChannelConfig)localObject1).a(i, "cgi");
            localOfflineHeaderConfig.d = ((DynamicChannelConfig)localObject1).a(i, "request_pre_process");
            localOfflineHeaderConfig.e = ((DynamicChannelConfig)localObject1).a(i, "receive_pre_process");
            ((List)localObject2).add(localOfflineHeaderConfig);
          }
          i += 1;
        }
        localObject3 = DynamicChannelHeaderModule.a();
        localObject1 = str1;
        if (localObject3 != null)
        {
          ((DynamicChannelHeaderModule)localObject3).a(this.d, (List)localObject2);
          localObject1 = str1;
        }
      }
      else
      {
        localObject1 = "ReadInJoyDynamicChannelBaseFragment";
      }
      QLog.d((String)localObject1, 2, new Object[] { "initOfflineConfig \n", "mSpanCount = ", Integer.valueOf(this.a), "\n", "mExposedTName = ", this.p, "\n", "mClickTName = ", this.q, "\n", "isSupportPullRefresh = ", Boolean.valueOf(this.r), "\n", "bodyIsNeedIDList = ", Boolean.valueOf(bool), "\n", "bodyCGI = ", str2, "\n", "bodyReqJSMethod = ", str3, "\n", "bodyRecJSMethod = ", str4, "\n", "headerConfigSize = ", Integer.valueOf(j), "\n" });
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "initOfflineConfig \n", "mSpanCount = ", Integer.valueOf(this.a), "\n", "mExposedTName = ", this.p, "\n", "mClickTName = ", this.q, "\n", "isSupportPullRefresh = ", Boolean.valueOf(this.r), "\n", "config is null." });
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    b(true);
  }
  
  protected void a(View paramView)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "addHeader.");
    if (!this.b.contains(paramView)) {
      this.b.add(paramView);
    }
    Object localObject = this.c.getRecyclerView();
    if (!((RecyclerViewWithHeaderFooter)localObject).hasHeader(paramView)) {
      ((RecyclerViewWithHeaderFooter)localObject).addHeaderView(paramView);
    }
    localObject = (RecyclerViewHeaderViewAdapter)((RecyclerViewWithHeaderFooter)localObject).getAdapter();
    if (!((RecyclerViewHeaderViewAdapter)localObject).hasHeader(paramView)) {
      ((RecyclerViewHeaderViewAdapter)localObject).addHeader(paramView);
    }
    cZ_();
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    a();
  }
  
  protected void b(View paramView)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "removeHeader.");
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.c.getRecyclerView();
    localRecyclerViewWithHeaderFooter.removeHeaderView(paramView);
    ((RecyclerViewHeaderViewAdapter)localRecyclerViewWithHeaderFooter.getAdapter()).removeHeader(paramView);
    cZ_();
  }
  
  protected void b(boolean paramBoolean)
  {
    XRecyclerView localXRecyclerView = this.c;
    if (localXRecyclerView == null) {
      return;
    }
    localXRecyclerView.post(new ReadInJoyDynamicChannelBaseFragment.1(this));
    if (paramBoolean) {
      this.c.post(new ReadInJoyDynamicChannelBaseFragment.2(this));
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void h()
  {
    super.h();
    b(true);
  }
  
  public void k()
  {
    super.k();
  }
  
  public void l()
  {
    super.l();
    b(true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.d = paramBundle.getInt("channel_id");
      this.m = paramBundle.getInt("channel_type");
      this.n = paramBundle.getString("channel_name");
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 1, new Object[] { "onCreate, mChannelID = ", Integer.valueOf(this.d), ", mChannelType = ", Integer.valueOf(this.m), ", mChannelName = ", this.n });
    y();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.c;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean q()
  {
    return true;
  }
  
  protected String w()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamic_feeds_");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
  
  protected void x()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        b((View)((Iterator)localObject).next());
      }
      this.b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment
 * JD-Core Version:    0.7.0.1
 */