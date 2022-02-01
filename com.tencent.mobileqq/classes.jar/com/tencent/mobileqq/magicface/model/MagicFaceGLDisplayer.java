package com.tencent.mobileqq.magicface.model;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ShaderUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;

public class MagicFaceGLDisplayer
{
  private static final short[] jdField_a_of_type_ArrayOfShort = { 0, 1, 2, 2, 3, 0 };
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = null;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer = null;
  private HashMap<String, ByteBuffer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private int jdField_b_of_type_Int;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer = null;
  private byte[] jdField_b_of_type_ArrayOfByte = null;
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte = null;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte = null;
  private int jdField_e_of_type_Int;
  private byte[] jdField_e_of_type_ArrayOfByte = null;
  private int jdField_f_of_type_Int;
  private byte[] jdField_f_of_type_ArrayOfByte = null;
  private int g;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k;
  private int l;
  private int m;
  private int n = -1;
  private int o = -1;
  private int p = -1;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  
  public MagicFaceGLDisplayer()
  {
    b();
    a();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject1 = IntBuffer.allocate(1);
    GLES20.glGenTextures(1, (IntBuffer)localObject1);
    int i1 = ((IntBuffer)localObject1).get();
    GLES20.glBindTexture(3553, i1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramArrayOfByte.length);
    ((StringBuilder)localObject2).append("");
    localObject2 = (ByteBuffer)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
    localObject1 = localObject2;
    if (localObject2 == null) {
      try
      {
        localObject1 = ByteBuffer.allocateDirect(paramArrayOfByte.length);
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramArrayOfByte.length);
        localStringBuilder.append("");
        ((HashMap)localObject2).put(localStringBuilder.toString(), localObject1);
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -2015;
      }
    }
    ((ByteBuffer)localObject1).order(ByteOrder.nativeOrder());
    ((ByteBuffer)localObject1).put(paramArrayOfByte);
    ((ByteBuffer)localObject1).position(0);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, (Buffer)localObject1);
    return i1;
  }
  
  private void a(float paramFloat)
  {
    double d1 = paramFloat * 3.14159F / 180.0F;
    paramFloat = (float)Math.sin(d1);
    float f1 = (float)Math.cos(d1);
    float[] arrayOfFloat = new float[16];
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = paramFloat;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (-paramFloat);
    arrayOfFloat[5] = f1;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 1.0F;
    Object localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(arrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    GLES20.glUniformMatrix4fv(this.g, 1, false, (FloatBuffer)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = this.u / this.s * this.t / this.v;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func updateRenderParam, [yCord]=");
      ((StringBuilder)localObject1).append(f1);
      QLog.d("MagicFaceGLDisplayer", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = this.q;
    float f2 = (i1 - this.s) / i1 / 2.0F;
    i1 = this.r;
    float f3 = (i1 - this.t) / i1 / 2.0F;
    Object localObject2 = new float[12];
    localObject2[0] = 1.0F;
    float f4 = -f1;
    localObject2[1] = f4;
    localObject2[2] = 0.0F;
    localObject2[3] = 1.0F;
    localObject2[4] = f1;
    localObject2[5] = 0.0F;
    localObject2[6] = -1.0F;
    localObject2[7] = f1;
    localObject2[8] = 0.0F;
    localObject2[9] = -1.0F;
    localObject2[10] = f4;
    localObject2[11] = 0.0F;
    Object localObject1 = new float[8];
    float f1 = 1.0F - f2;
    localObject1[0] = f1;
    f4 = 1.0F - f3;
    localObject1[1] = f4;
    localObject1[2] = f1;
    localObject1[3] = f3;
    localObject1[4] = f2;
    localObject1[5] = f3;
    localObject1[6] = f2;
    localObject1[7] = f4;
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(localObject2.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put((float[])localObject2);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    localObject2 = ByteBuffer.allocateDirect(localObject1.length * 4);
    ((ByteBuffer)localObject2).order(ByteOrder.nativeOrder());
    this.jdField_b_of_type_JavaNioFloatBuffer = ((ByteBuffer)localObject2).asFloatBuffer();
    this.jdField_b_of_type_JavaNioFloatBuffer.put((float[])localObject1);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
  
  private void b()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfShort.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
    this.jdField_a_of_type_JavaNioShortBuffer.put(jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = ShaderUtil.a("attribute vec4 position;\nattribute mediump vec2 textureCoordinate;\nvarying mediump vec2 coordinate;\nuniform mat4 transformMatrix;\nvoid main()\n{\n   gl_Position = position * transformMatrix; \n   coordinate = textureCoordinate; \n}\n", "precision highp float;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform sampler2D SamplerY_Alpha;\nuniform sampler2D SamplerU_Alpha;\nuniform sampler2D SamplerV_Alpha;\nvarying highp vec2 coordinate;\nvoid main()\n{\n    highp vec3 yuv;\n    highp vec3 rgb;    \n    yuv.x = texture2D(SamplerY, coordinate).r;    \n    yuv.y = texture2D(SamplerU, coordinate).r-0.5;    \n    yuv.z = texture2D(SamplerV, coordinate).r-0.5 ;    \n    rgb = mat3(      1,       1,      1,\n                       0,         -.34414, 1.772,\n                       1.402,     -.71414, 0) * yuv;    \n    highp vec3 yuv_Alpha;\n    highp vec3 rgb_Alpha;    \n    yuv_Alpha.x = texture2D(SamplerY_Alpha, coordinate).r;    \n    yuv_Alpha.y = texture2D(SamplerU_Alpha, coordinate).r-0.5;    \n    yuv_Alpha.z = texture2D(SamplerV_Alpha, coordinate).r-0.5 ;    \n    rgb_Alpha = mat3(      1,       1,      1,\n                       0,         -.34414, 1.772,\n                       1.402,     -.71414, 0) * yuv_Alpha;    \n         if(rgb_Alpha[0]  <= 0.196 ){   \n               rgb_Alpha[0] = 0.0;}   \n         else if(rgb_Alpha[0]  >= 0.922){     \n               rgb_Alpha[0] = 1.0;}  \n    gl_FragColor = vec4(rgb.r * rgb_Alpha.r ,rgb.g * rgb_Alpha.r ,rgb.b * rgb_Alpha.r, rgb_Alpha.r) ;\n}\n");
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "position");
    this.jdField_c_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "textureCoordinate");
    this.jdField_d_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerY");
    this.jdField_e_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerU");
    this.jdField_f_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerV");
    this.k = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerY_Alpha");
    this.l = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerU_Alpha");
    this.m = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerV_Alpha");
    this.g = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "transformMatrix");
    GLES20.glEnableVertexAttribArray(this.jdField_b_of_type_Int);
    GLES20.glEnableVertexAttribArray(this.jdField_c_of_type_Int);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func draw begins, _srcwidth:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",_srcheight:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",_dstWidth:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",_dstHeight:");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(",isFull:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MagicFaceGLDisplayer", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 <= 700) && (paramInt2 <= 900))
    {
      GLES20.glClear(16640);
      this.u = paramInt3;
      this.v = paramInt4;
      this.q = paramInt1;
      this.r = paramInt2;
      this.s = paramInt1;
      this.t = paramInt2;
      if (this.jdField_a_of_type_Float == -1.0F)
      {
        this.jdField_a_of_type_Float = paramFloat;
        this.jdField_a_of_type_Boolean = paramBoolean;
        a(this.jdField_a_of_type_Boolean);
        a(this.jdField_a_of_type_Float);
      }
      if (this.jdField_a_of_type_Float != paramFloat)
      {
        this.jdField_a_of_type_Float = paramFloat;
        a(this.jdField_a_of_type_Float);
      }
      if (this.jdField_a_of_type_Boolean != paramBoolean)
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        a(this.jdField_a_of_type_Boolean);
      }
      if ((this.q != this.s) || (this.r != this.t)) {
        a(this.jdField_a_of_type_Boolean);
      }
      localObject = this.jdField_a_of_type_ArrayOfByte;
      if (localObject == null)
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[this.q * this.r];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.q;
        paramInt3 = this.r;
        if (paramInt1 != paramInt2 * paramInt3) {
          this.jdField_a_of_type_ArrayOfByte = new byte[paramInt2 * paramInt3];
        }
      }
      localObject = this.jdField_b_of_type_ArrayOfByte;
      if (localObject == null)
      {
        this.jdField_b_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.q;
        paramInt3 = this.r;
        if (paramInt1 != paramInt2 * paramInt3 / 4) {
          this.jdField_b_of_type_ArrayOfByte = new byte[paramInt2 * paramInt3 / 4];
        }
      }
      localObject = this.jdField_c_of_type_ArrayOfByte;
      if (localObject == null)
      {
        this.jdField_c_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.q;
        paramInt3 = this.r;
        if (paramInt1 != paramInt2 * paramInt3 / 4) {
          this.jdField_c_of_type_ArrayOfByte = new byte[paramInt2 * paramInt3 / 4];
        }
      }
      localObject = this.jdField_d_of_type_ArrayOfByte;
      if (localObject == null)
      {
        this.jdField_d_of_type_ArrayOfByte = new byte[this.q * this.r];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.q;
        paramInt3 = this.r;
        if (paramInt1 != paramInt2 * paramInt3) {
          this.jdField_d_of_type_ArrayOfByte = new byte[paramInt2 * paramInt3];
        }
      }
      localObject = this.jdField_e_of_type_ArrayOfByte;
      if (localObject == null)
      {
        this.jdField_e_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.q;
        paramInt3 = this.r;
        if (paramInt1 != paramInt2 * paramInt3 / 4) {
          this.jdField_e_of_type_ArrayOfByte = new byte[paramInt2 * paramInt3 / 4];
        }
      }
      localObject = this.jdField_f_of_type_ArrayOfByte;
      if (localObject == null)
      {
        this.jdField_f_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.q;
        paramInt3 = this.r;
        if (paramInt1 != paramInt2 * paramInt3 / 4) {
          this.jdField_f_of_type_ArrayOfByte = new byte[paramInt2 * paramInt3 / 4];
        }
      }
    }
    try
    {
      System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.q * this.r);
      System.arraycopy(paramArrayOfByte1, this.q * this.r, this.jdField_b_of_type_ArrayOfByte, 0, this.q * this.r / 4);
      System.arraycopy(paramArrayOfByte1, this.q * this.r * 5 / 4, this.jdField_c_of_type_ArrayOfByte, 0, this.q * this.r / 4);
      System.arraycopy(paramArrayOfByte2, 0, this.jdField_d_of_type_ArrayOfByte, 0, this.q * this.r);
      System.arraycopy(paramArrayOfByte2, this.q * this.r, this.jdField_e_of_type_ArrayOfByte, 0, this.q * this.r / 4);
      System.arraycopy(paramArrayOfByte2, this.q * this.r * 5 / 4, this.jdField_f_of_type_ArrayOfByte, 0, this.q * this.r / 4);
      paramInt1 = this.h;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.i;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.j;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.n;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.o;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.p;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      this.h = a(this.jdField_a_of_type_ArrayOfByte, this.q, this.r);
      this.i = a(this.jdField_b_of_type_ArrayOfByte, this.q / 2, this.r / 2);
      this.j = a(this.jdField_c_of_type_ArrayOfByte, this.q / 2, this.r / 2);
      this.n = a(this.jdField_d_of_type_ArrayOfByte, this.q, this.r);
      this.o = a(this.jdField_e_of_type_ArrayOfByte, this.q / 2, this.r / 2);
      this.p = a(this.jdField_f_of_type_ArrayOfByte, this.q / 2, this.r / 2);
      if ((this.h != -2015) && (this.i != -2015) && (this.j != -2015) && (this.n != -2015) && (this.o != -2015))
      {
        if (this.p == -2015) {
          return;
        }
        GLES20.glVertexAttribPointer(this.jdField_b_of_type_Int, 3, 5126, false, 12, this.jdField_a_of_type_JavaNioFloatBuffer);
        GLES20.glVertexAttribPointer(this.jdField_c_of_type_Int, 2, 5126, false, 8, this.jdField_b_of_type_JavaNioFloatBuffer);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.n);
        GLES20.glUniform1i(this.k, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.o);
        GLES20.glUniform1i(this.l, 1);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.p);
        GLES20.glUniform1i(this.m, 2);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.h);
        GLES20.glUniform1i(this.jdField_d_of_type_Int, 3);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.i);
        GLES20.glUniform1i(this.jdField_e_of_type_Int, 4);
        GLES20.glActiveTexture(33989);
        GLES20.glBindTexture(3553, this.j);
        GLES20.glUniform1i(this.jdField_f_of_type_Int, 5);
        GLES20.glDrawElements(4, jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceGLDisplayer", 2, "func draw ends");
        }
      }
      return;
    }
    catch (OutOfMemoryError paramArrayOfByte1)
    {
      label1399:
      break label1399;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MagicFaceGLDisplayer", 2, "ooooom happens.");
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLDisplayer", 2, "func draw ends, video size is too big. something must be wrong");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicFaceGLDisplayer
 * JD-Core Version:    0.7.0.1
 */