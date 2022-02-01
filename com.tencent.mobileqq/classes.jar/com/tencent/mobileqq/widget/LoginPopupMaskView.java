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
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      if ((this.jdField_a_of_type_AndroidGraphicsPath == null) || (i != this.jdField_a_of_type_Int) || (j != this.b))
      {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
        localObject = this.jdField_a_of_type_AndroidGraphicsPath;
        float f1 = i;
        ((Path)localObject).moveTo(f1, j - this.c);
        localObject = this.jdField_a_of_type_AndroidGraphicsPath;
        float f2 = i - this.c * 2;
        float f3 = j - this.c * 2;
        float f4 = j;
        ((Path)localObject).arcTo(new RectF(f2, f3, f1, f4), 0.0F, 90.0F);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.c, f4);
        this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(0.0F, j - this.c * 2, this.c * 2, f4), 90.0F, 90.0F);
        this.jdField_a_of_type_AndroidGraphicsPath.close();
        this.jdField_a_of_type_Int = i;
        this.b = j;
        localObject = Shader.TileMode.CLAMP;
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, f4, new int[] { 15922167, -2132417049, -2565928 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDraw error2:");
      ((StringBuilder)localObject).append(paramCanvas.getMessage());
      QLog.e("LoginPopupMaskView", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.LoginPopupMaskView
 * JD-Core Version:    0.7.0.1
 */