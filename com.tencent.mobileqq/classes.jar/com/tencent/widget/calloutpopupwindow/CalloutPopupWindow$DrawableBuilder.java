package com.tencent.widget.calloutpopupwindow;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import com.tencent.mobileqq.util.DisplayUtil;

public class CalloutPopupWindow$DrawableBuilder
{
  private int jdField_a_of_type_Int;
  private CalloutPopupWindow.Builder jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder;
  private int b;
  private int c = 12;
  private int d = 8;
  
  public CalloutPopupWindow$DrawableBuilder(CalloutPopupWindow.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder = paramBuilder;
  }
  
  private int a(float paramFloat)
  {
    return DisplayUtil.a(CalloutPopupWindow.Builder.a(this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder), paramFloat);
  }
  
  private static int a(int paramInt)
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
  
  private static Drawable a(float paramFloat, int paramInt)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt);
    return localShapeDrawable;
  }
  
  private static Drawable a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new TriangleShape(a(paramInt3));
    ((TriangleShape)localObject).resize(paramInt1, paramInt2);
    localObject = new ShapeDrawable((Shape)localObject);
    ((ShapeDrawable)localObject).setIntrinsicWidth(paramInt1);
    ((ShapeDrawable)localObject).setIntrinsicHeight(paramInt2);
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt4);
    return localObject;
  }
  
  public CalloutPopupWindow.Builder a()
  {
    Drawable localDrawable1 = a(a(this.jdField_a_of_type_Int), this.b);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder.c(localDrawable1);
    localDrawable1 = a(a(this.c), a(this.d), 49, this.b);
    Drawable localDrawable2 = a(a(this.d), a(this.c), 51, this.b);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder.b(localDrawable2);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder.a(localDrawable1);
    return this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder;
  }
  
  public DrawableBuilder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public DrawableBuilder b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder
 * JD-Core Version:    0.7.0.1
 */