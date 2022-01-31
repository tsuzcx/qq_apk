package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.Animation;
import java.nio.FloatBuffer;

public class GLProgressBar
  extends GlView
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private GLImage jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage = new GLImage();
  private GLImageView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private GLProgressBar.ProgressBarListener jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar$ProgressBarListener;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 1;
  private float d;
  
  public GLProgressBar(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    f(8);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(paramGLViewContext, paramString);
    h();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    this.d = (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a().width() - this.jdField_c_of_type_AndroidGraphicsRectF.left * 2.0F);
    return (this.d - paramFloat1 - paramFloat2) * (float)this.jdField_a_of_type_Long / this.jdField_c_of_type_Int;
  }
  
  private boolean b()
  {
    return (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a());
  }
  
  private void f()
  {
    float f = this.jdField_b_of_type_AndroidGraphicsRectF.width();
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Int / f);
    this.jdField_c_of_type_Float = (this.jdField_b_of_type_Int / f);
  }
  
  private void g()
  {
    float f1 = this.jdField_b_of_type_AndroidGraphicsRectF.left;
    float f2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.jdField_b_of_type_AndroidGraphicsRectF.left;
    float f3 = this.jdField_b_of_type_AndroidGraphicsRectF.top;
    float f4 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.jdField_b_of_type_AndroidGraphicsRectF.top;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b();
    this.jdField_c_of_type_AndroidGraphicsRectF.left = (f1 - f2 + ((RectF)localObject).left);
    this.jdField_c_of_type_AndroidGraphicsRectF.top = (f3 - f4 + ((RectF)localObject).top);
    this.jdField_c_of_type_AndroidGraphicsRectF.right = (this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_b_of_type_AndroidGraphicsRectF.width());
    this.jdField_c_of_type_AndroidGraphicsRectF.bottom = (this.jdField_c_of_type_AndroidGraphicsRectF.top + this.jdField_b_of_type_AndroidGraphicsRectF.height());
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineColor4f;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineColor4f.a(((Color4f)localObject).a(), ((Color4f)localObject).b(), ((Color4f)localObject).c(), ((Color4f)localObject).d());
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.jdField_c_of_type_AndroidGraphicsRectF;
  }
  
  public Animation a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
  }
  
  public GLImage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage;
  }
  
  public void a()
  {
    if (this.j)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
      if (this.jdField_a_of_type_Long > 0L) {
        r();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = ((int)(paramInt1 * this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a()));
      this.jdField_b_of_type_Int = ((int)(paramInt2 * this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a()));
      f();
      return;
    }
    throw new RuntimeException("Must called after setProgressRegion");
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Long < this.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_Long > this.jdField_c_of_type_Int) {
        this.jdField_a_of_type_Long = this.jdField_c_of_type_Int;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    while ((this.jdField_a_of_type_Long < this.jdField_c_of_type_Int) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar$ProgressBarListener == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar$ProgressBarListener.a();
  }
  
  public void a(RectF paramRectF)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b(paramRectF);
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(paramAnimation);
  }
  
  public void a(GLProgressBar.ProgressBarListener paramProgressBarListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar$ProgressBarListener = paramProgressBarListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(paramString);
  }
  
  public boolean a()
  {
    boolean bool2 = super.a();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = b();
      h();
    }
    return bool1;
  }
  
  protected void ak_()
  {
    this.f = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a();
    k();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a();
    g();
    float f1 = this.jdField_c_of_type_AndroidGraphicsRectF.width() - this.jdField_b_of_type_Int;
    float f2 = a(this.jdField_a_of_type_Int, f1);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].set(this.jdField_c_of_type_AndroidGraphicsRectF.left, this.jdField_c_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[1].set(this.jdField_c_of_type_AndroidGraphicsRectF.left, this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[2].set(this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_a_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[3].set(this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_a_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
    f2 += this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[4].set(f2, this.jdField_c_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[5].set(f2, this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[6].set(f2 + f1, this.jdField_c_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[7].set(f1 + f2, this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    c(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(0.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(0.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(0.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(0.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_c_of_type_Float);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(0.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_c_of_type_Float);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(0.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F);
    o();
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    this.g = 8;
    this.h = 0;
  }
  
  public RectF b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b();
  }
  
  public void b(RectF paramRectF)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d(paramRectF);
  }
  
  public void b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a(paramString);
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void c(RectF paramRectF)
  {
    if (!this.jdField_b_of_type_AndroidGraphicsRectF.equals(paramRectF))
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.set(paramRectF);
      l();
      this.jdField_c_of_type_AndroidGraphicsRectF.set(paramRectF);
      m();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.e();
  }
  
  public void h_(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar
 * JD-Core Version:    0.7.0.1
 */