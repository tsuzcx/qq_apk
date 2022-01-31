package dov.com.qq.im.cropvideo;

import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.util.ShaderUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class RenderFilter
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF(-1.0F, 1.0F, 1.0F, -1.0F);
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.jdField_a_of_type_ArrayOfFloat);
  private final float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F };
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF(-1.0F, 1.0F, 1.0F, -1.0F);
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private final float[] jdField_b_of_type_ArrayOfFloat = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private int jdField_c_of_type_Int;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF(-1.0F, 1.0F, 1.0F, -1.0F);
  private final float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private int jdField_d_of_type_Int;
  private final float[] jdField_d_of_type_ArrayOfFloat = new float[16];
  private int jdField_e_of_type_Int;
  private float[] jdField_e_of_type_ArrayOfFloat = new float[16];
  private int jdField_f_of_type_Int;
  private final float[] jdField_f_of_type_ArrayOfFloat = new float[16];
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public RenderFilter()
  {
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    this.jdField_b_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_b_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
  
  private void a(RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = (paramRectF.right - paramRectF.left) * (paramFloat1 - 1.0F);
    paramFloat2 = (paramRectF.bottom - paramRectF.top) * (paramFloat2 - 1.0F);
    paramRectF.top -= paramFloat2 / 2.0F;
    float f1 = paramRectF.bottom;
    paramRectF.bottom = (paramFloat2 / 2.0F + f1);
    paramRectF.left -= paramFloat1 / 2.0F;
    paramFloat2 = paramRectF.right;
    paramRectF.right = (paramFloat1 / 2.0F + paramFloat2);
  }
  
  private void b()
  {
    Log.d("RenderFilter", "initMatrix videoWidth: " + this.j + ", videoHeight: " + this.k + ", screenWidth: " + this.h + ", screenHeight: " + this.i);
    float f4;
    if ((this.j > 0) && (this.k > 0) && (this.h > 0) && (this.i > 0))
    {
      Matrix.setIdentityM(this.jdField_d_of_type_ArrayOfFloat, 0);
      Matrix.setIdentityM(this.jdField_f_of_type_ArrayOfFloat, 0);
      Matrix.multiplyMM(this.jdField_d_of_type_ArrayOfFloat, 0, this.jdField_f_of_type_ArrayOfFloat, 0, this.jdField_c_of_type_ArrayOfFloat, 0);
      float f1 = this.j / this.k;
      float f2 = this.h / this.i;
      Matrix.orthoM(this.jdField_c_of_type_ArrayOfFloat, 0, -1.0F, 1.0F, -f1 / f2, f1 / f2, -1.0F, 1.0F);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(-1.0F, f2 / f1, 1.0F, -f2 / f1);
      float f3 = this.jdField_a_of_type_AndroidGraphicsRectF.right / this.jdField_a_of_type_AndroidGraphicsRectF.top;
      f4 = this.jdField_b_of_type_Float / this.jdField_a_of_type_Float;
      if (f1 <= f3 * f2) {
        break label307;
      }
    }
    label307:
    for (this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRectF.top / this.jdField_c_of_type_AndroidGraphicsRectF.top);; this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRectF.right / this.jdField_c_of_type_AndroidGraphicsRectF.right))
    {
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * f4);
      b(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, 1.0F);
      Log.d("RenderFilter", "initMatrix rectTexture: " + this.jdField_c_of_type_AndroidGraphicsRectF + ", rectTemp: " + this.jdField_b_of_type_AndroidGraphicsRectF);
      return;
    }
  }
  
  public int a()
  {
    float f1 = this.jdField_f_of_type_ArrayOfFloat[0] * this.h / this.j;
    return (int)(Math.abs(this.jdField_a_of_type_AndroidGraphicsRectF.right - this.jdField_a_of_type_AndroidGraphicsRectF.left) * this.h / 2.0F / f1);
  }
  
  public Rect a()
  {
    float f1 = this.jdField_f_of_type_ArrayOfFloat[0] * this.h / this.j;
    float f6 = this.jdField_b_of_type_AndroidGraphicsRectF.left;
    float f9 = this.jdField_f_of_type_ArrayOfFloat[12];
    float f7 = this.jdField_b_of_type_AndroidGraphicsRectF.top;
    float f8 = this.jdField_f_of_type_ArrayOfFloat[13];
    float f4 = this.jdField_b_of_type_AndroidGraphicsRectF.right;
    float f5 = this.jdField_f_of_type_ArrayOfFloat[12];
    float f2 = this.jdField_b_of_type_AndroidGraphicsRectF.bottom;
    float f3 = this.jdField_f_of_type_ArrayOfFloat[13];
    f6 = Math.abs(this.jdField_a_of_type_AndroidGraphicsRectF.left - (f6 + f9)) * this.h / 2.0F;
    f7 = Math.abs(this.jdField_a_of_type_AndroidGraphicsRectF.top - (f7 + f8)) * this.i / 2.0F;
    f4 = Math.abs(this.jdField_a_of_type_AndroidGraphicsRectF.right - (f4 + f5)) * this.h / 2.0F;
    f2 = Math.abs(this.jdField_a_of_type_AndroidGraphicsRectF.bottom - (f2 + f3)) * this.i / 2.0F;
    return new Rect((int)(f6 / f1), (int)(f7 / f1), (int)(f4 / f1), (int)(f2 / f1));
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = ShaderUtil.a("attribute vec4 aPosition;\nattribute vec4 aTexCoord;\nvarying vec2 vTexCoord;\nuniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nvoid main() {\n    vTexCoord = (uSTMatrix * aTexCoord).xy;\n    gl_Position = uMVPMatrix * aPosition;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTexCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTexCoord);\n}");
    this.jdField_c_of_type_Int = GLES20.glGetAttribLocation(this.jdField_b_of_type_Int, "aPosition");
    this.jdField_e_of_type_Int = GLES20.glGetAttribLocation(this.jdField_b_of_type_Int, "aTexCoord");
    this.jdField_f_of_type_Int = GLES20.glGetUniformLocation(this.jdField_b_of_type_Int, "uMVPMatrix");
    this.g = GLES20.glGetUniformLocation(this.jdField_b_of_type_Int, "uSTMatrix");
    this.jdField_d_of_type_Int = GLES20.glGetUniformLocation(this.jdField_b_of_type_Int, "sTexture");
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.jdField_a_of_type_Int = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.jdField_a_of_type_Int);
    ShaderUtil.a("glBindTexture mTextureID");
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 /= this.h;
    paramFloat2 /= -this.i;
    Matrix.translateM(this.jdField_f_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3);
    if ((this.jdField_b_of_type_AndroidGraphicsRectF.left < this.jdField_a_of_type_AndroidGraphicsRectF.left) && (this.jdField_b_of_type_AndroidGraphicsRectF.right > this.jdField_a_of_type_AndroidGraphicsRectF.right)) {
      if (this.jdField_f_of_type_ArrayOfFloat[12] > 0.0F)
      {
        if (this.jdField_f_of_type_ArrayOfFloat[12] + this.jdField_b_of_type_AndroidGraphicsRectF.left > this.jdField_a_of_type_AndroidGraphicsRectF.left) {
          this.jdField_f_of_type_ArrayOfFloat[12] = (this.jdField_a_of_type_AndroidGraphicsRectF.left - this.jdField_b_of_type_AndroidGraphicsRectF.left);
        }
        if ((this.jdField_b_of_type_AndroidGraphicsRectF.bottom >= this.jdField_a_of_type_AndroidGraphicsRectF.bottom) || (this.jdField_b_of_type_AndroidGraphicsRectF.top <= this.jdField_a_of_type_AndroidGraphicsRectF.top)) {
          break label638;
        }
        if (this.jdField_f_of_type_ArrayOfFloat[13] <= 0.0F) {
          break label575;
        }
        if (this.jdField_f_of_type_ArrayOfFloat[13] + this.jdField_b_of_type_AndroidGraphicsRectF.bottom > this.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
          this.jdField_f_of_type_ArrayOfFloat[13] = (this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.jdField_b_of_type_AndroidGraphicsRectF.bottom);
        }
      }
    }
    for (;;)
    {
      Matrix.multiplyMM(this.jdField_d_of_type_ArrayOfFloat, 0, this.jdField_f_of_type_ArrayOfFloat, 0, this.jdField_c_of_type_ArrayOfFloat, 0);
      Log.d("RenderFilter", "translate rectTemp: " + this.jdField_b_of_type_AndroidGraphicsRectF);
      return;
      if ((this.jdField_f_of_type_ArrayOfFloat[12] >= 0.0F) || (this.jdField_f_of_type_ArrayOfFloat[12] + this.jdField_b_of_type_AndroidGraphicsRectF.right >= this.jdField_a_of_type_AndroidGraphicsRectF.right)) {
        break;
      }
      this.jdField_f_of_type_ArrayOfFloat[12] = (this.jdField_a_of_type_AndroidGraphicsRectF.right - this.jdField_b_of_type_AndroidGraphicsRectF.right);
      break;
      if (((this.jdField_b_of_type_AndroidGraphicsRectF.left < this.jdField_a_of_type_AndroidGraphicsRectF.left) && (this.jdField_b_of_type_AndroidGraphicsRectF.right < this.jdField_a_of_type_AndroidGraphicsRectF.right)) || ((this.jdField_b_of_type_AndroidGraphicsRectF.left > this.jdField_a_of_type_AndroidGraphicsRectF.left) && (this.jdField_b_of_type_AndroidGraphicsRectF.right > this.jdField_a_of_type_AndroidGraphicsRectF.right))) {
        break;
      }
      if ((this.jdField_b_of_type_AndroidGraphicsRectF.left > this.jdField_a_of_type_AndroidGraphicsRectF.left) && (this.jdField_b_of_type_AndroidGraphicsRectF.right < this.jdField_a_of_type_AndroidGraphicsRectF.right))
      {
        if (this.jdField_f_of_type_ArrayOfFloat[12] > 0.0F)
        {
          if (this.jdField_f_of_type_ArrayOfFloat[12] + this.jdField_b_of_type_AndroidGraphicsRectF.right <= this.jdField_a_of_type_AndroidGraphicsRectF.right) {
            break;
          }
          this.jdField_f_of_type_ArrayOfFloat[12] = (this.jdField_a_of_type_AndroidGraphicsRectF.right - this.jdField_b_of_type_AndroidGraphicsRectF.right);
          break;
        }
        if ((this.jdField_f_of_type_ArrayOfFloat[12] >= 0.0F) || (this.jdField_f_of_type_ArrayOfFloat[12] + this.jdField_b_of_type_AndroidGraphicsRectF.left >= this.jdField_a_of_type_AndroidGraphicsRectF.left)) {
          break;
        }
        this.jdField_f_of_type_ArrayOfFloat[12] = (this.jdField_a_of_type_AndroidGraphicsRectF.left - this.jdField_b_of_type_AndroidGraphicsRectF.left);
        break;
      }
      this.jdField_f_of_type_ArrayOfFloat[12] = 0.0F;
      break;
      label575:
      if ((this.jdField_f_of_type_ArrayOfFloat[13] < 0.0F) && (this.jdField_f_of_type_ArrayOfFloat[13] + this.jdField_b_of_type_AndroidGraphicsRectF.top < this.jdField_a_of_type_AndroidGraphicsRectF.top))
      {
        this.jdField_f_of_type_ArrayOfFloat[13] = (this.jdField_a_of_type_AndroidGraphicsRectF.top - this.jdField_b_of_type_AndroidGraphicsRectF.top);
        continue;
        label638:
        if (((this.jdField_b_of_type_AndroidGraphicsRectF.bottom >= this.jdField_a_of_type_AndroidGraphicsRectF.bottom) || (this.jdField_b_of_type_AndroidGraphicsRectF.top >= this.jdField_a_of_type_AndroidGraphicsRectF.top)) && ((this.jdField_b_of_type_AndroidGraphicsRectF.bottom <= this.jdField_a_of_type_AndroidGraphicsRectF.bottom) || (this.jdField_b_of_type_AndroidGraphicsRectF.top <= this.jdField_a_of_type_AndroidGraphicsRectF.top))) {
          if ((this.jdField_b_of_type_AndroidGraphicsRectF.bottom > this.jdField_a_of_type_AndroidGraphicsRectF.bottom) && (this.jdField_b_of_type_AndroidGraphicsRectF.top < this.jdField_a_of_type_AndroidGraphicsRectF.top))
          {
            if (this.jdField_f_of_type_ArrayOfFloat[13] > 0.0F)
            {
              if (this.jdField_f_of_type_ArrayOfFloat[13] + this.jdField_b_of_type_AndroidGraphicsRectF.top > this.jdField_a_of_type_AndroidGraphicsRectF.top) {
                this.jdField_f_of_type_ArrayOfFloat[13] = (this.jdField_a_of_type_AndroidGraphicsRectF.top - this.jdField_b_of_type_AndroidGraphicsRectF.top);
              }
            }
            else if ((this.jdField_f_of_type_ArrayOfFloat[13] < 0.0F) && (this.jdField_f_of_type_ArrayOfFloat[13] + this.jdField_b_of_type_AndroidGraphicsRectF.bottom < this.jdField_a_of_type_AndroidGraphicsRectF.bottom)) {
              this.jdField_f_of_type_ArrayOfFloat[13] = (this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.jdField_b_of_type_AndroidGraphicsRectF.bottom);
            }
          }
          else {
            this.jdField_f_of_type_ArrayOfFloat[13] = 0.0F;
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.jdField_b_of_type_Int);
    GLES20.glUniformMatrix4fv(this.jdField_f_of_type_Int, 1, false, this.jdField_d_of_type_ArrayOfFloat, 0);
    GLES20.glUniformMatrix4fv(this.g, 1, false, this.jdField_e_of_type_ArrayOfFloat, 0);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glEnableVertexAttribArray(this.jdField_c_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_c_of_type_Int, 3, 5126, false, 12, this.jdField_a_of_type_JavaNioFloatBuffer);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glEnableVertexAttribArray(this.jdField_e_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_e_of_type_Int, 2, 5126, false, 8, this.jdField_b_of_type_JavaNioFloatBuffer);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt);
    GLES20.glUniform1i(this.jdField_d_of_type_Int, 0);
    GLES20.glDrawArrays(5, 0, 4);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Log.d("RenderFilter", "updateProjection width: " + paramInt1 + ", height: " + paramInt2 + ", screenWidth: " + this.h + ", screenHeight: " + this.i);
    if ((this.j != paramInt1) || (this.k != paramInt2))
    {
      this.j = paramInt1;
      this.k = paramInt2;
      b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d("RenderFilter", "setEdge left: " + paramInt1 + ", top: " + paramInt2 + ", right: " + paramInt3 + ", bottom: " + paramInt4);
    float f4 = this.h / 2;
    float f3 = this.i / 2;
    float f1 = paramInt1 / f4;
    float f2 = paramInt2 / f3;
    f4 = paramInt3 / f4;
    f3 = paramInt4 / f3;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(f1 - 1.0F, 1.0F - f2, f4 - 1.0F, 1.0F - f3);
    Log.d("RenderFilter", "setEdge rectEdge: " + this.jdField_a_of_type_AndroidGraphicsRectF);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_e_of_type_ArrayOfFloat = paramArrayOfFloat;
  }
  
  public int b()
  {
    float f1 = this.jdField_f_of_type_ArrayOfFloat[0] * this.h / this.j;
    return (int)(Math.abs(this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.jdField_a_of_type_AndroidGraphicsRectF.top) * this.i / 2.0F / f1);
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.jdField_f_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3);
    if (this.jdField_f_of_type_ArrayOfFloat[0] < this.jdField_a_of_type_Float) {
      this.jdField_f_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_Float;
    }
    if (this.jdField_f_of_type_ArrayOfFloat[5] < this.jdField_a_of_type_Float) {
      this.jdField_f_of_type_ArrayOfFloat[5] = this.jdField_a_of_type_Float;
    }
    if (this.jdField_f_of_type_ArrayOfFloat[0] > this.jdField_b_of_type_Float) {
      this.jdField_f_of_type_ArrayOfFloat[0] = this.jdField_b_of_type_Float;
    }
    if (this.jdField_f_of_type_ArrayOfFloat[5] > this.jdField_b_of_type_Float) {
      this.jdField_f_of_type_ArrayOfFloat[5] = this.jdField_b_of_type_Float;
    }
    Matrix.multiplyMM(this.jdField_d_of_type_ArrayOfFloat, 0, this.jdField_f_of_type_ArrayOfFloat, 0, this.jdField_c_of_type_ArrayOfFloat, 0);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRectF);
    a(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_f_of_type_ArrayOfFloat[0], this.jdField_f_of_type_ArrayOfFloat[5]);
    Log.d("RenderFilter", "scale rectTemp: " + this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Log.d("RenderFilter", "adjustSize width: " + paramInt1 + ", height: " + paramInt2 + ", videoWidth: " + this.j + ", videoHeight: " + this.k);
    if ((this.h != paramInt1) || (this.i != paramInt2))
    {
      this.h = paramInt1;
      this.i = paramInt2;
      GLES20.glViewport(0, 0, this.h, this.i);
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.RenderFilter
 * JD-Core Version:    0.7.0.1
 */