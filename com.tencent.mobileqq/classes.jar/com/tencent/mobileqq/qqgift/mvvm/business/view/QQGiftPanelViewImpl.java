package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewBinder;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewModel;
import com.tencent.mobileqq.qqgift.mvvm.business.SingleEventWrapper;
import com.tencent.mobileqq.qqgift.mvvm.business.data.QQGiftDtParams;
import com.tencent.mobileqq.qqgift.utils.QQGiftFastClickUtil;
import com.tencent.mobileqq.qqgift.utils.QQGiftPopupHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlur.onCalculateLocationListener;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
public class QQGiftPanelViewImpl
  extends LinearLayout
  implements View.OnClickListener, IQQGiftPanelView
{
  private RecyclerView a;
  private QQGiftPanelViewModel b;
  private TextView c;
  private LinearLayout d;
  private int e;
  private int f;
  private View g;
  private final IQQGiftSDK h;
  private QQBlurView i;
  private final AtomicBoolean j = new AtomicBoolean(false);
  private final AtomicBoolean k = new AtomicBoolean(false);
  private int l = 0;
  private PagerSnapHelper m;
  private StaggeredGridLayoutManager n;
  private QQGiftPopupHelper o;
  private LifeCycleAndViewModelStoreOwner p;
  private LinearLayout q;
  private TextView r;
  private int s;
  private LinearLayout t;
  private LinearLayout u;
  private final RecyclerView.OnScrollListener v = new QQGiftPanelViewImpl.1(this);
  private final QQBlur.onCalculateLocationListener w = new QQGiftPanelViewImpl.2(this);
  
  public QQGiftPanelViewImpl(Context paramContext, IQQGiftSDK paramIQQGiftSDK)
  {
    this(paramContext, paramIQQGiftSDK, null);
  }
  
  public QQGiftPanelViewImpl(Context paramContext, IQQGiftSDK paramIQQGiftSDK, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramIQQGiftSDK, paramAttributeSet, 0);
  }
  
  public QQGiftPanelViewImpl(Context paramContext, IQQGiftSDK paramIQQGiftSDK, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.h = paramIQQGiftSDK;
    a(paramContext);
    b(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      View localView = this.m.findSnapView(this.n);
      if (localView != null)
      {
        paramInt = this.n.getPosition(localView);
        b(paramInt);
      }
      else
      {
        paramInt = 0;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onScrollStateChanged] mCurrentPage:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",snapView:");
        localStringBuilder.append(localView);
        QLog.i("QQGiftPanelViewImpl", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131627982, this);
    setOnClickListener(this);
    f();
    this.e = ViewUtils.dip2px(16.0F);
    this.f = ViewUtils.dip2px(4.0F);
  }
  
  private void b(int paramInt)
  {
    if (this.l != paramInt)
    {
      this.l = paramInt;
      View localView = this.g;
      if (localView != null) {
        localView.animate().x(paramInt * this.e).setDuration(300L).start();
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.p = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment((Activity)paramContext);
    this.b = ((QQGiftPanelViewModel)ViewModelProviderHelper.a(this.p, QQGiftPanelViewModel.a).get(QQGiftPanelViewModel.class));
    this.b.a(this.h);
  }
  
  private void b(View paramView)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
    {
      paramView = new StringBuilder();
      paramView.append("[show] already has parent: ");
      paramView.append(localViewParent);
      QLog.i("QQGiftPanelViewImpl", 1, paramView.toString());
      return;
    }
    k();
    this.o = new QQGiftPopupHelper(getContext(), this, -1, -2);
    this.o.a(false);
    this.o.a(paramView);
  }
  
  @TargetApi(19)
  private void c(View paramView)
  {
    this.i = ((QQBlurView)findViewById(2131439803));
    if (this.j.getAndSet(true)) {
      return;
    }
    if (this.i != null)
    {
      paramView.invalidate();
      this.i.a(paramView);
      paramView = this.i;
      paramView.b(paramView);
      this.i.a(8.0F);
      this.i.a(8);
      this.i.a(new ColorDrawable(getResources().getColor(2131167350)));
      this.i.setCalculateLocationListener(this.w);
      this.i.d();
      this.i.a();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("initBlurView called mBlurBgView = ");
        paramView.append(Integer.toHexString(System.identityHashCode(this.i)));
        QLog.d("QQGiftPanelViewImpl", 2, paramView.toString());
      }
    }
  }
  
  private void f()
  {
    this.n = new StaggeredGridLayoutManager(1, 0);
    this.a = ((RecyclerView)findViewById(2131445211));
    this.q = ((LinearLayout)findViewById(2131437447));
    this.c = ((TextView)findViewById(2131448692));
    this.d = ((LinearLayout)findViewById(2131437475));
    this.r = ((TextView)findViewById(2131448425));
    this.t = ((LinearLayout)findViewById(2131437488));
    RoundRelativeLayout localRoundRelativeLayout = (RoundRelativeLayout)findViewById(2131445017);
    localRoundRelativeLayout.d = 3;
    localRoundRelativeLayout.b = ViewUtils.dpToPx(8.0F);
    localRoundRelativeLayout.setVisibility(0);
    localRoundRelativeLayout = (RoundRelativeLayout)findViewById(2131445016);
    localRoundRelativeLayout.d = 3;
    localRoundRelativeLayout.b = ViewUtils.dpToPx(8.0F);
    this.u = ((LinearLayout)findViewById(2131437540));
    this.u.setOnClickListener(this);
    this.a.setHasFixedSize(true);
    this.a.setLayoutManager(this.n);
    this.m = new PagerSnapHelper();
    this.m.attachToRecyclerView(this.a);
  }
  
  private void g()
  {
    QQGiftPanelViewBinder localQQGiftPanelViewBinder = new QQGiftPanelViewBinder();
    localQQGiftPanelViewBinder.a(this.p, this.b, this);
    localQQGiftPanelViewBinder.b(this.p, this.b, this);
  }
  
  private void h()
  {
    if (this.b.d().getValue() != null)
    {
      List localList = (List)((SingleEventWrapper)this.b.d().getValue()).b();
      if ((localList != null) && (localList.size() > 1))
      {
        Object localObject = this.d;
        int i1 = 0;
        ((LinearLayout)localObject).setVisibility(0);
        int i4 = localList.size();
        if (this.s != i4)
        {
          this.s = i4;
          i2 = this.e;
          localObject = this.d.getLayoutParams();
          if (localObject != null)
          {
            ((ViewGroup.LayoutParams)localObject).width = (i2 * i4);
            ((ViewGroup.LayoutParams)localObject).height = this.f;
            this.d.removeAllViews();
            this.g = new View(getContext());
            this.g.setBackgroundDrawable(getResources().getDrawable(2130847989));
            localObject = new ViewGroup.LayoutParams(this.e, -1);
            this.d.addView(this.g, (ViewGroup.LayoutParams)localObject);
          }
        }
        int i3;
        for (int i2 = 0; i1 < i4; i2 = i3)
        {
          localObject = ((List)localList.get(i1)).iterator();
          do
          {
            i3 = i2;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!((GiftServiceData)((Iterator)localObject).next()).i);
          i3 = i1;
          i1 += 1;
        }
        this.a.scrollToPosition(i2);
        b(i2);
        return;
      }
      this.d.setVisibility(4);
    }
  }
  
  private void i()
  {
    VideoReport.setPageId(this, "pg_sgrp_stream_aio");
    Map localMap = this.b.i();
    if (localMap != null) {
      VideoReport.setPageParams(this, new PageParams(localMap));
    }
    VideoReport.reportEvent("pgin", this, null);
  }
  
  private void j()
  {
    VideoReport.setElementId(this.u, "em_yes_gift_panel_recharge");
    VideoReport.setElementClickPolicy(this.u, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(this.u, ExposurePolicy.REPORT_ALL);
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_pgid", "pg_sgrp_stream_aio");
    VideoReport.setElementParams(this.u, localHashMap);
    VideoReport.reportEvent("imp", this.u, null);
  }
  
  private void k()
  {
    try
    {
      i();
      j();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQGiftPanelViewImpl", 1, localException, new Object[0]);
    }
  }
  
  private void l()
  {
    this.b.d().removeObservers(this.p);
    this.b.e().removeObservers(this.p);
  }
  
  public IQQGiftPanelView.OnPanelEventListener a(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    return this.b.b(paramOnPanelEventListener);
  }
  
  public void a()
  {
    h();
  }
  
  public void a(View paramView)
  {
    a(paramView, true);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.a.addOnScrollListener(this.v);
    c(paramView);
    g();
    c();
    if (paramBoolean) {
      b(paramView);
    }
  }
  
  public void a(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.q;
    int i2 = 0;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((LinearLayout)localObject).setVisibility(i1);
    localObject = this.a;
    int i1 = i2;
    if (paramBoolean) {
      i1 = 8;
    }
    ((RecyclerView)localObject).setVisibility(i1);
    if (paramBoolean) {
      this.r.setText(getResources().getString(2131897855));
    }
  }
  
  public void b()
  {
    QQGiftPopupHelper localQQGiftPopupHelper = this.o;
    if (localQQGiftPopupHelper != null) {
      localQQGiftPopupHelper.b();
    }
  }
  
  public void c()
  {
    this.b.a();
  }
  
  public void d()
  {
    QQBlurView localQQBlurView = this.i;
    if (localQQBlurView != null) {
      localQQBlurView.c();
    }
    this.j.set(false);
    this.k.set(false);
    this.l = 0;
    this.a.removeOnScrollListener(this.v);
    this.a.stopScroll();
    l();
    this.b.b();
  }
  
  public void e()
  {
    if (QQGiftFastClickUtil.a("QQGiftPanelViewImpl.rechargeClick")) {
      return;
    }
    this.b.c();
  }
  
  public ViewGroup getContentView()
  {
    return this;
  }
  
  public LinearLayout getListHeaderView()
  {
    return this.t;
  }
  
  public Context getViewContext()
  {
    return getContext();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437540) {
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i1 == 1) || (i1 == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    this.a.setAdapter(paramAdapter);
  }
  
  public void setCacheList(List<GiftServiceData> paramList)
  {
    this.b.b(paramList);
  }
  
  public void setDtPageExtra(Map<String, String> paramMap)
  {
    this.b.a(paramMap);
  }
  
  public void setDtParams(QQGiftDtParams paramQQGiftDtParams) {}
  
  public void setPanelEventListener(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    this.b.a(paramOnPanelEventListener);
  }
  
  public void setSceneData(GiftListData paramGiftListData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPanelViewImpl
 * JD-Core Version:    0.7.0.1
 */