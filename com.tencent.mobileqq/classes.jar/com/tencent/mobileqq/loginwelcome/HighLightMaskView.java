package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.util.VersionUtils;

public class HighLightMaskView
  extends View
{
  Path a;
  Paint b = new Paint();
  PorterDuffXfermode c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  
  public HighLightMaskView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public HighLightMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public void a()
  {
    if (this.a == null) {
      this.a = new Path();
    }
    this.a.reset();
    if (VersionUtils.e()) {
      setLayerType(1, null);
    }
    this.b.setColor(0);
    this.b.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(-1728053248);
    this.b.setXfermode(this.c);
    paramCanvas.drawPath(this.a, this.b);
    this.b.setXfermode(null);
  }
  
  public void setCircleSrc(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a.addCircle(paramFloat1, paramFloat2, paramFloat3, Path.Direction.CW);
  }
  
  public void setHighLightRect(RectF paramRectF)
  {
    this.a.addRect(paramRectF, Path.Direction.CW);
  }
  
  public void setRoundSrc(RectF paramRectF, float[] paramArrayOfFloat)
  {
    this.a.addRoundRect(paramRectF, paramArrayOfFloat, Path.Direction.CW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.HighLightMaskView
 * JD-Core Version:    0.7.0.1
 */