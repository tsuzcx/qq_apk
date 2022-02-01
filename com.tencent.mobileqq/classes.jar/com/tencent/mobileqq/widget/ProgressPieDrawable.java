package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;

public class ProgressPieDrawable
  extends Drawable
{
  static LruCache<String, Typeface> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(8);
  public float a;
  public int a;
  public Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  public Drawable a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  public ProgressPieDrawable.AnimationHandler a;
  public String a;
  WeakReference<ProgressPieDrawable.OnProgressListener> jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  public float b;
  public int b;
  public Paint b;
  RectF b;
  public String b;
  public WeakReference<Context> b;
  public boolean b;
  public float c;
  public int c;
  public Paint c;
  public boolean c;
  float d;
  public int d;
  public Paint d;
  public boolean d;
  public int e;
  private Paint e;
  public boolean e;
  public int f;
  public boolean f;
  public boolean g = false;
  private boolean h = false;
  private boolean i;
  
  public ProgressPieDrawable(Context paramContext)
  {
    this.jdField_a_of_type_Int = 100;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -90;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Float = 1.5F;
    this.jdField_b_of_type_Float = 4.0F;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_Float = 14.0F;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 25;
    this.jdField_f_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$AnimationHandler = new ProgressPieDrawable.AnimationHandler(this);
    this.jdField_f_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    a(paramContext);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Resources a()
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    return ((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getResources();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$AnimationHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$AnimationHandler.a(this.jdField_b_of_type_Int);
    invalidateSelf();
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Float = paramInt;
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float *= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_b_of_type_Float *= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_c_of_type_Float *= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(-1493172225);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(16777215);
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
      this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
    }
    else
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(16777215);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(3355443);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_c_of_type_Float);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public void a(ProgressPieDrawable.OnProgressListener paramOnProgressListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnProgressListener);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= this.jdField_a_of_type_Int);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$AnimationHandler.removeMessages(0);
    if (a(paramInt))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$AnimationHandler.a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$AnimationHandler.sendEmptyMessage(0);
      invalidateSelf();
      return;
    }
    throw new IllegalArgumentException(String.format("Animation progress (%d) is greater than the max progress (%d) or lower than 0 ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void c(int paramInt)
  {
    if (a(paramInt))
    {
      this.jdField_b_of_type_Int = paramInt;
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (ProgressPieDrawable.OnProgressListener)((WeakReference)localObject).get();
        if (localObject != null)
        {
          paramInt = this.jdField_b_of_type_Int;
          int j = this.jdField_a_of_type_Int;
          if (paramInt == j) {
            ((ProgressPieDrawable.OnProgressListener)localObject).onProgressCompleted(this);
          } else {
            ((ProgressPieDrawable.OnProgressListener)localObject).onProgressChanged(this, paramInt, j);
          }
        }
      }
      invalidateSelf();
      return;
    }
    throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void d(int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!isVisible()) {
      return;
    }
    Rect localRect = getBounds();
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f1 = this.jdField_d_of_type_Float;
    ((RectF)localObject).set(0.0F, 0.0F, f1, f1);
    this.jdField_a_of_type_AndroidGraphicsRectF.offset((localRect.width() - this.jdField_d_of_type_Float) / 2.0F, (localRect.height() - this.jdField_d_of_type_Float) / 2.0F);
    int j;
    if (this.jdField_c_of_type_Boolean)
    {
      j = (int)(this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F + 0.5F);
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      f1 = j;
      ((RectF)localObject).inset(f1, f1);
    }
    float f3 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    float f4 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
      paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, true, this.jdField_d_of_type_AndroidGraphicsPaint);
      j = this.jdField_d_of_type_Int;
      float f2;
      if ((j != 0) && (j != 1))
      {
        if (j == 2)
        {
          f2 = this.jdField_d_of_type_Float / 2.0F * (this.jdField_b_of_type_Int / this.jdField_a_of_type_Int);
          f1 = f2;
          if (this.jdField_c_of_type_Boolean) {
            f1 = f2 + 0.5F - this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth();
          }
          paramCanvas.drawCircle(f3, f4, f1, this.jdField_c_of_type_AndroidGraphicsPaint);
        }
        else
        {
          paramCanvas = new StringBuilder();
          paramCanvas.append("Invalid Progress Fill = ");
          paramCanvas.append(this.jdField_d_of_type_Int);
          throw new IllegalArgumentException(paramCanvas.toString());
        }
      }
      else
      {
        f2 = this.jdField_b_of_type_Int * 360 / this.jdField_a_of_type_Int;
        f1 = f2;
        if (this.jdField_a_of_type_Boolean) {
          f1 = f2 - 360.0F;
        }
        f2 = f1;
        if (this.jdField_b_of_type_Boolean) {
          f2 = -f1;
        }
        if (this.jdField_d_of_type_Int == 0)
        {
          if (this.i) {
            paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, true, this.jdField_e_of_type_AndroidGraphicsPaint);
          }
          paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Int, f2, true, this.jdField_c_of_type_AndroidGraphicsPaint);
        }
        else
        {
          j = (int)(this.jdField_c_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F + 0.5F);
          localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
          f1 = j;
          ((RectF)localObject).inset(f1, f1);
          if (this.i) {
            paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.jdField_e_of_type_AndroidGraphicsPaint);
          }
          paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_Int, f2, false, this.jdField_c_of_type_AndroidGraphicsPaint);
        }
      }
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_d_of_type_Boolean))
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        Typeface localTypeface = (Typeface)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_b_of_type_JavaLangString);
        localObject = localTypeface;
        if (localTypeface == null)
        {
          localObject = localTypeface;
          if (a() != null)
          {
            AssetManager localAssetManager = a().getAssets();
            localObject = localTypeface;
            if (localAssetManager != null)
            {
              localObject = Typeface.createFromAsset(localAssetManager, this.jdField_b_of_type_JavaLangString);
              jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.jdField_b_of_type_JavaLangString, localObject);
            }
          }
        }
        this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface((Typeface)localObject);
      }
      j = (int)f3;
      int k = (int)(f4 - (this.jdField_b_of_type_AndroidGraphicsPaint.descent() + this.jdField_b_of_type_AndroidGraphicsPaint.ascent()) / 2.0F);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, j, k, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localObject != null) && (this.jdField_e_of_type_Boolean))
    {
      if (this.h)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localRect.width(), localRect.height());
      }
      else
      {
        j = ((Drawable)localObject).getIntrinsicWidth();
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, j, j);
        this.jdField_a_of_type_AndroidGraphicsRect.offset((localRect.width() - j) / 2, (localRect.height() - j) / 2);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
      paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public void e(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void f(int paramInt)
  {
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public void g(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.jdField_d_of_type_Float;
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.jdField_d_of_type_Float;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void h(int paramInt)
  {
    this.jdField_c_of_type_Float = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_c_of_type_Float);
    invalidateSelf();
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidGraphicsPaint.getStyle() == Paint.Style.STROKE)
    {
      this.jdField_b_of_type_Float = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
      this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
      invalidateSelf();
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return super.onLevelChange(paramInt);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressPieDrawable
 * JD-Core Version:    0.7.0.1
 */