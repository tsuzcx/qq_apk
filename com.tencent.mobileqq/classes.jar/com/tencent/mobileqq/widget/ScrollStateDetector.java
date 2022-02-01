package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;

public class ScrollStateDetector
  implements Handler.Callback, ScrollListener
{
  Handler a = null;
  ScrollStateDetector.OnScrollListener b = null;
  int c = 0;
  boolean d;
  WeakReference<View> e;
  boolean f = false;
  int g = 10;
  
  public ScrollStateDetector(ScrollStateDetector.OnScrollListener paramOnScrollListener, Context paramContext)
  {
    this.b = paramOnScrollListener;
    this.g = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  void a(int paramInt)
  {
    int i = this.c;
    if (paramInt != i)
    {
      this.c = paramInt;
      if (this.b != null)
      {
        Object localObject = this.e;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (View)((WeakReference)localObject).get();
        }
        this.b.a((View)localObject, i, paramInt);
      }
    }
  }
  
  void a(View paramView)
  {
    Object localObject = this.e;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (View)((WeakReference)localObject).get();
    }
    if (localObject != paramView) {
      this.e = new WeakReference(paramView);
    }
  }
  
  public void fling(View paramView, int paramInt)
  {
    a(paramView);
    this.d = true;
    this.a.removeMessages(0);
    a(2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      this.a.removeMessages(0);
      this.d = false;
      a(0);
    }
    return true;
  }
  
  public void onFingerDown(View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramView);
    this.f = true;
    this.d = false;
  }
  
  public void onFingerUpOrCancel(View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramView);
    this.f = false;
    this.a.sendEmptyMessageDelayed(0, 100L);
  }
  
  public void onScrollChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView);
    paramInt3 = Math.abs(paramInt2 - paramInt4);
    if ((paramInt3 != 0) && (paramInt2 != 0)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    this.a.removeMessages(0);
    if ((paramInt1 != 0) && (!this.f))
    {
      this.d = false;
      a(0);
      return;
    }
    if (this.d)
    {
      if (paramInt3 <= this.g) {
        this.a.sendEmptyMessageDelayed(0, 50L);
      }
      a(2);
      return;
    }
    if ((!this.f) && (paramInt3 <= this.g)) {
      this.a.sendEmptyMessageDelayed(0, 50L);
    }
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollStateDetector
 * JD-Core Version:    0.7.0.1
 */