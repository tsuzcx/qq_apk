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
import bgwa;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.lang.reflect.Field;

public class PinnedHeaderIphoneTreeView
  extends PinnedHeaderExpandableListView
{
  public int a;
  public final Rect a;
  public Drawable a;
  public View.OnTouchListener a;
  public View a;
  public boolean a;
  public Drawable b;
  public View b;
  public boolean b;
  public View c;
  
  public PinnedHeaderIphoneTreeView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new bgwa(this);
    a();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new bgwa(this);
    a();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new bgwa(this);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)a("mGroupIndicator"));
    setGroupIndicator(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    if (paramInt1 > 0) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt2, paramInt1);
      return;
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (a() == null) {}
    for (;;)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        return;
      }
      catch (NullPointerException paramCanvas)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PinnedHeaderIphoneTreeView", 2, paramCanvas.getMessage());
        return;
      }
      int m = getChildCount();
      Object localObject3;
      Object localObject1;
      label74:
      int j;
      int i;
      int k;
      label104:
      Object localObject4;
      Object localObject5;
      switch (m)
      {
      default: 
        localObject3 = getChildAt(0);
        localObject1 = getChildAt(1);
        this.jdField_a_of_type_Boolean = true;
        j = getFirstVisiblePosition();
        i = j;
        if (Build.VERSION.SDK_INT < 8) {
          i = j - getHeaderViewsCount();
        }
        k = 0;
        localObject4 = localObject1;
        localObject5 = localObject3;
        j = i;
        if (k < m)
        {
          localObject5 = getChildAt(k);
          if ((((View)localObject5).getBottom() > 0) && (k + 1 < m))
          {
            localObject4 = getChildAt(k + 1);
            j = i + k;
          }
        }
        else
        {
          long l = a(j);
          i = c(l);
          b(l);
          this.jdField_b_of_type_AndroidViewView = null;
          if ((i == -1) || (!c(i))) {
            break label763;
          }
          if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int != i))
          {
            this.jdField_a_of_type_Int = i;
            this.jdField_a_of_type_AndroidViewView = a().getGroupView(i, true, this.c, this);
            this.jdField_a_of_type_AndroidViewView.setSelected(((View)localObject5).isSelected());
            this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
          if (this.jdField_a_of_type_AndroidViewView != this.c) {
            this.c = this.jdField_a_of_type_AndroidViewView;
          }
          if (b(l) == 0) {
            this.jdField_b_of_type_AndroidViewView = ((View)localObject5);
          }
          a(this.jdField_a_of_type_AndroidViewView, i, 0, ((View)localObject5).getWidth());
          this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
        }
        break;
      }
      try
      {
        for (;;)
        {
          super.dispatchDraw(paramCanvas);
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            if ((b(a(j + 1)) != 0) || (localObject4 == null)) {
              break label812;
            }
            i = ((View)localObject4).getTop();
            j = this.jdField_a_of_type_AndroidViewView.getBottom();
            if (i >= j) {
              break label812;
            }
            localObject1 = getDivider();
            i -= j;
            paramCanvas.translate(0.0F, i);
            if (this.jdField_a_of_type_AndroidViewView.isPressed())
            {
              localObject3 = getSelector();
              ((Drawable)localObject3).setBounds(new Rect(((Drawable)localObject3).getBounds().left, this.jdField_a_of_type_AndroidViewView.getTop(), ((Drawable)localObject3).getBounds().right, this.jdField_a_of_type_AndroidViewView.getBottom()));
              getSelector().draw(paramCanvas);
            }
            paramCanvas.translate(getPaddingLeft(), 0.0F);
            this.jdField_a_of_type_AndroidViewView.draw(paramCanvas);
            paramCanvas.translate(-getPaddingLeft(), 0.0F);
            if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
            {
              if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.isStateful()) {
                this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(new int[] { 16842920 });
              }
              localObject3 = (Integer)a("mIndicatorLeft");
              localObject4 = (Integer)a("mIndicatorRight");
              localObject5 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
              if (localObject3 != null) {
                break label793;
              }
              j = 0;
              m = this.jdField_a_of_type_AndroidViewView.getTop();
              if (localObject4 != null) {
                break label802;
              }
              k = 0;
              ((Drawable)localObject5).setBounds(j, m, k, this.jdField_a_of_type_AndroidViewView.getBottom());
              this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
            }
            if (localObject1 != null)
            {
              ((Drawable)localObject1).setBounds(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getBottom() - getDividerHeight(), this.jdField_a_of_type_AndroidViewView.getRight(), this.jdField_a_of_type_AndroidViewView.getBottom());
              paramCanvas.clipRect(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getBottom() - getDividerHeight() + i, this.jdField_a_of_type_AndroidViewView.getRight(), this.jdField_a_of_type_AndroidViewView.getBottom() + i);
            }
            paramCanvas.translate(0.0F, -i);
          }
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Boolean = false;
          return;
          try
          {
            super.dispatchDraw(paramCanvas);
            return;
          }
          catch (NullPointerException paramCanvas) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PinnedHeaderIphoneTreeView", 2, paramCanvas.getMessage());
          return;
          localObject3 = getChildAt(0);
          localObject1 = null;
          break label74;
          k += 1;
          break label104;
          label763:
          this.jdField_a_of_type_AndroidViewView = null;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("PinnedHeaderIphoneTreeView", 2, localNullPointerException.getMessage());
            continue;
            label793:
            j = ((Integer)localObject3).intValue();
            continue;
            label802:
            k = ((Integer)localObject4).intValue();
            continue;
            label812:
            Object localObject2 = null;
            i = 0;
          }
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      if (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        bool = this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent);
        if (bool) {
          return bool;
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        invalidate();
      }
    }
    try
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = true;
    if (paramView != this.jdField_b_of_type_AndroidViewView) {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
    return bool;
  }
  
  public View getChildAt(int paramInt)
  {
    View localView = super.getChildAt(paramInt);
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (localView == this.jdField_b_of_type_AndroidViewView)) {
        super.setGroupIndicator(null);
      }
    }
    else {
      return localView;
    }
    super.setGroupIndicator(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return localView;
  }
  
  public boolean isInFilterMode()
  {
    return true;
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void setGroupIndicator(Drawable paramDrawable)
  {
    super.setGroupIndicator(paramDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if ((paramDrawable != null) && (paramDrawable != this.jdField_b_of_type_AndroidGraphicsDrawableDrawable)) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView
 * JD-Core Version:    0.7.0.1
 */