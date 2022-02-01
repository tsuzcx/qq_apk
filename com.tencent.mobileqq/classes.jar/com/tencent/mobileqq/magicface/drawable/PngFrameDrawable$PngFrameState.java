package com.tencent.mobileqq.magicface.drawable;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.qphone.base.util.QLog;

final class PngFrameDrawable$PngFrameState
  extends Drawable.ConstantState
{
  String[] a;
  String[] b;
  int c;
  int d;
  int e = 119;
  boolean f;
  Paint g = new Paint(6);
  Shader.TileMode h = null;
  Shader.TileMode i = null;
  int j = 160;
  
  public PngFrameDrawable$PngFrameState(PngPlayParam paramPngPlayParam)
  {
    if (paramPngPlayParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PngFrameDrawable", 2, "【ramdom magic】 png frame param is null.");
      }
      throw new IllegalArgumentException("【ramdom magic】 png frame param is null.");
    }
    this.a = paramPngPlayParam.e;
    this.b = paramPngPlayParam.f;
    this.c = paramPngPlayParam.c;
    this.d = paramPngPlayParam.b;
    this.f = paramPngPlayParam.g;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new PngFrameDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func newDrawable");
    }
    return new PngFrameDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameDrawable.PngFrameState
 * JD-Core Version:    0.7.0.1
 */