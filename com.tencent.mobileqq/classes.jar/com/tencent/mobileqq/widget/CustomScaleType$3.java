package com.tencent.mobileqq.widget;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

final class CustomScaleType$3
  implements AnyScaleTypeImageView.DisplayRuleDef
{
  public Matrix a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    paramInt2 = paramDrawable.getIntrinsicWidth();
    float f = paramInt1 / paramInt2;
    localMatrix.setScale(f, f);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomScaleType.3
 * JD-Core Version:    0.7.0.1
 */