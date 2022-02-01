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
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerTask;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
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
  public AbsListView.OnScrollListener a = new RIJInvokeHandler.1(this);
  private SparseArray<IBaseHandler> b;
  private Set<RIJViewInterceptor> c = new HashSet();
  
  public RIJInvokeHandler()
  {
    this.c.add(new RIJVideoViewInterceptor());
  }
  
  private Object a(HandlerTask paramHandlerTask)
  {
    if (paramHandlerTask == null) {
      return null;
    }
    Object localObject1 = null;
    int i = 0;
    while (i < this.b.size())
    {
      long l1 = SystemClock.currentThreadTimeMillis();
      IBaseHandler localIBaseHandler = (IBaseHandler)this.b.valueAt(i);
      paramHandlerTask.a(localIBaseHandler);
      Object localObject2 = localObject1;
      if (paramHandlerTask.g != null)
      {
        if (localObject1 != null) {
          break;
        }
        localObject2 = paramHandlerTask.g;
        localIBaseHandler.s();
        paramHandlerTask.g = null;
      }
      long l2 = SystemClock.currentThreadTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("InvokeHandler", 2, new Object[] { "execute with return value handler job , id :%d, jobName :%s, cost :%ld ", Integer.valueOf(this.b.keyAt(i)), paramHandlerTask.a(), Long.valueOf(l2 - l1) });
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      RIJViewInterceptor localRIJViewInterceptor = (RIJViewInterceptor)localIterator.next();
      if (localRIJViewInterceptor.a(paramAbsBaseArticleInfo)) {
        localRIJViewInterceptor.a(paramAbsBaseArticleInfo, paramInt);
      }
    }
  }
  
  private void b(HandlerTask paramHandlerTask)
  {
    if (paramHandlerTask == null) {
      return;
    }
    int i = 0;
    while (i < this.b.size())
    {
      paramHandlerTask.a((IBaseHandler)this.b.valueAt(i));
      i += 1;
    }
  }
  
  public SparseArray<IBaseHandler> a()
  {
    return this.b;
  }
  
  public IBaseHandler a(int paramInt)
  {
    return (IBaseHandler)this.b.get(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b(new RIJInvokeHandler.10(this, "onActivityResult", paramInt1, paramInt2, paramIntent));
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    b(new RIJInvokeHandler.21(this, "onChannelArticleLoaded", paramInt, paramList));
  }
  
  public void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, int paramInt)
  {
    b(new RIJInvokeHandler.18(this, "onImageClick", paramContext, paramAbsBaseArticleInfo, paramString, paramInt));
  }
  
  public void a(SparseArray<IBaseHandler> paramSparseArray)
  {
    this.b = paramSparseArray;
  }
  
  public void a(SparseArray<IBaseHandler> paramSparseArray, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.b = paramSparseArray;
    int i = 0;
    while (i < paramSparseArray.size())
    {
      ((IBaseHandler)paramSparseArray.valueAt(i)).a(paramReadInJoyBaseAdapter);
      i += 1;
    }
  }
  
  public void a(View paramView1, View paramView2, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    b(new RIJInvokeHandler.27(this, "onPostGetAdapterView", paramView1, paramView2, paramAbsBaseArticleInfo, paramInt));
    a(paramAbsBaseArticleInfo, paramInt);
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    b(new RIJInvokeHandler.17(this, "onRegionClick", paramView, paramAbsBaseArticleInfo, paramInt));
  }
  
  public void a(View paramView, ListView paramListView)
  {
    b(new RIJInvokeHandler.3(this, "onListViewGroupInited", paramView, paramListView));
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    b(new RIJInvokeHandler.2(this, "onListViewGroupInit", paramView, paramListView, paramLong));
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.b = HandlerFactory.a(paramViewGroup);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    b(new RIJInvokeHandler.29(this, "OnDataChangedDrawCompletion", paramReadInJoyBaseListView));
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    b(new RIJInvokeHandler.16(this, "onStartTopRefresh", paramInt));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    b(new RIJInvokeHandler.4(this, "onScrollStateChanged", paramAbsListView, paramInt));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    b(new RIJInvokeHandler.5(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b(new RIJInvokeHandler.23(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    b(new RIJInvokeHandler.26(this, "onSetData", paramList));
  }
  
  public void a(Map<Integer, BaseReportData> paramMap)
  {
    b(new RIJInvokeHandler.6(this, "attachToViewGroup#1", paramMap));
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    b(new RIJInvokeHandler.8(this, "detachFromViewGroup", paramMap, paramBoolean));
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    b(new RIJInvokeHandler.7(this, "attachToViewGroup#2", paramSet, paramMap));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    b(new RIJInvokeHandler.20(this, "onBackToTop", paramBoolean, paramInt));
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    b(new RIJInvokeHandler.15(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public IBaseHandler b()
  {
    return a(2);
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    b(new RIJInvokeHandler.22(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public VideoHandler c()
  {
    return (VideoHandler)a(0);
  }
  
  public void d()
  {
    b(new RIJInvokeHandler.9(this, "onDestroy"));
  }
  
  public void e()
  {
    b(new RIJInvokeHandler.11(this, "onResume"));
  }
  
  public void f()
  {
    b(new RIJInvokeHandler.12(this, "onPause"));
  }
  
  public void g()
  {
    b(new RIJInvokeHandler.13(this, "onStart"));
  }
  
  public void h()
  {
    b(new RIJInvokeHandler.19(this, "onEndRefresh"));
  }
  
  public void i()
  {
    b(new RIJInvokeHandler.24(this, "onListViewDrawFinished"));
  }
  
  public Boolean j()
  {
    return (Boolean)a(new RIJInvokeHandler.25(this, "onBackPressed"));
  }
  
  public void k()
  {
    b(new RIJInvokeHandler.28(this, "onNotifyDataSetChange"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler
 * JD-Core Version:    0.7.0.1
 */