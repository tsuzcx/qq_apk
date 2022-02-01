package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.ViewGroup;
import java.util.concurrent.ArrayBlockingQueue;

public class LayoutInflateProcessor$InflateParams
{
  ArrayBlockingQueue a;
  private int b;
  private int c;
  private ViewGroup d;
  private LayoutInflateProcessor.OnInflateFinishedListener e;
  
  public LayoutInflateProcessor$InflateParams(int paramInt1, int paramInt2, ViewGroup paramViewGroup, LayoutInflateProcessor.OnInflateFinishedListener paramOnInflateFinishedListener)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramViewGroup;
    this.e = paramOnInflateFinishedListener;
  }
  
  public LayoutInflateProcessor$InflateParams(int paramInt, ViewGroup paramViewGroup, LayoutInflateProcessor.OnInflateFinishedListener paramOnInflateFinishedListener)
  {
    this(paramInt, 1, paramViewGroup, paramOnInflateFinishedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor.InflateParams
 * JD-Core Version:    0.7.0.1
 */