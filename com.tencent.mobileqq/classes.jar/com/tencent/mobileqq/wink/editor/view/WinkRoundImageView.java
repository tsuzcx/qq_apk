package com.tencent.mobileqq.wink.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class WinkRoundImageView
  extends ImageView
{
  public static int a = 1;
  private Paint b = new Paint();
  private Matrix c = new Matrix();
  private BitmapShader d;
  private int e = 90;
  private Bitmap f;
  private RectF g = new RectF();
  private RectF h;
  private Paint i;
  
  public WinkRoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WinkRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WinkRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b.setAntiAlias(true);
    this.h = new RectF();
    this.i = new Paint();
    this.i.setStyle(Paint.Style.FILL);
    this.i.setStrokeWidth(ImmersiveUtils.dpToPx(a));
    this.i.setColor(-1);
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      int j;
      if (paramDrawable.getIntrinsicWidth() <= 0) {
        j = getWidth();
      } else {
        j = paramDrawable.getIntrinsicWidth();
      }
      int k;
      if (paramDrawable.getIntrinsicHeight() <= 0) {
        k = getHeight();
      } else {
        k = paramDrawable.getIntrinsicHeight();
      }
      if ((j > 0) && (k > 0))
      {
        Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_4444);
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, j, k);
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    Object localObject = this.f;
    float f2 = 1.0F;
    float f1 = f2;
    if (localObject != null) {
      if (((Bitmap)localObject).getWidth() == getWidth())
      {
        f1 = f2;
        if (this.f.getHeight() == getHeight()) {}
      }
      else
      {
        f1 = Math.max(getWidth() * 1.0F / this.f.getWidth(), getHeight() * 1.0F / this.f.getHeight());
      }
    }
    this.c.setScale(f1, f1);
    localObject = this.d;
    if (localObject != null)
    {
      ((BitmapShader)localObject).setLocalMatrix(this.c);
      this.b.setShader(this.d);
    }
    this.h.set(ImmersiveUtils.dpToPx(a), ImmersiveUtils.dpToPx(a), getMeasuredWidth() - ImmersiveUtils.dpToPx(a), getMeasuredHeight() - ImmersiveUtils.dpToPx(a));
    localObject = this.g;
    int j = this.e;
    paramCanvas.drawRoundRect((RectF)localObject, j, j, this.i);
    localObject = this.h;
    j = this.e;
    paramCanvas.drawRoundRect((RectF)localObject, j, j, this.b);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.g.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (paramDrawable != getDrawable()))
    {
      this.f = a(paramDrawable);
      Bitmap localBitmap = this.f;
      if (localBitmap != null) {
        this.d = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      }
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setRoundRect(int paramInt)
  {
    int j = paramInt;
    if (paramInt <= 0) {
      j = 0;
    }
    this.e = j;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.view.WinkRoundImageView
 * JD-Core Version:    0.7.0.1
 */