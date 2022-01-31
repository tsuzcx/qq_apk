package com.tencent.mobileqq.shortvideo.dancemachine;

import aiff;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class GlView
{
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  public static boolean h;
  protected float a;
  private int jdField_a_of_type_Int = 1;
  protected aiff a;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Transformation jdField_a_of_type_AndroidViewAnimationTransformation;
  protected Color4f a;
  protected GLViewContext a;
  private String jdField_a_of_type_JavaLangString;
  protected FloatBuffer a;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  protected PointF[] a;
  private int jdField_b_of_type_Int = 0;
  protected RectF b;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[8];
  protected RectF c;
  private float[] c;
  private float[] d = new float[2];
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected boolean i;
  protected boolean j;
  protected boolean k;
  protected boolean l = false;
  protected boolean m = false;
  protected boolean n = false;
  
  static
  {
    jdField_h_of_type_Boolean = false;
  }
  
  public GlView(GLViewContext paramGLViewContext, String paramString)
  {
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineColor4f = new Color4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.jdField_h_of_type_Int = 2;
    this.jdField_i_of_type_Int = 4;
    this.jdField_a_of_type_Float = -0.5F;
    this.jdField_c_of_type_ArrayOfFloat = new float[2];
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext = paramGLViewContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aiff = GLShaderManager.a(paramString);
    this.k = false;
    this.l = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(paramInt * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    while (i1 < paramInt2)
    {
      this.jdField_c_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(paramInt1 + i1)].x;
      this.jdField_c_of_type_ArrayOfFloat[1] = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(paramInt1 + i1)].y;
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.d, this.jdField_c_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(paramInt1 + i1)].x = this.d[0];
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(paramInt1 + i1)].y = this.d[1];
      i1 += 1;
    }
  }
  
  private void a(RectF paramRectF)
  {
    paramRectF.left = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x;
    paramRectF.top = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y;
    paramRectF.right = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[2].x;
    paramRectF.bottom = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[2].y;
  }
  
  private void b(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = paramAnimation;
    if (paramAnimation != null)
    {
      if (paramAnimation.getStartTime() == -1L) {
        paramAnimation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
      }
      paramAnimation.reset();
    }
  }
  
  private boolean b()
  {
    return (this.jdField_b_of_type_Int & 0x10000) == 65536;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null)
    {
      if ((this.jdField_a_of_type_AndroidViewAnimationAnimation instanceof TranslateAnimation)) {
        return true;
      }
      if ((this.jdField_a_of_type_AndroidViewAnimationAnimation instanceof AnimationSet))
      {
        Iterator localIterator = ((AnimationSet)this.jdField_a_of_type_AndroidViewAnimationAnimation).getAnimations().iterator();
        while (localIterator.hasNext()) {
          if (((Animation)localIterator.next() instanceof TranslateAnimation)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Int & 0x2) == 2)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 1);
      return;
    }
    if ((this.jdField_a_of_type_Int & 0x4) == 4)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(0, 768);
      return;
    }
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
  }
  
  private void g()
  {
    GLES20.glDisable(3042);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[1].y <= 0.0F)
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].set(0.0F, 0.0F);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[1].set(0.0F, 0.0F);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[2].set(0.0F, 0.0F);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[3].set(0.0F, 0.0F);
      int i1 = 0;
      while (i1 < this.jdField_b_of_type_ArrayOfFloat.length)
      {
        this.jdField_b_of_type_ArrayOfFloat[0] = 0.0F;
        i1 += 1;
      }
    }
    if (this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y < 0.0F)
    {
      float f1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[1].y - this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y;
      f1 = (f1 - this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[1].y) / f1;
      this.jdField_b_of_type_ArrayOfFloat[0] = 0.0F;
      this.jdField_b_of_type_ArrayOfFloat[1] = f1;
      this.jdField_b_of_type_ArrayOfFloat[2] = 0.0F;
      this.jdField_b_of_type_ArrayOfFloat[3] = 1.0F;
      this.jdField_b_of_type_ArrayOfFloat[4] = 1.0F;
      this.jdField_b_of_type_ArrayOfFloat[5] = 1.0F;
      this.jdField_b_of_type_ArrayOfFloat[6] = 1.0F;
      this.jdField_b_of_type_ArrayOfFloat[7] = f1;
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y = 0.0F;
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[3].y = 0.0F;
    }
  }
  
  private void i()
  {
    if (this.jdField_h_of_type_Int == 0) {
      GLES20.glDrawArrays(5, 0, this.g);
    }
    do
    {
      return;
      if (this.jdField_h_of_type_Int == 1)
      {
        GLES20.glDrawArrays(4, 0, this.g);
        return;
      }
      if (this.jdField_h_of_type_Int == 2)
      {
        GLES20.glDrawArrays(6, 0, this.g);
        return;
      }
    } while (this.jdField_h_of_type_Int != 3);
    GLES20.glDrawArrays(0, 0, this.g);
  }
  
  public Animation a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationAnimation;
  }
  
  public void a()
  {
    if (this.j) {
      r();
    }
  }
  
  public void a(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      paramAnimation.setStartTime(-1L);
      b(paramAnimation);
    }
  }
  
  protected boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.k;
    this.k = false;
    if ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected void an_()
  {
    int i1 = ((Integer)this.jdField_a_of_type_Aiff.jdField_a_of_type_JavaUtilHashMap.get("a_position")).intValue();
    GLES20.glVertexAttribPointer(i1, 3, 5126, false, 0, 0);
    GLES20.glEnableVertexAttribArray(i1);
    i1 = ((Integer)this.jdField_a_of_type_Aiff.jdField_a_of_type_JavaUtilHashMap.get("a_texCoord")).intValue();
    GLES20.glVertexAttribPointer(i1, 2, 5126, false, 0, this.jdField_a_of_type_Aiff.b() * this.jdField_i_of_type_Int * 4);
    GLES20.glEnableVertexAttribArray(i1);
    i1 = ((Integer)this.jdField_a_of_type_Aiff.jdField_a_of_type_JavaUtilHashMap.get("a_color")).intValue();
    GLES20.glVertexAttribPointer(i1, 4, 5126, false, 0, this.jdField_a_of_type_Aiff.c() * this.jdField_i_of_type_Int * 4);
    GLES20.glEnableVertexAttribArray(i1);
    i1 = ((Integer)this.jdField_a_of_type_Aiff.b.get("u_texture")).intValue();
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.f);
    GLES20.glUniform1i(i1, 0);
  }
  
  protected void ao_()
  {
    k();
    n();
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    c(this.jdField_a_of_type_Float);
    if ((this.jdField_i_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsRectF.contains(this.jdField_c_of_type_AndroidGraphicsRectF)))
    {
      float f1 = (this.jdField_c_of_type_AndroidGraphicsRectF.left - this.jdField_b_of_type_AndroidGraphicsRectF.left) / this.jdField_b_of_type_AndroidGraphicsRectF.width();
      float f2 = (this.jdField_b_of_type_AndroidGraphicsRectF.right - this.jdField_c_of_type_AndroidGraphicsRectF.right) / this.jdField_b_of_type_AndroidGraphicsRectF.width();
      float f3 = (this.jdField_c_of_type_AndroidGraphicsRectF.top - this.jdField_b_of_type_AndroidGraphicsRectF.top) / this.jdField_b_of_type_AndroidGraphicsRectF.height();
      float f4 = (this.jdField_b_of_type_AndroidGraphicsRectF.bottom - this.jdField_c_of_type_AndroidGraphicsRectF.bottom) / this.jdField_b_of_type_AndroidGraphicsRectF.height();
      this.jdField_a_of_type_JavaNioFloatBuffer.put(f1);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(f3);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(f1);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F - f4);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F - f2);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F - f4);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F - f2);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(f3);
    }
    for (;;)
    {
      o();
      this.g = 4;
      this.jdField_h_of_type_Int = 2;
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_b_of_type_ArrayOfFloat);
        this.jdField_a_of_type_Boolean = false;
      }
      else
      {
        this.jdField_a_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
      }
    }
  }
  
  public RectF b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  final void c(float paramFloat)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.b().equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a());
    int i1 = 0;
    if (i1 < this.jdField_i_of_type_Int)
    {
      if (bool) {
        this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[i1].x);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[i1].y);
        this.jdField_a_of_type_JavaNioFloatBuffer.put(paramFloat);
        i1 += 1;
        break;
        if (jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a().width() - this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[i1].x);
        } else {
          this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[i1].x);
        }
      }
    }
  }
  
  public void d() {}
  
  public void d(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineColor4f.a(1.0F, 1.0F, 1.0F, paramFloat);
    this.k = true;
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    d(1.0F);
  }
  
  public void f(int paramInt)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Aiff == null) {
      DanceLog.a("GlView", "GlView: initView mProgramObject=null");
    }
    for (;;)
    {
      return;
      this.jdField_i_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Aiff.a() * this.jdField_i_of_type_Int);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = new PointF[this.jdField_i_of_type_Int];
      GLES20.glGenBuffers(1, this.jdField_a_of_type_ArrayOfInt, 0);
      paramInt = i1;
      while (paramInt < this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[paramInt] = new PointF();
        paramInt += 1;
      }
    }
  }
  
  public void f_(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public final void g(int paramInt)
  {
    this.jdField_a_of_type_Int = (paramInt & 0x7);
  }
  
  final void k()
  {
    l();
    m();
  }
  
  final void l()
  {
    if (!this.m)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(this.jdField_b_of_type_AndroidGraphicsRectF);
      this.m = true;
    }
  }
  
  final void m()
  {
    if (!this.n)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(this.jdField_c_of_type_AndroidGraphicsRectF);
      this.n = true;
    }
  }
  
  void n()
  {
    Rect localRect = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a();
    Animation localAnimation = a();
    int i1;
    int i2;
    if (localAnimation != null)
    {
      if (!localAnimation.isInitialized())
      {
        localAnimation.initialize((int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height(), localRect.width(), localRect.height());
        p();
      }
      if (this.jdField_a_of_type_AndroidViewAnimationTransformation == null) {
        this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
      }
      this.jdField_a_of_type_AndroidViewAnimationTransformation.getMatrix().reset();
      this.jdField_a_of_type_AndroidViewAnimationTransformation.setAlpha(1.0F);
      boolean bool2 = localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation);
      if ((b()) && (localAnimation.hasEnded())) {
        q();
      }
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (localAnimation.getFillAfter()) {
          bool1 = true;
        }
      }
      if (bool1)
      {
        d(this.jdField_a_of_type_AndroidViewAnimationTransformation.getAlpha());
        if (!this.jdField_a_of_type_AndroidViewAnimationTransformation.getMatrix().isIdentity())
        {
          this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
          this.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidViewAnimationTransformation.getMatrix());
          if (!c()) {
            this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_c_of_type_AndroidGraphicsRectF.left, this.jdField_c_of_type_AndroidGraphicsRectF.top);
          }
          this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].set(0.0F, 0.0F);
          this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[1].set(0.0F, this.jdField_c_of_type_AndroidGraphicsRectF.height());
          this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[2].set(this.jdField_c_of_type_AndroidGraphicsRectF.width(), this.jdField_c_of_type_AndroidGraphicsRectF.height());
          this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[3].set(this.jdField_c_of_type_AndroidGraphicsRectF.width(), 0.0F);
          a(0, 4);
          a(this.jdField_a_of_type_AndroidGraphicsRectF);
          i1 = 1;
          i2 = 1;
        }
      }
    }
    for (;;)
    {
      if (i1 == 0) {
        d(1.0F);
      }
      if (i2 == 0)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].set(this.jdField_c_of_type_AndroidGraphicsRectF.left, this.jdField_c_of_type_AndroidGraphicsRectF.top);
        this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[1].set(this.jdField_c_of_type_AndroidGraphicsRectF.left, this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
        this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[2].set(this.jdField_c_of_type_AndroidGraphicsRectF.right, this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
        this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[3].set(this.jdField_c_of_type_AndroidGraphicsRectF.right, this.jdField_c_of_type_AndroidGraphicsRectF.top);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRectF);
      }
      if (this.l)
      {
        h();
        this.jdField_a_of_type_Boolean = true;
      }
      return;
      i1 = 1;
      i2 = 0;
      continue;
      i1 = 0;
      i2 = 0;
    }
  }
  
  final void o()
  {
    int i1 = 0;
    while (i1 < this.jdField_i_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineColor4f.a(this.jdField_a_of_type_JavaNioFloatBuffer);
      i1 += 1;
    }
  }
  
  protected void p()
  {
    this.jdField_b_of_type_Int |= 0x10000;
  }
  
  protected void q()
  {
    this.jdField_b_of_type_Int &= 0xFFFEFFFF;
  }
  
  public final void r()
  {
    if (this.jdField_a_of_type_Aiff == null)
    {
      DanceLog.a("GlView", "GlView: drawInternal mProgramObject=null");
      return;
    }
    f();
    GLES20.glViewport(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a().left, this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a().top, this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a().width(), this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a().height());
    GLES20.glUseProgram(this.jdField_a_of_type_Aiff.jdField_a_of_type_Int);
    GLES20.glUniformMatrix4fv(((Integer)this.jdField_a_of_type_Aiff.b.get("u_projectionMatrix")).intValue(), 1, false, this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(), 0);
    GLES20.glBindBuffer(34962, this.jdField_a_of_type_ArrayOfInt[0]);
    GlUtil.a("glBindBuffer");
    if (a())
    {
      ao_();
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      GLES20.glBufferData(34962, this.jdField_a_of_type_JavaNioFloatBuffer.capacity() * 4, this.jdField_a_of_type_JavaNioFloatBuffer, 35044);
    }
    an_();
    i();
    GLES20.glBindBuffer(34962, 0);
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GlView
 * JD-Core Version:    0.7.0.1
 */