package com.tencent.mobileqq.magicface.drawable;

import aelq;
import aemb;
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
  private aelq jdField_a_of_type_Aelq;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private PngGifEngine jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine;
  
  private PngFrameDrawable(aelq paramaelq, Resources paramResources)
  {
    this.jdField_a_of_type_Aelq = paramaelq;
    if (paramResources != null) {}
    for (this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;; this.jdField_a_of_type_Int = paramaelq.d)
    {
      a();
      return;
    }
  }
  
  public PngFrameDrawable(PngPlayParam paramPngPlayParam, Resources paramResources)
  {
    this(new aelq(paramPngPlayParam), paramResources);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func initGifEngine");
    }
    aemb localaemb = new aemb();
    localaemb.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify = this;
    localaemb.jdField_a_of_type_Int = this.jdField_a_of_type_Aelq.jdField_b_of_type_Int;
    localaemb.jdField_b_of_type_Int = this.jdField_a_of_type_Aelq.jdField_a_of_type_Int;
    if (!this.jdField_a_of_type_Aelq.jdField_a_of_type_Boolean) {}
    for (localaemb.jdField_a_of_type_ArrayOfJavaLangString = null;; localaemb.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_Aelq.jdField_a_of_type_ArrayOfJavaLangString)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine = new PngGifEngine();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a(localaemb);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine == null) {
      return;
    }
    if ((this.jdField_a_of_type_Aelq.jdField_b_of_type_ArrayOfJavaLangString != null) && (paramInt < this.jdField_a_of_type_Aelq.jdField_b_of_type_ArrayOfJavaLangString.length)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a(this.jdField_a_of_type_Aelq.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func onBitmapReady,bitmap:" + paramBitmap);
    }
    if (paramBitmap == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidateSelf();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func draw,bitmap:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_Aelq.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Aelq;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Aelq.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_Aelq.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Aelq.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameDrawable
 * JD-Core Version:    0.7.0.1
 */