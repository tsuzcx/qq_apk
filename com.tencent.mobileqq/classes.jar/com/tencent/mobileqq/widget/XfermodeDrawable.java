package com.tencent.mobileqq.widget;

import alfe;
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
  private alfe a;
  
  private XfermodeDrawable(alfe paramalfe, Resources paramResources)
  {
    this.a = paramalfe;
    a(this.a);
  }
  
  private static Paint a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        return null;
      } while ((paramDrawable instanceof XfermodeDrawable));
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
    } while (!(paramDrawable instanceof DrawableContainer));
    return a(((DrawableContainer)paramDrawable).a());
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = a(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    Xfermode localXfermode = this.a.jdField_a_of_type_AndroidGraphicsXfermode;
    if ((localPaint != null) && (localPaint.getXfermode() != localXfermode)) {
      localPaint.setXfermode(localXfermode);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.XfermodeDrawable
 * JD-Core Version:    0.7.0.1
 */