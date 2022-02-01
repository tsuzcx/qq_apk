package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.lang.reflect.Field;

public class PinnedHeaderIphoneTreeView
  extends PinnedHeaderExpandableListView
{
  View a;
  public View b;
  public View c;
  int d = -1;
  public Drawable e;
  public Drawable f;
  public final Rect g = new Rect();
  public boolean h;
  public boolean i;
  public View.OnTouchListener j = new PinnedHeaderIphoneTreeView.1(this);
  
  public PinnedHeaderIphoneTreeView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.e = ((Drawable)a("mGroupIndicator"));
    setGroupIndicator(this.e);
  }
  
  public Object a(String paramString)
  {
    try
    {
      paramString = ExpandableListView.class.getDeclaredField(paramString);
      if (!paramString.isAccessible()) {
        paramString.setAccessible(true);
      }
      paramString = paramString.get(this);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2, 0);
      paramView.setLayoutParams(localLayoutParams1);
    }
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, getPaddingLeft() + getPaddingRight(), paramInt3);
    paramInt1 = localLayoutParams1.height;
    if (paramInt1 > 0) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    } else {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(paramInt2, paramInt1);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (getExpandableListAdapter() == null) {
      try
      {
        super.dispatchDraw(paramCanvas);
        return;
      }
      catch (NullPointerException paramCanvas)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PinnedHeaderIphoneTreeView", 2, paramCanvas.getMessage());
        }
        return;
      }
    }
    int i1 = getChildCount();
    if (i1 != 0)
    {
      Object localObject5 = null;
      View localView;
      Object localObject2;
      if (i1 != 1)
      {
        localView = getChildAt(0);
        localObject2 = getChildAt(1);
      }
      else
      {
        localView = getChildAt(0);
        localObject2 = null;
      }
      this.h = true;
      int m = getFirstVisiblePosition();
      int k = m;
      if (Build.VERSION.SDK_INT < 8) {
        k = m - getHeaderViewsCount();
      }
      m = 0;
      Object localObject4;
      Object localObject3;
      int n;
      for (;;)
      {
        localObject4 = localView;
        localObject3 = localObject2;
        n = k;
        if (m >= i1) {
          break;
        }
        localObject4 = getChildAt(m);
        if (((View)localObject4).getBottom() > 0)
        {
          n = m + 1;
          if (n < i1)
          {
            localObject3 = getChildAt(n);
            n = k + m;
            break;
          }
        }
        m += 1;
      }
      long l = getExpandableListPosition(n);
      k = getPackedPositionGroup(l);
      getPackedPositionType(l);
      this.b = null;
      if ((k != -1) && (isGroupExpanded(k)))
      {
        if ((this.a == null) || (this.i) || (this.d != k))
        {
          this.d = k;
          this.a = getExpandableListAdapter().getGroupView(k, true, this.c, this);
          localView = this.a;
          if (localView != null)
          {
            localView.setSelected(((View)localObject4).isSelected());
            this.a.setOnTouchListener(this.j);
          }
        }
        localView = this.a;
        if (localView != this.c) {
          this.c = localView;
        }
        if (getPackedPositionType(l) == 0) {
          this.b = ((View)localObject4);
        }
        localView = this.a;
        if (localView != null)
        {
          a(localView, k, 0, ((View)localObject4).getWidth());
          localView = this.a;
          localView.layout(0, 0, localView.getMeasuredWidth(), this.a.getMeasuredHeight());
        }
      }
      else
      {
        this.a = null;
      }
      try
      {
        super.dispatchDraw(paramCanvas);
      }
      catch (NullPointerException localNullPointerException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PinnedHeaderIphoneTreeView", 2, localNullPointerException.getMessage());
        }
      }
      if (this.a != null)
      {
        if ((getPackedPositionType(getExpandableListPosition(n + 1)) == 0) && (localObject3 != null))
        {
          k = ((View)localObject3).getTop();
          m = this.a.getBottom();
          if (k < m)
          {
            k -= m;
            localObject1 = getDivider();
            break label474;
          }
        }
        k = 0;
        Object localObject1 = localObject5;
        label474:
        paramCanvas.translate(0.0F, k);
        if (this.a.isPressed())
        {
          localObject2 = getSelector();
          ((Drawable)localObject2).setBounds(new Rect(((Drawable)localObject2).getBounds().left, this.a.getTop(), ((Drawable)localObject2).getBounds().right, this.a.getBottom()));
          getSelector().draw(paramCanvas);
        }
        paramCanvas.translate(getPaddingLeft(), 0.0F);
        this.a.draw(paramCanvas);
        paramCanvas.translate(-getPaddingLeft(), 0.0F);
        localObject2 = this.f;
        if (localObject2 != null)
        {
          if (((Drawable)localObject2).isStateful()) {
            this.f.setState(new int[] { 16842920 });
          }
          localObject2 = (Integer)a("mIndicatorLeft");
          localObject3 = (Integer)a("mIndicatorRight");
          localObject4 = this.f;
          if (localObject2 == null) {
            m = 0;
          } else {
            m = ((Integer)localObject2).intValue();
          }
          i1 = this.a.getTop();
          if (localObject3 == null) {
            n = 0;
          } else {
            n = ((Integer)localObject3).intValue();
          }
          ((Drawable)localObject4).setBounds(m, i1, n, this.a.getBottom());
          this.f.draw(paramCanvas);
        }
        if (localObject1 != null)
        {
          ((Drawable)localObject1).setBounds(this.a.getLeft(), this.a.getBottom() - getDividerHeight(), this.a.getRight(), this.a.getBottom());
          paramCanvas.clipRect(this.a.getLeft(), this.a.getBottom() - getDividerHeight() + k, this.a.getRight(), this.a.getBottom() + k);
        }
        paramCanvas.translate(0.0F, -k);
      }
      this.i = false;
      this.h = false;
      return;
    }
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (NullPointerException paramCanvas)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PinnedHeaderIphoneTreeView", 2, paramCanvas.getMessage());
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    View localView = this.a;
    boolean bool;
    if (localView != null)
    {
      localView.getGlobalVisibleRect(this.g);
      if (this.g.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        bool = this.a.dispatchTouchEvent(paramMotionEvent);
        if (bool) {
          return bool;
        }
      }
      else
      {
        this.a.setPressed(false);
        invalidate();
      }
    }
    try
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      label73:
      break label73;
    }
    return true;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (paramView != this.b) {
      return super.drawChild(paramCanvas, paramView, paramLong);
    }
    return true;
  }
  
  public View getChildAt(int paramInt)
  {
    View localView = super.getChildAt(paramInt);
    if (this.h)
    {
      if ((this.a != null) && (localView == this.b))
      {
        super.setGroupIndicator(null);
        return localView;
      }
      super.setGroupIndicator(this.e);
    }
    return localView;
  }
  
  protected boolean isInFilterMode()
  {
    return true;
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.i = true;
  }
  
  public void setGroupIndicator(Drawable paramDrawable)
  {
    super.setGroupIndicator(paramDrawable);
    this.e = paramDrawable;
    if ((paramDrawable != null) && (paramDrawable != this.f)) {
      this.f = paramDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView
 * JD-Core Version:    0.7.0.1
 */