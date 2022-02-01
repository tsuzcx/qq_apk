package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import com.tencent.qphone.base.util.QLog;

public class PinnedHeadAndFootExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  PinnedHeadAndFootExpandableListView.FooterExpandListViewListener a;
  int b;
  int c;
  Context d = null;
  PinnedHeadAndFootExpandableListView.ExpandableListAdapter e = null;
  View f = null;
  View g = null;
  boolean h = false;
  int i = 0;
  int j = 0;
  int k = -1;
  PinnedHeadAndFootExpandableListView.OnLayoutListener l = null;
  AbsListView.OnScrollListener m = null;
  ExpandableListView.OnGroupClickListener n = null;
  int o = -1;
  boolean p;
  View q;
  boolean r;
  boolean s;
  public int t;
  private boolean u = false;
  
  public PinnedHeadAndFootExpandableListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private View a(View paramView, int paramInt1, int paramInt2)
  {
    if (!(paramView instanceof ViewGroup)) {
      return paramView;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView;
    int i3 = localViewGroup.getChildCount();
    boolean bool = isChildrenDrawingOrderEnabled();
    Object localObject = null;
    int i1 = i3 - 1;
    for (;;)
    {
      paramView = localObject;
      if (i1 < 0) {
        break;
      }
      int i2;
      if (bool) {
        i2 = getChildDrawingOrder(i3, i1);
      } else {
        i2 = i1;
      }
      paramView = localViewGroup.getChildAt(i2);
      if (b(paramView, paramInt1, paramInt2)) {
        break;
      }
      i1 -= 1;
    }
    if (paramView == null) {
      return localViewGroup;
    }
    return paramView;
  }
  
  private void a(int paramInt)
  {
    PinnedHeadAndFootExpandableListView.ExpandableListAdapter localExpandableListAdapter = this.e;
    if ((localExpandableListAdapter != null) && (this.f != null) && (paramInt < localExpandableListAdapter.getGroupCount()))
    {
      this.o = paramInt;
      if (paramInt < 1)
      {
        this.f.setVisibility(8);
        return;
      }
      this.f.setVisibility(0);
      this.e.a(this.f, paramInt);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i1 = ExpandableListView.getPackedPositionType(getExpandableListPosition(paramInt));
    if (i1 != 2)
    {
      if (i1 == 0)
      {
        i1 = paramInt + 1;
        if ((ExpandableListView.getPackedPositionType(getExpandableListPosition(i1)) != 0) && (ExpandableListView.getPackedPositionType(getExpandableListPosition(i1)) != 2)) {
          this.i = 0;
        } else {
          this.i = -1;
        }
      }
      else if (getChildAt(0).getBottom() > this.g.getMeasuredHeight())
      {
        this.i = 0;
      }
      else if (ExpandableListView.getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 0)
      {
        this.i = 1;
      }
      else
      {
        this.i = 0;
      }
    }
    else {
      this.i = -1;
    }
    i1 = this.i;
    if (i1 != -1)
    {
      View localView;
      if (i1 == 1)
      {
        localView = getChildAt(1);
        int i2 = this.g.getMeasuredHeight();
        if (localView != null) {
          i1 = localView.getTop();
        } else {
          i1 = 0;
        }
        this.j = (i2 - i1);
      }
      else
      {
        this.j = 0;
      }
      this.g.setVisibility(0);
      paramInt = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(paramInt));
      if ((paramInt != this.k) || (paramBoolean) || (this.u))
      {
        this.u = false;
        this.k = paramInt;
        this.e.a(this.g, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.g.getMeasuredWidth(), 1073741824);
        i1 = View.MeasureSpec.makeMeasureSpec(this.g.getMeasuredHeight(), 1073741824);
        this.g.measure(paramInt, i1);
        localView = this.g;
        localView.layout(0, 0, localView.getMeasuredWidth(), this.g.getMeasuredHeight());
      }
    }
    else
    {
      if (paramBoolean) {
        this.u = true;
      }
      this.g.setVisibility(4);
    }
  }
  
  private void a(Context paramContext)
  {
    this.d = paramContext;
    super.setOnScrollListener(this);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i1 = 0;
      while (i1 < localViewGroup.getChildCount())
      {
        a(localViewGroup.getChildAt(i1));
        i1 += 1;
      }
    }
    paramView.refreshDrawableState();
  }
  
  private void b()
  {
    setFooterEnable(false);
    PinnedHeadAndFootExpandableListView.FooterExpandListViewListener localFooterExpandListViewListener = this.a;
    if (localFooterExpandListViewListener != null) {
      localFooterExpandListViewListener.a();
    }
  }
  
  private boolean b(View paramView, int paramInt1, int paramInt2)
  {
    return (paramView.isClickable()) && (paramInt2 >= paramView.getTop()) && (paramInt2 <= paramView.getBottom()) && (paramInt1 >= paramView.getLeft()) && (paramInt1 <= paramView.getRight());
  }
  
  protected void a()
  {
    if (this.f == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PinnedHeadAndFootExpandableListView", 2, "mHeaderView null");
      }
      return;
    }
    Object localObject = super.getExpandableListAdapter();
    if (!(localObject instanceof PinnedHeadAndFootExpandableListView.ExpandableListAdapter))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PinnedHeadAndFootExpandableListView", 2, "object null");
      }
      return;
    }
    localObject = (PinnedHeadAndFootExpandableListView.ExpandableListAdapter)localObject;
    int i8 = getFirstVisiblePosition();
    int i4 = getLastVisiblePosition();
    int i7 = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i4));
    int i6 = this.f.getMeasuredHeight();
    int i9 = getHeight();
    int i3 = i9 - i6;
    int i2 = i4 - 2;
    int i5 = i4 - 1;
    int i10 = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i2));
    int i1;
    if (i7 == ((PinnedHeadAndFootExpandableListView.ExpandableListAdapter)localObject).getGroupCount() - 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i2 >= 0) && (i10 != i7))
    {
      if (ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i5)) == i7) {
        i2 = i5;
      } else {
        i2 = i4;
      }
      localObject = getChildAt(i2 - i8);
      if (i9 - ((View)localObject).getTop() >= i6)
      {
        a(i7 + 1);
        i4 = ((View)localObject).getTop() + i6;
        i2 = i4;
        if (i4 < i3) {
          i2 = i3;
        }
        if (i1 != 0)
        {
          this.o = -1;
          localObject = this.f;
          i1 = -i6;
          ((View)localObject).layout(0, i1, this.b, i1);
          return;
        }
        this.f.layout(0, i2, this.b, i6 + i2);
        return;
      }
      a(i7);
      if ((i1 != 0) && (i2 != i4))
      {
        this.o = -1;
        this.f.layout(0, -i6, this.b, -this.c);
        return;
      }
      if (ExpandableListView.getPackedPositionType(getExpandableListPosition(i5)) == 0)
      {
        b();
        this.o = -1;
        this.f.layout(0, -i6, this.b, -this.c);
        return;
      }
      this.f.layout(0, i3, this.b, this.c + i3);
      return;
    }
    if (i1 != 0)
    {
      this.o = -1;
      localObject = this.f;
      i1 = this.c;
      ((View)localObject).layout(0, -i1, this.b, -i1);
    }
    else
    {
      this.f.layout(0, i3, this.b, this.c + i3);
    }
    a(i7 + 1);
  }
  
  public void addHeaderView(View paramView)
  {
    this.t = 1;
    super.addHeaderView(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView = this.g;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.j);
      drawChild(paramCanvas, this.g, getDrawingTime());
      paramCanvas.restore();
    }
    localView = this.f;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.f, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = (int)f1;
    int i2 = (int)f2;
    int i3 = pointToPosition(i1, i2);
    View localView = this.f;
    boolean bool;
    if ((localView != null) && (localView.getVisibility() == 0) && (i2 >= this.f.getTop()) && (i2 <= this.f.getBottom()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.q = a(this.f, i1, i2);
        this.r = true;
        return true;
      }
      if (paramMotionEvent.getAction() == 1)
      {
        paramMotionEvent = a(this.f, i1, i2);
        localView = this.q;
        if ((paramMotionEvent == localView) && (localView.isClickable()))
        {
          this.q.performClick();
          invalidate(new Rect(0, 0, this.b, this.c));
        }
        else if ((this.s) && (ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i3)) != -1))
        {
          bool = this.r;
        }
        this.r = false;
      }
      return true;
    }
    this.q = null;
    if (this.h)
    {
      localView = this.g;
      if ((localView != null) && (localView.dispatchTouchEvent(paramMotionEvent))) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.h = false;
      }
      return bool;
    }
    localView = this.g;
    if ((localView != null) && (f1 >= 0.0F) && (f1 <= localView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.g.getMeasuredHeight() - this.j) && (paramMotionEvent.getAction() == 0) && (this.g.getVisibility() == 0) && (this.g.dispatchTouchEvent(paramMotionEvent)))
    {
      this.h = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    View localView = this.g;
    if (localView != null) {
      a(localView);
    }
    localView = this.f;
    if (localView != null) {
      a(localView);
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.g != null) {
      a(getFirstVisiblePosition(), true);
    }
    PinnedHeadAndFootExpandableListView.OnLayoutListener localOnLayoutListener = this.l;
    if (localOnLayoutListener != null) {
      localOnLayoutListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.g;
    if (localView != null) {
      measureChild(localView, paramInt1, paramInt2);
    }
    localView = this.f;
    if (localView != null)
    {
      measureChild(localView, paramInt1, paramInt2);
      this.b = this.f.getMeasuredWidth();
      this.c = this.f.getMeasuredHeight();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.g != null) {
      a(paramInt1, false);
    }
    if (this.f != null) {
      a();
    }
    AbsListView.OnScrollListener localOnScrollListener = this.m;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.m;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean removeHeaderView(View paramView)
  {
    this.t = 0;
    return super.removeHeaderView(paramView);
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof PinnedHeadAndFootExpandableListView.ExpandableListAdapter))
    {
      this.e = ((PinnedHeadAndFootExpandableListView.ExpandableListAdapter)paramExpandableListAdapter);
      int i1 = this.e.a();
      if (i1 != 0)
      {
        this.g = LayoutInflater.from(this.d).inflate(i1, this, false);
        paramExpandableListAdapter = this.g;
        if (paramExpandableListAdapter != null)
        {
          paramExpandableListAdapter.setTag("headerView");
          this.g.setOnTouchListener(new PinnedHeadAndFootExpandableListView.1(this));
        }
        if ((this.p) && (this.f == null))
        {
          this.f = LayoutInflater.from(this.d).inflate(i1, this, false);
          paramExpandableListAdapter = this.f;
          if (paramExpandableListAdapter != null)
          {
            paramExpandableListAdapter.setTag("footerView");
            this.f.setOnClickListener(new PinnedHeadAndFootExpandableListView.2(this, this));
          }
        }
        requestLayout();
      }
    }
  }
  
  public void setFooterEnable(boolean paramBoolean)
  {
    this.p = paramBoolean;
    View localView = this.f;
    if (localView != null)
    {
      if (this.p)
      {
        localView.setVisibility(0);
        return;
      }
      localView.setVisibility(8);
    }
  }
  
  public void setFooterListener(PinnedHeadAndFootExpandableListView.FooterExpandListViewListener paramFooterExpandListViewListener)
  {
    this.a = paramFooterExpandListViewListener;
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.n = paramOnGroupClickListener;
    super.setOnGroupClickListener(paramOnGroupClickListener);
  }
  
  public void setOnLayoutListener(PinnedHeadAndFootExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.l = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.m = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PinnedHeadAndFootExpandableListView
 * JD-Core Version:    0.7.0.1
 */