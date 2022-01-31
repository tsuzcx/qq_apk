package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import beuw;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class RoundedImageView
  extends ImageView
{
  public static final Shader.TileMode a;
  private static final ImageView.ScaleType[] jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType;
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-16777216);
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F };
  private int jdField_b_of_type_Int;
  private Shader.TileMode jdField_b_of_type_AndroidGraphicsShader$TileMode = jdField_a_of_type_AndroidGraphicsShader$TileMode;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  private Shader.TileMode jdField_c_of_type_AndroidGraphicsShader$TileMode = jdField_a_of_type_AndroidGraphicsShader$TileMode;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  static
  {
    if (!RoundedImageView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_AndroidGraphicsShader$TileMode = Shader.TileMode.CLAMP;
      jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType = new ImageView.ScaleType[] { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
      return;
    }
  }
  
  public RoundedImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedImageView, paramInt, 0);
    paramInt = paramContext.getInt(0, -1);
    float f;
    int i;
    if (paramInt >= 0)
    {
      setScaleType(jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType[paramInt]);
      f = paramContext.getDimensionPixelSize(3, -1);
      this.jdField_a_of_type_ArrayOfFloat[0] = paramContext.getDimensionPixelSize(6, -1);
      this.jdField_a_of_type_ArrayOfFloat[1] = paramContext.getDimensionPixelSize(7, -1);
      this.jdField_a_of_type_ArrayOfFloat[2] = paramContext.getDimensionPixelSize(5, -1);
      this.jdField_a_of_type_ArrayOfFloat[3] = paramContext.getDimensionPixelSize(4, -1);
      int j = this.jdField_a_of_type_ArrayOfFloat.length;
      paramInt = 0;
      i = 0;
      label164:
      if (paramInt >= j) {
        break label211;
      }
      if (this.jdField_a_of_type_ArrayOfFloat[paramInt] >= 0.0F) {
        break label205;
      }
      this.jdField_a_of_type_ArrayOfFloat[paramInt] = 0.0F;
    }
    for (;;)
    {
      paramInt += 1;
      break label164;
      setScaleType(ImageView.ScaleType.FIT_CENTER);
      break;
      label205:
      i = 1;
    }
    label211:
    if (i == 0)
    {
      if (f >= 0.0F) {
        break label434;
      }
      f = 0.0F;
    }
    label434:
    for (;;)
    {
      i = this.jdField_a_of_type_ArrayOfFloat.length;
      paramInt = 0;
      while (paramInt < i)
      {
        this.jdField_a_of_type_ArrayOfFloat[paramInt] = f;
        paramInt += 1;
      }
      this.jdField_a_of_type_Float = paramContext.getDimensionPixelSize(2, -1);
      if (this.jdField_a_of_type_Float < 0.0F) {
        this.jdField_a_of_type_Float = 0.0F;
      }
      this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getColorStateList(1);
      if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
        this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-16777216);
      }
      this.e = paramContext.getBoolean(8, false);
      this.d = paramContext.getBoolean(9, false);
      paramInt = paramContext.getInt(10, -2);
      if (paramInt != -2)
      {
        setTileModeX(a(paramInt));
        setTileModeY(a(paramInt));
      }
      paramInt = paramContext.getInt(11, -2);
      if (paramInt != -2) {
        setTileModeX(a(paramInt));
      }
      paramInt = paramContext.getInt(12, -2);
      if (paramInt != -2) {
        setTileModeY(a(paramInt));
      }
      a();
      a(true);
      if (this.e) {
        super.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramContext.recycle();
      return;
    }
  }
  
  private static Shader.TileMode a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Shader.TileMode.CLAMP;
    case 1: 
      return Shader.TileMode.REPEAT;
    }
    return Shader.TileMode.MIRROR;
  }
  
  private Drawable a()
  {
    Object localObject3 = null;
    Resources localResources = getResources();
    if (localResources == null) {
      return null;
    }
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_Int != 0) {}
    try
    {
      localObject1 = localResources.getDrawable(this.jdField_a_of_type_Int);
      return beuw.a((Drawable)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("RoundedImageView", 1, "Unable to find resource: " + this.jdField_a_of_type_Int, localException);
        this.jdField_a_of_type_Int = 0;
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void a()
  {
    a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
  }
  
  private void a(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
  {
    if (paramDrawable == null) {}
    for (;;)
    {
      return;
      if ((paramDrawable instanceof beuw))
      {
        ((beuw)paramDrawable).a(paramScaleType).a(this.jdField_a_of_type_Float).a(this.jdField_a_of_type_AndroidContentResColorStateList).a(this.d).a(this.jdField_b_of_type_AndroidGraphicsShader$TileMode).b(this.jdField_c_of_type_AndroidGraphicsShader$TileMode);
        if (this.jdField_a_of_type_ArrayOfFloat != null) {
          ((beuw)paramDrawable).a(this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_ArrayOfFloat[2], this.jdField_a_of_type_ArrayOfFloat[3]);
        }
        b();
        return;
      }
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int j = paramDrawable.getNumberOfLayers();
        int i = 0;
        while (i < j)
        {
          a(paramDrawable.getDrawable(i), paramScaleType);
          i += 1;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.e)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = beuw.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ImageView.ScaleType.FIT_XY);
    }
  }
  
  private Drawable b()
  {
    Object localObject3 = null;
    Resources localResources = getResources();
    if (localResources == null) {
      return null;
    }
    Object localObject1 = localObject3;
    if (this.jdField_b_of_type_Int != 0) {}
    try
    {
      localObject1 = localResources.getDrawable(this.jdField_b_of_type_Int);
      return beuw.a((Drawable)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("RoundedImageView", 1, "Unable to find resource: " + this.jdField_b_of_type_Int, localException);
        this.jdField_b_of_type_Int = 0;
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void b()
  {
    if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.mutate();
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(paramInt);
    setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    a(true);
    super.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = b();
      setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    setBorderColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setBorderColor(ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList.equals(paramColorStateList)) {
      return;
    }
    if (paramColorStateList != null) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      a();
      a(false);
      if (this.jdField_a_of_type_Float <= 0.0F) {
        break;
      }
      invalidate();
      return;
      paramColorStateList = ColorStateList.valueOf(-16777216);
    }
  }
  
  public void setBorderWidth(float paramFloat)
  {
    if (this.jdField_a_of_type_Float == paramFloat) {
      return;
    }
    this.jdField_a_of_type_Float = paramFloat;
    a();
    a(false);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    setBorderWidth(getResources().getDimension(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.jdField_a_of_type_AndroidGraphicsColorFilter != paramColorFilter)
    {
      this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      b();
      invalidate();
    }
  }
  
  public void setCornerRadius(float paramFloat)
  {
    setCornerRadius(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setCornerRadius(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.jdField_a_of_type_ArrayOfFloat[0] == paramFloat1) && (this.jdField_a_of_type_ArrayOfFloat[1] == paramFloat2) && (this.jdField_a_of_type_ArrayOfFloat[2] == paramFloat4) && (this.jdField_a_of_type_ArrayOfFloat[3] == paramFloat3)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    this.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    this.jdField_a_of_type_ArrayOfFloat[3] = paramFloat3;
    this.jdField_a_of_type_ArrayOfFloat[2] = paramFloat4;
    a();
    a(false);
    invalidate();
  }
  
  public void setCornerRadius(int paramInt, float paramFloat)
  {
    if (this.jdField_a_of_type_ArrayOfFloat[paramInt] == paramFloat) {
      return;
    }
    this.jdField_a_of_type_ArrayOfFloat[paramInt] = paramFloat;
    a();
    a(false);
    invalidate();
  }
  
  public void setCornerRadiusDimen(int paramInt)
  {
    float f = getResources().getDimension(paramInt);
    setCornerRadius(f, f, f, f);
  }
  
  public void setCornerRadiusDimen(int paramInt1, int paramInt2)
  {
    setCornerRadius(paramInt1, getResources().getDimensionPixelSize(paramInt2));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = beuw.a(paramBitmap);
    a();
    super.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = beuw.a(paramDrawable);
    a();
    super.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = a();
      a();
      super.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    setImageDrawable(getDrawable());
  }
  
  public void setOval(boolean paramBoolean)
  {
    this.d = paramBoolean;
    a();
    a(false);
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((!jdField_a_of_type_Boolean) && (paramScaleType == null)) {
      throw new AssertionError();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != paramScaleType)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
      switch (beuy.a[paramScaleType.ordinal()])
      {
      default: 
        super.setScaleType(paramScaleType);
      }
    }
    for (;;)
    {
      a();
      a(false);
      invalidate();
      return;
      super.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    if (this.jdField_b_of_type_AndroidGraphicsShader$TileMode == paramTileMode) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsShader$TileMode = paramTileMode;
    a();
    a(false);
    invalidate();
  }
  
  public void setTileModeY(Shader.TileMode paramTileMode)
  {
    if (this.jdField_c_of_type_AndroidGraphicsShader$TileMode == paramTileMode) {
      return;
    }
    this.jdField_c_of_type_AndroidGraphicsShader$TileMode = paramTileMode;
    a();
    a(false);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundedImageView
 * JD-Core Version:    0.7.0.1
 */