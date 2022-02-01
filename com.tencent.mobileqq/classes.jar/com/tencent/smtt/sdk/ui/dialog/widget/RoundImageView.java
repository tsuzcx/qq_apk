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
    for (;;)
    {
      paramContext = this.d;
      if (j >= paramContext.length) {
        break;
      }
      paramContext[j] = this.h;
      j += 1;
    }
  }
  
  private Bitmap a()
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      localObject = localBitmap;
      Canvas localCanvas = new Canvas(localBitmap);
      localObject = localBitmap;
      Paint localPaint = new Paint(1);
      localObject = localBitmap;
      localPaint.setColor(-16777216);
      localObject = localBitmap;
      localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.h, this.h, localPaint);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return localObject;
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
    Bitmap localBitmap = this.c;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.c = null;
    }
    super.invalidate();
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject1 = this.g;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (Bitmap)((WeakReference)localObject1).get();
    }
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      this.a.setXfermode(null);
      paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, this.a);
    }
    else
    {
      Object localObject2 = getDrawable();
      if (localObject2 != null)
      {
        int j = ((Drawable)localObject2).getIntrinsicWidth();
        int k = ((Drawable)localObject2).getIntrinsicHeight();
        localObject1 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas((Bitmap)localObject1);
        float f2 = getWidth();
        float f1 = j;
        float f3 = f2 * 1.0F / f1;
        float f4 = getHeight();
        f2 = k;
        f3 = Math.max(f3, f4 * 1.0F / f2);
        ((Drawable)localObject2).setBounds(0, 0, (int)(f1 * f3), (int)(f3 * f2));
        ((Drawable)localObject2).draw(localCanvas);
        localObject2 = this.c;
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          this.c = a();
        }
        this.a.reset();
        this.a.setFilterBitmap(false);
        this.a.setXfermode(this.b);
        localObject2 = this.c;
        if (localObject2 != null) {
          localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, this.a);
        }
        this.a.setXfermode(null);
        paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        this.g = new WeakReference(localObject1);
      }
    }
    a(paramCanvas, 1, this.f, this.e, this.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.widget.RoundImageView
 * JD-Core Version:    0.7.0.1
 */