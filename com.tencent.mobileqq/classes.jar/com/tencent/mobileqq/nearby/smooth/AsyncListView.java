package com.tencent.mobileqq.nearby.smooth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class AsyncListView
  extends FPSXListView
  implements AsyncAbsListView
{
  final ItemManaged a = new ItemManaged(this);
  
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
    this.a.f();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(this.a.a(paramListAdapter));
    this.a.h();
  }
  
  public void setItemManager(ItemManager paramItemManager)
  {
    this.a.a(paramItemManager);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.a.a(paramOnItemSelectedListener);
    if (!this.a.a()) {
      super.setOnItemSelectedListener(paramOnItemSelectedListener);
    }
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.a(paramOnScrollListener);
    if (!this.a.a()) {
      super.setOnScrollListener(paramOnScrollListener);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.AsyncListView
 * JD-Core Version:    0.7.0.1
 */