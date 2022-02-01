package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.util.BitmapUtil;
import com.tencent.widget.ListView;

public class DraggableGridView
  extends FrameLayout
{
  private static int jdField_a_of_type_Int;
  private float jdField_a_of_type_Float = 0.0F;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private Handler jdField_a_of_type_AndroidOsHandler = new DraggableGridView.3(this, Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseDraggableGridViewAdapter jdField_a_of_type_ComTencentMobileqqWidgetBaseDraggableGridViewAdapter;
  private DraggableGridView.GridListViewAdapter jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$GridListViewAdapter;
  private DraggableGridView.OnGridItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$OnGridItemClickListener;
  private DraggableGridView.OnGridItemLongClickListener jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$OnGridItemLongClickListener;
  private DraggableGridView.ScrollThread jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 2;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int e = 0;
  
  public DraggableGridView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public DraggableGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private Point a(Point paramPoint)
  {
    if ((paramPoint.x == 0) && (paramPoint.y == 0)) {
      return null;
    }
    if (paramPoint.x == 0) {
      return new Point(this.jdField_a_of_type_ComTencentMobileqqWidgetBaseDraggableGridViewAdapter.a(paramPoint.y - 1) - 1, paramPoint.y - 1);
    }
    return new Point(paramPoint.x - 1, paramPoint.y);
  }
  
  private MeasureGridView a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      if ((localView.getTag() != null) && ((localView.getTag() instanceof Integer)) && (((Integer)localView.getTag()).intValue() == paramInt) && ((localView instanceof GridView))) {
        return (MeasureGridView)localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(Point paramPoint, boolean paramBoolean)
  {
    MeasureGridView localMeasureGridView = a(paramPoint.y);
    if (localMeasureGridView != null)
    {
      if (localMeasureGridView.getChildAt(paramPoint.x) == null) {
        return;
      }
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
      DraggableGridView.MovoAnimationListener localMovoAnimationListener = new DraggableGridView.MovoAnimationListener(this, this.jdField_b_of_type_AndroidGraphicsPoint, paramPoint, paramBoolean);
      View localView;
      Point localPoint;
      if (paramPoint.y == this.jdField_b_of_type_AndroidGraphicsPoint.y)
      {
        if (paramPoint.x > this.jdField_b_of_type_AndroidGraphicsPoint.x)
        {
          i = this.jdField_b_of_type_AndroidGraphicsPoint.x;
          for (;;)
          {
            i += 1;
            if (i > paramPoint.x) {
              break;
            }
            localView = localMeasureGridView.getChildAt(i);
            localPoint = new Point(i, paramPoint.y);
            a(localView, localPoint, a(localPoint), localMovoAnimationListener);
          }
        }
        i = this.jdField_b_of_type_AndroidGraphicsPoint.x - 1;
        while (i >= paramPoint.x)
        {
          localView = localMeasureGridView.getChildAt(i);
          localPoint = new Point(i, paramPoint.y);
          a(localView, localPoint, b(localPoint), localMovoAnimationListener);
          i -= 1;
        }
      }
      int k;
      int j;
      if (paramPoint.y > this.jdField_b_of_type_AndroidGraphicsPoint.y)
      {
        localMeasureGridView = a(this.jdField_b_of_type_AndroidGraphicsPoint.y);
        if (localMeasureGridView == null) {
          return;
        }
        i = this.jdField_b_of_type_AndroidGraphicsPoint.x;
        for (;;)
        {
          i += 1;
          if (i >= this.jdField_a_of_type_ComTencentMobileqqWidgetBaseDraggableGridViewAdapter.a(this.jdField_b_of_type_AndroidGraphicsPoint.y)) {
            break;
          }
          localView = localMeasureGridView.getChildAt(i);
          localPoint = new Point(i, this.jdField_b_of_type_AndroidGraphicsPoint.y);
          a(localView, localPoint, a(localPoint), localMovoAnimationListener);
        }
        for (i = this.jdField_b_of_type_AndroidGraphicsPoint.y;; i = k)
        {
          k = i + 1;
          if (k > paramPoint.y) {
            break;
          }
          localMeasureGridView = a(k);
          if (localMeasureGridView != null)
          {
            if (k == paramPoint.y) {
              i = paramPoint.x + 1;
            } else {
              i = localMeasureGridView.getAdapter().getCount();
            }
            j = 0;
            while (j < i)
            {
              localView = localMeasureGridView.getChildAt(j);
              localPoint = new Point(j, k);
              a(localView, localPoint, a(localPoint), localMovoAnimationListener);
              j += 1;
            }
          }
        }
      }
      localMeasureGridView = a(this.jdField_b_of_type_AndroidGraphicsPoint.y);
      if (localMeasureGridView == null) {
        return;
      }
      int i = this.jdField_b_of_type_AndroidGraphicsPoint.x - 1;
      while (i >= 0)
      {
        localView = localMeasureGridView.getChildAt(i);
        localPoint = new Point(i, this.jdField_b_of_type_AndroidGraphicsPoint.y);
        a(localView, localPoint, b(localPoint), localMovoAnimationListener);
        i -= 1;
      }
      i = this.jdField_b_of_type_AndroidGraphicsPoint.y - 1;
      while (i >= paramPoint.y)
      {
        localMeasureGridView = a(i);
        if (localMeasureGridView != null)
        {
          if (i == paramPoint.y) {
            j = paramPoint.x;
          } else {
            j = 0;
          }
          k = localMeasureGridView.getAdapter().getCount() - 1;
          while (k >= j)
          {
            localView = localMeasureGridView.getChildAt(k);
            localPoint = new Point(k, paramPoint.y);
            a(localView, localPoint, b(localPoint), localMovoAnimationListener);
            k -= 1;
          }
        }
        i -= 1;
      }
      this.jdField_b_of_type_AndroidGraphicsPoint.set(paramPoint.x, paramPoint.y);
    }
  }
  
  private void a(View paramView, Point paramPoint1, Point paramPoint2, DraggableGridView.MovoAnimationListener paramMovoAnimationListener)
  {
    if (paramPoint2 == null) {
      return;
    }
    paramPoint1 = a(paramPoint1.y, paramPoint1.x);
    paramPoint2 = a(paramPoint2.y, paramPoint2.x);
    if (paramPoint1 != null)
    {
      if (paramPoint2 == null) {
        return;
      }
      int i = paramPoint2.getLeft();
      int j = paramPoint1.getLeft();
      int k = ((View)paramPoint2.getParent()).getLeft();
      int m = ((View)paramPoint1.getParent()).getLeft();
      int n = paramPoint2.getTop();
      int i1 = paramPoint1.getTop();
      int i2 = ((View)paramPoint2.getParent()).getTop();
      int i3 = ((View)paramPoint1.getParent()).getTop();
      paramPoint1 = new TranslateAnimation(0, 0.0F, 0, i - j + k - m, 0, 0.0F, 0, n - i1 + i2 - i3);
      paramPoint1.setDuration(300L);
      paramPoint1.setAnimationListener(paramMovoAnimationListener);
      DraggableGridView.MovoAnimationListener.a(paramMovoAnimationListener);
      paramView.startAnimation(paramPoint1);
    }
  }
  
  private Point b(Point paramPoint)
  {
    if ((paramPoint.x == this.jdField_a_of_type_ComTencentMobileqqWidgetBaseDraggableGridViewAdapter.a(paramPoint.y) - 1) && (paramPoint.y == this.jdField_a_of_type_ComTencentMobileqqWidgetBaseDraggableGridViewAdapter.a() - 1)) {
      return null;
    }
    if (paramPoint.x == this.jdField_a_of_type_ComTencentMobileqqWidgetBaseDraggableGridViewAdapter.a(paramPoint.y) - 1) {
      return new Point(0, paramPoint.y + 1);
    }
    return new Point(paramPoint.x + 1, paramPoint.y);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = new DraggableGridView.2(this, getContext());
    this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetListView.setScrollbarFadingEnabled(false);
    addView(this.jdField_a_of_type_ComTencentWidgetListView, new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread = new DraggableGridView.ScrollThread(this);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Object localObject = a(this.jdField_a_of_type_ComTencentWidgetListView.pointToPosition(paramInt1, paramInt2) / 2);
    if ((localObject instanceof MeasureGridView))
    {
      localObject = (GridView)localObject;
      int j = ((GridView)localObject).getLeft();
      int i = ((GridView)localObject).getTop();
      paramInt1 = (paramInt1 - j) / (((GridView)localObject).getWidth() / this.jdField_b_of_type_Int);
      j = ((GridView)localObject).getHeight();
      double d1 = ((GridView)localObject).getCount();
      double d2 = this.jdField_b_of_type_Int;
      Double.isNaN(d1);
      Double.isNaN(d2);
      localObject = new Point((paramInt2 - i) / (j / (int)Math.ceil(d1 / d2)) * this.jdField_b_of_type_Int + paramInt1, ((Integer)((GridView)localObject).getTag()).intValue());
      if (!this.jdField_b_of_type_AndroidGraphicsPoint.equals(localObject)) {
        a((Point)localObject, false);
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2)
  {
    MeasureGridView localMeasureGridView = a(paramInt1);
    if (localMeasureGridView != null) {
      return localMeasureGridView.getChildAt(paramInt2);
    }
    return null;
  }
  
  Adapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$GridListViewAdapter;
  }
  
  public void a()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      removeView(localImageView);
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_AndroidGraphicsPoint.set(paramInt2, paramInt1);
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition() / 2;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$GridListViewAdapter.getItemViewType(this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition()) > 0) {
      if (j > 0) {
        i = j - 1;
      } else {
        i = 0;
      }
    }
    Point localPoint = new Point(this.jdField_a_of_type_ComTencentMobileqqWidgetBaseDraggableGridViewAdapter.a(i) - 1, i);
    View localView = a(paramInt1, paramInt2);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localView.startAnimation(localAlphaAnimation);
    if (localPoint.equals(this.jdField_b_of_type_AndroidGraphicsPoint))
    {
      localAlphaAnimation.setAnimationListener(new DraggableGridView.1(this, paramInt1, paramInt2));
      return;
    }
    a(localPoint, true);
  }
  
  @SuppressLint({"RtlHardcoded"})
  public void a(View paramView1, View paramView2)
  {
    int i = paramView1.getLeft();
    int j = paramView2.getLeft();
    int k = paramView1.getTop();
    int m = paramView2.getTop();
    int n = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
    paramView1 = BitmapUtil.a(paramView2);
    if (paramView1 != null)
    {
      int i1 = DisplayUtil.a(getContext(), 15.0F);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramView1.getWidth() + i1, paramView1.getHeight() + i1);
      i1 /= 2;
      k = k + m - n - i1;
      localLayoutParams.topMargin = k;
      i = i + j - i1;
      localLayoutParams.leftMargin = i;
      localLayoutParams.gravity = 51;
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramView2.getContext());
        addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      }
      this.jdField_a_of_type_AndroidGraphicsPoint.set(i, k);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView1);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 255) {
      return false;
    }
    this.jdField_c_of_type_Float = paramMotionEvent.getX();
    this.jdField_d_of_type_Float = paramMotionEvent.getY();
    if (i == 2)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
          this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
          this.e = 0;
        }
        paramMotionEvent = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        paramMotionEvent.leftMargin = ((int)(this.jdField_c_of_type_Float - this.jdField_a_of_type_Float + this.jdField_a_of_type_AndroidGraphicsPoint.x));
        paramMotionEvent.topMargin = ((int)(this.jdField_d_of_type_Float - this.jdField_b_of_type_Float + this.jdField_a_of_type_AndroidGraphicsPoint.y));
        if (paramMotionEvent.leftMargin + this.jdField_a_of_type_AndroidWidgetImageView.getWidth() < 1) {
          paramMotionEvent.leftMargin = (1 - this.jdField_a_of_type_AndroidWidgetImageView.getWidth());
        } else if (paramMotionEvent.leftMargin > getWidth() - 1) {
          paramMotionEvent.leftMargin = (getWidth() - 1);
        }
        if (paramMotionEvent.topMargin + this.jdField_a_of_type_AndroidWidgetImageView.getHeight() < 1) {
          paramMotionEvent.topMargin = (1 - this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
        } else if (paramMotionEvent.topMargin > getHeight() - 1) {
          paramMotionEvent.topMargin = (getHeight() - 1);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramMotionEvent);
        b((int)this.jdField_c_of_type_Float, (int)this.jdField_d_of_type_Float);
        i = this.jdField_a_of_type_ComTencentWidgetListView.getHeight();
        if (this.jdField_d_of_type_Float > i - DisplayUtil.a(getContext(), 30.0F))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread.a(1);
          return true;
        }
        if (this.jdField_d_of_type_Float < DisplayUtil.a(getContext(), 30.0F))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread.a(2);
          return true;
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread;
        if (paramMotionEvent != null) {
          paramMotionEvent.jdField_a_of_type_Boolean = true;
        }
        return true;
      }
    }
    else if ((i == 1) || (i == 3))
    {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_Boolean))
      {
        localObject = a(this.jdField_b_of_type_AndroidGraphicsPoint.y, this.jdField_b_of_type_AndroidGraphicsPoint.x);
        if (localObject != null)
        {
          View localView = (View)((View)localObject).getParent();
          i = localView.getLeft();
          int j = ((View)localObject).getLeft();
          int k = localView.getTop();
          int m = ((View)localObject).getTop();
          int n = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
          localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          localObject = new TranslateAnimation(0, 0.0F, 0, i + j - ((FrameLayout.LayoutParams)localObject).leftMargin, 0, 0.0F, 0, k + m - n - ((FrameLayout.LayoutParams)localObject).topMargin);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setAnimationListener(new DraggableGridView.DragEndAnimationListener(this, null));
          this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread;
      if (localObject != null) {
        ((DraggableGridView.ScrollThread)localObject).jdField_a_of_type_Boolean = true;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(BaseDraggableGridViewAdapter paramBaseDraggableGridViewAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBaseDraggableGridViewAdapter = paramBaseDraggableGridViewAdapter;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBaseDraggableGridViewAdapter.a = this;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$GridListViewAdapter = new DraggableGridView.GridListViewAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$GridListViewAdapter);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnGridItemClickListener(DraggableGridView.OnGridItemClickListener paramOnGridItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$OnGridItemClickListener = paramOnGridItemClickListener;
  }
  
  public void setOnGridItemLongClickListener(DraggableGridView.OnGridItemLongClickListener paramOnGridItemLongClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$OnGridItemLongClickListener = paramOnGridItemLongClickListener;
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetListView.setVerticalScrollBarEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView
 * JD-Core Version:    0.7.0.1
 */