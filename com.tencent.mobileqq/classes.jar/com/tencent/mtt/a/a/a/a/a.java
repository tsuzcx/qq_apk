package com.tencent.mtt.a.a.a.a;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

public class a
  extends RecyclerView.OnScrollListener
  implements View.OnAttachStateChangeListener
{
  private View a;
  private b b;
  private boolean c = false;
  private float d = 0.3F;
  private Runnable e = new a.1(this);
  
  void a()
  {
    b localb = this.b;
    if (localb != null) {
      localb.onFooterLoadMore();
    }
  }
  
  public void a(View paramView)
  {
    View localView = this.a;
    if (localView != null)
    {
      localView.removeCallbacks(this.e);
      this.a.removeOnAttachStateChangeListener(this);
    }
    this.c = false;
    this.a = paramView;
    paramView = this.a;
    if (paramView != null) {
      paramView.addOnAttachStateChangeListener(this);
    }
  }
  
  public void a(b paramb)
  {
    this.b = paramb;
  }
  
  public boolean b(View paramView)
  {
    boolean bool2 = this.c;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (!paramView.isShown())
    {
      this.c = false;
      return false;
    }
    Rect localRect = new Rect();
    bool2 = paramView.getGlobalVisibleRect(localRect);
    int i = paramView.getWidth() * paramView.getHeight();
    if ((bool2) && (i != 0))
    {
      if (localRect.width() * localRect.height() * 1.0F / i > this.d) {
        bool1 = true;
      }
      this.c = bool1;
      return this.c;
    }
    this.c = false;
    return false;
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = this.a;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.removeCallbacks(this.e);
      this.a.post(this.e);
    }
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */