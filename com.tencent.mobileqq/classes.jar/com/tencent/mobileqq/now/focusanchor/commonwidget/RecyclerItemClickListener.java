package com.tencent.mobileqq.now.focusanchor.commonwidget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerItemClickListener
  implements RecyclerView.OnItemTouchListener
{
  private GestureDetector a;
  private View b;
  private RecyclerView c;
  
  public RecyclerItemClickListener(Context paramContext, RecyclerItemClickListener.OnItemClickListener paramOnItemClickListener)
  {
    this.a = new GestureDetector(paramContext, new RecyclerItemClickListener.1(this, paramOnItemClickListener));
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.a.onTouchEvent(paramMotionEvent);
    this.b = paramRecyclerView.findChildViewUnder(paramMotionEvent.getX(), paramMotionEvent.getY());
    this.c = paramRecyclerView;
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.commonwidget.RecyclerItemClickListener
 * JD-Core Version:    0.7.0.1
 */