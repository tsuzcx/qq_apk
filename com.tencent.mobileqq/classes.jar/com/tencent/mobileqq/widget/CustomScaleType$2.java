package com.tencent.mobileqq.widget;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

final class CustomScaleType$2
  implements AnyScaleTypeImageView.DisplayRuleDef
{
  public Matrix a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f = Math.max(paramInt1 / i, paramInt2 / j);
    localMatrix.setScale(f, f);
    f = (int)0.5F;
    localMatrix.postTranslate(f, f);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomScaleType.2
 * JD-Core Version:    0.7.0.1
 */