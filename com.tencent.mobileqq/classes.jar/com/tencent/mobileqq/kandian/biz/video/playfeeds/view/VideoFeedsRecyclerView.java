package com.tencent.mobileqq.kandian.biz.video.playfeeds.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mobileqq.kandian.api.R.styleable;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.video.OrientationDetector;
import com.tencent.mobileqq.kandian.biz.video.OrientationDetector.OnOrientationChangedListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.PagerSnapHelper;
import com.tencent.widget.pull2refresh.PagerSnapHelper.PagerEventListener;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoFeedsRecyclerView
  extends RecyclerViewWithHeaderFooter
  implements OrientationDetector.OnOrientationChangedListener, PagerSnapHelper.PagerEventListener
{
  private static int a;
  private static int b;
  private long c;
  private float d;
  private int e;
  private boolean f = false;
  private boolean g = true;
  private boolean h = false;
  private int i = -1;
  private boolean j = false;
  private boolean k = true;
  private boolean l;
  private boolean m = true;
  private boolean n = true;
  private int o;
  private int p;
  private float q;
  private boolean r = true;
  private int s = 0;
  private View t;
  private View u;
  private RecyclerView.ViewHolder v;
  private PagerSnapHelper w;
  private OrientationDetector x;
  private List<ListEventListener> y;
  private RecyclerView.OnScrollListener z = new VideoFeedsRecyclerView.1(this);
  
  public VideoFeedsRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cO, paramInt, 0);
    this.o = paramContext.getInt(R.styleable.cP, 0);
    this.p = paramContext.getDimensionPixelSize(R.styleable.cQ, 0);
    this.q = paramContext.getFloat(R.styleable.cR, 25.0F);
    paramContext.recycle();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (!this.h) {
      return;
    }
    if (!this.f)
    {
      if (this.v == null) {
        return;
      }
      this.h = false;
      Object localObject = this.x;
      if ((localObject != null) && (this.k))
      {
        localObject = ((OrientationDetector)localObject).a();
        if ((localObject instanceof Activity)) {
          ((Activity)localObject).setRequestedOrientation(1);
        }
      }
      localObject = this.y;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ListEventListener)((Iterator)localObject).next()).a(this.v, false);
        }
      }
      if (paramBoolean)
      {
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(500L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        startAnimation((Animation)localObject);
      }
    }
  }
  
  private void b(int paramInt)
  {
    View localView = this.t;
    if (localView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localLayoutParams.width = -1;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (this.h) {
      return;
    }
    if (!this.f)
    {
      if (this.v == null) {
        return;
      }
      this.h = true;
      Object localObject = this.x;
      if ((localObject != null) && (this.k)) {
        if (paramInt == 0)
        {
          localObject = ((OrientationDetector)localObject).a();
          if ((localObject instanceof Activity)) {
            ((Activity)localObject).setRequestedOrientation(0);
          }
        }
        else
        {
          localObject = ((OrientationDetector)localObject).a();
          if ((localObject instanceof Activity)) {
            ((Activity)localObject).setRequestedOrientation(8);
          }
        }
      }
      localObject = this.y;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ListEventListener)((Iterator)localObject).next()).a(this.v, true);
        }
      }
      if (paramBoolean)
      {
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(500L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        startAnimation((Animation)localObject);
      }
    }
  }
  
  private void i()
  {
    addOnScrollListener(this.z);
    k();
    setOverScrollMode(2);
    setItemAnimator(null);
    setHasFixedSize(true);
    setItemViewCacheSize(0);
    setClipChildren(false);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    a = super.getMinFlingVelocity() * 3;
    b = super.getMinFlingVelocity() * 3;
  }
  
  private void j()
  {
    this.w = new PagerSnapHelper(this.o, this.q);
    this.w.f(this.p);
    this.w.d(this.e + 1);
    this.w.e(1);
    this.w.a(this);
    this.w.a(this);
    if (Build.VERSION.SDK_INT >= 23) {
      this.w.a(true);
    }
    addOnLayoutChangeListener(new VideoFeedsRecyclerView.2(this));
  }
  
  private void k()
  {
    View localView = new View(getContext());
    localView.setId(2131444258);
    localView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
    this.t = localView;
    addHeaderView(localView);
    localView = new View(getContext());
    localView.setId(2131444257);
    localView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
    this.u = localView;
    addFooterView(localView);
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeFullScreenStatus: mIsShowingFull=");
      localStringBuilder.append(this.h);
      QLog.d("VideoFeedsRecyclerView", 2, localStringBuilder.toString());
    }
    if (this.h)
    {
      a(true);
      return;
    }
    b(true);
  }
  
  public void a(int paramInt)
  {
    if ((!this.f) && (this.j))
    {
      if (this.v == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onOrientationChanged: requestOrientation=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", userOrientation=");
        localStringBuilder.append(this.i);
        QLog.d("VideoFeedsRecyclerView", 2, localStringBuilder.toString());
      }
      int i1 = this.i;
      if ((i1 != -1) && (i1 != paramInt)) {
        return;
      }
      this.i = -1;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 8)
          {
            if (paramInt != 9) {
              return;
            }
            a(paramInt, true);
            return;
          }
          b(paramInt, true);
          return;
        }
        a(paramInt, true);
        return;
      }
      b(paramInt, true);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.v = paramViewHolder;
    if (this.y != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPagerChanged: pagerSnapOnCenterViewChanged position=");
        ((StringBuilder)localObject).append(paramViewHolder.getLayoutPosition());
        ((StringBuilder)localObject).append(", this=");
        ((StringBuilder)localObject).append(this);
        QLog.d("VideoFeedsRecyclerView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.y.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ListEventListener)((Iterator)localObject).next()).a(paramViewHolder);
      }
    }
  }
  
  public void a(ListEventListener paramListEventListener)
  {
    if (this.y == null) {
      this.y = new ArrayList();
    }
    this.y.add(paramListEventListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "user exitFullScreen: ");
    }
    this.i = 1;
    a(1, paramBoolean);
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.y != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPagerIdle: pagerSnapOnCenterViewChanged position=");
        ((StringBuilder)localObject).append(paramViewHolder.getLayoutPosition());
        ((StringBuilder)localObject).append(", this=");
        ((StringBuilder)localObject).append(this);
        QLog.d("VideoFeedsRecyclerView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.y.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ListEventListener)((Iterator)localObject).next()).b(paramViewHolder);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "user enterFullScreen: ");
    }
    this.i = 0;
    b(0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.w.d();
  }
  
  public boolean c()
  {
    return this.w.e();
  }
  
  public void d()
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ListEventListener)((Iterator)localObject).next()).o();
      }
    }
  }
  
  public void e()
  {
    addOnLayoutChangeListener(new VideoFeedsRecyclerView.3(this));
  }
  
  public View f()
  {
    if ((getLayoutManager() instanceof LinearLayoutManager)) {
      return this.w.a((LinearLayoutManager)getLayoutManager());
    }
    return null;
  }
  
  public boolean g()
  {
    return this.f;
  }
  
  public int getBaseLine()
  {
    return this.w.h();
  }
  
  public RecyclerView.ViewHolder getCenterVH()
  {
    return this.v;
  }
  
  public int getCurrentAdpaterPosition()
  {
    return this.w.i() - 1;
  }
  
  public int getCurrentLayoutPosition()
  {
    return this.w.i();
  }
  
  public int getFooterViewsCount()
  {
    return super.getFooterViewsCount() + this.e;
  }
  
  public long getLastActionDownTimeStamp()
  {
    return this.c;
  }
  
  public List<ListEventListener> getListeners()
  {
    return this.y;
  }
  
  public int getMinFlingVelocity()
  {
    if (getLayoutManager().canScrollVertically()) {
      return a;
    }
    return b;
  }
  
  public void h()
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.y = null;
    }
    localObject = this.x;
    if (localObject != null) {
      ((OrientationDetector)localObject).b();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.c = System.currentTimeMillis();
    if (this.w.j()) {
      return false;
    }
    if (this.h) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.d = paramMotionEvent.getY();
      this.l = false;
    }
    if ((paramMotionEvent.getAction() == 2) && (!this.l) && (this.v != null))
    {
      int i1 = DisplayUtil.a(getContext(), 25.0F);
      int i2 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if (Math.abs(this.d - paramMotionEvent.getY()) > i2)
      {
        float f1 = this.d;
        float f2 = i1;
        if ((f1 < f2) || (Math.abs(getHeight() - this.d) < f2))
        {
          this.l = true;
          return false;
        }
      }
    }
    if (!this.g) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.w.j()) {
      return true;
    }
    if (this.h) {
      return false;
    }
    if (this.l) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void scrollToPosition(int paramInt)
  {
    super.scrollToPosition(getHeaderViewsCount() + paramInt);
    this.w.g();
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    RecyclerView.Adapter localAdapter = getAdapter();
    super.setAdapter(paramAdapter);
    if ((localAdapter != getAdapter()) && (getAdapter() != null) && (getLayoutManager() != null)) {
      j();
    }
  }
  
  public void setEnableFooterView(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setEnableHeaderView(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setExtraFooterCount(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setHeaderHeight(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    super.setLayoutManager(paramLayoutManager);
    if ((localLayoutManager != getLayoutManager()) && (getLayoutManager() != null) && (getAdapter() != null)) {
      j();
    }
  }
  
  public void setNeedDetectOrientation(Activity paramActivity, boolean paramBoolean)
  {
    this.j = paramBoolean;
    if ((this.j) && (this.x == null)) {
      this.x = new OrientationDetector(paramActivity, this);
    }
  }
  
  public void setNeedDetectOrientation(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.k = paramBoolean2;
    setNeedDetectOrientation(paramActivity, paramBoolean1);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setSnapOffset(int paramInt)
  {
    this.p = paramInt;
    PagerSnapHelper localPagerSnapHelper = this.w;
    if (localPagerSnapHelper != null) {
      localPagerSnapHelper.f(paramInt);
    }
  }
  
  public void setSnapOnFling(boolean paramBoolean)
  {
    this.r = paramBoolean;
    this.w.c(paramBoolean);
  }
  
  public void setSnapOnIdle(boolean paramBoolean)
  {
    this.w.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView
 * JD-Core Version:    0.7.0.1
 */