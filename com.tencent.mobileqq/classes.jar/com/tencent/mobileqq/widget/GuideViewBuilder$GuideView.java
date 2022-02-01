package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Pair;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class GuideViewBuilder$GuideView
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public GuideViewBuilder$GuideView(GuideViewBuilder paramGuideViewBuilder, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(GuideViewBuilder.GuideTarget paramGuideTarget, GuideViewBuilder.GuideLayoutParams paramGuideLayoutParams)
  {
    if (paramGuideLayoutParams.width == -9) {
      paramGuideLayoutParams.width = (paramGuideTarget.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -paramGuideLayoutParams.a * 2);
    }
    if (paramGuideLayoutParams.height == -9) {
      paramGuideLayoutParams.height = (paramGuideTarget.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -paramGuideLayoutParams.b * 2);
    }
    if (paramGuideLayoutParams.a != 2147483647)
    {
      paramGuideLayoutParams.gravity |= 0x3;
      paramGuideLayoutParams.leftMargin = (paramGuideTarget.jdField_a_of_type_ArrayOfInt[0] + paramGuideLayoutParams.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (paramGuideLayoutParams.b != 2147483647)
    {
      paramGuideLayoutParams.gravity |= 0x30;
      paramGuideLayoutParams.topMargin = (paramGuideTarget.jdField_a_of_type_ArrayOfInt[1] + paramGuideLayoutParams.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return paramGuideLayoutParams;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
      {
        GuideViewBuilder.GuideTarget localGuideTarget = (GuideViewBuilder.GuideTarget)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(i);
        if (localGuideTarget.jdField_a_of_type_ArrayOfInt == null)
        {
          localGuideTarget.jdField_a_of_type_ArrayOfInt = new int[2];
          localGuideTarget.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localGuideTarget.jdField_a_of_type_ArrayOfInt);
        }
        i += 1;
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuideView", 2, "getLocationOnScreen Null Pointer");
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
    {
      GuideViewBuilder.GuideTarget localGuideTarget = (GuideViewBuilder.GuideTarget)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localGuideTarget.jdField_a_of_type_ArrayOfInt[0], localGuideTarget.jdField_a_of_type_ArrayOfInt[1], localGuideTarget.jdField_a_of_type_ArrayOfInt[0] + localGuideTarget.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localGuideTarget.jdField_a_of_type_ArrayOfInt[1] + localGuideTarget.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localGuideTarget.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
    {
      GuideViewBuilder.GuideTarget localGuideTarget = (GuideViewBuilder.GuideTarget)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(paramInt1);
      Iterator localIterator = localGuideTarget.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localGuideTarget, (GuideViewBuilder.GuideLayoutParams)localPair.second);
          }
          if (localObject != null) {
            addViewInLayout((View)localPair.first, -1, (ViewGroup.LayoutParams)localObject);
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      int i = 0;
      while (i < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
      {
        GuideViewBuilder.GuideTarget localGuideTarget = (GuideViewBuilder.GuideTarget)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(i);
        if ((paramMotionEvent.getX() > localGuideTarget.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localGuideTarget.jdField_a_of_type_ArrayOfInt[0] + localGuideTarget.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localGuideTarget.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localGuideTarget.jdField_a_of_type_ArrayOfInt[1] + localGuideTarget.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localGuideTarget.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder.a.dismiss();
          localGuideTarget.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localGuideTarget.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuideViewBuilder.GuideView
 * JD-Core Version:    0.7.0.1
 */