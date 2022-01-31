package com.tencent.mobileqq.emoticonview;

import aepi;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ListAdapter;
import apvu;
import apvv;
import apvw;
import apxl;
import bdoo;
import bhzg;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorizontalListViewEx
  extends HorizontalListView
{
  private static List<View> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e;
  
  public HorizontalListViewEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = aepi.a(51.0F, paramContext.getResources());
    paramAttributeSet = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramAttributeSet);
    this.c = paramAttributeSet.widthPixels;
    c();
  }
  
  public static View a()
  {
    if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0)) {
      return (View)jdField_a_of_type_JavaUtilList.remove(0);
    }
    return null;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilList != null) {
      jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131166425));
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.e = bdoo.a(18.0F);
  }
  
  private void d()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getTag() != null)
      {
        apvw localapvw = (apvw)localView.getTag();
        localView.setSelected(false);
        localapvw.a.setSelected(false);
      }
      i += 1;
    }
  }
  
  public int a(int paramInt)
  {
    int i = this.mNextX + paramInt;
    if (i < 0) {
      return -1;
    }
    if (i > this.mMaxX) {
      return 1;
    }
    this.mScroller.a(this.mNextX, 0, paramInt, 0, 20);
    setCurrentScrollState(4098);
    requestLayout();
    return 0;
  }
  
  protected void b()
  {
    if ((this.d != this.mCurrentlySelectedAdapterIndex) && (getChildCount() > 0))
    {
      View localView = getChild(this.d);
      if (localView != null) {
        this.jdField_a_of_type_Int = localView.getLeft();
      }
      for (;;)
      {
        localView = getSelectedView();
        if (localView == null) {
          break;
        }
        d();
        int i = this.jdField_a_of_type_Int;
        int j = localView.getLeft();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, j });
        localValueAnimator.setDuration(200L);
        this.jdField_b_of_type_Boolean = true;
        localValueAnimator.addUpdateListener(new apxl(this, localView, j));
        localValueAnimator.start();
        return;
        if (this.d < getFirstVisiblePosition()) {
          this.jdField_a_of_type_Int = (-this.jdField_b_of_type_Int);
        } else if (this.d > getLastVisiblePosition()) {
          this.jdField_a_of_type_Int = (this.c - this.jdField_b_of_type_Int);
        }
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      localObject1 = getSelectedView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject1 = ((ViewGroup)localObject1).getChildAt(0);
        if (localObject1 != null) {
          break label50;
        }
      }
    }
    label50:
    int j;
    do
    {
      do
      {
        return;
        localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      } while (localObject1 == null);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_Int, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, this.jdField_a_of_type_Int + this.jdField_b_of_type_Int, getMeasuredHeight() - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.e, this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      j = getChildCount();
    } while (getAdapter() == null);
    paramCanvas = (apvu)getAdapter();
    int i = 0;
    label149:
    Object localObject2;
    apvw localapvw;
    if (i < j)
    {
      localObject1 = getChildAt(i);
      localObject2 = paramCanvas.getItem(this.mLeftViewAdapterIndex + i);
      if (((View)localObject1).getTag() != null)
      {
        localapvw = (apvw)((View)localObject1).getTag();
        if (localObject1 != getSelectedView()) {
          break label240;
        }
        ((View)localObject1).setSelected(true);
        localapvw.a.setSelected(true);
        if (localObject2 != null) {
          ((View)localObject1).setContentDescription(((apvv)localObject2).b);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label149;
      break;
      label240:
      ((View)localObject1).setSelected(false);
      localapvw.a.setSelected(false);
      if (localObject2 != null) {
        ((View)localObject1).setContentDescription(((apvv)localObject2).b);
      }
    }
  }
  
  public void resetCurrentX(int paramInt)
  {
    this.mCurrentX = (this.jdField_b_of_type_Int * paramInt);
  }
  
  public void setSelection(int paramInt)
  {
    int j = 0;
    super.setSelection(paramInt);
    if (this.mAdapter == null) {}
    label671:
    label703:
    for (;;)
    {
      return;
      if ((paramInt < this.mAdapter.getCount()) && (paramInt >= 0))
      {
        int k = getFirstVisiblePosition();
        int m = getLastVisiblePosition();
        int n;
        int i;
        if ((paramInt > m) && (m != -1))
        {
          n = (paramInt + 1) * this.jdField_b_of_type_Int;
          j = n - this.mNextX - (this.c - this.jdField_b_of_type_Int - this.jdField_b_of_type_Int);
          i = j;
          if (DEBUG)
          {
            i = j;
            if (QLog.isDevelopLevel())
            {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond right screen, position:" + paramInt + ",lastPosition:" + m + ",tabPosition:" + n + ",mNextX:" + this.mNextX + ",deltaX:" + j + ",mScreenWidth" + this.c);
              i = j;
            }
          }
          if (i == 0) {
            break label671;
          }
          a(i);
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label703;
          }
          b();
          this.d = this.mCurrentlySelectedAdapterIndex;
          return;
          if ((paramInt < k) && (k != -1))
          {
            n = this.jdField_b_of_type_Int * paramInt;
            j = n - this.mNextX;
            i = j;
            if (!DEBUG) {
              break;
            }
            i = j;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond l eft screen, position:" + paramInt + ",firstPosition:" + k + ",tabPosition:" + n + ",mNextX:" + this.mNextX + ",deltaX:" + j + ",mScreenWidth" + this.c);
            i = j;
            break;
          }
          View localView;
          int[] arrayOfInt;
          if (paramInt == k)
          {
            localView = getChildAt(0);
            arrayOfInt = new int[2];
            localView.getLocationOnScreen(arrayOfInt);
            i = arrayOfInt[0] - getLeft();
            if ((DEBUG) && (QLog.isDevelopLevel())) {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half left screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.mNextX + ",deltaX:" + i);
            }
            break;
          }
          if (paramInt == m)
          {
            localView = getChildAt(getChildCount() - 1);
            arrayOfInt = new int[2];
            localView.getLocationOnScreen(arrayOfInt);
            j = arrayOfInt[0] + this.jdField_b_of_type_Int - getRight();
            i = j;
            if (j < 0) {
              i = 0;
            }
            if ((DEBUG) && (QLog.isDevelopLevel())) {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half right screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.mNextX + ",deltaX:" + i);
            }
            break;
          }
          i = j;
          if (!DEBUG) {
            break;
          }
          i = j;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view inside screen, position:" + paramInt + ",mNextX:" + this.mNextX);
          i = j;
          break;
          if ((k == -1) && (m == -1)) {
            ViewCompat.postOnAnimation(this, new HorizontalListViewEx.1(this));
          } else {
            requestLayout();
          }
        }
      }
    }
  }
  
  public void setTabAnimateEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HorizontalListViewEx
 * JD-Core Version:    0.7.0.1
 */