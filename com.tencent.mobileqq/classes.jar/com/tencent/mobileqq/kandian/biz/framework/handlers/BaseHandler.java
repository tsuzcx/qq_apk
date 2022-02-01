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
  private ReadInJoyBaseListViewGroup a = null;
  private ReadInJoyBaseAdapter b = null;
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public RIJDataFetchManager a()
  {
    return this.a.getDataFetchManager();
  }
  
  public Integer a(int paramInt)
  {
    return Integer.valueOf(this.b.getItemViewType(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, List<Long> paramList) {}
  
  public void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, int paramInt) {}
  
  public void a(View paramView1, View paramView2, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public final void a(ViewGroup paramViewGroup)
  {
    this.a = ((ReadInJoyBaseListViewGroup)paramViewGroup);
  }
  
  public final void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    this.b = ((ReadInJoyBaseAdapter)paramIReadInJoyBaseAdapter);
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
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.a;
    if (localReadInJoyBaseListViewGroup != null) {
      localReadInJoyBaseListViewGroup.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public final Object b(int paramInt)
  {
    return this.b.getItem(paramInt);
  }
  
  public void b(int paramInt, List<ChannelBannerInfo> paramList) {}
  
  public void b(boolean paramBoolean, int paramInt)
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.a;
    if (localReadInJoyBaseListViewGroup != null) {
      localReadInJoyBaseListViewGroup.a(paramBoolean, paramInt);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public int c()
  {
    return this.b.c();
  }
  
  public void c(int paramInt) {}
  
  public ReadInJoyBaseListViewGroup d()
  {
    return this.a;
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public AbsListView e()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.b;
    if (localReadInJoyBaseAdapter != null) {
      return localReadInJoyBaseAdapter.d();
    }
    return null;
  }
  
  public int f()
  {
    return this.b.i();
  }
  
  public final ReadInJoyBaseAdapter g()
  {
    return this.b;
  }
  
  public RIJDataManager h()
  {
    return this.b.E();
  }
  
  public final Activity i()
  {
    return this.b.a();
  }
  
  public void o() {}
  
  public Boolean p()
  {
    return null;
  }
  
  public void q() {}
  
  public void r() {}
  
  public final int t()
  {
    return this.b.getCount();
  }
  
  public final boolean u()
  {
    return this.b.j();
  }
  
  public final IFaceDecoder v()
  {
    return this.b.l();
  }
  
  public AnimationSet w()
  {
    return this.b.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.BaseHandler
 * JD-Core Version:    0.7.0.1
 */