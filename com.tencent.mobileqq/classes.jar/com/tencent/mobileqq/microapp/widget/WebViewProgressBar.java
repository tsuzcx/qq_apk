package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.microapp.R.drawable;

public class WebViewProgressBar
  extends View
{
  private Drawable a;
  private Drawable b;
  private boolean c = true;
  private p d;
  private Drawable e = null;
  
  public WebViewProgressBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(p paramp)
  {
    if (this.d == paramp) {
      return;
    }
    if (this.d != null) {
      this.d.a(null);
    }
    this.d = paramp;
    if (this.d != null)
    {
      this.d.a(this);
      this.d.a(getWidth());
    }
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j;
    int i;
    if ((this.d != null) && (this.d.a() != 6))
    {
      if ((this.e == null) || (this.a == null)) {
        break label164;
      }
      j = (int)this.d.b();
      if (j >= this.a.getIntrinsicWidth()) {
        break label326;
      }
      i = j - this.a.getIntrinsicWidth();
      j = this.a.getIntrinsicWidth();
    }
    for (;;)
    {
      if (i + j > 0)
      {
        this.e.setBounds(0, 0, getWidth(), getHeight());
        this.e.draw(paramCanvas);
        if (this.b != null)
        {
          this.b.setBounds(0, 0, getWidth(), getHeight());
          this.b.draw(paramCanvas);
        }
      }
      this.a.setBounds(i, 0, j + i, getHeight());
      this.a.draw(paramCanvas);
      return;
      label164:
      if (this.b == null) {
        this.b = getContext().getResources().getDrawable(R.drawable.u);
      }
      this.b.setBounds(0, 0, getWidth(), getHeight());
      this.b.draw(paramCanvas);
      if (this.a == null) {
        this.a = getContext().getResources().getDrawable(R.drawable.v);
      }
      j = (int)this.d.b();
      if (this.c) {
        this.a.setAlpha(this.d.c());
      }
      if (j < this.a.getIntrinsicWidth())
      {
        i = j - this.a.getIntrinsicWidth();
        j = this.a.getIntrinsicWidth();
      }
      for (;;)
      {
        this.a.setBounds(i, 0, j + i, getHeight());
        this.a.draw(paramCanvas);
        return;
        i = 0;
      }
      label326:
      i = 0;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.d != null) {
      this.d.a(getWidth());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.WebViewProgressBar
 * JD-Core Version:    0.7.0.1
 */