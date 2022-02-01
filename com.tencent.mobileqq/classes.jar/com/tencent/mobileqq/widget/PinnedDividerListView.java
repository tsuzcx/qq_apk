package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.LinkedList;

public class PinnedDividerListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  private Context a = null;
  private PinnedDividerListView.DividerAdapter b = null;
  private View c = null;
  private int d = 0;
  private int e = 0;
  private AbsListView.OnScrollListener f = null;
  private LinkedList<View> g = new LinkedList();
  private PinnedDividerListView.OnLayoutListener h = null;
  
  public PinnedDividerListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PinnedDividerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PinnedDividerListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    super.setOnScrollListener(this);
  }
  
  public void addHeaderView(View paramView)
  {
    addHeaderView(paramView, null, false);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addHeaderView(paramView, paramObject, paramBoolean);
    this.g.add(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView = this.c;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.c, getDrawingTime());
    }
  }
  
  protected PinnedDividerListView.DividerAdapter getDividerAdapter()
  {
    return this.b;
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c != null)
    {
      i = getFirstVisiblePosition() - this.g.size();
      if ((i >= 0) && (!this.b.b(this.c, i)))
      {
        this.c.setVisibility(0);
        localObject = this.c;
        ((View)localObject).layout(0, -this.e, ((View)localObject).getMeasuredWidth(), this.c.getMeasuredHeight() - this.e);
        this.b.a(this.c, i);
      }
      else
      {
        this.c.setVisibility(4);
      }
    }
    int k = getChildCount();
    int i = this.g.size();
    for (;;)
    {
      int j = i + 1;
      if (j >= k) {
        break;
      }
      localObject = getChildAt(j);
      i = j;
      if (((View)localObject).getVisibility() != 0)
      {
        ((View)localObject).setVisibility(0);
        i = j;
      }
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((PinnedDividerListView.OnLayoutListener)localObject).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.c;
    if (localView != null) {
      measureChild(localView, paramInt1, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (this.c != null)
    {
      int j;
      if ((paramInt1 >= this.g.size()) && (!this.b.b(this.c, paramInt1 - this.g.size())))
      {
        j = paramInt1 - this.g.size();
        this.b.a(this.c, j);
        if (this.b.a(j))
        {
          this.d = 0;
          paramInt1 = 1;
        }
        else
        {
          localObject = getChildAt(0);
          if ((localObject != null) && (((View)localObject).getBottom() > this.c.getMeasuredHeight())) {
            this.d = 0;
          } else if (this.b.a(j + 1)) {
            this.d = 1;
          } else {
            this.d = 0;
          }
          paramInt1 = 0;
        }
        int k = getChildCount();
        i = paramInt1;
        if (paramInt1 != 0)
        {
          localObject = getChildAt(0);
          i = paramInt1;
          if (localObject != null)
          {
            i = paramInt1;
            if (((View)localObject).getVisibility() != 4)
            {
              ((View)localObject).setVisibility(4);
              i = paramInt1;
            }
          }
        }
        while (i < k)
        {
          localObject = getChildAt(i);
          if (((View)localObject).getVisibility() != 0) {
            ((View)localObject).setVisibility(0);
          }
          i += 1;
        }
        if (this.d == 1)
        {
          localObject = getChildAt(1);
          i = this.c.getMeasuredHeight();
          if (localObject != null) {
            paramInt1 = ((View)localObject).getTop();
          } else {
            paramInt1 = 0;
          }
          this.e = (i - paramInt1);
        }
        else
        {
          this.e = 0;
        }
        this.c.setVisibility(0);
        localObject = this.c;
        ((View)localObject).layout(0, -this.e, ((View)localObject).getMeasuredWidth(), this.c.getMeasuredHeight() - this.e);
        i = j;
      }
      else
      {
        this.d = -1;
        this.c.setVisibility(4);
        j = this.g.size();
        i = paramInt1;
        if (this.b.getCount() > 0)
        {
          i = paramInt1;
          if (this.b.a(0))
          {
            i = paramInt1;
            if (j >= paramInt1)
            {
              i = paramInt1;
              if (j < paramInt1 + paramInt2)
              {
                getChildAt(j - paramInt1).setVisibility(0);
                i = paramInt1;
              }
            }
          }
        }
      }
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScroll(paramAbsListView, i, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.f;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean removeHeaderView(View paramView)
  {
    boolean bool = super.removeHeaderView(paramView);
    if (bool) {
      this.g.remove(paramView);
    }
    return bool;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof PinnedDividerListView.DividerAdapter))
    {
      this.b = ((PinnedDividerListView.DividerAdapter)paramListAdapter);
      int i = this.b.a();
      if (i != 0)
      {
        this.c = LayoutInflater.from(this.a).inflate(i, this, false);
        requestLayout();
      }
      super.setAdapter(this.b);
      return;
    }
    this.b = null;
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnLayoutListener(PinnedDividerListView.OnLayoutListener paramOnLayoutListener)
  {
    this.h = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.f = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PinnedDividerListView
 * JD-Core Version:    0.7.0.1
 */