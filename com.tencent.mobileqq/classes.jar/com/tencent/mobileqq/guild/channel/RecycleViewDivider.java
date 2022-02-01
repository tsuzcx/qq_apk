package com.tencent.mobileqq.guild.channel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class RecycleViewDivider
  extends RecyclerView.ItemDecoration
{
  private static final int[] e = { 16843284 };
  private Paint a;
  private Drawable b;
  private int c = 2;
  private int d;
  private int f;
  private int g;
  private boolean h = true;
  
  public RecycleViewDivider(Context paramContext, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0)) {
      throw new IllegalArgumentException("请输入正确的参数！");
    }
    this.d = paramInt;
    paramContext = paramContext.obtainStyledAttributes(e);
    this.b = paramContext.getDrawable(0);
    paramContext.recycle();
  }
  
  public RecycleViewDivider(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramContext, paramInt1);
    this.c = paramInt2;
    this.a = new Paint(1);
    this.a.setColor(paramInt3);
    this.a.setStyle(Paint.Style.FILL);
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    if (!this.h) {
      return paramRecyclerView.getChildCount() - 1;
    }
    return paramRecyclerView.getChildCount();
  }
  
  private void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getPaddingLeft() + this.f;
    int k = paramRecyclerView.getMeasuredWidth() - paramRecyclerView.getPaddingRight() - this.g;
    int m = a(paramRecyclerView);
    int i = 0;
    while (i < m)
    {
      Object localObject = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
      int n = ((View)localObject).getBottom() + localLayoutParams.bottomMargin;
      int i1 = this.c + n;
      localObject = this.b;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(j, n, k, i1);
        this.b.draw(paramCanvas);
      }
      localObject = this.a;
      if (localObject != null) {
        paramCanvas.drawRect(j, n, k, i1, (Paint)localObject);
      }
      i += 1;
    }
  }
  
  private void b(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getPaddingTop();
    int k = paramRecyclerView.getMeasuredHeight() - paramRecyclerView.getPaddingBottom();
    int m = a(paramRecyclerView);
    int i = 0;
    while (i < m)
    {
      Object localObject = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
      int n = ((View)localObject).getRight() + localLayoutParams.rightMargin;
      int i1 = this.c + n;
      localObject = this.b;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(n, j, i1, k);
        this.b.draw(paramCanvas);
      }
      localObject = this.a;
      if (localObject != null) {
        paramCanvas.drawRect(n, j, i1, k, (Paint)localObject);
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if (this.d == 1)
    {
      paramRect.set(0, 0, 0, this.c);
      return;
    }
    paramRect.set(0, 0, 0, this.c);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    if (this.d == 1)
    {
      b(paramCanvas, paramRecyclerView);
      return;
    }
    a(paramCanvas, paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.RecycleViewDivider
 * JD-Core Version:    0.7.0.1
 */