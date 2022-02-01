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
  protected int a;
  protected XRecyclerView a;
  protected String a;
  protected List<View> a;
  protected String b = "0X8007626";
  protected int c;
  protected String c;
  protected int d;
  protected boolean e = false;
  protected boolean f = true;
  
  public ReadInJoyDynamicChannelBaseFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "0X8007625";
  }
  
  public static TemplateFactory a(String paramString)
  {
    TemplateFactory localTemplateFactory2 = TemplateFactory.a(paramString, false);
    TemplateFactory localTemplateFactory1 = localTemplateFactory2;
    if (localTemplateFactory2 == null) {
      localTemplateFactory1 = TemplateFactory.a(paramString, true);
    }
    return localTemplateFactory1;
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamic_feeds_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void j()
  {
    k();
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = new XRecyclerView(a());
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(this.jdField_a_of_type_Int, 1);
    localStaggeredGridLayoutManager.setGapStrategy(0);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().setLayoutManager(localStaggeredGridLayoutManager);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().setOnBindHeaderObserver(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().addOnScrollListener(new ReadInJoyDynamicChannelBaseFragment.3(this, localStaggeredGridLayoutManager));
    c();
    h();
  }
  
  private void k()
  {
    Object localObject1 = a(b());
    String str1 = "ReadInJoyDynamicChannelBaseFragment";
    if (localObject1 == null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "initOfflineConfig failed, templateFactory is null.");
      return;
    }
    if (((TemplateFactory)localObject1).a() > 0) {
      this.jdField_a_of_type_Int = ((TemplateFactory)localObject1).a();
    }
    localObject1 = ((TemplateFactory)localObject1).a();
    if (localObject1 != null)
    {
      String str2 = ((DynamicChannelConfig)localObject1).a("expose_t_name");
      String str3 = ((DynamicChannelConfig)localObject1).a("click_t_name");
      if (!TextUtils.isEmpty(str2)) {
        this.b = str2;
      }
      if (!TextUtils.isEmpty(str3)) {
        this.jdField_c_of_type_JavaLangString = str3;
      }
      str2 = ((DynamicChannelConfig)localObject1).a("is_support_pull_refresh");
      if (!TextUtils.isEmpty(str2)) {
        this.f = str2.equals("1");
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
      ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2).jdField_a_of_type_JavaLangString = str2;
      ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2).jdField_a_of_type_Boolean = bool;
      ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2).b = str3;
      ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2).jdField_c_of_type_JavaLangString = str4;
      Object localObject3 = DynamicChannelDataModule.a();
      if (localObject3 != null) {
        ((DynamicChannelDataModule)localObject3).a(this.jdField_c_of_type_Int, (ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject2);
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
            localOfflineHeaderConfig.jdField_a_of_type_JavaLangString = ((DynamicChannelConfig.HeadData)localObject3).jdField_a_of_type_JavaLangString;
            localOfflineHeaderConfig.b = ((DynamicChannelConfig.HeadData)localObject3).b;
            localOfflineHeaderConfig.jdField_c_of_type_JavaLangString = ((DynamicChannelConfig)localObject1).a(i, "cgi");
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
          ((DynamicChannelHeaderModule)localObject3).a(this.jdField_c_of_type_Int, (List)localObject2);
          localObject1 = str1;
        }
      }
      else
      {
        localObject1 = "ReadInJoyDynamicChannelBaseFragment";
      }
      QLog.d((String)localObject1, 2, new Object[] { "initOfflineConfig \n", "mSpanCount = ", Integer.valueOf(this.jdField_a_of_type_Int), "\n", "mExposedTName = ", this.b, "\n", "mClickTName = ", this.jdField_c_of_type_JavaLangString, "\n", "isSupportPullRefresh = ", Boolean.valueOf(this.f), "\n", "bodyIsNeedIDList = ", Boolean.valueOf(bool), "\n", "bodyCGI = ", str2, "\n", "bodyReqJSMethod = ", str3, "\n", "bodyRecJSMethod = ", str4, "\n", "headerConfigSize = ", Integer.valueOf(j), "\n" });
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "initOfflineConfig \n", "mSpanCount = ", Integer.valueOf(this.jdField_a_of_type_Int), "\n", "mExposedTName = ", this.b, "\n", "mClickTName = ", this.jdField_c_of_type_JavaLangString, "\n", "isSupportPullRefresh = ", Boolean.valueOf(this.f), "\n", "config is null." });
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    b(true);
  }
  
  protected void a(View paramView)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "addHeader.");
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramView)) {
      this.jdField_a_of_type_JavaUtilList.add(paramView);
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView();
    if (!((RecyclerViewWithHeaderFooter)localObject).hasHeader(paramView)) {
      ((RecyclerViewWithHeaderFooter)localObject).addHeaderView(paramView);
    }
    localObject = (RecyclerViewHeaderViewAdapter)((RecyclerViewWithHeaderFooter)localObject).getAdapter();
    if (!((RecyclerViewHeaderViewAdapter)localObject).hasHeader(paramView)) {
      ((RecyclerViewHeaderViewAdapter)localObject).addHeader(paramView);
    }
    aB_();
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    a();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamic_feeds_");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    return localStringBuilder.toString();
  }
  
  protected void b(View paramView)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "removeHeader.");
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView();
    localRecyclerViewWithHeaderFooter.removeHeaderView(paramView);
    ((RecyclerViewHeaderViewAdapter)localRecyclerViewWithHeaderFooter.getAdapter()).removeHeader(paramView);
    aB_();
  }
  
  protected void b(boolean paramBoolean)
  {
    XRecyclerView localXRecyclerView = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
    if (localXRecyclerView == null) {
      return;
    }
    localXRecyclerView.post(new ReadInJoyDynamicChannelBaseFragment.1(this));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.post(new ReadInJoyDynamicChannelBaseFragment.2(this));
    }
  }
  
  public void d()
  {
    super.d();
    b(true);
  }
  
  public void e()
  {
    super.e();
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    super.f();
    b(true);
  }
  
  protected void i()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        b((View)((Iterator)localObject).next());
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_c_of_type_Int = paramBundle.getInt("channel_id");
      this.d = paramBundle.getInt("channel_type");
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("channel_name");
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 1, new Object[] { "onCreate, mChannelID = ", Integer.valueOf(this.jdField_c_of_type_Int), ", mChannelType = ", Integer.valueOf(this.d), ", mChannelName = ", this.jdField_a_of_type_JavaLangString });
    j();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment
 * JD-Core Version:    0.7.0.1
 */