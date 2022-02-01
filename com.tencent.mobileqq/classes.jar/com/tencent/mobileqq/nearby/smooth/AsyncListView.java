package com.tencent.mobileqq.nearby.smooth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ListAdapter;
import aytk;
import aytl;
import blih;
import bljo;
import com.tencent.mobileqq.fpsreport.FPSXListView;

public class AsyncListView
  extends FPSXListView
{
  final aytk a = new aytk(this);
  
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
  
  public void setItemManager(aytl paramaytl)
  {
    this.a.a(paramaytl);
  }
  
  public void setOnItemSelectedListener(bljo parambljo)
  {
    this.a.a(parambljo);
    if (!this.a.a()) {
      super.setOnItemSelectedListener(parambljo);
    }
  }
  
  public void setOnScrollListener(blih paramblih)
  {
    this.a.a(paramblih);
    if (!this.a.a()) {
      super.setOnScrollListener(paramblih);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.AsyncListView
 * JD-Core Version:    0.7.0.1
 */