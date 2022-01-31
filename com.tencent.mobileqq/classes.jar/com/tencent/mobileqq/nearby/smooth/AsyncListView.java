package com.tencent.mobileqq.nearby.smooth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ListAdapter;
import atbi;
import atbj;
import begh;
import behk;
import com.tencent.mobileqq.fpsreport.FPSXListView;

public class AsyncListView
  extends FPSXListView
{
  final atbi a = new atbi(this);
  
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
  
  public void setItemManager(atbj paramatbj)
  {
    this.a.a(paramatbj);
  }
  
  public void setOnItemSelectedListener(behk parambehk)
  {
    this.a.a(parambehk);
    if (!this.a.a()) {
      super.setOnItemSelectedListener(parambehk);
    }
  }
  
  public void setOnScrollListener(begh parambegh)
  {
    this.a.a(parambegh);
    if (!this.a.a()) {
      super.setOnScrollListener(parambegh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.AsyncListView
 * JD-Core Version:    0.7.0.1
 */