package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;

public class OverScrollRecyclerView
  extends RecyclerView
{
  protected final OverScrollRecyclerView.OverScrollStateManager a = new OverScrollRecyclerView.OverScrollStateManager(this);
  
  public OverScrollRecyclerView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public OverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a.a();
  }
  
  public void b()
  {
    this.a.d();
  }
  
  public void c()
  {
    this.a.c();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.d();
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    this.a.a(paramLayoutManager);
  }
  
  public void setTouchDragRatio(float paramFloat1, float paramFloat2)
  {
    if (this.a.f != null)
    {
      this.a.f.b = paramFloat1;
      this.a.f.c = paramFloat2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */