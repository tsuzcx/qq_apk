package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class LoginPopupMaskView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private int b;
  private int c = 26;
  
  public LoginPopupMaskView(Context paramContext)
  {
    super(paramContext);
  }
  
  private int a(float paramFloat, Resources paramResources)
  {
    return ViewUtils.a(paramFloat);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      if ((this.jdField_a_of_type_AndroidGraphicsPath == null) || (i != this.jdField_a_of_type_Int) || (j != this.b))
      {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(i, j - this.c);
        this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(i - this.c * 2, j - this.c * 2, i, j), 0.0F, 90.0F);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.c, j);
        this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(0.0F, j - this.c * 2, this.c * 2, j), 90.0F, 90.0F);
        this.jdField_a_of_type_AndroidGraphicsPath.close();
        this.jdField_a_of_type_Int = i;
        this.b = j;
        float f = j;
        Object localObject = Shader.TileMode.CLAMP;
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 15922167, -2132417049, -2565928 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
      }
      paramCanvas.save();
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      paramCanvas.drawRect(0.0F, 0.0F, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
      return;
    }
    catch (Throwable paramCanvas)
    {
      QLog.e("LoginPopupMaskView", 1, "onDraw error2:" + paramCanvas.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.LoginPopupMaskView
 * JD-Core Version:    0.7.0.1
 */