package com.tencent.widget.calloutpopupwindow;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import com.tencent.mobileqq.util.DisplayUtil;

public class CalloutPopupWindow$DrawableBuilder
{
  private CalloutPopupWindow.Builder a;
  private int b;
  private int c;
  private int d = 12;
  private int e = 8;
  
  public CalloutPopupWindow$DrawableBuilder(CalloutPopupWindow.Builder paramBuilder)
  {
    this.a = paramBuilder;
  }
  
  private int a(float paramFloat)
  {
    return DisplayUtil.a(CalloutPopupWindow.Builder.a(this.a), paramFloat);
  }
  
  private static Drawable a(float paramFloat, int paramInt)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt);
    return localShapeDrawable;
  }
  
  private static Drawable a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new TriangleShape(c(paramInt3));
    ((TriangleShape)localObject).resize(paramInt1, paramInt2);
    localObject = new ShapeDrawable((Shape)localObject);
    ((ShapeDrawable)localObject).setIntrinsicWidth(paramInt1);
    ((ShapeDrawable)localObject).setIntrinsicHeight(paramInt2);
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt4);
    return localObject;
  }
  
  private static int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 32;
    case 52: 
      return 35;
    case 51: 
      return 36;
    case 50: 
      return 34;
    }
    return 33;
  }
  
  public CalloutPopupWindow.Builder a()
  {
    Drawable localDrawable1 = a(a(this.b), this.c);
    this.a.c(localDrawable1);
    localDrawable1 = a(a(this.d), a(this.e), 49, this.c);
    Drawable localDrawable2 = a(a(this.e), a(this.d), 51, this.c);
    this.a.b(localDrawable2);
    this.a.a(localDrawable1);
    return this.a;
  }
  
  public DrawableBuilder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public DrawableBuilder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder
 * JD-Core Version:    0.7.0.1
 */