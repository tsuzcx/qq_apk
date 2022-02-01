package com.tencent.mobileqq.surfaceviewaction.gl;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.surfaceviewaction.ISprite;
import com.tencent.mobileqq.surfaceviewaction.Point;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Sprite
  extends Node
  implements ISprite<SpriteGLView>
{
  protected ShortBuffer A;
  protected FloatBuffer B;
  protected float[] C = new float[16];
  protected Point D = new Point(0.0F, 0.0F);
  private final float[] s = { 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F };
  protected Texture w;
  protected final short[] x = { 0, 1, 2, 3, 4, 5 };
  protected final float[] y = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  protected FloatBuffer z;
  
  public Sprite()
  {
    l();
  }
  
  public Sprite(SpriteGLView paramSpriteGLView)
  {
    this.v = paramSpriteGLView;
    l();
  }
  
  public Sprite(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.v = paramSpriteGLView;
    this.w = new Texture(paramSpriteGLView, paramBitmap);
    m();
    l();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
  }
  
  public void a(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.v = paramSpriteGLView;
    this.w = new Texture(this.v, paramBitmap);
    m();
  }
  
  public void a(Texture paramTexture)
  {
    this.w = paramTexture;
    m();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    if (this.w == null) {
      return;
    }
    if (this.v != null) {
      GLES20.glUseProgram(this.v.w);
    }
    GLES20.glBindTexture(3553, n());
    GLES20.glEnableVertexAttribArray(paramInt3);
    GLES20.glVertexAttribPointer(paramInt3, 3, 5126, false, 0, this.z);
    GLES20.glEnableVertexAttribArray(paramInt4);
    GLES20.glVertexAttribPointer(paramInt4, 2, 5126, false, 0, this.B);
    Matrix.setIdentityM(this.C, 0);
    Matrix.translateM(this.C, 0, 0.0F, 0.0F, -1.0E-004F);
    a(this.D);
    float f1 = paramInt1;
    float f4 = paramInt2;
    float f2 = f1 / f4;
    float f3 = f1 / this.b / (this.f * d());
    float f5 = (this.D.a * 2.0F * d() - f1) / f4;
    if ((this.v != null) && (this.v.v)) {
      f1 = -paramInt2 + this.D.b * 2.0F * d();
    } else {
      f1 = f4 - this.D.b * 2.0F * d();
    }
    f1 /= f4;
    Matrix.translateM(this.C, 0, f5, f1, 0.0F);
    Matrix.rotateM(this.C, 0, -this.h, 0.0F, 0.0F, 1.0F);
    float[] arrayOfFloat = this.C;
    f1 = f2 / f3;
    Matrix.scaleM(arrayOfFloat, 0, f1, this.c / this.b * f1, 1.0F);
    arrayOfFloat = new float[16];
    Matrix.multiplyMM(arrayOfFloat, 0, paramArrayOfFloat, 0, this.C, 0);
    GLES20.glUniformMatrix4fv(paramInt5, 1, false, arrayOfFloat, 0);
    GLES20.glUniform1i(paramInt6, 0);
    GLES20.glUniform1f(paramInt7, this.i * e() / 255.0F / 255.0F);
    GLES20.glDrawElements(4, this.x.length, 5123, this.A);
    GLES20.glDisableVertexAttribArray(paramInt3);
    GLES20.glDisableVertexAttribArray(paramInt4);
  }
  
  public void f()
  {
    Texture localTexture = this.w;
    if (localTexture != null) {
      localTexture.c();
    }
  }
  
  protected void k()
  {
    super.k();
    Texture localTexture = this.w;
    if (localTexture != null) {
      localTexture.d = false;
    }
  }
  
  protected void l()
  {
    this.z = ByteBuffer.allocateDirect(this.s.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.s);
    this.z.position(0);
    this.A = ByteBuffer.allocateDirect(this.x.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer().put(this.x);
    this.A.position(0);
    this.B = ByteBuffer.allocateDirect(this.y.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.y);
    this.B.position(0);
  }
  
  protected void m()
  {
    Texture localTexture = this.w;
    if (localTexture != null)
    {
      if (localTexture.b == null) {
        return;
      }
      this.b = this.w.b.getWidth();
      this.c = this.w.b.getHeight();
    }
  }
  
  public int n()
  {
    this.w.b();
    return this.w.a;
  }
  
  public int o()
  {
    Texture localTexture = this.w;
    if ((localTexture != null) && (localTexture.b != null) && (!this.w.b.isRecycled())) {
      return this.w.b.getWidth();
    }
    return (int)this.b;
  }
  
  public int p()
  {
    Texture localTexture = this.w;
    if ((localTexture != null) && (localTexture.b != null) && (!this.w.b.isRecycled())) {
      return this.w.b.getHeight();
    }
    return (int)this.c;
  }
  
  public Texture q()
  {
    return this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Sprite
 * JD-Core Version:    0.7.0.1
 */