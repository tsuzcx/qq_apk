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
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class RoundedImageView
  extends ImageView
{
  public static final Shader.TileMode a;
  private static final ImageView.ScaleType[] jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType = { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-16777216);
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = null;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F };
  private int jdField_b_of_type_Int;
  private Shader.TileMode jdField_b_of_type_AndroidGraphicsShader$TileMode;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean = false;
  private Shader.TileMode jdField_c_of_type_AndroidGraphicsShader$TileMode;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsShader$TileMode = Shader.TileMode.CLAMP;
  }
  
  public RoundedImageView(Context paramContext)
  {
    super(paramContext);
    paramContext = jdField_a_of_type_AndroidGraphicsShader$TileMode;
    this.jdField_b_of_type_AndroidGraphicsShader$TileMode = paramContext;
    this.jdField_c_of_type_AndroidGraphicsShader$TileMode = paramContext;
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Shader.TileMode localTileMode = jdField_a_of_type_AndroidGraphicsShader$TileMode;
    this.jdField_b_of_type_AndroidGraphicsShader$TileMode = localTileMode;
    this.jdField_c_of_type_AndroidGraphicsShader$TileMode = localTileMode;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedImageView, paramInt, 0);
    paramInt = paramContext.getInt(0, -1);
    if (paramInt >= 0) {
      setScaleType(jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType[paramInt]);
    } else {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    float f2 = paramContext.getDimensionPixelSize(3, -1);
    this.jdField_a_of_type_ArrayOfFloat[0] = paramContext.getDimensionPixelSize(6, -1);
    this.jdField_a_of_type_ArrayOfFloat[1] = paramContext.getDimensionPixelSize(7, -1);
    this.jdField_a_of_type_ArrayOfFloat[2] = paramContext.getDimensionPixelSize(5, -1);
    this.jdField_a_of_type_ArrayOfFloat[3] = paramContext.getDimensionPixelSize(4, -1);
    int j = this.jdField_a_of_type_ArrayOfFloat.length;
    paramInt = 0;
    int i = 0;
    while (paramInt < j)
    {
      paramAttributeSet = this.jdField_a_of_type_ArrayOfFloat;
      if (paramAttributeSet[paramInt] < 0.0F) {
        paramAttributeSet[paramInt] = 0.0F;
      } else {
        i = 1;
      }
      paramInt += 1;
    }
    if (i == 0)
    {
      float f1 = f2;
      if (f2 < 0.0F) {
        f1 = 0.0F;
      }
      i = this.jdField_a_of_type_ArrayOfFloat.length;
      paramInt = 0;
      while (paramInt < i)
      {
        this.jdField_a_of_type_ArrayOfFloat[paramInt] = f1;
        paramInt += 1;
      }
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
  }
  
  private static Shader.TileMode a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return Shader.TileMode.MIRROR;
      }
      return Shader.TileMode.REPEAT;
    }
    return Shader.TileMode.CLAMP;
  }
  
  private Drawable a()
  {
    Object localObject4 = getResources();
    Object localObject3 = null;
    if (localObject4 == null) {
      return null;
    }
    int i = this.jdField_a_of_type_Int;
    Object localObject1 = localObject3;
    Object localObject2;
    if (i != 0) {
      try
      {
        localObject1 = ((Resources)localObject4).getDrawable(i);
      }
      catch (Exception localException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("Unable to find resource: ");
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_Int);
        QLog.w("RoundedImageView", 1, ((StringBuilder)localObject4).toString(), localException);
        this.jdField_a_of_type_Int = 0;
        localObject2 = localObject3;
      }
    }
    return RoundedDrawable.a(localObject2);
  }
  
  private void a()
  {
    a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
  }
  
  private void a(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
  {
    if (paramDrawable == null) {
      return;
    }
    boolean bool = paramDrawable instanceof RoundedDrawable;
    int i = 0;
    if (bool)
    {
      paramDrawable = (RoundedDrawable)paramDrawable;
      paramDrawable.a(paramScaleType).a(this.jdField_a_of_type_Float).a(this.jdField_a_of_type_AndroidContentResColorStateList).a(this.d).a(this.jdField_b_of_type_AndroidGraphicsShader$TileMode).b(this.jdField_c_of_type_AndroidGraphicsShader$TileMode);
      paramScaleType = this.jdField_a_of_type_ArrayOfFloat;
      if (paramScaleType != null) {
        paramDrawable.a(paramScaleType[0], paramScaleType[1], paramScaleType[2], paramScaleType[3]);
      }
      b();
      return;
    }
    if ((paramDrawable instanceof LayerDrawable))
    {
      paramDrawable = (LayerDrawable)paramDrawable;
      int j = paramDrawable.getNumberOfLayers();
      while (i < j)
      {
        a(paramDrawable.getDrawable(i), paramScaleType);
        i += 1;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.e)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = RoundedDrawable.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ImageView.ScaleType.FIT_XY);
    }
  }
  
  private Drawable b()
  {
    Object localObject4 = getResources();
    Object localObject3 = null;
    if (localObject4 == null) {
      return null;
    }
    int i = this.jdField_b_of_type_Int;
    Object localObject1 = localObject3;
    Object localObject2;
    if (i != 0) {
      try
      {
        localObject1 = ((Resources)localObject4).getDrawable(i);
      }
      catch (Exception localException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("Unable to find resource: ");
        ((StringBuilder)localObject4).append(this.jdField_b_of_type_Int);
        QLog.w("RoundedImageView", 1, ((StringBuilder)localObject4).toString(), localException);
        this.jdField_b_of_type_Int = 0;
        localObject2 = localObject3;
      }
    }
    return RoundedDrawable.a(localObject2);
  }
  
  private void b()
  {
    Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localDrawable.mutate();
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
    if (paramColorStateList == null) {
      paramColorStateList = ColorStateList.valueOf(-16777216);
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    a();
    a(false);
    if (this.jdField_a_of_type_Float > 0.0F) {
      invalidate();
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
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    if ((arrayOfFloat[0] == paramFloat1) && (arrayOfFloat[1] == paramFloat2) && (arrayOfFloat[2] == paramFloat4) && (arrayOfFloat[3] == paramFloat3)) {
      return;
    }
    arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[3] = paramFloat3;
    arrayOfFloat[2] = paramFloat4;
    a();
    a(false);
    invalidate();
  }
  
  public void setCornerRadius(int paramInt, float paramFloat)
  {
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    if (arrayOfFloat[paramInt] == paramFloat) {
      return;
    }
    arrayOfFloat[paramInt] = paramFloat;
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
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = RoundedDrawable.a(paramBitmap);
    a();
    super.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = RoundedDrawable.a(paramDrawable);
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
      switch (RoundedImageView.1.a[paramScaleType.ordinal()])
      {
      default: 
        super.setScaleType(paramScaleType);
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        super.setScaleType(ImageView.ScaleType.FIT_XY);
      }
      a();
      a(false);
      invalidate();
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