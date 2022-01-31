package dov.com.qq.im.capture.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import bajq;
import bhpq;
import bhpr;
import bhps;
import bhpt;
import java.util.ArrayList;
import java.util.List;

public class QIMCircleProgress
  extends ImageView
{
  public static int a;
  protected float a;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  protected Paint a;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private List<Float> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  float b;
  protected int b;
  public ValueAnimator b;
  protected Paint b;
  public boolean b;
  public float c;
  int c;
  protected Paint c;
  public boolean c;
  float jdField_d_of_type_Float = 5.0F;
  int jdField_d_of_type_Int;
  Paint jdField_d_of_type_AndroidGraphicsPaint;
  float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  int f;
  int g;
  int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  
  static
  {
    jdField_a_of_type_Int = 10000;
  }
  
  public QIMCircleProgress(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_c_of_type_Int = 10;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  public QIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_c_of_type_Int = 10;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  public float a()
  {
    return this.jdField_e_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public List<Float> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a()
  {
    setLayerType(1, null);
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = getResources().getColor(2131099993);
    this.f = getResources().getColor(2131100565);
    this.jdField_e_of_type_Int = 51;
    this.h = 100;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131101537));
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.f);
    this.g = -1;
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.g);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == this.jdField_e_of_type_Float)
    {
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Int == 1) {
      d();
    }
    invalidate();
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.l / 2, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.k / 2, this.jdField_c_of_type_AndroidGraphicsPaint);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(150L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(3);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bhpq(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bhpr(this));
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bhps(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new bhpt(this));
    }
  }
  
  public void c()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (!this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.i = getWidth();
    this.j = getHeight();
    if (this.i <= 0) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_Int * 1.38F, this.jdField_c_of_type_Int * 1.38F, this.i - this.jdField_c_of_type_Int * 1.38F, this.j - this.jdField_c_of_type_Int * 1.38F);
      float f1 = jdField_a_of_type_Int;
      int m = 0;
      f1 *= -0.005555556F;
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        f2 = ((Float)this.jdField_a_of_type_JavaUtilList.get(m)).floatValue();
        float f3 = -90.0F + 360.0F * f1 / jdField_a_of_type_Int + 2.0F;
        f1 = 360.0F * (f2 - f1) / jdField_a_of_type_Int - 4.0F;
        if (f1 > 0.0F)
        {
          if ((!this.jdField_a_of_type_Boolean) || (m != this.jdField_a_of_type_JavaUtilList.size() - 1)) {
            break label347;
          }
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth((int)(this.jdField_c_of_type_Int * (1.0D - 0.38D * this.jdField_c_of_type_Float)));
          this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth((int)(this.jdField_c_of_type_Int * (1.0D - 0.38D * this.jdField_c_of_type_Float)));
          this.jdField_d_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F * this.jdField_c_of_type_Float));
          if (Build.VERSION.SDK_INT >= 21) {
            this.jdField_d_of_type_AndroidGraphicsPaint.setShadowLayer(this.jdField_d_of_type_Float * this.jdField_c_of_type_Float, 0.0F, 0.0F, getResources().getColor(2131101537));
          }
          paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f3, f1, false, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f3, f1, false, this.jdField_d_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Int);
        }
        for (;;)
        {
          m += 1;
          f1 = f2;
          break;
          label347:
          paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f3, f1, false, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      float f2 = 360.0F * (this.jdField_e_of_type_Float - f1) / jdField_a_of_type_Int - 4.0F;
      if (f2 > 0.0F) {
        paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 2.0F + (-90.0F + 360.0F * f1 / jdField_a_of_type_Int), f2, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      while (this.jdField_b_of_type_Int != 2)
      {
        a(paramCanvas);
        return;
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F * this.jdField_c_of_type_Float));
          paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 2.0F + (-90.0F + 360.0F * f1 / jdField_a_of_type_Int), 5.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
        }
      }
    }
  }
  
  public void setCenterCircleColor(int paramInt)
  {
    this.g = paramInt;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.g);
    invalidate();
  }
  
  public void setCenterScaleValue(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    invalidate();
  }
  
  public void setCenterView()
  {
    this.k = bajq.a(24.0F);
    this.l = bajq.a(54.0F);
  }
  
  public void setProgress(float paramFloat)
  {
    if (paramFloat > jdField_a_of_type_Int) {}
    for (float f1 = jdField_a_of_type_Int;; f1 = paramFloat)
    {
      this.jdField_e_of_type_Float = f1;
      f1 = paramFloat;
      if (paramFloat < 0.0F) {
        f1 = 0.0F;
      }
      this.jdField_e_of_type_Float = f1;
      invalidate();
      return;
    }
  }
  
  public void setProgressColor(int paramInt)
  {
    this.f = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.f);
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.jdField_c_of_type_Int = ((int)(this.jdField_b_of_type_Float * paramFloat + 0.5D));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */