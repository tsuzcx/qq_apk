package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ColorNoteListLayout
  extends LinearLayout
{
  private int a;
  private int b;
  private View c;
  private RecyclerView d;
  private OnListHideListener e;
  private int f = -1;
  private int[] g = new int[2];
  
  public ColorNoteListLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ColorNoteListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ColorNoteListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    this.c = new View(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    addView(this.c, localLayoutParams);
    this.d = new RecyclerView(paramContext);
    this.d.setId(2131430973);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    addView(this.d, paramContext);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (paramKeyEvent.getAction() == 1)
      {
        paramKeyEvent = this.e;
        if (paramKeyEvent != null) {
          paramKeyEvent.c();
        }
      }
      return true;
    }
    return false;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.d;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!paramBoolean) {
      return;
    }
    Object localObject;
    if (this.f < 0)
    {
      paramInt1 = this.d.getChildCount();
      paramInt4 = 0;
      if (paramInt1 > 0)
      {
        paramInt1 = this.d.getChildAt(0).getMeasuredHeight();
        localObject = (RecyclerView.LayoutParams)this.d.getChildAt(0).getLayoutParams();
        paramInt1 = paramInt1 + ((RecyclerView.LayoutParams)localObject).topMargin + ((RecyclerView.LayoutParams)localObject).bottomMargin;
      }
      else
      {
        paramInt1 = 0;
      }
      paramInt3 = paramInt4;
      if (this.d.getChildCount() <= 4)
      {
        getLocationOnScreen(this.g);
        int j = this.d.getChildCount() * paramInt1;
        int i = this.g[1];
        if (((View)getParent()).getMeasuredHeight() - this.a - getPaddingBottom() + i >= j) {}
        for (paramInt2 = this.a;; paramInt2 = this.b - j)
        {
          paramInt3 = paramInt2 - i;
          break;
          paramInt3 = paramInt4;
          if (this.b - paramInt2 - getPaddingTop() + i < j) {
            break;
          }
        }
      }
      if (paramInt1 > 0)
      {
        this.f = paramInt3;
        localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).height = this.f;
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = this.f;
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAnchor(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void setHideListener(OnListHideListener paramOnListHideListener)
  {
    this.e = paramOnListHideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListLayout
 * JD-Core Version:    0.7.0.1
 */