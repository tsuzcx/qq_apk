package com.tencent.mobileqq.widget;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.widget.ImageView.ScaleType;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RoundedDrawable
  extends Drawable
{
  private float jdField_a_of_type_Float = 0.0F;
  private final int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-16777216);
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Shader.TileMode jdField_a_of_type_AndroidGraphicsShader$TileMode = Shader.TileMode.CLAMP;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.FIT_CENTER;
  private boolean jdField_a_of_type_Boolean = true;
  private final boolean[] jdField_a_of_type_ArrayOfBoolean = { 1, 1, 1, 1 };
  private float jdField_b_of_type_Float = 0.0F;
  private final int jdField_b_of_type_Int;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Shader.TileMode jdField_b_of_type_AndroidGraphicsShader$TileMode = Shader.TileMode.CLAMP;
  private boolean jdField_b_of_type_Boolean = false;
  private final RectF c = new RectF();
  private final RectF d = new RectF();
  private final RectF e = new RectF();
  
  public RoundedDrawable(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Int = paramBitmap.getWidth();
    this.jdField_b_of_type_Int = paramBitmap.getHeight();
    this.c.set(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(getState(), -16777216));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = Math.max(paramDrawable.getIntrinsicWidth(), 2);
    int j = Math.max(paramDrawable.getIntrinsicHeight(), 2);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (Throwable paramDrawable)
    {
      label76:
      break label76;
    }
    QLog.e("RoundedDrawable", 1, "Failed to create bitmap from drawable!");
    return null;
  }
  
  public static Drawable a(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      if ((paramDrawable instanceof RoundedDrawable)) {
        return paramDrawable;
      }
      if ((paramDrawable instanceof LayerDrawable))
      {
        localObject = paramDrawable.mutate().getConstantState();
        if (localObject != null) {
          paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
        }
        paramDrawable = (LayerDrawable)paramDrawable;
        int j = paramDrawable.getNumberOfLayers();
        int i = 0;
        while (i < j)
        {
          localObject = paramDrawable.getDrawable(i);
          paramDrawable.setDrawableByLayerId(paramDrawable.getId(i), a((Drawable)localObject));
          i += 1;
        }
        return paramDrawable;
      }
      Bitmap localBitmap = a(paramDrawable);
      localObject = paramDrawable;
      if (localBitmap != null) {
        localObject = new RoundedDrawable(localBitmap);
      }
    }
    return localObject;
  }
  
  public static RoundedDrawable a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      return new RoundedDrawable(paramBitmap);
    }
    return null;
  }
  
  private void a()
  {
    int i = RoundedDrawable.1.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()];
    Object localObject;
    float f1;
    if (i != 1)
    {
      float f2;
      float f3;
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5)
          {
            if (i != 6)
            {
              if (i != 7)
              {
                this.d.set(this.c);
                this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.c, this.jdField_a_of_type_AndroidGraphicsRectF, Matrix.ScaleToFit.CENTER);
                this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.d);
                localObject = this.d;
                f1 = this.jdField_b_of_type_Float;
                ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
                this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.c, this.d, Matrix.ScaleToFit.FILL);
              }
              else
              {
                this.d.set(this.jdField_a_of_type_AndroidGraphicsRectF);
                localObject = this.d;
                f1 = this.jdField_b_of_type_Float;
                ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
                this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
                this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.c, this.d, Matrix.ScaleToFit.FILL);
              }
            }
            else
            {
              this.d.set(this.c);
              this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.c, this.jdField_a_of_type_AndroidGraphicsRectF, Matrix.ScaleToFit.START);
              this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.d);
              localObject = this.d;
              f1 = this.jdField_b_of_type_Float;
              ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
              this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.c, this.d, Matrix.ScaleToFit.FILL);
            }
          }
          else
          {
            this.d.set(this.c);
            this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.c, this.jdField_a_of_type_AndroidGraphicsRectF, Matrix.ScaleToFit.END);
            this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.d);
            localObject = this.d;
            f1 = this.jdField_b_of_type_Float;
            ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
            this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.c, this.d, Matrix.ScaleToFit.FILL);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
          if ((this.jdField_a_of_type_Int <= this.jdField_a_of_type_AndroidGraphicsRectF.width()) && (this.jdField_b_of_type_Int <= this.jdField_a_of_type_AndroidGraphicsRectF.height())) {
            f1 = 1.0F;
          } else {
            f1 = Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_b_of_type_Int);
          }
          f2 = (int)((this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_a_of_type_Int * f1) * 0.5F + 0.5F);
          f3 = (int)((this.jdField_a_of_type_AndroidGraphicsRectF.height() - this.jdField_b_of_type_Int * f1) * 0.5F + 0.5F);
          this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f2, f3);
          this.d.set(this.c);
          this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.d);
          localObject = this.d;
          f1 = this.jdField_b_of_type_Float;
          ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.c, this.d, Matrix.ScaleToFit.FILL);
        }
      }
      else
      {
        this.d.set(this.jdField_a_of_type_AndroidGraphicsRectF);
        localObject = this.d;
        f1 = this.jdField_b_of_type_Float;
        ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        f2 = this.jdField_a_of_type_Int;
        f3 = this.d.height();
        float f4 = this.d.width();
        float f5 = this.jdField_b_of_type_Int;
        f1 = 0.0F;
        if (f2 * f3 > f4 * f5)
        {
          f2 = this.d.height() / this.jdField_b_of_type_Int;
          f3 = (this.d.width() - this.jdField_a_of_type_Int * f2) * 0.5F;
        }
        else
        {
          f2 = this.d.width() / this.jdField_a_of_type_Int;
          f1 = (this.d.height() - this.jdField_b_of_type_Int * f2) * 0.5F;
          f3 = 0.0F;
        }
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f2, f2);
        localObject = this.jdField_a_of_type_AndroidGraphicsMatrix;
        f2 = (int)(f3 + 0.5F);
        f3 = this.jdField_b_of_type_Float;
        ((Matrix)localObject).postTranslate(f2 + f3 / 2.0F, (int)(f1 + 0.5F) + f3 / 2.0F);
      }
    }
    else
    {
      this.d.set(this.jdField_a_of_type_AndroidGraphicsRectF);
      localObject = this.d;
      f1 = this.jdField_b_of_type_Float;
      ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate((int)((this.d.width() - this.jdField_a_of_type_Int) * 0.5F + 0.5F), (int)((this.d.height() - this.jdField_b_of_type_Int) * 0.5F + 0.5F));
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.d);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(Canvas paramCanvas)
  {
    if (b(this.jdField_a_of_type_ArrayOfBoolean)) {
      return;
    }
    if (this.jdField_a_of_type_Float == 0.0F) {
      return;
    }
    float f1 = this.jdField_b_of_type_AndroidGraphicsRectF.left;
    float f2 = this.jdField_b_of_type_AndroidGraphicsRectF.top;
    float f3 = this.jdField_b_of_type_AndroidGraphicsRectF.width() + f1;
    float f4 = this.jdField_b_of_type_AndroidGraphicsRectF.height() + f2;
    float f5 = this.jdField_a_of_type_Float;
    if (this.jdField_a_of_type_ArrayOfBoolean[0] == 0)
    {
      this.e.set(f1, f2, f1 + f5, f2 + f5);
      paramCanvas.drawRect(this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_ArrayOfBoolean[1] == 0)
    {
      this.e.set(f3 - f5, f2, f3, f5);
      paramCanvas.drawRect(this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_ArrayOfBoolean[2] == 0)
    {
      this.e.set(f3 - f5, f4 - f5, f3, f4);
      paramCanvas.drawRect(this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_ArrayOfBoolean[3] == 0)
    {
      this.e.set(f1, f4 - f5, f5 + f1, f4);
      paramCanvas.drawRect(this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private static boolean a(boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfBoolean[i] != 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void b(Canvas paramCanvas)
  {
    if (b(this.jdField_a_of_type_ArrayOfBoolean)) {
      return;
    }
    if (this.jdField_a_of_type_Float == 0.0F) {
      return;
    }
    float f1 = this.jdField_b_of_type_AndroidGraphicsRectF.left;
    float f2 = this.jdField_b_of_type_AndroidGraphicsRectF.top;
    float f3 = f1 + this.jdField_b_of_type_AndroidGraphicsRectF.width();
    float f4 = f2 + this.jdField_b_of_type_AndroidGraphicsRectF.height();
    float f5 = this.jdField_a_of_type_Float;
    float f6 = this.jdField_b_of_type_Float / 2.0F;
    if (this.jdField_a_of_type_ArrayOfBoolean[0] == 0)
    {
      paramCanvas.drawLine(f1 - f6, f2, f1 + f5, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(f1, f2 - f6, f1, f2 + f5, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_ArrayOfBoolean[1] == 0)
    {
      paramCanvas.drawLine(f3 - f5 - f6, f2, f3, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(f3, f2 - f6, f3, f2 + f5, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_ArrayOfBoolean[2] == 0)
    {
      paramCanvas.drawLine(f3 - f5 - f6, f4, f3 + f6, f4, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(f3, f4 - f5, f3, f4, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_ArrayOfBoolean[3] == 0)
    {
      paramCanvas.drawLine(f1 - f6, f4, f1 + f5, f4, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(f1, f4 - f5, f1, f4, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  private static boolean b(boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfBoolean[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public RoundedDrawable a(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
    return this;
  }
  
  public RoundedDrawable a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Object localObject = new HashSet(4);
    ((Set)localObject).add(Float.valueOf(paramFloat1));
    ((Set)localObject).add(Float.valueOf(paramFloat2));
    ((Set)localObject).add(Float.valueOf(paramFloat3));
    ((Set)localObject).add(Float.valueOf(paramFloat4));
    ((Set)localObject).remove(Float.valueOf(0.0F));
    if (((Set)localObject).size() <= 1)
    {
      if (!((Set)localObject).isEmpty())
      {
        float f = ((Float)((Set)localObject).iterator().next()).floatValue();
        if ((!Float.isInfinite(f)) && (!Float.isNaN(f)) && (f >= 0.0F))
        {
          this.jdField_a_of_type_Float = f;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid radius value: ");
          ((StringBuilder)localObject).append(f);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.jdField_a_of_type_Float = 0.0F;
      }
      localObject = this.jdField_a_of_type_ArrayOfBoolean;
      int j = 0;
      if (paramFloat1 > 0.0F) {
        i = 1;
      } else {
        i = 0;
      }
      localObject[0] = i;
      localObject = this.jdField_a_of_type_ArrayOfBoolean;
      if (paramFloat2 > 0.0F) {
        i = 1;
      } else {
        i = 0;
      }
      localObject[1] = i;
      localObject = this.jdField_a_of_type_ArrayOfBoolean;
      if (paramFloat3 > 0.0F) {
        i = 1;
      } else {
        i = 0;
      }
      localObject[2] = i;
      localObject = this.jdField_a_of_type_ArrayOfBoolean;
      int i = j;
      if (paramFloat4 > 0.0F) {
        i = 1;
      }
      localObject[3] = i;
      return this;
    }
    throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
  }
  
  public RoundedDrawable a(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      paramColorStateList = ColorStateList.valueOf(0);
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(getState(), -16777216));
    return this;
  }
  
  public RoundedDrawable a(Shader.TileMode paramTileMode)
  {
    if (this.jdField_a_of_type_AndroidGraphicsShader$TileMode != paramTileMode)
    {
      this.jdField_a_of_type_AndroidGraphicsShader$TileMode = paramTileMode;
      this.jdField_a_of_type_Boolean = true;
      invalidateSelf();
    }
    return this;
  }
  
  public RoundedDrawable a(ImageView.ScaleType paramScaleType)
  {
    ImageView.ScaleType localScaleType = paramScaleType;
    if (paramScaleType == null) {
      localScaleType = ImageView.ScaleType.FIT_CENTER;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != localScaleType)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = localScaleType;
      a();
    }
    return this;
  }
  
  public RoundedDrawable a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public RoundedDrawable b(Shader.TileMode paramTileMode)
  {
    if (this.jdField_b_of_type_AndroidGraphicsShader$TileMode != paramTileMode)
    {
      this.jdField_b_of_type_AndroidGraphicsShader$TileMode = paramTileMode;
      this.jdField_a_of_type_Boolean = true;
      invalidateSelf();
    }
    return this;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      BitmapShader localBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsShader$TileMode, this.jdField_b_of_type_AndroidGraphicsShader$TileMode);
      if ((this.jdField_a_of_type_AndroidGraphicsShader$TileMode == Shader.TileMode.CLAMP) && (this.jdField_b_of_type_AndroidGraphicsShader$TileMode == Shader.TileMode.CLAMP)) {
        localBitmapShader.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Float > 0.0F)
      {
        paramCanvas.drawOval(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawOval(this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
        return;
      }
      paramCanvas.drawOval(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    if (a(this.jdField_a_of_type_ArrayOfBoolean))
    {
      float f = this.jdField_a_of_type_Float;
      if (this.jdField_b_of_type_Float > 0.0F)
      {
        paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawRoundRect(this.d, f, f, this.jdField_b_of_type_AndroidGraphicsPaint);
        a(paramCanvas);
        b(paramCanvas);
        return;
      }
      paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
      a(paramCanvas);
      return;
    }
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_b_of_type_Float > 0.0F) {
      paramCanvas.drawRect(this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int getAlpha()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
  }
  
  public ColorFilter getColorFilter()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint.getColorFilter();
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return this.jdField_a_of_type_AndroidContentResColorStateList.isStateful();
  }
  
  protected void onBoundsChange(@NonNull Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRect);
    a();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(paramArrayOfInt, 0);
    if (this.jdField_b_of_type_AndroidGraphicsPaint.getColor() != i)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(i);
      return true;
    }
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundedDrawable
 * JD-Core Version:    0.7.0.1
 */