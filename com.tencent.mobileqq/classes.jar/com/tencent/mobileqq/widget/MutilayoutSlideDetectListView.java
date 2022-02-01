package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class MutilayoutSlideDetectListView
  extends SlideDetectListView
{
  public MutilayoutSlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View b(View paramView)
  {
    if ((paramView instanceof ShaderAnimLayout)) {
      return paramView;
    }
    if ((paramView instanceof RelativeLayout))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          View localView = b(paramView.getChildAt(i));
          if ((localView instanceof ShaderAnimLayout)) {
            return localView;
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public int a(View paramView)
  {
    paramView = (View)paramView.getParent();
    int i = paramView.getTop();
    while (paramView != this.d)
    {
      paramView = (View)paramView.getParent();
      i += paramView.getTop();
    }
    return i;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.m == null)
    {
      this.m = new GestureDetector(getContext(), this.l, new Handler(Looper.getMainLooper()));
      this.m.setIsLongpressEnabled(false);
    }
    this.m.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 1) {
        this.c = false;
      }
    }
    else
    {
      this.a = ((int)paramMotionEvent.getY());
      this.n = false;
      i = a(this.a);
      if ((this.d != null) && (b(i) == this.d))
      {
        if (paramMotionEvent.getX() >= this.d.getWidth() - this.g)
        {
          if ((this.h > 0) && (this.d.getHeight() > 0))
          {
            Object localObject = b(this.d);
            if (localObject != null)
            {
              View localView = (View)((View)localObject).getParent();
              i = a((View)localObject) + localView.getHeight() / 2;
              int j = this.h / 2;
              int k = this.h / 2;
              if ((this.a <= j + i) && (this.a >= i - k)) {
                break label319;
              }
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("accurate in delete:ycenter:");
                ((StringBuilder)localObject).append(i);
                ((StringBuilder)localObject).append(",motionheight:");
                ((StringBuilder)localObject).append(this.d.getHeight());
                ((StringBuilder)localObject).append("deleareaHeight:");
                ((StringBuilder)localObject).append(this.h);
                QLog.d("SlideDetectListView", 2, ((StringBuilder)localObject).toString());
              }
            }
            i = 0;
            break label321;
          }
          label319:
          i = 1;
          label321:
          if (i != 0)
          {
            this.n = true;
            return false;
          }
        }
      }
      else if (this.b == true) {
        return true;
      }
    }
    if (this.n == true) {
      return false;
    }
    if (this.a != 0)
    {
      if (this.b == true) {
        return true;
      }
      if (this.c) {
        return false;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MutilayoutSlideDetectListView
 * JD-Core Version:    0.7.0.1
 */