package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class CircleGuideView
  extends View
{
  private Paint a = new Paint();
  private Canvas b = new Canvas();
  private Bitmap c;
  private float d;
  private float e;
  private float f;
  private int g = 180;
  
  public CircleGuideView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CircleGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CircleGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a.setARGB(0, 0, 0, 0);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.a.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.c == null) {
      try
      {
        this.c = Bitmap.createBitmap(paramCanvas.getWidth(), paramCanvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.b.setBitmap(this.c);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CircleGuideView", 2, localThrowable.toString());
        }
      }
    }
    if (this.c != null)
    {
      this.b.drawColor(Color.argb(this.g, 0, 0, 0));
      this.b.drawCircle(this.d, this.e, this.f, this.a);
      Bitmap localBitmap = this.c;
      paramCanvas.drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), this.c.getHeight()), new Rect(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight()), null);
      return;
    }
    paramCanvas.drawColor(Color.argb(this.g, 0, 0, 0));
  }
  
  public void setCircle(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramFloat3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.CircleGuideView
 * JD-Core Version:    0.7.0.1
 */