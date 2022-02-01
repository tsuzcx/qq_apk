package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.framework.RIJViewInterceptor;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.video.RIJVideoViewInterceptor;
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerTask;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IHandlerFactory;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RIJInvokeHandler
{
  private SparseArray<IBaseHandler> jdField_a_of_type_AndroidUtilSparseArray;
  public AbsListView.OnScrollListener a;
  private Set<RIJViewInterceptor> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public RIJInvokeHandler()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new RIJInvokeHandler.1(this);
    this.jdField_a_of_type_JavaUtilSet.add(new RIJVideoViewInterceptor());
  }
  
  private Object a(HandlerTask paramHandlerTask)
  {
    if (paramHandlerTask == null) {
      return null;
    }
    Object localObject1 = null;
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      long l1 = SystemClock.currentThreadTimeMillis();
      IBaseHandler localIBaseHandler = (IBaseHandler)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      paramHandlerTask.a(localIBaseHandler);
      Object localObject2 = localObject1;
      if (paramHandlerTask.a != null)
      {
        if (localObject1 != null) {
          break;
        }
        localObject2 = paramHandlerTask.a;
        localIBaseHandler.d();
        paramHandlerTask.a = null;
      }
      long l2 = SystemClock.currentThreadTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("InvokeHandler", 2, new Object[] { "execute with return value handler job , id :%d, jobName :%s, cost :%ld ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i)), paramHandlerTask.a(), Long.valueOf(l2 - l1) });
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private void a(HandlerTask paramHandlerTask)
  {
    if (paramHandlerTask == null) {
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      long l1 = SystemClock.currentThreadTimeMillis();
      paramHandlerTask.a((IBaseHandler)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i));
      long l2 = SystemClock.currentThreadTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("InvokeHandler", 2, new Object[] { "execute handler job , id :%d, jobName :%s, cost :%ld", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i)), paramHandlerTask.a(), Long.valueOf(l2 - l1) });
      }
      i += 1;
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      RIJViewInterceptor localRIJViewInterceptor = (RIJViewInterceptor)localIterator.next();
      if (localRIJViewInterceptor.a(paramAbsBaseArticleInfo)) {
        localRIJViewInterceptor.a(paramAbsBaseArticleInfo, paramInt);
      }
    }
  }
  
  public SparseArray<IBaseHandler> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public VideoHandler a()
  {
    return (VideoHandler)a(0);
  }
  
  public IBaseHandler a()
  {
    return a(2);
  }
  
  public IBaseHandler a(int paramInt)
  {
    return (IBaseHandler)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public Boolean a()
  {
    return (Boolean)a(new RIJInvokeHandler.25(this, "onBackPressed"));
  }
  
  public void a()
  {
    a(new RIJInvokeHandler.9(this, "onDestroy"));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(new RIJInvokeHandler.10(this, "onActivityResult", paramInt1, paramInt2, paramIntent));
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    a(new RIJInvokeHandler.21(this, "onChannelArticleLoaded", paramInt, paramList));
  }
  
  public void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, int paramInt)
  {
    a(new RIJInvokeHandler.18(this, "onImageClick", paramContext, paramAbsBaseArticleInfo, paramString, paramInt));
  }
  
  public void a(SparseArray<IBaseHandler> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
  }
  
  public void a(SparseArray<IBaseHandler> paramSparseArray, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i = 0;
    while (i < paramSparseArray.size())
    {
      ((IBaseHandler)paramSparseArray.valueAt(i)).a(paramReadInJoyBaseAdapter);
      i += 1;
    }
  }
  
  public void a(View paramView1, View paramView2, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    a(new RIJInvokeHandler.27(this, "onPostGetAdapterView", paramView1, paramView2, paramAbsBaseArticleInfo, paramInt));
    a(paramAbsBaseArticleInfo, paramInt);
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    a(new RIJInvokeHandler.17(this, "onRegionClick", paramView, paramAbsBaseArticleInfo, paramInt));
  }
  
  public void a(View paramView, ListView paramListView)
  {
    a(new RIJInvokeHandler.3(this, "onListViewGroupInited", paramView, paramListView));
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    a(new RIJInvokeHandler.2(this, "onListViewGroupInit", paramView, paramListView, paramLong));
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = ((IHandlerFactory)QRoute.api(IHandlerFactory.class)).buildBusinessHandlers(paramViewGroup);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    a(new RIJInvokeHandler.29(this, "OnDataChangedDrawCompletion", paramReadInJoyBaseListView));
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    a(new RIJInvokeHandler.16(this, "onStartTopRefresh", paramInt));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    a(new RIJInvokeHandler.4(this, "onScrollStateChanged", paramAbsListView, paramInt));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(new RIJInvokeHandler.5(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(new RIJInvokeHandler.23(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    a(new RIJInvokeHandler.26(this, "onSetData", paramList));
  }
  
  public void a(Map<Integer, BaseReportData> paramMap)
  {
    a(new RIJInvokeHandler.6(this, "attachToViewGroup#1", paramMap));
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    a(new RIJInvokeHandler.8(this, "detachFromViewGroup", paramMap, paramBoolean));
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    a(new RIJInvokeHandler.7(this, "attachToViewGroup#2", paramSet, paramMap));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a(new RIJInvokeHandler.20(this, "onBackToTop", paramBoolean, paramInt));
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    a(new RIJInvokeHandler.15(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public void b()
  {
    a(new RIJInvokeHandler.11(this, "onResume"));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    a(new RIJInvokeHandler.22(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public void c()
  {
    a(new RIJInvokeHandler.12(this, "onPause"));
  }
  
  public void d()
  {
    a(new RIJInvokeHandler.13(this, "onStart"));
  }
  
  public void e()
  {
    a(new RIJInvokeHandler.19(this, "onEndRefresh"));
  }
  
  public void f()
  {
    a(new RIJInvokeHandler.24(this, "onListViewDrawFinished"));
  }
  
  public void g()
  {
    a(new RIJInvokeHandler.28(this, "onNotifyDataSetChange"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler
 * JD-Core Version:    0.7.0.1
 */