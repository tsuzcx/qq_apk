package com.tencent.mobileqq.nearby.smooth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ListAdapter;
import avtb;
import avtc;
import bhtv;
import bhuy;
import com.tencent.mobileqq.fpsreport.FPSXListView;

public class AsyncListView
  extends FPSXListView
{
  final avtb a = new avtb(this);
  
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
  
  public void setItemManager(avtc paramavtc)
  {
    this.a.a(paramavtc);
  }
  
  public void setOnItemSelectedListener(bhuy parambhuy)
  {
    this.a.a(parambhuy);
    if (!this.a.a()) {
      super.setOnItemSelectedListener(parambhuy);
    }
  }
  
  public void setOnScrollListener(bhtv parambhtv)
  {
    this.a.a(parambhtv);
    if (!this.a.a()) {
      super.setOnScrollListener(parambhtv);
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