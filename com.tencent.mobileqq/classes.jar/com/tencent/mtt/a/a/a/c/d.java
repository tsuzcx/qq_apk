package com.tencent.mtt.a.a.a.c;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.EasyRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class d
  extends RecyclerView.OnScrollListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final a a;
  private EasyRecyclerView b;
  private c c;
  private e d;
  private RecyclerView.ViewHolder e;
  private boolean f;
  private View g;
  private int h;
  private int i;
  private b j;
  
  public d(EasyRecyclerView paramEasyRecyclerView, c paramc, a parama, b paramb) {}
  
  private float a(View paramView)
  {
    View localView = this.g;
    if ((localView != null) && (paramView != null))
    {
      float f1;
      if (this.h == 1)
      {
        if (paramView.getY() < localView.getHeight()) {
          f1 = paramView.getY();
        }
      }
      else {
        for (int k = localView.getHeight();; k = localView.getWidth())
        {
          return f1 - k;
          if (localView.isShown()) {
            return -localView.getWidth();
          }
          if (paramView.getX() >= localView.getWidth()) {
            break;
          }
          f1 = localView.getX();
        }
      }
    }
    return 0.0F;
  }
  
  private void a(int paramInt)
  {
    if (paramInt != -1)
    {
      this.e = this.d.a(paramInt);
      this.i = paramInt;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("attachSticky:");
      ((StringBuilder)localObject).append(this.e);
      Log.d("returnHeader", ((StringBuilder)localObject).toString());
      this.g = ((ViewGroup)this.e.itemView).getChildAt(0);
      c(this.g);
      this.f = this.e.isRecyclable();
      this.e.setIsRecyclable(false);
      this.g.setVisibility(4);
      localObject = new FrameLayout.LayoutParams(-1, 0);
      ViewGroup.LayoutParams localLayoutParams = this.e.itemView.getLayoutParams();
      if (localLayoutParams != null) {
        paramInt = localLayoutParams.height;
      } else {
        paramInt = -2;
      }
      ((FrameLayout.LayoutParams)localObject).height = paramInt;
      this.j.addOnLayoutListener(this);
      this.j.attachHeader(this.g, (FrameLayout.LayoutParams)localObject);
    }
  }
  
  private View b(int paramInt)
  {
    int k = 0;
    while (k < this.b.getChildCount())
    {
      View localView = this.b.getChildAt(k);
      int m = this.b.getChildLayoutPosition(localView);
      if ((m > paramInt) && (this.c.isStickyPosition(m))) {
        return localView;
      }
      k += 1;
    }
    return null;
  }
  
  private void b()
  {
    if (this.e != null)
    {
      c(this.g);
      this.g.setTranslationY(0.0F);
      this.g.setTranslationX(0.0F);
      c();
      this.j.removeOnLayoutListener(this);
    }
    this.i = -1;
    this.e = null;
  }
  
  private boolean b(View paramView)
  {
    if (paramView != null) {
      if (this.h == 1)
      {
        if (paramView.getY() < 0.0F) {
          return true;
        }
      }
      else if (paramView.getX() < 0.0F) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    this.e.setIsRecyclable(this.f);
    Object localObject = this.a;
    if (localObject != null)
    {
      ((a)localObject).onHeaderDetached(this.e, this.g);
      return;
    }
    localObject = this.b.findViewHolderForAdapterPosition(this.e.getAdapterPosition());
    if ((localObject != null) && ((((RecyclerView.ViewHolder)localObject).itemView instanceof ViewGroup)))
    {
      localObject = (ViewGroup)((RecyclerView.ViewHolder)localObject).itemView;
      if (((ViewGroup)localObject).getChildCount() <= 0) {
        ((ViewGroup)localObject).addView(this.g);
      }
    }
  }
  
  private void c(View paramView)
  {
    if ((paramView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
  
  private void d()
  {
    if (this.e != null)
    {
      float f1 = a(b(this.i));
      if (this.h == 1)
      {
        this.g.setTranslationY(f1);
        return;
      }
      this.g.setTranslationX(f1);
    }
  }
  
  public int a()
  {
    if (this.b.getChildCount() <= 0) {
      return -1;
    }
    int m = this.b.getFirstChildPosition();
    View localView = this.b.getChildAt(0);
    int k = m;
    if (localView.getY() < 0.0F) {}
    while (k >= 0)
    {
      m = k;
      if (this.c.isStickyPosition(k)) {
        break label74;
      }
      k = m - 1;
    }
    k = -1;
    label74:
    m = k;
    if (k != -1)
    {
      if (k != this.b.getFirstChildPosition()) {
        return k;
      }
      m = k;
      if (!b(localView)) {
        m = -1;
      }
    }
    return m;
  }
  
  public void onGlobalLayout()
  {
    View localView = this.g;
    if (localView != null)
    {
      localView.setVisibility(0);
      d();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramInt1 = a();
    if (this.i != paramInt1)
    {
      b();
      a(paramInt1);
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.a.a.a.c.d
 * JD-Core Version:    0.7.0.1
 */