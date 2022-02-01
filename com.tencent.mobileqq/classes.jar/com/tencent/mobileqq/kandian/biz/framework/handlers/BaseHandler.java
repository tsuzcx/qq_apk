package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public abstract class BaseHandler
  implements IBaseHandler
{
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup = null;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = null;
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
  }
  
  public final Activity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public AnimationSet a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
  }
  
  public final IFaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
  }
  
  public RIJDataFetchManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a();
  }
  
  public RIJDataManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
  }
  
  public ReadInJoyBaseListViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
  }
  
  public final ReadInJoyBaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  }
  
  public AbsListView a()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localReadInJoyBaseAdapter != null) {
      return localReadInJoyBaseAdapter.a();
    }
    return null;
  }
  
  public Boolean a()
  {
    return null;
  }
  
  public Integer a(int paramInt)
  {
    return Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.getItemViewType(paramInt));
  }
  
  public final Object a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.getItem(paramInt);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, List<Long> paramList) {}
  
  public void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, int paramInt) {}
  
  public void a(View paramView1, View paramView2, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public final void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup = ((ReadInJoyBaseListViewGroup)paramViewGroup);
  }
  
  public final void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = ((ReadInJoyBaseAdapter)paramIReadInJoyBaseAdapter);
  }
  
  public void a(@Nullable AbsListView paramAbsListView) {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void a(List<? extends AbsBaseArticleInfo> paramList) {}
  
  public void a(Map<Integer, ? extends BaseReportData> paramMap) {}
  
  public void a(Map<Long, ? extends BaseReportData> paramMap, boolean paramBoolean) {}
  
  public void a(Set<Long> paramSet, Map<Long, ? extends BaseReportData> paramMap) {}
  
  public void a(boolean paramBoolean)
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localReadInJoyBaseListViewGroup != null) {
      localReadInJoyBaseListViewGroup.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public final boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b();
  }
  
  public void b(int paramInt, List<ChannelBannerInfo> paramList) {}
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public final int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.getCount();
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.BaseHandler
 * JD-Core Version:    0.7.0.1
 */