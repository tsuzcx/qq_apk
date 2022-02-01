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
  RectF a = new RectF();
  int[] b = new int[2];
  
  public GuideViewBuilder$GuideView(GuideViewBuilder paramGuideViewBuilder, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(GuideViewBuilder.GuideTarget paramGuideTarget, GuideViewBuilder.GuideLayoutParams paramGuideLayoutParams)
  {
    if (paramGuideLayoutParams.width == -9) {
      paramGuideLayoutParams.width = (paramGuideTarget.a.getMeasuredWidth() + -paramGuideLayoutParams.a * 2);
    }
    if (paramGuideLayoutParams.height == -9) {
      paramGuideLayoutParams.height = (paramGuideTarget.a.getMeasuredHeight() + -paramGuideLayoutParams.b * 2);
    }
    if (paramGuideLayoutParams.a != 2147483647)
    {
      paramGuideLayoutParams.gravity |= 0x3;
      paramGuideLayoutParams.leftMargin = (paramGuideTarget.b[0] + paramGuideLayoutParams.a - this.b[0]);
    }
    if (paramGuideLayoutParams.b != 2147483647)
    {
      paramGuideLayoutParams.gravity |= 0x30;
      paramGuideLayoutParams.topMargin = (paramGuideTarget.b[1] + paramGuideLayoutParams.b - this.b[1]);
    }
    return paramGuideLayoutParams;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.b);
      int i = 0;
      while (i < GuideViewBuilder.a(this.c).size())
      {
        GuideViewBuilder.GuideTarget localGuideTarget = (GuideViewBuilder.GuideTarget)GuideViewBuilder.a(this.c).valueAt(i);
        if (localGuideTarget.b == null)
        {
          localGuideTarget.b = new int[2];
          localGuideTarget.a.getLocationOnScreen(localGuideTarget.b);
        }
        i += 1;
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label76:
      break label76;
    }
    if (QLog.isColorLevel()) {
      QLog.e("GuideView", 2, "getLocationOnScreen Null Pointer");
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < GuideViewBuilder.a(this.c).size())
    {
      GuideViewBuilder.GuideTarget localGuideTarget = (GuideViewBuilder.GuideTarget)GuideViewBuilder.a(this.c).valueAt(i);
      int j = paramCanvas.save();
      this.a.set(localGuideTarget.b[0], localGuideTarget.b[1], localGuideTarget.b[0] + localGuideTarget.a.getMeasuredWidth(), localGuideTarget.b[1] + localGuideTarget.a.getMeasuredHeight());
      RectF localRectF = this.a;
      int[] arrayOfInt = this.b;
      localRectF.offset(-arrayOfInt[0], -arrayOfInt[1]);
      paramCanvas.clipRect(this.a);
      localGuideTarget.a.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < GuideViewBuilder.a(this.c).size())
    {
      GuideViewBuilder.GuideTarget localGuideTarget = (GuideViewBuilder.GuideTarget)GuideViewBuilder.a(this.c).valueAt(paramInt1);
      Iterator localIterator = localGuideTarget.c.iterator();
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
    if (paramMotionEvent.getAction() == 0)
    {
      int i = 0;
      while (i < GuideViewBuilder.a(this.c).size())
      {
        GuideViewBuilder.GuideTarget localGuideTarget = (GuideViewBuilder.GuideTarget)GuideViewBuilder.a(this.c).valueAt(i);
        if ((paramMotionEvent.getX() > localGuideTarget.b[0]) && (paramMotionEvent.getX() < localGuideTarget.b[0] + localGuideTarget.a.getMeasuredWidth()) && (paramMotionEvent.getY() > localGuideTarget.b[1]) && (paramMotionEvent.getY() < localGuideTarget.b[1] + localGuideTarget.a.getMeasuredHeight()) && (localGuideTarget.d != null))
        {
          this.c.c.dismiss();
          localGuideTarget.d.onClick(localGuideTarget.a);
          return true;
        }
        i += 1;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuideViewBuilder.GuideView
 * JD-Core Version:    0.7.0.1
 */