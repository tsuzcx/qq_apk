package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import bpnt;
import com.tencent.qphone.base.util.QLog;

public class DragAnimationMgr$DragViewIcon
  extends View
  implements Runnable
{
  float jdField_a_of_type_Float = 0.5F;
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int;
  Paint jdField_b_of_type_AndroidGraphicsPaint;
  public boolean b;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  int e;
  int f;
  int g = 0;
  int h = -1;
  int i;
  int j;
  
  public DragAnimationMgr$DragViewIcon(DragAnimationMgr paramDragAnimationMgr, Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  private int a(int paramInt)
  {
    if (paramInt < 0) {
      return -this.jdField_c_of_type_Int;
    }
    return this.jdField_d_of_type_Int;
  }
  
  private void a()
  {
    setLayerType(1, null);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(0);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF)
  {
    paramCanvas.drawRect(paramRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.j = ((int)paramRectF.width());
  }
  
  private int b()
  {
    if (this.g < 0) {}
    for (int k = this.jdField_c_of_type_Int + this.g;; k = this.jdField_d_of_type_Int - this.g)
    {
      int m = k;
      if (k < 0) {
        m = 0;
      }
      return m;
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_Int = getWidth();
    this.jdField_b_of_type_Int = getHeight();
    if (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    if (this.jdField_b_of_type_Float == 0.0F)
    {
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Int / 2);
      this.jdField_c_of_type_Float = (this.jdField_b_of_type_Int / 2);
      this.f = ((int)(this.jdField_b_of_type_Int * this.jdField_a_of_type_Float));
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    float f1 = this.jdField_b_of_type_Int / 2.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
    if (this.g == 0) {
      paramCanvas.drawCircle(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    label157:
    label1082:
    label1086:
    for (;;)
    {
      f1 = Math.abs(DragAnimationMgr.a(this.this$0).i - DragAnimationMgr.a(this.this$0).jdField_c_of_type_Float);
      int k = DragAnimationMgr.a(this.this$0).getHeight() / 2;
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "upScreenAnimation: currentY=" + DragAnimationMgr.a(this.this$0).i + " startY=" + DragAnimationMgr.a(this.this$0).jdField_c_of_type_Float + " moveYOffset=" + f1 + " parentHeightHalf=" + k);
      }
      int n;
      if (f1 > k)
      {
        if (!this.jdField_c_of_type_Boolean) {
          break;
        }
        this.jdField_c_of_type_Boolean = false;
        postDelayed(this, 5L);
        return;
        n = b();
        if (Math.abs(this.g) <= this.f) {
          if (n < this.e) {
            k = 1;
          }
        }
      }
      for (;;)
      {
        if (k == 0) {
          break label1086;
        }
        float f2;
        if (n < this.e)
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            this.i = this.j;
            this.jdField_c_of_type_Boolean = true;
            postDelayed(this, 5L);
          }
          if (n == 0)
          {
            if (this.g < 0)
            {
              this.g = (-this.jdField_c_of_type_Int);
              paramCanvas.drawCircle(this.jdField_b_of_type_Float - this.jdField_c_of_type_Int, this.jdField_c_of_type_Float, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
              break label157;
              paramCanvas.drawCircle(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
              paramCanvas.drawCircle(this.jdField_b_of_type_Float + this.g, this.jdField_c_of_type_Float, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
              if (this.g < 0) {
                this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Float + this.g, 0.0F, this.jdField_b_of_type_Float, this.jdField_b_of_type_Int);
              }
              for (;;)
              {
                a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRectF);
                this.jdField_a_of_type_Boolean = false;
                if (!this.jdField_c_of_type_Boolean) {
                  break label1082;
                }
                this.jdField_c_of_type_Boolean = false;
                this.jdField_d_of_type_Boolean = false;
                if (this.jdField_b_of_type_Boolean) {
                  break label1082;
                }
                postDelayed(this, 5L);
                k = 0;
                break;
                this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Float, 0.0F, this.jdField_b_of_type_Float + this.g, this.jdField_b_of_type_Int);
              }
              k = 1;
              continue;
            }
            paramCanvas.drawCircle(this.jdField_b_of_type_Float + this.jdField_d_of_type_Int, this.jdField_c_of_type_Float, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
            this.g = this.jdField_d_of_type_Int;
            break label157;
          }
          k = (int)(n * 1.0F / this.e * this.i);
          int m;
          if (this.g < 0)
          {
            m = n - this.jdField_c_of_type_Int;
            k += n - this.jdField_c_of_type_Int;
          }
          for (;;)
          {
            paramCanvas.drawCircle(this.jdField_b_of_type_Float + m, this.jdField_c_of_type_Float, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
            paramCanvas.drawCircle(this.jdField_b_of_type_Float + k, this.jdField_c_of_type_Float, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
            RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
            f1 = this.jdField_b_of_type_Float;
            f2 = m;
            float f3 = this.jdField_b_of_type_Float;
            localRectF.set(f2 + f1, 0.0F, k + f3, this.jdField_b_of_type_Int);
            a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRectF);
            break;
            m = this.jdField_d_of_type_Int - n - k;
            k = this.jdField_d_of_type_Int - n;
          }
        }
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_d_of_type_Boolean = true;
          if (!this.jdField_b_of_type_Boolean) {
            postDelayed(this, 5L);
          }
        }
        if (this.g < 0)
        {
          k = this.g + this.f;
          this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Float + this.g, 0.0F, this.jdField_b_of_type_Float + k, this.jdField_b_of_type_Int);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DragAnimationMgr", 2, "onDraw: maxIconWidth=" + this.f + " width=" + this.jdField_a_of_type_AndroidGraphicsRectF.width() + " radius=" + f1 + " mHeight=" + this.jdField_b_of_type_Int);
          }
          f2 = this.jdField_b_of_type_Float;
          paramCanvas.drawCircle(k + f2, this.jdField_c_of_type_Float, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.drawCircle(this.jdField_b_of_type_Float + this.g, this.jdField_c_of_type_Float, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
          a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRectF);
          break;
          k = this.g - this.f;
          this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Float + k, 0.0F, this.jdField_b_of_type_Float + this.g, this.jdField_b_of_type_Int);
        }
        k = b();
        if ((this.jdField_c_of_type_Boolean) || (k >= this.e)) {
          break;
        }
        this.jdField_a_of_type_Boolean = false;
        return;
        k = 0;
      }
    }
  }
  
  public void run()
  {
    if (this.g < 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (!this.jdField_b_of_type_Boolean) {
        DragAnimationMgr.a(this.this$0, this.jdField_c_of_type_Boolean, bool, this.jdField_d_of_type_Boolean);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr.DragViewIcon
 * JD-Core Version:    0.7.0.1
 */