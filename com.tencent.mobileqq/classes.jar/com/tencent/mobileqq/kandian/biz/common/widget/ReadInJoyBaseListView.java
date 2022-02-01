package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.api.R.styleable;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ReadInJoyBaseListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  protected TextView a;
  protected ProgressBar b;
  protected RelativeLayout c;
  protected int d;
  protected int e = 0;
  public int f = 0;
  protected ReadInJoyBaseListView.RefreshCallback g;
  protected boolean h = false;
  protected int i;
  public boolean j;
  ReadInJoyBaseListView.MultiScrollListener k = new ReadInJoyBaseListView.MultiScrollListener();
  protected boolean l = false;
  private boolean m;
  private ReadInJoyBaseListView.OnDrawCompleteListener n;
  private ReadInJoyBaseListView.ScrollEventCallback o = null;
  private ArrayList<ListView.OnScrollChangeListener> p = new ArrayList();
  private View q;
  
  public ReadInJoyBaseListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void b(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.c;
    if (localRelativeLayout != null) {
      localRelativeLayout.setPadding(localRelativeLayout.getPaddingLeft(), 0, this.c.getPaddingRight(), paramInt);
    }
  }
  
  private void c()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, RIJStringUtils.a(62.0F, getResources())));
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131915401);
    localTextView.setTextColor(-4473925);
    localTextView.setTextSize(14.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(0, 12, 0, 12);
    localTextView.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(localTextView);
    this.q = localRelativeLayout;
  }
  
  private boolean d()
  {
    ListAdapter localListAdapter = getAdapter();
    boolean bool = false;
    if (localListAdapter == null) {
      return false;
    }
    if (getFooterViewsCount() <= 0) {
      return false;
    }
    if (getLastVisiblePosition() == getAdapter().getCount() - 1) {
      bool = true;
    }
    return bool;
  }
  
  protected void a()
  {
    this.c = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131626438, this, false));
    this.b = ((ProgressBar)this.c.findViewById(2131440882));
    this.a = ((TextView)this.c.findViewById(2131440883));
    addFooterView(this.c);
  }
  
  protected void a(int paramInt)
  {
    if (this.l) {
      return;
    }
    if (paramInt != 4)
    {
      if ((d()) && (this.g != null))
      {
        this.c.setVisibility(0);
        this.a.setText(2131897925);
        this.b.setVisibility(0);
        b(0);
        this.f = 1;
        this.g.b(this, paramInt);
      }
    }
    else
    {
      if (d())
      {
        this.c.setVisibility(0);
        this.a.setText(2131897925);
        this.b.setVisibility(0);
        b(0);
      }
      ReadInJoyBaseListView.RefreshCallback localRefreshCallback = this.g;
      if (localRefreshCallback != null)
      {
        this.f = 1;
        localRefreshCallback.b(this, paramInt);
      }
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.bk);
    this.m = paramContext.getBoolean(R.styleable.bl, false);
    paramContext.recycle();
    if (this.m) {
      a();
    }
    if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.i)) {
      c();
    }
    super.setOnScrollListener(this.k);
    a(this);
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    ReadInJoyBaseListView.MultiScrollListener localMultiScrollListener = this.k;
    if (localMultiScrollListener != null) {
      localMultiScrollListener.a(paramOnScrollListener);
    }
  }
  
  public void a(ListView.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.p.add(paramOnScrollChangeListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMoreComplete(): hasMoreData=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ReadInJoyBaseListView", 2, localStringBuilder.toString());
    }
    this.f = 0;
    if (this.c != null)
    {
      this.e = 0;
      this.a.setText(2131897924);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      b(-this.d);
    }
    setFooterView(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseListView", 2, new Object[] { "loadingMoreComplete mCurrentStatus = ", Integer.valueOf(this.f), ", hasMoreData = ", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void b()
  {
    ReadInJoyBaseListView.MultiScrollListener localMultiScrollListener = this.k;
    if (localMultiScrollListener != null) {
      localMultiScrollListener.a();
    }
  }
  
  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    ReadInJoyBaseListView.MultiScrollListener localMultiScrollListener = this.k;
    if (localMultiScrollListener != null) {
      localMultiScrollListener.b(paramOnScrollListener);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    paramCanvas = this.n;
    if (paramCanvas != null)
    {
      paramCanvas.a(this);
      paramCanvas = this.o;
      if (paramCanvas != null) {
        paramCanvas.a();
      }
    }
  }
  
  public int getChennelId()
  {
    return this.i;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.d < 0))
    {
      RelativeLayout localRelativeLayout = this.c;
      if (localRelativeLayout != null)
      {
        this.d = localRelativeLayout.getHeight();
        b(-this.d);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.c != null) && (this.e < 0) && (this.f != 1) && (paramInt1 >= paramInt3 - paramInt2) && ((!((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.i)) || (!this.j))) {
      a(2);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext()) {
      ((ListView.OnScrollChangeListener)localIterator.next()).onScrollChanged(this.mFirstPosition, getChildCount(), this.mItemCount);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1) {
      if (paramInt == 2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.h = bool1;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof IReadInJoyBaseAdapter))) {
      ((IReadInJoyBaseAdapter)paramListAdapter).a(new ReadInJoyBaseListView.1(this));
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setCurrentStatus(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (paramBoolean)
    {
      if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.i))
      {
        if (this.q == null) {
          c();
        }
        removeFooterView(this.q);
      }
      if (this.c == null) {
        a();
      }
      if (getFooterViewsCount() <= 0) {
        addFooterView(this.c);
      }
    }
    else
    {
      if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.i))
      {
        removeFooterView(this.c);
        if (this.q == null) {
          c();
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.q);
        }
      }
      if (this.c == null) {
        a();
      }
      if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab())
      {
        int i1 = this.i;
        if ((i1 == 0) || (i1 == 56))
        {
          QLog.d("ReadInJoyBaseListView", 1, "independent kd recommend and video channel, keep footer view.");
          return;
        }
      }
      if (getFooterViewsCount() > 0) {
        removeFooterView(this.c);
      }
    }
  }
  
  public void setNeedShowFootView(boolean paramBoolean)
  {
    this.m = paramBoolean;
    a();
  }
  
  public void setNoMoreData(boolean paramBoolean)
  {
    if (paramBoolean != this.j)
    {
      this.j = paramBoolean;
      Object localObject;
      if (this.j)
      {
        if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.i))
        {
          if (this.q == null) {
            c();
          }
          localObject = this.c;
          if (localObject != null) {
            removeFooterView((View)localObject);
          }
          if (getFooterViewsCount() <= 0) {
            addFooterView(this.q);
          }
        }
      }
      else
      {
        localObject = this.q;
        if (localObject != null) {
          removeFooterView((View)localObject);
        }
      }
    }
  }
  
  public void setOnDrawCompleteListener(ReadInJoyBaseListView.OnDrawCompleteListener paramOnDrawCompleteListener)
  {
    this.n = paramOnDrawCompleteListener;
  }
  
  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    throw new RuntimeException("use addScrollListener  or removeScrollListener，better call addScrollListener in ReadInJoyBaseAdapter.onAddScrollListeners for control the call sequence");
  }
  
  public void setRefreshCallback(ReadInJoyBaseListView.RefreshCallback paramRefreshCallback)
  {
    this.g = paramRefreshCallback;
  }
  
  public void setScrollEventCallback(ReadInJoyBaseListView.ScrollEventCallback paramScrollEventCallback)
  {
    this.o = paramScrollEventCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView
 * JD-Core Version:    0.7.0.1
 */