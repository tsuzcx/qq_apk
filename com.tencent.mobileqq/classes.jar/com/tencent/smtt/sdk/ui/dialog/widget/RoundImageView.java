package com.tencent.smtt.sdk.ui.dialog.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.smtt.sdk.ui.dialog.c;
import java.lang.ref.WeakReference;

public class RoundImageView
  extends ImageView
{
  private Paint a = new Paint();
  private Xfermode b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  private Bitmap c;
  private float[] d;
  private RectF e;
  private int f = Color.parseColor("#eaeaea");
  private WeakReference<Bitmap> g;
  private float h;
  private Path i;
  
  public RoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.setAntiAlias(true);
    this.i = new Path();
    this.d = new float[8];
    this.e = new RectF();
    this.h = c.a(paramContext, 16.459999F);
    int j = 0;
    while (j < this.d.length)
    {
      this.d[j] = this.h;
      j += 1;
    }
  }
  
  private Bitmap a()
  {
    try
    {
      localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas;
      Paint localPaint;
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localCanvas = new Canvas(localBitmap);
        localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.h, this.h, localPaint);
        return localBitmap;
      }
      catch (Throwable localThrowable2)
      {
        Bitmap localBitmap;
        break label76;
      }
      localThrowable1 = localThrowable1;
      localBitmap = null;
    }
    label76:
    return localBitmap;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.i.reset();
    this.a.setStrokeWidth(paramInt1);
    this.a.setColor(paramInt2);
    this.a.setStyle(Paint.Style.STROKE);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, RectF paramRectF, float[] paramArrayOfFloat)
  {
    a(paramInt1, paramInt2);
    this.i.addRoundRect(paramRectF, paramArrayOfFloat, Path.Direction.CCW);
    paramCanvas.drawPath(this.i, this.a);
  }
  
  public void invalidate()
  {
    this.g = null;
    if (this.c != null)
    {
      this.c.recycle();
      this.c = null;
    }
    super.invalidate();
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    if (this.g == null)
    {
      localObject = null;
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        break label263;
      }
      localObject = getDrawable();
      if (localObject != null)
      {
        int j = ((Drawable)localObject).getIntrinsicWidth();
        int k = ((Drawable)localObject).getIntrinsicHeight();
        Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        float f1 = Math.max(getWidth() * 1.0F / j, getHeight() * 1.0F / k);
        ((Drawable)localObject).setBounds(0, 0, (int)(j * f1), (int)(k * f1));
        ((Drawable)localObject).draw(localCanvas);
        if ((this.c == null) || (this.c.isRecycled())) {
          this.c = a();
        }
        this.a.reset();
        this.a.setFilterBitmap(false);
        this.a.setXfermode(this.b);
        if (this.c != null) {
          localCanvas.drawBitmap(this.c, 0.0F, 0.0F, this.a);
        }
        this.a.setXfermode(null);
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
        this.g = new WeakReference(localBitmap);
      }
    }
    for (;;)
    {
      a(paramCanvas, 1, this.f, this.e, this.d);
      return;
      localObject = (Bitmap)this.g.get();
      break;
      label263:
      this.a.setXfermode(null);
      paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.a);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e.set(0.5F, 0.5F, paramInt1 - 0.5F, paramInt2 - 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.widget.RoundImageView
 * JD-Core Version:    0.7.0.1
 */