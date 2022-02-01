package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.R.styleable;

public class CircleBoarderImageView
  extends ImageView
{
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_CROP;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -16777216;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private final Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  
  public CircleBoarderImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CircleBoarderImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleBoarderImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleBoarderImageView, paramInt, 0);
    this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(2, 0);
    this.jdField_a_of_type_Int = paramContext.getColor(0, -16777216);
    this.jdField_c_of_type_Boolean = paramContext.getBoolean(1, false);
    this.jdField_c_of_type_Int = paramContext.getColor(3, 0);
    paramContext.recycle();
    a();
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      Bitmap localBitmap;
      if ((paramDrawable instanceof ColorDrawable)) {
        localBitmap = Bitmap.createBitmap(2, 2, jdField_a_of_type_AndroidGraphicsBitmap$Config);
      } else {
        localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), jdField_a_of_type_AndroidGraphicsBitmap$Config);
      }
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
    return null;
  }
  
  private RectF a()
  {
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight() - getPaddingTop() - getPaddingBottom();
    int k = Math.min(i, j);
    float f1 = getPaddingLeft() + (i - k) / 2.0F;
    float f2 = getPaddingTop() + (j - k) / 2.0F;
    float f3 = k;
    return new RectF(f1, f2, f1 + f3, f3 + f2);
  }
  
  private void a()
  {
    super.setScaleType(jdField_a_of_type_AndroidWidgetImageView$ScaleType);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      d();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void b()
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
    }
  }
  
  private void c()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    } else {
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(getDrawable());
    }
    d();
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    if ((getWidth() == 0) && (getHeight() == 0)) {
      return;
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap == null)
    {
      invalidate();
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.e = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    this.jdField_b_of_type_AndroidGraphicsRectF.set(a());
    this.jdField_b_of_type_Float = Math.min((this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_b_of_type_Int) / 2.0F, (this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_b_of_type_Int) / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF);
    if (!this.jdField_c_of_type_Boolean)
    {
      int i = this.jdField_b_of_type_Int;
      if (i > 0) {
        this.jdField_a_of_type_AndroidGraphicsRectF.inset(i - 1.0F, i - 1.0F);
      }
    }
    this.jdField_a_of_type_Float = Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F);
    b();
    e();
    invalidate();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(null);
    float f1 = this.jdField_d_of_type_Int;
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
    float f4 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
    float f5 = this.e;
    float f3 = 0.0F;
    if (f1 * f2 > f4 * f5)
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.e;
      f2 = (this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_d_of_type_Int * f1) * 0.5F;
    }
    else
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_d_of_type_Int;
      f3 = (this.jdField_a_of_type_AndroidGraphicsRectF.height() - this.e * f1) * 0.5F;
      f2 = 0.0F;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((int)(f2 + 0.5F) + this.jdField_a_of_type_AndroidGraphicsRectF.left, (int)(f3 + 0.5F) + this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_AndroidGraphicsBitmapShader.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public ColorFilter getColorFilter()
  {
    return this.jdField_a_of_type_AndroidGraphicsColorFilter;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      super.onDraw(paramCanvas);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    if (this.jdField_c_of_type_Int != 0) {
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), this.jdField_a_of_type_Float, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_b_of_type_Int > 0) {
      paramCanvas.drawCircle(this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY(), this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    throw new IllegalArgumentException("adjustViewBounds not supported.");
  }
  
  public void setBorderColor(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    invalidate();
  }
  
  @Deprecated
  public void setBorderColorResource(int paramInt)
  {
    setBorderColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    d();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    d();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == this.jdField_a_of_type_AndroidGraphicsColorFilter) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
    b();
    invalidate();
  }
  
  public void setDisableCircularTransformation(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    c();
  }
  
  @Deprecated
  public void setFillColor(int paramInt)
  {
    if (paramInt == this.jdField_c_of_type_Int) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  @Deprecated
  public void setFillColorResource(int paramInt)
  {
    setFillColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    c();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    c();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    c();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    c();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == jdField_a_of_type_AndroidWidgetImageView$ScaleType) {
      return;
    }
    throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleBoarderImageView
 * JD-Core Version:    0.7.0.1
 */