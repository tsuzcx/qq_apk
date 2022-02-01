package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.util.VersionUtils;

public class PAImageView
  extends AnyScaleTypeImageView
{
  float B = 10.0F;
  Paint C;
  float[] D;
  Path E;
  RectF F;
  private int a;
  private int b;
  private int c;
  private Bitmap d;
  private Canvas e;
  private BitmapShader f;
  private Paint g;
  private boolean h = false;
  
  public PAImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PAImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PAImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.F.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    this.E.addRoundRect(this.F, this.D, Path.Direction.CW);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.h)
    {
      super.draw(paramCanvas);
      return;
    }
    this.a = getWidth();
    this.b = getHeight();
    if ((this.a > 0) && (this.b > 0))
    {
      i = this.c;
      if (i == 1)
      {
        i = paramCanvas.getSaveCount();
        paramCanvas.save();
        super.draw(paramCanvas);
        paramCanvas.drawPath(this.E, this.C);
        paramCanvas.restoreToCount(i);
        return;
      }
      if (i == 2)
      {
        localObject = this.d;
        if ((localObject != null) && ((((Bitmap)localObject).getWidth() != this.a) || (this.d.getHeight() != this.b)))
        {
          this.d = null;
          this.f = null;
        }
        if (this.d != null) {}
      }
    }
    try
    {
      this.d = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.RGB_565);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label169:
      label190:
      label214:
      break label169;
    }
    try
    {
      this.d = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.RGB_565);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label190;
    }
    URLDrawable.clearMemoryCache();
    try
    {
      this.d = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.RGB_565);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      float f1;
      break label214;
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((Canvas)localObject).setBitmap(this.d);
    }
    localObject = this.d;
    if (localObject == null)
    {
      super.draw(paramCanvas);
      return;
    }
    if (this.e == null)
    {
      this.e = new Canvas((Bitmap)localObject);
      this.e.setBitmap(this.d);
    }
    if (this.f == null)
    {
      this.f = new BitmapShader(this.d, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.g.setShader(this.f);
    }
    super.draw(this.e);
    localObject = new RectF(0.0F, 0.0F, this.a, this.b + this.B * 2.0F);
    int i = paramCanvas.save();
    f1 = this.B;
    paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.g);
    paramCanvas.restoreToCount(i);
    return;
    super.draw(paramCanvas);
  }
  
  @TargetApi(11)
  public void g()
  {
    if (VersionUtils.e()) {
      this.c = 2;
    } else {
      this.c = 2;
    }
    int i = this.c;
    if (i == 1)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        setLayerType(2, null);
      }
      this.C = new Paint();
      this.C.setStyle(Paint.Style.FILL);
      this.C.setAntiAlias(true);
      this.C.setFilterBitmap(true);
      this.C.setColor(-16777216);
      this.C.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.E = new Path();
      this.F = new RectF();
      this.D = new float[8];
      return;
    }
    if (i == 2)
    {
      this.g = new Paint();
      this.g.setAntiAlias(true);
      this.g.setFilterBitmap(true);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.c == 1)) {
      a(getWidth(), getHeight());
    }
  }
  
  public void setUseRadiusRound(boolean paramBoolean, float paramFloat)
  {
    this.h = paramBoolean;
    this.B = paramFloat;
    float[] arrayOfFloat = this.D;
    if (arrayOfFloat != null)
    {
      arrayOfFloat[3] = paramFloat;
      arrayOfFloat[2] = paramFloat;
      arrayOfFloat[1] = paramFloat;
      arrayOfFloat[0] = paramFloat;
      arrayOfFloat[7] = 0.0F;
      arrayOfFloat[6] = 0.0F;
      arrayOfFloat[5] = 0.0F;
      arrayOfFloat[4] = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAImageView
 * JD-Core Version:    0.7.0.1
 */