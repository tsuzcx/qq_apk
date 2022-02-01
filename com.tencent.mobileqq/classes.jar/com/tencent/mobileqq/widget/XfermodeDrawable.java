package com.tencent.mobileqq.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;
import com.tencent.theme.SkinnableBitmapDrawable;

public class XfermodeDrawable
  extends DrawableContainer
{
  private XfermodeDrawable.XfermodeState a;
  
  private XfermodeDrawable(XfermodeDrawable.XfermodeState paramXfermodeState, Resources paramResources)
  {
    this.a = paramXfermodeState;
    a(this.a);
  }
  
  private static Paint a(Drawable paramDrawable)
  {
    Paint localPaint = null;
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof XfermodeDrawable)) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getPaint();
    }
    if ((paramDrawable instanceof NinePatchDrawable)) {
      return ((NinePatchDrawable)paramDrawable).getPaint();
    }
    if ((paramDrawable instanceof ShapeDrawable)) {
      return ((ShapeDrawable)paramDrawable).getPaint();
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)paramDrawable).getPaint();
    }
    if ((paramDrawable instanceof DrawableContainer)) {
      localPaint = a(((DrawableContainer)paramDrawable).a());
    }
    return localPaint;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = a(this.a.a);
    Xfermode localXfermode = this.a.c;
    if ((localPaint != null) && (localPaint.getXfermode() != localXfermode)) {
      localPaint.setXfermode(localXfermode);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.XfermodeDrawable
 * JD-Core Version:    0.7.0.1
 */