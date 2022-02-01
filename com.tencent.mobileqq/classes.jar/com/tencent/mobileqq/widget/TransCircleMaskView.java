package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.DisplayMetrics;
import android.view.View;

public class TransCircleMaskView
  extends View
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private Paint f;
  private Paint g;
  private Bitmap h;
  private Canvas i;
  private int j = -1;
  private boolean k = true;
  
  public TransCircleMaskView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public static int a(Context paramContext)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * 11.0F + 0.5F);
  }
  
  private void a()
  {
    this.f = new Paint();
    this.f.setColor(-16777216);
    this.c = getResources().getColor(2131168160);
    this.g = new Paint();
    this.g.setStyle(Paint.Style.FILL);
    this.g.setAntiAlias(true);
    this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.d = getWidth();
    this.e = getHeight();
    Bitmap localBitmap = this.h;
    if (localBitmap == null) {
      return;
    }
    localBitmap.eraseColor(0);
    this.i.drawColor(this.c);
    int n = this.j;
    int m = n;
    if (n == -1) {
      m = a(getContext());
    }
    this.i.drawCircle(this.d / 2, this.e / 2 + m, this.a, this.g);
    paramCanvas.drawBitmap(this.h, 0.0F, 0.0F, this.f);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != paramInt3)) || (paramInt2 != paramInt4)) {}
    try
    {
      this.h = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label34:
      Bitmap localBitmap;
      break label34;
    }
    this.h = null;
    localBitmap = this.h;
    if (localBitmap != null) {
      this.i = new Canvas(localBitmap);
    }
    if (this.k) {
      this.a = ((int)(paramInt2 * 0.5F * 0.83F));
    } else {
      this.a = ((int)(paramInt2 * 0.5F) - this.b);
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setIsUseMaskRadiusRatios(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
  
  public void setMaskRadius(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
  
  public void setUITopOffset(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setmMaskRadiusBless(int paramInt)
  {
    this.b = paramInt;
    this.c = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TransCircleMaskView
 * JD-Core Version:    0.7.0.1
 */