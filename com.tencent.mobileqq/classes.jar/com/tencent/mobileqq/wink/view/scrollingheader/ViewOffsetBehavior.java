package com.tencent.mobileqq.wink.view.scrollingheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private ViewOffsetHelper a;
  private int b = 0;
  private int c = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    paramCoordinatorLayout.onLayoutChild(paramV, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    ViewOffsetHelper localViewOffsetHelper = this.a;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.a(paramInt);
    }
    this.b = paramInt;
    return false;
  }
  
  public int b()
  {
    ViewOffsetHelper localViewOffsetHelper = this.a;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.c();
    }
    return 0;
  }
  
  public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    a(paramCoordinatorLayout, paramV, paramInt);
    if (this.a == null) {
      this.a = new ViewOffsetHelper(paramV);
    }
    this.a.a();
    this.a.b();
    paramInt = this.b;
    if (paramInt != 0)
    {
      this.a.a(paramInt);
      this.b = 0;
    }
    paramInt = this.c;
    if (paramInt != 0)
    {
      this.a.b(paramInt);
      this.c = 0;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.scrollingheader.ViewOffsetBehavior
 * JD-Core Version:    0.7.0.1
 */