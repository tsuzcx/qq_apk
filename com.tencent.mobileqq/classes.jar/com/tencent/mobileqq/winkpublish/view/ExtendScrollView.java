package com.tencent.mobileqq.winkpublish.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.component.media.annotation.Public;
import java.util.HashSet;
import java.util.Iterator;

public class ExtendScrollView
  extends ScrollView
{
  private HashSet<View> a;
  private HashSet<View> b;
  private int c = -1;
  private ExtendScrollView.OnDownListener d;
  
  @Public
  public ExtendScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  @Public
  public ExtendScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @Public
  public ExtendScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject1 = this.a;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (localObject1 != null)
    {
      Object localObject2 = ((HashSet)localObject1).iterator();
      do
      {
        bool1 = bool3;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (View)((Iterator)localObject2).next();
      } while (!a((View)localObject1, paramMotionEvent));
      localObject2 = this.b;
      if ((localObject2 != null) && (((HashSet)localObject2).contains(localObject1)))
      {
        bool1 = bool2;
        if (!b((View)localObject1, paramMotionEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      int i = paramMotionEvent.getActionMasked();
      if ((i != 1) && (i != 3))
      {
        this.c = ((int)paramMotionEvent.getRawY());
        return bool1;
      }
      this.c = -1;
    }
    return bool1;
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView != null)
    {
      if (paramMotionEvent == null) {
        return false;
      }
      try
      {
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        paramMotionEvent = new int[2];
        paramView.getLocationOnScreen(paramMotionEvent);
        int i = paramMotionEvent[0];
        int j = paramView.getWidth();
        int k = paramMotionEvent[1];
        int m = paramView.getHeight();
        return (i < f1) && (f1 < j + i) && (k < f2) && (f2 < m + k);
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    return false;
  }
  
  @TargetApi(14)
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT < 14) {
      return true;
    }
    if (paramView != null)
    {
      if (paramMotionEvent == null) {
        return false;
      }
      if (this.c == -1) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 14)
      {
        if (paramMotionEvent.getRawY() - this.c > 0.0F) {
          return paramView.canScrollVertically(-1);
        }
        if (paramMotionEvent.getRawY() - this.c < 0.0F) {
          return paramView.canScrollVertically(1);
        }
      }
      return true;
    }
    return false;
  }
  
  @Public
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (this.a == null) {
      this.a = new HashSet();
    }
    View localView = findViewById(paramInt);
    if (localView != null) {
      this.a.add(localView);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = getTouchDelegate();
    if (localObject != null) {
      ((TouchDelegate)localObject).onTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      localObject = this.d;
      if ((localObject != null) && (((ExtendScrollView.OnDownListener)localObject).a(paramMotionEvent))) {
        return true;
      }
    }
    else
    {
      localObject = this.d;
      if ((localObject != null) && (((ExtendScrollView.OnDownListener)localObject).b(paramMotionEvent))) {
        return true;
      }
    }
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (a(paramMotionEvent)) {
        return false;
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return false;
  }
  
  public void setOnDownListener(ExtendScrollView.OnDownListener paramOnDownListener)
  {
    this.d = paramOnDownListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.view.ExtendScrollView
 * JD-Core Version:    0.7.0.1
 */