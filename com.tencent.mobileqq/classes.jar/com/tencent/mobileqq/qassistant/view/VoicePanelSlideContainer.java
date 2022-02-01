package com.tencent.mobileqq.qassistant.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qassistant.listener.IPanelDragListener;
import com.tencent.mobileqq.qassistant.listener.IPanelSlideListener;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class VoicePanelSlideContainer
  extends RelativeLayout
  implements View.OnLayoutChangeListener
{
  private Context a;
  private int b = 20;
  private boolean c = false;
  private float d;
  private int e;
  private int f;
  private IPanelSlideListener g;
  private IPanelDragListener h;
  
  public VoicePanelSlideContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoicePanelSlideContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoicePanelSlideContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    if (paramContext != null) {
      this.b = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    }
    addOnLayoutChangeListener(this);
  }
  
  private void a(int paramInt)
  {
    if ((getY() <= this.e) && (paramInt == 0))
    {
      a(false);
      return;
    }
    a(true);
    offsetTopAndBottom(paramInt);
  }
  
  private void a(boolean paramBoolean)
  {
    IPanelDragListener localIPanelDragListener = this.h;
    if (localIPanelDragListener != null) {
      localIPanelDragListener.b(paramBoolean);
    }
  }
  
  private void b()
  {
    int i = (int)getY();
    ObjectAnimator localObjectAnimator;
    if (i - this.e > getMeasuredHeight() / 2)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, "y", new float[] { i, this.f });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.addListener(new VoicePanelSlideContainer.1(this));
      localObjectAnimator.start();
      return;
    }
    int j = this.e;
    if (i > j)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, "y", new float[] { i, j });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.addListener(new VoicePanelSlideContainer.2(this));
      localObjectAnimator.start();
      return;
    }
    if (i == j) {
      a(false);
    }
  }
  
  private void c()
  {
    IPanelSlideListener localIPanelSlideListener = this.g;
    if (localIPanelSlideListener != null) {
      localIPanelSlideListener.c();
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label101;
          }
        }
        else
        {
          float f1 = paramMotionEvent.getY();
          if (Math.abs(this.d - f1) > this.b) {
            bool = true;
          }
          this.c = bool;
          if (!this.c) {
            break label101;
          }
          this.d = paramMotionEvent.getY();
          break label101;
        }
      }
      this.c = false;
    }
    else
    {
      this.d = paramMotionEvent.getY();
      this.c = false;
    }
    label101:
    return this.c;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = this.a;
    if (paramView != null) {
      this.f = ScreenUtil.getRealHeight(paramView);
    }
    this.e = ((int)getY());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.c) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          int k = (int)getY();
          int j = (int)(paramMotionEvent.getY() - this.d);
          int m = this.e;
          i = j;
          if (k + j < m) {
            i = m - k;
          }
          a(i);
          return true;
        }
      }
      this.c = false;
      b();
      return true;
    }
    this.c = false;
    return true;
  }
  
  public void setPanelDragListener(IPanelDragListener paramIPanelDragListener)
  {
    this.h = paramIPanelDragListener;
  }
  
  public void setPanelSlideListener(IPanelSlideListener paramIPanelSlideListener)
  {
    this.g = paramIPanelSlideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer
 * JD-Core Version:    0.7.0.1
 */