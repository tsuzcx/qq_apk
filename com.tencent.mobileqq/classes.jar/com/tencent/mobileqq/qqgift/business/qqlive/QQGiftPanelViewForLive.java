package com.tencent.mobileqq.qqgift.business.qqlive;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
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
import com.tencent.mobileqq.qqgift.business.dt.QQGiftDtReportHelper;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.SingleEventWrapper;
import com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager;
import com.tencent.mobileqq.qqgift.mvvm.business.data.QQGiftDtParams;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;
import com.tencent.mobileqq.qqgift.utils.QQGiftImageUtil;
import com.tencent.mobileqq.qqgift.utils.QQGiftPopupHelper;
import com.tencent.mobileqq.qqgift.view.QQGiftComboSendView;
import com.tencent.mobileqq.qqgift.view.QQGiftComboSendViewListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlur.onCalculateLocationListener;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
public class QQGiftPanelViewForLive
  extends LinearLayout
  implements View.OnClickListener, IQQGiftPanelView, QQGiftComboSendViewListener
{
  private final RecyclerView.OnScrollListener A = new QQGiftPanelViewForLive.2(this);
  private final QQBlur.onCalculateLocationListener B = new QQGiftPanelViewForLive.3(this);
  private final Observer<Long> C = new QQGiftPanelViewForLive.4(this);
  private boolean D;
  private RecyclerView a;
  private QQGiftPanelViewModelForLive b;
  private View c;
  private TextView d;
  private TextView e;
  private TextView f;
  private LinearLayout g;
  private int h;
  private int i;
  private View j;
  private final IQQGiftSDK k;
  private QQBlurView l;
  private final AtomicBoolean m = new AtomicBoolean(false);
  private int n = 0;
  private PagerSnapHelper o;
  private StaggeredGridLayoutManager p;
  private QQGiftPopupHelper q;
  private LifeCycleAndViewModelStoreOwner r;
  private LinearLayout s;
  private TextView t;
  private int u;
  private LinearLayout v;
  private QQGiftComboSendView w;
  private GiftServiceData x;
  private int y = 0;
  private QQGiftDtReportHelper z;
  
  public QQGiftPanelViewForLive(Context paramContext, IQQGiftSDK paramIQQGiftSDK)
  {
    this(paramContext, paramIQQGiftSDK, null);
  }
  
  public QQGiftPanelViewForLive(Context paramContext, IQQGiftSDK paramIQQGiftSDK, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramIQQGiftSDK, paramAttributeSet, 0);
  }
  
  public QQGiftPanelViewForLive(Context paramContext, IQQGiftSDK paramIQQGiftSDK, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = paramIQQGiftSDK;
    BannerResManager.a(this.k.g()).c();
    a(paramContext);
    b(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131627983, this);
    setOnClickListener(this);
    h();
    this.h = ViewUtils.dip2px(16.0F);
    this.i = ViewUtils.dip2px(2.0F);
  }
  
  private void b(Context paramContext)
  {
    this.r = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment((Activity)paramContext);
    this.b = ((QQGiftPanelViewModelForLive)ViewModelProviderHelper.a(this.r, QQGiftPanelViewModelForLive.c).get(QQGiftPanelViewModelForLive.class));
    this.b.a(this.k);
    this.z = new QQGiftDtReportHelper(this.b);
    this.b.a(this.z);
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
    this.z.a(this, this.e, this.c);
    this.q = new QQGiftPopupHelper(getContext(), this, -1, -2);
    this.q.a(false);
    this.q.a(paramView);
  }
  
  @TargetApi(19)
  private void c(View paramView)
  {
    this.l = ((QQBlurView)findViewById(2131439803));
    if (this.m.getAndSet(true)) {
      return;
    }
    if (this.l != null)
    {
      paramView.invalidate();
      this.l.a(paramView);
      paramView = this.l;
      paramView.b(paramView);
      this.l.a(8.0F);
      this.l.a(8);
      this.l.a(new ColorDrawable(getResources().getColor(2131167350)));
      this.l.setCalculateLocationListener(this.B);
      this.l.d();
      this.l.a();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("initBlurView called mBlurBgView = ");
        paramView.append(Integer.toHexString(System.identityHashCode(this.l)));
        QLog.d("QQGiftPanelViewImpl", 2, paramView.toString());
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 0)
    {
      View localView = this.o.findSnapView(this.p);
      if (localView != null)
      {
        paramInt = this.p.getPosition(localView);
        e(paramInt);
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
  
  private void e(int paramInt)
  {
    if (this.n != paramInt)
    {
      this.n = paramInt;
      View localView = this.j;
      if (localView != null) {
        localView.animate().x(paramInt * this.h).setDuration(300L).start();
      }
    }
  }
  
  private void f(int paramInt)
  {
    if (this.u != paramInt)
    {
      this.u = paramInt;
      int i1 = this.h;
      Object localObject = this.g.getLayoutParams();
      int i2 = ViewUtils.dip2px(3.0F);
      GradientDrawable localGradientDrawable = QQGiftImageUtil.a(0, i2, 0, getResources().getColor(2131167353));
      this.g.setBackgroundDrawable(localGradientDrawable);
      if (localObject != null)
      {
        ((ViewGroup.LayoutParams)localObject).width = (paramInt * i1);
        ((ViewGroup.LayoutParams)localObject).height = this.i;
        this.g.removeAllViews();
        this.j = new ImageView(getContext());
        localObject = QQGiftImageUtil.a(0, i2, 0, getResources().getColor(2131168464));
        this.j.setBackgroundDrawable((Drawable)localObject);
        localObject = new ViewGroup.LayoutParams(this.h, -1);
        this.g.addView(this.j, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void h()
  {
    this.p = new StaggeredGridLayoutManager(1, 0);
    this.a = ((RecyclerView)findViewById(2131445211));
    this.s = ((LinearLayout)findViewById(2131437447));
    this.c = findViewById(2131437540);
    this.d = ((TextView)findViewById(2131448692));
    this.e = ((TextView)findViewById(2131448497));
    this.e.setOnClickListener(new QQGiftPanelViewForLive.1(this, 200));
    this.f = ((TextView)findViewById(2131448498));
    this.g = ((LinearLayout)findViewById(2131437475));
    this.t = ((TextView)findViewById(2131448425));
    this.v = ((LinearLayout)findViewById(2131437488));
    ((LinearLayout)findViewById(2131437540)).setOnClickListener(this);
    this.a.setHasFixedSize(true);
    this.a.setLayoutManager(this.p);
    this.o = new PagerSnapHelper();
    this.o.attachToRecyclerView(this.a);
    this.w = ((QQGiftComboSendView)findViewById(2131431022));
    this.w.a(BannerResManager.a(this.k.g()));
    this.w.setComboListener(this);
    j();
    i();
  }
  
  private void i()
  {
    int i1 = getResources().getColor(2131167359);
    if (this.D) {
      i1 = getResources().getColor(2131167362);
    }
    GradientDrawable localGradientDrawable = QQGiftImageUtil.a(0, ViewUtils.dip2px(15.0F), 0, i1);
    localGradientDrawable.mutate();
    this.e.setBackgroundDrawable(localGradientDrawable);
    localGradientDrawable = QQGiftImageUtil.a(0, ViewUtils.dip2px(15.0F), 0, i1);
    localGradientDrawable.mutate();
    localGradientDrawable.setAlpha(76);
    this.f.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void j()
  {
    RoundRelativeLayout localRoundRelativeLayout = (RoundRelativeLayout)findViewById(2131444919);
    localRoundRelativeLayout.d = 3;
    localRoundRelativeLayout.b = ViewUtils.dpToPx(8.0F);
    localRoundRelativeLayout.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRoundRelativeLayout.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.addRule(6, 2131437488);
      localLayoutParams.addRule(8, 2131437487);
      localRoundRelativeLayout.requestLayout();
    }
    localRoundRelativeLayout = (RoundRelativeLayout)findViewById(2131445016);
    localRoundRelativeLayout.d = 3;
    localRoundRelativeLayout.b = ViewUtils.dpToPx(8.0F);
  }
  
  private void k()
  {
    QQGiftPanelViewBinderForLive localQQGiftPanelViewBinderForLive = new QQGiftPanelViewBinderForLive();
    localQQGiftPanelViewBinderForLive.a(this.r, this.b, this);
    localQQGiftPanelViewBinderForLive.b(this.r, this.b, this);
    localQQGiftPanelViewBinderForLive.a(this.r, this.b, this);
    localQQGiftPanelViewBinderForLive.b(this.r, this.b, this);
  }
  
  private void l()
  {
    if (this.b.d().getValue() != null)
    {
      List localList = (List)((SingleEventWrapper)this.b.d().getValue()).b();
      if ((localList != null) && (localList.size() > 1))
      {
        Object localObject = this.g;
        int i1 = 0;
        ((LinearLayout)localObject).setVisibility(0);
        int i4 = localList.size();
        f(i4);
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
        e(i2);
        return;
      }
      this.g.setVisibility(4);
    }
  }
  
  private void m()
  {
    this.b.d().removeObservers(this.r);
    this.b.e().removeObservers(this.r);
  }
  
  private void n()
  {
    try
    {
      MutableLiveData localMutableLiveData = this.b.g();
      if (localMutableLiveData == null) {
        return;
      }
      if (((Integer)localMutableLiveData.getValue()).intValue() == 1)
      {
        localMutableLiveData.setValue(Integer.valueOf(0));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGiftPanelViewImpl", 1, localThrowable, new Object[0]);
    }
  }
  
  public IQQGiftPanelView.OnPanelEventListener a(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    return this.b.b(paramOnPanelEventListener);
  }
  
  public void a()
  {
    l();
  }
  
  public void a(int paramInt)
  {
    if ((this.y == 1) && (paramInt != 1) && (this.x != null))
    {
      int i1 = this.w.getCurComboNum();
      this.z.a(this.e, this.b.u(), i1);
      this.w.a();
      this.b.a(this.x.a, i1, i1);
    }
    this.y = paramInt;
    if (paramInt == 1)
    {
      this.x = this.b.b;
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.w.setVisibility(0);
      this.w.a(1, this.b.j());
      return;
    }
    if (paramInt == 2)
    {
      this.e.setVisibility(8);
      this.f.setVisibility(0);
      this.w.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    this.w.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b.a(paramInt1, paramInt2);
  }
  
  public void a(View paramView)
  {
    a(paramView, true);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.a.addOnScrollListener(this.A);
    c(paramView);
    k();
    if (paramBoolean) {
      b(paramView);
    }
    c();
  }
  
  public void a(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.s;
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
      this.t.setText(getResources().getString(2131897855));
    }
  }
  
  public void b()
  {
    QQGiftPopupHelper localQQGiftPopupHelper = this.q;
    if (localQQGiftPopupHelper != null) {
      localQQGiftPopupHelper.b();
    }
  }
  
  public void b(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void b(String paramString)
  {
    a(2);
    this.f.setText(paramString);
  }
  
  public void c()
  {
    this.b.a();
    this.b.a.observeForever(this.C);
  }
  
  public void c(int paramInt)
  {
    n();
  }
  
  public void d()
  {
    QQBlurView localQQBlurView = this.l;
    if (localQQBlurView != null) {
      localQQBlurView.c();
    }
    this.m.set(false);
    this.n = 0;
    this.a.removeOnScrollListener(this.A);
    this.a.stopScroll();
    m();
    this.b.b();
    n();
    this.b.a.removeObserver(this.C);
    this.z.b(this, this.e, this.c);
  }
  
  public void e()
  {
    this.b.c();
  }
  
  public void f()
  {
    this.b.q();
  }
  
  public void g()
  {
    n();
  }
  
  public ViewGroup getContentView()
  {
    return this;
  }
  
  public LinearLayout getListHeaderView()
  {
    return this.v;
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
  
  public void setDtParams(QQGiftDtParams paramQQGiftDtParams)
  {
    this.b.a(paramQQGiftDtParams);
  }
  
  public void setIsForBlack(boolean paramBoolean)
  {
    this.D = paramBoolean;
    this.b.a(paramBoolean);
    i();
  }
  
  public void setPanelEventListener(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    this.b.a(paramOnPanelEventListener);
  }
  
  public void setSceneData(GiftListData paramGiftListData)
  {
    this.b.a(paramGiftListData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewForLive
 * JD-Core Version:    0.7.0.1
 */