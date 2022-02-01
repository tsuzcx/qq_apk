package com.tencent.mobileqq.now.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.mobileqq.R.styleable;

public class CircleImageView
  extends ImageView
{
  private int a;
  
  public CircleImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private Bitmap a()
  {
    Rect localRect = new Rect(0, 0, getWidth(), getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    localCanvas.drawRect(localRect, localPaint);
    return localBitmap;
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {}
    do
    {
      return null;
      paramBitmap = a(paramBitmap, paramInt, paramInt);
    } while (paramBitmap == null);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramInt, paramInt);
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localPaint.setDither(true);
    localCanvas.drawCircle(paramInt / 2.0F, paramInt / 2.0F, paramInt / 2.0F, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramBitmap.getConfig());
    float f4 = paramBitmap.getWidth();
    float f3 = paramBitmap.getHeight();
    Canvas localCanvas = new Canvas(localBitmap);
    float f1 = paramInt1 / f4;
    float f2 = paramInt2 / f3;
    f4 = (paramInt1 - f4 * f1) / 2.0F;
    f3 = (paramInt2 - f3 * f2) / 1.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.postTranslate(f4, f3);
    localMatrix.preScale(f1, f2);
    Paint localPaint = new Paint();
    localPaint.setFilterBitmap(true);
    localCanvas.drawBitmap(paramBitmap, localMatrix, localPaint);
    return localBitmap;
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {}
    do
    {
      return;
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CircleImageView);
    } while (paramAttributeSet == null);
    this.a = paramAttributeSet.getDimensionPixelSize(0, 0);
    paramAttributeSet.recycle();
  }
  
  public Bitmap a(Drawable paramDrawable)
  {
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getDrawable();
    if ((localObject != null) && (getWidth() != 0) && (getHeight() != 0)) {}
    try
    {
      Bitmap localBitmap = a((Drawable)localObject);
      localObject = localBitmap;
      if (localBitmap == null) {
        localObject = a();
      }
      localObject = a(((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true), getWidth() - this.a * 2);
      if (localObject != null)
      {
        paramCanvas.drawBitmap((Bitmap)localObject, this.a, this.a, null);
        paramCanvas.save();
        paramCanvas.restore();
      }
      return;
    }
    catch (Exception paramCanvas)
    {
      paramCanvas.printStackTrace();
      return;
    }
    catch (OutOfMemoryError paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    try
    {
      Drawable localDrawable = getDrawable();
      if (localDrawable == null)
      {
        setMeasuredDimension(0, 0);
        return;
      }
      i = View.MeasureSpec.getSize(paramInt1);
      j = View.MeasureSpec.getSize(paramInt2);
      if ((j == 0) && (i == 0))
      {
        setMeasuredDimension(i, j);
        return;
      }
    }
    catch (Exception localException)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    if (j == 0)
    {
      setMeasuredDimension(i, localException.getIntrinsicHeight() * i / localException.getIntrinsicWidth());
      return;
    }
    if (i == 0)
    {
      setMeasuredDimension(localException.getIntrinsicWidth() * j / localException.getIntrinsicHeight(), j);
      return;
    }
    setMeasuredDimension(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.CircleImageView
 * JD-Core Version:    0.7.0.1
 */