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
import com.tencent.mobileqq.utils.ViewUtils;

public class MultiCardMaskView
  extends View
{
  private float jdField_a_of_type_Float = ViewUtils.b(12.0F);
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
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      float f = this.jdField_a_of_type_Float;
      localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardMaskView
 * JD-Core Version:    0.7.0.1
 */