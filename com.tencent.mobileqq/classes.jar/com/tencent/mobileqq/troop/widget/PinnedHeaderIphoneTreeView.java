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
  int jdField_a_of_type_Int = -1;
  public final Rect a;
  public Drawable a;
  public View.OnTouchListener a;
  View jdField_a_of_type_AndroidViewView;
  public boolean a;
  public Drawable b;
  public View b;
  public boolean b;
  public View c;
  
  public PinnedHeaderIphoneTreeView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new PinnedHeaderIphoneTreeView.1(this);
    a();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new PinnedHeaderIphoneTreeView.1(this);
    a();
  }
  
  public PinnedHeaderIphoneTreeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new PinnedHeaderIphoneTreeView.1(this);
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
    int m = getChildCount();
    if (m != 0)
    {
      Object localObject5 = null;
      View localView;
      Object localObject2;
      if (m != 1)
      {
        localView = getChildAt(0);
        localObject2 = getChildAt(1);
      }
      else
      {
        localView = getChildAt(0);
        localObject2 = null;
      }
      this.jdField_a_of_type_Boolean = true;
      int j = getFirstVisiblePosition();
      int i = j;
      if (Build.VERSION.SDK_INT < 8) {
        i = j - getHeaderViewsCount();
      }
      j = 0;
      Object localObject4;
      Object localObject3;
      int k;
      for (;;)
      {
        localObject4 = localView;
        localObject3 = localObject2;
        k = i;
        if (j >= m) {
          break;
        }
        localObject4 = getChildAt(j);
        if (((View)localObject4).getBottom() > 0)
        {
          k = j + 1;
          if (k < m)
          {
            localObject3 = getChildAt(k);
            k = i + j;
            break;
          }
        }
        j += 1;
      }
      long l = getExpandableListPosition(k);
      i = getPackedPositionGroup(l);
      getPackedPositionType(l);
      this.jdField_b_of_type_AndroidViewView = null;
      if ((i != -1) && (isGroupExpanded(i)))
      {
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int != i))
        {
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_AndroidViewView = getExpandableListAdapter().getGroupView(i, true, this.c, this);
          localView = this.jdField_a_of_type_AndroidViewView;
          if (localView != null)
          {
            localView.setSelected(((View)localObject4).isSelected());
            this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          }
        }
        localView = this.jdField_a_of_type_AndroidViewView;
        if (localView != this.c) {
          this.c = localView;
        }
        if (getPackedPositionType(l) == 0) {
          this.jdField_b_of_type_AndroidViewView = ((View)localObject4);
        }
        localView = this.jdField_a_of_type_AndroidViewView;
        if (localView != null)
        {
          a(localView, i, 0, ((View)localObject4).getWidth());
          localView = this.jdField_a_of_type_AndroidViewView;
          localView.layout(0, 0, localView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView = null;
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
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if ((getPackedPositionType(getExpandableListPosition(k + 1)) == 0) && (localObject3 != null))
        {
          i = ((View)localObject3).getTop();
          j = this.jdField_a_of_type_AndroidViewView.getBottom();
          if (i < j)
          {
            i -= j;
            localObject1 = getDivider();
            break label474;
          }
        }
        i = 0;
        Object localObject1 = localObject5;
        label474:
        paramCanvas.translate(0.0F, i);
        if (this.jdField_a_of_type_AndroidViewView.isPressed())
        {
          localObject2 = getSelector();
          ((Drawable)localObject2).setBounds(new Rect(((Drawable)localObject2).getBounds().left, this.jdField_a_of_type_AndroidViewView.getTop(), ((Drawable)localObject2).getBounds().right, this.jdField_a_of_type_AndroidViewView.getBottom()));
          getSelector().draw(paramCanvas);
        }
        paramCanvas.translate(getPaddingLeft(), 0.0F);
        this.jdField_a_of_type_AndroidViewView.draw(paramCanvas);
        paramCanvas.translate(-getPaddingLeft(), 0.0F);
        localObject2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (localObject2 != null)
        {
          if (((Drawable)localObject2).isStateful()) {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(new int[] { 16842920 });
          }
          localObject2 = (Integer)a("mIndicatorLeft");
          localObject3 = (Integer)a("mIndicatorRight");
          localObject4 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          if (localObject2 == null) {
            j = 0;
          } else {
            j = ((Integer)localObject2).intValue();
          }
          m = this.jdField_a_of_type_AndroidViewView.getTop();
          if (localObject3 == null) {
            k = 0;
          } else {
            k = ((Integer)localObject3).intValue();
          }
          ((Drawable)localObject4).setBounds(j, m, k, this.jdField_a_of_type_AndroidViewView.getBottom());
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
    View localView = this.jdField_a_of_type_AndroidViewView;
    boolean bool;
    if (localView != null)
    {
      localView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
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
    catch (Exception paramMotionEvent)
    {
      label73:
      break label73;
    }
    return true;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (paramView != this.jdField_b_of_type_AndroidViewView) {
      return super.drawChild(paramCanvas, paramView, paramLong);
    }
    return true;
  }
  
  public View getChildAt(int paramInt)
  {
    View localView = super.getChildAt(paramInt);
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (localView == this.jdField_b_of_type_AndroidViewView))
      {
        super.setGroupIndicator(null);
        return localView;
      }
      super.setGroupIndicator(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView
 * JD-Core Version:    0.7.0.1
 */