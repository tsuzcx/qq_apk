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
  private Path a;
  private int b;
  private int c;
  private int d = 26;
  private Paint e = new Paint();
  
  public LoginPopupMaskView(Context paramContext)
  {
    super(paramContext);
  }
  
  private int a(float paramFloat, Resources paramResources)
  {
    return ViewUtils.dip2px(paramFloat);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      if ((this.a == null) || (i != this.b) || (j != this.c))
      {
        this.a = new Path();
        localObject = this.a;
        float f1 = i;
        ((Path)localObject).moveTo(f1, j - this.d);
        localObject = this.a;
        float f2 = i - this.d * 2;
        float f3 = j - this.d * 2;
        float f4 = j;
        ((Path)localObject).arcTo(new RectF(f2, f3, f1, f4), 0.0F, 90.0F);
        this.a.lineTo(this.d, f4);
        this.a.arcTo(new RectF(0.0F, j - this.d * 2, this.d * 2, f4), 90.0F, 90.0F);
        this.a.close();
        this.b = i;
        this.c = j;
        localObject = Shader.TileMode.CLAMP;
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, f4, new int[] { 15922167, -2132417049, -2565928 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
        this.e.setShader((Shader)localObject);
      }
      paramCanvas.save();
      paramCanvas.clipPath(this.a);
      paramCanvas.drawRect(0.0F, 0.0F, i, j, this.e);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.LoginPopupMaskView
 * JD-Core Version:    0.7.0.1
 */