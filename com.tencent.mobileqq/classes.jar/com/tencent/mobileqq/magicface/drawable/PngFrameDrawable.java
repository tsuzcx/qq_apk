package com.tencent.mobileqq.magicface.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class PngFrameDrawable
  extends Drawable
  implements IRedrawNotify
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private PngFrameDrawable.PngFrameState jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState;
  private PngGifEngine jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine;
  
  private PngFrameDrawable(PngFrameDrawable.PngFrameState paramPngFrameState, Resources paramResources)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState = paramPngFrameState;
    if (paramResources != null) {
      this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
    } else {
      this.jdField_a_of_type_Int = paramPngFrameState.d;
    }
    a();
  }
  
  public PngFrameDrawable(PngPlayParam paramPngPlayParam, Resources paramResources)
  {
    this(new PngFrameDrawable.PngFrameState(paramPngPlayParam), paramResources);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func initGifEngine");
    }
    PngGifEngine.PngGifTaskParam localPngGifTaskParam = new PngGifEngine.PngGifTaskParam();
    localPngGifTaskParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify = this;
    localPngGifTaskParam.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_b_of_type_Int;
    localPngGifTaskParam.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_a_of_type_Int;
    if (!this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_a_of_type_Boolean) {
      localPngGifTaskParam.jdField_a_of_type_ArrayOfJavaLangString = null;
    } else {
      localPngGifTaskParam.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_a_of_type_ArrayOfJavaLangString;
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine = new PngGifEngine();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a(localPngGifTaskParam);
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_b_of_type_ArrayOfJavaLangString != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_b_of_type_ArrayOfJavaLangString.length)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func onBitmapReady,bitmap:");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("PngFrameDrawable", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBitmap == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidateSelf();
  }
  
  public boolean a()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    return (localBitmap != null) && (!localBitmap.isRecycled());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func draw,bitmap:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsBitmap);
      QLog.d("PngFrameDrawable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameDrawable$PngFrameState.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameDrawable
 * JD-Core Version:    0.7.0.1
 */