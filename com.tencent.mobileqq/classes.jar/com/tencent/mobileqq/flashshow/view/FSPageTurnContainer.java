package com.tencent.mobileqq.flashshow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.flashshow.view.refresh.FSLayerLoadFooterView;
import com.tencent.mobileqq.flashshow.view.refresh.FSLayerRefreshHeaderView;
import com.tencent.mobileqq.flashshow.view.refresh.PullRefreshLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FSPageTurnContainer
  extends FrameLayout
{
  private boolean a;
  private ViewPager2 b;
  private PullRefreshLayout c;
  private int d = 1;
  private FSPageTurnContainer.OnLoadDataCallback e;
  private int f = 2;
  private FSPageTurnContainer.OnRefreshLoadViewStatusListener g;
  private FSLayerRefreshHeaderView h;
  private FSLayerLoadFooterView i;
  
  public FSPageTurnContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSPageTurnContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSPageTurnContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(int paramInt)
  {
    if (!g())
    {
      if (h()) {
        return;
      }
      if (!(getViewPager2().getAdapter() instanceof BaseListViewAdapter)) {
        return;
      }
      BaseListViewAdapter localBaseListViewAdapter = (BaseListViewAdapter)getViewPager2().getAdapter();
      int j;
      if (localBaseListViewAdapter.getDataList() != null) {
        j = localBaseListViewAdapter.getDataList().size();
      } else {
        j = 0;
      }
      if (paramInt >= j - 1 - this.f)
      {
        QLog.d("FSPageTurnContainer", 1, "checkNeedTriggerPreloadLoadMore  preload loadMore");
        c(true);
        setPreloadLoadMore(true);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("triggerRefreshOrLoadMore  isLoadMore = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("FSPageTurnContainer", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (c())
      {
        QLog.d("FSPageTurnContainer", 1, "triggerRefreshOrLoadMore  isLoadMore = true , running preloadLoadMore");
        return;
      }
      localObject = this.e;
      if (localObject != null) {
        ((FSPageTurnContainer.OnLoadDataCallback)localObject).a(true);
      }
    }
    else
    {
      localObject = this.e;
      if (localObject != null) {
        ((FSPageTurnContainer.OnLoadDataCallback)localObject).a(false);
      }
    }
  }
  
  private void i()
  {
    this.c = ((PullRefreshLayout)findViewById(2131440660));
    setRefreshEnable(true);
    setLoadMoreEnable(true);
    this.c.setAutoLoadEnable(true);
    this.c.setOffsetRadio(3.0F);
    this.h = new FSLayerRefreshHeaderView(getContext());
    this.c.setHeaderView(this.h, 3);
    this.c.setHeaderViewMarginTop(ViewUtils.getStatusBarHeight(getContext()) + ViewUtils.dpToPx(28.0F));
    this.i = new FSLayerLoadFooterView(getContext());
    this.c.setFooterView(this.i, 2);
    this.c.setOnRefreshListener(new FSPageTurnContainer.2(this));
  }
  
  protected void a()
  {
    try
    {
      LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initView error:");
      localStringBuilder.append(localThrowable.toString());
      QLog.d("FSPageTurnContainer", 1, localStringBuilder.toString());
    }
    b();
    i();
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.b(paramBoolean);
  }
  
  protected void b()
  {
    this.b = ((ViewPager2)findViewById(2131444762));
    this.b.setOrientation(this.d);
    this.b.registerOnPageChangeCallback(new FSPageTurnContainer.1(this));
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
    setPreloadLoadMore(false);
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.c.e();
  }
  
  public void e()
  {
    this.c.f();
  }
  
  public void f()
  {
    this.c.g();
  }
  
  public boolean g()
  {
    return this.c.b();
  }
  
  public int getLayoutId()
  {
    return 2131624831;
  }
  
  public ViewPager2 getViewPager2()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return this.c.c();
  }
  
  public void setLoadMoreEnable(boolean paramBoolean)
  {
    this.c.setLoadMoreEnable(paramBoolean);
  }
  
  public void setLoadMorePreloadNum(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setOnLoadDataCallback(FSPageTurnContainer.OnLoadDataCallback paramOnLoadDataCallback)
  {
    this.e = paramOnLoadDataCallback;
  }
  
  public void setOnRefreshViewStatusListener(FSPageTurnContainer.OnRefreshLoadViewStatusListener paramOnRefreshLoadViewStatusListener)
  {
    this.g = paramOnRefreshLoadViewStatusListener;
    paramOnRefreshLoadViewStatusListener = this.h;
    if (paramOnRefreshLoadViewStatusListener != null) {
      paramOnRefreshLoadViewStatusListener.setOnRefreshViewStatusListener(this.g);
    }
    paramOnRefreshLoadViewStatusListener = this.i;
    if (paramOnRefreshLoadViewStatusListener != null) {
      paramOnRefreshLoadViewStatusListener.setOnRefreshViewStatusListener(this.g);
    }
  }
  
  public void setOrientationType(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setPreloadLoadMore(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setRefreshEnable(boolean paramBoolean)
  {
    this.c.setRefreshEnable(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.FSPageTurnContainer
 * JD-Core Version:    0.7.0.1
 */