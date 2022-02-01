package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class RoundImageView
  extends URLImageView
{
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_CROP;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -16777216;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public RoundImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    a();
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
        localBitmap = Bitmap.createBitmap(1, 1, jdField_a_of_type_AndroidGraphicsBitmap$Config);
      } else {
        localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), jdField_a_of_type_AndroidGraphicsBitmap$Config);
      }
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Int);
    this.d = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.c = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
    this.jdField_b_of_type_Float = Math.min((this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_b_of_type_Int) / 2.0F, (this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_b_of_type_Int) / 2.0F);
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    int i = this.jdField_b_of_type_Int;
    ((RectF)localObject).set(i, i, this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Float = Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F);
    c();
    invalidate();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(null);
    float f1 = this.c;
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
    float f4 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
    float f5 = this.d;
    float f3 = 0.0F;
    if (f1 * f2 > f4 * f5)
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.d;
      f2 = (this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.c * f1) * 0.5F;
    }
    else
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.c;
      f3 = (this.jdField_a_of_type_AndroidGraphicsRectF.height() - this.d * f1) * 0.5F;
      f2 = 0.0F;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
    Matrix localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    int i = (int)(f2 + 0.5F);
    int j = this.jdField_b_of_type_Int;
    localMatrix.postTranslate(i + j, (int)(f3 + 0.5F) + j);
    this.jdField_a_of_type_AndroidGraphicsBitmapShader.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      b();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceuu", 4, "onLoadSuccessed");
    }
    setImageDrawable(paramURLDrawable);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    b();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramDrawable);
    b();
  }
  
  public void setImageFilePath(String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str != null) && (str.equals(paramString))) {
      return;
    }
    try
    {
      setImageBitmap(BitmapFactory.decodeFile(paramString));
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("RoundImageView", 1, "setImageFilePath oom", paramString);
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(getDrawable());
    b();
  }
  
  public void setIsready()
  {
    this.jdField_a_of_type_Boolean = true;
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
 * Qualified Name:     com.tencent.mobileqq.utils.RoundImageView
 * JD-Core Version:    0.7.0.1
 */