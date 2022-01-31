package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import bbll;

public class MultiCardMaskView
  extends View
{
  private float jdField_a_of_type_Float = bbll.b(12.0F);
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean = true;
  
  public MultiCardMaskView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MultiCardMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    a();
  }
  
  private void a()
  {
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    if ((Build.VERSION.SDK_INT <= 18) || (a())) {
      setLayerType(1, null);
    }
  }
  
  private boolean a()
  {
    return (Build.VERSION.SDK_INT == 24) && ("Xiaomi".equals(Build.MANUFACTURER)) && ("MIX".equals(Build.MODEL));
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, Path.Direction.CW);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardMaskView
 * JD-Core Version:    0.7.0.1
 */