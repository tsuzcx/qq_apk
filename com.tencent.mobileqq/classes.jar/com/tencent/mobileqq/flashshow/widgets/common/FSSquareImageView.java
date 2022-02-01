package com.tencent.mobileqq.flashshow.widgets.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.theme.SkinnableBitmapDrawable;

public class FSSquareImageView
  extends ImageView
{
  private Paint a = new Paint();
  private Matrix b = new Matrix();
  private BitmapShader c;
  private int d = 90;
  private Bitmap e;
  private RectF f = new RectF();
  
  public FSSquareImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSSquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSSquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.setAntiAlias(true);
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
    }
    int i;
    if (paramDrawable.getIntrinsicWidth() <= 0) {
      i = getWidth();
    } else {
      i = paramDrawable.getIntrinsicWidth();
    }
    int j;
    if (paramDrawable.getIntrinsicHeight() <= 0) {
      j = getHeight();
    } else {
      j = paramDrawable.getIntrinsicHeight();
    }
    if ((i > 0) && (j > 0))
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    Object localObject = this.e;
    float f2 = 1.0F;
    float f1 = f2;
    if (localObject != null) {
      if (((Bitmap)localObject).getWidth() == getWidth())
      {
        f1 = f2;
        if (this.e.getHeight() == getHeight()) {}
      }
      else
      {
        f1 = Math.max(getWidth() * 1.0F / this.e.getWidth(), getHeight() * 1.0F / this.e.getHeight());
      }
    }
    this.b.setScale(f1, f1);
    localObject = this.c;
    if (localObject != null)
    {
      ((BitmapShader)localObject).setLocalMatrix(this.b);
      this.a.setShader(this.c);
    }
    localObject = this.f;
    int i = this.d;
    paramCanvas.drawRoundRect((RectF)localObject, i, i, this.a);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.f.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (paramDrawable != getDrawable()))
    {
      this.e = a(paramDrawable);
      Bitmap localBitmap = this.e;
      if (localBitmap != null) {
        this.c = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      }
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setRoundRect(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 0;
    }
    this.d = i;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSSquareImageView
 * JD-Core Version:    0.7.0.1
 */