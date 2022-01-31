package com.tencent.mobileqq.nearby.smooth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ListAdapter;
import avos;
import avot;
import bhpo;
import bhqr;
import com.tencent.mobileqq.fpsreport.FPSXListView;

public class AsyncListView
  extends FPSXListView
{
  final avos a = new avos(this);
  
  public AsyncListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AsyncListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AsyncListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.a();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(this.a.a(paramListAdapter));
    this.a.b();
  }
  
  public void setItemManager(avot paramavot)
  {
    this.a.a(paramavot);
  }
  
  public void setOnItemSelectedListener(bhqr parambhqr)
  {
    this.a.a(parambhqr);
    if (!this.a.a()) {
      super.setOnItemSelectedListener(parambhqr);
    }
  }
  
  public void setOnScrollListener(bhpo parambhpo)
  {
    this.a.a(parambhpo);
    if (!this.a.a()) {
      super.setOnScrollListener(parambhpo);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.a.a(paramOnTouchListener);
    if (!this.a.a()) {
      super.setOnTouchListener(paramOnTouchListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.AsyncListView
 * JD-Core Version:    0.7.0.1
 */