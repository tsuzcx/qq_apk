package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.List;

public class ReadinjoyViewLayer
  extends FrameLayout
{
  private int a;
  private int b;
  private boolean c;
  private List<View> d = new ArrayList();
  
  public ReadinjoyViewLayer(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadinjoyViewLayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    paramView.getLocalVisibleRect(localRect);
    boolean bool2 = false;
    int i = arrayOfInt[0] + localRect.left;
    int j = localRect.width();
    int k = arrayOfInt[1] + localRect.top;
    int m = localRect.height();
    boolean bool1 = bool2;
    if (i < paramFloat1)
    {
      bool1 = bool2;
      if (paramFloat1 < j + i)
      {
        bool1 = bool2;
        if (k < paramFloat2)
        {
          bool1 = bool2;
          if (paramFloat2 < m + k) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void a(View paramView)
  {
    this.d.add(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool1 = false;
    if (i == 0)
    {
      this.a = ((int)(paramMotionEvent.getX() + 0.5F));
      this.b = ((int)(paramMotionEvent.getY() + 0.5F));
      i = 0;
      while (i < this.d.size())
      {
        if (a((View)this.d.get(i), paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
        {
          FrameHelperActivity.c(false);
          return false;
        }
        i += 1;
      }
    }
    if (i == 2)
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      int j = (int)(paramMotionEvent.getY() + 0.5F);
      i = Math.abs(i - this.a);
      j = Math.abs(j - this.b);
      int k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((this.c) && (i > k))
      {
        if ((j / i < 0.6F) && (this.a > (int)(ScreenUtil.SCREEN_WIDTH * 0.1F))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          FrameHelperActivity.c(true);
        }
        this.c = false;
        break label230;
      }
    }
    else if ((i == 1) || (i == 3))
    {
      FrameHelperActivity.c(true);
      this.c = false;
    }
    i = 0;
    label230:
    if (i == 0) {}
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool1 = false;
    if (i == 0)
    {
      FrameHelperActivity.c(false);
    }
    else if ((i == 1) || (i == 3))
    {
      FrameHelperActivity.c(true);
      this.c = false;
    }
    try
    {
      boolean bool2 = super.onTouchEvent(paramMotionEvent);
      bool1 = bool2;
    }
    catch (Exception paramMotionEvent)
    {
      label47:
      break label47;
    }
    if (!bool1) {
      FrameHelperActivity.c(true);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadinjoyViewLayer
 * JD-Core Version:    0.7.0.1
 */