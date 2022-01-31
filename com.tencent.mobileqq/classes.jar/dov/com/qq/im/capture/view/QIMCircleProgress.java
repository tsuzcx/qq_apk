package dov.com.qq.im.capture.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import anpl;
import anpm;
import anpn;
import anpo;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class QIMCircleProgress
  extends ImageView
{
  public static int a;
  float jdField_a_of_type_Float = 1.0F;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = 0;
  public ValueAnimator b;
  Paint jdField_b_of_type_AndroidGraphicsPaint;
  public boolean b;
  public float c;
  int jdField_c_of_type_Int = 10;
  Paint jdField_c_of_type_AndroidGraphicsPaint;
  public boolean c;
  float jdField_d_of_type_Float = 5.0F;
  int jdField_d_of_type_Int;
  Paint jdField_d_of_type_AndroidGraphicsPaint;
  float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  int f;
  int g;
  int h;
  int i;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_Int = 10000;
  }
  
  public QIMCircleProgress(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    e();
  }
  
  public QIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    e();
  }
  
  private void e()
  {
    setLayerType(1, null);
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = getResources().getColor(2131492982);
    this.f = getResources().getColor(2131493442);
    this.jdField_e_of_type_Int = 51;
    this.g = 100;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131492969));
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.f);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
  }
  
  public float a()
  {
    return this.jdField_e_of_type_Float;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(150L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(3);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new anpl(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new anpm(this));
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new anpn(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new anpo(this));
    }
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
      c();
    }
    invalidate();
  }
  
  public void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  public void c()
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
  
  public void d()
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
    this.h = getWidth();
    this.i = getHeight();
    if (this.h <= 0) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_Int * 1.2F, this.jdField_c_of_type_Int * 1.2F, this.h - this.jdField_c_of_type_Int * 1.2F, this.i - this.jdField_c_of_type_Int * 1.2F);
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
            break label334;
          }
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth((int)(this.jdField_c_of_type_Int * (1.0D - 0.2D * this.jdField_c_of_type_Float)));
          this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth((int)(this.jdField_c_of_type_Int * (1.0D - 0.2D * this.jdField_c_of_type_Float)));
          this.jdField_d_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F * this.jdField_c_of_type_Float));
          this.jdField_d_of_type_AndroidGraphicsPaint.setShadowLayer(this.jdField_d_of_type_Float * this.jdField_c_of_type_Float, 0.0F, 0.0F, getResources().getColor(2131492969));
          paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f3, f1, false, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f3, f1, false, this.jdField_d_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Int);
        }
        for (;;)
        {
          m += 1;
          f1 = f2;
          break;
          label334:
          paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f3, f1, false, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      float f2 = 360.0F * (this.jdField_e_of_type_Float - f1) / jdField_a_of_type_Int - 4.0F;
      if (f2 > 0.0F) {
        paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 2.0F + (-90.0F + 360.0F * f1 / jdField_a_of_type_Int), f2, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      while (this.jdField_b_of_type_Int != 2)
      {
        paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.k / 2, this.jdField_b_of_type_AndroidGraphicsPaint);
        paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.j / 2, this.jdField_c_of_type_AndroidGraphicsPaint);
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
  
  public void setCenterScaleValue(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    invalidate();
  }
  
  public void setCenterView()
  {
    this.j = ViewUtils.a(24.0F);
    this.k = ViewUtils.a(54.0F);
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