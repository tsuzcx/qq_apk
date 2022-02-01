package com.tencent.mobileqq.guild.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnOverScrollListener;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class SwipPinnedHeaderExpandableListViewEx
  extends SwipPinnedHeaderExpandableListView
  implements AbsListView.OnOverScrollListener
{
  private QQGuildChannelView.OnListViewScroll a;
  private View.OnTouchListener b;
  private int c = 0;
  
  public SwipPinnedHeaderExpandableListViewEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public SwipPinnedHeaderExpandableListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SwipPinnedHeaderExpandableListViewEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (this.a != null)
    {
      int j = -getScrollY();
      if (this.c != j)
      {
        this.c = j;
        int i = getFirstVisiblePosition();
        float f = getChildAt(0).getY();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fling overScroll:");
          localStringBuilder.append(j);
          localStringBuilder.append(" firstViewY:");
          localStringBuilder.append(f);
          QLog.d("SwipPinnedHeaderExpandableListViewEx", 4, localStringBuilder.toString());
        }
        j = (int)(j + f);
        this.a.a(i, j);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    a();
    View.OnTouchListener localOnTouchListener = this.b;
    if (localOnTouchListener != null) {
      localOnTouchListener.onTouch(this, paramMotionEvent);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onOverScroll(int paramInt)
  {
    a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    a();
    View.OnTouchListener localOnTouchListener = this.b;
    if (localOnTouchListener != null) {
      localOnTouchListener.onTouch(this, paramMotionEvent);
    }
    return bool;
  }
  
  public void setOnListViewScroll(QQGuildChannelView.OnListViewScroll paramOnListViewScroll)
  {
    this.a = paramOnListViewScroll;
    setOnOverScrollListener(this);
  }
  
  public void setTouchHandler(View.OnTouchListener paramOnTouchListener)
  {
    this.b = paramOnTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.SwipPinnedHeaderExpandableListViewEx
 * JD-Core Version:    0.7.0.1
 */