package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class TipsLinearLayout
  extends LinearLayout
{
  private boolean a = false;
  private boolean b = true;
  private long c;
  private float d = 0.0F;
  private int e;
  private int f = 0;
  private TipsLinearLayout.TipsLayoutAnimListener g;
  
  public TipsLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TipsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public TipsLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(long paramLong)
  {
    float f3 = getMeasuredHeight();
    float f1 = f3 / 300.0F;
    f1 = (float)paramLong * f1;
    float f2 = f1;
    if (f1 > f3) {
      f2 = f3;
    }
    int i = this.f;
    float f4 = 0.0F;
    f1 = f4;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2) {
          f1 = f4;
        } else {
          f1 = -f2;
        }
      }
      else {
        f1 = f2 - f3;
      }
    }
    return (int)f1;
  }
  
  private void a(int paramInt)
  {
    this.a = true;
    this.b = true;
    this.f = paramInt;
    invalidate();
  }
  
  private void c()
  {
    if (this.g == null) {
      return;
    }
    if (this.f == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TipsLinearLayout", 2, "ANIM_IN end.");
      }
      this.g.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "ANIM_OUT end.");
    }
    this.g.b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "startInAnimation");
    }
    a(1);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "startOutAnimation");
    }
    a(2);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "Draw....");
    }
    if ((this.a) && (this.b))
    {
      this.c = SystemClock.uptimeMillis();
      this.b = false;
    }
    long l = SystemClock.uptimeMillis() - this.c;
    if ((this.a) && (!this.b) && (l >= 300L))
    {
      this.a = false;
      this.b = true;
      c();
    }
    if ((this.a) && (!this.b)) {
      this.e = a(l);
    } else if (this.f == 2) {
      this.e = (0 - getMeasuredHeight());
    } else {
      this.e = 0;
    }
    int i = paramCanvas.save();
    paramCanvas.translate(0.0F, this.e);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    if (!this.b) {
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setmTipsLayoutAnimListener(TipsLinearLayout.TipsLayoutAnimListener paramTipsLayoutAnimListener)
  {
    this.g = paramTipsLayoutAnimListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.TipsLinearLayout
 * JD-Core Version:    0.7.0.1
 */